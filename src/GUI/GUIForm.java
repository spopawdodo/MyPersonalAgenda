package GUI;

import Agenda.Agenda;
import Person.Person;
import Servicies.TaskServices;
import Tasks.Tasks;

import javax.swing.*;

public class GUIForm extends JFrame{
    private JPanel panel1;
    private JButton taskListButton;
    private JButton personListButton;

    private Agenda agenda;

    private Tasks[] tasks;
    private Person[] people;



    public GUIForm(Agenda agenda) {
        tasks = agenda.getTasksArr();
        people = agenda.getContacts();

        this.setSize(600, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //populateList();
        this.add(panel1);

        taskListButton.addActionListener(e->showTaskList());

        this.setVisible(true);
    }

    public void showTaskList(){
        int i;
    }


}
