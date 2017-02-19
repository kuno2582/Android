package com.example.kuno.activityex02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName,etKorean,etEnglish,etMath;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etKorean = (EditText) findViewById(R.id.etKorean);
        etEnglish = (EditText) findViewById(R.id.etEnglish);
        etMath = (EditText) findViewById(R.id.etMath);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", etName.getText().toString());
                intent.putExtra("Korean", etKorean.getText().toString());
                intent.putExtra("English", etEnglish.getText().toString());
                intent.putExtra("Math", etMath.getText().toString());
                startActivity(intent);
            }
        });
    }
}
