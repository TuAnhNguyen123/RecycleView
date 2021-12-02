
package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FoodModel> listFoods;
    private Context context;
    private OnItemFoodClickListener onItemFoodClickListener;


    private int LOADING_TYPE = 0;
    private int ITEM_TYPE = 1;
    private boolean isLoading = false;

    public FoodAdapter(List<FoodModel> listFoods, Context context) {
        this.listFoods = listFoods;
        this.context = context;

    }

    @Override
    public int getItemViewType(int position) {

        if(isLoading){
            if(position == listFoods.size()-1){
                return LOADING_TYPE;
            }
        }
        return ITEM_TYPE;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = null;
        if(viewType == ITEM_TYPE){
            view =layoutInflater.inflate(R.layout.dong_mon_an, parent, false);
            return new FoodViewHolder(view);
        }else{
            view = layoutInflater.inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==ITEM_TYPE){
            ((FoodViewHolder)holder).bind(listFoods.get(position));
        }
    }


    @Override
    public int getItemCount() {
        if (listFoods == null || listFoods.size() == 0) {
            return 0;
        }
        return listFoods.size();
    }
//ViewHolder quản lý view cho item
    class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvName, tvAddress, tvBusinessType, tvDistance, tvRating;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);


            // findViewById : chỉ được gọi từ view
            img = itemView.findViewById(R.id.imageViewFood);
            tvName = itemView.findViewById(R.id.textViewName);
            tvAddress = itemView.findViewById(R.id.textViewAddress);
            tvBusinessType = itemView.findViewById(R.id.textViewCategory);
            tvDistance = itemView.findViewById(R.id.textViewDistance);
            tvRating = itemView.findViewById(R.id.textViewRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //vị trí của item làm sao để có
                    //Toast.makeText(context, listFoods.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    if (onItemFoodClickListener != null) {
                        onItemFoodClickListener.onClick(getAdapterPosition());
                    }
                }
            });

        }

        public void bind(FoodModel foodModel) {
            img.setImageResource(foodModel.getImage());
            tvName.setText(foodModel.getName());
            tvAddress.setText(foodModel.getAddress());
            tvBusinessType.setText(foodModel.getBusinessType().toString());
            tvDistance.setText(foodModel.getDistance() + " km");
            tvRating.setText(foodModel.getRating() + " ");
        }
    }
    class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    public void bindOnItemFoodClickListener(OnItemFoodClickListener onItemFoodClickListener) {
        this.onItemFoodClickListener = onItemFoodClickListener;
    }
    //add object rỗng
    public void addFooterLoading(){
        isLoading = true;
        listFoods.add(null);

    }
    public void removeFooterLoading(){
        isLoading=false;
        int position = listFoods.size()-1;
        listFoods.remove(position);
        notifyItemRemoved(position);
    }
}
