// Main application class - acts as composition root
// Separates object construction from business logic (Main separation)

public class WeatherMonitoringApp {

    public static void main(String[] args) {
        System.out.println("=== Weather Monitoring System Started ===\n");

        // Create subject (Dependency Injection would be used in real apps)
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

        // Simulate weather changes
        simulateWeatherChanges(weatherStation);

        // Demonstrate dynamic observer management
        demonstrateObserverManagement(weatherStation, statisticsDisplay);

        System.out.println("\n=== Weather Monitoring System Finished ===");
    }

    private static void simulateWeatherChanges(WeatherStation weatherStation) {
        // Simulate realistic weather patterns
        weatherStation.setMeasurements(22.5f, 65.0f, 30.1f);
        weatherStation.setMeasurements(25.0f, 70.0f, 29.8f);
        weatherStation.setMeasurements(20.0f, 85.0f, 29.8f);
    }

    private static void demonstrateObserverManagement(WeatherStation weatherStation,
                                                      StatisticsDisplay statsDisplay) {
        System.out.println("\n--- Demonstrating Dynamic Observer Management ---");
        System.out.println("Active observers: " + weatherStation.getObservers().size());

        // Remove an observer at runtime
        statsDisplay.unsubscribe();
        System.out.println("After removal - Active observers: " +
                weatherStation.getObservers().size());

        // Add new measurement with reduced observers
        weatherStation.setMeasurements(18.5f, 90.0f, 30.2f);
    }
}