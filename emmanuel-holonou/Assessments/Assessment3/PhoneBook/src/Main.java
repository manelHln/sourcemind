import com.phonebook.PhoneBook;

public class Main {
    public static void main(String[] args) throws Exception {
        PhoneBook phoneBook = PhoneBook.getInstance();
        phoneBook.start();
    }
}