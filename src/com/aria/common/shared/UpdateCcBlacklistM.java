package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "ccNum",    "acctNo",    "clientAcctId",    "assignmentDirective",    "creditCardPaymentMethods",    "notes"})
@XmlRootElement(name = "update_cc_blacklist_m")
public class UpdateCcBlacklistM {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "cc_num")
    protected String ccNum;
        @XmlElement(name = "acct_no")
    protected Long acctNo;
        @XmlElement(name = "client_acct_id")
    protected String clientAcctId;
        @XmlElement(name = "assignment_directive")
    protected Long assignmentDirective;
        @XmlElement(name = "credit_card_payment_methods")
    protected CreditCardPaymentMethodsArray creditCardPaymentMethods;
        @XmlElement(name = "notes")
    protected String notes;
    
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

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String value) {
        this.ccNum = value;
    }
            public Long getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(Long value) {
        this.acctNo = value;
    }
            public String getClientAcctId() {
        return clientAcctId;
    }

    public void setClientAcctId(String value) {
        this.clientAcctId = value;
    }
            public Long getAssignmentDirective() {
        return assignmentDirective;
    }

    public void setAssignmentDirective(Long value) {
        this.assignmentDirective = value;
    }
            public CreditCardPaymentMethodsArray getCreditCardPaymentMethods() {
        return creditCardPaymentMethods;
    }

    public void setCreditCardPaymentMethods(CreditCardPaymentMethodsArray value) {
        this.creditCardPaymentMethods = value;
    }
            public String getNotes() {
        return notes;
    }

    public void setNotes(String value) {
        this.notes = value;
    }
            
}
