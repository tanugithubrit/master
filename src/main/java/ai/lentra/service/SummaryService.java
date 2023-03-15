package ai.lentra.service;

import ai.lentra.modal.summary.Summary;

import java.util.List;

public interface SummaryService {
    List<Summary> findAll();

    void addSummary(Summary summary);

    Summary findSummaryById(Long summaryId);

    Summary updateService(Summary newSUmmary, Summary summay);
}
