package com.democriteria.Criteria.service;


import com.democriteria.Criteria.entitiy.Student;
import com.democriteria.Criteria.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> findName(String name){
        return studentRepo.findName(name);
    }

    public List<Student> getStudents(int id){
        return studentRepo.getStudents(id);
    }

    public void save(Student student) {
        studentRepo.save(student);
    }

    public List<Student> likeBy(String name) {
        return studentRepo.likeBy(name);
    }



    public List<Student> findNameAsc() {
        return studentRepo.findNameAsc();
    }
}
