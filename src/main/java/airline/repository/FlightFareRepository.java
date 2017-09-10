package airline.repository;

import airline.model.TravelClassType;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightFareRepository {
    double getBaseFare(String flightNumber, TravelClassType travelClassType);
}
