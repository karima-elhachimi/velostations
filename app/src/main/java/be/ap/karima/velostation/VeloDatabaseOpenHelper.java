package be.ap.karima.velostation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VeloDatabaseOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_VELOSTATIONS = "velostations3.db";
    public static final int DATABASE_VERSION = 1;

    public VeloDatabaseOpenHelper(Context context) {
        super(context, DATABASE_VELOSTATIONS, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VeloDatabaseContract.VeloStationEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertIntoDatabase( SQLiteDatabase db, Station velo) {
        ContentValues values = new ContentValues();
        values.put(VeloDatabaseContract.VeloStationEntry.COLUMN_NAAM, velo.getName());
        values.put(VeloDatabaseContract.VeloStationEntry.COLUMN_LAT, velo.getLatitude());
        values.put(VeloDatabaseContract.VeloStationEntry.COLUMN_LONG, velo.getLongitude());
        Log.i("values: ", values.toString());

        db.insert(VeloDatabaseContract.VeloStationEntry.TABLE_VELO, null, values);
        Log.i("Database", db.toString());
    }

}
