package com.hcl.java8.part3.service;

import com.hcl.java8.part3.model.Course;
import com.hcl.java8.part3.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentCourseService {
    public List<Course> getStudentCourseDetails() {
        List<Student> csList = new ArrayList<>();
        csList.add(Student.builder().age(20).marks(88.0D).name("Stud CS 1").id("CS1").courseId(101).build());
        csList.add(Student.builder().age(21).marks(67.0D).name("Stud CS 2").id("CS2").courseId(101).build());
        Course course1 = Course.builder().courseId(101).courseName("CS ENGG").startDate(LocalDate.of(2022, 6, 8)).endDate(LocalDate.of(2022, 6, 15)).students(csList).build();
        List<Student> mechList = new ArrayList();
        mechList.add(Student.builder().age(25).marks(60.0D).name("Stud Mech 1").id("MH1").courseId(102).build());
        mechList.add(Student.builder().age(22).marks(86.0D).name("Stud Mech 2").id("MH2").courseId(102).build());
        mechList.add(Student.builder().age(28).marks(98.0D).name("Stud Mech 3").id("MH3").courseId(102).build());
        Course course2 = Course.builder().courseName("MECH ENGG").courseId(102).startDate(LocalDate.of(2022, 6, 13)).endDate(LocalDate.of(2022, 7, 15)).students(mechList).build();
        List<Student> techList = new ArrayList();
        techList.add(Student.builder().age(27).marks(75.0D).name("Stud Tech 1").id("TE1").courseId(103).build());
        Course course3 = Course.builder().courseName("BIO TECH").courseId(103).startDate(LocalDate.of(2022, 7, 1)).endDate(LocalDate.of(2022, 7, 22)).students(techList).build();
        List<Course> testData = Arrays.asList(course1, course2, course3);
        return testData;
    }

    public Course getStudentsByCourseId(Integer courseId, List<Course> courseList) {
        return courseList.stream().filter((c) -> {
            return c.getCourseId() == courseId;
        }).findFirst().get();
    }

    public double getAverageScoreByCourseId(Course foundCourse) {
        return foundCourse.getStudents().stream().mapToDouble(Student::getMarks).average().getAsDouble();
    }

    public String getAvailableCourses(List<Course> courseList, Integer timeFlag, LocalDate searchDate) {

        if (timeFlag == 1) {
            searchDate = searchDate.plusDays(7L);
        }

        if (timeFlag == 2) {
            searchDate = searchDate.plusMonths(1L);
        }

        LocalDate finalSearchDate = searchDate;
        Predicate<Course> checkStartDate = (course) ->
            course.startDate.isBefore(finalSearchDate) || course.startDate.isEqual(finalSearchDate);
        Predicate<Course> checkEndDate = (course) ->
            course.endDate.isAfter(finalSearchDate) || course.endDate.isEqual(finalSearchDate);
        Predicate<Course> checkAvailableCourses = checkStartDate.and(checkEndDate);
        return (courseList.stream().filter(checkAvailableCourses).collect(Collectors.toList())).toString();
    }
}
