package com.utbm.KeepIt;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends BaseActivity {

    private TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
    }
    /**
     * 初始化View
     */
    private void initView(){
        initNavBar(true,R.string.profile,false);
        userName=fd(R.id.userName);
//        String user=UserHelper.getInstance().getPhone();
//        userName.setText(user);
    }


    public void onChangePwdClick(View view) {
        Intent intent= new Intent(this,ChangePwdActivity.class);
        startActivity(intent);
        finish();
    }
    public void onLogoutClick(View view){
//        UserUtils.logout(this);
    }
}
