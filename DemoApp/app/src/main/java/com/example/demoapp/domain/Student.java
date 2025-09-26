package com.example.demoapp.domain;

import java.util.Date;

public class Student {
    private String name;
    private Date enrollmentDate;
    private String faculty;
    //private String studyType;
    private StudyType studyType;


    public Student(String name, Date enrollmentDate, String faculty, StudyType studyType) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
        this.faculty = faculty;
        this.studyType = studyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", faculty='" + faculty + '\'' +
                ", studyType=" + studyType +
                '}';
    }
}
