package airline.services;

import airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchService {
    @Autowired
    FlightRepository flightRepository;

    public List<Flight> search(String source, String destination) {
        flightRepository = new FlightRepository();
        List<Flight> availableFlights = new ArrayList<Flight>();

        for (Flight flight : flightRepository.getFlights()) {
            if (source.equals(flight.getSource()) && (destination.equals(flight.getDestination())))
                availableFlights.add(flight);
        }
        return availableFlights;
    }
}
