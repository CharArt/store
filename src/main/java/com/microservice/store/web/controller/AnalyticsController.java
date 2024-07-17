package com.microservice.store.web.controller;

import com.microservice.store.model.MeasurementType;
import com.microservice.store.model.Summary;
import com.microservice.store.model.SummaryType;
import com.microservice.store.service.SummaryService;
import com.microservice.store.web.dto.SummaryDto;
import com.microservice.store.web.mapper.SummaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final SummaryService service;
    private final SummaryMapper summaryMapper;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummery(
            @PathVariable long sensorId,
            @RequestParam(value = "mt", required = false) Set<MeasurementType> measurementTypes,
            @RequestParam(value = "st", required = false) Set<SummaryType> summaryTypes) {
        Summary summary = service.get(sensorId, measurementTypes, summaryTypes);
        return summaryMapper.toDto(summary);
    }

}
