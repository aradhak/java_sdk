package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usage_unit_type_translations_ReturnElement", propOrder = {"localeName", "localeNo", "usageUnitTypeNo", "usageUnitTypeDesc"})
public class UsageUnitTypeTranslationsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "usage_unit_type_no")
    protected Long usageUnitTypeNo;
    @XmlElement(name = "usage_unit_type_desc")
    protected String usageUnitTypeDesc;
    
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

    public Long getUsageUnitTypeNo() {
        return usageUnitTypeNo;
    }

    public void setUsageUnitTypeNo(Long value) {
        this.usageUnitTypeNo = value;
    }

    public String getUsageUnitTypeDesc() {
        return usageUnitTypeDesc;
    }

    public void setUsageUnitTypeDesc(String value) {
        this.usageUnitTypeDesc = value;
    }

    
}
