package company;
import java.util.ArrayList;

public class arrayLists {
    private static arrayLists uniqueLists;
    private ArrayList<Driver> driversList;
    private ArrayList<User> usersList;
    private ArrayList<Ride> ridesList;
    private ArrayList<RideRequest> RideRequest;

    private static arrayLists getInstance(){
        if(uniqueLists==null) {
            uniqueLists=new arrayLists();
            return uniqueLists;

        }
        else {
            return uniqueLists;
        }
    }

    public void addDriver(Driver driver){
        driversList.add(driver);
    }
    public void addUser(User user){
        usersList.add(user);
    }
    public void addRide(Ride ride){
        ridesList.add(ride);
    }
    public void addRideRequest(User user, String Source, String Destination){
        RideRequest r= user.Request(Source,Destination);
        RideRequest.add(r);
    }

   public void assignDriverToRide(){
       for (int i = 0; i < this.RideRequest.size(); i++)
       {
           for (int j = 0; j < this.driversList.size(); j++) {
               for (int k = 0; k < this.driversList.get(j).getFavAreas().size(); k++) {

                   if (this.RideRequest.get(i).getDestination() == this.driversList.get(j).getFavAreas().get(k)
                           &&(this.driversList.get(j).getPersonInfo().getCurrentStatus().equals("ACTIVE"))) {

                             this.RideRequest.get(i).notification(this.driversList.get(j));

                   }
               }
           }
       }
   }


    public ArrayList<Driver> getDriversList() {
        return driversList;
    }

    public void setDriversList(ArrayList<Driver> driversList) {
        this.driversList = driversList;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

   public ArrayList<Ride> getRidesList() {
        return ridesList;
    }

    public void setRidesList(ArrayList<Ride> ridesList) {
        this.ridesList = ridesList;
    }


    public ArrayList<company.RideRequest> getRideRequest() {
        return RideRequest;
    }

    public void setRideRequest(ArrayList<company.RideRequest> rideRequest) {
        RideRequest = rideRequest;
    }

    public void AddUser(User user) {
        usersList.add(user);
    }
}
