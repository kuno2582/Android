package com.example.kuno.actionbarex;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/*
Context(컨텍스트)
객체의 상태 정보를 표현
액티비티 정보 저장/제공

안드로이드에서는 UI구성요소인 뷰의 정보를 확인하거나 설정하기 위해 컨텍스트 객체를 사용합니다.
액티비티 클래스 안에서는 this를 컨텍스트 객체로 사용할 수 있습니다.
Activity 는 Context클래스를 상속하기 때문에 가능합니다.


*/

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = this.getSupportActionBar(); //현재 있는 액션바 가져오기

       /* actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME);*/
        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME);
        actionBar.setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.itSearch:
                Toast.makeText(this, "검색으로", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itChat:
                Toast.makeText(this, "채팅으로", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itEmail:
                Toast.makeText(this, "이메일로", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itRefresh:
                Toast.makeText(this, "새로고침", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itSettings:
                Toast.makeText(this, "설정으로", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                Toast.makeText(this, "뒤로", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
