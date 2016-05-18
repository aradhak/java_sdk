package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supp_obj_field_translations_ReturnElement", propOrder = {"localeName", "localeNo", "fieldNo", "fieldName", "description", "allowedValuesT"})
public class SuppObjFieldTranslationsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "field_no")
    protected Long fieldNo;
    @XmlElement(name = "field_name")
    protected String fieldName;
    @XmlElement(name = "description")
    protected String description;
    @XmlElement(name = "allowed_values_t")
    protected List<AllowedValuesTReturnElement> allowedValuesT;
    
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

    public Long getFieldNo() {
        return fieldNo;
    }

    public void setFieldNo(Long value) {
        this.fieldNo = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String value) {
        this.fieldName = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public List<AllowedValuesTReturnElement> getAllowedValuesT() {
        if (this.allowedValuesT == null) {
            this.allowedValuesT = new ArrayList<AllowedValuesTReturnElement>();
        }
        return this.allowedValuesT;
    }
}
