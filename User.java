package com.software.software.actors;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Scanner;

import com.software.software.Data.storage;
import com.software.software.ride.Ride;

public class User extends Person {
    static storage DB=new storage();
    int userId;
    public User() {
    }
    public void setUserId(){
        userId=DB.getUsersList().size()+1;
    }
    public int getUserId(){
        return userId;
    }
    public void isValid(personInfo personInfo) {
        super.isValid(personInfo);
        personInfo.setCurrentStatus(Status.valueOf("Active"));
    }
    public Ride Request(String source, String destination,int numOfPassinger)
    {
        Ride r = new Ride();
        r.setRideId();
        r.setDestination(destination);
        r.setSource(source);
        r.setNumberOfPassenger(numOfPassinger);
        r.setUser(this);
        return r;
    }
    public static void acceptOffer(int rideId,int driverId) {
        for(int i=0; i<DB.getOffers(rideId).size(); i++){
            if (DB.getOffers(rideId).get(i).getRideId()==rideId&&DB.getOffers(rideId).get(i).getDriver().getDriverId()==driverId){
                DB.addCompRide(DB.getOffers(rideId).get(i));
                break;
            }
        };
    }
    public static void setDriverRate(int driverId , int rate) {
    
        if (rate > 1 && rate < 5) {
             DB.getActiveDriverById(driverId).setDriverRate(rate);
        } else {
          //  System.out.println("rate must be in range 1 - 5 ");
        }

    }
    public String toString() {
        String var10000 = this.getPersonInfo().getUserName();
        return "User name is " + var10000 + " with phone number " + this.getPersonInfo().getPhoneNumber();
    }

}
