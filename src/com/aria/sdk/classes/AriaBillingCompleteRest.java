package com.aria.sdk.classes;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.aria.common.rest.RestUtilities;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * AriaBillingCompleteRest
 * 
 * Creates an client to the Aria APIs.
 *
 * Instances are threadsafe.
 *
 * Since construction is relatively costly, users should reuse a single instance across calls and across threads.
 *
 * @copyright Aria Systems, Inc
 */
public class AriaBillingCompleteRest extends BaseAriaBilling implements AriaBillingComplete {
    final private Client client;
  
    /************** CONSTRUCTOR ************************/
    
    /**
     * Create an Aria API client using the provided Jersey client.
     *
     * @param url the Aria API endpoint URI
     * @param client a Jersey client configured by the caller
     */
    public AriaBillingCompleteRest(String url, Client client) {
        super(url);
        this.client = client;
    }
    
    /**
     * Create an Aria API client using the provided Jersey client.
     *
     * @param url the Aria API endpoint URI
     */
    public AriaBillingCompleteRest(String url) {
        this(url, Client.create(new DefaultClientConfig()));
    }
        /**
     * @deprecated use {@link AriaBillingCompleteRest(String)} or {@link AriaBillingCompleteRest(String,Client)}
     */
    public AriaBillingCompleteRest(BaseAriaBillingDTO baseAriaBillingDTO) throws Exception {
        this(baseAriaBillingDTO.getUrl(), Client.create(new DefaultClientConfig()));
    }
        /**
     * Destroys the underlying {@link Client}.
     */
    public void close() {
      client.destroy();
    }
    
    /*************** END - CONSTRUCTOR ****************/

    public LibraryType getLibraryType() { 
      return BaseAriaBilling.asLibraryType("Complete");
    }
    
    protected String buildUrl(String restCallMethod) {
        return getURL()+"?output_format=json&rest_call="+restCallMethod;
    }
    
    /********************************** METHODS IMPLEMENTATION ***********************************************/

    public Map<String,Object> getInvoiceDetails(Long client_no, String auth_key, Long acct_no, Long src_transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"src_transaction_id", getValue("Long", src_transaction_id));
        
        return this.buildGetInvoiceDetailsHashMap(parameters);
    }

    public Map<String,Object> getInvoiceDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long src_transaction_id = (Long) map.get("src_transaction_id");
        
        return getInvoiceDetails(client_no, auth_key, acct_no, src_transaction_id);
    }
        private Map<String,Object> buildGetInvoiceDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_invoice_details", parameters);
        String[] returnValues = new String[13];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_line_items";
        returnValues[3] = "is_pending_ind";
        returnValues[4] = "custom_status_label";
        returnValues[5] = "custom_status_desc";
        returnValues[6] = "client_notes";
        returnValues[7] = "invoice_type_cd";
        returnValues[8] = "from_date";
        returnValues[9] = "to_date";
        returnValues[10] = "posting_status_cd";
        returnValues[11] = "posting_user";
        returnValues[12] = "posting_date";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> applyCashCredit(Long client_no, String auth_key, Long account_no, Double credit_amount, Long credit_reason_code, String comments, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"credit_amount", getValue("Double", credit_amount));
        addParameters(parameters,"credit_reason_code", getValue("Long", credit_reason_code));
        addParameters(parameters,"comments", getValue("String", comments));
        RestUtilities.addParameterValuesFromArray(parameters, specific_charge_transaction_id);
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildApplyCashCreditHashMap(parameters);
    }

    public Map<String,Object> applyCashCredit(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Double credit_amount = (Double) map.get("credit_amount");
        Long credit_reason_code = (Long) map.get("credit_reason_code");
        String comments = (String) map.get("comments");
        com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id = (com.aria.common.shared.SpecificChargeTransactionIdArray) map.get("specific_charge_transaction_id");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return applyCashCredit(client_no, auth_key, account_no, credit_amount, credit_reason_code, comments, specific_charge_transaction_id, client_receipt_id);
    }
        private Map<String,Object> buildApplyCashCreditHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "apply_cash_credit", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> applyServiceCredit(Long client_no, String auth_key, Long account_no, Double credit_amount, Long credit_reason_code, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"credit_amount", getValue("Double", credit_amount));
        addParameters(parameters,"credit_reason_code", getValue("Long", credit_reason_code));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildApplyServiceCreditHashMap(parameters);
    }

    public Map<String,Object> applyServiceCredit(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Double credit_amount = (Double) map.get("credit_amount");
        Long credit_reason_code = (Long) map.get("credit_reason_code");
        String comments = (String) map.get("comments");
        
        return applyServiceCredit(client_no, auth_key, account_no, credit_amount, credit_reason_code, comments);
    }
        private Map<String,Object> buildApplyServiceCreditHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "apply_service_credit", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "credit_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> bulkRecordUsage(Long client_no, String auth_key, com.aria.common.shared.UsageRecordsArray usage_records, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, usage_records);
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildBulkRecordUsageHashMap(parameters);
    }

    public Map<String,Object> bulkRecordUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.UsageRecordsArray usage_records = (com.aria.common.shared.UsageRecordsArray) map.get("usage_records");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return bulkRecordUsage(client_no, auth_key, usage_records, client_receipt_id);
    }
        private Map<String,Object> buildBulkRecordUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "bulk_record_usage", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "error_records";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelOrder(Long client_no, String auth_key, Long acct_no, Long order_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"order_no", getValue("Long", order_no));
        
        return this.buildCancelOrderHashMap(parameters);
    }

    public Map<String,Object> cancelOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long order_no = (Long) map.get("order_no");
        
        return cancelOrder(client_no, auth_key, acct_no, order_no);
    }
        private Map<String,Object> buildCancelOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_order", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelRecurringCredits(Long client_no, String auth_key, Long acct_no, String userid, String client_acct_id, com.aria.common.shared.RecurringCreditNoArray recurring_credit_no, String cancel_comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"userid", getValue("String", userid));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        RestUtilities.addParameterValuesFromArray(parameters, recurring_credit_no);
        addParameters(parameters,"cancel_comments", getValue("String", cancel_comments));
        
        return this.buildCancelRecurringCreditsHashMap(parameters);
    }

    public Map<String,Object> cancelRecurringCredits(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String userid = (String) map.get("userid");
        String client_acct_id = (String) map.get("client_acct_id");
        com.aria.common.shared.RecurringCreditNoArray recurring_credit_no = (com.aria.common.shared.RecurringCreditNoArray) map.get("recurring_credit_no");
        String cancel_comments = (String) map.get("cancel_comments");
        
        return cancelRecurringCredits(client_no, auth_key, acct_no, userid, client_acct_id, recurring_credit_no, cancel_comments);
    }
        private Map<String,Object> buildCancelRecurringCreditsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_recurring_credits", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "error_codes";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelStandingOrder(Long client_no, String auth_key, Long standing_order_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"standing_order_no", getValue("Long", standing_order_no));
        
        return this.buildCancelStandingOrderHashMap(parameters);
    }

    public Map<String,Object> cancelStandingOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long standing_order_no = (Long) map.get("standing_order_no");
        
        return cancelStandingOrder(client_no, auth_key, standing_order_no);
    }
        private Map<String,Object> buildCancelStandingOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_standing_order", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> collectFromAccount(Long client_no, String auth_key, Long account_no, Double amount_to_collect, Long bill_seq, String client_receipt_id, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String alt_client_acct_group_id, String track_data1, String track_data2, Long payment_application_method, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"amount_to_collect", getValue("Double", amount_to_collect));
        addParameters(parameters,"bill_seq", getValue("Long", bill_seq));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        RestUtilities.addParameterValuesFromArray(parameters, specific_charge_transaction_id);
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"payment_application_method", getValue("Long", payment_application_method));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        
        return this.buildCollectFromAccountHashMap(parameters);
    }

    public Map<String,Object> collectFromAccount(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Double amount_to_collect = (Double) map.get("amount_to_collect");
        Long bill_seq = (Long) map.get("bill_seq");
        String client_receipt_id = (String) map.get("client_receipt_id");
        com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id = (com.aria.common.shared.SpecificChargeTransactionIdArray) map.get("specific_charge_transaction_id");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String cvv = (String) map.get("cvv");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String bill_address3 = (String) map.get("bill_address3");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        Long payment_application_method = (Long) map.get("payment_application_method");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        
        return collectFromAccount(client_no, auth_key, account_no, amount_to_collect, bill_seq, client_receipt_id, specific_charge_transaction_id, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, cvv, bank_acct_type, bill_address3, alt_client_acct_group_id, track_data1, track_data2, payment_application_method, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd);
    }
        private Map<String,Object> buildCollectFromAccountHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "collect_from_account", parameters);
        String[] returnValues = new String[11];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "proc_cvv_response";
        returnValues[2] = "proc_avs_response";
        returnValues[3] = "proc_cavv_response";
        returnValues[4] = "proc_status_code";
        returnValues[5] = "proc_status_text";
        returnValues[6] = "proc_payment_id";
        returnValues[7] = "proc_auth_code";
        returnValues[8] = "proc_merch_comments";
        returnValues[9] = "error_code";
        returnValues[10] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> compareAgainstCcBlacklist(Long client_no, String auth_key, String cc_num, Long include_details){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"cc_num", getValue("String", cc_num));
        addParameters(parameters,"include_details", getValue("Long", include_details));
        
        return this.buildCompareAgainstCcBlacklistHashMap(parameters);
    }

    public Map<String,Object> compareAgainstCcBlacklist(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String cc_num = (String) map.get("cc_num");
        Long include_details = (Long) map.get("include_details");
        
        return compareAgainstCcBlacklist(client_no, auth_key, cc_num, include_details);
    }
        private Map<String,Object> buildCompareAgainstCcBlacklistHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "compare_against_cc_blacklist", parameters);
        String[] returnValues = new String[6];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "cc_num_blacklisted";
        returnValues[3] = "notes";
        returnValues[4] = "date_added";
        returnValues[5] = "date_removed";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> copyAcctPaymentMethod(Long client_no, String auth_key, Long source_acct_no, String client_source_acct_id, Long target_acct_no, String client_target_acct_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"source_acct_no", getValue("Long", source_acct_no));
        addParameters(parameters,"client_source_acct_id", getValue("String", client_source_acct_id));
        addParameters(parameters,"target_acct_no", getValue("Long", target_acct_no));
        addParameters(parameters,"client_target_acct_id", getValue("String", client_target_acct_id));
        
        return this.buildCopyAcctPaymentMethodHashMap(parameters);
    }

    public Map<String,Object> copyAcctPaymentMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long source_acct_no = (Long) map.get("source_acct_no");
        String client_source_acct_id = (String) map.get("client_source_acct_id");
        Long target_acct_no = (Long) map.get("target_acct_no");
        String client_target_acct_id = (String) map.get("client_target_acct_id");
        
        return copyAcctPaymentMethod(client_no, auth_key, source_acct_no, client_source_acct_id, target_acct_no, client_target_acct_id);
    }
        private Map<String,Object> buildCopyAcctPaymentMethodHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "copy_acct_payment_method", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "seq_nos";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createOrder(Long client_no, String auth_key, Long account_no, com.aria.common.shared.OrderLineItemsListArray order_line_items_list, Long bill_immediately, Long bill_seq, String client_order_id, String client_receipt_id, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String do_write, String coupon_cd, String alt_client_acct_group_id, String track_data1, String track_data2, Long alt_inv_template_no, String client_alt_inv_template_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String statement_message, String fulfilled_date, String order_comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        RestUtilities.addParameterValuesFromArray(parameters, order_line_items_list);
        addParameters(parameters,"bill_immediately", getValue("Long", bill_immediately));
        addParameters(parameters,"bill_seq", getValue("Long", bill_seq));
        addParameters(parameters,"client_order_id", getValue("String", client_order_id));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"alt_inv_template_no", getValue("Long", alt_inv_template_no));
        addParameters(parameters,"client_alt_inv_template_id", getValue("String", client_alt_inv_template_id));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"statement_message", getValue("String", statement_message));
        addParameters(parameters,"fulfilled_date", getValue("String", fulfilled_date));
        addParameters(parameters,"order_comments", getValue("String", order_comments));
        
        return this.buildCreateOrderHashMap(parameters);
    }

    public Map<String,Object> createOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        com.aria.common.shared.OrderLineItemsListArray order_line_items_list = (com.aria.common.shared.OrderLineItemsListArray) map.get("order_line_items_list");
        Long bill_immediately = (Long) map.get("bill_immediately");
        Long bill_seq = (Long) map.get("bill_seq");
        String client_order_id = (String) map.get("client_order_id");
        String client_receipt_id = (String) map.get("client_receipt_id");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String cvv = (String) map.get("cvv");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String bill_address3 = (String) map.get("bill_address3");
        String do_write = (String) map.get("do_write");
        String coupon_cd = (String) map.get("coupon_cd");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        Long alt_inv_template_no = (Long) map.get("alt_inv_template_no");
        String client_alt_inv_template_id = (String) map.get("client_alt_inv_template_id");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        String statement_message = (String) map.get("statement_message");
        String fulfilled_date = (String) map.get("fulfilled_date");
        String order_comments = (String) map.get("order_comments");
        
        return createOrder(client_no, auth_key, account_no, order_line_items_list, bill_immediately, bill_seq, client_order_id, client_receipt_id, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, cvv, bank_acct_type, bill_address3, do_write, coupon_cd, alt_client_acct_group_id, track_data1, track_data2, alt_inv_template_no, client_alt_inv_template_id, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, statement_message, fulfilled_date, order_comments);
    }
        private Map<String,Object> buildCreateOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_order", parameters);
        String[] returnValues = new String[23];
        
        returnValues[0] = "order_no";
        returnValues[1] = "transaction_id";
        returnValues[2] = "invoicing_error_code";
        returnValues[3] = "invoicing_error_msg";
        returnValues[4] = "statement_error_cd";
        returnValues[5] = "statement_error_msg";
        returnValues[6] = "proc_cvv_response";
        returnValues[7] = "proc_avs_response";
        returnValues[8] = "proc_cavv_response";
        returnValues[9] = "proc_status_code";
        returnValues[10] = "proc_status_text";
        returnValues[11] = "proc_payment_id";
        returnValues[12] = "proc_auth_code";
        returnValues[13] = "proc_merch_comments";
        returnValues[14] = "invoice_no";
        returnValues[15] = "error_code";
        returnValues[16] = "error_msg";
        returnValues[17] = "total_charges_before_tax";
        returnValues[18] = "total_tax_charges";
        returnValues[19] = "total_charges_after_tax";
        returnValues[20] = "total_credit";
        returnValues[21] = "invoice_line_items_list";
        returnValues[22] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createOrderWithPlans(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.OrderLineItemsListArray order_line_items_list, com.aria.common.shared.CartSuppPlansArray cart_supp_plans, String client_order_id, String coupon_code, String comments, String do_write, String client_receipt_id, Long bill_seq, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String track_data1, String track_data2, Long alt_inv_template_no, Long sync_mstr_bill_dates_override, com.aria.common.shared.MultipleCouponsArray multiple_coupons, String client_alt_inv_template_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String statement_message, String order_comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        RestUtilities.addParameterValuesFromArray(parameters, order_line_items_list);
        RestUtilities.addParameterValuesFromArray(parameters, cart_supp_plans);
        addParameters(parameters,"client_order_id", getValue("String", client_order_id));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"bill_seq", getValue("Long", bill_seq));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"alt_inv_template_no", getValue("Long", alt_inv_template_no));
        addParameters(parameters,"sync_mstr_bill_dates_override", getValue("Long", sync_mstr_bill_dates_override));
        RestUtilities.addParameterValuesFromArray(parameters, multiple_coupons);
        addParameters(parameters,"client_alt_inv_template_id", getValue("String", client_alt_inv_template_id));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"statement_message", getValue("String", statement_message));
        addParameters(parameters,"order_comments", getValue("String", order_comments));
        
        return this.buildCreateOrderWithPlansHashMap(parameters);
    }

    public Map<String,Object> createOrderWithPlans(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        com.aria.common.shared.OrderLineItemsListArray order_line_items_list = (com.aria.common.shared.OrderLineItemsListArray) map.get("order_line_items_list");
        com.aria.common.shared.CartSuppPlansArray cart_supp_plans = (com.aria.common.shared.CartSuppPlansArray) map.get("cart_supp_plans");
        String client_order_id = (String) map.get("client_order_id");
        String coupon_code = (String) map.get("coupon_code");
        String comments = (String) map.get("comments");
        String do_write = (String) map.get("do_write");
        String client_receipt_id = (String) map.get("client_receipt_id");
        Long bill_seq = (Long) map.get("bill_seq");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String cvv = (String) map.get("cvv");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String bill_address3 = (String) map.get("bill_address3");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        Long alt_inv_template_no = (Long) map.get("alt_inv_template_no");
        Long sync_mstr_bill_dates_override = (Long) map.get("sync_mstr_bill_dates_override");
        com.aria.common.shared.MultipleCouponsArray multiple_coupons = (com.aria.common.shared.MultipleCouponsArray) map.get("multiple_coupons");
        String client_alt_inv_template_id = (String) map.get("client_alt_inv_template_id");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        String statement_message = (String) map.get("statement_message");
        String order_comments = (String) map.get("order_comments");
        
        return createOrderWithPlans(client_no, auth_key, acct_no, order_line_items_list, cart_supp_plans, client_order_id, coupon_code, comments, do_write, client_receipt_id, bill_seq, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, cvv, bank_acct_type, bill_address3, track_data1, track_data2, alt_inv_template_no, sync_mstr_bill_dates_override, multiple_coupons, client_alt_inv_template_id, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, statement_message, order_comments);
    }
        private Map<String,Object> buildCreateOrderWithPlansHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_order_with_plans", parameters);
        String[] returnValues = new String[21];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "order_no";
        returnValues[3] = "invoice_no";
        returnValues[4] = "invoice_line_items_list";
        returnValues[5] = "invoicing_error_code";
        returnValues[6] = "invoicing_error_msg";
        returnValues[7] = "collection_error_code";
        returnValues[8] = "collection_error_msg";
        returnValues[9] = "statement_error_code";
        returnValues[10] = "statement_error_msg";
        returnValues[11] = "transaction_id";
        returnValues[12] = "proc_cvv_response";
        returnValues[13] = "proc_avs_response";
        returnValues[14] = "proc_cavv_response";
        returnValues[15] = "proc_status_code";
        returnValues[16] = "proc_status_text";
        returnValues[17] = "proc_payment_id";
        returnValues[18] = "proc_auth_code";
        returnValues[19] = "proc_merch_comments";
        returnValues[20] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createWriteoffOrDispute(Long client_no, String auth_key, Long acct_no, Long invoice_no, Double amount, Long reason_code, String comments, Long do_dispute, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"invoice_no", getValue("Long", invoice_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        addParameters(parameters,"reason_code", getValue("Long", reason_code));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_dispute", getValue("Long", do_dispute));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildCreateWriteoffOrDisputeHashMap(parameters);
    }

    public Map<String,Object> createWriteoffOrDispute(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long invoice_no = (Long) map.get("invoice_no");
        Double amount = (Double) map.get("amount");
        Long reason_code = (Long) map.get("reason_code");
        String comments = (String) map.get("comments");
        Long do_dispute = (Long) map.get("do_dispute");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return createWriteoffOrDispute(client_no, auth_key, acct_no, invoice_no, amount, reason_code, comments, do_dispute, client_receipt_id);
    }
        private Map<String,Object> buildCreateWriteoffOrDisputeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_writeoff_or_dispute", parameters);
        String[] returnValues = new String[15];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "rec_no";
        returnValues[3] = "created_by";
        returnValues[4] = "amount";
        returnValues[5] = "invoice_no";
        returnValues[6] = "invoice_date";
        returnValues[7] = "invoice_amt";
        returnValues[8] = "dispute_creation_date";
        returnValues[9] = "dispute_exp_date";
        returnValues[10] = "comments";
        returnValues[11] = "reason_code";
        returnValues[12] = "secondary_reason_code";
        returnValues[13] = "dispute_ind";
        returnValues[14] = "can_unsettle";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> discardUsage(Long client_no, String auth_key, com.aria.common.shared.UsageRecordNosArray usage_record_nos, com.aria.common.shared.ClientRecordIdsArray client_record_ids, Long exclusion_reason_cd, String exclusion_comment){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, usage_record_nos);
        RestUtilities.addParameterValuesFromArray(parameters, client_record_ids);
        addParameters(parameters,"exclusion_reason_cd", getValue("Long", exclusion_reason_cd));
        addParameters(parameters,"exclusion_comment", getValue("String", exclusion_comment));
        
        return this.buildDiscardUsageHashMap(parameters);
    }

    public Map<String,Object> discardUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.UsageRecordNosArray usage_record_nos = (com.aria.common.shared.UsageRecordNosArray) map.get("usage_record_nos");
        com.aria.common.shared.ClientRecordIdsArray client_record_ids = (com.aria.common.shared.ClientRecordIdsArray) map.get("client_record_ids");
        Long exclusion_reason_cd = (Long) map.get("exclusion_reason_cd");
        String exclusion_comment = (String) map.get("exclusion_comment");
        
        return discardUsage(client_no, auth_key, usage_record_nos, client_record_ids, exclusion_reason_cd, exclusion_comment);
    }
        private Map<String,Object> buildDiscardUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "discard_usage", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "failed_records";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> genInvoice(Long client_no, String auth_key, Long acct_no, String force_pending, String client_receipt_id, Long alt_bill_day, Long invoice_mode){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"force_pending", getValue("String", force_pending));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"alt_bill_day", getValue("Long", alt_bill_day));
        addParameters(parameters,"invoice_mode", getValue("Long", invoice_mode));
        
        return this.buildGenInvoiceHashMap(parameters);
    }

    public Map<String,Object> genInvoice(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String force_pending = (String) map.get("force_pending");
        String client_receipt_id = (String) map.get("client_receipt_id");
        Long alt_bill_day = (Long) map.get("alt_bill_day");
        Long invoice_mode = (Long) map.get("invoice_mode");
        
        return genInvoice(client_no, auth_key, acct_no, force_pending, client_receipt_id, alt_bill_day, invoice_mode);
    }
        private Map<String,Object> buildGenInvoiceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "gen_invoice", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_no";
        returnValues[3] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPaymentHistory(Long client_no, String auth_key, Long acct_no, String start_date, String end_date, Long limit_records, Long details_flag){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        addParameters(parameters,"limit_records", getValue("Long", limit_records));
        addParameters(parameters,"details_flag", getValue("Long", details_flag));
        
        return this.buildGetAcctPaymentHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctPaymentHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        Long limit_records = (Long) map.get("limit_records");
        Long details_flag = (Long) map.get("details_flag");
        
        return getAcctPaymentHistory(client_no, auth_key, acct_no, start_date, end_date, limit_records, details_flag);
    }
        private Map<String,Object> buildGetAcctPaymentHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_payment_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "payment_history";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPreviewStatement(Long client_no, String auth_key, Long acct_no, Double alt_stmt_template_no, Long auto_skip_to_next_bill_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"alt_stmt_template_no", getValue("Double", alt_stmt_template_no));
        addParameters(parameters,"auto_skip_to_next_bill_date", getValue("Long", auto_skip_to_next_bill_date));
        
        return this.buildGetAcctPreviewStatementHashMap(parameters);
    }

    public Map<String,Object> getAcctPreviewStatement(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double alt_stmt_template_no = (Double) map.get("alt_stmt_template_no");
        Long auto_skip_to_next_bill_date = (Long) map.get("auto_skip_to_next_bill_date");
        
        return getAcctPreviewStatement(client_no, auth_key, acct_no, alt_stmt_template_no, auto_skip_to_next_bill_date);
    }
        private Map<String,Object> buildGetAcctPreviewStatementHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_preview_statement", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "out_statement";
        returnValues[3] = "mime_type";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctWriteoffOrDisputes(Long client_no, String auth_key, Long acct_no, Long dispute_or_writeoff_flag, Long details_flag){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"dispute_or_writeoff_flag", getValue("Long", dispute_or_writeoff_flag));
        addParameters(parameters,"details_flag", getValue("Long", details_flag));
        
        return this.buildGetAcctWriteoffOrDisputesHashMap(parameters);
    }

    public Map<String,Object> getAcctWriteoffOrDisputes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long dispute_or_writeoff_flag = (Long) map.get("dispute_or_writeoff_flag");
        Long details_flag = (Long) map.get("details_flag");
        
        return getAcctWriteoffOrDisputes(client_no, auth_key, acct_no, dispute_or_writeoff_flag, details_flag);
    }
        private Map<String,Object> buildGetAcctWriteoffOrDisputesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_writeoff_or_disputes", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "write_off_info";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAllActionsByReceiptId(Long client_no, String auth_key, Long acct_no, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildGetAllActionsByReceiptIdHashMap(parameters);
    }

    public Map<String,Object> getAllActionsByReceiptId(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return getAllActionsByReceiptId(client_no, auth_key, acct_no, client_receipt_id);
    }
        private Map<String,Object> buildGetAllActionsByReceiptIdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_all_actions_by_receipt_id", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "receipt_action";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAriaXmlStatement(Long client_no, String auth_key, Long acct_no, Long xml_statement_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"xml_statement_no", getValue("Long", xml_statement_no));
        
        return this.buildGetAriaXmlStatementHashMap(parameters);
    }

    public Map<String,Object> getAriaXmlStatement(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long xml_statement_no = (Long) map.get("xml_statement_no");
        
        return getAriaXmlStatement(client_no, auth_key, acct_no, xml_statement_no);
    }
        private Map<String,Object> buildGetAriaXmlStatementHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_aria_xml_statement", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "xml_statement_content";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCcVelocityInfo(Long client_no, String auth_key, String cc_num, String start_date, String end_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"cc_num", getValue("String", cc_num));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        
        return this.buildGetCcVelocityInfoHashMap(parameters);
    }

    public Map<String,Object> getCcVelocityInfo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String cc_num = (String) map.get("cc_num");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        
        return getCcVelocityInfo(client_no, auth_key, cc_num, start_date, end_date);
    }
        private Map<String,Object> buildGetCcVelocityInfoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_cc_velocity_info", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "velocity_data";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getExtendedTransactionInfo(Long client_no, String auth_key, Long acct_no, Long transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        
        return this.buildGetExtendedTransactionInfoHashMap(parameters);
    }

    public Map<String,Object> getExtendedTransactionInfo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long transaction_id = (Long) map.get("transaction_id");
        
        return getExtendedTransactionInfo(client_no, auth_key, acct_no, transaction_id);
    }
        private Map<String,Object> buildGetExtendedTransactionInfoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_extended_transaction_info", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "trans_create_user";
        returnValues[3] = "trans_create_date";
        returnValues[4] = "extended_transaction_qualifiers";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getInvNoFromBalXfer(Long client_no, String auth_key, Long transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        
        return this.buildGetInvNoFromBalXferHashMap(parameters);
    }

    public Map<String,Object> getInvNoFromBalXfer(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long transaction_id = (Long) map.get("transaction_id");
        
        return getInvNoFromBalXfer(client_no, auth_key, transaction_id);
    }
        private Map<String,Object> buildGetInvNoFromBalXferHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_inv_no_from_bal_xfer", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_no";
        returnValues[3] = "acct_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getInvoicesToWriteoffOrDispute(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetInvoicesToWriteoffOrDisputeHashMap(parameters);
    }

    public Map<String,Object> getInvoicesToWriteoffOrDispute(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getInvoicesToWriteoffOrDispute(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetInvoicesToWriteoffOrDisputeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_invoices_to_writeoff_or_dispute", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getOrder(Long client_no, String auth_key, Long acct_no, Long my_order_no, String my_client_order_id, Long limit_records, Long details_flag){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"my_order_no", getValue("Long", my_order_no));
        addParameters(parameters,"my_client_order_id", getValue("String", my_client_order_id));
        addParameters(parameters,"limit_records", getValue("Long", limit_records));
        addParameters(parameters,"details_flag", getValue("Long", details_flag));
        
        return this.buildGetOrderHashMap(parameters);
    }

    public Map<String,Object> getOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long my_order_no = (Long) map.get("my_order_no");
        String my_client_order_id = (String) map.get("my_client_order_id");
        Long limit_records = (Long) map.get("limit_records");
        Long details_flag = (Long) map.get("details_flag");
        
        return getOrder(client_no, auth_key, acct_no, my_order_no, my_client_order_id, limit_records, details_flag);
    }
        private Map<String,Object> buildGetOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_order", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "order";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getOrderItems(Long client_no, String auth_key, Long order_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"order_no", getValue("Long", order_no));
        
        return this.buildGetOrderItemsHashMap(parameters);
    }

    public Map<String,Object> getOrderItems(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long order_no = (Long) map.get("order_no");
        
        return getOrderItems(client_no, auth_key, order_no);
    }
        private Map<String,Object> buildGetOrderItemsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_order_items", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "order_items_list";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPaymentApplicationDtls(Long client_no, String auth_key, Long acct_no, Long transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        
        return this.buildGetPaymentApplicationDtlsHashMap(parameters);
    }

    public Map<String,Object> getPaymentApplicationDtls(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long transaction_id = (Long) map.get("transaction_id");
        
        return getPaymentApplicationDtls(client_no, auth_key, acct_no, transaction_id);
    }
        private Map<String,Object> buildGetPaymentApplicationDtlsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_payment_application_dtls", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "payment_application_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPaymentApplications(Long client_no, String auth_key, Long acct_no, Long src_transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"src_transaction_id", getValue("Long", src_transaction_id));
        
        return this.buildGetPaymentApplicationsHashMap(parameters);
    }

    public Map<String,Object> getPaymentApplications(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long src_transaction_id = (Long) map.get("src_transaction_id");
        
        return getPaymentApplications(client_no, auth_key, acct_no, src_transaction_id);
    }
        private Map<String,Object> buildGetPaymentApplicationsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_payment_applications", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "payment_applications";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPaymentsOnInvoice(Long client_no, String auth_key, Long acct_no, Long src_transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"src_transaction_id", getValue("Long", src_transaction_id));
        
        return this.buildGetPaymentsOnInvoiceHashMap(parameters);
    }

    public Map<String,Object> getPaymentsOnInvoice(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long src_transaction_id = (Long) map.get("src_transaction_id");
        
        return getPaymentsOnInvoice(client_no, auth_key, acct_no, src_transaction_id);
    }
        private Map<String,Object> buildGetPaymentsOnInvoiceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_payments_on_invoice", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_payments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRefundDetails(Long client_no, String auth_key, Long acct_no, String include_voided, Long aria_event_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"include_voided", getValue("String", include_voided));
        addParameters(parameters,"aria_event_no", getValue("Long", aria_event_no));
        
        return this.buildGetRefundDetailsHashMap(parameters);
    }

    public Map<String,Object> getRefundDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String include_voided = (String) map.get("include_voided");
        Long aria_event_no = (Long) map.get("aria_event_no");
        
        return getRefundDetails(client_no, auth_key, acct_no, include_voided, aria_event_no);
    }
        private Map<String,Object> buildGetRefundDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_refund_details", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "refund_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRefundablePayments(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetRefundablePaymentsHashMap(parameters);
    }

    public Map<String,Object> getRefundablePayments(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getRefundablePayments(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetRefundablePaymentsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_refundable_payments", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "refundable_payments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getReversibleAuthorizations(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetReversibleAuthorizationsHashMap(parameters);
    }

    public Map<String,Object> getReversibleAuthorizations(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getReversibleAuthorizations(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetReversibleAuthorizationsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_reversible_authorizations", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "reversible_authorizations";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getReversibleInvsByPayment(Long client_no, String auth_key, Long acct_no, Long payment_transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"payment_transaction_id", getValue("Long", payment_transaction_id));
        
        return this.buildGetReversibleInvsByPaymentHashMap(parameters);
    }

    public Map<String,Object> getReversibleInvsByPayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long payment_transaction_id = (Long) map.get("payment_transaction_id");
        
        return getReversibleInvsByPayment(client_no, auth_key, acct_no, payment_transaction_id);
    }
        private Map<String,Object> buildGetReversibleInvsByPaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_reversible_invs_by_payment", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "reversible_invoices";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStandingOrder(Long client_no, String auth_key, Long acct_no, Long my_standing_order, String my_client_order_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"my_standing_order", getValue("Long", my_standing_order));
        addParameters(parameters,"my_client_order_id", getValue("String", my_client_order_id));
        
        return this.buildGetStandingOrderHashMap(parameters);
    }

    public Map<String,Object> getStandingOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long my_standing_order = (Long) map.get("my_standing_order");
        String my_client_order_id = (String) map.get("my_client_order_id");
        
        return getStandingOrder(client_no, auth_key, acct_no, my_standing_order, my_client_order_id);
    }
        private Map<String,Object> buildGetStandingOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_standing_order", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "so";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStandingOrderHist(Long client_no, String auth_key, Long standing_order_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"standing_order_no", getValue("Long", standing_order_no));
        
        return this.buildGetStandingOrderHistHashMap(parameters);
    }

    public Map<String,Object> getStandingOrderHist(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long standing_order_no = (Long) map.get("standing_order_no");
        
        return getStandingOrderHist(client_no, auth_key, standing_order_no);
    }
        private Map<String,Object> buildGetStandingOrderHistHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_standing_order_hist", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "order";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStandingOrderItems(Long client_no, String auth_key, Long standing_order_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"standing_order_no", getValue("Long", standing_order_no));
        
        return this.buildGetStandingOrderItemsHashMap(parameters);
    }

    public Map<String,Object> getStandingOrderItems(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long standing_order_no = (Long) map.get("standing_order_no");
        
        return getStandingOrderItems(client_no, auth_key, standing_order_no);
    }
        private Map<String,Object> buildGetStandingOrderItemsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_standing_order_items", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "so_items";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStatementForInvSize(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long invoice_no, String do_encoding){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"invoice_no", getValue("Long", invoice_no));
        addParameters(parameters,"do_encoding", getValue("String", do_encoding));
        
        return this.buildGetStatementForInvSizeHashMap(parameters);
    }

    public Map<String,Object> getStatementForInvSize(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        Long invoice_no = (Long) map.get("invoice_no");
        String do_encoding = (String) map.get("do_encoding");
        
        return getStatementForInvSize(client_no, auth_key, acct_no, client_acct_id, invoice_no, do_encoding);
    }
        private Map<String,Object> buildGetStatementForInvSizeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_statement_for_inv_size", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "num_chars";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStatementForInvoice(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long invoice_no, String do_encoding){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"invoice_no", getValue("Long", invoice_no));
        addParameters(parameters,"do_encoding", getValue("String", do_encoding));
        
        return this.buildGetStatementForInvoiceHashMap(parameters);
    }

    public Map<String,Object> getStatementForInvoice(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        Long invoice_no = (Long) map.get("invoice_no");
        String do_encoding = (String) map.get("do_encoding");
        
        return getStatementForInvoice(client_no, auth_key, acct_no, client_acct_id, invoice_no, do_encoding);
    }
        private Map<String,Object> buildGetStatementForInvoiceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_statement_for_invoice", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "out_statement";
        returnValues[3] = "mime_type";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getWriteoffDetails(Long client_no, String auth_key, Long acct_no, Long aria_event_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"aria_event_no", getValue("Long", aria_event_no));
        
        return this.buildGetWriteoffDetailsHashMap(parameters);
    }

    public Map<String,Object> getWriteoffDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long aria_event_no = (Long) map.get("aria_event_no");
        
        return getWriteoffDetails(client_no, auth_key, acct_no, aria_event_no);
    }
        private Map<String,Object> buildGetWriteoffDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_writeoff_details", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "writeoff_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> issueRefundToAcct(Long client_no, String auth_key, Long acct_no, Long payment_transaction_id, Long reason_code, Double total_refund_amount, String refund_check_number, String comments, String do_write, String auto_calc_refund, com.aria.common.shared.InvoicesToReverseArray invoices_to_reverse, String client_receipt_id, String is_unlinked_refund, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String cvv, String bill_first_name, String bill_last_name, String bill_company_name, String bill_address1, String bill_address2, String bill_address3, String bill_city, String bill_locality, String bill_country, String bill_state_prov, String bill_zip, String bill_phone, String bill_cell_phone, String bill_work_phone, String bill_email){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"payment_transaction_id", getValue("Long", payment_transaction_id));
        addParameters(parameters,"reason_code", getValue("Long", reason_code));
        addParameters(parameters,"total_refund_amount", getValue("Double", total_refund_amount));
        addParameters(parameters,"refund_check_number", getValue("String", refund_check_number));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"auto_calc_refund", getValue("String", auto_calc_refund));
        RestUtilities.addParameterValuesFromArray(parameters, invoices_to_reverse);
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"is_unlinked_refund", getValue("String", is_unlinked_refund));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        
        return this.buildIssueRefundToAcctHashMap(parameters);
    }

    public Map<String,Object> issueRefundToAcct(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long payment_transaction_id = (Long) map.get("payment_transaction_id");
        Long reason_code = (Long) map.get("reason_code");
        Double total_refund_amount = (Double) map.get("total_refund_amount");
        String refund_check_number = (String) map.get("refund_check_number");
        String comments = (String) map.get("comments");
        String do_write = (String) map.get("do_write");
        String auto_calc_refund = (String) map.get("auto_calc_refund");
        com.aria.common.shared.InvoicesToReverseArray invoices_to_reverse = (com.aria.common.shared.InvoicesToReverseArray) map.get("invoices_to_reverse");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String is_unlinked_refund = (String) map.get("is_unlinked_refund");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String cvv = (String) map.get("cvv");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_address3 = (String) map.get("bill_address3");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_country = (String) map.get("bill_country");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_phone = (String) map.get("bill_phone");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_email = (String) map.get("bill_email");
        
        return issueRefundToAcct(client_no, auth_key, acct_no, payment_transaction_id, reason_code, total_refund_amount, refund_check_number, comments, do_write, auto_calc_refund, invoices_to_reverse, client_receipt_id, is_unlinked_refund, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, cvv, bill_first_name, bill_last_name, bill_company_name, bill_address1, bill_address2, bill_address3, bill_city, bill_locality, bill_country, bill_state_prov, bill_zip, bill_phone, bill_cell_phone, bill_work_phone, bill_email);
    }
        private Map<String,Object> buildIssueRefundToAcctHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "issue_refund_to_acct", parameters);
        String[] returnValues = new String[6];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "applied_total_refund_amount";
        returnValues[3] = "applied_total_reversal_amount";
        returnValues[4] = "transaction_id";
        returnValues[5] = "reversed_invoice_lines";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> managePendingInvoice(Long client_no, String auth_key, Long invoice_no, Long acct_no, Long action_directive, Long bill_seq, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String alt_collect_on_approve, String alt_send_statement_on_approve, String cancel_orders_on_discard, String bank_acct_type, String bill_address3, String track_data1, String track_data2, String client_receipt_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String custom_status_label, String client_notes){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"invoice_no", getValue("Long", invoice_no));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"action_directive", getValue("Long", action_directive));
        addParameters(parameters,"bill_seq", getValue("Long", bill_seq));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"alt_collect_on_approve", getValue("String", alt_collect_on_approve));
        addParameters(parameters,"alt_send_statement_on_approve", getValue("String", alt_send_statement_on_approve));
        addParameters(parameters,"cancel_orders_on_discard", getValue("String", cancel_orders_on_discard));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"custom_status_label", getValue("String", custom_status_label));
        addParameters(parameters,"client_notes", getValue("String", client_notes));
        
        return this.buildManagePendingInvoiceHashMap(parameters);
    }

    public Map<String,Object> managePendingInvoice(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long invoice_no = (Long) map.get("invoice_no");
        Long acct_no = (Long) map.get("acct_no");
        Long action_directive = (Long) map.get("action_directive");
        Long bill_seq = (Long) map.get("bill_seq");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String cvv = (String) map.get("cvv");
        String alt_collect_on_approve = (String) map.get("alt_collect_on_approve");
        String alt_send_statement_on_approve = (String) map.get("alt_send_statement_on_approve");
        String cancel_orders_on_discard = (String) map.get("cancel_orders_on_discard");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String bill_address3 = (String) map.get("bill_address3");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        String custom_status_label = (String) map.get("custom_status_label");
        String client_notes = (String) map.get("client_notes");
        
        return managePendingInvoice(client_no, auth_key, invoice_no, acct_no, action_directive, bill_seq, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, cvv, alt_collect_on_approve, alt_send_statement_on_approve, cancel_orders_on_discard, bank_acct_type, bill_address3, track_data1, track_data2, client_receipt_id, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, custom_status_label, client_notes);
    }
        private Map<String,Object> buildManagePendingInvoiceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "manage_pending_invoice", parameters);
        String[] returnValues = new String[15];
        
        returnValues[0] = "new_invoice_no";
        returnValues[1] = "collection_error_code";
        returnValues[2] = "collection_error_msg";
        returnValues[3] = "statement_error_code";
        returnValues[4] = "statement_error_msg";
        returnValues[5] = "proc_cvv_response";
        returnValues[6] = "proc_avs_response";
        returnValues[7] = "proc_cavv_response";
        returnValues[8] = "proc_status_code";
        returnValues[9] = "proc_status_text";
        returnValues[10] = "proc_payment_id";
        returnValues[11] = "proc_auth_code";
        returnValues[12] = "proc_merch_comments";
        returnValues[13] = "error_code";
        returnValues[14] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> movePayment(Long client_no, String auth_key, Long account_no, Long payment_id, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"payment_id", getValue("Long", payment_id));
        RestUtilities.addParameterValuesFromArray(parameters, specific_charge_transaction_id);
        
        return this.buildMovePaymentHashMap(parameters);
    }

    public Map<String,Object> movePayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long payment_id = (Long) map.get("payment_id");
        com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id = (com.aria.common.shared.SpecificChargeTransactionIdArray) map.get("specific_charge_transaction_id");
        
        return movePayment(client_no, auth_key, account_no, payment_id, specific_charge_transaction_id);
    }
        private Map<String,Object> buildMovePaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "move_payment", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> preCalcInvoice(Long client_no, String auth_key, String log_id, String first_name, String mi, String last_name, String address1, String address2, String city, String state_prov_code, String zip_code, String country_code, String currency_code, com.aria.common.shared.PreCalcPlanArray pre_calc_plan, com.aria.common.shared.PreCalcSkuArray pre_calc_sku, Long tax_exempt_cd, String address3){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"log_id", getValue("String", log_id));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"mi", getValue("String", mi));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"state_prov_code", getValue("String", state_prov_code));
        addParameters(parameters,"zip_code", getValue("String", zip_code));
        addParameters(parameters,"country_code", getValue("String", country_code));
        addParameters(parameters,"currency_code", getValue("String", currency_code));
        RestUtilities.addParameterValuesFromArray(parameters, pre_calc_plan);
        RestUtilities.addParameterValuesFromArray(parameters, pre_calc_sku);
        addParameters(parameters,"tax_exempt_cd", getValue("Long", tax_exempt_cd));
        addParameters(parameters,"address3", getValue("String", address3));
        
        return this.buildPreCalcInvoiceHashMap(parameters);
    }

    public Map<String,Object> preCalcInvoice(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String log_id = (String) map.get("log_id");
        String first_name = (String) map.get("first_name");
        String mi = (String) map.get("mi");
        String last_name = (String) map.get("last_name");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String state_prov_code = (String) map.get("state_prov_code");
        String zip_code = (String) map.get("zip_code");
        String country_code = (String) map.get("country_code");
        String currency_code = (String) map.get("currency_code");
        com.aria.common.shared.PreCalcPlanArray pre_calc_plan = (com.aria.common.shared.PreCalcPlanArray) map.get("pre_calc_plan");
        com.aria.common.shared.PreCalcSkuArray pre_calc_sku = (com.aria.common.shared.PreCalcSkuArray) map.get("pre_calc_sku");
        Long tax_exempt_cd = (Long) map.get("tax_exempt_cd");
        String address3 = (String) map.get("address3");
        
        return preCalcInvoice(client_no, auth_key, log_id, first_name, mi, last_name, address1, address2, city, state_prov_code, zip_code, country_code, currency_code, pre_calc_plan, pre_calc_sku, tax_exempt_cd, address3);
    }
        private Map<String,Object> buildPreCalcInvoiceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "pre_calc_invoice", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "inv_calc_out";
        returnValues[3] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> recordAlternativePayment(Long client_no, String auth_key, Long acct_no, String client_acct_id, String reference_code, Double payment_amount, Long processor_id, Long pay_method, Long statement_no, String comments, String client_receipt_id, String allow_recurring){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"reference_code", getValue("String", reference_code));
        addParameters(parameters,"payment_amount", getValue("Double", payment_amount));
        addParameters(parameters,"processor_id", getValue("Long", processor_id));
        addParameters(parameters,"pay_method", getValue("Long", pay_method));
        addParameters(parameters,"statement_no", getValue("Long", statement_no));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"allow_recurring", getValue("String", allow_recurring));
        
        return this.buildRecordAlternativePaymentHashMap(parameters);
    }

    public Map<String,Object> recordAlternativePayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        String reference_code = (String) map.get("reference_code");
        Double payment_amount = (Double) map.get("payment_amount");
        Long processor_id = (Long) map.get("processor_id");
        Long pay_method = (Long) map.get("pay_method");
        Long statement_no = (Long) map.get("statement_no");
        String comments = (String) map.get("comments");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String allow_recurring = (String) map.get("allow_recurring");
        
        return recordAlternativePayment(client_no, auth_key, acct_no, client_acct_id, reference_code, payment_amount, processor_id, pay_method, statement_no, comments, client_receipt_id, allow_recurring);
    }
        private Map<String,Object> buildRecordAlternativePaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "record_alternative_payment", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "auth_no";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> recordExternalPayment(Long client_no, String auth_key, Long account_no, String reference_code, Double payment_amount, String comments, String client_receipt_id, com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id, Long external_destination_id, String external_id, com.aria.common.shared.InvoiceNoArray invoice_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"reference_code", getValue("String", reference_code));
        addParameters(parameters,"payment_amount", getValue("Double", payment_amount));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        RestUtilities.addParameterValuesFromArray(parameters, specific_charge_transaction_id);
        addParameters(parameters,"external_destination_id", getValue("Long", external_destination_id));
        addParameters(parameters,"external_id", getValue("String", external_id));
        RestUtilities.addParameterValuesFromArray(parameters, invoice_no);
        
        return this.buildRecordExternalPaymentHashMap(parameters);
    }

    public Map<String,Object> recordExternalPayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String reference_code = (String) map.get("reference_code");
        Double payment_amount = (Double) map.get("payment_amount");
        String comments = (String) map.get("comments");
        String client_receipt_id = (String) map.get("client_receipt_id");
        com.aria.common.shared.SpecificChargeTransactionIdArray specific_charge_transaction_id = (com.aria.common.shared.SpecificChargeTransactionIdArray) map.get("specific_charge_transaction_id");
        Long external_destination_id = (Long) map.get("external_destination_id");
        String external_id = (String) map.get("external_id");
        com.aria.common.shared.InvoiceNoArray invoice_no = (com.aria.common.shared.InvoiceNoArray) map.get("invoice_no");
        
        return recordExternalPayment(client_no, auth_key, account_no, reference_code, payment_amount, comments, client_receipt_id, specific_charge_transaction_id, external_destination_id, external_id, invoice_no);
    }
        private Map<String,Object> buildRecordExternalPaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "record_external_payment", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> recordOutGoingPayment(Long client_no, String auth_key, Long account_no, Double payment_amount, String reference_code, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"payment_amount", getValue("Double", payment_amount));
        addParameters(parameters,"reference_code", getValue("String", reference_code));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildRecordOutGoingPaymentHashMap(parameters);
    }

    public Map<String,Object> recordOutGoingPayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Double payment_amount = (Double) map.get("payment_amount");
        String reference_code = (String) map.get("reference_code");
        String comments = (String) map.get("comments");
        
        return recordOutGoingPayment(client_no, auth_key, account_no, payment_amount, reference_code, comments);
    }
        private Map<String,Object> buildRecordOutGoingPaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "record_out_going_payment", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> recordStandingOrder(Long client_no, String auth_key, Long account_no, Long billing_interval_units, Long times_to_bill, String billing_interval_type, String first_bill_date, com.aria.common.shared.StandingOrderArray standing_order, String client_order_id, String client_receipt_id, String statement_message, String order_comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"billing_interval_units", getValue("Long", billing_interval_units));
        addParameters(parameters,"times_to_bill", getValue("Long", times_to_bill));
        addParameters(parameters,"billing_interval_type", getValue("String", billing_interval_type));
        addParameters(parameters,"first_bill_date", getValue("String", first_bill_date));
        RestUtilities.addParameterValuesFromArray(parameters, standing_order);
        addParameters(parameters,"client_order_id", getValue("String", client_order_id));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"statement_message", getValue("String", statement_message));
        addParameters(parameters,"order_comments", getValue("String", order_comments));
        
        return this.buildRecordStandingOrderHashMap(parameters);
    }

    public Map<String,Object> recordStandingOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long billing_interval_units = (Long) map.get("billing_interval_units");
        Long times_to_bill = (Long) map.get("times_to_bill");
        String billing_interval_type = (String) map.get("billing_interval_type");
        String first_bill_date = (String) map.get("first_bill_date");
        com.aria.common.shared.StandingOrderArray standing_order = (com.aria.common.shared.StandingOrderArray) map.get("standing_order");
        String client_order_id = (String) map.get("client_order_id");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String statement_message = (String) map.get("statement_message");
        String order_comments = (String) map.get("order_comments");
        
        return recordStandingOrder(client_no, auth_key, account_no, billing_interval_units, times_to_bill, billing_interval_type, first_bill_date, standing_order, client_order_id, client_receipt_id, statement_message, order_comments);
    }
        private Map<String,Object> buildRecordStandingOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "record_standing_order", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "standing_order_no";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> recordUsage(Long client_no, String auth_key, Long acct_no, String userid, Long usage_type, Double usage_units, String usage_type_code, String usage_date, Double billable_units, Double amt, Double rate, String telco_from, String telco_to, String comments, String exclude_from_billing, String exclusion_comments, String qualifier_1, String qualifier_2, String qualifier_3, String qualifier_4, Long parent_usage_rec_no, String client_record_id, String caller_id, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"userid", getValue("String", userid));
        addParameters(parameters,"usage_type", getValue("Long", usage_type));
        addParameters(parameters,"usage_units", getValue("Double", usage_units));
        addParameters(parameters,"usage_type_code", getValue("String", usage_type_code));
        addParameters(parameters,"usage_date", getValue("String", usage_date));
        addParameters(parameters,"billable_units", getValue("Double", billable_units));
        addParameters(parameters,"amt", getValue("Double", amt));
        addParameters(parameters,"rate", getValue("Double", rate));
        addParameters(parameters,"telco_from", getValue("String", telco_from));
        addParameters(parameters,"telco_to", getValue("String", telco_to));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"exclude_from_billing", getValue("String", exclude_from_billing));
        addParameters(parameters,"exclusion_comments", getValue("String", exclusion_comments));
        addParameters(parameters,"qualifier_1", getValue("String", qualifier_1));
        addParameters(parameters,"qualifier_2", getValue("String", qualifier_2));
        addParameters(parameters,"qualifier_3", getValue("String", qualifier_3));
        addParameters(parameters,"qualifier_4", getValue("String", qualifier_4));
        addParameters(parameters,"parent_usage_rec_no", getValue("Long", parent_usage_rec_no));
        addParameters(parameters,"client_record_id", getValue("String", client_record_id));
        addParameters(parameters,"caller_id", getValue("String", caller_id));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildRecordUsageHashMap(parameters);
    }

    public Map<String,Object> recordUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String userid = (String) map.get("userid");
        Long usage_type = (Long) map.get("usage_type");
        Double usage_units = (Double) map.get("usage_units");
        String usage_type_code = (String) map.get("usage_type_code");
        String usage_date = (String) map.get("usage_date");
        Double billable_units = (Double) map.get("billable_units");
        Double amt = (Double) map.get("amt");
        Double rate = (Double) map.get("rate");
        String telco_from = (String) map.get("telco_from");
        String telco_to = (String) map.get("telco_to");
        String comments = (String) map.get("comments");
        String exclude_from_billing = (String) map.get("exclude_from_billing");
        String exclusion_comments = (String) map.get("exclusion_comments");
        String qualifier_1 = (String) map.get("qualifier_1");
        String qualifier_2 = (String) map.get("qualifier_2");
        String qualifier_3 = (String) map.get("qualifier_3");
        String qualifier_4 = (String) map.get("qualifier_4");
        Long parent_usage_rec_no = (Long) map.get("parent_usage_rec_no");
        String client_record_id = (String) map.get("client_record_id");
        String caller_id = (String) map.get("caller_id");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return recordUsage(client_no, auth_key, acct_no, userid, usage_type, usage_units, usage_type_code, usage_date, billable_units, amt, rate, telco_from, telco_to, comments, exclude_from_billing, exclusion_comments, qualifier_1, qualifier_2, qualifier_3, qualifier_4, parent_usage_rec_no, client_record_id, caller_id, client_receipt_id);
    }
        private Map<String,Object> buildRecordUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "record_usage", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_rec_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> reinstateTransaction(Long client_no, String auth_key, Long account_no, Long transaction_id, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildReinstateTransactionHashMap(parameters);
    }

    public Map<String,Object> reinstateTransaction(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long transaction_id = (Long) map.get("transaction_id");
        String comments = (String) map.get("comments");
        
        return reinstateTransaction(client_no, auth_key, account_no, transaction_id, comments);
    }
        private Map<String,Object> buildReinstateTransactionHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "reinstate_transaction", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "new_transaction_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> reverseAuthorizedElectronicPayment(Long client_no, String auth_key, Long acct_no, Long auth_no, Long reason_code, String comments, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"auth_no", getValue("Long", auth_no));
        addParameters(parameters,"reason_code", getValue("Long", reason_code));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildReverseAuthorizedElectronicPaymentHashMap(parameters);
    }

    public Map<String,Object> reverseAuthorizedElectronicPayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long auth_no = (Long) map.get("auth_no");
        Long reason_code = (Long) map.get("reason_code");
        String comments = (String) map.get("comments");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return reverseAuthorizedElectronicPayment(client_no, auth_key, acct_no, auth_no, reason_code, comments, client_receipt_id);
    }
        private Map<String,Object> buildReverseAuthorizedElectronicPaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "reverse_authorized_electronic_payment", parameters);
        String[] returnValues = new String[8];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "applied_total_reversal_amount";
        returnValues[3] = "proc_status_code";
        returnValues[4] = "proc_status_text";
        returnValues[5] = "proc_auth_id";
        returnValues[6] = "proc_auth_code";
        returnValues[7] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> settleAccountBalance(Long client_no, String auth_key, Long account_no, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bank_acct_type, String bill_address3, String alt_client_acct_group_id, String track_data1, String track_data2, String force_balance_scope, String client_receipt_id, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"force_balance_scope", getValue("String", force_balance_scope));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        
        return this.buildSettleAccountBalanceHashMap(parameters);
    }

    public Map<String,Object> settleAccountBalance(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String cvv = (String) map.get("cvv");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String bill_address3 = (String) map.get("bill_address3");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        String force_balance_scope = (String) map.get("force_balance_scope");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        
        return settleAccountBalance(client_no, auth_key, account_no, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, cvv, bank_acct_type, bill_address3, alt_client_acct_group_id, track_data1, track_data2, force_balance_scope, client_receipt_id, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd);
    }
        private Map<String,Object> buildSettleAccountBalanceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "settle_account_balance", parameters);
        String[] returnValues = new String[11];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "proc_cvv_response";
        returnValues[2] = "proc_avs_response";
        returnValues[3] = "proc_cavv_response";
        returnValues[4] = "proc_status_code";
        returnValues[5] = "proc_status_text";
        returnValues[6] = "proc_payment_id";
        returnValues[7] = "proc_auth_code";
        returnValues[8] = "proc_merch_comments";
        returnValues[9] = "error_code";
        returnValues[10] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> settleDisputeHold(Long client_no, String auth_key, Long acct_no, Long dispute_no, Long settlement_action, String comments, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"dispute_no", getValue("Long", dispute_no));
        addParameters(parameters,"settlement_action", getValue("Long", settlement_action));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildSettleDisputeHoldHashMap(parameters);
    }

    public Map<String,Object> settleDisputeHold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long dispute_no = (Long) map.get("dispute_no");
        Long settlement_action = (Long) map.get("settlement_action");
        String comments = (String) map.get("comments");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return settleDisputeHold(client_no, auth_key, acct_no, dispute_no, settlement_action, comments, client_receipt_id);
    }
        private Map<String,Object> buildSettleDisputeHoldHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "settle_dispute_hold", parameters);
        String[] returnValues = new String[15];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "rec_no";
        returnValues[3] = "created_by";
        returnValues[4] = "amount";
        returnValues[5] = "invoice_no";
        returnValues[6] = "invoice_date";
        returnValues[7] = "invoice_amt";
        returnValues[8] = "dispute_creation_date";
        returnValues[9] = "dispute_exp_date";
        returnValues[10] = "comments";
        returnValues[11] = "reason_code";
        returnValues[12] = "secondary_reason_code";
        returnValues[13] = "dispute_ind";
        returnValues[14] = "can_unsettle";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> transferAccountBalance(Long client_no, String auth_key, Long source_account_no, Long target_account_no, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"source_account_no", getValue("Long", source_account_no));
        addParameters(parameters,"target_account_no", getValue("Long", target_account_no));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildTransferAccountBalanceHashMap(parameters);
    }

    public Map<String,Object> transferAccountBalance(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long source_account_no = (Long) map.get("source_account_no");
        Long target_account_no = (Long) map.get("target_account_no");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return transferAccountBalance(client_no, auth_key, source_account_no, target_account_no, client_receipt_id);
    }
        private Map<String,Object> buildTransferAccountBalanceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "transfer_account_balance", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "balance_transferred";
        returnValues[2] = "error_code";
        returnValues[3] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctInvoice(Long client_no, String auth_key, Long account_no, Long src_transaction_id, String custom_status_label, String client_notes, Long posting_status_cd, String posting_user){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"src_transaction_id", getValue("Long", src_transaction_id));
        addParameters(parameters,"custom_status_label", getValue("String", custom_status_label));
        addParameters(parameters,"client_notes", getValue("String", client_notes));
        addParameters(parameters,"posting_status_cd", getValue("Long", posting_status_cd));
        addParameters(parameters,"posting_user", getValue("String", posting_user));
        
        return this.buildUpdateAcctInvoiceHashMap(parameters);
    }

    public Map<String,Object> updateAcctInvoice(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long src_transaction_id = (Long) map.get("src_transaction_id");
        String custom_status_label = (String) map.get("custom_status_label");
        String client_notes = (String) map.get("client_notes");
        Long posting_status_cd = (Long) map.get("posting_status_cd");
        String posting_user = (String) map.get("posting_user");
        
        return updateAcctInvoice(client_no, auth_key, account_no, src_transaction_id, custom_status_label, client_notes, posting_status_cd, posting_user);
    }
        private Map<String,Object> buildUpdateAcctInvoiceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_invoice", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateCcBlacklist(Long client_no, String auth_key, String cc_num, Long assignment_directive, Long acct_no, String client_acct_id, String notes, com.aria.common.shared.CreditCardPaymentMethodArray credit_card_payment_method){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"cc_num", getValue("String", cc_num));
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"notes", getValue("String", notes));
        RestUtilities.addParameterValuesFromArray(parameters, credit_card_payment_method);
        
        return this.buildUpdateCcBlacklistHashMap(parameters);
    }

    public Map<String,Object> updateCcBlacklist(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String cc_num = (String) map.get("cc_num");
        Long assignment_directive = (Long) map.get("assignment_directive");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        String notes = (String) map.get("notes");
        com.aria.common.shared.CreditCardPaymentMethodArray credit_card_payment_method = (com.aria.common.shared.CreditCardPaymentMethodArray) map.get("credit_card_payment_method");
        
        return updateCcBlacklist(client_no, auth_key, cc_num, assignment_directive, acct_no, client_acct_id, notes, credit_card_payment_method);
    }
        private Map<String,Object> buildUpdateCcBlacklistHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_cc_blacklist", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateOrder(Long client_no, String auth_key, Long account_no, Long order_no, Long bill_immediately, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_work_phone, String bill_work_phone_extension, String cvv, String bill_address3, String do_write, String alt_client_acct_group_id, String track_data1, String track_data2, Long alt_inv_template_no, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String fulfilled_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"order_no", getValue("Long", order_no));
        addParameters(parameters,"bill_immediately", getValue("Long", bill_immediately));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"alt_inv_template_no", getValue("Long", alt_inv_template_no));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"fulfilled_date", getValue("String", fulfilled_date));
        
        return this.buildUpdateOrderHashMap(parameters);
    }

    public Map<String,Object> updateOrder(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long order_no = (Long) map.get("order_no");
        Long bill_immediately = (Long) map.get("bill_immediately");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String cvv = (String) map.get("cvv");
        String bill_address3 = (String) map.get("bill_address3");
        String do_write = (String) map.get("do_write");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        Long alt_inv_template_no = (Long) map.get("alt_inv_template_no");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        String fulfilled_date = (String) map.get("fulfilled_date");
        
        return updateOrder(client_no, auth_key, account_no, order_no, bill_immediately, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_work_phone, bill_work_phone_extension, cvv, bill_address3, do_write, alt_client_acct_group_id, track_data1, track_data2, alt_inv_template_no, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, fulfilled_date);
    }
        private Map<String,Object> buildUpdateOrderHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_order", parameters);
        String[] returnValues = new String[22];
        
        returnValues[0] = "transaction_id";
        returnValues[1] = "invoicing_error_code";
        returnValues[2] = "invoicing_error_msg";
        returnValues[3] = "statement_error_cd";
        returnValues[4] = "statement_error_msg";
        returnValues[5] = "proc_cvv_response";
        returnValues[6] = "proc_avs_response";
        returnValues[7] = "proc_cavv_response";
        returnValues[8] = "proc_status_code";
        returnValues[9] = "proc_status_text";
        returnValues[10] = "proc_payment_id";
        returnValues[11] = "proc_auth_code";
        returnValues[12] = "proc_merch_comments";
        returnValues[13] = "invoice_no";
        returnValues[14] = "error_code";
        returnValues[15] = "error_msg";
        returnValues[16] = "total_charges_before_tax";
        returnValues[17] = "total_tax_charges";
        returnValues[18] = "total_charges_after_tax";
        returnValues[19] = "total_credit";
        returnValues[20] = "cart_invoice_line_items";
        returnValues[21] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateRefundCheckNo(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id, Long transaction_id, Long refund_check_number){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"acct_user_id", getValue("String", acct_user_id));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        addParameters(parameters,"refund_check_number", getValue("Long", refund_check_number));
        
        return this.buildUpdateRefundCheckNoHashMap(parameters);
    }

    public Map<String,Object> updateRefundCheckNo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String acct_user_id = (String) map.get("acct_user_id");
        String client_acct_id = (String) map.get("client_acct_id");
        Long transaction_id = (Long) map.get("transaction_id");
        Long refund_check_number = (Long) map.get("refund_check_number");
        
        return updateRefundCheckNo(client_no, auth_key, acct_no, acct_user_id, client_acct_id, transaction_id, refund_check_number);
    }
        private Map<String,Object> buildUpdateRefundCheckNoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_refund_check_no", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> voidTransaction(Long client_no, String auth_key, Long account_no, Long transaction_id, String comments, Long reason_code, String client_receipt_id, String discard_invoice_usage){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"reason_code", getValue("Long", reason_code));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"discard_invoice_usage", getValue("String", discard_invoice_usage));
        
        return this.buildVoidTransactionHashMap(parameters);
    }

    public Map<String,Object> voidTransaction(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long transaction_id = (Long) map.get("transaction_id");
        String comments = (String) map.get("comments");
        Long reason_code = (Long) map.get("reason_code");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String discard_invoice_usage = (String) map.get("discard_invoice_usage");
        
        return voidTransaction(client_no, auth_key, account_no, transaction_id, comments, reason_code, client_receipt_id, discard_invoice_usage);
    }
        private Map<String,Object> buildVoidTransactionHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "void_transaction", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "new_transaction_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPaypalAvsStatus(Long client_no, String auth_key, Long acct_no, Long client_acct_id, String email){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("Long", client_acct_id));
        addParameters(parameters,"email", getValue("String", email));
        
        return this.buildGetPaypalAvsStatusHashMap(parameters);
    }

    public Map<String,Object> getPaypalAvsStatus(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long client_acct_id = (Long) map.get("client_acct_id");
        String email = (String) map.get("email");
        
        return getPaypalAvsStatus(client_no, auth_key, acct_no, client_acct_id, email);
    }
        private Map<String,Object> buildGetPaypalAvsStatusHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_paypal_avs_status", parameters);
        String[] returnValues = new String[9];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "bill_agreement_id";
        returnValues[3] = "email";
        returnValues[4] = "paypal_confirmationcode";
        returnValues[5] = "paypal_streetmatch";
        returnValues[6] = "paypal_zipmatch";
        returnValues[7] = "paypal_countrycode";
        returnValues[8] = "paypal_token";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> initPaypalBillAgreement(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildInitPaypalBillAgreementHashMap(parameters);
    }

    public Map<String,Object> initPaypalBillAgreement(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return initPaypalBillAgreement(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildInitPaypalBillAgreementHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "init_paypal_bill_agreement", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "return_url";
        returnValues[3] = "token";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> savePaypalBillAgreement(Long client_no, String auth_key, Long acct_no, String token){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"token", getValue("String", token));
        
        return this.buildSavePaypalBillAgreementHashMap(parameters);
    }

    public Map<String,Object> savePaypalBillAgreement(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String token = (String) map.get("token");
        
        return savePaypalBillAgreement(client_no, auth_key, acct_no, token);
    }
        private Map<String,Object> buildSavePaypalBillAgreementHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "save_paypal_bill_agreement", parameters);
        String[] returnValues = new String[15];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "bill_agreement_id";
        returnValues[3] = "paypal_email";
        returnValues[4] = "paypal_payerid";
        returnValues[5] = "paypal_payerstatus";
        returnValues[6] = "paypal_countrycode";
        returnValues[7] = "paypal_shiptoname";
        returnValues[8] = "paypal_shiptostreet";
        returnValues[9] = "paypal_shipttostreet2";
        returnValues[10] = "paypal_shiptocity";
        returnValues[11] = "paypal_shiptostate";
        returnValues[12] = "paypal_shiptozip";
        returnValues[13] = "paypal_shiptocountrycode";
        returnValues[14] = "paypal_addressstatus";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> adjustBillingDates(Long client_no, String auth_key, Long acct_no, Long action_directive, Long adjustment_days, String adjustment_date, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"action_directive", getValue("Long", action_directive));
        addParameters(parameters,"adjustment_days", getValue("Long", adjustment_days));
        addParameters(parameters,"adjustment_date", getValue("String", adjustment_date));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildAdjustBillingDatesHashMap(parameters);
    }

    public Map<String,Object> adjustBillingDates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long action_directive = (Long) map.get("action_directive");
        Long adjustment_days = (Long) map.get("adjustment_days");
        String adjustment_date = (String) map.get("adjustment_date");
        String comments = (String) map.get("comments");
        
        return adjustBillingDates(client_no, auth_key, acct_no, action_directive, adjustment_days, adjustment_date, comments);
    }
        private Map<String,Object> buildAdjustBillingDatesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "adjust_billing_dates", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> applyCouponToAcct(Long client_no, String auth_key, Long acct_no, String coupon_code){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        
        return this.buildApplyCouponToAcctHashMap(parameters);
    }

    public Map<String,Object> applyCouponToAcct(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String coupon_code = (String) map.get("coupon_code");
        
        return applyCouponToAcct(client_no, auth_key, acct_no, coupon_code);
    }
        private Map<String,Object> buildApplyCouponToAcctHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "apply_coupon_to_acct", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "user_success_msg";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> assignCollectionsAcctGroup(Long client_no, String auth_key, Long acct_no, Long group_no, String client_acct_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"group_no", getValue("Long", group_no));
        addParameters(parameters,"client_acct_group_id", getValue("String", client_acct_group_id));
        
        return this.buildAssignCollectionsAcctGroupHashMap(parameters);
    }

    public Map<String,Object> assignCollectionsAcctGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long group_no = (Long) map.get("group_no");
        String client_acct_group_id = (String) map.get("client_acct_group_id");
        
        return assignCollectionsAcctGroup(client_no, auth_key, acct_no, group_no, client_acct_group_id);
    }
        private Map<String,Object> buildAssignCollectionsAcctGroupHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "assign_collections_acct_group", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> assignCustomAcctRates(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.CustomAcctRatesArray custom_acct_rates, Long plan_no, Long service_no, String client_plan_id, String client_service_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        RestUtilities.addParameterValuesFromArray(parameters, custom_acct_rates);
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        
        return this.buildAssignCustomAcctRatesHashMap(parameters);
    }

    public Map<String,Object> assignCustomAcctRates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        com.aria.common.shared.CustomAcctRatesArray custom_acct_rates = (com.aria.common.shared.CustomAcctRatesArray) map.get("custom_acct_rates");
        Long plan_no = (Long) map.get("plan_no");
        Long service_no = (Long) map.get("service_no");
        String client_plan_id = (String) map.get("client_plan_id");
        String client_service_id = (String) map.get("client_service_id");
        
        return assignCustomAcctRates(client_no, auth_key, acct_no, custom_acct_rates, plan_no, service_no, client_plan_id, client_service_id);
    }
        private Map<String,Object> buildAssignCustomAcctRatesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "assign_custom_acct_rates", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> assignFunctionalAcctGroup(Long client_no, String auth_key, Long acct_no, Long group_no, String client_acct_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"group_no", getValue("Long", group_no));
        addParameters(parameters,"client_acct_group_id", getValue("String", client_acct_group_id));
        
        return this.buildAssignFunctionalAcctGroupHashMap(parameters);
    }

    public Map<String,Object> assignFunctionalAcctGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long group_no = (Long) map.get("group_no");
        String client_acct_group_id = (String) map.get("client_acct_group_id");
        
        return assignFunctionalAcctGroup(client_no, auth_key, acct_no, group_no, client_acct_group_id);
    }
        private Map<String,Object> buildAssignFunctionalAcctGroupHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "assign_functional_acct_group", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> assignSuppPlan(Long client_no, String auth_key, Long acct_no, Long supp_plan_no, String client_supp_plan_id, Long alt_rate_schedule_no, Long num_plan_units, String coupon_code, Long assignment_directive, String comments, String do_write, String client_receipt_id, Long contract_type_no, Double contract_alt_recur_fee, Long contract_length_months, Double contract_cancel_fee, String contract_comments, String contract_start_date, Long offset_months, Long auto_offset_months_option, String alt_proration_start_date, String alt_client_acct_group_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String contract_end_date, Long sync_mstr_bill_dates_override, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"supp_plan_no", getValue("Long", supp_plan_no));
        addParameters(parameters,"client_supp_plan_id", getValue("String", client_supp_plan_id));
        addParameters(parameters,"alt_rate_schedule_no", getValue("Long", alt_rate_schedule_no));
        addParameters(parameters,"num_plan_units", getValue("Long", num_plan_units));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"contract_type_no", getValue("Long", contract_type_no));
        addParameters(parameters,"contract_alt_recur_fee", getValue("Double", contract_alt_recur_fee));
        addParameters(parameters,"contract_length_months", getValue("Long", contract_length_months));
        addParameters(parameters,"contract_cancel_fee", getValue("Double", contract_cancel_fee));
        addParameters(parameters,"contract_comments", getValue("String", contract_comments));
        addParameters(parameters,"contract_start_date", getValue("String", contract_start_date));
        addParameters(parameters,"offset_months", getValue("Long", offset_months));
        addParameters(parameters,"auto_offset_months_option", getValue("Long", auto_offset_months_option));
        addParameters(parameters,"alt_proration_start_date", getValue("String", alt_proration_start_date));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_custom_rates);
        addParameters(parameters,"effective_date", getValue("String", effective_date));
        addParameters(parameters,"offset_interval", getValue("Long", offset_interval));
        addParameters(parameters,"contract_end_date", getValue("String", contract_end_date));
        addParameters(parameters,"sync_mstr_bill_dates_override", getValue("Long", sync_mstr_bill_dates_override));
        addParameters(parameters,"client_alt_rate_schedule_id", getValue("String", client_alt_rate_schedule_id));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no);
        
        return this.buildAssignSuppPlanHashMap(parameters);
    }

    public Map<String,Object> assignSuppPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long supp_plan_no = (Long) map.get("supp_plan_no");
        String client_supp_plan_id = (String) map.get("client_supp_plan_id");
        Long alt_rate_schedule_no = (Long) map.get("alt_rate_schedule_no");
        Long num_plan_units = (Long) map.get("num_plan_units");
        String coupon_code = (String) map.get("coupon_code");
        Long assignment_directive = (Long) map.get("assignment_directive");
        String comments = (String) map.get("comments");
        String do_write = (String) map.get("do_write");
        String client_receipt_id = (String) map.get("client_receipt_id");
        Long contract_type_no = (Long) map.get("contract_type_no");
        Double contract_alt_recur_fee = (Double) map.get("contract_alt_recur_fee");
        Long contract_length_months = (Long) map.get("contract_length_months");
        Double contract_cancel_fee = (Double) map.get("contract_cancel_fee");
        String contract_comments = (String) map.get("contract_comments");
        String contract_start_date = (String) map.get("contract_start_date");
        Long offset_months = (Long) map.get("offset_months");
        Long auto_offset_months_option = (Long) map.get("auto_offset_months_option");
        String alt_proration_start_date = (String) map.get("alt_proration_start_date");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates = (com.aria.common.shared.NewAcctCustomRatesArray) map.get("new_acct_custom_rates");
        String effective_date = (String) map.get("effective_date");
        Long offset_interval = (Long) map.get("offset_interval");
        String contract_end_date = (String) map.get("contract_end_date");
        Long sync_mstr_bill_dates_override = (Long) map.get("sync_mstr_bill_dates_override");
        String client_alt_rate_schedule_id = (String) map.get("client_alt_rate_schedule_id");
        com.aria.common.shared.SurchargeNoArray surcharge_no = (com.aria.common.shared.SurchargeNoArray) map.get("surcharge_no");
        
        return assignSuppPlan(client_no, auth_key, acct_no, supp_plan_no, client_supp_plan_id, alt_rate_schedule_no, num_plan_units, coupon_code, assignment_directive, comments, do_write, client_receipt_id, contract_type_no, contract_alt_recur_fee, contract_length_months, contract_cancel_fee, contract_comments, contract_start_date, offset_months, auto_offset_months_option, alt_proration_start_date, alt_client_acct_group_id, new_acct_custom_rates, effective_date, offset_interval, contract_end_date, sync_mstr_bill_dates_override, client_alt_rate_schedule_id, surcharge_no);
    }
        private Map<String,Object> buildAssignSuppPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "assign_supp_plan", parameters);
        String[] returnValues = new String[16];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "invoice_no";
        returnValues[4] = "supp_plan_line_items";
        returnValues[5] = "total_charges_before_tax";
        returnValues[6] = "total_tax_charges";
        returnValues[7] = "total_charges_after_tax";
        returnValues[8] = "total_credit";
        returnValues[9] = "total_tax_credit";
        returnValues[10] = "total_credit_before_tax";
        returnValues[11] = "total";
        returnValues[12] = "expectd_activation_fee";
        returnValues[13] = "expectd_mthly_recurring_cost";
        returnValues[14] = "expectd_annu_recurring_cost";
        returnValues[15] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> assignSuppPlanMulti(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.SuppPlansToAssignArray supp_plans_to_assign, Long assignment_directive, String do_write, String comments, String client_receipt_id, String alt_proration_start_date, com.aria.common.shared.CouponCodesArray coupon_codes, String effective_date, Long sync_mstr_bill_dates_override, com.aria.common.shared.SuppPlanSurchargesArray supp_plan_surcharges, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        RestUtilities.addParameterValuesFromArray(parameters, supp_plans_to_assign);
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"alt_proration_start_date", getValue("String", alt_proration_start_date));
        RestUtilities.addParameterValuesFromArray(parameters, coupon_codes);
        addParameters(parameters,"effective_date", getValue("String", effective_date));
        addParameters(parameters,"sync_mstr_bill_dates_override", getValue("Long", sync_mstr_bill_dates_override));
        RestUtilities.addParameterValuesFromArray(parameters, supp_plan_surcharges);
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_custom_rates);
        
        return this.buildAssignSuppPlanMultiHashMap(parameters);
    }

    public Map<String,Object> assignSuppPlanMulti(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        com.aria.common.shared.SuppPlansToAssignArray supp_plans_to_assign = (com.aria.common.shared.SuppPlansToAssignArray) map.get("supp_plans_to_assign");
        Long assignment_directive = (Long) map.get("assignment_directive");
        String do_write = (String) map.get("do_write");
        String comments = (String) map.get("comments");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String alt_proration_start_date = (String) map.get("alt_proration_start_date");
        com.aria.common.shared.CouponCodesArray coupon_codes = (com.aria.common.shared.CouponCodesArray) map.get("coupon_codes");
        String effective_date = (String) map.get("effective_date");
        Long sync_mstr_bill_dates_override = (Long) map.get("sync_mstr_bill_dates_override");
        com.aria.common.shared.SuppPlanSurchargesArray supp_plan_surcharges = (com.aria.common.shared.SuppPlanSurchargesArray) map.get("supp_plan_surcharges");
        com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates = (com.aria.common.shared.NewAcctCustomRatesArray) map.get("new_acct_custom_rates");
        
        return assignSuppPlanMulti(client_no, auth_key, acct_no, supp_plans_to_assign, assignment_directive, do_write, comments, client_receipt_id, alt_proration_start_date, coupon_codes, effective_date, sync_mstr_bill_dates_override, supp_plan_surcharges, new_acct_custom_rates);
    }
        private Map<String,Object> buildAssignSuppPlanMultiHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "assign_supp_plan_multi", parameters);
        String[] returnValues = new String[28];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "invoice_no";
        returnValues[4] = "multi_sp_invoice_line_items";
        returnValues[5] = "collection_error_code";
        returnValues[6] = "collection_error_msg";
        returnValues[7] = "statement_error_code";
        returnValues[8] = "statement_error_msg";
        returnValues[9] = "proc_cvv_response";
        returnValues[10] = "proc_avs_response";
        returnValues[11] = "proc_cavv_response";
        returnValues[12] = "proc_status_code";
        returnValues[13] = "proc_status_text";
        returnValues[14] = "proc_payment_id";
        returnValues[15] = "proc_auth_code";
        returnValues[16] = "proc_merch_comments";
        returnValues[17] = "total_charges_before_tax";
        returnValues[18] = "total_tax_charges";
        returnValues[19] = "total_charges_after_tax";
        returnValues[20] = "total_credit";
        returnValues[21] = "total_tax_credit";
        returnValues[22] = "total_credit_before_tax";
        returnValues[23] = "total";
        returnValues[24] = "expectd_activation_fee";
        returnValues[25] = "expectd_mthly_recurring_cost";
        returnValues[26] = "expectd_annu_recurring_cost";
        returnValues[27] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> authorizeElectronicPayment(Long client_no, String auth_key, Long account_number, Double amount, Long payment_source, String CVV, Long bill_seq, String inTrackingNumber, String inAuthValue, String alt_client_acct_group_id, String track_data1, String track_data2, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String bank_acct_type, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_address3, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String record_cc_on_auth_failure, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_number", getValue("Long", account_number));
        addParameters(parameters,"amount", getValue("Double", amount));
        addParameters(parameters,"payment_source", getValue("Long", payment_source));
        addParameters(parameters,"CVV", getValue("String", CVV));
        addParameters(parameters,"bill_seq", getValue("Long", bill_seq));
        addParameters(parameters,"inTrackingNumber", getValue("String", inTrackingNumber));
        addParameters(parameters,"inAuthValue", getValue("String", inAuthValue));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"record_cc_on_auth_failure", getValue("String", record_cc_on_auth_failure));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        
        return this.buildAuthorizeElectronicPaymentHashMap(parameters);
    }

    public Map<String,Object> authorizeElectronicPayment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_number = (Long) map.get("account_number");
        Double amount = (Double) map.get("amount");
        Long payment_source = (Long) map.get("payment_source");
        String CVV = (String) map.get("CVV");
        Long bill_seq = (Long) map.get("bill_seq");
        String inTrackingNumber = (String) map.get("inTrackingNumber");
        String inAuthValue = (String) map.get("inAuthValue");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_address3 = (String) map.get("bill_address3");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String record_cc_on_auth_failure = (String) map.get("record_cc_on_auth_failure");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        
        return authorizeElectronicPayment(client_no, auth_key, account_number, amount, payment_source, CVV, bill_seq, inTrackingNumber, inAuthValue, alt_client_acct_group_id, track_data1, track_data2, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, bank_acct_type, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_address3, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, record_cc_on_auth_failure, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd);
    }
        private Map<String,Object> buildAuthorizeElectronicPaymentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "authorize_electronic_payment", parameters);
        String[] returnValues = new String[10];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proc_cvv_response";
        returnValues[3] = "proc_avs_response";
        returnValues[4] = "proc_cavv_response";
        returnValues[5] = "proc_status_code";
        returnValues[6] = "proc_status_text";
        returnValues[7] = "proc_payment_id";
        returnValues[8] = "proc_auth_code";
        returnValues[9] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> banAcct(Long client_no, String auth_key, Long account_no, String userid, Long days_to_restore, String date_to_restore, Long reason_cd, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"userid", getValue("String", userid));
        addParameters(parameters,"days_to_restore", getValue("Long", days_to_restore));
        addParameters(parameters,"date_to_restore", getValue("String", date_to_restore));
        addParameters(parameters,"reason_cd", getValue("Long", reason_cd));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildBanAcctHashMap(parameters);
    }

    public Map<String,Object> banAcct(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String userid = (String) map.get("userid");
        Long days_to_restore = (Long) map.get("days_to_restore");
        String date_to_restore = (String) map.get("date_to_restore");
        Long reason_cd = (Long) map.get("reason_cd");
        String comments = (String) map.get("comments");
        
        return banAcct(client_no, auth_key, account_no, userid, days_to_restore, date_to_restore, reason_cd, comments);
    }
        private Map<String,Object> buildBanAcctHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "ban_acct", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, String update_comments, Long close_status){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"contract_no", getValue("Long", contract_no));
        addParameters(parameters,"update_comments", getValue("String", update_comments));
        addParameters(parameters,"close_status", getValue("Long", close_status));
        
        return this.buildCancelAcctMultiplanContractHashMap(parameters);
    }

    public Map<String,Object> cancelAcctMultiplanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long contract_no = (Long) map.get("contract_no");
        String update_comments = (String) map.get("update_comments");
        Long close_status = (Long) map.get("close_status");
        
        return cancelAcctMultiplanContract(client_no, auth_key, acct_no, contract_no, update_comments, close_status);
    }
        private Map<String,Object> buildCancelAcctMultiplanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_acct_multiplan_contract", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, String update_comments, Long close_status){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"contract_no", getValue("Long", contract_no));
        addParameters(parameters,"update_comments", getValue("String", update_comments));
        addParameters(parameters,"close_status", getValue("Long", close_status));
        
        return this.buildCancelAcctPlanContractHashMap(parameters);
    }

    public Map<String,Object> cancelAcctPlanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long contract_no = (Long) map.get("contract_no");
        String update_comments = (String) map.get("update_comments");
        Long close_status = (Long) map.get("close_status");
        
        return cancelAcctPlanContract(client_no, auth_key, acct_no, contract_no, update_comments, close_status);
    }
        private Map<String,Object> buildCancelAcctPlanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_acct_plan_contract", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelAcctUniversalContract(Long client_no, String auth_key, Long acct_no, String update_comments, Long close_status){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"update_comments", getValue("String", update_comments));
        addParameters(parameters,"close_status", getValue("Long", close_status));
        
        return this.buildCancelAcctUniversalContractHashMap(parameters);
    }

    public Map<String,Object> cancelAcctUniversalContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String update_comments = (String) map.get("update_comments");
        Long close_status = (Long) map.get("close_status");
        
        return cancelAcctUniversalContract(client_no, auth_key, acct_no, update_comments, close_status);
    }
        private Map<String,Object> buildCancelAcctUniversalContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_acct_universal_contract", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelQueuedServicePlan(Long client_no, String auth_key, Long account_number, com.aria.common.shared.PlanNoToRemoveArray plan_no_to_remove, String remove_all_queued_plan_no, String remove_terminate_pending, String reactivate_terminate_pending){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_number", getValue("Long", account_number));
        RestUtilities.addParameterValuesFromArray(parameters, plan_no_to_remove);
        addParameters(parameters,"remove_all_queued_plan_no", getValue("String", remove_all_queued_plan_no));
        addParameters(parameters,"remove_terminate_pending", getValue("String", remove_terminate_pending));
        addParameters(parameters,"reactivate_terminate_pending", getValue("String", reactivate_terminate_pending));
        
        return this.buildCancelQueuedServicePlanHashMap(parameters);
    }

    public Map<String,Object> cancelQueuedServicePlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_number = (Long) map.get("account_number");
        com.aria.common.shared.PlanNoToRemoveArray plan_no_to_remove = (com.aria.common.shared.PlanNoToRemoveArray) map.get("plan_no_to_remove");
        String remove_all_queued_plan_no = (String) map.get("remove_all_queued_plan_no");
        String remove_terminate_pending = (String) map.get("remove_terminate_pending");
        String reactivate_terminate_pending = (String) map.get("reactivate_terminate_pending");
        
        return cancelQueuedServicePlan(client_no, auth_key, account_number, plan_no_to_remove, remove_all_queued_plan_no, remove_terminate_pending, reactivate_terminate_pending);
    }
        private Map<String,Object> buildCancelQueuedServicePlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_queued_service_plan", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelSuppPlan(Long client_no, String auth_key, Long acct_no, Long supp_plan_no, Long assignment_directive, String comments, String do_write, String client_receipt_id, String alt_proration_start_date, String effective_date, Long offset_interval, String invoice_unbilled_usage, String client_supp_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"supp_plan_no", getValue("Long", supp_plan_no));
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"alt_proration_start_date", getValue("String", alt_proration_start_date));
        addParameters(parameters,"effective_date", getValue("String", effective_date));
        addParameters(parameters,"offset_interval", getValue("Long", offset_interval));
        addParameters(parameters,"invoice_unbilled_usage", getValue("String", invoice_unbilled_usage));
        addParameters(parameters,"client_supp_plan_id", getValue("String", client_supp_plan_id));
        
        return this.buildCancelSuppPlanHashMap(parameters);
    }

    public Map<String,Object> cancelSuppPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long supp_plan_no = (Long) map.get("supp_plan_no");
        Long assignment_directive = (Long) map.get("assignment_directive");
        String comments = (String) map.get("comments");
        String do_write = (String) map.get("do_write");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String alt_proration_start_date = (String) map.get("alt_proration_start_date");
        String effective_date = (String) map.get("effective_date");
        Long offset_interval = (Long) map.get("offset_interval");
        String invoice_unbilled_usage = (String) map.get("invoice_unbilled_usage");
        String client_supp_plan_id = (String) map.get("client_supp_plan_id");
        
        return cancelSuppPlan(client_no, auth_key, acct_no, supp_plan_no, assignment_directive, comments, do_write, client_receipt_id, alt_proration_start_date, effective_date, offset_interval, invoice_unbilled_usage, client_supp_plan_id);
    }
        private Map<String,Object> buildCancelSuppPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_supp_plan", parameters);
        String[] returnValues = new String[18];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "invoice_no";
        returnValues[4] = "supp_plan_line_items";
        returnValues[5] = "total_charges_before_tax";
        returnValues[6] = "total_tax_charges";
        returnValues[7] = "total_charges_after_tax";
        returnValues[8] = "total_credit";
        returnValues[9] = "total_tax_credit";
        returnValues[10] = "total_credit_before_tax";
        returnValues[11] = "total";
        returnValues[12] = "proration_credit_result_amount";
        returnValues[13] = "proration_credit_amount";
        returnValues[14] = "proration_tax_amount";
        returnValues[15] = "client_service_id";
        returnValues[16] = "client_plan_id";
        returnValues[17] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelUnappliedSvceCredits(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.CreditIdsArray credit_ids){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        RestUtilities.addParameterValuesFromArray(parameters, credit_ids);
        
        return this.buildCancelUnappliedSvceCreditsHashMap(parameters);
    }

    public Map<String,Object> cancelUnappliedSvceCredits(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        com.aria.common.shared.CreditIdsArray credit_ids = (com.aria.common.shared.CreditIdsArray) map.get("credit_ids");
        
        return cancelUnappliedSvceCredits(client_no, auth_key, acct_no, credit_ids);
    }
        private Map<String,Object> buildCancelUnappliedSvceCreditsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_unapplied_svce_credits", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> cancelUnconsumedCredit(Long client_no, String auth_key, Long acct_no, String coupon_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        
        return this.buildCancelUnconsumedCreditHashMap(parameters);
    }

    public Map<String,Object> cancelUnconsumedCredit(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String coupon_cd = (String) map.get("coupon_cd");
        
        return cancelUnconsumedCredit(client_no, auth_key, acct_no, coupon_cd);
    }
        private Map<String,Object> buildCancelUnconsumedCreditHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "cancel_unconsumed_credit", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> closeAcctInstallation(Long client_no, String auth_key, Long acct_no, String install_complete_ind, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"install_complete_ind", getValue("String", install_complete_ind));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildCloseAcctInstallationHashMap(parameters);
    }

    public Map<String,Object> closeAcctInstallation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String install_complete_ind = (String) map.get("install_complete_ind");
        String comments = (String) map.get("comments");
        
        return closeAcctInstallation(client_no, auth_key, acct_no, install_complete_ind, comments);
    }
        private Map<String,Object> buildCloseAcctInstallationHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "close_acct_installation", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createAcctComplete(Long client_no, String auth_key, Long master_plan_no, String client_master_plan_id, String alt_start_date, String client_acct_id, String userid, Long status_cd, Long master_plan_units, com.aria.common.shared.SuppPlansArray supp_plans, com.aria.common.shared.SuppPlanUnitsArray supp_plan_units, Long notify_method, String promo_cd, String password, String secret_question, String secret_question_answer, String first_name, String mi, String last_name, String company_name, String address1, String address2, String city, String locality, String state_prov, String country, String postal_cd, String phone, String phone_ext, String cell_phone, String work_phone, String work_phone_ext, String email, String birthdate, String bill_first_name, String bill_mi, String bill_last_name, String bill_company_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_country, String bill_postal_cd, String bill_phone, String bill_phone_ext, String bill_cell_phone, String bill_work_phone, String bill_work_phone_ext, String bill_email, Long pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_acct_no, String bank_routing_no, Long resp_level_cd, Long senior_acct_no, String senior_acct_user_id, String client_senior_acct_id, com.aria.common.shared.FunctionalAcctGroupsArray functional_acct_groups, com.aria.common.shared.CollectionsAcctGroupsArray collections_acct_groups, com.aria.common.shared.SuppFieldNamesArray supp_field_names, com.aria.common.shared.SuppFieldValuesArray supp_field_values, Long test_acct_ind, Long status_until_alt_start, Double balance_forward, Long alt_bill_day, String do_full_invoicing, String do_prorated_invoicing, Long master_plan_alt_rate_sched_no, com.aria.common.shared.SuppPlanAltRateSchedNoArray supp_plan_alt_rate_sched_no, String client_receipt_id, String currency_cd, String cvv, String taxpayer_id, String bill_agreement_id, String retroactive_start_date, com.aria.common.shared.CouponCodesArray coupon_codes, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, Long alt_msg_template_no, Long seq_func_group_no, com.aria.common.shared.NewAcctPlanContractsArray new_acct_plan_contracts, String bank_acct_type, String address3, String bill_address3, com.aria.common.shared.UsageAccumulationConfigArray usage_accumulation_config, com.aria.common.shared.EnableUsagePoolingPlanNoArray enable_usage_pooling_plan_no, com.aria.common.shared.ClientFuncAcctGroupIdsArray client_func_acct_group_ids, com.aria.common.shared.ClientCollAcctGroupIdsArray client_coll_acct_group_ids, String track_data1, String track_data2, String do_write, Long tax_exemption_level, Long cn_alt_msg_template_no, String invoice_approval_required, String create_session, com.aria.common.shared.ClientSuppPlanIdsArray client_supp_plan_ids, String client_mp_alt_rate_sched_id, com.aria.common.shared.ClientSpAltRateSchedIdsArray client_sp_alt_rate_sched_ids, String client_alt_msg_template_id, String client_cn_alt_msg_template_no, com.aria.common.shared.SurchargeNoArray surcharge_no, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String bkup_bill_first_name, String bkup_bill_mi, String bkup_bill_last_name, String bkup_bill_company_name, String bkup_bill_address1, String bkup_bill_address2, String bkup_bill_address3, String bkup_bill_city, String bkup_bill_locality, String bkup_bill_state_prov, String bkup_bill_country, String bkup_bill_postal_cd, String bkup_bill_phone, String bkup_bill_phone_ext, String bkup_bill_cell_phone, String bkup_bill_work_phone, String bkup_bill_work_phone_ext, String bkup_bill_email, Long bkup_pay_method, String bkup_cc_number, Long bkup_cc_expire_mm, Long bkup_cc_expire_yyyy, String bkup_bank_acct_no, String bkup_bank_routing_no, String bkup_bank_acct_type, String bkup_bill_agreement_id, String bkup_cvv, String seq_func_group_id, Long revrec_profile_id, String revrec_client_defined_id, String stmnt_email_list_cc, String stmnt_email_list_bcc, Long invoice_posting_method_cd, String acct_start_date, Long min_statement_threshold, Long max_statements_to_defer, Long defer_full_statements_only, Long cc_id, Long bkup_cc_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"master_plan_no", getValue("Long", master_plan_no));
        addParameters(parameters,"client_master_plan_id", getValue("String", client_master_plan_id));
        addParameters(parameters,"alt_start_date", getValue("String", alt_start_date));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"userid", getValue("String", userid));
        addParameters(parameters,"status_cd", getValue("Long", status_cd));
        addParameters(parameters,"master_plan_units", getValue("Long", master_plan_units));
        RestUtilities.addParameterValuesFromArray(parameters, supp_plans);
        RestUtilities.addParameterValuesFromArray(parameters, supp_plan_units);
        addParameters(parameters,"notify_method", getValue("Long", notify_method));
        addParameters(parameters,"promo_cd", getValue("String", promo_cd));
        addParameters(parameters,"password", getValue("String", password));
        addParameters(parameters,"secret_question", getValue("String", secret_question));
        addParameters(parameters,"secret_question_answer", getValue("String", secret_question_answer));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"mi", getValue("String", mi));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"company_name", getValue("String", company_name));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"state_prov", getValue("String", state_prov));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"postal_cd", getValue("String", postal_cd));
        addParameters(parameters,"phone", getValue("String", phone));
        addParameters(parameters,"phone_ext", getValue("String", phone_ext));
        addParameters(parameters,"cell_phone", getValue("String", cell_phone));
        addParameters(parameters,"work_phone", getValue("String", work_phone));
        addParameters(parameters,"work_phone_ext", getValue("String", work_phone_ext));
        addParameters(parameters,"email", getValue("String", email));
        addParameters(parameters,"birthdate", getValue("String", birthdate));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_mi", getValue("String", bill_mi));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_postal_cd", getValue("String", bill_postal_cd));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_ext", getValue("String", bill_phone_ext));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_ext", getValue("String", bill_work_phone_ext));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"pay_method", getValue("Long", pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_acct_no", getValue("String", bank_acct_no));
        addParameters(parameters,"bank_routing_no", getValue("String", bank_routing_no));
        addParameters(parameters,"resp_level_cd", getValue("Long", resp_level_cd));
        addParameters(parameters,"senior_acct_no", getValue("Long", senior_acct_no));
        addParameters(parameters,"senior_acct_user_id", getValue("String", senior_acct_user_id));
        addParameters(parameters,"client_senior_acct_id", getValue("String", client_senior_acct_id));
        RestUtilities.addParameterValuesFromArray(parameters, functional_acct_groups);
        RestUtilities.addParameterValuesFromArray(parameters, collections_acct_groups);
        RestUtilities.addParameterValuesFromArray(parameters, supp_field_names);
        RestUtilities.addParameterValuesFromArray(parameters, supp_field_values);
        addParameters(parameters,"test_acct_ind", getValue("Long", test_acct_ind));
        addParameters(parameters,"status_until_alt_start", getValue("Long", status_until_alt_start));
        addParameters(parameters,"balance_forward", getValue("Double", balance_forward));
        addParameters(parameters,"alt_bill_day", getValue("Long", alt_bill_day));
        addParameters(parameters,"do_full_invoicing", getValue("String", do_full_invoicing));
        addParameters(parameters,"do_prorated_invoicing", getValue("String", do_prorated_invoicing));
        addParameters(parameters,"master_plan_alt_rate_sched_no", getValue("Long", master_plan_alt_rate_sched_no));
        RestUtilities.addParameterValuesFromArray(parameters, supp_plan_alt_rate_sched_no);
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"taxpayer_id", getValue("String", taxpayer_id));
        addParameters(parameters,"bill_agreement_id", getValue("String", bill_agreement_id));
        addParameters(parameters,"retroactive_start_date", getValue("String", retroactive_start_date));
        RestUtilities.addParameterValuesFromArray(parameters, coupon_codes);
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_custom_rates);
        addParameters(parameters,"alt_msg_template_no", getValue("Long", alt_msg_template_no));
        addParameters(parameters,"seq_func_group_no", getValue("Long", seq_func_group_no));
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_plan_contracts);
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"address3", getValue("String", address3));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        RestUtilities.addParameterValuesFromArray(parameters, usage_accumulation_config);
        RestUtilities.addParameterValuesFromArray(parameters, enable_usage_pooling_plan_no);
        RestUtilities.addParameterValuesFromArray(parameters, client_func_acct_group_ids);
        RestUtilities.addParameterValuesFromArray(parameters, client_coll_acct_group_ids);
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"tax_exemption_level", getValue("Long", tax_exemption_level));
        addParameters(parameters,"cn_alt_msg_template_no", getValue("Long", cn_alt_msg_template_no));
        addParameters(parameters,"invoice_approval_required", getValue("String", invoice_approval_required));
        addParameters(parameters,"create_session", getValue("String", create_session));
        RestUtilities.addParameterValuesFromArray(parameters, client_supp_plan_ids);
        addParameters(parameters,"client_mp_alt_rate_sched_id", getValue("String", client_mp_alt_rate_sched_id));
        RestUtilities.addParameterValuesFromArray(parameters, client_sp_alt_rate_sched_ids);
        addParameters(parameters,"client_alt_msg_template_id", getValue("String", client_alt_msg_template_id));
        addParameters(parameters,"client_cn_alt_msg_template_no", getValue("String", client_cn_alt_msg_template_no));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no);
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"bkup_bill_first_name", getValue("String", bkup_bill_first_name));
        addParameters(parameters,"bkup_bill_mi", getValue("String", bkup_bill_mi));
        addParameters(parameters,"bkup_bill_last_name", getValue("String", bkup_bill_last_name));
        addParameters(parameters,"bkup_bill_company_name", getValue("String", bkup_bill_company_name));
        addParameters(parameters,"bkup_bill_address1", getValue("String", bkup_bill_address1));
        addParameters(parameters,"bkup_bill_address2", getValue("String", bkup_bill_address2));
        addParameters(parameters,"bkup_bill_address3", getValue("String", bkup_bill_address3));
        addParameters(parameters,"bkup_bill_city", getValue("String", bkup_bill_city));
        addParameters(parameters,"bkup_bill_locality", getValue("String", bkup_bill_locality));
        addParameters(parameters,"bkup_bill_state_prov", getValue("String", bkup_bill_state_prov));
        addParameters(parameters,"bkup_bill_country", getValue("String", bkup_bill_country));
        addParameters(parameters,"bkup_bill_postal_cd", getValue("String", bkup_bill_postal_cd));
        addParameters(parameters,"bkup_bill_phone", getValue("String", bkup_bill_phone));
        addParameters(parameters,"bkup_bill_phone_ext", getValue("String", bkup_bill_phone_ext));
        addParameters(parameters,"bkup_bill_cell_phone", getValue("String", bkup_bill_cell_phone));
        addParameters(parameters,"bkup_bill_work_phone", getValue("String", bkup_bill_work_phone));
        addParameters(parameters,"bkup_bill_work_phone_ext", getValue("String", bkup_bill_work_phone_ext));
        addParameters(parameters,"bkup_bill_email", getValue("String", bkup_bill_email));
        addParameters(parameters,"bkup_pay_method", getValue("Long", bkup_pay_method));
        addParameters(parameters,"bkup_cc_number", getValue("String", bkup_cc_number));
        addParameters(parameters,"bkup_cc_expire_mm", getValue("Long", bkup_cc_expire_mm));
        addParameters(parameters,"bkup_cc_expire_yyyy", getValue("Long", bkup_cc_expire_yyyy));
        addParameters(parameters,"bkup_bank_acct_no", getValue("String", bkup_bank_acct_no));
        addParameters(parameters,"bkup_bank_routing_no", getValue("String", bkup_bank_routing_no));
        addParameters(parameters,"bkup_bank_acct_type", getValue("String", bkup_bank_acct_type));
        addParameters(parameters,"bkup_bill_agreement_id", getValue("String", bkup_bill_agreement_id));
        addParameters(parameters,"bkup_cvv", getValue("String", bkup_cvv));
        addParameters(parameters,"seq_func_group_id", getValue("String", seq_func_group_id));
        addParameters(parameters,"revrec_profile_id", getValue("Long", revrec_profile_id));
        addParameters(parameters,"revrec_client_defined_id", getValue("String", revrec_client_defined_id));
        addParameters(parameters,"stmnt_email_list_cc", getValue("String", stmnt_email_list_cc));
        addParameters(parameters,"stmnt_email_list_bcc", getValue("String", stmnt_email_list_bcc));
        addParameters(parameters,"invoice_posting_method_cd", getValue("Long", invoice_posting_method_cd));
        addParameters(parameters,"acct_start_date", getValue("String", acct_start_date));
        addParameters(parameters,"min_statement_threshold", getValue("Long", min_statement_threshold));
        addParameters(parameters,"max_statements_to_defer", getValue("Long", max_statements_to_defer));
        addParameters(parameters,"defer_full_statements_only", getValue("Long", defer_full_statements_only));
        addParameters(parameters,"cc_id", getValue("Long", cc_id));
        addParameters(parameters,"bkup_cc_id", getValue("Long", bkup_cc_id));
        
        return this.buildCreateAcctCompleteHashMap(parameters);
    }

    public Map<String,Object> createAcctComplete(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long master_plan_no = (Long) map.get("master_plan_no");
        String client_master_plan_id = (String) map.get("client_master_plan_id");
        String alt_start_date = (String) map.get("alt_start_date");
        String client_acct_id = (String) map.get("client_acct_id");
        String userid = (String) map.get("userid");
        Long status_cd = (Long) map.get("status_cd");
        Long master_plan_units = (Long) map.get("master_plan_units");
        com.aria.common.shared.SuppPlansArray supp_plans = (com.aria.common.shared.SuppPlansArray) map.get("supp_plans");
        com.aria.common.shared.SuppPlanUnitsArray supp_plan_units = (com.aria.common.shared.SuppPlanUnitsArray) map.get("supp_plan_units");
        Long notify_method = (Long) map.get("notify_method");
        String promo_cd = (String) map.get("promo_cd");
        String password = (String) map.get("password");
        String secret_question = (String) map.get("secret_question");
        String secret_question_answer = (String) map.get("secret_question_answer");
        String first_name = (String) map.get("first_name");
        String mi = (String) map.get("mi");
        String last_name = (String) map.get("last_name");
        String company_name = (String) map.get("company_name");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String locality = (String) map.get("locality");
        String state_prov = (String) map.get("state_prov");
        String country = (String) map.get("country");
        String postal_cd = (String) map.get("postal_cd");
        String phone = (String) map.get("phone");
        String phone_ext = (String) map.get("phone_ext");
        String cell_phone = (String) map.get("cell_phone");
        String work_phone = (String) map.get("work_phone");
        String work_phone_ext = (String) map.get("work_phone_ext");
        String email = (String) map.get("email");
        String birthdate = (String) map.get("birthdate");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_mi = (String) map.get("bill_mi");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_country = (String) map.get("bill_country");
        String bill_postal_cd = (String) map.get("bill_postal_cd");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_ext = (String) map.get("bill_phone_ext");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_ext = (String) map.get("bill_work_phone_ext");
        String bill_email = (String) map.get("bill_email");
        Long pay_method = (Long) map.get("pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_acct_no = (String) map.get("bank_acct_no");
        String bank_routing_no = (String) map.get("bank_routing_no");
        Long resp_level_cd = (Long) map.get("resp_level_cd");
        Long senior_acct_no = (Long) map.get("senior_acct_no");
        String senior_acct_user_id = (String) map.get("senior_acct_user_id");
        String client_senior_acct_id = (String) map.get("client_senior_acct_id");
        com.aria.common.shared.FunctionalAcctGroupsArray functional_acct_groups = (com.aria.common.shared.FunctionalAcctGroupsArray) map.get("functional_acct_groups");
        com.aria.common.shared.CollectionsAcctGroupsArray collections_acct_groups = (com.aria.common.shared.CollectionsAcctGroupsArray) map.get("collections_acct_groups");
        com.aria.common.shared.SuppFieldNamesArray supp_field_names = (com.aria.common.shared.SuppFieldNamesArray) map.get("supp_field_names");
        com.aria.common.shared.SuppFieldValuesArray supp_field_values = (com.aria.common.shared.SuppFieldValuesArray) map.get("supp_field_values");
        Long test_acct_ind = (Long) map.get("test_acct_ind");
        Long status_until_alt_start = (Long) map.get("status_until_alt_start");
        Double balance_forward = (Double) map.get("balance_forward");
        Long alt_bill_day = (Long) map.get("alt_bill_day");
        String do_full_invoicing = (String) map.get("do_full_invoicing");
        String do_prorated_invoicing = (String) map.get("do_prorated_invoicing");
        Long master_plan_alt_rate_sched_no = (Long) map.get("master_plan_alt_rate_sched_no");
        com.aria.common.shared.SuppPlanAltRateSchedNoArray supp_plan_alt_rate_sched_no = (com.aria.common.shared.SuppPlanAltRateSchedNoArray) map.get("supp_plan_alt_rate_sched_no");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String currency_cd = (String) map.get("currency_cd");
        String cvv = (String) map.get("cvv");
        String taxpayer_id = (String) map.get("taxpayer_id");
        String bill_agreement_id = (String) map.get("bill_agreement_id");
        String retroactive_start_date = (String) map.get("retroactive_start_date");
        com.aria.common.shared.CouponCodesArray coupon_codes = (com.aria.common.shared.CouponCodesArray) map.get("coupon_codes");
        com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates = (com.aria.common.shared.NewAcctCustomRatesArray) map.get("new_acct_custom_rates");
        Long alt_msg_template_no = (Long) map.get("alt_msg_template_no");
        Long seq_func_group_no = (Long) map.get("seq_func_group_no");
        com.aria.common.shared.NewAcctPlanContractsArray new_acct_plan_contracts = (com.aria.common.shared.NewAcctPlanContractsArray) map.get("new_acct_plan_contracts");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String address3 = (String) map.get("address3");
        String bill_address3 = (String) map.get("bill_address3");
        com.aria.common.shared.UsageAccumulationConfigArray usage_accumulation_config = (com.aria.common.shared.UsageAccumulationConfigArray) map.get("usage_accumulation_config");
        com.aria.common.shared.EnableUsagePoolingPlanNoArray enable_usage_pooling_plan_no = (com.aria.common.shared.EnableUsagePoolingPlanNoArray) map.get("enable_usage_pooling_plan_no");
        com.aria.common.shared.ClientFuncAcctGroupIdsArray client_func_acct_group_ids = (com.aria.common.shared.ClientFuncAcctGroupIdsArray) map.get("client_func_acct_group_ids");
        com.aria.common.shared.ClientCollAcctGroupIdsArray client_coll_acct_group_ids = (com.aria.common.shared.ClientCollAcctGroupIdsArray) map.get("client_coll_acct_group_ids");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        String do_write = (String) map.get("do_write");
        Long tax_exemption_level = (Long) map.get("tax_exemption_level");
        Long cn_alt_msg_template_no = (Long) map.get("cn_alt_msg_template_no");
        String invoice_approval_required = (String) map.get("invoice_approval_required");
        String create_session = (String) map.get("create_session");
        com.aria.common.shared.ClientSuppPlanIdsArray client_supp_plan_ids = (com.aria.common.shared.ClientSuppPlanIdsArray) map.get("client_supp_plan_ids");
        String client_mp_alt_rate_sched_id = (String) map.get("client_mp_alt_rate_sched_id");
        com.aria.common.shared.ClientSpAltRateSchedIdsArray client_sp_alt_rate_sched_ids = (com.aria.common.shared.ClientSpAltRateSchedIdsArray) map.get("client_sp_alt_rate_sched_ids");
        String client_alt_msg_template_id = (String) map.get("client_alt_msg_template_id");
        String client_cn_alt_msg_template_no = (String) map.get("client_cn_alt_msg_template_no");
        com.aria.common.shared.SurchargeNoArray surcharge_no = (com.aria.common.shared.SurchargeNoArray) map.get("surcharge_no");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        String bkup_bill_first_name = (String) map.get("bkup_bill_first_name");
        String bkup_bill_mi = (String) map.get("bkup_bill_mi");
        String bkup_bill_last_name = (String) map.get("bkup_bill_last_name");
        String bkup_bill_company_name = (String) map.get("bkup_bill_company_name");
        String bkup_bill_address1 = (String) map.get("bkup_bill_address1");
        String bkup_bill_address2 = (String) map.get("bkup_bill_address2");
        String bkup_bill_address3 = (String) map.get("bkup_bill_address3");
        String bkup_bill_city = (String) map.get("bkup_bill_city");
        String bkup_bill_locality = (String) map.get("bkup_bill_locality");
        String bkup_bill_state_prov = (String) map.get("bkup_bill_state_prov");
        String bkup_bill_country = (String) map.get("bkup_bill_country");
        String bkup_bill_postal_cd = (String) map.get("bkup_bill_postal_cd");
        String bkup_bill_phone = (String) map.get("bkup_bill_phone");
        String bkup_bill_phone_ext = (String) map.get("bkup_bill_phone_ext");
        String bkup_bill_cell_phone = (String) map.get("bkup_bill_cell_phone");
        String bkup_bill_work_phone = (String) map.get("bkup_bill_work_phone");
        String bkup_bill_work_phone_ext = (String) map.get("bkup_bill_work_phone_ext");
        String bkup_bill_email = (String) map.get("bkup_bill_email");
        Long bkup_pay_method = (Long) map.get("bkup_pay_method");
        String bkup_cc_number = (String) map.get("bkup_cc_number");
        Long bkup_cc_expire_mm = (Long) map.get("bkup_cc_expire_mm");
        Long bkup_cc_expire_yyyy = (Long) map.get("bkup_cc_expire_yyyy");
        String bkup_bank_acct_no = (String) map.get("bkup_bank_acct_no");
        String bkup_bank_routing_no = (String) map.get("bkup_bank_routing_no");
        String bkup_bank_acct_type = (String) map.get("bkup_bank_acct_type");
        String bkup_bill_agreement_id = (String) map.get("bkup_bill_agreement_id");
        String bkup_cvv = (String) map.get("bkup_cvv");
        String seq_func_group_id = (String) map.get("seq_func_group_id");
        Long revrec_profile_id = (Long) map.get("revrec_profile_id");
        String revrec_client_defined_id = (String) map.get("revrec_client_defined_id");
        String stmnt_email_list_cc = (String) map.get("stmnt_email_list_cc");
        String stmnt_email_list_bcc = (String) map.get("stmnt_email_list_bcc");
        Long invoice_posting_method_cd = (Long) map.get("invoice_posting_method_cd");
        String acct_start_date = (String) map.get("acct_start_date");
        Long min_statement_threshold = (Long) map.get("min_statement_threshold");
        Long max_statements_to_defer = (Long) map.get("max_statements_to_defer");
        Long defer_full_statements_only = (Long) map.get("defer_full_statements_only");
        Long cc_id = (Long) map.get("cc_id");
        Long bkup_cc_id = (Long) map.get("bkup_cc_id");
        
        return createAcctComplete(client_no, auth_key, master_plan_no, client_master_plan_id, alt_start_date, client_acct_id, userid, status_cd, master_plan_units, supp_plans, supp_plan_units, notify_method, promo_cd, password, secret_question, secret_question_answer, first_name, mi, last_name, company_name, address1, address2, city, locality, state_prov, country, postal_cd, phone, phone_ext, cell_phone, work_phone, work_phone_ext, email, birthdate, bill_first_name, bill_mi, bill_last_name, bill_company_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_country, bill_postal_cd, bill_phone, bill_phone_ext, bill_cell_phone, bill_work_phone, bill_work_phone_ext, bill_email, pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_acct_no, bank_routing_no, resp_level_cd, senior_acct_no, senior_acct_user_id, client_senior_acct_id, functional_acct_groups, collections_acct_groups, supp_field_names, supp_field_values, test_acct_ind, status_until_alt_start, balance_forward, alt_bill_day, do_full_invoicing, do_prorated_invoicing, master_plan_alt_rate_sched_no, supp_plan_alt_rate_sched_no, client_receipt_id, currency_cd, cvv, taxpayer_id, bill_agreement_id, retroactive_start_date, coupon_codes, new_acct_custom_rates, alt_msg_template_no, seq_func_group_no, new_acct_plan_contracts, bank_acct_type, address3, bill_address3, usage_accumulation_config, enable_usage_pooling_plan_no, client_func_acct_group_ids, client_coll_acct_group_ids, track_data1, track_data2, do_write, tax_exemption_level, cn_alt_msg_template_no, invoice_approval_required, create_session, client_supp_plan_ids, client_mp_alt_rate_sched_id, client_sp_alt_rate_sched_ids, client_alt_msg_template_id, client_cn_alt_msg_template_no, surcharge_no, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, bkup_bill_first_name, bkup_bill_mi, bkup_bill_last_name, bkup_bill_company_name, bkup_bill_address1, bkup_bill_address2, bkup_bill_address3, bkup_bill_city, bkup_bill_locality, bkup_bill_state_prov, bkup_bill_country, bkup_bill_postal_cd, bkup_bill_phone, bkup_bill_phone_ext, bkup_bill_cell_phone, bkup_bill_work_phone, bkup_bill_work_phone_ext, bkup_bill_email, bkup_pay_method, bkup_cc_number, bkup_cc_expire_mm, bkup_cc_expire_yyyy, bkup_bank_acct_no, bkup_bank_routing_no, bkup_bank_acct_type, bkup_bill_agreement_id, bkup_cvv, seq_func_group_id, revrec_profile_id, revrec_client_defined_id, stmnt_email_list_cc, stmnt_email_list_bcc, invoice_posting_method_cd, acct_start_date, min_statement_threshold, max_statements_to_defer, defer_full_statements_only, cc_id, bkup_cc_id);
    }
        private Map<String,Object> buildCreateAcctCompleteHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_acct_complete", parameters);
        String[] returnValues = new String[24];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_no";
        returnValues[3] = "out_userid";
        returnValues[4] = "invoicing_error_code";
        returnValues[5] = "invoicing_error_msg";
        returnValues[6] = "invoice_no";
        returnValues[7] = "proc_cvv_response";
        returnValues[8] = "proc_avs_response";
        returnValues[9] = "proc_cavv_response";
        returnValues[10] = "proc_status_code";
        returnValues[11] = "proc_status_text";
        returnValues[12] = "proc_payment_id";
        returnValues[13] = "proc_auth_code";
        returnValues[14] = "proc_merch_comments";
        returnValues[15] = "out_new_acct_plan_contracts";
        returnValues[16] = "invoice_charges_before_tax";
        returnValues[17] = "invoice_tax_charges";
        returnValues[18] = "invoice_charges_after_tax";
        returnValues[19] = "invoice_credit_amount";
        returnValues[20] = "invoice_total_amount";
        returnValues[21] = "new_acct_invoice_line_items";
        returnValues[22] = "third_party_errors";
        returnValues[23] = "session_id";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long length_months, String end_date, com.aria.common.shared.PlanNoArray plan_no, Long type_no, String create_comments, String start_date, String do_auto_discard, com.aria.common.shared.ClientPlanIdArray client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"length_months", getValue("Long", length_months));
        addParameters(parameters,"end_date", getValue("String", end_date));
        RestUtilities.addParameterValuesFromArray(parameters, plan_no);
        addParameters(parameters,"type_no", getValue("Long", type_no));
        addParameters(parameters,"create_comments", getValue("String", create_comments));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"do_auto_discard", getValue("String", do_auto_discard));
        RestUtilities.addParameterValuesFromArray(parameters, client_plan_id);
        
        return this.buildCreateAcctMultiplanContractHashMap(parameters);
    }

    public Map<String,Object> createAcctMultiplanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long length_months = (Long) map.get("length_months");
        String end_date = (String) map.get("end_date");
        com.aria.common.shared.PlanNoArray plan_no = (com.aria.common.shared.PlanNoArray) map.get("plan_no");
        Long type_no = (Long) map.get("type_no");
        String create_comments = (String) map.get("create_comments");
        String start_date = (String) map.get("start_date");
        String do_auto_discard = (String) map.get("do_auto_discard");
        com.aria.common.shared.ClientPlanIdArray client_plan_id = (com.aria.common.shared.ClientPlanIdArray) map.get("client_plan_id");
        
        return createAcctMultiplanContract(client_no, auth_key, acct_no, length_months, end_date, plan_no, type_no, create_comments, start_date, do_auto_discard, client_plan_id);
    }
        private Map<String,Object> buildCreateAcctMultiplanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_acct_multiplan_contract", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "contract_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long plan_no, Long length_months, String end_date, String client_plan_id, Long type_no, Double alt_recur_fee, Double cancel_fee, String create_comments, String start_date, String do_auto_discard){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"length_months", getValue("Long", length_months));
        addParameters(parameters,"end_date", getValue("String", end_date));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"type_no", getValue("Long", type_no));
        addParameters(parameters,"alt_recur_fee", getValue("Double", alt_recur_fee));
        addParameters(parameters,"cancel_fee", getValue("Double", cancel_fee));
        addParameters(parameters,"create_comments", getValue("String", create_comments));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"do_auto_discard", getValue("String", do_auto_discard));
        
        return this.buildCreateAcctPlanContractHashMap(parameters);
    }

    public Map<String,Object> createAcctPlanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long plan_no = (Long) map.get("plan_no");
        Long length_months = (Long) map.get("length_months");
        String end_date = (String) map.get("end_date");
        String client_plan_id = (String) map.get("client_plan_id");
        Long type_no = (Long) map.get("type_no");
        Double alt_recur_fee = (Double) map.get("alt_recur_fee");
        Double cancel_fee = (Double) map.get("cancel_fee");
        String create_comments = (String) map.get("create_comments");
        String start_date = (String) map.get("start_date");
        String do_auto_discard = (String) map.get("do_auto_discard");
        
        return createAcctPlanContract(client_no, auth_key, acct_no, plan_no, length_months, end_date, client_plan_id, type_no, alt_recur_fee, cancel_fee, create_comments, start_date, do_auto_discard);
    }
        private Map<String,Object> buildCreateAcctPlanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_acct_plan_contract", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "contract_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createAcctUniversalContract(Long client_no, String auth_key, Long acct_no, Long length_months, String end_date, Long type_no, String create_comments, String start_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"length_months", getValue("Long", length_months));
        addParameters(parameters,"end_date", getValue("String", end_date));
        addParameters(parameters,"type_no", getValue("Long", type_no));
        addParameters(parameters,"create_comments", getValue("String", create_comments));
        addParameters(parameters,"start_date", getValue("String", start_date));
        
        return this.buildCreateAcctUniversalContractHashMap(parameters);
    }

    public Map<String,Object> createAcctUniversalContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long length_months = (Long) map.get("length_months");
        String end_date = (String) map.get("end_date");
        Long type_no = (Long) map.get("type_no");
        String create_comments = (String) map.get("create_comments");
        String start_date = (String) map.get("start_date");
        
        return createAcctUniversalContract(client_no, auth_key, acct_no, length_months, end_date, type_no, create_comments, start_date);
    }
        private Map<String,Object> buildCreateAcctUniversalContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_acct_universal_contract", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "contract_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> createAdvancedServiceCredit(Long client_no, String auth_key, Long acct_no, Double amount, Long reason_code, String comments, Long eligible_plan_no, Long eligible_service_no, Long alt_service_no_to_apply, Long frequency_no, Long frequency_interval_months, String initial_credit_date, Double percent_amount, Long percent_eval_plan_no, Long percent_eval_service_no, com.aria.common.shared.EligibleServiceTypesArray eligible_service_types, String client_eligible_plan_id, String client_eligible_service_id, String client_alt_service_id_to_apply, String client_percent_eval_plan_id, String client_percent_eval_service_id, String credit_expiry_type_ind, Long credit_expiry_months, String credit_expiry_date, com.aria.common.shared.EligibleServicePlansArray eligible_service_plans, com.aria.common.shared.ClientEligibleServicePlanIdsArray client_eligible_service_plan_ids){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        addParameters(parameters,"reason_code", getValue("Long", reason_code));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"eligible_plan_no", getValue("Long", eligible_plan_no));
        addParameters(parameters,"eligible_service_no", getValue("Long", eligible_service_no));
        addParameters(parameters,"alt_service_no_to_apply", getValue("Long", alt_service_no_to_apply));
        addParameters(parameters,"frequency_no", getValue("Long", frequency_no));
        addParameters(parameters,"frequency_interval_months", getValue("Long", frequency_interval_months));
        addParameters(parameters,"initial_credit_date", getValue("String", initial_credit_date));
        addParameters(parameters,"percent_amount", getValue("Double", percent_amount));
        addParameters(parameters,"percent_eval_plan_no", getValue("Long", percent_eval_plan_no));
        addParameters(parameters,"percent_eval_service_no", getValue("Long", percent_eval_service_no));
        RestUtilities.addParameterValuesFromArray(parameters, eligible_service_types);
        addParameters(parameters,"client_eligible_plan_id", getValue("String", client_eligible_plan_id));
        addParameters(parameters,"client_eligible_service_id", getValue("String", client_eligible_service_id));
        addParameters(parameters,"client_alt_service_id_to_apply", getValue("String", client_alt_service_id_to_apply));
        addParameters(parameters,"client_percent_eval_plan_id", getValue("String", client_percent_eval_plan_id));
        addParameters(parameters,"client_percent_eval_service_id", getValue("String", client_percent_eval_service_id));
        addParameters(parameters,"credit_expiry_type_ind", getValue("String", credit_expiry_type_ind));
        addParameters(parameters,"credit_expiry_months", getValue("Long", credit_expiry_months));
        addParameters(parameters,"credit_expiry_date", getValue("String", credit_expiry_date));
        RestUtilities.addParameterValuesFromArray(parameters, eligible_service_plans);
        RestUtilities.addParameterValuesFromArray(parameters, client_eligible_service_plan_ids);
        
        return this.buildCreateAdvancedServiceCreditHashMap(parameters);
    }

    public Map<String,Object> createAdvancedServiceCredit(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        Long reason_code = (Long) map.get("reason_code");
        String comments = (String) map.get("comments");
        Long eligible_plan_no = (Long) map.get("eligible_plan_no");
        Long eligible_service_no = (Long) map.get("eligible_service_no");
        Long alt_service_no_to_apply = (Long) map.get("alt_service_no_to_apply");
        Long frequency_no = (Long) map.get("frequency_no");
        Long frequency_interval_months = (Long) map.get("frequency_interval_months");
        String initial_credit_date = (String) map.get("initial_credit_date");
        Double percent_amount = (Double) map.get("percent_amount");
        Long percent_eval_plan_no = (Long) map.get("percent_eval_plan_no");
        Long percent_eval_service_no = (Long) map.get("percent_eval_service_no");
        com.aria.common.shared.EligibleServiceTypesArray eligible_service_types = (com.aria.common.shared.EligibleServiceTypesArray) map.get("eligible_service_types");
        String client_eligible_plan_id = (String) map.get("client_eligible_plan_id");
        String client_eligible_service_id = (String) map.get("client_eligible_service_id");
        String client_alt_service_id_to_apply = (String) map.get("client_alt_service_id_to_apply");
        String client_percent_eval_plan_id = (String) map.get("client_percent_eval_plan_id");
        String client_percent_eval_service_id = (String) map.get("client_percent_eval_service_id");
        String credit_expiry_type_ind = (String) map.get("credit_expiry_type_ind");
        Long credit_expiry_months = (Long) map.get("credit_expiry_months");
        String credit_expiry_date = (String) map.get("credit_expiry_date");
        com.aria.common.shared.EligibleServicePlansArray eligible_service_plans = (com.aria.common.shared.EligibleServicePlansArray) map.get("eligible_service_plans");
        com.aria.common.shared.ClientEligibleServicePlanIdsArray client_eligible_service_plan_ids = (com.aria.common.shared.ClientEligibleServicePlanIdsArray) map.get("client_eligible_service_plan_ids");
        
        return createAdvancedServiceCredit(client_no, auth_key, acct_no, amount, reason_code, comments, eligible_plan_no, eligible_service_no, alt_service_no_to_apply, frequency_no, frequency_interval_months, initial_credit_date, percent_amount, percent_eval_plan_no, percent_eval_service_no, eligible_service_types, client_eligible_plan_id, client_eligible_service_id, client_alt_service_id_to_apply, client_percent_eval_plan_id, client_percent_eval_service_id, credit_expiry_type_ind, credit_expiry_months, credit_expiry_date, eligible_service_plans, client_eligible_service_plan_ids);
    }
        private Map<String,Object> buildCreateAdvancedServiceCreditHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "create_advanced_service_credit", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> deleteAcctCoupon(Long client_no, String auth_key, Long acct_no, String coupon_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        
        return this.buildDeleteAcctCouponHashMap(parameters);
    }

    public Map<String,Object> deleteAcctCoupon(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String coupon_cd = (String) map.get("coupon_cd");
        
        return deleteAcctCoupon(client_no, auth_key, acct_no, coupon_cd);
    }
        private Map<String,Object> buildDeleteAcctCouponHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "delete_acct_coupon", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> disableAllStandingUsage(Long client_no, String auth_key, Long acct_no, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildDisableAllStandingUsageHashMap(parameters);
    }

    public Map<String,Object> disableAllStandingUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String comments = (String) map.get("comments");
        
        return disableAllStandingUsage(client_no, auth_key, acct_no, comments);
    }
        private Map<String,Object> buildDisableAllStandingUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "disable_all_standing_usage", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> disableStandingUsage(Long client_no, String auth_key, Long acct_no, Long standing_usage_rec_no, String comments){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"standing_usage_rec_no", getValue("Long", standing_usage_rec_no));
        addParameters(parameters,"comments", getValue("String", comments));
        
        return this.buildDisableStandingUsageHashMap(parameters);
    }

    public Map<String,Object> disableStandingUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long standing_usage_rec_no = (Long) map.get("standing_usage_rec_no");
        String comments = (String) map.get("comments");
        
        return disableStandingUsage(client_no, auth_key, acct_no, standing_usage_rec_no, comments);
    }
        private Map<String,Object> buildDisableStandingUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "disable_standing_usage", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> disableStandingUsageByPlan(Long client_no, String auth_key, Long acct_no, Long plan_no, String comments, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildDisableStandingUsageByPlanHashMap(parameters);
    }

    public Map<String,Object> disableStandingUsageByPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long plan_no = (Long) map.get("plan_no");
        String comments = (String) map.get("comments");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return disableStandingUsageByPlan(client_no, auth_key, acct_no, plan_no, comments, client_plan_id);
    }
        private Map<String,Object> buildDisableStandingUsageByPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "disable_standing_usage_by_plan", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> genStatement(Long client_no, String auth_key, Long acct_no, String send_email){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"send_email", getValue("String", send_email));
        
        return this.buildGenStatementHashMap(parameters);
    }

    public Map<String,Object> genStatement(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String send_email = (String) map.get("send_email");
        
        return genStatement(client_no, auth_key, acct_no, send_email);
    }
        private Map<String,Object> buildGenStatementHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "gen_statement", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "statement_no";
        returnValues[1] = "seq_statement_id";
        returnValues[2] = "error_code";
        returnValues[3] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctBalance(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctBalanceHashMap(parameters);
    }

    public Map<String,Object> getAcctBalance(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctBalance(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctBalanceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_balance", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "currency_cd";
        returnValues[3] = "balance";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctComments(Long client_no, String auth_key, Long acct_no, String date_range_start, String date_range_end, String do_url_encoding, String filter_application_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"date_range_start", getValue("String", date_range_start));
        addParameters(parameters,"date_range_end", getValue("String", date_range_end));
        addParameters(parameters,"do_url_encoding", getValue("String", do_url_encoding));
        addParameters(parameters,"filter_application_id", getValue("String", filter_application_id));
        
        return this.buildGetAcctCommentsHashMap(parameters);
    }

    public Map<String,Object> getAcctComments(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String date_range_start = (String) map.get("date_range_start");
        String date_range_end = (String) map.get("date_range_end");
        String do_url_encoding = (String) map.get("do_url_encoding");
        String filter_application_id = (String) map.get("filter_application_id");
        
        return getAcctComments(client_no, auth_key, acct_no, date_range_start, date_range_end, do_url_encoding, filter_application_id);
    }
        private Map<String,Object> buildGetAcctCommentsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_comments", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctCreditDetails(Long client_no, String auth_key, Long acct_no, Long credit_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"credit_no", getValue("Long", credit_no));
        
        return this.buildGetAcctCreditDetailsHashMap(parameters);
    }

    public Map<String,Object> getAcctCreditDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long credit_no = (Long) map.get("credit_no");
        
        return getAcctCreditDetails(client_no, auth_key, acct_no, credit_no);
    }
        private Map<String,Object> buildGetAcctCreditDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_credit_details", parameters);
        String[] returnValues = new String[17];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "created_by";
        returnValues[3] = "created_date";
        returnValues[4] = "amount";
        returnValues[5] = "credit_type";
        returnValues[6] = "applied_amount";
        returnValues[7] = "unapplied_amount";
        returnValues[8] = "reason_code";
        returnValues[9] = "reason_text";
        returnValues[10] = "comments";
        returnValues[11] = "transaction_id";
        returnValues[12] = "void_transaction_id";
        returnValues[13] = "credit_expiry_type_ind";
        returnValues[14] = "credit_expiry_months";
        returnValues[15] = "credit_expiry_date";
        returnValues[16] = "eligible_service_plan_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctCredits(Long client_no, String auth_key, Long acct_no, Long limit_records){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"limit_records", getValue("Long", limit_records));
        
        return this.buildGetAcctCreditsHashMap(parameters);
    }

    public Map<String,Object> getAcctCredits(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long limit_records = (Long) map.get("limit_records");
        
        return getAcctCredits(client_no, auth_key, acct_no, limit_records);
    }
        private Map<String,Object> buildGetAcctCreditsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_credits", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_credits";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctDetailsAll(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctDetailsAllHashMap(parameters);
    }

    public Map<String,Object> getAcctDetailsAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctDetailsAll(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctDetailsAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_details_all", parameters);
        String[] returnValues = new String[150];
        
        returnValues[0] = "first_name";
        returnValues[1] = "mi";
        returnValues[2] = "last_name";
        returnValues[3] = "userid";
        returnValues[4] = "birthdate";
        returnValues[5] = "job_title";
        returnValues[6] = "salutation";
        returnValues[7] = "senior_acct_no";
        returnValues[8] = "client_acct_id";
        returnValues[9] = "resp_level_cd";
        returnValues[10] = "is_test_acct";
        returnValues[11] = "alt_email";
        returnValues[12] = "address1";
        returnValues[13] = "address2";
        returnValues[14] = "city";
        returnValues[15] = "state_prov";
        returnValues[16] = "locality";
        returnValues[17] = "postal_code";
        returnValues[18] = "country";
        returnValues[19] = "company_name";
        returnValues[20] = "cell_phone_npa";
        returnValues[21] = "cell_phone_nxx";
        returnValues[22] = "cell_phone_suffix";
        returnValues[23] = "fax_phone";
        returnValues[24] = "intl_cell_phone";
        returnValues[25] = "intl_phone";
        returnValues[26] = "phone_extension";
        returnValues[27] = "phone_npa";
        returnValues[28] = "phone_nxx";
        returnValues[29] = "phone_suffix";
        returnValues[30] = "work_phone";
        returnValues[31] = "work_phone_extension";
        returnValues[32] = "work_phone_npa";
        returnValues[33] = "work_phone_nxx";
        returnValues[34] = "work_phone_suffix";
        returnValues[35] = "bill_day";
        returnValues[36] = "created";
        returnValues[37] = "date_to_expire";
        returnValues[38] = "date_to_suspend";
        returnValues[39] = "last_arrears_bill_thru_date";
        returnValues[40] = "last_bill_date";
        returnValues[41] = "last_bill_thru_date";
        returnValues[42] = "next_bill_date";
        returnValues[43] = "plan_date";
        returnValues[44] = "status_date";
        returnValues[45] = "status_degrade_date";
        returnValues[46] = "status_cd";
        returnValues[47] = "status_label";
        returnValues[48] = "plan_no";
        returnValues[49] = "plan_name";
        returnValues[50] = "plan_units";
        returnValues[51] = "notify_method";
        returnValues[52] = "notify_method_name";
        returnValues[53] = "PASSWORD";
        returnValues[54] = "pin";
        returnValues[55] = "secret_question";
        returnValues[56] = "secret_question_answer";
        returnValues[57] = "pay_method";
        returnValues[58] = "pay_method_name";
        returnValues[59] = "currency_cd";
        returnValues[60] = "tax_id";
        returnValues[61] = "billing_email";
        returnValues[62] = "billing_first_name";
        returnValues[63] = "billing_middle_initial";
        returnValues[64] = "billing_last_name";
        returnValues[65] = "billing_address1";
        returnValues[66] = "billing_address2";
        returnValues[67] = "billing_city";
        returnValues[68] = "billing_state";
        returnValues[69] = "billing_locality";
        returnValues[70] = "billing_zip";
        returnValues[71] = "billing_country";
        returnValues[72] = "cc_type";
        returnValues[73] = "cc_suffix";
        returnValues[74] = "cc_expire_mm";
        returnValues[75] = "cc_expire_yyyy";
        returnValues[76] = "cc_id";
        returnValues[77] = "bank_acct_suffix";
        returnValues[78] = "bank_routing_no";
        returnValues[79] = "billing_cell_phone";
        returnValues[80] = "billing_cell_phone_npa";
        returnValues[81] = "billing_cell_phone_nxx";
        returnValues[82] = "billing_cell_phone_suffix";
        returnValues[83] = "billing_company_name";
        returnValues[84] = "billing_intl_phone";
        returnValues[85] = "billing_phone_extension";
        returnValues[86] = "billing_phone_npa";
        returnValues[87] = "billing_phone_nxx";
        returnValues[88] = "billing_phone_suffix";
        returnValues[89] = "billing_work_phone";
        returnValues[90] = "billing_work_phone_extension";
        returnValues[91] = "billing_work_phone_npa";
        returnValues[92] = "billing_work_phone_nxx";
        returnValues[93] = "billing_work_phone_suffix";
        returnValues[94] = "balance";
        returnValues[95] = "acct_create_client_receipt_id";
        returnValues[96] = "plan_client_receipt_id";
        returnValues[97] = "status_client_receipt_id";
        returnValues[98] = "taxpayer_id";
        returnValues[99] = "alt_msg_template_no";
        returnValues[100] = "seq_func_group_no";
        returnValues[101] = "promo_cd";
        returnValues[102] = "address3";
        returnValues[103] = "billing_address3";
        returnValues[104] = "address_verification_code";
        returnValues[105] = "address_match_score";
        returnValues[106] = "billing_address_verification_code";
        returnValues[107] = "billing_address_match_score";
        returnValues[108] = "client_plan_id";
        returnValues[109] = "client_alt_msg_template_id";
        returnValues[110] = "bkup_pay_method";
        returnValues[111] = "bkup_billing_email";
        returnValues[112] = "bkup_billing_first_name";
        returnValues[113] = "bkup_billing_middle_initial";
        returnValues[114] = "bkup_billing_last_name";
        returnValues[115] = "bkup_billing_address1";
        returnValues[116] = "bkup_billing_address2";
        returnValues[117] = "bkup_billing_city";
        returnValues[118] = "bkup_billing_state";
        returnValues[119] = "bkup_billing_locality";
        returnValues[120] = "bkup_billing_zip";
        returnValues[121] = "bkup_billing_country";
        returnValues[122] = "bkup_cc_type";
        returnValues[123] = "bkup_cc_suffix";
        returnValues[124] = "bkup_cc_expire_mm";
        returnValues[125] = "bkup_cc_expire_yyyy";
        returnValues[126] = "bkup_cc_id";
        returnValues[127] = "bkup_bank_acct_suffix";
        returnValues[128] = "bkup_bank_routing_no";
        returnValues[129] = "bkup_billing_cell_phone";
        returnValues[130] = "bkup_billing_cell_phone_npa";
        returnValues[131] = "bkup_billing_cell_phone_nxx";
        returnValues[132] = "bkup_billing_cell_phone_suffix";
        returnValues[133] = "bkup_billing_company_name";
        returnValues[134] = "bkup_billing_intl_phone";
        returnValues[135] = "bkup_billing_phone_extension";
        returnValues[136] = "bkup_billing_work_phone";
        returnValues[137] = "bkup_billing_work_phone_extension";
        returnValues[138] = "bkup_billing_work_phone_npa";
        returnValues[139] = "bkup_billing_work_phone_nxx";
        returnValues[140] = "bkup_billing_work_phone_suffix";
        returnValues[141] = "invoice_approval_required";
        returnValues[142] = "stmnt_email_list_cc";
        returnValues[143] = "stmnt_email_list_bcc";
        returnValues[144] = "invoice_posting_method_cd";
        returnValues[145] = "acct_start_date";
        returnValues[146] = "bill_agreement_id";
        returnValues[147] = "bkup_bill_agreement_id";
        returnValues[148] = "error_code";
        returnValues[149] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctGroupsByAcct(Long client_no, String auth_key, Long acct_no, String user_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"user_id", getValue("String", user_id));
        
        return this.buildGetAcctGroupsByAcctHashMap(parameters);
    }

    public Map<String,Object> getAcctGroupsByAcct(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String user_id = (String) map.get("user_id");
        
        return getAcctGroupsByAcct(client_no, auth_key, acct_no, user_id);
    }
        private Map<String,Object> buildGetAcctGroupsByAcctHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_groups_by_acct", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_groups";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctGroupsByClient(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetAcctGroupsByClientHashMap(parameters);
    }

    public Map<String,Object> getAcctGroupsByClient(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getAcctGroupsByClient(client_no, auth_key);
    }
        private Map<String,Object> buildGetAcctGroupsByClientHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_groups_by_client", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_groups";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctHasOrderedSku(Long client_no, String auth_key, Long acct_no, String sku){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"sku", getValue("String", sku));
        
        return this.buildGetAcctHasOrderedSkuHashMap(parameters);
    }

    public Map<String,Object> getAcctHasOrderedSku(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String sku = (String) map.get("sku");
        
        return getAcctHasOrderedSku(client_no, auth_key, acct_no, sku);
    }
        private Map<String,Object> buildGetAcctHasOrderedSkuHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_has_ordered_sku", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "ordered_ind";
        returnValues[3] = "billed_ind";
        returnValues[4] = "paid_ind";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctHierarchyDetails(Long client_no, String auth_key, Long acct_no, Long hierarchy_filter, Long include_current_acct){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"hierarchy_filter", getValue("Long", hierarchy_filter));
        addParameters(parameters,"include_current_acct", getValue("Long", include_current_acct));
        
        return this.buildGetAcctHierarchyDetailsHashMap(parameters);
    }

    public Map<String,Object> getAcctHierarchyDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long hierarchy_filter = (Long) map.get("hierarchy_filter");
        Long include_current_acct = (Long) map.get("include_current_acct");
        
        return getAcctHierarchyDetails(client_no, auth_key, acct_no, hierarchy_filter, include_current_acct);
    }
        private Map<String,Object> buildGetAcctHierarchyDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_hierarchy_details", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_hierarchy_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctInvoiceHistory(Long client_no, String auth_key, Long acct_no, String user_id, String start_bill_date, String end_bill_date, String include_voided, Long posting_status_cd, String posting_user){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"start_bill_date", getValue("String", start_bill_date));
        addParameters(parameters,"end_bill_date", getValue("String", end_bill_date));
        addParameters(parameters,"include_voided", getValue("String", include_voided));
        addParameters(parameters,"posting_status_cd", getValue("Long", posting_status_cd));
        addParameters(parameters,"posting_user", getValue("String", posting_user));
        
        return this.buildGetAcctInvoiceHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctInvoiceHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String user_id = (String) map.get("user_id");
        String start_bill_date = (String) map.get("start_bill_date");
        String end_bill_date = (String) map.get("end_bill_date");
        String include_voided = (String) map.get("include_voided");
        Long posting_status_cd = (Long) map.get("posting_status_cd");
        String posting_user = (String) map.get("posting_user");
        
        return getAcctInvoiceHistory(client_no, auth_key, acct_no, user_id, start_bill_date, end_bill_date, include_voided, posting_status_cd, posting_user);
    }
        private Map<String,Object> buildGetAcctInvoiceHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_invoice_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_history";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctMessage(Long client_no, String auth_key, Long acct_no, Long message_id, String do_encoding){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"message_id", getValue("Long", message_id));
        addParameters(parameters,"do_encoding", getValue("String", do_encoding));
        
        return this.buildGetAcctMessageHashMap(parameters);
    }

    public Map<String,Object> getAcctMessage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long message_id = (Long) map.get("message_id");
        String do_encoding = (String) map.get("do_encoding");
        
        return getAcctMessage(client_no, auth_key, acct_no, message_id, do_encoding);
    }
        private Map<String,Object> buildGetAcctMessageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_message", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "message_body";
        returnValues[3] = "mime_type";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctMessageSize(Long client_no, String auth_key, Long acct_no, Long message_id, String do_encoding){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"message_id", getValue("Long", message_id));
        addParameters(parameters,"do_encoding", getValue("String", do_encoding));
        
        return this.buildGetAcctMessageSizeHashMap(parameters);
    }

    public Map<String,Object> getAcctMessageSize(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long message_id = (Long) map.get("message_id");
        String do_encoding = (String) map.get("do_encoding");
        
        return getAcctMessageSize(client_no, auth_key, acct_no, message_id, do_encoding);
    }
        private Map<String,Object> buildGetAcctMessageSizeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_message_size", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "num_chars";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, String exclude_terminated_plans){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"contract_no", getValue("Long", contract_no));
        addParameters(parameters,"exclude_terminated_plans", getValue("String", exclude_terminated_plans));
        
        return this.buildGetAcctMultiplanContractHashMap(parameters);
    }

    public Map<String,Object> getAcctMultiplanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long contract_no = (Long) map.get("contract_no");
        String exclude_terminated_plans = (String) map.get("exclude_terminated_plans");
        
        return getAcctMultiplanContract(client_no, auth_key, acct_no, contract_no, exclude_terminated_plans);
    }
        private Map<String,Object> buildGetAcctMultiplanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_multiplan_contract", parameters);
        String[] returnValues = new String[14];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "type_no";
        returnValues[3] = "length_months";
        returnValues[4] = "create_comments";
        returnValues[5] = "update_comments";
        returnValues[6] = "create_date";
        returnValues[7] = "update_date";
        returnValues[8] = "start_date";
        returnValues[9] = "end_date";
        returnValues[10] = "status_code";
        returnValues[11] = "plan_no";
        returnValues[12] = "plan_name";
        returnValues[13] = "client_plan_id";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctNoFromUserId(Long client_no, String auth_key, String user_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        
        return this.buildGetAcctNoFromUserIdHashMap(parameters);
    }

    public Map<String,Object> getAcctNoFromUserId(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        
        return getAcctNoFromUserId(client_no, auth_key, user_id);
    }
        private Map<String,Object> buildGetAcctNoFromUserIdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_no_from_user_id", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctNotificationDetails(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"acct_user_id", getValue("String", acct_user_id));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        
        return this.buildGetAcctNotificationDetailsHashMap(parameters);
    }

    public Map<String,Object> getAcctNotificationDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String acct_user_id = (String) map.get("acct_user_id");
        String client_acct_id = (String) map.get("client_acct_id");
        
        return getAcctNotificationDetails(client_no, auth_key, acct_no, acct_user_id, client_acct_id);
    }
        private Map<String,Object> buildGetAcctNotificationDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_notification_details", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_notification_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctNotifyMethod(Long client_no, String auth_key, Long account_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        
        return this.buildGetAcctNotifyMethodHashMap(parameters);
    }

    public Map<String,Object> getAcctNotifyMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        
        return getAcctNotifyMethod(client_no, auth_key, account_no);
    }
        private Map<String,Object> buildGetAcctNotifyMethodHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_notify_method", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "notify_method";
        returnValues[3] = "notify_method_name";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctOpenCharges(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctOpenChargesHashMap(parameters);
    }

    public Map<String,Object> getAcctOpenCharges(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctOpenCharges(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctOpenChargesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_open_charges", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "total_amount";
        returnValues[3] = "open_charge_items";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPaymentMethods(Long client_no, String auth_key, Long acct_no, Long filter_seq_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"filter_seq_no", getValue("Long", filter_seq_no));
        
        return this.buildGetAcctPaymentMethodsHashMap(parameters);
    }

    public Map<String,Object> getAcctPaymentMethods(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long filter_seq_no = (Long) map.get("filter_seq_no");
        
        return getAcctPaymentMethods(client_no, auth_key, acct_no, filter_seq_no);
    }
        private Map<String,Object> buildGetAcctPaymentMethodsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_payment_methods", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "acct_pay_methods";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildGetAcctPlanContractHashMap(parameters);
    }

    public Map<String,Object> getAcctPlanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return getAcctPlanContract(client_no, auth_key, acct_no, plan_no, client_plan_id);
    }
        private Map<String,Object> buildGetAcctPlanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_plan_contract", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_plan_contract";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPlanHistory(Long client_no, String auth_key, Long account_number){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_number", getValue("Long", account_number));
        
        return this.buildGetAcctPlanHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctPlanHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_number = (Long) map.get("account_number");
        
        return getAcctPlanHistory(client_no, auth_key, account_number);
    }
        private Map<String,Object> buildGetAcctPlanHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_plan_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_hist";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPlanUnitInstanceAll(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long plan_no, String client_plan_id, Long plan_unit_inst_no, String client_plan_unit_inst_id, Long status_cd, Long plan_unit_inst_status_cd, Long fulfillment_only){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"plan_unit_inst_no", getValue("Long", plan_unit_inst_no));
        addParameters(parameters,"client_plan_unit_inst_id", getValue("String", client_plan_unit_inst_id));
        addParameters(parameters,"status_cd", getValue("Long", status_cd));
        addParameters(parameters,"plan_unit_inst_status_cd", getValue("Long", plan_unit_inst_status_cd));
        addParameters(parameters,"fulfillment_only", getValue("Long", fulfillment_only));
        
        return this.buildGetAcctPlanUnitInstanceAllHashMap(parameters);
    }

    public Map<String,Object> getAcctPlanUnitInstanceAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        Long plan_unit_inst_no = (Long) map.get("plan_unit_inst_no");
        String client_plan_unit_inst_id = (String) map.get("client_plan_unit_inst_id");
        Long status_cd = (Long) map.get("status_cd");
        Long plan_unit_inst_status_cd = (Long) map.get("plan_unit_inst_status_cd");
        Long fulfillment_only = (Long) map.get("fulfillment_only");
        
        return getAcctPlanUnitInstanceAll(client_no, auth_key, acct_no, client_acct_id, plan_no, client_plan_id, plan_unit_inst_no, client_plan_unit_inst_id, status_cd, plan_unit_inst_status_cd, fulfillment_only);
    }
        private Map<String,Object> buildGetAcctPlanUnitInstanceAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_plan_unit_instance_all", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_no";
        returnValues[3] = "client_acct_id";
        returnValues[4] = "all_plan_unit_instances";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPlans(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctPlansHashMap(parameters);
    }

    public Map<String,Object> getAcctPlans(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctPlans(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctPlansHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_plans", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctPlansAll(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctPlansAllHashMap(parameters);
    }

    public Map<String,Object> getAcctPlansAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctPlansAll(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctPlansAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_plans_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_acct_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctServiceOutageCredit(Long client_no, String auth_key, Long acct_no, String outage_start_date, String outage_end_date, String outage_start_time, String outage_end_time, com.aria.common.shared.PlansToGetOutageArray plans_to_get_outage, Double adjust_percent, com.aria.common.shared.ClientPlanIdsToGetOutageArray client_plan_ids_to_get_outage){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"outage_start_date", getValue("String", outage_start_date));
        addParameters(parameters,"outage_end_date", getValue("String", outage_end_date));
        addParameters(parameters,"outage_start_time", getValue("String", outage_start_time));
        addParameters(parameters,"outage_end_time", getValue("String", outage_end_time));
        RestUtilities.addParameterValuesFromArray(parameters, plans_to_get_outage);
        addParameters(parameters,"adjust_percent", getValue("Double", adjust_percent));
        RestUtilities.addParameterValuesFromArray(parameters, client_plan_ids_to_get_outage);
        
        return this.buildGetAcctServiceOutageCreditHashMap(parameters);
    }

    public Map<String,Object> getAcctServiceOutageCredit(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String outage_start_date = (String) map.get("outage_start_date");
        String outage_end_date = (String) map.get("outage_end_date");
        String outage_start_time = (String) map.get("outage_start_time");
        String outage_end_time = (String) map.get("outage_end_time");
        com.aria.common.shared.PlansToGetOutageArray plans_to_get_outage = (com.aria.common.shared.PlansToGetOutageArray) map.get("plans_to_get_outage");
        Double adjust_percent = (Double) map.get("adjust_percent");
        com.aria.common.shared.ClientPlanIdsToGetOutageArray client_plan_ids_to_get_outage = (com.aria.common.shared.ClientPlanIdsToGetOutageArray) map.get("client_plan_ids_to_get_outage");
        
        return getAcctServiceOutageCredit(client_no, auth_key, acct_no, outage_start_date, outage_end_date, outage_start_time, outage_end_time, plans_to_get_outage, adjust_percent, client_plan_ids_to_get_outage);
    }
        private Map<String,Object> buildGetAcctServiceOutageCreditHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_service_outage_credit", parameters);
        String[] returnValues = new String[6];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_no";
        returnValues[3] = "service_outage_line_items";
        returnValues[4] = "total_outage_credit";
        returnValues[5] = "adjusted_outage_credit";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctStatementHistory(Long client_no, String auth_key, Long acct_no, String user_id, String start_date, String end_date, String include_invoice_activity_eligibility){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        addParameters(parameters,"include_invoice_activity_eligibility", getValue("String", include_invoice_activity_eligibility));
        
        return this.buildGetAcctStatementHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctStatementHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String user_id = (String) map.get("user_id");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        String include_invoice_activity_eligibility = (String) map.get("include_invoice_activity_eligibility");
        
        return getAcctStatementHistory(client_no, auth_key, acct_no, user_id, start_date, end_date, include_invoice_activity_eligibility);
    }
        private Map<String,Object> buildGetAcctStatementHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_statement_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "statement_history";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctStatusHistory(Long client_no, String auth_key, Long account_number){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_number", getValue("Long", account_number));
        
        return this.buildGetAcctStatusHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctStatusHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_number = (Long) map.get("account_number");
        
        return getAcctStatusHistory(client_no, auth_key, account_number);
    }
        private Map<String,Object> buildGetAcctStatusHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_status_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "stat_hist";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctSuppFields(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctSuppFieldsHashMap(parameters);
    }

    public Map<String,Object> getAcctSuppFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctSuppFields(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctSuppFieldsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_supp_fields", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "supp_fields";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctSuppPlanHistory(Long client_no, String auth_key, Long acct_no, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildGetAcctSuppPlanHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctSuppPlanHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return getAcctSuppPlanHistory(client_no, auth_key, acct_no, plan_no, client_plan_id);
    }
        private Map<String,Object> buildGetAcctSuppPlanHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_supp_plan_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "supp_plan_hist";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctTaxExemptStatus(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctTaxExemptStatusHashMap(parameters);
    }

    public Map<String,Object> getAcctTaxExemptStatus(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctTaxExemptStatus(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctTaxExemptStatusHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_tax_exempt_status", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "exemption_level";
        returnValues[3] = "exemption_level_desc";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctTransHistory(Long client_no, String auth_key, Long account_no, Long transaction_type, String start_date, String end_date, Long record_limit, Long filter_statement_no, String include_void_transactions){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"transaction_type", getValue("Long", transaction_type));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        addParameters(parameters,"record_limit", getValue("Long", record_limit));
        addParameters(parameters,"filter_statement_no", getValue("Long", filter_statement_no));
        addParameters(parameters,"include_void_transactions", getValue("String", include_void_transactions));
        
        return this.buildGetAcctTransHistoryHashMap(parameters);
    }

    public Map<String,Object> getAcctTransHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long transaction_type = (Long) map.get("transaction_type");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        Long record_limit = (Long) map.get("record_limit");
        Long filter_statement_no = (Long) map.get("filter_statement_no");
        String include_void_transactions = (String) map.get("include_void_transactions");
        
        return getAcctTransHistory(client_no, auth_key, account_no, transaction_type, start_date, end_date, record_limit, filter_statement_no, include_void_transactions);
    }
        private Map<String,Object> buildGetAcctTransHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_trans_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "history";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctUniversalContract(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAcctUniversalContractHashMap(parameters);
    }

    public Map<String,Object> getAcctUniversalContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAcctUniversalContract(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAcctUniversalContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_universal_contract", parameters);
        String[] returnValues = new String[12];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "type_no";
        returnValues[3] = "length_months";
        returnValues[4] = "create_comments";
        returnValues[5] = "update_comments";
        returnValues[6] = "create_date";
        returnValues[7] = "update_date";
        returnValues[8] = "start_date";
        returnValues[9] = "end_date";
        returnValues[10] = "status_code";
        returnValues[11] = "contract_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctUuids(Long client_no, String auth_key, Long acct_no, String client_acct_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        
        return this.buildGetAcctUuidsHashMap(parameters);
    }

    public Map<String,Object> getAcctUuids(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        
        return getAcctUuids(client_no, auth_key, acct_no, client_acct_id);
    }
        private Map<String,Object> buildGetAcctUuidsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_uuids", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "uuid_data";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctsWithExistingPayMethod(Long client_no, String auth_key, Long pay_method, String form_payment_acct_id, String bank_routing_num, String bill_agreement_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"pay_method", getValue("Long", pay_method));
        addParameters(parameters,"form_payment_acct_id", getValue("String", form_payment_acct_id));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bill_agreement_id", getValue("String", bill_agreement_id));
        
        return this.buildGetAcctsWithExistingPayMethodHashMap(parameters);
    }

    public Map<String,Object> getAcctsWithExistingPayMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long pay_method = (Long) map.get("pay_method");
        String form_payment_acct_id = (String) map.get("form_payment_acct_id");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bill_agreement_id = (String) map.get("bill_agreement_id");
        
        return getAcctsWithExistingPayMethod(client_no, auth_key, pay_method, form_payment_acct_id, bank_routing_num, bill_agreement_id);
    }
        private Map<String,Object> buildGetAcctsWithExistingPayMethodHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_accts_with_existing_pay_method", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "accts_with_pay_method";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAllAcctContracts(Long client_no, String auth_key, Long acct_no, Long filter_status_code, String exclude_terminated_plans){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"filter_status_code", getValue("Long", filter_status_code));
        addParameters(parameters,"exclude_terminated_plans", getValue("String", exclude_terminated_plans));
        
        return this.buildGetAllAcctContractsHashMap(parameters);
    }

    public Map<String,Object> getAllAcctContracts(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long filter_status_code = (Long) map.get("filter_status_code");
        String exclude_terminated_plans = (String) map.get("exclude_terminated_plans");
        
        return getAllAcctContracts(client_no, auth_key, acct_no, filter_status_code, exclude_terminated_plans);
    }
        private Map<String,Object> buildGetAllAcctContractsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_all_acct_contracts", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_acct_contracts";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAllAcctReceiptIds(Long client_no, String auth_key, Long acct_no, String start_date_range, String end_date_range){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"start_date_range", getValue("String", start_date_range));
        addParameters(parameters,"end_date_range", getValue("String", end_date_range));
        
        return this.buildGetAllAcctReceiptIdsHashMap(parameters);
    }

    public Map<String,Object> getAllAcctReceiptIds(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String start_date_range = (String) map.get("start_date_range");
        String end_date_range = (String) map.get("end_date_range");
        
        return getAllAcctReceiptIds(client_no, auth_key, acct_no, start_date_range, end_date_range);
    }
        private Map<String,Object> buildGetAllAcctReceiptIdsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_all_acct_receipt_ids", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_receipt";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAvailChildPlansForAcct(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAvailChildPlansForAcctHashMap(parameters);
    }

    public Map<String,Object> getAvailChildPlansForAcct(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAvailChildPlansForAcct(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAvailChildPlansForAcctHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_avail_child_plans_for_acct", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAvailChildPlansForAcctAll(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAvailChildPlansForAcctAllHashMap(parameters);
    }

    public Map<String,Object> getAvailChildPlansForAcctAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAvailChildPlansForAcctAll(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAvailChildPlansForAcctAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_avail_child_plans_for_acct_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAvailChildPlansForPlan(Long client_no, String auth_key, Long in_plan_no, String in_client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"in_plan_no", getValue("Long", in_plan_no));
        addParameters(parameters,"in_client_plan_id", getValue("String", in_client_plan_id));
        
        return this.buildGetAvailChildPlansForPlanHashMap(parameters);
    }

    public Map<String,Object> getAvailChildPlansForPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long in_plan_no = (Long) map.get("in_plan_no");
        String in_client_plan_id = (String) map.get("in_client_plan_id");
        
        return getAvailChildPlansForPlan(client_no, auth_key, in_plan_no, in_client_plan_id);
    }
        private Map<String,Object> buildGetAvailChildPlansForPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_avail_child_plans_for_plan", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAvailChildPlansForPlanAll(Long client_no, String auth_key, Long in_plan_no, String in_client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"in_plan_no", getValue("Long", in_plan_no));
        addParameters(parameters,"in_client_plan_id", getValue("String", in_client_plan_id));
        
        return this.buildGetAvailChildPlansForPlanAllHashMap(parameters);
    }

    public Map<String,Object> getAvailChildPlansForPlanAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long in_plan_no = (Long) map.get("in_plan_no");
        String in_client_plan_id = (String) map.get("in_client_plan_id");
        
        return getAvailChildPlansForPlanAll(client_no, auth_key, in_plan_no, in_client_plan_id);
    }
        private Map<String,Object> buildGetAvailChildPlansForPlanAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_avail_child_plans_for_plan_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAvailablePlans(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAvailablePlansHashMap(parameters);
    }

    public Map<String,Object> getAvailablePlans(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAvailablePlans(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAvailablePlansHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_available_plans", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAvailablePlansAll(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetAvailablePlansAllHashMap(parameters);
    }

    public Map<String,Object> getAvailablePlansAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getAvailablePlansAll(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetAvailablePlansAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_available_plans_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCcUuid(Long client_no, String auth_key, String cc_number){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        
        return this.buildGetCcUuidHashMap(parameters);
    }

    public Map<String,Object> getCcUuid(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String cc_number = (String) map.get("cc_number");
        
        return getCcUuid(client_no, auth_key, cc_number);
    }
        private Map<String,Object> buildGetCcUuidHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_cc_uuid", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "uuid";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getChildAccts(Long client_no, String auth_key, Long parent_acct_no, String do_multi_level){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"parent_acct_no", getValue("Long", parent_acct_no));
        addParameters(parameters,"do_multi_level", getValue("String", do_multi_level));
        
        return this.buildGetChildAcctsHashMap(parameters);
    }

    public Map<String,Object> getChildAccts(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long parent_acct_no = (Long) map.get("parent_acct_no");
        String do_multi_level = (String) map.get("do_multi_level");
        
        return getChildAccts(client_no, auth_key, parent_acct_no, do_multi_level);
    }
        private Map<String,Object> buildGetChildAcctsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_child_accts", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "child_accts";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCouponDetails(Long client_no, String auth_key, Long acct_no, String coupon_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        
        return this.buildGetCouponDetailsHashMap(parameters);
    }

    public Map<String,Object> getCouponDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String coupon_cd = (String) map.get("coupon_cd");
        
        return getCouponDetails(client_no, auth_key, acct_no, coupon_cd);
    }
        private Map<String,Object> buildGetCouponDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_coupon_details", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupons";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCreditReasonCodes(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetCreditReasonCodesHashMap(parameters);
    }

    public Map<String,Object> getCreditReasonCodes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getCreditReasonCodes(client_no, auth_key);
    }
        private Map<String,Object> buildGetCreditReasonCodesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_credit_reason_codes", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "credit_reason_codes";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getFamilyTransHistory(Long client_no, String auth_key, Long parent_acct_no, String do_multi_level, Long trans_type, String start_date, String end_date, Long record_limit, String include_void_transactions){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"parent_acct_no", getValue("Long", parent_acct_no));
        addParameters(parameters,"do_multi_level", getValue("String", do_multi_level));
        addParameters(parameters,"trans_type", getValue("Long", trans_type));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        addParameters(parameters,"record_limit", getValue("Long", record_limit));
        addParameters(parameters,"include_void_transactions", getValue("String", include_void_transactions));
        
        return this.buildGetFamilyTransHistoryHashMap(parameters);
    }

    public Map<String,Object> getFamilyTransHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long parent_acct_no = (Long) map.get("parent_acct_no");
        String do_multi_level = (String) map.get("do_multi_level");
        Long trans_type = (Long) map.get("trans_type");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        Long record_limit = (Long) map.get("record_limit");
        String include_void_transactions = (String) map.get("include_void_transactions");
        
        return getFamilyTransHistory(client_no, auth_key, parent_acct_no, do_multi_level, trans_type, start_date, end_date, record_limit, include_void_transactions);
    }
        private Map<String,Object> buildGetFamilyTransHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_family_trans_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "fam_trans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPendingInvoiceNo(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetPendingInvoiceNoHashMap(parameters);
    }

    public Map<String,Object> getPendingInvoiceNo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getPendingInvoiceNo(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetPendingInvoiceNoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_pending_invoice_no", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "invoice_no";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPlansByPromoCode(Long client_no, String auth_key, String promo_code){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_code", getValue("String", promo_code));
        
        return this.buildGetPlansByPromoCodeHashMap(parameters);
    }

    public Map<String,Object> getPlansByPromoCode(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_code = (String) map.get("promo_code");
        
        return getPlansByPromoCode(client_no, auth_key, promo_code);
    }
        private Map<String,Object> buildGetPlansByPromoCodeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_plans_by_promo_code", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPlansByPromoCodeAll(Long client_no, String auth_key, String promo_code){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_code", getValue("String", promo_code));
        
        return this.buildGetPlansByPromoCodeAllHashMap(parameters);
    }

    public Map<String,Object> getPlansByPromoCodeAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_code = (String) map.get("promo_code");
        
        return getPlansByPromoCodeAll(client_no, auth_key, promo_code);
    }
        private Map<String,Object> buildGetPlansByPromoCodeAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_plans_by_promo_code_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPmtUuid(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long seq_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"seq_no", getValue("Long", seq_no));
        
        return this.buildGetPmtUuidHashMap(parameters);
    }

    public Map<String,Object> getPmtUuid(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        Long seq_no = (Long) map.get("seq_no");
        
        return getPmtUuid(client_no, auth_key, acct_no, client_acct_id, seq_no);
    }
        private Map<String,Object> buildGetPmtUuidHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_pmt_uuid", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "uuid";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getQueuedServicePlans(Long client_no, String auth_key, Long account_number){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_number", getValue("Long", account_number));
        
        return this.buildGetQueuedServicePlansHashMap(parameters);
    }

    public Map<String,Object> getQueuedServicePlans(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_number = (Long) map.get("account_number");
        
        return getQueuedServicePlans(client_no, auth_key, account_number);
    }
        private Map<String,Object> buildGetQueuedServicePlansHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_queued_service_plans", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "queued_plans";
        returnValues[3] = "current_rate_schedule_no";
        returnValues[4] = "client_current_rate_schedule_id";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRecurringCreditInfo(Long client_no, String auth_key, Long acct_no, Long filter_credit_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"filter_credit_no", getValue("Long", filter_credit_no));
        
        return this.buildGetRecurringCreditInfoHashMap(parameters);
    }

    public Map<String,Object> getRecurringCreditInfo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long filter_credit_no = (Long) map.get("filter_credit_no");
        
        return getRecurringCreditInfo(client_no, auth_key, acct_no, filter_credit_no);
    }
        private Map<String,Object> buildGetRecurringCreditInfoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_recurring_credit_info", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "recurring_credit_info";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStandingUsage(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetStandingUsageHashMap(parameters);
    }

    public Map<String,Object> getStandingUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getStandingUsage(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetStandingUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_standing_usage", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "su";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStatementContent(Long client_no, String auth_key, Long acct_no, Long statement_no, String do_encoding){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"statement_no", getValue("Long", statement_no));
        addParameters(parameters,"do_encoding", getValue("String", do_encoding));
        
        return this.buildGetStatementContentHashMap(parameters);
    }

    public Map<String,Object> getStatementContent(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long statement_no = (Long) map.get("statement_no");
        String do_encoding = (String) map.get("do_encoding");
        
        return getStatementContent(client_no, auth_key, acct_no, statement_no, do_encoding);
    }
        private Map<String,Object> buildGetStatementContentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_statement_content", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "statement_content";
        returnValues[3] = "mime_type";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getStatementContentSize(Long client_no, String auth_key, Long acct_no, Long statement_no, String do_encoding){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"statement_no", getValue("Long", statement_no));
        addParameters(parameters,"do_encoding", getValue("String", do_encoding));
        
        return this.buildGetStatementContentSizeHashMap(parameters);
    }

    public Map<String,Object> getStatementContentSize(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long statement_no = (Long) map.get("statement_no");
        String do_encoding = (String) map.get("do_encoding");
        
        return getStatementContentSize(client_no, auth_key, acct_no, statement_no, do_encoding);
    }
        private Map<String,Object> buildGetStatementContentSizeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_statement_content_size", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "num_chars";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getSuppFieldValues(Long client_no, String auth_key, Long acct_no, String field_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"field_name", getValue("String", field_name));
        
        return this.buildGetSuppFieldValuesHashMap(parameters);
    }

    public Map<String,Object> getSuppFieldValues(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String field_name = (String) map.get("field_name");
        
        return getSuppFieldValues(client_no, auth_key, acct_no, field_name);
    }
        private Map<String,Object> buildGetSuppFieldValuesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_supp_field_values", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_supp_field_values";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getSuppPlansByPromoCode(Long client_no, String auth_key, String promo_code){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_code", getValue("String", promo_code));
        
        return this.buildGetSuppPlansByPromoCodeHashMap(parameters);
    }

    public Map<String,Object> getSuppPlansByPromoCode(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_code = (String) map.get("promo_code");
        
        return getSuppPlansByPromoCode(client_no, auth_key, promo_code);
    }
        private Map<String,Object> buildGetSuppPlansByPromoCodeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_supp_plans_by_promo_code", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getSuppPlansByPromoCodeAll(Long client_no, String auth_key, String promo_code){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_code", getValue("String", promo_code));
        
        return this.buildGetSuppPlansByPromoCodeAllHashMap(parameters);
    }

    public Map<String,Object> getSuppPlansByPromoCodeAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_code = (String) map.get("promo_code");
        
        return getSuppPlansByPromoCodeAll(client_no, auth_key, promo_code);
    }
        private Map<String,Object> buildGetSuppPlansByPromoCodeAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_supp_plans_by_promo_code_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getUnappliedServiceCredits(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetUnappliedServiceCreditsHashMap(parameters);
    }

    public Map<String,Object> getUnappliedServiceCredits(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getUnappliedServiceCredits(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetUnappliedServiceCreditsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_unapplied_service_credits", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "unapplied_service_credits";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getUnbilledUsageSummary(Long client_no, String auth_key, Long acct_no, String usage_details_flag, String include_all_usage_unit_thresholds, Long plan_no, Long usage_type_no, String usage_type_code, String retrieve_excluded_usage){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"usage_details_flag", getValue("String", usage_details_flag));
        addParameters(parameters,"include_all_usage_unit_thresholds", getValue("String", include_all_usage_unit_thresholds));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"usage_type_no", getValue("Long", usage_type_no));
        addParameters(parameters,"usage_type_code", getValue("String", usage_type_code));
        addParameters(parameters,"retrieve_excluded_usage", getValue("String", retrieve_excluded_usage));
        
        return this.buildGetUnbilledUsageSummaryHashMap(parameters);
    }

    public Map<String,Object> getUnbilledUsageSummary(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String usage_details_flag = (String) map.get("usage_details_flag");
        String include_all_usage_unit_thresholds = (String) map.get("include_all_usage_unit_thresholds");
        Long plan_no = (Long) map.get("plan_no");
        Long usage_type_no = (Long) map.get("usage_type_no");
        String usage_type_code = (String) map.get("usage_type_code");
        String retrieve_excluded_usage = (String) map.get("retrieve_excluded_usage");
        
        return getUnbilledUsageSummary(client_no, auth_key, acct_no, usage_details_flag, include_all_usage_unit_thresholds, plan_no, usage_type_no, usage_type_code, retrieve_excluded_usage);
    }
        private Map<String,Object> buildGetUnbilledUsageSummaryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_unbilled_usage_summary", parameters);
        String[] returnValues = new String[23];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "currency_cd";
        returnValues[3] = "currency_name";
        returnValues[4] = "acct_mtd_threshold_amount";
        returnValues[5] = "acct_ptd_threshold_amount";
        returnValues[6] = "client_mtd_threshold_amount";
        returnValues[7] = "client_ptd_threshold_amount";
        returnValues[8] = "mtd_balance_amount";
        returnValues[9] = "ptd_balance_amount";
        returnValues[10] = "acct_mtd_delta_sign";
        returnValues[11] = "acct_mtd_delta_amount";
        returnValues[12] = "acct_ptd_delta_sign";
        returnValues[13] = "acct_ptd_delta_amount";
        returnValues[14] = "client_mtd_delta_sign";
        returnValues[15] = "client_mtd_delta_amount";
        returnValues[16] = "client_ptd_delta_sign";
        returnValues[17] = "client_ptd_delta_amount";
        returnValues[18] = "unapp_svc_credit_bal_amount";
        returnValues[19] = "unapp_svc_credit_delta_sign";
        returnValues[20] = "unapp_svc_credit_delta_amount";
        returnValues[21] = "unbilled_usage_recs";
        returnValues[22] = "unit_threshold_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getUsageHistory(Long client_no, String auth_key, Long acct_no, Long specified_usage_type_no, String date_range_start, String date_range_end, String specified_usage_type_code, com.aria.common.shared.UsageQualifier1Array usage_qualifier_1, com.aria.common.shared.UsageQualifier2Array usage_qualifier_2, com.aria.common.shared.UsageQualifier3Array usage_qualifier_3, com.aria.common.shared.UsageQualifier4Array usage_qualifier_4, Long limit, Long offset, Long transaction_id, Long invoice_no, Long invoice_line_item, String retrieve_excluded_usage){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"specified_usage_type_no", getValue("Long", specified_usage_type_no));
        addParameters(parameters,"date_range_start", getValue("String", date_range_start));
        addParameters(parameters,"date_range_end", getValue("String", date_range_end));
        addParameters(parameters,"specified_usage_type_code", getValue("String", specified_usage_type_code));
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_1);
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_2);
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_3);
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_4);
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"transaction_id", getValue("Long", transaction_id));
        addParameters(parameters,"invoice_no", getValue("Long", invoice_no));
        addParameters(parameters,"invoice_line_item", getValue("Long", invoice_line_item));
        addParameters(parameters,"retrieve_excluded_usage", getValue("String", retrieve_excluded_usage));
        
        return this.buildGetUsageHistoryHashMap(parameters);
    }

    public Map<String,Object> getUsageHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long specified_usage_type_no = (Long) map.get("specified_usage_type_no");
        String date_range_start = (String) map.get("date_range_start");
        String date_range_end = (String) map.get("date_range_end");
        String specified_usage_type_code = (String) map.get("specified_usage_type_code");
        com.aria.common.shared.UsageQualifier1Array usage_qualifier_1 = (com.aria.common.shared.UsageQualifier1Array) map.get("usage_qualifier_1");
        com.aria.common.shared.UsageQualifier2Array usage_qualifier_2 = (com.aria.common.shared.UsageQualifier2Array) map.get("usage_qualifier_2");
        com.aria.common.shared.UsageQualifier3Array usage_qualifier_3 = (com.aria.common.shared.UsageQualifier3Array) map.get("usage_qualifier_3");
        com.aria.common.shared.UsageQualifier4Array usage_qualifier_4 = (com.aria.common.shared.UsageQualifier4Array) map.get("usage_qualifier_4");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        Long transaction_id = (Long) map.get("transaction_id");
        Long invoice_no = (Long) map.get("invoice_no");
        Long invoice_line_item = (Long) map.get("invoice_line_item");
        String retrieve_excluded_usage = (String) map.get("retrieve_excluded_usage");
        
        return getUsageHistory(client_no, auth_key, acct_no, specified_usage_type_no, date_range_start, date_range_end, specified_usage_type_code, usage_qualifier_1, usage_qualifier_2, usage_qualifier_3, usage_qualifier_4, limit, offset, transaction_id, invoice_no, invoice_line_item, retrieve_excluded_usage);
    }
        private Map<String,Object> buildGetUsageHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_usage_history", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_history_records";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getUsageSummaryByType(Long client_no, String auth_key, Long acct_no, String user_id, Long usage_type_filter, String date_filter_start_date, String date_filter_start_time, String date_filter_end_date, String date_filter_end_time, Long billed_filter, Long billing_period_flag, com.aria.common.shared.UsageQualifier1Array usage_qualifier_1, com.aria.common.shared.UsageQualifier2Array usage_qualifier_2, com.aria.common.shared.UsageQualifier3Array usage_qualifier_3, com.aria.common.shared.UsageQualifier4Array usage_qualifier_4, String usage_type_cd_filter, String retrieve_excluded_usage){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"usage_type_filter", getValue("Long", usage_type_filter));
        addParameters(parameters,"date_filter_start_date", getValue("String", date_filter_start_date));
        addParameters(parameters,"date_filter_start_time", getValue("String", date_filter_start_time));
        addParameters(parameters,"date_filter_end_date", getValue("String", date_filter_end_date));
        addParameters(parameters,"date_filter_end_time", getValue("String", date_filter_end_time));
        addParameters(parameters,"billed_filter", getValue("Long", billed_filter));
        addParameters(parameters,"billing_period_flag", getValue("Long", billing_period_flag));
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_1);
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_2);
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_3);
        RestUtilities.addParameterValuesFromArray(parameters, usage_qualifier_4);
        addParameters(parameters,"usage_type_cd_filter", getValue("String", usage_type_cd_filter));
        addParameters(parameters,"retrieve_excluded_usage", getValue("String", retrieve_excluded_usage));
        
        return this.buildGetUsageSummaryByTypeHashMap(parameters);
    }

    public Map<String,Object> getUsageSummaryByType(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String user_id = (String) map.get("user_id");
        Long usage_type_filter = (Long) map.get("usage_type_filter");
        String date_filter_start_date = (String) map.get("date_filter_start_date");
        String date_filter_start_time = (String) map.get("date_filter_start_time");
        String date_filter_end_date = (String) map.get("date_filter_end_date");
        String date_filter_end_time = (String) map.get("date_filter_end_time");
        Long billed_filter = (Long) map.get("billed_filter");
        Long billing_period_flag = (Long) map.get("billing_period_flag");
        com.aria.common.shared.UsageQualifier1Array usage_qualifier_1 = (com.aria.common.shared.UsageQualifier1Array) map.get("usage_qualifier_1");
        com.aria.common.shared.UsageQualifier2Array usage_qualifier_2 = (com.aria.common.shared.UsageQualifier2Array) map.get("usage_qualifier_2");
        com.aria.common.shared.UsageQualifier3Array usage_qualifier_3 = (com.aria.common.shared.UsageQualifier3Array) map.get("usage_qualifier_3");
        com.aria.common.shared.UsageQualifier4Array usage_qualifier_4 = (com.aria.common.shared.UsageQualifier4Array) map.get("usage_qualifier_4");
        String usage_type_cd_filter = (String) map.get("usage_type_cd_filter");
        String retrieve_excluded_usage = (String) map.get("retrieve_excluded_usage");
        
        return getUsageSummaryByType(client_no, auth_key, acct_no, user_id, usage_type_filter, date_filter_start_date, date_filter_start_time, date_filter_end_date, date_filter_end_time, billed_filter, billing_period_flag, usage_qualifier_1, usage_qualifier_2, usage_qualifier_3, usage_qualifier_4, usage_type_cd_filter, retrieve_excluded_usage);
    }
        private Map<String,Object> buildGetUsageSummaryByTypeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_usage_summary_by_type", parameters);
        String[] returnValues = new String[7];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "start_date";
        returnValues[3] = "start_time";
        returnValues[4] = "end_date";
        returnValues[5] = "end_time";
        returnValues[6] = "usage_summary_records";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getUserIdFromAcctNo(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildGetUserIdFromAcctNoHashMap(parameters);
    }

    public Map<String,Object> getUserIdFromAcctNo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return getUserIdFromAcctNo(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildGetUserIdFromAcctNoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_user_id_from_acct_no", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "user_id";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getUseridHasOrderedSku(Long client_no, String auth_key, String user_id, String sku){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"sku", getValue("String", sku));
        
        return this.buildGetUseridHasOrderedSkuHashMap(parameters);
    }

    public Map<String,Object> getUseridHasOrderedSku(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        String sku = (String) map.get("sku");
        
        return getUseridHasOrderedSku(client_no, auth_key, user_id, sku);
    }
        private Map<String,Object> buildGetUseridHasOrderedSkuHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_userid_has_ordered_sku", parameters);
        String[] returnValues = new String[6];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "acct_no";
        returnValues[3] = "ordered_ind";
        returnValues[4] = "billed_ind";
        returnValues[5] = "paid_ind";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> modifyAcctMultiplanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, Long type_no, Long length_months, String start_date, String update_comments, Long modify_directive, com.aria.common.shared.PlansInputArray plans_input, String end_date, com.aria.common.shared.ClientPlanIdArray client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"contract_no", getValue("Long", contract_no));
        addParameters(parameters,"type_no", getValue("Long", type_no));
        addParameters(parameters,"length_months", getValue("Long", length_months));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"update_comments", getValue("String", update_comments));
        addParameters(parameters,"modify_directive", getValue("Long", modify_directive));
        RestUtilities.addParameterValuesFromArray(parameters, plans_input);
        addParameters(parameters,"end_date", getValue("String", end_date));
        RestUtilities.addParameterValuesFromArray(parameters, client_plan_id);
        
        return this.buildModifyAcctMultiplanContractHashMap(parameters);
    }

    public Map<String,Object> modifyAcctMultiplanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long contract_no = (Long) map.get("contract_no");
        Long type_no = (Long) map.get("type_no");
        Long length_months = (Long) map.get("length_months");
        String start_date = (String) map.get("start_date");
        String update_comments = (String) map.get("update_comments");
        Long modify_directive = (Long) map.get("modify_directive");
        com.aria.common.shared.PlansInputArray plans_input = (com.aria.common.shared.PlansInputArray) map.get("plans_input");
        String end_date = (String) map.get("end_date");
        com.aria.common.shared.ClientPlanIdArray client_plan_id = (com.aria.common.shared.ClientPlanIdArray) map.get("client_plan_id");
        
        return modifyAcctMultiplanContract(client_no, auth_key, acct_no, contract_no, type_no, length_months, start_date, update_comments, modify_directive, plans_input, end_date, client_plan_id);
    }
        private Map<String,Object> buildModifyAcctMultiplanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "modify_acct_multiplan_contract", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> modifyAcctPlanContract(Long client_no, String auth_key, Long acct_no, Long contract_no, Long type_no, Double alt_recur_fee, Long length_months, Double cancel_fee, String start_date, String update_comments, String end_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"contract_no", getValue("Long", contract_no));
        addParameters(parameters,"type_no", getValue("Long", type_no));
        addParameters(parameters,"alt_recur_fee", getValue("Double", alt_recur_fee));
        addParameters(parameters,"length_months", getValue("Long", length_months));
        addParameters(parameters,"cancel_fee", getValue("Double", cancel_fee));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"update_comments", getValue("String", update_comments));
        addParameters(parameters,"end_date", getValue("String", end_date));
        
        return this.buildModifyAcctPlanContractHashMap(parameters);
    }

    public Map<String,Object> modifyAcctPlanContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long contract_no = (Long) map.get("contract_no");
        Long type_no = (Long) map.get("type_no");
        Double alt_recur_fee = (Double) map.get("alt_recur_fee");
        Long length_months = (Long) map.get("length_months");
        Double cancel_fee = (Double) map.get("cancel_fee");
        String start_date = (String) map.get("start_date");
        String update_comments = (String) map.get("update_comments");
        String end_date = (String) map.get("end_date");
        
        return modifyAcctPlanContract(client_no, auth_key, acct_no, contract_no, type_no, alt_recur_fee, length_months, cancel_fee, start_date, update_comments, end_date);
    }
        private Map<String,Object> buildModifyAcctPlanContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "modify_acct_plan_contract", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> modifyAcctPlanUnitInstances(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.PlanUnitsArray plan_units, com.aria.common.shared.NewClientPlanUnitInstArray new_client_plan_unit_inst, String do_write){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        RestUtilities.addParameterValuesFromArray(parameters, plan_units);
        RestUtilities.addParameterValuesFromArray(parameters, new_client_plan_unit_inst);
        addParameters(parameters,"do_write", getValue("String", do_write));
        
        return this.buildModifyAcctPlanUnitInstancesHashMap(parameters);
    }

    public Map<String,Object> modifyAcctPlanUnitInstances(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        com.aria.common.shared.PlanUnitsArray plan_units = (com.aria.common.shared.PlanUnitsArray) map.get("plan_units");
        com.aria.common.shared.NewClientPlanUnitInstArray new_client_plan_unit_inst = (com.aria.common.shared.NewClientPlanUnitInstArray) map.get("new_client_plan_unit_inst");
        String do_write = (String) map.get("do_write");
        
        return modifyAcctPlanUnitInstances(client_no, auth_key, acct_no, plan_units, new_client_plan_unit_inst, do_write);
    }
        private Map<String,Object> buildModifyAcctPlanUnitInstancesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "modify_acct_plan_unit_instances", parameters);
        String[] returnValues = new String[19];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "invoice_no";
        returnValues[4] = "supp_plan_line_items";
        returnValues[5] = "total_charges_before_tax";
        returnValues[6] = "total_tax_charges";
        returnValues[7] = "total_charges_after_tax";
        returnValues[8] = "total_credit";
        returnValues[9] = "total_tax_credit";
        returnValues[10] = "total_credit_before_tax";
        returnValues[11] = "total";
        returnValues[12] = "proration_credit_result_amount";
        returnValues[13] = "proration_credit_amount";
        returnValues[14] = "proration_tax_amount";
        returnValues[15] = "expectd_activation_fee";
        returnValues[16] = "expectd_mthly_recurring_cost";
        returnValues[17] = "expectd_annu_recurring_cost";
        returnValues[18] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> modifyAcctSuppFields(Long client_no, String auth_key, Long acct_no, com.aria.common.shared.AcctSuppFieldsArray acct_supp_fields){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        RestUtilities.addParameterValuesFromArray(parameters, acct_supp_fields);
        
        return this.buildModifyAcctSuppFieldsHashMap(parameters);
    }

    public Map<String,Object> modifyAcctSuppFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        com.aria.common.shared.AcctSuppFieldsArray acct_supp_fields = (com.aria.common.shared.AcctSuppFieldsArray) map.get("acct_supp_fields");
        
        return modifyAcctSuppFields(client_no, auth_key, acct_no, acct_supp_fields);
    }
        private Map<String,Object> buildModifyAcctSuppFieldsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "modify_acct_supp_fields", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> modifyAcctUniversalContract(Long client_no, String auth_key, Long acct_no, Long contract_no, Long type_no, Long length_months, String start_date, String update_comments, String end_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"contract_no", getValue("Long", contract_no));
        addParameters(parameters,"type_no", getValue("Long", type_no));
        addParameters(parameters,"length_months", getValue("Long", length_months));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"update_comments", getValue("String", update_comments));
        addParameters(parameters,"end_date", getValue("String", end_date));
        
        return this.buildModifyAcctUniversalContractHashMap(parameters);
    }

    public Map<String,Object> modifyAcctUniversalContract(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long contract_no = (Long) map.get("contract_no");
        Long type_no = (Long) map.get("type_no");
        Long length_months = (Long) map.get("length_months");
        String start_date = (String) map.get("start_date");
        String update_comments = (String) map.get("update_comments");
        String end_date = (String) map.get("end_date");
        
        return modifyAcctUniversalContract(client_no, auth_key, acct_no, contract_no, type_no, length_months, start_date, update_comments, end_date);
    }
        private Map<String,Object> buildModifyAcctUniversalContractHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "modify_acct_universal_contract", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> modifySuppPlan(Long client_no, String auth_key, Long acct_no, Long supp_plan_no, Long alt_rate_schedule_no, Long num_plan_units, String coupon_code, Long assignment_directive, String comments, String do_write, String client_receipt_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String client_plan_id, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"supp_plan_no", getValue("Long", supp_plan_no));
        addParameters(parameters,"alt_rate_schedule_no", getValue("Long", alt_rate_schedule_no));
        addParameters(parameters,"num_plan_units", getValue("Long", num_plan_units));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_custom_rates);
        addParameters(parameters,"effective_date", getValue("String", effective_date));
        addParameters(parameters,"offset_interval", getValue("Long", offset_interval));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"client_alt_rate_schedule_id", getValue("String", client_alt_rate_schedule_id));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no);
        
        return this.buildModifySuppPlanHashMap(parameters);
    }

    public Map<String,Object> modifySuppPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long supp_plan_no = (Long) map.get("supp_plan_no");
        Long alt_rate_schedule_no = (Long) map.get("alt_rate_schedule_no");
        Long num_plan_units = (Long) map.get("num_plan_units");
        String coupon_code = (String) map.get("coupon_code");
        Long assignment_directive = (Long) map.get("assignment_directive");
        String comments = (String) map.get("comments");
        String do_write = (String) map.get("do_write");
        String client_receipt_id = (String) map.get("client_receipt_id");
        com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates = (com.aria.common.shared.NewAcctCustomRatesArray) map.get("new_acct_custom_rates");
        String effective_date = (String) map.get("effective_date");
        Long offset_interval = (Long) map.get("offset_interval");
        String client_plan_id = (String) map.get("client_plan_id");
        String client_alt_rate_schedule_id = (String) map.get("client_alt_rate_schedule_id");
        com.aria.common.shared.SurchargeNoArray surcharge_no = (com.aria.common.shared.SurchargeNoArray) map.get("surcharge_no");
        
        return modifySuppPlan(client_no, auth_key, acct_no, supp_plan_no, alt_rate_schedule_no, num_plan_units, coupon_code, assignment_directive, comments, do_write, client_receipt_id, new_acct_custom_rates, effective_date, offset_interval, client_plan_id, client_alt_rate_schedule_id, surcharge_no);
    }
        private Map<String,Object> buildModifySuppPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "modify_supp_plan", parameters);
        String[] returnValues = new String[19];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "invoice_no";
        returnValues[4] = "supp_plan_line_items";
        returnValues[5] = "total_charges_before_tax";
        returnValues[6] = "total_tax_charges";
        returnValues[7] = "total_charges_after_tax";
        returnValues[8] = "total_credit";
        returnValues[9] = "total_tax_credit";
        returnValues[10] = "total_credit_before_tax";
        returnValues[11] = "total";
        returnValues[12] = "proration_credit_result_amount";
        returnValues[13] = "proration_credit_amount";
        returnValues[14] = "proration_tax_amount";
        returnValues[15] = "expectd_activation_fee";
        returnValues[16] = "expectd_mthly_recurring_cost";
        returnValues[17] = "expectd_annu_recurring_cost";
        returnValues[18] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> recordStandingUsage(Long client_no, String auth_key, Long acct_no, Long usage_type, String usage_type_code, Double usage_units, String next_usage_date, String alt_desc, Long plan_no, String first_usage_date, String recurring_ind, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"usage_type", getValue("Long", usage_type));
        addParameters(parameters,"usage_type_code", getValue("String", usage_type_code));
        addParameters(parameters,"usage_units", getValue("Double", usage_units));
        addParameters(parameters,"next_usage_date", getValue("String", next_usage_date));
        addParameters(parameters,"alt_desc", getValue("String", alt_desc));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"first_usage_date", getValue("String", first_usage_date));
        addParameters(parameters,"recurring_ind", getValue("String", recurring_ind));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildRecordStandingUsageHashMap(parameters);
    }

    public Map<String,Object> recordStandingUsage(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long usage_type = (Long) map.get("usage_type");
        String usage_type_code = (String) map.get("usage_type_code");
        Double usage_units = (Double) map.get("usage_units");
        String next_usage_date = (String) map.get("next_usage_date");
        String alt_desc = (String) map.get("alt_desc");
        Long plan_no = (Long) map.get("plan_no");
        String first_usage_date = (String) map.get("first_usage_date");
        String recurring_ind = (String) map.get("recurring_ind");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return recordStandingUsage(client_no, auth_key, acct_no, usage_type, usage_type_code, usage_units, next_usage_date, alt_desc, plan_no, first_usage_date, recurring_ind, client_plan_id);
    }
        private Map<String,Object> buildRecordStandingUsageHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "record_standing_usage", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> removeAcctFromGroup(Long client_no, String auth_key, Long acct_no, Long group_no, String client_acct_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"group_no", getValue("Long", group_no));
        addParameters(parameters,"client_acct_group_id", getValue("String", client_acct_group_id));
        
        return this.buildRemoveAcctFromGroupHashMap(parameters);
    }

    public Map<String,Object> removeAcctFromGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long group_no = (Long) map.get("group_no");
        String client_acct_group_id = (String) map.get("client_acct_group_id");
        
        return removeAcctFromGroup(client_no, auth_key, acct_no, group_no, client_acct_group_id);
    }
        private Map<String,Object> buildRemoveAcctFromGroupHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "remove_acct_from_group", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> removeCustomAcctRates(Long client_no, String auth_key, Long acct_no, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildRemoveCustomAcctRatesHashMap(parameters);
    }

    public Map<String,Object> removeCustomAcctRates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return removeCustomAcctRates(client_no, auth_key, acct_no, plan_no, client_plan_id);
    }
        private Map<String,Object> buildRemoveCustomAcctRatesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "remove_custom_acct_rates", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> removePayMethod(Long client_no, String auth_key, Long acct_no, Long primary_or_bkup_pay_mthd_ind){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"primary_or_bkup_pay_mthd_ind", getValue("Long", primary_or_bkup_pay_mthd_ind));
        
        return this.buildRemovePayMethodHashMap(parameters);
    }

    public Map<String,Object> removePayMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long primary_or_bkup_pay_mthd_ind = (Long) map.get("primary_or_bkup_pay_mthd_ind");
        
        return removePayMethod(client_no, auth_key, acct_no, primary_or_bkup_pay_mthd_ind);
    }
        private Map<String,Object> buildRemovePayMethodHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "remove_pay_method", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> replaceSuppPlan(Long client_no, String auth_key, Long acct_no, Long existing_supp_plan_no, Long new_supp_plan_no, Long alt_rate_schedule_no, Long num_plan_units, String coupon_code, Long assignment_directive, String comments, String do_write, String client_receipt_id, Long offset_months, Long auto_offset_months_option, String alt_client_acct_group_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String invoice_unbilled_usage, Long sync_mstr_bill_dates_override, String client_existing_supp_plan_id, String client_new_supp_plan_id, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"existing_supp_plan_no", getValue("Long", existing_supp_plan_no));
        addParameters(parameters,"new_supp_plan_no", getValue("Long", new_supp_plan_no));
        addParameters(parameters,"alt_rate_schedule_no", getValue("Long", alt_rate_schedule_no));
        addParameters(parameters,"num_plan_units", getValue("Long", num_plan_units));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"offset_months", getValue("Long", offset_months));
        addParameters(parameters,"auto_offset_months_option", getValue("Long", auto_offset_months_option));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_custom_rates);
        addParameters(parameters,"effective_date", getValue("String", effective_date));
        addParameters(parameters,"offset_interval", getValue("Long", offset_interval));
        addParameters(parameters,"invoice_unbilled_usage", getValue("String", invoice_unbilled_usage));
        addParameters(parameters,"sync_mstr_bill_dates_override", getValue("Long", sync_mstr_bill_dates_override));
        addParameters(parameters,"client_existing_supp_plan_id", getValue("String", client_existing_supp_plan_id));
        addParameters(parameters,"client_new_supp_plan_id", getValue("String", client_new_supp_plan_id));
        addParameters(parameters,"client_alt_rate_schedule_id", getValue("String", client_alt_rate_schedule_id));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no);
        
        return this.buildReplaceSuppPlanHashMap(parameters);
    }

    public Map<String,Object> replaceSuppPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long existing_supp_plan_no = (Long) map.get("existing_supp_plan_no");
        Long new_supp_plan_no = (Long) map.get("new_supp_plan_no");
        Long alt_rate_schedule_no = (Long) map.get("alt_rate_schedule_no");
        Long num_plan_units = (Long) map.get("num_plan_units");
        String coupon_code = (String) map.get("coupon_code");
        Long assignment_directive = (Long) map.get("assignment_directive");
        String comments = (String) map.get("comments");
        String do_write = (String) map.get("do_write");
        String client_receipt_id = (String) map.get("client_receipt_id");
        Long offset_months = (Long) map.get("offset_months");
        Long auto_offset_months_option = (Long) map.get("auto_offset_months_option");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates = (com.aria.common.shared.NewAcctCustomRatesArray) map.get("new_acct_custom_rates");
        String effective_date = (String) map.get("effective_date");
        Long offset_interval = (Long) map.get("offset_interval");
        String invoice_unbilled_usage = (String) map.get("invoice_unbilled_usage");
        Long sync_mstr_bill_dates_override = (Long) map.get("sync_mstr_bill_dates_override");
        String client_existing_supp_plan_id = (String) map.get("client_existing_supp_plan_id");
        String client_new_supp_plan_id = (String) map.get("client_new_supp_plan_id");
        String client_alt_rate_schedule_id = (String) map.get("client_alt_rate_schedule_id");
        com.aria.common.shared.SurchargeNoArray surcharge_no = (com.aria.common.shared.SurchargeNoArray) map.get("surcharge_no");
        
        return replaceSuppPlan(client_no, auth_key, acct_no, existing_supp_plan_no, new_supp_plan_no, alt_rate_schedule_no, num_plan_units, coupon_code, assignment_directive, comments, do_write, client_receipt_id, offset_months, auto_offset_months_option, alt_client_acct_group_id, new_acct_custom_rates, effective_date, offset_interval, invoice_unbilled_usage, sync_mstr_bill_dates_override, client_existing_supp_plan_id, client_new_supp_plan_id, client_alt_rate_schedule_id, surcharge_no);
    }
        private Map<String,Object> buildReplaceSuppPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "replace_supp_plan", parameters);
        String[] returnValues = new String[19];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "invoice_no";
        returnValues[4] = "supp_plan_line_items";
        returnValues[5] = "total_charges_before_tax";
        returnValues[6] = "total_tax_charges";
        returnValues[7] = "total_charges_after_tax";
        returnValues[8] = "total_credit";
        returnValues[9] = "total_tax_credit";
        returnValues[10] = "total_credit_before_tax";
        returnValues[11] = "total";
        returnValues[12] = "proration_credit_result_amount";
        returnValues[13] = "proration_credit_amount";
        returnValues[14] = "proration_tax_amount";
        returnValues[15] = "expectd_activation_fee";
        returnValues[16] = "expectd_mthly_recurring_cost";
        returnValues[17] = "expectd_annu_recurring_cost";
        returnValues[18] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> resetUsgMtdBal(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildResetUsgMtdBalHashMap(parameters);
    }

    public Map<String,Object> resetUsgMtdBal(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return resetUsgMtdBal(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildResetUsgMtdBalHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "reset_usg_mtd_bal", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> resetUsgPtdBal(Long client_no, String auth_key, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildResetUsgPtdBalHashMap(parameters);
    }

    public Map<String,Object> resetUsgPtdBal(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        
        return resetUsgPtdBal(client_no, auth_key, acct_no);
    }
        private Map<String,Object> buildResetUsgPtdBalHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "reset_usg_ptd_bal", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> sendAcctEmail(Long client_no, String auth_key, String user_id, String template_class, Long template_no, String client_receipt_id, String client_template_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"template_class", getValue("String", template_class));
        addParameters(parameters,"template_no", getValue("Long", template_no));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"client_template_id", getValue("String", client_template_id));
        
        return this.buildSendAcctEmailHashMap(parameters);
    }

    public Map<String,Object> sendAcctEmail(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        String template_class = (String) map.get("template_class");
        Long template_no = (Long) map.get("template_no");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String client_template_id = (String) map.get("client_template_id");
        
        return sendAcctEmail(client_no, auth_key, user_id, template_class, template_no, client_receipt_id, client_template_id);
    }
        private Map<String,Object> buildSendAcctEmailHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "send_acct_email", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> sendAcctStatementEmail(Long client_no, String auth_key, Long acct_no, Long statement_no, String sequential_statement_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"statement_no", getValue("Long", statement_no));
        addParameters(parameters,"sequential_statement_no", getValue("String", sequential_statement_no));
        
        return this.buildSendAcctStatementEmailHashMap(parameters);
    }

    public Map<String,Object> sendAcctStatementEmail(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long statement_no = (Long) map.get("statement_no");
        String sequential_statement_no = (String) map.get("sequential_statement_no");
        
        return sendAcctStatementEmail(client_no, auth_key, acct_no, statement_no, sequential_statement_no);
    }
        private Map<String,Object> buildSendAcctStatementEmailHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "send_acct_statement_email", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> sendArcThresholdEmail(Long client_no, String auth_key, Long acct_no, Long resource_threshold_level, Long resource_balance, String resource_name, String resource_units_label){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"resource_threshold_level", getValue("Long", resource_threshold_level));
        addParameters(parameters,"resource_balance", getValue("Long", resource_balance));
        addParameters(parameters,"resource_name", getValue("String", resource_name));
        addParameters(parameters,"resource_units_label", getValue("String", resource_units_label));
        
        return this.buildSendArcThresholdEmailHashMap(parameters);
    }

    public Map<String,Object> sendArcThresholdEmail(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long resource_threshold_level = (Long) map.get("resource_threshold_level");
        Long resource_balance = (Long) map.get("resource_balance");
        String resource_name = (String) map.get("resource_name");
        String resource_units_label = (String) map.get("resource_units_label");
        
        return sendArcThresholdEmail(client_no, auth_key, acct_no, resource_threshold_level, resource_balance, resource_name, resource_units_label);
    }
        private Map<String,Object> buildSendArcThresholdEmailHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "send_arc_threshold_email", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setAcctNotifyOverride(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id, String template_class, Long override_template_no, Long behavioral_option, Long override_template_option){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"acct_user_id", getValue("String", acct_user_id));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"template_class", getValue("String", template_class));
        addParameters(parameters,"override_template_no", getValue("Long", override_template_no));
        addParameters(parameters,"behavioral_option", getValue("Long", behavioral_option));
        addParameters(parameters,"override_template_option", getValue("Long", override_template_option));
        
        return this.buildSetAcctNotifyOverrideHashMap(parameters);
    }

    public Map<String,Object> setAcctNotifyOverride(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String acct_user_id = (String) map.get("acct_user_id");
        String client_acct_id = (String) map.get("client_acct_id");
        String template_class = (String) map.get("template_class");
        Long override_template_no = (Long) map.get("override_template_no");
        Long behavioral_option = (Long) map.get("behavioral_option");
        Long override_template_option = (Long) map.get("override_template_option");
        
        return setAcctNotifyOverride(client_no, auth_key, acct_no, acct_user_id, client_acct_id, template_class, override_template_no, behavioral_option, override_template_option);
    }
        private Map<String,Object> buildSetAcctNotifyOverrideHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_acct_notify_override", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setAcctNotifyTmpltGrp(Long client_no, String auth_key, Long acct_no, String acct_user_id, String client_acct_id, String notification_template_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"acct_user_id", getValue("String", acct_user_id));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"notification_template_group_id", getValue("String", notification_template_group_id));
        
        return this.buildSetAcctNotifyTmpltGrpHashMap(parameters);
    }

    public Map<String,Object> setAcctNotifyTmpltGrp(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String acct_user_id = (String) map.get("acct_user_id");
        String client_acct_id = (String) map.get("client_acct_id");
        String notification_template_group_id = (String) map.get("notification_template_group_id");
        
        return setAcctNotifyTmpltGrp(client_no, auth_key, acct_no, acct_user_id, client_acct_id, notification_template_group_id);
    }
        private Map<String,Object> buildSetAcctNotifyTmpltGrpHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_acct_notify_tmplt_grp", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setAcctTaxExemptStatus(Long client_no, String auth_key, Long acct_no, Long exemption_level){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"exemption_level", getValue("Long", exemption_level));
        
        return this.buildSetAcctTaxExemptStatusHashMap(parameters);
    }

    public Map<String,Object> setAcctTaxExemptStatus(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long exemption_level = (Long) map.get("exemption_level");
        
        return setAcctTaxExemptStatus(client_no, auth_key, acct_no, exemption_level);
    }
        private Map<String,Object> buildSetAcctTaxExemptStatusHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_acct_tax_exempt_status", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setAcctUsgDailyThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        RestUtilities.addParameterValuesFromArray(parameters, usage_unit_thresholds);
        
        return this.buildSetAcctUsgDailyThresholdHashMap(parameters);
    }

    public Map<String,Object> setAcctUsgDailyThreshold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds = (com.aria.common.shared.UsageUnitThresholdsArray) map.get("usage_unit_thresholds");
        
        return setAcctUsgDailyThreshold(client_no, auth_key, acct_no, amount, usage_unit_thresholds);
    }
        private Map<String,Object> buildSetAcctUsgDailyThresholdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_acct_usg_daily_threshold", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setAcctUsgMtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        RestUtilities.addParameterValuesFromArray(parameters, usage_unit_thresholds);
        
        return this.buildSetAcctUsgMtdThresholdHashMap(parameters);
    }

    public Map<String,Object> setAcctUsgMtdThreshold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds = (com.aria.common.shared.UsageUnitThresholdsArray) map.get("usage_unit_thresholds");
        
        return setAcctUsgMtdThreshold(client_no, auth_key, acct_no, amount, usage_unit_thresholds);
    }
        private Map<String,Object> buildSetAcctUsgMtdThresholdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_acct_usg_mtd_threshold", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setAcctUsgPtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        RestUtilities.addParameterValuesFromArray(parameters, usage_unit_thresholds);
        
        return this.buildSetAcctUsgPtdThresholdHashMap(parameters);
    }

    public Map<String,Object> setAcctUsgPtdThreshold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds = (com.aria.common.shared.UsageUnitThresholdsArray) map.get("usage_unit_thresholds");
        
        return setAcctUsgPtdThreshold(client_no, auth_key, acct_no, amount, usage_unit_thresholds);
    }
        private Map<String,Object> buildSetAcctUsgPtdThresholdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_acct_usg_ptd_threshold", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setClientUsgDailyThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        RestUtilities.addParameterValuesFromArray(parameters, usage_unit_thresholds);
        
        return this.buildSetClientUsgDailyThresholdHashMap(parameters);
    }

    public Map<String,Object> setClientUsgDailyThreshold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds = (com.aria.common.shared.UsageUnitThresholdsArray) map.get("usage_unit_thresholds");
        
        return setClientUsgDailyThreshold(client_no, auth_key, acct_no, amount, usage_unit_thresholds);
    }
        private Map<String,Object> buildSetClientUsgDailyThresholdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_client_usg_daily_threshold", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setClientUsgMtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        RestUtilities.addParameterValuesFromArray(parameters, usage_unit_thresholds);
        
        return this.buildSetClientUsgMtdThresholdHashMap(parameters);
    }

    public Map<String,Object> setClientUsgMtdThreshold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds = (com.aria.common.shared.UsageUnitThresholdsArray) map.get("usage_unit_thresholds");
        
        return setClientUsgMtdThreshold(client_no, auth_key, acct_no, amount, usage_unit_thresholds);
    }
        private Map<String,Object> buildSetClientUsgMtdThresholdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_client_usg_mtd_threshold", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setClientUsgPtdThreshold(Long client_no, String auth_key, Long acct_no, Double amount, com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"amount", getValue("Double", amount));
        RestUtilities.addParameterValuesFromArray(parameters, usage_unit_thresholds);
        
        return this.buildSetClientUsgPtdThresholdHashMap(parameters);
    }

    public Map<String,Object> setClientUsgPtdThreshold(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Double amount = (Double) map.get("amount");
        com.aria.common.shared.UsageUnitThresholdsArray usage_unit_thresholds = (com.aria.common.shared.UsageUnitThresholdsArray) map.get("usage_unit_thresholds");
        
        return setClientUsgPtdThreshold(client_no, auth_key, acct_no, amount, usage_unit_thresholds);
    }
        private Map<String,Object> buildSetClientUsgPtdThresholdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_client_usg_ptd_threshold", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setPayMethodBankDraft(Long client_no, String auth_key, Long account_no, String bank_routing_num, String bank_acct_num, String do_collect, String change_status_after_coll, String reset_dates_after_status, String bank_acct_type, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"do_collect", getValue("String", do_collect));
        addParameters(parameters,"change_status_after_coll", getValue("String", change_status_after_coll));
        addParameters(parameters,"reset_dates_after_status", getValue("String", reset_dates_after_status));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildSetPayMethodBankDraftHashMap(parameters);
    }

    public Map<String,Object> setPayMethodBankDraft(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String do_collect = (String) map.get("do_collect");
        String change_status_after_coll = (String) map.get("change_status_after_coll");
        String reset_dates_after_status = (String) map.get("reset_dates_after_status");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return setPayMethodBankDraft(client_no, auth_key, account_no, bank_routing_num, bank_acct_num, do_collect, change_status_after_coll, reset_dates_after_status, bank_acct_type, client_receipt_id);
    }
        private Map<String,Object> buildSetPayMethodBankDraftHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_pay_method_bank_draft", parameters);
        String[] returnValues = new String[12];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "collection_error_code";
        returnValues[3] = "collection_error_msg";
        returnValues[4] = "proc_cvv_response";
        returnValues[5] = "proc_avs_response";
        returnValues[6] = "proc_cavv_response";
        returnValues[7] = "proc_status_code";
        returnValues[8] = "proc_status_text";
        returnValues[9] = "proc_payment_id";
        returnValues[10] = "proc_auth_code";
        returnValues[11] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setPayMethodCc(Long client_no, String auth_key, Long account_no, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String do_collect, String change_status_after_coll, String reset_dates_after_status, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"do_collect", getValue("String", do_collect));
        addParameters(parameters,"change_status_after_coll", getValue("String", change_status_after_coll));
        addParameters(parameters,"reset_dates_after_status", getValue("String", reset_dates_after_status));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildSetPayMethodCcHashMap(parameters);
    }

    public Map<String,Object> setPayMethodCc(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String do_collect = (String) map.get("do_collect");
        String change_status_after_coll = (String) map.get("change_status_after_coll");
        String reset_dates_after_status = (String) map.get("reset_dates_after_status");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return setPayMethodCc(client_no, auth_key, account_no, cc_number, cc_expire_mm, cc_expire_yyyy, do_collect, change_status_after_coll, reset_dates_after_status, client_receipt_id);
    }
        private Map<String,Object> buildSetPayMethodCcHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_pay_method_cc", parameters);
        String[] returnValues = new String[12];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "collection_error_code";
        returnValues[3] = "collection_error_msg";
        returnValues[4] = "proc_cvv_response";
        returnValues[5] = "proc_avs_response";
        returnValues[6] = "proc_cavv_response";
        returnValues[7] = "proc_status_code";
        returnValues[8] = "proc_status_text";
        returnValues[9] = "proc_payment_id";
        returnValues[10] = "proc_auth_code";
        returnValues[11] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setPayMethodNetTerms(Long client_no, String auth_key, Long account_no, Long pay_method){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"pay_method", getValue("Long", pay_method));
        
        return this.buildSetPayMethodNetTermsHashMap(parameters);
    }

    public Map<String,Object> setPayMethodNetTerms(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long pay_method = (Long) map.get("pay_method");
        
        return setPayMethodNetTerms(client_no, auth_key, account_no, pay_method);
    }
        private Map<String,Object> buildSetPayMethodNetTermsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_pay_method_net_terms", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setPaymentResponsibility(Long client_no, String auth_key, Long account_no, Long resp_level_cd, Long senior_account_no, String senior_acct_user_id, String client_senior_acct_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"resp_level_cd", getValue("Long", resp_level_cd));
        addParameters(parameters,"senior_account_no", getValue("Long", senior_account_no));
        addParameters(parameters,"senior_acct_user_id", getValue("String", senior_acct_user_id));
        addParameters(parameters,"client_senior_acct_id", getValue("String", client_senior_acct_id));
        
        return this.buildSetPaymentResponsibilityHashMap(parameters);
    }

    public Map<String,Object> setPaymentResponsibility(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long resp_level_cd = (Long) map.get("resp_level_cd");
        Long senior_account_no = (Long) map.get("senior_account_no");
        String senior_acct_user_id = (String) map.get("senior_acct_user_id");
        String client_senior_acct_id = (String) map.get("client_senior_acct_id");
        
        return setPaymentResponsibility(client_no, auth_key, account_no, resp_level_cd, senior_account_no, senior_acct_user_id, client_senior_acct_id);
    }
        private Map<String,Object> buildSetPaymentResponsibilityHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_payment_responsibility", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setServicePlanImmediately(Long client_no, String auth_key, Long account_no, Long plan_no, String client_receipt_id, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildSetServicePlanImmediatelyHashMap(parameters);
    }

    public Map<String,Object> setServicePlanImmediately(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long plan_no = (Long) map.get("plan_no");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return setServicePlanImmediately(client_no, auth_key, account_no, plan_no, client_receipt_id, client_plan_id);
    }
        private Map<String,Object> buildSetServicePlanImmediatelyHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_service_plan_immediately", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> toggleTestAccount(Long client_no, String auth_key, Long account_no, Long test_acct_ind){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"test_acct_ind", getValue("Long", test_acct_ind));
        
        return this.buildToggleTestAccountHashMap(parameters);
    }

    public Map<String,Object> toggleTestAccount(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long test_acct_ind = (Long) map.get("test_acct_ind");
        
        return toggleTestAccount(client_no, auth_key, account_no, test_acct_ind);
    }
        private Map<String,Object> buildToggleTestAccountHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "toggle_test_account", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctBillingContact(Long client_no, String auth_key, Long account_no, String first_name, String last_name, String middle_initial, String company_name, String address1, String address2, String city, String locality, String state, String country, String zip, String intl_phone, String email, String do_collect, String change_status_after_coll, String reset_dates_after_status, String address3, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"middle_initial", getValue("String", middle_initial));
        addParameters(parameters,"company_name", getValue("String", company_name));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"state", getValue("String", state));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"zip", getValue("String", zip));
        addParameters(parameters,"intl_phone", getValue("String", intl_phone));
        addParameters(parameters,"email", getValue("String", email));
        addParameters(parameters,"do_collect", getValue("String", do_collect));
        addParameters(parameters,"change_status_after_coll", getValue("String", change_status_after_coll));
        addParameters(parameters,"reset_dates_after_status", getValue("String", reset_dates_after_status));
        addParameters(parameters,"address3", getValue("String", address3));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildUpdateAcctBillingContactHashMap(parameters);
    }

    public Map<String,Object> updateAcctBillingContact(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String first_name = (String) map.get("first_name");
        String last_name = (String) map.get("last_name");
        String middle_initial = (String) map.get("middle_initial");
        String company_name = (String) map.get("company_name");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String locality = (String) map.get("locality");
        String state = (String) map.get("state");
        String country = (String) map.get("country");
        String zip = (String) map.get("zip");
        String intl_phone = (String) map.get("intl_phone");
        String email = (String) map.get("email");
        String do_collect = (String) map.get("do_collect");
        String change_status_after_coll = (String) map.get("change_status_after_coll");
        String reset_dates_after_status = (String) map.get("reset_dates_after_status");
        String address3 = (String) map.get("address3");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return updateAcctBillingContact(client_no, auth_key, account_no, first_name, last_name, middle_initial, company_name, address1, address2, city, locality, state, country, zip, intl_phone, email, do_collect, change_status_after_coll, reset_dates_after_status, address3, client_receipt_id);
    }
        private Map<String,Object> buildUpdateAcctBillingContactHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_billing_contact", parameters);
        String[] returnValues = new String[12];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "collection_error_code";
        returnValues[3] = "collection_error_msg";
        returnValues[4] = "proc_cvv_response";
        returnValues[5] = "proc_avs_response";
        returnValues[6] = "proc_cavv_response";
        returnValues[7] = "proc_status_code";
        returnValues[8] = "proc_status_text";
        returnValues[9] = "proc_payment_id";
        returnValues[10] = "proc_auth_code";
        returnValues[11] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctComplete(Long client_no, String auth_key, Long acct_no, String first_name, String last_name, String middle_initial, String company_name, String address1, String address2, String city, String locality, String state_prov, String country, String postal_cd, String phone, String phone_ext, String cell_phone, String work_phone, String work_phone_ext, String email, String birthdate, String bill_first_name, String bill_last_name, String bill_middle_initial, String bill_company_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_country, String bill_postal_cd, String bill_phone, String bill_phone_ext, String bill_cell_phone, String bill_work_phone, String bill_work_phone_ext, String bill_email, Long pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, Long master_plan_no, Long master_plan_alt_rate_sched_no, Long master_plan_units, Long master_plan_assign_directive, com.aria.common.shared.UpdateAcctSuppFieldArray update_acct_supp_field, com.aria.common.shared.UpdateAcctFuncGroupArray update_acct_func_group, com.aria.common.shared.UpdateAcctCollGroupArray update_acct_coll_group, Long status_cd, Long notify_method, String password, String secret_question, String secret_question_answer, String pin, Long test_acct_ind, Long resp_level_cd, Long senior_acct_no, String senior_acct_user_id, String client_senior_acct_id, String client_acct_id, String do_collect, String change_status_after_coll, String reset_dates_after_status, String client_receipt_id, String alt_do_dunning, String force_currency_change, String cvv, String taxpayer_id, String bill_agreement_id, String auto_cancel_supp_plans, Long offset_months, String alt_proration_start_date, Long alt_msg_template_no, Long seq_func_group_no, String bank_acct_type, String address3, String bill_address3, com.aria.common.shared.UsageAccumulationConfigArray usage_accumulation_config, com.aria.common.shared.EnableUsagePoolingPlanNoArray enable_usage_pooling_plan_no, com.aria.common.shared.DisableUsagePoolingPlanNoArray disable_usage_pooling_plan_no, String alt_client_acct_group_id, String track_data1, String track_data2, Long offset_interval, Long tax_exemption_level, Long cn_alt_msg_template_no, String promo_cd, String invoice_unbilled_usage, String coupon_code, String userid, String invoice_approval_required, String client_master_plan_id, String client_mp_alt_rate_sched_id, String client_alt_msg_template_id, String client_cn_alt_msg_template_id, com.aria.common.shared.UpdateSurchargeArray update_surcharge, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, String bkup_bill_first_name, String bkup_bill_mi, String bkup_bill_last_name, String bkup_bill_company_name, String bkup_bill_address1, String bkup_bill_address2, String bkup_bill_address3, String bkup_bill_city, String bkup_bill_locality, String bkup_bill_state_prov, String bkup_bill_country, String bkup_bill_postal_cd, String bkup_bill_phone, String bkup_bill_phone_ext, String bkup_bill_cell_phone, String bkup_bill_work_phone, String bkup_bill_work_phone_ext, String bkup_bill_email, Long bkup_pay_method, String bkup_cc_number, Long bkup_cc_expire_mm, Long bkup_cc_expire_yyyy, String bkup_bank_acct_no, String bkup_bank_routing_no, String bkup_bank_acct_type, String bkup_bill_agreement_id, String bkup_cvv, String seq_func_group_id, Long revrec_profile_id, String revrec_client_defined_id, String stmnt_email_list_cc, String stmnt_email_list_bcc, Long invoice_posting_method_cd, String acct_start_date, Long min_statement_threshold, Long max_statements_to_defer, Long defer_full_statements_only, Long cc_id, Long bkup_cc_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"middle_initial", getValue("String", middle_initial));
        addParameters(parameters,"company_name", getValue("String", company_name));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"state_prov", getValue("String", state_prov));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"postal_cd", getValue("String", postal_cd));
        addParameters(parameters,"phone", getValue("String", phone));
        addParameters(parameters,"phone_ext", getValue("String", phone_ext));
        addParameters(parameters,"cell_phone", getValue("String", cell_phone));
        addParameters(parameters,"work_phone", getValue("String", work_phone));
        addParameters(parameters,"work_phone_ext", getValue("String", work_phone_ext));
        addParameters(parameters,"email", getValue("String", email));
        addParameters(parameters,"birthdate", getValue("String", birthdate));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_postal_cd", getValue("String", bill_postal_cd));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_ext", getValue("String", bill_phone_ext));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_ext", getValue("String", bill_work_phone_ext));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"pay_method", getValue("Long", pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"master_plan_no", getValue("Long", master_plan_no));
        addParameters(parameters,"master_plan_alt_rate_sched_no", getValue("Long", master_plan_alt_rate_sched_no));
        addParameters(parameters,"master_plan_units", getValue("Long", master_plan_units));
        addParameters(parameters,"master_plan_assign_directive", getValue("Long", master_plan_assign_directive));
        RestUtilities.addParameterValuesFromArray(parameters, update_acct_supp_field);
        RestUtilities.addParameterValuesFromArray(parameters, update_acct_func_group);
        RestUtilities.addParameterValuesFromArray(parameters, update_acct_coll_group);
        addParameters(parameters,"status_cd", getValue("Long", status_cd));
        addParameters(parameters,"notify_method", getValue("Long", notify_method));
        addParameters(parameters,"password", getValue("String", password));
        addParameters(parameters,"secret_question", getValue("String", secret_question));
        addParameters(parameters,"secret_question_answer", getValue("String", secret_question_answer));
        addParameters(parameters,"pin", getValue("String", pin));
        addParameters(parameters,"test_acct_ind", getValue("Long", test_acct_ind));
        addParameters(parameters,"resp_level_cd", getValue("Long", resp_level_cd));
        addParameters(parameters,"senior_acct_no", getValue("Long", senior_acct_no));
        addParameters(parameters,"senior_acct_user_id", getValue("String", senior_acct_user_id));
        addParameters(parameters,"client_senior_acct_id", getValue("String", client_senior_acct_id));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"do_collect", getValue("String", do_collect));
        addParameters(parameters,"change_status_after_coll", getValue("String", change_status_after_coll));
        addParameters(parameters,"reset_dates_after_status", getValue("String", reset_dates_after_status));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"alt_do_dunning", getValue("String", alt_do_dunning));
        addParameters(parameters,"force_currency_change", getValue("String", force_currency_change));
        addParameters(parameters,"cvv", getValue("String", cvv));
        addParameters(parameters,"taxpayer_id", getValue("String", taxpayer_id));
        addParameters(parameters,"bill_agreement_id", getValue("String", bill_agreement_id));
        addParameters(parameters,"auto_cancel_supp_plans", getValue("String", auto_cancel_supp_plans));
        addParameters(parameters,"offset_months", getValue("Long", offset_months));
        addParameters(parameters,"alt_proration_start_date", getValue("String", alt_proration_start_date));
        addParameters(parameters,"alt_msg_template_no", getValue("Long", alt_msg_template_no));
        addParameters(parameters,"seq_func_group_no", getValue("Long", seq_func_group_no));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"address3", getValue("String", address3));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        RestUtilities.addParameterValuesFromArray(parameters, usage_accumulation_config);
        RestUtilities.addParameterValuesFromArray(parameters, enable_usage_pooling_plan_no);
        RestUtilities.addParameterValuesFromArray(parameters, disable_usage_pooling_plan_no);
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"offset_interval", getValue("Long", offset_interval));
        addParameters(parameters,"tax_exemption_level", getValue("Long", tax_exemption_level));
        addParameters(parameters,"cn_alt_msg_template_no", getValue("Long", cn_alt_msg_template_no));
        addParameters(parameters,"promo_cd", getValue("String", promo_cd));
        addParameters(parameters,"invoice_unbilled_usage", getValue("String", invoice_unbilled_usage));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        addParameters(parameters,"userid", getValue("String", userid));
        addParameters(parameters,"invoice_approval_required", getValue("String", invoice_approval_required));
        addParameters(parameters,"client_master_plan_id", getValue("String", client_master_plan_id));
        addParameters(parameters,"client_mp_alt_rate_sched_id", getValue("String", client_mp_alt_rate_sched_id));
        addParameters(parameters,"client_alt_msg_template_id", getValue("String", client_alt_msg_template_id));
        addParameters(parameters,"client_cn_alt_msg_template_id", getValue("String", client_cn_alt_msg_template_id));
        RestUtilities.addParameterValuesFromArray(parameters, update_surcharge);
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"bkup_bill_first_name", getValue("String", bkup_bill_first_name));
        addParameters(parameters,"bkup_bill_mi", getValue("String", bkup_bill_mi));
        addParameters(parameters,"bkup_bill_last_name", getValue("String", bkup_bill_last_name));
        addParameters(parameters,"bkup_bill_company_name", getValue("String", bkup_bill_company_name));
        addParameters(parameters,"bkup_bill_address1", getValue("String", bkup_bill_address1));
        addParameters(parameters,"bkup_bill_address2", getValue("String", bkup_bill_address2));
        addParameters(parameters,"bkup_bill_address3", getValue("String", bkup_bill_address3));
        addParameters(parameters,"bkup_bill_city", getValue("String", bkup_bill_city));
        addParameters(parameters,"bkup_bill_locality", getValue("String", bkup_bill_locality));
        addParameters(parameters,"bkup_bill_state_prov", getValue("String", bkup_bill_state_prov));
        addParameters(parameters,"bkup_bill_country", getValue("String", bkup_bill_country));
        addParameters(parameters,"bkup_bill_postal_cd", getValue("String", bkup_bill_postal_cd));
        addParameters(parameters,"bkup_bill_phone", getValue("String", bkup_bill_phone));
        addParameters(parameters,"bkup_bill_phone_ext", getValue("String", bkup_bill_phone_ext));
        addParameters(parameters,"bkup_bill_cell_phone", getValue("String", bkup_bill_cell_phone));
        addParameters(parameters,"bkup_bill_work_phone", getValue("String", bkup_bill_work_phone));
        addParameters(parameters,"bkup_bill_work_phone_ext", getValue("String", bkup_bill_work_phone_ext));
        addParameters(parameters,"bkup_bill_email", getValue("String", bkup_bill_email));
        addParameters(parameters,"bkup_pay_method", getValue("Long", bkup_pay_method));
        addParameters(parameters,"bkup_cc_number", getValue("String", bkup_cc_number));
        addParameters(parameters,"bkup_cc_expire_mm", getValue("Long", bkup_cc_expire_mm));
        addParameters(parameters,"bkup_cc_expire_yyyy", getValue("Long", bkup_cc_expire_yyyy));
        addParameters(parameters,"bkup_bank_acct_no", getValue("String", bkup_bank_acct_no));
        addParameters(parameters,"bkup_bank_routing_no", getValue("String", bkup_bank_routing_no));
        addParameters(parameters,"bkup_bank_acct_type", getValue("String", bkup_bank_acct_type));
        addParameters(parameters,"bkup_bill_agreement_id", getValue("String", bkup_bill_agreement_id));
        addParameters(parameters,"bkup_cvv", getValue("String", bkup_cvv));
        addParameters(parameters,"seq_func_group_id", getValue("String", seq_func_group_id));
        addParameters(parameters,"revrec_profile_id", getValue("Long", revrec_profile_id));
        addParameters(parameters,"revrec_client_defined_id", getValue("String", revrec_client_defined_id));
        addParameters(parameters,"stmnt_email_list_cc", getValue("String", stmnt_email_list_cc));
        addParameters(parameters,"stmnt_email_list_bcc", getValue("String", stmnt_email_list_bcc));
        addParameters(parameters,"invoice_posting_method_cd", getValue("Long", invoice_posting_method_cd));
        addParameters(parameters,"acct_start_date", getValue("String", acct_start_date));
        addParameters(parameters,"min_statement_threshold", getValue("Long", min_statement_threshold));
        addParameters(parameters,"max_statements_to_defer", getValue("Long", max_statements_to_defer));
        addParameters(parameters,"defer_full_statements_only", getValue("Long", defer_full_statements_only));
        addParameters(parameters,"cc_id", getValue("Long", cc_id));
        addParameters(parameters,"bkup_cc_id", getValue("Long", bkup_cc_id));
        
        return this.buildUpdateAcctCompleteHashMap(parameters);
    }

    public Map<String,Object> updateAcctComplete(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String first_name = (String) map.get("first_name");
        String last_name = (String) map.get("last_name");
        String middle_initial = (String) map.get("middle_initial");
        String company_name = (String) map.get("company_name");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String locality = (String) map.get("locality");
        String state_prov = (String) map.get("state_prov");
        String country = (String) map.get("country");
        String postal_cd = (String) map.get("postal_cd");
        String phone = (String) map.get("phone");
        String phone_ext = (String) map.get("phone_ext");
        String cell_phone = (String) map.get("cell_phone");
        String work_phone = (String) map.get("work_phone");
        String work_phone_ext = (String) map.get("work_phone_ext");
        String email = (String) map.get("email");
        String birthdate = (String) map.get("birthdate");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_country = (String) map.get("bill_country");
        String bill_postal_cd = (String) map.get("bill_postal_cd");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_ext = (String) map.get("bill_phone_ext");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_ext = (String) map.get("bill_work_phone_ext");
        String bill_email = (String) map.get("bill_email");
        Long pay_method = (Long) map.get("pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        Long master_plan_no = (Long) map.get("master_plan_no");
        Long master_plan_alt_rate_sched_no = (Long) map.get("master_plan_alt_rate_sched_no");
        Long master_plan_units = (Long) map.get("master_plan_units");
        Long master_plan_assign_directive = (Long) map.get("master_plan_assign_directive");
        com.aria.common.shared.UpdateAcctSuppFieldArray update_acct_supp_field = (com.aria.common.shared.UpdateAcctSuppFieldArray) map.get("update_acct_supp_field");
        com.aria.common.shared.UpdateAcctFuncGroupArray update_acct_func_group = (com.aria.common.shared.UpdateAcctFuncGroupArray) map.get("update_acct_func_group");
        com.aria.common.shared.UpdateAcctCollGroupArray update_acct_coll_group = (com.aria.common.shared.UpdateAcctCollGroupArray) map.get("update_acct_coll_group");
        Long status_cd = (Long) map.get("status_cd");
        Long notify_method = (Long) map.get("notify_method");
        String password = (String) map.get("password");
        String secret_question = (String) map.get("secret_question");
        String secret_question_answer = (String) map.get("secret_question_answer");
        String pin = (String) map.get("pin");
        Long test_acct_ind = (Long) map.get("test_acct_ind");
        Long resp_level_cd = (Long) map.get("resp_level_cd");
        Long senior_acct_no = (Long) map.get("senior_acct_no");
        String senior_acct_user_id = (String) map.get("senior_acct_user_id");
        String client_senior_acct_id = (String) map.get("client_senior_acct_id");
        String client_acct_id = (String) map.get("client_acct_id");
        String do_collect = (String) map.get("do_collect");
        String change_status_after_coll = (String) map.get("change_status_after_coll");
        String reset_dates_after_status = (String) map.get("reset_dates_after_status");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String alt_do_dunning = (String) map.get("alt_do_dunning");
        String force_currency_change = (String) map.get("force_currency_change");
        String cvv = (String) map.get("cvv");
        String taxpayer_id = (String) map.get("taxpayer_id");
        String bill_agreement_id = (String) map.get("bill_agreement_id");
        String auto_cancel_supp_plans = (String) map.get("auto_cancel_supp_plans");
        Long offset_months = (Long) map.get("offset_months");
        String alt_proration_start_date = (String) map.get("alt_proration_start_date");
        Long alt_msg_template_no = (Long) map.get("alt_msg_template_no");
        Long seq_func_group_no = (Long) map.get("seq_func_group_no");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String address3 = (String) map.get("address3");
        String bill_address3 = (String) map.get("bill_address3");
        com.aria.common.shared.UsageAccumulationConfigArray usage_accumulation_config = (com.aria.common.shared.UsageAccumulationConfigArray) map.get("usage_accumulation_config");
        com.aria.common.shared.EnableUsagePoolingPlanNoArray enable_usage_pooling_plan_no = (com.aria.common.shared.EnableUsagePoolingPlanNoArray) map.get("enable_usage_pooling_plan_no");
        com.aria.common.shared.DisableUsagePoolingPlanNoArray disable_usage_pooling_plan_no = (com.aria.common.shared.DisableUsagePoolingPlanNoArray) map.get("disable_usage_pooling_plan_no");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        Long offset_interval = (Long) map.get("offset_interval");
        Long tax_exemption_level = (Long) map.get("tax_exemption_level");
        Long cn_alt_msg_template_no = (Long) map.get("cn_alt_msg_template_no");
        String promo_cd = (String) map.get("promo_cd");
        String invoice_unbilled_usage = (String) map.get("invoice_unbilled_usage");
        String coupon_code = (String) map.get("coupon_code");
        String userid = (String) map.get("userid");
        String invoice_approval_required = (String) map.get("invoice_approval_required");
        String client_master_plan_id = (String) map.get("client_master_plan_id");
        String client_mp_alt_rate_sched_id = (String) map.get("client_mp_alt_rate_sched_id");
        String client_alt_msg_template_id = (String) map.get("client_alt_msg_template_id");
        String client_cn_alt_msg_template_id = (String) map.get("client_cn_alt_msg_template_id");
        com.aria.common.shared.UpdateSurchargeArray update_surcharge = (com.aria.common.shared.UpdateSurchargeArray) map.get("update_surcharge");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        String bkup_bill_first_name = (String) map.get("bkup_bill_first_name");
        String bkup_bill_mi = (String) map.get("bkup_bill_mi");
        String bkup_bill_last_name = (String) map.get("bkup_bill_last_name");
        String bkup_bill_company_name = (String) map.get("bkup_bill_company_name");
        String bkup_bill_address1 = (String) map.get("bkup_bill_address1");
        String bkup_bill_address2 = (String) map.get("bkup_bill_address2");
        String bkup_bill_address3 = (String) map.get("bkup_bill_address3");
        String bkup_bill_city = (String) map.get("bkup_bill_city");
        String bkup_bill_locality = (String) map.get("bkup_bill_locality");
        String bkup_bill_state_prov = (String) map.get("bkup_bill_state_prov");
        String bkup_bill_country = (String) map.get("bkup_bill_country");
        String bkup_bill_postal_cd = (String) map.get("bkup_bill_postal_cd");
        String bkup_bill_phone = (String) map.get("bkup_bill_phone");
        String bkup_bill_phone_ext = (String) map.get("bkup_bill_phone_ext");
        String bkup_bill_cell_phone = (String) map.get("bkup_bill_cell_phone");
        String bkup_bill_work_phone = (String) map.get("bkup_bill_work_phone");
        String bkup_bill_work_phone_ext = (String) map.get("bkup_bill_work_phone_ext");
        String bkup_bill_email = (String) map.get("bkup_bill_email");
        Long bkup_pay_method = (Long) map.get("bkup_pay_method");
        String bkup_cc_number = (String) map.get("bkup_cc_number");
        Long bkup_cc_expire_mm = (Long) map.get("bkup_cc_expire_mm");
        Long bkup_cc_expire_yyyy = (Long) map.get("bkup_cc_expire_yyyy");
        String bkup_bank_acct_no = (String) map.get("bkup_bank_acct_no");
        String bkup_bank_routing_no = (String) map.get("bkup_bank_routing_no");
        String bkup_bank_acct_type = (String) map.get("bkup_bank_acct_type");
        String bkup_bill_agreement_id = (String) map.get("bkup_bill_agreement_id");
        String bkup_cvv = (String) map.get("bkup_cvv");
        String seq_func_group_id = (String) map.get("seq_func_group_id");
        Long revrec_profile_id = (Long) map.get("revrec_profile_id");
        String revrec_client_defined_id = (String) map.get("revrec_client_defined_id");
        String stmnt_email_list_cc = (String) map.get("stmnt_email_list_cc");
        String stmnt_email_list_bcc = (String) map.get("stmnt_email_list_bcc");
        Long invoice_posting_method_cd = (Long) map.get("invoice_posting_method_cd");
        String acct_start_date = (String) map.get("acct_start_date");
        Long min_statement_threshold = (Long) map.get("min_statement_threshold");
        Long max_statements_to_defer = (Long) map.get("max_statements_to_defer");
        Long defer_full_statements_only = (Long) map.get("defer_full_statements_only");
        Long cc_id = (Long) map.get("cc_id");
        Long bkup_cc_id = (Long) map.get("bkup_cc_id");
        
        return updateAcctComplete(client_no, auth_key, acct_no, first_name, last_name, middle_initial, company_name, address1, address2, city, locality, state_prov, country, postal_cd, phone, phone_ext, cell_phone, work_phone, work_phone_ext, email, birthdate, bill_first_name, bill_last_name, bill_middle_initial, bill_company_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_country, bill_postal_cd, bill_phone, bill_phone_ext, bill_cell_phone, bill_work_phone, bill_work_phone_ext, bill_email, pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, master_plan_no, master_plan_alt_rate_sched_no, master_plan_units, master_plan_assign_directive, update_acct_supp_field, update_acct_func_group, update_acct_coll_group, status_cd, notify_method, password, secret_question, secret_question_answer, pin, test_acct_ind, resp_level_cd, senior_acct_no, senior_acct_user_id, client_senior_acct_id, client_acct_id, do_collect, change_status_after_coll, reset_dates_after_status, client_receipt_id, alt_do_dunning, force_currency_change, cvv, taxpayer_id, bill_agreement_id, auto_cancel_supp_plans, offset_months, alt_proration_start_date, alt_msg_template_no, seq_func_group_no, bank_acct_type, address3, bill_address3, usage_accumulation_config, enable_usage_pooling_plan_no, disable_usage_pooling_plan_no, alt_client_acct_group_id, track_data1, track_data2, offset_interval, tax_exemption_level, cn_alt_msg_template_no, promo_cd, invoice_unbilled_usage, coupon_code, userid, invoice_approval_required, client_master_plan_id, client_mp_alt_rate_sched_id, client_alt_msg_template_id, client_cn_alt_msg_template_id, update_surcharge, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, bkup_bill_first_name, bkup_bill_mi, bkup_bill_last_name, bkup_bill_company_name, bkup_bill_address1, bkup_bill_address2, bkup_bill_address3, bkup_bill_city, bkup_bill_locality, bkup_bill_state_prov, bkup_bill_country, bkup_bill_postal_cd, bkup_bill_phone, bkup_bill_phone_ext, bkup_bill_cell_phone, bkup_bill_work_phone, bkup_bill_work_phone_ext, bkup_bill_email, bkup_pay_method, bkup_cc_number, bkup_cc_expire_mm, bkup_cc_expire_yyyy, bkup_bank_acct_no, bkup_bank_routing_no, bkup_bank_acct_type, bkup_bill_agreement_id, bkup_cvv, seq_func_group_id, revrec_profile_id, revrec_client_defined_id, stmnt_email_list_cc, stmnt_email_list_bcc, invoice_posting_method_cd, acct_start_date, min_statement_threshold, max_statements_to_defer, defer_full_statements_only, cc_id, bkup_cc_id);
    }
        private Map<String,Object> buildUpdateAcctCompleteHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_complete", parameters);
        String[] returnValues = new String[24];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "collection_error_code";
        returnValues[4] = "collection_error_msg";
        returnValues[5] = "parent_child_sync_error_code";
        returnValues[6] = "parent_child_sync_error_msg";
        returnValues[7] = "master_plan_error_code";
        returnValues[8] = "master_plan_error_msg";
        returnValues[9] = "master_plan_coll_error_code";
        returnValues[10] = "master_plan_coll_error_msg";
        returnValues[11] = "master_plan_stmt_error_code";
        returnValues[12] = "master_plan_stmt_error_msg";
        returnValues[13] = "proc_cvv_response";
        returnValues[14] = "proc_avs_response";
        returnValues[15] = "proc_cavv_response";
        returnValues[16] = "proc_status_code";
        returnValues[17] = "proc_status_text";
        returnValues[18] = "proc_payment_id";
        returnValues[19] = "proc_auth_code";
        returnValues[20] = "proc_merch_comments";
        returnValues[21] = "invoice_no";
        returnValues[22] = "cancelled_supp_plans";
        returnValues[23] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctContact(Long client_no, String auth_key, Long account_no, String first_name, String last_name, String mi, String company_name, String address1, String address2, String city, String locality, String state_prov, String country, String postal_code, String intl_phone, String alt_email, String birthdate, String address3){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"mi", getValue("String", mi));
        addParameters(parameters,"company_name", getValue("String", company_name));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"state_prov", getValue("String", state_prov));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"postal_code", getValue("String", postal_code));
        addParameters(parameters,"intl_phone", getValue("String", intl_phone));
        addParameters(parameters,"alt_email", getValue("String", alt_email));
        addParameters(parameters,"birthdate", getValue("String", birthdate));
        addParameters(parameters,"address3", getValue("String", address3));
        
        return this.buildUpdateAcctContactHashMap(parameters);
    }

    public Map<String,Object> updateAcctContact(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String first_name = (String) map.get("first_name");
        String last_name = (String) map.get("last_name");
        String mi = (String) map.get("mi");
        String company_name = (String) map.get("company_name");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String locality = (String) map.get("locality");
        String state_prov = (String) map.get("state_prov");
        String country = (String) map.get("country");
        String postal_code = (String) map.get("postal_code");
        String intl_phone = (String) map.get("intl_phone");
        String alt_email = (String) map.get("alt_email");
        String birthdate = (String) map.get("birthdate");
        String address3 = (String) map.get("address3");
        
        return updateAcctContact(client_no, auth_key, account_no, first_name, last_name, mi, company_name, address1, address2, city, locality, state_prov, country, postal_code, intl_phone, alt_email, birthdate, address3);
    }
        private Map<String,Object> buildUpdateAcctContactHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_contact", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctCredentials(Long client_no, String auth_key, Long account_no, String password, String secret_question_answer, String secret_question, String pin){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"password", getValue("String", password));
        addParameters(parameters,"secret_question_answer", getValue("String", secret_question_answer));
        addParameters(parameters,"secret_question", getValue("String", secret_question));
        addParameters(parameters,"pin", getValue("String", pin));
        
        return this.buildUpdateAcctCredentialsHashMap(parameters);
    }

    public Map<String,Object> updateAcctCredentials(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String password = (String) map.get("password");
        String secret_question_answer = (String) map.get("secret_question_answer");
        String secret_question = (String) map.get("secret_question");
        String pin = (String) map.get("pin");
        
        return updateAcctCredentials(client_no, auth_key, account_no, password, secret_question_answer, secret_question, pin);
    }
        private Map<String,Object> buildUpdateAcctCredentialsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_credentials", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctNotifyMethod(Long client_no, String auth_key, Long account_no, Long notify_method, Long list_start_master_file){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"notify_method", getValue("Long", notify_method));
        addParameters(parameters,"list_start_master_file", getValue("Long", list_start_master_file));
        
        return this.buildUpdateAcctNotifyMethodHashMap(parameters);
    }

    public Map<String,Object> updateAcctNotifyMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long notify_method = (Long) map.get("notify_method");
        Long list_start_master_file = (Long) map.get("list_start_master_file");
        
        return updateAcctNotifyMethod(client_no, auth_key, account_no, notify_method, list_start_master_file);
    }
        private Map<String,Object> buildUpdateAcctNotifyMethodHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_notify_method", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctPlanUnitInstance(Long client_no, String auth_key, Long acct_no, String client_acct_id, Long plan_unit_inst_no, String client_plan_unit_inst_id, String new_client_plan_unit_inst_id, com.aria.common.shared.PlanUnitInstServicesArray plan_unit_inst_services, com.aria.common.shared.PlanUnitInstFieldsArray plan_unit_inst_fields, String do_write){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"client_acct_id", getValue("String", client_acct_id));
        addParameters(parameters,"plan_unit_inst_no", getValue("Long", plan_unit_inst_no));
        addParameters(parameters,"client_plan_unit_inst_id", getValue("String", client_plan_unit_inst_id));
        addParameters(parameters,"new_client_plan_unit_inst_id", getValue("String", new_client_plan_unit_inst_id));
        RestUtilities.addParameterValuesFromArray(parameters, plan_unit_inst_services);
        RestUtilities.addParameterValuesFromArray(parameters, plan_unit_inst_fields);
        addParameters(parameters,"do_write", getValue("String", do_write));
        
        return this.buildUpdateAcctPlanUnitInstanceHashMap(parameters);
    }

    public Map<String,Object> updateAcctPlanUnitInstance(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String client_acct_id = (String) map.get("client_acct_id");
        Long plan_unit_inst_no = (Long) map.get("plan_unit_inst_no");
        String client_plan_unit_inst_id = (String) map.get("client_plan_unit_inst_id");
        String new_client_plan_unit_inst_id = (String) map.get("new_client_plan_unit_inst_id");
        com.aria.common.shared.PlanUnitInstServicesArray plan_unit_inst_services = (com.aria.common.shared.PlanUnitInstServicesArray) map.get("plan_unit_inst_services");
        com.aria.common.shared.PlanUnitInstFieldsArray plan_unit_inst_fields = (com.aria.common.shared.PlanUnitInstFieldsArray) map.get("plan_unit_inst_fields");
        String do_write = (String) map.get("do_write");
        
        return updateAcctPlanUnitInstance(client_no, auth_key, acct_no, client_acct_id, plan_unit_inst_no, client_plan_unit_inst_id, new_client_plan_unit_inst_id, plan_unit_inst_services, plan_unit_inst_fields, do_write);
    }
        private Map<String,Object> buildUpdateAcctPlanUnitInstanceHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_plan_unit_instance", parameters);
        String[] returnValues = new String[31];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "out_acct_no";
        returnValues[3] = "out_client_acct_id";
        returnValues[4] = "out_plan_unit_inst_no";
        returnValues[5] = "out_client_plan_unit_inst_id";
        returnValues[6] = "proration_result_amount";
        returnValues[7] = "invoice_no";
        returnValues[8] = "invoice_line_items";
        returnValues[9] = "collection_error_code";
        returnValues[10] = "collection_error_msg";
        returnValues[11] = "statement_error_code";
        returnValues[12] = "statement_error_msg";
        returnValues[13] = "proc_cvv_response";
        returnValues[14] = "proc_avs_response";
        returnValues[15] = "proc_cavv_response";
        returnValues[16] = "proc_status_code";
        returnValues[17] = "proc_status_text";
        returnValues[18] = "proc_payment_id";
        returnValues[19] = "proc_auth_code";
        returnValues[20] = "proc_merch_comments";
        returnValues[21] = "total_charges_before_tax";
        returnValues[22] = "total_tax_charges";
        returnValues[23] = "total_charges_after_tax";
        returnValues[24] = "total_credit";
        returnValues[25] = "total_tax_credit";
        returnValues[26] = "total_credit_before_tax";
        returnValues[27] = "total";
        returnValues[28] = "expectd_monthly_rec_cost";
        returnValues[29] = "expectd_annual_rec_cost";
        returnValues[30] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctStatus(Long client_no, String auth_key, Long account_no, Long status_cd, Long queue_days, String queue_date, Long force_bill_date_reset, String comments, String client_receipt_id, String alt_do_dunning, String status_degrade_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"status_cd", getValue("Long", status_cd));
        addParameters(parameters,"queue_days", getValue("Long", queue_days));
        addParameters(parameters,"queue_date", getValue("String", queue_date));
        addParameters(parameters,"force_bill_date_reset", getValue("Long", force_bill_date_reset));
        addParameters(parameters,"comments", getValue("String", comments));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"alt_do_dunning", getValue("String", alt_do_dunning));
        addParameters(parameters,"status_degrade_date", getValue("String", status_degrade_date));
        
        return this.buildUpdateAcctStatusHashMap(parameters);
    }

    public Map<String,Object> updateAcctStatus(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long status_cd = (Long) map.get("status_cd");
        Long queue_days = (Long) map.get("queue_days");
        String queue_date = (String) map.get("queue_date");
        Long force_bill_date_reset = (Long) map.get("force_bill_date_reset");
        String comments = (String) map.get("comments");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String alt_do_dunning = (String) map.get("alt_do_dunning");
        String status_degrade_date = (String) map.get("status_degrade_date");
        
        return updateAcctStatus(client_no, auth_key, account_no, status_cd, queue_days, queue_date, force_bill_date_reset, comments, client_receipt_id, alt_do_dunning, status_degrade_date);
    }
        private Map<String,Object> buildUpdateAcctStatusHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_status", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateAcctSuppFields(Long client_no, String auth_key, Long account_no, String field_name, String value_text){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"field_name", getValue("String", field_name));
        addParameters(parameters,"value_text", getValue("String", value_text));
        
        return this.buildUpdateAcctSuppFieldsHashMap(parameters);
    }

    public Map<String,Object> updateAcctSuppFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        String field_name = (String) map.get("field_name");
        String value_text = (String) map.get("value_text");
        
        return updateAcctSuppFields(client_no, auth_key, account_no, field_name, value_text);
    }
        private Map<String,Object> buildUpdateAcctSuppFieldsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_acct_supp_fields", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateExistingBillingInfo(Long client_no, String auth_key, Long acct_no, Long seq_no, String address1, String address2, String city, String state, String zip, String country, Long cc_expire_mm, Long cc_expire_yyyy, Long phone_npa, Long phone_nxx, String phone_suffix, String phone_ext, String phone_country_cd, String intl_phone, String email, String locality, Long cell_phone_npa, Long cell_phone_nxx, String cell_phone_suffix, Long work_phone_npa, Long work_phone_nxx, String work_phone_suffix, String work_phone_ext, String do_collect, String change_status_after_coll, String reset_dates_after_status, String address3, String client_receipt_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"seq_no", getValue("Long", seq_no));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"state", getValue("String", state));
        addParameters(parameters,"zip", getValue("String", zip));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"phone_npa", getValue("Long", phone_npa));
        addParameters(parameters,"phone_nxx", getValue("Long", phone_nxx));
        addParameters(parameters,"phone_suffix", getValue("String", phone_suffix));
        addParameters(parameters,"phone_ext", getValue("String", phone_ext));
        addParameters(parameters,"phone_country_cd", getValue("String", phone_country_cd));
        addParameters(parameters,"intl_phone", getValue("String", intl_phone));
        addParameters(parameters,"email", getValue("String", email));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"cell_phone_npa", getValue("Long", cell_phone_npa));
        addParameters(parameters,"cell_phone_nxx", getValue("Long", cell_phone_nxx));
        addParameters(parameters,"cell_phone_suffix", getValue("String", cell_phone_suffix));
        addParameters(parameters,"work_phone_npa", getValue("Long", work_phone_npa));
        addParameters(parameters,"work_phone_nxx", getValue("Long", work_phone_nxx));
        addParameters(parameters,"work_phone_suffix", getValue("String", work_phone_suffix));
        addParameters(parameters,"work_phone_ext", getValue("String", work_phone_ext));
        addParameters(parameters,"do_collect", getValue("String", do_collect));
        addParameters(parameters,"change_status_after_coll", getValue("String", change_status_after_coll));
        addParameters(parameters,"reset_dates_after_status", getValue("String", reset_dates_after_status));
        addParameters(parameters,"address3", getValue("String", address3));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        
        return this.buildUpdateExistingBillingInfoHashMap(parameters);
    }

    public Map<String,Object> updateExistingBillingInfo(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long seq_no = (Long) map.get("seq_no");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String state = (String) map.get("state");
        String zip = (String) map.get("zip");
        String country = (String) map.get("country");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        Long phone_npa = (Long) map.get("phone_npa");
        Long phone_nxx = (Long) map.get("phone_nxx");
        String phone_suffix = (String) map.get("phone_suffix");
        String phone_ext = (String) map.get("phone_ext");
        String phone_country_cd = (String) map.get("phone_country_cd");
        String intl_phone = (String) map.get("intl_phone");
        String email = (String) map.get("email");
        String locality = (String) map.get("locality");
        Long cell_phone_npa = (Long) map.get("cell_phone_npa");
        Long cell_phone_nxx = (Long) map.get("cell_phone_nxx");
        String cell_phone_suffix = (String) map.get("cell_phone_suffix");
        Long work_phone_npa = (Long) map.get("work_phone_npa");
        Long work_phone_nxx = (Long) map.get("work_phone_nxx");
        String work_phone_suffix = (String) map.get("work_phone_suffix");
        String work_phone_ext = (String) map.get("work_phone_ext");
        String do_collect = (String) map.get("do_collect");
        String change_status_after_coll = (String) map.get("change_status_after_coll");
        String reset_dates_after_status = (String) map.get("reset_dates_after_status");
        String address3 = (String) map.get("address3");
        String client_receipt_id = (String) map.get("client_receipt_id");
        
        return updateExistingBillingInfo(client_no, auth_key, acct_no, seq_no, address1, address2, city, state, zip, country, cc_expire_mm, cc_expire_yyyy, phone_npa, phone_nxx, phone_suffix, phone_ext, phone_country_cd, intl_phone, email, locality, cell_phone_npa, cell_phone_nxx, cell_phone_suffix, work_phone_npa, work_phone_nxx, work_phone_suffix, work_phone_ext, do_collect, change_status_after_coll, reset_dates_after_status, address3, client_receipt_id);
    }
        private Map<String,Object> buildUpdateExistingBillingInfoHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_existing_billing_info", parameters);
        String[] returnValues = new String[12];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "collection_error_code";
        returnValues[3] = "collection_error_msg";
        returnValues[4] = "proc_cvv_response";
        returnValues[5] = "proc_avs_response";
        returnValues[6] = "proc_cavv_response";
        returnValues[7] = "proc_status_code";
        returnValues[8] = "proc_status_text";
        returnValues[9] = "proc_payment_id";
        returnValues[10] = "proc_auth_code";
        returnValues[11] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updateMasterPlan(Long client_no, String auth_key, Long acct_no, Long master_plan_no, Long alt_rate_schedule_no, Long num_plan_units, Long assignment_directive, String do_write, String client_receipt_id, String force_currency_change, String auto_cancel_supp_plans, Long offset_months, String alt_proration_start_date, String alt_client_acct_group_id, com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates, String effective_date, Long offset_interval, String invoice_unbilled_usage, String coupon_code, String client_master_plan_id, String client_alt_rate_schedule_id, com.aria.common.shared.SurchargeNoArray surcharge_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"master_plan_no", getValue("Long", master_plan_no));
        addParameters(parameters,"alt_rate_schedule_no", getValue("Long", alt_rate_schedule_no));
        addParameters(parameters,"num_plan_units", getValue("Long", num_plan_units));
        addParameters(parameters,"assignment_directive", getValue("Long", assignment_directive));
        addParameters(parameters,"do_write", getValue("String", do_write));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"force_currency_change", getValue("String", force_currency_change));
        addParameters(parameters,"auto_cancel_supp_plans", getValue("String", auto_cancel_supp_plans));
        addParameters(parameters,"offset_months", getValue("Long", offset_months));
        addParameters(parameters,"alt_proration_start_date", getValue("String", alt_proration_start_date));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        RestUtilities.addParameterValuesFromArray(parameters, new_acct_custom_rates);
        addParameters(parameters,"effective_date", getValue("String", effective_date));
        addParameters(parameters,"offset_interval", getValue("Long", offset_interval));
        addParameters(parameters,"invoice_unbilled_usage", getValue("String", invoice_unbilled_usage));
        addParameters(parameters,"coupon_code", getValue("String", coupon_code));
        addParameters(parameters,"client_master_plan_id", getValue("String", client_master_plan_id));
        addParameters(parameters,"client_alt_rate_schedule_id", getValue("String", client_alt_rate_schedule_id));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no);
        
        return this.buildUpdateMasterPlanHashMap(parameters);
    }

    public Map<String,Object> updateMasterPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        Long master_plan_no = (Long) map.get("master_plan_no");
        Long alt_rate_schedule_no = (Long) map.get("alt_rate_schedule_no");
        Long num_plan_units = (Long) map.get("num_plan_units");
        Long assignment_directive = (Long) map.get("assignment_directive");
        String do_write = (String) map.get("do_write");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String force_currency_change = (String) map.get("force_currency_change");
        String auto_cancel_supp_plans = (String) map.get("auto_cancel_supp_plans");
        Long offset_months = (Long) map.get("offset_months");
        String alt_proration_start_date = (String) map.get("alt_proration_start_date");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        com.aria.common.shared.NewAcctCustomRatesArray new_acct_custom_rates = (com.aria.common.shared.NewAcctCustomRatesArray) map.get("new_acct_custom_rates");
        String effective_date = (String) map.get("effective_date");
        Long offset_interval = (Long) map.get("offset_interval");
        String invoice_unbilled_usage = (String) map.get("invoice_unbilled_usage");
        String coupon_code = (String) map.get("coupon_code");
        String client_master_plan_id = (String) map.get("client_master_plan_id");
        String client_alt_rate_schedule_id = (String) map.get("client_alt_rate_schedule_id");
        com.aria.common.shared.SurchargeNoArray surcharge_no = (com.aria.common.shared.SurchargeNoArray) map.get("surcharge_no");
        
        return updateMasterPlan(client_no, auth_key, acct_no, master_plan_no, alt_rate_schedule_no, num_plan_units, assignment_directive, do_write, client_receipt_id, force_currency_change, auto_cancel_supp_plans, offset_months, alt_proration_start_date, alt_client_acct_group_id, new_acct_custom_rates, effective_date, offset_interval, invoice_unbilled_usage, coupon_code, client_master_plan_id, client_alt_rate_schedule_id, surcharge_no);
    }
        private Map<String,Object> buildUpdateMasterPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_master_plan", parameters);
        String[] returnValues = new String[29];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proration_result_amount";
        returnValues[3] = "collection_error_code";
        returnValues[4] = "collection_error_msg";
        returnValues[5] = "statement_error_code";
        returnValues[6] = "statement_error_msg";
        returnValues[7] = "proc_cvv_response";
        returnValues[8] = "proc_avs_response";
        returnValues[9] = "proc_cavv_response";
        returnValues[10] = "proc_status_code";
        returnValues[11] = "proc_status_text";
        returnValues[12] = "proc_payment_id";
        returnValues[13] = "proc_auth_code";
        returnValues[14] = "proc_merch_comments";
        returnValues[15] = "invoice_no";
        returnValues[16] = "cancelled_supp_plans";
        returnValues[17] = "expectd_activation_fee";
        returnValues[18] = "expectd_mthly_recurring_cost";
        returnValues[19] = "expectd_annu_recurring_cost";
        returnValues[20] = "upd_acct_invoice_line_items";
        returnValues[21] = "total_charges_before_tax";
        returnValues[22] = "total_tax_charges";
        returnValues[23] = "total_charges_after_tax";
        returnValues[24] = "total_credit";
        returnValues[25] = "total_tax_credit";
        returnValues[26] = "total_credit_before_tax";
        returnValues[27] = "total";
        returnValues[28] = "third_party_errors";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> updatePaymentMethod(Long client_no, String auth_key, Long account_number, String first_name, String last_name, String middle_initial, String company_name, String address1, String address2, String city, String locality, String state, String country, String zip, String intl_phone, String phone_npa, String phone_nxx, String phone_suffix, String phone_extension, String email, String pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bank_routing_num, String bank_acct_num, String do_collect, String change_status_after_coll, String reset_dates_after_status, String client_receipt_id, String bank_acct_type, String iban, Long bank_check_digit, String bank_swift_cd, String bank_country_cd, String mandate_id, String bank_id_cd, String bank_branch_cd, Long primary_or_bkup_pay_method_ind, Long ref_bkup_seq_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_number", getValue("Long", account_number));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"middle_initial", getValue("String", middle_initial));
        addParameters(parameters,"company_name", getValue("String", company_name));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"state", getValue("String", state));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"zip", getValue("String", zip));
        addParameters(parameters,"intl_phone", getValue("String", intl_phone));
        addParameters(parameters,"phone_npa", getValue("String", phone_npa));
        addParameters(parameters,"phone_nxx", getValue("String", phone_nxx));
        addParameters(parameters,"phone_suffix", getValue("String", phone_suffix));
        addParameters(parameters,"phone_extension", getValue("String", phone_extension));
        addParameters(parameters,"email", getValue("String", email));
        addParameters(parameters,"pay_method", getValue("String", pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bank_routing_num", getValue("String", bank_routing_num));
        addParameters(parameters,"bank_acct_num", getValue("String", bank_acct_num));
        addParameters(parameters,"do_collect", getValue("String", do_collect));
        addParameters(parameters,"change_status_after_coll", getValue("String", change_status_after_coll));
        addParameters(parameters,"reset_dates_after_status", getValue("String", reset_dates_after_status));
        addParameters(parameters,"client_receipt_id", getValue("String", client_receipt_id));
        addParameters(parameters,"bank_acct_type", getValue("String", bank_acct_type));
        addParameters(parameters,"iban", getValue("String", iban));
        addParameters(parameters,"bank_check_digit", getValue("Long", bank_check_digit));
        addParameters(parameters,"bank_swift_cd", getValue("String", bank_swift_cd));
        addParameters(parameters,"bank_country_cd", getValue("String", bank_country_cd));
        addParameters(parameters,"mandate_id", getValue("String", mandate_id));
        addParameters(parameters,"bank_id_cd", getValue("String", bank_id_cd));
        addParameters(parameters,"bank_branch_cd", getValue("String", bank_branch_cd));
        addParameters(parameters,"primary_or_bkup_pay_method_ind", getValue("Long", primary_or_bkup_pay_method_ind));
        addParameters(parameters,"ref_bkup_seq_no", getValue("Long", ref_bkup_seq_no));
        
        return this.buildUpdatePaymentMethodHashMap(parameters);
    }

    public Map<String,Object> updatePaymentMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_number = (Long) map.get("account_number");
        String first_name = (String) map.get("first_name");
        String last_name = (String) map.get("last_name");
        String middle_initial = (String) map.get("middle_initial");
        String company_name = (String) map.get("company_name");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String locality = (String) map.get("locality");
        String state = (String) map.get("state");
        String country = (String) map.get("country");
        String zip = (String) map.get("zip");
        String intl_phone = (String) map.get("intl_phone");
        String phone_npa = (String) map.get("phone_npa");
        String phone_nxx = (String) map.get("phone_nxx");
        String phone_suffix = (String) map.get("phone_suffix");
        String phone_extension = (String) map.get("phone_extension");
        String email = (String) map.get("email");
        String pay_method = (String) map.get("pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bank_routing_num = (String) map.get("bank_routing_num");
        String bank_acct_num = (String) map.get("bank_acct_num");
        String do_collect = (String) map.get("do_collect");
        String change_status_after_coll = (String) map.get("change_status_after_coll");
        String reset_dates_after_status = (String) map.get("reset_dates_after_status");
        String client_receipt_id = (String) map.get("client_receipt_id");
        String bank_acct_type = (String) map.get("bank_acct_type");
        String iban = (String) map.get("iban");
        Long bank_check_digit = (Long) map.get("bank_check_digit");
        String bank_swift_cd = (String) map.get("bank_swift_cd");
        String bank_country_cd = (String) map.get("bank_country_cd");
        String mandate_id = (String) map.get("mandate_id");
        String bank_id_cd = (String) map.get("bank_id_cd");
        String bank_branch_cd = (String) map.get("bank_branch_cd");
        Long primary_or_bkup_pay_method_ind = (Long) map.get("primary_or_bkup_pay_method_ind");
        Long ref_bkup_seq_no = (Long) map.get("ref_bkup_seq_no");
        
        return updatePaymentMethod(client_no, auth_key, account_number, first_name, last_name, middle_initial, company_name, address1, address2, city, locality, state, country, zip, intl_phone, phone_npa, phone_nxx, phone_suffix, phone_extension, email, pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bank_routing_num, bank_acct_num, do_collect, change_status_after_coll, reset_dates_after_status, client_receipt_id, bank_acct_type, iban, bank_check_digit, bank_swift_cd, bank_country_cd, mandate_id, bank_id_cd, bank_branch_cd, primary_or_bkup_pay_method_ind, ref_bkup_seq_no);
    }
        private Map<String,Object> buildUpdatePaymentMethodHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "update_payment_method", parameters);
        String[] returnValues = new String[13];
        
        returnValues[0] = "seq_no";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
        returnValues[3] = "collection_error_code";
        returnValues[4] = "collection_error_msg";
        returnValues[5] = "proc_cvv_response";
        returnValues[6] = "proc_avs_response";
        returnValues[7] = "proc_cavv_response";
        returnValues[8] = "proc_status_code";
        returnValues[9] = "proc_status_text";
        returnValues[10] = "proc_payment_id";
        returnValues[11] = "proc_auth_code";
        returnValues[12] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> useridExists(Long client_no, String auth_key, String user_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        
        return this.buildUseridExistsHashMap(parameters);
    }

    public Map<String,Object> useridExists(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        
        return useridExists(client_no, auth_key, user_id);
    }
        private Map<String,Object> buildUseridExistsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "userid_exists", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> useridIsAvailable(Long client_no, String auth_key, String user_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        
        return this.buildUseridIsAvailableHashMap(parameters);
    }

    public Map<String,Object> useridIsAvailable(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        
        return useridIsAvailable(client_no, auth_key, user_id);
    }
        private Map<String,Object> buildUseridIsAvailableHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "userid_is_available", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> validatePaymentInformation(Long client_no, String auth_key, Long account_no, Long CVV, Long seq_no, String inTrackingNumber, String inAuthValue, Long alt_pay_method, String cc_number, Long cc_expire_mm, Long cc_expire_yyyy, String bill_company_name, String bill_first_name, String bill_middle_initial, String bill_last_name, String bill_address1, String bill_address2, String bill_city, String bill_locality, String bill_state_prov, String bill_zip, String bill_country, String bill_email, String bill_phone, String bill_phone_extension, String bill_cell_phone, String bill_work_phone, String bill_work_phone_extension, String currency_cd, Long acct_group_no, String bill_address3, String alt_client_acct_group_id, String track_data1, String track_data2, String client_acct_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"account_no", getValue("Long", account_no));
        addParameters(parameters,"CVV", getValue("Long", CVV));
        addParameters(parameters,"seq_no", getValue("Long", seq_no));
        addParameters(parameters,"inTrackingNumber", getValue("String", inTrackingNumber));
        addParameters(parameters,"inAuthValue", getValue("String", inAuthValue));
        addParameters(parameters,"alt_pay_method", getValue("Long", alt_pay_method));
        addParameters(parameters,"cc_number", getValue("String", cc_number));
        addParameters(parameters,"cc_expire_mm", getValue("Long", cc_expire_mm));
        addParameters(parameters,"cc_expire_yyyy", getValue("Long", cc_expire_yyyy));
        addParameters(parameters,"bill_company_name", getValue("String", bill_company_name));
        addParameters(parameters,"bill_first_name", getValue("String", bill_first_name));
        addParameters(parameters,"bill_middle_initial", getValue("String", bill_middle_initial));
        addParameters(parameters,"bill_last_name", getValue("String", bill_last_name));
        addParameters(parameters,"bill_address1", getValue("String", bill_address1));
        addParameters(parameters,"bill_address2", getValue("String", bill_address2));
        addParameters(parameters,"bill_city", getValue("String", bill_city));
        addParameters(parameters,"bill_locality", getValue("String", bill_locality));
        addParameters(parameters,"bill_state_prov", getValue("String", bill_state_prov));
        addParameters(parameters,"bill_zip", getValue("String", bill_zip));
        addParameters(parameters,"bill_country", getValue("String", bill_country));
        addParameters(parameters,"bill_email", getValue("String", bill_email));
        addParameters(parameters,"bill_phone", getValue("String", bill_phone));
        addParameters(parameters,"bill_phone_extension", getValue("String", bill_phone_extension));
        addParameters(parameters,"bill_cell_phone", getValue("String", bill_cell_phone));
        addParameters(parameters,"bill_work_phone", getValue("String", bill_work_phone));
        addParameters(parameters,"bill_work_phone_extension", getValue("String", bill_work_phone_extension));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"acct_group_no", getValue("Long", acct_group_no));
        addParameters(parameters,"bill_address3", getValue("String", bill_address3));
        addParameters(parameters,"alt_client_acct_group_id", getValue("String", alt_client_acct_group_id));
        addParameters(parameters,"track_data1", getValue("String", track_data1));
        addParameters(parameters,"track_data2", getValue("String", track_data2));
        addParameters(parameters,"client_acct_group_id", getValue("String", client_acct_group_id));
        
        return this.buildValidatePaymentInformationHashMap(parameters);
    }

    public Map<String,Object> validatePaymentInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long account_no = (Long) map.get("account_no");
        Long CVV = (Long) map.get("CVV");
        Long seq_no = (Long) map.get("seq_no");
        String inTrackingNumber = (String) map.get("inTrackingNumber");
        String inAuthValue = (String) map.get("inAuthValue");
        Long alt_pay_method = (Long) map.get("alt_pay_method");
        String cc_number = (String) map.get("cc_number");
        Long cc_expire_mm = (Long) map.get("cc_expire_mm");
        Long cc_expire_yyyy = (Long) map.get("cc_expire_yyyy");
        String bill_company_name = (String) map.get("bill_company_name");
        String bill_first_name = (String) map.get("bill_first_name");
        String bill_middle_initial = (String) map.get("bill_middle_initial");
        String bill_last_name = (String) map.get("bill_last_name");
        String bill_address1 = (String) map.get("bill_address1");
        String bill_address2 = (String) map.get("bill_address2");
        String bill_city = (String) map.get("bill_city");
        String bill_locality = (String) map.get("bill_locality");
        String bill_state_prov = (String) map.get("bill_state_prov");
        String bill_zip = (String) map.get("bill_zip");
        String bill_country = (String) map.get("bill_country");
        String bill_email = (String) map.get("bill_email");
        String bill_phone = (String) map.get("bill_phone");
        String bill_phone_extension = (String) map.get("bill_phone_extension");
        String bill_cell_phone = (String) map.get("bill_cell_phone");
        String bill_work_phone = (String) map.get("bill_work_phone");
        String bill_work_phone_extension = (String) map.get("bill_work_phone_extension");
        String currency_cd = (String) map.get("currency_cd");
        Long acct_group_no = (Long) map.get("acct_group_no");
        String bill_address3 = (String) map.get("bill_address3");
        String alt_client_acct_group_id = (String) map.get("alt_client_acct_group_id");
        String track_data1 = (String) map.get("track_data1");
        String track_data2 = (String) map.get("track_data2");
        String client_acct_group_id = (String) map.get("client_acct_group_id");
        
        return validatePaymentInformation(client_no, auth_key, account_no, CVV, seq_no, inTrackingNumber, inAuthValue, alt_pay_method, cc_number, cc_expire_mm, cc_expire_yyyy, bill_company_name, bill_first_name, bill_middle_initial, bill_last_name, bill_address1, bill_address2, bill_city, bill_locality, bill_state_prov, bill_zip, bill_country, bill_email, bill_phone, bill_phone_extension, bill_cell_phone, bill_work_phone, bill_work_phone_extension, currency_cd, acct_group_no, bill_address3, alt_client_acct_group_id, track_data1, track_data2, client_acct_group_id);
    }
        private Map<String,Object> buildValidatePaymentInformationHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "validate_payment_information", parameters);
        String[] returnValues = new String[10];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "proc_cvv_response";
        returnValues[3] = "proc_avs_response";
        returnValues[4] = "proc_cavv_response";
        returnValues[5] = "proc_status_code";
        returnValues[6] = "proc_status_text";
        returnValues[7] = "proc_payment_id";
        returnValues[8] = "proc_auth_code";
        returnValues[9] = "proc_merch_comments";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> writeAcctComment(Long client_no, String auth_key, Long acct_no, String comment){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"comment", getValue("String", comment));
        
        return this.buildWriteAcctCommentHashMap(parameters);
    }

    public Map<String,Object> writeAcctComment(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String comment = (String) map.get("comment");
        
        return writeAcctComment(client_no, auth_key, acct_no, comment);
    }
        private Map<String,Object> buildWriteAcctCommentHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "write_acct_comment", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> authenticateCaller(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildAuthenticateCallerHashMap(parameters);
    }

    public Map<String,Object> authenticateCaller(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return authenticateCaller(client_no, auth_key);
    }
        private Map<String,Object> buildAuthenticateCallerHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "authenticate_caller", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> keepAlive(Long client_no, String auth_key, String session_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        
        return this.buildKeepAliveHashMap(parameters);
    }

    public Map<String,Object> keepAlive(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        
        return keepAlive(client_no, auth_key, session_id);
    }
        private Map<String,Object> buildKeepAliveHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "keep_alive", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> killSession(Long client_no, String auth_key, String session_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        
        return this.buildKillSessionHashMap(parameters);
    }

    public Map<String,Object> killSession(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        
        return killSession(client_no, auth_key, session_id);
    }
        private Map<String,Object> buildKillSessionHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "kill_session", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setSession(Long client_no, String auth_key, String user_id, Long acct_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        
        return this.buildSetSessionHashMap(parameters);
    }

    public Map<String,Object> setSession(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        Long acct_no = (Long) map.get("acct_no");
        
        return setSession(client_no, auth_key, user_id, acct_no);
    }
        private Map<String,Object> buildSetSessionHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_session", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "session_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setSessionAuth(Long client_no, String auth_key, String user_id, String password){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"password", getValue("String", password));
        
        return this.buildSetSessionAuthHashMap(parameters);
    }

    public Map<String,Object> setSessionAuth(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String user_id = (String) map.get("user_id");
        String password = (String) map.get("password");
        
        return setSessionAuth(client_no, auth_key, user_id, password);
    }
        private Map<String,Object> buildSetSessionAuthHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_session_auth", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "session_id";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> validateSession(Long client_no, String auth_key, String session_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        
        return this.buildValidateSessionHashMap(parameters);
    }

    public Map<String,Object> validateSession(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        
        return validateSession(client_no, auth_key, session_id);
    }
        private Map<String,Object> buildValidateSessionHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "validate_session", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "user_id";
        returnValues[1] = "account_no";
        returnValues[2] = "error_code";
        returnValues[3] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> advanceVirtualDatetime(Long client_no, String auth_key, Long offset_hours){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"offset_hours", getValue("Long", offset_hours));
        
        return this.buildAdvanceVirtualDatetimeHashMap(parameters);
    }

    public Map<String,Object> advanceVirtualDatetime(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long offset_hours = (Long) map.get("offset_hours");
        
        return advanceVirtualDatetime(client_no, auth_key, offset_hours);
    }
        private Map<String,Object> buildAdvanceVirtualDatetimeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "advance_virtual_datetime", parameters);
        String[] returnValues = new String[7];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "virtual_date";
        returnValues[3] = "virtual_time";
        returnValues[4] = "system_date";
        returnValues[5] = "system_time";
        returnValues[6] = "current_offset_hours";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> clearRegUssConfigParams(Long client_no, String auth_key, String set_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"set_name", getValue("String", set_name));
        
        return this.buildClearRegUssConfigParamsHashMap(parameters);
    }

    public Map<String,Object> clearRegUssConfigParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String set_name = (String) map.get("set_name");
        
        return clearRegUssConfigParams(client_no, auth_key, set_name);
    }
        private Map<String,Object> buildClearRegUssConfigParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "clear_reg_uss_config_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> clearRegUssParams(Long client_no, String auth_key, String session_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        
        return this.buildClearRegUssParamsHashMap(parameters);
    }

    public Map<String,Object> clearRegUssParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        
        return clearRegUssParams(client_no, auth_key, session_id);
    }
        private Map<String,Object> buildClearRegUssParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "clear_reg_uss_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> clientHasEventClass(Long client_no, String auth_key, Long class_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"class_no", getValue("Long", class_no));
        
        return this.buildClientHasEventClassHashMap(parameters);
    }

    public Map<String,Object> clientHasEventClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long class_no = (Long) map.get("class_no");
        
        return clientHasEventClass(client_no, auth_key, class_no);
    }
        private Map<String,Object> buildClientHasEventClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "client_has_event_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "response";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> deleteRegUssConfigParams(Long client_no, String auth_key, String set_name, com.aria.common.shared.ParamNamesArray param_names){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"set_name", getValue("String", set_name));
        RestUtilities.addParameterValuesFromArray(parameters, param_names);
        
        return this.buildDeleteRegUssConfigParamsHashMap(parameters);
    }

    public Map<String,Object> deleteRegUssConfigParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String set_name = (String) map.get("set_name");
        com.aria.common.shared.ParamNamesArray param_names = (com.aria.common.shared.ParamNamesArray) map.get("param_names");
        
        return deleteRegUssConfigParams(client_no, auth_key, set_name, param_names);
    }
        private Map<String,Object> buildDeleteRegUssConfigParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "delete_reg_uss_config_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> deleteRegUssParams(Long client_no, String auth_key, String session_id, com.aria.common.shared.ParamNamesArray param_names){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        RestUtilities.addParameterValuesFromArray(parameters, param_names);
        
        return this.buildDeleteRegUssParamsHashMap(parameters);
    }

    public Map<String,Object> deleteRegUssParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        com.aria.common.shared.ParamNamesArray param_names = (com.aria.common.shared.ParamNamesArray) map.get("param_names");
        
        return deleteRegUssParams(client_no, auth_key, session_id, param_names);
    }
        private Map<String,Object> buildDeleteRegUssParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "delete_reg_uss_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> genRandomString(Long client_no, String auth_key, String rand_type, Long rand_length, String rand_case){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"rand_type", getValue("String", rand_type));
        addParameters(parameters,"rand_length", getValue("Long", rand_length));
        addParameters(parameters,"rand_case", getValue("String", rand_case));
        
        return this.buildGenRandomStringHashMap(parameters);
    }

    public Map<String,Object> genRandomString(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String rand_type = (String) map.get("rand_type");
        Long rand_length = (Long) map.get("rand_length");
        String rand_case = (String) map.get("rand_case");
        
        return genRandomString(client_no, auth_key, rand_type, rand_length, rand_case);
    }
        private Map<String,Object> buildGenRandomStringHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "gen_random_string", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "random_string";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAcctSurcharges(Long client_no, String auth_key, Long acct_no, String include_detail_ind){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"include_detail_ind", getValue("String", include_detail_ind));
        
        return this.buildGetAcctSurchargesHashMap(parameters);
    }

    public Map<String,Object> getAcctSurcharges(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long acct_no = (Long) map.get("acct_no");
        String include_detail_ind = (String) map.get("include_detail_ind");
        
        return getAcctSurcharges(client_no, auth_key, acct_no, include_detail_ind);
    }
        private Map<String,Object> buildGetAcctSurchargesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_acct_surcharges", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "all_acct_surcharges";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAllClientReceiptIds(Long client_no, String auth_key, String start_date_range, String end_date_range){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"start_date_range", getValue("String", start_date_range));
        addParameters(parameters,"end_date_range", getValue("String", end_date_range));
        
        return this.buildGetAllClientReceiptIdsHashMap(parameters);
    }

    public Map<String,Object> getAllClientReceiptIds(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String start_date_range = (String) map.get("start_date_range");
        String end_date_range = (String) map.get("end_date_range");
        
        return getAllClientReceiptIds(client_no, auth_key, start_date_range, end_date_range);
    }
        private Map<String,Object> buildGetAllClientReceiptIdsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_all_client_receipt_ids", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "client_receipt";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAufStatus(Long client_no, String auth_key, String file_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"file_name", getValue("String", file_name));
        
        return this.buildGetAufStatusHashMap(parameters);
    }

    public Map<String,Object> getAufStatus(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String file_name = (String) map.get("file_name");
        
        return getAufStatus(client_no, auth_key, file_name);
    }
        private Map<String,Object> buildGetAufStatusHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_auf_status", parameters);
        String[] returnValues = new String[7];
        
        returnValues[0] = "status_cd";
        returnValues[1] = "load_date_time";
        returnValues[2] = "recs_received";
        returnValues[3] = "recs_loaded";
        returnValues[4] = "recs_failed";
        returnValues[5] = "error_code";
        returnValues[6] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getChildForItemClass(Long client_no, String auth_key, Long filter_class_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_class_no", getValue("Long", filter_class_no));
        
        return this.buildGetChildForItemClassHashMap(parameters);
    }

    public Map<String,Object> getChildForItemClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long filter_class_no = (Long) map.get("filter_class_no");
        
        return getChildForItemClass(client_no, auth_key, filter_class_no);
    }
        private Map<String,Object> buildGetChildForItemClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_child_for_item_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "child_item_class";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientCountries(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetClientCountriesHashMap(parameters);
    }

    public Map<String,Object> getClientCountries(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getClientCountries(client_no, auth_key);
    }
        private Map<String,Object> buildGetClientCountriesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_countries", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "client_country";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientCurrencies(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetClientCurrenciesHashMap(parameters);
    }

    public Map<String,Object> getClientCurrencies(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getClientCurrencies(client_no, auth_key);
    }
        private Map<String,Object> buildGetClientCurrenciesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_currencies", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "client_currency";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientItemClasses(Long client_no, String auth_key, Long filter_item_no, String filter_client_item_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_item_no", getValue("Long", filter_item_no));
        addParameters(parameters,"filter_client_item_id", getValue("String", filter_client_item_id));
        
        return this.buildGetClientItemClassesHashMap(parameters);
    }

    public Map<String,Object> getClientItemClasses(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long filter_item_no = (Long) map.get("filter_item_no");
        String filter_client_item_id = (String) map.get("filter_client_item_id");
        
        return getClientItemClasses(client_no, auth_key, filter_item_no, filter_client_item_id);
    }
        private Map<String,Object> buildGetClientItemClassesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_item_classes", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "all_item_classes";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientItemImages(Long client_no, String auth_key, Long item_no, String client_item_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"item_no", getValue("Long", item_no));
        addParameters(parameters,"client_item_id", getValue("String", client_item_id));
        
        return this.buildGetClientItemImagesHashMap(parameters);
    }

    public Map<String,Object> getClientItemImages(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long item_no = (Long) map.get("item_no");
        String client_item_id = (String) map.get("client_item_id");
        
        return getClientItemImages(client_no, auth_key, item_no, client_item_id);
    }
        private Map<String,Object> buildGetClientItemImagesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_item_images", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "item_images";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientItemPrices(Long client_no, String auth_key, String filter_currency_cd, String return_no_cost_items, Long filter_item_no, String filter_client_item_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_currency_cd", getValue("String", filter_currency_cd));
        addParameters(parameters,"return_no_cost_items", getValue("String", return_no_cost_items));
        addParameters(parameters,"filter_item_no", getValue("Long", filter_item_no));
        addParameters(parameters,"filter_client_item_id", getValue("String", filter_client_item_id));
        
        return this.buildGetClientItemPricesHashMap(parameters);
    }

    public Map<String,Object> getClientItemPrices(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String filter_currency_cd = (String) map.get("filter_currency_cd");
        String return_no_cost_items = (String) map.get("return_no_cost_items");
        Long filter_item_no = (Long) map.get("filter_item_no");
        String filter_client_item_id = (String) map.get("filter_client_item_id");
        
        return getClientItemPrices(client_no, auth_key, filter_currency_cd, return_no_cost_items, filter_item_no, filter_client_item_id);
    }
        private Map<String,Object> buildGetClientItemPricesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_item_prices", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "item_rates";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientItemSuppFields(Long client_no, String auth_key, Long filter_item_no, String filter_client_item_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_item_no", getValue("Long", filter_item_no));
        addParameters(parameters,"filter_client_item_id", getValue("String", filter_client_item_id));
        
        return this.buildGetClientItemSuppFieldsHashMap(parameters);
    }

    public Map<String,Object> getClientItemSuppFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long filter_item_no = (Long) map.get("filter_item_no");
        String filter_client_item_id = (String) map.get("filter_client_item_id");
        
        return getClientItemSuppFields(client_no, auth_key, filter_item_no, filter_client_item_id);
    }
        private Map<String,Object> buildGetClientItemSuppFieldsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_item_supp_fields", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "all_item_supp_fields";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientItemsAll(Long client_no, String auth_key, String filter_currency_cd, String return_no_cost_items, Long filter_item_no, String include_inactive_items, String filter_client_item_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_currency_cd", getValue("String", filter_currency_cd));
        addParameters(parameters,"return_no_cost_items", getValue("String", return_no_cost_items));
        addParameters(parameters,"filter_item_no", getValue("Long", filter_item_no));
        addParameters(parameters,"include_inactive_items", getValue("String", include_inactive_items));
        addParameters(parameters,"filter_client_item_id", getValue("String", filter_client_item_id));
        
        return this.buildGetClientItemsAllHashMap(parameters);
    }

    public Map<String,Object> getClientItemsAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String filter_currency_cd = (String) map.get("filter_currency_cd");
        String return_no_cost_items = (String) map.get("return_no_cost_items");
        Long filter_item_no = (Long) map.get("filter_item_no");
        String include_inactive_items = (String) map.get("include_inactive_items");
        String filter_client_item_id = (String) map.get("filter_client_item_id");
        
        return getClientItemsAll(client_no, auth_key, filter_currency_cd, return_no_cost_items, filter_item_no, include_inactive_items, filter_client_item_id);
    }
        private Map<String,Object> buildGetClientItemsAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_items_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "all_client_items";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientItemsBasic(Long client_no, String auth_key, String filter_currency_cd, String return_no_cost_items, Long filter_item_no, String include_inactive_items, String filter_client_item_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_currency_cd", getValue("String", filter_currency_cd));
        addParameters(parameters,"return_no_cost_items", getValue("String", return_no_cost_items));
        addParameters(parameters,"filter_item_no", getValue("Long", filter_item_no));
        addParameters(parameters,"include_inactive_items", getValue("String", include_inactive_items));
        addParameters(parameters,"filter_client_item_id", getValue("String", filter_client_item_id));
        
        return this.buildGetClientItemsBasicHashMap(parameters);
    }

    public Map<String,Object> getClientItemsBasic(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String filter_currency_cd = (String) map.get("filter_currency_cd");
        String return_no_cost_items = (String) map.get("return_no_cost_items");
        Long filter_item_no = (Long) map.get("filter_item_no");
        String include_inactive_items = (String) map.get("include_inactive_items");
        String filter_client_item_id = (String) map.get("filter_client_item_id");
        
        return getClientItemsBasic(client_no, auth_key, filter_currency_cd, return_no_cost_items, filter_item_no, include_inactive_items, filter_client_item_id);
    }
        private Map<String,Object> buildGetClientItemsBasicHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_items_basic", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "items_basic";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientPlanServiceRates(Long client_no, String auth_key, Long plan_no, Long service_no, Long alt_rate_schedule_no, String client_plan_id, String client_service_id, String client_alt_rate_schedule_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        addParameters(parameters,"alt_rate_schedule_no", getValue("Long", alt_rate_schedule_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        addParameters(parameters,"client_alt_rate_schedule_id", getValue("String", client_alt_rate_schedule_id));
        
        return this.buildGetClientPlanServiceRatesHashMap(parameters);
    }

    public Map<String,Object> getClientPlanServiceRates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        Long service_no = (Long) map.get("service_no");
        Long alt_rate_schedule_no = (Long) map.get("alt_rate_schedule_no");
        String client_plan_id = (String) map.get("client_plan_id");
        String client_service_id = (String) map.get("client_service_id");
        String client_alt_rate_schedule_id = (String) map.get("client_alt_rate_schedule_id");
        
        return getClientPlanServiceRates(client_no, auth_key, plan_no, service_no, alt_rate_schedule_no, client_plan_id, client_service_id, client_alt_rate_schedule_id);
    }
        private Map<String,Object> buildGetClientPlanServiceRatesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_plan_service_rates", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "plan_service_rates";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientPlanServices(Long client_no, String auth_key, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildGetClientPlanServicesHashMap(parameters);
    }

    public Map<String,Object> getClientPlanServices(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return getClientPlanServices(client_no, auth_key, plan_no, client_plan_id);
    }
        private Map<String,Object> buildGetClientPlanServicesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_plan_services", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "plan_services";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientPlansAll(Long client_no, String auth_key, Long plan_no, Long acct_no, String promo_code, Long parent_plan_no, com.aria.common.shared.SuppFieldNamesArray supp_field_names, com.aria.common.shared.SuppFieldValuesArray supp_field_values, String include_all_rate_schedules, String include_plan_hierarchy, String client_plan_id, String client_parent_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"acct_no", getValue("Long", acct_no));
        addParameters(parameters,"promo_code", getValue("String", promo_code));
        addParameters(parameters,"parent_plan_no", getValue("Long", parent_plan_no));
        RestUtilities.addParameterValuesFromArray(parameters, supp_field_names);
        RestUtilities.addParameterValuesFromArray(parameters, supp_field_values);
        addParameters(parameters,"include_all_rate_schedules", getValue("String", include_all_rate_schedules));
        addParameters(parameters,"include_plan_hierarchy", getValue("String", include_plan_hierarchy));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"client_parent_plan_id", getValue("String", client_parent_plan_id));
        
        return this.buildGetClientPlansAllHashMap(parameters);
    }

    public Map<String,Object> getClientPlansAll(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        Long acct_no = (Long) map.get("acct_no");
        String promo_code = (String) map.get("promo_code");
        Long parent_plan_no = (Long) map.get("parent_plan_no");
        com.aria.common.shared.SuppFieldNamesArray supp_field_names = (com.aria.common.shared.SuppFieldNamesArray) map.get("supp_field_names");
        com.aria.common.shared.SuppFieldValuesArray supp_field_values = (com.aria.common.shared.SuppFieldValuesArray) map.get("supp_field_values");
        String include_all_rate_schedules = (String) map.get("include_all_rate_schedules");
        String include_plan_hierarchy = (String) map.get("include_plan_hierarchy");
        String client_plan_id = (String) map.get("client_plan_id");
        String client_parent_plan_id = (String) map.get("client_parent_plan_id");
        
        return getClientPlansAll(client_no, auth_key, plan_no, acct_no, promo_code, parent_plan_no, supp_field_names, supp_field_values, include_all_rate_schedules, include_plan_hierarchy, client_plan_id, client_parent_plan_id);
    }
        private Map<String,Object> buildGetClientPlansAllHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_plans_all", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_client_plans";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getClientPlansBasic(Long client_no, String auth_key, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildGetClientPlansBasicHashMap(parameters);
    }

    public Map<String,Object> getClientPlansBasic(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return getClientPlansBasic(client_no, auth_key, plan_no, client_plan_id);
    }
        private Map<String,Object> buildGetClientPlansBasicHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_client_plans_basic", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "plans_basic";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCountryFromIp(Long client_no, String auth_key, String ip_address){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"ip_address", getValue("String", ip_address));
        
        return this.buildGetCountryFromIpHashMap(parameters);
    }

    public Map<String,Object> getCountryFromIp(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String ip_address = (String) map.get("ip_address");
        
        return getCountryFromIp(client_no, auth_key, ip_address);
    }
        private Map<String,Object> buildGetCountryFromIpHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_country_from_ip", parameters);
        String[] returnValues = new String[4];
        
        returnValues[0] = "country_code";
        returnValues[1] = "country_name";
        returnValues[2] = "error_code";
        returnValues[3] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCurrentSystemVersion(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetCurrentSystemVersionHashMap(parameters);
    }

    public Map<String,Object> getCurrentSystemVersion(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getCurrentSystemVersion(client_no, auth_key);
    }
        private Map<String,Object> buildGetCurrentSystemVersionHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_current_system_version", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "version";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getDailyBatchStatus(Long client_no, String auth_key, String batch_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"batch_date", getValue("String", batch_date));
        
        return this.buildGetDailyBatchStatusHashMap(parameters);
    }

    public Map<String,Object> getDailyBatchStatus(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String batch_date = (String) map.get("batch_date");
        
        return getDailyBatchStatus(client_no, auth_key, batch_date);
    }
        private Map<String,Object> buildGetDailyBatchStatusHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_daily_batch_status", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "status";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getEmailTemplates(Long client_no, String auth_key, String filter_template_class){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_template_class", getValue("String", filter_template_class));
        
        return this.buildGetEmailTemplatesHashMap(parameters);
    }

    public Map<String,Object> getEmailTemplates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String filter_template_class = (String) map.get("filter_template_class");
        
        return getEmailTemplates(client_no, auth_key, filter_template_class);
    }
        private Map<String,Object> buildGetEmailTemplatesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_email_templates", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "templates_by_client";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getItemsByClass(Long client_no, String auth_key, Long filter_class_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_class_no", getValue("Long", filter_class_no));
        
        return this.buildGetItemsByClassHashMap(parameters);
    }

    public Map<String,Object> getItemsByClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long filter_class_no = (Long) map.get("filter_class_no");
        
        return getItemsByClass(client_no, auth_key, filter_class_no);
    }
        private Map<String,Object> buildGetItemsByClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_items_by_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "class_items";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getItemsBySuppField(Long client_no, String auth_key, Long field_no, String field_val, String field_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_no", getValue("Long", field_no));
        addParameters(parameters,"field_val", getValue("String", field_val));
        addParameters(parameters,"field_name", getValue("String", field_name));
        
        return this.buildGetItemsBySuppFieldHashMap(parameters);
    }

    public Map<String,Object> getItemsBySuppField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_no = (Long) map.get("field_no");
        String field_val = (String) map.get("field_val");
        String field_name = (String) map.get("field_name");
        
        return getItemsBySuppField(client_no, auth_key, field_no, field_val, field_name);
    }
        private Map<String,Object> buildGetItemsBySuppFieldHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_items_by_supp_field", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "items_by_supp_field";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getMasterPlansBySuppField(Long client_no, String auth_key, Long field_no, String field_val, String field_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_no", getValue("Long", field_no));
        addParameters(parameters,"field_val", getValue("String", field_val));
        addParameters(parameters,"field_name", getValue("String", field_name));
        
        return this.buildGetMasterPlansBySuppFieldHashMap(parameters);
    }

    public Map<String,Object> getMasterPlansBySuppField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_no = (Long) map.get("field_no");
        String field_val = (String) map.get("field_val");
        String field_name = (String) map.get("field_name");
        
        return getMasterPlansBySuppField(client_no, auth_key, field_no, field_val, field_name);
    }
        private Map<String,Object> buildGetMasterPlansBySuppFieldHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_master_plans_by_supp_field", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "master_plans_by_supp_field";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getParentForItemClass(Long client_no, String auth_key, Long filter_class_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"filter_class_no", getValue("Long", filter_class_no));
        
        return this.buildGetParentForItemClassHashMap(parameters);
    }

    public Map<String,Object> getParentForItemClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long filter_class_no = (Long) map.get("filter_class_no");
        
        return getParentForItemClass(client_no, auth_key, filter_class_no);
    }
        private Map<String,Object> buildGetParentForItemClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_parent_for_item_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "parent_item_class";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRateSchedulesForPlan(Long client_no, String auth_key, Long plan_no, String currency_cd, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        return this.buildGetRateSchedulesForPlanHashMap(parameters);
    }

    public Map<String,Object> getRateSchedulesForPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        String currency_cd = (String) map.get("currency_cd");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return getRateSchedulesForPlan(client_no, auth_key, plan_no, currency_cd, client_plan_id);
    }
        private Map<String,Object> buildGetRateSchedulesForPlanHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_rate_schedules_for_plan", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "rate_sched";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRegUssConfigParams(Long client_no, String auth_key, String set_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"set_name", getValue("String", set_name));
        
        return this.buildGetRegUssConfigParamsHashMap(parameters);
    }

    public Map<String,Object> getRegUssConfigParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String set_name = (String) map.get("set_name");
        
        return getRegUssConfigParams(client_no, auth_key, set_name);
    }
        private Map<String,Object> buildGetRegUssConfigParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_reg_uss_config_params", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "out_reg_uss_config_params";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRegUssParams(Long client_no, String auth_key, String session_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        
        return this.buildGetRegUssParamsHashMap(parameters);
    }

    public Map<String,Object> getRegUssParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        
        return getRegUssParams(client_no, auth_key, session_id);
    }
        private Map<String,Object> buildGetRegUssParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_reg_uss_params", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "out_reg_uss_params";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getSuppPlansBySuppField(Long client_no, String auth_key, Long field_no, String field_val, String field_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_no", getValue("Long", field_no));
        addParameters(parameters,"field_val", getValue("String", field_val));
        addParameters(parameters,"field_name", getValue("String", field_name));
        
        return this.buildGetSuppPlansBySuppFieldHashMap(parameters);
    }

    public Map<String,Object> getSuppPlansBySuppField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_no = (Long) map.get("field_no");
        String field_val = (String) map.get("field_val");
        String field_name = (String) map.get("field_name");
        
        return getSuppPlansBySuppField(client_no, auth_key, field_no, field_val, field_name);
    }
        private Map<String,Object> buildGetSuppPlansBySuppFieldHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_supp_plans_by_supp_field", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "supp_plans_by_supp_field";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getTopLevelItemClass(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetTopLevelItemClassHashMap(parameters);
    }

    public Map<String,Object> getTopLevelItemClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getTopLevelItemClass(client_no, auth_key);
    }
        private Map<String,Object> buildGetTopLevelItemClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_top_level_item_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "top_item_class";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getVirtualDatetime(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        return this.buildGetVirtualDatetimeHashMap(parameters);
    }

    public Map<String,Object> getVirtualDatetime(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getVirtualDatetime(client_no, auth_key);
    }
        private Map<String,Object> buildGetVirtualDatetimeHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_virtual_datetime", parameters);
        String[] returnValues = new String[8];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "virtual_date";
        returnValues[3] = "virtual_time";
        returnValues[4] = "system_date";
        returnValues[5] = "system_time";
        returnValues[6] = "current_offset_hours";
        returnValues[7] = "is_batch_running";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getWebReplacementVals(Long client_no, String auth_key, com.aria.common.shared.WebValsInArray web_vals_in){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, web_vals_in);
        
        return this.buildGetWebReplacementValsHashMap(parameters);
    }

    public Map<String,Object> getWebReplacementVals(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.WebValsInArray web_vals_in = (com.aria.common.shared.WebValsInArray) map.get("web_vals_in");
        
        return getWebReplacementVals(client_no, auth_key, web_vals_in);
    }
        private Map<String,Object> buildGetWebReplacementValsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_web_replacement_vals", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "web_vals_out";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> replaceRegUssConfigParams(Long client_no, String auth_key, String set_name, com.aria.common.shared.InRegUssConfigParamsArray in_reg_uss_config_params){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"set_name", getValue("String", set_name));
        RestUtilities.addParameterValuesFromArray(parameters, in_reg_uss_config_params);
        
        return this.buildReplaceRegUssConfigParamsHashMap(parameters);
    }

    public Map<String,Object> replaceRegUssConfigParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String set_name = (String) map.get("set_name");
        com.aria.common.shared.InRegUssConfigParamsArray in_reg_uss_config_params = (com.aria.common.shared.InRegUssConfigParamsArray) map.get("in_reg_uss_config_params");
        
        return replaceRegUssConfigParams(client_no, auth_key, set_name, in_reg_uss_config_params);
    }
        private Map<String,Object> buildReplaceRegUssConfigParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "replace_reg_uss_config_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> replaceRegUssParams(Long client_no, String auth_key, String session_id, com.aria.common.shared.InRegUssParamsArray in_reg_uss_params){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        RestUtilities.addParameterValuesFromArray(parameters, in_reg_uss_params);
        
        return this.buildReplaceRegUssParamsHashMap(parameters);
    }

    public Map<String,Object> replaceRegUssParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        com.aria.common.shared.InRegUssParamsArray in_reg_uss_params = (com.aria.common.shared.InRegUssParamsArray) map.get("in_reg_uss_params");
        
        return replaceRegUssParams(client_no, auth_key, session_id, in_reg_uss_params);
    }
        private Map<String,Object> buildReplaceRegUssParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "replace_reg_uss_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setExternalObjectId(Long client_no, String auth_key, Long destination_id, Long source_type_id, Long object_id, String external_id, Long action_directive){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"destination_id", getValue("Long", destination_id));
        addParameters(parameters,"source_type_id", getValue("Long", source_type_id));
        addParameters(parameters,"object_id", getValue("Long", object_id));
        addParameters(parameters,"external_id", getValue("String", external_id));
        addParameters(parameters,"action_directive", getValue("Long", action_directive));
        
        return this.buildSetExternalObjectIdHashMap(parameters);
    }

    public Map<String,Object> setExternalObjectId(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long destination_id = (Long) map.get("destination_id");
        Long source_type_id = (Long) map.get("source_type_id");
        Long object_id = (Long) map.get("object_id");
        String external_id = (String) map.get("external_id");
        Long action_directive = (Long) map.get("action_directive");
        
        return setExternalObjectId(client_no, auth_key, destination_id, source_type_id, object_id, external_id, action_directive);
    }
        private Map<String,Object> buildSetExternalObjectIdHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_external_object_id", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setProvEngine(Long client_no, String auth_key, String on_off_indicator){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"on_off_indicator", getValue("String", on_off_indicator));
        
        return this.buildSetProvEngineHashMap(parameters);
    }

    public Map<String,Object> setProvEngine(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String on_off_indicator = (String) map.get("on_off_indicator");
        
        return setProvEngine(client_no, auth_key, on_off_indicator);
    }
        private Map<String,Object> buildSetProvEngineHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_prov_engine", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setRegUssConfigParams(Long client_no, String auth_key, String set_name, com.aria.common.shared.InRegUssConfigParamsArray in_reg_uss_config_params, String set_description, Long set_type_no){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"set_name", getValue("String", set_name));
        RestUtilities.addParameterValuesFromArray(parameters, in_reg_uss_config_params);
        addParameters(parameters,"set_description", getValue("String", set_description));
        addParameters(parameters,"set_type_no", getValue("Long", set_type_no));
        
        return this.buildSetRegUssConfigParamsHashMap(parameters);
    }

    public Map<String,Object> setRegUssConfigParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String set_name = (String) map.get("set_name");
        com.aria.common.shared.InRegUssConfigParamsArray in_reg_uss_config_params = (com.aria.common.shared.InRegUssConfigParamsArray) map.get("in_reg_uss_config_params");
        String set_description = (String) map.get("set_description");
        Long set_type_no = (Long) map.get("set_type_no");
        
        return setRegUssConfigParams(client_no, auth_key, set_name, in_reg_uss_config_params, set_description, set_type_no);
    }
        private Map<String,Object> buildSetRegUssConfigParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_reg_uss_config_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> setRegUssParams(Long client_no, String auth_key, String session_id, com.aria.common.shared.InRegUssParamsArray in_reg_uss_params, Long override_timeout_minutes){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        RestUtilities.addParameterValuesFromArray(parameters, in_reg_uss_params);
        addParameters(parameters,"override_timeout_minutes", getValue("Long", override_timeout_minutes));
        
        return this.buildSetRegUssParamsHashMap(parameters);
    }

    public Map<String,Object> setRegUssParams(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        com.aria.common.shared.InRegUssParamsArray in_reg_uss_params = (com.aria.common.shared.InRegUssParamsArray) map.get("in_reg_uss_params");
        Long override_timeout_minutes = (Long) map.get("override_timeout_minutes");
        
        return setRegUssParams(client_no, auth_key, session_id, in_reg_uss_params, override_timeout_minutes);
    }
        private Map<String,Object> buildSetRegUssParamsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "set_reg_uss_params", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> subscribeEvent(Long client_no, String auth_key, Long event_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"event_id", getValue("Long", event_id));
        
        return this.buildSubscribeEventHashMap(parameters);
    }

    public Map<String,Object> subscribeEvent(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long event_id = (Long) map.get("event_id");
        
        return subscribeEvent(client_no, auth_key, event_id);
    }
        private Map<String,Object> buildSubscribeEventHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "subscribe_event", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> subscribeEventClass(Long client_no, String auth_key, Long class_no, String do_write){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"class_no", getValue("Long", class_no));
        addParameters(parameters,"do_write", getValue("String", do_write));
        
        return this.buildSubscribeEventClassHashMap(parameters);
    }

    public Map<String,Object> subscribeEventClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long class_no = (Long) map.get("class_no");
        String do_write = (String) map.get("do_write");
        
        return subscribeEventClass(client_no, auth_key, class_no, do_write);
    }
        private Map<String,Object> buildSubscribeEventClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "subscribe_event_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "events";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> subscribeEvents(Long client_no, String auth_key, com.aria.common.shared.EventListArray event_list){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, event_list);
        
        return this.buildSubscribeEventsHashMap(parameters);
    }

    public Map<String,Object> subscribeEvents(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.EventListArray event_list = (com.aria.common.shared.EventListArray) map.get("event_list");
        
        return subscribeEvents(client_no, auth_key, event_list);
    }
        private Map<String,Object> buildSubscribeEventsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "subscribe_events", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> unsubscribeEvent(Long client_no, String auth_key, Long event_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"event_id", getValue("Long", event_id));
        
        return this.buildUnsubscribeEventHashMap(parameters);
    }

    public Map<String,Object> unsubscribeEvent(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long event_id = (Long) map.get("event_id");
        
        return unsubscribeEvent(client_no, auth_key, event_id);
    }
        private Map<String,Object> buildUnsubscribeEventHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "unsubscribe_event", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> unsubscribeEventClass(Long client_no, String auth_key, Long class_no, String do_write){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"class_no", getValue("Long", class_no));
        addParameters(parameters,"do_write", getValue("String", do_write));
        
        return this.buildUnsubscribeEventClassHashMap(parameters);
    }

    public Map<String,Object> unsubscribeEventClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long class_no = (Long) map.get("class_no");
        String do_write = (String) map.get("do_write");
        
        return unsubscribeEventClass(client_no, auth_key, class_no, do_write);
    }
        private Map<String,Object> buildUnsubscribeEventClassHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "unsubscribe_event_class", parameters);
        String[] returnValues = new String[3];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "events";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> unsubscribeEvents(Long client_no, String auth_key, com.aria.common.shared.EventListArray event_list){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, event_list);
        
        return this.buildUnsubscribeEventsHashMap(parameters);
    }

    public Map<String,Object> unsubscribeEvents(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.EventListArray event_list = (com.aria.common.shared.EventListArray) map.get("event_list");
        
        return unsubscribeEvents(client_no, auth_key, event_list);
    }
        private Map<String,Object> buildUnsubscribeEventsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "unsubscribe_events", parameters);
        String[] returnValues = new String[2];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    /********************************** END - METHODS IMPLEMENTATION ***********************************************/
}
