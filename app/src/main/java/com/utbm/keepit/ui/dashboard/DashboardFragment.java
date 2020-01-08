package com.utbm.keepit.ui.dashboard;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.activities.ChangePwdActivity;
import com.utbm.keepit.activities.LoginActivity;
import com.utbm.keepit.activities.MainActivity;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.backend.entity.JoinSeanceExercise;
import com.utbm.keepit.backend.entity.Seance;
import com.utbm.keepit.backend.service.ExerciseService;
import com.utbm.keepit.backend.service.JoinSeanceExerciseService;
import com.utbm.keepit.backend.service.SeanceService;
import com.utbm.keepit.ui.ExerciceChoosedListAdapter;
import com.utbm.keepit.ui.ExerciceListAdapter;
import com.utbm.keepit.ui.views.InputView;
import com.utbm.keepit.ui.views.PickerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private List<Exercise>  tempExercises;
    private List<JoinSeanceExercise> tempSeanceExercise;

    private ExerciseService exerciseService;
    private JoinSeanceExerciseService jseService = new JoinSeanceExerciseService();
    private SeanceService seanceService = new SeanceService();

    private List<Exercise>  allExercises;
    public List<String> items = new ArrayList<>();

    private RecyclerView exChoosed;
    private ExerciceChoosedListAdapter exerciceListAdapter;

    private Button addExercise, createSeance, annuler;

    private InputView seanceName,sceanceDuration, sceanceIntens, sceanceRep;
//    private PickerView hourPick,secondPick,minutePick;
//    private static String hour= "0",minute = "0",second = "0";


    private void showExerciseDialog() {
        final String[] exercisesItems = new String[items.size()];

        for (int i = 0; i < items.size(); i++) {
            exercisesItems[i] = items.get(i);
        }

        ExerciseDialog eDiaglog = new ExerciseDialog(getActivity(), items, new ExerciseDialog.PriorityListener() {
            @Override
            public void setExerciseSelectedId(Long id) {
                tempExercises.add(exerciseService.findExerciseById(id));
                exerciceListAdapter.notifyDataSetChanged();
            }

            @Override
            public void setExerciseDuration(int duration, Long id) {
                JoinSeanceExercise jse = new JoinSeanceExercise();
                jse.setDuration(duration);
                jse.setExerciseId(id);
                jse.setExerciseOrdre(tempSeanceExercise.size()+1);
                tempSeanceExercise.add(jse);
            }
        });

        eDiaglog.show();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // final TextView textView = root.findViewById(R.id.text_dashboard);
        seanceName = root.findViewById(R.id.sceance_name);
        sceanceIntens = root.findViewById(R.id.sceance_intensite);
        sceanceRep = root.findViewById(R.id.sceance_nombre);

        tempExercises = new ArrayList<Exercise>();
        tempSeanceExercise = new ArrayList<JoinSeanceExercise>();

        exerciseService = new ExerciseService();
        allExercises = exerciseService.findAll();
        if(items.size()!=allExercises.size()){
            for(Exercise e: allExercises){
                items.add(e.getId()+": "+e.toString());
            }
        }

        exChoosed=root.findViewById(R.id.exercise_choosed);
//        rvTopic.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.marginItemSize),rvGrid));
        exChoosed.setNestedScrollingEnabled(false);

        exerciceListAdapter =new ExerciceChoosedListAdapter(getActivity(),tempExercises,tempSeanceExercise);
        exChoosed.setLayoutManager(new LinearLayoutManager(getActivity()));
        exChoosed.setAdapter(exerciceListAdapter);

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

                Integer durations = 0;
                for(JoinSeanceExercise jse: tempSeanceExercise){
                    durations+=jse.getDuration();
                }

                if(seanceName.getInputStr() == null){
                    Toast.makeText(getActivity(), "please enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(sceanceIntens.getInputStr() == null){
                    Toast.makeText(getActivity(), "please choise intencity", Toast.LENGTH_SHORT).show();
                    return;
                }else if(sceanceRep.getInputStr() == null){
                    Toast.makeText(getActivity(), "please enter repeat times", Toast.LENGTH_SHORT).show();
                    return;
                }else if(durations == 0){
                    Toast.makeText(getActivity(), "please choose exercise and set duration", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Integer intencity = Integer.parseInt(sceanceIntens.getInputStr());
                    Integer repeat = Integer.parseInt(sceanceRep.getInputStr());
                    String name = seanceName.getInputStr();

                    Seance newS = new Seance(name,durations,intencity,repeat,tempExercises);
                    Long seanceId = seanceService.createSeance(newS);
                    for(JoinSeanceExercise jse: tempSeanceExercise){
                        jse.setSeanceId(seanceId);
                        jseService.createJoinSeanceExercise(jse);
                    }
                    Toast.makeText(getActivity(), "insert success", Toast.LENGTH_SHORT).show();
                    // TODO: return fragement  或者  activity返回到fragment
                }
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

}