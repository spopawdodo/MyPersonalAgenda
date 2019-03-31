package Person;

import ContactData.ContactInformation;

public class Colleague extends Work{
    String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Colleague(String name, String surname, String birthday, ContactInformation contactInformation, String workplace, String position) {
        super(name, surname, birthday, contactInformation, workplace);
        this.position = position;
    }

    @Override
    public void showPerson() {
        System.out.println(position +" at "+this.getWorkplace());
        super.showPerson();
    }
}
