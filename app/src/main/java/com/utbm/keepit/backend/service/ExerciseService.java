package com.utbm.keepit.backend.service;

import android.util.Log;

import com.utbm.keepit.MyApp;
import com.utbm.keepit.backend.dao.DaoSession;
import com.utbm.keepit.backend.dao.ExerciseDao;
import com.utbm.keepit.backend.entity.Exercise;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ExerciseService {
    private ExerciseDao exerciseDao;

    public ExerciseService(){
        DaoSession daoSession = MyApp.getDaoSession();
        exerciseDao = daoSession.getExerciseDao();
    }
    //CRUD
    public boolean createExercise(Exercise exercise){
        boolean flag = false;
        try{
            exerciseDao.insert(exercise);
            flag = true;
        }catch (Exception e){
            Log.i(TAG, "createExercise: "+e.toString());
            flag=false;
        }finally {
            return flag;
        }
    }

    public Exercise findExerciseById(Long id){
        return exerciseDao.load(id);
    }

    public List<Exercise> findAll(){
        return exerciseDao.loadAll();
    }

    public Exercise findByName(String name){
//        exerciseDao.
        return null;
    }


    //TODO: join class 的删除？
    public boolean deleteExercise(Exercise exercise){
        boolean flag = false;
        try{
            exerciseDao.delete(exercise);
            flag = true;
        }catch (Exception e){
            Log.i(TAG, "createExercise: "+e.toString());
            flag=false;
        }finally {
            return flag;
        }
    }
}
