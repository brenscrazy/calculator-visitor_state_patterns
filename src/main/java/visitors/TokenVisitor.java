package visitors;

import tokens.*;

public interface TokenVisitor {

    void visit(NumberToken token);
    void visit(LeftParenToken token);
    void visit(RightParenToken token);
    void visit(OperationToken token);


}
