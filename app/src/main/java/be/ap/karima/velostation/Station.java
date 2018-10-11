package be.ap.karima.velostation;

public class Station {

    private double Latitude;
    private double Longitude;
    private String Name;

    public Station(double lat, double longi, String name){
        this.Latitude = lat;
        this.Latitude = longi;
        this.Name = name;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
