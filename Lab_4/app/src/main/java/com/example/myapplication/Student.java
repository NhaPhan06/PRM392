package com.example.myapplication;

import java.io.Serializable;

public class Student implements Serializable {
    public Student(int id, String name, int grade) {
        Id = id;
        Name = name;
        Grade = grade;
    }

    private int Id;
    private String Name;
    private int Grade;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }
}
