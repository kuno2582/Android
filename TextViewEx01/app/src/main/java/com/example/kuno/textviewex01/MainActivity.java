package com.example.kuno.textviewex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
Activity
앱의 하나의 화면
안드로이드 폰에 나타나는 화면으로 사용자에게 보여주는 화면을 생성하는 요소
일반적으로 액티비티 하나당 하나의 xml파일이 존재합니다.
안드로이드에서도 여러개의 액티비티를 작성할 수 있습니다. 이 때 맨 앞에 나오는 화면
하나만 활성화 된 상태이고, 나머지는 모두 비활성화 된 상태로 존재합니다.
새로운 액티비티를 생성할 때 Activity클래스를 상속받아 새로운 클래스를 만들고
추가한 액티비티는 Manifest.xml 폴더에 등록해야 합니다.

UI 오브젝트
사용자 인터페이스 객체

유저 인터페이스 인스턴스
UI 오브젝트가 하나의 변수로 메모리에 할당된 상태

뷰그룹
뷰들을 여러개 포함하고 있는 것

레이아웃
뷰의 배치방식을 말함

TextView
Activity에 텍스트(문자열)을 표시하기 위한 뷰


*/


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
