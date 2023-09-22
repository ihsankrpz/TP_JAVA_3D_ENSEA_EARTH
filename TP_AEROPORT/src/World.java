import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class World {
    private ArrayList<Aeroport> list = new ArrayList<> ( );

    public World ( String fileName ) {
        try {
            BufferedReader buf = new BufferedReader ( new FileReader ( fileName ) );
            String s = buf.readLine ( );
            while (s != null) {
                s = s.replaceAll ( "\"", "" ); //Enleve les guillemets qui s´eparent les champs de donn´ees GPS.
                String fields[] = s.split ( "," ); // Une bonne id´ee : placer un point d'arr^et ici pour du debuggage.
                if (fields[1].equals ( "large_airport" )) {
                    // ajoute les élements dans la liste d'aéroport
                    list.add ( new Aeroport ( fields[9], fields[2], fields[5], Double.parseDouble ( fields[11] ), Double.parseDouble ( fields[12] ) ) );
                }
                s = buf.readLine ( );
            }
            //System.out.println ( list );
        } catch (Exception e) {
            System.out.println ( "Maybe the file isn't there ?" );
            System.out.println ( list.get ( list.size ( ) - 1 ) );
            e.printStackTrace ( );
        }
    }

    public ArrayList<Aeroport> getList () {
        return list;
    }

    public Aeroport findNearestAirport ( double latitude, double longitude ) {
        double dist;
        double buff;
        Aeroport aeroportFounded = new Aeroport ( null, null, null, 0, 0 );

        //premier calcul pour l'index 0
        buff = distance ( latitude, longitude, list.get ( 0 ).getLatitude (), list.get ( 0 ).getLongitude () );
        for (int i = 1; i < list.size ( ); i++) {
            //calcul pour le reste des index
            dist = distance ( latitude, longitude, list.get ( i ).getLatitude (), list.get ( i ).getLongitude () );
            //si la distance est plus petite
            if((dist < buff) && (buff !=0) ){
                //alors prendre les élements d'aéroport
                aeroportFounded = list.get ( i );
                buff = dist;
            }
        }
        return aeroportFounded;
    }

    public Aeroport findByCode ( String IATA ) {
        Aeroport aeroportFounded = new Aeroport ( null, null, null, 0, 0 );

        for (int i = 0; i < list.size ( ); i++) {
            //recherche par code IATA
            if (list.get ( i ).getIATA ( ).equals ( IATA )) {
                aeroportFounded = list.get ( i );
            }
        }
        return aeroportFounded;
    }

    public double distance ( double latitude1, double longitude1, double latitude2, double longitude2 ) {
        //calcul donné par le sujet
        return (Math.pow ( latitude2 - latitude1, 2 ) + Math.pow ( (longitude2 - longitude1) * Math.cos ( (latitude2 - latitude1) / 2 ), 2 ));
    }
}
