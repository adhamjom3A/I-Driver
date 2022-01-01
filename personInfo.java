//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.regex.Pattern;

public class personInfo {
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String role;
    private Status currentStatus;
    private storage l = new storage();

    public personInfo() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userN) {
        this.userName = userN;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (this.isValidPassword(password)) {
            this.password = password;
        } else {
            System.out.println("Sorry!your password try another password");
        }

    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public boolean isValidUserName(String s) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
        return s.matches(String.valueOf(pattern)) && s.length() > 3 && s.length() < 15 && this.isUniqueUser(s);
    }

    public boolean isUniqueUser(String s) {
        for(int i = 0; i < this.l.getUsersList().size(); ++i) {
            if (s == ((User)this.l.getUsersList().get(i)).getPersonInfo().getUserName()) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidPassword(String password) {
        boolean isValid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[@,#,$,%].*$)";
        return password.length() <= 15 && password.length() >= 8 && password.matches(upperCaseChars) && password.matches(lowerCaseChars) && password.matches(numbers) && password.matches(specialChars) && this.isUniquePassword(password);
    }

    public boolean isUniquePassword(String p) {
        for(int i = 0; i < this.l.getUsersList().size(); ++i) {
            if (p == ((User)this.l.getUsersList().get(i)).getPersonInfo().getPassword()) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidPhoneNum(String pnum) {
        return pnum.length() == 11 && pnum.charAt(0) == '0' && pnum.charAt(1) == '1';
    }

    public boolean isValidEmail(String email) {
        return email.contains("@") && this.isUniqueEmail(email) && email.contains(".com");
    }

    public boolean isUniqueEmail(String E) {
        for(int i = 0; i < this.l.getUsersList().size(); ++i) {
            if (E == ((User)this.l.getUsersList().get(i)).getPersonInfo().getEmail()) {
                return false;
            }
        }

        return true;
    }

    public boolean ExistNameUser(String e) {
        for(int i = 0; i < this.l.getUsersList().size(); ++i) {
            if (((User)this.l.getUsersList().get(i)).getPersonInfo().getUserName().equals(e)) {
                return true;
            }
        }

        return false;
    }

    public boolean ExistNameDriver(String e) {
        for(int i = 0; i < this.l.getDriversList().size(); ++i) {
            if (((Driver)this.l.getDriversList().get(i)).getPersonInfo().getUserName().equals(e)) {
                return true;
            }
        }

        return false;
    }

    public boolean ExistPasswordUser(String p) {
        for(int i = 0; i < this.l.getUsersList().size(); ++i) {
            if (((User)this.l.getUsersList().get(i)).getPersonInfo().getPassword().equals(p)) {
                return true;
            }
        }

        return false;
    }

    public boolean ExistPasswordDriver(String p) {
        for(int i = 0; i < this.l.getDriversList().size(); ++i) {
            if (((Driver)this.l.getDriversList().get(i)).getPersonInfo().getPassword().equals(p)) {
                return true;
            }
        }

        return false;
    }
}
