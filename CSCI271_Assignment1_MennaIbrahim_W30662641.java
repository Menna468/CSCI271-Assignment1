/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Menna Ibrahim
* OS: Ubuntu Debian Linux 21.1
* Compiler: javac 25.0.1
* Date: Jan 22. 2026
*
* Purpose:
* This program calculates my grades when having 7 assignments, 7 tests, midterm, and a final exam.
*
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Menna Ibrahim
* W30662641
********************************************************************/
import java.util.Scanner;

public class CSCI271_Assignment1_MennaIbrahim_W30662641 {
    public static void main(String[] args) {
        //decalaring and initializing variables
        double E = 0;
        double assignment = 0;
        double totalAssignments = 0;
        double test;
        double tests = 0;
        boolean grades = true; //to check if the grades are there 


        //for the input, so the program can read the user's input
        Scanner input =  new Scanner(System.in);
        
        
        while (grades) {
            //For the assignments, it takes the grades from file and calculates the average weight 
            System.out.print("Enter your assignments grades: ");
            for (int i = 0; i < 7; i++) {
                assignment = input.nextInt();
                if (assignment <= -1) {
                    grades = false;
                    System.exit(-1);
                }
                
                totalAssignments += assignment;

                
            }
            totalAssignments = totalAssignments / 7;
            System.out.print("Total assignments grade: ");
            System.out.println(String.format("%.2f", totalAssignments));
            
            //For the tests, it takes the grades from file and calculates the average weight 
            System.out.print("Enter your tests grades: ");
            for (int i = 0; i < 7; i++) {
                test = input.nextInt();
                if (test <= -1) {
                    grades = false;
                    System.exit(-1);
                }
                tests += test;
                
            }
            tests = tests / 7;
            System.out.print("Total tests grade: ");
            System.out.println (String.format("%.2f", tests));
            
            //For the midterm and the final exam grades
            System.out.print("Enter your midterm grade: ");
            int midterm = input.nextInt();
            if (midterm <= -1) {
                    grades = false;
                    break;
                }

            System.out.print("Enter your final grade: ");
            int finalExam = input.nextInt();
            if (finalExam <= -1) {
                    grades = false;
                    break;
                }

            //the equation that calculates the average for all tests and exams 
            E = (((0.4 * finalExam) + (0.2 * midterm) + (0.1 * tests)) / 0.7);
            System.out.print("E is: " );
            System.out.println(String.format("%.2f", E));

            //the equation for the weight of the assignments
            double W = ((E - 60.0) / 20.0) * 0.3;
        
            //depending on the tests and exams average grade, it will output the equation for it
            if (E < 60) {
                    System.out.print("less than 60: ");
                    System.out.println(String.format("%.2f",E));
                }
                
                else if (E >= 80) {
                    System.out.print("more than 80: ");
                    System.out.println(String.format("%.2f", (0.4 * finalExam) + (0.2 * midterm) + (0.1 * tests) + (0.3 * totalAssignments)));
                }

                else if (E >= 60 || E < 80) {
                    System.out.print("between 60 and 80: ");
                    System.out.println(String.format("%.2f", ( 1 - W) * E + (W * totalAssignments)));
                    
                }

        }
            


        

        input.close();
    }
    }
