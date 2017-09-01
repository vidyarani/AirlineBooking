package airline.services;

import airline.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        flights.add(new Flight("F1", "HYD", "BLR"));
        flights.add(new Flight("F2", "HYD", "PUN"));
        flights.add(new Flight("F3", "BLR", "PUN"));
        flights.add(new Flight("F4", "HYD", "BLR"));
        return flights;
    }
}
