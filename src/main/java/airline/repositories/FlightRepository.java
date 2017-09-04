package airline.repositories;

import airline.model.Flight;
import airline.model.FlightInformation;

import java.util.ArrayList;

public class FlightRepository {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        flights.add(new Flight("F1", "HYD", "BLR", new FlightInformation(10)));
        flights.add(new Flight("F2", "HYD", "PUN", new FlightInformation(5)));
        flights.add(new Flight("F3", "BLR", "PUN", new FlightInformation(1)));
        flights.add(new Flight("F4", "HYD", "BLR", new FlightInformation(0)));
        return flights;
    }
}
