package com.example.kuno.intentex03;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIntentTwo, btnAddress;
    private static final int SHOW_ACTIVITY_INTENTTWO = 1;
    private static final int SHOW_ACTIVITY_ADDRESS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntentTwo = (Button) findViewById(R.id.btnIntentTwo);
        btnAddress = (Button) findViewById(R.id.btnAddress);

        btnIntentTwo.setOnClickListener(this);
        btnAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        if(v.getId() == R.id.btnIntentTwo){

            intent = new Intent(MainActivity.this, IntentTwo.class);
            startActivityForResult(intent, SHOW_ACTIVITY_INTENTTWO);

        }else if(v.getId() == R.id.btnAddress){

            intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people"));
            startActivityForResult(intent, SHOW_ACTIVITY_ADDRESS);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){

            case SHOW_ACTIVITY_INTENTTWO:
                if(resultCode == Activity.RESULT_OK){
                    String result = data.getStringExtra("msg");
                    Toast.makeText(this, "성공: " + result, Toast.LENGTH_LONG).show();
                }else if(resultCode == Activity.RESULT_CANCELED){
                    Toast.makeText(this, "취소됨", Toast.LENGTH_LONG).show();
                }
                break;

            case SHOW_ACTIVITY_ADDRESS:

                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(this, "성공: " + data.getData().toString(), Toast.LENGTH_LONG).show();
                }else if(resultCode == Activity.RESULT_CANCELED){
                    Toast.makeText(this, "취소됨", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}
