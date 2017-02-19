package com.example.kuno.progressbarex;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/*

스레드로 데이터 처리하여 UI로 보여주기
스레드 UI에 접근하기 위해 Handler객체를 이용해야 합니다.
Thread -> Handler -> UI

*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    Handler handler = new Handler();
    boolean isRunning = false;

    TextView textView;

    Integer pbValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.pbProgress);
        textView = (TextView)findViewById(R.id.tvValue);

        progressBar.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        doProgress();

    }

    public void doProgress(){
        progressBar.setProgress(0);

        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    for(int i=0; i<20 && isRunning; i++){
                        Thread.sleep(1000);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.incrementProgressBy(5);

                                pbValue = progressBar.getProgress();

                                textView.setText(pbValue.toString());
                            }
                        });
                    }

                }catch(Exception e){
                    Log.e("핸들러 데모", e.toString());
                }

            }
        });

        isRunning = true;
        background.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        isRunning = false;
    }

    @Override
    public void onClick(View v) {
        doProgress();
    }
}
