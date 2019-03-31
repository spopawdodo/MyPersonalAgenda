package Person;

import ContactData.ContactInformation;
import DateType.Date;

public class User extends Person {
    String adress;
    public User (String name, String surname, Date birthday, ContactInformation contact, String adress){
        super (name, surname, birthday, contact);
        this.adress = adress;
    }

}
