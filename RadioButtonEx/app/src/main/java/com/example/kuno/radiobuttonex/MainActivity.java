package com.example.kuno.radiobuttonex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup = (RadioGroup)findViewById(R.id.radioGroup);
        tv = (TextView)findViewById(R.id.textView);

        rGroup.check(R.id.radioButton2);    //초기 선택값

        RadioButton rb = (RadioButton)findViewById(rGroup.getCheckedRadioButtonId());
        tv.setText("기본 선택: " + rb.getText());

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton)findViewById(rGroup.getCheckedRadioButtonId());
                tv.setText("당신의 선택: " + rb.getText());
            }
        });

    }
}
