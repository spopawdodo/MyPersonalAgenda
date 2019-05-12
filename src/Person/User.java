package Person;

import ContactData.ContactInformation;

import java.util.Objects;

public class User extends Person {
    private String address;

    // CONSTRUCTORS

    public User(){
        super();
        this.address = "-";
    }

    public User (String name, String surname, String birthday, ContactInformation contact, String address){
        super (name, surname, birthday, contact);
        this.address = address;
    }

    // ADDRESS

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /// SHOW , TOSTRING
    @Override
    public void showPerson() {
        super.showPerson();
        System.out.println("Address : "+this.address);
    }

    @Override
    public String toString() {
        return super.toString() +  "User{" +
                "address='" + address + '\'' +
                '}' + '\n';
    }


    ///EQUALS, HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getAddress().equals(user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAddress());
    }
}
