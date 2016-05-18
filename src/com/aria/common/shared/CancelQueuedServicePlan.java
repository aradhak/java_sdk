package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "accountNumber",    "planNoToRemove",    "removeAllQueuedPlanNo",    "removeTerminatePending",    "reactivateTerminatePending"})
@XmlRootElement(name = "cancel_queued_service_plan")
public class CancelQueuedServicePlan {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "account_number")
    protected Long accountNumber;
        @XmlElement(name = "plan_no_to_remove")
    protected PlanNoToRemoveArray planNoToRemove;
        @XmlElement(name = "remove_all_queued_plan_no")
    protected String removeAllQueuedPlanNo;
        @XmlElement(name = "remove_terminate_pending")
    protected String removeTerminatePending;
        @XmlElement(name = "reactivate_terminate_pending")
    protected String reactivateTerminatePending;
    
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long value) {
        this.accountNumber = value;
    }
            public PlanNoToRemoveArray getPlanNoToRemove() {
        return planNoToRemove;
    }

    public void setPlanNoToRemove(PlanNoToRemoveArray value) {
        this.planNoToRemove = value;
    }
            public String getRemoveAllQueuedPlanNo() {
        return removeAllQueuedPlanNo;
    }

    public void setRemoveAllQueuedPlanNo(String value) {
        this.removeAllQueuedPlanNo = value;
    }
            public String getRemoveTerminatePending() {
        return removeTerminatePending;
    }

    public void setRemoveTerminatePending(String value) {
        this.removeTerminatePending = value;
    }
            public String getReactivateTerminatePending() {
        return reactivateTerminatePending;
    }

    public void setReactivateTerminatePending(String value) {
        this.reactivateTerminatePending = value;
    }
            
}
