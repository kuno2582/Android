package com.example.kuno.intentobjectex02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kuno on 2017-02-01.
 */

public class SecondActivity extends Activity {

    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvView = (TextView) findViewById(R.id.tvView);

        Intent intent = getIntent();

        if(intent == null){
            tvView.setText("전달된 데이터가 없습니다.");
        }else{
            String strText = "";
            DataParcel obj = null;

            obj = (DataParcel)intent.getExtras().getParcelable("ObjectData");
            strText = "type: " + intent.getStringExtra("ObjectType") + "\n" +
                    "name: " + obj.name + "\n" +
                    "age: " + obj.age + "\n" +
                    "address: " + obj.address;
            tvView.setText(strText);
        }
    }
}
