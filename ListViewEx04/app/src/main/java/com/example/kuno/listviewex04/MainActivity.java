package com.example.kuno.listviewex04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
/*
SparseBooleanArray
 - ListView 다중 선택시 선택한 position에 대한 정보를 보관하고 있는 객체
 - get()메소드를 호출해서 선택된 position값을 구할 수 있습니다.
 - get()는 position값이 존재하면 true를 반환해 줍니다.

*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView myListView;
    Button btnAdd,btnDel;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDel = (Button)findViewById(R.id.btnDel);
        myListView = (ListView)findViewById(R.id.listView);
        myEditText = (EditText)findViewById(R.id.etText);

        items = new ArrayList<String>();
        items.add("One");
        items.add("Two");
        items.add("Three");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items);
        myListView.setAdapter(adapter);
        myListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnAdd:

                String text = myEditText.getText().toString();
                if(text.length() > 0){
                    items.add(0, text);
                    myListView.clearChoices();
                    adapter.notifyDataSetChanged();
                    myEditText.setText("");
                }
                break;

            case R.id.btnDel:

                SparseBooleanArray sba = myListView.getCheckedItemPositions();  //선택된 것들 배열로 가져오기

                if(sba.size() > 0){
                    for(int i=myListView.getCount()-1; 1>=0; i--){
                        if(sba.get(i)){
                            items.remove(i);
                        }
                    }
                }

                myListView.clearChoices();

                adapter.notifyDataSetChanged();

                break;
        }
    }
}
