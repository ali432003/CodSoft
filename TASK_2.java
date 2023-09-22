package CodSoft;
import java.util.*;

public class TASK_2 {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t Welcome to Student Grade Calculator\n");
        System.out.println("Enter No of Subjects: ");
        int sub = scanner.nextInt();
        double total_tot_marks = 0;
        double total_obt_marks = 0;
        
        for(int i = 1 ; i<=sub ; i++) {
        	System.out.printf("Enter Obtain marks of sub %d:  ",i);
        	double obtMarks = scanner.nextDouble();
        	System.out.printf("Enter Total(outOf) marks of %d subject: ",i);
            double totMarks = scanner.nextDouble();
            while(obtMarks>totMarks) {
            	System.out.println("\nWrong input Enter Again...\n");
            	System.out.printf("\nEnter Obtain marks of sub %d:  ",i);
            	obtMarks = scanner.nextDouble();
            	System.out.printf("\nEnter Total(outOf) marks of %d subject: ",i);
                totMarks = scanner.nextDouble();
            }
        	total_obt_marks += obtMarks;
        	total_tot_marks += totMarks;
        }
        
        
        double perCentt = (double) (((int)total_obt_marks/total_tot_marks)*100) ;
        
        
        // Grading System
        if(perCentt>=0 && perCentt<=50) {
        	System.out.printf("\n\t\t Your Grade: F \n\t\tYour Percentage: %f %% \n\t\tTotal marks Obtained: %f",perCentt,total_obt_marks);
        }
        else if(perCentt>=51 && perCentt<=60) {
        	System.out.printf("\n\t\t Your Grade: C \n\t\tYour Percentage: %f %% \n\t\tTotal marks Obtained: %f",perCentt,total_obt_marks);
        } 
        else if(perCentt>=61 && perCentt<=74) {
        	System.out.printf("\n\t\t Your Grade: B \n\t\tYour Percentage: %f %% \n\t\tTotal marks Obtained: %f",perCentt,total_obt_marks);
        }
        else if(perCentt>=75 && perCentt<=84) {
        	System.out.printf("\n\t\t Your Grade: A \n\t\tYour Percentage: %f %% \n\t\tTotal marks Obtained: %f",perCentt,total_obt_marks);
        }
        else{
        	System.out.printf("\n\t\t Your Grade: A+ \n\t\tYour Percentage: %f %% \n\t\tTotal marks Obtained: %f",perCentt,total_obt_marks);
        }
        
      }
}
