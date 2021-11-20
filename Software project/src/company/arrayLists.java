package company;

import java.util.ArrayList;

public class arrayLists {
	public static arrayLists uniqueLists;
	public ArrayList<Driver> driversList;
	public ArrayList<User> usersList;
	public ArrayList<Ride> ridesList;
	public ArrayList<Ride> RideRequest;

	public static arrayLists getInstance() {
		if (uniqueLists == null) {
			uniqueLists = new arrayLists();
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

	public void addRide(Ride ride) {
		ridesList.add(ride);
	}

	public void addRideRequest(User user, String Source, String Destination) {
		Ride r = user.Request(Source, Destination);
		RideRequest.add(r);
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

	/*public void setUsersList(ArrayList<User> usersList) {
		this.usersList = usersList;
	}*/

	public ArrayList<Ride> getRidesList() {
		return ridesList;
	}

	/*public void setRidesList(Ride r) {
		this.ridesList.add(r);
	}*/

	public ArrayList< Ride > getRideRequest() {
		return RideRequest;
	}

	/*public void setRideRequest(Ride rideRequest) {
		this.RideRequest.add(rideRequest);
	}*/
}
