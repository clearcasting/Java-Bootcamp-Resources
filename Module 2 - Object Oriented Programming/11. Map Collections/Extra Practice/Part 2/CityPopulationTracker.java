import java.util.HashMap;

public class CityPopulationTracker {
    private HashMap<String, City> cityPopulations;

    public CityPopulationTracker() {
        this.cityPopulations = new HashMap<>();
    }

    public City getCity(String name) {
        return new City(cityPopulations.get(name));
    }

    public void setCity(City source) {
        cityPopulations.put(source.getName(), new City(source));
    }

    public void addCity(City source) {
        cityPopulations.put(source.getName(), new City(source));
    }
}
