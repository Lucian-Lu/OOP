package thirdlab.behavior;

import thirdlab.models.DefaultFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public static void saveSnapshot(SnapshotManager snapshotManager) {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\thirdlab\\behavior\\saves\\snapshots.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileManager.getFileName()));
            writer.write(snapshotManager.getSnapShot().toString());

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LocalDateTime loadSnapshot() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\thirdlab\\behavior\\saves\\snapshots.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileManager.getFileName()));
            String snapshotString = reader.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
            LocalDateTime snapshot = LocalDateTime.parse(snapshotString, formatter);
            reader.close();
            return snapshot;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
