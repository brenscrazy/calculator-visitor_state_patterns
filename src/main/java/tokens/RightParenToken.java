package tokens;

import visitors.TokenVisitor;

public class RightParenToken implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
