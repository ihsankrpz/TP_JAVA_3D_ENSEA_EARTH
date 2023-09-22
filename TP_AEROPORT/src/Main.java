public class Main {
    public static void main ( String[] args ) {

        // TO TEST AEROPORT
        //Aeroport aeroport = new Aeroport ( "CDG", "Charle de Gaule", "France", 49.009691, 2.547925 );
        //System.out.println ( aeroport );

        // TO TEST WORLD
        //World w = new World ( "airport-codes_no_comma.csv" );
        //System.out.println ( "Found " + w.getList ( ).size ( ) + " airports." );
        //Aeroport paris = w.findNearestAirport ( 2.316, 48.866 );
        //Aeroport cdg = w.findByCode ( "CDG" );
        //double distance = w.distance ( 2.316, 48.866, paris.getLongitude ( ), paris.getLatitude ( ) );
        //System.out.println ( paris );
        //System.out.println ( distance );
        //double distanceCDG = w.distance ( 2.316, 48.866, cdg.getLongitude ( ), cdg.getLatitude ( ) );
        //System.out.println ( cdg );
        //System.out.println ( distanceCDG );

        //System.out.println ( w.findNearestAirport ( 51.24, -7.01 ) ); //Test seychelles

        Interface app = new Interface ();
        app.main(null);


    }
}