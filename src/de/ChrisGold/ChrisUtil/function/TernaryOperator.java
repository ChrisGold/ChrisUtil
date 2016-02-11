package de.ChrisGold.ChrisUtil.function;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
@FunctionalInterface
public interface TernaryOperator<E> {
    public E apply(E one, E two, E three);
}
