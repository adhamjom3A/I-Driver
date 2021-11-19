package company;

public class RideOperations {
	public void assignDriverToRide(arrayLists inventory) {
		for (int request = 0; request < inventory.RideRequest.size(); request++) {
			for (int driver = 0; driver < inventory.driversList.size(); driver++) {
				for (int favArea = 0; favArea < inventory.driversList.get(driver).getFavAreas().size(); favArea++) {
					if (inventory.RideRequest.get(request).getDestination() == inventory.driversList.get(driver)
							.getFavAreas().get(favArea)
							&& (inventory.driversList.get(driver).getPersonInfo().getCurrentStatus()
									.equals("ACTIVE"))) {
						inventory.driversList.get(driver).setAvailbleRide(inventory.RideRequest.get(request));
						inventory.driversList.get(driver).mkNotified();
					}
				}
			}
		}
	}
}
