package com.Flight;

import com.database.Connect;
import com.doublyLinkedList.DoublyLinkedList;

import java.sql.ResultSet;
import java.sql.Statement;

public class Start {
    private DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    public Start(){}


    public DoublyLinkedList<Flight> getPossiblesRoutes(int departureLocation, int arrivalLocation){
        Connect dbConnexion= Connect.getInstance("jok3r", "joker123");
        DoublyLinkedList<Flight> flights = new DoublyLinkedList<>();
        try(Statement statement = dbConnexion.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight");
            while (resultSet.next()){
                String depDate = String.valueOf(resultSet.getDate("dep_date"));
                String arrDate = String.valueOf(resultSet.getDate("arr_date"));
                int depLoc = resultSet.getInt("departure_location_id");
                int arrLoc = resultSet.getInt("arrival_location_id");
                Flight newFilght = new Flight(depDate, arrDate, depLoc, arrLoc);
                flights.append(newFilght);
            }
            resultSet.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flights;
    }
}
