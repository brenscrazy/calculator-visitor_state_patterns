package tokens;

import visitors.TokenVisitor;

public class DivideToken implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
