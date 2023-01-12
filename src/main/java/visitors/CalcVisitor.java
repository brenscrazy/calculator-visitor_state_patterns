package visitors;

import tokens.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CalcVisitor implements TokenVisitor{

    Deque<Double> stack;

    public double calculate(List<Token> tokens) {
        stack = new ArrayDeque<>();
        for (Token token : tokens) {
            token.accept(this);
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Input does not represent RPN.");
        }
        return stack.pop();
    }

    @Override
    public void visit(NumberToken token) {
        stack.push(token.number);
    }

    @Override
    public void visit(LeftParenToken token) {
        throw new IllegalArgumentException("LeftParenToken was found in input. " +
                "Token list should only contain NumberTokens ans OperationTokens");

    }

    @Override
    public void visit(RightParenToken token) {
        throw new IllegalArgumentException("RightParenToken was found in input. " +
                "Token list should only contain NumberTokens ans OperationTokens");
    }

    @Override
    public void visit(OperationToken token) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("Input does not represent RPN.");
        }
        double a = stack.pop();
        double b = stack.pop();
        stack.push(token.performOperation(b, a));
    }
}
