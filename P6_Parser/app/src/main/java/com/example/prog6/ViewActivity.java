package com.example.prog6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ViewActivity extends AppCompatActivity {
    TextView lblXmlData, lblJsonData;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lblXmlData = (TextView) findViewById(R.id.lbl_xml_data);
        lblJsonData = (TextView) findViewById(R.id.lbl_json_data);
        mode = getIntent().getIntExtra("mode", 0);
        if (mode == 1)
            parseJson();
        else
            parseXmlDocument();
    }

    public String parseXmlDocument() {
        try {
            InputStream is = getAssets().open("input.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();
            NodeList nList = doc.getElementsByTagName("employee");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element2 = (Element) node;
                lblXmlData.setText("City Name : " + getValue("city_name", element2) + "\n");
                lblXmlData.append("Latitude : " + getValue("Latitude", element2) + "\n");
                lblXmlData.append("Longitude : " + getValue("Longitude", element2) + "\n");
                lblXmlData.append("Temperature : " + getValue("Temperature", element2) + "\n");
                lblXmlData.append("Humidity : " + getValue("Humidity", element2) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public void parseJson() {
        try {
            InputStream inputStream = getAssets().open("input.json");
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String readData = new String(data);
            JSONObject jsonObject = new JSONObject(readData);
            JSONObject jsonObject1 = jsonObject.getJSONObject("employee");
            lblJsonData.setText("City Name:" + jsonObject1.getString("city_name") + "\n");
            lblJsonData.append("Latitude:" + jsonObject1.getString("Latitude") + "\n");
            lblJsonData.append("Longitude" + jsonObject1.getString("Longitude") + "\n");
            lblJsonData.append("Temperature:" + jsonObject1.getInt("Temperature") + "\n");
            lblJsonData.append("Humidity" + jsonObject1.getString("Humidity") + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
