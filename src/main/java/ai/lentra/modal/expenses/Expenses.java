package ai.lentra.modal.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Expenses{
	@Id
	@Column(name = "applicant_id")

	private long applicantId;

	@Column(name = "other_exp")
	private BigDecimal otherExp;

	@Column(name = "college_fees_amt")
	private BigDecimal collegeFeesAmt;

	@Column(name = "school_fees_amt")
	private BigDecimal schoolFeesAmt;

	@Column(name = "electric_bill_amt")
	private BigDecimal electricBillAmt;

	@Column(name = "office_transportation_cost")
	private BigDecimal officeTransportationCost;

	@Column(name = "cable_net_bill_amt")
	private BigDecimal cableNetBillAmt;

	@Column(name = "broadband_bill_amt")
	private BigDecimal broadbandBillAmt;

	@Column(name = "avg_fuel_cost")
	private BigDecimal avgFuelCost;

	@Column(name = "water_bill_amt")
	private BigDecimal waterBillAmt;

	@Column(name = "exp_score")
	private BigDecimal expScore;





}