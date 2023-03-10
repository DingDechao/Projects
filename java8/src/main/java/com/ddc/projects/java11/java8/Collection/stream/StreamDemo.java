package com.ddc.projects.java11.java8.Collection.stream;

import com.ddc.projects.java11.java8.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    static List<String> stringList = Arrays.asList("AAA", "BBB", "CCC", "DDD");
    static List<Employee> employeeList = null;

    static {
        Employee employee1 = new Employee(1l, "e1", 30, 100);
        Employee employee2 = new Employee(2l, "e2", 30, 100);
        Employee employee3 = new Employee(3l, "e3", 30, 100);
        Employee employee4 = new Employee(1l, "e4", 30, 100);
        Employee employee5 = new Employee(2l, "e5", 30, 100);
        Employee employee6 = new Employee(3l, "e6", 30, 100);
        Employee employee7 = new Employee(7l, "e7", 30, 100);
        Employee employee8 = new Employee(8l, "e8", 30, 100);
        Employee employee9 = new Employee(9l, "e9", 30, 100);
        Employee employee10 = new Employee(10l, "e10", 30, 100);
        Employee employee11 = new Employee(11l, "e11", 30, 100);
        Employee employee12 = new Employee(12l, "e12", 30, 100);
        employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

    }

    public static void main(String[] args) {
//        System.out.println(stringList.stream().findAny());
//        System.out.println(stringList.stream().parallel().findAny());
        Map<Long, List<Employee>> employeeList1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeparmentId));
        System.out.println(employeeList1);
        Map<Long, List<Employee>> employeeList2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeparmentId,Collectors.mapping()));
        System.out.println(employeeList1);
    }
}
