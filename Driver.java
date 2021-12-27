package company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Person {
	private RideOperations rideOperations;
	private String nationalId;
	private String driverLicenseNumber;
	private ArrayList<String> favAreas=new ArrayList<String>();
	private ArrayList<Integer> rates=new ArrayList<Integer>();
	private Ride availbleRide=new Ride();
	private boolean notified = false;
	private boolean isArrivedToLocation=false;
	private boolean isArrivedToDestination=false;
	public Boolean isValid(personInfo personInfo, String nationalId, String driverLicenseNumber) {
		super.isValid(personInfo);
		personInfo.setCurrentStatus(Status.valueOf("Pending"));
		return true;
	}
	public void setAvailbleRide(Ride ride) {
		availbleRide = ride;
	}
	public Ride getAvailbleRide() {
		return availbleRide;
	}
	public void mkNotified() {
		notified = true;
	}
	public void addFavAreas(String area) {
		this.favAreas.add(area);
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	public ArrayList<String> getFavAreas() {
		return favAreas;
	}
	/*public void setFavAreas(ArrayList<String> favAreas) {
		this.favAreas = favAreas;
	}*/
	public ArrayList<Integer> getRates() {
		return rates;
	}
	public int getAvRate(){
		int sum=0;
		for (int i=0;i<this.rates.size();i++){
			sum += this.rates.get(i);
		}
		return (sum/this.rates.size()+1);
	}
	public void setDriverRate(int rate) {
		rates.add(rate);
	}
	public void mkOffer(Ride ride) {
		System.out.println("Hi Driver.. Please enter Ride's price: ");
		Scanner sin = new Scanner(System.in);
		int price = sin.nextInt();
    	availbleRide.setPrice(price);
		rideOperations.setEvent(1,availbleRide);
		//return getAvailbleRide().getPrice();
    }
	public String toString() {
		return "Driver name is " + this.getPersonInfo().getUserName()+
				" Driver phone number " + this.getPersonInfo().getPhoneNumber();
	}

	public void setArrivedToLocation(boolean arrivedToLocation) {
		isArrivedToLocation = arrivedToLocation;
		rideOperations.setEvent(3,availbleRide);
	}

	public void setArrivedToDestination(boolean arrivedToLocaton) {
		isArrivedToDestination = arrivedToLocaton;
		rideOperations.setEvent(4,availbleRide);

	}
}


