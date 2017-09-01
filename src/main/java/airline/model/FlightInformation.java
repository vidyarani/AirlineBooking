package airline.model;

public class FlightInformation {
    private String source;
    private String destination;
    private int numberOfAvailableSeats;

    public FlightInformation(String source, String destination, int numberOfAvailableSeats) {
        this.source = source;
        this.destination = destination;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
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

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }
}
