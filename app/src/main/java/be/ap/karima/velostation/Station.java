package be.ap.karima.velostation;

public class Station {

    public double Latitude;
    public double Longitude;
    private String Name;

    public Station(double mlatitude, double mlongitude, String name){
        this.Latitude = mlatitude;
        this.Latitude = mlongitude;
        this.Name = name;
    }
    public Station(){

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
