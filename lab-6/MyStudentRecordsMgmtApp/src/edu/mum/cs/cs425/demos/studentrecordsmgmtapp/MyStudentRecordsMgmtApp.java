package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.*;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>(
                Arrays.asList(
                        new Student(110001,"Dave",LocalDate.parse("1951-11-18")),
                        new Student(110002,"Anna",LocalDate.parse("1990-07-12")),
                        new Student(110003,"Erica",LocalDate.parse("1974-01-31")),
                        new Student(110004,"Carlos",LocalDate.parse("2009-08-22")),
                        new Student(110005,"Bob",LocalDate.parse("1990-03-05")))
        );

        // list of all students
        System.out.println("List of all students");
        printListOfStudents(students);

        // list of platinum students
        System.out.println("List of platinum students");
        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);
        platinumAlumniStudents.sort(Comparator.comparing(Student::getDateOfAdmission,Comparator.reverseOrder()));

        for(Student st:platinumAlumniStudents){
            System.out.println(st);
        }
        System.out.println(getListOfPlatinumAlumniStudents(students));

    }

    public static void printListOfStudents(List<Student> students){
        students.sort(Comparator.comparing(Student::getName));
        for(Student st:students){
            System.out.println(st);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(List<Student> students){
        List<Student> platinumAlumniStudents = new LinkedList<Student>();
        for(Student st:students){
            if(Calendar.getInstance().get(Calendar.YEAR) - st.getDateOfAdmission().getYear() >= 30){
                platinumAlumniStudents.add(st);
            }
        }
        return platinumAlumniStudents;
    }

}
