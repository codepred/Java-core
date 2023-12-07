package pl.kaczmarek.java_core.DesignPatterns.Observator;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unSubscribe(Subscriber subscriber);

    void notifySubscriber();

    void upload(String title);
}
