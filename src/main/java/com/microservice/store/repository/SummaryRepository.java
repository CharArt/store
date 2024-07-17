package com.microservice.store.repository;

import com.microservice.store.model.Data;
import com.microservice.store.model.MeasurementType;
import com.microservice.store.model.Summary;
import com.microservice.store.model.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository {

    Optional<Summary> findBySensorId (long sensorId, Set<MeasurementType> measurementTypes, Set<SummaryType> summaryTypes);

    void handle(Data data);
}
