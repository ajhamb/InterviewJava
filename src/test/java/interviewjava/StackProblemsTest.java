package interviewjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackProblemsTest {

    @Test
    public void testRemoveExtraBracket() {
        StackProblems sp = new StackProblems();
        assertEquals("H(e)ll(o)", sp.removeExtraBracket("(H(e)ll(o)"));
    }
}
