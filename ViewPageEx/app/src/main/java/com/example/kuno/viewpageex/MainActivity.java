package com.example.kuno.viewpageex;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager myViewPager;

    int[] btn = {R.id.btnY, R.id.btnP, R.id.btnR};

    //이벤트 처리 객체
    private View.OnClickListener myListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            switch(v.getId()){

                case R.id.btnY:
                    myViewPager.setCurrentItem(0);
                    break;

                case R.id.btnP:
                    myViewPager.setCurrentItem(1);
                    break;

                case R.id.btnR:
                    myViewPager.setCurrentItem(2);
                    break;

                //토스트 메시지 출력
                case R.id.btnPink:
                case R.id.btnRed:
                case R.id.btnYellow:
                    String text = ((Button)v).getText().toString();
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int id : btn){
            findViewById(id).setOnClickListener(myListener);
        }

        myViewPager = (ViewPager)findViewById(R.id.vpView);

        myViewPager.setAdapter(new MyPagerAdapter(this));

    }

    private class MyPagerAdapter extends PagerAdapter {

        LayoutInflater myLayoutInflater;

        public MyPagerAdapter(Context context){
            myLayoutInflater = LayoutInflater.from(context);
        }

        //viewPager에서 사용할 view객체 생성/등록
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);

            View v = null;

            switch(position){
                case 0:
                    v = myLayoutInflater.inflate(R.layout.page_yellow, null);
                    v.findViewById(R.id.btnYellow).setOnClickListener(myListener);
                    break;
                case 1:
                    v = myLayoutInflater.inflate(R.layout.page_pink, null);
                    v.findViewById(R.id.btnPink).setOnClickListener(myListener);
                    break;
                case 2:
                    v = myLayoutInflater.inflate(R.layout.page_red, null);
                    v.findViewById(R.id.btnRed).setOnClickListener(myListener);
                    break;
            }

            ((ViewPager)container).addView(v, 0);

            return v;

        }

        //View객체 삭제하는 메소드
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            ((ViewPager)container).removeView((View)object);
        }

        //현재 PagerAdapter에서 관리한 페이지 갯수 반환
        @Override
        public int getCount() {
            return btn.length;
//            return 0;
        }

        //instantiateItem 메소드에서 완성된 객체를 이용할 것인치를 체크
        @Override
        public boolean isViewFromObject(View view, Object object) {
//            return false;
            return view == object;  //true이면 출력, false이면 출력x
        }
    }
}
