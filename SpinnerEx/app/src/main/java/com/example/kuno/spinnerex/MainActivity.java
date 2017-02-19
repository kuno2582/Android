package com.example.kuno.spinnerex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
/*

Spinner
 - 드롭다운 선택가능한 항목을 구현해 주는 클래스
 - 작은 화면에 여러 개의 항목을 표시해 주고 그 중 하나를 선택할 수 있도록 해주는
    기능을 제공합니다.
 - AdapterView 상속



*/

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] items = {"대한민국(서울)", "네팔(카트만두)", "라오스(비엔티안)", "레바논(베이루트)", "말레이시아(콸라룸푸르)",
        "몰디브(말레)", "몽골(울란바토르)", "미얀마(양곤)", "바레인(마나마)", "방글라데시(다카)", "베트남(하노이)", "부탄(탕부)",
        "사우디아라비아(리야드)", "스리랑카(스리자야와르데네푸라)", "싱가포르(싱가포르)", "요르단(암만)", "이라크(바그다드)",
        "이란(테헤란)", "이스라엘(예루살렘)", "인도(뉴델리)", "일본(도쿄)"};

    Spinner spinner;
    TextView myTextView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView)findViewById(R.id.tvView);
        spinner = (Spinner)findViewById(R.id.spCountry);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myTextView.setText(items[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        myTextView.setText("");
    }
}
