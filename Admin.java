//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.Scanner;

public class Admin {
    storage array = new storage();
    private String userName = "admin";
    private String password = "admin";

    public Admin() {
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void suspend(Person person) {
        person.getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
    }

    public void listUsers() {
        for(int i = 0; i < this.array.getUsersList().size(); ++i) {
            System.out.println(this.array.getUsersList().get(i));
            System.out.println("do you want to susbend this user? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if (s.equalsIgnoreCase("y")) {
                ((User)this.array.getUsersList().get(i)).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
            }
        }

    }

    public void listDriver() {
        for(int i = 0; i < this.array.getDriversList().size(); ++i) {
            System.out.println(this.array.getDriversList().get(i));
            System.out.println("do you want to susbend this driver? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if (s.equalsIgnoreCase("y")) {
                ((Driver)this.array.getDriversList().get(i)).getPersonInfo().setCurrentStatus(Status.valueOf("SUSPENDED"));
            }
        }

    }

    public void listPendingDrivers() {
        for(int i = 0; i < this.array.getPendingDrivers().size(); ++i) {
            System.out.println("pending drivers  : " + this.array.getPendingDrivers().get(i) + "\n Do you want to accept this driver? y/n");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if (s.equals("y")) {
                ((Driver)this.array.getPendingDrivers().get(i)).setStatus(Status.ACTIVE);
                this.array.addDriver((Driver)this.array.getPendingDrivers().get(i));
                this.array.getPendingDrivers().remove(i);
            } else if (s.equals("n")) {
                this.array.getPendingDrivers().remove(i);
            }
        }

    }

    public void approveDriver(Driver driver) {
        this.array.addDriver(driver);
        this.array.getPendingDrivers().remove(driver);
        driver.setStatus(Status.ACTIVE);
    }
}
