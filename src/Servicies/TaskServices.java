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
        Tasks[] tasksArr1 = new Tasks[size- 1];
        int j = 0;
        for ( int i = 0; i < size; i++){
            if (Objects.equals(task.getTask(), agenda.getTasksArr()[i].getTask()) &&
                    Objects.equals(task.getDeadLine(), agenda.getTasksArr()[i].getDeadLine())){
                continue;
            } else {
                tasksArr1[j] = agenda.getTasksArr()[i];
                j++;
            }
        }
        agenda.setTasksArr(tasksArr1);
    }
    public void sortByDeadLine( Agenda agenda)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks = new Tasks[size];
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        agenda.setTasksArr(sortedTasks);
        System.out.println("Sorted the deadline array ! \n");
    }

    public Tasks[] returnSortedByDeadLine( Agenda agenda)
    {
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks = new Tasks[size];
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByDate());
        return sortedTasks;
    }

    public void sortByPriority (Agenda agenda){
        int size = agenda.getTasksArr().length;
        Tasks[] sortedTasks = new Tasks[size];
        sortedTasks = agenda.getTasksArr();
        Arrays.sort(sortedTasks, new SortByPriorityDate());
    }

    public void showTasks (Agenda agenda)
    {
        int sizeOfTasks = agenda.getTasksArr().length;

        for ( int i = 0 ; i < sizeOfTasks; i++){
            System.out.println(agenda.getTasksArr()[i].isPriority()+ " "+agenda.getTasksArr()[i].getTask() + " " +agenda.getTasksArr()[i].getDeadLine().getDate());
        }

    }
}
