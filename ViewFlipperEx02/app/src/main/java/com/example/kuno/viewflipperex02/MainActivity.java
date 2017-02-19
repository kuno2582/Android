package com.example.kuno.viewflipperex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ViewFlipper myViewFlipper;

    int[] imageItems;

    float down_x;
    float up_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageItems = new int[]{
            R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04, R.drawable.img05,
            R.drawable.img06, R.drawable.img07, R.drawable.img08, R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12, R.drawable.img13
        };

        myViewFlipper = (ViewFlipper)findViewById(R.id.vfView);

        for(int i : imageItems){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(i);
            myViewFlipper.addView(imageView,
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        myViewFlipper.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        return false;
        if(v != myViewFlipper){
            return false;
        }

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            down_x = event.getX();
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            up_x = event.getX();

            if(up_x < down_x){
                myViewFlipper.setInAnimation(this, R.anim.push_left_in);
                myViewFlipper.setOutAnimation(this, R.anim.push_left_out);
                myViewFlipper.showNext();
            }else if(up_x > down_x){
                myViewFlipper.setInAnimation(this, R.anim.push_right_in);
                myViewFlipper.setOutAnimation(this, R.anim.push_right_out);
                myViewFlipper.showPrevious();
            }
        }
        return true;
    }
}
