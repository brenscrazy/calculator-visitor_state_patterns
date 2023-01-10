package tokens;

import visitors.TokenVisitor;

public class MultiplyToken implements Token {

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
