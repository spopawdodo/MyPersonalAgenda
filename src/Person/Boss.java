package Person;

import ContactData.ContactInformation;

public class Boss extends Work {
    String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boss(String name, String surname, String birthday, ContactInformation contactInformation, String workplace, String position) {
        super(name, surname, birthday, contactInformation, workplace);
        this.position = position;
    }

    @Override
    public void showPerson() {
        System.out.print(position +" ");
        super.showPerson();
    }
}
