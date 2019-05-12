package Person;

import ContactData.ContactInformation;

import java.util.Objects;

public class Client extends Work {
    private String company;
    //COMPANY
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    ///SHOW, TOSTRING
    @Override
    public void showPerson() {
        System.out.println(position + " at "+company);
        super.showPerson();
    }

    @Override
    public String toString() {
        return super.toString() + "Client{" +
                "company='" + company + '\'' +
                '}' + '\n';
    }

    /// CONSTRUCTOR
    public Client(String name, String surname, String birthday, ContactInformation contactInformation, String workplace, String company, String position) {
        super(name, surname, birthday, contactInformation, workplace, position);
        this.company = company;
    }

    public Client(){
        super();
        this.company="-";
    }

    ///EQUALS AND HASHCODE


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return getCompany().equals(client.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCompany());
    }
}
