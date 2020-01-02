package com.utbm.keepit.activities;

import android.os.Bundle;
import android.view.View;

import com.utbm.keepit.R;
import com.utbm.keepit.ui.views.InputView;


public class ChangePwdActivity extends BaseActivity {
        private InputView oldPwd,newPwd,confirmPwd;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_change_pwd);
            initView();
        }
        private void initView(){
            initNavBar(true,R.string.passwd_change,false);
            newPwd=fd(R.id.input_pwdn);
            oldPwd=fd(R.id.input_pwdo);
            confirmPwd=fd(R.id.input_pwdc);
        }
        public void onChangeClick(View view){
//            String pwdo=oldPwd.getInputStr();
//            String pwdn=newPwd.getInputStr();
//            String pwdc=confirmPwd.getInputStr();
//            String phone=UserHelper.getInstance().getPhone();
//            boolean isChanged=UserUtils.changePwd(this,pwdo,pwdn,pwdc);
//            if(isChanged){
//                UserUtils.logout(this);
//            }
//            else{
//                return;
//            }
//        }
    }

}
