package com.utbm.keepit.ui.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.utbm.keepit.R;
import com.utbm.keepit.activities.ChangePwdActivity;
import com.utbm.keepit.activities.LoginActivity;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.ui.views.InputView;
import com.utbm.keepit.ui.views.PickerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private List<Exercise>  tempExercises;
    private Button addExercise, createSeance, annuler;
    //
//    private Long id;
//    private Integer duration; // 持续时间
//    private Integer intensity;  // 强度
//    private Integer repeatTimes; //  seance 的重复次数  比如 一天做三 遍同一组运动
//    private List<Exercise> listExercises;
    private InputView sceanceDuration, sceanceIntens, sceanceRep;
    private PickerView hourPick,secondPick,minutePick;

//    AlertController.RecycleListView

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // final TextView textView = root.findViewById(R.id.text_dashboard);
        sceanceDuration = root.findViewById(R.id.sceance_duree);
        sceanceIntens = root.findViewById(R.id.sceance_intensite);
        sceanceRep = root.findViewById(R.id.sceance_nombre);
        tempExercises = new ArrayList<Exercise>();

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
//                Intent intent= new Intent(getActivity(), LoginActivity.class);
//                startActivity(intent);
//                getActivity().finish();
                CharSequence[] items=["1","2","3"];
                AlertDialog dialog = new AlertDialog.Builder(getActivity().setTitle("单选对话框")
                        .setSingleChoiceItems(items, -1, new View.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
//                tempExercises.add(e);
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