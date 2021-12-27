package company;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    RideOperations rideOperations;
    DataBase array=DataBase.getInstance();
    private String userName="admin";
    private String password="admin";
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public void addDiscountAreas(String area)
    {
        array.addAdminDiscountAreas(area);
    }
    public void suspend(Person person){
        person.getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));}
        public void listUsers() {
            for (int i = 0; i  < array.getUsersList().size(); i++) {
                System.out.println(array.getUsersList().get(i));
                System.out.println("do you want to susbend this user? y/n");
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();
                if(s.equalsIgnoreCase("y"))
                {
                    array.getUsersList().get(i).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
                }
                //else  {continue;}
            }


        }
    public void listDriver() {
        for (int i = 0; i < array.getDriversList().size(); i++) {
            System.out.println(array.getDriversList().get(i));
            System.out.println("do you want to susbend this driver? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if(s.equalsIgnoreCase("y"))
            {
                array.getDriversList().get(i).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
            }
            //else  {continue;}
        }
    }
    public void listPendingDrivers(){
        for (int i = 0; i < array.pendingDrivers.size(); i++) {
            System.out.println("pending drivers  : " + array.pendingDrivers.get(i) + "\n Do you want to accept this driver? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if(s.equals("y"))
            {
                array.pendingDrivers.get(i).setStatus(Status.ACTIVE);
                array.addDriver(array.pendingDrivers.get(i));
                array.pendingDrivers.remove(i);
            }
            else if(s.equals("n")) { array.pendingDrivers.remove(i);}

        }
    }
    public void approveDriver(Driver driver )
    {
        array.addDriver(driver);
        array.pendingDrivers.remove(driver);
        driver.setStatus(Status.ACTIVE);
    }
    public void getEvents(Ride ride){
        rideOperations.showRideEvents(ride);
    }
}
