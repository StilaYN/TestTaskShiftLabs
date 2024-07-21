package ru.cft.shiftlabtesttask.core.validator;

import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.entities.CharInterval;
import ru.cft.shiftlabtesttask.core.exception.IntervalFormatException;

@Component
public class CharacterIntervalValidator {

    public void valid(CharInterval interval) {
        if (interval.getLeftBorder() > interval.getRightBorder()) {
            throw new IntervalFormatException("Справа должно быть число больше чем слева");
        }
        if (interval.getLeftBorder().equals(interval.getRightBorder())) {
            throw new IntervalFormatException("Слева и справа должны быть разные значения");
        }
    }
}
