// Immutable weather data model
// Pure domain object without dependencies

public final class WeatherData {
    private final float temperature;
    private final float humidity;
    private final float pressure;

    public WeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    // Getters only - immutable
    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }

    @Override
    public String toString() {
        return String.format("WeatherData{temperature=%.1f, humidity=%.1f, pressure=%.1f}",
                temperature, humidity, pressure);
    }
}