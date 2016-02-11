package de.ChrisGold.ChrisUtil;

import de.ChrisGold.ChrisUtil.function.TernaryOperator;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class SetUtil {
    public static <E> Set<Set<E>> powerSet(Set<E> originalSet) {
        Set<Set<E>> sets = new HashSet<Set<E>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<E>());
            return sets;
        }
        List<E> list = new ArrayList<E>(originalSet);
        E head = list.get(0);
        Set<E> rest = new HashSet<E>(list.subList(1, list.size()));
        for (Set<E> set : powerSet(rest)) {
            Set<E> newSet = new HashSet<E>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public static <E> boolean closedUnder(Set<E> set, UnaryOperator<E> operator) {
        for (E element : set) {
            if (!set.contains(operator.apply(element))) return false;
        }
        return true;
    }

    public static <E> boolean closedUnder(Set<E> set, BinaryOperator<E> operator) {
        for (E e1 : set) {
            for (E e2 : set) {
                if (!set.contains(operator.apply(e1, e2))) return false;
            }
        }
        return true;
    }

    public static <E> boolean closedUnder(Set<E> set, TernaryOperator<E> operator) {
        for (E e1 : set) {
            for (E e2 : set) {
                for (E e3 : set) {
                    if (!set.contains(operator.apply(e1, e2, e3))) return false;
                }
            }
        }
        return true;
    }

    @SafeVarargs
    public static <E> Set<E> fromArray(E... arr) {
        Set<E> set = new HashSet<E>();
        set.addAll(Arrays.asList(arr));
        return set;
    }

    public static Set<Integer> intRange(int start, int stop) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = start; i < stop; i++) {
            set.add(i);
        }
        return set;
    }
}
