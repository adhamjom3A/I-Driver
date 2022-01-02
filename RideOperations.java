package company;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Observable;

public class RideOperations extends Observable {
    storage inventory = new storage();
    Status status=Status.ACTIVE;


    public ArrayList<Driver> assignDriverToRide(Ride r) {
        ArrayList<Driver> suitableDriver = new ArrayList<Driver>();
        for (int driver = 0; driver < inventory.getDriversList().size(); driver++) {
            for (int favArea = 0; favArea < inventory.getDriversList().get(driver).getFavAreas().size(); favArea++) {
                if (r.getDestination().equalsIgnoreCase(inventory.getDriversList().get(driver)
                        .getFavAreas().get(favArea))
                        && (inventory.getDriversList().get(driver).getPersonInfo().getCurrentStatus()
                        .equals(status))) {
                    inventory.getDriversList().get(driver).notify();
                    inventory.getDriversList().get(driver).setAvailbleRide(r);
                    inventory.getDriversList().get(driver).mkNotified();
                    suitableDriver.add(inventory.getDriversList().get(driver));
                }
            }
        }
        return suitableDriver;
    }
    ///this function return all the request rides with the same favorite area
    public ArrayList <Ride> allFavRide(String driverFavArea) {
        ArrayList<Ride> r = new ArrayList<Ride>();
        for (int req = 0; req < inventory.getRideRequest().size(); req++) {
            if (inventory.getRideRequest().get(req).getDestination() == driverFavArea) {
                r.add(inventory.getRideRequest().get(req));
            }
        }
        return r;
    }
    public void showRideEvents(Ride ride){
        ArrayList<event> rideEvents= ride.getRideEvents();
        for(int i=0; i< rideEvents.size(); i++){
            System.out.println(rideEvents.get(i).eventName);
            System.out.println(rideEvents.get(i).eventCaptain);
            System.out.println(rideEvents.get(i).eventTime);
            System.out.println(rideEvents.get(i).eventUser);
        }
    }
    public void setEvent(int index,Ride availbleRide){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        availbleRide.getRideEvents().get(index).setEventName(event.name.arrivedToLocation);
        availbleRide.getRideEvents().get(index).setEventCaptain(availbleRide.getDriver().getPersonInfo().getUserName());
        availbleRide.getRideEvents().get(index).setEventUser(availbleRide.getUser().getPersonInfo().getUserName());
        availbleRide.getRideEvents().get(index).setEventTime(localTime);
        availbleRide.getRideEvents().get(index).setEventDate(localDate);
    }
}