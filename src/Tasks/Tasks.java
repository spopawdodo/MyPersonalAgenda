package Tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.*;

public class Tasks {
    private boolean priority;
    private String task;
    private String deadLine;

    /// CONSTRUCTORS
    public Tasks(boolean priority, String task, String deadLine){
        this.priority = priority;
        this.task = task;
        this.deadLine = deadLine;
    }

    public Tasks(String task, String deadLine) {
        this.priority = false;
        this.task = task;
        this.deadLine = deadLine;
    }

    public Tasks(){
        this.priority = false;
        this.task = "-";
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        this.deadLine = df.format(date);
    }

    /// PRIORITY

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    ///TASK NAME

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    ///DEADLINE

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    ///TO STRING

    @Override
    public String toString() {
        return "Tasks{" +
                "priority=" + priority +
                ", task='" + task + '\'' +
                ", deadLine='" + deadLine + '\'' +
                '}';
    }

    ///EQUALS , HASHCODE


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tasks)) return false;
        Tasks tasks = (Tasks) o;
        return isPriority() == tasks.isPriority() &&
                getTask().equals(tasks.getTask()) &&
                getDeadLine().equals(tasks.getDeadLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPriority(), getTask(), getDeadLine());
    }
}
