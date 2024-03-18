package ru.gb.task2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Student getStudentbyId(@PathVariable long id){
        if (repository.getStudentbyId(id) == null){
            throw new IllegalStateException();
        }
        return repository.getStudentbyId(id);
    }

    @GetMapping()
    public List<Student> getAllStudents(){
      return repository.getStudents();
    }

    @GetMapping("/search")
    public List<Student> getStudentsByName(@RequestParam String name){
        return repository.getStudentbyName(name);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName){
        return repository.getStudentbyGroup(groupName);
    }

    @PostMapping("/add")
    public void createStudent(String name,String groupName){
        repository.createStudent(name, groupName);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id){
        repository.deleteStudent(id);
    }
}
