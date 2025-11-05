import java.util.List;

// Subject interface for objects that can be observed
// Encapsulates subscription management logic

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    List<Observer> getObservers();
}