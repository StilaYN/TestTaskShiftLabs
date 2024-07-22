package ru.cft.shiftlabtesttask.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.api.IntervalKind;
import ru.cft.shiftlabtesttask.core.entities.DigitInterval;
import ru.cft.shiftlabtesttask.core.exception.IntervalNotFoundException;
import ru.cft.shiftlabtesttask.core.mapper.DigitIntervalMapper;
import ru.cft.shiftlabtesttask.core.repository.DigitIntervalRepository;
import ru.cft.shiftlabtesttask.core.validator.DigitIntervalValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DigitIntervalService implements IntervalService<Integer> {

    private final DigitIntervalMapper digitIntervalMapper;
    private final CombiningIntervalService<DigitInterval> combiningIntervalService;
    private final DigitIntervalRepository digitIntervalRepository;
    private final DigitIntervalValidator digitIntervalValidator;

    @Override
    public IntervalKind getKind() {
        return IntervalKind.digits;
    }

    @Override
    public List<Integer> getMin() {
        DigitInterval result = digitIntervalRepository.findFirstByOrderByLeftBorderAscRightBorder()
            .orElseThrow(() -> new IntervalNotFoundException("Интервал не был найден"));
        return digitIntervalMapper.map(result);

    }

    @Override
    public void merge(List<List<Object>> request) {
        digitIntervalValidator.validate(request);
        List<DigitInterval> digitIntervalList = digitIntervalMapper.map(request);
        List<DigitInterval> digitCombinedIntervalList = combiningIntervalService.combine(digitIntervalList);
        digitIntervalRepository.saveAll(digitCombinedIntervalList);
    }
}
