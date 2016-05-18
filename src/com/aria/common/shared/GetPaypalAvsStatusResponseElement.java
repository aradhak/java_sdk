package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"errorCode", "errorMsg", "billAgreementId", "email", "paypalConfirmationcode", "paypalStreetmatch", "paypalZipmatch", "paypalCountrycode", "paypalToken"})
@XmlRootElement(name = "get_paypal_avs_statusResponseElement")
public class GetPaypalAvsStatusResponseElement {

    @XmlElement(name = "error_code")
    protected Long errorCode;
    @XmlElement(name = "error_msg")
    protected String errorMsg;
    @XmlElement(name = "bill_agreement_id")
    protected String billAgreementId;
    @XmlElement(name = "email")
    protected String email;
    @XmlElement(name = "paypal_confirmationcode")
    protected String paypalConfirmationcode;
    @XmlElement(name = "paypal_streetmatch")
    protected String paypalStreetmatch;
    @XmlElement(name = "paypal_zipmatch")
    protected String paypalZipmatch;
    @XmlElement(name = "paypal_countrycode")
    protected String paypalCountrycode;
    @XmlElement(name = "paypal_token")
    protected String paypalToken;
    
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

    public String getBillAgreementId() {
        return billAgreementId;
    }

    public void setBillAgreementId(String value) {
        this.billAgreementId = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getPaypalConfirmationcode() {
        return paypalConfirmationcode;
    }

    public void setPaypalConfirmationcode(String value) {
        this.paypalConfirmationcode = value;
    }

    public String getPaypalStreetmatch() {
        return paypalStreetmatch;
    }

    public void setPaypalStreetmatch(String value) {
        this.paypalStreetmatch = value;
    }

    public String getPaypalZipmatch() {
        return paypalZipmatch;
    }

    public void setPaypalZipmatch(String value) {
        this.paypalZipmatch = value;
    }

    public String getPaypalCountrycode() {
        return paypalCountrycode;
    }

    public void setPaypalCountrycode(String value) {
        this.paypalCountrycode = value;
    }

    public String getPaypalToken() {
        return paypalToken;
    }

    public void setPaypalToken(String value) {
        this.paypalToken = value;
    }

    
}
