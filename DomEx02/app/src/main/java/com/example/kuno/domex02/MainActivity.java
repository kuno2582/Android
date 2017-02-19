package com.example.kuno.domex02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
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

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<order>" +
                    "<item Maker=\"Samsung\" Price=\"239\">Notebook Always</item>" +
                    "<item Maker=\"LG\" Price=\"238\">Allday gram</item>" +
                    "<item Maker=\"HP\" Price=\"279\">OMEN</item>" +
                    "<item Maker=\"Apple\" Price=\"318\">MacbookPro</item>" +
                    "<item Maker=\"Microsoft\" Price=\"317\">Surface</item>" +
                "</order>";

        try{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream istream = new ByteArrayInputStream(xml.getBytes("utf-8"));

            Document doc = builder.parse(istream);
            Element order = doc.getDocumentElement();

            NodeList items = order.getElementsByTagName("item");
            String result = "";

            for(int i=0; i < items.getLength(); i++){
                Node item = items.item(i);
                Node text = item.getFirstChild();
                String itemName = text.getNodeValue();
                result += itemName + "\n";

                NamedNodeMap attrs = item.getAttributes();

                for(int j=0; j<attrs.getLength(); j++){
                    Node attr = attrs.item(j);
                    result += (attr.getNodeName() + " : " + attr.getNodeValue() +"\n");  //속성이름 + 속성값
                }
                result += "\n";
            }

            tvResult.setText("<주문 목록>\n" + result);

        }catch(Exception e){
            Toast.makeText(v.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}
