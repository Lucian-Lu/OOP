package secondlab.models;


import secondlab.behavior.LogManager;

public class Student {
    private String firstName;
    private String lastName;
    private final String email;
    private final Date enrollmentDate;
    private final Date dateOfBirth;
    private boolean graduated;


    public Student(String firstName, String lastName, String email,
                   Date enrollmentDate, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getGraduate() {
        return graduated;
    }

    public void setGraduate(boolean graduated) {
        this.graduated = graduated;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void changeFirstName(String email, String firstName) {
        University university = new University();
        for (Faculty faculty : university.getFaculties()) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    student.setFirstName(firstName);
                    System.out.println("Student first name changed successfully.\n");
                    LogManager.log("AUDIT: Student (" +
                            student.getEmail() + ") - first name changed");
                    return;
                }
            }
        }
        LogManager.log("WARN: Student email not found while changing first name");
        System.out.println("Student email not found.\n");
    }

    public static void changeLastName(String email, String lastName) {
        University university = new University();
        for (Faculty faculty : university.getFaculties()) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    student.setLastName(lastName);
                    System.out.println("Student last name changed successfully.\n");
                    LogManager.log("AUDIT: Student (" +
                            student.getEmail() + ") - last name changed");
                    return;
                }
            }
        }
        LogManager.log("WARN: Student email not found while changing last name");
        System.out.println("Student email not found.\n");
    }

    @Override
    public String toString() {
        return ("\n" + firstName + "\n" + lastName + "\n" + email + "\n" + enrollmentDate + "\n" +
                dateOfBirth + "\n" + graduated + "\n");
    }
}
