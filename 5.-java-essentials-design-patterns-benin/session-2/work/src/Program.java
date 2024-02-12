import sourcemind.Cat;
import sourcemind.Dog;
import sourcemind.Walkable;

public class Program {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Oscar", 2);
        Cat cat2 = new Cat("Oscar", 2);
        Cat cat3 = new Cat("Tom", 3);

        Dog dog1 = new Dog("Buddy", 4, 12.5, "Labrador");
        Dog dog2 = new Dog("Buddy", 4, 12.5, "Labrador");
        Dog dog3 = new Dog("Max", 3, 10.2, "Golden Retriever");


        System.out.println("Equality of cat1 and cat2: " + cat1.equals(cat2));
        System.out.println("Equality of cat1 and cat3: " + cat1.equals(cat3));

        System.out.println("Equality of dog1 and dog2: " + dog1.equals(dog2));
        System.out.println("Equality of dog1 and dog3: " + dog1.equals(dog3));

        System.out.println("Equality of cat1 and dog1: " + cat1.equals(dog1));
    }
}

