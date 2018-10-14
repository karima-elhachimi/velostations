package be.ap.karima.velostation;

import android.provider.BaseColumns;

public final class VeloDatabaseContract {

    public static final class VeloStationEntry implements BaseColumns {
        public static final String TABLE_VELO = "Velos3";
        public static final String COLUMN_NAAM = "Naam";
        public static final String COLUMN_LAT = "Latitude";
        public static final String COLUMN_LONG = "Longitude";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE "+ TABLE_VELO + " ("+
                _ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_NAAM + ", "+
                COLUMN_LAT + ", "+
                COLUMN_LONG+")";
    }
}
