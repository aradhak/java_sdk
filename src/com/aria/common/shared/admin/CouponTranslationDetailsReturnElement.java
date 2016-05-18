package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coupon_translation_details_ReturnElement", propOrder = {"localeName", "localeNo", "couponDesc", "couponMsg", "discountRuleT"})
public class CouponTranslationDetailsReturnElement {

    @XmlElement(name = "locale_name")
    protected String localeName;
    @XmlElement(name = "locale_no")
    protected Long localeNo;
    @XmlElement(name = "coupon_desc")
    protected String couponDesc;
    @XmlElement(name = "coupon_msg")
    protected String couponMsg;
    @XmlElement(name = "discount_rule_t")
    protected List<DiscountRuleTReturnElement> discountRuleT;
    
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

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String value) {
        this.couponDesc = value;
    }

    public String getCouponMsg() {
        return couponMsg;
    }

    public void setCouponMsg(String value) {
        this.couponMsg = value;
    }

    public List<DiscountRuleTReturnElement> getDiscountRuleT() {
        if (this.discountRuleT == null) {
            this.discountRuleT = new ArrayList<DiscountRuleTReturnElement>();
        }
        return this.discountRuleT;
    }
}
