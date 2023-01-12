package states;

import tokens.Tokenizer;
import tokens.Token;

public class EndState extends ParseState {

    public EndState(Tokenizer analyzer) {
        super(analyzer);
    }

    @Override
    public Token parse() {
        return null;
    }
}
