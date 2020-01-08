package com.utbm.keepit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.backend.service.ExerciseService;
import com.utbm.keepit.ui.ExerciceListAdapter;

import java.util.List;

public class AfficherSeanceExerciseActivity extends AppCompatActivity {
    private RecyclerView ExerciceList;

    private Long tid;
    private ExerciceListAdapter exerciceListAdapter;
    private ExerciseService exerciseService = new ExerciseService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        tid=getIntent().getExtras().getLong("sceanceid");

       //
        // List<Exercise> listExerciceData = exerciseService.findByTopicId(tid);//TODO : exercice数据源 根据homefragment传过来的id
       List<Exercise> listExerciceData=exerciseService.findBySceanceId(tid);
        ExerciceList=findViewById(R.id.exercise_list);

//        rvTopic.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.marginItemSize),rvGrid));
//        rvTopicItem.setNestedScrollingEnabled(false);
        System.out.println("listsize "+ listExerciceData.size());
        for(Exercise e: listExerciceData){
            System.out.println("Exercise data:");
            System.out.println(e.toString());
        }
        exerciceListAdapter =new ExerciceListAdapter(this,listExerciceData);
        ExerciceList.setLayoutManager(new LinearLayoutManager(this));
        ExerciceList.setAdapter(exerciceListAdapter);
    }
//
}
