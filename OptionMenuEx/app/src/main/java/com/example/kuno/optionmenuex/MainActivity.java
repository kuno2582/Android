package com.example.kuno.optionmenuex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/*
Menu 종류
 - 사용자가 여러 항목 중 하나를 선택하면 해당 명령을 수행하는 형태
2가지 종류

옵션 메뉴(Option Menu)
 - 디바이스의 메뉴 버튼을 눌렀을 때 표시되는 메뉴
 - 옵션메뉴는 각각의 화면마다 설정할 수 있습니다.
 - 액티비티의 주 메뉴를 구성
 - 화면 상단/하단에 숨겨져 있으며 Menu버튼을 눌러야 표시가 됩니다.
 - 프로그램의 주요 기능이나 설정등의 명령을 옵션 메뉴에 배치합니다.

컨텍스트 메뉴(Context Menu)
 - 아이템 항목을 길게 눌렀을 때(롱 클릭) 화면 정중앙에 표시되는 메뉴
 - 컨텍스트 메뉴는 각각의 뷰마다 설정할 수 있습니다.
 - 주로 리스트뷰의 항목에 대해 사용됩니다.

옵션 메뉴 추가방법
1) Menu 폴더 생성
2) xml 파일 생성
3) onCreateOptionMenu() - 메뉴생성
4) optionsItemSelected() - 메뉴항목 선택에 대한 이벤트 처리

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        //groupid   MENU.NONE (0)
        //itemid    메뉴 아이템 부여된 ID
        //order     표시될 순서, Menu.NONE(0)
        //title     메뉴 아이템에 표시될 텍스트
        menu.add(Menu.NONE, 1, Menu.NONE, "16px");
        menu.add(Menu.NONE, 2, Menu.NONE, "24px");
        menu.add(Menu.NONE, 3, Menu.NONE, "32px");
        menu.add(Menu.NONE, 4, Menu.NONE, "40px");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case 1:
                myListView.setDividerHeight(16);break;
            case 2:
                myListView.setDividerHeight(24);break;
            case 3:
                myListView.setDividerHeight(32);break;
            case 4:
                myListView.setDividerHeight(40);break;
        }
        return true;
    }
}
