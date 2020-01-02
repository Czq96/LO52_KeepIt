package com.utbm.keepit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.service.UserService;
import com.utbm.keepit.ui.views.InputView;


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

    }
    public void onRegisterClick(View view){
//        Intent intent=new Intent(this,RegisterActivity.class);
//        startActivity(intent);
    }
    /**
     * 登陆按扭验证登陆
     *
     */
    public void onCommitClick(View view){
//        String user=username.getInputStr();
//        String passwd=pwd.getInputStr();
        String userName = userNameInput.toString();
        String pwd = pwdInput.toString();

        if(userService.checkPwd(userName, pwd)){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            return;
        }
    }

}
