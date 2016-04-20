package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "all_acct_contracts_m_ReturnElement", propOrder = {"contractNo", "clientContractId", "contractScope", "typeNo", "lengthMonths", "cancelFee", "createComments", "updateComments", "createDate", "updateDate", "startDate", "endDate", "statusCode", "contractPlanInstanceInfo"})
public class AllAcctContractsMReturnElement {

    @XmlElement(name = "contract_no")
    protected Long contractNo;
    @XmlElement(name = "client_contract_id")
    protected String clientContractId;
    @XmlElement(name = "contract_scope")
    protected String contractScope;
    @XmlElement(name = "type_no")
    protected Long typeNo;
    @XmlElement(name = "length_months")
    protected Long lengthMonths;
    @XmlElement(name = "cancel_fee")
    protected Double cancelFee;
    @XmlElement(name = "create_comments")
    protected String createComments;
    @XmlElement(name = "update_comments")
    protected String updateComments;
    @XmlElement(name = "create_date")
    protected String createDate;
    @XmlElement(name = "update_date")
    protected String updateDate;
    @XmlElement(name = "start_date")
    protected String startDate;
    @XmlElement(name = "end_date")
    protected String endDate;
    @XmlElement(name = "status_code")
    protected Long statusCode;
    @XmlElement(name = "contract_plan_instance_info")
    protected List<ContractPlanInstanceInfoReturnElement> contractPlanInstanceInfo;
    
    public Long getContractNo() {
        return contractNo;
    }

    public void setContractNo(Long value) {
        this.contractNo = value;
    }

    public String getClientContractId() {
        return clientContractId;
    }

    public void setClientContractId(String value) {
        this.clientContractId = value;
    }

    public String getContractScope() {
        return contractScope;
    }

    public void setContractScope(String value) {
        this.contractScope = value;
    }

    public Long getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Long value) {
        this.typeNo = value;
    }

    public Long getLengthMonths() {
        return lengthMonths;
    }

    public void setLengthMonths(Long value) {
        this.lengthMonths = value;
    }

    public Double getCancelFee() {
        return cancelFee;
    }

    public void setCancelFee(Double value) {
        this.cancelFee = value;
    }

    public String getCreateComments() {
        return createComments;
    }

    public void setCreateComments(String value) {
        this.createComments = value;
    }

    public String getUpdateComments() {
        return updateComments;
    }

    public void setUpdateComments(String value) {
        this.updateComments = value;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String value) {
        this.createDate = value;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String value) {
        this.updateDate = value;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String value) {
        this.startDate = value;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String value) {
        this.endDate = value;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long value) {
        this.statusCode = value;
    }

    public List<ContractPlanInstanceInfoReturnElement> getContractPlanInstanceInfo() {
        if (this.contractPlanInstanceInfo == null) {
            this.contractPlanInstanceInfo = new ArrayList<ContractPlanInstanceInfoReturnElement>();
        }
        return this.contractPlanInstanceInfo;
    }
}
