package com.smarthome.device;

public class Tv extends Device {
    private DeviceState deviceState;

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.MEDIA;
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
