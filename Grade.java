// Grade.java
import java.io.Serializable;

public class Grade implements Comparable<Grade>, Serializable {
    private String course;
    private int grade;

    public Grade(String course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Grade other) {
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return course + ": " + grade;
    }
}
