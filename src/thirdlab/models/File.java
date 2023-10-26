package thirdlab.models;

import java.io.IOException;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class File {
    private final String folderLocation = "C:\\University Documents\\Lab\\OOP\\Test";
    public final String fileTest = "C:\\University Documents\\Lab\\OOP\\Test\\hi.txt";
    private String fileName;
    private String extension;


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
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

    public void getCreationDate() {
        try {
            Path path = Paths.get(fileTest);
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Creating time: " + attributes.creationTime());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUpdatedDate() {
        try {
            Path path = Paths.get(fileTest);
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Update time: " + attributes.lastModifiedTime());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
