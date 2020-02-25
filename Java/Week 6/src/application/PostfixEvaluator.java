//********************************************************************
//  PostfixEvaluator.java       
//
//  Represents an evaluator of postfix expressions. Assumes the
//  operands are constants.
//********************************************************************

package application;

//import dataStructures.LinkedStack;
import dataStructures.*;
import java.util.StringTokenizer;

public class PostfixEvaluator
{
   private final char ADD = '+', SUBTRACT = '-';
   private final char MULTIPLY = '*', DIVIDE = '/';

   private ArrayStack<Integer> stack;

   //-----------------------------------------------------------------
   //  Sets up this evalutor by creating a new stack.
   //-----------------------------------------------------------------
   public PostfixEvaluator()
   {
      stack = new ArrayStack<Integer>();
   }

   //-----------------------------------------------------------------
   //  Evaluates the specified postfix expression. If an operand is
   //  encountered, it is pushed onto the stack. If an operator is
   //  encountered, two operands are popped, the operation is
   //  evaluated, and the result is pushed onto the stack.
   //-----------------------------------------------------------------
   public int evaluate (String expr)
   {
      Integer operator1, operator2; 
      int op1, op2, result = 0;
      String token;
      StringTokenizer tokenizer = new StringTokenizer (expr);

      while (tokenizer.hasMoreTokens())
      {
         token = tokenizer.nextToken();

         if (isOperator(token))
         {
            operator1 = (Integer) stack.pop(); 
            op1 = operator1.intValue();
            operator2 = (Integer) stack.pop(); 
            op2 = operator2.intValue();
            result = evalSingleOp (token.charAt(0), op1, op2);
            stack.push (new Integer(result));
         }
         else
            stack.push (new Integer(Integer.parseInt(token)));
      }

      return result;
   }


   //-----------------------------------------------------------------
   //  Determines if the specified token is an operator.
   //-----------------------------------------------------------------
   private boolean isOperator (String token)
   {
      return ( token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/") );
   }

   //-----------------------------------------------------------------
   //  Evaluates a single expression consisting of the specified
   //  operator and operands.
   //-----------------------------------------------------------------
   private int evalSingleOp (char operation, int op1, int op2)
   {
      int result = 0;

      switch (operation)
      {
         case ADD:
            result = op1 + op2;
            break;
         case SUBTRACT:
            result = op1 - op2;
            break;
         case MULTIPLY:
            result = op1 * op2;
            break;
         case DIVIDE:
            result = op1 / op2;
      }

      return result;
   }
}
