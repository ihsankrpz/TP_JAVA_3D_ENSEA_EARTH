import java.time.LocalDateTime;

public class Flight{
    private String airLineCode;
    private String airLineName;
    private String arrivalTime;
    private String departureTime;
    private String number;

    public Flight ( String airLineCode,
                    String airLineName,
                    String arrivalTime,
                    String departureTime,
                    String number ) {
        this.airLineCode = airLineCode;
        this.airLineName = airLineName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.number = number;
    }

    @Override
    public String toString () {
        return "Flight{" +
                " airLineCode='" + airLineCode + '\'' +
                ", airLineName='" + airLineName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", number=" + number +
                "}\n";
    }
}
