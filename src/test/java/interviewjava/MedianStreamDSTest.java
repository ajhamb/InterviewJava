package interviewjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianStreamDSTest {

    @Test
    void testFindMedian_emptyStream_throwsException() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            medianFinder.findMedian();
        });
    }

    @Test
    void testAddNumAndFindMedian_singleElement_returnsElement() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_evenNumberOfElements_returnsAverageOfMiddleElements() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_oddNumberOfElements_returnsMiddleElement() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_duplicateNumbers_correctMedian() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_negativeNumbers_correctMedian() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(3);
        assertEquals(-1.0, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_numbersInOrder_correctMedian() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        assertEquals(3.0, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_numbersInReverseOrder_correctMedian() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(5);
        medianFinder.addNum(4);
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        medianFinder.addNum(1);
        assertEquals(3.0, medianFinder.findMedian(), 1e-9);
    }

    @Test
    void testAddNumAndFindMedian_randomOrder_correctMedian() {
        MedianStreamDS medianFinder = new MedianStreamDS();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.addNum(2);
        assertEquals(2.5, medianFinder.findMedian(), 1e-9);
    }
}
