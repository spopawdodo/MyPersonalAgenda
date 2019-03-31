package Person;

import ContactData.ContactInformation;

public class User extends Person {
    private String adress;
    public User (String name, String surname, String birthday, ContactInformation contact, String adress){
        super (name, surname, birthday, contact);
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public void showPerson() {
        super.showPerson();
        System.out.println("Adress : "+this.adress);
    }
}
