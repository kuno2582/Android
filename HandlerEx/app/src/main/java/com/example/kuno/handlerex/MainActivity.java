package com.example.kuno.handlerex;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/*
Handler(핸들러)
안드로이드에서 스레드간 통신 장치
메인스레드에 있는 변수값을 다른 스레드에서 값을 변경시켜주기 위해 사용
핸들러는 신호를 보내는 것, Runnable은 코드를 보내는 것

Message 객체의 정보
what        메시지의 의미
arg1        메시지 추가정보
arg2        메시지 추가정보
obj         변수만으로 메시지를 기술할 수 없을 때 임의의 객체를 생성한 후 전달
replyTo     메시지에 대한 응답 받을 객체를 지정정
*/

public class MainActivity extends AppCompatActivity {

    WorkerThread thread;
    Handler handler;

    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvView = (TextView)findViewById(R.id.tvView);

        handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if(msg.what == 1){
                    tvView.setText("i값: " + msg.arg1);
                }
            }
        };

        thread = new WorkerThread(handler);
        thread.start();

    }
}//class MainActivity

class WorkerThread extends Thread{
    Handler handler;

    WorkerThread(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        //super.run();

        for(int i=0; i<=20; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg = new Message();
            msg.what=1;
            msg.arg1=i;

            handler.sendMessage(msg);
        }
    }
}
