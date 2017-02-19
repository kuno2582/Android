package com.example.kuno.fileex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*

Data\Data\[프로젝트 패키지명]\files\파일명

*/

public class MainActivity extends AppCompatActivity {

    static final String NOTES = "notes.text";

    Button btnClose;
    EditText etEditer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClose = (Button) findViewById(R.id.btnClose);
        etEditer = (EditText) findViewById(R.id.etEditer);

        btnClose.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        InputStream in = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        try{
            in = openFileInput(NOTES);  //파일이름을 대상으로 읽는다, 바이너리정보가 저장
            if(in != null){
                inputStreamReader = new InputStreamReader(in);  //문자스트림으로 변환
                reader = new BufferedReader(inputStreamReader); //문자를 효율적으로 읽어옴

                String str; //덧붙일 때마다 쓰레기객체가 생성됨
                StringBuffer buf = new StringBuffer();  //덧붙일 때 원본에서 덧붙여서 쓰레기객체 생성x

                while((str = reader.readLine()) != null){
                    buf.append(str + '\n');
                }
                etEditer.setText(buf.toString());
            }
        }catch(FileNotFoundException e){

        }catch(Exception e){
            Toast.makeText(this, "예외: " + e.toString(), Toast.LENGTH_SHORT).show();
        }finally {
            try{
                if(reader!=null)reader.close();
                if(inputStreamReader!=null)inputStreamReader.close();
                if(in!=null)in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        OutputStreamWriter out = null;

        try{
            //mode_private  :   기존에 파일명 있으면 덮어쓰기
            out = new OutputStreamWriter(openFileOutput(NOTES, MODE_PRIVATE));
            out.write(etEditer.getText().toString());

            Toast.makeText(this, "데이터를 저장합니다!", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null) try {out.close();} catch (IOException e) {e.printStackTrace();}
        }
    }
}
