package ru.cft.shiftlabtesttask.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shiftlabtesttask.api.IntervalKind;
import ru.cft.shiftlabtesttask.core.service.ExecutorApiService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/intervals")
@RequiredArgsConstructor
public class IntervalController {

    private final ExecutorApiService executorApiService;

    @PostMapping(value = "/merge", consumes = "application/json")
    public void mergeInterval(
        @RequestBody
        List<List<Object>> intervalValue,
        @RequestParam(required = true)
        IntervalKind kind
    ) {
        executorApiService.executeMergeInterval(intervalValue, kind);
    }

    @GetMapping(value = "/min", produces = "application/json")
    public Object getMinInterval(@RequestParam(required = true) IntervalKind kind) {
        return executorApiService.executeGetMin(kind);
    }
}
