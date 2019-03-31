package Person;

import ContactData.ContactInformation;
import DateType.Date;

public class FamilyMember extends Person {
    String typeOfRelative;

    public String getTypeOfRelative() {
        return typeOfRelative;
    }

    public void setTypeOfRelative(String typeOfRelative) {
        this.typeOfRelative = typeOfRelative;
    }

    public FamilyMember(String name,
                        String surname,
                        Date birthday,
                        ContactInformation contact,
                        String typeOfRelative) {

        super (name, surname, birthday, contact);
        this.typeOfRelative = typeOfRelative;
    }
}
