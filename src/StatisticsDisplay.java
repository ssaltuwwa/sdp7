import java.util.ArrayList;
import java.util.List;

// Concrete Observer - displays weather statistics
// Follows Single Responsibility Principle

public class StatisticsDisplay implements Observer, DisplayElement {
    private final List<Float> temperatureReadings;
    private final Subject weatherStation;

    public StatisticsDisplay(Subject weatherStation) {
        this.temperatureReadings = new ArrayList<>();
        this.weatherStation = weatherStation;
        this.weatherStation.addObserver(this);
    }

    @Override
    public void update(WeatherData weatherData) {
        temperatureReadings.add(weatherData.getTemperature());
        display();
    }

    @Override
    public void display() {
        if (temperatureReadings.isEmpty()) {
            System.out.println("[Statistics] No data available");
            return;
        }

        float max = temperatureReadings.stream()
                .max(Float::compare)
                .orElse(0.0f);
        float min = temperatureReadings.stream()
                .min(Float::compare)
                .orElse(0.0f);
        float avg = (float) temperatureReadings.stream()
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0);

        System.out.printf("[Statistics] Max: %.1f°C, Min: %.1f°C, Avg: %.1f°C%n",
                max, min, avg);
    }

    public void unsubscribe() {
        weatherStation.removeObserver(this);
    }
}