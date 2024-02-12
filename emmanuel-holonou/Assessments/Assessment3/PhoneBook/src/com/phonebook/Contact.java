package com.phonebook;

import java.util.ArrayList;

public class Contact {
    private String firstName;
    private String lastName;
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    public Contact(String firstName, String lastName, ArrayList<String> phoneNumbers){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumbers(phoneNumbers);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString(){
        String str = "";
        str = str.concat(this.getFirstName() + "\n");
        str = str.concat(this.getLastName() + "\n");
        for(String number : this.getPhoneNumbers()){
            str = str.concat(number + "\n");
        }
        return str;
    }
}
