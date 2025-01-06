import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        while (true) {
            System.out.println("\nGrade Calculator Menu:");
            System.out.println("1. Enter grades");
            System.out.println("2. Calculate statistics");
            System.out.println("3. Display all grades");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    enterGrades(grades, scanner);
                    break;
                case 2:
                    if (!grades.isEmpty()) {
                        double average = calculateAverage(grades);
                        double highest = findHighest(grades);
                        double lowest = findLowest(grades);
                        displayStatistics(average, highest, lowest);
                    } else {
                        System.out.println("No grades entered yet.");
                    }
                    break;
                case 3:
                    if (!grades.isEmpty()) {
                        System.out.println("\nAll grades:");
                        for (double grade : grades) {
                            System.out.print(grade + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No grades entered yet.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            String response = scanner.next().toLowerCase();
            while (!response.equals("y") && !response.equals("n")) {
                System.out.print("Invalid input. Enter 'y' to continue or 'n' to exit: ");
                response = scanner.next().toLowerCase();
                scanner.nextLine(); // Consume newline left-over
            }
        }
    }

    private static void enterGrades(ArrayList<Double> grades, Scanner scanner) {
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            grades.add(grade);
        }
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static double findHighest(ArrayList<Double> grades) {
        if (grades.isEmpty()) {
            return 0;
        }
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static double findLowest(ArrayList<Double> grades) {
        if (grades.isEmpty()) {
            return 0;
        }
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    private static void displayStatistics(double average, double highest, double lowest) {
        System.out.println("\nGrade Statistics:");
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Highest: %.2f%n", highest);
        System.out.printf("Lowest: %.2f%n", lowest);
    }
}