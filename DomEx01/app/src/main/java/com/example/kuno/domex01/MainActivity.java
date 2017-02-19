package com.example.kuno.domex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
                + "<order><item>Notebook</item></order>";

        try{

            //돔파서를 생성할 수 있는 객체
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //돔파서 생성
            DocumentBuilder builder = factory.newDocumentBuilder();
            //xml을 바이트형태의 인풋스트림으로 읽어오기
            InputStream istream = new ByteArrayInputStream(xml.getBytes("utf-8"));
            //돔트리 생성하기
            Document doc = builder.parse(istream);

            Element order = doc.getDocumentElement();
            //아이템 태그만 가진 것들 가져와서 배열만들기
            NodeList items = order.getElementsByTagName("item");

            //0번째 아이템 가져와서 담기
            Node item = items.item(0);
            Node text = item.getFirstChild();
            String itemName = text.getNodeValue();

            tvResult.setText("주문항목: " + itemName);

        }catch(Exception e){
            Toast.makeText(v.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
