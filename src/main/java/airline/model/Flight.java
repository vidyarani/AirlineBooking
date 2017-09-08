package airline.model;

import java.time.LocalDate;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private Aeroplane aeroplane;

    public Flight() {
    }

    public Flight(String flightNumber, String source, String destination,
                  LocalDate departureDate, Aeroplane aeroplane) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.aeroplane = aeroplane;
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

    int getAvailableSeatsForClassType(TravelClassType travelClassType) {
        return aeroplane.getSeatsByClassType(travelClassType);
    }

    public String getAirPlaneName() {
        return aeroplane.getAirPlaneName();
    }

    public boolean canAccommodate(int numberOfPassengers, TravelClassType travelClassType) {
        return getAvailableSeatsForClassType(travelClassType) >= numberOfPassengers;
    }
}