package com.example.kuno.asynctaskex;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbProgress;
    Button btnTask;
    TextView tvView;

    private int mProgressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbProgress = (ProgressBar)findViewById(R.id.pbProgress);
        btnTask = (Button) findViewById(R.id.btnTask);
        tvView = (TextView) findViewById(R.id.tvView);

        btnTask.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new CounterTask().execute(0);
            }
        });
    }

    class CounterTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            //return null;
            mProgressStatus = params[0];

            while (mProgressStatus < 100) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mProgressStatus++;
                publishProgress(mProgressStatus);
            }

            return mProgressStatus;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            pbProgress.setProgress(mProgressStatus);
            tvView.setText(String.valueOf(mProgressStatus));

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            pbProgress.setProgress(mProgressStatus);
            tvView.setText(String.valueOf(mProgressStatus));
        }
    }

}
