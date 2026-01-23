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
        boolean grades = true; //to check if the grades are there 


        //for the input, so the program can read the user's input
        Scanner input =  new Scanner(System.in);
        
        
        
        while (grades) {
            //decalaring and initializing variables
            double E = 0; //the average grade for all tests, midterm, and final exam
            double assignment = 0; //for each assignment 
            double totalAssignments = 0; //for all assginments together
            double test = 0; //for each test
            double tests = 0; //for all tests together
            double midterm = 0; //midterm 
            double finalExam = 0; //final
            double avgA = 0; //average assignments
            double avgT = 0; //average tests

            //For the assignments, it takes the grades from file and calculates the average weight 
            //the for loop takes the first 7 scores and reads them as assignments 
            for (int i = 0; i < 7; ++i) {
                assignment = input.nextInt();
                //if the assignment score was -1 then it stops by exiting the for loop
                if (assignment <= -1) {
                    grades = false;
                    System.exit(-1);
                }
                
                totalAssignments += assignment; //adds every new assignment score to all assignments
                
            }
            avgA = totalAssignments / 7;
            System.out.println();
            System.out.print("Average score of assignments: ");
            System.out.println(String.format("%.2f", avgA));
            
            //For the tests, it takes the grades from file and calculates the average weight 
            //the for loop takes the second 7 scores and reads them as tests
            for (int i = 0; i < 7; ++i) {
                test = input.nextInt();
                //if the test score was -1 then it stops by exiting the for loop
                if (test <= -1) {
                    grades = false;
                    System.exit(-1);
                }
                tests += test; //adds every new test score to all tests
                
            }
            
                avgT = tests / 7;
                
            System.out.print("Average score of tests: ");
            System.out.println (String.format("%.2f", avgT));
            
            //For the midterm and the final exam grades
            midterm = input.nextInt();
            //if the midterm score was -1 then it stops by breaking out the loop
            if (midterm <= -1) {
                    grades = false;
                    break;
                }

            finalExam = input.nextInt();
            //if the final exam score was -1 then it stops by breaking out the loop
            if (finalExam <= -1) {
                    grades = false;
                    break;
                }

            //the equation that calculates the average for all tests and exams 
            E = (((0.4 * finalExam) + (0.2 * midterm) + (0.1 * avgT)) / 0.7);
            System.out.print("E is: " );
            System.out.println(String.format("%.2f", E));

            //the equation for the weight of the assignments
            double W = ((E - 60.0) / 20.0) * 0.3;
        
            //depending on the tests and exams average grade, it will output the equation for it
            //if E was below 60 then we print out final score as E
            if (E < 60) {
                    System.out.print("Since E is less than 60, so your final score is: ");
                    System.out.println(String.format("%.2f",E));
                }
                
                //if E was above 80 then we add the assignments to the equation
                else if (E >= 80) {
                    System.out.print("Since E is more than 80, so your final score is: ");
                    System.out.println(String.format("%.2f", (0.4 * finalExam) + (0.2 * midterm) + (0.1 * avgT) + (0.3 * avgA)));
                }

                //if E was between 60 and 80 then we increase the weight of the assignments based on how the student did in E and add it to the equation
                else if (E >= 60 && E < 80) {
                    System.out.print("Since E is between 60 and 80, so your final score is: ");
                    System.out.println(String.format("%.2f", (1 - W) * E + (W * avgA)));
                    
                }
            
                System.out.println("---------------------------------------------------------------------"); //divider
                

        }
            


        

        input.close(); //closes the scanner
    }
    }
