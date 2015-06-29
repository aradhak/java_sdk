package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "acctNo",    "firstName",    "lastName",    "middleInitial",    "companyName",    "address1",    "address2",    "city",    "locality",    "stateProv",    "country",    "postalCd",    "phone",    "phoneExt",    "cellPhone",    "workPhone",    "workPhoneExt",    "email",    "birthdate",    "billFirstName",    "billLastName",    "billMiddleInitial",    "billCompanyName",    "billAddress1",    "billAddress2",    "billCity",    "billLocality",    "billStateProv",    "billCountry",    "billPostalCd",    "billPhone",    "billPhoneExt",    "billCellPhone",    "billWorkPhone",    "billWorkPhoneExt",    "billEmail",    "payMethod",    "ccNumber",    "ccExpireMm",    "ccExpireYyyy",    "bankRoutingNum",    "bankAcctNum",    "masterPlanNo",    "masterPlanAltRateSchedNo",    "masterPlanUnits",    "masterPlanAssignDirective",    "updateAcctSuppField",    "updateAcctFuncGroup",    "updateAcctCollGroup",    "statusCd",    "notifyMethod",    "password",    "secretQuestion",    "secretQuestionAnswer",    "pin",    "testAcctInd",    "respLevelCd",    "seniorAcctNo",    "seniorAcctUserId",    "clientSeniorAcctId",    "clientAcctId",    "doCollect",    "changeStatusAfterColl",    "resetDatesAfterStatus",    "clientReceiptId",    "altDoDunning",    "forceCurrencyChange",    "cvv",    "taxpayerId",    "billAgreementId",    "autoCancelSuppPlans",    "offsetMonths",    "altProrationStartDate",    "altMsgTemplateNo",    "seqFuncGroupNo",    "bankAcctType",    "address3",    "billAddress3",    "usageAccumulationConfig",    "enableUsagePoolingPlanNo",    "disableUsagePoolingPlanNo",    "altClientAcctGroupId",    "trackData1",    "trackData2",    "offsetInterval",    "taxExemptionLevel",    "cnAltMsgTemplateNo",    "promoCd",    "invoiceUnbilledUsage",    "couponCode",    "userid",    "invoiceApprovalRequired",    "clientMasterPlanId",    "clientMpAltRateSchedId",    "clientAltMsgTemplateId",    "clientCnAltMsgTemplateId",    "updateSurcharge",    "iban",    "bankCheckDigit",    "bankSwiftCd",    "bankCountryCd",    "mandateId",    "bankIdCd",    "bankBranchCd",    "bkupBillFirstName",    "bkupBillMi",    "bkupBillLastName",    "bkupBillCompanyName",    "bkupBillAddress1",    "bkupBillAddress2",    "bkupBillAddress3",    "bkupBillCity",    "bkupBillLocality",    "bkupBillStateProv",    "bkupBillCountry",    "bkupBillPostalCd",    "bkupBillPhone",    "bkupBillPhoneExt",    "bkupBillCellPhone",    "bkupBillWorkPhone",    "bkupBillWorkPhoneExt",    "bkupBillEmail",    "bkupPayMethod",    "bkupCcNumber",    "bkupCcExpireMm",    "bkupCcExpireYyyy",    "bkupBankAcctNo",    "bkupBankRoutingNo",    "bkupBankAcctType",    "bkupBillAgreementId",    "bkupCvv",    "seqFuncGroupId",    "revrecProfileId",    "revrecClientDefinedId",    "stmntEmailList",    "stmntEmailListCc",    "stmntEmailListBcc",    "invoicePostingMethodCd",    "acctStartDate"})
@XmlRootElement(name = "update_acct_complete")
public class UpdateAcctComplete {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "acct_no")
    protected Long acctNo;
        @XmlElement(name = "first_name")
    protected String firstName;
        @XmlElement(name = "last_name")
    protected String lastName;
        @XmlElement(name = "middle_initial")
    protected String middleInitial;
        @XmlElement(name = "company_name")
    protected String companyName;
        @XmlElement(name = "address1")
    protected String address1;
        @XmlElement(name = "address2")
    protected String address2;
        @XmlElement(name = "city")
    protected String city;
        @XmlElement(name = "locality")
    protected String locality;
        @XmlElement(name = "state_prov")
    protected String stateProv;
        @XmlElement(name = "country")
    protected String country;
        @XmlElement(name = "postal_cd")
    protected String postalCd;
        @XmlElement(name = "phone")
    protected String phone;
        @XmlElement(name = "phone_ext")
    protected String phoneExt;
        @XmlElement(name = "cell_phone")
    protected String cellPhone;
        @XmlElement(name = "work_phone")
    protected String workPhone;
        @XmlElement(name = "work_phone_ext")
    protected String workPhoneExt;
        @XmlElement(name = "email")
    protected String email;
        @XmlElement(name = "birthdate")
    protected String birthdate;
        @XmlElement(name = "bill_first_name")
    protected String billFirstName;
        @XmlElement(name = "bill_last_name")
    protected String billLastName;
        @XmlElement(name = "bill_middle_initial")
    protected String billMiddleInitial;
        @XmlElement(name = "bill_company_name")
    protected String billCompanyName;
        @XmlElement(name = "bill_address1")
    protected String billAddress1;
        @XmlElement(name = "bill_address2")
    protected String billAddress2;
        @XmlElement(name = "bill_city")
    protected String billCity;
        @XmlElement(name = "bill_locality")
    protected String billLocality;
        @XmlElement(name = "bill_state_prov")
    protected String billStateProv;
        @XmlElement(name = "bill_country")
    protected String billCountry;
        @XmlElement(name = "bill_postal_cd")
    protected String billPostalCd;
        @XmlElement(name = "bill_phone")
    protected String billPhone;
        @XmlElement(name = "bill_phone_ext")
    protected String billPhoneExt;
        @XmlElement(name = "bill_cell_phone")
    protected String billCellPhone;
        @XmlElement(name = "bill_work_phone")
    protected String billWorkPhone;
        @XmlElement(name = "bill_work_phone_ext")
    protected String billWorkPhoneExt;
        @XmlElement(name = "bill_email")
    protected String billEmail;
        @XmlElement(name = "pay_method")
    protected Long payMethod;
        @XmlElement(name = "cc_number")
    protected String ccNumber;
        @XmlElement(name = "cc_expire_mm")
    protected Long ccExpireMm;
        @XmlElement(name = "cc_expire_yyyy")
    protected Long ccExpireYyyy;
        @XmlElement(name = "bank_routing_num")
    protected String bankRoutingNum;
        @XmlElement(name = "bank_acct_num")
    protected String bankAcctNum;
        @XmlElement(name = "master_plan_no")
    protected Long masterPlanNo;
        @XmlElement(name = "master_plan_alt_rate_sched_no")
    protected Long masterPlanAltRateSchedNo;
        @XmlElement(name = "master_plan_units")
    protected Long masterPlanUnits;
        @XmlElement(name = "master_plan_assign_directive")
    protected Long masterPlanAssignDirective;
        @XmlElement(name = "update_acct_supp_field")
    protected UpdateAcctSuppFieldArray updateAcctSuppField;
        @XmlElement(name = "update_acct_func_group")
    protected UpdateAcctFuncGroupArray updateAcctFuncGroup;
        @XmlElement(name = "update_acct_coll_group")
    protected UpdateAcctCollGroupArray updateAcctCollGroup;
        @XmlElement(name = "status_cd")
    protected Long statusCd;
        @XmlElement(name = "notify_method")
    protected Long notifyMethod;
        @XmlElement(name = "password")
    protected String password;
        @XmlElement(name = "secret_question")
    protected String secretQuestion;
        @XmlElement(name = "secret_question_answer")
    protected String secretQuestionAnswer;
        @XmlElement(name = "pin")
    protected String pin;
        @XmlElement(name = "test_acct_ind")
    protected Long testAcctInd;
        @XmlElement(name = "resp_level_cd")
    protected Long respLevelCd;
        @XmlElement(name = "senior_acct_no")
    protected Long seniorAcctNo;
        @XmlElement(name = "senior_acct_user_id")
    protected String seniorAcctUserId;
        @XmlElement(name = "client_senior_acct_id")
    protected String clientSeniorAcctId;
        @XmlElement(name = "client_acct_id")
    protected String clientAcctId;
        @XmlElement(name = "do_collect")
    protected String doCollect;
        @XmlElement(name = "change_status_after_coll")
    protected String changeStatusAfterColl;
        @XmlElement(name = "reset_dates_after_status")
    protected String resetDatesAfterStatus;
        @XmlElement(name = "client_receipt_id")
    protected String clientReceiptId;
        @XmlElement(name = "alt_do_dunning")
    protected String altDoDunning;
        @XmlElement(name = "force_currency_change")
    protected String forceCurrencyChange;
        @XmlElement(name = "cvv")
    protected String cvv;
        @XmlElement(name = "taxpayer_id")
    protected String taxpayerId;
        @XmlElement(name = "bill_agreement_id")
    protected String billAgreementId;
        @XmlElement(name = "auto_cancel_supp_plans")
    protected String autoCancelSuppPlans;
        @XmlElement(name = "offset_months")
    protected Long offsetMonths;
        @XmlElement(name = "alt_proration_start_date")
    protected String altProrationStartDate;
        @XmlElement(name = "alt_msg_template_no")
    protected Long altMsgTemplateNo;
        @XmlElement(name = "seq_func_group_no")
    protected Long seqFuncGroupNo;
        @XmlElement(name = "bank_acct_type")
    protected String bankAcctType;
        @XmlElement(name = "address3")
    protected String address3;
        @XmlElement(name = "bill_address3")
    protected String billAddress3;
        @XmlElement(name = "usage_accumulation_config")
    protected UsageAccumulationConfigArray usageAccumulationConfig;
        @XmlElement(name = "enable_usage_pooling_plan_no")
    protected EnableUsagePoolingPlanNoArray enableUsagePoolingPlanNo;
        @XmlElement(name = "disable_usage_pooling_plan_no")
    protected DisableUsagePoolingPlanNoArray disableUsagePoolingPlanNo;
        @XmlElement(name = "alt_client_acct_group_id")
    protected String altClientAcctGroupId;
        @XmlElement(name = "track_data1")
    protected String trackData1;
        @XmlElement(name = "track_data2")
    protected String trackData2;
        @XmlElement(name = "offset_interval")
    protected Long offsetInterval;
        @XmlElement(name = "tax_exemption_level")
    protected Long taxExemptionLevel;
        @XmlElement(name = "cn_alt_msg_template_no")
    protected Long cnAltMsgTemplateNo;
        @XmlElement(name = "promo_cd")
    protected String promoCd;
        @XmlElement(name = "invoice_unbilled_usage")
    protected String invoiceUnbilledUsage;
        @XmlElement(name = "coupon_code")
    protected String couponCode;
        @XmlElement(name = "userid")
    protected String userid;
        @XmlElement(name = "invoice_approval_required")
    protected String invoiceApprovalRequired;
        @XmlElement(name = "client_master_plan_id")
    protected String clientMasterPlanId;
        @XmlElement(name = "client_mp_alt_rate_sched_id")
    protected String clientMpAltRateSchedId;
        @XmlElement(name = "client_alt_msg_template_id")
    protected String clientAltMsgTemplateId;
        @XmlElement(name = "client_cn_alt_msg_template_id")
    protected String clientCnAltMsgTemplateId;
        @XmlElement(name = "update_surcharge")
    protected UpdateSurchargeArray updateSurcharge;
        @XmlElement(name = "iban")
    protected String iban;
        @XmlElement(name = "bank_check_digit")
    protected Long bankCheckDigit;
        @XmlElement(name = "bank_swift_cd")
    protected String bankSwiftCd;
        @XmlElement(name = "bank_country_cd")
    protected String bankCountryCd;
        @XmlElement(name = "mandate_id")
    protected String mandateId;
        @XmlElement(name = "bank_id_cd")
    protected String bankIdCd;
        @XmlElement(name = "bank_branch_cd")
    protected String bankBranchCd;
        @XmlElement(name = "bkup_bill_first_name")
    protected String bkupBillFirstName;
        @XmlElement(name = "bkup_bill_mi")
    protected String bkupBillMi;
        @XmlElement(name = "bkup_bill_last_name")
    protected String bkupBillLastName;
        @XmlElement(name = "bkup_bill_company_name")
    protected String bkupBillCompanyName;
        @XmlElement(name = "bkup_bill_address1")
    protected String bkupBillAddress1;
        @XmlElement(name = "bkup_bill_address2")
    protected String bkupBillAddress2;
        @XmlElement(name = "bkup_bill_address3")
    protected String bkupBillAddress3;
        @XmlElement(name = "bkup_bill_city")
    protected String bkupBillCity;
        @XmlElement(name = "bkup_bill_locality")
    protected String bkupBillLocality;
        @XmlElement(name = "bkup_bill_state_prov")
    protected String bkupBillStateProv;
        @XmlElement(name = "bkup_bill_country")
    protected String bkupBillCountry;
        @XmlElement(name = "bkup_bill_postal_cd")
    protected String bkupBillPostalCd;
        @XmlElement(name = "bkup_bill_phone")
    protected String bkupBillPhone;
        @XmlElement(name = "bkup_bill_phone_ext")
    protected String bkupBillPhoneExt;
        @XmlElement(name = "bkup_bill_cell_phone")
    protected String bkupBillCellPhone;
        @XmlElement(name = "bkup_bill_work_phone")
    protected String bkupBillWorkPhone;
        @XmlElement(name = "bkup_bill_work_phone_ext")
    protected String bkupBillWorkPhoneExt;
        @XmlElement(name = "bkup_bill_email")
    protected String bkupBillEmail;
        @XmlElement(name = "bkup_pay_method")
    protected Long bkupPayMethod;
        @XmlElement(name = "bkup_cc_number")
    protected String bkupCcNumber;
        @XmlElement(name = "bkup_cc_expire_mm")
    protected Long bkupCcExpireMm;
        @XmlElement(name = "bkup_cc_expire_yyyy")
    protected Long bkupCcExpireYyyy;
        @XmlElement(name = "bkup_bank_acct_no")
    protected String bkupBankAcctNo;
        @XmlElement(name = "bkup_bank_routing_no")
    protected String bkupBankRoutingNo;
        @XmlElement(name = "bkup_bank_acct_type")
    protected String bkupBankAcctType;
        @XmlElement(name = "bkup_bill_agreement_id")
    protected String bkupBillAgreementId;
        @XmlElement(name = "bkup_cvv")
    protected String bkupCvv;
        @XmlElement(name = "seq_func_group_id")
    protected String seqFuncGroupId;
        @XmlElement(name = "revrec_profile_id")
    protected Long revrecProfileId;
        @XmlElement(name = "revrec_client_defined_id")
    protected String revrecClientDefinedId;
        @XmlElement(name = "stmnt_email_list")
    protected String stmntEmailList;
        @XmlElement(name = "stmnt_email_list_cc")
    protected String stmntEmailListCc;
        @XmlElement(name = "stmnt_email_list_bcc")
    protected String stmntEmailListBcc;
        @XmlElement(name = "invoice_posting_method_cd")
    protected Long invoicePostingMethodCd;
        @XmlElement(name = "acct_start_date")
    protected String acctStartDate;
    
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
            public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }
            public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }
            public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String value) {
        this.middleInitial = value;
    }
            public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String value) {
        this.companyName = value;
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
            public String getLocality() {
        return locality;
    }

    public void setLocality(String value) {
        this.locality = value;
    }
            public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String value) {
        this.stateProv = value;
    }
            public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }
            public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String value) {
        this.postalCd = value;
    }
            public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }
            public String getPhoneExt() {
        return phoneExt;
    }

    public void setPhoneExt(String value) {
        this.phoneExt = value;
    }
            public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String value) {
        this.cellPhone = value;
    }
            public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String value) {
        this.workPhone = value;
    }
            public String getWorkPhoneExt() {
        return workPhoneExt;
    }

    public void setWorkPhoneExt(String value) {
        this.workPhoneExt = value;
    }
            public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }
            public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String value) {
        this.birthdate = value;
    }
            public String getBillFirstName() {
        return billFirstName;
    }

    public void setBillFirstName(String value) {
        this.billFirstName = value;
    }
            public String getBillLastName() {
        return billLastName;
    }

    public void setBillLastName(String value) {
        this.billLastName = value;
    }
            public String getBillMiddleInitial() {
        return billMiddleInitial;
    }

    public void setBillMiddleInitial(String value) {
        this.billMiddleInitial = value;
    }
            public String getBillCompanyName() {
        return billCompanyName;
    }

    public void setBillCompanyName(String value) {
        this.billCompanyName = value;
    }
            public String getBillAddress1() {
        return billAddress1;
    }

    public void setBillAddress1(String value) {
        this.billAddress1 = value;
    }
            public String getBillAddress2() {
        return billAddress2;
    }

    public void setBillAddress2(String value) {
        this.billAddress2 = value;
    }
            public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String value) {
        this.billCity = value;
    }
            public String getBillLocality() {
        return billLocality;
    }

    public void setBillLocality(String value) {
        this.billLocality = value;
    }
            public String getBillStateProv() {
        return billStateProv;
    }

    public void setBillStateProv(String value) {
        this.billStateProv = value;
    }
            public String getBillCountry() {
        return billCountry;
    }

    public void setBillCountry(String value) {
        this.billCountry = value;
    }
            public String getBillPostalCd() {
        return billPostalCd;
    }

    public void setBillPostalCd(String value) {
        this.billPostalCd = value;
    }
            public String getBillPhone() {
        return billPhone;
    }

    public void setBillPhone(String value) {
        this.billPhone = value;
    }
            public String getBillPhoneExt() {
        return billPhoneExt;
    }

    public void setBillPhoneExt(String value) {
        this.billPhoneExt = value;
    }
            public String getBillCellPhone() {
        return billCellPhone;
    }

    public void setBillCellPhone(String value) {
        this.billCellPhone = value;
    }
            public String getBillWorkPhone() {
        return billWorkPhone;
    }

    public void setBillWorkPhone(String value) {
        this.billWorkPhone = value;
    }
            public String getBillWorkPhoneExt() {
        return billWorkPhoneExt;
    }

    public void setBillWorkPhoneExt(String value) {
        this.billWorkPhoneExt = value;
    }
            public String getBillEmail() {
        return billEmail;
    }

    public void setBillEmail(String value) {
        this.billEmail = value;
    }
            public Long getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Long value) {
        this.payMethod = value;
    }
            public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String value) {
        this.ccNumber = value;
    }
            public Long getCcExpireMm() {
        return ccExpireMm;
    }

    public void setCcExpireMm(Long value) {
        this.ccExpireMm = value;
    }
            public Long getCcExpireYyyy() {
        return ccExpireYyyy;
    }

    public void setCcExpireYyyy(Long value) {
        this.ccExpireYyyy = value;
    }
            public String getBankRoutingNum() {
        return bankRoutingNum;
    }

    public void setBankRoutingNum(String value) {
        this.bankRoutingNum = value;
    }
            public String getBankAcctNum() {
        return bankAcctNum;
    }

    public void setBankAcctNum(String value) {
        this.bankAcctNum = value;
    }
            public Long getMasterPlanNo() {
        return masterPlanNo;
    }

    public void setMasterPlanNo(Long value) {
        this.masterPlanNo = value;
    }
            public Long getMasterPlanAltRateSchedNo() {
        return masterPlanAltRateSchedNo;
    }

    public void setMasterPlanAltRateSchedNo(Long value) {
        this.masterPlanAltRateSchedNo = value;
    }
            public Long getMasterPlanUnits() {
        return masterPlanUnits;
    }

    public void setMasterPlanUnits(Long value) {
        this.masterPlanUnits = value;
    }
            public Long getMasterPlanAssignDirective() {
        return masterPlanAssignDirective;
    }

    public void setMasterPlanAssignDirective(Long value) {
        this.masterPlanAssignDirective = value;
    }
            public UpdateAcctSuppFieldArray getUpdateAcctSuppField() {
        return updateAcctSuppField;
    }

    public void setUpdateAcctSuppField(UpdateAcctSuppFieldArray value) {
        this.updateAcctSuppField = value;
    }
            public UpdateAcctFuncGroupArray getUpdateAcctFuncGroup() {
        return updateAcctFuncGroup;
    }

    public void setUpdateAcctFuncGroup(UpdateAcctFuncGroupArray value) {
        this.updateAcctFuncGroup = value;
    }
            public UpdateAcctCollGroupArray getUpdateAcctCollGroup() {
        return updateAcctCollGroup;
    }

    public void setUpdateAcctCollGroup(UpdateAcctCollGroupArray value) {
        this.updateAcctCollGroup = value;
    }
            public Long getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Long value) {
        this.statusCd = value;
    }
            public Long getNotifyMethod() {
        return notifyMethod;
    }

    public void setNotifyMethod(Long value) {
        this.notifyMethod = value;
    }
            public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
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
            public String getPin() {
        return pin;
    }

    public void setPin(String value) {
        this.pin = value;
    }
            public Long getTestAcctInd() {
        return testAcctInd;
    }

    public void setTestAcctInd(Long value) {
        this.testAcctInd = value;
    }
            public Long getRespLevelCd() {
        return respLevelCd;
    }

    public void setRespLevelCd(Long value) {
        this.respLevelCd = value;
    }
            public Long getSeniorAcctNo() {
        return seniorAcctNo;
    }

    public void setSeniorAcctNo(Long value) {
        this.seniorAcctNo = value;
    }
            public String getSeniorAcctUserId() {
        return seniorAcctUserId;
    }

    public void setSeniorAcctUserId(String value) {
        this.seniorAcctUserId = value;
    }
            public String getClientSeniorAcctId() {
        return clientSeniorAcctId;
    }

    public void setClientSeniorAcctId(String value) {
        this.clientSeniorAcctId = value;
    }
            public String getClientAcctId() {
        return clientAcctId;
    }

    public void setClientAcctId(String value) {
        this.clientAcctId = value;
    }
            public String getDoCollect() {
        return doCollect;
    }

    public void setDoCollect(String value) {
        this.doCollect = value;
    }
            public String getChangeStatusAfterColl() {
        return changeStatusAfterColl;
    }

    public void setChangeStatusAfterColl(String value) {
        this.changeStatusAfterColl = value;
    }
            public String getResetDatesAfterStatus() {
        return resetDatesAfterStatus;
    }

    public void setResetDatesAfterStatus(String value) {
        this.resetDatesAfterStatus = value;
    }
            public String getClientReceiptId() {
        return clientReceiptId;
    }

    public void setClientReceiptId(String value) {
        this.clientReceiptId = value;
    }
            public String getAltDoDunning() {
        return altDoDunning;
    }

    public void setAltDoDunning(String value) {
        this.altDoDunning = value;
    }
            public String getForceCurrencyChange() {
        return forceCurrencyChange;
    }

    public void setForceCurrencyChange(String value) {
        this.forceCurrencyChange = value;
    }
            public String getCvv() {
        return cvv;
    }

    public void setCvv(String value) {
        this.cvv = value;
    }
            public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String value) {
        this.taxpayerId = value;
    }
            public String getBillAgreementId() {
        return billAgreementId;
    }

    public void setBillAgreementId(String value) {
        this.billAgreementId = value;
    }
            public String getAutoCancelSuppPlans() {
        return autoCancelSuppPlans;
    }

    public void setAutoCancelSuppPlans(String value) {
        this.autoCancelSuppPlans = value;
    }
            public Long getOffsetMonths() {
        return offsetMonths;
    }

    public void setOffsetMonths(Long value) {
        this.offsetMonths = value;
    }
            public String getAltProrationStartDate() {
        return altProrationStartDate;
    }

    public void setAltProrationStartDate(String value) {
        this.altProrationStartDate = value;
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
            public String getBankAcctType() {
        return bankAcctType;
    }

    public void setBankAcctType(String value) {
        this.bankAcctType = value;
    }
            public String getAddress3() {
        return address3;
    }

    public void setAddress3(String value) {
        this.address3 = value;
    }
            public String getBillAddress3() {
        return billAddress3;
    }

    public void setBillAddress3(String value) {
        this.billAddress3 = value;
    }
            public UsageAccumulationConfigArray getUsageAccumulationConfig() {
        return usageAccumulationConfig;
    }

    public void setUsageAccumulationConfig(UsageAccumulationConfigArray value) {
        this.usageAccumulationConfig = value;
    }
            public EnableUsagePoolingPlanNoArray getEnableUsagePoolingPlanNo() {
        return enableUsagePoolingPlanNo;
    }

    public void setEnableUsagePoolingPlanNo(EnableUsagePoolingPlanNoArray value) {
        this.enableUsagePoolingPlanNo = value;
    }
            public DisableUsagePoolingPlanNoArray getDisableUsagePoolingPlanNo() {
        return disableUsagePoolingPlanNo;
    }

    public void setDisableUsagePoolingPlanNo(DisableUsagePoolingPlanNoArray value) {
        this.disableUsagePoolingPlanNo = value;
    }
            public String getAltClientAcctGroupId() {
        return altClientAcctGroupId;
    }

    public void setAltClientAcctGroupId(String value) {
        this.altClientAcctGroupId = value;
    }
            public String getTrackData1() {
        return trackData1;
    }

    public void setTrackData1(String value) {
        this.trackData1 = value;
    }
            public String getTrackData2() {
        return trackData2;
    }

    public void setTrackData2(String value) {
        this.trackData2 = value;
    }
            public Long getOffsetInterval() {
        return offsetInterval;
    }

    public void setOffsetInterval(Long value) {
        this.offsetInterval = value;
    }
            public Long getTaxExemptionLevel() {
        return taxExemptionLevel;
    }

    public void setTaxExemptionLevel(Long value) {
        this.taxExemptionLevel = value;
    }
            public Long getCnAltMsgTemplateNo() {
        return cnAltMsgTemplateNo;
    }

    public void setCnAltMsgTemplateNo(Long value) {
        this.cnAltMsgTemplateNo = value;
    }
            public String getPromoCd() {
        return promoCd;
    }

    public void setPromoCd(String value) {
        this.promoCd = value;
    }
            public String getInvoiceUnbilledUsage() {
        return invoiceUnbilledUsage;
    }

    public void setInvoiceUnbilledUsage(String value) {
        this.invoiceUnbilledUsage = value;
    }
            public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String value) {
        this.couponCode = value;
    }
            public String getUserid() {
        return userid;
    }

    public void setUserid(String value) {
        this.userid = value;
    }
            public String getInvoiceApprovalRequired() {
        return invoiceApprovalRequired;
    }

    public void setInvoiceApprovalRequired(String value) {
        this.invoiceApprovalRequired = value;
    }
            public String getClientMasterPlanId() {
        return clientMasterPlanId;
    }

    public void setClientMasterPlanId(String value) {
        this.clientMasterPlanId = value;
    }
            public String getClientMpAltRateSchedId() {
        return clientMpAltRateSchedId;
    }

    public void setClientMpAltRateSchedId(String value) {
        this.clientMpAltRateSchedId = value;
    }
            public String getClientAltMsgTemplateId() {
        return clientAltMsgTemplateId;
    }

    public void setClientAltMsgTemplateId(String value) {
        this.clientAltMsgTemplateId = value;
    }
            public String getClientCnAltMsgTemplateId() {
        return clientCnAltMsgTemplateId;
    }

    public void setClientCnAltMsgTemplateId(String value) {
        this.clientCnAltMsgTemplateId = value;
    }
            public UpdateSurchargeArray getUpdateSurcharge() {
        return updateSurcharge;
    }

    public void setUpdateSurcharge(UpdateSurchargeArray value) {
        this.updateSurcharge = value;
    }
            public String getIban() {
        return iban;
    }

    public void setIban(String value) {
        this.iban = value;
    }
            public Long getBankCheckDigit() {
        return bankCheckDigit;
    }

    public void setBankCheckDigit(Long value) {
        this.bankCheckDigit = value;
    }
            public String getBankSwiftCd() {
        return bankSwiftCd;
    }

    public void setBankSwiftCd(String value) {
        this.bankSwiftCd = value;
    }
            public String getBankCountryCd() {
        return bankCountryCd;
    }

    public void setBankCountryCd(String value) {
        this.bankCountryCd = value;
    }
            public String getMandateId() {
        return mandateId;
    }

    public void setMandateId(String value) {
        this.mandateId = value;
    }
            public String getBankIdCd() {
        return bankIdCd;
    }

    public void setBankIdCd(String value) {
        this.bankIdCd = value;
    }
            public String getBankBranchCd() {
        return bankBranchCd;
    }

    public void setBankBranchCd(String value) {
        this.bankBranchCd = value;
    }
            public String getBkupBillFirstName() {
        return bkupBillFirstName;
    }

    public void setBkupBillFirstName(String value) {
        this.bkupBillFirstName = value;
    }
            public String getBkupBillMi() {
        return bkupBillMi;
    }

    public void setBkupBillMi(String value) {
        this.bkupBillMi = value;
    }
            public String getBkupBillLastName() {
        return bkupBillLastName;
    }

    public void setBkupBillLastName(String value) {
        this.bkupBillLastName = value;
    }
            public String getBkupBillCompanyName() {
        return bkupBillCompanyName;
    }

    public void setBkupBillCompanyName(String value) {
        this.bkupBillCompanyName = value;
    }
            public String getBkupBillAddress1() {
        return bkupBillAddress1;
    }

    public void setBkupBillAddress1(String value) {
        this.bkupBillAddress1 = value;
    }
            public String getBkupBillAddress2() {
        return bkupBillAddress2;
    }

    public void setBkupBillAddress2(String value) {
        this.bkupBillAddress2 = value;
    }
            public String getBkupBillAddress3() {
        return bkupBillAddress3;
    }

    public void setBkupBillAddress3(String value) {
        this.bkupBillAddress3 = value;
    }
            public String getBkupBillCity() {
        return bkupBillCity;
    }

    public void setBkupBillCity(String value) {
        this.bkupBillCity = value;
    }
            public String getBkupBillLocality() {
        return bkupBillLocality;
    }

    public void setBkupBillLocality(String value) {
        this.bkupBillLocality = value;
    }
            public String getBkupBillStateProv() {
        return bkupBillStateProv;
    }

    public void setBkupBillStateProv(String value) {
        this.bkupBillStateProv = value;
    }
            public String getBkupBillCountry() {
        return bkupBillCountry;
    }

    public void setBkupBillCountry(String value) {
        this.bkupBillCountry = value;
    }
            public String getBkupBillPostalCd() {
        return bkupBillPostalCd;
    }

    public void setBkupBillPostalCd(String value) {
        this.bkupBillPostalCd = value;
    }
            public String getBkupBillPhone() {
        return bkupBillPhone;
    }

    public void setBkupBillPhone(String value) {
        this.bkupBillPhone = value;
    }
            public String getBkupBillPhoneExt() {
        return bkupBillPhoneExt;
    }

    public void setBkupBillPhoneExt(String value) {
        this.bkupBillPhoneExt = value;
    }
            public String getBkupBillCellPhone() {
        return bkupBillCellPhone;
    }

    public void setBkupBillCellPhone(String value) {
        this.bkupBillCellPhone = value;
    }
            public String getBkupBillWorkPhone() {
        return bkupBillWorkPhone;
    }

    public void setBkupBillWorkPhone(String value) {
        this.bkupBillWorkPhone = value;
    }
            public String getBkupBillWorkPhoneExt() {
        return bkupBillWorkPhoneExt;
    }

    public void setBkupBillWorkPhoneExt(String value) {
        this.bkupBillWorkPhoneExt = value;
    }
            public String getBkupBillEmail() {
        return bkupBillEmail;
    }

    public void setBkupBillEmail(String value) {
        this.bkupBillEmail = value;
    }
            public Long getBkupPayMethod() {
        return bkupPayMethod;
    }

    public void setBkupPayMethod(Long value) {
        this.bkupPayMethod = value;
    }
            public String getBkupCcNumber() {
        return bkupCcNumber;
    }

    public void setBkupCcNumber(String value) {
        this.bkupCcNumber = value;
    }
            public Long getBkupCcExpireMm() {
        return bkupCcExpireMm;
    }

    public void setBkupCcExpireMm(Long value) {
        this.bkupCcExpireMm = value;
    }
            public Long getBkupCcExpireYyyy() {
        return bkupCcExpireYyyy;
    }

    public void setBkupCcExpireYyyy(Long value) {
        this.bkupCcExpireYyyy = value;
    }
            public String getBkupBankAcctNo() {
        return bkupBankAcctNo;
    }

    public void setBkupBankAcctNo(String value) {
        this.bkupBankAcctNo = value;
    }
            public String getBkupBankRoutingNo() {
        return bkupBankRoutingNo;
    }

    public void setBkupBankRoutingNo(String value) {
        this.bkupBankRoutingNo = value;
    }
            public String getBkupBankAcctType() {
        return bkupBankAcctType;
    }

    public void setBkupBankAcctType(String value) {
        this.bkupBankAcctType = value;
    }
            public String getBkupBillAgreementId() {
        return bkupBillAgreementId;
    }

    public void setBkupBillAgreementId(String value) {
        this.bkupBillAgreementId = value;
    }
            public String getBkupCvv() {
        return bkupCvv;
    }

    public void setBkupCvv(String value) {
        this.bkupCvv = value;
    }
            public String getSeqFuncGroupId() {
        return seqFuncGroupId;
    }

    public void setSeqFuncGroupId(String value) {
        this.seqFuncGroupId = value;
    }
            public Long getRevrecProfileId() {
        return revrecProfileId;
    }

    public void setRevrecProfileId(Long value) {
        this.revrecProfileId = value;
    }
            public String getRevrecClientDefinedId() {
        return revrecClientDefinedId;
    }

    public void setRevrecClientDefinedId(String value) {
        this.revrecClientDefinedId = value;
    }
            public String getStmntEmailList() {
        return stmntEmailList;
    }

    public void setStmntEmailList(String value) {
        this.stmntEmailList = value;
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
            
}
