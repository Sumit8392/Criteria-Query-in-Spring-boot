package com.democriteria.Criteria.entitiy;


import javax.persistence.*;

@Entity
@Table(name = "student_data")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String rollNumber;

    private String university;

    public Student() {
    }

    public Student(int id, String name, String rollNumber, String university) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
