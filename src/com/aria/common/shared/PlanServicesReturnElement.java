package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plan_services_ReturnElement", propOrder = {"serviceNo", "serviceDesc", "isRecurringInd", "isUsageBasedInd", "usageType", "taxableInd", "isTaxInd", "isArrearsInd", "isSetupInd", "isMiscInd", "isDonationInd", "isOrderBasedInd", "isCancellationInd", "coaId", "ledgerCode", "clientCoaCode", "displayInd", "tieredPricingRule", "isMinFeeInd", "clientServiceId", "usageTypeCd", "allServiceSuppFields", "fulfillmentBasedInd", "planServiceRates", "allPlanServiceRates", "usageTypeName", "usageTypeDesc", "usageTypeCode", "usageUnitLabel", "applyUsageRatesDaily"})
public class PlanServicesReturnElement {

    @XmlElement(name = "service_no")
    protected Long serviceNo;
    @XmlElement(name = "service_desc")
    protected String serviceDesc;
    @XmlElement(name = "is_recurring_ind")
    protected Long isRecurringInd;
    @XmlElement(name = "is_usage_based_ind")
    protected Long isUsageBasedInd;
    @XmlElement(name = "usage_type")
    protected Long usageType;
    @XmlElement(name = "taxable_ind")
    protected Long taxableInd;
    @XmlElement(name = "is_tax_ind")
    protected Long isTaxInd;
    @XmlElement(name = "is_arrears_ind")
    protected Long isArrearsInd;
    @XmlElement(name = "is_setup_ind")
    protected Long isSetupInd;
    @XmlElement(name = "is_misc_ind")
    protected Long isMiscInd;
    @XmlElement(name = "is_donation_ind")
    protected Long isDonationInd;
    @XmlElement(name = "is_order_based_ind")
    protected Long isOrderBasedInd;
    @XmlElement(name = "is_cancellation_ind")
    protected Long isCancellationInd;
    @XmlElement(name = "coa_id")
    protected String coaId;
    @XmlElement(name = "ledger_code")
    protected String ledgerCode;
    @XmlElement(name = "client_coa_code")
    protected String clientCoaCode;
    @XmlElement(name = "display_ind")
    protected Long displayInd;
    @XmlElement(name = "tiered_pricing_rule")
    protected Long tieredPricingRule;
    @XmlElement(name = "is_min_fee_ind")
    protected Long isMinFeeInd;
    @XmlElement(name = "client_service_id")
    protected String clientServiceId;
    @XmlElement(name = "usage_type_cd")
    protected String usageTypeCd;
    @XmlElement(name = "all_service_supp_fields")
    protected List<AllServiceSuppFieldsReturnElement> allServiceSuppFields;
    @XmlElement(name = "fulfillment_based_ind")
    protected Long fulfillmentBasedInd;
    @XmlElement(name = "plan_service_rates")
    protected List<PlanServiceRatesReturnElement> planServiceRates;
    @XmlElement(name = "all_plan_service_rates")
    protected List<AllPlanServiceRatesReturnElement> allPlanServiceRates;
    @XmlElement(name = "usage_type_name")
    protected String usageTypeName;
    @XmlElement(name = "usage_type_desc")
    protected String usageTypeDesc;
    @XmlElement(name = "usage_type_code")
    protected String usageTypeCode;
    @XmlElement(name = "usage_unit_label")
    protected String usageUnitLabel;
    @XmlElement(name = "apply_usage_rates_daily")
    protected Long applyUsageRatesDaily;
    
    public Long getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Long value) {
        this.serviceNo = value;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String value) {
        this.serviceDesc = value;
    }

    public Long getIsRecurringInd() {
        return isRecurringInd;
    }

    public void setIsRecurringInd(Long value) {
        this.isRecurringInd = value;
    }

    public Long getIsUsageBasedInd() {
        return isUsageBasedInd;
    }

    public void setIsUsageBasedInd(Long value) {
        this.isUsageBasedInd = value;
    }

    public Long getUsageType() {
        return usageType;
    }

    public void setUsageType(Long value) {
        this.usageType = value;
    }

    public Long getTaxableInd() {
        return taxableInd;
    }

    public void setTaxableInd(Long value) {
        this.taxableInd = value;
    }

    public Long getIsTaxInd() {
        return isTaxInd;
    }

    public void setIsTaxInd(Long value) {
        this.isTaxInd = value;
    }

    public Long getIsArrearsInd() {
        return isArrearsInd;
    }

    public void setIsArrearsInd(Long value) {
        this.isArrearsInd = value;
    }

    public Long getIsSetupInd() {
        return isSetupInd;
    }

    public void setIsSetupInd(Long value) {
        this.isSetupInd = value;
    }

    public Long getIsMiscInd() {
        return isMiscInd;
    }

    public void setIsMiscInd(Long value) {
        this.isMiscInd = value;
    }

    public Long getIsDonationInd() {
        return isDonationInd;
    }

    public void setIsDonationInd(Long value) {
        this.isDonationInd = value;
    }

    public Long getIsOrderBasedInd() {
        return isOrderBasedInd;
    }

    public void setIsOrderBasedInd(Long value) {
        this.isOrderBasedInd = value;
    }

    public Long getIsCancellationInd() {
        return isCancellationInd;
    }

    public void setIsCancellationInd(Long value) {
        this.isCancellationInd = value;
    }

    public String getCoaId() {
        return coaId;
    }

    public void setCoaId(String value) {
        this.coaId = value;
    }

    public String getLedgerCode() {
        return ledgerCode;
    }

    public void setLedgerCode(String value) {
        this.ledgerCode = value;
    }

    public String getClientCoaCode() {
        return clientCoaCode;
    }

    public void setClientCoaCode(String value) {
        this.clientCoaCode = value;
    }

    public Long getDisplayInd() {
        return displayInd;
    }

    public void setDisplayInd(Long value) {
        this.displayInd = value;
    }

    public Long getTieredPricingRule() {
        return tieredPricingRule;
    }

    public void setTieredPricingRule(Long value) {
        this.tieredPricingRule = value;
    }

    public Long getIsMinFeeInd() {
        return isMinFeeInd;
    }

    public void setIsMinFeeInd(Long value) {
        this.isMinFeeInd = value;
    }

    public String getClientServiceId() {
        return clientServiceId;
    }

    public void setClientServiceId(String value) {
        this.clientServiceId = value;
    }

    public String getUsageTypeCd() {
        return usageTypeCd;
    }

    public void setUsageTypeCd(String value) {
        this.usageTypeCd = value;
    }

    public List<AllServiceSuppFieldsReturnElement> getAllServiceSuppFields() {
        if (this.allServiceSuppFields == null) {
            this.allServiceSuppFields = new ArrayList<AllServiceSuppFieldsReturnElement>();
        }
        return this.allServiceSuppFields;
    }public Long getFulfillmentBasedInd() {
        return fulfillmentBasedInd;
    }

    public void setFulfillmentBasedInd(Long value) {
        this.fulfillmentBasedInd = value;
    }

    public List<PlanServiceRatesReturnElement> getPlanServiceRates() {
        if (this.planServiceRates == null) {
            this.planServiceRates = new ArrayList<PlanServiceRatesReturnElement>();
        }
        return this.planServiceRates;
    }public List<AllPlanServiceRatesReturnElement> getAllPlanServiceRates() {
        if (this.allPlanServiceRates == null) {
            this.allPlanServiceRates = new ArrayList<AllPlanServiceRatesReturnElement>();
        }
        return this.allPlanServiceRates;
    }public String getUsageTypeName() {
        return usageTypeName;
    }

    public void setUsageTypeName(String value) {
        this.usageTypeName = value;
    }

    public String getUsageTypeDesc() {
        return usageTypeDesc;
    }

    public void setUsageTypeDesc(String value) {
        this.usageTypeDesc = value;
    }

    public String getUsageTypeCode() {
        return usageTypeCode;
    }

    public void setUsageTypeCode(String value) {
        this.usageTypeCode = value;
    }

    public String getUsageUnitLabel() {
        return usageUnitLabel;
    }

    public void setUsageUnitLabel(String value) {
        this.usageUnitLabel = value;
    }

    public Long getApplyUsageRatesDaily() {
        return applyUsageRatesDaily;
    }

    public void setApplyUsageRatesDaily(Long value) {
        this.applyUsageRatesDaily = value;
    }

    
}
