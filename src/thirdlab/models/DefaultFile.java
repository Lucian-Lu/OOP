package thirdlab.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class DefaultFile {
    private static final String folderLocation = "C:\\University Documents\\Lab\\OOP\\Test";
    private String fileName;


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public static String getFolderLocation() {
        return folderLocation;
    }

    public String getExtensionFromFileName(String fileName) {
        if (fileName == null) {
            return "";
        }

        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }

    public static FileTime getCreationDate(String fileName) {
        try {
            String filePath = getFolderLocation() + "\\" + fileName;
            Path path = Paths.get(filePath);
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            return attributes.creationTime();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FileTime getUpdatedDate(String fileName) {
        try {
            String filePath = getFolderLocation() + "\\" + fileName;
            Path path = Paths.get(filePath);
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            return attributes.lastModifiedTime();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printFileInfo(String fileName) {
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + getExtensionFromFileName(fileName));
        System.out.println("Created: " + DefaultFile.getCreationDate(fileName));
        System.out.println("Updated: " + DefaultFile.getUpdatedDate(fileName));
    }
}
