package secondlab.models;

import secondlab.Date;


import java.util.Scanner;


public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private boolean graduatedStatus;

    public void createStudent() {
        //String firstName, String lastName, String email, Date enrollmentDate,
        //                    Date dateOfBirth
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's first name: ");
        this.firstName = scanner.nextLine();
        System.out.print("Enter the student's last name: ");
        this.lastName = scanner.next();
        System.out.print("Enter the student's email: ");
        this.email = scanner.next();
        System.out.print("Enter the student's enrollment date (DD.MM.YYYY): ");
        byte enrollment_day = scanner.nextByte();
        byte enrollment_month = scanner.nextByte();
        short enrollment_year = scanner.nextShort();
        this.enrollmentDate = new Date(enrollment_day, enrollment_month, enrollment_year);
        System.out.print("Enter the student's date of birth (DD.MM.YYYY): ");
        byte birth_day = scanner.nextByte();
        byte birth_month = scanner.nextByte();
        short birth_year = scanner.nextShort();
        this.dateOfBirth = new Date(birth_day, birth_month, birth_year);

        System.out.println("First Name = " + this.firstName);
        System.out.println("Last Name = " + this.lastName);
        System.out.println("Email = " + this.email);
        System.out.println("Enrollment Date = " + this.enrollmentDate);
        System.out.println("Date of Birth = " + this.dateOfBirth);
        scanner.close();
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

    public void setGraduatedStatus(Boolean graduatedStatus) {
        this.graduatedStatus = graduatedStatus;
    }

//    public void test() {
//        Scanner scanner = new Scanner(System.in);
//        Student student = new Student();
//        byte enrollment_day = scanner.nextByte();
//        byte enrollment_month = scanner.nextByte();
//        short enrollment_year = scanner.nextShort();
//        this.enrollmentDate = new Date(enrollment_day, enrollment_month, enrollment_year);
//        System.out.print(getEnrollmentDate());
//        scanner.close();
//    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

}
