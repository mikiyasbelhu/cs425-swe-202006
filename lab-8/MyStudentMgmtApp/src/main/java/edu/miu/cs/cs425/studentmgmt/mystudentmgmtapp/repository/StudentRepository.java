package edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.repository;

import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
