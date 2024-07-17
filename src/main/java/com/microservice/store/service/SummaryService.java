package com.microservice.store.service;

import com.microservice.store.model.Data;
import com.microservice.store.model.MeasurementType;
import com.microservice.store.model.Summary;
import com.microservice.store.model.SummaryType;

import java.util.Set;

public interface SummaryService {

    public Summary get(long sensorId, Set<MeasurementType> measurementTypes, Set<SummaryType> summaryTypes);

    void handle(Data data);
}
