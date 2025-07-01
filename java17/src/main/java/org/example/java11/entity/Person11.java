package org.example.java11.entity;

import java.util.List;

public class Person11 {

    private String name;
    private int age;

    private List<String> schoolList;

    public Person11() {

    }

    public Person11(String name, int age, List<String> schoolList) {
        this.name = name;
        this.age = age;
        this.schoolList = schoolList;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<String> schoolList) {
        this.schoolList = schoolList;
    }
}
