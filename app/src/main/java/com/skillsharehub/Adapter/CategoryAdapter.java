package com.skillsharehub.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.skillsharehub.Model.CategoryModel;
import com.skillsharehub.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;
    ArrayList<CategoryModel> list;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.design_category_project, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CategoryModel model = list.get(position);

        holder.txtCategory.setText(model.getName());

        if (model.isSelected()) {

            holder.cardView.setCardBackgroundColor(Color.parseColor("#4285F4"));
            holder.txtCategory.setTextColor(Color.WHITE);

        } else {

            holder.cardView.setCardBackgroundColor(Color.parseColor("#F2F2F2"));
            holder.txtCategory.setTextColor(Color.parseColor("#555555"));
        }

        holder.itemView.setOnClickListener(v -> {

            for (CategoryModel item : list) {
                item.setSelected(false);
            }

            model.setSelected(true);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCategory;
        MaterialCardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCategory = itemView.findViewById(R.id.txtCategory);
            cardView = (MaterialCardView) itemView;
        }
    }
}