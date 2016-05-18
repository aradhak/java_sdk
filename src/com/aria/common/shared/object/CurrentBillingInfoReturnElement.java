package com.aria.common.shared.object;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "current_billing_info_ReturnElement", propOrder = {"billingFirstName", "billingMiddleInitial", "billingLastName", "billingAddress1", "billingAddress2", "billingCity", "billingState", "billingLocality", "billingZip", "billingCountry", "billingPhoneNpa", "billingPhoneNxx", "billingPhoneSuffix", "billingPhoneExtension", "billingIntlPhone", "billingEmail", "billingPayMethod", "billingCcExpireMm", "billingCcExpireYyyy", "billingBankRoutingNum", "billingAgreementId"})
public class CurrentBillingInfoReturnElement {

    @XmlElement(name = "billing_first_name")
    protected String billingFirstName;
    @XmlElement(name = "billing_middle_initial")
    protected String billingMiddleInitial;
    @XmlElement(name = "billing_last_name")
    protected String billingLastName;
    @XmlElement(name = "billing_address1")
    protected String billingAddress1;
    @XmlElement(name = "billing_address2")
    protected String billingAddress2;
    @XmlElement(name = "billing_city")
    protected String billingCity;
    @XmlElement(name = "billing_state")
    protected String billingState;
    @XmlElement(name = "billing_locality")
    protected String billingLocality;
    @XmlElement(name = "billing_zip")
    protected String billingZip;
    @XmlElement(name = "billing_country")
    protected String billingCountry;
    @XmlElement(name = "billing_phone_npa")
    protected String billingPhoneNpa;
    @XmlElement(name = "billing_phone_nxx")
    protected String billingPhoneNxx;
    @XmlElement(name = "billing_phone_suffix")
    protected String billingPhoneSuffix;
    @XmlElement(name = "billing_phone_extension")
    protected String billingPhoneExtension;
    @XmlElement(name = "billing_intl_phone")
    protected String billingIntlPhone;
    @XmlElement(name = "billing_email")
    protected String billingEmail;
    @XmlElement(name = "billing_pay_method")
    protected String billingPayMethod;
    @XmlElement(name = "billing_cc_expire_mm")
    protected String billingCcExpireMm;
    @XmlElement(name = "billing_cc_expire_yyyy")
    protected String billingCcExpireYyyy;
    @XmlElement(name = "billing_bank_routing_num")
    protected String billingBankRoutingNum;
    @XmlElement(name = "billing_agreement_id")
    protected String billingAgreementId;
    
    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String value) {
        this.billingFirstName = value;
    }

    public String getBillingMiddleInitial() {
        return billingMiddleInitial;
    }

    public void setBillingMiddleInitial(String value) {
        this.billingMiddleInitial = value;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String value) {
        this.billingLastName = value;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String value) {
        this.billingAddress1 = value;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String value) {
        this.billingAddress2 = value;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String value) {
        this.billingCity = value;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String value) {
        this.billingState = value;
    }

    public String getBillingLocality() {
        return billingLocality;
    }

    public void setBillingLocality(String value) {
        this.billingLocality = value;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String value) {
        this.billingZip = value;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String value) {
        this.billingCountry = value;
    }

    public String getBillingPhoneNpa() {
        return billingPhoneNpa;
    }

    public void setBillingPhoneNpa(String value) {
        this.billingPhoneNpa = value;
    }

    public String getBillingPhoneNxx() {
        return billingPhoneNxx;
    }

    public void setBillingPhoneNxx(String value) {
        this.billingPhoneNxx = value;
    }

    public String getBillingPhoneSuffix() {
        return billingPhoneSuffix;
    }

    public void setBillingPhoneSuffix(String value) {
        this.billingPhoneSuffix = value;
    }

    public String getBillingPhoneExtension() {
        return billingPhoneExtension;
    }

    public void setBillingPhoneExtension(String value) {
        this.billingPhoneExtension = value;
    }

    public String getBillingIntlPhone() {
        return billingIntlPhone;
    }

    public void setBillingIntlPhone(String value) {
        this.billingIntlPhone = value;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String value) {
        this.billingEmail = value;
    }

    public String getBillingPayMethod() {
        return billingPayMethod;
    }

    public void setBillingPayMethod(String value) {
        this.billingPayMethod = value;
    }

    public String getBillingCcExpireMm() {
        return billingCcExpireMm;
    }

    public void setBillingCcExpireMm(String value) {
        this.billingCcExpireMm = value;
    }

    public String getBillingCcExpireYyyy() {
        return billingCcExpireYyyy;
    }

    public void setBillingCcExpireYyyy(String value) {
        this.billingCcExpireYyyy = value;
    }

    public String getBillingBankRoutingNum() {
        return billingBankRoutingNum;
    }

    public void setBillingBankRoutingNum(String value) {
        this.billingBankRoutingNum = value;
    }

    public String getBillingAgreementId() {
        return billingAgreementId;
    }

    public void setBillingAgreementId(String value) {
        this.billingAgreementId = value;
    }

    
}
