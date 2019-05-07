package Servicies.csvServices;

import Person.FamilyMember;
import Tasks.Tasks;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

public class WriteToCsv {

    private static final String FILE_HEADER_Family = "name,surname,birthday,relativeType";
    private static final String FILE_HEADER_Tasks = "task,deadline,priority";
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
            for (i = 0; i < data.length; i++) {
                //Write a new student object list to the CSV file
                fileWriter.append(String.valueOf(data[i].getName()));
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
            for (i = 0; i < data.length; i++) {
                //Write a new student object list to the CSV file
                fileWriter.append(String.valueOf(data[i].getTask()));
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
}
