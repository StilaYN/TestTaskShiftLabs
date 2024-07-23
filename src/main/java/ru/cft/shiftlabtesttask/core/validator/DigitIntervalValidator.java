package ru.cft.shiftlabtesttask.core.validator;

import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.exception.IntervalFormatException;

import java.util.List;

@Component
public class DigitIntervalValidator {

    public void validate(List<List<Object>> intervalList) {
        for (List<Object> interval : intervalList) {
            if (interval.size() != 2) {
                throw new IntervalFormatException("Все интервалы должны состоять из двух точек");
            }
            Integer left;
            Integer right;
            try {
                left = (Integer) interval.get(0);
                right = (Integer) interval.get(1);
            } catch (ClassCastException e) {
                throw new IntervalFormatException("Интервал должен содержать только цифры");
            }
            if (left.equals(right)) {
                throw new IntervalFormatException("Левая и правая граница должны быть различны");
            } else if (left > right) {
                throw new IntervalFormatException("Справа должно быть число больше чем слева");
            }
        }
    }
}
