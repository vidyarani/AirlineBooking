package airline.service;

import airline.model.Aeroplane;
import airline.model.Flight;
import airline.model.TravelClass;
import airline.model.TravelClassType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FareCalculatorByAvailableSeatsTest {
    private FareCalculatorByAvailableSeats fareCalculatorByAvailableSeats;
    private Map<TravelClassType, Integer> availableSeats = new HashMap<>();

    @Before
    public void setUp() {
        List<TravelClass> travelClassList = Arrays.asList(
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane = new Aeroplane("Boeing  777-200LR", travelClassList);
        Flight mockFlight = new Flight("F1", "HYD", "BLR", LocalDate.of(2017, 9, 18), aeroplane, availableSeats);
        fareCalculatorByAvailableSeats = new FareCalculatorByAvailableSeats(mockFlight, 1000);
    }

    @Test
    public void returnBaseFareIfAvailableSeatsIsLessThan40Percent() {
        availableSeats.put(TravelClassType.ECONOMY, 10);
        assertEquals(1000, fareCalculatorByAvailableSeats.calculate(), 0);
    }

    @Test
    public void apply30PercentOnBaseFareIfAvailableSeatsIslessThan90percent() {
        availableSeats.put(TravelClassType.ECONOMY, 80);
        assertEquals(1300, fareCalculatorByAvailableSeats.calculate(), 0);
    }

    @Test
    public void apply60PercentOnBaseFareIfAvailableSeatsIsGreaterThan90percent() {
        availableSeats.put(TravelClassType.ECONOMY, 190);
        assertEquals(1600, fareCalculatorByAvailableSeats.calculate(), 0);
    }
}