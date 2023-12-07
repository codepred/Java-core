package pl.kaczmarek.java_core.DesignPatterns.Strategy;

public class PlayAnimal {


    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal cat = new Cat();

        System.out.println(dog.tryToFly());
        System.out.println(cat.tryToFly());
    }
}
