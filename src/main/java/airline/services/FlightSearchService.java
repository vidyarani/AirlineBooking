package airline.services;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    FlightRepository flightRepository;

    public List<Flight> search(SearchCriteria searchCriteria) {
        flightRepository = new FlightRepository();
        List<Flight> allFlights = flightRepository.getFlights();

        return allFlights.stream()
                .filter(searchBySource(searchCriteria))
                .filter(searchByDestination(searchCriteria))
                .filter(searchByPassengers(searchCriteria))
                .collect(Collectors.toList());
    }

    public Predicate<Flight> searchByPassengers(SearchCriteria searchCriteria) {
        return x -> x.getFlightInformation().getNumberOfAvailableSeats() >= searchCriteria.getNumberOfPassengers();
    }

    public Predicate<Flight> searchByDestination(SearchCriteria searchCriteria) {
        return x -> x.getDestination().equals(searchCriteria.getDestination());
    }

    public Predicate<Flight> searchBySource(SearchCriteria searchCriteria) {
        return x -> x.getSource().equals(searchCriteria.getSource());
    }
}