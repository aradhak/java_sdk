package com.aria.sdk.classes;

import java.util.Map;

/**
 * AriaBillingComplete
 * Web Service class
 * @copyright Aria Systems, Inc
 * @author (Automatic generated) Aria
 */
public interface AriaBillingComplete  {
    /********************************** METHODS ***********************************************/
    /**
    * getInvoiceDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param src_transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_line_items - Type: ArrayList&#60;InvoiceLineItemsReturnElement&#62;<br>
    *   is_pending_ind - Type: javax.xml.ws.Holder<br>
    *   custom_status_label - Type: javax.xml.ws.Holder<br>
    *   custom_status_desc - Type: javax.xml.ws.Holder<br>
    *   client_notes - Type: javax.xml.ws.Holder<br>
    *   invoice_type_cd - Type: javax.xml.ws.Holder<br>
    *   from_date - Type: javax.xml.ws.Holder<br>
    *   to_date - Type: javax.xml.ws.Holder<br>
    *   posting_status_cd - Type: javax.xml.ws.Holder<br>
    *   posting_user - Type: javax.xml.ws.Holder<br>
    *   posting_date - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getInvoiceDetails(Long client_no, String auth_key, Long acct_no, Long src_transaction_id);

    abstract Map<String,Object> getInvoiceDetails(Map<String,Object> map);

    /**
    * applyCashCredit
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param credit_amount - Type: Double
    * @param credit_reason_code - Type: Long
    * @param comments - Type: String
    * @param specific_charge_transaction_id - Type: com.aria.common.shared.SpecificChargeTransactionIdArray
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> applyCashCredit(Long client_no, String auth_key, Long account_no, Double credit_amount, Long credit_reason_code, String comments, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id, String client_receipt_id);

    abstract Map<String,Object> applyCashCredit(Map<String,Object> map);

    /**
    * applyServiceCredit
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param credit_amount - Type: Double
    * @param credit_reason_code - Type: Long
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   credit_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> applyServiceCredit(Long client_no, String auth_key, Long account_no, Double credit_amount, Long credit_reason_code, String comments);

    abstract Map<String,Object> applyServiceCredit(Map<String,Object> map);

    /**
    * bulkRecordUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param usage_records - Type: com.aria.common.shared.UsageRecordsArray
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   error_records - Type: ArrayList&#60;ErrorRecordsReturnElement&#62;<br>
    */
    abstract Map<String,Object> bulkRecordUsage(Long client_no, String auth_key, com.aria.common.shared.UsageRecordsArray usage_records, String client_receipt_id);

    abstract Map<String,Object> bulkRecordUsage(Map<String,Object> map);

    /**
    * cancelOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param order_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelOrder(Long client_no, String auth_key, Long acct_no, Long order_no);

    abstract Map<String,Object> cancelOrder(Map<String,Object> map);

    /**
    * cancelRecurringCredits
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param userid - Type: String
    * @param client_acct_id - Type: String
    * @param recurring_credit_no - Type: com.aria.common.shared.RecurringCreditNoArray
    * @param cancel_comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   error_codes - Type: ArrayList&#60;ErrorCodesReturnElement&#62;<br>
    */
    abstract Map<String,Object> cancelRecurringCredits(Long client_no, String auth_key, Long acct_no, String userid, String client_acct_id, com.aria.common.shared.RecurringCreditNoArray recurring_credit_no, String cancel_comments);

    abstract Map<String,Object> cancelRecurringCredits(Map<String,Object> map);

    /**
    * cancelStandingOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param standing_order_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelStandingOrder(Long client_no, String auth_key, Long standing_order_no);

    abstract Map<String,Object> cancelStandingOrder(Map<String,Object> map);

    /**
    * collectFromAccount
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param amount_to_collect - Type: Double
    * @param bill_seq - Type: Long
    * @param client_receipt_id - Type: String
    * @param specific_charge_transaction_id - Type: com.aria.common.shared.SpecificChargeTransactionIdArray
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param cvv - Type: String
    * @param bank_acct_type - Type: String
    * @param bill_address3 - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param payment_application_method - Type: Long
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> collectFromAccount(Long client_no, String auth_key, Long account_no, Double amount_to_collect, Long bill_seq, String client_receipt_id, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String alt_client_acct_group_id, String track_data1, String track_data2, Long payment_application_method, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd);

    abstract Map<String,Object> collectFromAccount(Map<String,Object> map);

    /**
    * compareAgainstCcBlacklist
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param cc_num - Type: String
    * @param include_details - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   cc_num_blacklisted - Type: javax.xml.ws.Holder<br>
    *   notes - Type: javax.xml.ws.Holder<br>
    *   date_added - Type: javax.xml.ws.Holder<br>
    *   date_removed - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> compareAgainstCcBlacklist(Long client_no, String auth_key, String cc_num, Long include_details);

    abstract Map<String,Object> compareAgainstCcBlacklist(Map<String,Object> map);

    /**
    * copyAcctPaymentMethod
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param source_acct_no - Type: Long
    * @param client_source_acct_id - Type: String
    * @param target_acct_no - Type: Long
    * @param client_target_acct_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   seq_nos - Type: ArrayList&#60;SeqNosReturnElement&#62;<br>
    */
    abstract Map<String,Object> copyAcctPaymentMethod(Long client_no, String auth_key, Long source_acct_no, String client_source_acct_id, Long target_acct_no, String client_target_acct_id);

    abstract Map<String,Object> copyAcctPaymentMethod(Map<String,Object> map);

    /**
    * createOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param order_line_items_list - Type: com.aria.common.shared.OrderLineItemsListArray
    * @param bill_immediately - Type: Long
    * @param bill_seq - Type: Long
    * @param client_order_id - Type: String
    * @param client_receipt_id - Type: String
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param cvv - Type: String
    * @param bank_acct_type - Type: String
    * @param bill_address3 - Type: String
    * @param do_write - Type: String
    * @param coupon_cd - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param alt_inv_template_no - Type: Long
    * @param client_alt_inv_template_id - Type: String
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param statement_message - Type: String
    * @param fulfilled_date - Type: String
    * @param order_comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   order_no - Type: javax.xml.ws.Holder<br>
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_code - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_cd - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   invoice_line_items_list - Type: ArrayList&#60;InvoiceLineItemsListReturnElement&#62;<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> createOrder(Long client_no, String auth_key, Long account_no, com.aria.common.shared.OrderLineItemsListArray order_line_items_list, Long bill_immediately, Long bill_seq, String client_order_id, String client_receipt_id, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String do_write, String coupon_cd, String alt_client_acct_group_id, String track_data1, String track_data2, Long alt_inv_template_no, String client_alt_inv_template_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String statement_message, String fulfilled_date, String order_comments);

    abstract Map<String,Object> createOrder(Map<String,Object> map);

    /**
    * createOrderWithPlans
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param order_line_items_list - Type: com.aria.common.shared.OrderLineItemsListArray
    * @param cart_supp_plans - Type: com.aria.common.shared.CartSuppPlansArray
    * @param client_order_id - Type: String
    * @param coupon_code - Type: String
    * @param comments - Type: String
    * @param do_write - Type: String
    * @param client_receipt_id - Type: String
    * @param bill_seq - Type: Long
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param cvv - Type: String
    * @param bank_acct_type - Type: String
    * @param bill_address3 - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param alt_inv_template_no - Type: Long
    * @param sync_mstr_bill_dates_override - Type: Long
    * @param multiple_coupons - Type: com.aria.common.shared.MultipleCouponsArray
    * @param client_alt_inv_template_id - Type: String
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param statement_message - Type: String
    * @param order_comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   order_no - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   invoice_line_items_list - Type: ArrayList&#60;InvoiceLineItemsListReturnElement&#62;<br>
    *   invoicing_error_code - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_msg - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_code - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> createOrderWithPlans(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.OrderLineItemsListArray order_line_items_list, com.aria.common.shared.CartSuppPlansArray cart_supp_plans, String client_order_id, String coupon_code, String comments, String do_write, String client_receipt_id, Long bill_seq, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String track_data1, String track_data2, Long alt_inv_template_no, Long sync_mstr_bill_dates_override, com.aria.common.shared.MultipleCouponsArray multiple_coupons, String client_alt_inv_template_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String statement_message, String order_comments);

    abstract Map<String,Object> createOrderWithPlans(Map<String,Object> map);

    /**
    * createWriteoffOrDispute
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param invoice_no - Type: Long
    * @param amount - Type: Double
    * @param reason_code - Type: Long
    * @param comments - Type: String
    * @param do_dispute - Type: Long
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   rec_no - Type: javax.xml.ws.Holder<br>
    *   created_by - Type: javax.xml.ws.Holder<br>
    *   amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   invoice_date - Type: javax.xml.ws.Holder<br>
    *   invoice_amt - Type: javax.xml.ws.Holder<br>
    *   dispute_creation_date - Type: javax.xml.ws.Holder<br>
    *   dispute_exp_date - Type: javax.xml.ws.Holder<br>
    *   comments - Type: javax.xml.ws.Holder<br>
    *   reason_code - Type: javax.xml.ws.Holder<br>
    *   secondary_reason_code - Type: javax.xml.ws.Holder<br>
    *   dispute_ind - Type: javax.xml.ws.Holder<br>
    *   can_unsettle - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createWriteoffOrDispute(Long client_no, String auth_key, Long acct_no, Long invoice_no, Double amount, Long reason_code, String comments, Long do_dispute, String client_receipt_id);

    abstract Map<String,Object> createWriteoffOrDispute(Map<String,Object> map);

    /**
    * discardUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param usage_record_nos - Type: com.aria.common.shared.UsageRecordNosArray
    * @param client_record_ids - Type: com.aria.common.shared.ClientRecordIdsArray
    * @param exclusion_reason_cd - Type: Long
    * @param exclusion_comment - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   failed_records - Type: ArrayList&#60;FailedRecordsReturnElement&#62;<br>
    */
    abstract Map<String,Object> discardUsage(Long client_no, String auth_key, com.aria.common.shared.UsageRecordNosArray usage_record_nos, com.aria.common.shared.ClientRecordIdsArray client_record_ids, Long exclusion_reason_cd, String exclusion_comment);

    abstract Map<String,Object> discardUsage(Map<String,Object> map);

    /**
    * genInvoice
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param force_pending - Type: String
    * @param client_receipt_id - Type: String
    * @param alt_bill_day - Type: Long
    * @param invoice_mode - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> genInvoice(Long client_no, String auth_key, Long acct_no, String force_pending, String client_receipt_id, Long alt_bill_day, Long invoice_mode);

    abstract Map<String,Object> genInvoice(Map<String,Object> map);

    /**
    * getAcctPaymentHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param start_date - Type: String
    * @param end_date - Type: String
    * @param limit_records - Type: Long
    * @param details_flag - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   payment_history - Type: ArrayList&#60;PaymentHistoryReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctPaymentHistory(Long client_no, String auth_key, Long acct_no, String start_date, String end_date, Long limit_records, Long details_flag);

    abstract Map<String,Object> getAcctPaymentHistory(Map<String,Object> map);

    /**
    * getAcctPreviewStatement
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param alt_stmt_template_no - Type: Double
    * @param auto_skip_to_next_bill_date - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   out_statement - Type: javax.xml.ws.Holder<br>
    *   mime_type - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctPreviewStatement(Long client_no, String auth_key, Long acct_no, Double alt_stmt_template_no, Long auto_skip_to_next_bill_date);

    abstract Map<String,Object> getAcctPreviewStatement(Map<String,Object> map);

    /**
    * getAcctWriteoffOrDisputes
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param dispute_or_writeoff_flag - Type: Long
    * @param details_flag - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   write_off_info - Type: ArrayList&#60;WriteOffInfoReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctWriteoffOrDisputes(Long client_no, String auth_key, Long acct_no, Long dispute_or_writeoff_flag, Long details_flag);

    abstract Map<String,Object> getAcctWriteoffOrDisputes(Map<String,Object> map);

    /**
    * getAllActionsByReceiptId
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   receipt_action - Type: ArrayList&#60;ReceiptActionReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAllActionsByReceiptId(Long client_no, String auth_key, Long acct_no, String client_receipt_id);

    abstract Map<String,Object> getAllActionsByReceiptId(Map<String,Object> map);

    /**
    * getAriaXmlStatement
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param xml_statement_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   xml_statement_content - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAriaXmlStatement(Long client_no, String auth_key, Long acct_no, Long xml_statement_no);

    abstract Map<String,Object> getAriaXmlStatement(Map<String,Object> map);

    /**
    * getCcVelocityInfo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param cc_num - Type: String
    * @param start_date - Type: String
    * @param end_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   velocity_data - Type: ArrayList&#60;VelocityDataReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCcVelocityInfo(Long client_no, String auth_key, String cc_num, String start_date, String end_date);

    abstract Map<String,Object> getCcVelocityInfo(Map<String,Object> map);

    /**
    * getExtendedTransactionInfo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   trans_create_user - Type: javax.xml.ws.Holder<br>
    *   trans_create_date - Type: javax.xml.ws.Holder<br>
    *   extended_transaction_qualifiers - Type: ArrayList&#60;ExtendedTransactionQualifiersReturnElement&#62;<br>
    */
    abstract Map<String,Object> getExtendedTransactionInfo(Long client_no, String auth_key, Long acct_no, Long transaction_id);

    abstract Map<String,Object> getExtendedTransactionInfo(Map<String,Object> map);

    /**
    * getInvNoFromBalXfer
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   acct_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getInvNoFromBalXfer(Long client_no, String auth_key, Long transaction_id);

    abstract Map<String,Object> getInvNoFromBalXfer(Map<String,Object> map);

    /**
    * getInvoicesToWriteoffOrDispute
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_details - Type: ArrayList&#60;InvoiceDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getInvoicesToWriteoffOrDispute(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getInvoicesToWriteoffOrDispute(Map<String,Object> map);

    /**
    * getOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param my_order_no - Type: Long
    * @param my_client_order_id - Type: String
    * @param limit_records - Type: Long
    * @param details_flag - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   order - Type: ArrayList&#60;OrderReturnElement&#62;<br>
    */
    abstract Map<String,Object> getOrder(Long client_no, String auth_key, Long acct_no, Long my_order_no, String my_client_order_id, Long limit_records, Long details_flag);

    abstract Map<String,Object> getOrder(Map<String,Object> map);

    /**
    * getOrderItems
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param order_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   order_items_list - Type: ArrayList&#60;OrderItemsListReturnElement&#62;<br>
    */
    abstract Map<String,Object> getOrderItems(Long client_no, String auth_key, Long order_no);

    abstract Map<String,Object> getOrderItems(Map<String,Object> map);

    /**
    * getPaymentApplicationDtls
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   payment_application_details - Type: ArrayList&#60;PaymentApplicationDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPaymentApplicationDtls(Long client_no, String auth_key, Long acct_no, Long transaction_id);

    abstract Map<String,Object> getPaymentApplicationDtls(Map<String,Object> map);

    /**
    * getPaymentApplications
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param src_transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   payment_applications - Type: ArrayList&#60;PaymentApplicationsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPaymentApplications(Long client_no, String auth_key, Long acct_no, Long src_transaction_id);

    abstract Map<String,Object> getPaymentApplications(Map<String,Object> map);

    /**
    * getPaymentsOnInvoice
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param src_transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_payments - Type: ArrayList&#60;InvoicePaymentsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPaymentsOnInvoice(Long client_no, String auth_key, Long acct_no, Long src_transaction_id);

    abstract Map<String,Object> getPaymentsOnInvoice(Map<String,Object> map);

    /**
    * getRefundDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param include_voided - Type: String
    * @param aria_event_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   refund_details - Type: ArrayList&#60;RefundDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRefundDetails(Long client_no, String auth_key, Long acct_no, String include_voided, Long aria_event_no);

    abstract Map<String,Object> getRefundDetails(Map<String,Object> map);

    /**
    * getRefundablePayments
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   refundable_payments - Type: ArrayList&#60;RefundablePaymentsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRefundablePayments(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getRefundablePayments(Map<String,Object> map);

    /**
    * getReversibleAuthorizations
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   reversible_authorizations - Type: ArrayList&#60;ReversibleAuthorizationsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getReversibleAuthorizations(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getReversibleAuthorizations(Map<String,Object> map);

    /**
    * getReversibleInvsByPayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param payment_transaction_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   reversible_invoices - Type: ArrayList&#60;ReversibleInvoicesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getReversibleInvsByPayment(Long client_no, String auth_key, Long acct_no, Long payment_transaction_id);

    abstract Map<String,Object> getReversibleInvsByPayment(Map<String,Object> map);

    /**
    * getStandingOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param my_standing_order - Type: Long
    * @param my_client_order_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   so - Type: ArrayList&#60;SoReturnElement&#62;<br>
    */
    abstract Map<String,Object> getStandingOrder(Long client_no, String auth_key, Long acct_no, Long my_standing_order, String my_client_order_id);

    abstract Map<String,Object> getStandingOrder(Map<String,Object> map);

    /**
    * getStandingOrderHist
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param standing_order_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   order - Type: ArrayList&#60;OrderReturnElement&#62;<br>
    */
    abstract Map<String,Object> getStandingOrderHist(Long client_no, String auth_key, Long standing_order_no);

    abstract Map<String,Object> getStandingOrderHist(Map<String,Object> map);

    /**
    * getStandingOrderItems
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param standing_order_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   so_items - Type: ArrayList&#60;SoItemsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getStandingOrderItems(Long client_no, String auth_key, Long standing_order_no);

    abstract Map<String,Object> getStandingOrderItems(Map<String,Object> map);

    /**
    * getStatementForInvSize
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param invoice_no - Type: Long
    * @param do_encoding - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   num_chars - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getStatementForInvSize(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long invoice_no, String do_encoding);

    abstract Map<String,Object> getStatementForInvSize(Map<String,Object> map);

    /**
    * getStatementForInvoice
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param invoice_no - Type: Long
    * @param do_encoding - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   out_statement - Type: javax.xml.ws.Holder<br>
    *   mime_type - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getStatementForInvoice(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long invoice_no, String do_encoding);

    abstract Map<String,Object> getStatementForInvoice(Map<String,Object> map);

    /**
    * getWriteoffDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param aria_event_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   writeoff_details - Type: ArrayList&#60;WriteoffDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getWriteoffDetails(Long client_no, String auth_key, Long acct_no, Long aria_event_no);

    abstract Map<String,Object> getWriteoffDetails(Map<String,Object> map);

    /**
    * issueRefundToAcct
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param payment_transaction_id - Type: Long
    * @param reason_code - Type: Long
    * @param total_refund_amount - Type: Double
    * @param refund_check_number - Type: String
    * @param comments - Type: String
    * @param do_write - Type: String
    * @param auto_calc_refund - Type: String
    * @param invoices_to_reverse - Type: com.aria.common.shared.InvoicesToReverseArray
    * @param client_receipt_id - Type: String
    * @param is_unlinked_refund - Type: String
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param cvv - Type: String
    * @param bill_first_name - Type: String
    * @param bill_last_name - Type: String
    * @param bill_company_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_address3 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_country - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_phone - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_email - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   applied_total_refund_amount - Type: javax.xml.ws.Holder<br>
    *   applied_total_reversal_amount - Type: javax.xml.ws.Holder<br>
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   reversed_invoice_lines - Type: ArrayList&#60;ReversedInvoiceLinesReturnElement&#62;<br>
    */
    abstract Map<String,Object> issueRefundToAcct(Long client_no, String auth_key, Long acct_no, Long payment_transaction_id, Long reason_code, Double total_refund_amount, String refund_check_number, String comments, String do_write, String auto_calc_refund, com.aria.common.shared.InvoicesToReverseArray invoices_to_reverse, String client_receipt_id, String is_unlinked_refund, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String cvv, String bill_first_name, String bill_last_name, String bill_company_name, String bill_address1, String bill_address2, String bill_address3, String bill_city, String bill_locality, String bill_country, String bill_state_prov, String bill_zip, String bill_phone, String bill_cell_phone, String bill_work_phone, String bill_email);

    abstract Map<String,Object> issueRefundToAcct(Map<String,Object> map);

    /**
    * managePendingInvoice
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param invoice_no - Type: Long
    * @param acct_no - Type: Long
    * @param action_directive - Type: Long
    * @param bill_seq - Type: Long
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param cvv - Type: String
    * @param alt_collect_on_approve - Type: String
    * @param alt_send_statement_on_approve - Type: String
    * @param cancel_orders_on_discard - Type: String
    * @param bank_acct_type - Type: String
    * @param bill_address3 - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param client_receipt_id - Type: String
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param custom_status_label - Type: String
    * @param client_notes - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   new_invoice_no - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_code - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> managePendingInvoice(Long client_no, String auth_key, Long invoice_no, Long acct_no, Long action_directive, Long bill_seq, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String alt_collect_on_approve, String alt_send_statement_on_approve, String cancel_orders_on_discard, String bank_acct_type, String bill_address3, String track_data1, String track_data2, String client_receipt_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String custom_status_label, String client_notes);

    abstract Map<String,Object> managePendingInvoice(Map<String,Object> map);

    /**
    * movePayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param payment_id - Type: Long
    * @param specific_charge_transaction_id - Type: com.aria.common.shared.SpecificChargeTransactionIdArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> movePayment(Long client_no, String auth_key, Long account_no, Long payment_id, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id);

    abstract Map<String,Object> movePayment(Map<String,Object> map);

    /**
    * preCalcInvoice
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param log_id - Type: String
    * @param first_name - Type: String
    * @param mi - Type: String
    * @param last_name - Type: String
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param state_prov_code - Type: String
    * @param zip_code - Type: String
    * @param country_code - Type: String
    * @param currency_code - Type: String
    * @param pre_calc_plan - Type: com.aria.common.shared.PreCalcPlanArray
    * @param pre_calc_sku - Type: com.aria.common.shared.PreCalcSkuArray
    * @param tax_exempt_cd - Type: Long
    * @param address3 - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   inv_calc_out - Type: ArrayList&#60;InvCalcOutReturnElement&#62;<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> preCalcInvoice(Long client_no, String auth_key, String log_id, String first_name, String mi, String last_name, String address1, String address2, String city, String state_prov_code, String zip_code, String country_code, String currency_code, com.aria.common.shared.PreCalcPlanArray pre_calc_plan, com.aria.common.shared.PreCalcSkuArray pre_calc_sku, Long tax_exempt_cd, String address3);

    abstract Map<String,Object> preCalcInvoice(Map<String,Object> map);

    /**
    * recordAlternativePayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param reference_code - Type: String
    * @param payment_amount - Type: Double
    * @param processor_id - Type: Long
    * @param pay_method - Type: Long
    * @param statement_no - Type: Long
    * @param comments - Type: String
    * @param client_receipt_id - Type: String
    * @param allow_recurring - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   auth_no - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> recordAlternativePayment(Long client_no, String auth_key, Long acct_no, String client_acct_id, String reference_code, Double payment_amount, Long processor_id, Long pay_method, Long statement_no, String comments, String client_receipt_id, String allow_recurring);

    abstract Map<String,Object> recordAlternativePayment(Map<String,Object> map);

    /**
    * recordExternalPayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param reference_code - Type: String
    * @param payment_amount - Type: Double
    * @param comments - Type: String
    * @param client_receipt_id - Type: String
    * @param specific_charge_transaction_id - Type: com.aria.common.shared.SpecificChargeTransactionIdArray
    * @param external_destination_id - Type: Long
    * @param external_id - Type: String
    * @param invoice_no - Type: com.aria.common.shared.InvoiceNoArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> recordExternalPayment(Long client_no, String auth_key, Long account_no, String reference_code, Double payment_amount, String comments, String client_receipt_id, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id, Long external_destination_id, String external_id, com.aria.common.shared.InvoiceNoArray invoice_no);

    abstract Map<String,Object> recordExternalPayment(Map<String,Object> map);

    /**
    * recordOutGoingPayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param payment_amount - Type: Double
    * @param reference_code - Type: String
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> recordOutGoingPayment(Long client_no, String auth_key, Long account_no, Double payment_amount, String reference_code, String comments);

    abstract Map<String,Object> recordOutGoingPayment(Map<String,Object> map);

    /**
    * recordStandingOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param billing_interval_units - Type: Long
    * @param times_to_bill - Type: Long
    * @param billing_interval_type - Type: String
    * @param first_bill_date - Type: String
    * @param standing_order - Type: com.aria.common.shared.StandingOrderArray
    * @param client_order_id - Type: String
    * @param client_receipt_id - Type: String
    * @param statement_message - Type: String
    * @param order_comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   standing_order_no - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> recordStandingOrder(Long client_no, String auth_key, Long account_no, Long billing_interval_units, Long times_to_bill, String billing_interval_type, String first_bill_date, com.aria.common.shared.StandingOrderArray standing_order, String client_order_id, String client_receipt_id, String statement_message, String order_comments);

    abstract Map<String,Object> recordStandingOrder(Map<String,Object> map);

    /**
    * recordUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param userid - Type: String
    * @param usage_type - Type: Long
    * @param usage_units - Type: Double
    * @param usage_type_code - Type: String
    * @param usage_date - Type: String
    * @param billable_units - Type: Double
    * @param amt - Type: Double
    * @param rate - Type: Double
    * @param telco_from - Type: String
    * @param telco_to - Type: String
    * @param comments - Type: String
    * @param exclude_from_billing - Type: String
    * @param exclusion_comments - Type: String
    * @param qualifier_1 - Type: String
    * @param qualifier_2 - Type: String
    * @param qualifier_3 - Type: String
    * @param qualifier_4 - Type: String
    * @param parent_usage_rec_no - Type: Long
    * @param client_record_id - Type: String
    * @param caller_id - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_rec_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> recordUsage(Long client_no, String auth_key, Long acct_no, String userid, Long usage_type, Double usage_units, String usage_type_code, String usage_date, Double billable_units, Double amt, Double rate, String telco_from, String telco_to, String comments, String exclude_from_billing, String exclusion_comments, String qualifier_1, String qualifier_2, String qualifier_3, String qualifier_4, Long parent_usage_rec_no, String client_record_id, String caller_id, String client_receipt_id);

    abstract Map<String,Object> recordUsage(Map<String,Object> map);

    /**
    * reinstateTransaction
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param transaction_id - Type: Long
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   new_transaction_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> reinstateTransaction(Long client_no, String auth_key, Long account_no, Long transaction_id, String comments);

    abstract Map<String,Object> reinstateTransaction(Map<String,Object> map);

    /**
    * reverseAuthorizedElectronicPayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param auth_no - Type: Long
    * @param reason_code - Type: Long
    * @param comments - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   applied_total_reversal_amount - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_auth_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> reverseAuthorizedElectronicPayment(Long client_no, String auth_key, Long acct_no, Long auth_no, Long reason_code, String comments, String client_receipt_id);

    abstract Map<String,Object> reverseAuthorizedElectronicPayment(Map<String,Object> map);

    /**
    * settleAccountBalance
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param cvv - Type: String
    * @param bank_acct_type - Type: String
    * @param bill_address3 - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param force_balance_scope - Type: String
    * @param client_receipt_id - Type: String
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> settleAccountBalance(Long client_no, String auth_key, Long account_no, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String alt_client_acct_group_id, String track_data1, String track_data2, String force_balance_scope, String client_receipt_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd);

    abstract Map<String,Object> settleAccountBalance(Map<String,Object> map);

    /**
    * settleDisputeHold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param dispute_no - Type: Long
    * @param settlement_action - Type: Long
    * @param comments - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   rec_no - Type: javax.xml.ws.Holder<br>
    *   created_by - Type: javax.xml.ws.Holder<br>
    *   amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   invoice_date - Type: javax.xml.ws.Holder<br>
    *   invoice_amt - Type: javax.xml.ws.Holder<br>
    *   dispute_creation_date - Type: javax.xml.ws.Holder<br>
    *   dispute_exp_date - Type: javax.xml.ws.Holder<br>
    *   comments - Type: javax.xml.ws.Holder<br>
    *   reason_code - Type: javax.xml.ws.Holder<br>
    *   secondary_reason_code - Type: javax.xml.ws.Holder<br>
    *   dispute_ind - Type: javax.xml.ws.Holder<br>
    *   can_unsettle - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> settleDisputeHold(Long client_no, String auth_key, Long acct_no, Long dispute_no, Long settlement_action, String comments, String client_receipt_id);

    abstract Map<String,Object> settleDisputeHold(Map<String,Object> map);

    /**
    * transferAccountBalance
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param source_account_no - Type: Long
    * @param target_account_no - Type: Long
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   balance_transferred - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> transferAccountBalance(Long client_no, String auth_key, Long source_account_no, Long target_account_no, String client_receipt_id);

    abstract Map<String,Object> transferAccountBalance(Map<String,Object> map);

    /**
    * updateAcctInvoice
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param src_transaction_id - Type: Long
    * @param custom_status_label - Type: String
    * @param client_notes - Type: String
    * @param posting_status_cd - Type: Long
    * @param posting_user - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctInvoice(Long client_no, String auth_key, Long account_no, Long src_transaction_id, String custom_status_label, String client_notes, Long posting_status_cd, String posting_user);

    abstract Map<String,Object> updateAcctInvoice(Map<String,Object> map);

    /**
    * updateCcBlacklist
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param cc_num - Type: String
    * @param assignment_directive - Type: Long
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param notes - Type: String
    * @param credit_card_payment_method - Type: com.aria.common.shared.CreditCardPaymentMethodArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateCcBlacklist(Long client_no, String auth_key, String cc_num, Long assignment_directive, Long acct_no, String client_acct_id, String notes, com.aria.common.shared.CreditCardPaymentMethodArray credit_card_payment_method);

    abstract Map<String,Object> updateCcBlacklist(Map<String,Object> map);

    /**
    * updateOrder
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param order_no - Type: Long
    * @param bill_immediately - Type: Long
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param cvv - Type: String
    * @param bill_address3 - Type: String
    * @param do_write - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param alt_inv_template_no - Type: Long
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param fulfilled_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_code - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_cd - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   cart_invoice_line_items - Type: ArrayList&#60;CartInvoiceLineItemsReturnElement&#62;<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> updateOrder(Long client_no, String auth_key, Long account_no, Long order_no, Long bill_immediately, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bill_address3, String do_write, String alt_client_acct_group_id, String track_data1, String track_data2, Long alt_inv_template_no, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String fulfilled_date);

    abstract Map<String,Object> updateOrder(Map<String,Object> map);

    /**
    * updateRefundCheckNo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param acct_user_id - Type: String
    * @param client_acct_id - Type: String
    * @param transaction_id - Type: Long
    * @param refund_check_number - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateRefundCheckNo(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id, Long transaction_id, Long refund_check_number);

    abstract Map<String,Object> updateRefundCheckNo(Map<String,Object> map);

    /**
    * voidTransaction
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param transaction_id - Type: Long
    * @param comments - Type: String
    * @param reason_code - Type: Long
    * @param client_receipt_id - Type: String
    * @param discard_invoice_usage - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   new_transaction_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> voidTransaction(Long client_no, String auth_key, Long account_no, Long transaction_id, String comments, Long reason_code, String client_receipt_id, String discard_invoice_usage);

    abstract Map<String,Object> voidTransaction(Map<String,Object> map);

    /**
    * getPaypalAvsStatus
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: Long
    * @param email - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   bill_agreement_id - Type: javax.xml.ws.Holder<br>
    *   email - Type: javax.xml.ws.Holder<br>
    *   paypal_confirmationcode - Type: javax.xml.ws.Holder<br>
    *   paypal_streetmatch - Type: javax.xml.ws.Holder<br>
    *   paypal_zipmatch - Type: javax.xml.ws.Holder<br>
    *   paypal_countrycode - Type: javax.xml.ws.Holder<br>
    *   paypal_token - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getPaypalAvsStatus(Long client_no, String auth_key, Long acct_no, Long client_acct_id, String email);

    abstract Map<String,Object> getPaypalAvsStatus(Map<String,Object> map);

    /**
    * initPaypalBillAgreement
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   return_url - Type: javax.xml.ws.Holder<br>
    *   token - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> initPaypalBillAgreement(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> initPaypalBillAgreement(Map<String,Object> map);

    /**
    * savePaypalBillAgreement
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param token - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   bill_agreement_id - Type: javax.xml.ws.Holder<br>
    *   paypal_email - Type: javax.xml.ws.Holder<br>
    *   paypal_payerid - Type: javax.xml.ws.Holder<br>
    *   paypal_payerstatus - Type: javax.xml.ws.Holder<br>
    *   paypal_countrycode - Type: javax.xml.ws.Holder<br>
    *   paypal_shiptoname - Type: javax.xml.ws.Holder<br>
    *   paypal_shiptostreet - Type: javax.xml.ws.Holder<br>
    *   paypal_shipttostreet2 - Type: javax.xml.ws.Holder<br>
    *   paypal_shiptocity - Type: javax.xml.ws.Holder<br>
    *   paypal_shiptostate - Type: javax.xml.ws.Holder<br>
    *   paypal_shiptozip - Type: javax.xml.ws.Holder<br>
    *   paypal_shiptocountrycode - Type: javax.xml.ws.Holder<br>
    *   paypal_addressstatus - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> savePaypalBillAgreement(Long client_no, String auth_key, Long acct_no, String token);

    abstract Map<String,Object> savePaypalBillAgreement(Map<String,Object> map);

    /**
    * adjustBillingDates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param action_directive - Type: Long
    * @param adjustment_days - Type: Long
    * @param adjustment_date - Type: String
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> adjustBillingDates(Long client_no, String auth_key, Long acct_no, Long action_directive, Long adjustment_days, String adjustment_date, String comments);

    abstract Map<String,Object> adjustBillingDates(Map<String,Object> map);

    /**
    * applyCouponToAcct
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param coupon_code - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   user_success_msg - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> applyCouponToAcct(Long client_no, String auth_key, Long acct_no, String coupon_code);

    abstract Map<String,Object> applyCouponToAcct(Map<String,Object> map);

    /**
    * assignCollectionsAcctGroup
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param group_no - Type: Long
    * @param client_acct_group_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> assignCollectionsAcctGroup(Long client_no, String auth_key, Long acct_no, Long group_no, String client_acct_group_id);

    abstract Map<String,Object> assignCollectionsAcctGroup(Map<String,Object> map);

    /**
    * assignCustomAcctRates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param custom_acct_rates - Type: com.aria.common.shared.CustomAcctRatesArray
    * @param plan_no - Type: Long
    * @param service_no - Type: Long
    * @param client_plan_id - Type: String
    * @param client_service_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> assignCustomAcctRates(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.CustomAcctRatesArray custom_acct_rates, Long plan_no, Long service_no, String client_plan_id, String client_service_id);

    abstract Map<String,Object> assignCustomAcctRates(Map<String,Object> map);

    /**
    * assignFunctionalAcctGroup
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param group_no - Type: Long
    * @param client_acct_group_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> assignFunctionalAcctGroup(Long client_no, String auth_key, Long acct_no, Long group_no, String client_acct_group_id);

    abstract Map<String,Object> assignFunctionalAcctGroup(Map<String,Object> map);

    /**
    * assignSuppPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param supp_plan_no - Type: Long
    * @param client_supp_plan_id - Type: String
    * @param alt_rate_schedule_no - Type: Long
    * @param num_plan_units - Type: Long
    * @param coupon_code - Type: String
    * @param assignment_directive - Type: Long
    * @param comments - Type: String
    * @param do_write - Type: String
    * @param client_receipt_id - Type: String
    * @param contract_type_no - Type: Long
    * @param contract_alt_recur_fee - Type: Double
    * @param contract_length_months - Type: Long
    * @param contract_cancel_fee - Type: Double
    * @param contract_comments - Type: String
    * @param contract_start_date - Type: String
    * @param offset_months - Type: Long
    * @param auto_offset_months_option - Type: Long
    * @param alt_proration_start_date - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param new_acct_custom_rates - Type: com.aria.common.shared.NewAcctCustomRatesArray
    * @param effective_date - Type: String
    * @param offset_interval - Type: Long
    * @param contract_end_date - Type: String
    * @param sync_mstr_bill_dates_override - Type: Long
    * @param client_alt_rate_schedule_id - Type: String
    * @param surcharge_no - Type: com.aria.common.shared.SurchargeNoArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   supp_plan_line_items - Type: ArrayList&#60;SuppPlanLineItemsReturnElement&#62;<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   expectd_activation_fee - Type: javax.xml.ws.Holder<br>
    *   expectd_mthly_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annu_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> assignSuppPlan(Long client_no, String auth_key, Long acct_no, Long supp_plan_no, String client_supp_plan_id, Long alt_rate_schedule_no, Long num_plan_units, String coupon_code, Long assignment_directive, String comments, String do_write, String client_receipt_id, Long contract_type_no, Double contract_alt_recur_fee, Long contract_length_months, Double contract_cancel_fee, String contract_comments, String contract_start_date, Long offset_months, Long auto_offset_months_option, String alt_proration_start_date, String alt_client_acct_group_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String contract_end_date, Long sync_mstr_bill_dates_override, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no);

    abstract Map<String,Object> assignSuppPlan(Map<String,Object> map);

    /**
    * assignSuppPlanMulti
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param supp_plans_to_assign - Type: com.aria.common.shared.SuppPlansToAssignArray
    * @param assignment_directive - Type: Long
    * @param do_write - Type: String
    * @param comments - Type: String
    * @param client_receipt_id - Type: String
    * @param alt_proration_start_date - Type: String
    * @param coupon_codes - Type: com.aria.common.shared.CouponCodesArray
    * @param effective_date - Type: String
    * @param sync_mstr_bill_dates_override - Type: Long
    * @param supp_plan_surcharges - Type: com.aria.common.shared.SuppPlanSurchargesArray
    * @param new_acct_custom_rates - Type: com.aria.common.shared.NewAcctCustomRatesArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   multi_sp_invoice_line_items - Type: ArrayList&#60;MultiSpInvoiceLineItemsReturnElement&#62;<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_code - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   expectd_activation_fee - Type: javax.xml.ws.Holder<br>
    *   expectd_mthly_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annu_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> assignSuppPlanMulti(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.SuppPlansToAssignArray supp_plans_to_assign, Long assignment_directive, String do_write, String comments, String client_receipt_id, String alt_proration_start_date, com.aria.common.shared.CouponCodesArray coupon_codes, String effective_date, Long sync_mstr_bill_dates_override, com.aria.common.shared.SuppPlanSurchargesArray supp_plan_surcharges, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates);

    abstract Map<String,Object> assignSuppPlanMulti(Map<String,Object> map);

    /**
    * authorizeElectronicPayment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_number - Type: Long
    * @param amount - Type: Double
    * @param payment_source - Type: Long
    * @param CVV - Type: String
    * @param bill_seq - Type: Long
    * @param inTrackingNumber - Type: String
    * @param inAuthValue - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param bank_acct_type - Type: String
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_address3 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param record_cc_on_auth_failure - Type: String
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> authorizeElectronicPayment(Long client_no, String auth_key, Long account_number, Double amount, Long payment_source, String CVV, Long bill_seq, String inTrackingNumber, String inAuthValue, String alt_client_acct_group_id, String track_data1, String track_data2, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bank_acct_type, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_address3, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String record_cc_on_auth_failure, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd);

    abstract Map<String,Object> authorizeElectronicPayment(Map<String,Object> map);

    /**
    * banAcct
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param userid - Type: String
    * @param days_to_restore - Type: Long
    * @param date_to_restore - Type: String
    * @param reason_cd - Type: Long
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> banAcct(Long client_no, String auth_key, Long account_no, String userid, Long days_to_restore, String date_to_restore, Long reason_cd, String comments);

    abstract Map<String,Object> banAcct(Map<String,Object> map);

    /**
    * cancelAcctMultiplanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param contract_no - Type: Long
    * @param update_comments - Type: String
    * @param close_status - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, String update_comments, Long close_status);

    abstract Map<String,Object> cancelAcctMultiplanContract(Map<String,Object> map);

    /**
    * cancelAcctPlanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param contract_no - Type: Long
    * @param update_comments - Type: String
    * @param close_status - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, String update_comments, Long close_status);

    abstract Map<String,Object> cancelAcctPlanContract(Map<String,Object> map);

    /**
    * cancelAcctUniversalContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param update_comments - Type: String
    * @param close_status - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelAcctUniversalContract(Long client_no, String auth_key, Long acct_no, String update_comments, Long close_status);

    abstract Map<String,Object> cancelAcctUniversalContract(Map<String,Object> map);

    /**
    * cancelQueuedServicePlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_number - Type: Long
    * @param plan_no_to_remove - Type: com.aria.common.shared.PlanNoToRemoveArray
    * @param remove_all_queued_plan_no - Type: String
    * @param remove_terminate_pending - Type: String
    * @param reactivate_terminate_pending - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelQueuedServicePlan(Long client_no, String auth_key, Long account_number, com.aria.common.shared.PlanNoToRemoveArray plan_no_to_remove, String remove_all_queued_plan_no, String remove_terminate_pending, String reactivate_terminate_pending);

    abstract Map<String,Object> cancelQueuedServicePlan(Map<String,Object> map);

    /**
    * cancelSuppPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param supp_plan_no - Type: Long
    * @param assignment_directive - Type: Long
    * @param comments - Type: String
    * @param do_write - Type: String
    * @param client_receipt_id - Type: String
    * @param alt_proration_start_date - Type: String
    * @param effective_date - Type: String
    * @param offset_interval - Type: Long
    * @param invoice_unbilled_usage - Type: String
    * @param client_supp_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   supp_plan_line_items - Type: ArrayList&#60;SuppPlanLineItemsReturnElement&#62;<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   proration_credit_result_amount - Type: javax.xml.ws.Holder<br>
    *   proration_credit_amount - Type: javax.xml.ws.Holder<br>
    *   proration_tax_amount - Type: javax.xml.ws.Holder<br>
    *   client_service_id - Type: javax.xml.ws.Holder<br>
    *   client_plan_id - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> cancelSuppPlan(Long client_no, String auth_key, Long acct_no, Long supp_plan_no, Long assignment_directive, String comments, String do_write, String client_receipt_id, String alt_proration_start_date, String effective_date, Long offset_interval, String invoice_unbilled_usage, String client_supp_plan_id);

    abstract Map<String,Object> cancelSuppPlan(Map<String,Object> map);

    /**
    * cancelUnappliedSvceCredits
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param credit_ids - Type: com.aria.common.shared.CreditIdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelUnappliedSvceCredits(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.CreditIdsArray credit_ids);

    abstract Map<String,Object> cancelUnappliedSvceCredits(Map<String,Object> map);

    /**
    * cancelUnconsumedCredit
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param coupon_cd - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> cancelUnconsumedCredit(Long client_no, String auth_key, Long acct_no, String coupon_cd);

    abstract Map<String,Object> cancelUnconsumedCredit(Map<String,Object> map);

    /**
    * closeAcctInstallation
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param install_complete_ind - Type: String
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> closeAcctInstallation(Long client_no, String auth_key, Long acct_no, String install_complete_ind, String comments);

    abstract Map<String,Object> closeAcctInstallation(Map<String,Object> map);

    /**
    * createAcctComplete
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param master_plan_no - Type: Long
    * @param client_master_plan_id - Type: String
    * @param alt_start_date - Type: String
    * @param client_acct_id - Type: String
    * @param userid - Type: String
    * @param status_cd - Type: Long
    * @param master_plan_units - Type: Long
    * @param supp_plans - Type: com.aria.common.shared.SuppPlansArray
    * @param supp_plan_units - Type: com.aria.common.shared.SuppPlanUnitsArray
    * @param notify_method - Type: Long
    * @param promo_cd - Type: String
    * @param password - Type: String
    * @param secret_question - Type: String
    * @param secret_question_answer - Type: String
    * @param first_name - Type: String
    * @param mi - Type: String
    * @param last_name - Type: String
    * @param company_name - Type: String
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param locality - Type: String
    * @param state_prov - Type: String
    * @param country - Type: String
    * @param postal_cd - Type: String
    * @param phone - Type: String
    * @param phone_ext - Type: String
    * @param cell_phone - Type: String
    * @param work_phone - Type: String
    * @param work_phone_ext - Type: String
    * @param email - Type: String
    * @param birthdate - Type: String
    * @param bill_first_name - Type: String
    * @param bill_mi - Type: String
    * @param bill_last_name - Type: String
    * @param bill_company_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_country - Type: String
    * @param bill_postal_cd - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_ext - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_ext - Type: String
    * @param bill_email - Type: String
    * @param pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_acct_no - Type: String
    * @param bank_routing_no - Type: String
    * @param resp_level_cd - Type: Long
    * @param senior_acct_no - Type: Long
    * @param senior_acct_user_id - Type: String
    * @param client_senior_acct_id - Type: String
    * @param functional_acct_groups - Type: com.aria.common.shared.FunctionalAcctGroupsArray
    * @param collections_acct_groups - Type: com.aria.common.shared.CollectionsAcctGroupsArray
    * @param supp_field_names - Type: com.aria.common.shared.SuppFieldNamesArray
    * @param supp_field_values - Type: com.aria.common.shared.SuppFieldValuesArray
    * @param test_acct_ind - Type: Long
    * @param status_until_alt_start - Type: Long
    * @param balance_forward - Type: Double
    * @param alt_bill_day - Type: Long
    * @param do_full_invoicing - Type: String
    * @param do_prorated_invoicing - Type: String
    * @param master_plan_alt_rate_sched_no - Type: Long
    * @param supp_plan_alt_rate_sched_no - Type: com.aria.common.shared.SuppPlanAltRateSchedNoArray
    * @param client_receipt_id - Type: String
    * @param currency_cd - Type: String
    * @param cvv - Type: String
    * @param taxpayer_id - Type: String
    * @param bill_agreement_id - Type: String
    * @param retroactive_start_date - Type: String
    * @param coupon_codes - Type: com.aria.common.shared.CouponCodesArray
    * @param new_acct_custom_rates - Type: com.aria.common.shared.NewAcctCustomRatesArray
    * @param alt_msg_template_no - Type: Long
    * @param seq_func_group_no - Type: Long
    * @param new_acct_plan_contracts - Type: com.aria.common.shared.NewAcctPlanContractsArray
    * @param bank_acct_type - Type: String
    * @param address3 - Type: String
    * @param bill_address3 - Type: String
    * @param usage_accumulation_config - Type: com.aria.common.shared.UsageAccumulationConfigArray
    * @param enable_usage_pooling_plan_no - Type: com.aria.common.shared.EnableUsagePoolingPlanNoArray
    * @param client_func_acct_group_ids - Type: com.aria.common.shared.ClientFuncAcctGroupIdsArray
    * @param client_coll_acct_group_ids - Type: com.aria.common.shared.ClientCollAcctGroupIdsArray
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param do_write - Type: String
    * @param tax_exemption_level - Type: Long
    * @param cn_alt_msg_template_no - Type: Long
    * @param invoice_approval_required - Type: String
    * @param create_session - Type: String
    * @param client_supp_plan_ids - Type: com.aria.common.shared.ClientSuppPlanIdsArray
    * @param client_mp_alt_rate_sched_id - Type: String
    * @param client_sp_alt_rate_sched_ids - Type: com.aria.common.shared.ClientSpAltRateSchedIdsArray
    * @param client_alt_msg_template_id - Type: String
    * @param client_cn_alt_msg_template_no - Type: String
    * @param surcharge_no - Type: com.aria.common.shared.SurchargeNoArray
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param bkup_bill_first_name - Type: String
    * @param bkup_bill_mi - Type: String
    * @param bkup_bill_last_name - Type: String
    * @param bkup_bill_company_name - Type: String
    * @param bkup_bill_address1 - Type: String
    * @param bkup_bill_address2 - Type: String
    * @param bkup_bill_address3 - Type: String
    * @param bkup_bill_city - Type: String
    * @param bkup_bill_locality - Type: String
    * @param bkup_bill_state_prov - Type: String
    * @param bkup_bill_country - Type: String
    * @param bkup_bill_postal_cd - Type: String
    * @param bkup_bill_phone - Type: String
    * @param bkup_bill_phone_ext - Type: String
    * @param bkup_bill_cell_phone - Type: String
    * @param bkup_bill_work_phone - Type: String
    * @param bkup_bill_work_phone_ext - Type: String
    * @param bkup_bill_email - Type: String
    * @param bkup_pay_method - Type: Long
    * @param bkup_cc_number - Type: String
    * @param bkup_cc_expire_mm - Type: Long
    * @param bkup_cc_expire_yyyy - Type: Long
    * @param bkup_bank_acct_no - Type: String
    * @param bkup_bank_routing_no - Type: String
    * @param bkup_bank_acct_type - Type: String
    * @param bkup_bill_agreement_id - Type: String
    * @param bkup_cvv - Type: String
    * @param seq_func_group_id - Type: String
    * @param revrec_profile_id - Type: Long
    * @param revrec_client_defined_id - Type: String
    * @param stmnt_email_list_cc - Type: String
    * @param stmnt_email_list_bcc - Type: String
    * @param invoice_posting_method_cd - Type: Long
    * @param acct_start_date - Type: String
    * @param min_statement_threshold - Type: Long
    * @param max_statements_to_defer - Type: Long
    * @param defer_full_statements_only - Type: Long
    * @param cc_id - Type: Long
    * @param bkup_cc_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_no - Type: javax.xml.ws.Holder<br>
    *   out_userid - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_code - Type: javax.xml.ws.Holder<br>
    *   invoicing_error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   out_new_acct_plan_contracts - Type: ArrayList&#60;OutNewAcctPlanContractsReturnElement&#62;<br>
    *   invoice_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   invoice_tax_charges - Type: javax.xml.ws.Holder<br>
    *   invoice_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   invoice_credit_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_total_amount - Type: javax.xml.ws.Holder<br>
    *   new_acct_invoice_line_items - Type: ArrayList&#60;NewAcctInvoiceLineItemsReturnElement&#62;<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    *   session_id - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createAcctComplete(Long client_no, String auth_key, Long master_plan_no, String client_master_plan_id, String alt_start_date, String client_acct_id, String userid, Long status_cd, Long master_plan_units, com.aria.common.shared.SuppPlansArray supp_plans, com.aria.common.shared.SuppPlanUnitsArray supp_plan_units, Long notify_method, String promo_cd, String password, String secret_question, String secret_question_answer, String first_name, String mi, String last_name, String company_name, String address1, String address2, String city, String locality, String state_prov, String country, String postal_cd, String phone, String phone_ext, String cell_phone, String work_phone, String work_phone_ext, String email, String birthdate, String bill_first_name, String bill_mi, String bill_last_name, String bill_company_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_country, String bill_postal_cd, String bill_phone, String bill_phone_ext, String bill_cell_phone, String bill_work_phone, String bill_work_phone_ext, String bill_email, Long pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_acct_no, String bank_routing_no, Long resp_level_cd, Long senior_acct_no, String senior_acct_user_id, String client_senior_acct_id, com.aria.common.shared.FunctionalAcctGroupsArray functional_acct_groups, com.aria.common.shared.CollectionsAcctGroupsArray collections_acct_groups, com.aria.common.shared.SuppFieldNamesArray supp_field_names, com.aria.common.shared.SuppFieldValuesArray supp_field_values, Long test_acct_ind, Long status_until_alt_start, Double balance_forward, Long alt_bill_day, String do_full_invoicing, String do_prorated_invoicing, Long master_plan_alt_rate_sched_no, com.aria.common.shared.SuppPlanAltRateSchedNoArray supp_plan_alt_rate_sched_no, String client_receipt_id, String currency_cd, String cvv, String taxpayer_id, String bill_agreement_id, String retroactive_start_date, com.aria.common.shared.CouponCodesArray coupon_codes, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, Long alt_msg_template_no, Long seq_func_group_no, com.aria.common.shared.NewAcctPlanContractsArray new_acct_plan_contracts, String bank_acct_type, String address3, String bill_address3, com.aria.common.shared.UsageAccumulationConfigArray usage_accumulation_config, com.aria.common.shared.EnableUsagePoolingPlanNoArray enable_usage_pooling_plan_no, com.aria.common.shared.ClientFuncAcctGroupIdsArray client_func_acct_group_ids, com.aria.common.shared.ClientCollAcctGroupIdsArray client_coll_acct_group_ids, String track_data1, String track_data2, String do_write, Long tax_exemption_level, Long cn_alt_msg_template_no, String invoice_approval_required, String create_session, com.aria.common.shared.ClientSuppPlanIdsArray client_supp_plan_ids, String client_mp_alt_rate_sched_id, com.aria.common.shared.ClientSpAltRateSchedIdsArray client_sp_alt_rate_sched_ids, String client_alt_msg_template_id, String client_cn_alt_msg_template_no, com.aria.common.shared.SurchargeNoArray surcharge_no, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String bkup_bill_first_name, String bkup_bill_mi, String bkup_bill_last_name, String bkup_bill_company_name, String bkup_bill_address1, String bkup_bill_address2, String bkup_bill_address3, String bkup_bill_city, String bkup_bill_locality, String bkup_bill_state_prov, String bkup_bill_country, String bkup_bill_postal_cd, String bkup_bill_phone, String bkup_bill_phone_ext, String bkup_bill_cell_phone, String bkup_bill_work_phone, String bkup_bill_work_phone_ext, String bkup_bill_email, Long bkup_pay_method, String bkup_cc_number, Long bkup_cc_expire_mm, Long bkup_cc_expire_yyyy, String bkup_bank_acct_no, String bkup_bank_routing_no, String bkup_bank_acct_type, String bkup_bill_agreement_id, String bkup_cvv, String seq_func_group_id, Long revrec_profile_id, String revrec_client_defined_id, String stmnt_email_list_cc, String stmnt_email_list_bcc, Long invoice_posting_method_cd, String acct_start_date, Long min_statement_threshold, Long max_statements_to_defer, Long defer_full_statements_only, Long cc_id, Long bkup_cc_id);

    abstract Map<String,Object> createAcctComplete(Map<String,Object> map);

    /**
    * createAcctMultiplanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param length_months - Type: Long
    * @param end_date - Type: String
    * @param plan_no - Type: com.aria.common.shared.PlanNoArray
    * @param type_no - Type: Long
    * @param create_comments - Type: String
    * @param start_date - Type: String
    * @param do_auto_discard - Type: String
    * @param client_plan_id - Type: com.aria.common.shared.ClientPlanIdArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   contract_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long length_months, String end_date, com.aria.common.shared.PlanNoArray plan_no, Long type_no, String create_comments, String start_date, String do_auto_discard, com.aria.common.shared.ClientPlanIdArray client_plan_id);

    abstract Map<String,Object> createAcctMultiplanContract(Map<String,Object> map);

    /**
    * createAcctPlanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param plan_no - Type: Long
    * @param length_months - Type: Long
    * @param end_date - Type: String
    * @param client_plan_id - Type: String
    * @param type_no - Type: Long
    * @param alt_recur_fee - Type: Double
    * @param cancel_fee - Type: Double
    * @param create_comments - Type: String
    * @param start_date - Type: String
    * @param do_auto_discard - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   contract_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long plan_no, Long length_months, String end_date, String client_plan_id, Long type_no, Double alt_recur_fee, Double cancel_fee, String create_comments, String start_date, String do_auto_discard);

    abstract Map<String,Object> createAcctPlanContract(Map<String,Object> map);

    /**
    * createAcctUniversalContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param length_months - Type: Long
    * @param end_date - Type: String
    * @param type_no - Type: Long
    * @param create_comments - Type: String
    * @param start_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   contract_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createAcctUniversalContract(Long client_no, String auth_key, Long acct_no, Long length_months, String end_date, Long type_no, String create_comments, String start_date);

    abstract Map<String,Object> createAcctUniversalContract(Map<String,Object> map);

    /**
    * createAdvancedServiceCredit
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param reason_code - Type: Long
    * @param comments - Type: String
    * @param eligible_plan_no - Type: Long
    * @param eligible_service_no - Type: Long
    * @param alt_service_no_to_apply - Type: Long
    * @param frequency_no - Type: Long
    * @param frequency_interval_months - Type: Long
    * @param initial_credit_date - Type: String
    * @param percent_amount - Type: Double
    * @param percent_eval_plan_no - Type: Long
    * @param percent_eval_service_no - Type: Long
    * @param eligible_service_types - Type: com.aria.common.shared.EligibleServiceTypesArray
    * @param client_eligible_plan_id - Type: String
    * @param client_eligible_service_id - Type: String
    * @param client_alt_service_id_to_apply - Type: String
    * @param client_percent_eval_plan_id - Type: String
    * @param client_percent_eval_service_id - Type: String
    * @param credit_expiry_type_ind - Type: String
    * @param credit_expiry_months - Type: Long
    * @param credit_expiry_date - Type: String
    * @param eligible_service_plans - Type: com.aria.common.shared.EligibleServicePlansArray
    * @param client_eligible_service_plan_ids - Type: com.aria.common.shared.ClientEligibleServicePlanIdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createAdvancedServiceCredit(Long client_no, String auth_key, Long acct_no, Double amount, Long reason_code, String comments, Long eligible_plan_no, Long eligible_service_no, Long alt_service_no_to_apply, Long frequency_no, Long frequency_interval_months, String initial_credit_date, Double percent_amount, Long percent_eval_plan_no, Long percent_eval_service_no, com.aria.common.shared.EligibleServiceTypesArray eligible_service_types, String client_eligible_plan_id, String client_eligible_service_id, String client_alt_service_id_to_apply, String client_percent_eval_plan_id, String client_percent_eval_service_id, String credit_expiry_type_ind, Long credit_expiry_months, String credit_expiry_date, com.aria.common.shared.EligibleServicePlansArray eligible_service_plans, com.aria.common.shared.ClientEligibleServicePlanIdsArray client_eligible_service_plan_ids);

    abstract Map<String,Object> createAdvancedServiceCredit(Map<String,Object> map);

    /**
    * deleteAcctCoupon
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param coupon_cd - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteAcctCoupon(Long client_no, String auth_key, Long acct_no, String coupon_cd);

    abstract Map<String,Object> deleteAcctCoupon(Map<String,Object> map);

    /**
    * disableAllStandingUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> disableAllStandingUsage(Long client_no, String auth_key, Long acct_no, String comments);

    abstract Map<String,Object> disableAllStandingUsage(Map<String,Object> map);

    /**
    * disableStandingUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param standing_usage_rec_no - Type: Long
    * @param comments - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> disableStandingUsage(Long client_no, String auth_key, Long acct_no, Long standing_usage_rec_no, String comments);

    abstract Map<String,Object> disableStandingUsage(Map<String,Object> map);

    /**
    * disableStandingUsageByPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param plan_no - Type: Long
    * @param comments - Type: String
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> disableStandingUsageByPlan(Long client_no, String auth_key, Long acct_no, Long plan_no, String comments, String client_plan_id);

    abstract Map<String,Object> disableStandingUsageByPlan(Map<String,Object> map);

    /**
    * genStatement
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param send_email - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   statement_no - Type: javax.xml.ws.Holder<br>
    *   seq_statement_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> genStatement(Long client_no, String auth_key, Long acct_no, String send_email);

    abstract Map<String,Object> genStatement(Map<String,Object> map);

    /**
    * getAcctBalance
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    *   balance - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctBalance(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctBalance(Map<String,Object> map);

    /**
    * getAcctComments
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param date_range_start - Type: String
    * @param date_range_end - Type: String
    * @param do_url_encoding - Type: String
    * @param filter_application_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_comments - Type: ArrayList&#60;AcctCommentsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctComments(Long client_no, String auth_key, Long acct_no, String date_range_start, String date_range_end, String do_url_encoding, String filter_application_id);

    abstract Map<String,Object> getAcctComments(Map<String,Object> map);

    /**
    * getAcctCreditDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param credit_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   created_by - Type: javax.xml.ws.Holder<br>
    *   created_date - Type: javax.xml.ws.Holder<br>
    *   amount - Type: javax.xml.ws.Holder<br>
    *   credit_type - Type: javax.xml.ws.Holder<br>
    *   applied_amount - Type: javax.xml.ws.Holder<br>
    *   unapplied_amount - Type: javax.xml.ws.Holder<br>
    *   reason_code - Type: javax.xml.ws.Holder<br>
    *   reason_text - Type: javax.xml.ws.Holder<br>
    *   comments - Type: javax.xml.ws.Holder<br>
    *   transaction_id - Type: javax.xml.ws.Holder<br>
    *   void_transaction_id - Type: javax.xml.ws.Holder<br>
    *   credit_expiry_type_ind - Type: javax.xml.ws.Holder<br>
    *   credit_expiry_months - Type: javax.xml.ws.Holder<br>
    *   credit_expiry_date - Type: javax.xml.ws.Holder<br>
    *   eligible_service_plan_details - Type: ArrayList&#60;EligibleServicePlanDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctCreditDetails(Long client_no, String auth_key, Long acct_no, Long credit_no);

    abstract Map<String,Object> getAcctCreditDetails(Map<String,Object> map);

    /**
    * getAcctCredits
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param limit_records - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_credits - Type: ArrayList&#60;AcctCreditsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctCredits(Long client_no, String auth_key, Long acct_no, Long limit_records);

    abstract Map<String,Object> getAcctCredits(Map<String,Object> map);

    /**
    * getAcctDetailsAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   first_name - Type: javax.xml.ws.Holder<br>
    *   mi - Type: javax.xml.ws.Holder<br>
    *   last_name - Type: javax.xml.ws.Holder<br>
    *   userid - Type: javax.xml.ws.Holder<br>
    *   birthdate - Type: javax.xml.ws.Holder<br>
    *   job_title - Type: javax.xml.ws.Holder<br>
    *   salutation - Type: javax.xml.ws.Holder<br>
    *   senior_acct_no - Type: javax.xml.ws.Holder<br>
    *   client_acct_id - Type: javax.xml.ws.Holder<br>
    *   resp_level_cd - Type: javax.xml.ws.Holder<br>
    *   is_test_acct - Type: javax.xml.ws.Holder<br>
    *   alt_email - Type: javax.xml.ws.Holder<br>
    *   address1 - Type: javax.xml.ws.Holder<br>
    *   address2 - Type: javax.xml.ws.Holder<br>
    *   city - Type: javax.xml.ws.Holder<br>
    *   state_prov - Type: javax.xml.ws.Holder<br>
    *   locality - Type: javax.xml.ws.Holder<br>
    *   postal_code - Type: javax.xml.ws.Holder<br>
    *   country - Type: javax.xml.ws.Holder<br>
    *   company_name - Type: javax.xml.ws.Holder<br>
    *   cell_phone_npa - Type: javax.xml.ws.Holder<br>
    *   cell_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   cell_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   fax_phone - Type: javax.xml.ws.Holder<br>
    *   intl_cell_phone - Type: javax.xml.ws.Holder<br>
    *   intl_phone - Type: javax.xml.ws.Holder<br>
    *   phone_extension - Type: javax.xml.ws.Holder<br>
    *   phone_npa - Type: javax.xml.ws.Holder<br>
    *   phone_nxx - Type: javax.xml.ws.Holder<br>
    *   phone_suffix - Type: javax.xml.ws.Holder<br>
    *   work_phone - Type: javax.xml.ws.Holder<br>
    *   work_phone_extension - Type: javax.xml.ws.Holder<br>
    *   work_phone_npa - Type: javax.xml.ws.Holder<br>
    *   work_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   work_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   bill_day - Type: javax.xml.ws.Holder<br>
    *   created - Type: javax.xml.ws.Holder<br>
    *   date_to_expire - Type: javax.xml.ws.Holder<br>
    *   date_to_suspend - Type: javax.xml.ws.Holder<br>
    *   last_arrears_bill_thru_date - Type: javax.xml.ws.Holder<br>
    *   last_bill_date - Type: javax.xml.ws.Holder<br>
    *   last_bill_thru_date - Type: javax.xml.ws.Holder<br>
    *   next_bill_date - Type: javax.xml.ws.Holder<br>
    *   plan_date - Type: javax.xml.ws.Holder<br>
    *   status_date - Type: javax.xml.ws.Holder<br>
    *   status_degrade_date - Type: javax.xml.ws.Holder<br>
    *   status_cd - Type: javax.xml.ws.Holder<br>
    *   status_label - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    *   plan_name - Type: javax.xml.ws.Holder<br>
    *   plan_units - Type: javax.xml.ws.Holder<br>
    *   notify_method - Type: javax.xml.ws.Holder<br>
    *   notify_method_name - Type: javax.xml.ws.Holder<br>
    *   PASSWORD - Type: javax.xml.ws.Holder<br>
    *   pin - Type: javax.xml.ws.Holder<br>
    *   secret_question - Type: javax.xml.ws.Holder<br>
    *   secret_question_answer - Type: javax.xml.ws.Holder<br>
    *   pay_method - Type: javax.xml.ws.Holder<br>
    *   pay_method_name - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    *   tax_id - Type: javax.xml.ws.Holder<br>
    *   billing_email - Type: javax.xml.ws.Holder<br>
    *   billing_first_name - Type: javax.xml.ws.Holder<br>
    *   billing_middle_initial - Type: javax.xml.ws.Holder<br>
    *   billing_last_name - Type: javax.xml.ws.Holder<br>
    *   billing_address1 - Type: javax.xml.ws.Holder<br>
    *   billing_address2 - Type: javax.xml.ws.Holder<br>
    *   billing_city - Type: javax.xml.ws.Holder<br>
    *   billing_state - Type: javax.xml.ws.Holder<br>
    *   billing_locality - Type: javax.xml.ws.Holder<br>
    *   billing_zip - Type: javax.xml.ws.Holder<br>
    *   billing_country - Type: javax.xml.ws.Holder<br>
    *   cc_type - Type: javax.xml.ws.Holder<br>
    *   cc_suffix - Type: javax.xml.ws.Holder<br>
    *   cc_expire_mm - Type: javax.xml.ws.Holder<br>
    *   cc_expire_yyyy - Type: javax.xml.ws.Holder<br>
    *   cc_id - Type: javax.xml.ws.Holder<br>
    *   bank_acct_suffix - Type: javax.xml.ws.Holder<br>
    *   bank_routing_no - Type: javax.xml.ws.Holder<br>
    *   billing_cell_phone - Type: javax.xml.ws.Holder<br>
    *   billing_cell_phone_npa - Type: javax.xml.ws.Holder<br>
    *   billing_cell_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   billing_cell_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   billing_company_name - Type: javax.xml.ws.Holder<br>
    *   billing_intl_phone - Type: javax.xml.ws.Holder<br>
    *   billing_phone_extension - Type: javax.xml.ws.Holder<br>
    *   billing_phone_npa - Type: javax.xml.ws.Holder<br>
    *   billing_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   billing_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   billing_work_phone - Type: javax.xml.ws.Holder<br>
    *   billing_work_phone_extension - Type: javax.xml.ws.Holder<br>
    *   billing_work_phone_npa - Type: javax.xml.ws.Holder<br>
    *   billing_work_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   billing_work_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   balance - Type: javax.xml.ws.Holder<br>
    *   acct_create_client_receipt_id - Type: javax.xml.ws.Holder<br>
    *   plan_client_receipt_id - Type: javax.xml.ws.Holder<br>
    *   status_client_receipt_id - Type: javax.xml.ws.Holder<br>
    *   taxpayer_id - Type: javax.xml.ws.Holder<br>
    *   alt_msg_template_no - Type: javax.xml.ws.Holder<br>
    *   seq_func_group_no - Type: javax.xml.ws.Holder<br>
    *   promo_cd - Type: javax.xml.ws.Holder<br>
    *   address3 - Type: javax.xml.ws.Holder<br>
    *   billing_address3 - Type: javax.xml.ws.Holder<br>
    *   address_verification_code - Type: javax.xml.ws.Holder<br>
    *   address_match_score - Type: javax.xml.ws.Holder<br>
    *   billing_address_verification_code - Type: javax.xml.ws.Holder<br>
    *   billing_address_match_score - Type: javax.xml.ws.Holder<br>
    *   client_plan_id - Type: javax.xml.ws.Holder<br>
    *   client_alt_msg_template_id - Type: javax.xml.ws.Holder<br>
    *   bkup_pay_method - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_email - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_first_name - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_middle_initial - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_last_name - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_address1 - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_address2 - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_city - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_state - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_locality - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_zip - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_country - Type: javax.xml.ws.Holder<br>
    *   bkup_cc_type - Type: javax.xml.ws.Holder<br>
    *   bkup_cc_suffix - Type: javax.xml.ws.Holder<br>
    *   bkup_cc_expire_mm - Type: javax.xml.ws.Holder<br>
    *   bkup_cc_expire_yyyy - Type: javax.xml.ws.Holder<br>
    *   bkup_cc_id - Type: javax.xml.ws.Holder<br>
    *   bkup_bank_acct_suffix - Type: javax.xml.ws.Holder<br>
    *   bkup_bank_routing_no - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_cell_phone - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_cell_phone_npa - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_cell_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_cell_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_company_name - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_intl_phone - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_phone_extension - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_work_phone - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_work_phone_extension - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_work_phone_npa - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_work_phone_nxx - Type: javax.xml.ws.Holder<br>
    *   bkup_billing_work_phone_suffix - Type: javax.xml.ws.Holder<br>
    *   invoice_approval_required - Type: javax.xml.ws.Holder<br>
    *   stmnt_email_list_cc - Type: javax.xml.ws.Holder<br>
    *   stmnt_email_list_bcc - Type: javax.xml.ws.Holder<br>
    *   invoice_posting_method_cd - Type: javax.xml.ws.Holder<br>
    *   acct_start_date - Type: javax.xml.ws.Holder<br>
    *   bill_agreement_id - Type: javax.xml.ws.Holder<br>
    *   bkup_bill_agreement_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctDetailsAll(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctDetailsAll(Map<String,Object> map);

    /**
    * getAcctGroupsByAcct
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param user_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_groups - Type: ArrayList&#60;AcctGroupsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctGroupsByAcct(Long client_no, String auth_key, Long acct_no, String user_id);

    abstract Map<String,Object> getAcctGroupsByAcct(Map<String,Object> map);

    /**
    * getAcctGroupsByClient
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_groups - Type: ArrayList&#60;AcctGroupsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctGroupsByClient(Long client_no, String auth_key);

    abstract Map<String,Object> getAcctGroupsByClient(Map<String,Object> map);

    /**
    * getAcctHasOrderedSku
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param sku - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   ordered_ind - Type: javax.xml.ws.Holder<br>
    *   billed_ind - Type: javax.xml.ws.Holder<br>
    *   paid_ind - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctHasOrderedSku(Long client_no, String auth_key, Long acct_no, String sku);

    abstract Map<String,Object> getAcctHasOrderedSku(Map<String,Object> map);

    /**
    * getAcctHierarchyDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param hierarchy_filter - Type: Long
    * @param include_current_acct - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_hierarchy_details - Type: ArrayList&#60;AcctHierarchyDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctHierarchyDetails(Long client_no, String auth_key, Long acct_no, Long hierarchy_filter, Long include_current_acct);

    abstract Map<String,Object> getAcctHierarchyDetails(Map<String,Object> map);

    /**
    * getAcctInvoiceHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param user_id - Type: String
    * @param start_bill_date - Type: String
    * @param end_bill_date - Type: String
    * @param include_voided - Type: String
    * @param posting_status_cd - Type: Long
    * @param posting_user - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_history - Type: ArrayList&#60;InvoiceHistoryReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctInvoiceHistory(Long client_no, String auth_key, Long acct_no, String user_id, String start_bill_date, String end_bill_date, String include_voided, Long posting_status_cd, String posting_user);

    abstract Map<String,Object> getAcctInvoiceHistory(Map<String,Object> map);

    /**
    * getAcctMessage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param message_id - Type: Long
    * @param do_encoding - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   message_body - Type: javax.xml.ws.Holder<br>
    *   mime_type - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctMessage(Long client_no, String auth_key, Long acct_no, Long message_id, String do_encoding);

    abstract Map<String,Object> getAcctMessage(Map<String,Object> map);

    /**
    * getAcctMessageSize
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param message_id - Type: Long
    * @param do_encoding - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   num_chars - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctMessageSize(Long client_no, String auth_key, Long acct_no, Long message_id, String do_encoding);

    abstract Map<String,Object> getAcctMessageSize(Map<String,Object> map);

    /**
    * getAcctMultiplanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param contract_no - Type: Long
    * @param exclude_terminated_plans - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   type_no - Type: javax.xml.ws.Holder<br>
    *   length_months - Type: javax.xml.ws.Holder<br>
    *   create_comments - Type: javax.xml.ws.Holder<br>
    *   update_comments - Type: javax.xml.ws.Holder<br>
    *   create_date - Type: javax.xml.ws.Holder<br>
    *   update_date - Type: javax.xml.ws.Holder<br>
    *   start_date - Type: javax.xml.ws.Holder<br>
    *   end_date - Type: javax.xml.ws.Holder<br>
    *   status_code - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: ArrayList&#60;PlanNoReturnElement&#62;<br>
    *   plan_name - Type: ArrayList&#60;PlanNameReturnElement&#62;<br>
    *   client_plan_id - Type: ArrayList&#60;ClientPlanIdReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, String exclude_terminated_plans);

    abstract Map<String,Object> getAcctMultiplanContract(Map<String,Object> map);

    /**
    * getAcctNoFromUserId
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctNoFromUserId(Long client_no, String auth_key, String user_id);

    abstract Map<String,Object> getAcctNoFromUserId(Map<String,Object> map);

    /**
    * getAcctNotificationDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param acct_user_id - Type: String
    * @param client_acct_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_notification_details - Type: ArrayList&#60;AcctNotificationDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctNotificationDetails(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id);

    abstract Map<String,Object> getAcctNotificationDetails(Map<String,Object> map);

    /**
    * getAcctNotifyMethod
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   notify_method - Type: javax.xml.ws.Holder<br>
    *   notify_method_name - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctNotifyMethod(Long client_no, String auth_key, Long account_no);

    abstract Map<String,Object> getAcctNotifyMethod(Map<String,Object> map);

    /**
    * getAcctOpenCharges
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   total_amount - Type: javax.xml.ws.Holder<br>
    *   open_charge_items - Type: ArrayList&#60;OpenChargeItemsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctOpenCharges(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctOpenCharges(Map<String,Object> map);

    /**
    * getAcctPaymentMethods
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param filter_seq_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   acct_pay_methods - Type: ArrayList&#60;AcctPayMethodsReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctPaymentMethods(Long client_no, String auth_key, Long acct_no, Long filter_seq_no);

    abstract Map<String,Object> getAcctPaymentMethods(Map<String,Object> map);

    /**
    * getAcctPlanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param plan_no - Type: Long
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_plan_contract - Type: ArrayList&#60;AcctPlanContractReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long plan_no, String client_plan_id);

    abstract Map<String,Object> getAcctPlanContract(Map<String,Object> map);

    /**
    * getAcctPlanHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_number - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_hist - Type: ArrayList&#60;PlanHistReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctPlanHistory(Long client_no, String auth_key, Long account_number);

    abstract Map<String,Object> getAcctPlanHistory(Map<String,Object> map);

    /**
    * getAcctPlanUnitInstanceAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param plan_no - Type: Long
    * @param client_plan_id - Type: String
    * @param plan_unit_inst_no - Type: Long
    * @param client_plan_unit_inst_id - Type: String
    * @param status_cd - Type: Long
    * @param plan_unit_inst_status_cd - Type: Long
    * @param fulfillment_only - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_no - Type: javax.xml.ws.Holder<br>
    *   client_acct_id - Type: javax.xml.ws.Holder<br>
    *   all_plan_unit_instances - Type: ArrayList&#60;AllPlanUnitInstancesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctPlanUnitInstanceAll(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long plan_no, String client_plan_id, Long plan_unit_inst_no, String client_plan_unit_inst_id, Long status_cd, Long plan_unit_inst_status_cd, Long fulfillment_only);

    abstract Map<String,Object> getAcctPlanUnitInstanceAll(Map<String,Object> map);

    /**
    * getAcctPlans
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_plans - Type: ArrayList&#60;AcctPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctPlans(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctPlans(Map<String,Object> map);

    /**
    * getAcctPlansAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_acct_plans - Type: ArrayList&#60;AllAcctPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctPlansAll(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctPlansAll(Map<String,Object> map);

    /**
    * getAcctServiceOutageCredit
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param outage_start_date - Type: String
    * @param outage_end_date - Type: String
    * @param outage_start_time - Type: String
    * @param outage_end_time - Type: String
    * @param plans_to_get_outage - Type: com.aria.common.shared.PlansToGetOutageArray
    * @param adjust_percent - Type: Double
    * @param client_plan_ids_to_get_outage - Type: com.aria.common.shared.ClientPlanIdsToGetOutageArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_no - Type: javax.xml.ws.Holder<br>
    *   service_outage_line_items - Type: ArrayList&#60;ServiceOutageLineItemsReturnElement&#62;<br>
    *   total_outage_credit - Type: javax.xml.ws.Holder<br>
    *   adjusted_outage_credit - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctServiceOutageCredit(Long client_no, String auth_key, Long acct_no, String outage_start_date, String outage_end_date, String outage_start_time, String outage_end_time, com.aria.common.shared.PlansToGetOutageArray plans_to_get_outage, Double adjust_percent, com.aria.common.shared.ClientPlanIdsToGetOutageArray client_plan_ids_to_get_outage);

    abstract Map<String,Object> getAcctServiceOutageCredit(Map<String,Object> map);

    /**
    * getAcctStatementHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param user_id - Type: String
    * @param start_date - Type: String
    * @param end_date - Type: String
    * @param include_invoice_activity_eligibility - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_history - Type: ArrayList&#60;StatementHistoryReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctStatementHistory(Long client_no, String auth_key, Long acct_no, String user_id, String start_date, String end_date, String include_invoice_activity_eligibility);

    abstract Map<String,Object> getAcctStatementHistory(Map<String,Object> map);

    /**
    * getAcctStatusHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_number - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   stat_hist - Type: ArrayList&#60;StatHistReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctStatusHistory(Long client_no, String auth_key, Long account_number);

    abstract Map<String,Object> getAcctStatusHistory(Map<String,Object> map);

    /**
    * getAcctSuppFields
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   supp_fields - Type: ArrayList&#60;SuppFieldsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctSuppFields(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctSuppFields(Map<String,Object> map);

    /**
    * getAcctSuppPlanHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param plan_no - Type: Long
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   supp_plan_hist - Type: ArrayList&#60;SuppPlanHistReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctSuppPlanHistory(Long client_no, String auth_key, Long acct_no, Long plan_no, String client_plan_id);

    abstract Map<String,Object> getAcctSuppPlanHistory(Map<String,Object> map);

    /**
    * getAcctTaxExemptStatus
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   exemption_level - Type: javax.xml.ws.Holder<br>
    *   exemption_level_desc - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctTaxExemptStatus(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctTaxExemptStatus(Map<String,Object> map);

    /**
    * getAcctTransHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param transaction_type - Type: Long
    * @param start_date - Type: String
    * @param end_date - Type: String
    * @param record_limit - Type: Long
    * @param filter_statement_no - Type: Long
    * @param include_void_transactions - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   history - Type: ArrayList&#60;HistoryReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctTransHistory(Long client_no, String auth_key, Long account_no, Long transaction_type, String start_date, String end_date, Long record_limit, Long filter_statement_no, String include_void_transactions);

    abstract Map<String,Object> getAcctTransHistory(Map<String,Object> map);

    /**
    * getAcctUniversalContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   type_no - Type: javax.xml.ws.Holder<br>
    *   length_months - Type: javax.xml.ws.Holder<br>
    *   create_comments - Type: javax.xml.ws.Holder<br>
    *   update_comments - Type: javax.xml.ws.Holder<br>
    *   create_date - Type: javax.xml.ws.Holder<br>
    *   update_date - Type: javax.xml.ws.Holder<br>
    *   start_date - Type: javax.xml.ws.Holder<br>
    *   end_date - Type: javax.xml.ws.Holder<br>
    *   status_code - Type: javax.xml.ws.Holder<br>
    *   contract_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctUniversalContract(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAcctUniversalContract(Map<String,Object> map);

    /**
    * getAcctUuids
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   uuid_data - Type: ArrayList&#60;UuidDataReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctUuids(Long client_no, String auth_key, Long acct_no, String client_acct_id);

    abstract Map<String,Object> getAcctUuids(Map<String,Object> map);

    /**
    * getAcctsWithExistingPayMethod
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param pay_method - Type: Long
    * @param form_payment_acct_id - Type: String
    * @param bank_routing_num - Type: String
    * @param bill_agreement_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   accts_with_pay_method - Type: ArrayList&#60;AcctsWithPayMethodReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAcctsWithExistingPayMethod(Long client_no, String auth_key, Long pay_method, String form_payment_acct_id, String bank_routing_num, String bill_agreement_id);

    abstract Map<String,Object> getAcctsWithExistingPayMethod(Map<String,Object> map);

    /**
    * getAllAcctContracts
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param filter_status_code - Type: Long
    * @param exclude_terminated_plans - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_acct_contracts - Type: ArrayList&#60;AllAcctContractsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAllAcctContracts(Long client_no, String auth_key, Long acct_no, Long filter_status_code, String exclude_terminated_plans);

    abstract Map<String,Object> getAllAcctContracts(Map<String,Object> map);

    /**
    * getAllAcctReceiptIds
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param start_date_range - Type: String
    * @param end_date_range - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_receipt - Type: ArrayList&#60;AcctReceiptReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAllAcctReceiptIds(Long client_no, String auth_key, Long acct_no, String start_date_range, String end_date_range);

    abstract Map<String,Object> getAllAcctReceiptIds(Map<String,Object> map);

    /**
    * getAvailChildPlansForAcct
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAvailChildPlansForAcct(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAvailChildPlansForAcct(Map<String,Object> map);

    /**
    * getAvailChildPlansForAcctAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_plans - Type: ArrayList&#60;AllPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAvailChildPlansForAcctAll(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAvailChildPlansForAcctAll(Map<String,Object> map);

    /**
    * getAvailChildPlansForPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param in_plan_no - Type: Long
    * @param in_client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAvailChildPlansForPlan(Long client_no, String auth_key, Long in_plan_no, String in_client_plan_id);

    abstract Map<String,Object> getAvailChildPlansForPlan(Map<String,Object> map);

    /**
    * getAvailChildPlansForPlanAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param in_plan_no - Type: Long
    * @param in_client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_plans - Type: ArrayList&#60;AllPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAvailChildPlansForPlanAll(Long client_no, String auth_key, Long in_plan_no, String in_client_plan_id);

    abstract Map<String,Object> getAvailChildPlansForPlanAll(Map<String,Object> map);

    /**
    * getAvailablePlans
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAvailablePlans(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAvailablePlans(Map<String,Object> map);

    /**
    * getAvailablePlansAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_plans - Type: ArrayList&#60;AllPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAvailablePlansAll(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getAvailablePlansAll(Map<String,Object> map);

    /**
    * getCcUuid
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param cc_number - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   uuid - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getCcUuid(Long client_no, String auth_key, String cc_number);

    abstract Map<String,Object> getCcUuid(Map<String,Object> map);

    /**
    * getChildAccts
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param parent_acct_no - Type: Long
    * @param do_multi_level - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   child_accts - Type: ArrayList&#60;ChildAcctsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getChildAccts(Long client_no, String auth_key, Long parent_acct_no, String do_multi_level);

    abstract Map<String,Object> getChildAccts(Map<String,Object> map);

    /**
    * getCouponDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param coupon_cd - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coupons - Type: ArrayList&#60;CouponsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCouponDetails(Long client_no, String auth_key, Long acct_no, String coupon_cd);

    abstract Map<String,Object> getCouponDetails(Map<String,Object> map);

    /**
    * getCreditReasonCodes
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   credit_reason_codes - Type: ArrayList&#60;CreditReasonCodesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCreditReasonCodes(Long client_no, String auth_key);

    abstract Map<String,Object> getCreditReasonCodes(Map<String,Object> map);

    /**
    * getFamilyTransHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param parent_acct_no - Type: Long
    * @param do_multi_level - Type: String
    * @param trans_type - Type: Long
    * @param start_date - Type: String
    * @param end_date - Type: String
    * @param record_limit - Type: Long
    * @param include_void_transactions - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   fam_trans - Type: ArrayList&#60;FamTransReturnElement&#62;<br>
    */
    abstract Map<String,Object> getFamilyTransHistory(Long client_no, String auth_key, Long parent_acct_no, String do_multi_level, Long trans_type, String start_date, String end_date, Long record_limit, String include_void_transactions);

    abstract Map<String,Object> getFamilyTransHistory(Map<String,Object> map);

    /**
    * getPendingInvoiceNo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getPendingInvoiceNo(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getPendingInvoiceNo(Map<String,Object> map);

    /**
    * getPlansByPromoCode
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param promo_code - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlansByPromoCode(Long client_no, String auth_key, String promo_code);

    abstract Map<String,Object> getPlansByPromoCode(Map<String,Object> map);

    /**
    * getPlansByPromoCodeAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param promo_code - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_plans - Type: ArrayList&#60;AllPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlansByPromoCodeAll(Long client_no, String auth_key, String promo_code);

    abstract Map<String,Object> getPlansByPromoCodeAll(Map<String,Object> map);

    /**
    * getPmtUuid
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param seq_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   uuid - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getPmtUuid(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long seq_no);

    abstract Map<String,Object> getPmtUuid(Map<String,Object> map);

    /**
    * getQueuedServicePlans
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_number - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   queued_plans - Type: ArrayList&#60;QueuedPlansReturnElement&#62;<br>
    *   current_rate_schedule_no - Type: javax.xml.ws.Holder<br>
    *   client_current_rate_schedule_id - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getQueuedServicePlans(Long client_no, String auth_key, Long account_number);

    abstract Map<String,Object> getQueuedServicePlans(Map<String,Object> map);

    /**
    * getRecurringCreditInfo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param filter_credit_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   recurring_credit_info - Type: ArrayList&#60;RecurringCreditInfoReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRecurringCreditInfo(Long client_no, String auth_key, Long acct_no, Long filter_credit_no);

    abstract Map<String,Object> getRecurringCreditInfo(Map<String,Object> map);

    /**
    * getStandingUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   su - Type: ArrayList&#60;SuReturnElement&#62;<br>
    */
    abstract Map<String,Object> getStandingUsage(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getStandingUsage(Map<String,Object> map);

    /**
    * getStatementContent
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param statement_no - Type: Long
    * @param do_encoding - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_content - Type: javax.xml.ws.Holder<br>
    *   mime_type - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getStatementContent(Long client_no, String auth_key, Long acct_no, Long statement_no, String do_encoding);

    abstract Map<String,Object> getStatementContent(Map<String,Object> map);

    /**
    * getStatementContentSize
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param statement_no - Type: Long
    * @param do_encoding - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   num_chars - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getStatementContentSize(Long client_no, String auth_key, Long acct_no, Long statement_no, String do_encoding);

    abstract Map<String,Object> getStatementContentSize(Map<String,Object> map);

    /**
    * getSuppFieldValues
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param field_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_supp_field_values - Type: ArrayList&#60;AcctSuppFieldValuesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSuppFieldValues(Long client_no, String auth_key, Long acct_no, String field_name);

    abstract Map<String,Object> getSuppFieldValues(Map<String,Object> map);

    /**
    * getSuppPlansByPromoCode
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param promo_code - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSuppPlansByPromoCode(Long client_no, String auth_key, String promo_code);

    abstract Map<String,Object> getSuppPlansByPromoCode(Map<String,Object> map);

    /**
    * getSuppPlansByPromoCodeAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param promo_code - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_plans - Type: ArrayList&#60;AllPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSuppPlansByPromoCodeAll(Long client_no, String auth_key, String promo_code);

    abstract Map<String,Object> getSuppPlansByPromoCodeAll(Map<String,Object> map);

    /**
    * getUnappliedServiceCredits
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   unapplied_service_credits - Type: ArrayList&#60;UnappliedServiceCreditsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getUnappliedServiceCredits(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getUnappliedServiceCredits(Map<String,Object> map);

    /**
    * getUnbilledUsageSummary
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param usage_details_flag - Type: String
    * @param include_all_usage_unit_thresholds - Type: String
    * @param plan_no - Type: Long
    * @param usage_type_no - Type: Long
    * @param usage_type_code - Type: String
    * @param retrieve_excluded_usage - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    *   currency_name - Type: javax.xml.ws.Holder<br>
    *   acct_mtd_threshold_amount - Type: javax.xml.ws.Holder<br>
    *   acct_ptd_threshold_amount - Type: javax.xml.ws.Holder<br>
    *   client_mtd_threshold_amount - Type: javax.xml.ws.Holder<br>
    *   client_ptd_threshold_amount - Type: javax.xml.ws.Holder<br>
    *   mtd_balance_amount - Type: javax.xml.ws.Holder<br>
    *   ptd_balance_amount - Type: javax.xml.ws.Holder<br>
    *   acct_mtd_delta_sign - Type: javax.xml.ws.Holder<br>
    *   acct_mtd_delta_amount - Type: javax.xml.ws.Holder<br>
    *   acct_ptd_delta_sign - Type: javax.xml.ws.Holder<br>
    *   acct_ptd_delta_amount - Type: javax.xml.ws.Holder<br>
    *   client_mtd_delta_sign - Type: javax.xml.ws.Holder<br>
    *   client_mtd_delta_amount - Type: javax.xml.ws.Holder<br>
    *   client_ptd_delta_sign - Type: javax.xml.ws.Holder<br>
    *   client_ptd_delta_amount - Type: javax.xml.ws.Holder<br>
    *   unapp_svc_credit_bal_amount - Type: javax.xml.ws.Holder<br>
    *   unapp_svc_credit_delta_sign - Type: javax.xml.ws.Holder<br>
    *   unapp_svc_credit_delta_amount - Type: javax.xml.ws.Holder<br>
    *   unbilled_usage_recs - Type: ArrayList&#60;UnbilledUsageRecsReturnElement&#62;<br>
    *   unit_threshold_details - Type: ArrayList&#60;UnitThresholdDetailsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getUnbilledUsageSummary(Long client_no, String auth_key, Long acct_no, String usage_details_flag, String include_all_usage_unit_thresholds, Long plan_no, Long usage_type_no, String usage_type_code, String retrieve_excluded_usage);

    abstract Map<String,Object> getUnbilledUsageSummary(Map<String,Object> map);

    /**
    * getUsageHistory
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param specified_usage_type_no - Type: Long
    * @param date_range_start - Type: String
    * @param date_range_end - Type: String
    * @param specified_usage_type_code - Type: String
    * @param usage_qualifier_1 - Type: com.aria.common.shared.UsageQualifier1Array
    * @param usage_qualifier_2 - Type: com.aria.common.shared.UsageQualifier2Array
    * @param usage_qualifier_3 - Type: com.aria.common.shared.UsageQualifier3Array
    * @param usage_qualifier_4 - Type: com.aria.common.shared.UsageQualifier4Array
    * @param limit - Type: Long
    * @param offset - Type: Long
    * @param transaction_id - Type: Long
    * @param invoice_no - Type: Long
    * @param invoice_line_item - Type: Long
    * @param retrieve_excluded_usage - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_history_records - Type: ArrayList&#60;UsageHistoryRecordsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getUsageHistory(Long client_no, String auth_key, Long acct_no, Long specified_usage_type_no, String date_range_start, String date_range_end, String specified_usage_type_code, com.aria.common.shared.UsageQualifier1Array usage_qualifier_1, com.aria.common.shared.UsageQualifier2Array usage_qualifier_2, com.aria.common.shared.UsageQualifier3Array usage_qualifier_3, com.aria.common.shared.UsageQualifier4Array usage_qualifier_4, Long limit, Long offset, Long transaction_id, Long invoice_no, Long invoice_line_item, String retrieve_excluded_usage);

    abstract Map<String,Object> getUsageHistory(Map<String,Object> map);

    /**
    * getUsageSummaryByType
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param user_id - Type: String
    * @param usage_type_filter - Type: Long
    * @param date_filter_start_date - Type: String
    * @param date_filter_start_time - Type: String
    * @param date_filter_end_date - Type: String
    * @param date_filter_end_time - Type: String
    * @param billed_filter - Type: Long
    * @param billing_period_flag - Type: Long
    * @param usage_qualifier_1 - Type: com.aria.common.shared.UsageQualifier1Array
    * @param usage_qualifier_2 - Type: com.aria.common.shared.UsageQualifier2Array
    * @param usage_qualifier_3 - Type: com.aria.common.shared.UsageQualifier3Array
    * @param usage_qualifier_4 - Type: com.aria.common.shared.UsageQualifier4Array
    * @param usage_type_cd_filter - Type: String
    * @param retrieve_excluded_usage - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   start_date - Type: javax.xml.ws.Holder<br>
    *   start_time - Type: javax.xml.ws.Holder<br>
    *   end_date - Type: javax.xml.ws.Holder<br>
    *   end_time - Type: javax.xml.ws.Holder<br>
    *   usage_summary_records - Type: ArrayList&#60;UsageSummaryRecordsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getUsageSummaryByType(Long client_no, String auth_key, Long acct_no, String user_id, Long usage_type_filter, String date_filter_start_date, String date_filter_start_time, String date_filter_end_date, String date_filter_end_time, Long billed_filter, Long billing_period_flag, com.aria.common.shared.UsageQualifier1Array usage_qualifier_1, com.aria.common.shared.UsageQualifier2Array usage_qualifier_2, com.aria.common.shared.UsageQualifier3Array usage_qualifier_3, com.aria.common.shared.UsageQualifier4Array usage_qualifier_4, String usage_type_cd_filter, String retrieve_excluded_usage);

    abstract Map<String,Object> getUsageSummaryByType(Map<String,Object> map);

    /**
    * getUserIdFromAcctNo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   user_id - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getUserIdFromAcctNo(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> getUserIdFromAcctNo(Map<String,Object> map);

    /**
    * getUseridHasOrderedSku
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @param sku - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   acct_no - Type: javax.xml.ws.Holder<br>
    *   ordered_ind - Type: javax.xml.ws.Holder<br>
    *   billed_ind - Type: javax.xml.ws.Holder<br>
    *   paid_ind - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getUseridHasOrderedSku(Long client_no, String auth_key, String user_id, String sku);

    abstract Map<String,Object> getUseridHasOrderedSku(Map<String,Object> map);

    /**
    * modifyAcctMultiplanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param contract_no - Type: Long
    * @param type_no - Type: Long
    * @param length_months - Type: Long
    * @param start_date - Type: String
    * @param update_comments - Type: String
    * @param modify_directive - Type: Long
    * @param plans_input - Type: com.aria.common.shared.PlansInputArray
    * @param end_date - Type: String
    * @param client_plan_id - Type: com.aria.common.shared.ClientPlanIdArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> modifyAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, Long type_no, Long length_months, String start_date, String update_comments, Long modify_directive, com.aria.common.shared.PlansInputArray plans_input, String end_date, com.aria.common.shared.ClientPlanIdArray client_plan_id);

    abstract Map<String,Object> modifyAcctMultiplanContract(Map<String,Object> map);

    /**
    * modifyAcctPlanContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param contract_no - Type: Long
    * @param type_no - Type: Long
    * @param alt_recur_fee - Type: Double
    * @param length_months - Type: Long
    * @param cancel_fee - Type: Double
    * @param start_date - Type: String
    * @param update_comments - Type: String
    * @param end_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> modifyAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, Long type_no, Double alt_recur_fee, Long length_months, Double cancel_fee, String start_date, String update_comments, String end_date);

    abstract Map<String,Object> modifyAcctPlanContract(Map<String,Object> map);

    /**
    * modifyAcctPlanUnitInstances
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param plan_units - Type: com.aria.common.shared.PlanUnitsArray
    * @param new_client_plan_unit_inst - Type: com.aria.common.shared.NewClientPlanUnitInstArray
    * @param do_write - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   supp_plan_line_items - Type: ArrayList&#60;SuppPlanLineItemsReturnElement&#62;<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   proration_credit_result_amount - Type: javax.xml.ws.Holder<br>
    *   proration_credit_amount - Type: javax.xml.ws.Holder<br>
    *   proration_tax_amount - Type: javax.xml.ws.Holder<br>
    *   expectd_activation_fee - Type: javax.xml.ws.Holder<br>
    *   expectd_mthly_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annu_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> modifyAcctPlanUnitInstances(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.PlanUnitsArray plan_units, com.aria.common.shared.NewClientPlanUnitInstArray new_client_plan_unit_inst, String do_write);

    abstract Map<String,Object> modifyAcctPlanUnitInstances(Map<String,Object> map);

    /**
    * modifyAcctSuppFields
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param acct_supp_fields - Type: com.aria.common.shared.AcctSuppFieldsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> modifyAcctSuppFields(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.AcctSuppFieldsArray acct_supp_fields);

    abstract Map<String,Object> modifyAcctSuppFields(Map<String,Object> map);

    /**
    * modifyAcctUniversalContract
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param contract_no - Type: Long
    * @param type_no - Type: Long
    * @param length_months - Type: Long
    * @param start_date - Type: String
    * @param update_comments - Type: String
    * @param end_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> modifyAcctUniversalContract(Long client_no, String auth_key, Long acct_no, Long contract_no, Long type_no, Long length_months, String start_date, String update_comments, String end_date);

    abstract Map<String,Object> modifyAcctUniversalContract(Map<String,Object> map);

    /**
    * modifySuppPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param supp_plan_no - Type: Long
    * @param alt_rate_schedule_no - Type: Long
    * @param num_plan_units - Type: Long
    * @param coupon_code - Type: String
    * @param assignment_directive - Type: Long
    * @param comments - Type: String
    * @param do_write - Type: String
    * @param client_receipt_id - Type: String
    * @param new_acct_custom_rates - Type: com.aria.common.shared.NewAcctCustomRatesArray
    * @param effective_date - Type: String
    * @param offset_interval - Type: Long
    * @param client_plan_id - Type: String
    * @param client_alt_rate_schedule_id - Type: String
    * @param surcharge_no - Type: com.aria.common.shared.SurchargeNoArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   supp_plan_line_items - Type: ArrayList&#60;SuppPlanLineItemsReturnElement&#62;<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   proration_credit_result_amount - Type: javax.xml.ws.Holder<br>
    *   proration_credit_amount - Type: javax.xml.ws.Holder<br>
    *   proration_tax_amount - Type: javax.xml.ws.Holder<br>
    *   expectd_activation_fee - Type: javax.xml.ws.Holder<br>
    *   expectd_mthly_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annu_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> modifySuppPlan(Long client_no, String auth_key, Long acct_no, Long supp_plan_no, Long alt_rate_schedule_no, Long num_plan_units, String coupon_code, Long assignment_directive, String comments, String do_write, String client_receipt_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String client_plan_id, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no);

    abstract Map<String,Object> modifySuppPlan(Map<String,Object> map);

    /**
    * recordStandingUsage
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param usage_type - Type: Long
    * @param usage_type_code - Type: String
    * @param usage_units - Type: Double
    * @param next_usage_date - Type: String
    * @param alt_desc - Type: String
    * @param plan_no - Type: Long
    * @param first_usage_date - Type: String
    * @param recurring_ind - Type: String
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> recordStandingUsage(Long client_no, String auth_key, Long acct_no, Long usage_type, String usage_type_code, Double usage_units, String next_usage_date, String alt_desc, Long plan_no, String first_usage_date, String recurring_ind, String client_plan_id);

    abstract Map<String,Object> recordStandingUsage(Map<String,Object> map);

    /**
    * removeAcctFromGroup
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param group_no - Type: Long
    * @param client_acct_group_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> removeAcctFromGroup(Long client_no, String auth_key, Long acct_no, Long group_no, String client_acct_group_id);

    abstract Map<String,Object> removeAcctFromGroup(Map<String,Object> map);

    /**
    * removeCustomAcctRates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param plan_no - Type: Long
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> removeCustomAcctRates(Long client_no, String auth_key, Long acct_no, Long plan_no, String client_plan_id);

    abstract Map<String,Object> removeCustomAcctRates(Map<String,Object> map);

    /**
    * removePayMethod
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param primary_or_bkup_pay_mthd_ind - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> removePayMethod(Long client_no, String auth_key, Long acct_no, Long primary_or_bkup_pay_mthd_ind);

    abstract Map<String,Object> removePayMethod(Map<String,Object> map);

    /**
    * replaceSuppPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param existing_supp_plan_no - Type: Long
    * @param new_supp_plan_no - Type: Long
    * @param alt_rate_schedule_no - Type: Long
    * @param num_plan_units - Type: Long
    * @param coupon_code - Type: String
    * @param assignment_directive - Type: Long
    * @param comments - Type: String
    * @param do_write - Type: String
    * @param client_receipt_id - Type: String
    * @param offset_months - Type: Long
    * @param auto_offset_months_option - Type: Long
    * @param alt_client_acct_group_id - Type: String
    * @param new_acct_custom_rates - Type: com.aria.common.shared.NewAcctCustomRatesArray
    * @param effective_date - Type: String
    * @param offset_interval - Type: Long
    * @param invoice_unbilled_usage - Type: String
    * @param sync_mstr_bill_dates_override - Type: Long
    * @param client_existing_supp_plan_id - Type: String
    * @param client_new_supp_plan_id - Type: String
    * @param client_alt_rate_schedule_id - Type: String
    * @param surcharge_no - Type: com.aria.common.shared.SurchargeNoArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   supp_plan_line_items - Type: ArrayList&#60;SuppPlanLineItemsReturnElement&#62;<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   proration_credit_result_amount - Type: javax.xml.ws.Holder<br>
    *   proration_credit_amount - Type: javax.xml.ws.Holder<br>
    *   proration_tax_amount - Type: javax.xml.ws.Holder<br>
    *   expectd_activation_fee - Type: javax.xml.ws.Holder<br>
    *   expectd_mthly_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annu_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> replaceSuppPlan(Long client_no, String auth_key, Long acct_no, Long existing_supp_plan_no, Long new_supp_plan_no, Long alt_rate_schedule_no, Long num_plan_units, String coupon_code, Long assignment_directive, String comments, String do_write, String client_receipt_id, Long offset_months, Long auto_offset_months_option, String alt_client_acct_group_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String invoice_unbilled_usage, Long sync_mstr_bill_dates_override, String client_existing_supp_plan_id, String client_new_supp_plan_id, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no);

    abstract Map<String,Object> replaceSuppPlan(Map<String,Object> map);

    /**
    * resetUsgMtdBal
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> resetUsgMtdBal(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> resetUsgMtdBal(Map<String,Object> map);

    /**
    * resetUsgPtdBal
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> resetUsgPtdBal(Long client_no, String auth_key, Long acct_no);

    abstract Map<String,Object> resetUsgPtdBal(Map<String,Object> map);

    /**
    * sendAcctEmail
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @param template_class - Type: String
    * @param template_no - Type: Long
    * @param client_receipt_id - Type: String
    * @param client_template_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> sendAcctEmail(Long client_no, String auth_key, String user_id, String template_class, Long template_no, String client_receipt_id, String client_template_id);

    abstract Map<String,Object> sendAcctEmail(Map<String,Object> map);

    /**
    * sendAcctStatementEmail
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param statement_no - Type: Long
    * @param sequential_statement_no - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> sendAcctStatementEmail(Long client_no, String auth_key, Long acct_no, Long statement_no, String sequential_statement_no);

    abstract Map<String,Object> sendAcctStatementEmail(Map<String,Object> map);

    /**
    * sendArcThresholdEmail
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param resource_threshold_level - Type: Long
    * @param resource_balance - Type: Long
    * @param resource_name - Type: String
    * @param resource_units_label - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> sendArcThresholdEmail(Long client_no, String auth_key, Long acct_no, Long resource_threshold_level, Long resource_balance, String resource_name, String resource_units_label);

    abstract Map<String,Object> sendArcThresholdEmail(Map<String,Object> map);

    /**
    * setAcctNotifyOverride
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param acct_user_id - Type: String
    * @param client_acct_id - Type: String
    * @param template_class - Type: String
    * @param override_template_no - Type: Long
    * @param behavioral_option - Type: Long
    * @param override_template_option - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setAcctNotifyOverride(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id, String template_class, Long override_template_no, Long behavioral_option, Long override_template_option);

    abstract Map<String,Object> setAcctNotifyOverride(Map<String,Object> map);

    /**
    * setAcctNotifyTmpltGrp
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param acct_user_id - Type: String
    * @param client_acct_id - Type: String
    * @param notification_template_group_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setAcctNotifyTmpltGrp(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id, String notification_template_group_id);

    abstract Map<String,Object> setAcctNotifyTmpltGrp(Map<String,Object> map);

    /**
    * setAcctTaxExemptStatus
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param exemption_level - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setAcctTaxExemptStatus(Long client_no, String auth_key, Long acct_no, Long exemption_level);

    abstract Map<String,Object> setAcctTaxExemptStatus(Map<String,Object> map);

    /**
    * setAcctUsgDailyThreshold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param usage_unit_thresholds - Type: com.aria.common.shared.UsageUnitThresholdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setAcctUsgDailyThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds);

    abstract Map<String,Object> setAcctUsgDailyThreshold(Map<String,Object> map);

    /**
    * setAcctUsgMtdThreshold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param usage_unit_thresholds - Type: com.aria.common.shared.UsageUnitThresholdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setAcctUsgMtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds);

    abstract Map<String,Object> setAcctUsgMtdThreshold(Map<String,Object> map);

    /**
    * setAcctUsgPtdThreshold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param usage_unit_thresholds - Type: com.aria.common.shared.UsageUnitThresholdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setAcctUsgPtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds);

    abstract Map<String,Object> setAcctUsgPtdThreshold(Map<String,Object> map);

    /**
    * setClientUsgDailyThreshold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param usage_unit_thresholds - Type: com.aria.common.shared.UsageUnitThresholdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setClientUsgDailyThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds);

    abstract Map<String,Object> setClientUsgDailyThreshold(Map<String,Object> map);

    /**
    * setClientUsgMtdThreshold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param usage_unit_thresholds - Type: com.aria.common.shared.UsageUnitThresholdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setClientUsgMtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds);

    abstract Map<String,Object> setClientUsgMtdThreshold(Map<String,Object> map);

    /**
    * setClientUsgPtdThreshold
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param amount - Type: Double
    * @param usage_unit_thresholds - Type: com.aria.common.shared.UsageUnitThresholdsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setClientUsgPtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds);

    abstract Map<String,Object> setClientUsgPtdThreshold(Map<String,Object> map);

    /**
    * setPayMethodBankDraft
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param do_collect - Type: String
    * @param change_status_after_coll - Type: String
    * @param reset_dates_after_status - Type: String
    * @param bank_acct_type - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setPayMethodBankDraft(Long client_no, String auth_key, Long account_no, String bank_routing_num, String bank_acct_num, String do_collect, String change_status_after_coll, String reset_dates_after_status, String bank_acct_type, String client_receipt_id);

    abstract Map<String,Object> setPayMethodBankDraft(Map<String,Object> map);

    /**
    * setPayMethodCc
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param do_collect - Type: String
    * @param change_status_after_coll - Type: String
    * @param reset_dates_after_status - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setPayMethodCc(Long client_no, String auth_key, Long account_no, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String do_collect, String change_status_after_coll, String reset_dates_after_status, String client_receipt_id);

    abstract Map<String,Object> setPayMethodCc(Map<String,Object> map);

    /**
    * setPayMethodNetTerms
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param pay_method - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setPayMethodNetTerms(Long client_no, String auth_key, Long account_no, Long pay_method);

    abstract Map<String,Object> setPayMethodNetTerms(Map<String,Object> map);

    /**
    * setPaymentResponsibility
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param resp_level_cd - Type: Long
    * @param senior_account_no - Type: Long
    * @param senior_acct_user_id - Type: String
    * @param client_senior_acct_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setPaymentResponsibility(Long client_no, String auth_key, Long account_no, Long resp_level_cd, Long senior_account_no, String senior_acct_user_id, String client_senior_acct_id);

    abstract Map<String,Object> setPaymentResponsibility(Map<String,Object> map);

    /**
    * setServicePlanImmediately
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param plan_no - Type: Long
    * @param client_receipt_id - Type: String
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setServicePlanImmediately(Long client_no, String auth_key, Long account_no, Long plan_no, String client_receipt_id, String client_plan_id);

    abstract Map<String,Object> setServicePlanImmediately(Map<String,Object> map);

    /**
    * toggleTestAccount
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param test_acct_ind - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> toggleTestAccount(Long client_no, String auth_key, Long account_no, Long test_acct_ind);

    abstract Map<String,Object> toggleTestAccount(Map<String,Object> map);

    /**
    * updateAcctBillingContact
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param first_name - Type: String
    * @param last_name - Type: String
    * @param middle_initial - Type: String
    * @param company_name - Type: String
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param locality - Type: String
    * @param state - Type: String
    * @param country - Type: String
    * @param zip - Type: String
    * @param intl_phone - Type: String
    * @param email - Type: String
    * @param do_collect - Type: String
    * @param change_status_after_coll - Type: String
    * @param reset_dates_after_status - Type: String
    * @param address3 - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctBillingContact(Long client_no, String auth_key, Long account_no, String first_name, String last_name, String middle_initial, String company_name, String address1, String address2, String city, String locality, String state, String country, String zip, String intl_phone, String email, String do_collect, String change_status_after_coll, String reset_dates_after_status, String address3, String client_receipt_id);

    abstract Map<String,Object> updateAcctBillingContact(Map<String,Object> map);

    /**
    * updateAcctComplete
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param first_name - Type: String
    * @param last_name - Type: String
    * @param middle_initial - Type: String
    * @param company_name - Type: String
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param locality - Type: String
    * @param state_prov - Type: String
    * @param country - Type: String
    * @param postal_cd - Type: String
    * @param phone - Type: String
    * @param phone_ext - Type: String
    * @param cell_phone - Type: String
    * @param work_phone - Type: String
    * @param work_phone_ext - Type: String
    * @param email - Type: String
    * @param birthdate - Type: String
    * @param bill_first_name - Type: String
    * @param bill_last_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_company_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_country - Type: String
    * @param bill_postal_cd - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_ext - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_ext - Type: String
    * @param bill_email - Type: String
    * @param pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param master_plan_no - Type: Long
    * @param master_plan_alt_rate_sched_no - Type: Long
    * @param master_plan_units - Type: Long
    * @param master_plan_assign_directive - Type: Long
    * @param update_acct_supp_field - Type: com.aria.common.shared.UpdateAcctSuppFieldArray
    * @param update_acct_func_group - Type: com.aria.common.shared.UpdateAcctFuncGroupArray
    * @param update_acct_coll_group - Type: com.aria.common.shared.UpdateAcctCollGroupArray
    * @param status_cd - Type: Long
    * @param notify_method - Type: Long
    * @param password - Type: String
    * @param secret_question - Type: String
    * @param secret_question_answer - Type: String
    * @param pin - Type: String
    * @param test_acct_ind - Type: Long
    * @param resp_level_cd - Type: Long
    * @param senior_acct_no - Type: Long
    * @param senior_acct_user_id - Type: String
    * @param client_senior_acct_id - Type: String
    * @param client_acct_id - Type: String
    * @param do_collect - Type: String
    * @param change_status_after_coll - Type: String
    * @param reset_dates_after_status - Type: String
    * @param client_receipt_id - Type: String
    * @param alt_do_dunning - Type: String
    * @param force_currency_change - Type: String
    * @param cvv - Type: String
    * @param taxpayer_id - Type: String
    * @param bill_agreement_id - Type: String
    * @param auto_cancel_supp_plans - Type: String
    * @param offset_months - Type: Long
    * @param alt_proration_start_date - Type: String
    * @param alt_msg_template_no - Type: Long
    * @param seq_func_group_no - Type: Long
    * @param bank_acct_type - Type: String
    * @param address3 - Type: String
    * @param bill_address3 - Type: String
    * @param usage_accumulation_config - Type: com.aria.common.shared.UsageAccumulationConfigArray
    * @param enable_usage_pooling_plan_no - Type: com.aria.common.shared.EnableUsagePoolingPlanNoArray
    * @param disable_usage_pooling_plan_no - Type: com.aria.common.shared.DisableUsagePoolingPlanNoArray
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param offset_interval - Type: Long
    * @param tax_exemption_level - Type: Long
    * @param cn_alt_msg_template_no - Type: Long
    * @param promo_cd - Type: String
    * @param invoice_unbilled_usage - Type: String
    * @param coupon_code - Type: String
    * @param userid - Type: String
    * @param invoice_approval_required - Type: String
    * @param client_master_plan_id - Type: String
    * @param client_mp_alt_rate_sched_id - Type: String
    * @param client_alt_msg_template_id - Type: String
    * @param client_cn_alt_msg_template_id - Type: String
    * @param update_surcharge - Type: com.aria.common.shared.UpdateSurchargeArray
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param bkup_bill_first_name - Type: String
    * @param bkup_bill_mi - Type: String
    * @param bkup_bill_last_name - Type: String
    * @param bkup_bill_company_name - Type: String
    * @param bkup_bill_address1 - Type: String
    * @param bkup_bill_address2 - Type: String
    * @param bkup_bill_address3 - Type: String
    * @param bkup_bill_city - Type: String
    * @param bkup_bill_locality - Type: String
    * @param bkup_bill_state_prov - Type: String
    * @param bkup_bill_country - Type: String
    * @param bkup_bill_postal_cd - Type: String
    * @param bkup_bill_phone - Type: String
    * @param bkup_bill_phone_ext - Type: String
    * @param bkup_bill_cell_phone - Type: String
    * @param bkup_bill_work_phone - Type: String
    * @param bkup_bill_work_phone_ext - Type: String
    * @param bkup_bill_email - Type: String
    * @param bkup_pay_method - Type: Long
    * @param bkup_cc_number - Type: String
    * @param bkup_cc_expire_mm - Type: Long
    * @param bkup_cc_expire_yyyy - Type: Long
    * @param bkup_bank_acct_no - Type: String
    * @param bkup_bank_routing_no - Type: String
    * @param bkup_bank_acct_type - Type: String
    * @param bkup_bill_agreement_id - Type: String
    * @param bkup_cvv - Type: String
    * @param seq_func_group_id - Type: String
    * @param revrec_profile_id - Type: Long
    * @param revrec_client_defined_id - Type: String
    * @param stmnt_email_list_cc - Type: String
    * @param stmnt_email_list_bcc - Type: String
    * @param invoice_posting_method_cd - Type: Long
    * @param acct_start_date - Type: String
    * @param min_statement_threshold - Type: Long
    * @param max_statements_to_defer - Type: Long
    * @param defer_full_statements_only - Type: Long
    * @param cc_id - Type: Long
    * @param bkup_cc_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   parent_child_sync_error_code - Type: javax.xml.ws.Holder<br>
    *   parent_child_sync_error_msg - Type: javax.xml.ws.Holder<br>
    *   master_plan_error_code - Type: javax.xml.ws.Holder<br>
    *   master_plan_error_msg - Type: javax.xml.ws.Holder<br>
    *   master_plan_coll_error_code - Type: javax.xml.ws.Holder<br>
    *   master_plan_coll_error_msg - Type: javax.xml.ws.Holder<br>
    *   master_plan_stmt_error_code - Type: javax.xml.ws.Holder<br>
    *   master_plan_stmt_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   cancelled_supp_plans - Type: ArrayList&#60;CancelledSuppPlansReturnElement&#62;<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> updateAcctComplete(Long client_no, String auth_key, Long acct_no, String first_name, String last_name, String middle_initial, String company_name, String address1, String address2, String city, String locality, String state_prov, String country, String postal_cd, String phone, String phone_ext, String cell_phone, String work_phone, String work_phone_ext, String email, String birthdate, String bill_first_name, String bill_last_name, String bill_middle_initial, String bill_company_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_country, String bill_postal_cd, String bill_phone, String bill_phone_ext, String bill_cell_phone, String bill_work_phone, String bill_work_phone_ext, String bill_email, Long pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, Long master_plan_no, Long master_plan_alt_rate_sched_no, Long master_plan_units, Long master_plan_assign_directive, com.aria.common.shared.UpdateAcctSuppFieldArray update_acct_supp_field, com.aria.common.shared.UpdateAcctFuncGroupArray update_acct_func_group, com.aria.common.shared.UpdateAcctCollGroupArray update_acct_coll_group, Long status_cd, Long notify_method, String password, String secret_question, String secret_question_answer, String pin, Long test_acct_ind, Long resp_level_cd, Long senior_acct_no, String senior_acct_user_id, String client_senior_acct_id, String client_acct_id, String do_collect, String change_status_after_coll, String reset_dates_after_status, String client_receipt_id, String alt_do_dunning, String force_currency_change, String cvv, String taxpayer_id, String bill_agreement_id, String auto_cancel_supp_plans, Long offset_months, String alt_proration_start_date, Long alt_msg_template_no, Long seq_func_group_no, String bank_acct_type, String address3, String bill_address3, com.aria.common.shared.UsageAccumulationConfigArray usage_accumulation_config, com.aria.common.shared.EnableUsagePoolingPlanNoArray enable_usage_pooling_plan_no, com.aria.common.shared.DisableUsagePoolingPlanNoArray disable_usage_pooling_plan_no, String alt_client_acct_group_id, String track_data1, String track_data2, Long offset_interval, Long tax_exemption_level, Long cn_alt_msg_template_no, String promo_cd, String invoice_unbilled_usage, String coupon_code, String userid, String invoice_approval_required, String client_master_plan_id, String client_mp_alt_rate_sched_id, String client_alt_msg_template_id, String client_cn_alt_msg_template_id, com.aria.common.shared.UpdateSurchargeArray update_surcharge, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String bkup_bill_first_name, String bkup_bill_mi, String bkup_bill_last_name, String bkup_bill_company_name, String bkup_bill_address1, String bkup_bill_address2, String bkup_bill_address3, String bkup_bill_city, String bkup_bill_locality, String bkup_bill_state_prov, String bkup_bill_country, String bkup_bill_postal_cd, String bkup_bill_phone, String bkup_bill_phone_ext, String bkup_bill_cell_phone, String bkup_bill_work_phone, String bkup_bill_work_phone_ext, String bkup_bill_email, Long bkup_pay_method, String bkup_cc_number, Long bkup_cc_expire_mm, Long bkup_cc_expire_yyyy, String bkup_bank_acct_no, String bkup_bank_routing_no, String bkup_bank_acct_type, String bkup_bill_agreement_id, String bkup_cvv, String seq_func_group_id, Long revrec_profile_id, String revrec_client_defined_id, String stmnt_email_list_cc, String stmnt_email_list_bcc, Long invoice_posting_method_cd, String acct_start_date, Long min_statement_threshold, Long max_statements_to_defer, Long defer_full_statements_only, Long cc_id, Long bkup_cc_id);

    abstract Map<String,Object> updateAcctComplete(Map<String,Object> map);

    /**
    * updateAcctContact
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param first_name - Type: String
    * @param last_name - Type: String
    * @param mi - Type: String
    * @param company_name - Type: String
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param locality - Type: String
    * @param state_prov - Type: String
    * @param country - Type: String
    * @param postal_code - Type: String
    * @param intl_phone - Type: String
    * @param alt_email - Type: String
    * @param birthdate - Type: String
    * @param address3 - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctContact(Long client_no, String auth_key, Long account_no, String first_name, String last_name, String mi, String company_name, String address1, String address2, String city, String locality, String state_prov, String country, String postal_code, String intl_phone, String alt_email, String birthdate, String address3);

    abstract Map<String,Object> updateAcctContact(Map<String,Object> map);

    /**
    * updateAcctCredentials
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param password - Type: String
    * @param secret_question_answer - Type: String
    * @param secret_question - Type: String
    * @param pin - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctCredentials(Long client_no, String auth_key, Long account_no, String password, String secret_question_answer, String secret_question, String pin);

    abstract Map<String,Object> updateAcctCredentials(Map<String,Object> map);

    /**
    * updateAcctNotifyMethod
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param notify_method - Type: Long
    * @param list_start_master_file - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctNotifyMethod(Long client_no, String auth_key, Long account_no, Long notify_method, Long list_start_master_file);

    abstract Map<String,Object> updateAcctNotifyMethod(Map<String,Object> map);

    /**
    * updateAcctPlanUnitInstance
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param client_acct_id - Type: String
    * @param plan_unit_inst_no - Type: Long
    * @param client_plan_unit_inst_id - Type: String
    * @param new_client_plan_unit_inst_id - Type: String
    * @param plan_unit_inst_services - Type: com.aria.common.shared.PlanUnitInstServicesArray
    * @param plan_unit_inst_fields - Type: com.aria.common.shared.PlanUnitInstFieldsArray
    * @param do_write - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   out_acct_no - Type: javax.xml.ws.Holder<br>
    *   out_client_acct_id - Type: javax.xml.ws.Holder<br>
    *   out_plan_unit_inst_no - Type: javax.xml.ws.Holder<br>
    *   out_client_plan_unit_inst_id - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   invoice_line_items - Type: ArrayList&#60;InvoiceLineItemsReturnElement&#62;<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_code - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   expectd_monthly_rec_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annual_rec_cost - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> updateAcctPlanUnitInstance(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long plan_unit_inst_no, String client_plan_unit_inst_id, String new_client_plan_unit_inst_id, com.aria.common.shared.PlanUnitInstServicesArray plan_unit_inst_services, com.aria.common.shared.PlanUnitInstFieldsArray plan_unit_inst_fields, String do_write);

    abstract Map<String,Object> updateAcctPlanUnitInstance(Map<String,Object> map);

    /**
    * updateAcctStatus
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param status_cd - Type: Long
    * @param queue_days - Type: Long
    * @param queue_date - Type: String
    * @param force_bill_date_reset - Type: Long
    * @param comments - Type: String
    * @param client_receipt_id - Type: String
    * @param alt_do_dunning - Type: String
    * @param status_degrade_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctStatus(Long client_no, String auth_key, Long account_no, Long status_cd, Long queue_days, String queue_date, Long force_bill_date_reset, String comments, String client_receipt_id, String alt_do_dunning, String status_degrade_date);

    abstract Map<String,Object> updateAcctStatus(Map<String,Object> map);

    /**
    * updateAcctSuppFields
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param field_name - Type: String
    * @param value_text - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateAcctSuppFields(Long client_no, String auth_key, Long account_no, String field_name, String value_text);

    abstract Map<String,Object> updateAcctSuppFields(Map<String,Object> map);

    /**
    * updateExistingBillingInfo
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param seq_no - Type: Long
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param state - Type: String
    * @param zip - Type: String
    * @param country - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param phone_npa - Type: Long
    * @param phone_nxx - Type: Long
    * @param phone_suffix - Type: String
    * @param phone_ext - Type: String
    * @param phone_country_cd - Type: String
    * @param intl_phone - Type: String
    * @param email - Type: String
    * @param locality - Type: String
    * @param cell_phone_npa - Type: Long
    * @param cell_phone_nxx - Type: Long
    * @param cell_phone_suffix - Type: String
    * @param work_phone_npa - Type: Long
    * @param work_phone_nxx - Type: Long
    * @param work_phone_suffix - Type: String
    * @param work_phone_ext - Type: String
    * @param do_collect - Type: String
    * @param change_status_after_coll - Type: String
    * @param reset_dates_after_status - Type: String
    * @param address3 - Type: String
    * @param client_receipt_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateExistingBillingInfo(Long client_no, String auth_key, Long acct_no, Long seq_no, String address1, String address2, String city, String state, String zip, String country, Long cc_expire_mm, Long cc_expire_yyyy, Long phone_npa, Long phone_nxx, String phone_suffix, String phone_ext, String phone_country_cd, String intl_phone, String email, String locality, Long cell_phone_npa, Long cell_phone_nxx, String cell_phone_suffix, Long work_phone_npa, Long work_phone_nxx, String work_phone_suffix, String work_phone_ext, String do_collect, String change_status_after_coll, String reset_dates_after_status, String address3, String client_receipt_id);

    abstract Map<String,Object> updateExistingBillingInfo(Map<String,Object> map);

    /**
    * updateMasterPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param master_plan_no - Type: Long
    * @param alt_rate_schedule_no - Type: Long
    * @param num_plan_units - Type: Long
    * @param assignment_directive - Type: Long
    * @param do_write - Type: String
    * @param client_receipt_id - Type: String
    * @param force_currency_change - Type: String
    * @param auto_cancel_supp_plans - Type: String
    * @param offset_months - Type: Long
    * @param alt_proration_start_date - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param new_acct_custom_rates - Type: com.aria.common.shared.NewAcctCustomRatesArray
    * @param effective_date - Type: String
    * @param offset_interval - Type: Long
    * @param invoice_unbilled_usage - Type: String
    * @param coupon_code - Type: String
    * @param client_master_plan_id - Type: String
    * @param client_alt_rate_schedule_id - Type: String
    * @param surcharge_no - Type: com.aria.common.shared.SurchargeNoArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proration_result_amount - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   statement_error_code - Type: javax.xml.ws.Holder<br>
    *   statement_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    *   invoice_no - Type: javax.xml.ws.Holder<br>
    *   cancelled_supp_plans - Type: ArrayList&#60;CancelledSuppPlansReturnElement&#62;<br>
    *   expectd_activation_fee - Type: javax.xml.ws.Holder<br>
    *   expectd_mthly_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   expectd_annu_recurring_cost - Type: javax.xml.ws.Holder<br>
    *   upd_acct_invoice_line_items - Type: ArrayList&#60;UpdAcctInvoiceLineItemsReturnElement&#62;<br>
    *   total_charges_before_tax - Type: javax.xml.ws.Holder<br>
    *   total_tax_charges - Type: javax.xml.ws.Holder<br>
    *   total_charges_after_tax - Type: javax.xml.ws.Holder<br>
    *   total_credit - Type: javax.xml.ws.Holder<br>
    *   total_tax_credit - Type: javax.xml.ws.Holder<br>
    *   total_credit_before_tax - Type: javax.xml.ws.Holder<br>
    *   total - Type: javax.xml.ws.Holder<br>
    *   third_party_errors - Type: ArrayList&#60;ThirdPartyErrorsReturnElement&#62;<br>
    */
    abstract Map<String,Object> updateMasterPlan(Long client_no, String auth_key, Long acct_no, Long master_plan_no, Long alt_rate_schedule_no, Long num_plan_units, Long assignment_directive, String do_write, String client_receipt_id, String force_currency_change, String auto_cancel_supp_plans, Long offset_months, String alt_proration_start_date, String alt_client_acct_group_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String invoice_unbilled_usage, String coupon_code, String client_master_plan_id, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no);

    abstract Map<String,Object> updateMasterPlan(Map<String,Object> map);

    /**
    * updatePaymentMethod
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_number - Type: Long
    * @param first_name - Type: String
    * @param last_name - Type: String
    * @param middle_initial - Type: String
    * @param company_name - Type: String
    * @param address1 - Type: String
    * @param address2 - Type: String
    * @param city - Type: String
    * @param locality - Type: String
    * @param state - Type: String
    * @param country - Type: String
    * @param zip - Type: String
    * @param intl_phone - Type: String
    * @param phone_npa - Type: String
    * @param phone_nxx - Type: String
    * @param phone_suffix - Type: String
    * @param phone_extension - Type: String
    * @param email - Type: String
    * @param pay_method - Type: String
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bank_routing_num - Type: String
    * @param bank_acct_num - Type: String
    * @param do_collect - Type: String
    * @param change_status_after_coll - Type: String
    * @param reset_dates_after_status - Type: String
    * @param client_receipt_id - Type: String
    * @param bank_acct_type - Type: String
    * @param iban - Type: String
    * @param bank_check_digit - Type: Long
    * @param bank_swift_cd - Type: String
    * @param bank_country_cd - Type: String
    * @param mandate_id - Type: String
    * @param bank_id_cd - Type: String
    * @param bank_branch_cd - Type: String
    * @param primary_or_bkup_pay_method_ind - Type: Long
    * @param ref_bkup_seq_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   seq_no - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   collection_error_code - Type: javax.xml.ws.Holder<br>
    *   collection_error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updatePaymentMethod(Long client_no, String auth_key, Long account_number, String first_name, String last_name, String middle_initial, String company_name, String address1, String address2, String city, String locality, String state, String country, String zip, String intl_phone, String phone_npa, String phone_nxx, String phone_suffix, String phone_extension, String email, String pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String do_collect, String change_status_after_coll, String reset_dates_after_status, String client_receipt_id, String bank_acct_type, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, Long primary_or_bkup_pay_method_ind, Long ref_bkup_seq_no);

    abstract Map<String,Object> updatePaymentMethod(Map<String,Object> map);

    /**
    * useridExists
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> useridExists(Long client_no, String auth_key, String user_id);

    abstract Map<String,Object> useridExists(Map<String,Object> map);

    /**
    * useridIsAvailable
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> useridIsAvailable(Long client_no, String auth_key, String user_id);

    abstract Map<String,Object> useridIsAvailable(Map<String,Object> map);

    /**
    * validatePaymentInformation
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param account_no - Type: Long
    * @param CVV - Type: Long
    * @param seq_no - Type: Long
    * @param inTrackingNumber - Type: String
    * @param inAuthValue - Type: String
    * @param alt_pay_method - Type: Long
    * @param cc_number - Type: String
    * @param cc_expire_mm - Type: Long
    * @param cc_expire_yyyy - Type: Long
    * @param bill_company_name - Type: String
    * @param bill_first_name - Type: String
    * @param bill_middle_initial - Type: String
    * @param bill_last_name - Type: String
    * @param bill_address1 - Type: String
    * @param bill_address2 - Type: String
    * @param bill_city - Type: String
    * @param bill_locality - Type: String
    * @param bill_state_prov - Type: String
    * @param bill_zip - Type: String
    * @param bill_country - Type: String
    * @param bill_email - Type: String
    * @param bill_phone - Type: String
    * @param bill_phone_extension - Type: String
    * @param bill_cell_phone - Type: String
    * @param bill_work_phone - Type: String
    * @param bill_work_phone_extension - Type: String
    * @param currency_cd - Type: String
    * @param acct_group_no - Type: Long
    * @param bill_address3 - Type: String
    * @param alt_client_acct_group_id - Type: String
    * @param track_data1 - Type: String
    * @param track_data2 - Type: String
    * @param client_acct_group_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   proc_cvv_response - Type: javax.xml.ws.Holder<br>
    *   proc_avs_response - Type: javax.xml.ws.Holder<br>
    *   proc_cavv_response - Type: javax.xml.ws.Holder<br>
    *   proc_status_code - Type: javax.xml.ws.Holder<br>
    *   proc_status_text - Type: javax.xml.ws.Holder<br>
    *   proc_payment_id - Type: javax.xml.ws.Holder<br>
    *   proc_auth_code - Type: javax.xml.ws.Holder<br>
    *   proc_merch_comments - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> validatePaymentInformation(Long client_no, String auth_key, Long account_no, Long CVV, Long seq_no, String inTrackingNumber, String inAuthValue, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String currency_cd, Long acct_group_no, String bill_address3, String alt_client_acct_group_id, String track_data1, String track_data2, String client_acct_group_id);

    abstract Map<String,Object> validatePaymentInformation(Map<String,Object> map);

    /**
    * writeAcctComment
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param comment - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> writeAcctComment(Long client_no, String auth_key, Long acct_no, String comment);

    abstract Map<String,Object> writeAcctComment(Map<String,Object> map);

    /**
    * authenticateCaller
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> authenticateCaller(Long client_no, String auth_key);

    abstract Map<String,Object> authenticateCaller(Map<String,Object> map);

    /**
    * keepAlive
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> keepAlive(Long client_no, String auth_key, String session_id);

    abstract Map<String,Object> keepAlive(Map<String,Object> map);

    /**
    * killSession
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> killSession(Long client_no, String auth_key, String session_id);

    abstract Map<String,Object> killSession(Map<String,Object> map);

    /**
    * setSession
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @param acct_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   session_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setSession(Long client_no, String auth_key, String user_id, Long acct_no);

    abstract Map<String,Object> setSession(Map<String,Object> map);

    /**
    * setSessionAuth
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param user_id - Type: String
    * @param password - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   session_id - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setSessionAuth(Long client_no, String auth_key, String user_id, String password);

    abstract Map<String,Object> setSessionAuth(Map<String,Object> map);

    /**
    * validateSession
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   user_id - Type: javax.xml.ws.Holder<br>
    *   account_no - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> validateSession(Long client_no, String auth_key, String session_id);

    abstract Map<String,Object> validateSession(Map<String,Object> map);

    /**
    * advanceVirtualDatetime
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param offset_hours - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   virtual_date - Type: javax.xml.ws.Holder<br>
    *   virtual_time - Type: javax.xml.ws.Holder<br>
    *   system_date - Type: javax.xml.ws.Holder<br>
    *   system_time - Type: javax.xml.ws.Holder<br>
    *   current_offset_hours - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> advanceVirtualDatetime(Long client_no, String auth_key, Long offset_hours);

    abstract Map<String,Object> advanceVirtualDatetime(Map<String,Object> map);

    /**
    * clearRegUssConfigParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param set_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> clearRegUssConfigParams(Long client_no, String auth_key, String set_name);

    abstract Map<String,Object> clearRegUssConfigParams(Map<String,Object> map);

    /**
    * clearRegUssParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> clearRegUssParams(Long client_no, String auth_key, String session_id);

    abstract Map<String,Object> clearRegUssParams(Map<String,Object> map);

    /**
    * clientHasEventClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param class_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   response - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> clientHasEventClass(Long client_no, String auth_key, Long class_no);

    abstract Map<String,Object> clientHasEventClass(Map<String,Object> map);

    /**
    * deleteRegUssConfigParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param set_name - Type: String
    * @param param_names - Type: com.aria.common.shared.ParamNamesArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteRegUssConfigParams(Long client_no, String auth_key, String set_name, com.aria.common.shared.ParamNamesArray param_names);

    abstract Map<String,Object> deleteRegUssConfigParams(Map<String,Object> map);

    /**
    * deleteRegUssParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @param param_names - Type: com.aria.common.shared.ParamNamesArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteRegUssParams(Long client_no, String auth_key, String session_id, com.aria.common.shared.ParamNamesArray param_names);

    abstract Map<String,Object> deleteRegUssParams(Map<String,Object> map);

    /**
    * genRandomString
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param rand_type - Type: String
    * @param rand_length - Type: Long
    * @param rand_case - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   random_string - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> genRandomString(Long client_no, String auth_key, String rand_type, Long rand_length, String rand_case);

    abstract Map<String,Object> genRandomString(Map<String,Object> map);

    /**
    * getAcctSurcharges
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param acct_no - Type: Long
    * @param include_detail_ind - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   all_acct_surcharges - Type: ArrayList&#60;AllAcctSurchargesReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAcctSurcharges(Long client_no, String auth_key, Long acct_no, String include_detail_ind);

    abstract Map<String,Object> getAcctSurcharges(Map<String,Object> map);

    /**
    * getAllClientReceiptIds
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param start_date_range - Type: String
    * @param end_date_range - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   client_receipt - Type: ArrayList&#60;ClientReceiptReturnElement&#62;<br>
    */
    abstract Map<String,Object> getAllClientReceiptIds(Long client_no, String auth_key, String start_date_range, String end_date_range);

    abstract Map<String,Object> getAllClientReceiptIds(Map<String,Object> map);

    /**
    * getAufStatus
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param file_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   status_cd - Type: javax.xml.ws.Holder<br>
    *   load_date_time - Type: javax.xml.ws.Holder<br>
    *   recs_received - Type: javax.xml.ws.Holder<br>
    *   recs_loaded - Type: javax.xml.ws.Holder<br>
    *   recs_failed - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getAufStatus(Long client_no, String auth_key, String file_name);

    abstract Map<String,Object> getAufStatus(Map<String,Object> map);

    /**
    * getChildForItemClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_class_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   child_item_class - Type: ArrayList&#60;ChildItemClassReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getChildForItemClass(Long client_no, String auth_key, Long filter_class_no);

    abstract Map<String,Object> getChildForItemClass(Map<String,Object> map);

    /**
    * getClientCountries
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   client_country - Type: ArrayList&#60;ClientCountryReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientCountries(Long client_no, String auth_key);

    abstract Map<String,Object> getClientCountries(Map<String,Object> map);

    /**
    * getClientCurrencies
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   client_currency - Type: ArrayList&#60;ClientCurrencyReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientCurrencies(Long client_no, String auth_key);

    abstract Map<String,Object> getClientCurrencies(Map<String,Object> map);

    /**
    * getClientItemClasses
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_item_no - Type: Long
    * @param filter_client_item_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   all_item_classes - Type: ArrayList&#60;AllItemClassesReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientItemClasses(Long client_no, String auth_key, Long filter_item_no, String filter_client_item_id);

    abstract Map<String,Object> getClientItemClasses(Map<String,Object> map);

    /**
    * getClientItemImages
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param item_no - Type: Long
    * @param client_item_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   item_images - Type: ArrayList&#60;ItemImagesReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientItemImages(Long client_no, String auth_key, Long item_no, String client_item_id);

    abstract Map<String,Object> getClientItemImages(Map<String,Object> map);

    /**
    * getClientItemPrices
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_currency_cd - Type: String
    * @param return_no_cost_items - Type: String
    * @param filter_item_no - Type: Long
    * @param filter_client_item_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   item_rates - Type: ArrayList&#60;ItemRatesReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientItemPrices(Long client_no, String auth_key, String filter_currency_cd, String return_no_cost_items, Long filter_item_no, String filter_client_item_id);

    abstract Map<String,Object> getClientItemPrices(Map<String,Object> map);

    /**
    * getClientItemSuppFields
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_item_no - Type: Long
    * @param filter_client_item_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   all_item_supp_fields - Type: ArrayList&#60;AllItemSuppFieldsReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientItemSuppFields(Long client_no, String auth_key, Long filter_item_no, String filter_client_item_id);

    abstract Map<String,Object> getClientItemSuppFields(Map<String,Object> map);

    /**
    * getClientItemsAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_currency_cd - Type: String
    * @param return_no_cost_items - Type: String
    * @param filter_item_no - Type: Long
    * @param include_inactive_items - Type: String
    * @param filter_client_item_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   all_client_items - Type: ArrayList&#60;AllClientItemsReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientItemsAll(Long client_no, String auth_key, String filter_currency_cd, String return_no_cost_items, Long filter_item_no, String include_inactive_items, String filter_client_item_id);

    abstract Map<String,Object> getClientItemsAll(Map<String,Object> map);

    /**
    * getClientItemsBasic
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_currency_cd - Type: String
    * @param return_no_cost_items - Type: String
    * @param filter_item_no - Type: Long
    * @param include_inactive_items - Type: String
    * @param filter_client_item_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   items_basic - Type: ArrayList&#60;ItemsBasicReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientItemsBasic(Long client_no, String auth_key, String filter_currency_cd, String return_no_cost_items, Long filter_item_no, String include_inactive_items, String filter_client_item_id);

    abstract Map<String,Object> getClientItemsBasic(Map<String,Object> map);

    /**
    * getClientPlanServiceRates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param plan_no - Type: Long
    * @param service_no - Type: Long
    * @param alt_rate_schedule_no - Type: Long
    * @param client_plan_id - Type: String
    * @param client_service_id - Type: String
    * @param client_alt_rate_schedule_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   plan_service_rates - Type: ArrayList&#60;PlanServiceRatesReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientPlanServiceRates(Long client_no, String auth_key, Long plan_no, Long service_no, Long alt_rate_schedule_no, String client_plan_id, String client_service_id, String client_alt_rate_schedule_id);

    abstract Map<String,Object> getClientPlanServiceRates(Map<String,Object> map);

    /**
    * getClientPlanServices
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param plan_no - Type: Long
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   plan_services - Type: ArrayList&#60;PlanServicesReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientPlanServices(Long client_no, String auth_key, Long plan_no, String client_plan_id);

    abstract Map<String,Object> getClientPlanServices(Map<String,Object> map);

    /**
    * getClientPlansAll
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param plan_no - Type: Long
    * @param acct_no - Type: Long
    * @param promo_code - Type: String
    * @param parent_plan_no - Type: Long
    * @param supp_field_names - Type: com.aria.common.shared.SuppFieldNamesArray
    * @param supp_field_values - Type: com.aria.common.shared.SuppFieldValuesArray
    * @param include_all_rate_schedules - Type: String
    * @param include_plan_hierarchy - Type: String
    * @param client_plan_id - Type: String
    * @param client_parent_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   all_client_plans - Type: ArrayList&#60;AllClientPlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getClientPlansAll(Long client_no, String auth_key, Long plan_no, Long acct_no, String promo_code, Long parent_plan_no, com.aria.common.shared.SuppFieldNamesArray supp_field_names, com.aria.common.shared.SuppFieldValuesArray supp_field_values, String include_all_rate_schedules, String include_plan_hierarchy, String client_plan_id, String client_parent_plan_id);

    abstract Map<String,Object> getClientPlansAll(Map<String,Object> map);

    /**
    * getClientPlansBasic
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param plan_no - Type: Long
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   plans_basic - Type: ArrayList&#60;PlansBasicReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getClientPlansBasic(Long client_no, String auth_key, Long plan_no, String client_plan_id);

    abstract Map<String,Object> getClientPlansBasic(Map<String,Object> map);

    /**
    * getCountryFromIp
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param ip_address - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   country_code - Type: javax.xml.ws.Holder<br>
    *   country_name - Type: javax.xml.ws.Holder<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getCountryFromIp(Long client_no, String auth_key, String ip_address);

    abstract Map<String,Object> getCountryFromIp(Map<String,Object> map);

    /**
    * getCurrentSystemVersion
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   version - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getCurrentSystemVersion(Long client_no, String auth_key);

    abstract Map<String,Object> getCurrentSystemVersion(Map<String,Object> map);

    /**
    * getDailyBatchStatus
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param batch_date - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   status - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getDailyBatchStatus(Long client_no, String auth_key, String batch_date);

    abstract Map<String,Object> getDailyBatchStatus(Map<String,Object> map);

    /**
    * getEmailTemplates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_template_class - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   templates_by_client - Type: ArrayList&#60;TemplatesByClientReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getEmailTemplates(Long client_no, String auth_key, String filter_template_class);

    abstract Map<String,Object> getEmailTemplates(Map<String,Object> map);

    /**
    * getItemsByClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_class_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   class_items - Type: ArrayList&#60;ClassItemsReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getItemsByClass(Long client_no, String auth_key, Long filter_class_no);

    abstract Map<String,Object> getItemsByClass(Map<String,Object> map);

    /**
    * getItemsBySuppField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param field_no - Type: Long
    * @param field_val - Type: String
    * @param field_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   items_by_supp_field - Type: ArrayList&#60;ItemsBySuppFieldReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getItemsBySuppField(Long client_no, String auth_key, Long field_no, String field_val, String field_name);

    abstract Map<String,Object> getItemsBySuppField(Map<String,Object> map);

    /**
    * getMasterPlansBySuppField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param field_no - Type: Long
    * @param field_val - Type: String
    * @param field_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   master_plans_by_supp_field - Type: ArrayList&#60;MasterPlansBySuppFieldReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getMasterPlansBySuppField(Long client_no, String auth_key, Long field_no, String field_val, String field_name);

    abstract Map<String,Object> getMasterPlansBySuppField(Map<String,Object> map);

    /**
    * getParentForItemClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param filter_class_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   parent_item_class - Type: ArrayList&#60;ParentItemClassReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getParentForItemClass(Long client_no, String auth_key, Long filter_class_no);

    abstract Map<String,Object> getParentForItemClass(Map<String,Object> map);

    /**
    * getRateSchedulesForPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param plan_no - Type: Long
    * @param currency_cd - Type: String
    * @param client_plan_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   rate_sched - Type: ArrayList&#60;RateSchedReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRateSchedulesForPlan(Long client_no, String auth_key, Long plan_no, String currency_cd, String client_plan_id);

    abstract Map<String,Object> getRateSchedulesForPlan(Map<String,Object> map);

    /**
    * getRegUssConfigParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param set_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   out_reg_uss_config_params - Type: ArrayList&#60;OutRegUssConfigParamsReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getRegUssConfigParams(Long client_no, String auth_key, String set_name);

    abstract Map<String,Object> getRegUssConfigParams(Map<String,Object> map);

    /**
    * getRegUssParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   out_reg_uss_params - Type: ArrayList&#60;OutRegUssParamsReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getRegUssParams(Long client_no, String auth_key, String session_id);

    abstract Map<String,Object> getRegUssParams(Map<String,Object> map);

    /**
    * getSuppPlansBySuppField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param field_no - Type: Long
    * @param field_val - Type: String
    * @param field_name - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   supp_plans_by_supp_field - Type: ArrayList&#60;SuppPlansBySuppFieldReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getSuppPlansBySuppField(Long client_no, String auth_key, Long field_no, String field_val, String field_name);

    abstract Map<String,Object> getSuppPlansBySuppField(Map<String,Object> map);

    /**
    * getTopLevelItemClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   top_item_class - Type: ArrayList&#60;TopItemClassReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getTopLevelItemClass(Long client_no, String auth_key);

    abstract Map<String,Object> getTopLevelItemClass(Map<String,Object> map);

    /**
    * getVirtualDatetime
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   virtual_date - Type: javax.xml.ws.Holder<br>
    *   virtual_time - Type: javax.xml.ws.Holder<br>
    *   system_date - Type: javax.xml.ws.Holder<br>
    *   system_time - Type: javax.xml.ws.Holder<br>
    *   current_offset_hours - Type: javax.xml.ws.Holder<br>
    *   is_batch_running - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getVirtualDatetime(Long client_no, String auth_key);

    abstract Map<String,Object> getVirtualDatetime(Map<String,Object> map);

    /**
    * getWebReplacementVals
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param web_vals_in - Type: com.aria.common.shared.WebValsInArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   web_vals_out - Type: ArrayList&#60;WebValsOutReturnElement&#62;<br>
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getWebReplacementVals(Long client_no, String auth_key, com.aria.common.shared.WebValsInArray web_vals_in);

    abstract Map<String,Object> getWebReplacementVals(Map<String,Object> map);

    /**
    * replaceRegUssConfigParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param set_name - Type: String
    * @param in_reg_uss_config_params - Type: com.aria.common.shared.InRegUssConfigParamsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> replaceRegUssConfigParams(Long client_no, String auth_key, String set_name, com.aria.common.shared.InRegUssConfigParamsArray in_reg_uss_config_params);

    abstract Map<String,Object> replaceRegUssConfigParams(Map<String,Object> map);

    /**
    * replaceRegUssParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @param in_reg_uss_params - Type: com.aria.common.shared.InRegUssParamsArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> replaceRegUssParams(Long client_no, String auth_key, String session_id, com.aria.common.shared.InRegUssParamsArray in_reg_uss_params);

    abstract Map<String,Object> replaceRegUssParams(Map<String,Object> map);

    /**
    * setExternalObjectId
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param destination_id - Type: Long
    * @param source_type_id - Type: Long
    * @param object_id - Type: Long
    * @param external_id - Type: String
    * @param action_directive - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setExternalObjectId(Long client_no, String auth_key, Long destination_id, Long source_type_id, Long object_id, String external_id, Long action_directive);

    abstract Map<String,Object> setExternalObjectId(Map<String,Object> map);

    /**
    * setProvEngine
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param on_off_indicator - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setProvEngine(Long client_no, String auth_key, String on_off_indicator);

    abstract Map<String,Object> setProvEngine(Map<String,Object> map);

    /**
    * setRegUssConfigParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param set_name - Type: String
    * @param in_reg_uss_config_params - Type: com.aria.common.shared.InRegUssConfigParamsArray
    * @param set_description - Type: String
    * @param set_type_no - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setRegUssConfigParams(Long client_no, String auth_key, String set_name, com.aria.common.shared.InRegUssConfigParamsArray in_reg_uss_config_params, String set_description, Long set_type_no);

    abstract Map<String,Object> setRegUssConfigParams(Map<String,Object> map);

    /**
    * setRegUssParams
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param session_id - Type: String
    * @param in_reg_uss_params - Type: com.aria.common.shared.InRegUssParamsArray
    * @param override_timeout_minutes - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setRegUssParams(Long client_no, String auth_key, String session_id, com.aria.common.shared.InRegUssParamsArray in_reg_uss_params, Long override_timeout_minutes);

    abstract Map<String,Object> setRegUssParams(Map<String,Object> map);

    /**
    * subscribeEvent
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param event_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> subscribeEvent(Long client_no, String auth_key, Long event_id);

    abstract Map<String,Object> subscribeEvent(Map<String,Object> map);

    /**
    * subscribeEventClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param class_no - Type: Long
    * @param do_write - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   events - Type: ArrayList&#60;EventsReturnElement&#62;<br>
    */
    abstract Map<String,Object> subscribeEventClass(Long client_no, String auth_key, Long class_no, String do_write);

    abstract Map<String,Object> subscribeEventClass(Map<String,Object> map);

    /**
    * subscribeEvents
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param event_list - Type: com.aria.common.shared.EventListArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> subscribeEvents(Long client_no, String auth_key, com.aria.common.shared.EventListArray event_list);

    abstract Map<String,Object> subscribeEvents(Map<String,Object> map);

    /**
    * unsubscribeEvent
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param event_id - Type: Long
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> unsubscribeEvent(Long client_no, String auth_key, Long event_id);

    abstract Map<String,Object> unsubscribeEvent(Map<String,Object> map);

    /**
    * unsubscribeEventClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param class_no - Type: Long
    * @param do_write - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   events - Type: ArrayList&#60;EventsReturnElement&#62;<br>
    */
    abstract Map<String,Object> unsubscribeEventClass(Long client_no, String auth_key, Long class_no, String do_write);

    abstract Map<String,Object> unsubscribeEventClass(Map<String,Object> map);

    /**
    * unsubscribeEvents
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @param event_list - Type: com.aria.common.shared.EventListArray
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> unsubscribeEvents(Long client_no, String auth_key, com.aria.common.shared.EventListArray event_list);

    abstract Map<String,Object> unsubscribeEvents(Map<String,Object> map);

    /********************************** END - METHODS ***********************************************/
}
