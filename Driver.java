//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Person {
    private String nationalId;
    private String driverLicenseNumber;
    private ArrayList<String> favAreas = new ArrayList();
    private ArrayList<Integer> rates = new ArrayList();
    private Ride availbleRide = new Ride();
    private boolean notified = false;

    public Driver() {
    }

    public Boolean isValid(personInfo personInfo, String nationalId, String driverLicenseNumber) {
        super.isValid(personInfo);
        personInfo.setCurrentStatus(Status.valueOf("Pending"));
        return true;
    }

    public void setAvailbleRide(Ride ride) {
        this.availbleRide = ride;
    }

    public Ride getAvailbleRide() {
        return this.availbleRide;
    }

    public void mkNotified() {
        this.notified = true;
    }

    public void addFavAreas(String area) {
        this.favAreas.add(area);
    }

    public String getNationalId() {
        return this.nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getDriverLicenseNumber() {
        return this.driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public ArrayList<String> getFavAreas() {
        return this.favAreas;
    }

    public ArrayList<Integer> getRates() {
        return this.rates;
    }

    public int getAvRate() {
        int sum = 0;

        for(int i = 0; i < this.rates.size(); ++i) {
            sum += (Integer)this.rates.get(i);
        }

        return sum / this.rates.size() + 1;
    }

    public void setDriverRate(int rate) {
        this.rates.add(rate);
    }

    public void mkOffer(int price) {
        this.availbleRide.setPrice(price);
    }

    public String toString() {
        String var10000 = this.getPersonInfo().getUserName();
        return "Driver name is " + var10000 + " Driver phone number " + this.getPersonInfo().getPhoneNumber();
    }
}
