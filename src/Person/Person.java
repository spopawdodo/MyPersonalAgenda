package Person;

import ContactData.ContactInformation;

import java.util.Objects;

import static constants.ConstantValues.defaultData;

public abstract class Person {
    protected String name;
    protected String surname;
    protected String birthday;
    protected ContactInformation contact;

    /// CONSTRUCTORS

    public Person(String name, String surname, String birthday, ContactInformation contactInformation) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.contact = contactInformation;
    }

    public Person(String name, String surname, String birthday) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.contact = defaultData;
    }

    public Person(){
        this.name = "-";
        this.surname = "-";
        this.birthday = "-";
        this.contact = defaultData;
    }

    /// NAME

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ///SURNAME

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    ///BIRTHDAY

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    ///CONTACT INFORMATION

    public ContactInformation getContact() {
        return contact;
    }

    public void setContact(String cellphoneNumber, String homeNumber, String mailAdress){
        this.contact.setContactInformation(cellphoneNumber, homeNumber, mailAdress);
    }

    public void setContact(ContactInformation contact) {
        this.contact = contact;
    }

    //// SHOW, TOSTRING

    public void showPerson(){
        System.out.println("Name : "+name+ " "+surname+
                "\nBirthday : "+birthday+ "\n");

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    //// EQUALS, HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) &&
                getSurname().equals(person.getSurname()) &&
                getBirthday().equals(person.getBirthday()) &&
                getContact().equals(person.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthday(), getContact());
    }
}
