package com.utbm.keepit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.ui.TopicItemAdapter;
import com.utbm.keepit.ui.TopicListAdapter;

import java.util.List;

public class TopicItemActivity extends AppCompatActivity {
    private RecyclerView rvTopicItem;
    private TopicItemAdapter topicItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_item);
        Integer tid=getIntent().getExtras().getInt("topicid");
        List<Exercise> listExerciceData = topicService.findAll(tid);//TODO : exercice数据源 根据homefragment传过来的id
        rvTopicItem=findViewById(R.id.rv_topicItem);
//        rvTopic.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.marginItemSize),rvGrid));
        rvTopicItem.setNestedScrollingEnabled(false);
        topicItemAdapter=new TopicItemAdapter(this,listExerciceData);
        rvTopicItem.setAdapter(topicItemAdapter);
    }
}
