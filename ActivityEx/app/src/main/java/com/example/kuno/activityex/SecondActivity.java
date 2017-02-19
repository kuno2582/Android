package com.example.kuno.activityex;

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

        tv = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle == null){
            tv.append("\n\n저장된 데이터가 없습니다.");
        }else{
            String msg = bundle.getString("msg");
            tv.append("\n\n" + msg);
        }
    }
}
