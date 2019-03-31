package Agenda;

import Person.Person;
import Person.User;
import Servicies.TaskServices;
import Tasks.Tasks;

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

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public Person[] getContacts() {
        return contacts;
    }

    public void setContacts(Person[] contacts) {
        this.contacts = contacts;
    }

    public Agenda(User user, Tasks[] tasks, Person[] contacts){
        this.holder = user;
        this.tasksArr = tasks;
        this.contacts = contacts;
    }

    public void showAgenda(){
        System.out.println("Here are your personal details :");
        this.showHolder();
        System.out.println("\nHere are your tasks : ");
        this.showTasks();
        System.out.println("\nHere are your contacts : ");
        this.showContacts();
        System.out.println();
    }

    public void showHolder(){
        holder.showPerson();
    }

    public void showTasks(){
        new TaskServices().showTasks(this);
    }

    public void showContacts(){
        for ( int i = 0; i < contacts.length; i++)
            contacts[i].showPerson();
    }


}
