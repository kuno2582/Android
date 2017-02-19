package com.tistory.codedragon.lifecycleex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
Log.e   Error 수준 로그
Log.w   Warning 수준 로그
Log.i   Info 수준 로그
Log.d   Debug 수준 로그
Log.v   메시지 로그
*/

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Lifecycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate 실행됨");
    }


    @Override
    protected void onStart(){
        super.onStart();

        Log.i(TAG, "onStart 실행됨");
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        Log.i(TAG, "onRestart 실행됨");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.i(TAG, "onResume 실행됨");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.i(TAG, "onPause 실행됨");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.i(TAG, "onStop 실행됨");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.i(TAG, "onDestroy 실행됨");
    }

}
