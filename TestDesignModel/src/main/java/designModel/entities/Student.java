package designModel.entities;

public class Student {
    String name;
    int grade;

    public Student() {
    }

    public Student(int grade) {
        this.grade = grade;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
