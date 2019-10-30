package se.lexicon.jakob;

import java.util.Scanner;

public class SimpleCalc {
    public static Scanner scan;

    public static void main(String[] args)
    {
        scan = new Scanner(System.in); //Create new scanner called scan to be able to use it
        menu(); // Call menu method at the start of application
    }

    //Will be used to call for different functions in the application through a menu system
    //And it will keep looping until the user wants to quit
    static void menu()
    {
        boolean keepAlive = true; //Set boolean to true

        while (keepAlive) {
            System.out.printf("-----[Calculator]-----\n 1: Calculate\n 2: Exit \n Selected: ");
            int choice = scan.nextInt(); //User input for menu selection

            switch (choice) {
                case 1: //Call the calculate method
                    calculate();
                    break;
                case 2: //Set boolean to false to stop looping the application
                    keepAlive = false;
                    System.out.println("Application Terminated.");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    //Main method to get user input and call different operator methods to get the result
    static void calculate()
    {
        boolean keepCalculating = true; //Set bool to true

        double num1; //User input variable
        double num2; //User input variable

        System.out.printf("Number: ");
        num1 = scan.nextDouble(); //User input for first number
        double firstNumber = num1; //Save the value of the first input as origin number


        while (keepCalculating) //keep application running as long as true
        {
            char operator;

            System.out.printf("Operator (+,-,*,/) (q) to quit: ");
            operator = scan.next().charAt(0); //User input for operator selection

            if (operator == 'q') //If the user press Q, quit calculator method and return to menu
            {
                keepCalculating = false;
            } else //If the user selects an operator the calculation method will keep going
                {
                System.out.printf("Number: ");
                num2 = scan.nextDouble(); //User input for second number

                switch (operator) {
                    case '+': //Call Addition method
                        num1 = addition(num1, num2);
                        break;
                    case '-': //Call subtraction method
                        num1 = subtraction(num1, num2);
                        break;
                    case '*': //Call multiplication method
                        num1 = multiplication(num1, num2);
                        break;
                    case '/': //Call division method
                        num1 = division(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid input");
                        return;
                }

                System.out.println("Result: " + firstNumber + " " + operator + " " + num2 + " = " + num1); //Show the result of the calculation
                firstNumber = num1; //Save the result of num1 as the origin number to use for further calculation
            }
        }
    }

    //Addition method
    static double addition(double num1, double num2)
    {
        return num1 + num2; //Return the value for num1 + num2
    }

    //Subtraction method
    static double subtraction(double num1, double num2)
    {
        return num1 - num2; //Return the value for num1 - num2
    }

    //Multiplication method
    static double multiplication(double num1, double num2)
    {
        return num1 * num2; //Return the value for num1 * num2
    }

    //Division method
    static double division(double num1, double num2)
    {
        return num1 / num2; //Return the value for num1 / num2
    }
}