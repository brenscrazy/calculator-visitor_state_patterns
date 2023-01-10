package visitors;

import tokens.*;

public interface TokenVisitor {

    void visit(NumberToken token);

    void visit(LeftParenToken token);
    void visit(RightParenToken token);
    void visit(PlusToken token);
    void visit(MinusToken token);
    void visit(MultiplyToken token);
    void visit(DivideToken token);


}
