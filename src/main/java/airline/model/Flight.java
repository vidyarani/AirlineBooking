package airline.model;

public class Flight {
    private String flightNumber;
    private FlightInformation flightInformation;

    public Flight() {
    }

    public Flight(String flightNumber, FlightInformation flightInformation) {
        this.flightNumber = flightNumber;
        this.flightInformation = flightInformation;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }
}
