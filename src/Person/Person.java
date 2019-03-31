package Person;

import ContactData.ContactInformation;
import DateType.Date;

public abstract class Person {
    protected String name;
    protected String surname;
    protected Date birthday;
    protected ContactInformation contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ContactInformation getContact() {
        return contact;
    }

    public void setContact(ContactInformation contact) {
        this.contact = contact;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Date birthday) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Date birthday, ContactInformation contactInformation) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.contact = contactInformation;
    }
}
