package airline.services;

import airline.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRepository {

    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        Flight flight1 = new Flight("F1", "HYD", "BLR");
        Flight flight2 = new Flight("F2", "HYD", "PUN");
        Flight flight3 = new Flight("F3", "BLR", "PUN");
        Flight flight4 = new Flight("F4", "HYD", "BLR");


        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;
    }
}
