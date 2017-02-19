package com.example.kuno.intentmultiex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void listenerAbout(View v){
        Intent intent  = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    public void listenerCharacters(View v){
        Intent intent  = new Intent(getApplicationContext(), CharactersActivity.class);
        startActivity(intent);
    }

    public void listenerSettings(View v){
        Intent intent  = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.menuSettings:

                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);

                return true;
        }
        return false;
    }
}
