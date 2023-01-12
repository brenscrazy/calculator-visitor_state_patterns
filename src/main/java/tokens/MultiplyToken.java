package tokens;

import visitors.TokenVisitor;

public class MultiplyToken implements OperationToken {

    private final int PRIORITY = 2;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MultiplyToken;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }

    @Override
    public double performOperation(double a, double b) {
        return a * b;
    }
}
