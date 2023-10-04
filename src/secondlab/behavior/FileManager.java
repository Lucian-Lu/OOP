package secondlab.behavior;

import org.w3c.dom.ls.LSOutput;
import secondlab.models.*;

import java.io.*;
import java.time.LocalDate;

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
            LogManager.log("FATAL: Error saving data to " + fileManager.getFileName());
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
            LogManager.log("FATAL: Error loading data from " + fileManager.getFileName());
            System.out.println("Error while loading file.\n");
            throw new RuntimeException(e);
        }
        System.out.println("Successfully loaded previous data.");
    }

    public static void graduateBatch() {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\secondlab\\behavior\\saves\\batch\\graduates.txt");
        LogManager.log("INFO: Loading data from " + fileManager.getFileName());
        try (BufferedReader reader = new BufferedReader(new FileReader(fileManager.getFileName()))) {
            if (!reader.ready()) {
                LogManager.log("WARN: Graduated student batch file is empty");
                return;
            }
            while (reader.ready()) {
                String email = reader.readLine();
                Faculty.graduateStudent(email);
                LogManager.log("AUDIT: Graduated student from batch file");
            }
        } catch (IOException e) {
            LogManager.log("FATAL: Error loading data from " + fileManager.getFileName());
            System.out.println("Error while loading batch graduation file.\n");
            throw new RuntimeException(e);
        }
        LogManager.log("AUDIT: Successfully graduated students from batch file");
    }

    public static void enrollBatch(String abbreviation) {
        FileManager fileManager = new FileManager();
        fileManager.setFileName(".\\src\\secondlab\\behavior\\saves\\batch\\students.txt");
        LogManager.log("INFO: Loading data from " + fileManager.getFileName());
        try (BufferedReader reader = new BufferedReader(new FileReader(fileManager.getFileName()))) {
            if (!reader.ready()) {
                LogManager.log("WARN: Students enroll batch file is empty");
                return;
            }
            while (reader.ready()) {
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                String email = reader.readLine();
                String[] enrollmentDate = LocalDate.now().toString().split("-");
                Date formatEnrollmentDate = new Date(
                        (byte) Integer.parseInt(enrollmentDate[2]),
                        (byte) Integer.parseInt(enrollmentDate[1]),
                        (short) Integer.parseInt(enrollmentDate[0]));
                String[] dateOfBirth = reader.readLine().split("-");
                Date formatDateOfBirth = new Date(
                        (byte) Integer.parseInt(dateOfBirth[0]),
                        (byte) Integer.parseInt(dateOfBirth[1]),
                        (short) Integer.parseInt(dateOfBirth[2]));
                Faculty.createAndAddStudentToFaculty(abbreviation, firstName, lastName, email,
                        formatEnrollmentDate, formatDateOfBirth);
                reader.readLine();
                LogManager.log("AUDIT: Student enrolled from batch file");
            }
        } catch (IOException e) {
            LogManager.log("FATAL: Error loading data from " + fileManager.getFileName());
            System.out.println("Error while loading batch students enroll file.\n");
            throw new RuntimeException(e);
        }
        LogManager.log("AUDIT: Successfully enrolled students from batch file");
    }

}
