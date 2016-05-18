package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plans_ReturnElement", propOrder = {"planNo", "clientPlanId", "planName", "planLevel", "billingInterval", "activeInd", "description", "isDeletable", "planDesc"})
public class PlansReturnElement {

    @XmlElement(name = "plan_no")
    protected Long planNo;
    @XmlElement(name = "client_plan_id")
    protected String clientPlanId;
    @XmlElement(name = "plan_name")
    protected String planName;
    @XmlElement(name = "plan_level")
    protected Long planLevel;
    @XmlElement(name = "billing_interval")
    protected Long billingInterval;
    @XmlElement(name = "active_ind")
    protected Long activeInd;
    @XmlElement(name = "description")
    protected String description;
    @XmlElement(name = "is_deletable")
    protected String isDeletable;
    @XmlElement(name = "plan_desc")
    protected String planDesc;
    
    public Long getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Long value) {
        this.planNo = value;
    }

    public String getClientPlanId() {
        return clientPlanId;
    }

    public void setClientPlanId(String value) {
        this.clientPlanId = value;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String value) {
        this.planName = value;
    }

    public Long getPlanLevel() {
        return planLevel;
    }

    public void setPlanLevel(Long value) {
        this.planLevel = value;
    }

    public Long getBillingInterval() {
        return billingInterval;
    }

    public void setBillingInterval(Long value) {
        this.billingInterval = value;
    }

    public Long getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Long value) {
        this.activeInd = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getIsDeletable() {
        return isDeletable;
    }

    public void setIsDeletable(String value) {
        this.isDeletable = value;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String value) {
        this.planDesc = value;
    }

    
}
