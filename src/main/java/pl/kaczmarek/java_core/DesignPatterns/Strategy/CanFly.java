package pl.kaczmarek.java_core.DesignPatterns.Strategy;

public class CanFly implements Fly{

    @Override
    public String tryToFly() {
        return  "CAN FLY";
    }
}
