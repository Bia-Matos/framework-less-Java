package simplerest.demo.service;

import com.google.gson.Gson;
import simplerest.demo.entity.Student;
import simplerest.demo.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentService {
    private ConcurrentMap<Integer, Student> students;
    private AtomicInteger key;

    public StudentService() {
        this.students = new ConcurrentHashMap<>();
        key = new AtomicInteger();

        this.addStudent(new Student("Beatriz", 10));
        this.addStudent(new Student("Joao", 8));
        this.addStudent(new Student("Pedro", 5));
    }

    public String getStudents() {
        List<Student> studentList = new ArrayList<>(this.students.values());

        return Util.toJson(studentList);
    }

    public boolean createStudent(String jsonPayload) {
        if (jsonPayload != null) {
            Gson gson = new Gson();
            Student student = gson.fromJson(jsonPayload, Student.class);
            this.addStudent(student);
            return true;
        }
        return false;
    }

    private void addStudent(Student student) {
        Integer id = key.incrementAndGet();
        student.setId(id);
        this.students.put(id, student);
    }
}
