package thirdlab.behavior;


import thirdlab.behavior.*;
import thirdlab.models.*;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;

public class ApplicationLoop {
    private Scanner scanner;
    private SnapshotManager snapshotManager;
    private LocalDateTime snapshot;

    public ApplicationLoop() {
        scanner = new Scanner(System.in);
        snapshotManager = new SnapshotManager();
        snapshotManager.setSnapshot(FileManager.loadSnapshot());
        snapshot = snapshotManager.getSnapShot();
    }

    public void closeScanner() {
        scanner.close();
    }

    public void run() {
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("File change monitoring system. Please select an option:\n" +
                    "commit - update the snapshot time to the current time\n" +
                    "info <filename> - print general info about the file\n" +
                    "status - display all the files & their status\n" +
                    "q - quit program\n\n" +
                    "> ");
            String option = scanner.nextLine();
            String pattern = "\\s+";
            String[] optionCommands = option.split(pattern);
            switch (optionCommands[0]) {
                case "commit":
                    commit();
                    System.out.println("\n");
                    break;
                case "info":
                    info(optionCommands[1]);
                    System.out.println("\n");
                    break;
                case "status":
                    status();
                    System.out.println("\n");
                    break;
                case "q":
                    keepLooping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void commit() {
        snapshotManager.updateSnapshot();
        snapshot = snapshotManager.getSnapShot();
        FileManager.saveSnapshot(snapshotManager);
        System.out.println("Snapshot successfully updated.");
    }

    public void info(String fileName) {
        DefaultFile file = new DefaultFile();
        String extension = file.getExtensionFromFileName(fileName);
        switch (extension) {
            case "txt":
                TextFile textFile = new TextFile();
                textFile.printFileInfo(fileName);
                break;
            case "png":
            case "jpg":
                ImageFile imageFile = new ImageFile();
                imageFile.printFileInfo(fileName);
                break;
            case "py":
            case "java":
                ProgramFile programFileJava = new ProgramFile();
                programFileJava.printFileInfo(fileName);
                break;
            default:
                file.printFileInfo(fileName);
                break;
        }
    }

    public void status() {
        File directory = new File(DefaultFile.getFolderLocation());
        System.out.println("Created snapshot at " + snapshot);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                        LocalDateTime updateTime = attributes.lastModifiedTime().toInstant().atZone(
                                ZoneId.systemDefault()).toLocalDateTime();
                        int comparisonResult = snapshot.compareTo(updateTime);
                        if (comparisonResult <= 0) {
                            System.out.println(file.getName() + " - Changed");
                        } else {
                            System.out.println(file.getName() + " - No Change");
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
