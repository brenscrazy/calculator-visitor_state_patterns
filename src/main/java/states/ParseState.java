package states;

import tokens.Tokenizer;
import tokens.Token;

public abstract class ParseState {

    protected Tokenizer analyzer;

    public ParseState(Tokenizer analyzer) {
        this.analyzer = analyzer;
    }


    abstract public Token parse();

}
