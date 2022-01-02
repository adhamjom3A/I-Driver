package com.software.software.web;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.software.software.Data.storage;
import com.software.software.actors.Driver;
import com.software.software.actors.User;
import com.software.software.actors.personInfo;
import com.software.software.control.Admin;
import com.software.software.operations.driverOperations;
import com.software.software.operations.userOperations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/software")
public class softwareApi {
    storage inventory=new storage();

    @PostMapping("signUp/user")
    public void userSignUp(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password,
        @RequestParam(name="birthday") String birthday,
        @RequestParam(name="email")    String email,
        @RequestParam(name="phoneNumber") String phoneNumber){
        personInfo userInfo=new personInfo();
        userInfo.setPassword(password);
        userInfo.setUserName(userName);
        userInfo.setPhoneNumber(phoneNumber);
        userInfo.setEmail(email);
        userInfo.setBirthday(birthday);
        userInfo.setRole("user");
        User user=new User();
        user.regist(userInfo);
        inventory.AddUser(user);
    }

    @PostMapping("/signUp/driver")
    public void driverSignUp(
        @RequestParam(name="DrvierName") String userName,
        @RequestParam(name="password") String password,
        @RequestParam(name="licenseNumber") String licensNumber,
        @RequestParam(name="nationalId")String nationalId,
        @RequestParam(name="email")    String email,
        @RequestParam(name="availbleSets")int availbleSets,
        @RequestParam(name="phoneNumber") String phoneNumber){
        personInfo driverInfo=new personInfo();
        driverInfo.setPassword(password);
        driverInfo.setUserName(userName);
        driverInfo.setPhoneNumber(phoneNumber);
        driverInfo.setEmail(email);
        driverInfo.setRole("driver");
        Driver driver=new Driver();
        driver.setAvailbleSets(availbleSets);
        driver.setDriverLicenseNumber(licensNumber);
        driver.setNationalId(nationalId);
        driver.regist(driverInfo);
        inventory.addPendingDrivers(driver);
    }



    @PostMapping("signIn/admin")
    public boolean adminSignIn(
        @RequestParam(name="adminUserName") String adminUserName,
        @RequestParam(name="adminPassword") String adminPassword){
            return Admin.signIn(adminUserName, adminPassword);
        }


    @PostMapping("/signIn/user")
    public boolean UserSignIn(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password )
        {
            return userOperations.userSignIn(userName, password, inventory);
        }


    @PostMapping("signIn/driver")
    public boolean DriverSignIn(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password )
        {
            return driverOperations.driverSignIn(userName, password, inventory);
        }
    @PostMapping ("signIn/user/requestRide")
    public void requestRide(
        @RequestParam(name="source")String source,
        @RequestParam(name="destination")String destination,
        @RequestParam(name="numberOfPassingers")int numberOfPassingers){
            userOperations.requestRide(source, destination, numberOfPassingers);
        }
    
    @PostMapping("signIn/driver/makeOffer")
    public void makeOffer(@RequestParam (name="price")int price){
        Driver.mkOffer(price);
    }

}
