package ai.lentra.modal.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Summary{
	@Id
	@Column(name = "applicant_id")
	private long applicantId;
	@Column(name = "ref_id")

	private Integer sumRefId;

	@Column(name = "other_findings")

	private Integer otherFindings;

	@Column(name = "final_score")

	private Integer finalScore;

	@Column(name = "remark")

	private String remark;

	@Column(name = "remark_date_time")

	private Date remarkDateTime;

	@Column(name = "prepared_by")

	private String preparedBy;

	@Column(name = "date_and_time_performed")

	private Date dateAndTimePerformed;

	@Column(name = "reviewed_by")

	private String reviewedBy;

	@Column(name = "agency_name")

	private String agencyName;

	@Column(name = "sum_score")

	private Integer sumScore;
}