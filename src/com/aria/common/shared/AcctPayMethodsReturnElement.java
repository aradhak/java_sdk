package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acct_pay_methods_ReturnElement", propOrder = {"firstName", "middleInitial", "lastName", "address1", "address2", "city", "state", "zipcode", "country", "locality", "phone", "cellPhone", "workPhone", "email", "companyName", "seqNo", "payMethodId", "payMethodName", "persistentInd", "fromDate", "toDate", "ccExpMm", "ccExpYy", "ccId", "ccType", "bankRouting", "bankName", "bankAcctType", "suffix", "currentPayMethod", "billInfoApiReceiptId", "address3", "fromDateTime", "toDateTime", "bkupPayMethodInd", "billAgreementId"})
public class AcctPayMethodsReturnElement {

    @XmlElement(name = "first_name")
    protected String firstName;
    @XmlElement(name = "middle_initial")
    protected String middleInitial;
    @XmlElement(name = "last_name")
    protected String lastName;
    @XmlElement(name = "address1")
    protected String address1;
    @XmlElement(name = "address2")
    protected String address2;
    @XmlElement(name = "city")
    protected String city;
    @XmlElement(name = "state")
    protected String state;
    @XmlElement(name = "zipcode")
    protected String zipcode;
    @XmlElement(name = "country")
    protected String country;
    @XmlElement(name = "locality")
    protected String locality;
    @XmlElement(name = "phone")
    protected String phone;
    @XmlElement(name = "cell_phone")
    protected String cellPhone;
    @XmlElement(name = "work_phone")
    protected String workPhone;
    @XmlElement(name = "email")
    protected String email;
    @XmlElement(name = "company_name")
    protected String companyName;
    @XmlElement(name = "seq_no")
    protected Long seqNo;
    @XmlElement(name = "pay_method_id")
    protected Long payMethodId;
    @XmlElement(name = "pay_method_name")
    protected String payMethodName;
    @XmlElement(name = "persistent_ind")
    protected Long persistentInd;
    @XmlElement(name = "from_date")
    protected String fromDate;
    @XmlElement(name = "to_date")
    protected String toDate;
    @XmlElement(name = "cc_exp_mm")
    protected Long ccExpMm;
    @XmlElement(name = "cc_exp_yy")
    protected Long ccExpYy;
    @XmlElement(name = "cc_id")
    protected Long ccId;
    @XmlElement(name = "cc_type")
    protected String ccType;
    @XmlElement(name = "bank_routing")
    protected Long bankRouting;
    @XmlElement(name = "bank_name")
    protected String bankName;
    @XmlElement(name = "bank_acct_type")
    protected String bankAcctType;
    @XmlElement(name = "suffix")
    protected String suffix;
    @XmlElement(name = "current_pay_method")
    protected Long currentPayMethod;
    @XmlElement(name = "bill_info_api_receipt_id")
    protected String billInfoApiReceiptId;
    @XmlElement(name = "address3")
    protected String address3;
    @XmlElement(name = "from_date_time")
    protected String fromDateTime;
    @XmlElement(name = "to_date_time")
    protected String toDateTime;
    @XmlElement(name = "bkup_pay_method_ind")
    protected Long bkupPayMethodInd;
    @XmlElement(name = "bill_agreement_id")
    protected String billAgreementId;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String value) {
        this.middleInitial = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String value) {
        this.address1 = value;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String value) {
        this.address2 = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String value) {
        this.zipcode = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String value) {
        this.locality = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String value) {
        this.cellPhone = value;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String value) {
        this.workPhone = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String value) {
        this.companyName = value;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long value) {
        this.seqNo = value;
    }

    public Long getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(Long value) {
        this.payMethodId = value;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public void setPayMethodName(String value) {
        this.payMethodName = value;
    }

    public Long getPersistentInd() {
        return persistentInd;
    }

    public void setPersistentInd(Long value) {
        this.persistentInd = value;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String value) {
        this.fromDate = value;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String value) {
        this.toDate = value;
    }

    public Long getCcExpMm() {
        return ccExpMm;
    }

    public void setCcExpMm(Long value) {
        this.ccExpMm = value;
    }

    public Long getCcExpYy() {
        return ccExpYy;
    }

    public void setCcExpYy(Long value) {
        this.ccExpYy = value;
    }

    public Long getCcId() {
        return ccId;
    }

    public void setCcId(Long value) {
        this.ccId = value;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String value) {
        this.ccType = value;
    }

    public Long getBankRouting() {
        return bankRouting;
    }

    public void setBankRouting(Long value) {
        this.bankRouting = value;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String value) {
        this.bankName = value;
    }

    public String getBankAcctType() {
        return bankAcctType;
    }

    public void setBankAcctType(String value) {
        this.bankAcctType = value;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String value) {
        this.suffix = value;
    }

    public Long getCurrentPayMethod() {
        return currentPayMethod;
    }

    public void setCurrentPayMethod(Long value) {
        this.currentPayMethod = value;
    }

    public String getBillInfoApiReceiptId() {
        return billInfoApiReceiptId;
    }

    public void setBillInfoApiReceiptId(String value) {
        this.billInfoApiReceiptId = value;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String value) {
        this.address3 = value;
    }

    public String getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(String value) {
        this.fromDateTime = value;
    }

    public String getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(String value) {
        this.toDateTime = value;
    }

    public Long getBkupPayMethodInd() {
        return bkupPayMethodInd;
    }

    public void setBkupPayMethodInd(Long value) {
        this.bkupPayMethodInd = value;
    }

    public String getBillAgreementId() {
        return billAgreementId;
    }

    public void setBillAgreementId(String value) {
        this.billAgreementId = value;
    }

    
}
