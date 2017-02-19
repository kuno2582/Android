package com.example.kuno.contextmenubyxml;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    Button btnContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        btnContext = (Button) findViewById(R.id.btnContext);

        registerForContextMenu(btnContext);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        if(v == btnContext){
            menuInflater.inflate(R.menu.main, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.red:
                mainLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                mainLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yellow:
                mainLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.gray:
                mainLayout.setBackgroundColor(Color.GRAY);
                break;
            case R.id.green:
                mainLayout.setBackgroundColor(Color.GREEN);
                break;
        }
        return false;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.red:
                mainLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                mainLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yellow:
                mainLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.gray:
                mainLayout.setBackgroundColor(Color.GRAY);
                break;
            case R.id.green:
                mainLayout.setBackgroundColor(Color.GREEN);
                break;
        }
        return false;
    }
}
