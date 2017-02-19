package com.example.kuno.optionmenubyxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/*
\res\menu
 - 메뉴를 정의하는 xml파일
 - 가장 상위에 <menu>태그를 가지고 있습니다.
 - 각각의 메뉴아이템은 <item>태그로 정의해 줍니다.
 - 메뉴를 정의한 xml파일 onCreateOptionsMenu()메소드 안에서 인플레이터 객체를 사용해서
    메뉴정보를 생성합니다.


*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.itSeoul:
                Toast.makeText(this, "서울", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itBusan:
                Toast.makeText(this, "부산", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itNewYork:
                Toast.makeText(this, "뉴욕", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itVenice:
                Toast.makeText(this, "베니스", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
