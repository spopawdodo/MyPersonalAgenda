package Person;

import ContactData.ContactInformation;

public class Work extends Person {
    // CLASS Boss Merged with Class Colleague
    // Class Work No Longer Abstract
    protected String workplace;
    protected String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Work(String name, String surname, String birthday, ContactInformation contactInformation, String workplace, String position) {
        super(name, surname, birthday, contactInformation);
        this.workplace = workplace;
        this.position = position;
    }

    @Override
    public void showPerson() {
        System.out.println(workplace);
        super.showPerson();
    }
}
