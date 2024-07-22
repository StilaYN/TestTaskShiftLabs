package ru.cft.shiftlabtesttask.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.api.IntervalKind;
import ru.cft.shiftlabtesttask.core.validator.IntervalListValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutorApiService {

    private final IntervalListValidator intervalListValidator;
    private final IntervalServiceProvider intervalServiceProvider;

    public void executeMergeInterval(List<List<Object>> intervalList, IntervalKind kind) {
        if (intervalList.isEmpty()) return;
        intervalListValidator.validate(intervalList);
        IntervalService intervalService = intervalServiceProvider.getIntervalService(kind);
        intervalService.merge(intervalList);
    }

    public List executeGetMin(IntervalKind kind) {
        IntervalService intervalService = intervalServiceProvider.getIntervalService(kind);
        return intervalService.getMin();
    }

}
