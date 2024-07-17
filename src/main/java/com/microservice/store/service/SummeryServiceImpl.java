package com.microservice.store.service;

import com.microservice.store.model.Data;
import com.microservice.store.model.MeasurementType;
import com.microservice.store.model.Summary;
import com.microservice.store.model.SummaryType;
import com.microservice.store.model.exception.SensorNotFoundException;
import com.microservice.store.repository.SummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummeryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(long sensorId, Set<MeasurementType> measurementTypes, Set<SummaryType> summaryTypes) {


        return summaryRepository.findBySensorId(sensorId,
                        measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
                        summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes)
                .orElseThrow(SensorNotFoundException::new);
    }

    @Override
    public void handle(Data data) {
        summaryRepository.handle(data);
    }
}
