package Main;

import Agenda.Agenda;
import ContactData.ContactInformation;
import DateType.Date;
import Person.User;
import Servicies.TaskServices;
import Tasks.Tasks;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Tasks task1 = new Tasks(true, "Buy apples", new Date("02.04.2016"));
        Tasks task2 = new Tasks ("Finnish project", new Date ("26.03.2019"));
        Tasks task3 = new Tasks("Go shopping", new Date ("30.03.2016"));
        Tasks task4 = new Tasks("Make bed",new Date ("27.03.2018"));
        Tasks task5 = new Tasks ("Finnish project", new Date ("27.03.2019"));
        Tasks[] allTasks = new Tasks[]{task1, task2};


        User user = new User ("Pop", "Maria", new Date("28.07.1998"), new ContactInformation("112", "-", "maria.denisa@gmail.com"), "Bucharest");

        Agenda agenda1 = new Agenda(user, allTasks);
        TaskServices service = new TaskServices();

        service.addTask(agenda1, task3);
        service.addTask(agenda1, task4);

        service.sortByDeadLine(agenda1);
        allTasks = service.returnSortedByDeadLine(agenda1);

        service.sortByPriority(agenda1);

        //service.showTasks(agenda1);
        agenda1.showAgenda();

    }
}
