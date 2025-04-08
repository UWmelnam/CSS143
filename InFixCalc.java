import java.util.Scanner;


// Solution author: <Mohamed Elnamous>

public class InFixCalc {

    public static final Scanner console = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) { 
        String input1 = "4 + 4 / 2"; // Example input for calculate() method.
        String input2 ="1 * -3";
        String input3 ="1 * -3 + 6 / 3";
        String input4 ="5";
        String input5 ="-5";

        int answer = calculate(input1);
        int answer1 = calculate(input2);
        int answer2 = calculate(input3);
        int answer3 = calculate(input4);
        int answer4 = calculate(input5);
        
        System.out.println("Answer is " + answer);
        System.out.println("Answer is " + answer1);
        System.out.println("Answer is " + answer2);
        System.out.println("Answer is " + answer3);
        System.out.println("Answer is " + answer4);
    }

    // preconditions: all binary operations are separated via a space
    // postconditions: returns the result of the processed string
    // Mohamed Elnamous - infix calculator exercise

    
    public static int calculate(String input) {
        int lhs = 0; // short for left-hand side
        int rhs = 0; // short for right-hand side
        char operator; // placeholder for the operator, and also will be used to check what kind of operation happens
                        // to the return value.
        
        // splits the input at every preceeding space, following the simple pattern of 
        // [lhs] [operator] [rhs] [operator] [rhs] ... 
        String[] tokens = input.split(" ");
        
        // the first element or "token" of the token array is referenced using tokens[0],
        // and is parsed into an integer using the Integer.parseInt() method.
        lhs = Integar.parseInt(tokens[0]);

        // how this for loop initialization works is since we already took the first element of the tokens array
        // we will skip that element index by intiailizating i to 1, and since we are using regular binary operators,
        // we will incremenet i by 2 to skip every operator in the tokens array, and only will take the rhs values
        for (int i = 1; i < tokens.length; i += 2) {
            operator = tokens[i].charAt(0); // the first (and only) character of tokens[i].charAt(0) is the operator.

            // since I will always be an odd number and will always take an operator's index, tokens[i + 1] will always be a rhs value.
            rhs = Integar.parseInt(tokens[i + 1]); 
            
            // first iteration = i = 1
            // lhf = 1
            // operator = *
            // rhs = -3
            // lhs = 1 * -3 = -3

            // so now based on what type of binary operator we have, we will do the operation and assign the result to lhs.
            // the reason why we are assigning the result to lhs is because we will always be using lhs as the left-hand side of the next operation.
            switch(operator) {
                
            }

        }

        return lhs;
    }
}
