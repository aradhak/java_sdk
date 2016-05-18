package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "acctNo",    "paymentTransactionId",    "reasonCode",    "totalRefundAmount",    "refundCheckNumber",    "comments",    "doWrite",    "autoCalcRefund",    "invoicesToReverse",    "clientReceiptId",    "isUnlinkedRefund",    "altPayMethod",    "ccNumber",    "ccExpireMm",    "ccExpireYyyy",    "cvv",    "billFirstName",    "billLastName",    "billCompanyName",    "billAddress1",    "billAddress2",    "billAddress3",    "billCity",    "billLocality",    "billCountry",    "billStateProv",    "billZip",    "billPhone",    "billCellPhone",    "billWorkPhone",    "billEmail"})
@XmlRootElement(name = "issue_refund_to_acct")
public class IssueRefundToAcct {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "acct_no")
    protected Long acctNo;
        @XmlElement(name = "payment_transaction_id")
    protected Long paymentTransactionId;
        @XmlElement(name = "reason_code")
    protected Long reasonCode;
        @XmlElement(name = "total_refund_amount")
    protected Double totalRefundAmount;
        @XmlElement(name = "refund_check_number")
    protected String refundCheckNumber;
        @XmlElement(name = "comments")
    protected String comments;
        @XmlElement(name = "do_write")
    protected String doWrite;
        @XmlElement(name = "auto_calc_refund")
    protected String autoCalcRefund;
        @XmlElement(name = "invoices_to_reverse")
    protected InvoicesToReverseArray invoicesToReverse;
        @XmlElement(name = "client_receipt_id")
    protected String clientReceiptId;
        @XmlElement(name = "is_unlinked_refund")
    protected String isUnlinkedRefund;
        @XmlElement(name = "alt_pay_method")
    protected Long altPayMethod;
        @XmlElement(name = "cc_number")
    protected String ccNumber;
        @XmlElement(name = "cc_expire_mm")
    protected Long ccExpireMm;
        @XmlElement(name = "cc_expire_yyyy")
    protected Long ccExpireYyyy;
        @XmlElement(name = "cvv")
    protected String cvv;
        @XmlElement(name = "bill_first_name")
    protected String billFirstName;
        @XmlElement(name = "bill_last_name")
    protected String billLastName;
        @XmlElement(name = "bill_company_name")
    protected String billCompanyName;
        @XmlElement(name = "bill_address1")
    protected String billAddress1;
        @XmlElement(name = "bill_address2")
    protected String billAddress2;
        @XmlElement(name = "bill_address3")
    protected String billAddress3;
        @XmlElement(name = "bill_city")
    protected String billCity;
        @XmlElement(name = "bill_locality")
    protected String billLocality;
        @XmlElement(name = "bill_country")
    protected String billCountry;
        @XmlElement(name = "bill_state_prov")
    protected String billStateProv;
        @XmlElement(name = "bill_zip")
    protected String billZip;
        @XmlElement(name = "bill_phone")
    protected String billPhone;
        @XmlElement(name = "bill_cell_phone")
    protected String billCellPhone;
        @XmlElement(name = "bill_work_phone")
    protected String billWorkPhone;
        @XmlElement(name = "bill_email")
    protected String billEmail;
    
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

    public Long getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(Long value) {
        this.acctNo = value;
    }
            public Long getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(Long value) {
        this.paymentTransactionId = value;
    }
            public Long getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Long value) {
        this.reasonCode = value;
    }
            public Double getTotalRefundAmount() {
        return totalRefundAmount;
    }

    public void setTotalRefundAmount(Double value) {
        this.totalRefundAmount = value;
    }
            public String getRefundCheckNumber() {
        return refundCheckNumber;
    }

    public void setRefundCheckNumber(String value) {
        this.refundCheckNumber = value;
    }
            public String getComments() {
        return comments;
    }

    public void setComments(String value) {
        this.comments = value;
    }
            public String getDoWrite() {
        return doWrite;
    }

    public void setDoWrite(String value) {
        this.doWrite = value;
    }
            public String getAutoCalcRefund() {
        return autoCalcRefund;
    }

    public void setAutoCalcRefund(String value) {
        this.autoCalcRefund = value;
    }
            public InvoicesToReverseArray getInvoicesToReverse() {
        return invoicesToReverse;
    }

    public void setInvoicesToReverse(InvoicesToReverseArray value) {
        this.invoicesToReverse = value;
    }
            public String getClientReceiptId() {
        return clientReceiptId;
    }

    public void setClientReceiptId(String value) {
        this.clientReceiptId = value;
    }
            public String getIsUnlinkedRefund() {
        return isUnlinkedRefund;
    }

    public void setIsUnlinkedRefund(String value) {
        this.isUnlinkedRefund = value;
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
            public String getCvv() {
        return cvv;
    }

    public void setCvv(String value) {
        this.cvv = value;
    }
            public String getBillFirstName() {
        return billFirstName;
    }

    public void setBillFirstName(String value) {
        this.billFirstName = value;
    }
            public String getBillLastName() {
        return billLastName;
    }

    public void setBillLastName(String value) {
        this.billLastName = value;
    }
            public String getBillCompanyName() {
        return billCompanyName;
    }

    public void setBillCompanyName(String value) {
        this.billCompanyName = value;
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
            public String getBillAddress3() {
        return billAddress3;
    }

    public void setBillAddress3(String value) {
        this.billAddress3 = value;
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
            public String getBillCountry() {
        return billCountry;
    }

    public void setBillCountry(String value) {
        this.billCountry = value;
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
            public String getBillPhone() {
        return billPhone;
    }

    public void setBillPhone(String value) {
        this.billPhone = value;
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
            public String getBillEmail() {
        return billEmail;
    }

    public void setBillEmail(String value) {
        this.billEmail = value;
    }
            
}
