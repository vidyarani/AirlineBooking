package airline.repositories;

import airline.model.Flight;
import airline.model.FlightInformation;

import java.util.ArrayList;

public class FlightRepository {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        flights.add(new Flight("F1", new FlightInformation("HYD", "BLR", 10)));
        flights.add(new Flight("F2", new FlightInformation("HYD", "PUN", 5)));
        flights.add(new Flight("F3", new FlightInformation("BLR", "PUN", 1)));
        flights.add(new Flight("F4", new FlightInformation("HYD", "BLR", 0)));
        return flights;
    }
}
