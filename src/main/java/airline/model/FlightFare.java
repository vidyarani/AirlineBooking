package airline.model;

public class FlightFare {
    private String flightNumber;
    private TravelClassType travelClassType;
    private double baseFare;

    public FlightFare(String flightNumber, TravelClassType travelClassType, double baseFare) {
        this.flightNumber = flightNumber;
        this.travelClassType = travelClassType;
        this.baseFare = baseFare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public TravelClassType getTravelClassType() {
        return travelClassType;
    }

    public double getBaseFare() {
        return baseFare;
    }
}
