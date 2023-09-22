public class Aeroport {
    private final String IATA;
    private final String name;
    private final String country;
    private final double latitude;
    private final double longitude;


    public Aeroport ( String IATA, String name, String country, double latitude, double longitude ) {
        this.IATA = IATA;
        this.name = name;
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
                ", Name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}' + "\n";
    }
}
