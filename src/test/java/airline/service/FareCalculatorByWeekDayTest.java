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

public class FareCalculatorByWeekDayTest {
    private FareCalculatorByWeekDay fareCalculatorByWeekDay;
    private Flight flight;
    private Aeroplane aeroplane;
    private Map<TravelClassType, Integer> availableSeats = new HashMap<>();

    @Before
    public void setUp() {
        List<TravelClass> travelClassList1 = new ArrayList<>();
         aeroplane = new Aeroplane("Boeing  777-200LR", travelClassList1);

        availableSeats.put(TravelClassType.FIRST, 4);
        availableSeats.put(TravelClassType.BUSINESS, 20);
        availableSeats.put(TravelClassType.ECONOMY, 100);
    }

    @Test
    public void apply40PercentOnBaseFareIfFlightTravelsOnMonday(){
        flight = new Flight("F1", "HYD", "BLR", LocalDate.of(2017, 9, 25), aeroplane, availableSeats);
        fareCalculatorByWeekDay = new FareCalculatorByWeekDay(flight,1000);
        assertEquals(1400,fareCalculatorByWeekDay.calculate(),0);
    }

    @Test
    public void returnBaseFareIfFlightTravelsOnSaturday(){
        flight = new Flight("F1", "HYD", "BLR", LocalDate.of(2017, 9, 30), aeroplane, availableSeats);
        fareCalculatorByWeekDay = new FareCalculatorByWeekDay(flight,1000);
        assertEquals(1000,fareCalculatorByWeekDay.calculate(),0);
    }
}