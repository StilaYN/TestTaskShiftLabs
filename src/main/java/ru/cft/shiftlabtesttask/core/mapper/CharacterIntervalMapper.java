package ru.cft.shiftlabtesttask.core.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.entities.CharInterval;
import ru.cft.shiftlabtesttask.core.validator.CharacterIntervalValidator;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CharacterIntervalMapper {

    private final CharacterIntervalValidator characterIntervalValidator;

    public List<CharInterval> map(List<List<Object>> intervalsList) {
        List<CharInterval> charIntervals = new ArrayList<>();
        for (List<Object> interval : intervalsList) {
            CharInterval charInterval = CharInterval.builder()
                .leftBorder(interval.get(0).toString().charAt(0))
                .rightBorder(interval.get(1).toString().charAt(0))
                .build();
            characterIntervalValidator.valid(charInterval);
            charIntervals.add(charInterval);
        }
        return charIntervals;
    }

    public List<Character> map(CharInterval charInterval) {
        List<Character> intervalInList = new ArrayList<>();
        intervalInList.add(charInterval.getLeftBorder());
        intervalInList.add(charInterval.getRightBorder());
        return intervalInList;
    }
}
