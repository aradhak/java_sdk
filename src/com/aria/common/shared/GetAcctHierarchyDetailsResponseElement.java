package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"errorCode", "errorMsg", "acctHierarchyDetails"})
@XmlRootElement(name = "get_acct_hierarchy_detailsResponseElement")
public class GetAcctHierarchyDetailsResponseElement {

    @XmlElement(name = "error_code")
    protected Long errorCode;
    @XmlElement(name = "error_msg")
    protected String errorMsg;
    @XmlElement(name = "acct_hierarchy_details")
    protected List<AcctHierarchyDetailsReturnElement> acctHierarchyDetails;
    
    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long value) {
        this.errorCode = value;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

    public List<AcctHierarchyDetailsReturnElement> getAcctHierarchyDetails() {
        if (this.acctHierarchyDetails == null) {
            this.acctHierarchyDetails = new ArrayList<AcctHierarchyDetailsReturnElement>();
        }
        return this.acctHierarchyDetails;
    }
}
