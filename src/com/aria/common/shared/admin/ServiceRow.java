package com.aria.common.shared.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "service_row", propOrder = {
    "name",
    "glCd",
    "taxable",
    "taxGroup",
    "commodityCd",
    "serviceNo",
    "clientServiceId",
    "serviceType",
    "taxableInd",
    "usageType",
    "rateType",
    "pricingRule",
    "highWater",
    "taxInclusiveInd",
    "usageThreshold",
    "tier",
    "fulfillmentBasedInd",
    "applyUsageRatesDaily",
    "billingOption",
    "threshold"
    })
public class ServiceRow {

    @XmlElement(name = "name")
    protected String name;
    @XmlElement(name = "gl_cd")
    protected String glCd;
    @XmlElement(name = "taxable")
    protected Long taxable;
    @XmlElement(name = "tax_group")
    protected Long taxGroup;
    @XmlElement(name = "commodity_cd")
    protected String commodityCd;
    @XmlElement(name = "service_no")
    protected Long serviceNo;
    @XmlElement(name = "client_service_id")
    protected String clientServiceId;
    @XmlElement(name = "service_type")
    protected String serviceType;
    @XmlElement(name = "taxable_ind")
    protected String taxableInd;
    @XmlElement(name = "usage_type")
    protected Long usageType;
    @XmlElement(name = "rate_type")
    protected String rateType;
    @XmlElement(name = "pricing_rule")
    protected String pricingRule;
    @XmlElement(name = "high_water")
    protected Long highWater;
    @XmlElement(name = "tax_inclusive_ind")
    protected Long taxInclusiveInd;
    @XmlElement(name = "usage_threshold")
    protected com.aria.common.shared.admin.UsageThresholdArray usageThreshold;
    @XmlElement(name = "tier")
    protected com.aria.common.shared.admin.TierArray tier;
    @XmlElement(name = "fulfillment_based_ind")
    protected Long fulfillmentBasedInd;
    @XmlElement(name = "apply_usage_rates_daily")
    protected Long applyUsageRatesDaily;
    @XmlElement(name = "billing_option")
    protected Long billingOption;
    @XmlElement(name = "threshold")
    protected Long threshold;
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getGlCd() {
        return glCd;
    }

    public void setGlCd(String value) {
        this.glCd = value;
    }

    public Long getTaxable() {
        return taxable;
    }

    public void setTaxable(Long value) {
        this.taxable = value;
    }

    public Long getTaxGroup() {
        return taxGroup;
    }

    public void setTaxGroup(Long value) {
        this.taxGroup = value;
    }

    public String getCommodityCd() {
        return commodityCd;
    }

    public void setCommodityCd(String value) {
        this.commodityCd = value;
    }

    public Long getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Long value) {
        this.serviceNo = value;
    }

    public String getClientServiceId() {
        return clientServiceId;
    }

    public void setClientServiceId(String value) {
        this.clientServiceId = value;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String value) {
        this.serviceType = value;
    }

    public String getTaxableInd() {
        return taxableInd;
    }

    public void setTaxableInd(String value) {
        this.taxableInd = value;
    }

    public Long getUsageType() {
        return usageType;
    }

    public void setUsageType(Long value) {
        this.usageType = value;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String value) {
        this.rateType = value;
    }

    public String getPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(String value) {
        this.pricingRule = value;
    }

    public Long getHighWater() {
        return highWater;
    }

    public void setHighWater(Long value) {
        this.highWater = value;
    }

    public Long getTaxInclusiveInd() {
        return taxInclusiveInd;
    }

    public void setTaxInclusiveInd(Long value) {
        this.taxInclusiveInd = value;
    }

    public com.aria.common.shared.admin.UsageThresholdArray getUsageThreshold() {
        return usageThreshold;
    }

    public void setUsageThreshold(com.aria.common.shared.admin.UsageThresholdArray value) {
        this.usageThreshold = value;
    }

    public com.aria.common.shared.admin.TierArray getTier() {
        return tier;
    }

    public void setTier(com.aria.common.shared.admin.TierArray value) {
        this.tier = value;
    }

    public Long getFulfillmentBasedInd() {
        return fulfillmentBasedInd;
    }

    public void setFulfillmentBasedInd(Long value) {
        this.fulfillmentBasedInd = value;
    }

    public Long getApplyUsageRatesDaily() {
        return applyUsageRatesDaily;
    }

    public void setApplyUsageRatesDaily(Long value) {
        this.applyUsageRatesDaily = value;
    }

    public Long getBillingOption() {
        return billingOption;
    }

    public void setBillingOption(Long value) {
        this.billingOption = value;
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long value) {
        this.threshold = value;
    }

    
}
