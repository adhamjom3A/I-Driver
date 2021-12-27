package company;

public abstract interface Regist{
    public Boolean isValid(personInfo personInfo);

    public personInfo regist(String name, String phoneNum, String Email,String password, String role );
    public personInfo regist(String name, String phoneNum,String password, String role);
}
