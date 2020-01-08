package com.utbm.keepit.activities;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.utbm.keepit.R;
import com.utbm.keepit.backend.entity.Exercise;
import com.utbm.keepit.backend.service.ExerciseService;
import com.utbm.keepit.backend.service.ExerciseWithJoinSeance;

import java.util.List;

public class StopwatchActivity extends AppCompatActivity {
    //Numbers of seconds displayed in the stopwatch 

//    private Button createTimer;
    //Is the stopwatch running 
    private boolean running;
    private ExerciseService exerciseService = new ExerciseService();
    private Long tid;
    private List<ExerciseWithJoinSeance> listExerciceData;
    //private List<Integer> seconds;
    private int seconds;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_stopwatch);
        tid=getIntent().getExtras().getLong("seanceid");
        listExerciceData=exerciseService.findBySceanceId(tid);

            i =0;
            seconds = listExerciceData.get(i).jse.getDuration();
            runTimer();


       /*     }
        });*/
    }

//    public void onCreateTimerClick(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        runTimer();
//    }
    //Start the stopwatch running when the Start button is clicked 
    public void onClickStart(View view){ running = true;
        }
    //Stop the stopwatch running when the Stop button is clicked 
    public void onClickStop(View view){
            running = false;
        }
    //Reset the stopwatch running when the Reset button is clicked 
    public void onClickReset(View view){
            running = false; seconds = 0;
    }


    private void runTimer(){

        final TextView timeView = (TextView)findViewById(R.id.time_view);
       /* for (int i = 0; i < listExerciceData.size() - 1; i++) {
            int seconds = listExerciceData.get(i).jse.getDuration();*/



        final Handler handler = new Handler();



            handler.post(new Runnable() {
                @Override

                public void run() {
                    Exercise exe = listExerciceData.get(i).e;
                    String uri = listExerciceData.get(i).e.getImageResource();
                    System.out.println(uri);
                    int hours = seconds / 3600;
                    int minutes = (seconds % 3600) / 60;
                    int secs = seconds % 60;
                    String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                    timeView.setText(time);
                    if (running) {
                        seconds--;
                        if (seconds > 0) {

//                        //TODO : 30s huozhe 15s
                            Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 200);
                            ImageView imageView = new ImageView(getApplicationContext());
//                            System.out.println(uri.toString());
                            //TODO: uri verifier()
                            if (uri.length() > 1) {
                                imageView.setImageURI(Uri.parse(uri));
                            } else {
                                imageView.setImageResource(R.mipmap.muscle);
                            }
                            LinearLayout toastView = (LinearLayout) toast.getView();
                            toastView.setOrientation(LinearLayout.HORIZONTAL);
                            toastView.addView(imageView, 0);
                            toast.show();
                        }
                        else {// 结束的时候震动
                            if (i < listExerciceData.size()) {
                                Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                                vib.vibrate(1000);
                                i++;
                                seconds = listExerciceData.get(i).jse.getDuration();
                            }
                        }
                    }
                    handler.postDelayed(this, 1000);
                }

            });

    }
}