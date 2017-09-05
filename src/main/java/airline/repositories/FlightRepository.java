package airline.repositories;

import airline.model.Flight;
import airline.model.FlightInformation;

import java.time.LocalDate;
import java.util.ArrayList;

public class FlightRepository {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        flights.add(new Flight("F1", "HYD", "BLR", new FlightInformation(10), LocalDate.now()));
        flights.add(new Flight("F2", "HYD", "PUN", new FlightInformation(5), LocalDate.of(2017, 11,7)));
        flights.add(new Flight("F3", "BLR", "PUN", new FlightInformation(1), LocalDate.of(2017, 12,6)));
        flights.add(new Flight("F4", "HYD", "BLR", new FlightInformation(1), LocalDate.now().plusDays(2)));
        return flights;
    }
}
