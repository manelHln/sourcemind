package com.smarthome.device;

import java.time.LocalTime;

public abstract class Device {
    private String deviceName;
    private DeviceType deviceType;



    public abstract DeviceType getDeviceType();
    public String getDeviceName(){
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public abstract DeviceState getDeviceState();

    public abstract void setDeviceState(String value);
}
