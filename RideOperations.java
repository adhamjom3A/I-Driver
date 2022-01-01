//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.ArrayList;

public class RideOperations {
    storage inventory = new storage();
    Status status;

    public RideOperations() {
        this.status = Status.ACTIVE;
    }

    public ArrayList<Driver> assignDriverToRide(Ride r) {
        ArrayList<Driver> suitableDriver = new ArrayList();

        for(int driver = 0; driver < this.inventory.getDriversList().size(); ++driver) {
            for(int favArea = 0; favArea < ((Driver)this.inventory.getDriversList().get(driver)).getFavAreas().size(); ++favArea) {
                if (r.getDestination().equalsIgnoreCase((String)((Driver)this.inventory.getDriversList().get(driver)).getFavAreas().get(favArea)) && ((Driver)this.inventory.getDriversList().get(driver)).getPersonInfo().getCurrentStatus().equals(this.status)) {
                    ((Driver)this.inventory.getDriversList().get(driver)).setAvailbleRide(r);
                    ((Driver)this.inventory.getDriversList().get(driver)).mkNotified();
                    suitableDriver.add((Driver)this.inventory.getDriversList().get(driver));
                }
            }
        }

        return suitableDriver;
    }

    public ArrayList<Ride> allFavRide(String driverFavArea) {
        ArrayList<Ride> r = new ArrayList();

        for(int req = 0; req < this.inventory.getRideRequest().size(); ++req) {
            if (((Ride)this.inventory.getRideRequest().get(req)).getDestination() == driverFavArea) {
                r.add((Ride)this.inventory.getRideRequest().get(req));
            }
        }

        return r;
    }
}
