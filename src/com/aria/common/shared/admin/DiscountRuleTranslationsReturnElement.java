package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discount_rule_translations_ReturnElement", propOrder = {"localeName", "localeNo", "ruleNo", "description", "extDescription", "ruleName"})
public class DiscountRuleTranslationsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "rule_no")
    protected Long ruleNo;
    @XmlElement(name = "description")
    protected String description;
    @XmlElement(name = "ext_description")
    protected String extDescription;
    @XmlElement(name = "rule_name")
    protected String ruleName;
    
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

    public Long getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(Long value) {
        this.ruleNo = value;
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

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String value) {
        this.ruleName = value;
    }

    
}
