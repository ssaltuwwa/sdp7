import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Concrete Subject - Weather Station that manages observers and notifications
// Follows Open/Closed Principle - can extend functionality without modification

public class WeatherStation implements Subject {
    private final List<Observer> observers;
    private WeatherData currentWeatherData;

    public WeatherStation() {
        // Thread-safe list for dynamic observer management
        this.observers = new CopyOnWriteArrayList<>();
        this.currentWeatherData = new WeatherData(0.0f, 0.0f, 0.0f);
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer added: " + observer.getClass().getSimpleName());
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
            System.out.println("Observer removed: " + observer.getClass().getSimpleName());
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentWeatherData);
        }
    }

    @Override
    public List<Observer> getObservers() {
        return new ArrayList<>(observers); // Return copy for encapsulation
    }

    // Updates weather measurements and notifies all observers
    // Core business logic separated from notification mechanism

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.currentWeatherData = new WeatherData(temperature, humidity, pressure);
        System.out.println("\n--- Weather Updated: " + currentWeatherData + " ---");
        notifyObservers();
    }

    public WeatherData getCurrentWeatherData() {
        return currentWeatherData;
    }
}