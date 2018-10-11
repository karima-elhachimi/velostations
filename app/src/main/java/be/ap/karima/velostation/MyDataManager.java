package be.ap.karima.velostation;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyDataManager {


    public static JsonHandler jsonHdlr;
    private static MyDataManager instance = null;
    private static ArrayList<Station> stationList;


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

        final String TAG = "JSON ITEM ";
        for(int i = 0; i < jsonHdlr.jArray.length(); i++) {

            try {
                JSONObject jsonItem = (JSONObject) jsonHdlr.jArray.get(i);
                double lat = (double) jsonItem.get("point_lat");
                double lng = (double) jsonItem.get("point_lng");
                String name = jsonItem.get("naam").toString();
                Station velo = new Station(lat, lng, name);
                Log.i(TAG + i, velo.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
