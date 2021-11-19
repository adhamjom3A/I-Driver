package company;

public class User extends Person {
	private String Source;
	private String Destination;

	public Boolean isValid(personInfo personInfo) {
		super.isValid(personInfo);
		personInfo.setCurrentStatus(Status.valueOf("Active"));
		return true;
	}

	public Ride Request(String source, String destination) {
		Ride r = new RideRequest();
		r.setDestination(destination);
		r.setSource(source);
		r.setUser(this);
		return r;
	}

	public boolean acceptOffer(Driver driver) {
		System.out.println("The Driver says this ride will cost " + driver.getAvailbleRide().getPrice());
		System.out.println("y or n");
		Scanner sc = new Scanner(System.in);
		char input = sc.nextchar();
		if (input == "y") {
			return true;
		} else {
			return false;
		}
	}
}
