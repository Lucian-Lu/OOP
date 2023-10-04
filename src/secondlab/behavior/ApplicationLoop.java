package secondlab.behavior;

import secondlab.models.*;
import secondlab.behavior.FileManager;

import java.time.LocalDate;
import java.util.Scanner;

public class ApplicationLoop {

    private Scanner scanner;
    private University university;

    public ApplicationLoop() {
        scanner = new Scanner(System.in);
        university = new University();
    }

    public void closeScanner() {
        scanner.close();
    }

    public void run() {
        boolean keepLooping = true;
        run :
        while (keepLooping) {
            System.out.print("\nWelcome to TUM's management system!\n" +
                    "What do you want to do?\n" +
                    "g - General operations\n" +
                    "f - Faculty operations\n" +
                    "s - Student operations\n" +
                    "o - batch operations\n\n" +
                    "q - Quit Program\n" +
                    "> ");

            String option = scanner.nextLine();
            LogManager.log("AUDIT: Entered command - main menu: " + option);

            switch (option) {
                case "g":
                    keepLooping = generalOperations();
                    break;
                case "f":
                    keepLooping = facultyOperations();
                    break;
                case "s":
                    keepLooping = studentOperations();
                    break;
                case "o":
                    keepLooping = batchOperations();
                    break;
                case "q":
                    LogManager.log("INFO: Exiting program - main menu");
                    System.out.println("Exiting program...");
                    break run;
                default:
                    LogManager.log("WARN: Wrong option - main menu");
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

    }

    public boolean generalOperations() {
        LogManager.log("AUDIT: Using general operations");
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
            LogManager.log("AUDIT: Entered command - general operations: " + option);
            String[] optionCommands = option.split("/");
            switch (optionCommands[0]) {
                case "nf":
                    university.createFaculty(optionCommands[1], optionCommands[2],
                            StudyField.valueOf(optionCommands[3]));
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
                    LogManager.log("AUDIT: Back from - general operations");
                    keepLooping = false;
                    break;
                case "q":
                    LogManager.log("INFO: Exiting program - general operations");
                    System.out.println("Exiting program...");
                    return false;
                default:
                    LogManager.log("WARN: Wrong option - general operations");
                    System.out.println("Invalid option. Try again.\n");
            }
        }
        return true;
    }

    public boolean facultyOperations() {
        LogManager.log("AUDIT: Using faculty operations");
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
            LogManager.log("AUDIT: Entered command - faculty operations: " + option);
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
                    Faculty.createAndAddStudentToFaculty(optionCommands[1], optionCommands[2],
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
                    LogManager.log("AUDIT: Back from - faculty operations");
                    keepLooping = false;
                    break;
                case "q":
                    LogManager.log("INFO: Exiting program - faculty operations");
                    System.out.println("Exiting program...");
                    return false;
                default:
                    LogManager.log("WARN: Wrong option - faculty operations");
                    System.out.println("Invalid option. Try again.\n");
            }
        }
        return true;
    }

    public boolean studentOperations() {
        LogManager.log("AUDIT: Using student operations");
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("Student operations\n" +
                    "What do you want to do?\n" +
                    "cf/<email>/<first name> (c)hange (f)irst name\n" +
                    "cl/<email>/<last name> (c)hange (l)ast name\n\n" +
                    "b - Back\n" +
                    "q - Quit Program\n" +
                    "> ");
            String option = scanner.nextLine();
            LogManager.log("AUDIT: Entered command - student operations: " + option);
            String[] optionCommands = option.split("/");
            switch (optionCommands[0]) {
                case "cf":
                    Student.changeFirstName(optionCommands[1], optionCommands[2]);
                    break;
                case "cl":
                    Student.changeLastName(optionCommands[1], optionCommands[2]);
                    break;
                case "b":
                    LogManager.log("AUDIT: Back from - student operations");
                    keepLooping = false;
                    break;
                case "q":
                    LogManager.log("INFO: Exiting program - student operations");
                    System.out.println("Exiting program...");
                    return false;
                default:
                    LogManager.log("WARN: Wrong option - student operations");
                    System.out.println("Invalid option. Try again.\n");
            }
        }
        return true;
    }

    public boolean batchOperations() {
        LogManager.log("AUDIT: Using batch operations");
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.print("Batch operations\n" +
                    "What do you want to do?\n" +
                    "be/<faculty abbreviation> (b)atch (e)nrollment\n" +
                    "bg (b)atch (g)raduation\n\n" +
                    "b - Back\n" +
                    "q - Quit Program\n" +
                    "> ");
            String option = scanner.nextLine();
            LogManager.log("AUDIT: Entered command - batch operations: " + option);
            String[] optionCommands = option.split("/");
            switch (optionCommands[0]) {
                case "be":
                    FileManager.enrollBatch(optionCommands[1]);
                    break;
                case "bg":
                    FileManager.graduateBatch();
                    break;
                case "b":
                    LogManager.log("AUDIT: Back from - batch operations");
                    keepLooping = false;
                    break;
                case "q":
                    LogManager.log("INFO: Exiting program - batch operations");
                    System.out.println("Exiting program...");
                    return false;
                default:
                    LogManager.log("WARN: Wrong option - batch operations");
                    System.out.println("Invalid option. Try again.\n");
            }
        }
        return true;
    }

}
