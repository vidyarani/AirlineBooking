package airline.model;

import java.awt.datatransfer.FlavorListener;

public class Flight {
    public String flightNumber;
    public String source;
    public String destination;

    public Flight() {
    
    }

    public Flight(String flightNumber, String source, String destination) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
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
}
