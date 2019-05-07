package Servicies;

import Agenda.Agenda;
import Person.Person;

import java.util.Arrays;
import java.util.Objects;

public class PersonServices {
    /**
     * Class with the services list for the contacts array
     * Add Person
     * Remove Person
     */
    public static void addPerson(Agenda agenda, Person person){
        int size = 0;
        if ( agenda.getContacts() != null){
             size = agenda.getContacts().length;
        }
        Person[] newContacts = new Person[size + 1];
        if ( size == 0){
            newContacts[0] = person;
        }
        else {
            for (int i = 0; i < size; i++)
                newContacts[i] = agenda.getContacts()[i];
            newContacts[size] = person;
        }
        agenda.setContacts(newContacts);

        AuditServices.writeAuditCsv("addPerson");


    }

    public static void removePerson(Agenda agenda, Person person)
    {
        int size = agenda.getContacts().length;
        Person[] newContacts = new Person[size - 1];
        int j = 0, i;
        for ( i = 0; i < size - 1; i++){
            if (!(Objects.equals(person.getName(), agenda.getContacts()[i].getName()) &&
                    Objects.equals(person.getSurname(), agenda.getContacts()[i].getSurname()))){
                newContacts[j] = agenda.getContacts()[i];
                j++;
            }
        }

        if (i == j){
            if (!(Objects.equals(person.getName(), agenda.getContacts()[size-1].getName()) &&
                    Objects.equals(person.getSurname(), agenda.getContacts()[size-1].getSurname())))
                System.out.println("Person not found !");
            else
                agenda.setContacts(newContacts);
        }
        else{
            newContacts[size-2] = agenda.getContacts()[size -1];
            agenda.setContacts(newContacts);
        }
        AuditServices.writeAuditCsv("removePerson");

    }

    public static void sortByName(Agenda agenda){
        int size = agenda.getContacts().length;
        Person[] newPerson = agenda.getContacts();
        Arrays.sort(newPerson, new SortByName());
        agenda.setContacts(newPerson);
        AuditServices.writeAuditCsv("sortByName");

    }
}
