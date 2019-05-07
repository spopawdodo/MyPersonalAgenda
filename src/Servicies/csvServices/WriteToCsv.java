package Servicies.csvServices;

import Agenda.Agenda;
import Person.FamilyMember;
import Person.User;
import Person.Work;
import Tasks.Tasks;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

public class WriteToCsv {

    private static final String FILE_HEADER_Family = "name,surname,birthday,relativeType";
    private static final String FILE_HEADER_Tasks = "task,deadline,priority";
    private static final String FILE_HEADER_User = "name,surname,birthday,address";
    private static final String FILE_HEADER_Work = "name,surname,birthday,position,workplace";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeFamilyToCsv(String fileName, FamilyMember[] data) {
        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER_Family.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            int i = 0;
            int size;
            try{
                size = data.length;
            }catch (Exception e){
                size = 0;
                System.out.println("No familyMember data to write! ");
                //e.printStackTrace();
            }
            for (i = 0; i < size ; i++) {

                fileWriter.append(data[i].getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getSurname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getTypeOfRelative());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }


    }

    public static void writeTasksToCsv(String fileName, Tasks[] data) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER_Tasks.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            int i = 0;
            int size;
            try{
                size = data.length;
            }catch (Exception e){
                size = 0;
                System.out.println("No task data to write! ");
                //e.printStackTrace();
            }
            for (i = 0; i < size ; i++) {

                fileWriter.append(data[i].getTask());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getDeadLine());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(data[i].isPriority()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public static void writeHolderToCsv(String fileName, User data){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER_User.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            int i = 0;
            try{
                fileWriter.append(data.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data.getSurname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data.getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data.getAdress());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }catch (Exception e){
                System.out.println("No userData to write! ");
                //e.printStackTrace();
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }


    }

    public static void writeWorkToCsv(String fileName, Work[] data){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER_Work.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            int i = 0;
            int size;
            try{
                size = data.length;
            }catch (Exception e){
                size = 0;
                System.out.println("No workData to write! ");
                //e.printStackTrace();
            }
            for (i = 0; i < size; i++) {

                fileWriter.append(data[i].getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getSurname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getBirthday());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getPosition());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(data[i].getWorkplace());
                fileWriter.append(NEW_LINE_SEPARATOR);

            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }


    }

    public static void updateCsvData(String userPath, String taskPath, String familyPath, String workPath, Agenda agenda){
        writeTasksToCsv(taskPath, agenda.getTasksArr());
        writeFamilyToCsv(familyPath, agenda.getFamilyMembers());
        writeHolderToCsv(userPath, agenda.getHolder());
        writeWorkToCsv(workPath, agenda.getWorkContacts());
        System.out.println("Data updated succesfully!");
    }
}
