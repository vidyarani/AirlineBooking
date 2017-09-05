package airline.model;

import java.time.LocalDate;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private FlightInformation flightInformation;

    public Flight() {
    }

    public Flight(String flightNumber, String source, String destination, FlightInformation flightInformation, LocalDate departureDate) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.flightInformation = flightInformation;
        this.departureDate = departureDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }
}