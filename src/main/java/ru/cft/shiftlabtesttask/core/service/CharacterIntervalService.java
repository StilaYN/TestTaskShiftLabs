package ru.cft.shiftlabtesttask.core.service;

import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.api.IntervalKind;

import java.util.List;

@Service
public class CharacterIntervalService extends IntervalService<Character> {

    protected IntervalKind kind = IntervalKind.letters;

    @Override
    public List<Character> getMin() {
        return List.of();
    }

    @Override
    public List<Character> merge(List<List<Object>> request) {
        return List.of();
    }
}
