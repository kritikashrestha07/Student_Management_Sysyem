package repository;

import model.Student;
import java.util.List;

public interface StudentReader {

    Student findById(int id);

    List<Student> findAll();
}