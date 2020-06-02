package edu.miu.cs.cs425.demowebapps.eregistrar.service;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;

public interface StudentService {
    Iterable<Student> getAllStudents();
}
