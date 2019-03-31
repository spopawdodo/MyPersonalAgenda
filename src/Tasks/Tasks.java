package Tasks;

import java.util.regex.*;

public class Tasks {
    private boolean priority;
    private String task;
    private String deadLine;

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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

}
