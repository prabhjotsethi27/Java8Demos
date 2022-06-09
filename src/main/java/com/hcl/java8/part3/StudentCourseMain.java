package com.hcl.java8.part3;

import com.hcl.java8.part3.model.Course;
import com.hcl.java8.part3.service.StudentCourseService;

import java.time.LocalDate;
import java.util.List;

public class StudentCourseMain {
    public static void main(String[] args) {

        // Write a simple standalone Java application: (Use Main application with classes Student and Course)
        //Student should have their basic details associated with course details: course name, start and end dates
        //3. Get all student details based on given course input
        //4. Get the average score of all students for any given course
        //5. Get all available courses for the given input (next week, next month)
        
        StudentCourseService ob = new StudentCourseService();
        List<Course> courseList = ob.getStudentCourseDetails();
        System.out.println("Task 3.......");
        System.out.println("List of all courses: " + courseList.toString());
        Course courseById = ob.getStudentsByCourseId(102, courseList);
        System.out.println("\n 1. Getting all student details based on given course input: \n\t" + courseById.toString());
        double averageScore = ob.getAverageScoreByCourseId(courseById);
        System.out.println("\n\n 2. Getting the average score of all students for any given course: \n " + averageScore);
        System.out.println("\n\n 3. Getting all available courses for the given input (next week, next month): \n");
        LocalDate searchDate = LocalDate.of(2022,6,8);
        System.out.println("\n\t Search Date: Next week from today-> " + searchDate.plusDays(7L) + "\n\t List of available courses:" + ob.getAvailableCourses(courseList, 1, searchDate));
        System.out.println("\n\t Search Date: Next month from today-> " + searchDate.plusMonths(1L) + "\n\t List of available courses:" + ob.getAvailableCourses(courseList, 2, searchDate));
    }
}
