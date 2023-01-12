import tokens.Token;
import tokens.Tokenizer;
import visitors.CalcVisitor;
import visitors.ParseVisitor;
import visitors.PrintVisitor;
import visitors.TokenVisitor;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Tokenizer tokenizer = new Tokenizer();
    private static ParseVisitor parseVisitor = new ParseVisitor();
    private static CalcVisitor calcVisitor = new CalcVisitor();
    private static PrintVisitor printVisitor = new PrintVisitor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usage:");
        System.out.println();
        System.out.println("----Print expression in infix form in order to");
        System.out.println("calculate its result and print it in RPN");
        System.out.println();
        System.out.println("----Print \"quit\" in order to finish execution");
        System.out.println();
        System.out.println("-----------------------------------------------");
        while (true) {
            System.out.println();
            System.out.println("Print expression: ");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            List<Token> tokenized;
            try {
                tokenized = tokenizer.parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println("An outor occurred during tokenizing: " + e.getMessage() + ". Please try again.");
                continue;
            }
            List<Token> rpn;
            try {
                rpn = parseVisitor.parse(tokenized);
            } catch (IllegalArgumentException e) {
                System.out.println("Can't turn expression into RPN: " + e.getMessage() + ". Please try again.");
                continue;
            }
            String rpnString = printVisitor.print(rpn);
            System.out.println("Generated RPN     : " + rpnString);
            try {
                double result = calcVisitor.calculate(rpn);
                System.out.println("Calculated result : " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Generated RPN can not be calculated. Please check");
                System.out.println("if input expression is correct and try again.");
            }
        }
    }

}
