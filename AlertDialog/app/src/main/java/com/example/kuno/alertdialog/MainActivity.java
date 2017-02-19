package com.example.kuno.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*

AlertDialog 클래스
 - 알림 대화상자를 보여주는 클래스
 - 토스트 메시지와 함께 앱에서 필요한 메시지(상태, 데이터, 정보)를 보여줄 때 사용합니다.
 - 사용자에게 메시지를 전달하고 질문을 통해 사용자의 선택을 받을 수 있는 화면창을
    제공해주게 됩니다.

*/

public class MainActivity extends AppCompatActivity {

    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = (Button)findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("AlertDialog Test");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setMessage("종료하시겠습니까?");

                dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplication(), "예 버튼 CLICK", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNeutralButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplication(), "취소 버튼 CLICK", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast msg = Toast.makeText(getApplication(), "아니오 버튼 CLICK", Toast.LENGTH_SHORT);

                        DisplayMetrics disp = getApplicationContext().getResources().getDisplayMetrics();

                        int xOffset = (int)(Math.random() * disp.widthPixels);
                        int yOffset = (int)(Math.random() * disp.heightPixels);

                        msg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

                        msg.show();
                    }
                });

                dialog.show();
            }
        });

    }
}
