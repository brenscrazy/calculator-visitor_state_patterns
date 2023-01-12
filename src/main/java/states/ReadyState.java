package states;

import tokens.*;

import java.util.Map;

public class ReadyState extends ParseState {

    private final Map<Character, Token> oneCharacterTokens = Map.of(
            '+', new PlusToken(),
            '-', new MinusToken(),
            '*', new MultiplyToken(),
            '/', new DivideToken(),
            '(', new LeftParenToken(),
            ')', new RightParenToken()
    );

    public ReadyState(Tokenizer analyzer) {
        super(analyzer);
    }

    @Override
    public Token parse() {
        analyzer.skipWhitespaces();
        if (analyzer.isEnd()) {
            analyzer.setState(new EndState(analyzer));
            return null;
        }
        char currentChar = analyzer.getCurrentChar();
        if (oneCharacterTokens.containsKey(currentChar)) {
            analyzer.skipChar();
            return oneCharacterTokens.get(currentChar);
        }
        if (Character.isDigit(currentChar)) {
            analyzer.setState(new NumberState(analyzer));
            return null;
        }
        analyzer.setState(new ErrorState(analyzer));
        return null;
    }

}
