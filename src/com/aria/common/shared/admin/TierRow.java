package com.aria.common.shared.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tier_row", propOrder = {
    "from",
    "to",
    "description",
    "amount",
    "schedule"
    })
public class TierRow {

    @XmlElement(name = "from")
    protected Long from;
    @XmlElement(name = "to")
    protected Long to;
    @XmlElement(name = "description")
    protected String description;
    @XmlElement(name = "amount")
    protected Double amount;
    @XmlElement(name = "schedule")
    protected com.aria.common.shared.admin.ScheduleArray schedule;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double value) {
        this.amount = value;
    }

    public com.aria.common.shared.admin.ScheduleArray getSchedule() {
        return schedule;
    }

    public void setSchedule(com.aria.common.shared.admin.ScheduleArray value) {
        this.schedule = value;
    }

    
}
