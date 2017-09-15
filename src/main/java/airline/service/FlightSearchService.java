package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.TravelClassType;
import airline.repository.FlightSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {
    @Autowired
    FlightSearchRepository flightSearchRepository;


    public List<Flight> search(SearchCriteria searchCriteria) {
        List<Flight> allFlights = flightSearchRepository.getFlights();

        if ((searchCriteria.getDepartureDate() != null) &&
                (TravelClassType.FIRST.equals(searchCriteria.getTravelClassType())) &&
                (!(LocalDate.now().compareTo(LocalDate.parse(searchCriteria.getDepartureDate())) <= 10)))
            return new ArrayList<>();
        return allFlights.stream()
                .filter(searchBySource(searchCriteria.getSource()))
                .filter(searchByDestination(searchCriteria.getDestination()))
                .filter(searchByPassengersByClassOfTravel(searchCriteria.getTravelClassType(), searchCriteria.getNumberOfPassengers()))
                .filter(searchByDepartureDate(searchCriteria.getDepartureDate()))
                .collect(Collectors.toList());
    }

    private Predicate<Flight> searchBySource(String source) {
        return flight ->
                source == null ||
                        Objects.equals(source, "") ||
                        flight.startsFrom(source);
    }

    private Predicate<Flight> searchByDestination(String destination) {
        return flight ->
                destination == null ||
                        Objects.equals(destination, "") ||
                        flight.departsTo(destination);
    }

    private Predicate<Flight> searchByDepartureDate(String departureDate) {
        return flight ->
                departureDate == null ||
                        flight.travelsOnDate(LocalDate.parse(departureDate));
    }

    private Predicate<Flight> searchByPassengersByClassOfTravel(TravelClassType travelClassType,
                                                                int numberOfPassengers) {
        return flight ->
                travelClassType == null ||
                        flight.canAccommodate(numberOfPassengers, travelClassType);
    }
}
