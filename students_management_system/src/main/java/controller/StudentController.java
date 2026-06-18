package controller;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentController {

    private final StudentDAO dao = new StudentDAOImpl();

    public void addStudent(Student student) {

        if (!student.getEmail().contains("@")) {
            System.out.println("Invalid Email.");
            return;
        }

        if (student.getMarks() < 0 ||
                student.getMarks() > 100) {

            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        dao.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    public Student getStudent(int id) {
        return dao.getStudentById(id);
    }

    public boolean updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    public boolean deleteStudent(int id) {
        return dao.deleteStudent(id);
    }

    public Student getTopper() {
        return dao.getTopper();
    }

    public List<Student> searchByCourse(String course) {
        return dao.searchByCourse(course);
    }
}