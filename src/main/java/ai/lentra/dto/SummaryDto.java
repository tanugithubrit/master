package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@JsonIgnoreProperties(ignoreUnknown = true)

public class SummaryDto {


        @JsonProperty("id")
        private Long id;
        @JsonProperty("ref_id")
        private Integer refId;

        @JsonProperty("other_findings")
        private Integer otherFindings;

        @JsonProperty("final_score")
        private Integer finalScore;

        @JsonProperty("remark")
        private String remark;

        @JsonProperty("remark_date_time")
        private Date remarkDateTime;

        @JsonProperty("prepared_by")
        private String preparedBy;

        @JsonProperty("date_and_time_performed")
        private Date dateAndTimePerformed;

        @JsonProperty("reviewed_by")
        private String reviewedBy;

        @JsonProperty("agency_name")
        private String agencyName;

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }

        public Integer getRefId() {
        return refId;
    }

        public void setRefId(Integer refId) {
        this.refId = refId;
    }

        public Integer getOtherFindings() {
        return otherFindings;
    }

        public void setOtherFindings(Integer otherFindings) {
        this.otherFindings = otherFindings;
    }

        public Integer getFinalScore() {
        return finalScore;
    }

        public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

        public String getRemark() {
        return remark;
    }

        public void setRemark(String remark) {
        this.remark = remark;
    }

        public Date getRemarkDateTime() {
        return remarkDateTime;
    }

        public void setRemarkDateTime(Date remarkDateTime) {
        this.remarkDateTime = remarkDateTime;
    }

        public String getPreparedBy() {
        return preparedBy;
    }

        public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

        public Date getDateAndTimePerformed() {
        return dateAndTimePerformed;
    }

        public void setDateAndTimePerformed(Date dateAndTimePerformed) {
        this.dateAndTimePerformed = dateAndTimePerformed;
    }

        public String getReviewedBy() {
        return reviewedBy;
    }

        public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

        public String getAgencyName() {
        return agencyName;
    }

        public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

}
