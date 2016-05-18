package com.aria.common.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientNo",
    "authKey",    "doWrite",    "clientReceiptId",    "a1AltStartDate",    "a1ClientAcctId",    "a1Userid",    "a1StatusCd",    "a1MasterPlanNo",    "a1MasterPlanUnits",    "a1SuppPlans",    "a1SuppPlanUnits",    "a1NotifyMethod",    "a1PromoCd",    "a1Password",    "a1SecretQuestion",    "a1SecretQuestionAnswer",    "a1FirstName",    "a1Mi",    "a1LastName",    "a1CompanyName",    "a1Address1",    "a1Address2",    "a1City",    "a1Locality",    "a1StateProv",    "a1Country",    "a1PostalCd",    "a1Phone",    "a1PhoneExt",    "a1CellPhone",    "a1WorkPhone",    "a1WorkPhoneExt",    "a1Email",    "a1Birthdate",    "a1BillFirstName",    "a1BillMi",    "a1BillLastName",    "a1BillCompanyName",    "a1BillAddress1",    "a1BillAddress2",    "a1BillCity",    "a1BillLocality",    "a1BillStateProv",    "a1BillCountry",    "a1BillPostalCd",    "a1BillPhone",    "a1BillPhoneExt",    "a1BillCellPhone",    "a1BillWorkPhone",    "a1BillWorkPhoneExt",    "a1BillEmail",    "a1PayMethod",    "a1CcNumber",    "a1CcExpireMm",    "a1CcExpireYyyy",    "a1BankAcctNo",    "a1BankRoutingNo",    "a1RespLevelCd",    "a1FunctionalAcctGroups",    "a1CollectionsAcctGroups",    "a1SuppFieldNames",    "a1SuppFieldValues",    "a1TestAcctInd",    "a1StatusUntilAltStart",    "a1BalanceForward",    "a1AltBillDay",    "a1DoFullInvoicing",    "a1DoProratedInvoicing",    "a1MasterPlanAltRateSchedNo",    "a1SuppPlanAltRateSchedNo",    "a1CurrencyCd",    "a1Cvv",    "a1TaxpayerId",    "a1BillAgreementId",    "a1RetroactiveStartDate",    "a1CouponCodes",    "a1NewAcctCustomRates",    "a1AltMsgTemplateNo",    "a1SeqFuncGroupNo",    "a1NewAcctPlanContracts",    "a1BankAcctType",    "a1Address3",    "a1BillAddress3",    "a1UsageAccumulationConfig",    "a1EnableUsagePoolingPlanNo",    "a1ClientFuncAcctGroupIds",    "a1ClientCollAcctGroupIds",    "a1TrackData1",    "a1TrackData2",    "a1TaxExemptionLevel",    "a1CnAltMsgTemplateNo",    "a1InvoiceApprovalRequired",    "a1CreateSession",    "a1ClientMasterPlanId",    "a1ClientSuppPlanIds",    "a1ClientMpAltRateSchedId",    "a1ClientSpAltRateSchedIds",    "a1ClientAltMsgTemplateId",    "a1ClientCnAltMsgTemplateNo",    "a1Iban",    "a1BankCheckDigit",    "a1BankSwiftCd",    "a1BankCountryCd",    "a1MandateId",    "a1BankIdCd",    "a1BankBranchCd",    "a1SurchargeNo",    "a1BkupBillFirstName",    "a1BkupBillMi",    "a1BkupBillLastName",    "a1BkupBillCompanyName",    "a1BkupBillAddress1",    "a1BkupBillAddress2",    "a1BkupBillAddress3",    "a1BkupBillCity",    "a1BkupBillLocality",    "a1BkupBillStateProv",    "a1BkupBillCountry",    "a1BkupBillPostalCd",    "a1BkupBillPhone",    "a1BkupBillPhoneExt",    "a1BkupBillCellPhone",    "a1BkupBillWorkPhone",    "a1BkupBillWorkPhoneExt",    "a1BkupBillEmail",    "a1BkupPayMethod",    "a1BkupCcNumber",    "a1BkupCcExpireMm",    "a1BkupCcExpireYyyy",    "a1BkupBankAcctNo",    "a1BkupBankRoutingNo",    "a1BkupBankAcctType",    "a1BkupBillAgreementId",    "a1BkupCvv",    "a1SeqFuncGroupId",    "a1RevrecProfileId",    "a1RevrecClientDefinedId",    "a1StmntEmailListCc",    "a1StmntEmailListBcc",    "a1InvoicePostingMethodCd",    "a1AcctStartDate",    "a1MinStatementThreshold",    "a1MaxStatementsToDefer",    "a1DeferFullStatementsOnly",    "a1CcId",    "a1BkupCcId",    "a2AltStartDate",    "a2ClientAcctId",    "a2Userid",    "a2StatusCd",    "a2MasterPlanNo",    "a2MasterPlanUnits",    "a2SuppPlans",    "a2SuppPlanUnits",    "a2NotifyMethod",    "a2PromoCd",    "a2Password",    "a2SecretQuestion",    "a2SecretQuestionAnswer",    "a2FirstName",    "a2Mi",    "a2LastName",    "a2CompanyName",    "a2Address1",    "a2Address2",    "a2City",    "a2Locality",    "a2StateProv",    "a2Country",    "a2PostalCd",    "a2Phone",    "a2PhoneExt",    "a2CellPhone",    "a2WorkPhone",    "a2WorkPhoneExt",    "a2Email",    "a2Birthdate",    "a2BillFirstName",    "a2BillMi",    "a2BillLastName",    "a2BillCompanyName",    "a2BillAddress1",    "a2BillAddress2",    "a2BillCity",    "a2BillLocality",    "a2BillStateProv",    "a2BillCountry",    "a2BillPostalCd",    "a2BillPhone",    "a2BillPhoneExt",    "a2BillCellPhone",    "a2BillWorkPhone",    "a2BillWorkPhoneExt",    "a2BillEmail",    "a2PayMethod",    "a2CcNumber",    "a2CcExpireMm",    "a2CcExpireYyyy",    "a2BankAcctNo",    "a2BankRoutingNo",    "a2RespLevelCd",    "a2FunctionalAcctGroups",    "a2CollectionsAcctGroups",    "a2SuppFieldNames",    "a2SuppFieldValues",    "a2TestAcctInd",    "a2StatusUntilAltStart",    "a2BalanceForward",    "a2AltBillDay",    "a2DoFullInvoicing",    "a2DoProratedInvoicing",    "a2MasterPlanAltRateSchedNo",    "a2SuppPlanAltRateSchedNo",    "a2CurrencyCd",    "a2Cvv",    "a2TaxpayerId",    "a2BillAgreementId",    "a2RetroactiveStartDate",    "a2CouponCodes",    "a2NewAcctCustomRates",    "a2AltMsgTemplateNo",    "a2SeqFuncGroupNo",    "a2NewAcctPlanContracts",    "a2BankAcctType",    "a2Address3",    "a2BillAddress3",    "a2UsageAccumulationConfig",    "a2EnableUsagePoolingPlanNo",    "a2ClientFuncAcctGroupIds",    "a2ClientCollAcctGroupIds",    "a2TrackData1",    "a2TrackData2",    "a2TaxExemptionLevel",    "a2CnAltMsgTemplateNo",    "a2InvoiceApprovalRequired",    "a2CreateSession",    "a2ClientMasterPlanId",    "a2ClientSuppPlanIds",    "a2ClientMpAltRateSchedId",    "a2ClientSpAltRateSchedIds",    "a2ClientAltMsgTemplateId",    "a2ClientCnAltMsgTemplateNo",    "a2Iban",    "a2BankCheckDigit",    "a2BankSwiftCd",    "a2BankCountryCd",    "a2MandateId",    "a2BankIdCd",    "a2BankBranchCd",    "a2SurchargeNo",    "a2BkupBillFirstName",    "a2BkupBillMi",    "a2BkupBillLastName",    "a2BkupBillCompanyName",    "a2BkupBillAddress1",    "a2BkupBillAddress2",    "a2BkupBillAddress3",    "a2BkupBillCity",    "a2BkupBillLocality",    "a2BkupBillStateProv",    "a2BkupBillCountry",    "a2BkupBillPostalCd",    "a2BkupBillPhone",    "a2BkupBillPhoneExt",    "a2BkupBillCellPhone",    "a2BkupBillWorkPhone",    "a2BkupBillWorkPhoneExt",    "a2BkupBillEmail",    "a2BkupPayMethod",    "a2BkupCcNumber",    "a2BkupCcExpireMm",    "a2BkupCcExpireYyyy",    "a2BkupBankAcctNo",    "a2BkupBankRoutingNo",    "a2BkupBankAcctType",    "a2BkupBillAgreementId",    "a2BkupCvv",    "a2SeqFuncGroupId",    "a2RevrecProfileId",    "a2RevrecClientDefinedId",    "a2StmntEmailListCc",    "a2StmntEmailListBcc",    "a2InvoicePostingMethodCd",    "a2AcctStartDate",    "a2MinStatementThreshold",    "a2MaxStatementsToDefer",    "a2DeferFullStatementsOnly",    "a2CcId",    "a2BkupCcId",    "a3AltStartDate",    "a3ClientAcctId",    "a3Userid",    "a3StatusCd",    "a3MasterPlanNo",    "a3MasterPlanUnits",    "a3SuppPlans",    "a3SuppPlanUnits",    "a3NotifyMethod",    "a3PromoCd",    "a3Password",    "a3SecretQuestion",    "a3SecretQuestionAnswer",    "a3FirstName",    "a3Mi",    "a3LastName",    "a3CompanyName",    "a3Address1",    "a3Address2",    "a3City",    "a3Locality",    "a3StateProv",    "a3Country",    "a3PostalCd",    "a3Phone",    "a3PhoneExt",    "a3CellPhone",    "a3WorkPhone",    "a3WorkPhoneExt",    "a3Email",    "a3Birthdate",    "a3BillFirstName",    "a3BillMi",    "a3BillLastName",    "a3BillCompanyName",    "a3BillAddress1",    "a3BillAddress2",    "a3BillCity",    "a3BillLocality",    "a3BillStateProv",    "a3BillCountry",    "a3BillPostalCd",    "a3BillPhone",    "a3BillPhoneExt",    "a3BillCellPhone",    "a3BillWorkPhone",    "a3BillWorkPhoneExt",    "a3BillEmail",    "a3PayMethod",    "a3CcNumber",    "a3CcExpireMm",    "a3CcExpireYyyy",    "a3BankAcctNo",    "a3BankRoutingNo",    "a3RespLevelCd",    "a3FunctionalAcctGroups",    "a3CollectionsAcctGroups",    "a3SuppFieldNames",    "a3SuppFieldValues",    "a3TestAcctInd",    "a3StatusUntilAltStart",    "a3BalanceForward",    "a3AltBillDay",    "a3DoFullInvoicing",    "a3DoProratedInvoicing",    "a3MasterPlanAltRateSchedNo",    "a3SuppPlanAltRateSchedNo",    "a3CurrencyCd",    "a3Cvv",    "a3TaxpayerId",    "a3BillAgreementId",    "a3RetroactiveStartDate",    "a3CouponCodes",    "a3NewAcctCustomRates",    "a3AltMsgTemplateNo",    "a3SeqFuncGroupNo",    "a3NewAcctPlanContracts",    "a3BankAcctType",    "a3Address3",    "a3BillAddress3",    "a3UsageAccumulationConfig",    "a3EnableUsagePoolingPlanNo",    "a3ClientFuncAcctGroupIds",    "a3ClientCollAcctGroupIds",    "a3TrackData1",    "a3TrackData2",    "a3TaxExemptionLevel",    "a3CnAltMsgTemplateNo",    "a3InvoiceApprovalRequired",    "a3CreateSession",    "a3ClientMasterPlanId",    "a3ClientSuppPlanIds",    "a3ClientMpAltRateSchedId",    "a3ClientSpAltRateSchedIds",    "a3ClientAltMsgTemplateId",    "a3ClientCnAltMsgTemplateNo",    "a3Iban",    "a3BankCheckDigit",    "a3BankSwiftCd",    "a3BankCountryCd",    "a3MandateId",    "a3BankIdCd",    "a3BankBranchCd",    "a3SurchargeNo",    "a3BkupBillFirstName",    "a3BkupBillMi",    "a3BkupBillLastName",    "a3BkupBillCompanyName",    "a3BkupBillAddress1",    "a3BkupBillAddress2",    "a3BkupBillAddress3",    "a3BkupBillCity",    "a3BkupBillLocality",    "a3BkupBillStateProv",    "a3BkupBillCountry",    "a3BkupBillPostalCd",    "a3BkupBillPhone",    "a3BkupBillPhoneExt",    "a3BkupBillCellPhone",    "a3BkupBillWorkPhone",    "a3BkupBillWorkPhoneExt",    "a3BkupBillEmail",    "a3BkupPayMethod",    "a3BkupCcNumber",    "a3BkupCcExpireMm",    "a3BkupCcExpireYyyy",    "a3BkupBankAcctNo",    "a3BkupBankRoutingNo",    "a3BkupBankAcctType",    "a3BkupBillAgreementId",    "a3BkupCvv",    "a3SeqFuncGroupId",    "a3RevrecProfileId",    "a3RevrecClientDefinedId",    "a3StmntEmailListCc",    "a3StmntEmailListBcc",    "a3InvoicePostingMethodCd",    "a3AcctStartDate",    "a3MinStatementThreshold",    "a3MaxStatementsToDefer",    "a3DeferFullStatementsOnly",    "a3CcId",    "a3BkupCcId",    "a4AltStartDate",    "a4ClientAcctId",    "a4Userid",    "a4StatusCd",    "a4MasterPlanNo",    "a4MasterPlanUnits",    "a4SuppPlans",    "a4SuppPlanUnits",    "a4NotifyMethod",    "a4PromoCd",    "a4Password",    "a4SecretQuestion",    "a4SecretQuestionAnswer",    "a4FirstName",    "a4Mi",    "a4LastName",    "a4CompanyName",    "a4Address1",    "a4Address2",    "a4City",    "a4Locality",    "a4StateProv",    "a4Country",    "a4PostalCd",    "a4Phone",    "a4PhoneExt",    "a4CellPhone",    "a4WorkPhone",    "a4WorkPhoneExt",    "a4Email",    "a4Birthdate",    "a4BillFirstName",    "a4BillMi",    "a4BillLastName",    "a4BillCompanyName",    "a4BillAddress1",    "a4BillAddress2",    "a4BillCity",    "a4BillLocality",    "a4BillStateProv",    "a4BillCountry",    "a4BillPostalCd",    "a4BillPhone",    "a4BillPhoneExt",    "a4BillCellPhone",    "a4BillWorkPhone",    "a4BillWorkPhoneExt",    "a4BillEmail",    "a4PayMethod",    "a4CcNumber",    "a4CcExpireMm",    "a4CcExpireYyyy",    "a4BankAcctNo",    "a4BankRoutingNo",    "a4RespLevelCd",    "a4FunctionalAcctGroups",    "a4CollectionsAcctGroups",    "a4SuppFieldNames",    "a4SuppFieldValues",    "a4TestAcctInd",    "a4StatusUntilAltStart",    "a4BalanceForward",    "a4AltBillDay",    "a4DoFullInvoicing",    "a4DoProratedInvoicing",    "a4MasterPlanAltRateSchedNo",    "a4SuppPlanAltRateSchedNo",    "a4CurrencyCd",    "a4Cvv",    "a4TaxpayerId",    "a4BillAgreementId",    "a4RetroactiveStartDate",    "a4CouponCodes",    "a4NewAcctCustomRates",    "a4AltMsgTemplateNo",    "a4SeqFuncGroupNo",    "a4NewAcctPlanContracts",    "a4BankAcctType",    "a4Address3",    "a4BillAddress3",    "a4UsageAccumulationConfig",    "a4EnableUsagePoolingPlanNo",    "a4ClientFuncAcctGroupIds",    "a4ClientCollAcctGroupIds",    "a4TrackData1",    "a4TrackData2",    "a4TaxExemptionLevel",    "a4CnAltMsgTemplateNo",    "a4InvoiceApprovalRequired",    "a4CreateSession",    "a4ClientMasterPlanId",    "a4ClientSuppPlanIds",    "a4ClientMpAltRateSchedId",    "a4ClientSpAltRateSchedIds",    "a4ClientAltMsgTemplateId",    "a4ClientCnAltMsgTemplateNo",    "a4Iban",    "a4BankCheckDigit",    "a4BankSwiftCd",    "a4BankCountryCd",    "a4MandateId",    "a4BankIdCd",    "a4BankBranchCd",    "a4SurchargeNo",    "a4BkupBillFirstName",    "a4BkupBillMi",    "a4BkupBillLastName",    "a4BkupBillCompanyName",    "a4BkupBillAddress1",    "a4BkupBillAddress2",    "a4BkupBillAddress3",    "a4BkupBillCity",    "a4BkupBillLocality",    "a4BkupBillStateProv",    "a4BkupBillCountry",    "a4BkupBillPostalCd",    "a4BkupBillPhone",    "a4BkupBillPhoneExt",    "a4BkupBillCellPhone",    "a4BkupBillWorkPhone",    "a4BkupBillWorkPhoneExt",    "a4BkupBillEmail",    "a4BkupPayMethod",    "a4BkupCcNumber",    "a4BkupCcExpireMm",    "a4BkupCcExpireYyyy",    "a4BkupBankAcctNo",    "a4BkupBankRoutingNo",    "a4BkupBankAcctType",    "a4BkupBillAgreementId",    "a4BkupCvv",    "a4SeqFuncGroupId",    "a4RevrecProfileId",    "a4RevrecClientDefinedId",    "a4StmntEmailListCc",    "a4StmntEmailListBcc",    "a4InvoicePostingMethodCd",    "a4AcctStartDate",    "a4MinStatementThreshold",    "a4MaxStatementsToDefer",    "a4DeferFullStatementsOnly",    "a4CcId",    "a4BkupCcId",    "a5AltStartDate",    "a5ClientAcctId",    "a5Userid",    "a5StatusCd",    "a5MasterPlanNo",    "a5MasterPlanUnits",    "a5SuppPlans",    "a5SuppPlanUnits",    "a5NotifyMethod",    "a5PromoCd",    "a5Password",    "a5SecretQuestion",    "a5SecretQuestionAnswer",    "a5FirstName",    "a5Mi",    "a5LastName",    "a5CompanyName",    "a5Address1",    "a5Address2",    "a5City",    "a5Locality",    "a5StateProv",    "a5Country",    "a5PostalCd",    "a5Phone",    "a5PhoneExt",    "a5CellPhone",    "a5WorkPhone",    "a5WorkPhoneExt",    "a5Email",    "a5Birthdate",    "a5BillFirstName",    "a5BillMi",    "a5BillLastName",    "a5BillCompanyName",    "a5BillAddress1",    "a5BillAddress2",    "a5BillCity",    "a5BillLocality",    "a5BillStateProv",    "a5BillCountry",    "a5BillPostalCd",    "a5BillPhone",    "a5BillPhoneExt",    "a5BillCellPhone",    "a5BillWorkPhone",    "a5BillWorkPhoneExt",    "a5BillEmail",    "a5PayMethod",    "a5CcNumber",    "a5CcExpireMm",    "a5CcExpireYyyy",    "a5BankAcctNo",    "a5BankRoutingNo",    "a5RespLevelCd",    "a5FunctionalAcctGroups",    "a5CollectionsAcctGroups",    "a5SuppFieldNames",    "a5SuppFieldValues",    "a5TestAcctInd",    "a5StatusUntilAltStart",    "a5BalanceForward",    "a5AltBillDay",    "a5DoFullInvoicing",    "a5DoProratedInvoicing",    "a5MasterPlanAltRateSchedNo",    "a5SuppPlanAltRateSchedNo",    "a5CurrencyCd",    "a5Cvv",    "a5TaxpayerId",    "a5BillAgreementId",    "a5RetroactiveStartDate",    "a5CouponCodes",    "a5NewAcctCustomRates",    "a5AltMsgTemplateNo",    "a5SeqFuncGroupNo",    "a5NewAcctPlanContracts",    "a5BankAcctType",    "a5Address3",    "a5BillAddress3",    "a5UsageAccumulationConfig",    "a5EnableUsagePoolingPlanNo",    "a5ClientFuncAcctGroupIds",    "a5ClientCollAcctGroupIds",    "a5TrackData1",    "a5TrackData2",    "a5TaxExemptionLevel",    "a5CnAltMsgTemplateNo",    "a5InvoiceApprovalRequired",    "a5CreateSession",    "a5ClientMasterPlanId",    "a5ClientSuppPlanIds",    "a5ClientMpAltRateSchedId",    "a5ClientSpAltRateSchedIds",    "a5ClientAltMsgTemplateId",    "a5ClientCnAltMsgTemplateNo",    "a5Iban",    "a5BankCheckDigit",    "a5BankSwiftCd",    "a5BankCountryCd",    "a5MandateId",    "a5BankIdCd",    "a5BankBranchCd",    "a5SurchargeNo",    "a5BkupBillFirstName",    "a5BkupBillMi",    "a5BkupBillLastName",    "a5BkupBillCompanyName",    "a5BkupBillAddress1",    "a5BkupBillAddress2",    "a5BkupBillAddress3",    "a5BkupBillCity",    "a5BkupBillLocality",    "a5BkupBillStateProv",    "a5BkupBillCountry",    "a5BkupBillPostalCd",    "a5BkupBillPhone",    "a5BkupBillPhoneExt",    "a5BkupBillCellPhone",    "a5BkupBillWorkPhone",    "a5BkupBillWorkPhoneExt",    "a5BkupBillEmail",    "a5BkupPayMethod",    "a5BkupCcNumber",    "a5BkupCcExpireMm",    "a5BkupCcExpireYyyy",    "a5BkupBankAcctNo",    "a5BkupBankRoutingNo",    "a5BkupBankAcctType",    "a5BkupBillAgreementId",    "a5BkupCvv",    "a5SeqFuncGroupId",    "a5RevrecProfileId",    "a5RevrecClientDefinedId",    "a5StmntEmailListCc",    "a5StmntEmailListBcc",    "a5InvoicePostingMethodCd",    "a5AcctStartDate",    "a5MinStatementThreshold",    "a5MaxStatementsToDefer",    "a5DeferFullStatementsOnly",    "a5CcId",    "a5BkupCcId"})
@XmlRootElement(name = "create_acct_hierarchy")
public class CreateAcctHierarchy {

    @XmlElement(name = "client_no")
    protected Long clientNo;
    @XmlElement(name = "auth_key")
    protected String authKey;
        @XmlElement(name = "do_write")
    protected String doWrite;
        @XmlElement(name = "client_receipt_id")
    protected String clientReceiptId;
        @XmlElement(name = "a1_alt_start_date")
    protected String a1AltStartDate;
        @XmlElement(name = "a1_client_acct_id")
    protected String a1ClientAcctId;
        @XmlElement(name = "a1_userid")
    protected String a1Userid;
        @XmlElement(name = "a1_status_cd")
    protected Long a1StatusCd;
        @XmlElement(name = "a1_master_plan_no")
    protected Long a1MasterPlanNo;
        @XmlElement(name = "a1_master_plan_units")
    protected Long a1MasterPlanUnits;
        @XmlElement(name = "a1_supp_plans")
    protected A1SuppPlansArray a1SuppPlans;
        @XmlElement(name = "a1_supp_plan_units")
    protected A1SuppPlanUnitsArray a1SuppPlanUnits;
        @XmlElement(name = "a1_notify_method")
    protected Long a1NotifyMethod;
        @XmlElement(name = "a1_promo_cd")
    protected String a1PromoCd;
        @XmlElement(name = "a1_password")
    protected String a1Password;
        @XmlElement(name = "a1_secret_question")
    protected String a1SecretQuestion;
        @XmlElement(name = "a1_secret_question_answer")
    protected String a1SecretQuestionAnswer;
        @XmlElement(name = "a1_first_name")
    protected String a1FirstName;
        @XmlElement(name = "a1_mi")
    protected String a1Mi;
        @XmlElement(name = "a1_last_name")
    protected String a1LastName;
        @XmlElement(name = "a1_company_name")
    protected String a1CompanyName;
        @XmlElement(name = "a1_address1")
    protected String a1Address1;
        @XmlElement(name = "a1_address2")
    protected String a1Address2;
        @XmlElement(name = "a1_city")
    protected String a1City;
        @XmlElement(name = "a1_locality")
    protected String a1Locality;
        @XmlElement(name = "a1_state_prov")
    protected String a1StateProv;
        @XmlElement(name = "a1_country")
    protected String a1Country;
        @XmlElement(name = "a1_postal_cd")
    protected String a1PostalCd;
        @XmlElement(name = "a1_phone")
    protected String a1Phone;
        @XmlElement(name = "a1_phone_ext")
    protected String a1PhoneExt;
        @XmlElement(name = "a1_cell_phone")
    protected String a1CellPhone;
        @XmlElement(name = "a1_work_phone")
    protected String a1WorkPhone;
        @XmlElement(name = "a1_work_phone_ext")
    protected String a1WorkPhoneExt;
        @XmlElement(name = "a1_email")
    protected String a1Email;
        @XmlElement(name = "a1_birthdate")
    protected String a1Birthdate;
        @XmlElement(name = "a1_bill_first_name")
    protected String a1BillFirstName;
        @XmlElement(name = "a1_bill_mi")
    protected String a1BillMi;
        @XmlElement(name = "a1_bill_last_name")
    protected String a1BillLastName;
        @XmlElement(name = "a1_bill_company_name")
    protected String a1BillCompanyName;
        @XmlElement(name = "a1_bill_address1")
    protected String a1BillAddress1;
        @XmlElement(name = "a1_bill_address2")
    protected String a1BillAddress2;
        @XmlElement(name = "a1_bill_city")
    protected String a1BillCity;
        @XmlElement(name = "a1_bill_locality")
    protected String a1BillLocality;
        @XmlElement(name = "a1_bill_state_prov")
    protected String a1BillStateProv;
        @XmlElement(name = "a1_bill_country")
    protected String a1BillCountry;
        @XmlElement(name = "a1_bill_postal_cd")
    protected String a1BillPostalCd;
        @XmlElement(name = "a1_bill_phone")
    protected String a1BillPhone;
        @XmlElement(name = "a1_bill_phone_ext")
    protected String a1BillPhoneExt;
        @XmlElement(name = "a1_bill_cell_phone")
    protected String a1BillCellPhone;
        @XmlElement(name = "a1_bill_work_phone")
    protected String a1BillWorkPhone;
        @XmlElement(name = "a1_bill_work_phone_ext")
    protected String a1BillWorkPhoneExt;
        @XmlElement(name = "a1_bill_email")
    protected String a1BillEmail;
        @XmlElement(name = "a1_pay_method")
    protected Long a1PayMethod;
        @XmlElement(name = "a1_cc_number")
    protected String a1CcNumber;
        @XmlElement(name = "a1_cc_expire_mm")
    protected Long a1CcExpireMm;
        @XmlElement(name = "a1_cc_expire_yyyy")
    protected Long a1CcExpireYyyy;
        @XmlElement(name = "a1_bank_acct_no")
    protected String a1BankAcctNo;
        @XmlElement(name = "a1_bank_routing_no")
    protected String a1BankRoutingNo;
        @XmlElement(name = "a1_resp_level_cd")
    protected Long a1RespLevelCd;
        @XmlElement(name = "a1_functional_acct_groups")
    protected A1FunctionalAcctGroupsArray a1FunctionalAcctGroups;
        @XmlElement(name = "a1_collections_acct_groups")
    protected A1CollectionsAcctGroupsArray a1CollectionsAcctGroups;
        @XmlElement(name = "a1_supp_field_names")
    protected A1SuppFieldNamesArray a1SuppFieldNames;
        @XmlElement(name = "a1_supp_field_values")
    protected A1SuppFieldValuesArray a1SuppFieldValues;
        @XmlElement(name = "a1_test_acct_ind")
    protected Long a1TestAcctInd;
        @XmlElement(name = "a1_status_until_alt_start")
    protected Long a1StatusUntilAltStart;
        @XmlElement(name = "a1_balance_forward")
    protected Double a1BalanceForward;
        @XmlElement(name = "a1_alt_bill_day")
    protected Long a1AltBillDay;
        @XmlElement(name = "a1_do_full_invoicing")
    protected String a1DoFullInvoicing;
        @XmlElement(name = "a1_do_prorated_invoicing")
    protected String a1DoProratedInvoicing;
        @XmlElement(name = "a1_master_plan_alt_rate_sched_no")
    protected Long a1MasterPlanAltRateSchedNo;
        @XmlElement(name = "a1_supp_plan_alt_rate_sched_no")
    protected A1SuppPlanAltRateSchedNoArray a1SuppPlanAltRateSchedNo;
        @XmlElement(name = "a1_currency_cd")
    protected String a1CurrencyCd;
        @XmlElement(name = "a1_cvv")
    protected String a1Cvv;
        @XmlElement(name = "a1_taxpayer_id")
    protected String a1TaxpayerId;
        @XmlElement(name = "a1_bill_agreement_id")
    protected String a1BillAgreementId;
        @XmlElement(name = "a1_retroactive_start_date")
    protected String a1RetroactiveStartDate;
        @XmlElement(name = "a1_coupon_codes")
    protected A1CouponCodesArray a1CouponCodes;
        @XmlElement(name = "a1_new_acct_custom_rates")
    protected A1NewAcctCustomRatesArray a1NewAcctCustomRates;
        @XmlElement(name = "a1_alt_msg_template_no")
    protected Long a1AltMsgTemplateNo;
        @XmlElement(name = "a1_seq_func_group_no")
    protected Long a1SeqFuncGroupNo;
        @XmlElement(name = "a1_new_acct_plan_contracts")
    protected A1NewAcctPlanContractsArray a1NewAcctPlanContracts;
        @XmlElement(name = "a1_bank_acct_type")
    protected String a1BankAcctType;
        @XmlElement(name = "a1_address3")
    protected String a1Address3;
        @XmlElement(name = "a1_bill_address3")
    protected String a1BillAddress3;
        @XmlElement(name = "a1_usage_accumulation_config")
    protected A1UsageAccumulationConfigArray a1UsageAccumulationConfig;
        @XmlElement(name = "a1_enable_usage_pooling_plan_no")
    protected A1EnableUsagePoolingPlanNoArray a1EnableUsagePoolingPlanNo;
        @XmlElement(name = "a1_client_func_acct_group_ids")
    protected A1ClientFuncAcctGroupIdsArray a1ClientFuncAcctGroupIds;
        @XmlElement(name = "a1_client_coll_acct_group_ids")
    protected A1ClientCollAcctGroupIdsArray a1ClientCollAcctGroupIds;
        @XmlElement(name = "a1_track_data1")
    protected String a1TrackData1;
        @XmlElement(name = "a1_track_data2")
    protected String a1TrackData2;
        @XmlElement(name = "a1_tax_exemption_level")
    protected Long a1TaxExemptionLevel;
        @XmlElement(name = "a1_cn_alt_msg_template_no")
    protected Long a1CnAltMsgTemplateNo;
        @XmlElement(name = "a1_invoice_approval_required")
    protected String a1InvoiceApprovalRequired;
        @XmlElement(name = "a1_create_session")
    protected String a1CreateSession;
        @XmlElement(name = "a1_client_master_plan_id")
    protected String a1ClientMasterPlanId;
        @XmlElement(name = "a1_client_supp_plan_ids")
    protected A1ClientSuppPlanIdsArray a1ClientSuppPlanIds;
        @XmlElement(name = "a1_client_mp_alt_rate_sched_id")
    protected String a1ClientMpAltRateSchedId;
        @XmlElement(name = "a1_client_sp_alt_rate_sched_ids")
    protected A1ClientSpAltRateSchedIdsArray a1ClientSpAltRateSchedIds;
        @XmlElement(name = "a1_client_alt_msg_template_id")
    protected String a1ClientAltMsgTemplateId;
        @XmlElement(name = "a1_client_cn_alt_msg_template_no")
    protected String a1ClientCnAltMsgTemplateNo;
        @XmlElement(name = "a1_iban")
    protected String a1Iban;
        @XmlElement(name = "a1_bank_check_digit")
    protected Long a1BankCheckDigit;
        @XmlElement(name = "a1_bank_swift_cd")
    protected String a1BankSwiftCd;
        @XmlElement(name = "a1_bank_country_cd")
    protected String a1BankCountryCd;
        @XmlElement(name = "a1_mandate_id")
    protected String a1MandateId;
        @XmlElement(name = "a1_bank_id_cd")
    protected String a1BankIdCd;
        @XmlElement(name = "a1_bank_branch_cd")
    protected String a1BankBranchCd;
        @XmlElement(name = "a1_surcharge_no")
    protected A1SurchargeNoArray a1SurchargeNo;
        @XmlElement(name = "a1_bkup_bill_first_name")
    protected String a1BkupBillFirstName;
        @XmlElement(name = "a1_bkup_bill_mi")
    protected String a1BkupBillMi;
        @XmlElement(name = "a1_bkup_bill_last_name")
    protected String a1BkupBillLastName;
        @XmlElement(name = "a1_bkup_bill_company_name")
    protected String a1BkupBillCompanyName;
        @XmlElement(name = "a1_bkup_bill_address1")
    protected String a1BkupBillAddress1;
        @XmlElement(name = "a1_bkup_bill_address2")
    protected String a1BkupBillAddress2;
        @XmlElement(name = "a1_bkup_bill_address3")
    protected String a1BkupBillAddress3;
        @XmlElement(name = "a1_bkup_bill_city")
    protected String a1BkupBillCity;
        @XmlElement(name = "a1_bkup_bill_locality")
    protected String a1BkupBillLocality;
        @XmlElement(name = "a1_bkup_bill_state_prov")
    protected String a1BkupBillStateProv;
        @XmlElement(name = "a1_bkup_bill_country")
    protected String a1BkupBillCountry;
        @XmlElement(name = "a1_bkup_bill_postal_cd")
    protected String a1BkupBillPostalCd;
        @XmlElement(name = "a1_bkup_bill_phone")
    protected String a1BkupBillPhone;
        @XmlElement(name = "a1_bkup_bill_phone_ext")
    protected String a1BkupBillPhoneExt;
        @XmlElement(name = "a1_bkup_bill_cell_phone")
    protected String a1BkupBillCellPhone;
        @XmlElement(name = "a1_bkup_bill_work_phone")
    protected String a1BkupBillWorkPhone;
        @XmlElement(name = "a1_bkup_bill_work_phone_ext")
    protected String a1BkupBillWorkPhoneExt;
        @XmlElement(name = "a1_bkup_bill_email")
    protected String a1BkupBillEmail;
        @XmlElement(name = "a1_bkup_pay_method")
    protected Long a1BkupPayMethod;
        @XmlElement(name = "a1_bkup_cc_number")
    protected String a1BkupCcNumber;
        @XmlElement(name = "a1_bkup_cc_expire_mm")
    protected Long a1BkupCcExpireMm;
        @XmlElement(name = "a1_bkup_cc_expire_yyyy")
    protected Long a1BkupCcExpireYyyy;
        @XmlElement(name = "a1_bkup_bank_acct_no")
    protected String a1BkupBankAcctNo;
        @XmlElement(name = "a1_bkup_bank_routing_no")
    protected String a1BkupBankRoutingNo;
        @XmlElement(name = "a1_bkup_bank_acct_type")
    protected String a1BkupBankAcctType;
        @XmlElement(name = "a1_bkup_bill_agreement_id")
    protected String a1BkupBillAgreementId;
        @XmlElement(name = "a1_bkup_cvv")
    protected String a1BkupCvv;
        @XmlElement(name = "a1_seq_func_group_id")
    protected String a1SeqFuncGroupId;
        @XmlElement(name = "a1_revrec_profile_id")
    protected Long a1RevrecProfileId;
        @XmlElement(name = "a1_revrec_client_defined_id")
    protected String a1RevrecClientDefinedId;
        @XmlElement(name = "a1_stmnt_email_list_cc")
    protected String a1StmntEmailListCc;
        @XmlElement(name = "a1_stmnt_email_list_bcc")
    protected String a1StmntEmailListBcc;
        @XmlElement(name = "a1_invoice_posting_method_cd")
    protected Long a1InvoicePostingMethodCd;
        @XmlElement(name = "a1_acct_start_date")
    protected String a1AcctStartDate;
        @XmlElement(name = "a1_min_statement_threshold")
    protected Long a1MinStatementThreshold;
        @XmlElement(name = "a1_max_statements_to_defer")
    protected Long a1MaxStatementsToDefer;
        @XmlElement(name = "a1_defer_full_statements_only")
    protected Long a1DeferFullStatementsOnly;
        @XmlElement(name = "a1_cc_id")
    protected Long a1CcId;
        @XmlElement(name = "a1_bkup_cc_id")
    protected Long a1BkupCcId;
        @XmlElement(name = "a2_alt_start_date")
    protected String a2AltStartDate;
        @XmlElement(name = "a2_client_acct_id")
    protected String a2ClientAcctId;
        @XmlElement(name = "a2_userid")
    protected String a2Userid;
        @XmlElement(name = "a2_status_cd")
    protected Long a2StatusCd;
        @XmlElement(name = "a2_master_plan_no")
    protected Long a2MasterPlanNo;
        @XmlElement(name = "a2_master_plan_units")
    protected Long a2MasterPlanUnits;
        @XmlElement(name = "a2_supp_plans")
    protected A2SuppPlansArray a2SuppPlans;
        @XmlElement(name = "a2_supp_plan_units")
    protected A2SuppPlanUnitsArray a2SuppPlanUnits;
        @XmlElement(name = "a2_notify_method")
    protected Long a2NotifyMethod;
        @XmlElement(name = "a2_promo_cd")
    protected String a2PromoCd;
        @XmlElement(name = "a2_password")
    protected String a2Password;
        @XmlElement(name = "a2_secret_question")
    protected String a2SecretQuestion;
        @XmlElement(name = "a2_secret_question_answer")
    protected String a2SecretQuestionAnswer;
        @XmlElement(name = "a2_first_name")
    protected String a2FirstName;
        @XmlElement(name = "a2_mi")
    protected String a2Mi;
        @XmlElement(name = "a2_last_name")
    protected String a2LastName;
        @XmlElement(name = "a2_company_name")
    protected String a2CompanyName;
        @XmlElement(name = "a2_address1")
    protected String a2Address1;
        @XmlElement(name = "a2_address2")
    protected String a2Address2;
        @XmlElement(name = "a2_city")
    protected String a2City;
        @XmlElement(name = "a2_locality")
    protected String a2Locality;
        @XmlElement(name = "a2_state_prov")
    protected String a2StateProv;
        @XmlElement(name = "a2_country")
    protected String a2Country;
        @XmlElement(name = "a2_postal_cd")
    protected String a2PostalCd;
        @XmlElement(name = "a2_phone")
    protected String a2Phone;
        @XmlElement(name = "a2_phone_ext")
    protected String a2PhoneExt;
        @XmlElement(name = "a2_cell_phone")
    protected String a2CellPhone;
        @XmlElement(name = "a2_work_phone")
    protected String a2WorkPhone;
        @XmlElement(name = "a2_work_phone_ext")
    protected String a2WorkPhoneExt;
        @XmlElement(name = "a2_email")
    protected String a2Email;
        @XmlElement(name = "a2_birthdate")
    protected String a2Birthdate;
        @XmlElement(name = "a2_bill_first_name")
    protected String a2BillFirstName;
        @XmlElement(name = "a2_bill_mi")
    protected String a2BillMi;
        @XmlElement(name = "a2_bill_last_name")
    protected String a2BillLastName;
        @XmlElement(name = "a2_bill_company_name")
    protected String a2BillCompanyName;
        @XmlElement(name = "a2_bill_address1")
    protected String a2BillAddress1;
        @XmlElement(name = "a2_bill_address2")
    protected String a2BillAddress2;
        @XmlElement(name = "a2_bill_city")
    protected String a2BillCity;
        @XmlElement(name = "a2_bill_locality")
    protected String a2BillLocality;
        @XmlElement(name = "a2_bill_state_prov")
    protected String a2BillStateProv;
        @XmlElement(name = "a2_bill_country")
    protected String a2BillCountry;
        @XmlElement(name = "a2_bill_postal_cd")
    protected String a2BillPostalCd;
        @XmlElement(name = "a2_bill_phone")
    protected String a2BillPhone;
        @XmlElement(name = "a2_bill_phone_ext")
    protected String a2BillPhoneExt;
        @XmlElement(name = "a2_bill_cell_phone")
    protected String a2BillCellPhone;
        @XmlElement(name = "a2_bill_work_phone")
    protected String a2BillWorkPhone;
        @XmlElement(name = "a2_bill_work_phone_ext")
    protected String a2BillWorkPhoneExt;
        @XmlElement(name = "a2_bill_email")
    protected String a2BillEmail;
        @XmlElement(name = "a2_pay_method")
    protected Long a2PayMethod;
        @XmlElement(name = "a2_cc_number")
    protected String a2CcNumber;
        @XmlElement(name = "a2_cc_expire_mm")
    protected Long a2CcExpireMm;
        @XmlElement(name = "a2_cc_expire_yyyy")
    protected Long a2CcExpireYyyy;
        @XmlElement(name = "a2_bank_acct_no")
    protected String a2BankAcctNo;
        @XmlElement(name = "a2_bank_routing_no")
    protected String a2BankRoutingNo;
        @XmlElement(name = "a2_resp_level_cd")
    protected Long a2RespLevelCd;
        @XmlElement(name = "a2_functional_acct_groups")
    protected A2FunctionalAcctGroupsArray a2FunctionalAcctGroups;
        @XmlElement(name = "a2_collections_acct_groups")
    protected A2CollectionsAcctGroupsArray a2CollectionsAcctGroups;
        @XmlElement(name = "a2_supp_field_names")
    protected A2SuppFieldNamesArray a2SuppFieldNames;
        @XmlElement(name = "a2_supp_field_values")
    protected A2SuppFieldValuesArray a2SuppFieldValues;
        @XmlElement(name = "a2_test_acct_ind")
    protected Long a2TestAcctInd;
        @XmlElement(name = "a2_status_until_alt_start")
    protected Long a2StatusUntilAltStart;
        @XmlElement(name = "a2_balance_forward")
    protected Double a2BalanceForward;
        @XmlElement(name = "a2_alt_bill_day")
    protected Long a2AltBillDay;
        @XmlElement(name = "a2_do_full_invoicing")
    protected String a2DoFullInvoicing;
        @XmlElement(name = "a2_do_prorated_invoicing")
    protected String a2DoProratedInvoicing;
        @XmlElement(name = "a2_master_plan_alt_rate_sched_no")
    protected Long a2MasterPlanAltRateSchedNo;
        @XmlElement(name = "a2_supp_plan_alt_rate_sched_no")
    protected A2SuppPlanAltRateSchedNoArray a2SuppPlanAltRateSchedNo;
        @XmlElement(name = "a2_currency_cd")
    protected String a2CurrencyCd;
        @XmlElement(name = "a2_cvv")
    protected String a2Cvv;
        @XmlElement(name = "a2_taxpayer_id")
    protected String a2TaxpayerId;
        @XmlElement(name = "a2_bill_agreement_id")
    protected String a2BillAgreementId;
        @XmlElement(name = "a2_retroactive_start_date")
    protected String a2RetroactiveStartDate;
        @XmlElement(name = "a2_coupon_codes")
    protected A2CouponCodesArray a2CouponCodes;
        @XmlElement(name = "a2_new_acct_custom_rates")
    protected A2NewAcctCustomRatesArray a2NewAcctCustomRates;
        @XmlElement(name = "a2_alt_msg_template_no")
    protected Long a2AltMsgTemplateNo;
        @XmlElement(name = "a2_seq_func_group_no")
    protected Long a2SeqFuncGroupNo;
        @XmlElement(name = "a2_new_acct_plan_contracts")
    protected A2NewAcctPlanContractsArray a2NewAcctPlanContracts;
        @XmlElement(name = "a2_bank_acct_type")
    protected String a2BankAcctType;
        @XmlElement(name = "a2_address3")
    protected String a2Address3;
        @XmlElement(name = "a2_bill_address3")
    protected String a2BillAddress3;
        @XmlElement(name = "a2_usage_accumulation_config")
    protected A2UsageAccumulationConfigArray a2UsageAccumulationConfig;
        @XmlElement(name = "a2_enable_usage_pooling_plan_no")
    protected A2EnableUsagePoolingPlanNoArray a2EnableUsagePoolingPlanNo;
        @XmlElement(name = "a2_client_func_acct_group_ids")
    protected A2ClientFuncAcctGroupIdsArray a2ClientFuncAcctGroupIds;
        @XmlElement(name = "a2_client_coll_acct_group_ids")
    protected A2ClientCollAcctGroupIdsArray a2ClientCollAcctGroupIds;
        @XmlElement(name = "a2_track_data1")
    protected String a2TrackData1;
        @XmlElement(name = "a2_track_data2")
    protected String a2TrackData2;
        @XmlElement(name = "a2_tax_exemption_level")
    protected Long a2TaxExemptionLevel;
        @XmlElement(name = "a2_cn_alt_msg_template_no")
    protected Long a2CnAltMsgTemplateNo;
        @XmlElement(name = "a2_invoice_approval_required")
    protected String a2InvoiceApprovalRequired;
        @XmlElement(name = "a2_create_session")
    protected String a2CreateSession;
        @XmlElement(name = "a2_client_master_plan_id")
    protected String a2ClientMasterPlanId;
        @XmlElement(name = "a2_client_supp_plan_ids")
    protected A2ClientSuppPlanIdsArray a2ClientSuppPlanIds;
        @XmlElement(name = "a2_client_mp_alt_rate_sched_id")
    protected String a2ClientMpAltRateSchedId;
        @XmlElement(name = "a2_client_sp_alt_rate_sched_ids")
    protected A2ClientSpAltRateSchedIdsArray a2ClientSpAltRateSchedIds;
        @XmlElement(name = "a2_client_alt_msg_template_id")
    protected String a2ClientAltMsgTemplateId;
        @XmlElement(name = "a2_client_cn_alt_msg_template_no")
    protected String a2ClientCnAltMsgTemplateNo;
        @XmlElement(name = "a2_iban")
    protected String a2Iban;
        @XmlElement(name = "a2_bank_check_digit")
    protected Long a2BankCheckDigit;
        @XmlElement(name = "a2_bank_swift_cd")
    protected String a2BankSwiftCd;
        @XmlElement(name = "a2_bank_country_cd")
    protected String a2BankCountryCd;
        @XmlElement(name = "a2_mandate_id")
    protected String a2MandateId;
        @XmlElement(name = "a2_bank_id_cd")
    protected String a2BankIdCd;
        @XmlElement(name = "a2_bank_branch_cd")
    protected String a2BankBranchCd;
        @XmlElement(name = "a2_surcharge_no")
    protected A2SurchargeNoArray a2SurchargeNo;
        @XmlElement(name = "a2_bkup_bill_first_name")
    protected String a2BkupBillFirstName;
        @XmlElement(name = "a2_bkup_bill_mi")
    protected String a2BkupBillMi;
        @XmlElement(name = "a2_bkup_bill_last_name")
    protected String a2BkupBillLastName;
        @XmlElement(name = "a2_bkup_bill_company_name")
    protected String a2BkupBillCompanyName;
        @XmlElement(name = "a2_bkup_bill_address1")
    protected String a2BkupBillAddress1;
        @XmlElement(name = "a2_bkup_bill_address2")
    protected String a2BkupBillAddress2;
        @XmlElement(name = "a2_bkup_bill_address3")
    protected String a2BkupBillAddress3;
        @XmlElement(name = "a2_bkup_bill_city")
    protected String a2BkupBillCity;
        @XmlElement(name = "a2_bkup_bill_locality")
    protected String a2BkupBillLocality;
        @XmlElement(name = "a2_bkup_bill_state_prov")
    protected String a2BkupBillStateProv;
        @XmlElement(name = "a2_bkup_bill_country")
    protected String a2BkupBillCountry;
        @XmlElement(name = "a2_bkup_bill_postal_cd")
    protected String a2BkupBillPostalCd;
        @XmlElement(name = "a2_bkup_bill_phone")
    protected String a2BkupBillPhone;
        @XmlElement(name = "a2_bkup_bill_phone_ext")
    protected String a2BkupBillPhoneExt;
        @XmlElement(name = "a2_bkup_bill_cell_phone")
    protected String a2BkupBillCellPhone;
        @XmlElement(name = "a2_bkup_bill_work_phone")
    protected String a2BkupBillWorkPhone;
        @XmlElement(name = "a2_bkup_bill_work_phone_ext")
    protected String a2BkupBillWorkPhoneExt;
        @XmlElement(name = "a2_bkup_bill_email")
    protected String a2BkupBillEmail;
        @XmlElement(name = "a2_bkup_pay_method")
    protected Long a2BkupPayMethod;
        @XmlElement(name = "a2_bkup_cc_number")
    protected String a2BkupCcNumber;
        @XmlElement(name = "a2_bkup_cc_expire_mm")
    protected Long a2BkupCcExpireMm;
        @XmlElement(name = "a2_bkup_cc_expire_yyyy")
    protected Long a2BkupCcExpireYyyy;
        @XmlElement(name = "a2_bkup_bank_acct_no")
    protected String a2BkupBankAcctNo;
        @XmlElement(name = "a2_bkup_bank_routing_no")
    protected String a2BkupBankRoutingNo;
        @XmlElement(name = "a2_bkup_bank_acct_type")
    protected String a2BkupBankAcctType;
        @XmlElement(name = "a2_bkup_bill_agreement_id")
    protected String a2BkupBillAgreementId;
        @XmlElement(name = "a2_bkup_cvv")
    protected String a2BkupCvv;
        @XmlElement(name = "a2_seq_func_group_id")
    protected String a2SeqFuncGroupId;
        @XmlElement(name = "a2_revrec_profile_id")
    protected Long a2RevrecProfileId;
        @XmlElement(name = "a2_revrec_client_defined_id")
    protected String a2RevrecClientDefinedId;
        @XmlElement(name = "a2_stmnt_email_list_cc")
    protected String a2StmntEmailListCc;
        @XmlElement(name = "a2_stmnt_email_list_bcc")
    protected String a2StmntEmailListBcc;
        @XmlElement(name = "a2_invoice_posting_method_cd")
    protected Long a2InvoicePostingMethodCd;
        @XmlElement(name = "a2_acct_start_date")
    protected String a2AcctStartDate;
        @XmlElement(name = "a2_min_statement_threshold")
    protected Long a2MinStatementThreshold;
        @XmlElement(name = "a2_max_statements_to_defer")
    protected Long a2MaxStatementsToDefer;
        @XmlElement(name = "a2_defer_full_statements_only")
    protected Long a2DeferFullStatementsOnly;
        @XmlElement(name = "a2_cc_id")
    protected Long a2CcId;
        @XmlElement(name = "a2_bkup_cc_id")
    protected Long a2BkupCcId;
        @XmlElement(name = "a3_alt_start_date")
    protected String a3AltStartDate;
        @XmlElement(name = "a3_client_acct_id")
    protected String a3ClientAcctId;
        @XmlElement(name = "a3_userid")
    protected String a3Userid;
        @XmlElement(name = "a3_status_cd")
    protected Long a3StatusCd;
        @XmlElement(name = "a3_master_plan_no")
    protected Long a3MasterPlanNo;
        @XmlElement(name = "a3_master_plan_units")
    protected Long a3MasterPlanUnits;
        @XmlElement(name = "a3_supp_plans")
    protected A3SuppPlansArray a3SuppPlans;
        @XmlElement(name = "a3_supp_plan_units")
    protected A3SuppPlanUnitsArray a3SuppPlanUnits;
        @XmlElement(name = "a3_notify_method")
    protected Long a3NotifyMethod;
        @XmlElement(name = "a3_promo_cd")
    protected String a3PromoCd;
        @XmlElement(name = "a3_password")
    protected String a3Password;
        @XmlElement(name = "a3_secret_question")
    protected String a3SecretQuestion;
        @XmlElement(name = "a3_secret_question_answer")
    protected String a3SecretQuestionAnswer;
        @XmlElement(name = "a3_first_name")
    protected String a3FirstName;
        @XmlElement(name = "a3_mi")
    protected String a3Mi;
        @XmlElement(name = "a3_last_name")
    protected String a3LastName;
        @XmlElement(name = "a3_company_name")
    protected String a3CompanyName;
        @XmlElement(name = "a3_address1")
    protected String a3Address1;
        @XmlElement(name = "a3_address2")
    protected String a3Address2;
        @XmlElement(name = "a3_city")
    protected String a3City;
        @XmlElement(name = "a3_locality")
    protected String a3Locality;
        @XmlElement(name = "a3_state_prov")
    protected String a3StateProv;
        @XmlElement(name = "a3_country")
    protected String a3Country;
        @XmlElement(name = "a3_postal_cd")
    protected String a3PostalCd;
        @XmlElement(name = "a3_phone")
    protected String a3Phone;
        @XmlElement(name = "a3_phone_ext")
    protected String a3PhoneExt;
        @XmlElement(name = "a3_cell_phone")
    protected String a3CellPhone;
        @XmlElement(name = "a3_work_phone")
    protected String a3WorkPhone;
        @XmlElement(name = "a3_work_phone_ext")
    protected String a3WorkPhoneExt;
        @XmlElement(name = "a3_email")
    protected String a3Email;
        @XmlElement(name = "a3_birthdate")
    protected String a3Birthdate;
        @XmlElement(name = "a3_bill_first_name")
    protected String a3BillFirstName;
        @XmlElement(name = "a3_bill_mi")
    protected String a3BillMi;
        @XmlElement(name = "a3_bill_last_name")
    protected String a3BillLastName;
        @XmlElement(name = "a3_bill_company_name")
    protected String a3BillCompanyName;
        @XmlElement(name = "a3_bill_address1")
    protected String a3BillAddress1;
        @XmlElement(name = "a3_bill_address2")
    protected String a3BillAddress2;
        @XmlElement(name = "a3_bill_city")
    protected String a3BillCity;
        @XmlElement(name = "a3_bill_locality")
    protected String a3BillLocality;
        @XmlElement(name = "a3_bill_state_prov")
    protected String a3BillStateProv;
        @XmlElement(name = "a3_bill_country")
    protected String a3BillCountry;
        @XmlElement(name = "a3_bill_postal_cd")
    protected String a3BillPostalCd;
        @XmlElement(name = "a3_bill_phone")
    protected String a3BillPhone;
        @XmlElement(name = "a3_bill_phone_ext")
    protected String a3BillPhoneExt;
        @XmlElement(name = "a3_bill_cell_phone")
    protected String a3BillCellPhone;
        @XmlElement(name = "a3_bill_work_phone")
    protected String a3BillWorkPhone;
        @XmlElement(name = "a3_bill_work_phone_ext")
    protected String a3BillWorkPhoneExt;
        @XmlElement(name = "a3_bill_email")
    protected String a3BillEmail;
        @XmlElement(name = "a3_pay_method")
    protected Long a3PayMethod;
        @XmlElement(name = "a3_cc_number")
    protected String a3CcNumber;
        @XmlElement(name = "a3_cc_expire_mm")
    protected Long a3CcExpireMm;
        @XmlElement(name = "a3_cc_expire_yyyy")
    protected Long a3CcExpireYyyy;
        @XmlElement(name = "a3_bank_acct_no")
    protected String a3BankAcctNo;
        @XmlElement(name = "a3_bank_routing_no")
    protected String a3BankRoutingNo;
        @XmlElement(name = "a3_resp_level_cd")
    protected Long a3RespLevelCd;
        @XmlElement(name = "a3_functional_acct_groups")
    protected A3FunctionalAcctGroupsArray a3FunctionalAcctGroups;
        @XmlElement(name = "a3_collections_acct_groups")
    protected A3CollectionsAcctGroupsArray a3CollectionsAcctGroups;
        @XmlElement(name = "a3_supp_field_names")
    protected A3SuppFieldNamesArray a3SuppFieldNames;
        @XmlElement(name = "a3_supp_field_values")
    protected A3SuppFieldValuesArray a3SuppFieldValues;
        @XmlElement(name = "a3_test_acct_ind")
    protected Long a3TestAcctInd;
        @XmlElement(name = "a3_status_until_alt_start")
    protected Long a3StatusUntilAltStart;
        @XmlElement(name = "a3_balance_forward")
    protected Double a3BalanceForward;
        @XmlElement(name = "a3_alt_bill_day")
    protected Long a3AltBillDay;
        @XmlElement(name = "a3_do_full_invoicing")
    protected String a3DoFullInvoicing;
        @XmlElement(name = "a3_do_prorated_invoicing")
    protected String a3DoProratedInvoicing;
        @XmlElement(name = "a3_master_plan_alt_rate_sched_no")
    protected Long a3MasterPlanAltRateSchedNo;
        @XmlElement(name = "a3_supp_plan_alt_rate_sched_no")
    protected A3SuppPlanAltRateSchedNoArray a3SuppPlanAltRateSchedNo;
        @XmlElement(name = "a3_currency_cd")
    protected String a3CurrencyCd;
        @XmlElement(name = "a3_cvv")
    protected String a3Cvv;
        @XmlElement(name = "a3_taxpayer_id")
    protected String a3TaxpayerId;
        @XmlElement(name = "a3_bill_agreement_id")
    protected String a3BillAgreementId;
        @XmlElement(name = "a3_retroactive_start_date")
    protected String a3RetroactiveStartDate;
        @XmlElement(name = "a3_coupon_codes")
    protected A3CouponCodesArray a3CouponCodes;
        @XmlElement(name = "a3_new_acct_custom_rates")
    protected A3NewAcctCustomRatesArray a3NewAcctCustomRates;
        @XmlElement(name = "a3_alt_msg_template_no")
    protected Long a3AltMsgTemplateNo;
        @XmlElement(name = "a3_seq_func_group_no")
    protected Long a3SeqFuncGroupNo;
        @XmlElement(name = "a3_new_acct_plan_contracts")
    protected A3NewAcctPlanContractsArray a3NewAcctPlanContracts;
        @XmlElement(name = "a3_bank_acct_type")
    protected String a3BankAcctType;
        @XmlElement(name = "a3_address3")
    protected String a3Address3;
        @XmlElement(name = "a3_bill_address3")
    protected String a3BillAddress3;
        @XmlElement(name = "a3_usage_accumulation_config")
    protected A3UsageAccumulationConfigArray a3UsageAccumulationConfig;
        @XmlElement(name = "a3_enable_usage_pooling_plan_no")
    protected A3EnableUsagePoolingPlanNoArray a3EnableUsagePoolingPlanNo;
        @XmlElement(name = "a3_client_func_acct_group_ids")
    protected A3ClientFuncAcctGroupIdsArray a3ClientFuncAcctGroupIds;
        @XmlElement(name = "a3_client_coll_acct_group_ids")
    protected A3ClientCollAcctGroupIdsArray a3ClientCollAcctGroupIds;
        @XmlElement(name = "a3_track_data1")
    protected String a3TrackData1;
        @XmlElement(name = "a3_track_data2")
    protected String a3TrackData2;
        @XmlElement(name = "a3_tax_exemption_level")
    protected Long a3TaxExemptionLevel;
        @XmlElement(name = "a3_cn_alt_msg_template_no")
    protected Long a3CnAltMsgTemplateNo;
        @XmlElement(name = "a3_invoice_approval_required")
    protected String a3InvoiceApprovalRequired;
        @XmlElement(name = "a3_create_session")
    protected String a3CreateSession;
        @XmlElement(name = "a3_client_master_plan_id")
    protected String a3ClientMasterPlanId;
        @XmlElement(name = "a3_client_supp_plan_ids")
    protected A3ClientSuppPlanIdsArray a3ClientSuppPlanIds;
        @XmlElement(name = "a3_client_mp_alt_rate_sched_id")
    protected String a3ClientMpAltRateSchedId;
        @XmlElement(name = "a3_client_sp_alt_rate_sched_ids")
    protected A3ClientSpAltRateSchedIdsArray a3ClientSpAltRateSchedIds;
        @XmlElement(name = "a3_client_alt_msg_template_id")
    protected String a3ClientAltMsgTemplateId;
        @XmlElement(name = "a3_client_cn_alt_msg_template_no")
    protected String a3ClientCnAltMsgTemplateNo;
        @XmlElement(name = "a3_iban")
    protected String a3Iban;
        @XmlElement(name = "a3_bank_check_digit")
    protected Long a3BankCheckDigit;
        @XmlElement(name = "a3_bank_swift_cd")
    protected String a3BankSwiftCd;
        @XmlElement(name = "a3_bank_country_cd")
    protected String a3BankCountryCd;
        @XmlElement(name = "a3_mandate_id")
    protected String a3MandateId;
        @XmlElement(name = "a3_bank_id_cd")
    protected String a3BankIdCd;
        @XmlElement(name = "a3_bank_branch_cd")
    protected String a3BankBranchCd;
        @XmlElement(name = "a3_surcharge_no")
    protected A3SurchargeNoArray a3SurchargeNo;
        @XmlElement(name = "a3_bkup_bill_first_name")
    protected String a3BkupBillFirstName;
        @XmlElement(name = "a3_bkup_bill_mi")
    protected String a3BkupBillMi;
        @XmlElement(name = "a3_bkup_bill_last_name")
    protected String a3BkupBillLastName;
        @XmlElement(name = "a3_bkup_bill_company_name")
    protected String a3BkupBillCompanyName;
        @XmlElement(name = "a3_bkup_bill_address1")
    protected String a3BkupBillAddress1;
        @XmlElement(name = "a3_bkup_bill_address2")
    protected String a3BkupBillAddress2;
        @XmlElement(name = "a3_bkup_bill_address3")
    protected String a3BkupBillAddress3;
        @XmlElement(name = "a3_bkup_bill_city")
    protected String a3BkupBillCity;
        @XmlElement(name = "a3_bkup_bill_locality")
    protected String a3BkupBillLocality;
        @XmlElement(name = "a3_bkup_bill_state_prov")
    protected String a3BkupBillStateProv;
        @XmlElement(name = "a3_bkup_bill_country")
    protected String a3BkupBillCountry;
        @XmlElement(name = "a3_bkup_bill_postal_cd")
    protected String a3BkupBillPostalCd;
        @XmlElement(name = "a3_bkup_bill_phone")
    protected String a3BkupBillPhone;
        @XmlElement(name = "a3_bkup_bill_phone_ext")
    protected String a3BkupBillPhoneExt;
        @XmlElement(name = "a3_bkup_bill_cell_phone")
    protected String a3BkupBillCellPhone;
        @XmlElement(name = "a3_bkup_bill_work_phone")
    protected String a3BkupBillWorkPhone;
        @XmlElement(name = "a3_bkup_bill_work_phone_ext")
    protected String a3BkupBillWorkPhoneExt;
        @XmlElement(name = "a3_bkup_bill_email")
    protected String a3BkupBillEmail;
        @XmlElement(name = "a3_bkup_pay_method")
    protected Long a3BkupPayMethod;
        @XmlElement(name = "a3_bkup_cc_number")
    protected String a3BkupCcNumber;
        @XmlElement(name = "a3_bkup_cc_expire_mm")
    protected Long a3BkupCcExpireMm;
        @XmlElement(name = "a3_bkup_cc_expire_yyyy")
    protected Long a3BkupCcExpireYyyy;
        @XmlElement(name = "a3_bkup_bank_acct_no")
    protected String a3BkupBankAcctNo;
        @XmlElement(name = "a3_bkup_bank_routing_no")
    protected String a3BkupBankRoutingNo;
        @XmlElement(name = "a3_bkup_bank_acct_type")
    protected String a3BkupBankAcctType;
        @XmlElement(name = "a3_bkup_bill_agreement_id")
    protected String a3BkupBillAgreementId;
        @XmlElement(name = "a3_bkup_cvv")
    protected String a3BkupCvv;
        @XmlElement(name = "a3_seq_func_group_id")
    protected String a3SeqFuncGroupId;
        @XmlElement(name = "a3_revrec_profile_id")
    protected Long a3RevrecProfileId;
        @XmlElement(name = "a3_revrec_client_defined_id")
    protected String a3RevrecClientDefinedId;
        @XmlElement(name = "a3_stmnt_email_list_cc")
    protected String a3StmntEmailListCc;
        @XmlElement(name = "a3_stmnt_email_list_bcc")
    protected String a3StmntEmailListBcc;
        @XmlElement(name = "a3_invoice_posting_method_cd")
    protected Long a3InvoicePostingMethodCd;
        @XmlElement(name = "a3_acct_start_date")
    protected String a3AcctStartDate;
        @XmlElement(name = "a3_min_statement_threshold")
    protected Long a3MinStatementThreshold;
        @XmlElement(name = "a3_max_statements_to_defer")
    protected Long a3MaxStatementsToDefer;
        @XmlElement(name = "a3_defer_full_statements_only")
    protected Long a3DeferFullStatementsOnly;
        @XmlElement(name = "a3_cc_id")
    protected Long a3CcId;
        @XmlElement(name = "a3_bkup_cc_id")
    protected Long a3BkupCcId;
        @XmlElement(name = "a4_alt_start_date")
    protected String a4AltStartDate;
        @XmlElement(name = "a4_client_acct_id")
    protected String a4ClientAcctId;
        @XmlElement(name = "a4_userid")
    protected String a4Userid;
        @XmlElement(name = "a4_status_cd")
    protected Long a4StatusCd;
        @XmlElement(name = "a4_master_plan_no")
    protected Long a4MasterPlanNo;
        @XmlElement(name = "a4_master_plan_units")
    protected Long a4MasterPlanUnits;
        @XmlElement(name = "a4_supp_plans")
    protected A4SuppPlansArray a4SuppPlans;
        @XmlElement(name = "a4_supp_plan_units")
    protected A4SuppPlanUnitsArray a4SuppPlanUnits;
        @XmlElement(name = "a4_notify_method")
    protected Long a4NotifyMethod;
        @XmlElement(name = "a4_promo_cd")
    protected String a4PromoCd;
        @XmlElement(name = "a4_password")
    protected String a4Password;
        @XmlElement(name = "a4_secret_question")
    protected String a4SecretQuestion;
        @XmlElement(name = "a4_secret_question_answer")
    protected String a4SecretQuestionAnswer;
        @XmlElement(name = "a4_first_name")
    protected String a4FirstName;
        @XmlElement(name = "a4_mi")
    protected String a4Mi;
        @XmlElement(name = "a4_last_name")
    protected String a4LastName;
        @XmlElement(name = "a4_company_name")
    protected String a4CompanyName;
        @XmlElement(name = "a4_address1")
    protected String a4Address1;
        @XmlElement(name = "a4_address2")
    protected String a4Address2;
        @XmlElement(name = "a4_city")
    protected String a4City;
        @XmlElement(name = "a4_locality")
    protected String a4Locality;
        @XmlElement(name = "a4_state_prov")
    protected String a4StateProv;
        @XmlElement(name = "a4_country")
    protected String a4Country;
        @XmlElement(name = "a4_postal_cd")
    protected String a4PostalCd;
        @XmlElement(name = "a4_phone")
    protected String a4Phone;
        @XmlElement(name = "a4_phone_ext")
    protected String a4PhoneExt;
        @XmlElement(name = "a4_cell_phone")
    protected String a4CellPhone;
        @XmlElement(name = "a4_work_phone")
    protected String a4WorkPhone;
        @XmlElement(name = "a4_work_phone_ext")
    protected String a4WorkPhoneExt;
        @XmlElement(name = "a4_email")
    protected String a4Email;
        @XmlElement(name = "a4_birthdate")
    protected String a4Birthdate;
        @XmlElement(name = "a4_bill_first_name")
    protected String a4BillFirstName;
        @XmlElement(name = "a4_bill_mi")
    protected String a4BillMi;
        @XmlElement(name = "a4_bill_last_name")
    protected String a4BillLastName;
        @XmlElement(name = "a4_bill_company_name")
    protected String a4BillCompanyName;
        @XmlElement(name = "a4_bill_address1")
    protected String a4BillAddress1;
        @XmlElement(name = "a4_bill_address2")
    protected String a4BillAddress2;
        @XmlElement(name = "a4_bill_city")
    protected String a4BillCity;
        @XmlElement(name = "a4_bill_locality")
    protected String a4BillLocality;
        @XmlElement(name = "a4_bill_state_prov")
    protected String a4BillStateProv;
        @XmlElement(name = "a4_bill_country")
    protected String a4BillCountry;
        @XmlElement(name = "a4_bill_postal_cd")
    protected String a4BillPostalCd;
        @XmlElement(name = "a4_bill_phone")
    protected String a4BillPhone;
        @XmlElement(name = "a4_bill_phone_ext")
    protected String a4BillPhoneExt;
        @XmlElement(name = "a4_bill_cell_phone")
    protected String a4BillCellPhone;
        @XmlElement(name = "a4_bill_work_phone")
    protected String a4BillWorkPhone;
        @XmlElement(name = "a4_bill_work_phone_ext")
    protected String a4BillWorkPhoneExt;
        @XmlElement(name = "a4_bill_email")
    protected String a4BillEmail;
        @XmlElement(name = "a4_pay_method")
    protected Long a4PayMethod;
        @XmlElement(name = "a4_cc_number")
    protected String a4CcNumber;
        @XmlElement(name = "a4_cc_expire_mm")
    protected Long a4CcExpireMm;
        @XmlElement(name = "a4_cc_expire_yyyy")
    protected Long a4CcExpireYyyy;
        @XmlElement(name = "a4_bank_acct_no")
    protected String a4BankAcctNo;
        @XmlElement(name = "a4_bank_routing_no")
    protected String a4BankRoutingNo;
        @XmlElement(name = "a4_resp_level_cd")
    protected Long a4RespLevelCd;
        @XmlElement(name = "a4_functional_acct_groups")
    protected A4FunctionalAcctGroupsArray a4FunctionalAcctGroups;
        @XmlElement(name = "a4_collections_acct_groups")
    protected A4CollectionsAcctGroupsArray a4CollectionsAcctGroups;
        @XmlElement(name = "a4_supp_field_names")
    protected A4SuppFieldNamesArray a4SuppFieldNames;
        @XmlElement(name = "a4_supp_field_values")
    protected A4SuppFieldValuesArray a4SuppFieldValues;
        @XmlElement(name = "a4_test_acct_ind")
    protected Long a4TestAcctInd;
        @XmlElement(name = "a4_status_until_alt_start")
    protected Long a4StatusUntilAltStart;
        @XmlElement(name = "a4_balance_forward")
    protected Double a4BalanceForward;
        @XmlElement(name = "a4_alt_bill_day")
    protected Long a4AltBillDay;
        @XmlElement(name = "a4_do_full_invoicing")
    protected String a4DoFullInvoicing;
        @XmlElement(name = "a4_do_prorated_invoicing")
    protected String a4DoProratedInvoicing;
        @XmlElement(name = "a4_master_plan_alt_rate_sched_no")
    protected Long a4MasterPlanAltRateSchedNo;
        @XmlElement(name = "a4_supp_plan_alt_rate_sched_no")
    protected A4SuppPlanAltRateSchedNoArray a4SuppPlanAltRateSchedNo;
        @XmlElement(name = "a4_currency_cd")
    protected String a4CurrencyCd;
        @XmlElement(name = "a4_cvv")
    protected String a4Cvv;
        @XmlElement(name = "a4_taxpayer_id")
    protected String a4TaxpayerId;
        @XmlElement(name = "a4_bill_agreement_id")
    protected String a4BillAgreementId;
        @XmlElement(name = "a4_retroactive_start_date")
    protected String a4RetroactiveStartDate;
        @XmlElement(name = "a4_coupon_codes")
    protected A4CouponCodesArray a4CouponCodes;
        @XmlElement(name = "a4_new_acct_custom_rates")
    protected A4NewAcctCustomRatesArray a4NewAcctCustomRates;
        @XmlElement(name = "a4_alt_msg_template_no")
    protected Long a4AltMsgTemplateNo;
        @XmlElement(name = "a4_seq_func_group_no")
    protected Long a4SeqFuncGroupNo;
        @XmlElement(name = "a4_new_acct_plan_contracts")
    protected A4NewAcctPlanContractsArray a4NewAcctPlanContracts;
        @XmlElement(name = "a4_bank_acct_type")
    protected String a4BankAcctType;
        @XmlElement(name = "a4_address3")
    protected String a4Address3;
        @XmlElement(name = "a4_bill_address3")
    protected String a4BillAddress3;
        @XmlElement(name = "a4_usage_accumulation_config")
    protected A4UsageAccumulationConfigArray a4UsageAccumulationConfig;
        @XmlElement(name = "a4_enable_usage_pooling_plan_no")
    protected A4EnableUsagePoolingPlanNoArray a4EnableUsagePoolingPlanNo;
        @XmlElement(name = "a4_client_func_acct_group_ids")
    protected A4ClientFuncAcctGroupIdsArray a4ClientFuncAcctGroupIds;
        @XmlElement(name = "a4_client_coll_acct_group_ids")
    protected A4ClientCollAcctGroupIdsArray a4ClientCollAcctGroupIds;
        @XmlElement(name = "a4_track_data1")
    protected String a4TrackData1;
        @XmlElement(name = "a4_track_data2")
    protected String a4TrackData2;
        @XmlElement(name = "a4_tax_exemption_level")
    protected Long a4TaxExemptionLevel;
        @XmlElement(name = "a4_cn_alt_msg_template_no")
    protected Long a4CnAltMsgTemplateNo;
        @XmlElement(name = "a4_invoice_approval_required")
    protected String a4InvoiceApprovalRequired;
        @XmlElement(name = "a4_create_session")
    protected String a4CreateSession;
        @XmlElement(name = "a4_client_master_plan_id")
    protected String a4ClientMasterPlanId;
        @XmlElement(name = "a4_client_supp_plan_ids")
    protected A4ClientSuppPlanIdsArray a4ClientSuppPlanIds;
        @XmlElement(name = "a4_client_mp_alt_rate_sched_id")
    protected String a4ClientMpAltRateSchedId;
        @XmlElement(name = "a4_client_sp_alt_rate_sched_ids")
    protected A4ClientSpAltRateSchedIdsArray a4ClientSpAltRateSchedIds;
        @XmlElement(name = "a4_client_alt_msg_template_id")
    protected String a4ClientAltMsgTemplateId;
        @XmlElement(name = "a4_client_cn_alt_msg_template_no")
    protected String a4ClientCnAltMsgTemplateNo;
        @XmlElement(name = "a4_iban")
    protected String a4Iban;
        @XmlElement(name = "a4_bank_check_digit")
    protected Long a4BankCheckDigit;
        @XmlElement(name = "a4_bank_swift_cd")
    protected String a4BankSwiftCd;
        @XmlElement(name = "a4_bank_country_cd")
    protected String a4BankCountryCd;
        @XmlElement(name = "a4_mandate_id")
    protected String a4MandateId;
        @XmlElement(name = "a4_bank_id_cd")
    protected String a4BankIdCd;
        @XmlElement(name = "a4_bank_branch_cd")
    protected String a4BankBranchCd;
        @XmlElement(name = "a4_surcharge_no")
    protected A4SurchargeNoArray a4SurchargeNo;
        @XmlElement(name = "a4_bkup_bill_first_name")
    protected String a4BkupBillFirstName;
        @XmlElement(name = "a4_bkup_bill_mi")
    protected String a4BkupBillMi;
        @XmlElement(name = "a4_bkup_bill_last_name")
    protected String a4BkupBillLastName;
        @XmlElement(name = "a4_bkup_bill_company_name")
    protected String a4BkupBillCompanyName;
        @XmlElement(name = "a4_bkup_bill_address1")
    protected String a4BkupBillAddress1;
        @XmlElement(name = "a4_bkup_bill_address2")
    protected String a4BkupBillAddress2;
        @XmlElement(name = "a4_bkup_bill_address3")
    protected String a4BkupBillAddress3;
        @XmlElement(name = "a4_bkup_bill_city")
    protected String a4BkupBillCity;
        @XmlElement(name = "a4_bkup_bill_locality")
    protected String a4BkupBillLocality;
        @XmlElement(name = "a4_bkup_bill_state_prov")
    protected String a4BkupBillStateProv;
        @XmlElement(name = "a4_bkup_bill_country")
    protected String a4BkupBillCountry;
        @XmlElement(name = "a4_bkup_bill_postal_cd")
    protected String a4BkupBillPostalCd;
        @XmlElement(name = "a4_bkup_bill_phone")
    protected String a4BkupBillPhone;
        @XmlElement(name = "a4_bkup_bill_phone_ext")
    protected String a4BkupBillPhoneExt;
        @XmlElement(name = "a4_bkup_bill_cell_phone")
    protected String a4BkupBillCellPhone;
        @XmlElement(name = "a4_bkup_bill_work_phone")
    protected String a4BkupBillWorkPhone;
        @XmlElement(name = "a4_bkup_bill_work_phone_ext")
    protected String a4BkupBillWorkPhoneExt;
        @XmlElement(name = "a4_bkup_bill_email")
    protected String a4BkupBillEmail;
        @XmlElement(name = "a4_bkup_pay_method")
    protected Long a4BkupPayMethod;
        @XmlElement(name = "a4_bkup_cc_number")
    protected String a4BkupCcNumber;
        @XmlElement(name = "a4_bkup_cc_expire_mm")
    protected Long a4BkupCcExpireMm;
        @XmlElement(name = "a4_bkup_cc_expire_yyyy")
    protected Long a4BkupCcExpireYyyy;
        @XmlElement(name = "a4_bkup_bank_acct_no")
    protected String a4BkupBankAcctNo;
        @XmlElement(name = "a4_bkup_bank_routing_no")
    protected String a4BkupBankRoutingNo;
        @XmlElement(name = "a4_bkup_bank_acct_type")
    protected String a4BkupBankAcctType;
        @XmlElement(name = "a4_bkup_bill_agreement_id")
    protected String a4BkupBillAgreementId;
        @XmlElement(name = "a4_bkup_cvv")
    protected String a4BkupCvv;
        @XmlElement(name = "a4_seq_func_group_id")
    protected String a4SeqFuncGroupId;
        @XmlElement(name = "a4_revrec_profile_id")
    protected Long a4RevrecProfileId;
        @XmlElement(name = "a4_revrec_client_defined_id")
    protected String a4RevrecClientDefinedId;
        @XmlElement(name = "a4_stmnt_email_list_cc")
    protected String a4StmntEmailListCc;
        @XmlElement(name = "a4_stmnt_email_list_bcc")
    protected String a4StmntEmailListBcc;
        @XmlElement(name = "a4_invoice_posting_method_cd")
    protected Long a4InvoicePostingMethodCd;
        @XmlElement(name = "a4_acct_start_date")
    protected String a4AcctStartDate;
        @XmlElement(name = "a4_min_statement_threshold")
    protected Long a4MinStatementThreshold;
        @XmlElement(name = "a4_max_statements_to_defer")
    protected Long a4MaxStatementsToDefer;
        @XmlElement(name = "a4_defer_full_statements_only")
    protected Long a4DeferFullStatementsOnly;
        @XmlElement(name = "a4_cc_id")
    protected Long a4CcId;
        @XmlElement(name = "a4_bkup_cc_id")
    protected Long a4BkupCcId;
        @XmlElement(name = "a5_alt_start_date")
    protected String a5AltStartDate;
        @XmlElement(name = "a5_client_acct_id")
    protected String a5ClientAcctId;
        @XmlElement(name = "a5_userid")
    protected String a5Userid;
        @XmlElement(name = "a5_status_cd")
    protected Long a5StatusCd;
        @XmlElement(name = "a5_master_plan_no")
    protected Long a5MasterPlanNo;
        @XmlElement(name = "a5_master_plan_units")
    protected Long a5MasterPlanUnits;
        @XmlElement(name = "a5_supp_plans")
    protected A5SuppPlansArray a5SuppPlans;
        @XmlElement(name = "a5_supp_plan_units")
    protected A5SuppPlanUnitsArray a5SuppPlanUnits;
        @XmlElement(name = "a5_notify_method")
    protected Long a5NotifyMethod;
        @XmlElement(name = "a5_promo_cd")
    protected String a5PromoCd;
        @XmlElement(name = "a5_password")
    protected String a5Password;
        @XmlElement(name = "a5_secret_question")
    protected String a5SecretQuestion;
        @XmlElement(name = "a5_secret_question_answer")
    protected String a5SecretQuestionAnswer;
        @XmlElement(name = "a5_first_name")
    protected String a5FirstName;
        @XmlElement(name = "a5_mi")
    protected String a5Mi;
        @XmlElement(name = "a5_last_name")
    protected String a5LastName;
        @XmlElement(name = "a5_company_name")
    protected String a5CompanyName;
        @XmlElement(name = "a5_address1")
    protected String a5Address1;
        @XmlElement(name = "a5_address2")
    protected String a5Address2;
        @XmlElement(name = "a5_city")
    protected String a5City;
        @XmlElement(name = "a5_locality")
    protected String a5Locality;
        @XmlElement(name = "a5_state_prov")
    protected String a5StateProv;
        @XmlElement(name = "a5_country")
    protected String a5Country;
        @XmlElement(name = "a5_postal_cd")
    protected String a5PostalCd;
        @XmlElement(name = "a5_phone")
    protected String a5Phone;
        @XmlElement(name = "a5_phone_ext")
    protected String a5PhoneExt;
        @XmlElement(name = "a5_cell_phone")
    protected String a5CellPhone;
        @XmlElement(name = "a5_work_phone")
    protected String a5WorkPhone;
        @XmlElement(name = "a5_work_phone_ext")
    protected String a5WorkPhoneExt;
        @XmlElement(name = "a5_email")
    protected String a5Email;
        @XmlElement(name = "a5_birthdate")
    protected String a5Birthdate;
        @XmlElement(name = "a5_bill_first_name")
    protected String a5BillFirstName;
        @XmlElement(name = "a5_bill_mi")
    protected String a5BillMi;
        @XmlElement(name = "a5_bill_last_name")
    protected String a5BillLastName;
        @XmlElement(name = "a5_bill_company_name")
    protected String a5BillCompanyName;
        @XmlElement(name = "a5_bill_address1")
    protected String a5BillAddress1;
        @XmlElement(name = "a5_bill_address2")
    protected String a5BillAddress2;
        @XmlElement(name = "a5_bill_city")
    protected String a5BillCity;
        @XmlElement(name = "a5_bill_locality")
    protected String a5BillLocality;
        @XmlElement(name = "a5_bill_state_prov")
    protected String a5BillStateProv;
        @XmlElement(name = "a5_bill_country")
    protected String a5BillCountry;
        @XmlElement(name = "a5_bill_postal_cd")
    protected String a5BillPostalCd;
        @XmlElement(name = "a5_bill_phone")
    protected String a5BillPhone;
        @XmlElement(name = "a5_bill_phone_ext")
    protected String a5BillPhoneExt;
        @XmlElement(name = "a5_bill_cell_phone")
    protected String a5BillCellPhone;
        @XmlElement(name = "a5_bill_work_phone")
    protected String a5BillWorkPhone;
        @XmlElement(name = "a5_bill_work_phone_ext")
    protected String a5BillWorkPhoneExt;
        @XmlElement(name = "a5_bill_email")
    protected String a5BillEmail;
        @XmlElement(name = "a5_pay_method")
    protected Long a5PayMethod;
        @XmlElement(name = "a5_cc_number")
    protected String a5CcNumber;
        @XmlElement(name = "a5_cc_expire_mm")
    protected Long a5CcExpireMm;
        @XmlElement(name = "a5_cc_expire_yyyy")
    protected Long a5CcExpireYyyy;
        @XmlElement(name = "a5_bank_acct_no")
    protected String a5BankAcctNo;
        @XmlElement(name = "a5_bank_routing_no")
    protected String a5BankRoutingNo;
        @XmlElement(name = "a5_resp_level_cd")
    protected Long a5RespLevelCd;
        @XmlElement(name = "a5_functional_acct_groups")
    protected A5FunctionalAcctGroupsArray a5FunctionalAcctGroups;
        @XmlElement(name = "a5_collections_acct_groups")
    protected A5CollectionsAcctGroupsArray a5CollectionsAcctGroups;
        @XmlElement(name = "a5_supp_field_names")
    protected A5SuppFieldNamesArray a5SuppFieldNames;
        @XmlElement(name = "a5_supp_field_values")
    protected A5SuppFieldValuesArray a5SuppFieldValues;
        @XmlElement(name = "a5_test_acct_ind")
    protected Long a5TestAcctInd;
        @XmlElement(name = "a5_status_until_alt_start")
    protected Long a5StatusUntilAltStart;
        @XmlElement(name = "a5_balance_forward")
    protected Double a5BalanceForward;
        @XmlElement(name = "a5_alt_bill_day")
    protected Long a5AltBillDay;
        @XmlElement(name = "a5_do_full_invoicing")
    protected String a5DoFullInvoicing;
        @XmlElement(name = "a5_do_prorated_invoicing")
    protected String a5DoProratedInvoicing;
        @XmlElement(name = "a5_master_plan_alt_rate_sched_no")
    protected Long a5MasterPlanAltRateSchedNo;
        @XmlElement(name = "a5_supp_plan_alt_rate_sched_no")
    protected A5SuppPlanAltRateSchedNoArray a5SuppPlanAltRateSchedNo;
        @XmlElement(name = "a5_currency_cd")
    protected String a5CurrencyCd;
        @XmlElement(name = "a5_cvv")
    protected String a5Cvv;
        @XmlElement(name = "a5_taxpayer_id")
    protected String a5TaxpayerId;
        @XmlElement(name = "a5_bill_agreement_id")
    protected String a5BillAgreementId;
        @XmlElement(name = "a5_retroactive_start_date")
    protected String a5RetroactiveStartDate;
        @XmlElement(name = "a5_coupon_codes")
    protected A5CouponCodesArray a5CouponCodes;
        @XmlElement(name = "a5_new_acct_custom_rates")
    protected A5NewAcctCustomRatesArray a5NewAcctCustomRates;
        @XmlElement(name = "a5_alt_msg_template_no")
    protected Long a5AltMsgTemplateNo;
        @XmlElement(name = "a5_seq_func_group_no")
    protected Long a5SeqFuncGroupNo;
        @XmlElement(name = "a5_new_acct_plan_contracts")
    protected A5NewAcctPlanContractsArray a5NewAcctPlanContracts;
        @XmlElement(name = "a5_bank_acct_type")
    protected String a5BankAcctType;
        @XmlElement(name = "a5_address3")
    protected String a5Address3;
        @XmlElement(name = "a5_bill_address3")
    protected String a5BillAddress3;
        @XmlElement(name = "a5_usage_accumulation_config")
    protected A5UsageAccumulationConfigArray a5UsageAccumulationConfig;
        @XmlElement(name = "a5_enable_usage_pooling_plan_no")
    protected A5EnableUsagePoolingPlanNoArray a5EnableUsagePoolingPlanNo;
        @XmlElement(name = "a5_client_func_acct_group_ids")
    protected A5ClientFuncAcctGroupIdsArray a5ClientFuncAcctGroupIds;
        @XmlElement(name = "a5_client_coll_acct_group_ids")
    protected A5ClientCollAcctGroupIdsArray a5ClientCollAcctGroupIds;
        @XmlElement(name = "a5_track_data1")
    protected String a5TrackData1;
        @XmlElement(name = "a5_track_data2")
    protected String a5TrackData2;
        @XmlElement(name = "a5_tax_exemption_level")
    protected Long a5TaxExemptionLevel;
        @XmlElement(name = "a5_cn_alt_msg_template_no")
    protected Long a5CnAltMsgTemplateNo;
        @XmlElement(name = "a5_invoice_approval_required")
    protected String a5InvoiceApprovalRequired;
        @XmlElement(name = "a5_create_session")
    protected String a5CreateSession;
        @XmlElement(name = "a5_client_master_plan_id")
    protected String a5ClientMasterPlanId;
        @XmlElement(name = "a5_client_supp_plan_ids")
    protected A5ClientSuppPlanIdsArray a5ClientSuppPlanIds;
        @XmlElement(name = "a5_client_mp_alt_rate_sched_id")
    protected String a5ClientMpAltRateSchedId;
        @XmlElement(name = "a5_client_sp_alt_rate_sched_ids")
    protected A5ClientSpAltRateSchedIdsArray a5ClientSpAltRateSchedIds;
        @XmlElement(name = "a5_client_alt_msg_template_id")
    protected String a5ClientAltMsgTemplateId;
        @XmlElement(name = "a5_client_cn_alt_msg_template_no")
    protected String a5ClientCnAltMsgTemplateNo;
        @XmlElement(name = "a5_iban")
    protected String a5Iban;
        @XmlElement(name = "a5_bank_check_digit")
    protected Long a5BankCheckDigit;
        @XmlElement(name = "a5_bank_swift_cd")
    protected String a5BankSwiftCd;
        @XmlElement(name = "a5_bank_country_cd")
    protected String a5BankCountryCd;
        @XmlElement(name = "a5_mandate_id")
    protected String a5MandateId;
        @XmlElement(name = "a5_bank_id_cd")
    protected String a5BankIdCd;
        @XmlElement(name = "a5_bank_branch_cd")
    protected String a5BankBranchCd;
        @XmlElement(name = "a5_surcharge_no")
    protected A5SurchargeNoArray a5SurchargeNo;
        @XmlElement(name = "a5_bkup_bill_first_name")
    protected String a5BkupBillFirstName;
        @XmlElement(name = "a5_bkup_bill_mi")
    protected String a5BkupBillMi;
        @XmlElement(name = "a5_bkup_bill_last_name")
    protected String a5BkupBillLastName;
        @XmlElement(name = "a5_bkup_bill_company_name")
    protected String a5BkupBillCompanyName;
        @XmlElement(name = "a5_bkup_bill_address1")
    protected String a5BkupBillAddress1;
        @XmlElement(name = "a5_bkup_bill_address2")
    protected String a5BkupBillAddress2;
        @XmlElement(name = "a5_bkup_bill_address3")
    protected String a5BkupBillAddress3;
        @XmlElement(name = "a5_bkup_bill_city")
    protected String a5BkupBillCity;
        @XmlElement(name = "a5_bkup_bill_locality")
    protected String a5BkupBillLocality;
        @XmlElement(name = "a5_bkup_bill_state_prov")
    protected String a5BkupBillStateProv;
        @XmlElement(name = "a5_bkup_bill_country")
    protected String a5BkupBillCountry;
        @XmlElement(name = "a5_bkup_bill_postal_cd")
    protected String a5BkupBillPostalCd;
        @XmlElement(name = "a5_bkup_bill_phone")
    protected String a5BkupBillPhone;
        @XmlElement(name = "a5_bkup_bill_phone_ext")
    protected String a5BkupBillPhoneExt;
        @XmlElement(name = "a5_bkup_bill_cell_phone")
    protected String a5BkupBillCellPhone;
        @XmlElement(name = "a5_bkup_bill_work_phone")
    protected String a5BkupBillWorkPhone;
        @XmlElement(name = "a5_bkup_bill_work_phone_ext")
    protected String a5BkupBillWorkPhoneExt;
        @XmlElement(name = "a5_bkup_bill_email")
    protected String a5BkupBillEmail;
        @XmlElement(name = "a5_bkup_pay_method")
    protected Long a5BkupPayMethod;
        @XmlElement(name = "a5_bkup_cc_number")
    protected String a5BkupCcNumber;
        @XmlElement(name = "a5_bkup_cc_expire_mm")
    protected Long a5BkupCcExpireMm;
        @XmlElement(name = "a5_bkup_cc_expire_yyyy")
    protected Long a5BkupCcExpireYyyy;
        @XmlElement(name = "a5_bkup_bank_acct_no")
    protected String a5BkupBankAcctNo;
        @XmlElement(name = "a5_bkup_bank_routing_no")
    protected String a5BkupBankRoutingNo;
        @XmlElement(name = "a5_bkup_bank_acct_type")
    protected String a5BkupBankAcctType;
        @XmlElement(name = "a5_bkup_bill_agreement_id")
    protected String a5BkupBillAgreementId;
        @XmlElement(name = "a5_bkup_cvv")
    protected String a5BkupCvv;
        @XmlElement(name = "a5_seq_func_group_id")
    protected String a5SeqFuncGroupId;
        @XmlElement(name = "a5_revrec_profile_id")
    protected Long a5RevrecProfileId;
        @XmlElement(name = "a5_revrec_client_defined_id")
    protected String a5RevrecClientDefinedId;
        @XmlElement(name = "a5_stmnt_email_list_cc")
    protected String a5StmntEmailListCc;
        @XmlElement(name = "a5_stmnt_email_list_bcc")
    protected String a5StmntEmailListBcc;
        @XmlElement(name = "a5_invoice_posting_method_cd")
    protected Long a5InvoicePostingMethodCd;
        @XmlElement(name = "a5_acct_start_date")
    protected String a5AcctStartDate;
        @XmlElement(name = "a5_min_statement_threshold")
    protected Long a5MinStatementThreshold;
        @XmlElement(name = "a5_max_statements_to_defer")
    protected Long a5MaxStatementsToDefer;
        @XmlElement(name = "a5_defer_full_statements_only")
    protected Long a5DeferFullStatementsOnly;
        @XmlElement(name = "a5_cc_id")
    protected Long a5CcId;
        @XmlElement(name = "a5_bkup_cc_id")
    protected Long a5BkupCcId;
    
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

    public String getDoWrite() {
        return doWrite;
    }

    public void setDoWrite(String value) {
        this.doWrite = value;
    }
            public String getClientReceiptId() {
        return clientReceiptId;
    }

    public void setClientReceiptId(String value) {
        this.clientReceiptId = value;
    }
            public String getA1AltStartDate() {
        return a1AltStartDate;
    }

    public void setA1AltStartDate(String value) {
        this.a1AltStartDate = value;
    }
            public String getA1ClientAcctId() {
        return a1ClientAcctId;
    }

    public void setA1ClientAcctId(String value) {
        this.a1ClientAcctId = value;
    }
            public String getA1Userid() {
        return a1Userid;
    }

    public void setA1Userid(String value) {
        this.a1Userid = value;
    }
            public Long getA1StatusCd() {
        return a1StatusCd;
    }

    public void setA1StatusCd(Long value) {
        this.a1StatusCd = value;
    }
            public Long getA1MasterPlanNo() {
        return a1MasterPlanNo;
    }

    public void setA1MasterPlanNo(Long value) {
        this.a1MasterPlanNo = value;
    }
            public Long getA1MasterPlanUnits() {
        return a1MasterPlanUnits;
    }

    public void setA1MasterPlanUnits(Long value) {
        this.a1MasterPlanUnits = value;
    }
            public A1SuppPlansArray getA1SuppPlans() {
        return a1SuppPlans;
    }

    public void setA1SuppPlans(A1SuppPlansArray value) {
        this.a1SuppPlans = value;
    }
            public A1SuppPlanUnitsArray getA1SuppPlanUnits() {
        return a1SuppPlanUnits;
    }

    public void setA1SuppPlanUnits(A1SuppPlanUnitsArray value) {
        this.a1SuppPlanUnits = value;
    }
            public Long getA1NotifyMethod() {
        return a1NotifyMethod;
    }

    public void setA1NotifyMethod(Long value) {
        this.a1NotifyMethod = value;
    }
            public String getA1PromoCd() {
        return a1PromoCd;
    }

    public void setA1PromoCd(String value) {
        this.a1PromoCd = value;
    }
            public String getA1Password() {
        return a1Password;
    }

    public void setA1Password(String value) {
        this.a1Password = value;
    }
            public String getA1SecretQuestion() {
        return a1SecretQuestion;
    }

    public void setA1SecretQuestion(String value) {
        this.a1SecretQuestion = value;
    }
            public String getA1SecretQuestionAnswer() {
        return a1SecretQuestionAnswer;
    }

    public void setA1SecretQuestionAnswer(String value) {
        this.a1SecretQuestionAnswer = value;
    }
            public String getA1FirstName() {
        return a1FirstName;
    }

    public void setA1FirstName(String value) {
        this.a1FirstName = value;
    }
            public String getA1Mi() {
        return a1Mi;
    }

    public void setA1Mi(String value) {
        this.a1Mi = value;
    }
            public String getA1LastName() {
        return a1LastName;
    }

    public void setA1LastName(String value) {
        this.a1LastName = value;
    }
            public String getA1CompanyName() {
        return a1CompanyName;
    }

    public void setA1CompanyName(String value) {
        this.a1CompanyName = value;
    }
            public String getA1Address1() {
        return a1Address1;
    }

    public void setA1Address1(String value) {
        this.a1Address1 = value;
    }
            public String getA1Address2() {
        return a1Address2;
    }

    public void setA1Address2(String value) {
        this.a1Address2 = value;
    }
            public String getA1City() {
        return a1City;
    }

    public void setA1City(String value) {
        this.a1City = value;
    }
            public String getA1Locality() {
        return a1Locality;
    }

    public void setA1Locality(String value) {
        this.a1Locality = value;
    }
            public String getA1StateProv() {
        return a1StateProv;
    }

    public void setA1StateProv(String value) {
        this.a1StateProv = value;
    }
            public String getA1Country() {
        return a1Country;
    }

    public void setA1Country(String value) {
        this.a1Country = value;
    }
            public String getA1PostalCd() {
        return a1PostalCd;
    }

    public void setA1PostalCd(String value) {
        this.a1PostalCd = value;
    }
            public String getA1Phone() {
        return a1Phone;
    }

    public void setA1Phone(String value) {
        this.a1Phone = value;
    }
            public String getA1PhoneExt() {
        return a1PhoneExt;
    }

    public void setA1PhoneExt(String value) {
        this.a1PhoneExt = value;
    }
            public String getA1CellPhone() {
        return a1CellPhone;
    }

    public void setA1CellPhone(String value) {
        this.a1CellPhone = value;
    }
            public String getA1WorkPhone() {
        return a1WorkPhone;
    }

    public void setA1WorkPhone(String value) {
        this.a1WorkPhone = value;
    }
            public String getA1WorkPhoneExt() {
        return a1WorkPhoneExt;
    }

    public void setA1WorkPhoneExt(String value) {
        this.a1WorkPhoneExt = value;
    }
            public String getA1Email() {
        return a1Email;
    }

    public void setA1Email(String value) {
        this.a1Email = value;
    }
            public String getA1Birthdate() {
        return a1Birthdate;
    }

    public void setA1Birthdate(String value) {
        this.a1Birthdate = value;
    }
            public String getA1BillFirstName() {
        return a1BillFirstName;
    }

    public void setA1BillFirstName(String value) {
        this.a1BillFirstName = value;
    }
            public String getA1BillMi() {
        return a1BillMi;
    }

    public void setA1BillMi(String value) {
        this.a1BillMi = value;
    }
            public String getA1BillLastName() {
        return a1BillLastName;
    }

    public void setA1BillLastName(String value) {
        this.a1BillLastName = value;
    }
            public String getA1BillCompanyName() {
        return a1BillCompanyName;
    }

    public void setA1BillCompanyName(String value) {
        this.a1BillCompanyName = value;
    }
            public String getA1BillAddress1() {
        return a1BillAddress1;
    }

    public void setA1BillAddress1(String value) {
        this.a1BillAddress1 = value;
    }
            public String getA1BillAddress2() {
        return a1BillAddress2;
    }

    public void setA1BillAddress2(String value) {
        this.a1BillAddress2 = value;
    }
            public String getA1BillCity() {
        return a1BillCity;
    }

    public void setA1BillCity(String value) {
        this.a1BillCity = value;
    }
            public String getA1BillLocality() {
        return a1BillLocality;
    }

    public void setA1BillLocality(String value) {
        this.a1BillLocality = value;
    }
            public String getA1BillStateProv() {
        return a1BillStateProv;
    }

    public void setA1BillStateProv(String value) {
        this.a1BillStateProv = value;
    }
            public String getA1BillCountry() {
        return a1BillCountry;
    }

    public void setA1BillCountry(String value) {
        this.a1BillCountry = value;
    }
            public String getA1BillPostalCd() {
        return a1BillPostalCd;
    }

    public void setA1BillPostalCd(String value) {
        this.a1BillPostalCd = value;
    }
            public String getA1BillPhone() {
        return a1BillPhone;
    }

    public void setA1BillPhone(String value) {
        this.a1BillPhone = value;
    }
            public String getA1BillPhoneExt() {
        return a1BillPhoneExt;
    }

    public void setA1BillPhoneExt(String value) {
        this.a1BillPhoneExt = value;
    }
            public String getA1BillCellPhone() {
        return a1BillCellPhone;
    }

    public void setA1BillCellPhone(String value) {
        this.a1BillCellPhone = value;
    }
            public String getA1BillWorkPhone() {
        return a1BillWorkPhone;
    }

    public void setA1BillWorkPhone(String value) {
        this.a1BillWorkPhone = value;
    }
            public String getA1BillWorkPhoneExt() {
        return a1BillWorkPhoneExt;
    }

    public void setA1BillWorkPhoneExt(String value) {
        this.a1BillWorkPhoneExt = value;
    }
            public String getA1BillEmail() {
        return a1BillEmail;
    }

    public void setA1BillEmail(String value) {
        this.a1BillEmail = value;
    }
            public Long getA1PayMethod() {
        return a1PayMethod;
    }

    public void setA1PayMethod(Long value) {
        this.a1PayMethod = value;
    }
            public String getA1CcNumber() {
        return a1CcNumber;
    }

    public void setA1CcNumber(String value) {
        this.a1CcNumber = value;
    }
            public Long getA1CcExpireMm() {
        return a1CcExpireMm;
    }

    public void setA1CcExpireMm(Long value) {
        this.a1CcExpireMm = value;
    }
            public Long getA1CcExpireYyyy() {
        return a1CcExpireYyyy;
    }

    public void setA1CcExpireYyyy(Long value) {
        this.a1CcExpireYyyy = value;
    }
            public String getA1BankAcctNo() {
        return a1BankAcctNo;
    }

    public void setA1BankAcctNo(String value) {
        this.a1BankAcctNo = value;
    }
            public String getA1BankRoutingNo() {
        return a1BankRoutingNo;
    }

    public void setA1BankRoutingNo(String value) {
        this.a1BankRoutingNo = value;
    }
            public Long getA1RespLevelCd() {
        return a1RespLevelCd;
    }

    public void setA1RespLevelCd(Long value) {
        this.a1RespLevelCd = value;
    }
            public A1FunctionalAcctGroupsArray getA1FunctionalAcctGroups() {
        return a1FunctionalAcctGroups;
    }

    public void setA1FunctionalAcctGroups(A1FunctionalAcctGroupsArray value) {
        this.a1FunctionalAcctGroups = value;
    }
            public A1CollectionsAcctGroupsArray getA1CollectionsAcctGroups() {
        return a1CollectionsAcctGroups;
    }

    public void setA1CollectionsAcctGroups(A1CollectionsAcctGroupsArray value) {
        this.a1CollectionsAcctGroups = value;
    }
            public A1SuppFieldNamesArray getA1SuppFieldNames() {
        return a1SuppFieldNames;
    }

    public void setA1SuppFieldNames(A1SuppFieldNamesArray value) {
        this.a1SuppFieldNames = value;
    }
            public A1SuppFieldValuesArray getA1SuppFieldValues() {
        return a1SuppFieldValues;
    }

    public void setA1SuppFieldValues(A1SuppFieldValuesArray value) {
        this.a1SuppFieldValues = value;
    }
            public Long getA1TestAcctInd() {
        return a1TestAcctInd;
    }

    public void setA1TestAcctInd(Long value) {
        this.a1TestAcctInd = value;
    }
            public Long getA1StatusUntilAltStart() {
        return a1StatusUntilAltStart;
    }

    public void setA1StatusUntilAltStart(Long value) {
        this.a1StatusUntilAltStart = value;
    }
            public Double getA1BalanceForward() {
        return a1BalanceForward;
    }

    public void setA1BalanceForward(Double value) {
        this.a1BalanceForward = value;
    }
            public Long getA1AltBillDay() {
        return a1AltBillDay;
    }

    public void setA1AltBillDay(Long value) {
        this.a1AltBillDay = value;
    }
            public String getA1DoFullInvoicing() {
        return a1DoFullInvoicing;
    }

    public void setA1DoFullInvoicing(String value) {
        this.a1DoFullInvoicing = value;
    }
            public String getA1DoProratedInvoicing() {
        return a1DoProratedInvoicing;
    }

    public void setA1DoProratedInvoicing(String value) {
        this.a1DoProratedInvoicing = value;
    }
            public Long getA1MasterPlanAltRateSchedNo() {
        return a1MasterPlanAltRateSchedNo;
    }

    public void setA1MasterPlanAltRateSchedNo(Long value) {
        this.a1MasterPlanAltRateSchedNo = value;
    }
            public A1SuppPlanAltRateSchedNoArray getA1SuppPlanAltRateSchedNo() {
        return a1SuppPlanAltRateSchedNo;
    }

    public void setA1SuppPlanAltRateSchedNo(A1SuppPlanAltRateSchedNoArray value) {
        this.a1SuppPlanAltRateSchedNo = value;
    }
            public String getA1CurrencyCd() {
        return a1CurrencyCd;
    }

    public void setA1CurrencyCd(String value) {
        this.a1CurrencyCd = value;
    }
            public String getA1Cvv() {
        return a1Cvv;
    }

    public void setA1Cvv(String value) {
        this.a1Cvv = value;
    }
            public String getA1TaxpayerId() {
        return a1TaxpayerId;
    }

    public void setA1TaxpayerId(String value) {
        this.a1TaxpayerId = value;
    }
            public String getA1BillAgreementId() {
        return a1BillAgreementId;
    }

    public void setA1BillAgreementId(String value) {
        this.a1BillAgreementId = value;
    }
            public String getA1RetroactiveStartDate() {
        return a1RetroactiveStartDate;
    }

    public void setA1RetroactiveStartDate(String value) {
        this.a1RetroactiveStartDate = value;
    }
            public A1CouponCodesArray getA1CouponCodes() {
        return a1CouponCodes;
    }

    public void setA1CouponCodes(A1CouponCodesArray value) {
        this.a1CouponCodes = value;
    }
            public A1NewAcctCustomRatesArray getA1NewAcctCustomRates() {
        return a1NewAcctCustomRates;
    }

    public void setA1NewAcctCustomRates(A1NewAcctCustomRatesArray value) {
        this.a1NewAcctCustomRates = value;
    }
            public Long getA1AltMsgTemplateNo() {
        return a1AltMsgTemplateNo;
    }

    public void setA1AltMsgTemplateNo(Long value) {
        this.a1AltMsgTemplateNo = value;
    }
            public Long getA1SeqFuncGroupNo() {
        return a1SeqFuncGroupNo;
    }

    public void setA1SeqFuncGroupNo(Long value) {
        this.a1SeqFuncGroupNo = value;
    }
            public A1NewAcctPlanContractsArray getA1NewAcctPlanContracts() {
        return a1NewAcctPlanContracts;
    }

    public void setA1NewAcctPlanContracts(A1NewAcctPlanContractsArray value) {
        this.a1NewAcctPlanContracts = value;
    }
            public String getA1BankAcctType() {
        return a1BankAcctType;
    }

    public void setA1BankAcctType(String value) {
        this.a1BankAcctType = value;
    }
            public String getA1Address3() {
        return a1Address3;
    }

    public void setA1Address3(String value) {
        this.a1Address3 = value;
    }
            public String getA1BillAddress3() {
        return a1BillAddress3;
    }

    public void setA1BillAddress3(String value) {
        this.a1BillAddress3 = value;
    }
            public A1UsageAccumulationConfigArray getA1UsageAccumulationConfig() {
        return a1UsageAccumulationConfig;
    }

    public void setA1UsageAccumulationConfig(A1UsageAccumulationConfigArray value) {
        this.a1UsageAccumulationConfig = value;
    }
            public A1EnableUsagePoolingPlanNoArray getA1EnableUsagePoolingPlanNo() {
        return a1EnableUsagePoolingPlanNo;
    }

    public void setA1EnableUsagePoolingPlanNo(A1EnableUsagePoolingPlanNoArray value) {
        this.a1EnableUsagePoolingPlanNo = value;
    }
            public A1ClientFuncAcctGroupIdsArray getA1ClientFuncAcctGroupIds() {
        return a1ClientFuncAcctGroupIds;
    }

    public void setA1ClientFuncAcctGroupIds(A1ClientFuncAcctGroupIdsArray value) {
        this.a1ClientFuncAcctGroupIds = value;
    }
            public A1ClientCollAcctGroupIdsArray getA1ClientCollAcctGroupIds() {
        return a1ClientCollAcctGroupIds;
    }

    public void setA1ClientCollAcctGroupIds(A1ClientCollAcctGroupIdsArray value) {
        this.a1ClientCollAcctGroupIds = value;
    }
            public String getA1TrackData1() {
        return a1TrackData1;
    }

    public void setA1TrackData1(String value) {
        this.a1TrackData1 = value;
    }
            public String getA1TrackData2() {
        return a1TrackData2;
    }

    public void setA1TrackData2(String value) {
        this.a1TrackData2 = value;
    }
            public Long getA1TaxExemptionLevel() {
        return a1TaxExemptionLevel;
    }

    public void setA1TaxExemptionLevel(Long value) {
        this.a1TaxExemptionLevel = value;
    }
            public Long getA1CnAltMsgTemplateNo() {
        return a1CnAltMsgTemplateNo;
    }

    public void setA1CnAltMsgTemplateNo(Long value) {
        this.a1CnAltMsgTemplateNo = value;
    }
            public String getA1InvoiceApprovalRequired() {
        return a1InvoiceApprovalRequired;
    }

    public void setA1InvoiceApprovalRequired(String value) {
        this.a1InvoiceApprovalRequired = value;
    }
            public String getA1CreateSession() {
        return a1CreateSession;
    }

    public void setA1CreateSession(String value) {
        this.a1CreateSession = value;
    }
            public String getA1ClientMasterPlanId() {
        return a1ClientMasterPlanId;
    }

    public void setA1ClientMasterPlanId(String value) {
        this.a1ClientMasterPlanId = value;
    }
            public A1ClientSuppPlanIdsArray getA1ClientSuppPlanIds() {
        return a1ClientSuppPlanIds;
    }

    public void setA1ClientSuppPlanIds(A1ClientSuppPlanIdsArray value) {
        this.a1ClientSuppPlanIds = value;
    }
            public String getA1ClientMpAltRateSchedId() {
        return a1ClientMpAltRateSchedId;
    }

    public void setA1ClientMpAltRateSchedId(String value) {
        this.a1ClientMpAltRateSchedId = value;
    }
            public A1ClientSpAltRateSchedIdsArray getA1ClientSpAltRateSchedIds() {
        return a1ClientSpAltRateSchedIds;
    }

    public void setA1ClientSpAltRateSchedIds(A1ClientSpAltRateSchedIdsArray value) {
        this.a1ClientSpAltRateSchedIds = value;
    }
            public String getA1ClientAltMsgTemplateId() {
        return a1ClientAltMsgTemplateId;
    }

    public void setA1ClientAltMsgTemplateId(String value) {
        this.a1ClientAltMsgTemplateId = value;
    }
            public String getA1ClientCnAltMsgTemplateNo() {
        return a1ClientCnAltMsgTemplateNo;
    }

    public void setA1ClientCnAltMsgTemplateNo(String value) {
        this.a1ClientCnAltMsgTemplateNo = value;
    }
            public String getA1Iban() {
        return a1Iban;
    }

    public void setA1Iban(String value) {
        this.a1Iban = value;
    }
            public Long getA1BankCheckDigit() {
        return a1BankCheckDigit;
    }

    public void setA1BankCheckDigit(Long value) {
        this.a1BankCheckDigit = value;
    }
            public String getA1BankSwiftCd() {
        return a1BankSwiftCd;
    }

    public void setA1BankSwiftCd(String value) {
        this.a1BankSwiftCd = value;
    }
            public String getA1BankCountryCd() {
        return a1BankCountryCd;
    }

    public void setA1BankCountryCd(String value) {
        this.a1BankCountryCd = value;
    }
            public String getA1MandateId() {
        return a1MandateId;
    }

    public void setA1MandateId(String value) {
        this.a1MandateId = value;
    }
            public String getA1BankIdCd() {
        return a1BankIdCd;
    }

    public void setA1BankIdCd(String value) {
        this.a1BankIdCd = value;
    }
            public String getA1BankBranchCd() {
        return a1BankBranchCd;
    }

    public void setA1BankBranchCd(String value) {
        this.a1BankBranchCd = value;
    }
            public A1SurchargeNoArray getA1SurchargeNo() {
        return a1SurchargeNo;
    }

    public void setA1SurchargeNo(A1SurchargeNoArray value) {
        this.a1SurchargeNo = value;
    }
            public String getA1BkupBillFirstName() {
        return a1BkupBillFirstName;
    }

    public void setA1BkupBillFirstName(String value) {
        this.a1BkupBillFirstName = value;
    }
            public String getA1BkupBillMi() {
        return a1BkupBillMi;
    }

    public void setA1BkupBillMi(String value) {
        this.a1BkupBillMi = value;
    }
            public String getA1BkupBillLastName() {
        return a1BkupBillLastName;
    }

    public void setA1BkupBillLastName(String value) {
        this.a1BkupBillLastName = value;
    }
            public String getA1BkupBillCompanyName() {
        return a1BkupBillCompanyName;
    }

    public void setA1BkupBillCompanyName(String value) {
        this.a1BkupBillCompanyName = value;
    }
            public String getA1BkupBillAddress1() {
        return a1BkupBillAddress1;
    }

    public void setA1BkupBillAddress1(String value) {
        this.a1BkupBillAddress1 = value;
    }
            public String getA1BkupBillAddress2() {
        return a1BkupBillAddress2;
    }

    public void setA1BkupBillAddress2(String value) {
        this.a1BkupBillAddress2 = value;
    }
            public String getA1BkupBillAddress3() {
        return a1BkupBillAddress3;
    }

    public void setA1BkupBillAddress3(String value) {
        this.a1BkupBillAddress3 = value;
    }
            public String getA1BkupBillCity() {
        return a1BkupBillCity;
    }

    public void setA1BkupBillCity(String value) {
        this.a1BkupBillCity = value;
    }
            public String getA1BkupBillLocality() {
        return a1BkupBillLocality;
    }

    public void setA1BkupBillLocality(String value) {
        this.a1BkupBillLocality = value;
    }
            public String getA1BkupBillStateProv() {
        return a1BkupBillStateProv;
    }

    public void setA1BkupBillStateProv(String value) {
        this.a1BkupBillStateProv = value;
    }
            public String getA1BkupBillCountry() {
        return a1BkupBillCountry;
    }

    public void setA1BkupBillCountry(String value) {
        this.a1BkupBillCountry = value;
    }
            public String getA1BkupBillPostalCd() {
        return a1BkupBillPostalCd;
    }

    public void setA1BkupBillPostalCd(String value) {
        this.a1BkupBillPostalCd = value;
    }
            public String getA1BkupBillPhone() {
        return a1BkupBillPhone;
    }

    public void setA1BkupBillPhone(String value) {
        this.a1BkupBillPhone = value;
    }
            public String getA1BkupBillPhoneExt() {
        return a1BkupBillPhoneExt;
    }

    public void setA1BkupBillPhoneExt(String value) {
        this.a1BkupBillPhoneExt = value;
    }
            public String getA1BkupBillCellPhone() {
        return a1BkupBillCellPhone;
    }

    public void setA1BkupBillCellPhone(String value) {
        this.a1BkupBillCellPhone = value;
    }
            public String getA1BkupBillWorkPhone() {
        return a1BkupBillWorkPhone;
    }

    public void setA1BkupBillWorkPhone(String value) {
        this.a1BkupBillWorkPhone = value;
    }
            public String getA1BkupBillWorkPhoneExt() {
        return a1BkupBillWorkPhoneExt;
    }

    public void setA1BkupBillWorkPhoneExt(String value) {
        this.a1BkupBillWorkPhoneExt = value;
    }
            public String getA1BkupBillEmail() {
        return a1BkupBillEmail;
    }

    public void setA1BkupBillEmail(String value) {
        this.a1BkupBillEmail = value;
    }
            public Long getA1BkupPayMethod() {
        return a1BkupPayMethod;
    }

    public void setA1BkupPayMethod(Long value) {
        this.a1BkupPayMethod = value;
    }
            public String getA1BkupCcNumber() {
        return a1BkupCcNumber;
    }

    public void setA1BkupCcNumber(String value) {
        this.a1BkupCcNumber = value;
    }
            public Long getA1BkupCcExpireMm() {
        return a1BkupCcExpireMm;
    }

    public void setA1BkupCcExpireMm(Long value) {
        this.a1BkupCcExpireMm = value;
    }
            public Long getA1BkupCcExpireYyyy() {
        return a1BkupCcExpireYyyy;
    }

    public void setA1BkupCcExpireYyyy(Long value) {
        this.a1BkupCcExpireYyyy = value;
    }
            public String getA1BkupBankAcctNo() {
        return a1BkupBankAcctNo;
    }

    public void setA1BkupBankAcctNo(String value) {
        this.a1BkupBankAcctNo = value;
    }
            public String getA1BkupBankRoutingNo() {
        return a1BkupBankRoutingNo;
    }

    public void setA1BkupBankRoutingNo(String value) {
        this.a1BkupBankRoutingNo = value;
    }
            public String getA1BkupBankAcctType() {
        return a1BkupBankAcctType;
    }

    public void setA1BkupBankAcctType(String value) {
        this.a1BkupBankAcctType = value;
    }
            public String getA1BkupBillAgreementId() {
        return a1BkupBillAgreementId;
    }

    public void setA1BkupBillAgreementId(String value) {
        this.a1BkupBillAgreementId = value;
    }
            public String getA1BkupCvv() {
        return a1BkupCvv;
    }

    public void setA1BkupCvv(String value) {
        this.a1BkupCvv = value;
    }
            public String getA1SeqFuncGroupId() {
        return a1SeqFuncGroupId;
    }

    public void setA1SeqFuncGroupId(String value) {
        this.a1SeqFuncGroupId = value;
    }
            public Long getA1RevrecProfileId() {
        return a1RevrecProfileId;
    }

    public void setA1RevrecProfileId(Long value) {
        this.a1RevrecProfileId = value;
    }
            public String getA1RevrecClientDefinedId() {
        return a1RevrecClientDefinedId;
    }

    public void setA1RevrecClientDefinedId(String value) {
        this.a1RevrecClientDefinedId = value;
    }
                public String getA1StmntEmailListCc() {
        return a1StmntEmailListCc;
    }

    public void setA1StmntEmailListCc(String value) {
        this.a1StmntEmailListCc = value;
    }
            public String getA1StmntEmailListBcc() {
        return a1StmntEmailListBcc;
    }

    public void setA1StmntEmailListBcc(String value) {
        this.a1StmntEmailListBcc = value;
    }
            public Long getA1InvoicePostingMethodCd() {
        return a1InvoicePostingMethodCd;
    }

    public void setA1InvoicePostingMethodCd(Long value) {
        this.a1InvoicePostingMethodCd = value;
    }
            public String getA1AcctStartDate() {
        return a1AcctStartDate;
    }

    public void setA1AcctStartDate(String value) {
        this.a1AcctStartDate = value;
    }
            public Long getA1MinStatementThreshold() {
        return a1MinStatementThreshold;
    }

    public void setA1MinStatementThreshold(Long value) {
        this.a1MinStatementThreshold = value;
    }
            public Long getA1MaxStatementsToDefer() {
        return a1MaxStatementsToDefer;
    }

    public void setA1MaxStatementsToDefer(Long value) {
        this.a1MaxStatementsToDefer = value;
    }
            public Long getA1DeferFullStatementsOnly() {
        return a1DeferFullStatementsOnly;
    }

    public void setA1DeferFullStatementsOnly(Long value) {
        this.a1DeferFullStatementsOnly = value;
    }
            public Long getA1CcId() {
        return a1CcId;
    }

    public void setA1CcId(Long value) {
        this.a1CcId = value;
    }
            public Long getA1BkupCcId() {
        return a1BkupCcId;
    }

    public void setA1BkupCcId(Long value) {
        this.a1BkupCcId = value;
    }
            public String getA2AltStartDate() {
        return a2AltStartDate;
    }

    public void setA2AltStartDate(String value) {
        this.a2AltStartDate = value;
    }
            public String getA2ClientAcctId() {
        return a2ClientAcctId;
    }

    public void setA2ClientAcctId(String value) {
        this.a2ClientAcctId = value;
    }
            public String getA2Userid() {
        return a2Userid;
    }

    public void setA2Userid(String value) {
        this.a2Userid = value;
    }
            public Long getA2StatusCd() {
        return a2StatusCd;
    }

    public void setA2StatusCd(Long value) {
        this.a2StatusCd = value;
    }
            public Long getA2MasterPlanNo() {
        return a2MasterPlanNo;
    }

    public void setA2MasterPlanNo(Long value) {
        this.a2MasterPlanNo = value;
    }
            public Long getA2MasterPlanUnits() {
        return a2MasterPlanUnits;
    }

    public void setA2MasterPlanUnits(Long value) {
        this.a2MasterPlanUnits = value;
    }
            public A2SuppPlansArray getA2SuppPlans() {
        return a2SuppPlans;
    }

    public void setA2SuppPlans(A2SuppPlansArray value) {
        this.a2SuppPlans = value;
    }
            public A2SuppPlanUnitsArray getA2SuppPlanUnits() {
        return a2SuppPlanUnits;
    }

    public void setA2SuppPlanUnits(A2SuppPlanUnitsArray value) {
        this.a2SuppPlanUnits = value;
    }
            public Long getA2NotifyMethod() {
        return a2NotifyMethod;
    }

    public void setA2NotifyMethod(Long value) {
        this.a2NotifyMethod = value;
    }
            public String getA2PromoCd() {
        return a2PromoCd;
    }

    public void setA2PromoCd(String value) {
        this.a2PromoCd = value;
    }
            public String getA2Password() {
        return a2Password;
    }

    public void setA2Password(String value) {
        this.a2Password = value;
    }
            public String getA2SecretQuestion() {
        return a2SecretQuestion;
    }

    public void setA2SecretQuestion(String value) {
        this.a2SecretQuestion = value;
    }
            public String getA2SecretQuestionAnswer() {
        return a2SecretQuestionAnswer;
    }

    public void setA2SecretQuestionAnswer(String value) {
        this.a2SecretQuestionAnswer = value;
    }
            public String getA2FirstName() {
        return a2FirstName;
    }

    public void setA2FirstName(String value) {
        this.a2FirstName = value;
    }
            public String getA2Mi() {
        return a2Mi;
    }

    public void setA2Mi(String value) {
        this.a2Mi = value;
    }
            public String getA2LastName() {
        return a2LastName;
    }

    public void setA2LastName(String value) {
        this.a2LastName = value;
    }
            public String getA2CompanyName() {
        return a2CompanyName;
    }

    public void setA2CompanyName(String value) {
        this.a2CompanyName = value;
    }
            public String getA2Address1() {
        return a2Address1;
    }

    public void setA2Address1(String value) {
        this.a2Address1 = value;
    }
            public String getA2Address2() {
        return a2Address2;
    }

    public void setA2Address2(String value) {
        this.a2Address2 = value;
    }
            public String getA2City() {
        return a2City;
    }

    public void setA2City(String value) {
        this.a2City = value;
    }
            public String getA2Locality() {
        return a2Locality;
    }

    public void setA2Locality(String value) {
        this.a2Locality = value;
    }
            public String getA2StateProv() {
        return a2StateProv;
    }

    public void setA2StateProv(String value) {
        this.a2StateProv = value;
    }
            public String getA2Country() {
        return a2Country;
    }

    public void setA2Country(String value) {
        this.a2Country = value;
    }
            public String getA2PostalCd() {
        return a2PostalCd;
    }

    public void setA2PostalCd(String value) {
        this.a2PostalCd = value;
    }
            public String getA2Phone() {
        return a2Phone;
    }

    public void setA2Phone(String value) {
        this.a2Phone = value;
    }
            public String getA2PhoneExt() {
        return a2PhoneExt;
    }

    public void setA2PhoneExt(String value) {
        this.a2PhoneExt = value;
    }
            public String getA2CellPhone() {
        return a2CellPhone;
    }

    public void setA2CellPhone(String value) {
        this.a2CellPhone = value;
    }
            public String getA2WorkPhone() {
        return a2WorkPhone;
    }

    public void setA2WorkPhone(String value) {
        this.a2WorkPhone = value;
    }
            public String getA2WorkPhoneExt() {
        return a2WorkPhoneExt;
    }

    public void setA2WorkPhoneExt(String value) {
        this.a2WorkPhoneExt = value;
    }
            public String getA2Email() {
        return a2Email;
    }

    public void setA2Email(String value) {
        this.a2Email = value;
    }
            public String getA2Birthdate() {
        return a2Birthdate;
    }

    public void setA2Birthdate(String value) {
        this.a2Birthdate = value;
    }
            public String getA2BillFirstName() {
        return a2BillFirstName;
    }

    public void setA2BillFirstName(String value) {
        this.a2BillFirstName = value;
    }
            public String getA2BillMi() {
        return a2BillMi;
    }

    public void setA2BillMi(String value) {
        this.a2BillMi = value;
    }
            public String getA2BillLastName() {
        return a2BillLastName;
    }

    public void setA2BillLastName(String value) {
        this.a2BillLastName = value;
    }
            public String getA2BillCompanyName() {
        return a2BillCompanyName;
    }

    public void setA2BillCompanyName(String value) {
        this.a2BillCompanyName = value;
    }
            public String getA2BillAddress1() {
        return a2BillAddress1;
    }

    public void setA2BillAddress1(String value) {
        this.a2BillAddress1 = value;
    }
            public String getA2BillAddress2() {
        return a2BillAddress2;
    }

    public void setA2BillAddress2(String value) {
        this.a2BillAddress2 = value;
    }
            public String getA2BillCity() {
        return a2BillCity;
    }

    public void setA2BillCity(String value) {
        this.a2BillCity = value;
    }
            public String getA2BillLocality() {
        return a2BillLocality;
    }

    public void setA2BillLocality(String value) {
        this.a2BillLocality = value;
    }
            public String getA2BillStateProv() {
        return a2BillStateProv;
    }

    public void setA2BillStateProv(String value) {
        this.a2BillStateProv = value;
    }
            public String getA2BillCountry() {
        return a2BillCountry;
    }

    public void setA2BillCountry(String value) {
        this.a2BillCountry = value;
    }
            public String getA2BillPostalCd() {
        return a2BillPostalCd;
    }

    public void setA2BillPostalCd(String value) {
        this.a2BillPostalCd = value;
    }
            public String getA2BillPhone() {
        return a2BillPhone;
    }

    public void setA2BillPhone(String value) {
        this.a2BillPhone = value;
    }
            public String getA2BillPhoneExt() {
        return a2BillPhoneExt;
    }

    public void setA2BillPhoneExt(String value) {
        this.a2BillPhoneExt = value;
    }
            public String getA2BillCellPhone() {
        return a2BillCellPhone;
    }

    public void setA2BillCellPhone(String value) {
        this.a2BillCellPhone = value;
    }
            public String getA2BillWorkPhone() {
        return a2BillWorkPhone;
    }

    public void setA2BillWorkPhone(String value) {
        this.a2BillWorkPhone = value;
    }
            public String getA2BillWorkPhoneExt() {
        return a2BillWorkPhoneExt;
    }

    public void setA2BillWorkPhoneExt(String value) {
        this.a2BillWorkPhoneExt = value;
    }
            public String getA2BillEmail() {
        return a2BillEmail;
    }

    public void setA2BillEmail(String value) {
        this.a2BillEmail = value;
    }
            public Long getA2PayMethod() {
        return a2PayMethod;
    }

    public void setA2PayMethod(Long value) {
        this.a2PayMethod = value;
    }
            public String getA2CcNumber() {
        return a2CcNumber;
    }

    public void setA2CcNumber(String value) {
        this.a2CcNumber = value;
    }
            public Long getA2CcExpireMm() {
        return a2CcExpireMm;
    }

    public void setA2CcExpireMm(Long value) {
        this.a2CcExpireMm = value;
    }
            public Long getA2CcExpireYyyy() {
        return a2CcExpireYyyy;
    }

    public void setA2CcExpireYyyy(Long value) {
        this.a2CcExpireYyyy = value;
    }
            public String getA2BankAcctNo() {
        return a2BankAcctNo;
    }

    public void setA2BankAcctNo(String value) {
        this.a2BankAcctNo = value;
    }
            public String getA2BankRoutingNo() {
        return a2BankRoutingNo;
    }

    public void setA2BankRoutingNo(String value) {
        this.a2BankRoutingNo = value;
    }
            public Long getA2RespLevelCd() {
        return a2RespLevelCd;
    }

    public void setA2RespLevelCd(Long value) {
        this.a2RespLevelCd = value;
    }
            public A2FunctionalAcctGroupsArray getA2FunctionalAcctGroups() {
        return a2FunctionalAcctGroups;
    }

    public void setA2FunctionalAcctGroups(A2FunctionalAcctGroupsArray value) {
        this.a2FunctionalAcctGroups = value;
    }
            public A2CollectionsAcctGroupsArray getA2CollectionsAcctGroups() {
        return a2CollectionsAcctGroups;
    }

    public void setA2CollectionsAcctGroups(A2CollectionsAcctGroupsArray value) {
        this.a2CollectionsAcctGroups = value;
    }
            public A2SuppFieldNamesArray getA2SuppFieldNames() {
        return a2SuppFieldNames;
    }

    public void setA2SuppFieldNames(A2SuppFieldNamesArray value) {
        this.a2SuppFieldNames = value;
    }
            public A2SuppFieldValuesArray getA2SuppFieldValues() {
        return a2SuppFieldValues;
    }

    public void setA2SuppFieldValues(A2SuppFieldValuesArray value) {
        this.a2SuppFieldValues = value;
    }
            public Long getA2TestAcctInd() {
        return a2TestAcctInd;
    }

    public void setA2TestAcctInd(Long value) {
        this.a2TestAcctInd = value;
    }
            public Long getA2StatusUntilAltStart() {
        return a2StatusUntilAltStart;
    }

    public void setA2StatusUntilAltStart(Long value) {
        this.a2StatusUntilAltStart = value;
    }
            public Double getA2BalanceForward() {
        return a2BalanceForward;
    }

    public void setA2BalanceForward(Double value) {
        this.a2BalanceForward = value;
    }
            public Long getA2AltBillDay() {
        return a2AltBillDay;
    }

    public void setA2AltBillDay(Long value) {
        this.a2AltBillDay = value;
    }
            public String getA2DoFullInvoicing() {
        return a2DoFullInvoicing;
    }

    public void setA2DoFullInvoicing(String value) {
        this.a2DoFullInvoicing = value;
    }
            public String getA2DoProratedInvoicing() {
        return a2DoProratedInvoicing;
    }

    public void setA2DoProratedInvoicing(String value) {
        this.a2DoProratedInvoicing = value;
    }
            public Long getA2MasterPlanAltRateSchedNo() {
        return a2MasterPlanAltRateSchedNo;
    }

    public void setA2MasterPlanAltRateSchedNo(Long value) {
        this.a2MasterPlanAltRateSchedNo = value;
    }
            public A2SuppPlanAltRateSchedNoArray getA2SuppPlanAltRateSchedNo() {
        return a2SuppPlanAltRateSchedNo;
    }

    public void setA2SuppPlanAltRateSchedNo(A2SuppPlanAltRateSchedNoArray value) {
        this.a2SuppPlanAltRateSchedNo = value;
    }
            public String getA2CurrencyCd() {
        return a2CurrencyCd;
    }

    public void setA2CurrencyCd(String value) {
        this.a2CurrencyCd = value;
    }
            public String getA2Cvv() {
        return a2Cvv;
    }

    public void setA2Cvv(String value) {
        this.a2Cvv = value;
    }
            public String getA2TaxpayerId() {
        return a2TaxpayerId;
    }

    public void setA2TaxpayerId(String value) {
        this.a2TaxpayerId = value;
    }
            public String getA2BillAgreementId() {
        return a2BillAgreementId;
    }

    public void setA2BillAgreementId(String value) {
        this.a2BillAgreementId = value;
    }
            public String getA2RetroactiveStartDate() {
        return a2RetroactiveStartDate;
    }

    public void setA2RetroactiveStartDate(String value) {
        this.a2RetroactiveStartDate = value;
    }
            public A2CouponCodesArray getA2CouponCodes() {
        return a2CouponCodes;
    }

    public void setA2CouponCodes(A2CouponCodesArray value) {
        this.a2CouponCodes = value;
    }
            public A2NewAcctCustomRatesArray getA2NewAcctCustomRates() {
        return a2NewAcctCustomRates;
    }

    public void setA2NewAcctCustomRates(A2NewAcctCustomRatesArray value) {
        this.a2NewAcctCustomRates = value;
    }
            public Long getA2AltMsgTemplateNo() {
        return a2AltMsgTemplateNo;
    }

    public void setA2AltMsgTemplateNo(Long value) {
        this.a2AltMsgTemplateNo = value;
    }
            public Long getA2SeqFuncGroupNo() {
        return a2SeqFuncGroupNo;
    }

    public void setA2SeqFuncGroupNo(Long value) {
        this.a2SeqFuncGroupNo = value;
    }
            public A2NewAcctPlanContractsArray getA2NewAcctPlanContracts() {
        return a2NewAcctPlanContracts;
    }

    public void setA2NewAcctPlanContracts(A2NewAcctPlanContractsArray value) {
        this.a2NewAcctPlanContracts = value;
    }
            public String getA2BankAcctType() {
        return a2BankAcctType;
    }

    public void setA2BankAcctType(String value) {
        this.a2BankAcctType = value;
    }
            public String getA2Address3() {
        return a2Address3;
    }

    public void setA2Address3(String value) {
        this.a2Address3 = value;
    }
            public String getA2BillAddress3() {
        return a2BillAddress3;
    }

    public void setA2BillAddress3(String value) {
        this.a2BillAddress3 = value;
    }
            public A2UsageAccumulationConfigArray getA2UsageAccumulationConfig() {
        return a2UsageAccumulationConfig;
    }

    public void setA2UsageAccumulationConfig(A2UsageAccumulationConfigArray value) {
        this.a2UsageAccumulationConfig = value;
    }
            public A2EnableUsagePoolingPlanNoArray getA2EnableUsagePoolingPlanNo() {
        return a2EnableUsagePoolingPlanNo;
    }

    public void setA2EnableUsagePoolingPlanNo(A2EnableUsagePoolingPlanNoArray value) {
        this.a2EnableUsagePoolingPlanNo = value;
    }
            public A2ClientFuncAcctGroupIdsArray getA2ClientFuncAcctGroupIds() {
        return a2ClientFuncAcctGroupIds;
    }

    public void setA2ClientFuncAcctGroupIds(A2ClientFuncAcctGroupIdsArray value) {
        this.a2ClientFuncAcctGroupIds = value;
    }
            public A2ClientCollAcctGroupIdsArray getA2ClientCollAcctGroupIds() {
        return a2ClientCollAcctGroupIds;
    }

    public void setA2ClientCollAcctGroupIds(A2ClientCollAcctGroupIdsArray value) {
        this.a2ClientCollAcctGroupIds = value;
    }
            public String getA2TrackData1() {
        return a2TrackData1;
    }

    public void setA2TrackData1(String value) {
        this.a2TrackData1 = value;
    }
            public String getA2TrackData2() {
        return a2TrackData2;
    }

    public void setA2TrackData2(String value) {
        this.a2TrackData2 = value;
    }
            public Long getA2TaxExemptionLevel() {
        return a2TaxExemptionLevel;
    }

    public void setA2TaxExemptionLevel(Long value) {
        this.a2TaxExemptionLevel = value;
    }
            public Long getA2CnAltMsgTemplateNo() {
        return a2CnAltMsgTemplateNo;
    }

    public void setA2CnAltMsgTemplateNo(Long value) {
        this.a2CnAltMsgTemplateNo = value;
    }
            public String getA2InvoiceApprovalRequired() {
        return a2InvoiceApprovalRequired;
    }

    public void setA2InvoiceApprovalRequired(String value) {
        this.a2InvoiceApprovalRequired = value;
    }
            public String getA2CreateSession() {
        return a2CreateSession;
    }

    public void setA2CreateSession(String value) {
        this.a2CreateSession = value;
    }
            public String getA2ClientMasterPlanId() {
        return a2ClientMasterPlanId;
    }

    public void setA2ClientMasterPlanId(String value) {
        this.a2ClientMasterPlanId = value;
    }
            public A2ClientSuppPlanIdsArray getA2ClientSuppPlanIds() {
        return a2ClientSuppPlanIds;
    }

    public void setA2ClientSuppPlanIds(A2ClientSuppPlanIdsArray value) {
        this.a2ClientSuppPlanIds = value;
    }
            public String getA2ClientMpAltRateSchedId() {
        return a2ClientMpAltRateSchedId;
    }

    public void setA2ClientMpAltRateSchedId(String value) {
        this.a2ClientMpAltRateSchedId = value;
    }
            public A2ClientSpAltRateSchedIdsArray getA2ClientSpAltRateSchedIds() {
        return a2ClientSpAltRateSchedIds;
    }

    public void setA2ClientSpAltRateSchedIds(A2ClientSpAltRateSchedIdsArray value) {
        this.a2ClientSpAltRateSchedIds = value;
    }
            public String getA2ClientAltMsgTemplateId() {
        return a2ClientAltMsgTemplateId;
    }

    public void setA2ClientAltMsgTemplateId(String value) {
        this.a2ClientAltMsgTemplateId = value;
    }
            public String getA2ClientCnAltMsgTemplateNo() {
        return a2ClientCnAltMsgTemplateNo;
    }

    public void setA2ClientCnAltMsgTemplateNo(String value) {
        this.a2ClientCnAltMsgTemplateNo = value;
    }
            public String getA2Iban() {
        return a2Iban;
    }

    public void setA2Iban(String value) {
        this.a2Iban = value;
    }
            public Long getA2BankCheckDigit() {
        return a2BankCheckDigit;
    }

    public void setA2BankCheckDigit(Long value) {
        this.a2BankCheckDigit = value;
    }
            public String getA2BankSwiftCd() {
        return a2BankSwiftCd;
    }

    public void setA2BankSwiftCd(String value) {
        this.a2BankSwiftCd = value;
    }
            public String getA2BankCountryCd() {
        return a2BankCountryCd;
    }

    public void setA2BankCountryCd(String value) {
        this.a2BankCountryCd = value;
    }
            public String getA2MandateId() {
        return a2MandateId;
    }

    public void setA2MandateId(String value) {
        this.a2MandateId = value;
    }
            public String getA2BankIdCd() {
        return a2BankIdCd;
    }

    public void setA2BankIdCd(String value) {
        this.a2BankIdCd = value;
    }
            public String getA2BankBranchCd() {
        return a2BankBranchCd;
    }

    public void setA2BankBranchCd(String value) {
        this.a2BankBranchCd = value;
    }
            public A2SurchargeNoArray getA2SurchargeNo() {
        return a2SurchargeNo;
    }

    public void setA2SurchargeNo(A2SurchargeNoArray value) {
        this.a2SurchargeNo = value;
    }
            public String getA2BkupBillFirstName() {
        return a2BkupBillFirstName;
    }

    public void setA2BkupBillFirstName(String value) {
        this.a2BkupBillFirstName = value;
    }
            public String getA2BkupBillMi() {
        return a2BkupBillMi;
    }

    public void setA2BkupBillMi(String value) {
        this.a2BkupBillMi = value;
    }
            public String getA2BkupBillLastName() {
        return a2BkupBillLastName;
    }

    public void setA2BkupBillLastName(String value) {
        this.a2BkupBillLastName = value;
    }
            public String getA2BkupBillCompanyName() {
        return a2BkupBillCompanyName;
    }

    public void setA2BkupBillCompanyName(String value) {
        this.a2BkupBillCompanyName = value;
    }
            public String getA2BkupBillAddress1() {
        return a2BkupBillAddress1;
    }

    public void setA2BkupBillAddress1(String value) {
        this.a2BkupBillAddress1 = value;
    }
            public String getA2BkupBillAddress2() {
        return a2BkupBillAddress2;
    }

    public void setA2BkupBillAddress2(String value) {
        this.a2BkupBillAddress2 = value;
    }
            public String getA2BkupBillAddress3() {
        return a2BkupBillAddress3;
    }

    public void setA2BkupBillAddress3(String value) {
        this.a2BkupBillAddress3 = value;
    }
            public String getA2BkupBillCity() {
        return a2BkupBillCity;
    }

    public void setA2BkupBillCity(String value) {
        this.a2BkupBillCity = value;
    }
            public String getA2BkupBillLocality() {
        return a2BkupBillLocality;
    }

    public void setA2BkupBillLocality(String value) {
        this.a2BkupBillLocality = value;
    }
            public String getA2BkupBillStateProv() {
        return a2BkupBillStateProv;
    }

    public void setA2BkupBillStateProv(String value) {
        this.a2BkupBillStateProv = value;
    }
            public String getA2BkupBillCountry() {
        return a2BkupBillCountry;
    }

    public void setA2BkupBillCountry(String value) {
        this.a2BkupBillCountry = value;
    }
            public String getA2BkupBillPostalCd() {
        return a2BkupBillPostalCd;
    }

    public void setA2BkupBillPostalCd(String value) {
        this.a2BkupBillPostalCd = value;
    }
            public String getA2BkupBillPhone() {
        return a2BkupBillPhone;
    }

    public void setA2BkupBillPhone(String value) {
        this.a2BkupBillPhone = value;
    }
            public String getA2BkupBillPhoneExt() {
        return a2BkupBillPhoneExt;
    }

    public void setA2BkupBillPhoneExt(String value) {
        this.a2BkupBillPhoneExt = value;
    }
            public String getA2BkupBillCellPhone() {
        return a2BkupBillCellPhone;
    }

    public void setA2BkupBillCellPhone(String value) {
        this.a2BkupBillCellPhone = value;
    }
            public String getA2BkupBillWorkPhone() {
        return a2BkupBillWorkPhone;
    }

    public void setA2BkupBillWorkPhone(String value) {
        this.a2BkupBillWorkPhone = value;
    }
            public String getA2BkupBillWorkPhoneExt() {
        return a2BkupBillWorkPhoneExt;
    }

    public void setA2BkupBillWorkPhoneExt(String value) {
        this.a2BkupBillWorkPhoneExt = value;
    }
            public String getA2BkupBillEmail() {
        return a2BkupBillEmail;
    }

    public void setA2BkupBillEmail(String value) {
        this.a2BkupBillEmail = value;
    }
            public Long getA2BkupPayMethod() {
        return a2BkupPayMethod;
    }

    public void setA2BkupPayMethod(Long value) {
        this.a2BkupPayMethod = value;
    }
            public String getA2BkupCcNumber() {
        return a2BkupCcNumber;
    }

    public void setA2BkupCcNumber(String value) {
        this.a2BkupCcNumber = value;
    }
            public Long getA2BkupCcExpireMm() {
        return a2BkupCcExpireMm;
    }

    public void setA2BkupCcExpireMm(Long value) {
        this.a2BkupCcExpireMm = value;
    }
            public Long getA2BkupCcExpireYyyy() {
        return a2BkupCcExpireYyyy;
    }

    public void setA2BkupCcExpireYyyy(Long value) {
        this.a2BkupCcExpireYyyy = value;
    }
            public String getA2BkupBankAcctNo() {
        return a2BkupBankAcctNo;
    }

    public void setA2BkupBankAcctNo(String value) {
        this.a2BkupBankAcctNo = value;
    }
            public String getA2BkupBankRoutingNo() {
        return a2BkupBankRoutingNo;
    }

    public void setA2BkupBankRoutingNo(String value) {
        this.a2BkupBankRoutingNo = value;
    }
            public String getA2BkupBankAcctType() {
        return a2BkupBankAcctType;
    }

    public void setA2BkupBankAcctType(String value) {
        this.a2BkupBankAcctType = value;
    }
            public String getA2BkupBillAgreementId() {
        return a2BkupBillAgreementId;
    }

    public void setA2BkupBillAgreementId(String value) {
        this.a2BkupBillAgreementId = value;
    }
            public String getA2BkupCvv() {
        return a2BkupCvv;
    }

    public void setA2BkupCvv(String value) {
        this.a2BkupCvv = value;
    }
            public String getA2SeqFuncGroupId() {
        return a2SeqFuncGroupId;
    }

    public void setA2SeqFuncGroupId(String value) {
        this.a2SeqFuncGroupId = value;
    }
            public Long getA2RevrecProfileId() {
        return a2RevrecProfileId;
    }

    public void setA2RevrecProfileId(Long value) {
        this.a2RevrecProfileId = value;
    }
            public String getA2RevrecClientDefinedId() {
        return a2RevrecClientDefinedId;
    }

    public void setA2RevrecClientDefinedId(String value) {
        this.a2RevrecClientDefinedId = value;
    }
                public String getA2StmntEmailListCc() {
        return a2StmntEmailListCc;
    }

    public void setA2StmntEmailListCc(String value) {
        this.a2StmntEmailListCc = value;
    }
            public String getA2StmntEmailListBcc() {
        return a2StmntEmailListBcc;
    }

    public void setA2StmntEmailListBcc(String value) {
        this.a2StmntEmailListBcc = value;
    }
            public Long getA2InvoicePostingMethodCd() {
        return a2InvoicePostingMethodCd;
    }

    public void setA2InvoicePostingMethodCd(Long value) {
        this.a2InvoicePostingMethodCd = value;
    }
            public String getA2AcctStartDate() {
        return a2AcctStartDate;
    }

    public void setA2AcctStartDate(String value) {
        this.a2AcctStartDate = value;
    }
            public Long getA2MinStatementThreshold() {
        return a2MinStatementThreshold;
    }

    public void setA2MinStatementThreshold(Long value) {
        this.a2MinStatementThreshold = value;
    }
            public Long getA2MaxStatementsToDefer() {
        return a2MaxStatementsToDefer;
    }

    public void setA2MaxStatementsToDefer(Long value) {
        this.a2MaxStatementsToDefer = value;
    }
            public Long getA2DeferFullStatementsOnly() {
        return a2DeferFullStatementsOnly;
    }

    public void setA2DeferFullStatementsOnly(Long value) {
        this.a2DeferFullStatementsOnly = value;
    }
            public Long getA2CcId() {
        return a2CcId;
    }

    public void setA2CcId(Long value) {
        this.a2CcId = value;
    }
            public Long getA2BkupCcId() {
        return a2BkupCcId;
    }

    public void setA2BkupCcId(Long value) {
        this.a2BkupCcId = value;
    }
            public String getA3AltStartDate() {
        return a3AltStartDate;
    }

    public void setA3AltStartDate(String value) {
        this.a3AltStartDate = value;
    }
            public String getA3ClientAcctId() {
        return a3ClientAcctId;
    }

    public void setA3ClientAcctId(String value) {
        this.a3ClientAcctId = value;
    }
            public String getA3Userid() {
        return a3Userid;
    }

    public void setA3Userid(String value) {
        this.a3Userid = value;
    }
            public Long getA3StatusCd() {
        return a3StatusCd;
    }

    public void setA3StatusCd(Long value) {
        this.a3StatusCd = value;
    }
            public Long getA3MasterPlanNo() {
        return a3MasterPlanNo;
    }

    public void setA3MasterPlanNo(Long value) {
        this.a3MasterPlanNo = value;
    }
            public Long getA3MasterPlanUnits() {
        return a3MasterPlanUnits;
    }

    public void setA3MasterPlanUnits(Long value) {
        this.a3MasterPlanUnits = value;
    }
            public A3SuppPlansArray getA3SuppPlans() {
        return a3SuppPlans;
    }

    public void setA3SuppPlans(A3SuppPlansArray value) {
        this.a3SuppPlans = value;
    }
            public A3SuppPlanUnitsArray getA3SuppPlanUnits() {
        return a3SuppPlanUnits;
    }

    public void setA3SuppPlanUnits(A3SuppPlanUnitsArray value) {
        this.a3SuppPlanUnits = value;
    }
            public Long getA3NotifyMethod() {
        return a3NotifyMethod;
    }

    public void setA3NotifyMethod(Long value) {
        this.a3NotifyMethod = value;
    }
            public String getA3PromoCd() {
        return a3PromoCd;
    }

    public void setA3PromoCd(String value) {
        this.a3PromoCd = value;
    }
            public String getA3Password() {
        return a3Password;
    }

    public void setA3Password(String value) {
        this.a3Password = value;
    }
            public String getA3SecretQuestion() {
        return a3SecretQuestion;
    }

    public void setA3SecretQuestion(String value) {
        this.a3SecretQuestion = value;
    }
            public String getA3SecretQuestionAnswer() {
        return a3SecretQuestionAnswer;
    }

    public void setA3SecretQuestionAnswer(String value) {
        this.a3SecretQuestionAnswer = value;
    }
            public String getA3FirstName() {
        return a3FirstName;
    }

    public void setA3FirstName(String value) {
        this.a3FirstName = value;
    }
            public String getA3Mi() {
        return a3Mi;
    }

    public void setA3Mi(String value) {
        this.a3Mi = value;
    }
            public String getA3LastName() {
        return a3LastName;
    }

    public void setA3LastName(String value) {
        this.a3LastName = value;
    }
            public String getA3CompanyName() {
        return a3CompanyName;
    }

    public void setA3CompanyName(String value) {
        this.a3CompanyName = value;
    }
            public String getA3Address1() {
        return a3Address1;
    }

    public void setA3Address1(String value) {
        this.a3Address1 = value;
    }
            public String getA3Address2() {
        return a3Address2;
    }

    public void setA3Address2(String value) {
        this.a3Address2 = value;
    }
            public String getA3City() {
        return a3City;
    }

    public void setA3City(String value) {
        this.a3City = value;
    }
            public String getA3Locality() {
        return a3Locality;
    }

    public void setA3Locality(String value) {
        this.a3Locality = value;
    }
            public String getA3StateProv() {
        return a3StateProv;
    }

    public void setA3StateProv(String value) {
        this.a3StateProv = value;
    }
            public String getA3Country() {
        return a3Country;
    }

    public void setA3Country(String value) {
        this.a3Country = value;
    }
            public String getA3PostalCd() {
        return a3PostalCd;
    }

    public void setA3PostalCd(String value) {
        this.a3PostalCd = value;
    }
            public String getA3Phone() {
        return a3Phone;
    }

    public void setA3Phone(String value) {
        this.a3Phone = value;
    }
            public String getA3PhoneExt() {
        return a3PhoneExt;
    }

    public void setA3PhoneExt(String value) {
        this.a3PhoneExt = value;
    }
            public String getA3CellPhone() {
        return a3CellPhone;
    }

    public void setA3CellPhone(String value) {
        this.a3CellPhone = value;
    }
            public String getA3WorkPhone() {
        return a3WorkPhone;
    }

    public void setA3WorkPhone(String value) {
        this.a3WorkPhone = value;
    }
            public String getA3WorkPhoneExt() {
        return a3WorkPhoneExt;
    }

    public void setA3WorkPhoneExt(String value) {
        this.a3WorkPhoneExt = value;
    }
            public String getA3Email() {
        return a3Email;
    }

    public void setA3Email(String value) {
        this.a3Email = value;
    }
            public String getA3Birthdate() {
        return a3Birthdate;
    }

    public void setA3Birthdate(String value) {
        this.a3Birthdate = value;
    }
            public String getA3BillFirstName() {
        return a3BillFirstName;
    }

    public void setA3BillFirstName(String value) {
        this.a3BillFirstName = value;
    }
            public String getA3BillMi() {
        return a3BillMi;
    }

    public void setA3BillMi(String value) {
        this.a3BillMi = value;
    }
            public String getA3BillLastName() {
        return a3BillLastName;
    }

    public void setA3BillLastName(String value) {
        this.a3BillLastName = value;
    }
            public String getA3BillCompanyName() {
        return a3BillCompanyName;
    }

    public void setA3BillCompanyName(String value) {
        this.a3BillCompanyName = value;
    }
            public String getA3BillAddress1() {
        return a3BillAddress1;
    }

    public void setA3BillAddress1(String value) {
        this.a3BillAddress1 = value;
    }
            public String getA3BillAddress2() {
        return a3BillAddress2;
    }

    public void setA3BillAddress2(String value) {
        this.a3BillAddress2 = value;
    }
            public String getA3BillCity() {
        return a3BillCity;
    }

    public void setA3BillCity(String value) {
        this.a3BillCity = value;
    }
            public String getA3BillLocality() {
        return a3BillLocality;
    }

    public void setA3BillLocality(String value) {
        this.a3BillLocality = value;
    }
            public String getA3BillStateProv() {
        return a3BillStateProv;
    }

    public void setA3BillStateProv(String value) {
        this.a3BillStateProv = value;
    }
            public String getA3BillCountry() {
        return a3BillCountry;
    }

    public void setA3BillCountry(String value) {
        this.a3BillCountry = value;
    }
            public String getA3BillPostalCd() {
        return a3BillPostalCd;
    }

    public void setA3BillPostalCd(String value) {
        this.a3BillPostalCd = value;
    }
            public String getA3BillPhone() {
        return a3BillPhone;
    }

    public void setA3BillPhone(String value) {
        this.a3BillPhone = value;
    }
            public String getA3BillPhoneExt() {
        return a3BillPhoneExt;
    }

    public void setA3BillPhoneExt(String value) {
        this.a3BillPhoneExt = value;
    }
            public String getA3BillCellPhone() {
        return a3BillCellPhone;
    }

    public void setA3BillCellPhone(String value) {
        this.a3BillCellPhone = value;
    }
            public String getA3BillWorkPhone() {
        return a3BillWorkPhone;
    }

    public void setA3BillWorkPhone(String value) {
        this.a3BillWorkPhone = value;
    }
            public String getA3BillWorkPhoneExt() {
        return a3BillWorkPhoneExt;
    }

    public void setA3BillWorkPhoneExt(String value) {
        this.a3BillWorkPhoneExt = value;
    }
            public String getA3BillEmail() {
        return a3BillEmail;
    }

    public void setA3BillEmail(String value) {
        this.a3BillEmail = value;
    }
            public Long getA3PayMethod() {
        return a3PayMethod;
    }

    public void setA3PayMethod(Long value) {
        this.a3PayMethod = value;
    }
            public String getA3CcNumber() {
        return a3CcNumber;
    }

    public void setA3CcNumber(String value) {
        this.a3CcNumber = value;
    }
            public Long getA3CcExpireMm() {
        return a3CcExpireMm;
    }

    public void setA3CcExpireMm(Long value) {
        this.a3CcExpireMm = value;
    }
            public Long getA3CcExpireYyyy() {
        return a3CcExpireYyyy;
    }

    public void setA3CcExpireYyyy(Long value) {
        this.a3CcExpireYyyy = value;
    }
            public String getA3BankAcctNo() {
        return a3BankAcctNo;
    }

    public void setA3BankAcctNo(String value) {
        this.a3BankAcctNo = value;
    }
            public String getA3BankRoutingNo() {
        return a3BankRoutingNo;
    }

    public void setA3BankRoutingNo(String value) {
        this.a3BankRoutingNo = value;
    }
            public Long getA3RespLevelCd() {
        return a3RespLevelCd;
    }

    public void setA3RespLevelCd(Long value) {
        this.a3RespLevelCd = value;
    }
            public A3FunctionalAcctGroupsArray getA3FunctionalAcctGroups() {
        return a3FunctionalAcctGroups;
    }

    public void setA3FunctionalAcctGroups(A3FunctionalAcctGroupsArray value) {
        this.a3FunctionalAcctGroups = value;
    }
            public A3CollectionsAcctGroupsArray getA3CollectionsAcctGroups() {
        return a3CollectionsAcctGroups;
    }

    public void setA3CollectionsAcctGroups(A3CollectionsAcctGroupsArray value) {
        this.a3CollectionsAcctGroups = value;
    }
            public A3SuppFieldNamesArray getA3SuppFieldNames() {
        return a3SuppFieldNames;
    }

    public void setA3SuppFieldNames(A3SuppFieldNamesArray value) {
        this.a3SuppFieldNames = value;
    }
            public A3SuppFieldValuesArray getA3SuppFieldValues() {
        return a3SuppFieldValues;
    }

    public void setA3SuppFieldValues(A3SuppFieldValuesArray value) {
        this.a3SuppFieldValues = value;
    }
            public Long getA3TestAcctInd() {
        return a3TestAcctInd;
    }

    public void setA3TestAcctInd(Long value) {
        this.a3TestAcctInd = value;
    }
            public Long getA3StatusUntilAltStart() {
        return a3StatusUntilAltStart;
    }

    public void setA3StatusUntilAltStart(Long value) {
        this.a3StatusUntilAltStart = value;
    }
            public Double getA3BalanceForward() {
        return a3BalanceForward;
    }

    public void setA3BalanceForward(Double value) {
        this.a3BalanceForward = value;
    }
            public Long getA3AltBillDay() {
        return a3AltBillDay;
    }

    public void setA3AltBillDay(Long value) {
        this.a3AltBillDay = value;
    }
            public String getA3DoFullInvoicing() {
        return a3DoFullInvoicing;
    }

    public void setA3DoFullInvoicing(String value) {
        this.a3DoFullInvoicing = value;
    }
            public String getA3DoProratedInvoicing() {
        return a3DoProratedInvoicing;
    }

    public void setA3DoProratedInvoicing(String value) {
        this.a3DoProratedInvoicing = value;
    }
            public Long getA3MasterPlanAltRateSchedNo() {
        return a3MasterPlanAltRateSchedNo;
    }

    public void setA3MasterPlanAltRateSchedNo(Long value) {
        this.a3MasterPlanAltRateSchedNo = value;
    }
            public A3SuppPlanAltRateSchedNoArray getA3SuppPlanAltRateSchedNo() {
        return a3SuppPlanAltRateSchedNo;
    }

    public void setA3SuppPlanAltRateSchedNo(A3SuppPlanAltRateSchedNoArray value) {
        this.a3SuppPlanAltRateSchedNo = value;
    }
            public String getA3CurrencyCd() {
        return a3CurrencyCd;
    }

    public void setA3CurrencyCd(String value) {
        this.a3CurrencyCd = value;
    }
            public String getA3Cvv() {
        return a3Cvv;
    }

    public void setA3Cvv(String value) {
        this.a3Cvv = value;
    }
            public String getA3TaxpayerId() {
        return a3TaxpayerId;
    }

    public void setA3TaxpayerId(String value) {
        this.a3TaxpayerId = value;
    }
            public String getA3BillAgreementId() {
        return a3BillAgreementId;
    }

    public void setA3BillAgreementId(String value) {
        this.a3BillAgreementId = value;
    }
            public String getA3RetroactiveStartDate() {
        return a3RetroactiveStartDate;
    }

    public void setA3RetroactiveStartDate(String value) {
        this.a3RetroactiveStartDate = value;
    }
            public A3CouponCodesArray getA3CouponCodes() {
        return a3CouponCodes;
    }

    public void setA3CouponCodes(A3CouponCodesArray value) {
        this.a3CouponCodes = value;
    }
            public A3NewAcctCustomRatesArray getA3NewAcctCustomRates() {
        return a3NewAcctCustomRates;
    }

    public void setA3NewAcctCustomRates(A3NewAcctCustomRatesArray value) {
        this.a3NewAcctCustomRates = value;
    }
            public Long getA3AltMsgTemplateNo() {
        return a3AltMsgTemplateNo;
    }

    public void setA3AltMsgTemplateNo(Long value) {
        this.a3AltMsgTemplateNo = value;
    }
            public Long getA3SeqFuncGroupNo() {
        return a3SeqFuncGroupNo;
    }

    public void setA3SeqFuncGroupNo(Long value) {
        this.a3SeqFuncGroupNo = value;
    }
            public A3NewAcctPlanContractsArray getA3NewAcctPlanContracts() {
        return a3NewAcctPlanContracts;
    }

    public void setA3NewAcctPlanContracts(A3NewAcctPlanContractsArray value) {
        this.a3NewAcctPlanContracts = value;
    }
            public String getA3BankAcctType() {
        return a3BankAcctType;
    }

    public void setA3BankAcctType(String value) {
        this.a3BankAcctType = value;
    }
            public String getA3Address3() {
        return a3Address3;
    }

    public void setA3Address3(String value) {
        this.a3Address3 = value;
    }
            public String getA3BillAddress3() {
        return a3BillAddress3;
    }

    public void setA3BillAddress3(String value) {
        this.a3BillAddress3 = value;
    }
            public A3UsageAccumulationConfigArray getA3UsageAccumulationConfig() {
        return a3UsageAccumulationConfig;
    }

    public void setA3UsageAccumulationConfig(A3UsageAccumulationConfigArray value) {
        this.a3UsageAccumulationConfig = value;
    }
            public A3EnableUsagePoolingPlanNoArray getA3EnableUsagePoolingPlanNo() {
        return a3EnableUsagePoolingPlanNo;
    }

    public void setA3EnableUsagePoolingPlanNo(A3EnableUsagePoolingPlanNoArray value) {
        this.a3EnableUsagePoolingPlanNo = value;
    }
            public A3ClientFuncAcctGroupIdsArray getA3ClientFuncAcctGroupIds() {
        return a3ClientFuncAcctGroupIds;
    }

    public void setA3ClientFuncAcctGroupIds(A3ClientFuncAcctGroupIdsArray value) {
        this.a3ClientFuncAcctGroupIds = value;
    }
            public A3ClientCollAcctGroupIdsArray getA3ClientCollAcctGroupIds() {
        return a3ClientCollAcctGroupIds;
    }

    public void setA3ClientCollAcctGroupIds(A3ClientCollAcctGroupIdsArray value) {
        this.a3ClientCollAcctGroupIds = value;
    }
            public String getA3TrackData1() {
        return a3TrackData1;
    }

    public void setA3TrackData1(String value) {
        this.a3TrackData1 = value;
    }
            public String getA3TrackData2() {
        return a3TrackData2;
    }

    public void setA3TrackData2(String value) {
        this.a3TrackData2 = value;
    }
            public Long getA3TaxExemptionLevel() {
        return a3TaxExemptionLevel;
    }

    public void setA3TaxExemptionLevel(Long value) {
        this.a3TaxExemptionLevel = value;
    }
            public Long getA3CnAltMsgTemplateNo() {
        return a3CnAltMsgTemplateNo;
    }

    public void setA3CnAltMsgTemplateNo(Long value) {
        this.a3CnAltMsgTemplateNo = value;
    }
            public String getA3InvoiceApprovalRequired() {
        return a3InvoiceApprovalRequired;
    }

    public void setA3InvoiceApprovalRequired(String value) {
        this.a3InvoiceApprovalRequired = value;
    }
            public String getA3CreateSession() {
        return a3CreateSession;
    }

    public void setA3CreateSession(String value) {
        this.a3CreateSession = value;
    }
            public String getA3ClientMasterPlanId() {
        return a3ClientMasterPlanId;
    }

    public void setA3ClientMasterPlanId(String value) {
        this.a3ClientMasterPlanId = value;
    }
            public A3ClientSuppPlanIdsArray getA3ClientSuppPlanIds() {
        return a3ClientSuppPlanIds;
    }

    public void setA3ClientSuppPlanIds(A3ClientSuppPlanIdsArray value) {
        this.a3ClientSuppPlanIds = value;
    }
            public String getA3ClientMpAltRateSchedId() {
        return a3ClientMpAltRateSchedId;
    }

    public void setA3ClientMpAltRateSchedId(String value) {
        this.a3ClientMpAltRateSchedId = value;
    }
            public A3ClientSpAltRateSchedIdsArray getA3ClientSpAltRateSchedIds() {
        return a3ClientSpAltRateSchedIds;
    }

    public void setA3ClientSpAltRateSchedIds(A3ClientSpAltRateSchedIdsArray value) {
        this.a3ClientSpAltRateSchedIds = value;
    }
            public String getA3ClientAltMsgTemplateId() {
        return a3ClientAltMsgTemplateId;
    }

    public void setA3ClientAltMsgTemplateId(String value) {
        this.a3ClientAltMsgTemplateId = value;
    }
            public String getA3ClientCnAltMsgTemplateNo() {
        return a3ClientCnAltMsgTemplateNo;
    }

    public void setA3ClientCnAltMsgTemplateNo(String value) {
        this.a3ClientCnAltMsgTemplateNo = value;
    }
            public String getA3Iban() {
        return a3Iban;
    }

    public void setA3Iban(String value) {
        this.a3Iban = value;
    }
            public Long getA3BankCheckDigit() {
        return a3BankCheckDigit;
    }

    public void setA3BankCheckDigit(Long value) {
        this.a3BankCheckDigit = value;
    }
            public String getA3BankSwiftCd() {
        return a3BankSwiftCd;
    }

    public void setA3BankSwiftCd(String value) {
        this.a3BankSwiftCd = value;
    }
            public String getA3BankCountryCd() {
        return a3BankCountryCd;
    }

    public void setA3BankCountryCd(String value) {
        this.a3BankCountryCd = value;
    }
            public String getA3MandateId() {
        return a3MandateId;
    }

    public void setA3MandateId(String value) {
        this.a3MandateId = value;
    }
            public String getA3BankIdCd() {
        return a3BankIdCd;
    }

    public void setA3BankIdCd(String value) {
        this.a3BankIdCd = value;
    }
            public String getA3BankBranchCd() {
        return a3BankBranchCd;
    }

    public void setA3BankBranchCd(String value) {
        this.a3BankBranchCd = value;
    }
            public A3SurchargeNoArray getA3SurchargeNo() {
        return a3SurchargeNo;
    }

    public void setA3SurchargeNo(A3SurchargeNoArray value) {
        this.a3SurchargeNo = value;
    }
            public String getA3BkupBillFirstName() {
        return a3BkupBillFirstName;
    }

    public void setA3BkupBillFirstName(String value) {
        this.a3BkupBillFirstName = value;
    }
            public String getA3BkupBillMi() {
        return a3BkupBillMi;
    }

    public void setA3BkupBillMi(String value) {
        this.a3BkupBillMi = value;
    }
            public String getA3BkupBillLastName() {
        return a3BkupBillLastName;
    }

    public void setA3BkupBillLastName(String value) {
        this.a3BkupBillLastName = value;
    }
            public String getA3BkupBillCompanyName() {
        return a3BkupBillCompanyName;
    }

    public void setA3BkupBillCompanyName(String value) {
        this.a3BkupBillCompanyName = value;
    }
            public String getA3BkupBillAddress1() {
        return a3BkupBillAddress1;
    }

    public void setA3BkupBillAddress1(String value) {
        this.a3BkupBillAddress1 = value;
    }
            public String getA3BkupBillAddress2() {
        return a3BkupBillAddress2;
    }

    public void setA3BkupBillAddress2(String value) {
        this.a3BkupBillAddress2 = value;
    }
            public String getA3BkupBillAddress3() {
        return a3BkupBillAddress3;
    }

    public void setA3BkupBillAddress3(String value) {
        this.a3BkupBillAddress3 = value;
    }
            public String getA3BkupBillCity() {
        return a3BkupBillCity;
    }

    public void setA3BkupBillCity(String value) {
        this.a3BkupBillCity = value;
    }
            public String getA3BkupBillLocality() {
        return a3BkupBillLocality;
    }

    public void setA3BkupBillLocality(String value) {
        this.a3BkupBillLocality = value;
    }
            public String getA3BkupBillStateProv() {
        return a3BkupBillStateProv;
    }

    public void setA3BkupBillStateProv(String value) {
        this.a3BkupBillStateProv = value;
    }
            public String getA3BkupBillCountry() {
        return a3BkupBillCountry;
    }

    public void setA3BkupBillCountry(String value) {
        this.a3BkupBillCountry = value;
    }
            public String getA3BkupBillPostalCd() {
        return a3BkupBillPostalCd;
    }

    public void setA3BkupBillPostalCd(String value) {
        this.a3BkupBillPostalCd = value;
    }
            public String getA3BkupBillPhone() {
        return a3BkupBillPhone;
    }

    public void setA3BkupBillPhone(String value) {
        this.a3BkupBillPhone = value;
    }
            public String getA3BkupBillPhoneExt() {
        return a3BkupBillPhoneExt;
    }

    public void setA3BkupBillPhoneExt(String value) {
        this.a3BkupBillPhoneExt = value;
    }
            public String getA3BkupBillCellPhone() {
        return a3BkupBillCellPhone;
    }

    public void setA3BkupBillCellPhone(String value) {
        this.a3BkupBillCellPhone = value;
    }
            public String getA3BkupBillWorkPhone() {
        return a3BkupBillWorkPhone;
    }

    public void setA3BkupBillWorkPhone(String value) {
        this.a3BkupBillWorkPhone = value;
    }
            public String getA3BkupBillWorkPhoneExt() {
        return a3BkupBillWorkPhoneExt;
    }

    public void setA3BkupBillWorkPhoneExt(String value) {
        this.a3BkupBillWorkPhoneExt = value;
    }
            public String getA3BkupBillEmail() {
        return a3BkupBillEmail;
    }

    public void setA3BkupBillEmail(String value) {
        this.a3BkupBillEmail = value;
    }
            public Long getA3BkupPayMethod() {
        return a3BkupPayMethod;
    }

    public void setA3BkupPayMethod(Long value) {
        this.a3BkupPayMethod = value;
    }
            public String getA3BkupCcNumber() {
        return a3BkupCcNumber;
    }

    public void setA3BkupCcNumber(String value) {
        this.a3BkupCcNumber = value;
    }
            public Long getA3BkupCcExpireMm() {
        return a3BkupCcExpireMm;
    }

    public void setA3BkupCcExpireMm(Long value) {
        this.a3BkupCcExpireMm = value;
    }
            public Long getA3BkupCcExpireYyyy() {
        return a3BkupCcExpireYyyy;
    }

    public void setA3BkupCcExpireYyyy(Long value) {
        this.a3BkupCcExpireYyyy = value;
    }
            public String getA3BkupBankAcctNo() {
        return a3BkupBankAcctNo;
    }

    public void setA3BkupBankAcctNo(String value) {
        this.a3BkupBankAcctNo = value;
    }
            public String getA3BkupBankRoutingNo() {
        return a3BkupBankRoutingNo;
    }

    public void setA3BkupBankRoutingNo(String value) {
        this.a3BkupBankRoutingNo = value;
    }
            public String getA3BkupBankAcctType() {
        return a3BkupBankAcctType;
    }

    public void setA3BkupBankAcctType(String value) {
        this.a3BkupBankAcctType = value;
    }
            public String getA3BkupBillAgreementId() {
        return a3BkupBillAgreementId;
    }

    public void setA3BkupBillAgreementId(String value) {
        this.a3BkupBillAgreementId = value;
    }
            public String getA3BkupCvv() {
        return a3BkupCvv;
    }

    public void setA3BkupCvv(String value) {
        this.a3BkupCvv = value;
    }
            public String getA3SeqFuncGroupId() {
        return a3SeqFuncGroupId;
    }

    public void setA3SeqFuncGroupId(String value) {
        this.a3SeqFuncGroupId = value;
    }
            public Long getA3RevrecProfileId() {
        return a3RevrecProfileId;
    }

    public void setA3RevrecProfileId(Long value) {
        this.a3RevrecProfileId = value;
    }
            public String getA3RevrecClientDefinedId() {
        return a3RevrecClientDefinedId;
    }

    public void setA3RevrecClientDefinedId(String value) {
        this.a3RevrecClientDefinedId = value;
    }
                public String getA3StmntEmailListCc() {
        return a3StmntEmailListCc;
    }

    public void setA3StmntEmailListCc(String value) {
        this.a3StmntEmailListCc = value;
    }
            public String getA3StmntEmailListBcc() {
        return a3StmntEmailListBcc;
    }

    public void setA3StmntEmailListBcc(String value) {
        this.a3StmntEmailListBcc = value;
    }
            public Long getA3InvoicePostingMethodCd() {
        return a3InvoicePostingMethodCd;
    }

    public void setA3InvoicePostingMethodCd(Long value) {
        this.a3InvoicePostingMethodCd = value;
    }
            public String getA3AcctStartDate() {
        return a3AcctStartDate;
    }

    public void setA3AcctStartDate(String value) {
        this.a3AcctStartDate = value;
    }
            public Long getA3MinStatementThreshold() {
        return a3MinStatementThreshold;
    }

    public void setA3MinStatementThreshold(Long value) {
        this.a3MinStatementThreshold = value;
    }
            public Long getA3MaxStatementsToDefer() {
        return a3MaxStatementsToDefer;
    }

    public void setA3MaxStatementsToDefer(Long value) {
        this.a3MaxStatementsToDefer = value;
    }
            public Long getA3DeferFullStatementsOnly() {
        return a3DeferFullStatementsOnly;
    }

    public void setA3DeferFullStatementsOnly(Long value) {
        this.a3DeferFullStatementsOnly = value;
    }
            public Long getA3CcId() {
        return a3CcId;
    }

    public void setA3CcId(Long value) {
        this.a3CcId = value;
    }
            public Long getA3BkupCcId() {
        return a3BkupCcId;
    }

    public void setA3BkupCcId(Long value) {
        this.a3BkupCcId = value;
    }
            public String getA4AltStartDate() {
        return a4AltStartDate;
    }

    public void setA4AltStartDate(String value) {
        this.a4AltStartDate = value;
    }
            public String getA4ClientAcctId() {
        return a4ClientAcctId;
    }

    public void setA4ClientAcctId(String value) {
        this.a4ClientAcctId = value;
    }
            public String getA4Userid() {
        return a4Userid;
    }

    public void setA4Userid(String value) {
        this.a4Userid = value;
    }
            public Long getA4StatusCd() {
        return a4StatusCd;
    }

    public void setA4StatusCd(Long value) {
        this.a4StatusCd = value;
    }
            public Long getA4MasterPlanNo() {
        return a4MasterPlanNo;
    }

    public void setA4MasterPlanNo(Long value) {
        this.a4MasterPlanNo = value;
    }
            public Long getA4MasterPlanUnits() {
        return a4MasterPlanUnits;
    }

    public void setA4MasterPlanUnits(Long value) {
        this.a4MasterPlanUnits = value;
    }
            public A4SuppPlansArray getA4SuppPlans() {
        return a4SuppPlans;
    }

    public void setA4SuppPlans(A4SuppPlansArray value) {
        this.a4SuppPlans = value;
    }
            public A4SuppPlanUnitsArray getA4SuppPlanUnits() {
        return a4SuppPlanUnits;
    }

    public void setA4SuppPlanUnits(A4SuppPlanUnitsArray value) {
        this.a4SuppPlanUnits = value;
    }
            public Long getA4NotifyMethod() {
        return a4NotifyMethod;
    }

    public void setA4NotifyMethod(Long value) {
        this.a4NotifyMethod = value;
    }
            public String getA4PromoCd() {
        return a4PromoCd;
    }

    public void setA4PromoCd(String value) {
        this.a4PromoCd = value;
    }
            public String getA4Password() {
        return a4Password;
    }

    public void setA4Password(String value) {
        this.a4Password = value;
    }
            public String getA4SecretQuestion() {
        return a4SecretQuestion;
    }

    public void setA4SecretQuestion(String value) {
        this.a4SecretQuestion = value;
    }
            public String getA4SecretQuestionAnswer() {
        return a4SecretQuestionAnswer;
    }

    public void setA4SecretQuestionAnswer(String value) {
        this.a4SecretQuestionAnswer = value;
    }
            public String getA4FirstName() {
        return a4FirstName;
    }

    public void setA4FirstName(String value) {
        this.a4FirstName = value;
    }
            public String getA4Mi() {
        return a4Mi;
    }

    public void setA4Mi(String value) {
        this.a4Mi = value;
    }
            public String getA4LastName() {
        return a4LastName;
    }

    public void setA4LastName(String value) {
        this.a4LastName = value;
    }
            public String getA4CompanyName() {
        return a4CompanyName;
    }

    public void setA4CompanyName(String value) {
        this.a4CompanyName = value;
    }
            public String getA4Address1() {
        return a4Address1;
    }

    public void setA4Address1(String value) {
        this.a4Address1 = value;
    }
            public String getA4Address2() {
        return a4Address2;
    }

    public void setA4Address2(String value) {
        this.a4Address2 = value;
    }
            public String getA4City() {
        return a4City;
    }

    public void setA4City(String value) {
        this.a4City = value;
    }
            public String getA4Locality() {
        return a4Locality;
    }

    public void setA4Locality(String value) {
        this.a4Locality = value;
    }
            public String getA4StateProv() {
        return a4StateProv;
    }

    public void setA4StateProv(String value) {
        this.a4StateProv = value;
    }
            public String getA4Country() {
        return a4Country;
    }

    public void setA4Country(String value) {
        this.a4Country = value;
    }
            public String getA4PostalCd() {
        return a4PostalCd;
    }

    public void setA4PostalCd(String value) {
        this.a4PostalCd = value;
    }
            public String getA4Phone() {
        return a4Phone;
    }

    public void setA4Phone(String value) {
        this.a4Phone = value;
    }
            public String getA4PhoneExt() {
        return a4PhoneExt;
    }

    public void setA4PhoneExt(String value) {
        this.a4PhoneExt = value;
    }
            public String getA4CellPhone() {
        return a4CellPhone;
    }

    public void setA4CellPhone(String value) {
        this.a4CellPhone = value;
    }
            public String getA4WorkPhone() {
        return a4WorkPhone;
    }

    public void setA4WorkPhone(String value) {
        this.a4WorkPhone = value;
    }
            public String getA4WorkPhoneExt() {
        return a4WorkPhoneExt;
    }

    public void setA4WorkPhoneExt(String value) {
        this.a4WorkPhoneExt = value;
    }
            public String getA4Email() {
        return a4Email;
    }

    public void setA4Email(String value) {
        this.a4Email = value;
    }
            public String getA4Birthdate() {
        return a4Birthdate;
    }

    public void setA4Birthdate(String value) {
        this.a4Birthdate = value;
    }
            public String getA4BillFirstName() {
        return a4BillFirstName;
    }

    public void setA4BillFirstName(String value) {
        this.a4BillFirstName = value;
    }
            public String getA4BillMi() {
        return a4BillMi;
    }

    public void setA4BillMi(String value) {
        this.a4BillMi = value;
    }
            public String getA4BillLastName() {
        return a4BillLastName;
    }

    public void setA4BillLastName(String value) {
        this.a4BillLastName = value;
    }
            public String getA4BillCompanyName() {
        return a4BillCompanyName;
    }

    public void setA4BillCompanyName(String value) {
        this.a4BillCompanyName = value;
    }
            public String getA4BillAddress1() {
        return a4BillAddress1;
    }

    public void setA4BillAddress1(String value) {
        this.a4BillAddress1 = value;
    }
            public String getA4BillAddress2() {
        return a4BillAddress2;
    }

    public void setA4BillAddress2(String value) {
        this.a4BillAddress2 = value;
    }
            public String getA4BillCity() {
        return a4BillCity;
    }

    public void setA4BillCity(String value) {
        this.a4BillCity = value;
    }
            public String getA4BillLocality() {
        return a4BillLocality;
    }

    public void setA4BillLocality(String value) {
        this.a4BillLocality = value;
    }
            public String getA4BillStateProv() {
        return a4BillStateProv;
    }

    public void setA4BillStateProv(String value) {
        this.a4BillStateProv = value;
    }
            public String getA4BillCountry() {
        return a4BillCountry;
    }

    public void setA4BillCountry(String value) {
        this.a4BillCountry = value;
    }
            public String getA4BillPostalCd() {
        return a4BillPostalCd;
    }

    public void setA4BillPostalCd(String value) {
        this.a4BillPostalCd = value;
    }
            public String getA4BillPhone() {
        return a4BillPhone;
    }

    public void setA4BillPhone(String value) {
        this.a4BillPhone = value;
    }
            public String getA4BillPhoneExt() {
        return a4BillPhoneExt;
    }

    public void setA4BillPhoneExt(String value) {
        this.a4BillPhoneExt = value;
    }
            public String getA4BillCellPhone() {
        return a4BillCellPhone;
    }

    public void setA4BillCellPhone(String value) {
        this.a4BillCellPhone = value;
    }
            public String getA4BillWorkPhone() {
        return a4BillWorkPhone;
    }

    public void setA4BillWorkPhone(String value) {
        this.a4BillWorkPhone = value;
    }
            public String getA4BillWorkPhoneExt() {
        return a4BillWorkPhoneExt;
    }

    public void setA4BillWorkPhoneExt(String value) {
        this.a4BillWorkPhoneExt = value;
    }
            public String getA4BillEmail() {
        return a4BillEmail;
    }

    public void setA4BillEmail(String value) {
        this.a4BillEmail = value;
    }
            public Long getA4PayMethod() {
        return a4PayMethod;
    }

    public void setA4PayMethod(Long value) {
        this.a4PayMethod = value;
    }
            public String getA4CcNumber() {
        return a4CcNumber;
    }

    public void setA4CcNumber(String value) {
        this.a4CcNumber = value;
    }
            public Long getA4CcExpireMm() {
        return a4CcExpireMm;
    }

    public void setA4CcExpireMm(Long value) {
        this.a4CcExpireMm = value;
    }
            public Long getA4CcExpireYyyy() {
        return a4CcExpireYyyy;
    }

    public void setA4CcExpireYyyy(Long value) {
        this.a4CcExpireYyyy = value;
    }
            public String getA4BankAcctNo() {
        return a4BankAcctNo;
    }

    public void setA4BankAcctNo(String value) {
        this.a4BankAcctNo = value;
    }
            public String getA4BankRoutingNo() {
        return a4BankRoutingNo;
    }

    public void setA4BankRoutingNo(String value) {
        this.a4BankRoutingNo = value;
    }
            public Long getA4RespLevelCd() {
        return a4RespLevelCd;
    }

    public void setA4RespLevelCd(Long value) {
        this.a4RespLevelCd = value;
    }
            public A4FunctionalAcctGroupsArray getA4FunctionalAcctGroups() {
        return a4FunctionalAcctGroups;
    }

    public void setA4FunctionalAcctGroups(A4FunctionalAcctGroupsArray value) {
        this.a4FunctionalAcctGroups = value;
    }
            public A4CollectionsAcctGroupsArray getA4CollectionsAcctGroups() {
        return a4CollectionsAcctGroups;
    }

    public void setA4CollectionsAcctGroups(A4CollectionsAcctGroupsArray value) {
        this.a4CollectionsAcctGroups = value;
    }
            public A4SuppFieldNamesArray getA4SuppFieldNames() {
        return a4SuppFieldNames;
    }

    public void setA4SuppFieldNames(A4SuppFieldNamesArray value) {
        this.a4SuppFieldNames = value;
    }
            public A4SuppFieldValuesArray getA4SuppFieldValues() {
        return a4SuppFieldValues;
    }

    public void setA4SuppFieldValues(A4SuppFieldValuesArray value) {
        this.a4SuppFieldValues = value;
    }
            public Long getA4TestAcctInd() {
        return a4TestAcctInd;
    }

    public void setA4TestAcctInd(Long value) {
        this.a4TestAcctInd = value;
    }
            public Long getA4StatusUntilAltStart() {
        return a4StatusUntilAltStart;
    }

    public void setA4StatusUntilAltStart(Long value) {
        this.a4StatusUntilAltStart = value;
    }
            public Double getA4BalanceForward() {
        return a4BalanceForward;
    }

    public void setA4BalanceForward(Double value) {
        this.a4BalanceForward = value;
    }
            public Long getA4AltBillDay() {
        return a4AltBillDay;
    }

    public void setA4AltBillDay(Long value) {
        this.a4AltBillDay = value;
    }
            public String getA4DoFullInvoicing() {
        return a4DoFullInvoicing;
    }

    public void setA4DoFullInvoicing(String value) {
        this.a4DoFullInvoicing = value;
    }
            public String getA4DoProratedInvoicing() {
        return a4DoProratedInvoicing;
    }

    public void setA4DoProratedInvoicing(String value) {
        this.a4DoProratedInvoicing = value;
    }
            public Long getA4MasterPlanAltRateSchedNo() {
        return a4MasterPlanAltRateSchedNo;
    }

    public void setA4MasterPlanAltRateSchedNo(Long value) {
        this.a4MasterPlanAltRateSchedNo = value;
    }
            public A4SuppPlanAltRateSchedNoArray getA4SuppPlanAltRateSchedNo() {
        return a4SuppPlanAltRateSchedNo;
    }

    public void setA4SuppPlanAltRateSchedNo(A4SuppPlanAltRateSchedNoArray value) {
        this.a4SuppPlanAltRateSchedNo = value;
    }
            public String getA4CurrencyCd() {
        return a4CurrencyCd;
    }

    public void setA4CurrencyCd(String value) {
        this.a4CurrencyCd = value;
    }
            public String getA4Cvv() {
        return a4Cvv;
    }

    public void setA4Cvv(String value) {
        this.a4Cvv = value;
    }
            public String getA4TaxpayerId() {
        return a4TaxpayerId;
    }

    public void setA4TaxpayerId(String value) {
        this.a4TaxpayerId = value;
    }
            public String getA4BillAgreementId() {
        return a4BillAgreementId;
    }

    public void setA4BillAgreementId(String value) {
        this.a4BillAgreementId = value;
    }
            public String getA4RetroactiveStartDate() {
        return a4RetroactiveStartDate;
    }

    public void setA4RetroactiveStartDate(String value) {
        this.a4RetroactiveStartDate = value;
    }
            public A4CouponCodesArray getA4CouponCodes() {
        return a4CouponCodes;
    }

    public void setA4CouponCodes(A4CouponCodesArray value) {
        this.a4CouponCodes = value;
    }
            public A4NewAcctCustomRatesArray getA4NewAcctCustomRates() {
        return a4NewAcctCustomRates;
    }

    public void setA4NewAcctCustomRates(A4NewAcctCustomRatesArray value) {
        this.a4NewAcctCustomRates = value;
    }
            public Long getA4AltMsgTemplateNo() {
        return a4AltMsgTemplateNo;
    }

    public void setA4AltMsgTemplateNo(Long value) {
        this.a4AltMsgTemplateNo = value;
    }
            public Long getA4SeqFuncGroupNo() {
        return a4SeqFuncGroupNo;
    }

    public void setA4SeqFuncGroupNo(Long value) {
        this.a4SeqFuncGroupNo = value;
    }
            public A4NewAcctPlanContractsArray getA4NewAcctPlanContracts() {
        return a4NewAcctPlanContracts;
    }

    public void setA4NewAcctPlanContracts(A4NewAcctPlanContractsArray value) {
        this.a4NewAcctPlanContracts = value;
    }
            public String getA4BankAcctType() {
        return a4BankAcctType;
    }

    public void setA4BankAcctType(String value) {
        this.a4BankAcctType = value;
    }
            public String getA4Address3() {
        return a4Address3;
    }

    public void setA4Address3(String value) {
        this.a4Address3 = value;
    }
            public String getA4BillAddress3() {
        return a4BillAddress3;
    }

    public void setA4BillAddress3(String value) {
        this.a4BillAddress3 = value;
    }
            public A4UsageAccumulationConfigArray getA4UsageAccumulationConfig() {
        return a4UsageAccumulationConfig;
    }

    public void setA4UsageAccumulationConfig(A4UsageAccumulationConfigArray value) {
        this.a4UsageAccumulationConfig = value;
    }
            public A4EnableUsagePoolingPlanNoArray getA4EnableUsagePoolingPlanNo() {
        return a4EnableUsagePoolingPlanNo;
    }

    public void setA4EnableUsagePoolingPlanNo(A4EnableUsagePoolingPlanNoArray value) {
        this.a4EnableUsagePoolingPlanNo = value;
    }
            public A4ClientFuncAcctGroupIdsArray getA4ClientFuncAcctGroupIds() {
        return a4ClientFuncAcctGroupIds;
    }

    public void setA4ClientFuncAcctGroupIds(A4ClientFuncAcctGroupIdsArray value) {
        this.a4ClientFuncAcctGroupIds = value;
    }
            public A4ClientCollAcctGroupIdsArray getA4ClientCollAcctGroupIds() {
        return a4ClientCollAcctGroupIds;
    }

    public void setA4ClientCollAcctGroupIds(A4ClientCollAcctGroupIdsArray value) {
        this.a4ClientCollAcctGroupIds = value;
    }
            public String getA4TrackData1() {
        return a4TrackData1;
    }

    public void setA4TrackData1(String value) {
        this.a4TrackData1 = value;
    }
            public String getA4TrackData2() {
        return a4TrackData2;
    }

    public void setA4TrackData2(String value) {
        this.a4TrackData2 = value;
    }
            public Long getA4TaxExemptionLevel() {
        return a4TaxExemptionLevel;
    }

    public void setA4TaxExemptionLevel(Long value) {
        this.a4TaxExemptionLevel = value;
    }
            public Long getA4CnAltMsgTemplateNo() {
        return a4CnAltMsgTemplateNo;
    }

    public void setA4CnAltMsgTemplateNo(Long value) {
        this.a4CnAltMsgTemplateNo = value;
    }
            public String getA4InvoiceApprovalRequired() {
        return a4InvoiceApprovalRequired;
    }

    public void setA4InvoiceApprovalRequired(String value) {
        this.a4InvoiceApprovalRequired = value;
    }
            public String getA4CreateSession() {
        return a4CreateSession;
    }

    public void setA4CreateSession(String value) {
        this.a4CreateSession = value;
    }
            public String getA4ClientMasterPlanId() {
        return a4ClientMasterPlanId;
    }

    public void setA4ClientMasterPlanId(String value) {
        this.a4ClientMasterPlanId = value;
    }
            public A4ClientSuppPlanIdsArray getA4ClientSuppPlanIds() {
        return a4ClientSuppPlanIds;
    }

    public void setA4ClientSuppPlanIds(A4ClientSuppPlanIdsArray value) {
        this.a4ClientSuppPlanIds = value;
    }
            public String getA4ClientMpAltRateSchedId() {
        return a4ClientMpAltRateSchedId;
    }

    public void setA4ClientMpAltRateSchedId(String value) {
        this.a4ClientMpAltRateSchedId = value;
    }
            public A4ClientSpAltRateSchedIdsArray getA4ClientSpAltRateSchedIds() {
        return a4ClientSpAltRateSchedIds;
    }

    public void setA4ClientSpAltRateSchedIds(A4ClientSpAltRateSchedIdsArray value) {
        this.a4ClientSpAltRateSchedIds = value;
    }
            public String getA4ClientAltMsgTemplateId() {
        return a4ClientAltMsgTemplateId;
    }

    public void setA4ClientAltMsgTemplateId(String value) {
        this.a4ClientAltMsgTemplateId = value;
    }
            public String getA4ClientCnAltMsgTemplateNo() {
        return a4ClientCnAltMsgTemplateNo;
    }

    public void setA4ClientCnAltMsgTemplateNo(String value) {
        this.a4ClientCnAltMsgTemplateNo = value;
    }
            public String getA4Iban() {
        return a4Iban;
    }

    public void setA4Iban(String value) {
        this.a4Iban = value;
    }
            public Long getA4BankCheckDigit() {
        return a4BankCheckDigit;
    }

    public void setA4BankCheckDigit(Long value) {
        this.a4BankCheckDigit = value;
    }
            public String getA4BankSwiftCd() {
        return a4BankSwiftCd;
    }

    public void setA4BankSwiftCd(String value) {
        this.a4BankSwiftCd = value;
    }
            public String getA4BankCountryCd() {
        return a4BankCountryCd;
    }

    public void setA4BankCountryCd(String value) {
        this.a4BankCountryCd = value;
    }
            public String getA4MandateId() {
        return a4MandateId;
    }

    public void setA4MandateId(String value) {
        this.a4MandateId = value;
    }
            public String getA4BankIdCd() {
        return a4BankIdCd;
    }

    public void setA4BankIdCd(String value) {
        this.a4BankIdCd = value;
    }
            public String getA4BankBranchCd() {
        return a4BankBranchCd;
    }

    public void setA4BankBranchCd(String value) {
        this.a4BankBranchCd = value;
    }
            public A4SurchargeNoArray getA4SurchargeNo() {
        return a4SurchargeNo;
    }

    public void setA4SurchargeNo(A4SurchargeNoArray value) {
        this.a4SurchargeNo = value;
    }
            public String getA4BkupBillFirstName() {
        return a4BkupBillFirstName;
    }

    public void setA4BkupBillFirstName(String value) {
        this.a4BkupBillFirstName = value;
    }
            public String getA4BkupBillMi() {
        return a4BkupBillMi;
    }

    public void setA4BkupBillMi(String value) {
        this.a4BkupBillMi = value;
    }
            public String getA4BkupBillLastName() {
        return a4BkupBillLastName;
    }

    public void setA4BkupBillLastName(String value) {
        this.a4BkupBillLastName = value;
    }
            public String getA4BkupBillCompanyName() {
        return a4BkupBillCompanyName;
    }

    public void setA4BkupBillCompanyName(String value) {
        this.a4BkupBillCompanyName = value;
    }
            public String getA4BkupBillAddress1() {
        return a4BkupBillAddress1;
    }

    public void setA4BkupBillAddress1(String value) {
        this.a4BkupBillAddress1 = value;
    }
            public String getA4BkupBillAddress2() {
        return a4BkupBillAddress2;
    }

    public void setA4BkupBillAddress2(String value) {
        this.a4BkupBillAddress2 = value;
    }
            public String getA4BkupBillAddress3() {
        return a4BkupBillAddress3;
    }

    public void setA4BkupBillAddress3(String value) {
        this.a4BkupBillAddress3 = value;
    }
            public String getA4BkupBillCity() {
        return a4BkupBillCity;
    }

    public void setA4BkupBillCity(String value) {
        this.a4BkupBillCity = value;
    }
            public String getA4BkupBillLocality() {
        return a4BkupBillLocality;
    }

    public void setA4BkupBillLocality(String value) {
        this.a4BkupBillLocality = value;
    }
            public String getA4BkupBillStateProv() {
        return a4BkupBillStateProv;
    }

    public void setA4BkupBillStateProv(String value) {
        this.a4BkupBillStateProv = value;
    }
            public String getA4BkupBillCountry() {
        return a4BkupBillCountry;
    }

    public void setA4BkupBillCountry(String value) {
        this.a4BkupBillCountry = value;
    }
            public String getA4BkupBillPostalCd() {
        return a4BkupBillPostalCd;
    }

    public void setA4BkupBillPostalCd(String value) {
        this.a4BkupBillPostalCd = value;
    }
            public String getA4BkupBillPhone() {
        return a4BkupBillPhone;
    }

    public void setA4BkupBillPhone(String value) {
        this.a4BkupBillPhone = value;
    }
            public String getA4BkupBillPhoneExt() {
        return a4BkupBillPhoneExt;
    }

    public void setA4BkupBillPhoneExt(String value) {
        this.a4BkupBillPhoneExt = value;
    }
            public String getA4BkupBillCellPhone() {
        return a4BkupBillCellPhone;
    }

    public void setA4BkupBillCellPhone(String value) {
        this.a4BkupBillCellPhone = value;
    }
            public String getA4BkupBillWorkPhone() {
        return a4BkupBillWorkPhone;
    }

    public void setA4BkupBillWorkPhone(String value) {
        this.a4BkupBillWorkPhone = value;
    }
            public String getA4BkupBillWorkPhoneExt() {
        return a4BkupBillWorkPhoneExt;
    }

    public void setA4BkupBillWorkPhoneExt(String value) {
        this.a4BkupBillWorkPhoneExt = value;
    }
            public String getA4BkupBillEmail() {
        return a4BkupBillEmail;
    }

    public void setA4BkupBillEmail(String value) {
        this.a4BkupBillEmail = value;
    }
            public Long getA4BkupPayMethod() {
        return a4BkupPayMethod;
    }

    public void setA4BkupPayMethod(Long value) {
        this.a4BkupPayMethod = value;
    }
            public String getA4BkupCcNumber() {
        return a4BkupCcNumber;
    }

    public void setA4BkupCcNumber(String value) {
        this.a4BkupCcNumber = value;
    }
            public Long getA4BkupCcExpireMm() {
        return a4BkupCcExpireMm;
    }

    public void setA4BkupCcExpireMm(Long value) {
        this.a4BkupCcExpireMm = value;
    }
            public Long getA4BkupCcExpireYyyy() {
        return a4BkupCcExpireYyyy;
    }

    public void setA4BkupCcExpireYyyy(Long value) {
        this.a4BkupCcExpireYyyy = value;
    }
            public String getA4BkupBankAcctNo() {
        return a4BkupBankAcctNo;
    }

    public void setA4BkupBankAcctNo(String value) {
        this.a4BkupBankAcctNo = value;
    }
            public String getA4BkupBankRoutingNo() {
        return a4BkupBankRoutingNo;
    }

    public void setA4BkupBankRoutingNo(String value) {
        this.a4BkupBankRoutingNo = value;
    }
            public String getA4BkupBankAcctType() {
        return a4BkupBankAcctType;
    }

    public void setA4BkupBankAcctType(String value) {
        this.a4BkupBankAcctType = value;
    }
            public String getA4BkupBillAgreementId() {
        return a4BkupBillAgreementId;
    }

    public void setA4BkupBillAgreementId(String value) {
        this.a4BkupBillAgreementId = value;
    }
            public String getA4BkupCvv() {
        return a4BkupCvv;
    }

    public void setA4BkupCvv(String value) {
        this.a4BkupCvv = value;
    }
            public String getA4SeqFuncGroupId() {
        return a4SeqFuncGroupId;
    }

    public void setA4SeqFuncGroupId(String value) {
        this.a4SeqFuncGroupId = value;
    }
            public Long getA4RevrecProfileId() {
        return a4RevrecProfileId;
    }

    public void setA4RevrecProfileId(Long value) {
        this.a4RevrecProfileId = value;
    }
            public String getA4RevrecClientDefinedId() {
        return a4RevrecClientDefinedId;
    }

    public void setA4RevrecClientDefinedId(String value) {
        this.a4RevrecClientDefinedId = value;
    }
                public String getA4StmntEmailListCc() {
        return a4StmntEmailListCc;
    }

    public void setA4StmntEmailListCc(String value) {
        this.a4StmntEmailListCc = value;
    }
            public String getA4StmntEmailListBcc() {
        return a4StmntEmailListBcc;
    }

    public void setA4StmntEmailListBcc(String value) {
        this.a4StmntEmailListBcc = value;
    }
            public Long getA4InvoicePostingMethodCd() {
        return a4InvoicePostingMethodCd;
    }

    public void setA4InvoicePostingMethodCd(Long value) {
        this.a4InvoicePostingMethodCd = value;
    }
            public String getA4AcctStartDate() {
        return a4AcctStartDate;
    }

    public void setA4AcctStartDate(String value) {
        this.a4AcctStartDate = value;
    }
            public Long getA4MinStatementThreshold() {
        return a4MinStatementThreshold;
    }

    public void setA4MinStatementThreshold(Long value) {
        this.a4MinStatementThreshold = value;
    }
            public Long getA4MaxStatementsToDefer() {
        return a4MaxStatementsToDefer;
    }

    public void setA4MaxStatementsToDefer(Long value) {
        this.a4MaxStatementsToDefer = value;
    }
            public Long getA4DeferFullStatementsOnly() {
        return a4DeferFullStatementsOnly;
    }

    public void setA4DeferFullStatementsOnly(Long value) {
        this.a4DeferFullStatementsOnly = value;
    }
            public Long getA4CcId() {
        return a4CcId;
    }

    public void setA4CcId(Long value) {
        this.a4CcId = value;
    }
            public Long getA4BkupCcId() {
        return a4BkupCcId;
    }

    public void setA4BkupCcId(Long value) {
        this.a4BkupCcId = value;
    }
            public String getA5AltStartDate() {
        return a5AltStartDate;
    }

    public void setA5AltStartDate(String value) {
        this.a5AltStartDate = value;
    }
            public String getA5ClientAcctId() {
        return a5ClientAcctId;
    }

    public void setA5ClientAcctId(String value) {
        this.a5ClientAcctId = value;
    }
            public String getA5Userid() {
        return a5Userid;
    }

    public void setA5Userid(String value) {
        this.a5Userid = value;
    }
            public Long getA5StatusCd() {
        return a5StatusCd;
    }

    public void setA5StatusCd(Long value) {
        this.a5StatusCd = value;
    }
            public Long getA5MasterPlanNo() {
        return a5MasterPlanNo;
    }

    public void setA5MasterPlanNo(Long value) {
        this.a5MasterPlanNo = value;
    }
            public Long getA5MasterPlanUnits() {
        return a5MasterPlanUnits;
    }

    public void setA5MasterPlanUnits(Long value) {
        this.a5MasterPlanUnits = value;
    }
            public A5SuppPlansArray getA5SuppPlans() {
        return a5SuppPlans;
    }

    public void setA5SuppPlans(A5SuppPlansArray value) {
        this.a5SuppPlans = value;
    }
            public A5SuppPlanUnitsArray getA5SuppPlanUnits() {
        return a5SuppPlanUnits;
    }

    public void setA5SuppPlanUnits(A5SuppPlanUnitsArray value) {
        this.a5SuppPlanUnits = value;
    }
            public Long getA5NotifyMethod() {
        return a5NotifyMethod;
    }

    public void setA5NotifyMethod(Long value) {
        this.a5NotifyMethod = value;
    }
            public String getA5PromoCd() {
        return a5PromoCd;
    }

    public void setA5PromoCd(String value) {
        this.a5PromoCd = value;
    }
            public String getA5Password() {
        return a5Password;
    }

    public void setA5Password(String value) {
        this.a5Password = value;
    }
            public String getA5SecretQuestion() {
        return a5SecretQuestion;
    }

    public void setA5SecretQuestion(String value) {
        this.a5SecretQuestion = value;
    }
            public String getA5SecretQuestionAnswer() {
        return a5SecretQuestionAnswer;
    }

    public void setA5SecretQuestionAnswer(String value) {
        this.a5SecretQuestionAnswer = value;
    }
            public String getA5FirstName() {
        return a5FirstName;
    }

    public void setA5FirstName(String value) {
        this.a5FirstName = value;
    }
            public String getA5Mi() {
        return a5Mi;
    }

    public void setA5Mi(String value) {
        this.a5Mi = value;
    }
            public String getA5LastName() {
        return a5LastName;
    }

    public void setA5LastName(String value) {
        this.a5LastName = value;
    }
            public String getA5CompanyName() {
        return a5CompanyName;
    }

    public void setA5CompanyName(String value) {
        this.a5CompanyName = value;
    }
            public String getA5Address1() {
        return a5Address1;
    }

    public void setA5Address1(String value) {
        this.a5Address1 = value;
    }
            public String getA5Address2() {
        return a5Address2;
    }

    public void setA5Address2(String value) {
        this.a5Address2 = value;
    }
            public String getA5City() {
        return a5City;
    }

    public void setA5City(String value) {
        this.a5City = value;
    }
            public String getA5Locality() {
        return a5Locality;
    }

    public void setA5Locality(String value) {
        this.a5Locality = value;
    }
            public String getA5StateProv() {
        return a5StateProv;
    }

    public void setA5StateProv(String value) {
        this.a5StateProv = value;
    }
            public String getA5Country() {
        return a5Country;
    }

    public void setA5Country(String value) {
        this.a5Country = value;
    }
            public String getA5PostalCd() {
        return a5PostalCd;
    }

    public void setA5PostalCd(String value) {
        this.a5PostalCd = value;
    }
            public String getA5Phone() {
        return a5Phone;
    }

    public void setA5Phone(String value) {
        this.a5Phone = value;
    }
            public String getA5PhoneExt() {
        return a5PhoneExt;
    }

    public void setA5PhoneExt(String value) {
        this.a5PhoneExt = value;
    }
            public String getA5CellPhone() {
        return a5CellPhone;
    }

    public void setA5CellPhone(String value) {
        this.a5CellPhone = value;
    }
            public String getA5WorkPhone() {
        return a5WorkPhone;
    }

    public void setA5WorkPhone(String value) {
        this.a5WorkPhone = value;
    }
            public String getA5WorkPhoneExt() {
        return a5WorkPhoneExt;
    }

    public void setA5WorkPhoneExt(String value) {
        this.a5WorkPhoneExt = value;
    }
            public String getA5Email() {
        return a5Email;
    }

    public void setA5Email(String value) {
        this.a5Email = value;
    }
            public String getA5Birthdate() {
        return a5Birthdate;
    }

    public void setA5Birthdate(String value) {
        this.a5Birthdate = value;
    }
            public String getA5BillFirstName() {
        return a5BillFirstName;
    }

    public void setA5BillFirstName(String value) {
        this.a5BillFirstName = value;
    }
            public String getA5BillMi() {
        return a5BillMi;
    }

    public void setA5BillMi(String value) {
        this.a5BillMi = value;
    }
            public String getA5BillLastName() {
        return a5BillLastName;
    }

    public void setA5BillLastName(String value) {
        this.a5BillLastName = value;
    }
            public String getA5BillCompanyName() {
        return a5BillCompanyName;
    }

    public void setA5BillCompanyName(String value) {
        this.a5BillCompanyName = value;
    }
            public String getA5BillAddress1() {
        return a5BillAddress1;
    }

    public void setA5BillAddress1(String value) {
        this.a5BillAddress1 = value;
    }
            public String getA5BillAddress2() {
        return a5BillAddress2;
    }

    public void setA5BillAddress2(String value) {
        this.a5BillAddress2 = value;
    }
            public String getA5BillCity() {
        return a5BillCity;
    }

    public void setA5BillCity(String value) {
        this.a5BillCity = value;
    }
            public String getA5BillLocality() {
        return a5BillLocality;
    }

    public void setA5BillLocality(String value) {
        this.a5BillLocality = value;
    }
            public String getA5BillStateProv() {
        return a5BillStateProv;
    }

    public void setA5BillStateProv(String value) {
        this.a5BillStateProv = value;
    }
            public String getA5BillCountry() {
        return a5BillCountry;
    }

    public void setA5BillCountry(String value) {
        this.a5BillCountry = value;
    }
            public String getA5BillPostalCd() {
        return a5BillPostalCd;
    }

    public void setA5BillPostalCd(String value) {
        this.a5BillPostalCd = value;
    }
            public String getA5BillPhone() {
        return a5BillPhone;
    }

    public void setA5BillPhone(String value) {
        this.a5BillPhone = value;
    }
            public String getA5BillPhoneExt() {
        return a5BillPhoneExt;
    }

    public void setA5BillPhoneExt(String value) {
        this.a5BillPhoneExt = value;
    }
            public String getA5BillCellPhone() {
        return a5BillCellPhone;
    }

    public void setA5BillCellPhone(String value) {
        this.a5BillCellPhone = value;
    }
            public String getA5BillWorkPhone() {
        return a5BillWorkPhone;
    }

    public void setA5BillWorkPhone(String value) {
        this.a5BillWorkPhone = value;
    }
            public String getA5BillWorkPhoneExt() {
        return a5BillWorkPhoneExt;
    }

    public void setA5BillWorkPhoneExt(String value) {
        this.a5BillWorkPhoneExt = value;
    }
            public String getA5BillEmail() {
        return a5BillEmail;
    }

    public void setA5BillEmail(String value) {
        this.a5BillEmail = value;
    }
            public Long getA5PayMethod() {
        return a5PayMethod;
    }

    public void setA5PayMethod(Long value) {
        this.a5PayMethod = value;
    }
            public String getA5CcNumber() {
        return a5CcNumber;
    }

    public void setA5CcNumber(String value) {
        this.a5CcNumber = value;
    }
            public Long getA5CcExpireMm() {
        return a5CcExpireMm;
    }

    public void setA5CcExpireMm(Long value) {
        this.a5CcExpireMm = value;
    }
            public Long getA5CcExpireYyyy() {
        return a5CcExpireYyyy;
    }

    public void setA5CcExpireYyyy(Long value) {
        this.a5CcExpireYyyy = value;
    }
            public String getA5BankAcctNo() {
        return a5BankAcctNo;
    }

    public void setA5BankAcctNo(String value) {
        this.a5BankAcctNo = value;
    }
            public String getA5BankRoutingNo() {
        return a5BankRoutingNo;
    }

    public void setA5BankRoutingNo(String value) {
        this.a5BankRoutingNo = value;
    }
            public Long getA5RespLevelCd() {
        return a5RespLevelCd;
    }

    public void setA5RespLevelCd(Long value) {
        this.a5RespLevelCd = value;
    }
            public A5FunctionalAcctGroupsArray getA5FunctionalAcctGroups() {
        return a5FunctionalAcctGroups;
    }

    public void setA5FunctionalAcctGroups(A5FunctionalAcctGroupsArray value) {
        this.a5FunctionalAcctGroups = value;
    }
            public A5CollectionsAcctGroupsArray getA5CollectionsAcctGroups() {
        return a5CollectionsAcctGroups;
    }

    public void setA5CollectionsAcctGroups(A5CollectionsAcctGroupsArray value) {
        this.a5CollectionsAcctGroups = value;
    }
            public A5SuppFieldNamesArray getA5SuppFieldNames() {
        return a5SuppFieldNames;
    }

    public void setA5SuppFieldNames(A5SuppFieldNamesArray value) {
        this.a5SuppFieldNames = value;
    }
            public A5SuppFieldValuesArray getA5SuppFieldValues() {
        return a5SuppFieldValues;
    }

    public void setA5SuppFieldValues(A5SuppFieldValuesArray value) {
        this.a5SuppFieldValues = value;
    }
            public Long getA5TestAcctInd() {
        return a5TestAcctInd;
    }

    public void setA5TestAcctInd(Long value) {
        this.a5TestAcctInd = value;
    }
            public Long getA5StatusUntilAltStart() {
        return a5StatusUntilAltStart;
    }

    public void setA5StatusUntilAltStart(Long value) {
        this.a5StatusUntilAltStart = value;
    }
            public Double getA5BalanceForward() {
        return a5BalanceForward;
    }

    public void setA5BalanceForward(Double value) {
        this.a5BalanceForward = value;
    }
            public Long getA5AltBillDay() {
        return a5AltBillDay;
    }

    public void setA5AltBillDay(Long value) {
        this.a5AltBillDay = value;
    }
            public String getA5DoFullInvoicing() {
        return a5DoFullInvoicing;
    }

    public void setA5DoFullInvoicing(String value) {
        this.a5DoFullInvoicing = value;
    }
            public String getA5DoProratedInvoicing() {
        return a5DoProratedInvoicing;
    }

    public void setA5DoProratedInvoicing(String value) {
        this.a5DoProratedInvoicing = value;
    }
            public Long getA5MasterPlanAltRateSchedNo() {
        return a5MasterPlanAltRateSchedNo;
    }

    public void setA5MasterPlanAltRateSchedNo(Long value) {
        this.a5MasterPlanAltRateSchedNo = value;
    }
            public A5SuppPlanAltRateSchedNoArray getA5SuppPlanAltRateSchedNo() {
        return a5SuppPlanAltRateSchedNo;
    }

    public void setA5SuppPlanAltRateSchedNo(A5SuppPlanAltRateSchedNoArray value) {
        this.a5SuppPlanAltRateSchedNo = value;
    }
            public String getA5CurrencyCd() {
        return a5CurrencyCd;
    }

    public void setA5CurrencyCd(String value) {
        this.a5CurrencyCd = value;
    }
            public String getA5Cvv() {
        return a5Cvv;
    }

    public void setA5Cvv(String value) {
        this.a5Cvv = value;
    }
            public String getA5TaxpayerId() {
        return a5TaxpayerId;
    }

    public void setA5TaxpayerId(String value) {
        this.a5TaxpayerId = value;
    }
            public String getA5BillAgreementId() {
        return a5BillAgreementId;
    }

    public void setA5BillAgreementId(String value) {
        this.a5BillAgreementId = value;
    }
            public String getA5RetroactiveStartDate() {
        return a5RetroactiveStartDate;
    }

    public void setA5RetroactiveStartDate(String value) {
        this.a5RetroactiveStartDate = value;
    }
            public A5CouponCodesArray getA5CouponCodes() {
        return a5CouponCodes;
    }

    public void setA5CouponCodes(A5CouponCodesArray value) {
        this.a5CouponCodes = value;
    }
            public A5NewAcctCustomRatesArray getA5NewAcctCustomRates() {
        return a5NewAcctCustomRates;
    }

    public void setA5NewAcctCustomRates(A5NewAcctCustomRatesArray value) {
        this.a5NewAcctCustomRates = value;
    }
            public Long getA5AltMsgTemplateNo() {
        return a5AltMsgTemplateNo;
    }

    public void setA5AltMsgTemplateNo(Long value) {
        this.a5AltMsgTemplateNo = value;
    }
            public Long getA5SeqFuncGroupNo() {
        return a5SeqFuncGroupNo;
    }

    public void setA5SeqFuncGroupNo(Long value) {
        this.a5SeqFuncGroupNo = value;
    }
            public A5NewAcctPlanContractsArray getA5NewAcctPlanContracts() {
        return a5NewAcctPlanContracts;
    }

    public void setA5NewAcctPlanContracts(A5NewAcctPlanContractsArray value) {
        this.a5NewAcctPlanContracts = value;
    }
            public String getA5BankAcctType() {
        return a5BankAcctType;
    }

    public void setA5BankAcctType(String value) {
        this.a5BankAcctType = value;
    }
            public String getA5Address3() {
        return a5Address3;
    }

    public void setA5Address3(String value) {
        this.a5Address3 = value;
    }
            public String getA5BillAddress3() {
        return a5BillAddress3;
    }

    public void setA5BillAddress3(String value) {
        this.a5BillAddress3 = value;
    }
            public A5UsageAccumulationConfigArray getA5UsageAccumulationConfig() {
        return a5UsageAccumulationConfig;
    }

    public void setA5UsageAccumulationConfig(A5UsageAccumulationConfigArray value) {
        this.a5UsageAccumulationConfig = value;
    }
            public A5EnableUsagePoolingPlanNoArray getA5EnableUsagePoolingPlanNo() {
        return a5EnableUsagePoolingPlanNo;
    }

    public void setA5EnableUsagePoolingPlanNo(A5EnableUsagePoolingPlanNoArray value) {
        this.a5EnableUsagePoolingPlanNo = value;
    }
            public A5ClientFuncAcctGroupIdsArray getA5ClientFuncAcctGroupIds() {
        return a5ClientFuncAcctGroupIds;
    }

    public void setA5ClientFuncAcctGroupIds(A5ClientFuncAcctGroupIdsArray value) {
        this.a5ClientFuncAcctGroupIds = value;
    }
            public A5ClientCollAcctGroupIdsArray getA5ClientCollAcctGroupIds() {
        return a5ClientCollAcctGroupIds;
    }

    public void setA5ClientCollAcctGroupIds(A5ClientCollAcctGroupIdsArray value) {
        this.a5ClientCollAcctGroupIds = value;
    }
            public String getA5TrackData1() {
        return a5TrackData1;
    }

    public void setA5TrackData1(String value) {
        this.a5TrackData1 = value;
    }
            public String getA5TrackData2() {
        return a5TrackData2;
    }

    public void setA5TrackData2(String value) {
        this.a5TrackData2 = value;
    }
            public Long getA5TaxExemptionLevel() {
        return a5TaxExemptionLevel;
    }

    public void setA5TaxExemptionLevel(Long value) {
        this.a5TaxExemptionLevel = value;
    }
            public Long getA5CnAltMsgTemplateNo() {
        return a5CnAltMsgTemplateNo;
    }

    public void setA5CnAltMsgTemplateNo(Long value) {
        this.a5CnAltMsgTemplateNo = value;
    }
            public String getA5InvoiceApprovalRequired() {
        return a5InvoiceApprovalRequired;
    }

    public void setA5InvoiceApprovalRequired(String value) {
        this.a5InvoiceApprovalRequired = value;
    }
            public String getA5CreateSession() {
        return a5CreateSession;
    }

    public void setA5CreateSession(String value) {
        this.a5CreateSession = value;
    }
            public String getA5ClientMasterPlanId() {
        return a5ClientMasterPlanId;
    }

    public void setA5ClientMasterPlanId(String value) {
        this.a5ClientMasterPlanId = value;
    }
            public A5ClientSuppPlanIdsArray getA5ClientSuppPlanIds() {
        return a5ClientSuppPlanIds;
    }

    public void setA5ClientSuppPlanIds(A5ClientSuppPlanIdsArray value) {
        this.a5ClientSuppPlanIds = value;
    }
            public String getA5ClientMpAltRateSchedId() {
        return a5ClientMpAltRateSchedId;
    }

    public void setA5ClientMpAltRateSchedId(String value) {
        this.a5ClientMpAltRateSchedId = value;
    }
            public A5ClientSpAltRateSchedIdsArray getA5ClientSpAltRateSchedIds() {
        return a5ClientSpAltRateSchedIds;
    }

    public void setA5ClientSpAltRateSchedIds(A5ClientSpAltRateSchedIdsArray value) {
        this.a5ClientSpAltRateSchedIds = value;
    }
            public String getA5ClientAltMsgTemplateId() {
        return a5ClientAltMsgTemplateId;
    }

    public void setA5ClientAltMsgTemplateId(String value) {
        this.a5ClientAltMsgTemplateId = value;
    }
            public String getA5ClientCnAltMsgTemplateNo() {
        return a5ClientCnAltMsgTemplateNo;
    }

    public void setA5ClientCnAltMsgTemplateNo(String value) {
        this.a5ClientCnAltMsgTemplateNo = value;
    }
            public String getA5Iban() {
        return a5Iban;
    }

    public void setA5Iban(String value) {
        this.a5Iban = value;
    }
            public Long getA5BankCheckDigit() {
        return a5BankCheckDigit;
    }

    public void setA5BankCheckDigit(Long value) {
        this.a5BankCheckDigit = value;
    }
            public String getA5BankSwiftCd() {
        return a5BankSwiftCd;
    }

    public void setA5BankSwiftCd(String value) {
        this.a5BankSwiftCd = value;
    }
            public String getA5BankCountryCd() {
        return a5BankCountryCd;
    }

    public void setA5BankCountryCd(String value) {
        this.a5BankCountryCd = value;
    }
            public String getA5MandateId() {
        return a5MandateId;
    }

    public void setA5MandateId(String value) {
        this.a5MandateId = value;
    }
            public String getA5BankIdCd() {
        return a5BankIdCd;
    }

    public void setA5BankIdCd(String value) {
        this.a5BankIdCd = value;
    }
            public String getA5BankBranchCd() {
        return a5BankBranchCd;
    }

    public void setA5BankBranchCd(String value) {
        this.a5BankBranchCd = value;
    }
            public A5SurchargeNoArray getA5SurchargeNo() {
        return a5SurchargeNo;
    }

    public void setA5SurchargeNo(A5SurchargeNoArray value) {
        this.a5SurchargeNo = value;
    }
            public String getA5BkupBillFirstName() {
        return a5BkupBillFirstName;
    }

    public void setA5BkupBillFirstName(String value) {
        this.a5BkupBillFirstName = value;
    }
            public String getA5BkupBillMi() {
        return a5BkupBillMi;
    }

    public void setA5BkupBillMi(String value) {
        this.a5BkupBillMi = value;
    }
            public String getA5BkupBillLastName() {
        return a5BkupBillLastName;
    }

    public void setA5BkupBillLastName(String value) {
        this.a5BkupBillLastName = value;
    }
            public String getA5BkupBillCompanyName() {
        return a5BkupBillCompanyName;
    }

    public void setA5BkupBillCompanyName(String value) {
        this.a5BkupBillCompanyName = value;
    }
            public String getA5BkupBillAddress1() {
        return a5BkupBillAddress1;
    }

    public void setA5BkupBillAddress1(String value) {
        this.a5BkupBillAddress1 = value;
    }
            public String getA5BkupBillAddress2() {
        return a5BkupBillAddress2;
    }

    public void setA5BkupBillAddress2(String value) {
        this.a5BkupBillAddress2 = value;
    }
            public String getA5BkupBillAddress3() {
        return a5BkupBillAddress3;
    }

    public void setA5BkupBillAddress3(String value) {
        this.a5BkupBillAddress3 = value;
    }
            public String getA5BkupBillCity() {
        return a5BkupBillCity;
    }

    public void setA5BkupBillCity(String value) {
        this.a5BkupBillCity = value;
    }
            public String getA5BkupBillLocality() {
        return a5BkupBillLocality;
    }

    public void setA5BkupBillLocality(String value) {
        this.a5BkupBillLocality = value;
    }
            public String getA5BkupBillStateProv() {
        return a5BkupBillStateProv;
    }

    public void setA5BkupBillStateProv(String value) {
        this.a5BkupBillStateProv = value;
    }
            public String getA5BkupBillCountry() {
        return a5BkupBillCountry;
    }

    public void setA5BkupBillCountry(String value) {
        this.a5BkupBillCountry = value;
    }
            public String getA5BkupBillPostalCd() {
        return a5BkupBillPostalCd;
    }

    public void setA5BkupBillPostalCd(String value) {
        this.a5BkupBillPostalCd = value;
    }
            public String getA5BkupBillPhone() {
        return a5BkupBillPhone;
    }

    public void setA5BkupBillPhone(String value) {
        this.a5BkupBillPhone = value;
    }
            public String getA5BkupBillPhoneExt() {
        return a5BkupBillPhoneExt;
    }

    public void setA5BkupBillPhoneExt(String value) {
        this.a5BkupBillPhoneExt = value;
    }
            public String getA5BkupBillCellPhone() {
        return a5BkupBillCellPhone;
    }

    public void setA5BkupBillCellPhone(String value) {
        this.a5BkupBillCellPhone = value;
    }
            public String getA5BkupBillWorkPhone() {
        return a5BkupBillWorkPhone;
    }

    public void setA5BkupBillWorkPhone(String value) {
        this.a5BkupBillWorkPhone = value;
    }
            public String getA5BkupBillWorkPhoneExt() {
        return a5BkupBillWorkPhoneExt;
    }

    public void setA5BkupBillWorkPhoneExt(String value) {
        this.a5BkupBillWorkPhoneExt = value;
    }
            public String getA5BkupBillEmail() {
        return a5BkupBillEmail;
    }

    public void setA5BkupBillEmail(String value) {
        this.a5BkupBillEmail = value;
    }
            public Long getA5BkupPayMethod() {
        return a5BkupPayMethod;
    }

    public void setA5BkupPayMethod(Long value) {
        this.a5BkupPayMethod = value;
    }
            public String getA5BkupCcNumber() {
        return a5BkupCcNumber;
    }

    public void setA5BkupCcNumber(String value) {
        this.a5BkupCcNumber = value;
    }
            public Long getA5BkupCcExpireMm() {
        return a5BkupCcExpireMm;
    }

    public void setA5BkupCcExpireMm(Long value) {
        this.a5BkupCcExpireMm = value;
    }
            public Long getA5BkupCcExpireYyyy() {
        return a5BkupCcExpireYyyy;
    }

    public void setA5BkupCcExpireYyyy(Long value) {
        this.a5BkupCcExpireYyyy = value;
    }
            public String getA5BkupBankAcctNo() {
        return a5BkupBankAcctNo;
    }

    public void setA5BkupBankAcctNo(String value) {
        this.a5BkupBankAcctNo = value;
    }
            public String getA5BkupBankRoutingNo() {
        return a5BkupBankRoutingNo;
    }

    public void setA5BkupBankRoutingNo(String value) {
        this.a5BkupBankRoutingNo = value;
    }
            public String getA5BkupBankAcctType() {
        return a5BkupBankAcctType;
    }

    public void setA5BkupBankAcctType(String value) {
        this.a5BkupBankAcctType = value;
    }
            public String getA5BkupBillAgreementId() {
        return a5BkupBillAgreementId;
    }

    public void setA5BkupBillAgreementId(String value) {
        this.a5BkupBillAgreementId = value;
    }
            public String getA5BkupCvv() {
        return a5BkupCvv;
    }

    public void setA5BkupCvv(String value) {
        this.a5BkupCvv = value;
    }
            public String getA5SeqFuncGroupId() {
        return a5SeqFuncGroupId;
    }

    public void setA5SeqFuncGroupId(String value) {
        this.a5SeqFuncGroupId = value;
    }
            public Long getA5RevrecProfileId() {
        return a5RevrecProfileId;
    }

    public void setA5RevrecProfileId(Long value) {
        this.a5RevrecProfileId = value;
    }
            public String getA5RevrecClientDefinedId() {
        return a5RevrecClientDefinedId;
    }

    public void setA5RevrecClientDefinedId(String value) {
        this.a5RevrecClientDefinedId = value;
    }
                public String getA5StmntEmailListCc() {
        return a5StmntEmailListCc;
    }

    public void setA5StmntEmailListCc(String value) {
        this.a5StmntEmailListCc = value;
    }
            public String getA5StmntEmailListBcc() {
        return a5StmntEmailListBcc;
    }

    public void setA5StmntEmailListBcc(String value) {
        this.a5StmntEmailListBcc = value;
    }
            public Long getA5InvoicePostingMethodCd() {
        return a5InvoicePostingMethodCd;
    }

    public void setA5InvoicePostingMethodCd(Long value) {
        this.a5InvoicePostingMethodCd = value;
    }
            public String getA5AcctStartDate() {
        return a5AcctStartDate;
    }

    public void setA5AcctStartDate(String value) {
        this.a5AcctStartDate = value;
    }
            public Long getA5MinStatementThreshold() {
        return a5MinStatementThreshold;
    }

    public void setA5MinStatementThreshold(Long value) {
        this.a5MinStatementThreshold = value;
    }
            public Long getA5MaxStatementsToDefer() {
        return a5MaxStatementsToDefer;
    }

    public void setA5MaxStatementsToDefer(Long value) {
        this.a5MaxStatementsToDefer = value;
    }
            public Long getA5DeferFullStatementsOnly() {
        return a5DeferFullStatementsOnly;
    }

    public void setA5DeferFullStatementsOnly(Long value) {
        this.a5DeferFullStatementsOnly = value;
    }
            public Long getA5CcId() {
        return a5CcId;
    }

    public void setA5CcId(Long value) {
        this.a5CcId = value;
    }
            public Long getA5BkupCcId() {
        return a5BkupCcId;
    }

    public void setA5BkupCcId(Long value) {
        this.a5BkupCcId = value;
    }
            
}
