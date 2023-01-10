package tokens;

import visitors.TokenVisitor;

public class MinusToken implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
