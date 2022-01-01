//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

public class Person {
    private personInfo PersonInfor = new personInfo();

    public Person() {
    }

    public personInfo getPersonInfo() {
        return this.PersonInfor;
    }

    public void setPersonInfo(personInfo personInfo) {
        this.PersonInfor = personInfo;
    }

    public void isValid(personInfo personInfo) {
    }

    public void regist(personInfo p) {
        this.PersonInfor = p;
    }

    public void setStatus(Status s) {
        this.getPersonInfo().setCurrentStatus(s);
    }
}
