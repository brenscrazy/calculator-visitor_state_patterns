package tokens;

import states.EndState;
import states.ErrorState;
import states.ParseState;
import states.ReadyState;

import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {

    private String input;

    private ParseState state;

    private int pos;

    public List<Token> parse(String input) {
        this.input = input;
        this.pos = 0;
        this.state = new ReadyState(this);
        List<Token> result = new ArrayList<>();
        while (!(state instanceof EndState || state instanceof ErrorState)) {
            result.add(state.parse());
        }
        return result;
    }

    public void setState(ParseState state) {
        this.state = state;
    }

    public void skipChar() {
        pos++;
    }

    public char getCurrentChar() {
        return input.charAt(pos);
    }

    public boolean isEnd() {
        return pos >= input.length();
    }

    public void skipWhitespaces() {
        while (!isEnd() && Character.isWhitespace(getCurrentChar())) {
            skipChar();
        }
    }

}
