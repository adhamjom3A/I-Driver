package company;
import java.lang.String;
public  class Person implements Regist {
    private personInfo personInfo;

    public personInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(company.personInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Boolean isValid(personInfo personInfo) {
        if (personInfo.getUserName().contains()){

        }
)
        if (!personInfo.getEmail().contains("@")) {
            System.out.println("invalid email");
            return false;
        } else {
            return true;
        }
    }

}



