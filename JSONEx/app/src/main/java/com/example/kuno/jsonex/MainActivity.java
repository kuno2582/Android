package com.example.kuno.jsonex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnParse;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = (Button) findViewById(R.id.btnParse);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnParse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String strJSON = "[8, 1, 9, 6, 2, 4, 7, 3, 5]";

        try{
            int sum = 0;

            JSONArray jsonArray = new JSONArray(strJSON);

            for(int i=0; i<jsonArray.length(); i++){
                sum += jsonArray.getInt(i);
            }

            tvResult.setText("Sum = " + sum);

        }catch (Exception e){
            Toast.makeText(v.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
