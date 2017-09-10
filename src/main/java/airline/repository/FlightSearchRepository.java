package airline.repository;

import airline.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FlightSearchRepository {
    ArrayList<Flight> getFlights();
}
