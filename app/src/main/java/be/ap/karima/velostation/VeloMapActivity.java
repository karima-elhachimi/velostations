package be.ap.karima.velostation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
//om de map mogelijk te maken

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class VeloMapActivity extends AppCompatActivity {

    private MapView map = null;
    private MyDataManager dm = MyDataManager.getInstance(this);
    public Intent intent = getIntent();
    public Station geselecteerdeVelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velo_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.back_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(VeloMapActivity.this , Velolist.class);
               startActivity(intent);
            }
        });

        map = (MapView) findViewById(R.id.mapview);

        int position = Integer.parseInt(intent.getStringExtra("Position"));
        geselecteerdeVelo = dm.getStationList().get(position);
        Log.i("VELO ", geselecteerdeVelo.toString());
        setMapOptions(geselecteerdeVelo);

    }

    @Override
    protected void onResume() {
        super.onResume();

        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        map.onPause();  //needed for compass, my location overlays, v6.0.0 and up

    }

    public void setMapOptions(Station velo){

        map.setTileSource(TileSourceFactory.MAPNIK);
        IMapController mapController = map.getController();
        mapController.setZoom(9);
        GeoPoint startPoint = new GeoPoint(velo.getLatitude(), velo.getLongitude());
        mapController.setCenter(startPoint);
    }





}
