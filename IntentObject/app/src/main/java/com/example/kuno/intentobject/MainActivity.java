package com.example.kuno.intentobject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSerializable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSerializable = (Button) findViewById(R.id.btnSerializable);
        btnSerializable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        DataSerial obj = new DataSerial("kuno", 27, "YakSoo");
        intent.putExtra("ObjectType", "오브젝트 Serializable");
        intent.putExtra("ObjectData", obj);

        startActivity(intent);
    }
}
