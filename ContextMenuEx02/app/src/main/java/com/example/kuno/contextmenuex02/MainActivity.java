package com.example.kuno.contextmenuex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/*
1) XML -> .xml 파일
2) onCreateActionMode()
3) onActionItemClicked()





*/

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {

    ActionMode mActionMode;
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvView = (TextView) findViewById(R.id.tvView);

        tvView.setOnLongClickListener(this);
    }


    @Override
    public boolean onLongClick(View v) {
        //return false;

        if(mActionMode != null){
            return false;
        }

        mActionMode = this.startActionMode(this);
        v.setSelected(true);
        return true;
    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //return false;
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        //return false;
        switch(item.getItemId()){
            case R.id.itAttach:
                mode.finish();
                return true;
            case R.id.itShare:
                Toast.makeText(getApplication(), "공유되었습니다.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        mActionMode = null;
    }
}
