package com.utbm.KeepIt;

import android.os.Bundle;
import android.view.View;

import com.utbm.KeepIt.Entity.User;
import com.utbm.KeepIt.dao.UserDaoHelper;
import com.utbm.KeepIt.views.InputView;

public class RegisterActivity extends BaseActivity {
    InputView inputName, inputPwd, inputPwdConfirm;
    private UserDaoHelper userDao;

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
        if(pwd!=pwdConfirm){
            return;
        }
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        boolean isRegistered = userDao.insertUser(user);
        if (!isRegistered) {
            return;
        }
        onBackPressed();
    }
}
