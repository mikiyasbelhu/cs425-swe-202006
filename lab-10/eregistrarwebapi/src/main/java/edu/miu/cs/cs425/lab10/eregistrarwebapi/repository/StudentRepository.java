package edu.miu.cs.cs425.lab10.eregistrarwebapi.repository;

import edu.miu.cs.cs425.lab10.eregistrarwebapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrderByFirstName(String studentNumber, String firstName, String middleName, String lastName);
    List<Student> findAllByCgpaEquals(Double overdueFee);
    List<Student> findAllByEnrollmentDateEquals(LocalDate datePublished);
}
