package com.democriteria.Criteria.repository;

import com.democriteria.Criteria.entitiy.Student;

import java.util.List;

public interface StudentCustomRepo
{

    public List<Student> getStudents (int id);

    public List<Student> findName(String name);

    public List<Student> likeBy(String name);

    public List<Student> findNameAsc();





    }
