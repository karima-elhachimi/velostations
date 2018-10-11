package be.ap.karima.velostation;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.lang.Object;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonHandler {

    public Context context;
    public JSONArray jArray;


    public JsonHandler(Context ctx) {
        this.context = ctx;
        parseJsonToArray();
    }

    public String readJsonFromAssets() {
        String json = null;

        try {
            InputStream inputStream = context.getAssets().open("velostation.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            Log.i("READ JSON SUCCES", json );
        } catch (IOException ioe) {

            Log.e("READ JSON FAIL", ioe.getMessage());
        }

        return json;
    }

    public  void  parseJsonToArray() {
        String json = readJsonFromAssets();
        jArray = null;

        try {
            jArray = new JSONArray(json);
            Log.i("JSON", jArray.toString());
            Log.i("JSON item", jArray.get(0).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
