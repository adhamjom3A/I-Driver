package company;

public class RideRequest {
    private String Source;
    private String Destination;
    private User user;

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String notification(Driver driver)
    {
        return "there's a ride";
    }
}
