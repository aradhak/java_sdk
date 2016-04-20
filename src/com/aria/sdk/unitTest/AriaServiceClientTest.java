package com.aria.sdk.unitTest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.junit.Test;

import com.aria.sdk.classes.AriaBillingBuilder;
import com.aria.sdk.classes.AriaBillingComplete;
import com.aria.sdk.classes.BaseAriaBillingDTO;
import com.aria.sdk.classes.CallType;
import com.aria.sdk.classes.LibraryType;
import com.aria.sdk.classes.OutPutFormat;

public class AriaServiceClientTest {
    /**************************** CLASS ATTRIBUTES ***********************/
    public final String ERROR_CODE = "error_code";
    public final String ERROR_MESSAGE = "error_msg";
    private static ResourceBundle resourceBundle;
    private Map<String,Object> hashMapReturnValues = new HashMap<String,Object>();
    private AriaBillingComplete ariaBillingComplete;
    private String dispatcher = getResourceBundle().getString("api.dispatcher.url");
    /**************************** END - CLASS ATTRIBUTES ***********************/

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle("ariasdk");
        }
        return resourceBundle;
    }

    /**************************** GETTERS ***********************/
    public AriaBillingComplete getBaseAriaBilling() throws Exception {
        if (ariaBillingComplete == null){
            /*REST CALL*/
            BaseAriaBillingDTO baseAriaBillingDTO = new BaseAriaBillingDTO(dispatcher,"logger",false/*Debug*/,CallType.REST,OutPutFormat.OUTPUT_JSON,LibraryType.CORE);
            ariaBillingComplete = AriaBillingBuilder.getAriaSDK(baseAriaBillingDTO);
        }
        return ariaBillingComplete;
    }
    public long getClientNo() {
        return Long.parseLong(getResourceBundle().getString("client.no"));
    }
    public String getAuthKey() {
        return getResourceBundle().getString("client.auth.key");
    }
    /**************************** END - GETTERS ***********************/

    @org.junit.BeforeClass
    public static void init() {
    }
    /*************************** TEST ******************************/
    @Test
    /* Please, UnComment the method call on which you wnat to do the test */
    public void fullTest() throws Exception{
        //getInvoiceDetails();
        //applyCashCredit();
        //applyServiceCredit();
        //bulkRecordUsage();
        //cancelOrder();
        //cancelRecurringCredits();
        //cancelStandingOrder();
        //collectFromAccount();
        //compareAgainstCcBlacklist();
        //copyAcctPaymentMethod();
        //createOrder();
        //createOrderWithPlans();
        //createWriteoffOrDispute();
        //discardUsage();
        //genInvoice();
        //getAcctPaymentHistory();
        //getAcctPreviewStatement();
        //getAcctWriteoffOrDisputes();
        //getAllActionsByReceiptId();
        //getAriaXmlStatement();
        //getCcVelocityInfo();
        //getExtendedTransactionInfo();
        //getInvNoFromBalXfer();
        //getInvoicesToWriteoffOrDispute();
        //getOrder();
        //getOrderItems();
        //getPaymentApplicationDtls();
        //getPaymentApplications();
        //getPaymentsOnInvoice();
        //getRefundDetails();
        //getRefundablePayments();
        //getReversibleAuthorizations();
        //getReversibleInvsByPayment();
        //getStandingOrder();
        //getStandingOrderHist();
        //getStandingOrderItems();
        //getStatementForInvSize();
        //getStatementForInvoice();
        //getWriteoffDetails();
        //issueRefundToAcct();
        //managePendingInvoice();
        //movePayment();
        //preCalcInvoice();
        //recordAlternativePayment();
        //recordExternalPayment();
        //recordOutGoingPayment();
        //recordStandingOrder();
        //recordUsage();
        //reinstateTransaction();
        //reverseAuthorizedElectronicPayment();
        //settleAccountBalance();
        //settleDisputeHold();
        //transferAccountBalance();
        //updateAcctInvoice();
        //updateCcBlacklist();
        //updateOrder();
        //updateRefundCheckNo();
        //voidTransaction();
        //initPaypalBillAgreement();
        //savePaypalBillAgreement();
        //activateSuppPlan();
        //adjustBillingDates();
        //applyCouponToAcct();
        //assignCollectionsAcctGroup();
        //assignCustomAcctRates();
        //assignFunctionalAcctGroup();
        //assignSuppPlan();
        //assignSuppPlanMulti();
        //authorizeElectronicPayment();
        //banAcct();
        //cancelAcctMultiplanContract();
        //cancelAcctPlanContract();
        //cancelAcctUniversalContract();
        //cancelQueuedServicePlan();
        //cancelSuppPlan();
        //cancelUnappliedSvceCredits();
        //cancelUnconsumedCredit();
        //closeAcctInstallation();
        //createAccount();
        //createAcctComplete();
        //createAcctHierarchy();
        //createAcctMultiplanContract();
        //createAcctPlanContract();
        //createAcctUniversalContract();
        //createAdvancedServiceCredit();
        //deleteAcctCoupon();
        //disableAllStandingUsage();
        //disableStandingUsage();
        //disableStandingUsageByPlan();
        //genStatement();
        //getAcctBalance();
        //getAcctComments();
        //getAcctCreditDetails();
        //getAcctCredits();
        //getAcctDetailsAll();
        //getAcctGroupsByAcct();
        //getAcctGroupsByClient();
        //getAcctHasOrderedSku();
        //getAcctHierarchyDetails();
        //getAcctInvoiceHistory();
        //getAcctMessage();
        //getAcctMessageSize();
        //getAcctMultiplanContract();
        //getAcctNoFromUserId();
        //getAcctNotificationDetails();
        //getAcctNotifyMethod();
        //getAcctOpenCharges();
        //getAcctPaymentMethods();
        //getAcctPlanContract();
        //getAcctPlanHistory();
        //getAcctPlanUnitInstanceAll();
        //getAcctPlans();
        //getAcctPlansAll();
        //getAcctServiceOutageCredit();
        //getAcctStatementHistory();
        //getAcctStatusHistory();
        //getAcctSuppFields();
        //getAcctSuppPlanHistory();
        //getAcctTaxExemptStatus();
        //getAcctTransHistory();
        //getAcctUniversalContract();
        //getAcctUuids();
        //getAcctsWithExistingPayMethod();
        //getAllAcctActiveContracts();
        //getAllAcctContracts();
        //getAllAcctReceiptIds();
        //getAvailChildPlansForAcct();
        //getAvailChildPlansForAcctAll();
        //getAvailChildPlansForPlan();
        //getAvailChildPlansForPlanAll();
        //getAvailablePlans();
        //getAvailablePlansAll();
        //getCcUuid();
        //getChildAccts();
        //getCouponDetails();
        //getCreditReasonCodes();
        //getFamilyTransHistory();
        //getPaymentMethods();
        //getPendingInvoiceNo();
        //getPlansByPromoCode();
        //getPlansByPromoCodeAll();
        //getPmtUuid();
        //getQueuedServicePlans();
        //getRecurringCreditInfo();
        //getStandingUsage();
        //getStatementContent();
        //getStatementContentSize();
        //getSuppFieldValues();
        //getSuppPlansByPromoCode();
        //getSuppPlansByPromoCodeAll();
        //getUnappliedServiceCredits();
        //getUnbilledUsageSummary();
        //getUsageHistory();
        //getUsageSummaryByType();
        //getUserIdFromAcctNo();
        //getUseridHasOrderedSku();
        //modifyAcctMultiplanContract();
        //modifyAcctPlanContract();
        //modifyAcctPlanUnitInstances();
        //modifyAcctSuppFields();
        //modifyAcctUniversalContract();
        //modifySuppPlan();
        //recordStandingUsage();
        //removeAcctFromGroup();
        //removeCustomAcctRates();
        //removePayMethod();
        //replaceSuppPlan();
        //resetUsgMtdBal();
        //resetUsgPtdBal();
        //sendAcctEmail();
        //sendAcctStatementEmail();
        //sendArcThresholdEmail();
        //setAcctNotifyOverride();
        //setAcctNotifyTmpltGrp();
        //setAcctTaxExemptStatus();
        //setAcctUsgDailyThreshold();
        //setAcctUsgMtdThreshold();
        //setAcctUsgPtdThreshold();
        //setClientUsgDailyThreshold();
        //setClientUsgMtdThreshold();
        //setClientUsgPtdThreshold();
        //setPayMethodBankDraft();
        //setPayMethodCc();
        //setPayMethodNetTerms();
        //setPaymentResponsibility();
        //setServicePlan();
        //setServicePlanImmediately();
        //setServicePlanNumber();
        //toggleTestAccount();
        //updateAcctBillingContact();
        //updateAcctComplete();
        //updateAcctContact();
        //updateAcctCredentials();
        //updateAcctNotifyMethod();
        //updateAcctPlanUnitInstance();
        //updateAcctStatus();
        //updateAcctSuppFields();
        //updateExistingBillingInfo();
        //updateMasterPlan();
        //updatePaymentMethod();
        //useridExists();
        //useridIsAvailable();
        //validatePaymentInformation();
        //writeAcctComment();
        //authenticateCaller();
        //keepAlive();
        //killSession();
        //setSession();
        //setSessionAuth();
        //validateSession();
        //advanceVirtualDatetime();
        //clearRegUssConfigParams();
        //clearRegUssParams();
        //clientHasEventClass();
        //deleteRegUssConfigParams();
        //deleteRegUssParams();
        //genRandomString();
        //getAcctSurcharges();
        //getAllClientReceiptIds();
        //getAufStatus();
        //getChildForItemClass();
        //getClientCountries();
        //getClientCurrencies();
        //getClientItemClasses();
        //getClientItemImages();
        //getClientItemPrices();
        //getClientItemSuppFields();
        //getClientItems();
        //getClientItemsAll();
        //getClientItemsBasic();
        //getClientPlanServiceRates();
        //getClientPlanServices();
        //getClientPlans();
        //getClientPlansAll();
        //getClientPlansBasic();
        //getCountryFromIp();
        //getCurrentSystemVersion();
        //getDailyBatchStatus();
        //getEmailTemplates();
        //getItemRatingsReviews();
        //getItemsByClass();
        //getItemsBySuppField();
        //getMasterPlansBySuppField();
        //getParentForItemClass();
        //getRateSchedulesForPlan();
        //getRegUssConfigParams();
        //getRegUssParams();
        //getSuppPlansBySuppField();
        //getTopLevelItemClass();
        //getVirtualDatetime();
        //getWebReplacementVals();
        //recordItemRatingsReviews();
        //replaceRegUssConfigParams();
        //replaceRegUssParams();
        //setExternalObjectId();
        //setProvEngine();
        //setRegUssConfigParams();
        //setRegUssParams();
        //subscribeEvent();
        //subscribeEventClass();
        //subscribeEvents();
        //unsubscribeEvent();
        //unsubscribeEventClass();
        //unsubscribeEvents();
        //updateInventoryItemStock();
        //savePaypalBillAgreementM();
        //acctPlanInstallCompleteM();
        //adjustAcctPlanBillingDatesM();
        //applyCouponToAcctM();
        //assignAcctPlanM();
        //assignCustomAcctPlanRatesM();
        //authorizeElectronicPaymentM();
        //cancelAcctPlanM();
        //cancelInstanceContractM();
        //cancelQueuedAcctPlanChangeM();
        //cancelUnappliedServiceCreditsM();
        //createAcctBillingGroupM();
        //createAcctCompleteM();
        //createAcctDunningGroupM();
        //createAdvancedServiceCreditM();
        //createInstanceContractM();
        //deleteAcctCouponM();
        //genStatementM();
        //getAcctBalanceM();
        //getAcctBillingGroupDetailsM();
        //getAcctContactsM();
        //getAcctCouponDetailsM();
        //getAcctCreditsM();
        //getAcctDetailsAllM();
        //getAcctDunningGroupDetailsM();
        //getAcctHierarchyDetailsM();
        //getAcctPaymentMethodsM();
        //getAcctPlanBalanceM();
        //getAcctPlanHistoryM();
        //getAcctPlanNotifyMethodM();
        //getAcctPlanUnitInstanceAllM();
        //getAcctPlansAllM();
        //getAcctPlansM();
        //getAcctServiceOutageCreditM();
        //getAcctStatementHistoryM();
        //getAcctTransHistoryM();
        //getAcctUuidsM();
        //getAllAcctContractsM();
        //getAvailPlansForAcctAllM();
        //getAvailPlansForAcctM();
        //getCashCreditsDetailsM();
        //getCcUuidM();
        //getCreditDetailsM();
        //getFamilyTransHistoryM();
        //getInstanceContractM();
        //getInvoiceHistoryM();
        //getPendingInvoiceNoM();
        //getPlansByPromoCodeAllM();
        //getPlansByPromoCodeM();
        //getPmtUuidM();
        //getQueuedAcctPlansM();
        //getRateSchedulesForPlanM();
        //getRecurringCreditInfoM();
        //getSuppPlansByPromoCodeAllM();
        //getSuppPlansByPromoCodeM();
        //getUnappliedServiceCreditsM();
        //getUnbilledUsageSummaryM();
        //getUsageHistoryM();
        //getUsageSummaryByTypeM();
        //modifyAcctPlanUnitInstancesM();
        //modifyInstanceContractM();
        //removeAcctPaymentMethodM();
        //removeAcctPlanCustomRatesM();
        //replaceAcctPlanM();
        //setMonetaryUsgThresholdM();
        //setPaymentResponsibilityM();
        //setUsgMtdPtdBalM();
        //updateAcctBillingGroupM();
        //updateAcctCompleteM();
        //updateAcctDunningGroupM();
        //updateAcctPlanM();
        //updateAcctPlanMultiM();
        //updateAcctPlanStatusM();
        //updateAcctPlanUnitInstanceM();
        //updateContactM();
        //updatePaymentMethodM();
        //setSessionAuthM();
        //setSessionM();
        //validateSessionM();
        //getAcctNsoInclusionListM();
        //getAcctSurchargesM();
        //getClientItemsAllM();
        //getClientItemsBasicM();
        //getClientItemsM();
        //getClientPlansAllM();
        //getClientPlansBasicM();
        //getMasterPlansBySuppFieldM();
        //getSuppPlansBySuppFieldM();
        //applyCashCreditM();
        //applyServiceCreditM();
        //bulkRecordUsageM();
        //cancelRecurringCreditsM();
        //collectFromAccountM();
        //copyAcctPaymentMethodM();
        //createOrderM();
        //createOrderWithPlanM();
        //createWriteoffOrDisputeM();
        //genInvoiceM();
        //getAcctPaymentHistoryM();
        //getAcctPreviewStatementM();
        //getAcctWriteoffOrDisputesM();
        //getInvNoFromBalXferM();
        //getInvoiceDetailsM();
        //getInvoicesToWriteoffOrDisputeM();
        //getOrderM();
        //getPaymentsOnInvoiceM();
        //getRefundablePaymentsM();
        //getReversibleInvsByPaymentM();
        //getUnappliedCreditsPaymentsM();
        //getWriteoffDetailsM();
        //issueRefundToAcctM();
        //managePendingInvoiceM();
        //recordAlternativePaymentM();
        //recordExternalPaymentM();
        //recordUsageM();
        //settleAccountBalanceM();
        //updateCcBlacklistM();
        //voidInvoiceM();
            }

    //@Test
    public void getInvoiceDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoiceDetails(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoiceDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void applyCashCredit() throws Exception {
        com.aria.common.shared.SpecificChargeTransactionIdArray specificChargeTransactionIdArray = new com.aria.common.shared.SpecificChargeTransactionIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().applyCashCredit(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
                , specificChargeTransactionIdArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "applyCashCredit - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void applyServiceCredit() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().applyServiceCredit(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "applyServiceCredit - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void bulkRecordUsage() throws Exception {
        com.aria.common.shared.UsageRecordsArray usageRecordsArray = new com.aria.common.shared.UsageRecordsArray();
        
        hashMapReturnValues = getBaseAriaBilling().bulkRecordUsage(getClientNo(), getAuthKey()        , usageRecordsArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "bulkRecordUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelOrder() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelOrder(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelRecurringCredits() throws Exception {
        com.aria.common.shared.RecurringCreditNoArray recurringCreditNoArray = new com.aria.common.shared.RecurringCreditNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().cancelRecurringCredits(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , recurringCreditNoArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelRecurringCredits - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelStandingOrder() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelStandingOrder(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelStandingOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void collectFromAccount() throws Exception {
        com.aria.common.shared.SpecificChargeTransactionIdArray specificChargeTransactionIdArray = new com.aria.common.shared.SpecificChargeTransactionIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().collectFromAccount(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
                , specificChargeTransactionIdArray
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "collectFromAccount - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void compareAgainstCcBlacklist() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().compareAgainstCcBlacklist(getClientNo(), getAuthKey()        , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "compareAgainstCcBlacklist - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void copyAcctPaymentMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().copyAcctPaymentMethod(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "copyAcctPaymentMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createOrder() throws Exception {
        com.aria.common.shared.OrderLineItemsListArray orderLineItemsListArray = new com.aria.common.shared.OrderLineItemsListArray();
        
        hashMapReturnValues = getBaseAriaBilling().createOrder(getClientNo(), getAuthKey()        , 1L
                , orderLineItemsListArray
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createOrderWithPlans() throws Exception {
        com.aria.common.shared.OrderLineItemsListArray orderLineItemsListArray = new com.aria.common.shared.OrderLineItemsListArray();
        com.aria.common.shared.CartSuppPlansArray cartSuppPlansArray = new com.aria.common.shared.CartSuppPlansArray();
        com.aria.common.shared.MultipleCouponsArray multipleCouponsArray = new com.aria.common.shared.MultipleCouponsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createOrderWithPlans(getClientNo(), getAuthKey()        , 1L
                , orderLineItemsListArray
                , cartSuppPlansArray
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , multipleCouponsArray
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createOrderWithPlans - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createWriteoffOrDispute() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createWriteoffOrDispute(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1d
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createWriteoffOrDispute - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void discardUsage() throws Exception {
        com.aria.common.shared.UsageRecordNosArray usageRecordNosArray = new com.aria.common.shared.UsageRecordNosArray();
        com.aria.common.shared.ClientRecordIdsArray clientRecordIdsArray = new com.aria.common.shared.ClientRecordIdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().discardUsage(getClientNo(), getAuthKey()        , usageRecordNosArray
                , clientRecordIdsArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "discardUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void genInvoice() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().genInvoice(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "genInvoice - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPaymentHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPaymentHistory(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPaymentHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPreviewStatement() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPreviewStatement(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPreviewStatement - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctWriteoffOrDisputes() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctWriteoffOrDisputes(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctWriteoffOrDisputes - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllActionsByReceiptId() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllActionsByReceiptId(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllActionsByReceiptId - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAriaXmlStatement() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAriaXmlStatement(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAriaXmlStatement - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCcVelocityInfo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCcVelocityInfo(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCcVelocityInfo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getExtendedTransactionInfo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getExtendedTransactionInfo(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getExtendedTransactionInfo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvNoFromBalXfer() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvNoFromBalXfer(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvNoFromBalXfer - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvoicesToWriteoffOrDispute() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoicesToWriteoffOrDispute(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoicesToWriteoffOrDispute - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getOrder() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getOrder(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getOrderItems() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getOrderItems(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getOrderItems - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPaymentApplicationDtls() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPaymentApplicationDtls(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPaymentApplicationDtls - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPaymentApplications() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPaymentApplications(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPaymentApplications - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPaymentsOnInvoice() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPaymentsOnInvoice(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPaymentsOnInvoice - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRefundDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRefundDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRefundDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRefundablePayments() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRefundablePayments(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRefundablePayments - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getReversibleAuthorizations() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getReversibleAuthorizations(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getReversibleAuthorizations - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getReversibleInvsByPayment() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getReversibleInvsByPayment(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getReversibleInvsByPayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStandingOrder() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStandingOrder(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStandingOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStandingOrderHist() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStandingOrderHist(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStandingOrderHist - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStandingOrderItems() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStandingOrderItems(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStandingOrderItems - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStatementForInvSize() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStatementForInvSize(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStatementForInvSize - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStatementForInvoice() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStatementForInvoice(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStatementForInvoice - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getWriteoffDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getWriteoffDetails(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getWriteoffDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void issueRefundToAcct() throws Exception {
        com.aria.common.shared.InvoicesToReverseArray invoicesToReverseArray = new com.aria.common.shared.InvoicesToReverseArray();
        
        hashMapReturnValues = getBaseAriaBilling().issueRefundToAcct(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1d
                , ""
                , ""
                , ""
                , ""
                , invoicesToReverseArray
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "issueRefundToAcct - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void managePendingInvoice() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().managePendingInvoice(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "managePendingInvoice - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void movePayment() throws Exception {
        com.aria.common.shared.SpecificChargeTransactionIdArray specificChargeTransactionIdArray = new com.aria.common.shared.SpecificChargeTransactionIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().movePayment(getClientNo(), getAuthKey()        , 1L
                , 1L
                , specificChargeTransactionIdArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "movePayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void preCalcInvoice() throws Exception {
        com.aria.common.shared.PreCalcPlanArray preCalcPlanArray = new com.aria.common.shared.PreCalcPlanArray();
        com.aria.common.shared.PreCalcSkuArray preCalcSkuArray = new com.aria.common.shared.PreCalcSkuArray();
        
        hashMapReturnValues = getBaseAriaBilling().preCalcInvoice(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , preCalcPlanArray
                , preCalcSkuArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "preCalcInvoice - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordAlternativePayment() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().recordAlternativePayment(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1d
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordAlternativePayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordExternalPayment() throws Exception {
        com.aria.common.shared.SpecificChargeTransactionIdArray specificChargeTransactionIdArray = new com.aria.common.shared.SpecificChargeTransactionIdArray();
        com.aria.common.shared.InvoiceNoArray invoiceNoArray = new com.aria.common.shared.InvoiceNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().recordExternalPayment(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1d
                , ""
                , ""
                , specificChargeTransactionIdArray
                , 1L
                , ""
                , invoiceNoArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordExternalPayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordOutGoingPayment() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().recordOutGoingPayment(getClientNo(), getAuthKey()        , 1L
                , 1d
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordOutGoingPayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordStandingOrder() throws Exception {
        com.aria.common.shared.StandingOrderArray standingOrderArray = new com.aria.common.shared.StandingOrderArray();
        
        hashMapReturnValues = getBaseAriaBilling().recordStandingOrder(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , standingOrderArray
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordStandingOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordUsage() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().recordUsage(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1d
                , ""
                , ""
                , 1d
                , 1d
                , 1d
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void reinstateTransaction() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().reinstateTransaction(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "reinstateTransaction - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void reverseAuthorizedElectronicPayment() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().reverseAuthorizedElectronicPayment(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "reverseAuthorizedElectronicPayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void settleAccountBalance() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().settleAccountBalance(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "settleAccountBalance - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void settleDisputeHold() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().settleDisputeHold(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "settleDisputeHold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void transferAccountBalance() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().transferAccountBalance(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "transferAccountBalance - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctInvoice() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctInvoice(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctInvoice - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateCcBlacklist() throws Exception {
        com.aria.common.shared.CreditCardPaymentMethodArray creditCardPaymentMethodArray = new com.aria.common.shared.CreditCardPaymentMethodArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateCcBlacklist(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
                , ""
                , ""
                , creditCardPaymentMethodArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateCcBlacklist - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateOrder() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateOrder(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateOrder - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateRefundCheckNo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateRefundCheckNo(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateRefundCheckNo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void voidTransaction() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().voidTransaction(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "voidTransaction - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void initPaypalBillAgreement() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().initPaypalBillAgreement(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "initPaypalBillAgreement - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void savePaypalBillAgreement() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().savePaypalBillAgreement(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "savePaypalBillAgreement - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void adjustBillingDates() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().adjustBillingDates(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "adjustBillingDates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void applyCouponToAcct() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().applyCouponToAcct(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "applyCouponToAcct - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignCollectionsAcctGroup() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().assignCollectionsAcctGroup(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignCollectionsAcctGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignCustomAcctRates() throws Exception {
        com.aria.common.shared.CustomAcctRatesArray customAcctRatesArray = new com.aria.common.shared.CustomAcctRatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().assignCustomAcctRates(getClientNo(), getAuthKey()        , 1L
                , customAcctRatesArray
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignCustomAcctRates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignFunctionalAcctGroup() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().assignFunctionalAcctGroup(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignFunctionalAcctGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignSuppPlan() throws Exception {
        com.aria.common.shared.NewAcctCustomRatesArray newAcctCustomRatesArray = new com.aria.common.shared.NewAcctCustomRatesArray();
        com.aria.common.shared.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.SurchargeNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().assignSuppPlan(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1d
                , 1L
                , 1d
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , newAcctCustomRatesArray
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , surchargeNoArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignSuppPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignSuppPlanMulti() throws Exception {
        com.aria.common.shared.SuppPlansToAssignArray suppPlansToAssignArray = new com.aria.common.shared.SuppPlansToAssignArray();
        com.aria.common.shared.CouponCodesArray couponCodesArray = new com.aria.common.shared.CouponCodesArray();
        com.aria.common.shared.SuppPlanSurchargesArray suppPlanSurchargesArray = new com.aria.common.shared.SuppPlanSurchargesArray();
        com.aria.common.shared.NewAcctCustomRatesArray newAcctCustomRatesArray = new com.aria.common.shared.NewAcctCustomRatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().assignSuppPlanMulti(getClientNo(), getAuthKey()        , 1L
                , suppPlansToAssignArray
                , 1L
                , ""
                , ""
                , ""
                , ""
                , couponCodesArray
                , ""
                , 1L
                , suppPlanSurchargesArray
                , newAcctCustomRatesArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignSuppPlanMulti - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void authorizeElectronicPayment() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().authorizeElectronicPayment(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "authorizeElectronicPayment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void banAcct() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().banAcct(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "banAcct - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelAcctMultiplanContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelAcctMultiplanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelAcctMultiplanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelAcctPlanContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelAcctPlanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelAcctPlanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelAcctUniversalContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelAcctUniversalContract(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelAcctUniversalContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelQueuedServicePlan() throws Exception {
        com.aria.common.shared.PlanNoToRemoveArray planNoToRemoveArray = new com.aria.common.shared.PlanNoToRemoveArray();
        
        hashMapReturnValues = getBaseAriaBilling().cancelQueuedServicePlan(getClientNo(), getAuthKey()        , 1L
                , planNoToRemoveArray
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelQueuedServicePlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelSuppPlan() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelSuppPlan(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelSuppPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelUnappliedSvceCredits() throws Exception {
        com.aria.common.shared.CreditIdsArray creditIdsArray = new com.aria.common.shared.CreditIdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().cancelUnappliedSvceCredits(getClientNo(), getAuthKey()        , 1L
                , creditIdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelUnappliedSvceCredits - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelUnconsumedCredit() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelUnconsumedCredit(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelUnconsumedCredit - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void closeAcctInstallation() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().closeAcctInstallation(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "closeAcctInstallation - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctComplete() throws Exception {
        com.aria.common.shared.SuppPlansArray suppPlansArray = new com.aria.common.shared.SuppPlansArray();
        com.aria.common.shared.SuppPlanUnitsArray suppPlanUnitsArray = new com.aria.common.shared.SuppPlanUnitsArray();
        com.aria.common.shared.FunctionalAcctGroupsArray functionalAcctGroupsArray = new com.aria.common.shared.FunctionalAcctGroupsArray();
        com.aria.common.shared.CollectionsAcctGroupsArray collectionsAcctGroupsArray = new com.aria.common.shared.CollectionsAcctGroupsArray();
        com.aria.common.shared.SuppFieldNamesArray suppFieldNamesArray = new com.aria.common.shared.SuppFieldNamesArray();
        com.aria.common.shared.SuppFieldValuesArray suppFieldValuesArray = new com.aria.common.shared.SuppFieldValuesArray();
        com.aria.common.shared.SuppPlanAltRateSchedNoArray suppPlanAltRateSchedNoArray = new com.aria.common.shared.SuppPlanAltRateSchedNoArray();
        com.aria.common.shared.CouponCodesArray couponCodesArray = new com.aria.common.shared.CouponCodesArray();
        com.aria.common.shared.NewAcctCustomRatesArray newAcctCustomRatesArray = new com.aria.common.shared.NewAcctCustomRatesArray();
        com.aria.common.shared.NewAcctPlanContractsArray newAcctPlanContractsArray = new com.aria.common.shared.NewAcctPlanContractsArray();
        com.aria.common.shared.UsageAccumulationConfigArray usageAccumulationConfigArray = new com.aria.common.shared.UsageAccumulationConfigArray();
        com.aria.common.shared.EnableUsagePoolingPlanNoArray enableUsagePoolingPlanNoArray = new com.aria.common.shared.EnableUsagePoolingPlanNoArray();
        com.aria.common.shared.ClientFuncAcctGroupIdsArray clientFuncAcctGroupIdsArray = new com.aria.common.shared.ClientFuncAcctGroupIdsArray();
        com.aria.common.shared.ClientCollAcctGroupIdsArray clientCollAcctGroupIdsArray = new com.aria.common.shared.ClientCollAcctGroupIdsArray();
        com.aria.common.shared.ClientSuppPlanIdsArray clientSuppPlanIdsArray = new com.aria.common.shared.ClientSuppPlanIdsArray();
        com.aria.common.shared.ClientSpAltRateSchedIdsArray clientSpAltRateSchedIdsArray = new com.aria.common.shared.ClientSpAltRateSchedIdsArray();
        com.aria.common.shared.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.SurchargeNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAcctComplete(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , suppPlansArray
                , suppPlanUnitsArray
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , functionalAcctGroupsArray
                , collectionsAcctGroupsArray
                , suppFieldNamesArray
                , suppFieldValuesArray
                , 1L
                , 1L
                , 1d
                , 1L
                , ""
                , ""
                , 1L
                , suppPlanAltRateSchedNoArray
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , couponCodesArray
                , newAcctCustomRatesArray
                , 1L
                , 1L
                , newAcctPlanContractsArray
                , ""
                , ""
                , ""
                , usageAccumulationConfigArray
                , enableUsagePoolingPlanNoArray
                , clientFuncAcctGroupIdsArray
                , clientCollAcctGroupIdsArray
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , clientSuppPlanIdsArray
                , ""
                , clientSpAltRateSchedIdsArray
                , ""
                , ""
                , surchargeNoArray
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctComplete - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctMultiplanContract() throws Exception {
        com.aria.common.shared.PlanNoArray planNoArray = new com.aria.common.shared.PlanNoArray();
        com.aria.common.shared.ClientPlanIdArray clientPlanIdArray = new com.aria.common.shared.ClientPlanIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAcctMultiplanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , planNoArray
                , 1L
                , ""
                , ""
                , ""
                , clientPlanIdArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctMultiplanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctPlanContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createAcctPlanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , 1d
                , 1d
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctPlanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctUniversalContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createAcctUniversalContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctUniversalContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAdvancedServiceCredit() throws Exception {
        com.aria.common.shared.EligibleServiceTypesArray eligibleServiceTypesArray = new com.aria.common.shared.EligibleServiceTypesArray();
        com.aria.common.shared.EligibleServicePlansArray eligibleServicePlansArray = new com.aria.common.shared.EligibleServicePlansArray();
        com.aria.common.shared.ClientEligibleServicePlanIdsArray clientEligibleServicePlanIdsArray = new com.aria.common.shared.ClientEligibleServicePlanIdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAdvancedServiceCredit(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1d
                , 1L
                , 1L
                , eligibleServiceTypesArray
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , eligibleServicePlansArray
                , clientEligibleServicePlanIdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAdvancedServiceCredit - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteAcctCoupon() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().deleteAcctCoupon(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteAcctCoupon - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void disableAllStandingUsage() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().disableAllStandingUsage(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "disableAllStandingUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void disableStandingUsage() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().disableStandingUsage(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "disableStandingUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void disableStandingUsageByPlan() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().disableStandingUsageByPlan(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "disableStandingUsageByPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void genStatement() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().genStatement(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "genStatement - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctBalance() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctBalance(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctBalance - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctComments() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctComments(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctComments - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctCreditDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctCreditDetails(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctCreditDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctCredits() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctCredits(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctCredits - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctDetailsAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctDetailsAll(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctDetailsAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctGroupsByAcct() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctGroupsByAcct(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctGroupsByAcct - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctGroupsByClient() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctGroupsByClient(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctGroupsByClient - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctHasOrderedSku() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctHasOrderedSku(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctHasOrderedSku - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctHierarchyDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctHierarchyDetails(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctHierarchyDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctInvoiceHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctInvoiceHistory(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctInvoiceHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctMessage() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctMessage(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctMessage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctMessageSize() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctMessageSize(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctMessageSize - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctMultiplanContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctMultiplanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctMultiplanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctNoFromUserId() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctNoFromUserId(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctNoFromUserId - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctNotificationDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctNotificationDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctNotificationDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctNotifyMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctNotifyMethod(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctNotifyMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctOpenCharges() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctOpenCharges(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctOpenCharges - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPaymentMethods() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPaymentMethods(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPaymentMethods - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanHistory(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanUnitInstanceAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanUnitInstanceAll(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanUnitInstanceAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlans() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlans(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlans - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlansAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlansAll(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlansAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctServiceOutageCredit() throws Exception {
        com.aria.common.shared.PlansToGetOutageArray plansToGetOutageArray = new com.aria.common.shared.PlansToGetOutageArray();
        com.aria.common.shared.ClientPlanIdsToGetOutageArray clientPlanIdsToGetOutageArray = new com.aria.common.shared.ClientPlanIdsToGetOutageArray();
        
        hashMapReturnValues = getBaseAriaBilling().getAcctServiceOutageCredit(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , plansToGetOutageArray
                , 1d
                , clientPlanIdsToGetOutageArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctServiceOutageCredit - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctStatementHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctStatementHistory(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctStatementHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctStatusHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctStatusHistory(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctStatusHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctSuppFields() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctSuppFields(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctSuppFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctSuppPlanHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctSuppPlanHistory(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctSuppPlanHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctTaxExemptStatus() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctTaxExemptStatus(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctTaxExemptStatus - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctTransHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctTransHistory(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctTransHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctUniversalContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctUniversalContract(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctUniversalContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctUuids() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctUuids(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctUuids - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctsWithExistingPayMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctsWithExistingPayMethod(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctsWithExistingPayMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllAcctContracts() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllAcctContracts(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllAcctContracts - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllAcctReceiptIds() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllAcctReceiptIds(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllAcctReceiptIds - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailChildPlansForAcct() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailChildPlansForAcct(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailChildPlansForAcct - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailChildPlansForAcctAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailChildPlansForAcctAll(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailChildPlansForAcctAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailChildPlansForPlan() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailChildPlansForPlan(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailChildPlansForPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailChildPlansForPlanAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailChildPlansForPlanAll(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailChildPlansForPlanAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailablePlans() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailablePlans(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailablePlans - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailablePlansAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailablePlansAll(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailablePlansAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCcUuid() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCcUuid(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCcUuid - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getChildAccts() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getChildAccts(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getChildAccts - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCouponDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCouponDetails(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCouponDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCreditReasonCodes() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCreditReasonCodes(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCreditReasonCodes - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getFamilyTransHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getFamilyTransHistory(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getFamilyTransHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPendingInvoiceNo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPendingInvoiceNo(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPendingInvoiceNo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlansByPromoCode() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlansByPromoCode(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlansByPromoCode - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlansByPromoCodeAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlansByPromoCodeAll(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlansByPromoCodeAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPmtUuid() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPmtUuid(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPmtUuid - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getQueuedServicePlans() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getQueuedServicePlans(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getQueuedServicePlans - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRecurringCreditInfo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRecurringCreditInfo(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRecurringCreditInfo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStandingUsage() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStandingUsage(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStandingUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStatementContent() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStatementContent(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStatementContent - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getStatementContentSize() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getStatementContentSize(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getStatementContentSize - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppFieldValues() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppFieldValues(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppFieldValues - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppPlansByPromoCode() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppPlansByPromoCode(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppPlansByPromoCode - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppPlansByPromoCodeAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppPlansByPromoCodeAll(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppPlansByPromoCodeAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUnappliedServiceCredits() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUnappliedServiceCredits(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUnappliedServiceCredits - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUnbilledUsageSummary() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUnbilledUsageSummary(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUnbilledUsageSummary - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageHistory() throws Exception {
        com.aria.common.shared.UsageQualifier1Array usageQualifier1Array = new com.aria.common.shared.UsageQualifier1Array();
        com.aria.common.shared.UsageQualifier2Array usageQualifier2Array = new com.aria.common.shared.UsageQualifier2Array();
        com.aria.common.shared.UsageQualifier3Array usageQualifier3Array = new com.aria.common.shared.UsageQualifier3Array();
        com.aria.common.shared.UsageQualifier4Array usageQualifier4Array = new com.aria.common.shared.UsageQualifier4Array();
        
        hashMapReturnValues = getBaseAriaBilling().getUsageHistory(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
                , usageQualifier1Array
                , usageQualifier2Array
                , usageQualifier3Array
                , usageQualifier4Array
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageSummaryByType() throws Exception {
        com.aria.common.shared.UsageQualifier1Array usageQualifier1Array = new com.aria.common.shared.UsageQualifier1Array();
        com.aria.common.shared.UsageQualifier2Array usageQualifier2Array = new com.aria.common.shared.UsageQualifier2Array();
        com.aria.common.shared.UsageQualifier3Array usageQualifier3Array = new com.aria.common.shared.UsageQualifier3Array();
        com.aria.common.shared.UsageQualifier4Array usageQualifier4Array = new com.aria.common.shared.UsageQualifier4Array();
        
        hashMapReturnValues = getBaseAriaBilling().getUsageSummaryByType(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , usageQualifier1Array
                , usageQualifier2Array
                , usageQualifier3Array
                , usageQualifier4Array
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageSummaryByType - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUserIdFromAcctNo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUserIdFromAcctNo(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUserIdFromAcctNo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUseridHasOrderedSku() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUseridHasOrderedSku(getClientNo(), getAuthKey()        , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUseridHasOrderedSku - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyAcctMultiplanContract() throws Exception {
        com.aria.common.shared.PlansInputArray plansInputArray = new com.aria.common.shared.PlansInputArray();
        com.aria.common.shared.ClientPlanIdArray clientPlanIdArray = new com.aria.common.shared.ClientPlanIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().modifyAcctMultiplanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , plansInputArray
                , ""
                , clientPlanIdArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyAcctMultiplanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyAcctPlanContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().modifyAcctPlanContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1d
                , 1L
                , 1d
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyAcctPlanContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyAcctPlanUnitInstances() throws Exception {
        com.aria.common.shared.PlanUnitsArray planUnitsArray = new com.aria.common.shared.PlanUnitsArray();
        com.aria.common.shared.NewClientPlanUnitInstArray newClientPlanUnitInstArray = new com.aria.common.shared.NewClientPlanUnitInstArray();
        
        hashMapReturnValues = getBaseAriaBilling().modifyAcctPlanUnitInstances(getClientNo(), getAuthKey()        , 1L
                , planUnitsArray
                , newClientPlanUnitInstArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyAcctPlanUnitInstances - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyAcctSuppFields() throws Exception {
        com.aria.common.shared.AcctSuppFieldsArray acctSuppFieldsArray = new com.aria.common.shared.AcctSuppFieldsArray();
        
        hashMapReturnValues = getBaseAriaBilling().modifyAcctSuppFields(getClientNo(), getAuthKey()        , 1L
                , acctSuppFieldsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyAcctSuppFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyAcctUniversalContract() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().modifyAcctUniversalContract(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyAcctUniversalContract - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifySuppPlan() throws Exception {
        com.aria.common.shared.NewAcctCustomRatesArray newAcctCustomRatesArray = new com.aria.common.shared.NewAcctCustomRatesArray();
        com.aria.common.shared.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.SurchargeNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().modifySuppPlan(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , newAcctCustomRatesArray
                , ""
                , 1L
                , ""
                , ""
                , surchargeNoArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifySuppPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordStandingUsage() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().recordStandingUsage(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1d
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordStandingUsage - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void removeAcctFromGroup() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().removeAcctFromGroup(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "removeAcctFromGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void removeCustomAcctRates() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().removeCustomAcctRates(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "removeCustomAcctRates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void removePayMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().removePayMethod(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "removePayMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void replaceSuppPlan() throws Exception {
        com.aria.common.shared.NewAcctCustomRatesArray newAcctCustomRatesArray = new com.aria.common.shared.NewAcctCustomRatesArray();
        com.aria.common.shared.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.SurchargeNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().replaceSuppPlan(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , newAcctCustomRatesArray
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , surchargeNoArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "replaceSuppPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void resetUsgMtdBal() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().resetUsgMtdBal(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "resetUsgMtdBal - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void resetUsgPtdBal() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().resetUsgPtdBal(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "resetUsgPtdBal - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void sendAcctEmail() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().sendAcctEmail(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "sendAcctEmail - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void sendAcctStatementEmail() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().sendAcctStatementEmail(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "sendAcctStatementEmail - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void sendArcThresholdEmail() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().sendArcThresholdEmail(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "sendArcThresholdEmail - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setAcctNotifyOverride() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setAcctNotifyOverride(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setAcctNotifyOverride - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setAcctNotifyTmpltGrp() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setAcctNotifyTmpltGrp(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setAcctNotifyTmpltGrp - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setAcctTaxExemptStatus() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setAcctTaxExemptStatus(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setAcctTaxExemptStatus - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setAcctUsgDailyThreshold() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setAcctUsgDailyThreshold(getClientNo(), getAuthKey()        , 1L
                , 1d
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setAcctUsgDailyThreshold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setAcctUsgMtdThreshold() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setAcctUsgMtdThreshold(getClientNo(), getAuthKey()        , 1L
                , 1d
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setAcctUsgMtdThreshold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setAcctUsgPtdThreshold() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setAcctUsgPtdThreshold(getClientNo(), getAuthKey()        , 1L
                , 1d
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setAcctUsgPtdThreshold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setClientUsgDailyThreshold() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setClientUsgDailyThreshold(getClientNo(), getAuthKey()        , 1L
                , 1d
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setClientUsgDailyThreshold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setClientUsgMtdThreshold() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setClientUsgMtdThreshold(getClientNo(), getAuthKey()        , 1L
                , 1d
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setClientUsgMtdThreshold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setClientUsgPtdThreshold() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setClientUsgPtdThreshold(getClientNo(), getAuthKey()        , 1L
                , 1d
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setClientUsgPtdThreshold - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setPayMethodBankDraft() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setPayMethodBankDraft(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setPayMethodBankDraft - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setPayMethodCc() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setPayMethodCc(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setPayMethodCc - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setPayMethodNetTerms() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setPayMethodNetTerms(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setPayMethodNetTerms - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setPaymentResponsibility() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setPaymentResponsibility(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setPaymentResponsibility - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setServicePlanImmediately() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setServicePlanImmediately(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setServicePlanImmediately - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void toggleTestAccount() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().toggleTestAccount(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "toggleTestAccount - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctBillingContact() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctBillingContact(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctBillingContact - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctComplete() throws Exception {
        com.aria.common.shared.UpdateAcctSuppFieldArray updateAcctSuppFieldArray = new com.aria.common.shared.UpdateAcctSuppFieldArray();
        com.aria.common.shared.UpdateAcctFuncGroupArray updateAcctFuncGroupArray = new com.aria.common.shared.UpdateAcctFuncGroupArray();
        com.aria.common.shared.UpdateAcctCollGroupArray updateAcctCollGroupArray = new com.aria.common.shared.UpdateAcctCollGroupArray();
        com.aria.common.shared.UsageAccumulationConfigArray usageAccumulationConfigArray = new com.aria.common.shared.UsageAccumulationConfigArray();
        com.aria.common.shared.EnableUsagePoolingPlanNoArray enableUsagePoolingPlanNoArray = new com.aria.common.shared.EnableUsagePoolingPlanNoArray();
        com.aria.common.shared.DisableUsagePoolingPlanNoArray disableUsagePoolingPlanNoArray = new com.aria.common.shared.DisableUsagePoolingPlanNoArray();
        com.aria.common.shared.UpdateSurchargeArray updateSurchargeArray = new com.aria.common.shared.UpdateSurchargeArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctComplete(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , updateAcctSuppFieldArray
                , updateAcctFuncGroupArray
                , updateAcctCollGroupArray
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , usageAccumulationConfigArray
                , enableUsagePoolingPlanNoArray
                , disableUsagePoolingPlanNoArray
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , updateSurchargeArray
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctComplete - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctContact() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctContact(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctContact - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctCredentials() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctCredentials(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctCredentials - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctNotifyMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctNotifyMethod(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctNotifyMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctPlanUnitInstance() throws Exception {
        com.aria.common.shared.PlanUnitInstServicesArray planUnitInstServicesArray = new com.aria.common.shared.PlanUnitInstServicesArray();
        com.aria.common.shared.PlanUnitInstFieldsArray planUnitInstFieldsArray = new com.aria.common.shared.PlanUnitInstFieldsArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctPlanUnitInstance(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , planUnitInstServicesArray
                , planUnitInstFieldsArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctPlanUnitInstance - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctStatus() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctStatus(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctStatus - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctSuppFields() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctSuppFields(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctSuppFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateExistingBillingInfo() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateExistingBillingInfo(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateExistingBillingInfo - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateMasterPlan() throws Exception {
        com.aria.common.shared.NewAcctCustomRatesArray newAcctCustomRatesArray = new com.aria.common.shared.NewAcctCustomRatesArray();
        com.aria.common.shared.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.SurchargeNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateMasterPlan(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , newAcctCustomRatesArray
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , surchargeNoArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateMasterPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updatePaymentMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updatePaymentMethod(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updatePaymentMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void useridExists() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().useridExists(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "useridExists - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void useridIsAvailable() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().useridIsAvailable(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "useridIsAvailable - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void validatePaymentInformation() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().validatePaymentInformation(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "validatePaymentInformation - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void writeAcctComment() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().writeAcctComment(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "writeAcctComment - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void authenticateCaller() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().authenticateCaller(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "authenticateCaller - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void keepAlive() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().keepAlive(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "keepAlive - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void killSession() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().killSession(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "killSession - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setSession() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setSession(getClientNo(), getAuthKey()        , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setSession - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setSessionAuth() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setSessionAuth(getClientNo(), getAuthKey()        , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setSessionAuth - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void validateSession() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().validateSession(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "validateSession - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void advanceVirtualDatetime() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().advanceVirtualDatetime(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "advanceVirtualDatetime - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void clearRegUssConfigParams() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().clearRegUssConfigParams(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "clearRegUssConfigParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void clearRegUssParams() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().clearRegUssParams(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "clearRegUssParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void clientHasEventClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().clientHasEventClass(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "clientHasEventClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteRegUssConfigParams() throws Exception {
        com.aria.common.shared.ParamNamesArray paramNamesArray = new com.aria.common.shared.ParamNamesArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteRegUssConfigParams(getClientNo(), getAuthKey()        , ""
                , paramNamesArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteRegUssConfigParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteRegUssParams() throws Exception {
        com.aria.common.shared.ParamNamesArray paramNamesArray = new com.aria.common.shared.ParamNamesArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteRegUssParams(getClientNo(), getAuthKey()        , ""
                , paramNamesArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteRegUssParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void genRandomString() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().genRandomString(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "genRandomString - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctSurcharges() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctSurcharges(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctSurcharges - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllClientReceiptIds() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllClientReceiptIds(getClientNo(), getAuthKey()        , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllClientReceiptIds - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAufStatus() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAufStatus(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAufStatus - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getChildForItemClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getChildForItemClass(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getChildForItemClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientCountries() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientCountries(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientCountries - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientCurrencies() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientCurrencies(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientCurrencies - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemClasses() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemClasses(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemClasses - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemImages() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemImages(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemImages - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemPrices() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemPrices(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemPrices - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemSuppFields() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemSuppFields(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemSuppFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemsAll() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemsAll(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemsAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemsBasic() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemsBasic(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemsBasic - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPlanServiceRates() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientPlanServiceRates(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPlanServiceRates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPlanServices() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientPlanServices(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPlanServices - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPlansAll() throws Exception {
        com.aria.common.shared.SuppFieldNamesArray suppFieldNamesArray = new com.aria.common.shared.SuppFieldNamesArray();
        com.aria.common.shared.SuppFieldValuesArray suppFieldValuesArray = new com.aria.common.shared.SuppFieldValuesArray();
        
        hashMapReturnValues = getBaseAriaBilling().getClientPlansAll(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , suppFieldNamesArray
                , suppFieldValuesArray
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPlansAll - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPlansBasic() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientPlansBasic(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPlansBasic - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCountryFromIp() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCountryFromIp(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCountryFromIp - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCurrentSystemVersion() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCurrentSystemVersion(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCurrentSystemVersion - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getDailyBatchStatus() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getDailyBatchStatus(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getDailyBatchStatus - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getEmailTemplates() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getEmailTemplates(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getEmailTemplates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getItemsByClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getItemsByClass(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getItemsByClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getItemsBySuppField() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getItemsBySuppField(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getItemsBySuppField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getMasterPlansBySuppField() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getMasterPlansBySuppField(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getMasterPlansBySuppField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getParentForItemClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getParentForItemClass(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getParentForItemClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRateSchedulesForPlan() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRateSchedulesForPlan(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRateSchedulesForPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRegUssConfigParams() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRegUssConfigParams(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRegUssConfigParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRegUssParams() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRegUssParams(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRegUssParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppPlansBySuppField() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppPlansBySuppField(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppPlansBySuppField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getTopLevelItemClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getTopLevelItemClass(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getTopLevelItemClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getVirtualDatetime() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getVirtualDatetime(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getVirtualDatetime - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getWebReplacementVals() throws Exception {
        com.aria.common.shared.WebValsInArray webValsInArray = new com.aria.common.shared.WebValsInArray();
        
        hashMapReturnValues = getBaseAriaBilling().getWebReplacementVals(getClientNo(), getAuthKey()        , webValsInArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getWebReplacementVals - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void replaceRegUssConfigParams() throws Exception {
        com.aria.common.shared.InRegUssConfigParamsArray inRegUssConfigParamsArray = new com.aria.common.shared.InRegUssConfigParamsArray();
        
        hashMapReturnValues = getBaseAriaBilling().replaceRegUssConfigParams(getClientNo(), getAuthKey()        , ""
                , inRegUssConfigParamsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "replaceRegUssConfigParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void replaceRegUssParams() throws Exception {
        com.aria.common.shared.InRegUssParamsArray inRegUssParamsArray = new com.aria.common.shared.InRegUssParamsArray();
        
        hashMapReturnValues = getBaseAriaBilling().replaceRegUssParams(getClientNo(), getAuthKey()        , ""
                , inRegUssParamsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "replaceRegUssParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setExternalObjectId() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setExternalObjectId(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setExternalObjectId - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setProvEngine() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setProvEngine(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setProvEngine - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setRegUssConfigParams() throws Exception {
        com.aria.common.shared.InRegUssConfigParamsArray inRegUssConfigParamsArray = new com.aria.common.shared.InRegUssConfigParamsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setRegUssConfigParams(getClientNo(), getAuthKey()        , ""
                , inRegUssConfigParamsArray
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setRegUssConfigParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setRegUssParams() throws Exception {
        com.aria.common.shared.InRegUssParamsArray inRegUssParamsArray = new com.aria.common.shared.InRegUssParamsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setRegUssParams(getClientNo(), getAuthKey()        , ""
                , inRegUssParamsArray
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setRegUssParams - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void subscribeEvent() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().subscribeEvent(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "subscribeEvent - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void subscribeEventClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().subscribeEventClass(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "subscribeEventClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void subscribeEvents() throws Exception {
        com.aria.common.shared.EventListArray eventListArray = new com.aria.common.shared.EventListArray();
        
        hashMapReturnValues = getBaseAriaBilling().subscribeEvents(getClientNo(), getAuthKey()        , eventListArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "subscribeEvents - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void unsubscribeEvent() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().unsubscribeEvent(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "unsubscribeEvent - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void unsubscribeEventClass() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().unsubscribeEventClass(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "unsubscribeEventClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void unsubscribeEvents() throws Exception {
        com.aria.common.shared.EventListArray eventListArray = new com.aria.common.shared.EventListArray();
        
        hashMapReturnValues = getBaseAriaBilling().unsubscribeEvents(getClientNo(), getAuthKey()        , eventListArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "unsubscribeEvents - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void savePaypalBillAgreementM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().savePaypalBillAgreementM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "savePaypalBillAgreementM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void acctPlanInstallCompleteM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().acctPlanInstallCompleteM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "acctPlanInstallCompleteM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void adjustAcctPlanBillingDatesM() throws Exception {
        com.aria.common.shared.BillingDatesArray billingDatesArray = new com.aria.common.shared.BillingDatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().adjustAcctPlanBillingDatesM(getClientNo(), getAuthKey()        , 1L
                , billingDatesArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "adjustAcctPlanBillingDatesM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void applyCouponToAcctM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().applyCouponToAcctM(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "applyCouponToAcctM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignAcctPlanM() throws Exception {
        com.aria.common.shared.CouponCodesArray couponCodesArray = new com.aria.common.shared.CouponCodesArray();
        com.aria.common.shared.MpiSurchargesArray mpiSurchargesArray = new com.aria.common.shared.MpiSurchargesArray();
        com.aria.common.shared.PlanInstanceFieldsArray planInstanceFieldsArray = new com.aria.common.shared.PlanInstanceFieldsArray();
        com.aria.common.shared.CustomRatesArray customRatesArray = new com.aria.common.shared.CustomRatesArray();
        com.aria.common.shared.NsoItemListArray nsoItemListArray = new com.aria.common.shared.NsoItemListArray();
        
        hashMapReturnValues = getBaseAriaBilling().assignAcctPlanM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , ""
                , 1d
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , 1d
                , couponCodesArray
                , ""
                , mpiSurchargesArray
                , 1L
                , ""
                , planInstanceFieldsArray
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , customRatesArray
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , nsoItemListArray
                , 1L
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignAcctPlanM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void assignCustomAcctPlanRatesM() throws Exception {
        com.aria.common.shared.CustomAcctRatesArray customAcctRatesArray = new com.aria.common.shared.CustomAcctRatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().assignCustomAcctPlanRatesM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , customAcctRatesArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "assignCustomAcctPlanRatesM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void authorizeElectronicPaymentM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().authorizeElectronicPaymentM(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "authorizeElectronicPaymentM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelAcctPlanM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelAcctPlanM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelAcctPlanM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelInstanceContractM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().cancelInstanceContractM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelInstanceContractM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelQueuedAcctPlanChangeM() throws Exception {
        com.aria.common.shared.PlanInstanceToRemoveArray planInstanceToRemoveArray = new com.aria.common.shared.PlanInstanceToRemoveArray();
        com.aria.common.shared.QueueIdToRemoveArray queueIdToRemoveArray = new com.aria.common.shared.QueueIdToRemoveArray();
        
        hashMapReturnValues = getBaseAriaBilling().cancelQueuedAcctPlanChangeM(getClientNo(), getAuthKey()        , 1L
                , planInstanceToRemoveArray
                , queueIdToRemoveArray
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelQueuedAcctPlanChangeM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelUnappliedServiceCreditsM() throws Exception {
        com.aria.common.shared.CreditIdsArray creditIdsArray = new com.aria.common.shared.CreditIdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().cancelUnappliedServiceCreditsM(getClientNo(), getAuthKey()        , creditIdsArray
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelUnappliedServiceCreditsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctBillingGroupM() throws Exception {
        com.aria.common.shared.MasterPlansSummaryArray masterPlansSummaryArray = new com.aria.common.shared.MasterPlansSummaryArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAcctBillingGroupM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , masterPlansSummaryArray
                , ""
                , 1L
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctBillingGroupM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctCompleteM() throws Exception {
        com.aria.common.shared.AcctArray acctArray = new com.aria.common.shared.AcctArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAcctCompleteM(getClientNo(), getAuthKey()        , ""
                , ""
                , acctArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctCompleteM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAcctDunningGroupM() throws Exception {
        com.aria.common.shared.MasterPlansSummaryArray masterPlansSummaryArray = new com.aria.common.shared.MasterPlansSummaryArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAcctDunningGroupM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , masterPlansSummaryArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAcctDunningGroupM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createAdvancedServiceCreditM() throws Exception {
        com.aria.common.shared.EligibleServiceTypesArray eligibleServiceTypesArray = new com.aria.common.shared.EligibleServiceTypesArray();
        com.aria.common.shared.EligibleServicePlansArray eligibleServicePlansArray = new com.aria.common.shared.EligibleServicePlansArray();
        com.aria.common.shared.ClientEligibleServicePlanIdsArray clientEligibleServicePlanIdsArray = new com.aria.common.shared.ClientEligibleServicePlanIdsArray();
        com.aria.common.shared.EligiblePlanInstancesArray eligiblePlanInstancesArray = new com.aria.common.shared.EligiblePlanInstancesArray();
        com.aria.common.shared.ClientEligiblePlanInstancesArray clientEligiblePlanInstancesArray = new com.aria.common.shared.ClientEligiblePlanInstancesArray();
        
        hashMapReturnValues = getBaseAriaBilling().createAdvancedServiceCreditM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1d
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1d
                , 1L
                , 1L
                , eligibleServiceTypesArray
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , eligibleServicePlansArray
                , clientEligibleServicePlanIdsArray
                , 1L
                , eligiblePlanInstancesArray
                , clientEligiblePlanInstancesArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createAdvancedServiceCreditM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createInstanceContractM() throws Exception {
        com.aria.common.shared.ContractPlanInstancesArray contractPlanInstancesArray = new com.aria.common.shared.ContractPlanInstancesArray();
        com.aria.common.shared.ContractRolloverCustomRatesArray contractRolloverCustomRatesArray = new com.aria.common.shared.ContractRolloverCustomRatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().createInstanceContractM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1L
                , ""
                , contractPlanInstancesArray
                , ""
                , 1d
                , ""
                , ""
                , ""
                , ""
                , contractRolloverCustomRatesArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createInstanceContractM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteAcctCouponM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().deleteAcctCouponM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteAcctCouponM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void genStatementM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().genStatementM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "genStatementM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctBalanceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctBalanceM(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctBalanceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctBillingGroupDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctBillingGroupDetailsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctBillingGroupDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctContactsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctContactsM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctContactsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctCouponDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctCouponDetailsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctCouponDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctCreditsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctCreditsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctCreditsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctDetailsAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctDetailsAllM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctDetailsAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctDunningGroupDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctDunningGroupDetailsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctDunningGroupDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctHierarchyDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctHierarchyDetailsM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctHierarchyDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPaymentMethodsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPaymentMethodsM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPaymentMethodsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanBalanceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanBalanceM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanBalanceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanHistoryM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanNotifyMethodM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanNotifyMethodM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanNotifyMethodM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlanUnitInstanceAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlanUnitInstanceAllM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlanUnitInstanceAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlansAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlansAllM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlansAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPlansM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPlansM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPlansM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctServiceOutageCreditM() throws Exception {
        com.aria.common.shared.PlansToGetOutageArray plansToGetOutageArray = new com.aria.common.shared.PlansToGetOutageArray();
        com.aria.common.shared.ClientPlanIdsToGetOutageArray clientPlanIdsToGetOutageArray = new com.aria.common.shared.ClientPlanIdsToGetOutageArray();
        
        hashMapReturnValues = getBaseAriaBilling().getAcctServiceOutageCreditM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , plansToGetOutageArray
                , 1d
                , clientPlanIdsToGetOutageArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctServiceOutageCreditM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctStatementHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctStatementHistoryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctStatementHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctTransHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctTransHistoryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctTransHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctUuidsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctUuidsM(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctUuidsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllAcctContractsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllAcctContractsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllAcctContractsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailPlansForAcctAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailPlansForAcctAllM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailPlansForAcctAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAvailPlansForAcctM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAvailPlansForAcctM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAvailPlansForAcctM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCashCreditsDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCashCreditsDetailsM(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCashCreditsDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCcUuidM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCcUuidM(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCcUuidM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCreditDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCreditDetailsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCreditDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getFamilyTransHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getFamilyTransHistoryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getFamilyTransHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInstanceContractM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInstanceContractM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInstanceContractM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvoiceHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoiceHistoryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoiceHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPendingInvoiceNoM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPendingInvoiceNoM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPendingInvoiceNoM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlansByPromoCodeAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlansByPromoCodeAllM(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlansByPromoCodeAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlansByPromoCodeM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlansByPromoCodeM(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlansByPromoCodeM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPmtUuidM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPmtUuidM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPmtUuidM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getQueuedAcctPlansM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getQueuedAcctPlansM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getQueuedAcctPlansM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRateSchedulesForPlanM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRateSchedulesForPlanM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRateSchedulesForPlanM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRecurringCreditInfoM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRecurringCreditInfoM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRecurringCreditInfoM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppPlansByPromoCodeAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppPlansByPromoCodeAllM(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppPlansByPromoCodeAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppPlansByPromoCodeM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppPlansByPromoCodeM(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppPlansByPromoCodeM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUnappliedServiceCreditsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUnappliedServiceCreditsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUnappliedServiceCreditsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUnbilledUsageSummaryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUnbilledUsageSummaryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUnbilledUsageSummaryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageHistoryM() throws Exception {
        com.aria.common.shared.UsageQualifier1Array usageQualifier1Array = new com.aria.common.shared.UsageQualifier1Array();
        com.aria.common.shared.UsageQualifier2Array usageQualifier2Array = new com.aria.common.shared.UsageQualifier2Array();
        com.aria.common.shared.UsageQualifier3Array usageQualifier3Array = new com.aria.common.shared.UsageQualifier3Array();
        com.aria.common.shared.UsageQualifier4Array usageQualifier4Array = new com.aria.common.shared.UsageQualifier4Array();
        
        hashMapReturnValues = getBaseAriaBilling().getUsageHistoryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , usageQualifier1Array
                , usageQualifier2Array
                , usageQualifier3Array
                , usageQualifier4Array
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageSummaryByTypeM() throws Exception {
        com.aria.common.shared.UsageQualifier1Array usageQualifier1Array = new com.aria.common.shared.UsageQualifier1Array();
        com.aria.common.shared.UsageQualifier2Array usageQualifier2Array = new com.aria.common.shared.UsageQualifier2Array();
        com.aria.common.shared.UsageQualifier3Array usageQualifier3Array = new com.aria.common.shared.UsageQualifier3Array();
        com.aria.common.shared.UsageQualifier4Array usageQualifier4Array = new com.aria.common.shared.UsageQualifier4Array();
        
        hashMapReturnValues = getBaseAriaBilling().getUsageSummaryByTypeM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , usageQualifier1Array
                , usageQualifier2Array
                , usageQualifier3Array
                , usageQualifier4Array
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageSummaryByTypeM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyAcctPlanUnitInstancesM() throws Exception {
        com.aria.common.shared.RemovePlanUnitsArray removePlanUnitsArray = new com.aria.common.shared.RemovePlanUnitsArray();
        com.aria.common.shared.NewClientPlanUnitInstArray newClientPlanUnitInstArray = new com.aria.common.shared.NewClientPlanUnitInstArray();
        
        hashMapReturnValues = getBaseAriaBilling().modifyAcctPlanUnitInstancesM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , removePlanUnitsArray
                , 1L
                , 1d
                , newClientPlanUnitInstArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyAcctPlanUnitInstancesM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void modifyInstanceContractM() throws Exception {
        com.aria.common.shared.ContractPlanInstancesUpdateArray contractPlanInstancesUpdateArray = new com.aria.common.shared.ContractPlanInstancesUpdateArray();
        com.aria.common.shared.ContractRolloverCustomRatesArray contractRolloverCustomRatesArray = new com.aria.common.shared.ContractRolloverCustomRatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().modifyInstanceContractM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , 1d
                , 1L
                , ""
                , ""
                , ""
                , contractPlanInstancesUpdateArray
                , contractRolloverCustomRatesArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "modifyInstanceContractM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void removeAcctPaymentMethodM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().removeAcctPaymentMethodM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "removeAcctPaymentMethodM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void removeAcctPlanCustomRatesM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().removeAcctPlanCustomRatesM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "removeAcctPlanCustomRatesM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void replaceAcctPlanM() throws Exception {
        com.aria.common.shared.CouponCodesArray couponCodesArray = new com.aria.common.shared.CouponCodesArray();
        com.aria.common.shared.MpSurchargesArray mpSurchargesArray = new com.aria.common.shared.MpSurchargesArray();
        com.aria.common.shared.PlanInstanceFieldUpdateArray planInstanceFieldUpdateArray = new com.aria.common.shared.PlanInstanceFieldUpdateArray();
        com.aria.common.shared.CustomRatesArray customRatesArray = new com.aria.common.shared.CustomRatesArray();
        
        hashMapReturnValues = getBaseAriaBilling().replaceAcctPlanM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1d
                , couponCodesArray
                , ""
                , mpSurchargesArray
                , 1L
                , ""
                , planInstanceFieldUpdateArray
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , customRatesArray
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "replaceAcctPlanM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setMonetaryUsgThresholdM() throws Exception {
        com.aria.common.shared.UsageUnitThresholdsArray usageUnitThresholdsArray = new com.aria.common.shared.UsageUnitThresholdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().setMonetaryUsgThresholdM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , usageUnitThresholdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setMonetaryUsgThresholdM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setPaymentResponsibilityM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setPaymentResponsibilityM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setPaymentResponsibilityM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setUsgMtdPtdBalM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setUsgMtdPtdBalM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setUsgMtdPtdBalM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctBillingGroupM() throws Exception {
        com.aria.common.shared.MasterPlansSummaryArray masterPlansSummaryArray = new com.aria.common.shared.MasterPlansSummaryArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctBillingGroupM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , masterPlansSummaryArray
                , ""
                , 1L
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctBillingGroupM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctCompleteM() throws Exception {
        com.aria.common.shared.AcctCouponsArray acctCouponsArray = new com.aria.common.shared.AcctCouponsArray();
        com.aria.common.shared.FunctionalAcctGroupsUpdateArray functionalAcctGroupsUpdateArray = new com.aria.common.shared.FunctionalAcctGroupsUpdateArray();
        com.aria.common.shared.CollectionAcctGroupsUpdateArray collectionAcctGroupsUpdateArray = new com.aria.common.shared.CollectionAcctGroupsUpdateArray();
        com.aria.common.shared.AcctSuppFieldsUpdateArray acctSuppFieldsUpdateArray = new com.aria.common.shared.AcctSuppFieldsUpdateArray();
        com.aria.common.shared.AccountSurchargesArray accountSurchargesArray = new com.aria.common.shared.AccountSurchargesArray();
        com.aria.common.shared.MpCouponsArray mpCouponsArray = new com.aria.common.shared.MpCouponsArray();
        com.aria.common.shared.MasterPlanPlanInstFieldsArray masterPlanPlanInstFieldsArray = new com.aria.common.shared.MasterPlanPlanInstFieldsArray();
        com.aria.common.shared.MpSurchargesArray mpSurchargesArray = new com.aria.common.shared.MpSurchargesArray();
        com.aria.common.shared.UpdateAcctCustomRatesArray updateAcctCustomRatesArray = new com.aria.common.shared.UpdateAcctCustomRatesArray();
        com.aria.common.shared.BillingGroupsArrayArray billingGroupsArrayArray = new com.aria.common.shared.BillingGroupsArrayArray();
        com.aria.common.shared.PaymentMethodsArrayArray paymentMethodsArrayArray = new com.aria.common.shared.PaymentMethodsArrayArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctCompleteM(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , acctCouponsArray
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , functionalAcctGroupsUpdateArray
                , collectionAcctGroupsUpdateArray
                , acctSuppFieldsUpdateArray
                , accountSurchargesArray
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , mpCouponsArray
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , masterPlanPlanInstFieldsArray
                , mpSurchargesArray
                , updateAcctCustomRatesArray
                , billingGroupsArrayArray
                , paymentMethodsArrayArray
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctCompleteM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctDunningGroupM() throws Exception {
        com.aria.common.shared.MasterPlansSummaryArray masterPlansSummaryArray = new com.aria.common.shared.MasterPlansSummaryArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctDunningGroupM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , masterPlansSummaryArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctDunningGroupM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctPlanM() throws Exception {
        com.aria.common.shared.CouponCodesArray couponCodesArray = new com.aria.common.shared.CouponCodesArray();
        com.aria.common.shared.PlanInstanceFieldUpdateArray planInstanceFieldUpdateArray = new com.aria.common.shared.PlanInstanceFieldUpdateArray();
        com.aria.common.shared.CustomRatesArray customRatesArray = new com.aria.common.shared.CustomRatesArray();
        com.aria.common.shared.MpSurchargesArray mpSurchargesArray = new com.aria.common.shared.MpSurchargesArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctPlanM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , 1d
                , couponCodesArray
                , ""
                , 1L
                , ""
                , planInstanceFieldUpdateArray
                , 1L
                , ""
                , ""
                , ""
                , customRatesArray
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , mpSurchargesArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctPlanM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctPlanMultiM() throws Exception {
        com.aria.common.shared.PlanUpdatesArray planUpdatesArray = new com.aria.common.shared.PlanUpdatesArray();
        com.aria.common.shared.AcctBillingGroupsArray acctBillingGroupsArray = new com.aria.common.shared.AcctBillingGroupsArray();
        com.aria.common.shared.AcctPaymentMethodsArray acctPaymentMethodsArray = new com.aria.common.shared.AcctPaymentMethodsArray();
        com.aria.common.shared.AcctDunningGroupsArray acctDunningGroupsArray = new com.aria.common.shared.AcctDunningGroupsArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctPlanMultiM(getClientNo(), getAuthKey()        , 1L
                , ""
                , planUpdatesArray
                , acctBillingGroupsArray
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , acctPaymentMethodsArray
                , acctDunningGroupsArray
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctPlanMultiM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctPlanStatusM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctPlanStatusM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctPlanStatusM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateAcctPlanUnitInstanceM() throws Exception {
        com.aria.common.shared.PlanUnitInstanceServicesArray planUnitInstanceServicesArray = new com.aria.common.shared.PlanUnitInstanceServicesArray();
        com.aria.common.shared.PlanUnitInstFieldsArray planUnitInstFieldsArray = new com.aria.common.shared.PlanUnitInstFieldsArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateAcctPlanUnitInstanceM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , planUnitInstanceServicesArray
                , planUnitInstFieldsArray
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateAcctPlanUnitInstanceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateContactM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateContactM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateContactM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updatePaymentMethodM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updatePaymentMethodM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updatePaymentMethodM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setSessionAuthM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setSessionAuthM(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setSessionAuthM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setSessionM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setSessionM(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setSessionM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void validateSessionM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().validateSessionM(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "validateSessionM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctNsoInclusionListM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctNsoInclusionListM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctNsoInclusionListM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctSurchargesM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctSurchargesM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctSurchargesM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemsAllM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemsAllM(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemsAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientItemsBasicM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientItemsBasicM(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientItemsBasicM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPlansAllM() throws Exception {
        com.aria.common.shared.SuppFieldNamesArray suppFieldNamesArray = new com.aria.common.shared.SuppFieldNamesArray();
        com.aria.common.shared.SuppFieldValuesArray suppFieldValuesArray = new com.aria.common.shared.SuppFieldValuesArray();
        
        hashMapReturnValues = getBaseAriaBilling().getClientPlansAllM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , suppFieldNamesArray
                , suppFieldValuesArray
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPlansAllM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPlansBasicM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientPlansBasicM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPlansBasicM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getMasterPlansBySuppFieldM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getMasterPlansBySuppFieldM(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getMasterPlansBySuppFieldM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppPlansBySuppFieldM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppPlansBySuppFieldM(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppPlansBySuppFieldM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void applyCashCreditM() throws Exception {
        com.aria.common.shared.SpecificInvoicesArray specificInvoicesArray = new com.aria.common.shared.SpecificInvoicesArray();
        com.aria.common.shared.SpecificTransactionsArray specificTransactionsArray = new com.aria.common.shared.SpecificTransactionsArray();
        
        hashMapReturnValues = getBaseAriaBilling().applyCashCreditM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1d
                , specificInvoicesArray
                , specificTransactionsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "applyCashCreditM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void applyServiceCreditM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().applyServiceCreditM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1d
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "applyServiceCreditM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void bulkRecordUsageM() throws Exception {
        com.aria.common.shared.UsageRecsArray usageRecsArray = new com.aria.common.shared.UsageRecsArray();
        
        hashMapReturnValues = getBaseAriaBilling().bulkRecordUsageM(getClientNo(), getAuthKey()        , usageRecsArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "bulkRecordUsageM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void cancelRecurringCreditsM() throws Exception {
        com.aria.common.shared.RecurringCreditNoArray recurringCreditNoArray = new com.aria.common.shared.RecurringCreditNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().cancelRecurringCreditsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , recurringCreditNoArray
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "cancelRecurringCreditsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void collectFromAccountM() throws Exception {
        com.aria.common.shared.SpecificChargeTransactionIdArray specificChargeTransactionIdArray = new com.aria.common.shared.SpecificChargeTransactionIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().collectFromAccountM(getClientNo(), getAuthKey()        , 1L
                , 1d
                , 1L
                , ""
                , ""
                , specificChargeTransactionIdArray
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "collectFromAccountM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void copyAcctPaymentMethodM() throws Exception {
        com.aria.common.shared.PaymentMethodsArray paymentMethodsArray = new com.aria.common.shared.PaymentMethodsArray();
        
        hashMapReturnValues = getBaseAriaBilling().copyAcctPaymentMethodM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , paymentMethodsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "copyAcctPaymentMethodM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createOrderM() throws Exception {
        com.aria.common.shared.OrderLineItemsArray orderLineItemsArray = new com.aria.common.shared.OrderLineItemsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createOrderM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , orderLineItemsArray
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createOrderM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createOrderWithPlanM() throws Exception {
        com.aria.common.shared.OrderLineItemsArray orderLineItemsArray = new com.aria.common.shared.OrderLineItemsArray();
        com.aria.common.shared.MultipleCouponsArray multipleCouponsArray = new com.aria.common.shared.MultipleCouponsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createOrderWithPlanM(getClientNo(), getAuthKey()        , 1L
                , ""
                , orderLineItemsArray
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , multipleCouponsArray
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createOrderWithPlanM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createWriteoffOrDisputeM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createWriteoffOrDisputeM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createWriteoffOrDisputeM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void genInvoiceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().genInvoiceM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "genInvoiceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPaymentHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPaymentHistoryM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPaymentHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctPreviewStatementM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctPreviewStatementM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1d
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctPreviewStatementM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAcctWriteoffOrDisputesM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAcctWriteoffOrDisputesM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAcctWriteoffOrDisputesM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvNoFromBalXferM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvNoFromBalXferM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvNoFromBalXferM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvoiceDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoiceDetailsM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoiceDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvoicesToWriteoffOrDisputeM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoicesToWriteoffOrDisputeM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoicesToWriteoffOrDisputeM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getOrderM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getOrderM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getOrderM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPaymentsOnInvoiceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPaymentsOnInvoiceM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPaymentsOnInvoiceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRefundablePaymentsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRefundablePaymentsM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRefundablePaymentsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getReversibleInvsByPaymentM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getReversibleInvsByPaymentM(getClientNo(), getAuthKey()        , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getReversibleInvsByPaymentM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUnappliedCreditsPaymentsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUnappliedCreditsPaymentsM(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUnappliedCreditsPaymentsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getWriteoffDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getWriteoffDetailsM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getWriteoffDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void issueRefundToAcctM() throws Exception {
        com.aria.common.shared.InvoiceTransToReverseArray invoiceTransToReverseArray = new com.aria.common.shared.InvoiceTransToReverseArray();
        
        hashMapReturnValues = getBaseAriaBilling().issueRefundToAcctM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1L
                , 1d
                , ""
                , ""
                , ""
                , ""
                , invoiceTransToReverseArray
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "issueRefundToAcctM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void managePendingInvoiceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().managePendingInvoiceM(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "managePendingInvoiceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordAlternativePaymentM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().recordAlternativePaymentM(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1d
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordAlternativePaymentM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordExternalPaymentM() throws Exception {
        com.aria.common.shared.SpecificChargeTransactionIdArray specificChargeTransactionIdArray = new com.aria.common.shared.SpecificChargeTransactionIdArray();
        com.aria.common.shared.InvoiceNoArray invoiceNoArray = new com.aria.common.shared.InvoiceNoArray();
        
        hashMapReturnValues = getBaseAriaBilling().recordExternalPaymentM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1d
                , ""
                , ""
                , 1L
                , ""
                , ""
                , specificChargeTransactionIdArray
                , invoiceNoArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordExternalPaymentM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void recordUsageM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().recordUsageM(getClientNo(), getAuthKey()        , 1d
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1d
                , 1d
                , 1d
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "recordUsageM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void settleAccountBalanceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().settleAccountBalanceM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "settleAccountBalanceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateCcBlacklistM() throws Exception {
        com.aria.common.shared.CreditCardPaymentMethodsArray creditCardPaymentMethodsArray = new com.aria.common.shared.CreditCardPaymentMethodsArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateCcBlacklistM(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , 1L
                , creditCardPaymentMethodsArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateCcBlacklistM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void voidInvoiceM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().voidInvoiceM(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "voidInvoiceM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

        /*************************** END - TEST ******************************/
}
