package ru.cft.shiftlabtesttask.core.service;

import ru.cft.shiftlabtesttask.api.IntervalKind;

import java.util.List;

public abstract class IntervalService<T> {

    protected IntervalKind kind = null;

    public abstract List<T> getMin();

    public abstract void merge(List<List<Object>> request);
}
