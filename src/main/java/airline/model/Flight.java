package airline.model;

import java.time.LocalDate;
import java.util.Map;

public class Flight {
    private final String flightNumber;
    private final String source;
    private final String destination;
    private final LocalDate departureDate;
    private final Aeroplane aeroplane;
    private final Map<TravelClassType, Integer> availableSeats;

    public Flight(String flightNumber, String source, String destination, LocalDate departureDate, Aeroplane aeroplane,
                  Map<TravelClassType, Integer> availableSeats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.aeroplane = aeroplane;
        this.availableSeats = availableSeats;
    }

    public String getModelName() {
        return aeroplane.getAirPlaneName();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public boolean startsFrom(String source) {
        return this.source.equals(source);
    }

    boolean reachesTo(String destination) {
        return this.destination.equals(destination);
    }

    boolean travelsOnDate(LocalDate departureDate) {
        return this.departureDate.equals(departureDate);
    }

    public boolean canAccommodate(int numberOfPassengers, TravelClassType travelClassType) {
        return getAvailableSeats(travelClassType) >= numberOfPassengers;
    }

    private int getAvailableSeats(TravelClassType travelClassType) {
        return availableSeats.get(travelClassType);
    }

    public int getPercentageOfAvailableSeats(TravelClassType travelClassType) {
        int availableSeats = getAvailableSeats(travelClassType);
        int totalSeats = aeroplane.getTotalSeatsByClassType(travelClassType);
        return (availableSeats * 100) / totalSeats;
    }
}
