package lab01.tdd.strategy;

/**
 * This class represent an implementation of SelectStrategyFactory.
 */
public class SelectStrategyFactoryImpl implements SelectStrategyFactory{

    @Override
    public SelectStrategy createEqualStrategy(int element) {
        return new EqualStrategy(element);
    }

    @Override
    public SelectStrategy createEvenStrategy() {
        return new MultipleOfStrategy(2);
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int element) {
        return new MultipleOfStrategy(element);
    }
}
