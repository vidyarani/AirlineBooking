package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.SearchResult;
import airline.model.TravelClassType;
import airline.repository.FlightFareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightFareService {

    FlightFareRepository flightFareRepository;

    @Autowired
    FlightFareService(FlightFareRepository flightFareRepository) {
        this.flightFareRepository = flightFareRepository;
    }

    public List<SearchResult> getFlightsWithTotalFare(List<Flight> availableFlights, SearchCriteria searchCriteria) {
        List<SearchResult> searchResults = new ArrayList<SearchResult>();
        for (Flight flight : availableFlights) {
            SearchResult searchResult = createSearchResult(searchCriteria, flight);
            searchResults.add(searchResult);
        }
        return searchResults;
    }

    private SearchResult createSearchResult(SearchCriteria searchCriteria, Flight flight) {
        return new SearchResult(flight.getFlightNumber(),flight.getModelName(), flight.getSource(), flight.getDestination(),
                calculateTotalFare(searchCriteria, flight));
    }

    double calculateTotalFare(SearchCriteria searchCriteria, Flight flight) {
        return searchCriteria.getNumberOfPassengers() *
                getBaseFare(flight.getFlightNumber(), searchCriteria.getTravelClassType());
    }

    private double getBaseFare(String flightNumber, TravelClassType travelClassType) {
        return flightFareRepository.getBaseFare(flightNumber, travelClassType);
    }
}
