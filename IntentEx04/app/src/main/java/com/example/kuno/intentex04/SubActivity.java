package com.example.kuno.intentex04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kuno on 2017-02-01.
 */

public class SubActivity extends Activity implements View.OnClickListener {

    EditText etData;
    Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etData = (EditText) findViewById(R.id.etData);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnOk){
            Intent intent = new Intent();
            intent.putExtra("INPUT_TEXT", etData.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }else if(v.getId() == R.id.btnCancel){
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
