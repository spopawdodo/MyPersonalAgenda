package Main;

import Agenda.Agenda;
import ContactData.ContactInformation;
import Person.FamilyMember;
import Person.Person;
import Person.User;
import Servicies.PersonServices;
import Servicies.TaskServices;
import Tasks.Tasks;
import Person.Work;
import Person.Boss;
import Person.Client;
import Person.Colleague;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        /**
         * Initializari Persoane din clasele:
         * User ( Persoana ce detine agenda )
         * FamilyMember
         * Work : Boss, Client, Colleague
         */
        ContactInformation defaultInfo = new ContactInformation("123", "456", "user@mail.com");

        FamilyMember mom = new FamilyMember("Pop", "Cristina", "05.05.1969", defaultInfo,  "Mother");
        FamilyMember brother = new FamilyMember("Pop", "Ionut", "02.05.2001", defaultInfo, "Brother" );

        Boss manager = new Boss("Mr", "Chef", "03.03.2003", defaultInfo, "Restaurant", "Manager");

        Client client1 = new Client("Mrs", "Client", "", defaultInfo, "Unibuc", "Ase", "Teacher" );
        Client client2 = new Client("Mr", "Doctor", "", defaultInfo, "Unibuc", "Hospital", "Pediatrician");

        Colleague colleague1 = new Colleague("Mr", "Colleague", "01.01.2000", defaultInfo, "Restaurant", "Chef");

        User user = new User ("Pop", "Maria", "28.07.1998", new ContactInformation("112", "-", "maria.denisa@gmail.com"), "Bucharest");
        /***
         * Initializari taskuri si aduagarea lor ulterior in lista
         * Prin constructor
         * Prin functie de adaugare
         */
        Tasks task1 = new Tasks(true, "Buy apples", "02.04.2016");
        Tasks task2 = new Tasks ("Finnish project", "26.03.2019");
        Tasks task3 = new Tasks("Go shopping", "30.03.2016");
        Tasks task4 = new Tasks("Make bed","27.03.2018");
        Tasks task5 = new Tasks ("Finnish project", "26.03.2019");
        Tasks[] allTasks = new Tasks[]{task1, task2};

        TaskServices service = new TaskServices();

        Person[] people = new Person[]{mom, brother, manager, client1};
        /**
         * Configurarea agendei
         * User
         * Lista de taskuri
         * Lista de contacte
         * As dori sa o continui cu : o lista de evenimente ( intr - o alta faza a proiectului)
         */
        Agenda agenda1 = new Agenda(user, allTasks, people);

        service.addTask(agenda1, task3);
        service.addTask(agenda1, task4);
        service.removeTask(agenda1, task5);
        service.sortByDeadLine(agenda1);
        allTasks = service.returnSortedByDeadLine(agenda1);

        //service.sortByPriority(agenda1);

        PersonServices ps = new PersonServices();
        ps.addPerson(agenda1, client2);
        ps.addPerson(agenda1, client2);
        ps.removePerson(agenda1, client2);

        ps.sortByName(agenda1);

        agenda1.showAgenda();

    }
}
