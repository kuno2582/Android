package com.example.kuno.jsonex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

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

        String strJSON = "[{\"Product\":\"Dress shirt\",\"Maker\":\"ZIOZIA\", \"Price\":63000},"
                + "{\"Product\":\"Pants\",\"Maker\":\"XESS\",\"Price\":52000},"
                + "{\"Product\":\"Shoes\",\"Maker\":\"Kumkang\",\"Price\":202000},"
                + "{\"Product\":\"Necktie\",\"Maker\":\"BASSO\",\"Price\":60000}"
                + "]";

        try{
            String result = "<주문 목록>\n";
            JSONArray ja = new JSONArray(strJSON);

            for(int i=0; i<ja.length(); i++){
                JSONObject order = ja.getJSONObject(i);
                result += "제품명: " + order.getString("Product") +
                    ", 브랜드: " + order.getString("Maker") +
                    ", 가격: " + order.getInt("Price") +"\n";
            }
            tvResult.setText(result);

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
