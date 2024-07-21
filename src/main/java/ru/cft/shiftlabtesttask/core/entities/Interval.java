package ru.cft.shiftlabtesttask.core.entities;

public interface Interval<T, IntervalType extends Interval> extends Cloneable, Comparable<IntervalType> {

    T getLeftBorder();

    T getRightBorder();

    IntervalType combine(IntervalType secondInterval);
}
