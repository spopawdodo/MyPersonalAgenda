package Person;

import ContactData.ContactInformation;

import java.util.Objects;

import static constants.ConstantValues.defaultData;

public class Work extends Person {
    // CLASSBoss Merged with ClassColleague
    // Class Work No Longer Abstract
    protected String workplace;
    protected String position;

    /// POSITION

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /// WOKRPLACE

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    /// CONSTRUCTORS
    public Work(){
        super();
        this.workplace= "-";
        this.position = "-";
    }

    public Work(String name, String surname, String birthday, ContactInformation contactInformation, String workplace, String position) {
        super(name, surname, birthday, contactInformation);
        this.workplace = workplace;
        this.position = position;
    }

    public Work(String name, String surname, String birthday, String workplace, String position) {
        super(name, surname, birthday, defaultData);
        this.workplace = workplace;
        this.position = position;
    }

    //// TO STRING, SHOW

    @Override
    public void showPerson() {
        System.out.println(workplace);
        super.showPerson();
    }

    @Override
    public String toString() {
        return super.toString() + "Work{" +
                "workplace='" + workplace + '\'' +
                ", position='" + position + '\'' +
                '}' + "\n";
    }


    /// EQUALS, HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;
        if (!super.equals(o)) return false;
        Work work = (Work) o;
        return getWorkplace().equals(work.getWorkplace()) &&
                getPosition().equals(work.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWorkplace(), getPosition());
    }
}
