package Tasks;
import DateType.Date;

import java.util.regex.*;

public class Tasks {
    private boolean priority;
    private String task;
    private Date deadLine;

    public Tasks(boolean priority, String task, Date deadLine) {
        this.priority = priority;
        this.task = task;
        this.deadLine = deadLine;
    }

    public Tasks(String task, Date deadLine) {
        this.priority = false;
        this.task = task;
        this.deadLine = deadLine;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public void setDeadLine(String deadLine){
        this.deadLine = new Date(deadLine);
    }
}
