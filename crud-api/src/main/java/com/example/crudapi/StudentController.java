package com.example.crudapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    private final AtomicLong counter = new AtomicLong(2);

    public StudentController() {
        students.add(new Student(1L, "Asha", "IT"));
        students.add(new Student(2L, "Rahul", "Computer"));
    }

    // Read all students
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    // Create a student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(counter.incrementAndGet());
        students.add(student);
        return student;
    }

    // Update a student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student updatedStudent) {

        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(updatedStudent.getName());
                student.setCourse(updatedStudent.getCourse());
                return student;
            }
        }

        return null;
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean removed = students.removeIf(
                student -> student.getId().equals(id));

        if (removed) {
            return "Student deleted successfully";
        }

        return "Student not found";
    }
}
