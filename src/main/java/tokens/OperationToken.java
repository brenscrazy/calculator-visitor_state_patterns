package tokens;

public interface OperationToken extends Token {

    int getPriority();

    double performOperation(double a, double b);

}
