package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usage_type_translations_ReturnElement", propOrder = {"localeName", "localeNo", "usageTypeNo", "usageTypeName", "usageTypeDesc"})
public class UsageTypeTranslationsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "usage_type_no")
    protected Long usageTypeNo;
    @XmlElement(name = "usage_type_name")
    protected String usageTypeName;
    @XmlElement(name = "usage_type_desc")
    protected String usageTypeDesc;
    
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

    public Long getUsageTypeNo() {
        return usageTypeNo;
    }

    public void setUsageTypeNo(Long value) {
        this.usageTypeNo = value;
    }

    public String getUsageTypeName() {
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

    
}
