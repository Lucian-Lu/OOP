package secondlab.behavior;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {

    public static void clearLogFile() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\secondlab\\behavior\\saves\\logs.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileManager.getFileName()))) {
        } catch (IOException e) {
            System.out.println("Error while clearing logs.\n");
            throw new RuntimeException(e);
        }
    }

    public static void log (String logMessage) {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\secondlab\\behavior\\saves\\logs.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileManager.getFileName(), true))){
            String logTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ss mm HH dd MM yyyy"));
            writer.write(logTime + " | " + logMessage + "\n");
        } catch (IOException e){
            System.out.println("Error while creating logs.\n");
            throw new RuntimeException(e);
        }
    }
}
