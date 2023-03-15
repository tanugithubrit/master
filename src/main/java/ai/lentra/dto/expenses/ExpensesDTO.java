package ai.lentra.dto.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class ExpensesDTO {

	private long applicantId;
	private int officeTransportationCost;
	private int electricBillAmt;
	private int cableNetBillAmt;
	private int waterBillAmt;
	private int broadbandBillAmt;
	private int avgFuelCost;
	private String otherExpenses;
	private int schoolFeesAmt;
	private int collegeFeesAmt;
}