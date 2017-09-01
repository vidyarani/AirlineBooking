package airline.services;

import airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    @Autowired
    FlightRepository flightRepository;

    public List<Flight> search(String source, String destination) {
        flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getFlights();
        return flights.stream()
                .filter(x -> x.getSource().equals(source))
                .filter(x -> x.getDestination().equals(destination))
                .collect(Collectors.toList());
    }
}
