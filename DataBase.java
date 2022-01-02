package com.software.software.Data;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.software.software.actors.Driver;
import com.software.software.actors.User;
import com.software.software.ride.Ride;

public class DataBase {
    private static DataBase uniqueLists = new DataBase();
    public ArrayList<Driver> driversList = new ArrayList();
    public ArrayList<User> usersList = new ArrayList();
    private ArrayList<Ride> compridesList = new ArrayList();
    private ArrayList<Ride> RideRequest = new ArrayList();
    private ArrayList<Driver> pendingDrivers = new ArrayList();
    private ArrayList<String> adminDiscontsAreas=new ArrayList();
    private Map<Integer,ArrayList<Ride>> offers=new HashMap<Integer,ArrayList<Ride>>();
    public void pushOffer(Ride offeredRide){
       if(offers.get(offeredRide.getRideId())!=null){
           ArrayList<Ride> offeredRides=offers.get(offeredRide.getRideId());
           offers.remove(offeredRide.getRideId());
           offers.put(offeredRide.getRideId(), offeredRides);
       }
    }
    public DataBase() {
    }

    public void setDriversList(ArrayList<Driver> driversList) {
        this.driversList = driversList;
    }

    public ArrayList<Ride> getCompridesList() {
        return this.compridesList;
    }

    public void setCompridesList(ArrayList<Ride> compridesList) {
        this.compridesList = compridesList;
    }

    public void setRideRequest(ArrayList<Ride> rideRequest) {
        this.RideRequest = rideRequest;
    }

    public void setPendingDrivers(ArrayList<Driver> pendingDrivers) {
        this.pendingDrivers = pendingDrivers;
    }

    public static DataBase getInstance() {
        if (uniqueLists == null) {
            uniqueLists = new DataBase();
            return uniqueLists;
        } else {
            return uniqueLists;
        }
    }

    public void addDriver(Driver driver) {
        this.driversList.add(driver);
    }

    public void addUser(User user) {
        this.usersList.add(user);
    }

    public void addCompRide(Ride ride) {
        this.compridesList.add(ride);
    }

    public void addRideRequest(Ride r) {
        this.RideRequest.add(r);
    }

    public ArrayList<Driver> getDriversList() {
        return this.driversList;
    }

    public ArrayList<User> getUsersList() {
        return this.usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public ArrayList<Ride> getRidesList() {
        return this.compridesList;
    }

    public void setRidesList(Ride r) {
        this.compridesList.add(r);
    }

    public ArrayList<Ride> getRideRequest() {
        return this.RideRequest;
    }

    public void setRideRequest(Ride rideRequest) {
        this.RideRequest.add(rideRequest);
    }

    public void AddUser(User user) {
        this.usersList.add(user);
    }

    public ArrayList<Driver> getPendingDrivers() {
        return this.pendingDrivers;
    }

    public void addPendingDrivers(Driver d) {
        this.pendingDrivers.add(d);
        //System.out.println("driver add sucessfuly");
    }
    public void addAdminDiscontsArea(String area){
        this.adminDiscontsAreas.add(area);
    }
    public Driver getActiveDriverById(int id){
        Driver selectedDriver=new Driver();
        for (int driver=0; driver<driversList.size(); driver++){
            if (id==driversList.get(driver).getDriverId()){
                selectedDriver= driversList.get(driver);
                break;
            }
        }
        return selectedDriver;
    }

    public Driver getPendingDriverById(int id){
        Driver selectedDriver=new Driver();
        for (int driver=0; driver<pendingDrivers.size(); driver++){
            if (id==pendingDrivers.get(driver).getDriverId()){
                selectedDriver= pendingDrivers.get(driver);
                break;
            }
        }
        return selectedDriver;
    }
    public Ride getRideById(int id){
        Ride selectedRide=new Ride();
        for(int ride=0; ride<RideRequest.size(); ride++){
            if (id==RideRequest.get(ride).getRideId()){
                selectedRide=RideRequest.get(ride);
            }
        }
        return selectedRide;
    }
    public ArrayList<Ride>getOffers(int rideId){
        return offers.get(rideId);
    }

    public User getUserById(int id){
        User u=new User();
        for (int user=0; user<usersList.size(); user++){
            if (usersList.get(user).getUserId()==id){
                u= usersList.get(user);
            }
        }
        return u;
    }
}

