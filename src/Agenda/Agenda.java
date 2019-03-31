package Agenda;

import Person.Person;
import Person.User;
import Servicies.PersonServicies;
import Servicies.TaskServices;
import Tasks.Tasks;

import java.util.Arrays;
import java.util.Objects;

public class Agenda {
    private Tasks[] tasksArr;
    private User holder;
    private Person[] contacts;

    public Tasks[] getTasksArr() {
        return tasksArr;
    }

    public void setTasksArr(Tasks[] tasksArr) {
        this.tasksArr = tasksArr;
    }

    public Agenda(User user)
    {
        this.holder = user;
    }

    public Agenda(User user, Tasks[] tasks){
        this.holder = user;
        this.tasksArr = tasks;
    }

    public void showAgenda(){
        System.out.println("Here are your personal details :");
        this.showHolder();
        System.out.println("Here are your tasks : ");
        this.showTasks();
        System.out.println("Here are your contacts : ");
    }

    public void showHolder(){
        new PersonServicies().showPerson(this.holder);
    }

    public void showTasks(){
        new TaskServices().showTasks(this);
    }


}
