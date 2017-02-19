package com.example.kuno.messageex;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*
스레드(Thread)
동시 수행 가능한 작업단위

스레드 사용
 - 스레드는 같은 프로세스 안에 있기 때문에 그 작업의 결과를 바로 처리할 수 있다.
 - 그러나, UI객체에는 직접 접근할 수 없다.
 - 핸들러(Handler)객체를 사용해서 메시지를 전달함으로써 메인 스레드에서 처리할 수 있도록
    만들어주어야 합니다.

메인 스레드
 - 안드로이드에서 UI를 처리하기 위해 사용되는 기본 스레드를 의미한다.
 - 메인 스레드에서 UI에 이미 접근해 있기 때문에 새로운 스레드는 핸들러 객체를 이용해서 메인 스레드에 메시지를
    전달함으로써, UI처리를 해야 한다.



*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAlert, btnToast, btnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = (Button)findViewById(R.id.btnAlert);
        btnToast = (Button)findViewById(R.id.btnToast);
        btnProgress = (Button)findViewById(R.id.btnProgress);

        btnAlert.setOnClickListener(this);
        btnToast.setOnClickListener(this);
        btnProgress.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btnAlert:
                new AlertDialog.Builder(this).setTitle("대화상자").setMessage("경고창을 오픈하였습니다.").setCancelable(false)
                .setNeutralButton("닫기", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;

            case R.id.btnToast:
                Toast.makeText(this, "토스트 메시지가 오픈되었습니다.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnProgress:

                final ProgressDialog progressDialog = ProgressDialog.show(this, "프로그레스 바 작동중", "잠시만 기다려주세요");

                new Thread(){
                    @Override
                    public void run() {
//                        super.run();
                        try{
                            sleep(5000);
                        }catch (Exception e){
                            Log.e("Message Demo", e.toString());
                        }

                        progressDialog.dismiss();
                    }
                }.start();
                break;
        }
    }
}
