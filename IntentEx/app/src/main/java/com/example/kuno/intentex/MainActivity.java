package com.example.kuno.intentex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] buttons = {R.id.btnDial, R.id.btnCall, R.id.btnMap, R.id.btnMessage, R.id.btnSettings};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int button:buttons){
            Button btn = (Button) findViewById(button);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        if(v.getId() == R.id.btnCall){
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-6260-6107"));
        }else if(v.getId() == R.id.btnDial){
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
        }else if(v.getId() == R.id.btnMessage){
            intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-6260-6107"));
        }else if(v.getId() == R.id.btnMap){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Seoul"));
        }else if(v.getId() == R.id.btnSettings){
            intent = new Intent("android.settings.SETTINGS");
        }

        startActivity(intent);

    }
}
