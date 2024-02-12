package com.smarthome.device;

public class Conditioner extends Device {
    private DeviceState deviceState;
    private Double temperature;

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.CONDITIONER;
    }

    public boolean setTemperature(Double temperature) {
        if (temperature < 16 || temperature > 30) {
            return false;
        }
        this.temperature = temperature;
        return true;
    }

    public Double getTemperature() {
        return this.temperature;
    }

    protected boolean isOn() {
        return this.deviceState.equals(DeviceState.ON);
    }

    @Override
    public DeviceState getDeviceState() {
        return this.deviceState;
    }

    @Override
    public void setDeviceState(String value) {
        if (this.setTemperature((double) Integer.parseInt(value))) {
            this.deviceState = DeviceState.ON;
        }
    }
}
