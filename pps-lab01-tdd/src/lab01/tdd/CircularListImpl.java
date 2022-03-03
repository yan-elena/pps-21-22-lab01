package lab01.tdd;

import lab01.tdd.strategy.SelectStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * This class represent an implementation of CircularList.
 */
public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private int index;

    public CircularListImpl() {
        list = new LinkedList<>();
        index = -1;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        setNextIndex();
        return Optional.of(this.list.get(this.index));
    }

    @Override
    public Optional<Integer> previous() {
        setPreviousIndex();
        return Optional.of(this.list.get(this.index));
    }

    @Override
    public void reset() {
        if (this.size() > 1) {
            final List<Integer> resetList = new LinkedList<>();
            resetList.add(this.list.get(this.index));
            resetList.addAll(this.list.subList(2, this.size()));
            resetList.add(this.list.get(0));
            this.list = resetList;
        }
        this.index = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        this.setNextIndex();
        final Optional<Integer> nextElement = this.list.stream().skip(this.index).filter(strategy::apply).findFirst();
        nextElement.ifPresent(integer -> this.index = this.list.indexOf(integer));
        return nextElement;
    }

    private void setNextIndex() {
        this.index = (this.index + 1 == this.size()) ? 0 : this.index + 1;
    }

    private void setPreviousIndex() {
        this.index = (this.index - 1 < 0) ? this.size() - 1 : this.index - 1;
    }
}
