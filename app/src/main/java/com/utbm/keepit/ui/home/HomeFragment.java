package com.utbm.keepit.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.utbm.keepit.R;
import com.utbm.keepit.activities.ChangePwdActivity;
import com.utbm.keepit.activities.CreateTopicActivity;
import com.utbm.keepit.activities.LoginActivity;
import com.utbm.keepit.activities.MainActivity;
import com.utbm.keepit.backend.entity.Topic;
import com.utbm.keepit.backend.service.TopicService;
import com.utbm.keepit.ui.TopicListAdapter;

import java.util.List;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;
//    private ListView listTopicView;
    private TopicService topicService = new TopicService();
//    private TopicAdapter adapter;
    private RecyclerView rvTopic;
    private TopicListAdapter topicListAdapter;
    private Button createTopic;


    public View onCreateView(@NonNull LayoutInflater inflater,
                         ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);


//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        topicService = new TopicService();
 //       List<Topic> listTopicData = topicService.findAll();
//
  //      listTopicView = (ListView)root.findViewById(R.id.TopicList);
//
  //      adapter = new TopicAdapter(listTopicData, getActivity());


    //    listTopicView.setAdapter(adapter);

        List<Topic> listTopicData = topicService.findAll();
        rvTopic=root.findViewById(R.id.rv_topic);
//        rvTopic.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.marginItemSize),rvGrid));
        rvTopic.setNestedScrollingEnabled(false);
        topicListAdapter=new TopicListAdapter(this.getContext(),listTopicData);
        rvTopic.setAdapter(topicListAdapter);
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        createTopic = (Button) getActivity().findViewById(R.id.btn_create_topic);
        createTopic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), CreateTopicActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

    }



}
