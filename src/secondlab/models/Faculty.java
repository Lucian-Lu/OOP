package secondlab.models;

import secondlab.Date;

import java.util.*;
import java.time.LocalDate;


public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;
    private secondlab.Date gradDate;


    public Faculty() {
        this.students = new ArrayList<>();
    }

    // TODO change name to reflect the method's functionality better
    public void assignFaculty() {
        // TODO not assign but assign student to faculty

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

        //scanner.close();
    }

    public void setGraduated() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input student email to modify the graduation status of: ");
        String email = scanner.next();
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                System.out.print("Input the student graduation status of the student: ");
                boolean gradStatus = scanner.nextBoolean();
                student.setGraduatedStatus(gradStatus);
            }
        }
        System.out.print(students);
        scanner.close();
//        LocalDate date = LocalDate.now();
//        String dateString = date.toString();
//        String[] dateString2 = dateString.split("-");
//        ArrayList<Integer> dateSt = new ArrayList<>();
//        for (String test : dateString2) {
//            int test2 = Integer.parseInt(test);
//            dateSt.add(test2);
//        }
//        Collections.swap(dateSt, 0, 2);
    }

}