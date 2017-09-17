package airline.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FlightTest {
    private Flight flight;

    @Before
    public void setUp() throws Exception {
        List<TravelClass> travelClassList1 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane = new Aeroplane("Boeing  777-200LR", travelClassList1);

        Map<TravelClassType, Integer> availableSeats = new HashMap<>();
        availableSeats.put(TravelClassType.FIRST, 4);
        availableSeats.put(TravelClassType.BUSINESS, 20);
        availableSeats.put(TravelClassType.ECONOMY, 100);
        flight = new Flight("F1", "HYD", "BLR", LocalDate.of(2017, 9, 06), aeroplane, availableSeats);
    }

    @Test
    public void shouldReturnTrueIfFlightStartsFromHYD() {
        assertTrue(flight.startsFrom("HYD"));
    }

    @Test
    public void shouldReturnFalseIfFlightDoesNotStartFromBLR() {
        assertFalse(flight.startsFrom("BLR"));
    }

    @Test
    public void shouldReturnTrueIfFlightReachesBLR() {
        assertTrue(flight.departsTo("BLR"));
    }

    @Test
    public void shouldReturnFalseIfFlightDoesNotReachPUN() {
        assertFalse(flight.departsTo("PUN"));
    }

    @Test
    public void shouldReturnTrueIfFlightTravelsOnDate() {
        assertTrue(flight.travelsOnDate(LocalDate.of(2017, 9, 06)));
    }

    @Test
    public void shouldReturnFalseIfFlightDoesNotTravelOnDate() {
        assertFalse(flight.travelsOnDate(LocalDate.of(2017, 9, 20)));
    }

    @Test
    public void shouldCheckIfFlightCanAccommodateForFirstClass() {
        assertTrue(flight.canAccommodate(4, TravelClassType.FIRST));
    }

    @Test
    public void shouldCheckAvailableSeatsForBusinessClass() {
        assertTrue(flight.canAccommodate(15, TravelClassType.BUSINESS));
    }

    @Test
    public void shouldCheckAvailableSeatsForEconomyClass() {
        assertTrue(flight.canAccommodate(50, TravelClassType.ECONOMY));
    }

    @Test
    public void shouldReturnPercentageOfAvailableSeatsInFirstClass() {
        assertEquals(0.50, flight.getPercentageOfAvailableSeats(TravelClassType.FIRST),0.01);
    }

    @Test
    public void shouldReturnPercentageOfAvailableSeatsInBusinessClass() {
        assertEquals(0.57, flight.getPercentageOfAvailableSeats(TravelClassType.BUSINESS),0.01);
    }

    @Test
    public void shouldReturnPercentageOfAvailableSeatsInEconomyClass() {
        assertEquals(0.51, flight.getPercentageOfAvailableSeats(TravelClassType.ECONOMY),0.01);
    }
}
