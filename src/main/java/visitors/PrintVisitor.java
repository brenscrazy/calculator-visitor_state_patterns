package visitors;

import tokens.*;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PrintVisitor implements TokenVisitor {

    List<String> strings;

    public String print(List<Token> tokens) {
        strings = new ArrayList<>();
        for (Token token : tokens) {
            token.accept(this);
        }
        return String.join(" ", strings);
    }

    @Override
    public void visit(NumberToken token) {
        strings.add(token.toString());
    }

    @Override
    public void visit(LeftParenToken token) {
        strings.add(token.toString());
    }

    @Override
    public void visit(RightParenToken token) {
        strings.add(token.toString());
    }

    @Override
    public void visit(OperationToken token) {
        strings.add(token.toString());
    }
}
