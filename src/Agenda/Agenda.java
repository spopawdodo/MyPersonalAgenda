package Agenda;

import Person.Person;
import Person.User;
import Person.FamilyMember;
import Person.Work;
import Servicies.PersonServices;
import Servicies.TaskServices;
import Tasks.Tasks;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private Tasks[] tasksArr;
    private User holder;
    private Person[] contacts;
    private List<FamilyMember> familyMembers;
    private List<Work> workContacts;

    //// FAMILY MEMBERS

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    //// WORK CONTACTS

    public List<Work> getWorkContacts() {
        return workContacts;
    }

    public void setWorkContacts(List<Work> workContacts) {
        this.workContacts = workContacts;
    }

    //// TASK ARRAY

    public Tasks[] getTasksArr() {
        return tasksArr;
    }

    public void setTasksArr(Tasks[] tasksArr) {
        this.tasksArr = tasksArr;
    }

    //// HOLDER

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    //// ALL CONTACTS

    public Person[] getContacts() {
        return contacts;
    }

    public void setContacts(Person[] contacts) {
        this.contacts = contacts;
    }

    ////AGENDA CONSTRUCTORS

    public Agenda(User user)
    {
        this.holder = user;
        this.workContacts = new ArrayList<Work>();
        this.familyMembers = new ArrayList<FamilyMember>();
        this.contacts = new Person[]{};
        this.tasksArr = new Tasks[]{};
    }

    public Agenda() {
        this.holder = new User();
        this.workContacts = new ArrayList<Work>();
        this.familyMembers = new ArrayList<FamilyMember>();
        this.contacts = new Person[]{};
        this.tasksArr = new Tasks[]{};


    }

    public Agenda(User user, Tasks[] tasks, Person[] contacts){
        this.holder = user;
        this.tasksArr = tasks;
        this.contacts = contacts;
        this.workContacts = new ArrayList<Work>();
        this.familyMembers = new ArrayList<FamilyMember>();
    }


    //!!!
    public Agenda(User user, Tasks[] tasks, List<FamilyMember> familyMembers, List<Work> workContacts){
        this.holder = user;
        this.tasksArr = tasks;

        this.familyMembers = new ArrayList<FamilyMember>();
        this.familyMembers.addAll(familyMembers);

        this.workContacts = new ArrayList<Work>();
        this.workContacts.addAll(workContacts);

        this.contacts = new Person[]{};

        for (int i = 0; i < familyMembers.size(); i++){
            PersonServices.addPerson(this, familyMembers.get(i));
        }

        for (int i = 0; i < workContacts.size(); i++){
            PersonServices.addPerson(this, workContacts.get(i));
        }
    }

    public Agenda(User user, Tasks[] tasks, List<FamilyMember> familyMembers, List<Work> workContacts, Person[] people){
        this.holder = user;
        this.tasksArr = tasks;
        this.familyMembers = familyMembers;
        this.workContacts = workContacts;
        this.contacts = people;
    }


    //// PRINT METHODS

    public void showAgenda(){
        this.showHolder();
        this.showTasks();
        this.showContacts();
        this.showWork();
        this.showFamilyMembers();
        System.out.println();
    }

    public void showHolder(){
        System.out.println("Here are your personal details :");

        System.out.println(holder.toString());
    }

    public void showTasks(){
        System.out.println("\nHere are your tasks : ");

        TaskServices.showTasks(this);
    }

    public void showContacts(){
        System.out.println("\nHere are your contacts : ");

        try{

            for ( int i = 0; i < contacts.length; i++)
                System.out.println(contacts[i].toString());
        } catch (NullPointerException e){
            System.out.println("Null Pointer !\n" +
                    "You have no contacts to show !");
        } catch (Exception e){
            System.out.println("Error in showing contacts array!");
        }

        System.out.println("\n");

    }

    public void showWork(){
        System.out.println("These are your work contacts :\n " + workContacts);
    }

    public void showFamilyMembers(){
        System.out.println("These are your family contacts :\n" + familyMembers);
    }


}
