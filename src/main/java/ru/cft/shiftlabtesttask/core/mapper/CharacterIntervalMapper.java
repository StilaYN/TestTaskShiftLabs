package ru.cft.shiftlabtesttask.core.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.cft.shiftlabtesttask.core.entities.CharInterval;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CharacterIntervalMapper {

    public List<CharInterval> map(List<List<Object>> intervalsList) {
        List<CharInterval> charIntervals = new ArrayList<>();
        for (List<Object> interval : intervalsList) {
            String left = interval.get(0).toString();
            String right = interval.get(1).toString();
            CharInterval charInterval = CharInterval.builder()
                .leftBorder(left.toLowerCase().charAt(0))
                .rightBorder(right.toLowerCase().charAt(0))
                .build();
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
