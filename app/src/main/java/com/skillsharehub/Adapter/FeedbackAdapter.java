package com.skillsharehub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skillsharehub.Model.FeedbackModel;
import com.skillsharehub.R;

import java.util.ArrayList;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder>{

    Context context;
    ArrayList<FeedbackModel> list;

    public FeedbackAdapter(Context context, ArrayList<FeedbackModel> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context)
                .inflate(R.layout.design_feedback,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FeedbackModel model=list.get(position);

        holder.name.setText(model.getName());
        holder.course.setText(model.getCourse());
        holder.feedback.setText(model.getFeedback());
        holder.date.setText(model.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,course,feedback,date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.txtName);
            course=itemView.findViewById(R.id.txtCourse);
            feedback=itemView.findViewById(R.id.txtFeedback);
            date=itemView.findViewById(R.id.txtDate);

        }
    }

}