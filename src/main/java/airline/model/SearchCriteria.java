package airline.model;

public class SearchCriteria {
    private String source;
    private String destination;
    private int numberOfPassengers;
    private String departureDate;

    public SearchCriteria() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDepartureDate() {
        return departureDate != null ? departureDate : null;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate.equals("") ? null : departureDate;
    }
}
