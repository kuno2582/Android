package com.example.kuno.listviewcustomized;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
BaseAdapter
 - 어댑터 뷰와 관계되는 어댑터를 구현하기 위해서는 BaseAdapter 클래스를
    상속받는 어댑터 클래스를 정의해서 사용합니다.
 - BaseAdapter를 상속받은 클래스를 생성하면 BaseAdapter 내에 정의된 추상메소드를 구현해야 합니다.
    getCount, getItem, getItemId, getView 들이 있습니다.





*/
public class MainActivity extends AppCompatActivity {

    ArrayList<MyItem> myItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myItems = new ArrayList<MyItem>();
        myItems.add(new MyItem(R.mipmap.ic_launcher, "SONY VAIO"));
        myItems.add(new MyItem(R.mipmap.ic_launcher, "HP PAVILION"));
        myItems.add(new MyItem(R.mipmap.ic_launcher, "LG GRAM"));
        myItems.add(new MyItem(R.mipmap.ic_launcher, "Apple MacBookPro"));
        myItems.add(new MyItem(R.mipmap.ic_launcher, "MS Surface"));

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.widget_icontext, myItems);
        ListView lvList = (ListView)findViewById(R.id.lvList);
        lvList.setAdapter(myListAdapter);

    }

    class MyItem {
        int icon;
        String name;

        public MyItem(int icon, String name) {
            this.icon = icon;
            this.name = name;
        }
    }

    class MyListAdapter extends BaseAdapter {

        //context는 프로그래밍에서 객체의 상태 정보를 표현(Activity 정보 저장)
        Context context;
        LayoutInflater inflater;

        int layout;
        ArrayList<MyItem> myItems;

        public MyListAdapter(Context context, int layout, ArrayList<MyItem> myItems) {
            this.context = context;
            this.layout = layout;
            this.myItems = myItems;

            inflater = LayoutInflater.from(context);

        }

        @Override
        public int getCount() {
//            return 0;
            return myItems.size();
        }

        @Override
        public Object getItem(int position) {
//            return null;
            return myItems.get(position).name;
        }

        @Override
        public long getItemId(int position) {
//            return 0;
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            return null;
            final int pos = position;
            if (convertView == null) {
                convertView = inflater.inflate(layout, null);
            }

            ImageView ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            ivIcon.setImageResource(myItems.get(position).icon);

            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            tvName.setText(myItems.get(position).name);

            Button btnSelect = (Button)convertView.findViewById(R.id.btnSelect);
            btnSelect.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String str = myItems.get(pos).name + "를 주문합니다.";

                    Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
                }


            });

            return convertView;
        }

    }
}
