package lab01.tdd.strategy;

import lab01.tdd.SelectStrategy;

/**
 * This class represent an instance of SelectStrategy.
 * In particular EqualStrategy calculate the equal element of a given one.
 */
public class EqualStrategy implements SelectStrategy {

    private final int element;

    public EqualStrategy(final int element) {
        this.element = element;
    }

    @Override
    public boolean apply(int element) {
        return this.element == element;
    }
}
