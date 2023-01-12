package visitors;

import org.junit.Assert;
import org.junit.Test;
import tokens.Token;
import tokens.Tokenizer;

import java.util.List;

public class CalcVisitorTest {

    Tokenizer tokenizer = new Tokenizer();

    ParseVisitor parseVisitor = new ParseVisitor();

    CalcVisitor calcVisitor = new CalcVisitor();

    double delta = 0.00001;

    @Test
    public void simpleTest() {
        Assert.assertEquals(3, calculate("1 + 2"), delta);
    }

    @Test
    public void harderTest() {
        Assert.assertEquals(1279, calculate("(23 + 10) * 5 - 3 * (32 + 5) * (10 - 4 * 5) + 8 / 2"), delta);
    }

    @Test
    public void testFail(){
        assertThrows("1 + * 2");
        assertThrows("1 + 2 2");
        assertThrows("* 2");
    }

    private void assertThrows(String input) {
        try {
            Double result = calculate(input);
            Assert.fail();
        } catch (IllegalArgumentException e) {}
    }

    private double calculate(String input) {
        return calcVisitor.calculate(parseVisitor.parse(tokenizer.parse(input)));
    }

}
