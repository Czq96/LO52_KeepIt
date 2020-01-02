package com.utbm.keepit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.utbm.keepit.backend.entity.User;
import com.utbm.keepit.backend.service.UserService;


public class LoginActivity extends AppCompatActivity {

    private UserService userService;
    //定义控件
//    private InputView username , pwd ;
    private TextInputLayout userNameInput, pwdInput;
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









//    //TODO: 找一个别的方式初始化数据库
//    private void initialBdd(){
//        userDao = new UserDaoHelper(this);
//        User u = new User("admin","admin");
//        userDao.insertUser(u);
//
//        TopicDaoHelper topicDao = new TopicDaoHelper(this);
//        ExerciseDaoHelper exerciseDaoHelper = new ExerciseDaoHelper(this);
//        JoinTopicExerciseDaoHelper joinTopicExerciseDaoHelper = new JoinTopicExerciseDaoHelper(this);
//        SeanceDaoHelper seanceDaoHelper = new SeanceDaoHelper(this);
//        JoinSeanceExerciseDaoHelper joinSeanceExercise = new JoinSeanceExerciseDaoHelper(this);
//
//        topicDao.insertTopic(new Topic("Dos"));
//        topicDao.insertTopic(new Topic("Cuisses"));
//        topicDao.insertTopic(new Topic("Biceps"));
//
//        exerciseDaoHelper.insertExercise(new Exercise("foo",0,2,3,"descrpition 1","file url 1"));
//        exerciseDaoHelper.insertExercise(new Exercise("bar",1,6,3,"descrpition 2","file url 2"));
//        exerciseDaoHelper.insertExercise(new Exercise("xxxxx",2,2,6,"descrpition 3","file url 3"));
//
//        joinTopicExerciseDaoHelper.insertJoinTopicExercises(new JoinTopicExercises((long) 1,"Dos","foo"));
//        joinTopicExerciseDaoHelper.insertJoinTopicExercises(new JoinTopicExercises((long) 2,"Cuisses","bar"));
//        joinTopicExerciseDaoHelper.insertJoinTopicExercises(new JoinTopicExercises((long) 3,"Biceps","xxxxx"));
//        joinTopicExerciseDaoHelper.insertJoinTopicExercises(new JoinTopicExercises((long) 4,"Cuisses","xxxxx"));
//        joinTopicExerciseDaoHelper.insertJoinTopicExercises(new JoinTopicExercises((long) 5,"Dos","xxxxx"));
//
//        seanceDaoHelper.insertSeance(new Seance((long) 1,10,5,3));
//        seanceDaoHelper.insertSeance(new Seance((long) 2,20,7,5));
//
//        joinSeanceExercise.insertJoinSeanceExercise(new JoinSeanceExercise((long)1,(long)1,"foo"));
//        joinSeanceExercise.insertJoinSeanceExercise(new JoinSeanceExercise((long)2,(long)2,"foo"));
//        joinSeanceExercise.insertJoinSeanceExercise(new JoinSeanceExercise((long)3,(long)2,"bar"));
//        joinSeanceExercise.insertJoinSeanceExercise(new JoinSeanceExercise((long)4,(long)2,"xxxxx"));
//            db.execSQL("INSERT INTO Seance(duration,intensity,repeatTimes) VALUES(10,5,3)");
//            db.execSQL("INSERT INTO Seance(duration,intensity,repeatTimes) VALUES(20,7,5)");
//            //插入SeanceExercises
//            //\Long id;Long seanceId; String exerciseName;
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(1,'foo')");
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(2,'foo')");
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(2,'bar')");
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(2,'xxxxx')");

//        db.execSQL("INSERT INTO Topic(topicName) VALUES('Dos')");
//            db.execSQL("INSERT INTO Topic(topicName) VALUES('Cuisses')");
//            db.execSQL("INSERT INTO Topic(topicName) VALUES('Biceps')");
//            //插入 Exercise
//            //    String name; int typePublic;int levelDifficult;
//            //    int levelGroup; String  description;String imageResource;
//            //    @ToMany
//            //   private List<Topic> listTopic;
//            db.execSQL("INSERT INTO Exercise VALUES('foo',0,7,3,'descrpition 1','file url 1')");
//            db.execSQL("INSERT INTO Exercise VALUES('bar',1,2,2,'descrpition 2','file url 2')");
//            db.execSQL("INSERT INTO Exercise VALUES('xxxxx',2,5,1,'descrpition 3','file url 3')");
//            //插入JoinTopicExercise
//            // private Long id;   topicName;String exerciseName;
//            //TODO：測試 1.能否一個 EXercise 添加兩個相同的 topic  2.ex 能否沒有topic
//            db.execSQL("INSERT INTO JoinTopicExercise(topicName,exerciseName) VALUES('Dos','foo')");
//            db.execSQL("INSERT INTO JoinTopicExercise(topicName,exerciseName) VALUES('Cuisses','bar')");
//            db.execSQL("INSERT INTO JoinTopicExercise(topicName,exerciseName) VALUES('Biceps','xxxxx')");
//            db.execSQL("INSERT INTO JoinTopicExercise(topicName,exerciseName) VALUES('Cuisses','xxxxx')");
//            db.execSQL("INSERT INTO JoinTopicExercise(topicName,exerciseName) VALUES('Dos','xxxxx')");
//            //插入Seance
//            //Long id;Integer duration; Integer intensity;Integer repeatTimes;
//            // List<Exercise> listExercises
//            db.execSQL("INSERT INTO Seance(duration,intensity,repeatTimes) VALUES(10,5,3)");
//            db.execSQL("INSERT INTO Seance(duration,intensity,repeatTimes) VALUES(20,7,5)");
//            //插入SeanceExercises
//            //\Long id;Long seanceId; String exerciseName;
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(1,'foo')");
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(2,'foo')");
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(2,'bar')");
//            db.execSQL("INSERT INTO JoinSeanceExercises(seanceId,exerciseName) VALUES(2,'xxxxx')");
//            //插入 User
//            // TODO :
//            db.execSQL("INSERT INTO User VALUES('admin','admin')");
//            db.execSQL("INSERT INTO User VALUES('admin2','admin2')");



//    }
