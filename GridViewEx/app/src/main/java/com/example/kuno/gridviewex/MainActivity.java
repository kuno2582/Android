package com.example.kuno.gridviewex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
/*
GridView
 - 뷰들을 고정된 개수의 열들로 이루어진 격자형태로 배치시켜주는 뷰
 - 격자의 각 칸에 이미지 아이콘을 배치하는 경우가 일반적입니다.
 - 사용자가 한 항목을 선택해서 특정 작업을 수행할 수 있도록 하는 위젯
 - ListView, Spinner 1차원적인 데이터를 표시
 - GridView는 행과 열로 이루어진 2차원적인 데이터를 표시



*/

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] items = {"애플", "자두", "사과", "패션후르츠", "망고스틴", "귤",
            "오렌지", "포도", "수박", "배", "자몽", "레몬", "파인애플"};

    TextView myTextView;
    GridView myGridView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView)findViewById(R.id.tvView);
        myGridView = (GridView)findViewById(R.id.gvView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        myGridView.setAdapter(adapter);

        myGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        myTextView.setText(items[position]);
    }
}
