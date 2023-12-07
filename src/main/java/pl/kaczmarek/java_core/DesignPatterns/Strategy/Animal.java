package pl.kaczmarek.java_core.DesignPatterns.Strategy;

public class Animal {

    private String name;
    private int weight;
    private double speed;
    public Fly flyType;

    public void setFlyType(Fly flyType) {
        this.flyType = flyType;
    }

    public String tryToFly(){
        return flyType.tryToFly();
    }
}
