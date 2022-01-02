package com.software.software.actors;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Scanner;

import com.software.software.ride.Ride;

public class User extends Person {
    public User() {
    }
    public void isValid(personInfo personInfo) {
        super.isValid(personInfo);
        personInfo.setCurrentStatus(Status.valueOf("Active"));
    }
    public Ride Request(String source, String destination,int numOfPassinger)
    {
        Ride r = new Ride();
        r.setDestination(destination);
        r.setSource(source);
        r.setNumberOfPassenger(numOfPassinger);
        r.setUser(this);
        return r;
    }
    public boolean acceptOffer(Driver driver) {
        System.out.println("The Driver says this ride will cost " + driver.getAvailbleRide().getPrice());
        System.out.println("y or n");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input.equals("y");
    }
    public void setDriverRate(Driver d, int rate, Ride r) {
        if (rate > 1 && rate < 5) {
            r.setRate(rate);
        } else {
          //  System.out.println("rate must be in range 1 - 5 ");
        }

    }
    public String toString() {
        String var10000 = this.getPersonInfo().getUserName();
        return "User name is " + var10000 + " with phone number " + this.getPersonInfo().getPhoneNumber();
    }

}
