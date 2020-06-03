package edu.miu.cs.cs425.demowebapps.eregistrar.service;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public abstract List<Student> getAllStudents();
    public abstract Student registerStudent(Student student);
    public abstract Student getStudentById(Long id);
    public abstract void deleteStudentById(Long studentId);
    public abstract List<Student> searchStudents(String searchString);
}
