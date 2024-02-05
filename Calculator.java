// Calculator.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    public double getAverageGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) return 0;

        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        return (double) sum / grades.size();
    }

    public double getMedianGrade(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) return 0;

        List<Grade> sortedGrades = new ArrayList<>(grades);
        Collections.sort(sortedGrades, Comparator.comparingInt(g -> g.getGrade()));

        int size = sortedGrades.size();
        int middle = size / 2;

        if (size % 2 == 0) {
            int median1 = sortedGrades.get(middle - 1).getGrade();
            int median2 = sortedGrades.get(middle).getGrade();
            return (double) (median1 + median2) / 2;
        } else {
            return sortedGrades.get(middle).getGrade();
        }
    }
}
