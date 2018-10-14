package be.ap.karima.velostation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
    public VeloRecyclerAdaper veloRA;
    public CardView veloCV;
    public TextView naamTV;
    public MyDataManager dm;
    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 22;
    public VeloDatabaseOpenHelper dbOpenHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velolist);

        dm = MyDataManager.getInstance(this);
        dbOpenHelper = new VeloDatabaseOpenHelper(this);


        veloListRV = (RecyclerView) findViewById(R.id.velo_list_recyclerview);
        veloCV = (CardView) findViewById(R.id.velo_cardview);
        naamTV = (TextView)findViewById(R.id.naam_textview);
        veloListLM = new LinearLayoutManager(this);
        veloListRV.setLayoutManager(veloListLM);
        veloRA = new VeloRecyclerAdaper(this, dm.getStationList());
        veloListRV.setAdapter(veloRA);
        saveVelosToDB();

    }


    @Override
    protected void onResume() {
        super.onResume();
        veloRA.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        dbOpenHelper.close();
        super.onDestroy();
    }

    private void saveVelosToDB(){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        for(Station velo : dm.getStationList()) {
            dbOpenHelper.insertIntoDatabase(db, velo);
        }
    }

}
