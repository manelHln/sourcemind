package sourcemind;

import java.util.Objects;

public class Dog implements Walkable {
    private String name;
    private int age;
    private double weight;
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    @Override
    public void walk() {
        System.out.println("A dog walking");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dog dog = (Dog) obj;
        return age == dog.age &&
                Double.compare(dog.weight, weight) == 0 &&
                Objects.equals(name, dog.name) &&
                Objects.equals(breed, dog.breed);
    }
    
}
