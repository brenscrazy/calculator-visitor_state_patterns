package visitors;

import org.junit.Assert;
import org.junit.Test;
import tokens.*;

import java.util.List;

public class ParseVisitorTest {

    Tokenizer tokenizer = new Tokenizer();
    
    ParseVisitor parseVisitor = new ParseVisitor();
    
    @Test
    public void simpleTest() {
        List<Token> tokens = tokenizer.parse("1 + 2");
        List<Token> actualParsed = parseVisitor.parse(tokens);
        List<Token> expected = List.of(new NumberToken(1), new NumberToken(2), new PlusToken());
        TokenizerTest.assertListsEqual(expected, actualParsed);
    }

    @Test
    public void harderTest() {
        List<Token> tokens = tokenizer.parse("1 + (2 - 3) * 4 + 5 / 6");
        List<Token> actualParsed = parseVisitor.parse(tokens);
        List<Token> expected = List.of(
                new NumberToken(1),
                new NumberToken(2),
                new NumberToken(3),
                new MinusToken(),
                new NumberToken(4),
                new MultiplyToken(),
                new PlusToken(),
                new NumberToken(5),
                new NumberToken(6),
                new DivideToken(),
                new PlusToken()
        );
        TokenizerTest.assertListsEqual(expected, actualParsed);
    }

    @Test
    public void testError() {
        assertThrows("(1 + 2");
        assertThrows("(1 + 2) * 3 )");
    }

    private void assertThrows(String input) {
        try {
            List<Token> tokens = tokenizer.parse(input);
            List<Token> result = parseVisitor.parse(tokens);
            Assert.fail();
        } catch (IllegalArgumentException e) {}
    }

}
