public class Aeroport {
    private String IATA;
    private String Name;
    private String country;
    private double latitude;
    private double longitude;

    public Aeroport ( String IATA, String name, String country, double latitude, double longitude ) {
        this.IATA = IATA;
        Name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIATA () {
        return IATA;
    }

    public double getLatitude () {
        return latitude;
    }

    public double getLongitude () {
        return longitude;
    }

    @Override
    public String toString () {
        return "Interface{" +
                "IATA='" + IATA + '\'' +
                ", Name='" + Name + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
