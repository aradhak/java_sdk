package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plan_rate_schedules_ReturnElement", propOrder = {"scheduleNo", "scheduleName", "scheduleCurrency", "scheduleDefaultInd", "scheduleDefaultIndCurr", "scheduleDisplayInd"})
public class PlanRateSchedulesReturnElement {

    @XmlElement(name = "schedule_no")
    protected Long scheduleNo;
    @XmlElement(name = "schedule_name")
    protected String scheduleName;
    @XmlElement(name = "schedule_currency")
    protected String scheduleCurrency;
    @XmlElement(name = "schedule_default_ind")
    protected Long scheduleDefaultInd;
    @XmlElement(name = "schedule_default_ind_curr")
    protected Long scheduleDefaultIndCurr;
    @XmlElement(name = "schedule_display_ind")
    protected Long scheduleDisplayInd;
    
    public Long getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(Long value) {
        this.scheduleNo = value;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String value) {
        this.scheduleName = value;
    }

    public String getScheduleCurrency() {
        return scheduleCurrency;
    }

    public void setScheduleCurrency(String value) {
        this.scheduleCurrency = value;
    }

    public Long getScheduleDefaultInd() {
        return scheduleDefaultInd;
    }

    public void setScheduleDefaultInd(Long value) {
        this.scheduleDefaultInd = value;
    }

    public Long getScheduleDefaultIndCurr() {
        return scheduleDefaultIndCurr;
    }

    public void setScheduleDefaultIndCurr(Long value) {
        this.scheduleDefaultIndCurr = value;
    }

    public Long getScheduleDisplayInd() {
        return scheduleDisplayInd;
    }

    public void setScheduleDisplayInd(Long value) {
        this.scheduleDisplayInd = value;
    }

    
}
