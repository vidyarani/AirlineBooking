package airline.model;

public class SearchResult {

    private String modelName;
    private String source;
    private String destination;
    private double totalFare;

    public SearchResult(String modelName, String source, String destination, double totalFare) {
        this.modelName = modelName;
        this.source = source;
        this.destination = destination;
        this.totalFare = totalFare;
    }

    public String getModelName() {
        return modelName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getTotalFare() {
        return totalFare;
    }

    @Override
    public boolean equals(Object object) {
        SearchResult searchResult = (SearchResult) object;
        return (this.modelName.equals(searchResult.modelName) && this.source.equals(searchResult.source) &&
                this.destination.equals(searchResult.destination) && this.totalFare == searchResult.totalFare);
    }
}
