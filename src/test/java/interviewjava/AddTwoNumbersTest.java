package interviewjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    @Test
    void addsTwoIntegers() {
        assertEquals(8.0, AddTwoNumbers.add(3, 5), 1e-9);
    }

    @Test
    void addsDoubles() {
        assertEquals(4.0, AddTwoNumbers.add(2.5, 1.5), 1e-9);
    }

    @Test
    void handlesNegative() {
        assertEquals(0.0, AddTwoNumbers.add(-1, 1), 1e-9);
    }

}
