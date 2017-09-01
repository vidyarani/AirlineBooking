package airline.services;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    FlightRepository flightRepository;

    public List<Flight> search(SearchCriteria searchCriteria) {
        flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getFlights();
        return flights.stream()
                .filter(x -> x.getFlightInformation().getSource().equals(searchCriteria.getSource()))
                .filter(x -> x.getFlightInformation().getDestination().equals(searchCriteria.getDestination()))
                .filter(x -> x.getFlightInformation().getNumberOfAvailableSeats() >= searchCriteria.getNumberOfPassengers())
                .collect(Collectors.toList());
    }
}
