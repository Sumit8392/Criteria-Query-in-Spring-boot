package com.democriteria.Criteria.controller;

import com.democriteria.Criteria.entitiy.Student;
import com.democriteria.Criteria.service.StudentService;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public String save(@RequestBody Student student){
        studentService.save(student);
        return "New Student id Added";
    }

    //Criteria getStudent id;
    @GetMapping("/id/{id}")
    public List<Student> getid(@PathVariable("id") int id){
        List<Student> getResponse=studentService.getStudents(id);
        return getResponse;
    }

    @GetMapping("/findName/{name}")
    public List<Student> findName(@PathVariable("name") String name){
        return studentService.findName(name);
    }

    @GetMapping("/like/{name}")
    public List<Student> likeBy(@PathVariable("name") String name){
        List<Student> getResponse=studentService.likeBy(name);
        return getResponse;
    }
    @GetMapping("/findNameAsc")
    public List<Student> findNameAsc() {
        List<Student> getResponse = studentService.findNameAsc();
        return getResponse;

    }
}
