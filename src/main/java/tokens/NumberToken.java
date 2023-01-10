package tokens;

import visitors.TokenVisitor;

public class NumberToken implements Token {

    public final double number;

    public NumberToken(double number) {
        this.number = number;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
