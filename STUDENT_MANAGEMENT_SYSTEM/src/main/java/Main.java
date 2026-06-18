import model.Student;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentRepository repository =
                new InMemoryStudentRepository();

        StudentService service =
                new StudentService(repository);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    service.addStudent(
                            new Student(name, address));

                    System.out.println("Student Added Successfully.");
                    break;

                case 2:

                    List<Student> students =
                            service.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        students.forEach(System.out::println);
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    Student found =
                            service.searchStudent(searchId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Student student =
                            service.searchStudent(updateId);

                    if (student != null) {

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Address: ");
                        String newAddress = sc.nextLine();

                        Student updatedStudent =
                                new Student(newName, newAddress);

                        updatedStudent.setId(updateId);

                        service.updateStudent(updatedStudent);

                        System.out.println("Student Updated.");
                    } else {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();

                    service.deleteStudent(deleteId);

                    System.out.println("Student Deleted.");
                    break;

                case 6:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}