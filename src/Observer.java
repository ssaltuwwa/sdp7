// Observer interface for objects that need to be notified of weather changes
// Follows Dependency Inversion Principle - depends on abstraction

public interface Observer {
    void update(WeatherData weatherData);
}