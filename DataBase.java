package company;

import java.util.ArrayList;

public class DataBase {
	private static DataBase uniqueLists=new DataBase();
	public ArrayList<Driver> driversList=new ArrayList<Driver>();
	public ArrayList<User> usersList=new ArrayList<User>();
	public ArrayList<Ride> compridesList=new ArrayList<Ride>();
	public ArrayList<Ride> RideRequest=new ArrayList<Ride>();
	public ArrayList<Driver> pendingDrivers=new ArrayList<Driver>();
	public ArrayList<String> adminDiscountAreas = new ArrayList<String>();
	
	public void addAdminDiscountAreas(String area)
	{
		adminDiscountAreas.add(area);
	}

	public ArrayList<String> getAdminDiscountAreas() {
		return adminDiscountAreas;
	}

	public void setAdminDiscountAreas(ArrayList<String> adminDiscountAreas) {
		this.adminDiscountAreas = adminDiscountAreas;
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
		driversList.add(driver);
	}
	public void addUser(User user) {
		usersList.add(user);

	}
	public void addCompRide(Ride ride) {
		compridesList.add(ride);
	}
	public void addRideRequest(User user, String Source, String Destination) {
		Ride r = user.Request(Source, Destination);RideRequest.add(r);
	}
	public ArrayList<Driver> getDriversList() {
		return driversList;
	}
	/*public void setDriversList(ArrayList<Driver> driversList) {
		this.driversList = driversList;
	}*/
	public ArrayList<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(ArrayList<User> usersList) {
		this.usersList = usersList;
	}
	public ArrayList<Ride> getRidesList() {
		return compridesList;
	}
	public void setRidesList(Ride r) {
		this.compridesList.add(r);
	}
	public ArrayList< Ride > getRideRequest() {
		return RideRequest;
	}
	public void setRideRequest(Ride rideRequest) {
		this.RideRequest.add(rideRequest);
	}
	public void AddUser(User user) {
		usersList.add(user);
	}
	/*public void showAllMemoryList(){
		System.out.println("All Driver are");
		for(int i=0;i<pendingDrivers.size();i++) {
		System.out.println(i+1 + " - " + pendingDrivers.get(i));}
		System.out.println("All Users are");
			for(int i=0;i<usersList.size();i++){
				System.out.println(i+1 + " - " +usersList.get(i));
			}
	}*/
	public ArrayList<Driver> getPendingDrivers() {
		return pendingDrivers;
	}
	public void addPendingDrivers(Driver d) {
		pendingDrivers.add(d);
		System.out.println("driver add sucessfuly");
	}
}

