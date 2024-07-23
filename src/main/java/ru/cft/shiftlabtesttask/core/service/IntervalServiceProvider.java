package ru.cft.shiftlabtesttask.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.api.IntervalKind;

import javax.management.ServiceNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class IntervalServiceProvider {

    @Autowired
    private List<IntervalService> serviceList;

    public IntervalService getIntervalService(IntervalKind kind) throws ServiceNotFoundException {
        return serviceList
            .stream()
            .filter(intervalService -> intervalService.getKind() == kind).findAny().orElseThrow(()->new ServiceNotFoundException("Сервис для обработки данного типа не был найден"));
    }

}
