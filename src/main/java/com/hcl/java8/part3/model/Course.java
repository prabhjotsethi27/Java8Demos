package com.hcl.java8.part3.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class Course {

    String courseName;
    Integer courseId;
    public LocalDate startDate;
    public LocalDate endDate;
    List<Student> students;

    public String toString() {
        return "\n\t Course{courseName='" + this.courseName + '\'' + ", courseId=" + this.courseId + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", \n\t Students List=" + this.students.toString() + '}';
    }

}
