package com.aria.common.shared.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "schedule_row", propOrder = {
    "scheduleName",
    "currencyCd",
    "clientRateScheduleId",
    "isDefault",
    "taxInclusiveRate",
    "tier",
    "scheduleNo",
    "availableFromDt",
    "availableToDt",
    "futureRate",
    "futureChangeDt",
    "followupRsNo",
    "clientFollowupRsId",
    "amount",
    "from",
    "to",
    "description",
    "futureAmount",
    "minSurchargeToApply"
    })
public class ScheduleRow {

    @XmlElement(name = "schedule_name")
    protected String scheduleName;
    @XmlElement(name = "currency_cd")
    protected String currencyCd;
    @XmlElement(name = "client_rate_schedule_id")
    protected String clientRateScheduleId;
    @XmlElement(name = "is_default")
    protected Long isDefault;
    @XmlElement(name = "tax_inclusive_rate")
    protected Long taxInclusiveRate;
    @XmlElement(name = "tier")
    protected com.aria.common.shared.admin.TierArray tier;
    @XmlElement(name = "schedule_no")
    protected String scheduleNo;
    @XmlElement(name = "available_from_dt")
    protected String availableFromDt;
    @XmlElement(name = "available_to_dt")
    protected String availableToDt;
    @XmlElement(name = "future_rate")
    protected Long futureRate;
    @XmlElement(name = "future_change_dt")
    protected String futureChangeDt;
    @XmlElement(name = "followup_rs_no")
    protected Long followupRsNo;
    @XmlElement(name = "client_followup_rs_id")
    protected String clientFollowupRsId;
    @XmlElement(name = "amount")
    protected Double amount;
    @XmlElement(name = "from")
    protected Long from;
    @XmlElement(name = "to")
    protected Long to;
    @XmlElement(name = "description")
    protected String description;
    @XmlElement(name = "future_amount")
    protected Double futureAmount;
    @XmlElement(name = "min_surcharge_to_apply")
    protected Double minSurchargeToApply;
    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String value) {
        this.scheduleName = value;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String value) {
        this.currencyCd = value;
    }

    public String getClientRateScheduleId() {
        return clientRateScheduleId;
    }

    public void setClientRateScheduleId(String value) {
        this.clientRateScheduleId = value;
    }

    public Long getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Long value) {
        this.isDefault = value;
    }

    public Long getTaxInclusiveRate() {
        return taxInclusiveRate;
    }

    public void setTaxInclusiveRate(Long value) {
        this.taxInclusiveRate = value;
    }

    public com.aria.common.shared.admin.TierArray getTier() {
        return tier;
    }

    public void setTier(com.aria.common.shared.admin.TierArray value) {
        this.tier = value;
    }

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String value) {
        this.scheduleNo = value;
    }

    public String getAvailableFromDt() {
        return availableFromDt;
    }

    public void setAvailableFromDt(String value) {
        this.availableFromDt = value;
    }

    public String getAvailableToDt() {
        return availableToDt;
    }

    public void setAvailableToDt(String value) {
        this.availableToDt = value;
    }

    public Long getFutureRate() {
        return futureRate;
    }

    public void setFutureRate(Long value) {
        this.futureRate = value;
    }

    public String getFutureChangeDt() {
        return futureChangeDt;
    }

    public void setFutureChangeDt(String value) {
        this.futureChangeDt = value;
    }

    public Long getFollowupRsNo() {
        return followupRsNo;
    }

    public void setFollowupRsNo(Long value) {
        this.followupRsNo = value;
    }

    public String getClientFollowupRsId() {
        return clientFollowupRsId;
    }

    public void setClientFollowupRsId(String value) {
        this.clientFollowupRsId = value;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double value) {
        this.amount = value;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long value) {
        this.from = value;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long value) {
        this.to = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Double getFutureAmount() {
        return futureAmount;
    }

    public void setFutureAmount(Double value) {
        this.futureAmount = value;
    }

    public Double getMinSurchargeToApply() {
        return minSurchargeToApply;
    }

    public void setMinSurchargeToApply(Double value) {
        this.minSurchargeToApply = value;
    }

    
}
