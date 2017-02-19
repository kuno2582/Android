package com.example.kuno.listviewex03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView myListView;
    EditText myEditText;
    Button btnAdd, btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.lvList);
        myEditText = (EditText)findViewById(R.id.etText);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDel = (Button)findViewById(R.id.btnDel);

        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);
        myListView.setAdapter(adapter);

        myListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //이걸 선언해야 선택가능해진다.

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
                    adapter.notifyDataSetChanged();
                    myEditText.setText("");
                }
                break;

            case R.id.btnDel:

                int id = myListView.getCheckedItemPosition();
                if(id != ListView.INVALID_POSITION){
                    items.remove(id);
                    myListView.clearChoices();
                    adapter.notifyDataSetChanged();
                }
                break;
        }

    }
}
