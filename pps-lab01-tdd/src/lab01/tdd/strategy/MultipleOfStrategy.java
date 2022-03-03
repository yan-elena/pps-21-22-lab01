package lab01.tdd.strategy;

/**
 * This class represent an instance of SelectStrategy.
 * In particular EqualStrategy calculate the multiple element of a given one.
 */
public class MultipleOfStrategy implements SelectStrategy {

    private final int divisor;

    public MultipleOfStrategy(final int divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean apply(int element) {
        return element % divisor == 0;
    }
}
