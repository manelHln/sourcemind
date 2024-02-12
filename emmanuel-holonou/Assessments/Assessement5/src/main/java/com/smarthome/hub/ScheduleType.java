package com.smarthome.hub;

public enum ScheduleType {
    ALWAYS, FROM_TO;
    public static ScheduleType getScheduleType(String schedule) {
        if (schedule.toLowerCase().contains("from") && schedule.toLowerCase().contains("to")) {
            return FROM_TO;
        } else if (schedule.toLowerCase().contains("always")) {
            return ALWAYS;
        } else {
            return null;
        }
    }
}
