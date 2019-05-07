package Servicies.csvServices;

import Agenda.Agenda;
import Person.Person;
import Person.User;
import Person.Work;
import Person.FamilyMember;
import Servicies.PersonServices;
import Servicies.TaskServices;
import Tasks.Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static constants.ConstantValues.defaultData;

public class LoadCsvData {
    private static final String COMMA_DELIMITER = ",";
    private static PersonServices pers;

    public static void loadCsvFamilyData(String fileName, Agenda agenda){
        BufferedReader fileReader = null;
        FamilyMember[] loadedFamily = new FamilyMember[2];

        try {
            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();
            int i = 0;
            while((line = fileReader.readLine()) != null && i < 20){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){
                    FamilyMember familyMember = new FamilyMember(tokens[0], tokens[1],tokens[2], defaultData, tokens[3]);
                    loadedFamily[i] = familyMember;
                    pers.addPerson(agenda, familyMember);
                }
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        agenda.setFamilyMembers(loadedFamily);
    }

    public static void loadCsvUserData(String fileName, Agenda agenda){
        BufferedReader fileReader = null;
        User[] loadedUser = new User[2];
        try {
            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();
            int i = 0;
            while((line = fileReader.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){
                      User user = new User(tokens[0], tokens[1], tokens[2], defaultData, tokens[3]);
                      /*loadedUser[i].setName(tokens[0]);
                      loadedUser[i].setSurname(tokens[1]);
                      loadedUser[i].setBirthday(tokens[2]);
                      loadedUser[i].setContact(defaultData);
                      loadedUser[i].setAdress(tokens[3]); */
                      loadedUser[i] = user;
                }
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        agenda.setHolder(loadedUser[0]);
    }

    public static void loadCsvTasks(String fileName, Agenda agenda){
        BufferedReader fileReader = null;
        //Tasks[] loadedTasks = new Tasks[20];
        try {

            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();
            int i = 0;
            while((line = fileReader.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){
                    Tasks task1 = new Tasks(tokens[0],tokens[1]);

                    if (tokens[2] == "true")
                        task1.setPriority(true);
                    else
                        task1.setPriority(false);

                    //TaskServices.addTask(agenda, task1);
                }
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

    }

    public static void loadCsvWork(String fileName, Agenda agenda){
        BufferedReader fileReader = null;
        //Work[] loadedWork = new Work[];
        try {

            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();
            int i = 0;
            while((line = fileReader.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){
                    /*loadedWork[i].setName(tokens[0]);
                    loadedWork[i].setSurname(tokens[1]);
                    loadedWork[i].setBirthday(tokens[2]);
                    loadedWork[i].setPosition(tokens[3]);
                    loadedWork[i].setWorkplace(tokens[4]);
                    loadedWork[i].setContact(defaultData);
                    */

                    Work work = new Work(tokens[0], tokens[1], tokens[2], defaultData, tokens[3], tokens[4]);

                    pers.addPerson(agenda, work);
                }
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        //agenda.setWorkContacts(loadedWork);
    }

    public static void loadCsvData ( Agenda agenda, String familyPath, String userPath, String tasksPath, String workPath){
        loadCsvUserData(userPath, agenda);
        loadCsvFamilyData(familyPath, agenda);
        loadCsvTasks(tasksPath, agenda);
        loadCsvWork(workPath, agenda);
        System.out.println("Data loaded successfully !");
    }
}
