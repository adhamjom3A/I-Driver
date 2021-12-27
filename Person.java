package company;
import java.lang.String;
import java.util.regex.Pattern;

public  class Person {
    private personInfo PersonInfor=new personInfo();
    public personInfo getPersonInfo() {
        return PersonInfor;
    }
    public void setPersonInfo(personInfo personInfo) {
        this.PersonInfor = personInfo;
    }
    public void isValid(personInfo personInfo) {}
       /* return  (isValidUserName(personInfo.getUserName())&&personInfo.getEmail().contains("@")
                &&isValidPassword(personInfo.getPassword())
                &&isValidPhoneNum(personInfo.getPhoneNumber()));
    }*/


    public void regist(personInfo p) {
        PersonInfor=p;
    }
    public void setStatus(Status s){
        getPersonInfo().setCurrentStatus(s);
    }
}
