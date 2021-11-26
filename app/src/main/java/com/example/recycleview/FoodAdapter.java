
package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<FoodModel> listFoods;
    private Context context;
    private OnItemFoodClickListener onItemFoodClickListener;
    private int LOADING_TYPE = 0;
    private int ITEM_TYPE = 1;

    public FoodAdapter(List<FoodModel> listFoods, Context context) {
        this.listFoods = listFoods;
        this.context = context;

    }

    @NonNull

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_mon_an, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        holder.bind(listFoods.get(position));
    }

    @Override
    public int getItemCount() {
        if (listFoods == null || listFoods.size() == 0) {
            return 0;
        }
        return listFoods.size();
    }

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

    public void bindOnItemFoodClickListener(OnItemFoodClickListener onItemFoodClickListener) {
        this.onItemFoodClickListener = onItemFoodClickListener;
    }
}
