package ai.lentra.service;


import ai.lentra.modal.summary.Summary;
import ai.lentra.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import static ai.lentra.commons.ErrorMessage.SUMMARY_NOT_FOUND;


@Service
@Transactional
public class SummaryServiceImpl implements SummaryService{

    @Autowired
    SummaryRepository summaryRepository;
    @Override
    public List<Summary> findAll() {
        return summaryRepository.findAll();
    }

    @Override
    public void addSummary(Summary summary) {

Integer score = calculateScore(summary);
summary.setSumScore(score);
        summaryRepository.save(summary);
    }

    private Integer calculateScore(Summary summary) {

        Integer score = summary.getFinalScore() +summary.getOtherFindings();
        return  score;
    }

    @Override
    public Summary findSummaryById(Long summaryId) {
        return summaryRepository
                .findById(summaryId)
                .orElseThrow(() -> new EntityNotFoundException(SUMMARY_NOT_FOUND + " for given Id " + summaryId));
    }

    @Override
    public Summary updateService(Summary newSummary, Summary summary) {
        summary.setAgencyName(newSummary.getAgencyName());
        summary.setFinalScore(newSummary.getFinalScore());
        summary.setDateAndTimePerformed(newSummary.getDateAndTimePerformed());
        summary.setRemark(newSummary.getRemark());
        summary.setOtherFindings(newSummary.getOtherFindings());
        summary.setPreparedBy(newSummary.getPreparedBy());
        summary.setSumRefId(newSummary.getSumRefId());
        summary.setRemarkDateTime(newSummary.getRemarkDateTime());
        summary.setReviewedBy(newSummary.getReviewedBy());
        return summaryRepository.save(summary);
    }
}
