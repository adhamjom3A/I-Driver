package company;
import java.lang.String;
import java.util.regex.Pattern;

public  class Person implements Regist {
    private personInfo personInfo;
    private arrayLists l;

    public personInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(company.personInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Boolean isValid(personInfo personInfo) {
        return  (isValidUserName(personInfo.getUserName())&&personInfo.getEmail().contains("@")
                &&isValidPassword(personInfo.getPassword())
                &&isValidPhoneNum(personInfo.getPhoneNumber()));
    }

    ////check username
    public boolean isValidUserName(String s) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
        if (s.matches(String.valueOf(pattern)) && (s.length() > 3 && s.length() < 15)&&isUniqueUser(s)) {
            return true;
        }
        return false;
    }

    public boolean isUniqueUser(String s) {
        for (int i = 0; i < l.usersList.size(); i++) {
            if (s == l.usersList.get(i).getPersonInfo().getUserName())
                return false;
        }
        return true;
    }
    ///check Password
    public  boolean isValidPassword(String password)
            {
                boolean isValid = true;
                String upperCaseChars = "(.*[A-Z].*)";
                String lowerCaseChars = "(.*[a-z].*)";
                String numbers = "(.*[0-9].*)";
                String specialChars = "(.*[@,#,$,%].*$)";
                if ((password.length() > 15 || password.length() < 8)||(!password.matches(upperCaseChars ))
                    ||(!password.matches(lowerCaseChars ))||!password.matches(numbers )
                    ||!password.matches(specialChars ) ||!isUniquePassword(password)) {
                    return false;
                }
                return true;
            }
    public boolean isUniquePassword(String p) {
        for (int i = 0; i < l.usersList.size(); i++) {
            if (p == l.usersList.get(i).getPersonInfo().getPassword())
                return false;
        }
        return true;
    }
    //check phonenumber
    public boolean isValidPhoneNum(String pnum){
        if (pnum.length()==14&& pnum.charAt(0)=='0'&& pnum.charAt(1)=='1')
            return true;
        return false;
    }
}
