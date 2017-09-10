package airline.model;

public class TravelClass {
    private TravelClassType travelClassType;
    private int totalSeats;

    public TravelClass(TravelClassType travelClassType, int totalSeats) {
        this.travelClassType = travelClassType;
        this.totalSeats = totalSeats;
    }

    int getTotalSeats() {
        return totalSeats;
    }

    TravelClassType getTravelClassType() {
        return travelClassType;
    }
}
