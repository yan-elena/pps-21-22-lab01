import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.SelectStrategy;
import lab01.tdd.strategy.SelectStrategyFactory;
import lab01.tdd.strategy.SelectStrategyFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList with select strategy
 */
public class CircularListWithSelectStrategyTest {

    private CircularList circularList;
    private SelectStrategyFactory selectStrategyFactory;

    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl();
        this.selectStrategyFactory = new SelectStrategyFactoryImpl();
    }

    @Test
    void testSelectNextWithEqualStrategy() {
        final int first = 1;
        final int second = 2;
        final int third = 3;
        circularList.add(first);
        circularList.add(second);
        circularList.add(third);
        final SelectStrategy equalStrategy = this.selectStrategyFactory.createEqualStrategy(3);
        assertEquals(third, circularList.next(equalStrategy).orElseThrow());
        assertEquals(third, circularList.next(equalStrategy).orElseThrow());
    }

    @Test
    void testSelectNextWithEvenStrategy() {
        int first = 1;
        int second = 2;
        int third = 3;
        int fourth = 4;
        circularList.add(first);
        circularList.add(second);
        circularList.add(third);
        circularList.add(fourth);
        final SelectStrategy evenStrategy = this.selectStrategyFactory.createEvenStrategy();
        assertEquals(second, circularList.next(evenStrategy).orElseThrow());
        assertEquals(fourth, circularList.next(evenStrategy).orElseThrow());
    }

    @Test
    void testSelectNextWithMultipleStrategy() {
        int first = 1;
        int second = 3;
        int third = 6;
        int fourth = 4;
        circularList.add(first);
        circularList.add(second);
        circularList.add(third);
        circularList.add(fourth);
        final SelectStrategy multipleStrategy = this.selectStrategyFactory.createMultipleOfStrategy(3);
        assertEquals(second, circularList.next(multipleStrategy).orElseThrow());
        assertEquals(third, circularList.next(multipleStrategy).orElseThrow());
    }
}
