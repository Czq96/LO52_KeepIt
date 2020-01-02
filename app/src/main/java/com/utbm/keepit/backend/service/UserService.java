package com.utbm.keepit.backend.service;

import android.util.Log;

import com.utbm.keepit.activities.MyApp;
import com.utbm.keepit.backend.dao.DaoSession;
import com.utbm.keepit.backend.dao.UserDao;
import com.utbm.keepit.backend.entity.User;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class UserService {
    private UserDao userDao;

    public UserService(){
        DaoSession daoSession = MyApp.getDaoSession();
        userDao = daoSession.getUserDao();
    }
    //CRUD
    public boolean createUser(User user){
        boolean flag = false;
        try{
            userDao.insert(user);
            flag = true;
        }catch (Exception e){
            Log.i(TAG, "createUser: "+e.toString());
            flag=false;
        }finally {
            return flag;
        }
    }

    public User findUserByName(String name){
        return userDao.load(name);
//        try{
//            userDao.load(name);
//        }catch (Exception e){
//            Log.i(TAG, "createUser: "+e.toString());
//         }
    }

    public boolean updateUserPwd(User user){
        boolean flag = false;
        try{
            userDao.update(user);
            flag = true;
        }catch (Exception e){
            Log.i(TAG, "createUser: "+e.toString());
            flag=false;
        }finally {
            return flag;
        }
    }

    //TODO: 存在的问题： USER和数据库中的其他表现在没有联系，A 和 B 共享所有相同的数据
    public boolean deleteUser(User user){
        boolean flag = false;
        try{
            userDao.delete(user);
            flag = true;
        }catch (Exception e){
            Log.i(TAG, "createUser: "+e.toString());
            flag=false;
        }finally {
            return flag;
        }
    }

    public boolean checkPwd(String name, String pwd){
        return this.findUserByName(name).getPwd().equals(pwd);
    }

}