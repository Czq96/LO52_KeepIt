package com.utbm.keepit.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.utbm.keepit.MyApp;
import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.backend.entity.Topic;
import com.utbm.keepit.backend.service.TopicService;
import com.utbm.keepit.ui.TopicAdapter;

import java.util.List;

import static com.utbm.keepit.R.layout.fragment_home;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ListView listTopicView;
    private TopicService topicService;
    private TopicAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        topicService = new TopicService();
        List<Topic> listTopicData = topicService.findAll();

        for(Topic t : listTopicData){
            System.out.println(t.toString());
            System.out.println(t.getListExercises().size());
            for(Exercise e : t.getListExercises()){
                System.out.println("Exercise: ");
                System.out.println(e.toString());
            }
        }


        listTopicView = (ListView)root.findViewById(R.id.TopicList);

        adapter = new TopicAdapter(listTopicData, getActivity());


        listTopicView.setAdapter(adapter);

        return root;
    }



    
}