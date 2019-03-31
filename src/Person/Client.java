package Person;

import ContactData.ContactInformation;

public class Client extends Work {
    private String company;
    private String position;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void showPerson() {
        System.out.println(position + " at "+company);
        super.showPerson();
    }

    public Client(String name, String surname, String birthday, ContactInformation contactInformation, String workplace, String company, String position) {
        super(name, surname, birthday, contactInformation, workplace);
        this.company = company;
        this.position = position;
    }
}
