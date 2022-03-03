package lab01.tdd.strategy;

import lab01.tdd.SelectStrategy;

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
