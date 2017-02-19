package com.tistory.codedragon.framelayoutex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        ivImage = (ImageView)findViewById(R.id.imageView);

        ivImage.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(ivImage.getVisibility() == View.VISIBLE){
                    ivImage.setVisibility(View.INVISIBLE);
                }else{
                    ivImage.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
