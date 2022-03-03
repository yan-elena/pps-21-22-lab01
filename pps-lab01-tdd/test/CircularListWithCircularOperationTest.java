import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList next and previous operations
 */
public class CircularListWithCircularOperationTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void testCircularNext() {
        final int first = 1;
        final int second = 2;
        final int third = 3;
        this.circularList.add(first);
        this.circularList.add(second);
        this.circularList.add(third);
        assertEquals(first, this.circularList.next().orElseThrow());
        assertEquals(second, this.circularList.next().orElseThrow());
        assertEquals(third, this.circularList.next().orElseThrow());
        assertEquals(first, this.circularList.next().orElseThrow());
    }

    @Test
    void testCircularPrevious() {
        final int first = 1;
        final int second = 2;
        final int third = 3;
        this.circularList.add(first);
        this.circularList.add(second);
        this.circularList.add(third);
        assertEquals(first, this.circularList.next().orElseThrow());
        assertEquals(third, this.circularList.previous().orElseThrow());
    }
}
