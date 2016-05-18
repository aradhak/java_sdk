package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"errorCode", "errorMsg", "billAgreementId", "paypalEmail", "paypalPayerid", "paypalPayerstatus", "paypalCountrycode", "paypalShiptoname", "paypalShiptostreet", "paypalShipttostreet2", "paypalShiptocity", "paypalShiptostate", "paypalShiptozip", "paypalShiptocountrycode", "paypalAddressstatus"})
@XmlRootElement(name = "save_paypal_bill_agreementResponseElement")
public class SavePaypalBillAgreementResponseElement {

    @XmlElement(name = "error_code")
    protected Long errorCode;
    @XmlElement(name = "error_msg")
    protected String errorMsg;
    @XmlElement(name = "bill_agreement_id")
    protected String billAgreementId;
    @XmlElement(name = "paypal_email")
    protected String paypalEmail;
    @XmlElement(name = "paypal_payerid")
    protected String paypalPayerid;
    @XmlElement(name = "paypal_payerstatus")
    protected String paypalPayerstatus;
    @XmlElement(name = "paypal_countrycode")
    protected String paypalCountrycode;
    @XmlElement(name = "paypal_shiptoname")
    protected String paypalShiptoname;
    @XmlElement(name = "paypal_shiptostreet")
    protected String paypalShiptostreet;
    @XmlElement(name = "paypal_shipttostreet2")
    protected String paypalShipttostreet2;
    @XmlElement(name = "paypal_shiptocity")
    protected String paypalShiptocity;
    @XmlElement(name = "paypal_shiptostate")
    protected String paypalShiptostate;
    @XmlElement(name = "paypal_shiptozip")
    protected String paypalShiptozip;
    @XmlElement(name = "paypal_shiptocountrycode")
    protected String paypalShiptocountrycode;
    @XmlElement(name = "paypal_addressstatus")
    protected String paypalAddressstatus;
    
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

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(String value) {
        this.paypalEmail = value;
    }

    public String getPaypalPayerid() {
        return paypalPayerid;
    }

    public void setPaypalPayerid(String value) {
        this.paypalPayerid = value;
    }

    public String getPaypalPayerstatus() {
        return paypalPayerstatus;
    }

    public void setPaypalPayerstatus(String value) {
        this.paypalPayerstatus = value;
    }

    public String getPaypalCountrycode() {
        return paypalCountrycode;
    }

    public void setPaypalCountrycode(String value) {
        this.paypalCountrycode = value;
    }

    public String getPaypalShiptoname() {
        return paypalShiptoname;
    }

    public void setPaypalShiptoname(String value) {
        this.paypalShiptoname = value;
    }

    public String getPaypalShiptostreet() {
        return paypalShiptostreet;
    }

    public void setPaypalShiptostreet(String value) {
        this.paypalShiptostreet = value;
    }

    public String getPaypalShipttostreet2() {
        return paypalShipttostreet2;
    }

    public void setPaypalShipttostreet2(String value) {
        this.paypalShipttostreet2 = value;
    }

    public String getPaypalShiptocity() {
        return paypalShiptocity;
    }

    public void setPaypalShiptocity(String value) {
        this.paypalShiptocity = value;
    }

    public String getPaypalShiptostate() {
        return paypalShiptostate;
    }

    public void setPaypalShiptostate(String value) {
        this.paypalShiptostate = value;
    }

    public String getPaypalShiptozip() {
        return paypalShiptozip;
    }

    public void setPaypalShiptozip(String value) {
        this.paypalShiptozip = value;
    }

    public String getPaypalShiptocountrycode() {
        return paypalShiptocountrycode;
    }

    public void setPaypalShiptocountrycode(String value) {
        this.paypalShiptocountrycode = value;
    }

    public String getPaypalAddressstatus() {
        return paypalAddressstatus;
    }

    public void setPaypalAddressstatus(String value) {
        this.paypalAddressstatus = value;
    }

    
}
