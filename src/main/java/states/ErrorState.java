package states;

import tokens.Tokenizer;
import tokens.Token;

public class ErrorState extends ParseState {
    public ErrorState(Tokenizer analyzer) {
        super(analyzer);
    }

    @Override
    public Token parse() {
        throw new IllegalArgumentException("Unexpected character found while parsing on position " + analyzer.getPos()
                + " : " + analyzer.getCurrentChar());
    }
}
