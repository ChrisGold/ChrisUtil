package de.ChrisGold.ChrisUtil;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class TriggerList<T> implements List<T> {

    private final List<T> wrapping;
    private final Runnable onTrigger;
    private final Predicate<List<T>> triggerCondition;

    public TriggerList(List<T> wrapping, Runnable trigger, Predicate<List<T>> when) {
        this.wrapping = wrapping;
        this.onTrigger = trigger;
        this.triggerCondition = when;
    }

    @Override
    public int size() {
        return wrapping.size();
    }

    @Override
    public boolean isEmpty() {
        return wrapping.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return wrapping.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return wrapping.iterator();
    }

    @Override
    public Object[] toArray() {
        return wrapping.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return wrapping.toArray(a);
    }

    @Override
    public boolean add(T t) {
        boolean added = wrapping.add(t);
        if (triggerCondition.test(wrapping)) {
            onTrigger.run();
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = wrapping.remove(o);
        if (triggerCondition.test(wrapping)) {
            onTrigger.run();
        }
        return remove;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return wrapping.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return wrapping.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return wrapping.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return wrapping.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return wrapping.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        wrapping.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        wrapping.sort(c);
    }

    @Override
    public void clear() {
        wrapping.clear();
    }

    @Override
    public boolean equals(Object o) {
        return wrapping.equals(o);
    }

    @Override
    public int hashCode() {
        return wrapping.hashCode();
    }

    @Override
    public T get(int index) {
        return wrapping.get(index);
    }

    @Override
    public T set(int index, T element) {
        T set = wrapping.set(index, element);
        if (triggerCondition.test(wrapping)) {
            onTrigger.run();
        }
        return set;

    }

    @Override
    public void add(int index, T element) {
        wrapping.add(index, element);
        if (triggerCondition.test(wrapping)) {
            onTrigger.run();
        }
    }

    @Override
    public T remove(int index) {
        return wrapping.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return wrapping.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return wrapping.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return wrapping.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return wrapping.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return wrapping.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<T> spliterator() {
        return wrapping.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return wrapping.removeIf(filter);
    }

    @Override
    public Stream<T> stream() {
        return wrapping.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return wrapping.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        wrapping.forEach(action);
    }
}
