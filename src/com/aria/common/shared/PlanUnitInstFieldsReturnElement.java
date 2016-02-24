package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plan_unit_inst_fields_ReturnElement", propOrder = {"fieldName", "fieldValue", "planUnitInstDirective"})
public class PlanUnitInstFieldsReturnElement {

    @XmlElement(name = "field_name")
    protected String fieldName;
    @XmlElement(name = "field_value")
    protected String fieldValue;
    @XmlElement(name = "plan_unit_inst_directive")
    protected Long planUnitInstDirective;
    
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String value) {
        this.fieldName = value;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String value) {
        this.fieldValue = value;
    }

    public Long getPlanUnitInstDirective() {
        return planUnitInstDirective;
    }

    public void setPlanUnitInstDirective(Long value) {
        this.planUnitInstDirective = value;
    }

    
}
