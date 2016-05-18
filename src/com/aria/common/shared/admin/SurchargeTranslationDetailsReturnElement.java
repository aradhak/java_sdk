package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "surcharge_translation_details_ReturnElement", propOrder = {"localeName", "localeNo", "surchargeNo", "surchargeName", "description", "extDescription", "surchargeTierT"})
public class SurchargeTranslationDetailsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "surcharge_no")
    protected Long surchargeNo;
    @XmlElement(name = "surcharge_name")
    protected String surchargeName;
    @XmlElement(name = "description")
    protected String description;
    @XmlElement(name = "ext_description")
    protected String extDescription;
    @XmlElement(name = "surcharge_tier_t")
    protected List<SurchargeTierTReturnElement> surchargeTierT;
    
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

    public Long getSurchargeNo() {
        return surchargeNo;
    }

    public void setSurchargeNo(Long value) {
        this.surchargeNo = value;
    }

    public String getSurchargeName() {
        return surchargeName;
    }

    public void setSurchargeName(String value) {
        this.surchargeName = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getExtDescription() {
        return extDescription;
    }

    public void setExtDescription(String value) {
        this.extDescription = value;
    }

    public List<SurchargeTierTReturnElement> getSurchargeTierT() {
        if (this.surchargeTierT == null) {
            this.surchargeTierT = new ArrayList<SurchargeTierTReturnElement>();
        }
        return this.surchargeTierT;
    }
}
