package com.aria.sdk.classes;

import java.util.Map;

/**
 * AriaBillingIntegration
 * Web Service class
 * @copyright Aria Systems, Inc
 * @author (Automatic generated) Aria
 */
public interface AriaBillingIntegration {
    /********************************** METHODS ***********************************************/
    /**
    * getAccountDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   account_details - Type: ArrayList&#60;AccountDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAccountDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAccountDetails(Map<String,Object> map);

    /**
    * getAccountStatusHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   account_status_history - Type: ArrayList&#60;AccountStatusHistoryReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAccountStatusHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAccountStatusHistory(Map<String,Object> map);

    /**
    * getAccountPlanHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   account_plan_history - Type: ArrayList&#60;AccountPlanHistoryReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAccountPlanHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAccountPlanHistory(Map<String,Object> map);

    /**
    * getPaymentDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   payment_details - Type: ArrayList&#60;PaymentDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPaymentDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getPaymentDetails(Map<String,Object> map);

    /**
    * getOrderDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   order_details - Type: ArrayList&#60;OrderDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getOrderDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getOrderDetails(Map<String,Object> map);

    /**
    * getInvoiceInformation
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   invoice_details - Type: ArrayList&#60;InvoiceDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getInvoiceInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getInvoiceInformation(Map<String,Object> map);

    /**
    * getTransactionInformation
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   transaction_information - Type: ArrayList&#60;TransactionInformationReturnElement&#62;<br>
    */
    abstract Map<String,Object> getTransactionInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getTransactionInformation(Map<String,Object> map);

    /**
    * getRefundInformation
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   refund_information - Type: ArrayList&#60;RefundInformationReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRefundInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getRefundInformation(Map<String,Object> map);

    /**
    * getCouponHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   coupon_history - Type: ArrayList&#60;CouponHistoryReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCouponHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getCouponHistory(Map<String,Object> map);

    /**
    * listTransactionTypes
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @param query_string - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   map_record - Type: ArrayList&#60;MapRecordReturnElement&#62;<br>
    */
    abstract Map<String,Object> listTransactionTypes(Long client_no, String auth_key, Long limit, Long offset, String query_string);

    abstract Map<String,Object> listTransactionTypes(Map<String,Object> map);

    /**
    * listPaymentMethods
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @param query_string - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   map_record - Type: ArrayList&#60;MapRecordReturnElement&#62;<br>
    */
    abstract Map<String,Object> listPaymentMethods(Long client_no, String auth_key, Long limit, Long offset, String query_string);

    abstract Map<String,Object> listPaymentMethods(Map<String,Object> map);

    /**
    * listPaymentProcessors
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @param query_string - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   map_record - Type: ArrayList&#60;MapRecordReturnElement&#62;<br>
    */
    abstract Map<String,Object> listPaymentProcessors(Long client_no, String auth_key, Long limit, Long offset, String query_string);

    abstract Map<String,Object> listPaymentProcessors(Map<String,Object> map);

    /**
    * getAllInvoiceInformation
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   all_invoice_details - Type: ArrayList&#60;AllInvoiceDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAllInvoiceInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAllInvoiceInformation(Map<String,Object> map);

    /**
    * getPlanInstanceInformationM
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   plan_instance_details - Type: ArrayList&#60;PlanInstanceDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlanInstanceInformationM(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getPlanInstanceInformationM(Map<String,Object> map);

    /**
    * getAccountDetailsM
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   account_details_m - Type: ArrayList&#60;AccountDetailsMReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAccountDetailsM(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAccountDetailsM(Map<String,Object> map);

    /**
    * getCouponHistoryM
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   coupon_history_m - Type: ArrayList&#60;CouponHistoryMReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCouponHistoryM(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getCouponHistoryM(Map<String,Object> map);

    /**
    * getInvoiceInformationM
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   invoice_details_m - Type: ArrayList&#60;InvoiceDetailsMReturnElement&#62;<br>
    */
    abstract Map<String,Object> getInvoiceInformationM(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getInvoiceInformationM(Map<String,Object> map);

    /**
    * getAllInvoiceInformationM
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   all_invoice_details_m - Type: ArrayList&#60;AllInvoiceDetailsMReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAllInvoiceInformationM(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAllInvoiceInformationM(Map<String,Object> map);

    /**
    * getAccountPlanHistoryM
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param query_string - Type: String
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   starting_record - Type: javax.xml.ws.Holder<br>
    *   total_records - Type: javax.xml.ws.Holder<br>
    *   account_plan_history_m - Type: ArrayList&#60;AccountPlanHistoryMReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAccountPlanHistoryM(Long client_no, String auth_key, String query_string, Long limit, Long offset);

    abstract Map<String,Object> getAccountPlanHistoryM(Map<String,Object> map);

    /********************************** END - METHODS ***********************************************/
}
