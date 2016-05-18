package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "client_ReturnElement", propOrder = {"clientName", "domain", "address1", "address2", "city", "locality", "stateProv", "country", "postalCode", "phone", "contact", "contactAddress1", "contactAddress2", "contactCity", "contactState", "contactZip", "contactPhone", "contactEmail", "billingContact", "billingAddress1", "billingAddress2", "billingCity", "billingState", "billingZip", "billingPhone", "billingEmail", "contactCountry", "contactLocality", "billingCountry", "billingLocality", "batchJobAlertContact", "batchJobAlertEmail", "clientLocaleName", "localeNo", "localeName"})
public class ClientReturnElement {

    @XmlElement(name = "client_name")
    protected String clientName;
    @XmlElement(name = "domain")
    protected String domain;
    @XmlElement(name = "address1")
    protected String address1;
    @XmlElement(name = "address2")
    protected String address2;
    @XmlElement(name = "city")
    protected String city;
    @XmlElement(name = "locality")
    protected String locality;
    @XmlElement(name = "state_prov")
    protected String stateProv;
    @XmlElement(name = "country")
    protected String country;
    @XmlElement(name = "postal_code")
    protected String postalCode;
    @XmlElement(name = "phone")
    protected String phone;
    @XmlElement(name = "contact")
    protected String contact;
    @XmlElement(name = "contact_address1")
    protected String contactAddress1;
    @XmlElement(name = "contact_address2")
    protected String contactAddress2;
    @XmlElement(name = "contact_city")
    protected String contactCity;
    @XmlElement(name = "contact_state")
    protected String contactState;
    @XmlElement(name = "contact_zip")
    protected String contactZip;
    @XmlElement(name = "contact_phone")
    protected String contactPhone;
    @XmlElement(name = "contact_email")
    protected String contactEmail;
    @XmlElement(name = "billing_contact")
    protected String billingContact;
    @XmlElement(name = "billing_address1")
    protected String billingAddress1;
    @XmlElement(name = "billing_address2")
    protected String billingAddress2;
    @XmlElement(name = "billing_city")
    protected String billingCity;
    @XmlElement(name = "billing_state")
    protected String billingState;
    @XmlElement(name = "billing_zip")
    protected String billingZip;
    @XmlElement(name = "billing_phone")
    protected String billingPhone;
    @XmlElement(name = "billing_email")
    protected String billingEmail;
    @XmlElement(name = "contact_country")
    protected String contactCountry;
    @XmlElement(name = "contact_locality")
    protected String contactLocality;
    @XmlElement(name = "billing_country")
    protected String billingCountry;
    @XmlElement(name = "billing_locality")
    protected String billingLocality;
    @XmlElement(name = "batch_job_alert_contact")
    protected String batchJobAlertContact;
    @XmlElement(name = "batch_job_alert_email")
    protected String batchJobAlertEmail;
    @XmlElement(name = "client_locale_name")
    protected String clientLocaleName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "locale_name")
    protected String localeName;
    
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String value) {
        this.clientName = value;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String value) {
        this.domain = value;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String value) {
        this.address1 = value;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String value) {
        this.address2 = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String value) {
        this.locality = value;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String value) {
        this.stateProv = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String value) {
        this.contact = value;
    }

    public String getContactAddress1() {
        return contactAddress1;
    }

    public void setContactAddress1(String value) {
        this.contactAddress1 = value;
    }

    public String getContactAddress2() {
        return contactAddress2;
    }

    public void setContactAddress2(String value) {
        this.contactAddress2 = value;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String value) {
        this.contactCity = value;
    }

    public String getContactState() {
        return contactState;
    }

    public void setContactState(String value) {
        this.contactState = value;
    }

    public String getContactZip() {
        return contactZip;
    }

    public void setContactZip(String value) {
        this.contactZip = value;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    public String getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(String value) {
        this.billingContact = value;
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

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String value) {
        this.billingZip = value;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String value) {
        this.billingPhone = value;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String value) {
        this.billingEmail = value;
    }

    public String getContactCountry() {
        return contactCountry;
    }

    public void setContactCountry(String value) {
        this.contactCountry = value;
    }

    public String getContactLocality() {
        return contactLocality;
    }

    public void setContactLocality(String value) {
        this.contactLocality = value;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String value) {
        this.billingCountry = value;
    }

    public String getBillingLocality() {
        return billingLocality;
    }

    public void setBillingLocality(String value) {
        this.billingLocality = value;
    }

    public String getBatchJobAlertContact() {
        return batchJobAlertContact;
    }

    public void setBatchJobAlertContact(String value) {
        this.batchJobAlertContact = value;
    }

    public String getBatchJobAlertEmail() {
        return batchJobAlertEmail;
    }

    public void setBatchJobAlertEmail(String value) {
        this.batchJobAlertEmail = value;
    }

    public String getClientLocaleName() {
        return clientLocaleName;
    }

    public void setClientLocaleName(String value) {
        this.clientLocaleName = value;
    }

    public Long getLocaleNo() {
        return localeNo;
    }

    public void setLocaleNo(Long value) {
        this.localeNo = value;
    }

    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String value) {
        this.localeName = value;
    }

    
}
