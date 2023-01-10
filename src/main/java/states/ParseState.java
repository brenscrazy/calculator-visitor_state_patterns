package states;

import tokens.LexicalAnalyzer;
import tokens.Token;

public abstract class ParseState {

    protected LexicalAnalyzer analyzer;

    public ParseState(LexicalAnalyzer analyzer) {
        this.analyzer = analyzer;
    }


    abstract public Token parse();

}
