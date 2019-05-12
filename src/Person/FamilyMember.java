package Person;

import ContactData.ContactInformation;

import java.util.Objects;

import static constants.ConstantValues.defaultData;

public class FamilyMember extends Person {
    private String typeOfRelative;


    /// TYPE OF RELATIVE
    public String getTypeOfRelative() {
        return typeOfRelative;
    }

    public void setTypeOfRelative(String typeOfRelative) {
        this.typeOfRelative = typeOfRelative;
    }

    /// CONSTRUCTOR

    public FamilyMember(){
        super();
        this.typeOfRelative = "-";
    }

    public FamilyMember(String name,
                        String surname,
                        String birthday,
                        ContactInformation contact,
                        String typeOfRelative) {

        super (name, surname, birthday, contact);
        this.typeOfRelative = typeOfRelative;
    }

    public FamilyMember(String name,
                        String surname,
                        String birthday,
                        String typeOfRelative) {

        super (name, surname, birthday, defaultData);
        this.typeOfRelative = typeOfRelative;
    }

    /// TO STRING , SHOW

    @Override
    public void showPerson() {
        System.out.println(typeOfRelative);
        super.showPerson();

    }

    @Override
    public String toString() {
        return super.toString() + "FamilyMember{" +
                "typeOfRelative='" + typeOfRelative + '\'' +
                '}' + '\n';
    }

    /// EQUALS, HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyMember)) return false;
        if (!super.equals(o)) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(getTypeOfRelative(), that.getTypeOfRelative());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTypeOfRelative());
    }
}
