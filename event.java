package com.software.software.ride;


import java.time.LocalDate;
import java.time.LocalTime;

public class event {
    public enum name{puttingPrice,arrivedToLocation,acceptingPrice,arrivedToDestination}
    public name eventName;
    public LocalTime eventTime;
    LocalDate eventDate;
    public String eventCaptain;
    String eventUser;
    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public name getEventName() {
        return eventName;
    }

    public void setEventName(name eventName) {
        this.eventName = eventName;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventCaptain() {
        return eventCaptain;
    }

    public void setEventCaptain(String eventCaptain) {
        this.eventCaptain = eventCaptain;
    }

    public String getEventUser() {
        return eventUser;
    }

    public void setEventUser(String eventUser) {
        this.eventUser = eventUser;
    }
}

