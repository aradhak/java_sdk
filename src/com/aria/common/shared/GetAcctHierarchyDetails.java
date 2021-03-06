package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "acctNo",    "hierarchyFilter",    "includeCurrentAcct"})
@XmlRootElement(name = "get_acct_hierarchy_details")
public class GetAcctHierarchyDetails {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "acct_no")
    protected Long acctNo;
        @XmlElement(name = "hierarchy_filter")
    protected Long hierarchyFilter;
        @XmlElement(name = "include_current_acct")
    protected Long includeCurrentAcct;
    
    public long getClientNo() {
        return clientNo;
    }

    public void setClientNo(Long value) {
        this.clientNo = value;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String value) {
        this.authKey = value;
    }

    public Long getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(Long value) {
        this.acctNo = value;
    }
            public Long getHierarchyFilter() {
        return hierarchyFilter;
    }

    public void setHierarchyFilter(Long value) {
        this.hierarchyFilter = value;
    }
            public Long getIncludeCurrentAcct() {
        return includeCurrentAcct;
    }

    public void setIncludeCurrentAcct(Long value) {
        this.includeCurrentAcct = value;
    }
            
}
