package com.example.kuno.customdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {

        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.custom_dialog);
        loginDialog.setTitle("로그인 화면");

        Button btnLogin = (Button)loginDialog.findViewById(R.id.btnLogin);
        Button btnCancel = (Button)loginDialog.findViewById(R.id.btnCancel);
        final EditText etUsername = (EditText)loginDialog.findViewById(R.id.etUserName);
        final EditText etPassword = (EditText)loginDialog.findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().trim().length() > 0 && etPassword.getText().toString().trim().length() > 0){
                    Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                    loginDialog.dismiss();
                }else{
                    Toast.makeText(getApplicationContext(), "ID 또는 PW가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

        loginDialog.show();

    }
}
