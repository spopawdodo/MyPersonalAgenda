package Main;

import Agenda.Agenda;
import ContactData.ContactInformation;
import Person.FamilyMember;
import Person.Person;
import Person.User;
import Servicies.PersonServices;
import Servicies.TaskServices;
import Servicies.csvServices.LoadCsvData;
import Servicies.csvServices.WriteToCsv;
import Tasks.Tasks;
import Person.Work;
import Person.Client;

import java.util.ArrayList;
import java.util.List;

import static constants.ConstantValues.defaultData;

public class Main {
    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        LoadCsvData.loadCsvData( agenda1, "Family1.csv", "User1.csv", "Tasks1.csv", "Work1.csv");

        FamilyMember mom = new FamilyMember("Pop", "Cristina", "05.05.1969", defaultData,  "Mother");
        FamilyMember brother = new FamilyMember("Pop", "Ionut", "02.05.2001", defaultData, "Brother" );
        FamilyMember cousin = new FamilyMember("Pop", "Adrian", "07.10.2004", defaultData, "Cousin" );

        Work manager = new Work("Mr", "Chef", "03.03.2003", defaultData, "Restaurant", "Manager");

        Client client1 = new Client("Mrs", "Client", "", defaultData, "Unibuc", "Ase", "Teacher" );


        Work colleague1 = new Work("Mr", "Colleague1", "01.01.2000", defaultData, "Restaurant", "Chef");
        Work colleague2 = new Work("Mr", "Colleague1", "01.01.2000", defaultData, "Restaurant", "Chef");

        User user = new User ("Pop", "Maria", "28.07.1998", new ContactInformation("112", "-", "maria.denisa@gmail.com"), "Bucharest");

        Client client2 = new Client("Mr", "Doctor", "", defaultData, "Unibuc", "Hospital", "Pediatrician");



        Tasks task1 = new Tasks(true, "Buy apples", "02.04.2016");
        Tasks task2 = new Tasks ("Finnish project", "26.03.2019");

        Tasks task3 = new Tasks("Go shopping", "30.03.2016");
        Tasks task4 = new Tasks("Make bed","27.03.2018");
        Tasks task5 = new Tasks ("Finnish project", "26.03.2019");
        Tasks task6= new Tasks();

        Tasks[] allTasks = new Tasks[]{task1, task2};

        /**
        List<FamilyMember> members = new ArrayList<FamilyMember>();
        List<Work> workContacts = new ArrayList<Work>();
        Person[] people = new Person[]{};

        workContacts.add(manager);
        workContacts.add(client1);

        members.add(brother);
        */

        //// TASKS TESTS
        TaskServices.addTask(agenda1, task3);
        TaskServices.addTask(agenda1, task4);
        TaskServices.addTask(agenda1, task6);
        TaskServices.removeTask(agenda1, task5);
        TaskServices.sortByPriority(agenda1);

        /// PERSON TESTS

        PersonServices.addPerson(agenda1, client2);
        //PersonServices.addPerson(agenda1, client2);
        PersonServices.removePerson(agenda1, client2);
        PersonServices.addPerson(agenda1, client2);
        PersonServices.sortByName(agenda1);


        /// Family Tests
        //PersonServices.removeFamilyMember(agenda1, mom);
        PersonServices.addFamilyMember(agenda1,mom);
        PersonServices.addFamilyMember(agenda1,cousin);

        ///Work Test

        PersonServices.addWork(agenda1, colleague1);
        //PersonServices.removeWork(agenda1,colleague2);
        PersonServices.addWork(agenda1, client2);
        //PersonServices.removeWork(agenda1, client2);

        //agenda1.showAgenda();



        WriteToCsv.updateCsvData("User.csv", "Tasks.csv", "Family.csv", "Work.csv", agenda1);





    }
}
