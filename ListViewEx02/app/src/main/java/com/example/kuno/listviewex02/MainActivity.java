package com.example.kuno.listviewex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    EditText myEditText;
    Button button;
    ArrayList<String> todoItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.lvList);
        myEditText = (EditText)findViewById(R.id.etText);
        button = (Button)findViewById(R.id.btnAdd);

        todoItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);

        myListView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                todoItems.add(0, myEditText.getText().toString());
                adapter.notifyDataSetChanged(); //배열에 변경된 사항이 바로 적용되어 뷰에 나타남
                myEditText.setText("");
            }
        });
    }
}
