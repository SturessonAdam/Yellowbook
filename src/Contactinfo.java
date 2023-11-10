import java.util.ArrayList;
import java.util.List;

public class Contactinfo {
    private String firstname;
    private String surname;
    private int age;
    private Adress adress;
    private List<String> phonenumber;

    public Contactinfo(String firstname, String surname, int age, Adress adress, String PhonenumberOne, String PhonenumberTwo) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.adress = adress;
        this.phonenumber = new ArrayList<>();
        this.phonenumber.add(PhonenumberOne);
        this.phonenumber.add(PhonenumberTwo);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
    public void setPhonenumber(String phonenumber) {
        getPhonenumber().add(phonenumber);
    }

    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public Adress getAdress() {
        return adress;
    }
    public List<String> getPhonenumber() {
        return phonenumber;
    }

    @Override
    public String toString() {
        return "Contact - " + firstname + " " + surname +
                ", Age: " + age +
                ", " + adress +
                ", Phonenumber private/work: " + phonenumber;
    }
}
