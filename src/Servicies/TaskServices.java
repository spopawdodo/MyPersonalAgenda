package Servicies;

import Agenda.Agenda;
import Tasks.Tasks;
import com.sun.security.auth.NTUserPrincipal;

import java.util.Arrays;
import java.util.Objects;

public class TaskServices {

    public static void addTask(Agenda agenda, Tasks newTask)
    {
        int size = 0;
        try{
            size = agenda.getTasksArr().length;
        } catch (NullPointerException e){
            System.out.println("ERROR in finding the taskArray! ");
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
        int size = 0;

        try{
            size = agenda.getTasksArr().length;
        } catch (NullPointerException e){
            System.out.println("ERROR in finding the taskArray! ");
        }

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

    /// DEADLINE SORT
    public static void sortByDeadLine( Agenda agenda)
    {
        AuditServices.writeAuditCsv("sortByDeadLine");
        int size = 0;
        try{
            size = agenda.getTasksArr().length;
        } catch (NullPointerException e){
            System.out.println("ERROR in finding the taskArray! ");
        }
        if (size == 0){
            System.out.println("No tasks to sort");
            return;
        }
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        agenda.setTasksArr(sortedTasks);
        System.out.println("Sorted the deadline array ! \n");

    }

    public static Tasks[] returnSortedByDeadLine( Agenda agenda)
    {
        Tasks[] sortedTasks = new Tasks[]{};
        int size = 0;
        try{
            size = agenda.getTasksArr().length;
        } catch (NullPointerException e){
            System.out.println("ERROR in finding the taskArray! ");
        }
        if (size == 0){
            System.out.println("No tasks to sort");
            return sortedTasks;
        }

        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        AuditServices.writeAuditCsv("returnSortedByDeadline");

        return sortedTasks;
    }

    /// PRORITY SORT
    public static void sortByPriority (Agenda agenda){
        int size = 0;
        try{
            size = agenda.getTasksArr().length;
        } catch (NullPointerException e){
            System.out.println("ERROR in finding the taskArray! ");
        }
        if (size == 0){
            System.out.println("No tasks to sort");
            return;
        }
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByPriorityDate());
        agenda.setTasksArr(sortedTasks);
        AuditServices.writeAuditCsv("sortByPriority");

    }

    public static Tasks[] returnsSortedByPriority (Agenda agenda){
        int size = 0;
        Tasks[] sortedTasks = new Tasks[]{};
        try{
            size = agenda.getTasksArr().length;
        } catch (NullPointerException e){
            System.out.println("ERROR in finding the taskArray! ");
        }
        if (size == 0){
            System.out.println("No tasks to sort");
            return sortedTasks;
        }

        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByPriorityDate());

        AuditServices.writeAuditCsv("returnSortedByPriority");

        return sortedTasks;

    }

    //// SHOW
    public static void showTasks (Agenda agenda)
    {
        if (agenda.getTasksArr() == null){
            System.out.println("Empty Task Array !");
            return;
        }
        Tasks[] array = agenda.getTasksArr();
        int sizeOfTasks = agenda.getTasksArr().length;

        for ( int i = 0 ; i < sizeOfTasks; i++){
            if (array[i].isPriority())
                System.out.print("Important ! ");

            //System.out.println(agenda.getTasksArr()[i].getTask() + " " +agenda.getTasksArr()[i].getDeadLine());

            System.out.println(array[i].toString());

        }
        AuditServices.writeAuditCsv("showTasks");
    }
}
