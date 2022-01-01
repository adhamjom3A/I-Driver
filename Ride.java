//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.io.PrintStream;

public class Ride {
    private String Source;
    private String Destination;
    private User user;
    private Driver driver;
    private int price;
    private int Rate;

    public Ride() {
    }

    public void setPrice(int p) {
        this.price = p;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRate() {
        return this.Rate;
    }

    public void setRate(int rate) {
        this.Rate = rate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getSource() {
        return this.Source;
    }

    public void setSource(String source) {
        this.Source = source;
    }

    public String getDestination() {
        return this.Destination;
    }

    public void setDestination(String destination) {
        this.Destination = destination;
    }

    public void ShowRideDetails() {
        PrintStream var10000 = System.out;
        String var10001 = this.getSource();
        var10000.println("Ride Source is " + var10001 + "Ride Distenation is " + this.getDestination() + "the Ride requested by " + this.getUser().getPersonInfo().getUserName() + "with price " + this.getPrice() + "which is confirmed with Driver " + this.getDriver().getPersonInfo().getUserName());
    }

    public String toString() {
        String var10000 = this.Source;
        return "Source='" + var10000 + "', Destination='" + this.Destination + "', user=" + this.user.getPersonInfo().getUserName() + ", driver=" + this.driver.getPersonInfo().getUserName() + ", price=" + this.price + ", Rate=" + this.Rate + "}";
    }
}
