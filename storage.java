package com.software.software.Data;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.ArrayList;

import com.software.software.actors.Driver;
import com.software.software.actors.User;
import com.software.software.ride.Ride;

public class storage {
    DataBase DB = DataBase.getInstance();
    public Object driversList;

    public storage() {
    }

    public void addDriver(Driver driver) {
        this.DB.addDriver(driver);
    }

    public void addUser(User user) {
        this.DB.addUser(user);
    }

    public void addCompRide(Ride ride) {
        this.DB.addCompRide(ride);
    }

    public void addRideRequest(Ride r) {
        this.DB.addRideRequest(r);
    }

    public ArrayList<Driver> getDriversList() {
        ArrayList<Driver> l = this.DB.getDriversList();
        return l;
    }

    public ArrayList<User> getUsersList() {
        ArrayList<User> l = this.DB.getUsersList();
        return l;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.DB.setUsersList(usersList);
    }

    public ArrayList<Ride> getRidesList() {
        ArrayList<Ride> l = this.DB.getRidesList();
        return l;
    }

    public void setRidesList(Ride r) {
        this.DB.setRidesList(r);
    }

    public ArrayList<Ride> getRideRequest() {
        ArrayList<Ride> l = this.DB.getRidesList();
        return l;
    }

    public void setRideRequest(Ride rideRequest) {
        this.DB.setRideRequest(rideRequest);
    }

    public void AddUser(User user) {
        this.DB.AddUser(user);
    }

    public ArrayList<Driver> getPendingDrivers() {
        ArrayList<Driver> l = this.DB.getPendingDrivers();
        return l;
    }
    public void addAdminDiscountAreas(String area){
        this.DB.addAdminDiscontsArea(area);
    }
    public void addPendingDrivers(Driver d) {
        this.DB.addPendingDrivers(d);
    }
    public Driver getPendingDriverById(int id){
        return DB.getPendingDriverById(id);
    }
    public Driver getActiveDriverById(int id){
        return DB.getPendingDriverById(id);
    }
    public void removePendingDriver(Driver driver){
        DB.getPendingDrivers().remove(driver);
    }
    public Ride getRideByID(int id){
        return DB.getRideById(id);
    }
    public void pushOffer(Ride offeredRide){
        DB.pushOffer(offeredRide);
    }
    public ArrayList<Ride> getOffers(int rideId){
        return DB.getOffers(rideId);
    }
    public User getUserById(int id){
        return DB.getUserById(id);
    }
}

