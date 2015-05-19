package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usage_unit_types_ReturnElement", propOrder = {"usageUnitTypeNo", "usageUnitTypeDesc", "clientUsageUnitTypeId"})
public class UsageUnitTypesReturnElement {

    @XmlElement(name = "usage_unit_type_no")
    protected Long usageUnitTypeNo;
    @XmlElement(name = "usage_unit_type_desc")
    protected String usageUnitTypeDesc;
    @XmlElement(name = "client_usage_unit_type_id")
    protected String clientUsageUnitTypeId;
    
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

    public String getClientUsageUnitTypeId() {
        return clientUsageUnitTypeId;
    }

    public void setClientUsageUnitTypeId(String value) {
        this.clientUsageUnitTypeId = value;
    }

    
}
