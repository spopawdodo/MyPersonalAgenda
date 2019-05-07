package Servicies;

import Agenda.Agenda;
import Tasks.Tasks;

import java.util.Arrays;
import java.util.Objects;

public  class TaskServices {

    public static void addTask(Agenda agenda, Tasks newTask)
    {   int size = 0;
        if (agenda.getTasksArr() != null){
            size = agenda.getTasksArr().length;
        }
        Tasks[] tasksArr1 = new Tasks[size + 1];
        if ( size == 0){
            tasksArr1[0] = newTask;
        }
        else {
            for ( int i = 0; i < size; i++){
                tasksArr1[i] = agenda.getTasksArr()[i];
            }
            tasksArr1[size] = newTask;
        }
        agenda.setTasksArr(tasksArr1);
        AuditServices.writeAuditCsv("addTask");

    }

    public static void removeTask(Agenda agenda, Tasks task)
    {
        int size = agenda.getTasksArr().length;
        if (size == 0 ){
            System.out.println("Task not found");
            return;
        }
        Tasks[] tasksArr1 = new Tasks[size - 1];
        int j = 0, i;
        for ( i = 0; i < size - 1; i++){
            if (!(Objects.equals(task.getTask(), agenda.getTasksArr()[i].getTask()) &&
                    Objects.equals(task.getDeadLine(), agenda.getTasksArr()[i].getDeadLine()))){
                tasksArr1[j] = agenda.getTasksArr()[i];
                j++;
            }
        }
        if ( i == j){
            if ( (Objects.equals(task.getTask(), agenda.getTasksArr()[size-1].getTask()) &&
                    Objects.equals(task.getDeadLine(), agenda.getTasksArr()[size-1].getDeadLine()))) {
                agenda.setTasksArr(tasksArr1);
            }
            else
                System.out.println("Task not found!");
        }
        else{
            tasksArr1[size-2] = agenda.getTasksArr()[size-1];
            agenda.setTasksArr(tasksArr1);

        }
        AuditServices.writeAuditCsv("removeTask");


    }
    public static void sortByDeadLine( Agenda agenda)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        agenda.setTasksArr(sortedTasks);
        System.out.println("Sorted the deadline array ! \n");
        AuditServices.writeAuditCsv("sortByDeadLine");

    }

    public static Tasks[] returnSortedByDeadLine( Agenda agenda)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        AuditServices.writeAuditCsv("returnSortedByDeadline");

        return sortedTasks;
    }

    public static void sortByPriority (Agenda agenda){
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByPriorityDate());
        AuditServices.writeAuditCsv("sortByPriority");

    }

    public static void showTasks (Agenda agenda)
    {
        if (agenda.getTasksArr() == null){
            System.out.println("Empty Task Array !");
            return;
        }
        int sizeOfTasks = agenda.getTasksArr().length;

        for ( int i = 0 ; i < sizeOfTasks; i++){
            if (agenda.getTasksArr()[i].isPriority())
                System.out.print("Important ! ");
            System.out.println(agenda.getTasksArr()[i].getTask() + " " +agenda.getTasksArr()[i].getDeadLine());
        }
        AuditServices.writeAuditCsv("showTasks");
    }
}
