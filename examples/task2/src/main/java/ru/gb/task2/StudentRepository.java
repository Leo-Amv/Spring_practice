package ru.gb.task2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Alex","A"));
        students.add(new Student("Petr","B"));
        students.add(new Student("Alex","C"));
        students.add(new Student("Aleksey","C"));
        students.add(new Student("Alina","B"));
        students.add(new Student("Pedro","A"));
        students.add(new Student("Niko","B"));
        students.add(new Student("Nisa","A"));
        students.add(new Student("Leo","C"));
        students.add(new Student("Leman","A"));
        students.add(new Student("Oleg","B"));
    }

    public Student getStudentbyId(long id){
        return students.stream().filter(it -> Objects.equals(it.getId(),id)).findFirst().orElse(null);
    }
    public List<Student> getStudents(){
        return List.copyOf(students);
    }
    public List<Student> getStudentbyName(String name ){
        return students.stream().filter(it -> it.getName().contains(name)).toList();
    }
    public List<Student> getStudentbyGroup(String group ){
        return students.stream().filter(it -> it.getGroupName().contains(group)).toList();
    }
    public void createStudent(Student student){
        students.add(student);
    }
    public void deleteStudent(long id){
        students.remove(getStudentbyId(id));
    }
}
