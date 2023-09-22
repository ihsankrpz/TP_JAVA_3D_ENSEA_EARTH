public class Aeroport {
    private final String IATA;
    private final String name;
    private final String country;
    private final double longitude;
    private final double latitude;

    public Aeroport ( String IATA, String name, String country, double longitude, double latitude ) {
        this.IATA = IATA;
        this.name = name;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getIATA () {
        return IATA;
    }

    public double getLongitude () {
        return longitude;
    }

    public double getLatitude () {
        return latitude;
    }

    @Override
    public String toString () {
        return "Interface{" +
                "IATA='" + IATA + '\'' +
                ", Name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}' + "\n";
    }
}
