package com.software.software.control;


import java.util.ArrayList;
import java.util.Scanner;

import com.software.software.Data.storage;
import com.software.software.actors.Driver;
import com.software.software.actors.Person;
import com.software.software.actors.Status;
import com.software.software.operations.RideOperations;
import com.software.software.ride.Ride;
import com.software.software.ride.event;

public class Admin {
    RideOperations rideOperations;
    static storage DB=new storage();
    private static String userName="admin";
    private static String password="admin";
    public static boolean signIn(String Name,String pass){
        if(userName.equalsIgnoreCase(Name)&&password.equalsIgnoreCase(pass)){
            return true;
        }
        else{
            return false;
        }
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public void addDiscountAreas(String area)
    {
        DB.addAdminDiscountAreas(area);
    }
    public static void suspendDriver(int id){
        DB.getActiveDriverById(id).getPersonInfo().setCurrentStatus(Status.SUSPENDED);
    }

    public static void suspendUser(int id){
        
        DB.getUserById(id).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
    }
    public void listUsers() {
        for (int i = 0; i  < DB.getUsersList().size(); i++) {
            //System.out.println(DB.getUsersList().get(i));
           // System.out.println("do you want to susbend this user? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if(s.equalsIgnoreCase("y"))
            {
                DB.getUsersList().get(i).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
            }
            //else  {continue;}
        }


    }
    public void listDriver() {
        for (int i = 0; i < DB.getDriversList().size(); i++) {
            System.out.println(DB.getDriversList().get(i));
            System.out.println("do you want to susbend this driver? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if(s.equalsIgnoreCase("y"))
            {
                DB.getDriversList().get(i).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
            }
            //else  {continue;}
        }
    }
    public static ArrayList<Driver> listPendingDrivers(){
        return DB.getPendingDrivers();
        }
    
    public static void approveDriver( int driverID )
    {
        Driver driver=DB.getPendingDriverById(driverID);
        driver.setStatus(Status.ACTIVE);
        DB.addDriver(driver);
    }
    public ArrayList<event> getEvents(int id){
        return rideOperations.showRideEvents(id);
    }
}

