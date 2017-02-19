package com.example.kuno.activityex02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kuno on 2017-01-31.
 */

public class SecondActivity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        tv = (TextView) findViewById(R.id.tvContent);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle == null){
            tv.append("등록된 데이터가 없습니다.");
        }else{
            String name = bundle.getString("name");
            String korean = bundle.getString("Korean");
            String english = bundle.getString("English");
            String math = bundle.getString("Math");

            int sum = Integer.parseInt(korean) + Integer.parseInt(english) + Integer.parseInt(math);
            int avg = sum/3;

            tv.setText("이름: " + name + "\n");
            tv.append("국어: " + korean + "\n");
            tv.append("영어: " + english + "\n");
            tv.append("수학: " + math + "\n");
            tv.append("총점: " + sum + "\n");
            tv.append("평균: " + avg + "\n");

        }
    }
}
