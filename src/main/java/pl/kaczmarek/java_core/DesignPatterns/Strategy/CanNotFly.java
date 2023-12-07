package pl.kaczmarek.java_core.DesignPatterns.Strategy;

public class CanNotFly implements Fly{

    @Override
    public String tryToFly() {
        return "CAN NOT FLY";
    }
}
