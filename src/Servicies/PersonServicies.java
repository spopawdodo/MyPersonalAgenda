package Servicies;

import Person.Person;

public class PersonServicies {
    public void showPerson(Person person){
        System.out.println("Nume : "+person.getName()+
                           "\nPrenume : "+person.getSurname()+
                            "\nBirthday : "+person.getBirthday().getDate()+
                            "\nContact Information :\nCellPhone Number : " +person.getContact().getCellphoneNumber() + "\n");

    }
}
