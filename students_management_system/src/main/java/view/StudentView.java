package view;

import controller.StudentController;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {

    private final StudentController controller =
            new StudentController();

    private final Scanner sc = new Scanner(System.in);

    public void start() {

        while(true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Topper");
            System.out.println("7. Search By Course");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> displayTopper();
                case 7 -> searchByCourse();
                case 8 -> {
                    System.out.println("Thank You");
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private void addStudent() {

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Course: ");
        String course = sc.nextLine();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();

        controller.addStudent(
                new Student(name, email, course, marks)
        );
    }

    private void viewStudents() {

        List<Student> students =
                controller.getAllStudents();

        students.forEach(System.out::println);
    }

    private void searchStudent() {

        System.out.print("Enter Student ID: ");

        int id = sc.nextInt();

        Student student =
                controller.getStudent(id);

        if(student == null)
            System.out.println("Student Not Found");
        else
            System.out.println(student);
    }

    private void updateStudent() {

        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Email: ");
        String email = sc.nextLine();

        System.out.print("New Course: ");
        String course = sc.nextLine();

        System.out.print("New Marks: ");
        double marks = sc.nextDouble();

        Student student =
                new Student(id,name,email,course,marks);

        if(controller.updateStudent(student))
            System.out.println("Updated");
        else
            System.out.println("Student Not Found");
    }

    private void deleteStudent() {

        System.out.print("Student ID: ");

        int id = sc.nextInt();

        if(controller.deleteStudent(id))
            System.out.println("Deleted");
        else
            System.out.println("Student Not Found");
    }

    private void displayTopper() {

        Student topper = controller.getTopper();

        if(topper != null)
            System.out.println(topper);
        else
            System.out.println("No Records");
    }

    private void searchByCourse() {

        System.out.print("Course: ");

        String course = sc.nextLine();

        List<Student> students =
                controller.searchByCourse(course);

        students.forEach(System.out::println);
    }
}