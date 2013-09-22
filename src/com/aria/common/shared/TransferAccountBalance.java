package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey","sourceAccountNo","targetAccountNo"})
@XmlRootElement(name = "transfer_account_balance")
public class TransferAccountBalance {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
    @XmlElement(name = "source_account_no")
    protected Long sourceAccountNo;
    @XmlElement(name = "target_account_no")
    protected Long targetAccountNo;
    
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

    public Long getSourceAccountNo() {
        return sourceAccountNo;
    }

    public void setSourceAccountNo(Long value) {
        this.sourceAccountNo = value;
    }
    
    public Long getTargetAccountNo() {
        return targetAccountNo;
    }

    public void setTargetAccountNo(Long value) {
        this.targetAccountNo = value;
    }
    
    
}
