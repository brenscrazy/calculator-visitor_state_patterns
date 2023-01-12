package tokens;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TokenizerTest {

    private final Tokenizer analyzer = new Tokenizer();
    private final double delta = 0.00001;

    private final List<Token> oneCharacterTokens = List.of(
            new PlusToken(),
            new MinusToken(),
            new MultiplyToken(),
            new DivideToken(),
            new LeftParenToken(),
            new RightParenToken()
    );

    @Test
    public void simpleTest() {
        List<Token> tokens = analyzer.parse("1 + 2");
        Assert.assertTrue(tokens.get(0) instanceof NumberToken);
        Assert.assertEquals(1, ((NumberToken) tokens.get(0)).number, delta);
        Assert.assertTrue(tokens.get(2) instanceof NumberToken);
        Assert.assertEquals(2, ((NumberToken) tokens.get(2)).number, delta);
        Assert.assertTrue(tokens.get(1) instanceof PlusToken);
    }

    @Test
    public void randomTests() {
        for (int i = 0; i < 1000; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int iters = ThreadLocalRandom.current().nextInt(5, 15);
            List<Token> expectedTokens = new ArrayList<>();
            for (int j = 0; j < iters; j++) {
                int tokenNum = ThreadLocalRandom.current().nextInt(0, 7);
                Token nextToken;
                if (tokenNum == 6) {
                    nextToken = new NumberToken(ThreadLocalRandom.current().nextDouble(0, 10));
                } else {
                    nextToken = oneCharacterTokens.get(tokenNum);
                }
                stringBuilder
                        .append(nextToken)
                        .append(" ".repeat(ThreadLocalRandom.current().nextInt(1, 10)));
                expectedTokens.add(nextToken);
            }
            List<Token> actualTokens = analyzer.parse(stringBuilder.toString());
            assertListsEqual(expectedTokens, actualTokens);
        }
    }

    @Test
    public void errorTest() {
        try {
            analyzer.parse("1 + pi");
            Assert.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    public static <T> void assertListsEqual(List<T> expected, List<T> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int j = 0; j < expected.size(); j++) {
            Assert.assertEquals(expected.get(j), actual.get(j));
        }
    }

}
