package ru.gb.task2;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Alex","A"));
        students.add(new Student("Petr","B"));
        students.add(new Student("Alex","C"));
        students.add(new Student("Alex","C"));
        students.add(new Student("Alex","B"));
        students.add(new Student("Alex","A"));
        students.add(new Student("Alex","B"));
        students.add(new Student("Alex","A"));
        students.add(new Student("Alex","C"));
        students.add(new Student("Alex","A"));
        students.add(new Student("Alex","B"));
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
    public void createStudent(String name,String groupName){
        students.add(new Student(name,groupName));
    }
    public void deleteStudent(long id){
        students.remove(getStudentbyId(id));
    }
}
