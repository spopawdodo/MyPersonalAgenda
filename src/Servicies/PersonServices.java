package Servicies;

import Agenda.Agenda;
import Person.Person;
import Person.FamilyMember;
import Person.Work;


import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PersonServices {
    /**
     * Class with the services list for the contacts array
     * Add Person
     * Remove Person
     * Sort By Name
     */
    public static void addPerson(Agenda agenda, Person person){
        AuditServices.writeAuditCsv("addPerson");
        int size = 0;
        try{
             size = agenda.getContacts().length;
        }catch(NullPointerException e){
            System.out.println("Person array not found!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        Person[] newContacts = new Person[size + 1];
        if ( size == 0){
            newContacts[0] = person;
        }
        else {
            for (int i = 0; i < size; i++) {
                if ((Objects.equals(person.getName(), agenda.getContacts()[i].getName()) &&
                        Objects.equals(person.getSurname(), agenda.getContacts()[i].getSurname()))) {
                    System.out.println("Person already in array !");
                    return;
                }
                newContacts[i] = agenda.getContacts()[i];
            }
            newContacts[size] = person;
        }
        agenda.setContacts(newContacts);

    }

    public static void removePerson(Agenda agenda, Person person) {
        int size = 0;
        try{
            size = agenda.getContacts().length;
        }catch (NullPointerException e){
            System.out.println("Person Array not found!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (size == 0){
            System.out.println("Person Array is empty!");
            return;
        }
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
        Person[] newPerson;
        try{
            newPerson = agenda.getContacts();
        } catch (NullPointerException e){
            System.out.println("Contact List not found !");
            e.printStackTrace();
            return;
        } catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
            return;
        }
        if (newPerson.length == 0 )
        {
            System.out.println("No contacts to sort!");
        }
        Arrays.sort(newPerson, new SortByName());
        agenda.setContacts(newPerson);
        AuditServices.writeAuditCsv("sortByName");

    }

    /*
    * Family members
    * add
    * remove
    */
    public static void addFamilyMember(Agenda agenda, FamilyMember person){

        List<FamilyMember> newList;

        try{
            newList = agenda.getFamilyMembers();
        } catch (NullPointerException e){
            System.out.println("Family List not found !");
            e.printStackTrace();
            return;
        } catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
            return;
        }


        if (newList.indexOf(person) == -1){
            newList.add(person);
            agenda.setFamilyMembers(newList);
            PersonServices.addPerson(agenda, person);
        }
        else{
            System.out.println("Family Member already in list!");
        }

        AuditServices.writeAuditCsv("addFamilyMember");

    }

    public static void removeFamilyMember(Agenda agenda, FamilyMember person)
    {
        AuditServices.writeAuditCsv("removeFamilyMember");
        List<FamilyMember> newList;

        try{
            newList = agenda.getFamilyMembers();
        } catch (NullPointerException e){
            System.out.println("Family List not found !");
            e.printStackTrace();
            return;
        } catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
            return;
        }

        int index = newList.indexOf(person);
        if (index != -1){
            newList.remove(index);
            agenda.setFamilyMembers(newList);
            PersonServices.removePerson(agenda, person);
        }
        else{
            System.out.println("Family Member not found!");
        }



    }

    /**
     * Work Contacts
     * add
     * remove
     */
    public static void addWork(Agenda agenda, Work person){

        List<Work> newList;

        try{
            newList = agenda.getWorkContacts();
        } catch (NullPointerException e){
            System.out.println("Work List not found !");
            e.printStackTrace();
            return;
        } catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
            return;
        }


        if (newList.indexOf(person) == -1){
            newList.add(person);
            agenda.setWorkContacts(newList);
            PersonServices.addPerson(agenda, person);
        }
        else{
            System.out.println("Work contact already in list!");
        }

        AuditServices.writeAuditCsv("addFamilyMember");

    }

    public static void removeWork(Agenda agenda, Work person){
        AuditServices.writeAuditCsv("removeWorkContact");

        List<Work> newList;

        try{
            newList = agenda.getWorkContacts();
        } catch (NullPointerException e){
            System.out.println("Work List not found !");
            e.printStackTrace();
            return;
        } catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
            return;
        }

        int index = newList.indexOf(person);
        if (index != -1){
            newList.remove(index);
            agenda.setWorkContacts(newList);
            PersonServices.removePerson(agenda, person);
        }
        else{
            System.out.println("Work Contact not found!");
        }


    }


}
