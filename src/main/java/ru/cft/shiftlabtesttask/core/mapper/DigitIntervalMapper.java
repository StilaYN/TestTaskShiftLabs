package ru.cft.shiftlabtesttask.core.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.entities.DigitInterval;
import ru.cft.shiftlabtesttask.core.validator.DigitIntervalValidator;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DigitIntervalMapper {

    private final DigitIntervalValidator digitIntervalValidator;

    public List<DigitInterval> map(List<List<Object>> intervalsList) {
        List<DigitInterval> digitIntervals = new ArrayList<>();
        for (List<Object> interval : intervalsList) {
            DigitInterval digitInterval = DigitInterval.builder()
                .leftBorder((Integer) interval.get(0))
                .rightBorder((Integer) interval.get(1))
                .build();
            digitIntervalValidator.valid(digitInterval);
            digitIntervals.add(digitInterval);
        }
        return digitIntervals;
    }

    public List<Integer> map(DigitInterval digitInterval) {
        List<Integer> interval = new ArrayList<>();
        interval.add(digitInterval.getLeftBorder());
        interval.add(digitInterval.getRightBorder());
        return interval;
    }
}
