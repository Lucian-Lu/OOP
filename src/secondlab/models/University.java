package secondlab.models;

import java.util.ArrayList;
import java.util.List;

public class University {

    private static List<Faculty> faculties = new ArrayList<>();

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void createFaculty(String name, String abbreviation, String studyField) {
        faculties.add(new Faculty(name, abbreviation, studyField));
        System.out.println("New faculty created successfully.\n");
    }


    public void searchStudentFaculty(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    System.out.println("Faculty correlated to student = " +
                            faculty.getAbbreviation() + "\n");
                    return;
                }
            }
        }
        System.out.println("Student not found");
    }


    public void displayFaculties() {
        int i = 1;
        for (Faculty faculty : faculties) {
            System.out.println("Faculty nr: " + i + "\n" +
                    faculty.getName() + "\n" +
                    faculty.getAbbreviation() + "\n" +
                    faculty.getStudyField());
            i++;
        }
    }

    public void displayAllStudyFieldFaculties(String studyField) {
        int i = 1;
        System.out.println("---------Study Field - " + studyField + "---------");
        for (Faculty faculty : faculties) {
            if (faculty.getStudyField().toString().equals(studyField)) {
                System.out.println("Faculty nr: " + i + "\n" +
                        faculty.getName() + "\n" +
                        faculty.getAbbreviation());
            }
        }
    }
}
