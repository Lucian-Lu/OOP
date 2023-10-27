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
        fileManager.setFileName(".\\src\\thirdlab\\saves\\snapshots.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileManager.getFileName()));
            writer.write(snapshotManager.getSnapShot().toString());
            FileManager.saveFiles();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LocalDateTime loadSnapshot() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\thirdlab\\saves\\snapshots.txt");
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

    public static void saveFiles() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\thirdlab\\saves\\files.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileManager.getFileName()));
            File directory = new File(DefaultFile.getFolderLocation());
            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        writer.write(file.getName());
                        writer.newLine();
                    }
                }
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] loadFiles() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\thirdlab\\saves\\files.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileManager.getFileName()));
            String file;
            List<String> files = new ArrayList<>();
            while ((file = reader.readLine()) != null) {
                files.add(file);
            }
            reader.close();
            return files.toArray(new String[0]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
