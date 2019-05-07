package Servicies.csvServices;

import Agenda.Agenda;
import Person.Person;

import Person.FamilyMember;
import Tasks.Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadCsvData {
    private static final String COMMA_DELIMITER = ",";
    public static void loadCsvFamilyData(String fileName, Agenda agenda){
        BufferedReader fileReader = null;

        try {
            //Person.FamilyMember[] family= new FamilyMember[];
            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();

            while((line = fileReader.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){
                    System.out.println(tokens[0]);
                }

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

    public static void loadCsvUserData(String fileName){
        BufferedReader fileReader = null;

        try {
            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();

            while((line = fileReader.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){

                }

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

    public static void loadCsvTasks(String fileName, Agenda agenda){
        BufferedReader fileReader = null;
        Tasks[] loadedTasks = new Tasks[20];
        try {

            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

            fileReader.readLine();
            int i = 0;
            while((line = fileReader.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0){
                    loadedTasks[i].setTask(tokens[0]);
                    loadedTasks[i].setDeadLine(tokens[1]);
                    if (tokens[2] == "true")
                        loadedTasks[i].setPriority(true);
                    else
                        loadedTasks[i].setPriority(false);
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

        agenda.setTasksArr(loadedTasks);
    }

    public static void loadCsvData ( Agenda agenda, String familyPath, String userPath, String tasksPath){
        //loadCsvFamilyData(familyPath);
        //loadCsvUserData(userPath);
        loadCsvTasks(tasksPath, agenda);
        System.out.println("Data loaded successfully !");
    }
}
