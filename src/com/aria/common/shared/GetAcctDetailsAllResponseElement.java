package com.aria.common.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"firstName", "mi", "lastName", "userid", "birthdate", "jobTitle", "salutation", "seniorAcctNo", "clientAcctId", "respLevelCd", "isTestAcct", "altEmail", "address1", "address2", "city", "stateProv", "locality", "postalCode", "country", "companyName", "cellPhoneNpa", "cellPhoneNxx", "cellPhoneSuffix", "faxPhone", "intlCellPhone", "intlPhone", "phoneExtension", "phoneNpa", "phoneNxx", "phoneSuffix", "workPhone", "workPhoneExtension", "workPhoneNpa", "workPhoneNxx", "workPhoneSuffix", "billDay", "created", "dateToExpire", "dateToSuspend", "lastArrearsBillThruDate", "lastBillDate", "lastBillThruDate", "nextBillDate", "planDate", "statusDate", "statusDegradeDate", "statusCd", "statusLabel", "planNo", "planName", "planUnits", "notifyMethod", "notifyMethodName", "password", "pin", "secretQuestion", "secretQuestionAnswer", "payMethod", "payMethodName", "currencyCd", "taxId", "billingEmail", "billingFirstName", "billingMiddleInitial", "billingLastName", "billingAddress1", "billingAddress2", "billingCity", "billingState", "billingLocality", "billingZip", "billingCountry", "ccSuffix", "ccExpireMm", "ccExpireYyyy", "ccId", "bankAcctSuffix", "bankRoutingNo", "billingCellPhone", "billingCellPhoneNpa", "billingCellPhoneNxx", "billingCellPhoneSuffix", "billingCompanyName", "billingIntlPhone", "billingPhoneExtension", "billingPhoneNpa", "billingPhoneNxx", "billingPhoneSuffix", "billingWorkPhone", "billingWorkPhoneExtension", "billingWorkPhoneNpa", "billingWorkPhoneNxx", "billingWorkPhoneSuffix", "balance", "acctCreateClientReceiptId", "planClientReceiptId", "statusClientReceiptId", "taxpayerId", "altMsgTemplateNo", "seqFuncGroupNo", "promoCd", "address3", "billingAddress3", "addressVerificationCode", "addressMatchScore", "billingAddressVerificationCode", "billingAddressMatchScore", "clientPlanId", "clientAltMsgTemplateId", "bkupPayMethod", "bkupBillingEmail", "bkupBillingFirstName", "bkupBillingMiddleInitial", "bkupBillingLastName", "bkupBillingAddress1", "bkupBillingAddress2", "bkupBillingCity", "bkupBillingState", "bkupBillingLocality", "bkupBillingZip", "bkupBillingCountry", "bkupCcSuffix", "bkupCcExpireMm", "bkupCcExpireYyyy", "bkupCcId", "bkupBankAcctSuffix", "bkupBankRoutingNo", "bkupBillingCellPhone", "bkupBillingCellPhoneNpa", "bkupBillingCellPhoneNxx", "bkupBillingCellPhoneSuffix", "bkupBillingCompanyName", "bkupBillingIntlPhone", "bkupBillingPhoneExtension", "bkupBillingWorkPhone", "bkupBillingWorkPhoneExtension", "bkupBillingWorkPhoneNpa", "bkupBillingWorkPhoneNxx", "bkupBillingWorkPhoneSuffix", "stmntEmailList", "invoiceApprovalRequired", "stmntEmailListCc", "stmntEmailListBcc", "invoicePostingMethodCd", "acctStartDate", "billAgreementId", "bkupBillAgreementId", "errorCode", "errorMsg"})
@XmlRootElement(name = "get_acct_details_allResponseElement")
public class GetAcctDetailsAllResponseElement {

    @XmlElement(name = "first_name")
    protected String firstName;
    @XmlElement(name = "mi")
    protected String mi;
    @XmlElement(name = "last_name")
    protected String lastName;
    @XmlElement(name = "userid")
    protected String userid;
    @XmlElement(name = "birthdate")
    protected String birthdate;
    @XmlElement(name = "job_title")
    protected String jobTitle;
    @XmlElement(name = "salutation")
    protected String salutation;
    @XmlElement(name = "senior_acct_no")
    protected String seniorAcctNo;
    @XmlElement(name = "client_acct_id")
    protected String clientAcctId;
    @XmlElement(name = "resp_level_cd")
    protected String respLevelCd;
    @XmlElement(name = "is_test_acct")
    protected String isTestAcct;
    @XmlElement(name = "alt_email")
    protected String altEmail;
    @XmlElement(name = "address1")
    protected String address1;
    @XmlElement(name = "address2")
    protected String address2;
    @XmlElement(name = "city")
    protected String city;
    @XmlElement(name = "state_prov")
    protected String stateProv;
    @XmlElement(name = "locality")
    protected String locality;
    @XmlElement(name = "postal_code")
    protected String postalCode;
    @XmlElement(name = "country")
    protected String country;
    @XmlElement(name = "company_name")
    protected String companyName;
    @XmlElement(name = "cell_phone_npa")
    protected String cellPhoneNpa;
    @XmlElement(name = "cell_phone_nxx")
    protected String cellPhoneNxx;
    @XmlElement(name = "cell_phone_suffix")
    protected String cellPhoneSuffix;
    @XmlElement(name = "fax_phone")
    protected String faxPhone;
    @XmlElement(name = "intl_cell_phone")
    protected String intlCellPhone;
    @XmlElement(name = "intl_phone")
    protected String intlPhone;
    @XmlElement(name = "phone_extension")
    protected String phoneExtension;
    @XmlElement(name = "phone_npa")
    protected String phoneNpa;
    @XmlElement(name = "phone_nxx")
    protected String phoneNxx;
    @XmlElement(name = "phone_suffix")
    protected String phoneSuffix;
    @XmlElement(name = "work_phone")
    protected String workPhone;
    @XmlElement(name = "work_phone_extension")
    protected String workPhoneExtension;
    @XmlElement(name = "work_phone_npa")
    protected String workPhoneNpa;
    @XmlElement(name = "work_phone_nxx")
    protected String workPhoneNxx;
    @XmlElement(name = "work_phone_suffix")
    protected String workPhoneSuffix;
    @XmlElement(name = "bill_day")
    protected String billDay;
    @XmlElement(name = "created")
    protected String created;
    @XmlElement(name = "date_to_expire")
    protected String dateToExpire;
    @XmlElement(name = "date_to_suspend")
    protected String dateToSuspend;
    @XmlElement(name = "last_arrears_bill_thru_date")
    protected String lastArrearsBillThruDate;
    @XmlElement(name = "last_bill_date")
    protected String lastBillDate;
    @XmlElement(name = "last_bill_thru_date")
    protected String lastBillThruDate;
    @XmlElement(name = "next_bill_date")
    protected String nextBillDate;
    @XmlElement(name = "plan_date")
    protected String planDate;
    @XmlElement(name = "status_date")
    protected String statusDate;
    @XmlElement(name = "status_degrade_date")
    protected String statusDegradeDate;
    @XmlElement(name = "status_cd")
    protected String statusCd;
    @XmlElement(name = "status_label")
    protected String statusLabel;
    @XmlElement(name = "plan_no")
    protected String planNo;
    @XmlElement(name = "plan_name")
    protected String planName;
    @XmlElement(name = "plan_units")
    protected String planUnits;
    @XmlElement(name = "notify_method")
    protected String notifyMethod;
    @XmlElement(name = "notify_method_name")
    protected String notifyMethodName;
    @XmlElement(name = "PASSWORD")
    protected String password;
    @XmlElement(name = "pin")
    protected String pin;
    @XmlElement(name = "secret_question")
    protected String secretQuestion;
    @XmlElement(name = "secret_question_answer")
    protected String secretQuestionAnswer;
    @XmlElement(name = "pay_method")
    protected String payMethod;
    @XmlElement(name = "pay_method_name")
    protected String payMethodName;
    @XmlElement(name = "currency_cd")
    protected String currencyCd;
    @XmlElement(name = "tax_id")
    protected String taxId;
    @XmlElement(name = "billing_email")
    protected String billingEmail;
    @XmlElement(name = "billing_first_name")
    protected String billingFirstName;
    @XmlElement(name = "billing_middle_initial")
    protected String billingMiddleInitial;
    @XmlElement(name = "billing_last_name")
    protected String billingLastName;
    @XmlElement(name = "billing_address1")
    protected String billingAddress1;
    @XmlElement(name = "billing_address2")
    protected String billingAddress2;
    @XmlElement(name = "billing_city")
    protected String billingCity;
    @XmlElement(name = "billing_state")
    protected String billingState;
    @XmlElement(name = "billing_locality")
    protected String billingLocality;
    @XmlElement(name = "billing_zip")
    protected String billingZip;
    @XmlElement(name = "billing_country")
    protected String billingCountry;
    @XmlElement(name = "cc_suffix")
    protected String ccSuffix;
    @XmlElement(name = "cc_expire_mm")
    protected String ccExpireMm;
    @XmlElement(name = "cc_expire_yyyy")
    protected String ccExpireYyyy;
    @XmlElement(name = "cc_id")
    protected Long ccId;
    @XmlElement(name = "bank_acct_suffix")
    protected String bankAcctSuffix;
    @XmlElement(name = "bank_routing_no")
    protected String bankRoutingNo;
    @XmlElement(name = "billing_cell_phone")
    protected String billingCellPhone;
    @XmlElement(name = "billing_cell_phone_npa")
    protected String billingCellPhoneNpa;
    @XmlElement(name = "billing_cell_phone_nxx")
    protected String billingCellPhoneNxx;
    @XmlElement(name = "billing_cell_phone_suffix")
    protected String billingCellPhoneSuffix;
    @XmlElement(name = "billing_company_name")
    protected String billingCompanyName;
    @XmlElement(name = "billing_intl_phone")
    protected String billingIntlPhone;
    @XmlElement(name = "billing_phone_extension")
    protected String billingPhoneExtension;
    @XmlElement(name = "billing_phone_npa")
    protected String billingPhoneNpa;
    @XmlElement(name = "billing_phone_nxx")
    protected String billingPhoneNxx;
    @XmlElement(name = "billing_phone_suffix")
    protected String billingPhoneSuffix;
    @XmlElement(name = "billing_work_phone")
    protected String billingWorkPhone;
    @XmlElement(name = "billing_work_phone_extension")
    protected String billingWorkPhoneExtension;
    @XmlElement(name = "billing_work_phone_npa")
    protected String billingWorkPhoneNpa;
    @XmlElement(name = "billing_work_phone_nxx")
    protected String billingWorkPhoneNxx;
    @XmlElement(name = "billing_work_phone_suffix")
    protected String billingWorkPhoneSuffix;
    @XmlElement(name = "balance")
    protected String balance;
    @XmlElement(name = "acct_create_client_receipt_id")
    protected String acctCreateClientReceiptId;
    @XmlElement(name = "plan_client_receipt_id")
    protected String planClientReceiptId;
    @XmlElement(name = "status_client_receipt_id")
    protected String statusClientReceiptId;
    @XmlElement(name = "taxpayer_id")
    protected String taxpayerId;
    @XmlElement(name = "alt_msg_template_no")
    protected Long altMsgTemplateNo;
    @XmlElement(name = "seq_func_group_no")
    protected Long seqFuncGroupNo;
    @XmlElement(name = "promo_cd")
    protected String promoCd;
    @XmlElement(name = "address3")
    protected String address3;
    @XmlElement(name = "billing_address3")
    protected String billingAddress3;
    @XmlElement(name = "address_verification_code")
    protected String addressVerificationCode;
    @XmlElement(name = "address_match_score")
    protected Double addressMatchScore;
    @XmlElement(name = "billing_address_verification_code")
    protected String billingAddressVerificationCode;
    @XmlElement(name = "billing_address_match_score")
    protected Double billingAddressMatchScore;
    @XmlElement(name = "client_plan_id")
    protected String clientPlanId;
    @XmlElement(name = "client_alt_msg_template_id")
    protected String clientAltMsgTemplateId;
    @XmlElement(name = "bkup_pay_method")
    protected String bkupPayMethod;
    @XmlElement(name = "bkup_billing_email")
    protected String bkupBillingEmail;
    @XmlElement(name = "bkup_billing_first_name")
    protected String bkupBillingFirstName;
    @XmlElement(name = "bkup_billing_middle_initial")
    protected String bkupBillingMiddleInitial;
    @XmlElement(name = "bkup_billing_last_name")
    protected String bkupBillingLastName;
    @XmlElement(name = "bkup_billing_address1")
    protected String bkupBillingAddress1;
    @XmlElement(name = "bkup_billing_address2")
    protected String bkupBillingAddress2;
    @XmlElement(name = "bkup_billing_city")
    protected String bkupBillingCity;
    @XmlElement(name = "bkup_billing_state")
    protected String bkupBillingState;
    @XmlElement(name = "bkup_billing_locality")
    protected String bkupBillingLocality;
    @XmlElement(name = "bkup_billing_zip")
    protected String bkupBillingZip;
    @XmlElement(name = "bkup_billing_country")
    protected String bkupBillingCountry;
    @XmlElement(name = "bkup_cc_suffix")
    protected String bkupCcSuffix;
    @XmlElement(name = "bkup_cc_expire_mm")
    protected String bkupCcExpireMm;
    @XmlElement(name = "bkup_cc_expire_yyyy")
    protected String bkupCcExpireYyyy;
    @XmlElement(name = "bkup_cc_id")
    protected Long bkupCcId;
    @XmlElement(name = "bkup_bank_acct_suffix")
    protected String bkupBankAcctSuffix;
    @XmlElement(name = "bkup_bank_routing_no")
    protected String bkupBankRoutingNo;
    @XmlElement(name = "bkup_billing_cell_phone")
    protected String bkupBillingCellPhone;
    @XmlElement(name = "bkup_billing_cell_phone_npa")
    protected String bkupBillingCellPhoneNpa;
    @XmlElement(name = "bkup_billing_cell_phone_nxx")
    protected String bkupBillingCellPhoneNxx;
    @XmlElement(name = "bkup_billing_cell_phone_suffix")
    protected String bkupBillingCellPhoneSuffix;
    @XmlElement(name = "bkup_billing_company_name")
    protected String bkupBillingCompanyName;
    @XmlElement(name = "bkup_billing_intl_phone")
    protected String bkupBillingIntlPhone;
    @XmlElement(name = "bkup_billing_phone_extension")
    protected String bkupBillingPhoneExtension;
    @XmlElement(name = "bkup_billing_work_phone")
    protected String bkupBillingWorkPhone;
    @XmlElement(name = "bkup_billing_work_phone_extension")
    protected String bkupBillingWorkPhoneExtension;
    @XmlElement(name = "bkup_billing_work_phone_npa")
    protected String bkupBillingWorkPhoneNpa;
    @XmlElement(name = "bkup_billing_work_phone_nxx")
    protected String bkupBillingWorkPhoneNxx;
    @XmlElement(name = "bkup_billing_work_phone_suffix")
    protected String bkupBillingWorkPhoneSuffix;
    @XmlElement(name = "stmnt_email_list")
    protected String stmntEmailList;
    @XmlElement(name = "invoice_approval_required")
    protected Long invoiceApprovalRequired;
    @XmlElement(name = "stmnt_email_list_cc")
    protected String stmntEmailListCc;
    @XmlElement(name = "stmnt_email_list_bcc")
    protected String stmntEmailListBcc;
    @XmlElement(name = "invoice_posting_method_cd")
    protected Long invoicePostingMethodCd;
    @XmlElement(name = "acct_start_date")
    protected String acctStartDate;
    @XmlElement(name = "bill_agreement_id")
    protected String billAgreementId;
    @XmlElement(name = "bkup_bill_agreement_id")
    protected String bkupBillAgreementId;
    @XmlElement(name = "error_code")
    protected Long errorCode;
    @XmlElement(name = "error_msg")
    protected String errorMsg;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String value) {
        this.mi = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String value) {
        this.userid = value;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String value) {
        this.birthdate = value;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String value) {
        this.jobTitle = value;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String value) {
        this.salutation = value;
    }

    public String getSeniorAcctNo() {
        return seniorAcctNo;
    }

    public void setSeniorAcctNo(String value) {
        this.seniorAcctNo = value;
    }

    public String getClientAcctId() {
        return clientAcctId;
    }

    public void setClientAcctId(String value) {
        this.clientAcctId = value;
    }

    public String getRespLevelCd() {
        return respLevelCd;
    }

    public void setRespLevelCd(String value) {
        this.respLevelCd = value;
    }

    public String getIsTestAcct() {
        return isTestAcct;
    }

    public void setIsTestAcct(String value) {
        this.isTestAcct = value;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String value) {
        this.altEmail = value;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String value) {
        this.address1 = value;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String value) {
        this.address2 = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String value) {
        this.stateProv = value;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String value) {
        this.locality = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String value) {
        this.companyName = value;
    }

    public String getCellPhoneNpa() {
        return cellPhoneNpa;
    }

    public void setCellPhoneNpa(String value) {
        this.cellPhoneNpa = value;
    }

    public String getCellPhoneNxx() {
        return cellPhoneNxx;
    }

    public void setCellPhoneNxx(String value) {
        this.cellPhoneNxx = value;
    }

    public String getCellPhoneSuffix() {
        return cellPhoneSuffix;
    }

    public void setCellPhoneSuffix(String value) {
        this.cellPhoneSuffix = value;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public void setFaxPhone(String value) {
        this.faxPhone = value;
    }

    public String getIntlCellPhone() {
        return intlCellPhone;
    }

    public void setIntlCellPhone(String value) {
        this.intlCellPhone = value;
    }

    public String getIntlPhone() {
        return intlPhone;
    }

    public void setIntlPhone(String value) {
        this.intlPhone = value;
    }

    public String getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExtension(String value) {
        this.phoneExtension = value;
    }

    public String getPhoneNpa() {
        return phoneNpa;
    }

    public void setPhoneNpa(String value) {
        this.phoneNpa = value;
    }

    public String getPhoneNxx() {
        return phoneNxx;
    }

    public void setPhoneNxx(String value) {
        this.phoneNxx = value;
    }

    public String getPhoneSuffix() {
        return phoneSuffix;
    }

    public void setPhoneSuffix(String value) {
        this.phoneSuffix = value;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String value) {
        this.workPhone = value;
    }

    public String getWorkPhoneExtension() {
        return workPhoneExtension;
    }

    public void setWorkPhoneExtension(String value) {
        this.workPhoneExtension = value;
    }

    public String getWorkPhoneNpa() {
        return workPhoneNpa;
    }

    public void setWorkPhoneNpa(String value) {
        this.workPhoneNpa = value;
    }

    public String getWorkPhoneNxx() {
        return workPhoneNxx;
    }

    public void setWorkPhoneNxx(String value) {
        this.workPhoneNxx = value;
    }

    public String getWorkPhoneSuffix() {
        return workPhoneSuffix;
    }

    public void setWorkPhoneSuffix(String value) {
        this.workPhoneSuffix = value;
    }

    public String getBillDay() {
        return billDay;
    }

    public void setBillDay(String value) {
        this.billDay = value;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String value) {
        this.created = value;
    }

    public String getDateToExpire() {
        return dateToExpire;
    }

    public void setDateToExpire(String value) {
        this.dateToExpire = value;
    }

    public String getDateToSuspend() {
        return dateToSuspend;
    }

    public void setDateToSuspend(String value) {
        this.dateToSuspend = value;
    }

    public String getLastArrearsBillThruDate() {
        return lastArrearsBillThruDate;
    }

    public void setLastArrearsBillThruDate(String value) {
        this.lastArrearsBillThruDate = value;
    }

    public String getLastBillDate() {
        return lastBillDate;
    }

    public void setLastBillDate(String value) {
        this.lastBillDate = value;
    }

    public String getLastBillThruDate() {
        return lastBillThruDate;
    }

    public void setLastBillThruDate(String value) {
        this.lastBillThruDate = value;
    }

    public String getNextBillDate() {
        return nextBillDate;
    }

    public void setNextBillDate(String value) {
        this.nextBillDate = value;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String value) {
        this.planDate = value;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String value) {
        this.statusDate = value;
    }

    public String getStatusDegradeDate() {
        return statusDegradeDate;
    }

    public void setStatusDegradeDate(String value) {
        this.statusDegradeDate = value;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String value) {
        this.statusCd = value;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String value) {
        this.statusLabel = value;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String value) {
        this.planNo = value;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String value) {
        this.planName = value;
    }

    public String getPlanUnits() {
        return planUnits;
    }

    public void setPlanUnits(String value) {
        this.planUnits = value;
    }

    public String getNotifyMethod() {
        return notifyMethod;
    }

    public void setNotifyMethod(String value) {
        this.notifyMethod = value;
    }

    public String getNotifyMethodName() {
        return notifyMethodName;
    }

    public void setNotifyMethodName(String value) {
        this.notifyMethodName = value;
    }

    public String getPASSWORD() {
        return password;
    }

    public void setPASSWORD(String value) {
        this.password = value;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String value) {
        this.pin = value;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String value) {
        this.secretQuestion = value;
    }

    public String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    public void setSecretQuestionAnswer(String value) {
        this.secretQuestionAnswer = value;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String value) {
        this.payMethod = value;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public void setPayMethodName(String value) {
        this.payMethodName = value;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String value) {
        this.currencyCd = value;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String value) {
        this.taxId = value;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String value) {
        this.billingEmail = value;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String value) {
        this.billingFirstName = value;
    }

    public String getBillingMiddleInitial() {
        return billingMiddleInitial;
    }

    public void setBillingMiddleInitial(String value) {
        this.billingMiddleInitial = value;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String value) {
        this.billingLastName = value;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String value) {
        this.billingAddress1 = value;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String value) {
        this.billingAddress2 = value;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String value) {
        this.billingCity = value;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String value) {
        this.billingState = value;
    }

    public String getBillingLocality() {
        return billingLocality;
    }

    public void setBillingLocality(String value) {
        this.billingLocality = value;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String value) {
        this.billingZip = value;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String value) {
        this.billingCountry = value;
    }

    public String getCcSuffix() {
        return ccSuffix;
    }

    public void setCcSuffix(String value) {
        this.ccSuffix = value;
    }

    public String getCcExpireMm() {
        return ccExpireMm;
    }

    public void setCcExpireMm(String value) {
        this.ccExpireMm = value;
    }

    public String getCcExpireYyyy() {
        return ccExpireYyyy;
    }

    public void setCcExpireYyyy(String value) {
        this.ccExpireYyyy = value;
    }

    public Long getCcId() {
        return ccId;
    }

    public void setCcId(Long value) {
        this.ccId = value;
    }

    public String getBankAcctSuffix() {
        return bankAcctSuffix;
    }

    public void setBankAcctSuffix(String value) {
        this.bankAcctSuffix = value;
    }

    public String getBankRoutingNo() {
        return bankRoutingNo;
    }

    public void setBankRoutingNo(String value) {
        this.bankRoutingNo = value;
    }

    public String getBillingCellPhone() {
        return billingCellPhone;
    }

    public void setBillingCellPhone(String value) {
        this.billingCellPhone = value;
    }

    public String getBillingCellPhoneNpa() {
        return billingCellPhoneNpa;
    }

    public void setBillingCellPhoneNpa(String value) {
        this.billingCellPhoneNpa = value;
    }

    public String getBillingCellPhoneNxx() {
        return billingCellPhoneNxx;
    }

    public void setBillingCellPhoneNxx(String value) {
        this.billingCellPhoneNxx = value;
    }

    public String getBillingCellPhoneSuffix() {
        return billingCellPhoneSuffix;
    }

    public void setBillingCellPhoneSuffix(String value) {
        this.billingCellPhoneSuffix = value;
    }

    public String getBillingCompanyName() {
        return billingCompanyName;
    }

    public void setBillingCompanyName(String value) {
        this.billingCompanyName = value;
    }

    public String getBillingIntlPhone() {
        return billingIntlPhone;
    }

    public void setBillingIntlPhone(String value) {
        this.billingIntlPhone = value;
    }

    public String getBillingPhoneExtension() {
        return billingPhoneExtension;
    }

    public void setBillingPhoneExtension(String value) {
        this.billingPhoneExtension = value;
    }

    public String getBillingPhoneNpa() {
        return billingPhoneNpa;
    }

    public void setBillingPhoneNpa(String value) {
        this.billingPhoneNpa = value;
    }

    public String getBillingPhoneNxx() {
        return billingPhoneNxx;
    }

    public void setBillingPhoneNxx(String value) {
        this.billingPhoneNxx = value;
    }

    public String getBillingPhoneSuffix() {
        return billingPhoneSuffix;
    }

    public void setBillingPhoneSuffix(String value) {
        this.billingPhoneSuffix = value;
    }

    public String getBillingWorkPhone() {
        return billingWorkPhone;
    }

    public void setBillingWorkPhone(String value) {
        this.billingWorkPhone = value;
    }

    public String getBillingWorkPhoneExtension() {
        return billingWorkPhoneExtension;
    }

    public void setBillingWorkPhoneExtension(String value) {
        this.billingWorkPhoneExtension = value;
    }

    public String getBillingWorkPhoneNpa() {
        return billingWorkPhoneNpa;
    }

    public void setBillingWorkPhoneNpa(String value) {
        this.billingWorkPhoneNpa = value;
    }

    public String getBillingWorkPhoneNxx() {
        return billingWorkPhoneNxx;
    }

    public void setBillingWorkPhoneNxx(String value) {
        this.billingWorkPhoneNxx = value;
    }

    public String getBillingWorkPhoneSuffix() {
        return billingWorkPhoneSuffix;
    }

    public void setBillingWorkPhoneSuffix(String value) {
        this.billingWorkPhoneSuffix = value;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String value) {
        this.balance = value;
    }

    public String getAcctCreateClientReceiptId() {
        return acctCreateClientReceiptId;
    }

    public void setAcctCreateClientReceiptId(String value) {
        this.acctCreateClientReceiptId = value;
    }

    public String getPlanClientReceiptId() {
        return planClientReceiptId;
    }

    public void setPlanClientReceiptId(String value) {
        this.planClientReceiptId = value;
    }

    public String getStatusClientReceiptId() {
        return statusClientReceiptId;
    }

    public void setStatusClientReceiptId(String value) {
        this.statusClientReceiptId = value;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String value) {
        this.taxpayerId = value;
    }

    public Long getAltMsgTemplateNo() {
        return altMsgTemplateNo;
    }

    public void setAltMsgTemplateNo(Long value) {
        this.altMsgTemplateNo = value;
    }

    public Long getSeqFuncGroupNo() {
        return seqFuncGroupNo;
    }

    public void setSeqFuncGroupNo(Long value) {
        this.seqFuncGroupNo = value;
    }

    public String getPromoCd() {
        return promoCd;
    }

    public void setPromoCd(String value) {
        this.promoCd = value;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String value) {
        this.address3 = value;
    }

    public String getBillingAddress3() {
        return billingAddress3;
    }

    public void setBillingAddress3(String value) {
        this.billingAddress3 = value;
    }

    public String getAddressVerificationCode() {
        return addressVerificationCode;
    }

    public void setAddressVerificationCode(String value) {
        this.addressVerificationCode = value;
    }

    public Double getAddressMatchScore() {
        return addressMatchScore;
    }

    public void setAddressMatchScore(Double value) {
        this.addressMatchScore = value;
    }

    public String getBillingAddressVerificationCode() {
        return billingAddressVerificationCode;
    }

    public void setBillingAddressVerificationCode(String value) {
        this.billingAddressVerificationCode = value;
    }

    public Double getBillingAddressMatchScore() {
        return billingAddressMatchScore;
    }

    public void setBillingAddressMatchScore(Double value) {
        this.billingAddressMatchScore = value;
    }

    public String getClientPlanId() {
        return clientPlanId;
    }

    public void setClientPlanId(String value) {
        this.clientPlanId = value;
    }

    public String getClientAltMsgTemplateId() {
        return clientAltMsgTemplateId;
    }

    public void setClientAltMsgTemplateId(String value) {
        this.clientAltMsgTemplateId = value;
    }

    public String getBkupPayMethod() {
        return bkupPayMethod;
    }

    public void setBkupPayMethod(String value) {
        this.bkupPayMethod = value;
    }

    public String getBkupBillingEmail() {
        return bkupBillingEmail;
    }

    public void setBkupBillingEmail(String value) {
        this.bkupBillingEmail = value;
    }

    public String getBkupBillingFirstName() {
        return bkupBillingFirstName;
    }

    public void setBkupBillingFirstName(String value) {
        this.bkupBillingFirstName = value;
    }

    public String getBkupBillingMiddleInitial() {
        return bkupBillingMiddleInitial;
    }

    public void setBkupBillingMiddleInitial(String value) {
        this.bkupBillingMiddleInitial = value;
    }

    public String getBkupBillingLastName() {
        return bkupBillingLastName;
    }

    public void setBkupBillingLastName(String value) {
        this.bkupBillingLastName = value;
    }

    public String getBkupBillingAddress1() {
        return bkupBillingAddress1;
    }

    public void setBkupBillingAddress1(String value) {
        this.bkupBillingAddress1 = value;
    }

    public String getBkupBillingAddress2() {
        return bkupBillingAddress2;
    }

    public void setBkupBillingAddress2(String value) {
        this.bkupBillingAddress2 = value;
    }

    public String getBkupBillingCity() {
        return bkupBillingCity;
    }

    public void setBkupBillingCity(String value) {
        this.bkupBillingCity = value;
    }

    public String getBkupBillingState() {
        return bkupBillingState;
    }

    public void setBkupBillingState(String value) {
        this.bkupBillingState = value;
    }

    public String getBkupBillingLocality() {
        return bkupBillingLocality;
    }

    public void setBkupBillingLocality(String value) {
        this.bkupBillingLocality = value;
    }

    public String getBkupBillingZip() {
        return bkupBillingZip;
    }

    public void setBkupBillingZip(String value) {
        this.bkupBillingZip = value;
    }

    public String getBkupBillingCountry() {
        return bkupBillingCountry;
    }

    public void setBkupBillingCountry(String value) {
        this.bkupBillingCountry = value;
    }

    public String getBkupCcSuffix() {
        return bkupCcSuffix;
    }

    public void setBkupCcSuffix(String value) {
        this.bkupCcSuffix = value;
    }

    public String getBkupCcExpireMm() {
        return bkupCcExpireMm;
    }

    public void setBkupCcExpireMm(String value) {
        this.bkupCcExpireMm = value;
    }

    public String getBkupCcExpireYyyy() {
        return bkupCcExpireYyyy;
    }

    public void setBkupCcExpireYyyy(String value) {
        this.bkupCcExpireYyyy = value;
    }

    public Long getBkupCcId() {
        return bkupCcId;
    }

    public void setBkupCcId(Long value) {
        this.bkupCcId = value;
    }

    public String getBkupBankAcctSuffix() {
        return bkupBankAcctSuffix;
    }

    public void setBkupBankAcctSuffix(String value) {
        this.bkupBankAcctSuffix = value;
    }

    public String getBkupBankRoutingNo() {
        return bkupBankRoutingNo;
    }

    public void setBkupBankRoutingNo(String value) {
        this.bkupBankRoutingNo = value;
    }

    public String getBkupBillingCellPhone() {
        return bkupBillingCellPhone;
    }

    public void setBkupBillingCellPhone(String value) {
        this.bkupBillingCellPhone = value;
    }

    public String getBkupBillingCellPhoneNpa() {
        return bkupBillingCellPhoneNpa;
    }

    public void setBkupBillingCellPhoneNpa(String value) {
        this.bkupBillingCellPhoneNpa = value;
    }

    public String getBkupBillingCellPhoneNxx() {
        return bkupBillingCellPhoneNxx;
    }

    public void setBkupBillingCellPhoneNxx(String value) {
        this.bkupBillingCellPhoneNxx = value;
    }

    public String getBkupBillingCellPhoneSuffix() {
        return bkupBillingCellPhoneSuffix;
    }

    public void setBkupBillingCellPhoneSuffix(String value) {
        this.bkupBillingCellPhoneSuffix = value;
    }

    public String getBkupBillingCompanyName() {
        return bkupBillingCompanyName;
    }

    public void setBkupBillingCompanyName(String value) {
        this.bkupBillingCompanyName = value;
    }

    public String getBkupBillingIntlPhone() {
        return bkupBillingIntlPhone;
    }

    public void setBkupBillingIntlPhone(String value) {
        this.bkupBillingIntlPhone = value;
    }

    public String getBkupBillingPhoneExtension() {
        return bkupBillingPhoneExtension;
    }

    public void setBkupBillingPhoneExtension(String value) {
        this.bkupBillingPhoneExtension = value;
    }

    public String getBkupBillingWorkPhone() {
        return bkupBillingWorkPhone;
    }

    public void setBkupBillingWorkPhone(String value) {
        this.bkupBillingWorkPhone = value;
    }

    public String getBkupBillingWorkPhoneExtension() {
        return bkupBillingWorkPhoneExtension;
    }

    public void setBkupBillingWorkPhoneExtension(String value) {
        this.bkupBillingWorkPhoneExtension = value;
    }

    public String getBkupBillingWorkPhoneNpa() {
        return bkupBillingWorkPhoneNpa;
    }

    public void setBkupBillingWorkPhoneNpa(String value) {
        this.bkupBillingWorkPhoneNpa = value;
    }

    public String getBkupBillingWorkPhoneNxx() {
        return bkupBillingWorkPhoneNxx;
    }

    public void setBkupBillingWorkPhoneNxx(String value) {
        this.bkupBillingWorkPhoneNxx = value;
    }

    public String getBkupBillingWorkPhoneSuffix() {
        return bkupBillingWorkPhoneSuffix;
    }

    public void setBkupBillingWorkPhoneSuffix(String value) {
        this.bkupBillingWorkPhoneSuffix = value;
    }

    public String getStmntEmailList() {
        return stmntEmailList;
    }

    public void setStmntEmailList(String value) {
        this.stmntEmailList = value;
    }

    public Long getInvoiceApprovalRequired() {
        return invoiceApprovalRequired;
    }

    public void setInvoiceApprovalRequired(Long value) {
        this.invoiceApprovalRequired = value;
    }

    public String getStmntEmailListCc() {
        return stmntEmailListCc;
    }

    public void setStmntEmailListCc(String value) {
        this.stmntEmailListCc = value;
    }

    public String getStmntEmailListBcc() {
        return stmntEmailListBcc;
    }

    public void setStmntEmailListBcc(String value) {
        this.stmntEmailListBcc = value;
    }

    public Long getInvoicePostingMethodCd() {
        return invoicePostingMethodCd;
    }

    public void setInvoicePostingMethodCd(Long value) {
        this.invoicePostingMethodCd = value;
    }

    public String getAcctStartDate() {
        return acctStartDate;
    }

    public void setAcctStartDate(String value) {
        this.acctStartDate = value;
    }

    public String getBillAgreementId() {
        return billAgreementId;
    }

    public void setBillAgreementId(String value) {
        this.billAgreementId = value;
    }

    public String getBkupBillAgreementId() {
        return bkupBillAgreementId;
    }

    public void setBkupBillAgreementId(String value) {
        this.bkupBillAgreementId = value;
    }

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

    
}
