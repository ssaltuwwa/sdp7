// Concrete Observer - displays current weather conditions
// Single Responsibility: only handles current conditions display

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final Subject weatherStation;

    public CurrentConditionsDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.addObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display(); // Auto-display when updated
    }

    @Override
    public void display() {
        System.out.printf("[Current] Temperature: %.1f°C, Humidity: %.1f%%%n",
                temperature, humidity);
    }

    public void unsubscribe() {
        weatherStation.removeObserver(this);
    }
}