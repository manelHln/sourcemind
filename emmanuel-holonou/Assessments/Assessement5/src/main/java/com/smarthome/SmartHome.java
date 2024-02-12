package com.smarthome;

import com.smarthome.device.Device;
import com.smarthome.device.DeviceType;
import com.smarthome.hub.Hub;

import java.io.*;
import java.util.logging.Handler;


public class SmartHome {
    Hub hub = new Hub();

    File file = new File("devices.txt");

    public void addDevicesToHub(){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader
                    .lines()
                    .forEach(line -> {
                        hub.addDevice(line);
                        });
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
