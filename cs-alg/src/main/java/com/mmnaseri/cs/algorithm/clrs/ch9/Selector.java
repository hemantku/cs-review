package com.mmnaseri.cs.algorithm.clrs.ch9;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (7/11/15, 5:46 PM)
 */
public interface Selector<E extends Comparable<E>> {

    @SuppressWarnings("unchecked")
    E select(int order, E... items);

}