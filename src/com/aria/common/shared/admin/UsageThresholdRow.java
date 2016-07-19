package com.aria.common.shared.admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usage_threshold_row", propOrder = {
    "noticeDestType",
    "noticeBalanceType",
    "notifications"
    })
public class UsageThresholdRow {

    @XmlElement(name = "notice_dest_type")
    protected String noticeDestType;
    @XmlElement(name = "notice_balance_type")
    protected String noticeBalanceType;
    @XmlElement(name = "notifications")
    protected com.aria.common.shared.admin.NotificationsArray notifications;
    public String getNoticeDestType() {
        return noticeDestType;
    }

    public void setNoticeDestType(String value) {
        this.noticeDestType = value;
    }

    public String getNoticeBalanceType() {
        return noticeBalanceType;
    }

    public void setNoticeBalanceType(String value) {
        this.noticeBalanceType = value;
    }

    public com.aria.common.shared.admin.NotificationsArray getNotifications() {
        return notifications;
    }

    public void setNotifications(com.aria.common.shared.admin.NotificationsArray value) {
        this.notifications = value;
    }

    
}
