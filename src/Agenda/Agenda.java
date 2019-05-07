package Agenda;

import Person.Person;
import Person.User;
import Person.FamilyMember;
import Person.Work;
import Servicies.TaskServices;
import Tasks.Tasks;

public class Agenda {
    private Tasks[] tasksArr;
    private User holder;
    private Person[] contacts;
    private FamilyMember[] familyMembers;
    private Work[] workContacts;

    public FamilyMember[] getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(FamilyMember[] familyMembers) {
        this.familyMembers = familyMembers;
    }

    public Work[] getWorkContacts() {
        return workContacts;
    }

    public void setWorkContacts(Work[] workContacts) {
        this.workContacts = workContacts;
    }

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

    public Agenda() {
    }

    public Agenda(User user, Tasks[] tasks, Person[] contacts){
        this.holder = user;
        this.tasksArr = tasks;
        this.contacts = contacts;
    }

    public Agenda(User user, Tasks[] tasks, FamilyMember[] familyMembers, Work[] workContacts){
        this.holder = user;
        this.tasksArr = tasks;
        this.familyMembers = familyMembers;
        this.workContacts = workContacts;
        this.setContacts(familyMembers);
    }

    public Agenda(User user, Tasks[] tasks, FamilyMember[] familyMembers, Work[] workContacts, Person[] people){
        this.holder = user;
        this.tasksArr = tasks;
        this.familyMembers = familyMembers;
        this.workContacts = workContacts;
        this.contacts = people;
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
        TaskServices.showTasks(this);
    }

    public void showContacts(){
        for ( int i = 0; i < contacts.length; i++)
            contacts[i].showPerson();
    }


}
