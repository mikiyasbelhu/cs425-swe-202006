package edu.miu.cs.cs425.demowebapps.eregistrar;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.miu.cs.cs425.demowebapps.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EregistrarApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(EregistrarApplication.class, args);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(1L,"000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019,5,24), true);
        Student student2 = new Student(2L,"000-61-0002", "John", "Trester", "George", 3.24, LocalDate.of(2019,5,21), false);
        saveStudent(student1);
        saveStudent(student2);
    }
}
