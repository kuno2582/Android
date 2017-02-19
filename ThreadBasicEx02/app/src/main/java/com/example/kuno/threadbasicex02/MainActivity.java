package com.example.kuno.threadbasicex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    WorkerThread thread;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class WorkerThread extends Thread{

        @Override
        public void run() {
//            super.run();
            int i = 0;
            for(i=0; i<30; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.v("Thread","time=" + i);
            }
        }
    }   //class WorkerThread

    @Override
    protected void onStart() {
        super.onStart();

        thread = new WorkerThread();
        running = true;
        thread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        running = false;
    }
}
