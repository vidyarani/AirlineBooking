package airline.service;

import airline.model.Aeroplane;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.model.TravelClassType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class FareCalculatorByDepartureDateTest {

    @Test
    public void apply50percentOnBaseFareIfFlightIsDepartingIn5Days() {
        List<TravelClass> travelClassList = new ArrayList<>();
        Aeroplane aeroplane = new Aeroplane("Boeing  777-200LR", travelClassList);
        Map<TravelClassType, Integer> availableSeats = new HashMap<>();
        Flight mockFlight = new Flight("F1", "HYD", "BLR", LocalDate.of(2017, 9, 25), aeroplane, availableSeats);
        FareCalculatorByDepartureDate fareCalculatorByDepartureDate = new FareCalculatorByDepartureDate(mockFlight, 1000);
        assertEquals(1500, fareCalculatorByDepartureDate.calculate(), 0);
    }
}
