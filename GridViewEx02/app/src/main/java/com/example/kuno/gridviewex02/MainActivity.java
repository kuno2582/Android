package com.example.kuno.gridviewex02;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] images = {
            R.drawable.austria, R.drawable.belgium, R.drawable.bulgaria, R.drawable.cyprus,
            R.drawable.czech_republic, R.drawable.denmark, R.drawable.estonia, R.drawable.finland,
            R.drawable.france, R.drawable.germany, R.drawable.greece, R.drawable.hungary,
            R.drawable.ireland, R.drawable.italy, R.drawable.latvia, R.drawable.lithuania,
            R.drawable.luxembourg, R.drawable.malta, R.drawable.netherlands, R.drawable.poland,
            R.drawable.portugal, R.drawable.romania, R.drawable.slovakia, R.drawable.slovenia,
            R.drawable.spain, R.drawable.sweden, R.drawable.united_kingdom
    };

    GridView myGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGridView = (GridView)findViewById(R.id.gvView);

        myGridView.setAdapter(new ImageAdapter(this));
    }

    class ImageAdapter extends BaseAdapter {

        private Context context;

        public ImageAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView myImageView = (ImageView)convertView;

            if(convertView == null){
                myImageView = new ImageView(context);
            }

            myImageView.setLayoutParams(new GridView.LayoutParams(80, 80));
            myImageView.setPadding(10, 10, 10, 10);
            myImageView.setImageResource(images[position]);

            return myImageView;

        }
    }
}
