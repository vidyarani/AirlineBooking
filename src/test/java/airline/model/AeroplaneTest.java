package airline.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AeroplaneTest {
    Aeroplane aeroplane;

    @Before
    public void setUp() {
        List<TravelClass> travelClassList = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        aeroplane = new Aeroplane("Boeing", travelClassList);
    }

    @Test
    public void shouldReturnZeroWithTravelClassNotProvided(){
        assertEquals(0,aeroplane.getSeatsByClassType(null));
    }

    @Test
    public void shouldReturnAvailableSeatsForFirstClass() {
        int availableSeats = aeroplane.getSeatsByClassType(TravelClassType.FIRST);
        assertEquals(8, availableSeats);
    }

    @Test
    public void shouldReturnAvailableSeatsForBusinessClass() {
        int availableSeats = aeroplane.getSeatsByClassType(TravelClassType.BUSINESS);
        assertEquals(35, availableSeats);
    }

    @Test
    public void shouldReturnAvailableSeatsForEconomyClass() {
        int availableSeats = aeroplane.getSeatsByClassType(TravelClassType.ECONOMY);
        assertEquals(195, availableSeats);
    }
}