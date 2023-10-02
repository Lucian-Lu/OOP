package secondlab;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;


public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;
    private Date gradDate;

    public Faculty() {
        this.students = new ArrayList<>();
    }

    public void assignFaculty() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the faculty name: ");
        this.name = scanner.next();
        System.out.print("Enter faculty abbreviation: ");
        this.abbreviation = scanner.next();
        System.out.println("Enter student details: ");
        Student student = new Student();
        student.createStudent();
        this.students.add(student);
        System.out.println("Pick from the study fields:\n" +
                "    1 = MECHANICAL_ENGINEERING,\n" +
                "    2 = SOFTWARE_ENGINEERING,\n" +
                "    3 = FOOD_TECHNOLOGY,\n" +
                "    4 = URBANISM_ARCHITECTURE,\n" +
                "    5 = VETERINARY_MEDICINE");
        byte option;
        option = scanner.nextByte();
        switch (option){
            case 1:
                this.studyField = StudyField.MECHANICAL_ENGINEERING;
                break;
            case 2:
                this.studyField = StudyField.SOFTWARE_ENGINEERING;
                break;
            case 3:
                this.studyField = StudyField.FOOD_TECHNOLOGY;
                break;
            case 4:
                this.studyField = StudyField.URBANISM_ARCHITECTURE;
                break;
            case 5:
                this.studyField = StudyField.VETERINARY_MEDICINE;
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }

        System.out.println("Faculty Name = " + this.name);
        System.out.println("Faculty Abbreviation = " + this.abbreviation);
        System.out.println("Faculty Students? = " + this.students);
        System.out.println("Study Field = " + this.studyField);
    }

    public void isGraduated() {
        Scanner scanner = new Scanner(System.in);
        this.gradDate = new Date(day, month, year);
        System.out.println(gradDate);
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        date = date.format(formatters);
        System.out.println(date);
        System.out.println(gradDate);
    }
}