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
}
