//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        storage memory = new storage();
        Admin admin = new Admin();
        new Person();
        new User();
        new Driver();
        new Ride();
        RideOperations rideOperations = new RideOperations();
        Scanner in = new Scanner(System.in);

        while(true) {
            label118:
            while(true) {
                personInfo personInformation = new personInfo();
                System.out.println("Hello, Log in OR signUP First!");
                System.out.println("1- SignUP  OR 2- LogIn OR 3- exit ");
                String firstStep = in.nextLine();
                String role;
                String userName;
                String password;
                String choice;
                String password;
                if (firstStep.equals("1")) {
                    System.out.println("Please fill your information");
                    System.out.println("Your name: ");

                    for(role = in.nextLine(); !personInformation.isValidUserName(role); role = in.nextLine()) {
                        System.out.println("please re enter your name ");
                    }

                    personInformation.setUserName(role);
                    System.out.println("Your phone Number: ");

                    for(userName = in.nextLine(); !personInformation.isValidPhoneNum(userName); userName = in.nextLine()) {
                        System.out.println("please re enter your num ");
                    }

                    personInformation.setPhoneNumber(userName);
                    System.out.println("Your email (optional)");

                    for(password = in.nextLine(); !personInformation.isValidEmail(password); password = in.nextLine()) {
                        System.out.println("please re enter your email ");
                    }

                    personInformation.setEmail(password);
                    System.out.println("Your Password: ");

                    for(password = in.nextLine(); !personInformation.isValidPassword(password); password = in.nextLine()) {
                        System.out.println("please re enter your password ");
                    }

                    personInformation.setPassword(password);
                    System.out.println("Choose your role User/Driver");
                    choice = in.nextLine();
                    personInformation.setRole(choice);
                    if (choice.equalsIgnoreCase("user")) {
                        User newUser = new User();
                        newUser.regist(personInformation);
                        memory.addUser(newUser);
                        userOperation(newUser, rideOperations, memory);
                    } else if (choice.equalsIgnoreCase("driver")) {
                        Driver newDriver = new Driver();
                        newDriver.regist(personInformation);
                        System.out.println("Please enter he national id, license number");
                        String id = in.nextLine();
                        String licenseNum = in.nextLine();
                        newDriver.setNationalId(id);
                        newDriver.setDriverLicenseNumber(licenseNum);
                        Status s = Status.PENDING;
                        newDriver.setStatus(s);
                        memory.addPendingDrivers(newDriver);
                        driverOperation(newDriver, rideOperations, memory);
                    } else {
                        System.out.println("Please choose correct Role!");
                    }
                } else if (!firstStep.equals("2")) {
                    if (firstStep.equals("3")) {
                        return;
                    }

                    System.out.println("Please choose one of the perv Actions ");
                } else {
                    System.out.println("Please enter the role");
                    role = in.nextLine();
                    System.out.println("Please enter the user name");
                    userName = in.nextLine();
                    if (role.equalsIgnoreCase("user")) {
                        while(!personInformation.ExistNameUser(userName)) {
                            System.out.println("PLease, Enter Your correct name!");
                            userName = in.nextLine();
                        }

                        if (personInformation.ExistNameUser(userName)) {
                            System.out.println("Please enter the password");

                            for(password = in.nextLine(); !personInformation.ExistPasswordUser(password); password = in.nextLine()) {
                                System.out.println("please, Enter your correct password!");
                            }

                            User userSignedIn = userSignIn(userName, password, memory);
                            userOperation(userSignedIn, rideOperations, memory);
                        }
                    } else if (role.equalsIgnoreCase("driver")) {
                        while(!personInformation.ExistNameDriver(userName)) {
                            System.out.println("PLease, Enter Your correct name!");
                            userName = in.nextLine();
                        }

                        if (personInformation.ExistNameDriver(userName)) {
                            System.out.println("Please enter the password");

                            for(password = in.nextLine(); !personInformation.ExistPasswordDriver(password); password = in.nextLine()) {
                                System.out.println("please, Enter your correct password!");
                            }

                            Driver driverSignedIn = driverSignIn(userName, password, memory);
                            Status s = Status.ACTIVE;
                            driverSignedIn.setStatus(s);
                            driverOperation(driverSignedIn, rideOperations, memory);
                        }
                    } else if (role.equalsIgnoreCase("Admin")) {
                        Boolean flag = true;
                        if (!userName.equalsIgnoreCase(admin.getUserName())) {
                            System.out.println("wrong admin userName");
                            flag = false;
                        }

                        System.out.println("Enter Your password!");
                        password = in.nextLine();
                        if (!password.equalsIgnoreCase(admin.getPassword())) {
                            System.out.println("wrong admin password");
                            flag = false;
                        }

                        if (flag) {
                            while(true) {
                                while(true) {
                                    System.out.println("1-list all drivers 2- users 3- list all pending Drivers 4- back to the main menu ");
                                    choice = in.nextLine();
                                    if (choice.equals("1")) {
                                        admin.listDriver();
                                    } else if (choice.equals("2")) {
                                        admin.listUsers();
                                    } else if (choice.equals("3")) {
                                        admin.listPendingDrivers();
                                    } else if (choice.equals("4")) {
                                        continue label118;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void userOperation(User newUser, RideOperations rideOperat, storage m) {
        System.out.println("Please Enter your source and destination");
        Scanner input = new Scanner(System.in);
        String source = input.nextLine();
        String destination = input.nextLine();
        new Ride();
        Ride selectedRide = newUser.Request(source, destination);
        m.addRideRequest(selectedRide);
        new ArrayList();
        ArrayList<Driver> suitableDriverToRide = rideOperat.assignDriverToRide(selectedRide);

        for(int i = 0; i < suitableDriverToRide.size(); ++i) {
            ((Driver)suitableDriverToRide.get(i)).mkOffer();
            if (newUser.acceptOffer((Driver)suitableDriverToRide.get(i))) {
                Ride compelteRide = ((Driver)suitableDriverToRide.get(i)).getAvailbleRide();
                compelteRide.setDriver((Driver)suitableDriverToRide.get(i));
                m.addCompRide(compelteRide);
                System.out.println("Please rate this driver");
                int rate = input.nextInt();
                newUser.setDriverRate((Driver)suitableDriverToRide.get(i), rate, compelteRide);
                break;
            }
        }

    }

    public static void driverOperation(Driver driver, RideOperations rideOperat, storage memory) {
        System.out.println("1-Add fav area 2-show your rates 3-Show Rides with fav area");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String fvArea;
        if (n == 1) {
            System.out.println("please enter the fav area");
            fvArea = in.nextLine();
            driver.addFavAreas(fvArea);
            System.out.println("fav area added successfully, add another? y,n");

            for(String choice = in.nextLine(); choice.equalsIgnoreCase("y"); choice = in.nextLine()) {
                System.out.println("enter the another Area");
                fvArea = in.nextLine();
                driver.addFavAreas(fvArea);
                System.out.println("continue?");
            }
        } else if (n == 2) {
            System.out.println("your rates are " + driver.getRates());
        } else if (n == 3) {
            System.out.println("Please driver, enter your fav area");
            fvArea = in.next();
            System.out.println(rideOperat.allFavRide(fvArea));
        }

    }

    public static User userSignIn(String userName, String passWord, storage memory) {
        User tempUser = new User();

        for(int user = 0; user < memory.getUsersList().size(); ++user) {
            personInfo userInfo = ((User)memory.getUsersList().get(user)).getPersonInfo();
            if (userInfo.getUserName() == userName && userInfo.getPassword() == passWord) {
                tempUser = (User)memory.getUsersList().get(user);
            }
        }

        return tempUser;
    }

    public static Driver driverSignIn(String driverName, String passWord, storage memory) {
        Driver tempDriver = new Driver();

        for(int driver = 0; driver < memory.getDriversList().size(); ++driver) {
            personInfo driverInfo = ((Driver)memory.getDriversList().get(driver)).getPersonInfo();
            if (driverInfo.getUserName() == driverName && driverInfo.getPassword() == passWord) {
                tempDriver = (Driver)memory.getDriversList().get(driver);
            }
        }

        return tempDriver;
    }
}
