package ru.cft.shiftlabtesttask.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.api.IntervalKind;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IntervalServiceProvider {

    @Autowired
    private List<IntervalService> serviceList;

    public IntervalService getIntervalService(IntervalKind kind) {
        return (IntervalService) serviceList
            .stream()
            .filter(intervalService -> intervalService.kind == kind);
    }

}
