package be.ap.karima.velostation;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyDataManager {


    public static JsonHandler jsonHdlr;
    private static MyDataManager instance = null;
    private static List<Station> stationList;


    public static MyDataManager getInstance(Context context) {
        if(instance != null){
           return instance;
        } else {
            instance = new MyDataManager();
            jsonHdlr = new JsonHandler(context);
            createStationList();
            return instance;
        }
    }

    public static void createStationList() {

        stationList = new ArrayList<Station>();
        final String TAG = "JSON ITEM ";
        for(int i = 0; i < jsonHdlr.jArray.length(); i++) {

            try {
                JSONObject jsonItem = (JSONObject) jsonHdlr.jArray.getJSONObject(i);
                double longi = Double.parseDouble(jsonItem.get("point_lng").toString());
                double lati = Double.parseDouble(jsonItem.get("point_lat").toString());
                String name = jsonItem.get("naam").toString();
                Station velo = new Station(lati, longi, name);
                velo.Latitude = lati;
                velo.Longitude = longi;
                Log.i(TAG + i, velo.toString() + "lat: "+velo.getLatitude() +" long: "+velo.getLongitude());

                stationList.add(i, velo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public static Station getVeloStation(int pos) {
        return stationList.get(pos);
    }

    public static List<Station> getStationList(){
        return stationList;
    }


}
