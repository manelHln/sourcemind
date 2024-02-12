package com.smarthome;


public class App
{
    public static void main( String[] args ) throws Exception {
        SmartHome smartHome = new SmartHome();
        smartHome.addDevicesToHub();
        System.out.println(smartHome.hub);
    }
}
