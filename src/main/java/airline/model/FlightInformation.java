package airline.model;

public class FlightInformation {
    private int availableSeats;

    public FlightInformation(int numberOfAvailableSeats) {
        this.availableSeats = numberOfAvailableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}