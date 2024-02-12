package com.Flight;


public class Flight {
    private int departureLocation;
    private String departureDate;
    private int arrivalLocation;
    private String arrivalDate;

    public Flight(String departureDate, String arrivalDate, int departureLocation, int arrivalLocation){
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Departure date: " + this.departureDate + "\n");
        str.append("Departure Location: " + this.departureLocation + "\n");
        str.append("Arrival date: " + this.arrivalDate + "\n");
        str.append("Arrival Location: " + this.arrivalLocation + "\n");
        return str.toString();
    }
}
