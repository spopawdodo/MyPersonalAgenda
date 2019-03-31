package Person;

import ContactData.ContactInformation;

public abstract class Work extends Person {
    private String workplace;

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Work(String name, String surname, String birthday, ContactInformation contactInformation, String workplace) {
        super(name, surname, birthday, contactInformation);
        this.workplace = workplace;

    }

    @Override
    public void showPerson() {
        System.out.println(workplace);
        super.showPerson();
    }
}
