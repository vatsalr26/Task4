// App.java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("1) Add student, 2) List students, 3) Add course completion for student, " +
                    "4) List course completions of student, 5) Calculate the average of course completions, " +
                    "6) Calculate median of course completions, 7) Save students to file, " +
                    "8) Load students from file, 0) End the program");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addStudent(scanner, university);
                        break;

                    case 2:
                        listStudentsForAddCourse(university);
                        break;

                    case 3:
                        addCourseCompletion(scanner, university);
                        break;

                    case 4:
                        listCourseCompletions(scanner, university);
                        break;

                    case 5:
                        calculateAverage(scanner, university, calculator);
                        break;

                    case 6:
                        calculateMedian(scanner, university, calculator);
                        break;

                    case 7:
                        university.saveToFile();
                        break;

                    case 8:
                        university.loadFromFile();
                        break;

                    case 0:
                        System.out.println("Thank you for using the program.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Wrong input value");
                }
            } catch (Exception e) {
                System.out.println("Wrong input value");
                scanner.nextLine(); 
            }
        }
    }


    private static void addStudent(Scanner scanner, University university) {
        try {
            System.out.println("What is the name of the student?");
            String name = scanner.nextLine();
    
            System.out.println("What is the student number of the student?");
            String studentNumberStr = scanner.nextLine();
    
            // Validate student ID
            if (studentNumberStr.length() != 7 || !studentNumberStr.matches("\\d+")) {
                System.out.println("Wrong input value");
                return;
            }
    
            int studentNumber = Integer.parseInt(studentNumberStr);
            Student student = new Student(name, studentNumberStr); // Use studentNumberStr to preserve leading zeros
            university.addStudent(student);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input value");}
    }
    
    
    

    private static void addCourseCompletion(Scanner scanner, University university) {
        listStudentsForAddCourse(university);
        System.out.println("Which student do you want to add course completion for?");
        int studentIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Student selectedStudent = university.getStudents().get(studentIndex);
    
        System.out.println("What is the name of the course?");
        String courseName = scanner.nextLine();
        System.out.println("What is the grade of the course?");
        int grade = scanner.nextInt();
        selectedStudent.addGrade(courseName, grade);
    }
    
    private static void listStudentsForAddCourse(University university) {
        for (int i = 0; i < university.getStudents().size(); i++) {
            System.out.println(i + ": " + university.getStudents().get(i).getName());
        }
    }
    
    

    private static void listCourseCompletions(Scanner scanner, University university) {
        listStudentsForAddCourse(university);
        System.out.println("Which student do you want to list course completions for?");
        int studentIndexForList = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Student studentForList = university.getStudents().get(studentIndexForList);

        System.out.println("Course Completions:");
        for (Grade g : studentForList.getGrades()) {
            System.out.println(g);
        }
    }

    private static void calculateAverage(Scanner scanner, University university, Calculator calculator) {
        listStudentsForAddCourse(university);
        System.out.println("Which student do you want to calculate the average for?");
        int studentIndexForAverage = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Student studentForAverage = university.getStudents().get(studentIndexForAverage);

        double average = calculator.getAverageGrade(studentForAverage);
        System.out.println("Average is " + average);
    }

    private static void calculateMedian(Scanner scanner, University university, Calculator calculator) {
        listStudentsForAddCourse(university);
        System.out.println("Which student do you want to calculate the median for?");
        int studentIndexForMedian = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Student studentForMedian = university.getStudents().get(studentIndexForMedian);

        double median = calculator.getMedianGrade(studentForMedian);
        System.out.println("Median is " + median);
    }
}
