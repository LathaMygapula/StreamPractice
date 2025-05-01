package com.example.StreamPractice.exercise2;

import org.yaml.snakeyaml.events.CollectionEndEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvancedStreams {
    record Student(String firstName, String lastName, String city, double grade, int age, String department) {
    }

    public static void main(String[] args) {
        List<Student> students = mockStudentData();

        // 1. Find students from Miami with a grade greater than 8.0
        List<Student> studentsFromMiamiAndGrade8 = students.stream()
                .filter(student -> student.city.equals("Miami") && student.grade > 8.0)
                .toList();
        System.out.println("1. Find students from Miami with a grade greater than 8.0 -> " + studentsFromMiamiAndGrade8);
        System.out.println("");

        // 2. Find the student with the highest grade
        Student studentWithHighGrade = students.stream()
                .sorted(Comparator.comparing(Student::grade, Collections.reverseOrder())).findFirst().get();
        System.out.println("2. Find the student with the highest grade -> "+studentWithHighGrade);
        System.out.println("");

        // 3. Count the number of students in each department
        Map<String, Long> studentsInEachDept = students.stream()
                .collect(Collectors.groupingBy(Student::department, Collectors.counting()));
        System.out.println("3. Count the number of students in each department -> "+studentsInEachDept);
        System.out.println("");

        // 4. Find the average grade per department
        Map<String, Double> avgGradeInEachDept = students.stream()
                .collect(Collectors.groupingBy(Student::department, Collectors.averagingDouble(Student::grade)));
        System.out.println("4. Find the average grade per department -> "+avgGradeInEachDept);
        System.out.println("");

        //5. List students sorted by age and then by grade
        List<String> sortedStudentList = students.stream()
                .sorted(Comparator.comparing(Student::age).thenComparing(Student::grade)).map(student -> student.firstName).toList();
        System.out.println("5. List students sorted by age and then by grade -> "+sortedStudentList);
        System.out.println("");

        // 6. Create a comma-separated list of student names
        String commaSeperatedStudentList = students.stream()
                .map(student -> student.firstName+" "+student.lastName).reduce((str1, str2) -> str1 + "," + str2).orElse("");
        System.out.println("6. Create a comma-separated list of student names -> "+commaSeperatedStudentList);
        System.out.println("");

        // 7. Check if all students are above 18
        boolean b = students.stream().allMatch(student -> student.age > 18);
        System.out.println("7. Check if all students are above 18 -> "+b);
        System.out.println("");

        // 8. Find the department with the most students
        Map.Entry<String, Long> stringLongEntry = students.stream()
                .collect(Collectors.groupingBy(Student::department, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println("8. Find the department with the most students -> "+stringLongEntry.getKey());
        System.out.println("");

        // 9. Divide students into those who have grades above 8.0 and below
        Map<Boolean, List<Student>> divideStudents = students.stream()
                .collect(Collectors.partitioningBy(student -> student.grade >= 8.0));
        System.out.println("9. Divide students into those who have grades above 8.0 and below -> "+divideStudents);
        System.out.println("");

        // 10. Find the student with the longest full name
        Optional<Student> longestStudentName = students.stream()
                .max(Comparator.comparingInt(name -> (name.firstName + name.lastName).length()));
        System.out.println("10. Find the student with the longest full name -> "+longestStudentName.orElse(null));

    }

    public static List<Student> mockStudentData() {
        return Arrays.asList(
                new Student("John", "Smith", "Miami", 8.38, 19, "Civil"),
                new Student("Mike", "Miles", "New York", 8.4, 21, "IT"),
                new Student("Michael", "Peterson", "New York", 7.5, 20, "Civil"),
                new Student("James", "Robertson", "Miami", 9.1, 20, "IT"),
                new Student("John", "Miller", "Miami", 7.83, 20, "Civil")
        );
    }
}
