package com.skillsharehub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.skillsharehub.Model.ProjectModel;
import com.skillsharehub.R;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    Context context;
    ArrayList<ProjectModel> list;

    public ProjectAdapter(Context context, ArrayList<ProjectModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.design_project, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ProjectModel model = list.get(position);

        holder.txtTitle.setText(model.getTitle());
        holder.txtAuthor.setText("by " + model.getAuthor());
        holder.txtDescription.setText(model.getDescription());
        holder.txtCategory.setText(model.getCategory());
        holder.txtLikes.setText(String.valueOf(model.getLikes()));

        holder.txtAvatar.setText(getInitials(model.getAuthor()));

        holder.layoutTags.removeAllViews();

        for (String tech : model.getTechnologies()) {

            TextView chip = new TextView(context);

            chip.setText(tech);

            chip.setTextSize(12);

            chip.setPadding(25,10,25,10);

            chip.setBackgroundResource(R.drawable.bg_chip_gray);

            chip.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            ((LinearLayout.LayoutParams) chip.getLayoutParams())
                    .setMarginEnd(12);

            holder.layoutTags.addView(chip);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtAvatar;
        TextView txtTitle;
        TextView txtAuthor;
        TextView txtDescription;
        TextView txtCategory;
        TextView txtLikes;

        LinearLayout layoutTags;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAvatar=itemView.findViewById(R.id.txtAvatar);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtAuthor=itemView.findViewById(R.id.txtAuthor);
            txtDescription=itemView.findViewById(R.id.txtDescription);
            txtCategory=itemView.findViewById(R.id.txtCategory);
            txtLikes=itemView.findViewById(R.id.txtLikes);
            layoutTags=itemView.findViewById(R.id.layoutTags);
        }
    }

    private String getInitials(String name){

        String[] words=name.split(" ");

        String initials="";

        for(String word:words){

            initials+=word.charAt(0);
        }

        return initials.toUpperCase();
    }

}