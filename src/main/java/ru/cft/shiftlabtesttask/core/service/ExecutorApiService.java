package ru.cft.shiftlabtesttask.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cft.shiftlabtesttask.api.IntervalKind;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutorApiService {


    public List executePost(List<List<Object>> intervalList, IntervalKind kind) {
        return null;
    }

    public List executeGet(IntervalKind kind) {
        return null;
    }

}
