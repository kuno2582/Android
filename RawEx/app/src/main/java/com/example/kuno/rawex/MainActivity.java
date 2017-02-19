package com.example.kuno.rawex;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/*

raw
/res/raw 폴더에 필요한 파일을 저장해서 사용하는 방법
/res/raw 폴더는 읽기전용으로만 사용
openRawResource()

*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnWrite,btnRead,btnRawRead;
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnRawRead = (Button) findViewById(R.id.btnRawRead);
        tvView = (TextView) findViewById(R.id.tvView);
        tvView.setMovementMethod(new ScrollingMovementMethod());

        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnRawRead.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btnWrite:
                try {
                    FileOutputStream fos = openFileOutput("poem.txt", Context.MODE_PRIVATE);
                    String strPome = "분명한 것과 희미한 것 - 홍순택 - ";
                    fos.write(strPome.getBytes());
                    fos.close();
                    Toast.makeText(getApplication(), "poem.txt파일이 생성되었습니다.", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    tvView.setText(e.toString());
                }
                break;

            case R.id.btnRead:
                try{
                    FileInputStream fis = openFileInput("poem.txt");
                    byte[] txt = new byte[100];
                    fis.read(txt);
                    String str = new String(txt);
                    fis.close();
                    Toast.makeText(getApplication(), str, Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(getApplication(), "poem.txt파일이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnRawRead:

                try {
                    InputStream is = getResources().openRawResource(R.raw.settings);
                    byte[] txt = new byte[is.available()];
                    is.read(txt);
                    tvView.setText(new String(txt));

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
