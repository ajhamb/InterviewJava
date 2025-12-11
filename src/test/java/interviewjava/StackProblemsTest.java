package interviewjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackProblemsTest {

    private StackProblems sp;

    @BeforeEach
    public void setUp() {
        sp = new StackProblems();
    }

    @Test
    public void testRemoveExtraOpeningBracket() {
        assertEquals("H(e)ll(o)", sp.removeExtraBracket("(H(e)ll(o)"));
    }

    @Test
    public void testRemoveExtraClosingBracket() {
        assertEquals("H(e)ll(o)", sp.removeExtraBracket("H(e)ll(o))"));
    }

    @Test
    public void testStringWithNoBrackets() {
        assertEquals("Hello", sp.removeExtraBracket("Hello"));
    }

    @Test
    public void testStringWithBalancedBrackets() {
        assertEquals("(H(e)l)l(o)", sp.removeExtraBracket("(H(e)l)l(o)"));
    }

    @Test
    public void testComplexStringWithExtraBrackets() {
        assertEquals("a((b)c)d(e)", sp.removeExtraBracket(")a((b)c)d(e))"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", sp.removeExtraBracket(""));
    }

    @Test
    public void testMultipleExtraBrackets() {
        assertEquals("((H(e)ll(o)))", sp.removeExtraBracket("((H(e)ll(o)))"));
    }

    @Test
    public void testOnlyBrackets() {
        assertEquals("()()()", sp.removeExtraBracket("()()()"));
    }

    @Test
    public void testInvalidNestedBrackets() {
        assertEquals("(())", sp.removeExtraBracket("(()))"));
    }

    @Test
    public void testAdjacentExtraBrackets() {
        assertEquals("", sp.removeExtraBracket(")("));
    }

    @Test
    public void testNoValidBrackets() {
        assertEquals("", sp.removeExtraBracket(")))((("));
    }

    @Test
    public void testMinParenthesisRemove_EmptyString() {
        assertEquals(0, sp.minParenthesisRemove(""));
    }

    @Test
    public void testMinParenthesisRemove_Balanced() {
        assertEquals(0, sp.minParenthesisRemove("()"));
        assertEquals(0, sp.minParenthesisRemove("(())"));
        assertEquals(0, sp.minParenthesisRemove("a(b)c"));
    }

    @Test
    public void testMinParenthesisRemove_Unbalanced() {
        assertEquals(1, sp.minParenthesisRemove("(()"));
        assertEquals(1, sp.minParenthesisRemove("())"));
        assertEquals(2, sp.minParenthesisRemove(")("));
        assertEquals(3, sp.minParenthesisRemove("((("));
        assertEquals(3, sp.minParenthesisRemove(")))"));
    }

    @Test
    public void testMinParenthesisRemove_Complex() {
        assertEquals(1, sp.minParenthesisRemove("a(b))"));
        assertEquals(2, sp.minParenthesisRemove(")(()"));
    }
}
