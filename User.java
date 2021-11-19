package company;

public class User extends Person {
    private String Source;
    private  String Destination;


    public Boolean isValid(personInfo personInfo){
        super.isValid(personInfo);
        personInfo.setCurrentStatus(Status.valueOf("Active"));
        return true;
    }

    public RideRequest Request(String source, String destination){
        RideRequest r=new RideRequest();
        r.setDestination(destination);
        r.setSource(source);
        r.setUser(this);
        return r;
    }
}