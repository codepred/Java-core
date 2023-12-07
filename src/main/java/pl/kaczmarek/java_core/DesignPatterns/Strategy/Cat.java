package pl.kaczmarek.java_core.DesignPatterns.Strategy;

public class Cat extends Animal{

    void land(){
        System.out.println("ON 4 HANDS");
    }

    public Cat() {
        super();
        flyType = new CanFly();
    }
}
