package secondlab.models;

import java.util.*;


public class Faculty {
    private final String name;
    private final String abbreviation;
    private List<Student> students;
    private final StudyField studyField;


    public Faculty(String name, String abbreviation, String studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.students = new ArrayList<>();
        this.studyField = StudyField.valueOf(studyField);
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public List<Student> getStudents() {
        return students;
    }

    public static void addStudentToFaculty(String abbreviation, String firstName, String lastName,
                                    String email, Date enrollmentDate, Date birthDate) {
        University university = new University();
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                Student student = new Student(firstName, lastName,
                        email, enrollmentDate, birthDate);
                faculty.students.add(student);
                System.out.println("Student successfully added to faculty.\n");
                return;
            }
        }
        System.out.println("Faculty not found.\n");
    }

    public static void graduateStudent(String email) {
        University university = new University();
        for (Faculty faculty : university.getFaculties()) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    student.setGraduate(true);
                    System.out.println("Student graduated successfully.\n");
                    return;
                }
            }
        }
        System.out.println("Student not found. Please make sure to check for typos.\n");
    }

    public static void displayEnrolledStudents(String abbreviation) {
        University university = new University();
        int i = 1;
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                for (Student student : faculty.getStudents()) {
                    if (!student.getGraduate()) {
                        System.out.println("Student nr: " + i + "\n" +
                                "Student first name: " + student.getFirstName() + "\n" +
                                "Student last name: " + student.getLastName() + "\n" +
                                "Student email: " + student.getEmail() + "\n" +
                                "Student enrollment date: " + student.getEnrollmentDate() + "\n" +
                                "Student date of birth: " + student.getDateOfBirth() + "\n");
                        i++;
                    }
                }
            }
        }
        if (i == 1) {
            System.out.println("No students have been found. Check your faculty abbreviation.\n");
        }
    }

    public static void displayGraduatedStudents(String abbreviation) {
        University university = new University();
        int i = 1;
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                for (Student student : faculty.getStudents()) {
                    if (student.getGraduate()) {
                        System.out.println("Student nr: " + i + "\n" +
                                "Student first name: " + student.getFirstName() + "\n" +
                                "Student last name: " + student.getLastName() + "\n" +
                                "Student email: " + student.getEmail() + "\n" +
                                "Student enrollment date: " + student.getEnrollmentDate() + "\n" +
                                "Student date of birth: " + student.getDateOfBirth() + "\n");
                        i++;
                    }
                }
            }
        }
        if (i == 1) {
            System.out.println("No students have been found. Check your faculty abbreviation.\n");
        }
    }

    public static void enrolledInFaculty(String abbreviation, String email) {
        String[] email_abbreviation = email.split("[@.]");
        if (abbreviation.equals(email_abbreviation[2])) {
            System.out.println("Student is enrolled in this faculty.\n");
            return;
        }
        System.out.println("Student is not enrolled in this faculty.\n");
    }

}