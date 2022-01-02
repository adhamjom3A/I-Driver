package com.software.software.operations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.software.software.Data.storage;
import com.software.software.actors.Driver;
import com.software.software.ride.Ride;
import com.software.software.ride.event;
import com.software.software.actors.Status;



public class RideOperations  {
    storage inventory = new storage();
    Status status=Status.ACTIVE;

    //refactoring
    public ArrayList<Driver> FilterDrivers(ArrayList<Driver> a,Ride r){
        ArrayList<Driver> drivers = new ArrayList<>();
        for (int d=0; d<a.size();d++){
            if (r.getNumberOfPassenger()<=a.get(d).getAvailbleSets()){
                drivers.add(a.get(d));
            }
        }
        return drivers;
    }

    public ArrayList<Driver> assignDriverToRide() {
        Ride r=new Ride();
        ArrayList<Driver> suitableDriver = new ArrayList<Driver>();
        for (int driver = 0; driver < inventory.getDriversList().size(); driver++) {
            for(int rideRequest=0; rideRequest<inventory.getRideRequest().size(); rideRequest++){
                r=inventory.getRideRequest().get(rideRequest);
                for (int favArea = 0; favArea < inventory.getDriversList().get(driver).getFavAreas().size(); favArea++) {
                    if (r.getDestination().equalsIgnoreCase(inventory.getDriversList().get(driver)
                            .getFavAreas().get(favArea))
                            && (inventory.getDriversList().get(driver).getPersonInfo().getCurrentStatus()
                            .equals(status))) {
                        //inventory.getDriversList().get(driver).notify();
                        inventory.getDriversList().get(driver).setAvailbleRide(r);
                        inventory.getDriversList().get(driver).mkNotified();
                        suitableDriver.add(inventory.getDriversList().get(driver));
                    }
                }
            }
        }
        return FilterDrivers(suitableDriver,r);
    }

    ///this function return all the request rides with the same favorite area
    public ArrayList <Ride> allFavRide(String driverFavArea) {
        ArrayList<Ride> r = new ArrayList<Ride>();
        for (int req = 0; req < inventory.getRideRequest().size(); req++) {
            if (inventory.getRideRequest().get(req).getDestination() == driverFavArea) {
                r.add(inventory.getRideRequest().get(req));
            }
        }
        return r;
    }
    public ArrayList<event> showRideEvents(int rideID){
        ArrayList<event> rideEvents= inventory.getRideByID(rideID).getRideEvents();
        return rideEvents;
        
    }
    public static void setEvent(int index,Ride availbleRide){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        availbleRide.getRideEvents().get(index).setEventName(event.name.arrivedToLocation);
        availbleRide.getRideEvents().get(index).setEventCaptain(availbleRide.getDriver().getPersonInfo().getUserName());
        availbleRide.getRideEvents().get(index).setEventUser(availbleRide.getUser().getPersonInfo().getUserName());
        availbleRide.getRideEvents().get(index).setEventTime(localTime);
        availbleRide.getRideEvents().get(index).setEventDate(localDate);
    }

    
}