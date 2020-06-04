package edu.miu.cs.cs425.lab10.eregistrarwebapi.service;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student registerStudent(Student student);
    Student updateStudent(Student updatedStudent, Long studentId);
    void deleteStudentById(Long studentId);
}
