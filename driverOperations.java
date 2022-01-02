package com.software.software.operations;

import com.software.software.Data.DataBase;
import com.software.software.Data.storage;
import com.software.software.actors.Driver;
import com.software.software.actors.personInfo;

public class driverOperations {

     public static boolean driverSignIn(String driverName,String passWord,storage memory){
        boolean isFound=false;
        
        for (int driver=0; driver<memory.getDriversList().size(); driver++){
            personInfo driverInfo=memory.getDriversList().get(driver).getPersonInfo();
            if(driverInfo.getUserName()==driverName&&driverInfo.getPassword()==passWord){
                isFound=true;
            }
        }
        return isFound;
    }
    
}
