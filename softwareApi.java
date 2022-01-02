package com.software.software.web;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
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
    Gson gson = new GsonBuilder().create();
    ////////////////////User API///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @PostMapping("/signUp/user")
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



    @PostMapping("/signIn/user")
    public boolean UserSignIn(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password )
        {
            return userOperations.userSignIn(userName, password, inventory);
        }

    @PostMapping ("/signIn/user/requestRide")
    public void requestRide(//return price
        @RequestParam(name="source")String source,
        @RequestParam(name="destination")String destination,
        @RequestParam(name="numberOfPassingers")int numberOfPassingers){
            userOperations.requestRide(source, destination, numberOfPassingers);
        }
    
    

    @GetMapping("/signIn/user/requestRide/getOffers")
    public JsonArray getOffers(@RequestParam (name="rideId")int rideId){
        JsonArray offers = (JsonArray) gson.toJsonTree(inventory.getOffers(rideId));
        return offers;
    }
    @PostMapping("/signIn/user/requestRide/getOffers/acceptOffer")
    public void acceptOffer(@RequestParam(name="rideId")int rideId,@RequestParam(name="driverId")int driverId){
        User.acceptOffer(rideId, driverId);
    }


        //////////////////////////////////////////Driver Api////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        @PostMapping("/signUp/driver")
        public void driverSignUp(
            @RequestParam(name="DriverName") String userName,
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
    


    @PostMapping("/signIn/driver")
    public boolean DriverSignIn(
        @RequestParam(name="userName") String userName,
        @RequestParam(name="password") String password )
        {
            return driverOperations.driverSignIn(userName, password, inventory);
        }
    
    @PostMapping("/signIn/driver/makeOffer")
    public void makeOffer(@RequestParam (name="price")int price){
        Driver.mkOffer(price);
    }


    //////////////////////////////////////////////////////Admin Api/////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/signIn/admin")
    public boolean adminSignIn(
        @RequestParam(name="adminUserName") String adminUserName,
        @RequestParam(name="adminPassword") String adminPassword){
            return Admin.signIn(adminUserName, adminPassword);
        }


    @GetMapping("/signIn/admin/listPendingDrivers")
    public JsonArray listPendingDrivers(){
        JsonArray pending = gson.toJsonTree(Admin.listPendingDrivers()).getAsJsonArray();
        return pending ;
    }
 
    @PostMapping("/signIn/admin/approveDriver")
    public void approveDriver(@RequestParam (name="ID")int id){
        Admin.approveDriver(id);
    }

      @PostMapping("/signIn/admin/suspend/user")
    public void suspendUser(@RequestParam (name="ID")int id){
        Admin.suspendUser(id);
    }
    @PostMapping("/signIn/admin/suspend/driver")
    public void suspendDriver(@RequestParam (name="ID")int id){
        Admin.suspendDriver(id);
    }
     
      @PostMapping("/signIn/user/setDriverRate")
    public void setDriverRate(@RequestParam (name="ID")int id,@RequestParam (name="Rate")int rate){
        User.setDriverRate(id, rate);
    }

 @GetMapping("/signIn/driver/getRates")
    public JsonArray getRates(@RequestParam(name="ID")int id){
        JsonArray rates = gson.toJsonTree(inventory.getActiveDriverById(id).getRates()).getAsJsonArray();
        return rates;
    }

}
