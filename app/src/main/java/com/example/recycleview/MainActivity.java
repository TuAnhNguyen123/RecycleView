package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRcvFood;
    List<FoodModel>mListFood;
    FoodAdapter mFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRcvFood = findViewById(R.id.recycleViewFood);

        mListFood = new ArrayList<>();
        mListFood.addAll(FoodModel.getMock());

        mFoodAdapter = new FoodAdapter(mListFood,this);

        mRcvFood.setHasFixedSize(true);
        mRcvFood.setAdapter(mFoodAdapter);
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
    }
}