// Grade.java
import java.io.Serializable;

public class Grade implements Serializable {
    private String course;
    private int grade;

    public Grade(String course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return course + ": " + grade;
    }
}
