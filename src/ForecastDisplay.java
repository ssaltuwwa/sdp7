// Concrete Observer - displays weather forecast
// Simple forecast based on pressure changes

public class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure;
    private float currentPressure;
    private final Subject weatherStation;

    public ForecastDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        this.lastPressure = 29.92f; // Default sea level pressure
        this.weatherStation.addObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }

    @Override
    public void display() {
        String forecast;
        if (currentPressure > lastPressure) {
            forecast = "Improving weather!";
        } else if (currentPressure < lastPressure) {
            forecast = "Cooler, rainy weather expected";
        } else {
            forecast = "More of the same";
        }

        System.out.println("[Forecast] " + forecast +
                " (Pressure: " + currentPressure + ")");
    }

    public void unsubscribe() {
        weatherStation.removeObserver(this);
    }
}