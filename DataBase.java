//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.ArrayList;

public class DataBase {
    private static DataBase uniqueLists = new DataBase();
    private ArrayList<Driver> driversList = new ArrayList();
    private ArrayList<User> usersList = new ArrayList();
    private ArrayList<Ride> compridesList = new ArrayList();
    private ArrayList<Ride> RideRequest = new ArrayList();
    private ArrayList<Driver> pendingDrivers = new ArrayList();

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
        System.out.println("driver add sucessfuly");
    }
}
