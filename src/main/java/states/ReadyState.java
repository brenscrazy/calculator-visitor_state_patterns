package states;

import tokens.*;

import java.util.Map;

public class ReadyState extends ParseState {

    private Map<Character, Token> oneCharacterTokens = Map.of(
            '+', new PlusToken(),
            '-', new MinusToken(),
            '*', new MultiplyToken(),
            '/', new DivideToken(),
            '(', new LeftParenToken(),
            ')', new RightParenToken()
    );

    public ReadyState(LexicalAnalyzer analyzer) {
        super(analyzer);
    }

    @Override
    public Token parse() {
        analyzer.skipWhitespaces();
        if (analyzer.isEnd()) {
            return new Token;
        }
        char currentChar = analyzer.getCurrentChar();
        if (oneCharacterTokens.containsKey(currentChar)) {
            analyzer.skipChar();
            return oneCharacterTokens.get(currentChar);
        }

        return null;
    }

}
