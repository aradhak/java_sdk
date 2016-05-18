package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plan_group_translation_info_ReturnElement", propOrder = {"localeName", "localeNo", "plansT"})
public class PlanGroupTranslationInfoReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "plans_t")
    protected List<PlansTReturnElement> plansT;
    
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

    public List<PlansTReturnElement> getPlansT() {
        if (this.plansT == null) {
            this.plansT = new ArrayList<PlansTReturnElement>();
        }
        return this.plansT;
    }
}
