package repository;

import model.Student;

public interface StudentWriter {

    void save(Student student);

    void update(Student student);

    void delete(int id);
}