package edu.miu.cs.cs425.demowebapps.eregistrar.controller;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.miu.cs.cs425.demowebapps.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    StudentService studentService;

    @Autowired
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value="/eregistrar/student/list")
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students",students);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");

        return modelAndView;
    }

    @GetMapping(value = "eregistrar/student/new")
    public String showStudentRegistrationForm(Model model){
        Student student = new Student();
        model.addAttribute(student);
        return "student/new";
    }

    @PostMapping(value = "eregistrar/student/new")
    public String registerStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model ){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            model.addAttribute(student);
            return "student/new";
        }
        studentService.registerStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = "eregistrar/student/edit/{studentId}")
    public String showStudentEditForm(@PathVariable Long studentId, Model model){
        Student student = studentService.getStudentById(studentId);
        model.addAttribute(student);
        return "student/edit";
    }

    @GetMapping(value = {"eregistrar/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/search", "/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
}
