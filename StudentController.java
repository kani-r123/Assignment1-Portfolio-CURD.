package com.example.crudapi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final List<Student> students = new ArrayList<>();
    private int nextId = 3;

    public StudentController() {
        students.add(new Student(1, "Asha", "IT"));
        students.add(new Student(2, "Rahul", "Computer"));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setCourse(updatedStudent.getCourse());
                return student;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean removed = students.removeIf(
            student -> student.getId() == id
        );
        return removed ? "Student deleted" : "Student not found";
    }
}
