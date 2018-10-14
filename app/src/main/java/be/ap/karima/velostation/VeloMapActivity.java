package be.ap.karima.velostation;

import android.content.Intent;
import android.graphics.Canvas;
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
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.mylocation.SimpleLocationOverlay;

import java.util.ArrayList;
import java.util.List;

public class VeloMapActivity extends AppCompatActivity {

    private MapView map = null;
    private MyDataManager dm = MyDataManager.getInstance(this);
    public Intent my_intent;
    public Station geselecteerdeVelo;
    public List<OverlayItem> mItems;

    public SimpleLocationOverlay myOverlay;

//todo: voeg marker of icon toe aan map - done

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
               Intent new_intent = new Intent(VeloMapActivity.this , Velolist.class);
               startActivity(new_intent);
            }
        });

        my_intent = getIntent();
        map = (MapView) findViewById(R.id.mapview);
        mItems = new ArrayList<OverlayItem>();
        myOverlay = new SimpleLocationOverlay(this);

        //todo: fout hier uitzoeken - done
        //todo: permissions vragen
        int position = Integer.parseInt(my_intent.getStringExtra("pos"));
        geselecteerdeVelo = dm.getVeloStation(position);
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




        double lati = velo.getLatitude();
        double longi = velo.getLongitude();
        map.setTileSource(TileSourceFactory.MAPNIK);
        IMapController mapController = map.getController();
        mapController.setZoom(20);
        GeoPoint startPoint = new GeoPoint(velo.getLatitude(), velo.getLongitude());
        //OverlayItem olItem = new OverlayItem("Here", "SampleDescription", startPoint);
        myOverlay.setLocation(startPoint);
       // map.getOverlays().add(myOverlay);

        mapController.setCenter(startPoint);
    }





}
