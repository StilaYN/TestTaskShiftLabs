package ru.cft.shiftlabtesttask.core.validator;

import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.exception.IntervalFormatException;

import java.util.List;

@Component
public class CharacterIntervalValidator {

    public void validate(List<List<Object>> intervalList) {
        String regex = "^[a-z]$";
        for (List<Object> interval : intervalList) {
            if (interval.size() != 2) {
                throw new IntervalFormatException("Все интервалы должны состоять из двух точек");
            }
            String left = interval.get(0).toString().toLowerCase();
            String right = interval.get(1).toString().toLowerCase();
            if (!left.matches(regex) || !right.matches(regex)) {
                throw new IntervalFormatException("Границы интервала могут состоять только из одной буквы английского алфавита");
            }
            if (left.compareToIgnoreCase(right) == 0) {
                throw new IntervalFormatException("Левая и правая граница должны быть различны");
            } else if (left.compareToIgnoreCase(right) > 0) {
                throw new IntervalFormatException("Справа должно быть символ больше чем слева");
            }
        }
    }
}
