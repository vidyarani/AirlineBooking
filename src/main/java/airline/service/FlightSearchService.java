package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    //    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> search(SearchCriteria searchCriteria) {
        flightRepository = new FlightRepository();
        List<Flight> allFlights = flightRepository.getFlights();
        return allFlights.stream()
                .filter(searchBySource(searchCriteria))
                .filter(searchByDestination(searchCriteria))
                .filter(searchByPassengersByClassOfTravel(searchCriteria))
                .filter(searchByDepartureDate(searchCriteria))
                .collect(Collectors.toList());
    }

    private Predicate<Flight> searchByDepartureDate(SearchCriteria searchCriteria) {
        return flight ->
                searchCriteria.getDepartureDate() == null ||
                        flight.getDepartureDate().equals(LocalDate.parse(searchCriteria.getDepartureDate()));
    }

    private Predicate<Flight> searchByPassengersByClassOfTravel(SearchCriteria searchCriteria) {
        return flight ->
                searchCriteria.getTravelClassType() == null ||
                        flight.canAccommodate(searchCriteria.getNumberOfPassengers(), searchCriteria.getTravelClassType());
    }

    private Predicate<Flight> searchByDestination(SearchCriteria searchCriteria) {
        return flight ->
                searchCriteria.getDestination() == null ||
                        searchCriteria.getDestination() == "" ||
                        flight.getDestination().equals(searchCriteria.getDestination());
    }

    private Predicate<Flight> searchBySource(SearchCriteria searchCriteria) {
        return flight ->
                searchCriteria.getSource() == null ||
                        searchCriteria.getSource() == "" ||
                        flight.startsFrom(searchCriteria.getSource());
    }
}