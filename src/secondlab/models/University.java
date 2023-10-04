package secondlab.models;

import secondlab.behavior.LogManager;

import java.util.ArrayList;
import java.util.List;

public class University {

    private static List<Faculty> faculties = new ArrayList<>();

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void createFaculty(String name, String abbreviation, StudyField studyField) {
        faculties.add(new Faculty(name, abbreviation, studyField));
        System.out.println("New faculty created successfully.\n");
        LogManager.log("AUDIT: Created new faculty");
    }


    public void searchStudentFaculty(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    System.out.println("Faculty correlated to student = " +
                            faculty.getAbbreviation() + "\n" +
                            "Student first name = " + student.getFirstName() + "\n" +
                            "Student last name = " + student.getLastName() + "\n" +
                            "Student enrollment date = " + student.getEnrollmentDate() + "\n" +
                            "Student date of birth = " + student.getDateOfBirth() + "\n"
                            );
                    LogManager.log("AUDIT: Searched student by faculty using email");
                    return;
                }
            }
        }
        LogManager.log("WARN: Student not found by this email - " + email);
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
        LogManager.log("AUDIT: Displayed all faculties");
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
        LogManager.log("AUDIT: Displayed faculties related to " + studyField);
    }
}
