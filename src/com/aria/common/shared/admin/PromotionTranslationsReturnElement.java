package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotion_translations_ReturnElement", propOrder = {"localeName", "localeNo", "promoCd", "promoDesc"})
public class PromotionTranslationsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "promo_cd")
    protected String promoCd;
    @XmlElement(name = "promo_desc")
    protected String promoDesc;
    
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

    public String getPromoCd() {
        return promoCd;
    }

    public void setPromoCd(String value) {
        this.promoCd = value;
    }

    public String getPromoDesc() {
        return promoDesc;
    }

    public void setPromoDesc(String value) {
        this.promoDesc = value;
    }

    
}
