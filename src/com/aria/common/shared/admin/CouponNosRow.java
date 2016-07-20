package com.aria.common.shared.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coupon_nos_row", propOrder = {
    "couponNo"
    })
public class CouponNosRow {

    @XmlElement(name = "coupon_no")
    protected String couponNo;
    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String value) {
        this.couponNo = value;
    }

    
}
