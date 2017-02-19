package com.example.kuno.intentex03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kuno on 2017-02-01.
 */

public class IntentTwo extends Activity implements View.OnClickListener {

    Button btnSuccess, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btnSuccess = (Button) findViewById(R.id.btnSuccess);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnSuccess.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSuccess){

            Intent intentResult = getIntent();
            intentResult.putExtra("msg", "데이터");

            setResult(RESULT_OK, intentResult);

            finish();

        }else if(v.getId() == R.id.btnCancel){

            setResult(RESULT_CANCELED, null);

            finish();

        }
    }

}
