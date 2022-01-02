package com.software.software.ride;


import java.util.ArrayList;

import com.software.software.Data.storage;
import com.software.software.Discounts.ridePrice;
import com.software.software.actors.Driver;
import com.software.software.actors.User;

public class Ride implements ridePrice {
    storage DB=new storage();
    private int rideID=0;
    private String Source;
    private String Destination;
    private User user;
    private Driver driver;
    private int numberOfPassenger;
    private int price;
    private int Rate;
    public  void setRideId(){
        rideID=DB.getRideRequest().size()+1;
    }
    public int getRideId(){
        return rideID;
    }
    private ArrayList<event> rideEvents=new ArrayList<event>();
    public void setPrice(int p) {
        this.price = p;
    }
    public int getPrice() {
        return price;
    }
    public int getRate() {
        return Rate;
    }
    public void setRate(int rate) {
        this.Rate = rate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public String getSource() {
        return Source;
    }
    public void setSource(String source) {
        Source = source;
    }
    public String getDestination() {
        return Destination;
    }
    public void setDestination(String destination) {
        Destination = destination;
    }
    public int getNumberOfPassenger() {
        return this.numberOfPassenger;
    }
    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassenger = numberOfPassenger;
    }
    public ArrayList<event> getRideEvents() {
        ArrayList<event> copiedEvents = new ArrayList<event>(rideEvents);
        return copiedEvents;
    }
    public void ShowRideDetails() {
        System.out.println("Ride Source is " + this.getSource()+
                "Ride Distenation is " + this.getDestination()
                + "the Ride requested by " + this.getUser().getPersonInfo().getUserName()
                + "with price " + this.getPrice()
                + "which is confirmed with Driver "
                + this.getDriver().getPersonInfo().getUserName());
    }
    @Override
    public String toString() {
        return
                "Source='" + Source + '\'' +
                        ", Destination='" + Destination + '\'' +
                        ", user=" + user.getPersonInfo().getUserName() +
                        ", driver=" + driver.getPersonInfo().getUserName()+
                        ", price=" + price +
                        ", Rate=" + Rate +
                        '}';
    }

    @Override
    public int getRidePrice() {
        return this.getPrice();
    }
}
