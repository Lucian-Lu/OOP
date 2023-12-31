package thirdlab.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgramFile extends DefaultFile {

    public void analyzeJavaFile(String filePath) {
        int lineCount = 0;
        int classCount = 0;
        int methodCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                lineCount++;
                if (line.matches("\\s*class.*") ||
                        line.matches(".*(public|private|protected)\\s+class.*")){
                    classCount++;
                } else if (line.matches(".*(public|private|protected).*\\(.*\\)\\s*\\{.*")) {
                    methodCount++;
                }
            }

            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total lines: " + lineCount);
        System.out.println("Total classes: " + classCount);
        System.out.println("Total methods: " + methodCount);
    }

    public void analyzePythonFile(String filePath) {
        int lineCount = 0;
        int classCount = 0;
        int methodCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                lineCount++;
                if (line.matches("class.*")) {
                    classCount++;
                } else if (line.matches("def.*\\(.*\\):")) {
                    methodCount++;
                }
            }

            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total lines: " + lineCount);
        System.out.println("Total classes: " + classCount);
        System.out.println("Total methods: " + methodCount);
    }

    @Override
    public void printFileInfo(String fileName) {
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + getExtensionFromFileName(fileName));
        System.out.println("Created: " + DefaultFile.getCreationDate(fileName));
        System.out.println("Updated: " + DefaultFile.getUpdatedDate(fileName));
        if (getExtensionFromFileName(fileName).equals("java")) {
            analyzeJavaFile(getFolderLocation() + "\\" + fileName);
        } else {
            analyzePythonFile(getFolderLocation() + "\\" + fileName);
        }
    }
}
