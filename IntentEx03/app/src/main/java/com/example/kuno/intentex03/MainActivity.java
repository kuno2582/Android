package com.example.kuno.intentex03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUESTCODE_ANOTHER = 1004;

    Button btnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity = (Button) findViewById(R.id.btnActivity);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivityForResult(intent, REQUESTCODE_ANOTHER);
            }
        });
    }


    //받아온 결과값 처리 메소드 오버라이드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUESTCODE_ANOTHER){
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult() 메소드 자동호출됨" + "\n" +
            "요청코드: " + requestCode + ", 결과코드: " + resultCode, Toast.LENGTH_LONG);  //baseContext = applicationContext
            toast.show();

            if(resultCode == RESULT_OK){    //result_ok는 -1로 자동 세팅되어있음
                String name = data.getExtras().getString("name");

                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 name: " + name, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }
}
