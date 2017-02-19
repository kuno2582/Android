package com.example.kuno.intentex04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int GET_DATA = 1;
    Button btnMove;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = (Button) findViewById(R.id.btnMove);
        tvData = (TextView) findViewById(R.id.tvData);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, GET_DATA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GET_DATA){
            if(resultCode == RESULT_OK){
                tvData.setText(data.getStringExtra("INPUT_TEXT"));
            }else if(resultCode == RESULT_CANCELED){
                tvData.setText("");
            }
        }
    }
}
