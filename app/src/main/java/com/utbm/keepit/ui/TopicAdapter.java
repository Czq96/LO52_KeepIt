package com.utbm.keepit.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.utbm.keepit.MyApp;
import com.utbm.keepit.R;
import com.utbm.keepit.activities.MainActivity;
import com.utbm.keepit.backend.entity.Topic;
import com.utbm.keepit.ui.home.HomeFragment;

import java.util.List;

import static com.utbm.keepit.R.layout.fragment_home;

public class TopicAdapter extends BaseAdapter {

    List<Topic> data;
    Context context;

    public Context getContext() {
        return context;
    }

    public TopicAdapter(List<Topic> data, Context context){
//        super(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        if(data == null)
            return 0;
        else
            return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    //返回带数据当前行的Item视图对象
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1. 如果convertView是null, 加载item的布局文件
        if(convertView==null) {
            Log.e("TAG", "getView() load layout");

            convertView = View.inflate(getContext(), R.layout.topic_item, null);
        }
        //2. 得到当前行数据对象
         Topic topic = data.get(position);
        //3. 得到当前行需要更新的子View对象
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_item_icon);
        TextView id = (TextView) convertView.findViewById(R.id.topic_id);
        TextView name = (TextView) convertView.findViewById(R.id.topic_name);
        //4. 给视图设置数据
//        imageView.setImageDrawable(appInfo.getIcon());
        id.setText(topic.getId().toString());
        name.setText(topic.getTopicName());

        //返回convertView
        return convertView;
    }

}

