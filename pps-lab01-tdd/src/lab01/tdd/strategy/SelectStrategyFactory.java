package lab01.tdd.strategy;

/**
 * Represent a select Strategy Factory.
 */
public interface SelectStrategyFactory {

    /**
     * Returns an instance of equal Strategy.
     * @param element the element to apply the strategy
     * @return equal strategy
     */
    SelectStrategy createEqualStrategy(int element);

    /**
     * Returns an instance of even Strategy.
     * @return even strategy
     */
    SelectStrategy createEvenStrategy();

    /**
     * Returns an instance of multiple Strategy.
     * @param element the element to apply the strategy
     * @return multiple strategy
     */
    SelectStrategy createMultipleOfStrategy(int element);
}
