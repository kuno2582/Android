package com.example.kuno.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
SharedPreferences 객체
 - 앱과 관련된 간단한 데이터 저장할 때 쓰입니다.
 - key, value 쌍으로 파일 생성하여 키(Key)를 통해 데이터(value)를
    가져올 수 있도록 제공해 줍니다.
 - 사용자의 옵션 선택사항이나 앱 자체의 프로그램 구성정보를 주로 저장하는 용도로 사용합니다.
    즉, 환경설정시 많이 사용합니다.
 - 한쪽 Activity에서 프레퍼런스의 정보를 수정하면 다른 Activity에서도 수정된 값을
    읽을 수 있도록 제공하는 객체이기도 합니다.


1) 내장메모리
/data/data/[package folder]/files/file.txt

2) SDCard
/sdcard 혹은 /storage/sdcard

3) raw
프로젝트 /res/raw/file.txt  ->  openRawResource() 통해 접근

4) SharedPreferences 객체
/data/data/[pakage folder]/shared_prefs/file.xml

*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etText;
    Button btnWrite, btnRead, btnMove;
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnMove = (Button) findViewById(R.id.btnMove);
        tvView = (TextView) findViewById(R.id.tvView);

        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnMove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnWrite:
                SharedPreferences sharedPreferences = getSharedPreferences("PreferencesEx", MODE_PRIVATE);//덮어쓰기모드
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("text", etText.getText().toString());
                editor.commit();
                etText.setText("");
                break;
            case R.id.btnRead:
                sharedPreferences = getSharedPreferences("PreferencesEx", MODE_PRIVATE);
                tvView.setText(sharedPreferences.getString("text", "")); //두번째 인자는 첫번째 인자가 없을 때의 대체값
                break;
            case R.id.btnMove:
                Intent intent = new Intent(this, TwoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
