package com.example.kuno.viewflipperex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
/*
ViewFlipper
 - 여러개 뷰들을 ViewFlipper에 넣은 다음 페이지 넘김 효과와 함께 보여주는 위젯
 - 안에 여러개의 뷰들을 배치한 후 필요에 따라 화면을 왼쪽으로 또는 오른쪽으로 밀어서(swipe) 화면에
    해당 뷰를 하나 보여주는 방식으로 동작하는 위젯
 - android-support-v4.jar 라이브러리 추가


*/


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper myViewFlipper;
    Button btnPrev,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewFlipper = (ViewFlipper)findViewById(R.id.vfDetails);
        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnNext){
            myViewFlipper.showNext();
        }else if(v.getId() == R.id.btnPrev){
            myViewFlipper.showPrevious();
        }
    }
}
