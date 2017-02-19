package com.example.kuno.tabhostex;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
/*

TabHost
 - 탭 기능을 제공해주는 UI오브젝트
 - TabWidget(탭 버튼), FrameLayout(화면을 구성하는 부분)

TabHost 사용 방법
1   TabHost 객체 생성
2   TabSpec 객체 생성
3   TabSpec 객체에 Indicator 설정
4   TabSpec 객체에 Content 설정
5   TabHost 등록

*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost myTabHost = (TabHost)findViewById(R.id.tabhost);

        myTabHost.setup();

        TabHost.TabSpec tabSpec = myTabHost.newTabSpec("tab_analogClock");
        tabSpec.setContent(R.id.tab1_analogClock);
        tabSpec.setIndicator("시계", getResources().getDrawable(R.mipmap.ic_launcher));

        myTabHost.addTab(tabSpec);

        tabSpec = myTabHost.newTabSpec("tag_button");
        tabSpec.setContent(R.id.tab2_button);
        tabSpec.setIndicator("버튼", ContextCompat.getDrawable(this, R.mipmap.ic_launcher));

        myTabHost.addTab(tabSpec);

        myTabHost.setCurrentTab(1); //시작탭 설정
    }
}
