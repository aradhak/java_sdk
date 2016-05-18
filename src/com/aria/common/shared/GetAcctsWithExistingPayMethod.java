package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "payMethod",    "formPaymentAcctId",    "bankRoutingNum",    "billAgreementId"})
@XmlRootElement(name = "get_accts_with_existing_pay_method")
public class GetAcctsWithExistingPayMethod {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "pay_method")
    protected Long payMethod;
        @XmlElement(name = "form_payment_acct_id")
    protected String formPaymentAcctId;
        @XmlElement(name = "bank_routing_num")
    protected String bankRoutingNum;
        @XmlElement(name = "bill_agreement_id")
    protected String billAgreementId;
    
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

    public Long getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Long value) {
        this.payMethod = value;
    }
            public String getFormPaymentAcctId() {
        return formPaymentAcctId;
    }

    public void setFormPaymentAcctId(String value) {
        this.formPaymentAcctId = value;
    }
            public String getBankRoutingNum() {
        return bankRoutingNum;
    }

    public void setBankRoutingNum(String value) {
        this.bankRoutingNum = value;
    }
            public String getBillAgreementId() {
        return billAgreementId;
    }

    public void setBillAgreementId(String value) {
        this.billAgreementId = value;
    }
            
}
