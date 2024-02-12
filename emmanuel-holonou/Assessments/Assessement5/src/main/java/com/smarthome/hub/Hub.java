package com.smarthome.hub;

import com.smarthome.device.Device;
import com.smarthome.device.DeviceFactory;
import com.smarthome.device.DeviceType;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Hub {
    static List<Device> deviceList = new ArrayList<>();
    DeviceFactory deviceFactory = new DeviceFactory();

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public void addDevice(String entry) {
        // <Device Type> <Device Name> <Value> <Schedule>
        String[] deviceInformation = entry.split(" ");
        Device device = deviceFactory.getDevice(deviceInformation[0]);
        device.setDeviceName(deviceInformation[1]);
        ScheduleType scheduleType = ScheduleType.getScheduleType(entry);
        String value = deviceInformation[2];
        if (scheduleType.equals(ScheduleType.ALWAYS)){
            device.setDeviceState(value);
            deviceList.add(device);
            return;
        }
        String from_value = deviceInformation[4];
        String to_value = deviceInformation[6];
        scheduleState(from_value, to_value, device);
        deviceList.add(device);
    }


    public void scheduleState(String from, String to, Device device) {
        String[] fromParts = from.split(":");
        String[] toParts = to.split(":");
        LocalTime fromDate = LocalTime.of(Integer.parseInt(fromParts[0]), Integer.parseInt(fromParts[1]));
        LocalTime toDate = LocalTime.of(Integer.parseInt(toParts[0]), Integer.parseInt(toParts[1]));
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isAfter(fromDate) && currentTime.isBefore(toDate)) {
            device.setDeviceState("ON");
        } else {
            device.setDeviceState("OFF");
        }

        long initialDelay = calculateInitialDelay(currentTime, fromDate);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable runnable = () -> {
            if (currentTime.isAfter(fromDate) && currentTime.isBefore(toDate)) {
                System.out.println(device.getDeviceName() + " is being turned on!");
                device.setDeviceState("ON");
            } else {
                System.out.println(device.getDeviceName() + " is being turned off!");
                device.setDeviceState("OFF");
            }
        };

        scheduler.schedule(runnable, initialDelay, TimeUnit.SECONDS);

        scheduler.shutdown();
    }


    private long calculateInitialDelay(LocalTime currentTime, LocalTime scheduledTime) {
        long initialDelay = 0;

        if (currentTime.isBefore(scheduledTime)) {
            initialDelay = Duration.between(currentTime, scheduledTime).getSeconds();
        } else {
            initialDelay = Duration.between(currentTime, scheduledTime.plusHours(24)).getSeconds();
        }

        return initialDelay;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Device device :
                deviceList) {
            str.append(device.getDeviceName() + " is right now " + device.getDeviceState().toString() + " \n");
        }
        return str.toString();
    }


    public static List<Device> getDevicesList(){
        return deviceList;
    }
}
