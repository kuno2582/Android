package com.example.kuno.xmlpullparseex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnParse;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParse = (Button) findViewById(R.id.btnParse);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnParse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                +"<order><item>Laptop</item></order>";

        //파싱결과 확인을 위한 변수
        boolean initem = false;
        String itemName = "";

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xml));

            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                switch(eventType){
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("item")){
                            initem=true;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        if(initem){
                            itemName = parser.getText();
                            initem = false;
                        }
                        break;
                }
                eventType = parser.next();
            }//while

            tvResult.setText("주문 항목: " + itemName);

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
