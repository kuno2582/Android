package com.example.kuno.domex03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnParseXML;
    EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParseXML = (Button) findViewById(R.id.btnParseXML);
        etResult = (EditText) findViewById(R.id.etResult);

        btnParseXML.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        InputStream in = null;

        try{

            in = getResources().openRawResource(R.raw.product);

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document doc = builder.parse(in);

            NodeList orders = doc.getElementsByTagName("item");

            StringBuffer sb = new StringBuffer();
            sb.append("주문항목\n");

            for(int i=0; i<orders.getLength(); i++){

                String s = orders.item(i).getFirstChild().getNodeValue();
                sb.append((i+1) + ":" + s + "\n");

            }

            etResult.setText(sb.toString());

        }catch (Exception e){
            Toast.makeText(this, "예외: " +e.toString(), Toast.LENGTH_LONG).show();
        }finally{
            if(in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
