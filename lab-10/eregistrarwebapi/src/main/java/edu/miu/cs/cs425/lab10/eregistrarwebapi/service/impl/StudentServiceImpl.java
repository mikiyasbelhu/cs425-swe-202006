package edu.miu.cs.cs425.lab10.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student updatedStudent, Long studentId) {
        return studentRepository.findById(studentId)
                .map(student -> {
                    student.setStudentNumber(updatedStudent.getStudentNumber());
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setMiddleName(updatedStudent.getMiddleName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setCgpa(updatedStudent.getCgpa());
                    student.setEnrollmentDate(updatedStudent.getEnrollmentDate());
                    student.setInternational(updatedStudent.getInternational());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> studentRepository.save(updatedStudent));
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

}
