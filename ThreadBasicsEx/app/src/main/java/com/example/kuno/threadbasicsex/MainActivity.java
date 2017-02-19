package com.example.kuno.threadbasicsex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
Thread
 - 동시 수행을 위한 가장 작은 작업단위
 - UI 객체는 직접 접근할 수 없으므로 핸들러(Handler)객체를 사용해서 메인스레드가 처리할 수 있도록
    만들어 주어야 합니다.

메인스레드
 - 안드로이드에서 UI처리하기 위해 사용되는 기본 스레드
 - 메인 스레드에서 UI에 이미 접근해 있기 때문에 새로운 스레드는 핸들러 객체를 이용해서
    메인스레드에 메시지(post())를 전달해서 처리하게 됩니다.


*/

public class MainActivity extends AppCompatActivity {

    Thread thread;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        thread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i = 0;
                for(i=0; i<=20; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.v("THREAD", "time="+i);
                }
            }
        });  //스레드의 인자 -> 러너블 클래스의 런메서드 오버라이드 하고 있는 객체가 올 수 있다

        running = true;
        thread.start();
    }//onStart()

    @Override
    protected void onStop() {
        super.onStop();

        running = false;
    }
}
