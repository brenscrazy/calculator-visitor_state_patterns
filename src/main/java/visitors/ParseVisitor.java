package visitors;

import tokens.*;

import java.util.*;

public class ParseVisitor implements TokenVisitor {

    private Deque<Token> tokenStack;

    private List<Token> result;

    public List<Token> parse(List<Token> tokens) {
        result = new ArrayList<>();
        tokenStack = new ArrayDeque<>();

        for (Token token : tokens) {
            token.accept(this);
        }

        while (!tokenStack.isEmpty()) {
            if (tokenStack.peek() instanceof LeftParenToken) {
                throw new IllegalArgumentException("Non-paired parenthesis");
            }
            result.add(tokenStack.pop());
        }

        return result;

    }

    @Override
    public void visit(NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(LeftParenToken token) {
        tokenStack.push(token);
    }

    @Override
    public void visit(RightParenToken token) {
        while (!tokenStack.isEmpty() && !(tokenStack.peek() instanceof LeftParenToken)) {
            result.add(tokenStack.pop());
        }
        if (tokenStack.isEmpty()) {
            throw new IllegalArgumentException("Non-paired parenthesis");
        }
        tokenStack.pop();
    }

    @Override
    public void visit(OperationToken token) {
        Token lastToken = tokenStack.peek();
        while (lastToken instanceof OperationToken &&
               ((OperationToken) lastToken).getPriority() >= token.getPriority()) {
            result.add(lastToken);
            tokenStack.pop();
            lastToken = tokenStack.peek();
        }
        tokenStack.push(token);
    }

    public static void main(String[] args) {
        System.out.println(new ParseVisitor().parse(new Tokenizer().parse("3 + 4 * 2 / (1 - 5)) -2")));
    }

}
