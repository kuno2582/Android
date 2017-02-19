package com.example.kuno.listviewex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/*
선택 위젯
 - 여러 개의 아이템중에 하나를 선택할 수 있게 해주는 위젯
 - 선택 위젯은 어댑터(adapter)를 사용하기 때문에 직접 위젯에 데이터를 설정할 수 없습니다.
 - 어댑터에서 만들어주는 뷰를 사용해서 여러개의 아이템을 표시해 주는 방식
 - 선택 위젯에 표시할 항목에 대한 데이터는 어댑터 객체로부터 가져와서 표시해 주게 됩니다.
 - 어댑터뷰(AdapterView)를 상속받고 있습니다.

ListView
 - 수직방향의 목록을 만들어주는 선택 위젯 (수직 스크롤 지원)


*/

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] items = {"서울", "대전", "대구", "부산", "광주", "인천", "여수", "목포", "포항", "통영", "제주", "수원", "독도도"};

    TextView text;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView);
        list = (ListView)findViewById(R.id.listView);

        //목록 생성 작업
        //ArrayAdapter(현재액티비티, 어떤 자식을 만들건지 뷰 지정, 어떤 데이터를 뷰에 넣을건지)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        list.setAdapter(adapter);

        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        text.setText(items[position]);
    }
}
