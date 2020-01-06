package com.utbm.keepit.backend.service;

import android.database.Cursor;
import android.util.Log;

import com.utbm.keepit.MyApp;
import com.utbm.keepit.backend.dao.DaoSession;
import com.utbm.keepit.backend.dao.ExerciseDao;
import com.utbm.keepit.backend.entity.Exercise;

import java.util.ArrayList;
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

    public List<Exercise> findByTopicId(long topicId){
        //TODO: 似乎有点小问题  待测试
    /*QueryBuilder<Exercise> qb = exerciseDao.queryBuilder();
    Query query = exerciseDao.queryRawCreate(
            ", GROUP G WHERE G.NAME=? AND T.GROUP_ID=G._ID", "admin";
    qb.join(JoinTopicExercise.class, JoinTopicExerciseDao.Properties.ExerciseId);
    qb.join(Topic.class, TopicDao.Properties.Id).where(TopicDao.Properties.Id.eq(topicId));
    qb.distinct();
    String strSql = "";
    qb
    return qb.queryRaw(Exercise.class, sql, strSql);
    return qb.list();*/
        try
        {
            DaoSession session= MyApp.getDaoSession();
            long fromId=-1;
            String strSql="select * from EXERCISE e inner join JOIN_TOPIC_EXERCISE te on e._id = te.EXERCISE_ID" +
                    " inner join TOPIC t on te.TOPIC_ID =t._id" +
                    " where t._id = " + topicId ;
            Cursor c  = session.getDatabase().rawQuery(strSql,null);
            ArrayList<Exercise> list = new ArrayList<Exercise>();
            if(c.moveToFirst())
            {
                Exercise exercise= new Exercise();
                exercise.setId(c.getLong(c.getColumnIndex("_id")));
                exercise.setDescription(c.getString(c.getColumnIndex("DESCRIPTION")));
                exercise.setName(c.getString(c.getColumnIndex("NAME")));
                exercise.setLevelDifficult(c.getInt(c.getColumnIndex("LEVEL_DIFFICULT")));
                exercise.setTypePublic(c.getInt(c.getColumnIndex("TYPE_PUBLIC")));
                exercise.setLevelGroup(c.getInt(c.getColumnIndex("LEVEL_GROUP")));
                exercise.setImageResource(c.getString(c.getColumnIndex("IMAGE_RESOURCE")));
                list.add(exercise);
            }
            c.close();
            return list;
        }
        catch (Exception ex)
        {
            ex.getMessage();

        }
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
