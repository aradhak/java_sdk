package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coupons_ReturnElement", propOrder = {"couponCd", "couponDesc", "expiresAfter", "couponScope", "couponTranslations", "couponNo", "couponMsg", "statusInd", "noOfUses", "startDate", "endDate"})
public class CouponsReturnElement {

    @XmlElement(name = "coupon_cd")
    protected String couponCd;
    @XmlElement(name = "coupon_desc")
    protected String couponDesc;
    @XmlElement(name = "expires_after")
    protected String expiresAfter;
    @XmlElement(name = "coupon_scope")
    protected Long couponScope;
    @XmlElement(name = "coupon_translations")
    protected List<CouponTranslationsReturnElement> couponTranslations;
    @XmlElement(name = "coupon_no")
    protected String couponNo;
    @XmlElement(name = "coupon_msg")
    protected String couponMsg;
    @XmlElement(name = "status_ind")
    protected Long statusInd;
    @XmlElement(name = "no_of_uses")
    protected Long noOfUses;
    @XmlElement(name = "start_date")
    protected String startDate;
    @XmlElement(name = "end_date")
    protected String endDate;
    
    public String getCouponCd() {
        return couponCd;
    }

    public void setCouponCd(String value) {
        this.couponCd = value;
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String value) {
        this.couponDesc = value;
    }

    public String getExpiresAfter() {
        return expiresAfter;
    }

    public void setExpiresAfter(String value) {
        this.expiresAfter = value;
    }

    public Long getCouponScope() {
        return couponScope;
    }

    public void setCouponScope(Long value) {
        this.couponScope = value;
    }

    public List<CouponTranslationsReturnElement> getCouponTranslations() {
        if (this.couponTranslations == null) {
            this.couponTranslations = new ArrayList<CouponTranslationsReturnElement>();
        }
        return this.couponTranslations;
    }public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String value) {
        this.couponNo = value;
    }

    public String getCouponMsg() {
        return couponMsg;
    }

    public void setCouponMsg(String value) {
        this.couponMsg = value;
    }

    public Long getStatusInd() {
        return statusInd;
    }

    public void setStatusInd(Long value) {
        this.statusInd = value;
    }

    public Long getNoOfUses() {
        return noOfUses;
    }

    public void setNoOfUses(Long value) {
        this.noOfUses = value;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String value) {
        this.startDate = value;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String value) {
        this.endDate = value;
    }

    
}
