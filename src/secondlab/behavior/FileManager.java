package secondlab.behavior;

import secondlab.models.Faculty;
import secondlab.models.StudyField;
import secondlab.models.University;
import secondlab.models.Date;

import java.io.*;

public class FileManager {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public static void save() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\secondlab\\behavior\\saves\\database.txt");
        LogManager.log("INFO: Saving data to " + fileManager.getFileName());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileManager.getFileName()))) {
            University university = new University();
            for (Faculty faculty : university.getFaculties()) {
                writer.write(faculty.toString());
            }
            writer.close();
            LogManager.log("INFO: Saved data to " + fileManager.getFileName());
            System.out.println("Faculties added to database successfully.\n");
        } catch (IOException e) {
            System.out.println("Error while creating file.\n");
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        University university = new University();
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\secondlab\\behavior\\saves\\database.txt");
        LogManager.log("INFO: Loading data from " + fileManager.getFileName());
        try (BufferedReader reader = new BufferedReader(new FileReader(fileManager.getFileName()))) {
            while (reader.ready()) {
                String name = reader.readLine();
                String abbreviation = reader.readLine();
                StudyField studyField = StudyField.valueOf(reader.readLine());
                String checkNextLine = reader.readLine();
                university.createFaculty(name, abbreviation, studyField);

                if (!checkNextLine.equals("[]")) {
                    checkNextLine = reader.readLine();
                    while (!checkNextLine.equals("]")) {

                        String firstName = checkNextLine;
                        String lastName = reader.readLine();
                        String email = reader.readLine();

                        String[] dateParts = reader.readLine().split("-");
                        Date enrollmentDate = new Date(
                                    (byte) Integer.parseInt(dateParts[0]),
                                    (byte) Integer.parseInt(dateParts[1]),
                                    (short) Integer.parseInt(dateParts[2]));

                        dateParts = reader.readLine().split("-");
                        Date dateOfBirth = new Date(
                                    (byte) Integer.parseInt(dateParts[0]),
                                    (byte) Integer.parseInt(dateParts[1]),
                                    (short) Integer.parseInt(dateParts[2]));

                        Faculty.createAndAddStudentToFaculty(abbreviation, firstName, lastName,
                                email, enrollmentDate, dateOfBirth);

                        boolean graduated = Boolean.parseBoolean(reader.readLine());
                        if (graduated) {
                            Faculty.graduateStudent(email);
                        }
                        checkNextLine = reader.readLine();
                        if (checkNextLine.equals(", ")) {
                            checkNextLine = reader.readLine();
                        }
                    }
                }
            }
            LogManager.log("INFO: Loaded data from " + fileManager.getFileName());
        } catch (IOException e) {
            System.out.println("Error while loading file.\n");
            throw new RuntimeException(e);
        }
        System.out.println("Successfully loaded previous data.");
    }

}
