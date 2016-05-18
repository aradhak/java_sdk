package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "error_codes_ReturnElement", propOrder = {"recurCreditNo", "errorCode", "errorMsg"})
public class ErrorCodesReturnElement {

    @XmlElement(name = "recur_credit_no")
    protected Long recurCreditNo;
    @XmlElement(name = "error_code")
    protected Long errorCode;
    @XmlElement(name = "error_msg")
    protected String errorMsg;
    
    public Long getRecurCreditNo() {
        return recurCreditNo;
    }

    public void setRecurCreditNo(Long value) {
        this.recurCreditNo = value;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long value) {
        this.errorCode = value;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

    
}
