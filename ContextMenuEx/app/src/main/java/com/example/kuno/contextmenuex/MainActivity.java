package com.example.kuno.contextmenuex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/*
컨텍스트 메뉴 생성
1) XML 폴더 생성
2) xml 파일 생성
3) onCreateContextMenu()
4) onContextItemSelected()
5) onCreate()안에 registerForContextMenu()로 등록

*/

public class MainActivity extends AppCompatActivity {

    String[] items = {
            "진돗개", "삽살개", "불독", "슈나우저", "푸들", "차우차우", "달마시안", "그레이하운드", "콜리",
            "셰퍼드", "세인트버나드", "그레이트데인", "시츄", "리트리버", "비글", "보르조이", "도베르만"
    };

    ArrayAdapter<String> adapter;
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.lvList);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        myListView.setAdapter(adapter);

        registerForContextMenu(myListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Divider 변경");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        menu.add(Menu.NONE, 1, Menu.NONE, "16px");
        menu.add(Menu.NONE, 2, Menu.NONE, "24px");
        menu.add(Menu.NONE, 3, Menu.NONE, "32px");
        menu.add(Menu.NONE, 4, Menu.NONE, "40px");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);
        switch(item.getItemId()){
            case 1:
                myListView.setDividerHeight(16);
                return true;
            case 2:
                myListView.setDividerHeight(24);
                return true;
            case 3:
                myListView.setDividerHeight(32);
                return true;
            case 4:
                myListView.setDividerHeight(40);
                return true;
        }
        return false;
    }
}
