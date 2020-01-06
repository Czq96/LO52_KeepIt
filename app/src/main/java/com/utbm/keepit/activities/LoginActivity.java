package com.utbm.keepit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.User;
import com.utbm.keepit.backend.service.UserService;
import com.utbm.keepit.ui.views.InputView;

import java.util.List;


public class LoginActivity extends AppCompatActivity {

    private UserService userService;
    //定义控件
    private InputView userNameInput, pwdInput;
    private Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userService = new UserService();
        //获取控件
        userNameInput = findViewById(R.id.activity_login_username_input);
        pwdInput = findViewById(R.id.activity_login_pwd_input);

//        List<User> lu = userService.getUserDao().loadAll();
//        for(User u : lu){
//            System.out.println(u.toString());
//        }
//
//        System.out.println(userService.checkPwd("admin","admin"));


    }
    public void onRegisterClick(View view){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    /**
     * 登陆按扭验证登陆
     *
     */
    public void onCreateTopicClick(View view){
        Intent intent=new Intent(this,CreateTopicActivity.class);
        startActivity(intent);
        finish();
    }
}
