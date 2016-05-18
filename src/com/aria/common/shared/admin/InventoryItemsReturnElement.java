package com.aria.common.shared.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inventory_items_ReturnElement", propOrder = {"itemNo", "itemName", "itemType", "clientSku", "activeInd", "stockLevel", "clientItemId"})
public class InventoryItemsReturnElement {

    @XmlElement(name = "item_no")
    protected Long itemNo;
    @XmlElement(name = "item_name")
    protected String itemName;
    @XmlElement(name = "item_type")
    protected Long itemType;
    @XmlElement(name = "client_sku")
    protected String clientSku;
    @XmlElement(name = "active_ind")
    protected Long activeInd;
    @XmlElement(name = "stock_level")
    protected Double stockLevel;
    @XmlElement(name = "client_item_id")
    protected String clientItemId;
    
    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long value) {
        this.itemNo = value;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String value) {
        this.itemName = value;
    }

    public Long getItemType() {
        return itemType;
    }

    public void setItemType(Long value) {
        this.itemType = value;
    }

    public String getClientSku() {
        return clientSku;
    }

    public void setClientSku(String value) {
        this.clientSku = value;
    }

    public Long getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Long value) {
        this.activeInd = value;
    }

    public Double getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Double value) {
        this.stockLevel = value;
    }

    public String getClientItemId() {
        return clientItemId;
    }

    public void setClientItemId(String value) {
        this.clientItemId = value;
    }

    
}
