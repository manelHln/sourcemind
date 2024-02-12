import com.Flight.Flight;
import com.Flight.Start;

import com.doublyLinkedList.DoublyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the departure location: ");
        char depLoc = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Enter the arrival location: ");
        char arrLoc = sc.next().charAt(0);

        DoublyLinkedList<Flight> flights = start.getPossiblesRoutes(depLoc, arrLoc);
        System.out.println(flights);
    }
}