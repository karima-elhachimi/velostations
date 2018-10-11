package be.ap.karima.velostation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class Velolist extends AppCompatActivity {
    public RecyclerView veloListRV;
    public LinearLayoutManager veloListLM;
    public CardView veloCV;
    public TextView naamTV;
    public MyDataManager dm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velolist);

        dm = MyDataManager.getInstance(this);
        veloListRV = (RecyclerView) findViewById(R.id.velo_list_recyclerview);
        veloCV = (CardView) findViewById(R.id.velo_cardview);
        naamTV = (TextView)findViewById(R.id.naam_textview);
        veloListLM = new LinearLayoutManager(this);

        veloListRV.setLayoutManager(veloListLM);


    }





}
