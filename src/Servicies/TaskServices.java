package Servicies;

import Agenda.Agenda;
import Tasks.Tasks;

import java.util.Arrays;
import java.util.Objects;

public class TaskServices {

    public void addTask(Agenda agenda, Tasks newTask)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] tasksArr1 = new Tasks[size + 1];

        for ( int i = 0; i < size; i++){
            tasksArr1[i] = agenda.getTasksArr()[i];
        }

        tasksArr1[size] = newTask;
        agenda.setTasksArr(tasksArr1);
    }

    public void removeTask(Agenda agenda, Tasks task)
    {
        int size = agenda.getTasksArr().length;
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

    }
    public void sortByDeadLine( Agenda agenda)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        agenda.setTasksArr(sortedTasks);
        System.out.println("Sorted the deadline array ! \n");
    }

    public Tasks[] returnSortedByDeadLine( Agenda agenda)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        return sortedTasks;
    }

    public void sortByPriority (Agenda agenda){
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks;
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByPriorityDate());
    }

    public void showTasks (Agenda agenda)
    {
        int sizeOfTasks = agenda.getTasksArr().length;

        for ( int i = 0 ; i < sizeOfTasks; i++){
            if (agenda.getTasksArr()[i].isPriority())
                System.out.print("Important ! ");
            System.out.println(agenda.getTasksArr()[i].getTask() + " " +agenda.getTasksArr()[i].getDeadLine());
        }

    }
}
