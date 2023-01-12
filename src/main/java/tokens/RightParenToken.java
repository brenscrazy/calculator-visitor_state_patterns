package tokens;

import visitors.TokenVisitor;

public class RightParenToken implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RightParenToken;
    }
}
