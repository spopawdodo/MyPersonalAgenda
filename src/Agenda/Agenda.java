package Agenda;

import Person.Person;
import Person.User;
import Tasks.Tasks;

import java.util.Arrays;
import java.util.Objects;

public class Agenda {
    private Tasks[] tasksArr;
    private User holder; // o sa devina in curand persona, un nou tip de clasa
    private Person[] persons;

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

}
