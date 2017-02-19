package com.tistory.codedragon.layoutinflaterex;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/*
LayoutInflater
- XML에 정의된 뷰들을 View의 형태로 반환해 주는 역할
- XML레이아웃 파일에서 뷰들을 생성할 때 LayoutInflater를 사용해야 합니다.
- LayoutInflater.from()이용해서 얻을 수 있습니다.


*/


public class MainActivity extends AppCompatActivity {

    Button btnLayoutInflater;
    RadioGroup radioGroup;
    RadioButton rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayoutInflater = (Button)findViewById(R.id.btnLayoutInflater);

        btnLayoutInflater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateLayout();
//                setContentView(R.layout.layout_sub);

            }
        });

    }

    private void inflateLayout(){

        LinearLayout containerLayout =
                (LinearLayout)findViewById(R.id.containerLayout);

        LayoutInflater inflater =
                (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.layout_sub, containerLayout, true);

        Button btnSelect = (Button)findViewById(R.id.btnSelect);
        radioGroup = (RadioGroup) findViewById(R.id.rgLanguage);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());

                Toast.makeText(MainActivity.this,
                        "당신은 " + rb.getText().toString() + "프로그래머 입니다.",
                        Toast.LENGTH_LONG).show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());

                Toast.makeText(MainActivity.this,
                        "당신은 " + rb.getText().toString() + "프로그래머 입니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
