package Servicies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditServices {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "action_name,timestamp";

    //File attributes

    private static String fileName = "audit";
    private static Path path = Paths.get("src","output", fileName+".csv");
    private static FileWriter fileWriter = null;

    static {
        boolean exists = false;

        if ( new File(String.valueOf(path)).exists())
            exists = true; // File already Created
        if ( ! exists){
            // Create new file
            try{
                fileWriter = new FileWriter(String.valueOf(path), true);

                // Write the CSV file header
                fileWriter.append(FILE_HEADER.toString());

                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
            } catch (IOException e){
                e.printStackTrace();

            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                }
                catch (IOException e){
                    System.out.println("Error while closing Audit file !");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeAuditCsv(String actionName){
        // Date Object
        Date date = new Date();

        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss:SS a dd-MMM-yyyy");

        // Write the action to the csv file
        try {
            fileWriter = new FileWriter(String.valueOf(path), true);

            fileWriter.append(actionName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(df.format(date));
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while closing Audit file !");
                e.printStackTrace();
            }
        }
    }
}
