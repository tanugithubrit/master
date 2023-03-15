package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ExpensesDto {




    @JsonProperty("other_exp")
    private BigDecimal otherExp;

    @JsonProperty("college_fees_amt")
    private BigDecimal collegeFeesAmt;

    @JsonProperty("school_fees_amt")
    private BigDecimal schoolFeesAmt;

    @JsonProperty("electric_bill_amt")
    private BigDecimal electricBillAmt;

    @JsonProperty("office_transportation_cost")
    private BigDecimal officeTransportationCost;

    @JsonProperty("cable_net_bill_amt")
    private BigDecimal cableNetBillAmt;

    @JsonProperty("broadband_bill_amt")
    private BigDecimal broadbandBillAmt;

    @JsonProperty("avg_fuel_cost")
    private Integer avgFuelCost;

    @JsonProperty("water_bill_amt")
    private BigDecimal waterBillAmt;
    @JsonProperty("applicant_id")
    private Integer applicantId;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }


    public BigDecimal getOtherExp() {
        return otherExp;
    }

    public void setOtherExp(BigDecimal otherExp) {
        this.otherExp = otherExp;
    }

    public BigDecimal getCollegeFeesAmt() {
        return collegeFeesAmt;
    }

    public void setCollegeFeesAmt(BigDecimal collegeFeesAmt) {
        this.collegeFeesAmt = collegeFeesAmt;
    }

    public BigDecimal getSchoolFeesAmt() {
        return schoolFeesAmt;
    }

    public void setSchoolFeesAmt(BigDecimal schoolFeesAmt) {
        this.schoolFeesAmt = schoolFeesAmt;
    }

    public BigDecimal getElectricBillAmt() {
        return electricBillAmt;
    }

    public void setElectricBillAmt(BigDecimal electricBillAmt) {
        this.electricBillAmt = electricBillAmt;
    }

    public BigDecimal getOfficeTransportationCost() {
        return officeTransportationCost;
    }

    public void setOfficeTransportationCost(BigDecimal officeTransportationCost) {
        this.officeTransportationCost = officeTransportationCost;
    }

    public BigDecimal getCableNetBillAmt() {
        return cableNetBillAmt;
    }

    public void setCableNetBillAmt(BigDecimal cableNetBillAmt) {
        this.cableNetBillAmt = cableNetBillAmt;
    }

    public BigDecimal getBroadbandBillAmt() {
        return broadbandBillAmt;
    }

    public void setBroadbandBillAmt(BigDecimal broadbandBillAmt) {
        this.broadbandBillAmt = broadbandBillAmt;
    }

    public Integer getAvgFuelCost() {
        return avgFuelCost;
    }

    public void setAvgFuelCost(Integer avgFuelCost) {
        this.avgFuelCost = avgFuelCost;
    }

    public BigDecimal getWaterBillAmt() {
        return waterBillAmt;
    }

    public void setWaterBillAmt(BigDecimal waterBillAmt) {
        this.waterBillAmt = waterBillAmt;
    }
}
