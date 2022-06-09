package com.hcl.java8.part3.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {
    String id;
    String name;
    int age;
    double marks;
    int courseId;

    public String toString() {
        return "Student{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", age=" + this.age + ", marks=" + this.marks + ", courseId=" + this.courseId + '}';
    }
}
