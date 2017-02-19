package com.example.kuno.jsonex03;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.tvText);

        AssetManager assetManager = getResources().getAssets();

        try{
            AssetManager.AssetInputStream assetInputStream =
                    (AssetManager.AssetInputStream)assetManager.open("sample.json");

            //바이트 스트림을 문자열로 바꾸기 위해 버퍼객체 생성
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetInputStream, "UTF-8"));

            //읽은 버퍼를 스트링버퍼에 누적
            StringBuffer stringBuffer = new StringBuffer();
            String result = null;

            while((result = bufferedReader.readLine())!=null){
                stringBuffer.append(result);
            }

            String msg = stringBuffer.toString();

            JSONObject jsonObject = new JSONObject(msg);

            String menu = jsonObject.getString("menu");
            text.setText(menu + "\n");

            JSONArray jsonArray = new JSONArray(jsonObject.getString("member")); //배열

            for(int i=0; i<jsonArray.length(); i++){
                text.append("------------------------------\n");
                text.append(jsonArray.getJSONObject(i).getString("id") + "\n");
                text.append(jsonArray.getJSONObject(i).getString("name") + "\n");
                text.append(jsonArray.getJSONObject(i).getString("address") + "\n");
                text.append(jsonArray.getJSONObject(i).getString("job") + "\n");
            }


        }catch (Exception e){
            Log.e("JSON Demo", e.toString());
        }
    }
}
