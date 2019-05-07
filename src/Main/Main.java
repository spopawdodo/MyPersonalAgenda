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
import Person.Boss;
import Person.Client;
import Person.Colleague;

import java.text.SimpleDateFormat;
import java.util.Objects;

import static constants.ConstantValues.defaultData;

public class Main {
    public static void main(String[] args) {

        /**
         * Initializari Persoane din clasele:
         * User ( Persoana ce detine agenda )
         * FamilyMember
         * Work : Boss, Client, Colleague
         */
        /*
        FamilyMember mom = new FamilyMember("Pop", "Cristina", "05.05.1969", defaultData,  "Mother");
        FamilyMember brother = new FamilyMember("Pop", "Ionut", "02.05.2001", defaultData, "Brother" );

        Work manager = new Work("Mr", "Chef", "03.03.2003", defaultData, "Restaurant", "Manager");

        Client client1 = new Client("Mrs", "Client", "", defaultData, "Unibuc", "Ase", "Teacher" );


        Work colleague1 = new Work("Mr", "Colleague", "01.01.2000", defaultData, "Restaurant", "Chef");

        User user = new User ("Pop", "Maria", "28.07.1998", new ContactInformation("112", "-", "maria.denisa@gmail.com"), "Bucharest");
        */
        Client client2 = new Client("Mr", "Doctor", "", defaultData, "Unibuc", "Hospital", "Pediatrician");
        /***
         * Initializari taskuri si aduagarea lor ulterior in lista
         * Prin constructor
         * Prin functie de adaugare
        */

        /*
        Tasks task1 = new Tasks(true, "Buy apples", "02.04.2016");
        Tasks task2 = new Tasks ("Finnish project", "26.03.2019");
        */
        Tasks task3 = new Tasks("Go shopping", "30.03.2016");
        Tasks task4 = new Tasks("Make bed","27.03.2018");
        Tasks task5 = new Tasks ("Finnish project", "26.03.2019");
        //Tasks[] allTasks = new Tasks[]{};

        TaskServices service = new TaskServices();
        //FamilyMember[] members = new FamilyMember[]{mom, brother};
        //Work[] workContacts = new Work[]{manager, client1};
        //Person[] people = new Person[]{mom, brother, manager, client1};

        System.out.println();

        /**
         * Configurarea agendei
         * User
         * Lista de taskuri
         * Lista de contacte
         * As dori sa o continui cu : o lista de evenimente ( intr - o alta faza a proiectului)
         */

        //Agenda agenda1 = new Agenda(user, allTasks, members, workContacts);
        Agenda agenda1 = new Agenda();
        //service.addTask(agenda1, task3);
        //service.addTask(agenda1, task4);
        //service.removeTask(agenda1, task5);
        //service.sortByDeadLine(agenda1);
        ///agenda1.setTasksArr(service.returnSortedByDeadLine(agenda1));

        //service.sortByPriority(agenda1);

        PersonServices ps = new PersonServices();
       // ps.addPerson(agenda1, client2);
        ps.addPerson(agenda1, client2);
        ps.removePerson(agenda1, client2);
        ps.addPerson(agenda1, client2);
        ps.sortByName(agenda1);


        LoadCsvData obj= new LoadCsvData();
        //obj.loadCsvFamilyData("/Users/maria/IdeaProjects/MyPersonalAgenda/src/FamilyInfo.csv");
        obj.loadCsvData( agenda1, "Family1.csv", "User1.csv", "Tasks1.csv", "Work1.csv");

        agenda1.showContacts();
        agenda1.showTasks();

        WriteToCsv wrt = new WriteToCsv();
        //wrt.updateCsvData("User.csv", "Tasks.csv", "Family.csv", "Work.csv", agenda1);
        wrt.writeFamilyToCsv("Family.csv", agenda1.getFamilyMembers());
        wrt.writeHolderToCsv("User.csv", agenda1.getHolder());
        wrt.writeTasksToCsv("Tasks.csv", agenda1.getTasksArr());

    }
}
