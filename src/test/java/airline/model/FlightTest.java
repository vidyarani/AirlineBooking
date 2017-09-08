package airline.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightTest {
    private Flight flight;

    @Before
    public void setUp() throws Exception {
        List<TravelClass> travelClassList1 = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane = new Aeroplane("Boeing", travelClassList1);
        flight = new Flight("F1", "HYD", "BLR",
                LocalDate.of(2017, 9, 06), aeroplane);
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
        assertTrue(flight.reachesTo("BLR"));
    }

    @Test
    public void shouldReturnFalseIfFlightDoesNotReachPUN() {
        assertFalse(flight.reachesTo("PUN"));
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
    public void shouldReturnAvailableSeatsForFirstClass() throws Exception {
        assertEquals(8, flight.getAvailableSeatsForClassType(TravelClassType.FIRST));
    }

    @Test
    public void shouldReturnAvailableSeatsForBusinessClass() throws Exception {
        assertEquals(35, flight.getAvailableSeatsForClassType(TravelClassType.BUSINESS));
    }

    @Test
    public void shouldReturnAvailableSeatsForEconomyClass() throws Exception {
        assertEquals(195, flight.getAvailableSeatsForClassType(TravelClassType.ECONOMY));
    }
}