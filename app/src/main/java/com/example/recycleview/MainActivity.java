package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRcvFood;
    List<FoodModel>mListFood;
    FoodAdapter mFoodAdapter;
    int mCurrentPage = 1;
    int mLastPage = 10;
    boolean mIsLoading = false;
    boolean mIsTotalPage = false;
    SwipeRefreshLayout swipeRefreshLayout;
    ConstraintLayout constraintLayoutLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRcvFood = findViewById(R.id.recycleViewFood);
        // swipeRefeshLayout
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        constraintLayoutLoading = findViewById(R.id.layoutLoading);


        mListFood = new ArrayList<>();
        mListFood.addAll(FoodModel.getMock());

        mFoodAdapter = new FoodAdapter(mListFood,this);

        mRcvFood.setHasFixedSize(true);
        mRcvFood.setAdapter(mFoodAdapter);
        mFoodAdapter.addFooterLoading();

        mFoodAdapter.bindOnItemFoodClickListener(new OnItemFoodClickListener() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(MainActivity.this, mListFood.get(position).getName(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "Xóa" + mListFood.get(position).getName(), Toast.LENGTH_SHORT).show();
                Log.d("BBB",mListFood.size()+ " ");
                mListFood.remove(position);
                Log.d("BBB",mListFood.size()+ " ");
                mFoodAdapter.notifyItemRemoved(position);
            }
        });

        mRcvFood.addOnScrollListener(new PaginationScrollListener((LinearLayoutManager) mRcvFood.getLayoutManager()) {
            @Override
            public void loadMore() {

                mIsLoading = true;
                mCurrentPage +=1;
                loadNextPage();
            }

            @Override
            public boolean isLoading() {
                return mIsLoading;
            }

            @Override
            public boolean isLastPage() {
                return mIsTotalPage;
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //mRcvFood.setVisibility(View.GONE);
                        constraintLayoutLoading.setVisibility(View.VISIBLE);
                    }
                },2000);
                swipeRefreshLayout.setRefreshing(false);

            }
        });
        mRcvFood.setVisibility(View.VISIBLE);
        constraintLayoutLoading.setVisibility(View.GONE);
    }

    private void loadNextPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int position = mListFood.size()-1;
                mFoodAdapter.removeFooterLoading();
                List<FoodModel> foodModels = FoodModel.getMock();
                mListFood.addAll(FoodModel.getMock());
                mFoodAdapter.notifyItemRangeChanged(position,foodModels.size());
                foodModels =null;
                mIsLoading = false;
                if (mCurrentPage<mLastPage){
                    mFoodAdapter.addFooterLoading();
                }
            }
        },2000);
    }

}