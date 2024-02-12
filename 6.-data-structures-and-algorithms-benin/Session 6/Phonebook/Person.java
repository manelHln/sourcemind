import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public void addNumber(PhoneNumber number) {
        this.phoneNumbers.add(number);
    }

    public PhoneNumber[] getPhoneNumbers() {
        return this.phoneNumbers.toArray(new PhoneNumber[this.phoneNumbers.size()]);
    }
}
