package designpatterns;

public class Adapter {
    interface DogInterface {
        String bark();
    }

    static class Dog implements DogInterface {
        public String bark() {
            return "bow wow";
        }
    }

    interface ToyDogInterface {
        String play();
    }

    static class ToyDog implements ToyDogInterface {
        public String play() {
            return "beep beep";
        }
    }

    static class DogAdapter implements ToyDogInterface {
        Dog dog;

        DogAdapter(Dog dog) {
            this.dog = dog;
        }

        @Override
        public String play() {
            return dog.bark();
        }
    }

    public static void main(String... args) {
        DogInterface dog = new Dog();
        ToyDogInterface tdg = new ToyDog();
        ToyDogInterface tddog = new DogAdapter((Dog) dog);

        System.out.println(dog.bark());
        System.out.println(tdg.play());
        System.out.println(tddog.play());
    }
}

