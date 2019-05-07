package Person;

import ContactData.ContactInformation;

public abstract class Person {
    protected String name;
    protected String surname;
    protected String birthday;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ContactInformation getContact() {
        return contact;
    }
    public void showPerson(){
        System.out.println("Name : "+name+ " "+surname+
                "\nBirthday : "+birthday+ "\n");

    }
    public void setContact(String cellphoneNumber, String homeNumber, String mailAdress){
        this.contact.setContactInformation(cellphoneNumber, homeNumber, mailAdress);
    }

    public void setContact(ContactInformation contact) {
        this.contact = contact;
    }

    public Person(String name, String surname, String birthday, ContactInformation contactInformation) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.contact = contactInformation;
    }
}
