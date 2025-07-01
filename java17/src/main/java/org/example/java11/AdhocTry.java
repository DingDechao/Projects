//package org.example.java11;
//
//import com.ddc.projects.java11.entity.Person;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AdhocTry {
//
//    private void getInt(int intA) {
//        var intB = intA;
//        System.out.println("intA = " + intA);
//        System.out.println("intB = " + intB);
//        intB = 100;
//        System.out.println("intA = " + intA);
//        System.out.println("intB = " + intB);
//    }
//
//    private void getPerson(Person person) {
//        var newPerson = person;
//        System.out.println(person.toString());
//        System.out.println(newPerson.toString());
//        newPerson.setAge(100);
//        newPerson.setName("User");
//        System.out.println(person.toString());
//        System.out.println(newPerson.toString());
//        List<String> stringList = person.getSchoolList();
//        for (var school : stringList) {
//            System.out.println(school);
//        }
//
//
//    }
//    public static void main(String[] args) {
////        AdhocTry adhocTry = new AdhocTry();
////        adhocTry.getInt(200);
////
////        Person person = new Person();
////        person.setName("User100");
////        person.setAge(200);
////        List<String> schoolList = null;//List.of("1", "2");
////        person.setSchoolList(schoolList);
////        adhocTry.getPerson(person);
//
////        List<String> stringList = List.of("1", null);
//        List<Person> personList = new ArrayList<>();
//        Person person1 = new Person();
//        Person person2 = null;
//        personList.add(person2);
//        for (var s : personList) {
//            System.out.println(s.getAge());
//        }
//    }
//}
