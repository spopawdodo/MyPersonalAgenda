package Servicies;

import Person.Person;

import java.util.Comparator;

public class SortByName implements Comparator<Person> {

    public int compare(Person a, Person b){
        String NameA = a.getName();
        String NameB = b.getName();
        if (NameA.compareTo(NameB) !=0)
            return NameA.compareTo(NameB);
        else
            NameA = a.getSurname();
            NameB = b.getSurname();
            return NameA.compareTo(NameB);
    }
}
