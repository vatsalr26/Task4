// Calculator.java
import java.util.Collections;
import java.util.List;

public class Calculator {
    public double getAverageGrade(Student student) {
        List<Grade> grades = student.getGrades();

        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        return (double) sum / grades.size();
    }

    public double getMedianGrade(Student student) {
        List<Grade> grades = student.getGrades();

        if (grades.isEmpty()) {
            return 0.0;
        }

        Collections.sort(grades);
        int size = grades.size();

        if (size % 2 == 0) {
            int mid1 = size / 2 - 1;
            int mid2 = size / 2;
            return (double) (grades.get(mid1).getGrade() + grades.get(mid2).getGrade()) / 2;
        } else {
            int mid = size / 2;
            return grades.get(mid).getGrade();
        }
    }
}
