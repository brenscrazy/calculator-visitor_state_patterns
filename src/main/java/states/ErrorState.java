package states;

import tokens.LexicalAnalyzer;
import tokens.Token;

public class ErrorState implements ParseState {
    @Override
    public Token parse(LexicalAnalyzer analyzer) {
        return null;
    }
}
