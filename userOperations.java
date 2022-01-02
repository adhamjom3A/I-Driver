package com.software.software.operations;


import java.sql.Driver;
import java.util.ArrayList;

import javax.print.attribute.standard.Destination;

import com.software.software.Data.storage;
import com.software.software.actors.User;
import com.software.software.actors.personInfo;
import com.software.software.ride.Ride;

public class userOperations {
    static RideOperations rideOperat;
    static storage m;
    static User newUser;
    public static boolean userSignIn(String userName,String passWord,storage memory){
        boolean isFound=false;
        for (int user=0; user<memory.getUsersList().size(); user++){
            personInfo userInfo=memory.getUsersList().get(user).getPersonInfo();
            if(userInfo.getUserName()==userName&&userInfo.getPassword()==passWord){
                isFound=true;
            }
        }
        return isFound;
    }

    public static void requestRide(String source,String destination,int numOfPassingers) {
        Ride selectedRide = newUser.Request(source, destination,numOfPassingers);
        m.addRideRequest(selectedRide);
    }
 

}
