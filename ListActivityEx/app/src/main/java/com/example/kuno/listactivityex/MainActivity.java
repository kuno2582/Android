package com.example.kuno.listactivityex;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/*
ListActivity
 - ListView 정보를 가지고 있습니다.
 - onListItemClick()라는 이벤트 핸들러가 구현되어져 있어 이벤트 재정의해서 사용하면 이벤트 처리를 할 수 있다.
 - ListActivity는 생성되는 listView에 대한 정보를 가지고 있으며, ListView는 ListActivity에 고유ID명으로 명시해줘야한다.

ListView 표시 방법
 - Activity 상속해서 ListView 추가
    ListView의 ID 개발자가 마음대로 지정
 - ListActivity 상속해서 ListView 추가
    ListView의 ID를 ListActivity의 정해진 ID(@android:id/List)를 사용해야 합니다.

*/


public class MainActivity extends ListActivity {

    String[] items = {"미국", "영국", "일본", "아프리카", "프랑스", "독일", "뉴질랜드", "중국", "방콕", "방클라데시",
        "인도", "알래스카", "한국"};

    TextView myTextView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView)findViewById(R.id.tvView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        /*super.onListItemClick(l, v, position, id);*/
        myTextView.setText(items[position]);
    }
}
