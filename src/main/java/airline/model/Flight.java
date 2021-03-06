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

    public boolean startsFrom(String source) {
        return this.source.equals(source);
    }

    public boolean departsTo(String destination) {
        return this.destination.equals(destination);
    }

    public boolean travelsOnDate(LocalDate departureDate) {
        return this.departureDate.equals(departureDate);
    }

    public boolean canAccommodate(int numberOfPassengers, TravelClassType travelClassType) {
        return getAvailableSeats(travelClassType) >= numberOfPassengers;
    }

    private double getAvailableSeats(TravelClassType travelClassType) {
        return availableSeats.get(travelClassType);
    }

    public double getPercentageOfAvailableSeats(TravelClassType travelClassType) {
        double availableSeats = getAvailableSeats(travelClassType);
        double totalSeats = aeroplane.getTotalSeatsByClassType(travelClassType);
        return (availableSeats) / totalSeats;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }
}
