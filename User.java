package company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class User extends Person{
	/*public User (Person person){
		this.setPersonInfo(person.getPersonInfo());
	}*/
	private RideOperations rideOperations;
	public void isValid(personInfo personInfo) {
		super.isValid(personInfo);
		personInfo.setCurrentStatus(Status.valueOf("Active"));
	}
	public Ride Request(String source, String destination) {
		Ride r = new Ride();
		r.setDestination(destination);
		r.setSource(source);
		r.setUser(this);
		return r;
	}
	public boolean acceptOffer(Driver driver) {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		System.out.println("The Driver says this ride will cost " + driver.getAvailbleRide().getPrice());
		System.out.println("y or n");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.equals("y")) {
			rideOperations.setEvent(2, driver.getAvailbleRide());
			return true;
		} else {
			return false;
		}
	}
	public void setDriverRate(Driver d, int rate,Ride r){

		if (rate >1&&rate < 5)
		r.setRate(rate);
		else
			System.out.println("rate must be in range 1 - 5 ");
	}

	@Override
	public String toString() {
		return "User name is " + this.getPersonInfo().getUserName()+
				" with phone number " + this.getPersonInfo().getPhoneNumber();
	}
}