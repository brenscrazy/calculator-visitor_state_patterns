package states;

import tokens.Tokenizer;
import tokens.NumberToken;
import tokens.Token;

public class NumberState extends ParseState {


    public NumberState(Tokenizer analyzer) {
        super(analyzer);
    }

    @Override
    public Token parse() {
        double res = 0;
        boolean metDot = false;
        double multiplier = 0.1;
        while (!analyzer.isEnd() &&
                (Character.isDigit(analyzer.getCurrentChar()) || (analyzer.getCurrentChar() == '.' && !metDot))) {
            if (analyzer.getCurrentChar() == '.') {
                metDot = true;
            } else {
                int digit = analyzer.getCurrentChar() - '0';
                if (metDot) {
                    res += digit * multiplier;
                    multiplier /= 10;
                } else {
                    res *= 10;
                    res += digit;
                }
            }
            analyzer.skipChar();
        }
        analyzer.setState(new ReadyState(analyzer));
        return new NumberToken(res);
    }
}
