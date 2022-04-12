import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FlightsInfoManager extends FlightsFileManager {

    private String origin;
    private String destination;
    private String airline;
    private ZonedDateTime departure;
    private ZonedDateTime arrival;
    private Double price;
    private long flightTime;

    public FlightsInfoManager(String origin, String destination, String airline, String departure,
                              String arrival, String price) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss '('zzz')'");

        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departure = ZonedDateTime.parse(departure, dateTimeFormatter);
        this.arrival = ZonedDateTime.parse(arrival, dateTimeFormatter);
        this.price = new Double (price);
        this. flightTime = this.departure.until(this.arrival, ChronoUnit.HOURS);
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(ZonedDateTime departure) {
        this.departure = departure;
    }

    public ZonedDateTime getArrival() {
        return arrival;
    }

    public void setArrival(ZonedDateTime arrival) {
        this.arrival = arrival;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(long flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public String toString() {
        return "FlightsInfoManager{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", price=" + price +
                ", flightTime =" + flightTime +
                '}';
    }

    public static String getFlightTimeLines(FlightsInfoManager formatedData){
        return  formatedData.getOrigin() + ";" +
                formatedData.getDestination() + ";" +
                formatedData.getAirline() + ";" +
                formatedData.getDeparture()+ ";" +
                formatedData.getArrival()+ ";" +
                formatedData.getPrice()+ ";" +
                formatedData.getFlightTime();
    }
}
