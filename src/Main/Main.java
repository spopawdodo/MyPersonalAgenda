package Main;

import Agenda.Agenda;
import ContactData.ContactInformation;
import Person.FamilyMember;
import Person.Person;
import Person.User;
import Servicies.TaskServices;
import Tasks.Tasks;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        FamilyMember mom = new FamilyMember("Pop", "Cristina", "05.05.1969", new ContactInformation("-", "-", "-"),  "Mother");
        FamilyMember brother = new FamilyMember("Pop", "Ionut", "02.05.2001", new ContactInformation("-", "-", "-"), "Brother" );

        Tasks task1 = new Tasks(true, "Buy apples", "02.04.2016");
        Tasks task2 = new Tasks ("Finnish project", "26.03.2019");
        Tasks task3 = new Tasks("Go shopping", "30.03.2016");
        Tasks task4 = new Tasks("Make bed","27.03.2018");
        Tasks task5 = new Tasks ("Finnish project", "27.03.2019");
        Tasks[] allTasks = new Tasks[]{task1, task2};

        TaskServices service = new TaskServices();

        User user = new User ("Pop", "Maria", "28.07.1998", new ContactInformation("112", "-", "maria.denisa@gmail.com"), "Bucharest");

        Person[] people = new Person[]{mom, brother};

        Agenda agenda1 = new Agenda(user, allTasks, people);

        service.addTask(agenda1, task3);
        service.addTask(agenda1, task4);

        service.sortByDeadLine(agenda1);
        allTasks = service.returnSortedByDeadLine(agenda1);

        service.sortByPriority(agenda1);

        //service.showTasks(agenda1);
        agenda1.showAgenda();

    }
}
