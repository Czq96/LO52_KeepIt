package com.utbm.keepit.activities;
//TODO : start 按钮或者计时结束的问题
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.backend.entity.JoinSeanceExercise;
import com.utbm.keepit.backend.service.ExerciseService;
import com.utbm.keepit.backend.service.ExerciseWithJoinSeance;
import com.utbm.keepit.ui.ExerciceListAdapter;
import com.utbm.keepit.ui.ExerciceListWithJoinSeanceAdapter;

import java.util.List;
import java.util.Map;

public class AfficherSeanceExerciseActivity extends AppCompatActivity {
    private RecyclerView ExerciceList;

    private Long tid;
    private ExerciceListWithJoinSeanceAdapter exerciceListAdapter;
    private ExerciseService exerciseService = new ExerciseService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceance_exercise);
        tid=getIntent().getExtras().getLong("seanceid");

        System.out.println("tid: " + tid);
       //
        // List<Exercise> listExerciceData = exerciseService.findByTopicId(tid);//TODO : exercice数据源 根据homefragment传过来的id
       List<ExerciseWithJoinSeance> listExerciceData=exerciseService.findBySceanceId(tid);
        ExerciceList=findViewById(R.id.exercise_list);

//        rvTopic.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.marginItemSize),rvGrid));
//        rvTopicItem.setNestedScrollingEnabled(false);
        System.out.println("listsize "+ listExerciceData.size());
        for(ExerciseWithJoinSeance ewj: listExerciceData){
            System.out.println("Exercise data:");
            System.out.println(ewj.e.getId());
        }


        exerciceListAdapter =new ExerciceListWithJoinSeanceAdapter(this,listExerciceData);
        ExerciceList.setLayoutManager(new LinearLayoutManager(this));
        ExerciceList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        ExerciceList.setAdapter(exerciceListAdapter);
    }
    public void onBtnStart(View v){
        Intent intent = new Intent(this,StopwatchActivity.class);//changer
        intent.putExtra("seanceid",tid);
        startActivity(intent);
    }
//
}
