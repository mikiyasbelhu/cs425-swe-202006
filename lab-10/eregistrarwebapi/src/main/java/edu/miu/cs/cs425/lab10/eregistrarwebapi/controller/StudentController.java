package edu.miu.cs.cs425.lab10.eregistrarwebapi.controller;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab10.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    StudentService studentService;

    @Autowired
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value="/list")
    public List<Student> listStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = {"/get/{studentId}"})
    public Student getStudent(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/register")
    public Student registerStudent(@Valid @RequestBody Student student){
        return studentService.registerStudent(student);
    }

    @PutMapping(value = "/edit/{studentId}")
    public Student updateStudent(@Valid @RequestBody Student updatedStudent, @PathVariable Long studentId){

        System.out.println("updatedStudent");
        System.out.println(updatedStudent.getFirstName());
        return studentService.updateStudent(updatedStudent,studentId);
    }

    @DeleteMapping(value = {"/delete/{studentId}"})
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }


}
