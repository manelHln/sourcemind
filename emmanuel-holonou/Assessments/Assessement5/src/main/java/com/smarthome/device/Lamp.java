package com.smarthome.device;

public class Lamp extends Device {
    private DeviceState deviceState;

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.LAMP;
    }

    @Override
    public DeviceState getDeviceState() {
        return this.deviceState;
    }

    @Override
    public void setDeviceState(String value) {
        this.deviceState = DeviceState.valueOf(value.toUpperCase());
    }
}
