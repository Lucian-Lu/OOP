package secondlab;

import secondlab.models.Date;
import secondlab.models.Faculty;
import secondlab.models.Student;
import secondlab.models.University;

import java.util.*;
import java.time.LocalDate;

public class Main {

    private Scanner scanner;
    private University university;

    public Main() {
        scanner = new Scanner(System.in);
        university = new University();
    }

    public void run() {

        while (true) {
            System.out.print("\nWelcome to TUM's management system!\n" +
                    "What do you want to do?\n" +
                    "g - General operations\n" +
                    "f - Faculty operations\n" +
                    "s - Student operations\n\n" +
                    "q - Quit Program\n" +
                    "> ");

            String option = scanner.nextLine();

            switch (option) {
                case "g":
                    generalOperations();
                    break;
                case "f":
                    facultyOperations();
                    break;
                case "s":
                    studentOperations();
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

    }

    public void generalOperations() {
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("\nGeneral operations\n" +
                    "What do you want to do?\n" +
                    "nf/<faculty name>/<faculty abbreviation>/<field> - create faculty\n" +
                    "ss/<student email> - search student and show faculty\n" +
                    "df - display faculties\n" +
                    "df/<field> - display all faculties of a field\n\n" +
                    "b - Back\n" +
                    "q - Quit program\n" +
                    "> ");
            String option = scanner.nextLine();
            String[] optionCommands = option.split("/");
            switch (optionCommands[0]) {
                case "nf":
                    university.createFaculty(optionCommands[1], optionCommands[2], optionCommands[3]);
                    break;
                case "ss":
                    university.searchStudentFaculty(optionCommands[1]);
                    break;
                case "df":
                    if (optionCommands.length == 1) {
                        university.displayFaculties();
                    } else {
                        university.displayAllStudyFieldFaculties(optionCommands[1]);
                    }
                    break;
                case "b":
                    keepLooping = false;
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }

    public void facultyOperations() {
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("\nFaculty operations\n" +
                    "What do you want to do?\n" +
                    "ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year>" +
                    " - create student\n" +
                    "gs/<email> (g)raduate (s)tudent\n" +
                    "ds/<faculty abbreviation> (d)isplay enrolled (s)tudents\n" +
                    "dg/<faculty abbreviation> (d)isplay (g)raduated students\n" +
                    "bf/<faculty abbreviation>/<email> check if student (b) elongs to (f)aculty\n\n" +
                    "b - Back\n" +
                    "q - Quit Program\n" +
                    "> ");
            String option = scanner.nextLine();
            String[] optionCommands = option.split("/");
            switch (optionCommands[0]) {
                case "ns":
                    String[] enrollmentDate = LocalDate.now().toString().split("-");
                    Date formatEnrollmentDate = new Date(
                            (byte) Integer.parseInt(enrollmentDate[2]),
                            (byte) Integer.parseInt(enrollmentDate[1]),
                            (short) Integer.parseInt(enrollmentDate[0]));
                    Date formatBirthDate = new Date(
                            (byte) Integer.parseInt(optionCommands[5]),
                            (byte) Integer.parseInt(optionCommands[6]),
                            (short) Integer.parseInt(optionCommands[7]));
                    Faculty.addStudentToFaculty(optionCommands[1], optionCommands[2],
                            optionCommands[3], optionCommands[4], formatEnrollmentDate,
                            formatBirthDate);
                    break;
                case "gs":
                    Faculty.graduateStudent(optionCommands[1]);
                    break;
                case "ds":
                    Faculty.displayEnrolledStudents(optionCommands[1]);
                    break;
                case "dg":
                    Faculty.displayGraduatedStudents(optionCommands[1]);
                    break;
                case "bf":
                    Faculty.enrolledInFaculty(optionCommands[1], optionCommands[2]);
                    break;
                case "b":
                    keepLooping = false;
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }

    public void studentOperations() {
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("Student operations\n" +
                    "What do you want to do?\n" +
                    "cf/<email>/<first name> (c)hange (f)irst name\n"+
                    "cl/<email>/<last name> (c)hange (l)ast name\n\n" +
                    "b - Back\n" +
                    "q - Quit Program\n" +
                    "> ");
            String option = scanner.nextLine();
            String[] optionCommands = option.split("/");
            switch (optionCommands[0]) {
                case "cf":
                    Student.changeFirstName(optionCommands[1], optionCommands[2]);
                    break;
                case "cl":
                    Student.changeLastName(optionCommands[1], optionCommands[2]);
                    break;
                case "b":
                    keepLooping = false;
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }


    public static void main(String[] args) {
        Main app = new Main();
        app.run();
        app.scanner.close();
    }
}
