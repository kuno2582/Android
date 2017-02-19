package com.example.kuno.intentobjectex02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnParcelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParcelButton = (Button) findViewById(R.id.btnParcelable);

        btnParcelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                DataParcel obj = new DataParcel("Kuno", 27, "Yaksu");

                intent.putExtra("ObjectType", "오브젝트 Parcelable");
                intent.putExtra("ObjectData", obj);

                startActivity(intent);
            }
        });
    }
}
