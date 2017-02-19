package com.example.kuno.eventex01;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

/*

이벤트(Event)
자바 프로그램에서 어떤 특정한 행동이 발생한 그 자체를 의미
ex) 버튼을 클릭, 메뉴를 선택하는 행위

이벤트소스
이벤트 발생 근원

이벤트 리스너
onClickListener를 통해 UI오브젝트에 이벤트 핸들러 객체를 연결

이벤트 핸들러
사용자 조작, 값 변경등 다양한 이벤트에 대한 처리기능을 수행하는 부분


*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(this);

        updateTime();

    }

    private void updateTime(){
        btn.setText(sf.format(new Date()));
    }

    @Override
    public void onClick(View v) {
        updateTime();
    }
}
