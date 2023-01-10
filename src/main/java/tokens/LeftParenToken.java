package tokens;

import visitors.TokenVisitor;

public class LeftParenToken implements Token {


    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
