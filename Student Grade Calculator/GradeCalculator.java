import java.util.Scanner;

public class GradeCalculator 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        int totalMarks = 0;
        
        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) 
        {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }
        
        // Calculate average percentage
        double averagePercentage = (totalMarks * 100.0) / (numSubjects * 100);
        
        // Determine grade
        String grade;
        if (averagePercentage >= 90) 
        {
            grade = "A";
        } 
        
        else if (averagePercentage >= 80) 
        {
            grade = "B";
        } 
        
        else if (averagePercentage >= 70) 
        {
            grade = "C";
        } 
        
        else if (averagePercentage >= 60) 
        {
            grade = "D";
        }
        
        else 
        {
            grade = "F";
        }
        
        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
