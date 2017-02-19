package com.example.kuno.asynctaskex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCount;
    Button btnStart;
    CountAsyncTask countAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.tvcount);
        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnStart:
                    countAsyncTask = new CountAsyncTask(MainActivity.this, tvCount);
                    countAsyncTask.execute(100, 50);
                    break;
            }
        }
    };
}
