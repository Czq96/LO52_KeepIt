package com.utbm.keepit.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.activities.TopicItemActivity;
import com.utbm.keepit.backend.entity.Exercise;

import java.util.List;

public class TopicItemAdapter extends RecyclerView.Adapter<TopicItemAdapter.ViewHolder> {
    private Context context;
    private List<Exercise> exercises;
    public TopicItemAdapter(Context context, List<Exercise> exercises){
        this.context=context;
        this.exercises=exercises;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            imageView=itemView.findViewById(R.id.exercise_image);
            textView=itemView.findViewById(R.id.exercise_name);

        }
    }
}
