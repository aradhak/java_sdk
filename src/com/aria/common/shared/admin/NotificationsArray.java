package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifications_array", propOrder = {
    "notificationsRow"
})
public class NotificationsArray {

    @XmlElement(name = "notifications_row")
    protected List<NotificationsRow> notificationsRow;

    public List<NotificationsRow> getNotificationsRow() {
        if (this.notificationsRow == null) {
            this.notificationsRow = new ArrayList<NotificationsRow>();
        }
        return this.notificationsRow;
    }

}
