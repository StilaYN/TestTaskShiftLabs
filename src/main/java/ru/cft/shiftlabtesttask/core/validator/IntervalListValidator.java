package ru.cft.shiftlabtesttask.core.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.exception.IntervalFormatException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IntervalListValidator {

    public void validate(List<List<Object>> intervalList) {
        for (List<Object> interval : intervalList) {
            if (interval.size() != 2) {
                throw new IntervalFormatException("Все интервалы должны состоять из двух точек");
            }
        }
    }
}
