package ru.cft.shiftlabtesttask.core.service;

import ru.cft.shiftlabtesttask.api.IntervalKind;

import java.util.List;

public interface IntervalService<T> {

    public IntervalKind getKind();

    public List<T> getMin();

    public void merge(List<List<Object>> request);
}
