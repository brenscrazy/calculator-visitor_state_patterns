package tokens;

import states.EndState;
import states.ParseState;
import states.ReadyState;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private String input;

    private ParseState state;

    private int pos;

    public List<Token> parse(String input) {
        this.input = input;
        this.pos = 0;
        this.state = new ReadyState(this);
        List<Token> result = new ArrayList<>();
        while (!(state instanceof EndState)) {
            Token nextToken = state.parse();
            if (nextToken != null) {
                result.add(nextToken);
            }
        }
        return result;
    }

    public void setState(ParseState state) {
        this.state = state;
    }

    public void skipChar() {
        pos++;
    }

    public void unskipChar() {
        if (pos != 0) {
            pos--;
        }
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

    public int getPos() {
        return pos;
    }

    public static void main(String[] args) {
        Tokenizer analyzer = new Tokenizer();
        System.out.println(analyzer.parse("(30 + 2) / 8"));
    }

}
