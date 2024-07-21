package ru.cft.shiftlabtesttask.core.service;

import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.api.IntervalKind;

import java.util.List;

@Service
public class DigitIntervalService extends IntervalService<Integer> {

    protected IntervalKind kind = IntervalKind.digits;

    @Override
    public List<Integer> getMin() {
        return List.of();
    }

    @Override
    public List<Integer> merge(List<List<Object>> request) {
        return List.of();
    }
}
