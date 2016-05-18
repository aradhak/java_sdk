package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "service_translation_details_ReturnElement", propOrder = {"localeName", "localeNo", "serviceNo", "serviceName", "rateSchedulesT"})
public class ServiceTranslationDetailsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "service_no")
    protected String serviceNo;
    @XmlElement(name = "service_name")
    protected String serviceName;
    @XmlElement(name = "rate_schedules_t")
    protected List<RateSchedulesTReturnElement> rateSchedulesT;
    
    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String value) {
        this.localeName = value;
    }

    public Long getLocaleNo() {
        return localeNo;
    }

    public void setLocaleNo(Long value) {
        this.localeNo = value;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String value) {
        this.serviceNo = value;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String value) {
        this.serviceName = value;
    }

    public List<RateSchedulesTReturnElement> getRateSchedulesT() {
        if (this.rateSchedulesT == null) {
            this.rateSchedulesT = new ArrayList<RateSchedulesTReturnElement>();
        }
        return this.rateSchedulesT;
    }
}
