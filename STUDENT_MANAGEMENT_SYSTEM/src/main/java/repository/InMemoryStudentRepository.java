package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Student findById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void update(Student updatedStudent) {

        for (Student student : students) {

            if (student.getId() == updatedStudent.getId()) {

                student.setName(updatedStudent.getName());
                student.setAddress(updatedStudent.getAddress());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}