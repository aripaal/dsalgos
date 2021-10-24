package designpatterns;

import java.util.*;

public class FactoryPattern {
    static Pet petFactory(String animalType) {
        if (animalType.equals("cat"))
            return new Cat();
        else if (animalType.equals("dog"))
            return new Dog();
        else return null;
    }

    public static void main(String... args) {
        List<Pet> pets = Arrays.asList(petFactory("cat"), petFactory("dog"), petFactory("cat"));
        for (Pet p : pets) {
            p.drink();
            p.eat();
            p.sleep();
        }

    }
}

interface Pet {
    void eat();

    void sleep();

    void drink();
}

class Dog implements Pet {

    @Override
    public void eat() {
        System.out.println("Dog eating bones");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeping on mat");
    }

    @Override
    public void drink() {
        System.out.println("Dog drinking water");
    }
}

class Cat implements Pet {

    @Override
    public void eat() {
        System.out.println("Cat eating fish");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeping on bed");
    }

    @Override
    public void drink() {
        System.out.println("Cat drinking milk");
    }
}