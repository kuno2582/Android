package com.example.kuno.domex04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    ListView lvList;
    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvList = (ListView) findViewById(R.id.lvList);

        InputStream in = null;

        try{
            in = getResources().openRawResource(R.raw.words);

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document doc = builder.parse(in);

            //NodeList words = doc.getElementsByTagName("word"); 아래와 같은 표현
            NodeList words = doc.getDocumentElement().getElementsByTagName("word");

            for(int i=0; i<words.getLength(); i++){
                Element e = (Element) words.item(i);
                items.add(e.getAttribute("value"));
            }

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

            lvList.setAdapter(adapter);


        }catch (Exception e){
            Toast.makeText(this, "예외: " + e.toString(), Toast.LENGTH_LONG);
        }finally {
            if(in!=null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
