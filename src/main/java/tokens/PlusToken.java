package tokens;

import visitors.TokenVisitor;

public class PlusToken implements OperationToken {

    private final int PRIORITY = 1;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "+";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PlusToken;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }

    @Override
    public double performOperation(double a, double b) {
        return a + b;
    }
}
