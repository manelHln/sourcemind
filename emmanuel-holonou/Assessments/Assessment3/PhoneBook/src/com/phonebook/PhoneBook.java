package com.phonebook;

import Exceptions.InvalidFileException;
import Exceptions.WrongInputException;
import com.phonebook.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook extends PhonebookActions {
    private ArrayList<Contact> Contacts = new ArrayList<>();
    private static PhoneBook instance;

    public static PhoneBook getInstance(){
        if(instance == null){
            return new PhoneBook();
        }
        return instance;
    }

    public void setContactList(Contact contact){
        Contacts.add(contact);
    }


    protected void init() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data.txt"))) {
                String firstName = null;
                String lastName = null;
                ArrayList<String> phoneNumbers = new ArrayList<>();
                int numbersCount = 0;
                while (reader.ready()){
                    String line = reader.readLine();
                    if(line.toLowerCase().startsWith("fir")){
                        firstName = line;
                    }
                    else if(line.toLowerCase().startsWith("las")){
                        lastName = line;
                    }
                    else if(line.toLowerCase().startsWith("mob") || line.toLowerCase().startsWith("off") || line.toLowerCase().startsWith("hom")){
                        if(phoneNumbers == null){
                            phoneNumbers = new ArrayList<>();
                        }
                        phoneNumbers.add(line);
                        numbersCount++;
                    }
                    if(line.startsWith("--")){
                            Contacts.add(new Contact(firstName, lastName, phoneNumbers));
                            firstName = null;
                            lastName = null;
                            phoneNumbers = null;
                    }
                    //Make sure last contact is added since end of line might not be "---"
                    if(!reader.ready() && firstName != null && lastName != null){
                        Contacts.add(new Contact(firstName, lastName, phoneNumbers));
                        firstName = null;
                        lastName = null;
                        phoneNumbers = null;
                    }
                }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void start() throws IOException {
        this.init();
        System.out.println("*** Phonebook Search Application ***");
//        System.out.println(this);
        System.out.println("\n\n");
        System.out.println("Choose your action");
        System.out.println("1: Find by name");
        System.out.println("2: Find by number");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        sc.nextLine();
        try{
            switch (choice) {
                case "1" -> {
                    System.out.println("Enter the name");
                    String input = sc.nextLine();
                    if(!this.validateName(input)){
                        throw new WrongInputException("Enter at least 3 letters");
                    }
                    this.searchByName(input);
                }
                case "2" -> {
                    System.out.println("Enter the number");
                    String input = sc.nextLine();
                    this.searchByNumber(input);
                }
                default -> throw new WrongInputException("Wrong Input provided!!Please enter 1 or 2 according to your need");
            }
        }
        catch (WrongInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void searchByName(String str) {
        for(Contact contact : Contacts){
            if(contact.getFirstName().toLowerCase().contains(str) || contact.getLastName().toLowerCase().contains(str)){
                System.out.println(contact.toString());
            }
        }
    }

    @Override
    public void searchByNumber(String str) {
        for(Contact contact : Contacts){
            for (String number: contact.getPhoneNumbers()){
                String tel = Utils.removeSpaces(number.split(":")[1].trim());
                String test = Utils.removeSpaces(str);
                if(tel.equals(test)){
                    System.out.println(contact.toString());
                    break;
                }
            }
        }
    }

    @Override
    public String toString(){
        String str = "";
        for(Contact contact : this.Contacts){
            str = str.concat(contact.toString() + "-------------------- \n");
        }
        return str;
    }
}
