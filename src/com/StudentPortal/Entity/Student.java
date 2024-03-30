package com.StudentPortal.Entity;

public class Student {
    private Integer RollNo;
    private String Student_Name;
    private String Course;

    @Override
    public String toString() {
        return "RollNo : " + RollNo +
                "Student_Name :" + Student_Name+
                "Course : " + Course;
    }

    public Student() {
    }

    public Student(Integer rollNo, String student_Name, String course) {
        RollNo = rollNo;
        Student_Name = student_Name;
        Course = course;
    }

    public Integer getRollNo() {
        return RollNo;
    }

    public void setRollNo(Integer rollNo) {
        RollNo = rollNo;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
