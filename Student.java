// Student.java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private String studentNumber;
    private List<Grade> grades;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void addGrade(String course, int grade) {
        Grade newGrade = new Grade(course, grade);
        grades.add(newGrade);
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return studentNumber + ": " + name;
    }
}
