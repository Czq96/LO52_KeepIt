package com.utbm.keepit;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.utbm.keepit.backend.dao.DaoSession;
import com.utbm.keepit.backend.dao.UserDao;
import com.utbm.keepit.backend.entity.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.utbm.keepit.MyApp;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

//        DaoSession daoSession = ((MyApp) getApplication()).getDaoSession();
//        userDao = daoSession.getUserDao();

//        System.out.println("添加测试user admin admin");
//        User testu = new User("adminxxx","adminxxx");
//        userDao.insert(testu);
//        System.out.println("插入完毕");
//        List<User> lu = userDao.loadAll();
//        for(User u : lu){
//            System.out.println(u.toString());
//        }
        System.out.println("----------------------------------------------------------------");


    }



}
