package com.example.kuno.eventex02_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn;

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);

        updateTime();

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                updateTime();
            }
        });

    }

    private void updateTime(){
        btn.setText(sf.format(new Date()));
    }
}
