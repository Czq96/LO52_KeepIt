package com.utbm.KeepIt;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

public class BaseActivity extends Activity {
    private ImageView navBack;
    private TextView navTitle;
    private ImageView navMe;

    /**
     * 简化findViewById
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View>T fd(@IdRes int id){
        return findViewById(id);
    }

    /**
     * 初始化navBar
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack, int title, boolean isShowMe){
        navBack=findViewById(R.id.navBack);
        navTitle=fd(R.id.navTitle);
        navMe=fd(R.id.navMe);
        navBack.setVisibility(isShowBack?View.VISIBLE:View.GONE);
        navTitle.setText(title);
        navMe.setVisibility(isShowMe?View.VISIBLE:View.GONE);
        navBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        navMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,ProfileActivity.class));
            }
        });

    }

}
