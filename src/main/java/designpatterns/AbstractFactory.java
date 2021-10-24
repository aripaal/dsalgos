package designpatterns;

import lombok.*;

public class AbstractFactory {
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Car {
        @Getter
        @Setter
        String model;
        String location;
    }

    @ToString
    static class LuxuryCar extends Car {

        String location;

        LuxuryCar(String location) {

            super("Luxury", location);
            this.location = location;
        }
    }

    @ToString
    static class BudgetCar extends Car {
        String location;

        BudgetCar(String location) {
            super("Budget", location);
            this.location = location;
        }
    }

    static class IndianFactory {
        static Car buildCar(String type) {
            if (type.equals("Luxury")) {
                return new LuxuryCar("India");
            } else {
                return new BudgetCar("India");
            }
        }
    }

    static class USFactory {
        static Car buildCar(String type) {
            if (type.equals("Luxury")) {
                return new LuxuryCar("US");
            } else {
                return new BudgetCar("US");
            }
        }
    }

    public static void main(String... args) {
        System.out.println(AbstractFactory.IndianFactory.buildCar("Luxury"));
        System.out.println(AbstractFactory.USFactory.buildCar("Budget"));
    }
}
