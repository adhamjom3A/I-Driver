package company;


import java.util.regex.Pattern;

enum Status {SUSPENDED,PENDING,ACTIVE,NOTACTIVE}
public class personInfo {
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String role;
    private Status currentStatus;
    private DataBase l = DataBase.getInstance();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userN) {
        this.userName = userN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        phoneNumber = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isValidPassword(password))
            this.password = password;
        else
            System.out.println("Sorry!your password try another password");
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public boolean isValidUserName(String s) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
        if (s.matches(String.valueOf(pattern)) && (s.length() > 3 && s.length() < 15) && isUniqueUser(s)) {
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

    public boolean isValidPassword(String password) {
        boolean isValid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[@,#,$,%].*$)";
        if ((password.length() > 15 || password.length() < 8) || (!password.matches(upperCaseChars))
                || (!password.matches(lowerCaseChars)) || !password.matches(numbers)
                || !password.matches(specialChars) || !isUniquePassword(password)) {
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

    public boolean isValidPhoneNum(String pnum) {
        if (pnum.length() == 11 && pnum.charAt(0) == '0' && pnum.charAt(1) == '1')
            return true;
        return false;
    }

    public boolean isValidEmail(String email) {
        if (email.contains("@") && isUniqueEmail(email) && email.contains(".com")) {
            return true;
        }
        return false;
    }

    public boolean isUniqueEmail(String E) {
        for (int i = 0; i < l.usersList.size(); i++) {
            if (E == l.usersList.get(i).getPersonInfo().getEmail())
                return false;
        }
        return true;
    }
    public boolean ExistNameUser(String e) {
        for (int i = 0; i < l.usersList.size(); i++) {
            if (l.usersList.get(i).getPersonInfo().getUserName().equals(e) )
                return true;
        }
        return false;
    }
    public boolean ExistNameDriver(String e) {
        for (int i = 0; i < l.driversList.size(); i++) {
            if (l.driversList.get(i).getPersonInfo().getUserName().equals(e) )
                return true;
        }
        return false;
    }
    public boolean ExistPasswordUser(String p) {
        for (int i = 0; i < l.usersList.size(); i++) {
            if (l.usersList.get(i).getPersonInfo().getPassword().equals(p)) {
                return true;
            }
        }
    return false;
    }
    public boolean ExistPasswordDriver (String p){
            for (int i = 0; i < l.driversList.size(); i++) {
                if (l.driversList.get(i).getPersonInfo().getPassword() .equals(p) )
                    return true;
            }
            return false;
        }
}
