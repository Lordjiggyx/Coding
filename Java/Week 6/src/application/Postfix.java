package application;

import java.util.Scanner;


//********************************************************************
//  Postfix.java      
//
//  Demonstrates the use of a stack to evaluate postfix expressions.
//********************************************************************


public class Postfix    
{
   //-----------------------------------------------------------------
   //  Reads and evaluates multiple postfix expressions.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String expression, again;
      int result;

     Scanner scan = new Scanner(System.in);
         do
         {
            PostfixEvaluator evaluator = new PostfixEvaluator();
            System.out.println ("Enter a valid postfix expression: ");
            
            expression = scan.nextLine();

            result = evaluator.evaluate (expression);
            System.out.println();
            System.out.println ("That expression equals " + result);

            System.out.print ("Evaluate another expression [Y/N]? ");
            again = scan.nextLine();
            System.out.println();
         }
         while (again.equalsIgnoreCase("y"));
      
   }
}
