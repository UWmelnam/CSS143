import java.util.Scanner;
import java.io.PrintWriter;
import java.io.*;

public class Grader {

    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        int numGrades = 0;
        do {  
            System.out.print("Enter the number of grades: ");
            numGrades = console.nextInt(); 

            if (numGrades <= 0) {
                System.out.println("Invalid number, please enter a positive integer.");
            }
        }
        while (numGrades <= 0);
        
        int[] grades = new int[numGrades];  

            System.out.println("Enter the grades seperated by spaces: ");
            for (int i = 0; i < numGrades; i++) {
                grades[i] = console.nextInt();
            }
            
            System.out.println("Enter the file name to save your grades: ");
            final String FILE_NAME = console.next();

            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
                for (int i = 0; i < numGrades; i++) {
                    writer.printf("%d %s\n", grades[i], getLetterGrade(grades[i]));
                }
            } catch (IOException | IllegalArgumentException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
            finally {
                System.out.printf("Average: %.2f\n", average(grades, numGrades));
                System.out.println("Grades saved to " + FILE_NAME); 
            }
        }

        public static String getLetterGrade(int score) {
            switch (score / 10) {
                case 10:
                return "A+";
                case 9: 
                return "A";
                case 8:
                return "B";
                case 7:
                return "C";
                case 6:
                return "D";
                case 5:
                return "F";
                default:
                return "NA";
            }
        }

        public static double average(int[] grades, int numGrades) { {

        double average = 0.0; 
        
        for (int i = 0; i < numGrades; i++) {
            average += grades[i];
        }

        average = average / numGrades;
        return average;
        }
    }
}