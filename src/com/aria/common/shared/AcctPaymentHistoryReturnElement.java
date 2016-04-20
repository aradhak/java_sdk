package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acct_payment_history_ReturnElement", propOrder = {"transactionId", "paymentSource", "paymentStatus", "paymentDate", "paymentTransType", "paymentCurrency", "paymentAmount", "paymentAmountLeftToApply", "voidingEventNo", "voidableFlag", "ccSuffix", "ccString", "payMethodType", "procStatusCode", "procPaymentId", "procAuthCode", "paymentTimestamp", "procStatusText", "paymentMethodNo", "clientPaymentMethodId", "paymentReceivedDate", "paymentApplicationDetails"})
public class AcctPaymentHistoryReturnElement {

    @XmlElement(name = "transaction_id")
    protected Long transactionId;
    @XmlElement(name = "payment_source")
    protected String paymentSource;
    @XmlElement(name = "payment_status")
    protected String paymentStatus;
    @XmlElement(name = "payment_date")
    protected String paymentDate;
    @XmlElement(name = "payment_trans_type")
    protected Long paymentTransType;
    @XmlElement(name = "payment_currency")
    protected String paymentCurrency;
    @XmlElement(name = "payment_amount")
    protected Double paymentAmount;
    @XmlElement(name = "payment_amount_left_to_apply")
    protected Double paymentAmountLeftToApply;
    @XmlElement(name = "voiding_event_no")
    protected Long voidingEventNo;
    @XmlElement(name = "voidable_flag")
    protected Long voidableFlag;
    @XmlElement(name = "cc_suffix")
    protected String ccSuffix;
    @XmlElement(name = "cc_string")
    protected String ccString;
    @XmlElement(name = "pay_method_type")
    protected Long payMethodType;
    @XmlElement(name = "proc_status_code")
    protected Long procStatusCode;
    @XmlElement(name = "proc_payment_id")
    protected String procPaymentId;
    @XmlElement(name = "proc_auth_code")
    protected String procAuthCode;
    @XmlElement(name = "payment_timestamp")
    protected String paymentTimestamp;
    @XmlElement(name = "proc_status_text")
    protected String procStatusText;
    @XmlElement(name = "payment_method_no")
    protected Long paymentMethodNo;
    @XmlElement(name = "client_payment_method_id")
    protected String clientPaymentMethodId;
    @XmlElement(name = "payment_received_date")
    protected String paymentReceivedDate;
    @XmlElement(name = "payment_application_details")
    protected List<PaymentApplicationDetailsReturnElement> paymentApplicationDetails;
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long value) {
        this.transactionId = value;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setPaymentSource(String value) {
        this.paymentSource = value;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String value) {
        this.paymentStatus = value;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    public Long getPaymentTransType() {
        return paymentTransType;
    }

    public void setPaymentTransType(Long value) {
        this.paymentTransType = value;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String value) {
        this.paymentCurrency = value;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double value) {
        this.paymentAmount = value;
    }

    public Double getPaymentAmountLeftToApply() {
        return paymentAmountLeftToApply;
    }

    public void setPaymentAmountLeftToApply(Double value) {
        this.paymentAmountLeftToApply = value;
    }

    public Long getVoidingEventNo() {
        return voidingEventNo;
    }

    public void setVoidingEventNo(Long value) {
        this.voidingEventNo = value;
    }

    public Long getVoidableFlag() {
        return voidableFlag;
    }

    public void setVoidableFlag(Long value) {
        this.voidableFlag = value;
    }

    public String getCcSuffix() {
        return ccSuffix;
    }

    public void setCcSuffix(String value) {
        this.ccSuffix = value;
    }

    public String getCcString() {
        return ccString;
    }

    public void setCcString(String value) {
        this.ccString = value;
    }

    public Long getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(Long value) {
        this.payMethodType = value;
    }

    public Long getProcStatusCode() {
        return procStatusCode;
    }

    public void setProcStatusCode(Long value) {
        this.procStatusCode = value;
    }

    public String getProcPaymentId() {
        return procPaymentId;
    }

    public void setProcPaymentId(String value) {
        this.procPaymentId = value;
    }

    public String getProcAuthCode() {
        return procAuthCode;
    }

    public void setProcAuthCode(String value) {
        this.procAuthCode = value;
    }

    public String getPaymentTimestamp() {
        return paymentTimestamp;
    }

    public void setPaymentTimestamp(String value) {
        this.paymentTimestamp = value;
    }

    public String getProcStatusText() {
        return procStatusText;
    }

    public void setProcStatusText(String value) {
        this.procStatusText = value;
    }

    public Long getPaymentMethodNo() {
        return paymentMethodNo;
    }

    public void setPaymentMethodNo(Long value) {
        this.paymentMethodNo = value;
    }

    public String getClientPaymentMethodId() {
        return clientPaymentMethodId;
    }

    public void setClientPaymentMethodId(String value) {
        this.clientPaymentMethodId = value;
    }

    public String getPaymentReceivedDate() {
        return paymentReceivedDate;
    }

    public void setPaymentReceivedDate(String value) {
        this.paymentReceivedDate = value;
    }

    public List<PaymentApplicationDetailsReturnElement> getPaymentApplicationDetails() {
        if (this.paymentApplicationDetails == null) {
            this.paymentApplicationDetails = new ArrayList<PaymentApplicationDetailsReturnElement>();
        }
        return this.paymentApplicationDetails;
    }
}
