package states;

import tokens.LexicalAnalyzer;
import tokens.Token;

public class EndState extends ParseState {

    public EndState(LexicalAnalyzer analyzer) {
        super(analyzer);
    }

    @Override
    public Token parse(LexicalAnalyzer analyzer) {
        return null;
    }
}
