package com.utbm.keepit.ui.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.activities.ChangePwdActivity;
import com.utbm.keepit.activities.LoginActivity;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.backend.service.ExerciseService;
import com.utbm.keepit.ui.views.InputView;
import com.utbm.keepit.ui.views.PickerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private List<Exercise>  tempExercises;
    private ExerciseService exerciseService;
    private List<Exercise>  allExercises;
    public List<String> items = new ArrayList<>();
    String stringChoice;

    private RecyclerView exChoosed;
//    private  topicListAdapter;
//    rvTopic=root.findViewById(R.id.rv_topic);
////        rvTopic.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.marginItemSize),rvGrid));
//        rvTopic.setNestedScrollingEnabled(false);
//        rvTopic.setLayoutManager(new GridLayoutManager(this.getContext(),3));
//    topicListAdapter=new TopicListAdapter(this.getContext(),listTopicData);
//        rvTopic.setAdapter(topicListAdapter);

    private Button addExercise, createSeance, annuler;
    //
//    private Long id;
//    private Integer duration; // 持续时间
//    private Integer intensity;  // 强度
//    private Integer repeatTimes; //  seance 的重复次数  比如 一天做三 遍同一组运动
//    private List<Exercise> listExercises;
    private InputView sceanceDuration, sceanceIntens, sceanceRep;
    private PickerView hourPick,secondPick,minutePick;


    private void showExerciseDialog() {
        final String[] exercisesItems = new String[items.size()];

        for (int i = 0; i < items.size(); i++) {
            exercisesItems[i] = items.get(i);
        }

        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(getActivity());
        singleChoiceDialog.setTitle("Choisir un entraînement");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(exercisesItems, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stringChoice = exercisesItems[which];
                    }
                });
        singleChoiceDialog.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (stringChoice != null) {
                            Long eId = Long.valueOf(stringChoice.split(": Name")[0]);
                            tempExercises.add(exerciseService.findExerciseById((Long)eId));
                        }
                    }
                });
        singleChoiceDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       return;
                    }
                });
        singleChoiceDialog.show();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // final TextView textView = root.findViewById(R.id.text_dashboard);
        sceanceDuration = root.findViewById(R.id.sceance_duree);
        sceanceIntens = root.findViewById(R.id.sceance_intensite);
        sceanceRep = root.findViewById(R.id.sceance_nombre);
        tempExercises = new ArrayList<Exercise>();
        exerciseService = new ExerciseService();
        allExercises = exerciseService.findAll();
        if(items.size()!=allExercises.size()){
            for(Exercise e: allExercises){
                items.add(e.getId()+": "+e.toString());
            }
        }


        hourPick = (PickerView) root.findViewById(R.id.hour_pick);
        minutePick = (PickerView) root.findViewById(R.id.minute_pick);
        secondPick = (PickerView) root.findViewById(R.id.second_pick);
        List<String> hour = new ArrayList<String>();
        List<String> seconds = new ArrayList<String>();
        for (int i = 0; i < 24; i++)
        {
            hour.add(i < 10 ? "0" + i : "" + i);
        }
        for (int i = 0; i < 60; i++)
        {
            seconds.add(i < 10 ? "0" + i : "" + i);
        }
        hourPick.setData(hour);
        hourPick.setOnSelectListener(new PickerView.onSelectListener()
        {

            @Override
            public void onSelect(String text)
            {
//                Toast.makeText(getActivity(), "选择了 " + text + " 分",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        minutePick.setData(seconds);
        minutePick.setOnSelectListener(new PickerView.onSelectListener()
        {

            @Override
            public void onSelect(String text)
            {
//                Toast.makeText(getActivity().this, "选择了 " + text + " 秒",
//                        Toast.LENGTH_SHORT).show();
            }
        });
        secondPick.setData(seconds);
        secondPick.setOnSelectListener(new PickerView.onSelectListener()
        {

            @Override
            public void onSelect(String text)
            {
//                Toast.makeText(getActivity().this, "选择了 " + text + " 秒",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addExercise = (Button) getActivity().findViewById(R.id.add_one_exercise);
        createSeance = (Button) getActivity().findViewById(R.id.btn_create_seance);
        annuler = (Button) getActivity().findViewById(R.id.btn_cancle_create_seance);

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExerciseDialog();
            }
        });

        createSeance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer duration = Integer.parseInt(sceanceDuration.getInputStr());
                Integer intencity = Integer.parseInt(sceanceIntens.getInputStr());
                Integer repeat = Integer.parseInt(sceanceRep.getInputStr());

            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ChangePwdActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

}