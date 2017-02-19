package com.example.kuno.activityex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMove,btnEnter;
    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = (Button) findViewById(R.id.btnMove);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        etText = (EditText) findViewById(R.id.etText);

        btnMove.setOnClickListener(this);
        btnEnter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch(v.getId()){

            case R.id.btnMove:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                break;

            case R.id.btnEnter:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("msg", etText.getText().toString());
                break;
        }

        startActivity(intent);
    }
}
