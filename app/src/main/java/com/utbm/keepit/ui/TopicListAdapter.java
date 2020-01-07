package com.utbm.keepit.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.activities.TopicItemActivity;
import com.utbm.keepit.backend.entity.Topic;

import java.util.List;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.ViewHolder> {
    private Context context;
    private List<Topic> topics;
    public TopicListAdapter(Context context, List<Topic> topics){
        this.context=context;
        this.topics=topics;
    }
    @NonNull
    @Override
    public TopicListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.topic_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopicListAdapter.ViewHolder holder, final int position) {
//        holder.imageView.setImageURI(topics.get(position).getImagePath());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, TopicItemActivity.class);
                intent.putExtra("topicid",topics.get(position).getId());//TODO 根据topicid获取对应的exercice
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            imageView=itemView.findViewById(R.id.img_topic);

        }
    }
}
