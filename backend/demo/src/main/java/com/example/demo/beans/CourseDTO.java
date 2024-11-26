package com.example.demo.beans;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String courseCode;
    private String courseName;
    private Integer specialization;
    private Integer credit;
    private String facId;
    private Integer maxStudents;
    private Integer maxTa;
}
