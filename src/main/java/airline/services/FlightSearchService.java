package airline.services;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                .filter(searchByDepartureDate(searchCriteria))
                .collect(Collectors.toList());
    }

    private Predicate<Flight> searchByDepartureDate(SearchCriteria searchCriteria) {
        return x -> null == (searchCriteria.getDepartureDate()) ||
                x.getDepartureDate().equals(LocalDate.parse(searchCriteria.getDepartureDate()));
    }

    private Predicate<Flight> searchByPassengers(SearchCriteria searchCriteria) {
        return x -> x.getFlightInformation().getAvailableSeats() >= searchCriteria.getNumberOfPassengers();
    }

    private Predicate<Flight> searchByDestination(SearchCriteria searchCriteria) {
        return x -> null == searchCriteria.getDestination() || searchCriteria.getDestination() == ""
                || x.getDestination().equals(searchCriteria.getDestination());
    }

    private Predicate<Flight> searchBySource(SearchCriteria searchCriteria) {
        return x -> null == searchCriteria.getSource() || searchCriteria.getSource() == ""
                || x.getSource().equals(searchCriteria.getSource());
    }
}