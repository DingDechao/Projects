package com.ddc.projects.java8.entity;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person implements Cloneable{

    private double salary;
    private Date hireDate;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
        this.hireDate = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee) super.clone();
        cloned.hireDate = (Date) hireDate.clone();
        return  cloned;
    }

    public void setHireDate(int year, int month, int day){
        Date newDate = new GregorianCalendar(year,month-1,day).getTime();
        hireDate.setTime(newDate.getTime());
    }
}
