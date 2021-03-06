package company;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Person {
	private String nationalId;
	private String driverLicenseNumber;
	private ArrayList<String> favAreas;
	private ArrayList<Integer> rates;
	private Ride availbleRide;
	private boolean notified = false;

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

	public void addFavArea(String area) {
		favAreas.add(area);
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

	/*public void setRates(ArrayList<Integer> rates) {
		this.rates = rates;
	}*/

	public Ride mkOffer() {

		System.out.println("Hi Driver.. Please enter Ride price: ");
		Scanner sin = new Scanner(System.in);
		int price = sin.nextInt();
    	availbleRide.setPrice(price);
    	return availbleRide;
    }


}
