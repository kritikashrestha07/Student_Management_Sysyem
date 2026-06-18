package service;

import model.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository repository;
    private int nextId = 1;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(Student student) {

        student.setId(nextId++);

        repository.save(student);

        System.out.println("Generated Student ID: " + student.getId());
    }

    public Student searchStudent(int id) {
        return repository.findById(id);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void updateStudent(Student student) {
        repository.update(student);
    }

    public void deleteStudent(int id) {
        repository.delete(id);
    }
}