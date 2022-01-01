//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.ArrayList;

public class storage {
    DataBase DB = DataBase.getInstance();

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

    public void addPendingDrivers(Driver d) {
        this.DB.addPendingDrivers(d);
    }
}
