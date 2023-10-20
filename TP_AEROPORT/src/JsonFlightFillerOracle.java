import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JsonFlightFillerOracle {

    ArrayList<Flight> list = new ArrayList<>();

    public JsonFlightFillerOracle(String jsonString,World w) {
        try {
            InputStream is = new ByteArrayInputStream ( jsonString.getBytes ( StandardCharsets.UTF_8 ) );
            JsonReader rdr = Json.createReader ( is );
            JsonObject obj = rdr.readObject ( );
            JsonArray results = obj.getJsonArray ( "data" );
            //System.out.println( results);
            for (JsonObject result : results.getValuesAs ( JsonObject.class )) {
                try {
                    //get flight
                    /*String flight_date = result.getString("flight_date");
                    String flight_status = result.getString("flight_status");*/

                    //get departure
                    JsonObject departure = result.getJsonObject ( "departure" );
                    /*String departureAirport = departure.getString ( "airport" );
                    String departureTimezone = departure.getString ( "timezone" );
                    String departureIATA = departure.getString ( "iata");
                    String departureICAO = departure.getString( "icao" );
                    String departureTerminal = departure.getString ( "terminal" );
                    String departureGate = departure.getString ( "gate" );
                    String departureDelay = departure.getString ( "delay" );*/
                    String departureScheduled = departure.getString( "scheduled" );
                    /*String departureEstimated = departure.getString ( "estimated" );
                    String departureActual = departure.getString ( "actual" );
                    String departureEstimatedRunway = departure.getString ( "estimated_runway");
                    String departureActualRunway = departure.getString ( "actual_runway");*/

                    //get arrival
                    JsonObject arrival = result.getJsonObject( "arrival" );
                    /*String arrivalAirport = arrival.getString ( "airport" );
                    String arrivalTimezone = arrival.getString ( "timezone" );
                    String arrivalIATA = arrival.getString ( "iata");
                    String arrivalICAO  = arrival.getString ( "icao" );
                    String arrivalTerminal = arrival.getString ( "terminal" );
                    String arrivalGate = arrival.getString ( "gate" );
                    String arrivalBaggage = arrival.getString("baggage" );
                    String arrivalDelay = arrival.getString ( "delay" );*/
                    String arrivalScheduled = arrival.getString ( "scheduled");
                    /*String arrivalEstimated = arrival.getString ( "estimated" );
                    String arrivalActual = arrival.getString ( "actual" );
                    String arrivalEstimatedRunway = arrival.getString ( "estimated_runway" );
                    String arrivalActualRunway = arrival.getString ( "actual_runway");*/

                    //get airline
                    JsonObject airline = result.getJsonObject ( "airline" );
                    String airlineName = airline.getString ( "name" );
                    /*String airlineIATA = airline.getString ( "iata");*/
                    String airlineICAO = airline.getString ( "icao" );

                    //get flight
                    JsonObject flight = result.getJsonObject ( "flight" );
                    String flightNumber = flight.getString ( "number" );
                    /*String flightIATA = flight.getString ( "iata" );
                    String flightICAO = flight.getString ( "icao" );
                    String flightCodeshared = flight.getString ( "codeshared" );*/

                    //get the rest
                    /*String aircraft = result.getString ( "aircraft" );
                    String live = result.getString ( "live" );*/

                    list.add(new Flight(airlineICAO, airlineName, arrivalScheduled, departureScheduled, flightNumber));

                } catch (Exception e) {
                    e.printStackTrace ( );
                }
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }
}
