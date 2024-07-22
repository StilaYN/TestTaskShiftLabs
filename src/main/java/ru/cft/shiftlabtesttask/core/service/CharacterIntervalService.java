package ru.cft.shiftlabtesttask.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.api.IntervalKind;
import ru.cft.shiftlabtesttask.core.entities.CharInterval;
import ru.cft.shiftlabtesttask.core.exception.IntervalNotFoundException;
import ru.cft.shiftlabtesttask.core.mapper.CharacterIntervalMapper;
import ru.cft.shiftlabtesttask.core.repository.CharacterIntervalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterIntervalService implements IntervalService<Character> {

    private final CombiningIntervalService<CharInterval> combiningIntervalService;
    private final CharacterIntervalMapper characterIntervalMapper;
    private final CharacterIntervalRepository characterIntervalRepository;

    @Override
    public IntervalKind getKind() {
        return IntervalKind.letters;
    }

    @Override
    public List<Character> getMin() {
        CharInterval result = characterIntervalRepository.findFirstByOrderByLeftBorderAscRightBorder()
            .orElseThrow(() -> new IntervalNotFoundException("Интервал не был найден"));
        return characterIntervalMapper.map(result);
    }

    @Override
    public void merge(List<List<Object>> request) {
        List<CharInterval> charIntervalList = characterIntervalMapper.map(request);
        List<CharInterval> charCombinedIntervalList = combiningIntervalService.combine(charIntervalList);
        characterIntervalRepository.saveAll(charCombinedIntervalList);
    }
}
