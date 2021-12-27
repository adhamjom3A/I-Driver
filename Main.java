package company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase memory = DataBase.getInstance();
        Admin admin = new Admin();
        Person person = new Person();
        User user=new User();
        Driver driver=new company.Driver();
        Ride ride=new Ride();
        RideOperations rideOperations = new RideOperations();
        Scanner in = new Scanner(System.in);
        while (true) {
            personInfo personInformation=new personInfo();
            System.out.println("Hello, Log in OR signUP First!");
            System.out.println("1- SignUP  OR 2- LogIn OR 3- exit ");
            String firstStep = in.nextLine();
            if (firstStep.equals("1")) {
                System.out.println("Please fill your information");
                System.out.println("Your name: ");
                String n = in.nextLine();
                while(!personInformation.isValidUserName(n)){
                    System.out.println("please re enter your name ");
                    n = in.nextLine();
                }
                personInformation.setUserName(n);
                System.out.println("Your phone Number: ");
                String phone = in.nextLine();
                while(!personInformation.isValidPhoneNum(phone)){
                    System.out.println("please re enter your num ");
                    phone = in.nextLine();
                }
                personInformation.setPhoneNumber(phone);
                System.out.println("Your email (optional)");
                String email = in.nextLine();
                while(!personInformation.isValidEmail(email)){
                    System.out.println("please re enter your email ");
                    email = in.nextLine();
                }
                personInformation.setEmail(email);
                System.out.println("Your Password: ");
                String password = in.nextLine();
                while(!personInformation.isValidPassword(password)){
                    System.out.println("please re enter your password ");
                    password= in.nextLine();
                }
                personInformation.setPassword(password);
                System.out.println("Choose your role User/Driver");
                String rol = in.nextLine();
                personInformation.setRole(rol);
                if (rol.equalsIgnoreCase("user")){
                    User newUser =new User();
                    newUser.regist(personInformation);
                    memory.addUser(newUser);
                    userOperation(newUser,rideOperations,memory);

                }
                else if (rol.equalsIgnoreCase("driver")) {
                    Driver newDriver=new Driver();
                    newDriver.regist(personInformation);
                    System.out.println("Please enter he national id, license number");
                    String id=in.nextLine();
                    String licenseNum=in.nextLine();
                    newDriver.setNationalId(id);
                    newDriver.setDriverLicenseNumber(licenseNum);
                    Status s=Status.PENDING;
                    newDriver.setStatus(s);
                    memory.addPendingDrivers(newDriver);
                    //System.out.println(memory.driversList.size());
                    driverOperation(newDriver,rideOperations,memory);
                }
                else {
                    System.out.println("Please choose correct Role!");
                }
            }
            else if (firstStep.equals("2")) {
                System.out.println("Please enter the role");
                String role = in.nextLine();

                System.out.println("Please enter the user name");
                String userName = in.nextLine();
                if (role.equalsIgnoreCase("user")) {
                    while(!personInformation.ExistNameUser(userName)){
                        System.out.println("PLease, Enter Your correct name!");
                         userName = in.nextLine();
                    }
                   if (personInformation.ExistNameUser(userName)) {
                       System.out.println("Please enter the password");
                       String password = in.nextLine();
                       while (!personInformation.ExistPasswordUser(password)) {
                           System.out.println("please, Enter your correct password!");
                           password = in.nextLine();
                       }
                           User userSignedIn = userSignIn(userName, password, memory);
                           userOperation(userSignedIn, rideOperations, memory);
                   }
                }
                else if (role.equalsIgnoreCase("driver")) {
                    while(!personInformation.ExistNameDriver(userName)){
                        System.out.println("PLease, Enter Your correct name!");
                        userName = in.nextLine();
                    }if(personInformation.ExistNameDriver(userName)){
                        System.out.println("Please enter the password");
                        String password = in.nextLine();
                        while (!personInformation.ExistPasswordDriver(password)) {
                            System.out.println("please, Enter your correct password!");
                            password = in.nextLine();
                        }
                            Driver driverSignedIn = driverSignIn(userName, password, memory);
                            Status s = Status.ACTIVE;
                            driverSignedIn.setStatus(s);
                            driverOperation(driverSignedIn,rideOperations,memory);
                    }
                }
                else if (role.equalsIgnoreCase("Admin")){
                    Boolean flag = true;
                    /*System.out.println("PLease, Enter Your user name!");
                    userName = in.nextLine();*/
                    if(!(userName.equalsIgnoreCase(admin.getUserName())))
                    {
                        System.out.println("wrong admin userName");
                        flag=false;
                    }
                    System.out.println("Enter Your password!");
                    String password = in.nextLine();
                    if(!(password.equalsIgnoreCase(admin.getPassword())))
                    {
                        System.out.println("wrong admin password");
                        flag=false;
                    }
                    if(flag){
                        while(true)
                        {
                            System.out.println("1-list all drivers 2- users 3- list all pending Drivers 4- back to the main menu ");
                            String choice = in.nextLine();
                            if(choice.equals("1"))
                            {
                                admin.listDriver();
                            }
                            else if (choice.equals("2"))
                            {
                                admin.listUsers();
                            }
                            else if (choice.equals("3"))
                            {
                                admin.listPendingDrivers();
                            }
                            else if( choice.equals("4")) {
                                break;
                            }
                        }
                    }


                    }
                }

                else if (firstStep.equals("3")){
                break;
            }
            else {
                System.out.println("Please choose one of the perv Actions ");
            }
        }
    }
    public static void userOperation(User newUser,RideOperations rideOperat, DataBase m){
        System.out.println("Please Enter your source and destination");
        Scanner input = new Scanner(System.in);
        String source = input.nextLine();
        String destination = input.nextLine();
        Ride selectedRide = new Ride();
        selectedRide = newUser.Request(source,destination);
        m.RideRequest.add(selectedRide);
        //System.out.println("stored successfully");
        ArrayList<Driver> suitableDriverToRide = new ArrayList<Driver>();
        suitableDriverToRide = rideOperat.assignDriverToRide(selectedRide);
        // System.out.println(suitableDriverToRide.size());
        for (int i=0; i<suitableDriverToRide.size();i++){
            // System.out.println("stored successfully");
            suitableDriverToRide.get(i).mkOffer(selectedRide);
            if (newUser.acceptOffer(suitableDriverToRide.get(i))){
                Ride compelteRide =suitableDriverToRide.get(i).getAvailbleRide();
                compelteRide.setDriver(suitableDriverToRide.get(i));
                m.addCompRide(compelteRide);
                //compelteRide.ShowRideDetails();
                System.out.println("Please rate this driver");
                int rate=input.nextInt();
                newUser.setDriverRate(suitableDriverToRide.get(i),rate,compelteRide);
                break;
            }
        }

    }
    public static void driverOperation(Driver driver,RideOperations rideOperat, DataBase memory){
        System.out.println("1-Add fav area 2-show your rates 3-Show Rides with fav area");
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        in.nextLine();
        if (n==1){
        System.out.println("please enter the fav area");
        String favArea=in.nextLine();
        driver.addFavAreas(favArea);
        System.out.println("fav area added successfully, add another? y,n");
        String choice=in.nextLine();
        while(choice.equalsIgnoreCase("y")){
            System.out.println("enter the another Area");
            favArea = in.nextLine();
            driver.addFavAreas(favArea);
            System.out.println("continue?");
            choice=in.nextLine();
        }
        }
     else if (n==2){
            System.out.println("your rates are "+ driver.getRates());
        }
     else if (n==3){
            System.out.println("Please driver, enter your fav area");
            String fvArea = in.next();
            System.out.println(rideOperat.allFavRide(fvArea));
        }
    }
    public static User userSignIn(String userName,String passWord,DataBase memory){
        User tempUser=new User();
        for (int user=0; user<memory.usersList.size(); user++){
            personInfo userInfo=memory.usersList.get(user).getPersonInfo();
            if(userInfo.getUserName()==userName&&userInfo.getPassword()==passWord){
                tempUser=memory.usersList.get(user);
            }
        }
        return tempUser;
    }
    public static Driver driverSignIn(String driverName,String passWord,DataBase memory){
        Driver tempDriver=new Driver();
        for (int driver=0; driver<memory.driversList.size(); driver++){
            personInfo driverInfo=memory.driversList.get(driver).getPersonInfo();
            if(driverInfo.getUserName()==driverName&&driverInfo.getPassword()==passWord){
                tempDriver=memory.driversList.get(driver);
            }
        }
        return tempDriver;
    }

}

