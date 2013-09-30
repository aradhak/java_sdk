package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey","invoiceNo","acctNo","actionDirective","billSeq","altPayMethod","ccNumber","ccExpireMm","ccExpireYyyy","bankRoutingNum","bankAcctNum","billCompanyName","billFirstName","billMiddleInitial","billLastName","billAddress1","billAddress2","billCity","billLocality","billStateProv","billZip","billCountry","billEmail","billPhone","billPhoneExtension","billCellPhone","billWorkPhone","billWorkPhoneExtension","cvv","altCollectOnApprove","altSendStatementOnApprove","cancelOrdersOnDiscard","billAddress3","trackData1","trackData2"})
@XmlRootElement(name = "manage_pending_invoice")
public class ManagePendingInvoice {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
    @XmlElement(name = "invoice_no")
    protected Long invoiceNo;
    @XmlElement(name = "acct_no")
    protected Long acctNo;
    @XmlElement(name = "action_directive")
    protected Long actionDirective;
    @XmlElement(name = "bill_seq")
    protected Long billSeq;
    @XmlElement(name = "alt_pay_method")
    protected Long altPayMethod;
    @XmlElement(name = "cc_number")
    protected String ccNumber;
    @XmlElement(name = "cc_expire_mm")
    protected Long ccExpireMm;
    @XmlElement(name = "cc_expire_yyyy")
    protected Long ccExpireYyyy;
    @XmlElement(name = "bank_routing_num")
    protected String bankRoutingNum;
    @XmlElement(name = "bank_acct_num")
    protected String bankAcctNum;
    @XmlElement(name = "bill_company_name")
    protected String billCompanyName;
    @XmlElement(name = "bill_first_name")
    protected String billFirstName;
    @XmlElement(name = "bill_middle_initial")
    protected String billMiddleInitial;
    @XmlElement(name = "bill_last_name")
    protected String billLastName;
    @XmlElement(name = "bill_address1")
    protected String billAddress1;
    @XmlElement(name = "bill_address2")
    protected String billAddress2;
    @XmlElement(name = "bill_city")
    protected String billCity;
    @XmlElement(name = "bill_locality")
    protected String billLocality;
    @XmlElement(name = "bill_state_prov")
    protected String billStateProv;
    @XmlElement(name = "bill_zip")
    protected String billZip;
    @XmlElement(name = "bill_country")
    protected String billCountry;
    @XmlElement(name = "bill_email")
    protected String billEmail;
    @XmlElement(name = "bill_phone")
    protected String billPhone;
    @XmlElement(name = "bill_phone_extension")
    protected String billPhoneExtension;
    @XmlElement(name = "bill_cell_phone")
    protected String billCellPhone;
    @XmlElement(name = "bill_work_phone")
    protected String billWorkPhone;
    @XmlElement(name = "bill_work_phone_extension")
    protected String billWorkPhoneExtension;
    @XmlElement(name = "cvv")
    protected String cvv;
    @XmlElement(name = "alt_collect_on_approve")
    protected String altCollectOnApprove;
    @XmlElement(name = "alt_send_statement_on_approve")
    protected String altSendStatementOnApprove;
    @XmlElement(name = "cancel_orders_on_discard")
    protected String cancelOrdersOnDiscard;
    @XmlElement(name = "bill_address3")
    protected String billAddress3;
    @XmlElement(name = "track_data1")
    protected String trackData1;
    @XmlElement(name = "track_data2")
    protected String trackData2;
    
    public long getClientNo() {
        return clientNo;
    }

    public void setClientNo(Long value) {
        this.clientNo = value;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String value) {
        this.authKey = value;
    }

    public Long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Long value) {
        this.invoiceNo = value;
    }
    
    public Long getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(Long value) {
        this.acctNo = value;
    }
    
    public Long getActionDirective() {
        return actionDirective;
    }

    public void setActionDirective(Long value) {
        this.actionDirective = value;
    }
    
    public Long getBillSeq() {
        return billSeq;
    }

    public void setBillSeq(Long value) {
        this.billSeq = value;
    }
    
    public Long getAltPayMethod() {
        return altPayMethod;
    }

    public void setAltPayMethod(Long value) {
        this.altPayMethod = value;
    }
    
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String value) {
        this.ccNumber = value;
    }
    
    public Long getCcExpireMm() {
        return ccExpireMm;
    }

    public void setCcExpireMm(Long value) {
        this.ccExpireMm = value;
    }
    
    public Long getCcExpireYyyy() {
        return ccExpireYyyy;
    }

    public void setCcExpireYyyy(Long value) {
        this.ccExpireYyyy = value;
    }
    
    public String getBankRoutingNum() {
        return bankRoutingNum;
    }

    public void setBankRoutingNum(String value) {
        this.bankRoutingNum = value;
    }
    
    public String getBankAcctNum() {
        return bankAcctNum;
    }

    public void setBankAcctNum(String value) {
        this.bankAcctNum = value;
    }
    
    public String getBillCompanyName() {
        return billCompanyName;
    }

    public void setBillCompanyName(String value) {
        this.billCompanyName = value;
    }
    
    public String getBillFirstName() {
        return billFirstName;
    }

    public void setBillFirstName(String value) {
        this.billFirstName = value;
    }
    
    public String getBillMiddleInitial() {
        return billMiddleInitial;
    }

    public void setBillMiddleInitial(String value) {
        this.billMiddleInitial = value;
    }
    
    public String getBillLastName() {
        return billLastName;
    }

    public void setBillLastName(String value) {
        this.billLastName = value;
    }
    
    public String getBillAddress1() {
        return billAddress1;
    }

    public void setBillAddress1(String value) {
        this.billAddress1 = value;
    }
    
    public String getBillAddress2() {
        return billAddress2;
    }

    public void setBillAddress2(String value) {
        this.billAddress2 = value;
    }
    
    public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String value) {
        this.billCity = value;
    }
    
    public String getBillLocality() {
        return billLocality;
    }

    public void setBillLocality(String value) {
        this.billLocality = value;
    }
    
    public String getBillStateProv() {
        return billStateProv;
    }

    public void setBillStateProv(String value) {
        this.billStateProv = value;
    }
    
    public String getBillZip() {
        return billZip;
    }

    public void setBillZip(String value) {
        this.billZip = value;
    }
    
    public String getBillCountry() {
        return billCountry;
    }

    public void setBillCountry(String value) {
        this.billCountry = value;
    }
    
    public String getBillEmail() {
        return billEmail;
    }

    public void setBillEmail(String value) {
        this.billEmail = value;
    }
    
    public String getBillPhone() {
        return billPhone;
    }

    public void setBillPhone(String value) {
        this.billPhone = value;
    }
    
    public String getBillPhoneExtension() {
        return billPhoneExtension;
    }

    public void setBillPhoneExtension(String value) {
        this.billPhoneExtension = value;
    }
    
    public String getBillCellPhone() {
        return billCellPhone;
    }

    public void setBillCellPhone(String value) {
        this.billCellPhone = value;
    }
    
    public String getBillWorkPhone() {
        return billWorkPhone;
    }

    public void setBillWorkPhone(String value) {
        this.billWorkPhone = value;
    }
    
    public String getBillWorkPhoneExtension() {
        return billWorkPhoneExtension;
    }

    public void setBillWorkPhoneExtension(String value) {
        this.billWorkPhoneExtension = value;
    }
    
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String value) {
        this.cvv = value;
    }
    
    public String getAltCollectOnApprove() {
        return altCollectOnApprove;
    }

    public void setAltCollectOnApprove(String value) {
        this.altCollectOnApprove = value;
    }
    
    public String getAltSendStatementOnApprove() {
        return altSendStatementOnApprove;
    }

    public void setAltSendStatementOnApprove(String value) {
        this.altSendStatementOnApprove = value;
    }
    
    public String getCancelOrdersOnDiscard() {
        return cancelOrdersOnDiscard;
    }

    public void setCancelOrdersOnDiscard(String value) {
        this.cancelOrdersOnDiscard = value;
    }
    
    public String getBillAddress3() {
        return billAddress3;
    }

    public void setBillAddress3(String value) {
        this.billAddress3 = value;
    }
    
    public String getTrackData1() {
        return trackData1;
    }

    public void setTrackData1(String value) {
        this.trackData1 = value;
    }
    
    public String getTrackData2() {
        return trackData2;
    }

    public void setTrackData2(String value) {
        this.trackData2 = value;
    }
    
    
}