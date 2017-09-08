package airline.model;

public class TravelClass {
    private TravelClassType travelClassType;
    private int availableSeats;

    public TravelClass(TravelClassType travelClassType, int numberOfAvailableSeats) {
        this.travelClassType = travelClassType;
        this.availableSeats = numberOfAvailableSeats;
    }

    int getAvailableSeats() {
        return availableSeats;
    }

    TravelClassType getTravelClassType() {
        return travelClassType;
    }
}