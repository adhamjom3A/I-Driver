package company;


import java.util.ArrayList;

public class Driver extends Person {
    private String nationalId;
    private String driverLicenseNumber;
    private ArrayList<String> favAreas;
    private ArrayList<Integer> rates;

    public Boolean isValid(personInfo personInfo,String nationalId,String driverLicenseNumber){
        super.isValid(personInfo);

        personInfo.setCurrentStatus(Status.valueOf("Pending"));
        return true;
    }

    public void addFavAreas(String area)
    {
        favAreas.add(area);
    }
    public String getNationalId() {
        return nationalId;
    }
    public int searchArea(String Area)
    {
        for (int i = 0; i < this.getFavAreas().size(); i++) {
            if(this.getFavAreas().get(i)==Area)
            {
                return i;
            }
        }
        return -1;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public ArrayList<String> getFavAreas() {
        return favAreas;
    }

    public void setFavAreas(ArrayList<String> favAreas) {
        this.favAreas = favAreas;
    }

    public ArrayList<Integer> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Integer> rates) {
        this.rates = rates;
    }
}
