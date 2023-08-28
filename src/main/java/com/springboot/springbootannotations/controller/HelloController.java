package com.springboot.springbootannotations.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.springbootannotations.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
         return "hello world";
    }

    @GetMapping("/student")
    public Student student(){
        Student std=new Student(1,"surya",24);
        return std;
    }
     @GetMapping("/students")
    public List<Student> students(){
        List<Student>  students=new ArrayList<>();
         students.add(new Student(1,"surya",24));
         students.add(new Student(1,"surya",24));
         students.add(new Student(1,"surya",24));
         students.add(new Student(1,"surya",24));
         return students;
     }
    @GetMapping("/students/{id}")
     public Student studentPathVariable(@PathVariable int id){
        return new Student(id,"surya",24);
    }
    @GetMapping("students/query")
    public Student studentRequestParam(@RequestParam int id){
         return new Student(id,"surya",22);

    }
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student studentData(@RequestBody Student student){
        System.out.println(student.getName());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return student;

    }
}
