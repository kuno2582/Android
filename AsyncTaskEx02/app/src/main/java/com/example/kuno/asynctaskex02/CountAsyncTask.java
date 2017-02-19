package com.example.kuno.asynctaskex02;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class CountAsyncTask extends AsyncTask<Integer, String, Integer> {

    final static String TAG = "CountAsyncTask";

    Context mContext = null;
    TextView mTv = null;
    boolean cancelFlag = false;
    ProgressDialog dialog = null;

    public CountAsyncTask(Context context, TextView view) {
        this.mContext = context;
        this.mTv = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.i(TAG, "onPreExecute()");

        dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("Downloading");
        dialog.setMessage("Waiting...");
        dialog.setCancelable(false);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "취소", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                cancelFlag = true;
                cancel(true);

                Toast.makeText(mContext.getApplicationContext(), "Cancel Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "숨기기", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext.getApplicationContext(), "Hide Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setProgress(0);
        dialog.show();

    }

    @Override
    protected Integer doInBackground(Integer... params) {
        //return null;
        Log.i(TAG, "doInBackground()");
        Log.i(TAG, "params[0]: " + params[0]);
        Log.i(TAG, "params[1]: " + params[1]);

        for(int i=0; i<params[0]; i++){
            publishProgress(String.valueOf(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(cancelFlag)
                break;
        }

        return params[0];

    }//doInbackground<>

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        Log.i(TAG, "onProgressUpdate()");

        int i = Integer.parseInt((values[0]));

        dialog.setProgress(i);

        mTv.setText(String.valueOf(i));
    }//onProgressUpdate()

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        Log.i(TAG, "onPostExecute()");
        Log.i(TAG, "result: " + integer);

        mTv.setText(String.valueOf(integer));
        dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        Log.i(TAG, "onCancelled()");
        mTv.setText("Cancelled");
        dialog.dismiss();
    }
}
