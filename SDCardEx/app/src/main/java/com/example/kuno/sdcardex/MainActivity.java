package com.example.kuno.sdcardex;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String filename = "test" + System.currentTimeMillis() + ".txt";

    File sdcard_path = Environment.getExternalStorageDirectory();

    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = (TextView) findViewById(R.id.tvOutput);

        writeFileToSDCard();

        readFileFromSDCard();
    }

    private void writeFileToSDCard() {
        tvOutput.setText("[파일 쓰기]\n");

        if(sdcard_path.exists() && sdcard_path.canWrite()){

            File uadDir = new File(sdcard_path.getAbsolutePath() + "/filetest");   //파일생성
            uadDir.mkdir();

            FileOutputStream fos = null;

            try{

                fos = new FileOutputStream(uadDir.getAbsolutePath() + "/" + filename);

                String msg = "SD카드의 파일 내용";

                fos.write(msg.getBytes());

                tvOutput.append("파일이 생성되었습니다.\n");

            }catch(Exception e){
                Toast.makeText(this, "예외: " + e.toString(), Toast.LENGTH_SHORT).show();
            }finally {
                if(fos!=null) try {fos.close();} catch (IOException e) {e.printStackTrace();}
            }

        }

    }

    private void readFileFromSDCard() {

        tvOutput.append("------------------------------\n");
        tvOutput.append("[파일읽기]\n");

        File rFile = new File(sdcard_path.getAbsolutePath() + "/filetest/" + filename);

        if(rFile.canRead()){
            FileInputStream fis = null;

            try{

                fis = new FileInputStream(rFile);

                byte[] reader = new byte[fis.available()];  //fis의 바이트 크기만큼
                fis.read(reader);

                tvOutput.append(new String(reader));

            }catch (Exception e){
                Toast.makeText(this, "예외 발생: " + e.toString(), Toast.LENGTH_SHORT).show();
            }finally{
                if(fis!=null) try {fis.close();} catch (IOException e) {e.printStackTrace();}
            }
        }

    }
}
