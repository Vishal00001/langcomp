package com.utility.comparisonutility;

import com.utility.comparisonutility.utils.MathUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vishal on 18/3/21.
 */
public class PostfixNotation implements PolishNotation {

    private Scanner sc;

    public PostfixNotation(){
        this.sc = new Scanner(System.in);
    }

    /**
     * runPolishNotation method is a default implementatiion to run the polish notation
     * @argument no arguments
     * @return void
     */
    @Override
    public void runPolishNotation() {

        boolean flag = true;


        while (flag) {
            System.out.println("Please enter the expression:");
            try {
                System.out.println("Your result is: " + evalPostfix(sc.nextLine()));
            } catch (Exception e) {
                System.err.println(e.getStackTrace());
            }

            System.out.println("Do you want to continue? (Y/N)");
            flag = StringUtils.equalsIgnoreCase(sc.nextLine().trim(), "Y") ? true : false;
        }

        if (!flag) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    /**
     * evalPostfix method evaluate the Reverse Polish Notation
     * argument required String expression
     * return value is double
     */
    @Override
    public double evalPostfix(String exp) throws Exception{
        //Create a stack
        Stack<Double> stack = new Stack<>();

        if(org.apache.commons.lang3.StringUtils.isBlank(exp)){
            throw new Exception("Expression can not be null, It should be, for eg. 1 2 3 + -, 5 1 2 + 4 * + 3 - in such format.");
        }

        // read all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == ' ')
                continue;

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isAlphabetic(c)){
                throw new IllegalArgumentException("You have entered an illegal expression, expression can not be alphanumeric.\n For eg. 1 2 3 + -, 5 1 2 + 4 * + 3 -");
            }

            // If the scanned character is an operand
            // (number here),extract the number
            // Push it to the stack.
            else if (Character.isDigit(c)) {
                int n = 0;

                //extract the characters and store it in num
                while (Character.isDigit(c)) {

                    if (c == ' ')
                        continue;

                    n = n * 10 + (c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;

                //push the number in stack
                stack.push((double) (n));
            }
            else {
                double val1 = stack.pop();
                double val2 = 0.0;

                switch (c) {

                    case '^':
                        val2 = stack.pop();
                        stack.push(Math.pow(val2, val1));
                        break;

                    case '%':
                        stack.push(val1/100);
                        break;

                    case '!':
                        stack.push(MathUtils.evalFactorial((int)val1).doubleValue());
                        break;

                    case '+':
                        val2 = stack.pop();
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        val2 = stack.pop();
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        val2 = stack.pop();
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        val2 = stack.pop();
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
