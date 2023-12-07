package pl.kaczmarek.java_core.DesignPatterns.Observator;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
