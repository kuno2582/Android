package com.example.kuno.sqliteex;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    DatabaseAdapter databaseAdapter;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;

    static final String TAG = "SQLiteDemo";

    TextView tv_mCurrentID;
    EditText etEditMemo;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_mCurrentID = (TextView) findViewById(R.id.tvId);
        etEditMemo = (EditText) findViewById(R.id.etEditMemo);
        listView = (ListView) findViewById(R.id.lvList);

        int buttons[] = {R.id.btnAdd, R.id.btnDelete, R.id.btnModify};

        for(int id:buttons){
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
        }

        listView.setOnItemClickListener(this);

        setEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();

        cursor = databaseAdapter.fetchAllMemo();

        String[] from = DatabaseAdapter.PROJECTION;
        int[] to = new int[]{R.id.tv_ID, R.id.tv_Content};

        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.memo_row,
                cursor, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);  //마지막 인자는 의무사항(데이터감시)

        listView.setAdapter(simpleCursorAdapter);
    }

    //데이터 선택에 따른 버튼 활성화/비활성화 메서드
    private void setEnabled(boolean enabled){
        int buttons[] = {R.id.btnDelete, R.id.btnModify};

        for(int id:buttons){
            Button button = (Button) findViewById(id);
            button.setEnabled(enabled);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        cursor.close();

        databaseAdapter.close();
    }

    private  void toastMemo(String str){

        if(str.length() == 0){
            return;
        }

        String memo = databaseAdapter.searchMemo(str);
        Toast.makeText(this, memo, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        String id = tv_mCurrentID.getText().toString();
        String content = etEditMemo.getText().toString();

        if(v.getId()==R.id.btnAdd){
            if(content.length() != 0){
                databaseAdapter.addMemo(content);
                toastMemo(content);
            }
        }else if(v.getId()==R.id.btnModify){
            if(content.length()!=0){
                databaseAdapter.setMemo(id, content);
                toastMemo(content);
            }
        }else if(v.getId()==R.id.btnDelete){
            databaseAdapter.deleteMemo(id);
        }

        etEditMemo.setText("");
        tv_mCurrentID.setText("ID");

        cursor = databaseAdapter.fetchAllMemo();
        simpleCursorAdapter.changeCursor(cursor); //변경사항을 알려주고 refresh시켜줌

        setEnabled(false);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        LinearLayout layout = (LinearLayout) view;   //클릭이 일어난 자식뷰
        TextView tv_Content = (TextView) layout.findViewById(R.id.tv_Content);
        etEditMemo.setText(tv_Content.getText());
        tv_mCurrentID.setText(Long.toString(id));

        setEnabled(true);

        toastMemo(tv_Content.getText().toString());

    }
}
