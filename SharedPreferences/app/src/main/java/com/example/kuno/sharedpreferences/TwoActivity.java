package com.example.kuno.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kuno on 2017-01-25.
 */

public class TwoActivity extends Activity {

    Button btnReadTwo;
    TextView tvViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btnReadTwo = (Button) findViewById(R.id.btnReadTwo);
        tvViewTwo = (TextView) findViewById(R.id.tvViewTwo);

        btnReadTwo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("PreferencesEx", MODE_PRIVATE);
                tvViewTwo.setText(sharedPreferences.getString("text", ""));
            }
        });
    }

}
