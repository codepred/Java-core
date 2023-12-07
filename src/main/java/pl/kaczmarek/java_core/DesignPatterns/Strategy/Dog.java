package pl.kaczmarek.java_core.DesignPatterns.Strategy;

public class Dog extends Animal{

    void bark(){
        System.out.println("HAU HAU");
    }

    public Dog() {
        super();

        flyType = new CanNotFly();

    }
}
