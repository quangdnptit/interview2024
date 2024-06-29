package com.example.demo.interview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.stream.Collectors;

public class JavaStream {
    public static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
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
    }
    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("My", 1);
        dataMap.put("Name", 2);
        dataMap.put("MQy", 3);

        dataMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(item ->
                System.out.println(item.getKey()));


        Student student = new Student("Q", 13);
        Student student1 = new Student("D", 23);
        Student student2 = new Student("N", 14);
        List<Student> studentList = Arrays.asList(student, student2, student1);
        List<Student> data = studentList.stream().sorted(Comparator.comparingInt(Student::getAge)).filter(std -> std.age < 15).collect(Collectors.toList());
        System.out.println(new ObjectMapper().writeValueAsString(data));
    }
}
