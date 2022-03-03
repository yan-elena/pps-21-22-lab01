import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList basic operations
 */
public class CircularListBasicOperationTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void testInitialEmpty() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void testAdd() {
        final int element = 0;
        this.circularList.add(element);
        assertFalse(this.circularList.isEmpty());
        assertEquals(element, this.circularList.next().orElseThrow());
    }

    @Test
    void testReset() {
        final int first = 1;
        final int second = 2;
        final int third = 3;
        this.circularList.add(first);
        this.circularList.add(second);
        this.circularList.add(third);
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(second, this.circularList.next().orElseThrow());
        assertEquals(third, this.circularList.next().orElseThrow());
        assertEquals(first, this.circularList.next().orElseThrow());
    }

    @Test
    void testNext() {
        final int element = 1;
        this.circularList.add(element);
        assertEquals(element, this.circularList.next().orElseThrow());
    }

    @Test
    void testPrevious() {
        final int first = 1;
        final int second = 2;
        this.circularList.add(first);
        this.circularList.add(second);
        assertEquals(first, this.circularList.next().orElseThrow());
        assertEquals(second, this.circularList.next().orElseThrow());
        assertEquals(first, this.circularList.previous().orElseThrow());
    }
}
