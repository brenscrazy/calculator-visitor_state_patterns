package tokens;

import visitors.TokenVisitor;

public class PlusToken implements Token {


    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
