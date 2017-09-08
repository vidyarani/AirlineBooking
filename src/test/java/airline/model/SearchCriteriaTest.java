package airline.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchCriteriaTest {
    @Test
    public void shouldConvertDateToNullWhenDepartureDateNotProvided() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setDepartureDate("");
        assertNull(searchCriteria.getDepartureDate());
    }
}