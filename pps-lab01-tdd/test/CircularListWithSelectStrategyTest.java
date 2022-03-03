import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.strategy.EqualStrategy;
import lab01.tdd.strategy.MultipleOfStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularListWithSelectStrategyTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void testSelectNextWithEqualStrategy() {
        int first = 1;
        int second = 2;
        int third = 3;
        circularList.add(first);
        circularList.add(second);
        circularList.add(third);
        assertEquals(third, circularList.next(new EqualStrategy(3)).orElseThrow());
        assertTrue(circularList.next(new EqualStrategy(3)).isEmpty());
    }

    @Test
    void testSelectNextWithMultipleStrategy() {
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = 4;
        circularList.add(first);
        circularList.add(second);
        circularList.add(third);
        circularList.add(fourth);
        assertEquals(second, circularList.next(new MultipleOfStrategy(2)).orElseThrow());
        assertEquals(fourth, circularList.next(new MultipleOfStrategy(2)).orElseThrow());
    }
}
