package com.smarthome.device;

public class DeviceFactory {
    public Device getDevice(String deviceName){
        switch (deviceName.toLowerCase()){
            case "lamp":
                return new Lamp();
            case "conditioner":
                return new Conditioner();
            case "media":
                return new Tv();
            default:
                throw new IllegalArgumentException("Unknown Device type" + deviceName);
        }
    }
}
