package com.example.kuno.popupmenuex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

/*
PopupMenu
 - 팝업 메뉴를 제공
 - 특정 위치에 팝업되어 서브 메뉴로 사용할 수 있는 메뉴를 의미한다.

*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopup = (Button) findViewById(R.id.btnPopup);
        btnPopup.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getApplicationContext(), "클릭된 팝업 메뉴: "+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();
    }
}
