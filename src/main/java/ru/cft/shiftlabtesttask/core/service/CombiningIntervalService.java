package ru.cft.shiftlabtesttask.core.service;

import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.core.entities.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CombiningIntervalService<IntervalType extends Interval> {

    public List<IntervalType> combine(List<IntervalType> intervalList) {
        if (intervalList == null || intervalList.isEmpty()) {
            return null;
        }
        intervalList.sort(Comparator.naturalOrder());
        List<IntervalType> combinedIntervalList = new ArrayList<>();
        IntervalType currentInterval = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            IntervalType combinedInterval = (IntervalType) currentInterval.combine(intervalList.get(i));
            if (combinedInterval == null) {
                combinedIntervalList.add(currentInterval);
                currentInterval = intervalList.get(i);
            } else {
                currentInterval = combinedInterval;
            }
        }
        combinedIntervalList.add(currentInterval);
        return combinedIntervalList;
    }
}
