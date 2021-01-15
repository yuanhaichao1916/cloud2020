package designModel.entities;

import java.util.Objects;

public class Student {
    String name;
    int grade;
    Status status;


    public Student() {
    }

    public Student(int grade) {
        this.grade = grade;
    }

    public Student(String name, int grade,Status status) {
        this.name = name;
        this.grade = grade;
        this.status = status;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade &&
                Objects.equals(name, student.name) &&
                status == student.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade, status);
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
