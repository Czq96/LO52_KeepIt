package com.utbm.keepit.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.User;
import com.utbm.keepit.backend.service.UserService;
import com.utbm.keepit.ui.views.InputView;

public class RegisterActivity extends BaseActivity {
    InputView inputName, inputPwd, inputPwdConfirm;
    UserService userService = new UserService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

    }
    /**
     * 初始化View
     */
    private void initView(){
        initNavBar(true,R.string.register,false);
        inputName = findViewById(R.id.input_name);
        inputPwd = findViewById(R.id.input_passwd);
        inputPwdConfirm = findViewById(R.id.input_confirm_passwd);
    }
    public void onRegisterClick(View view) {
        String name = inputName.getInputStr();
        String pwd = inputPwd.getInputStr();
        String pwdConfirm = inputPwdConfirm.getInputStr();
        if(pwd==pwdConfirm){
            if(userService.findUserByName(name)!=null){
                Toast.makeText(RegisterActivity.this, "user existed", Toast.LENGTH_SHORT).show();
                return ;
            }
            else{
                try{
                    userService.createUser(new User(name, pwd));
                    Toast.makeText(RegisterActivity.this, "user create success", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(RegisterActivity.this, "Create failed", Toast.LENGTH_SHORT).show();
                    return ;
                }
            }
        }
        else{
            Toast.makeText(RegisterActivity.this, "different password", Toast.LENGTH_SHORT).show();
            return ;
        }
        onBackPressed();
    }
}
