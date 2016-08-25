package com.aria.sdk.classes;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.aria.common.rest.object.RestUtilities;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * AriaBillingIntegrationRest
 * 
 * Creates an client to the Aria APIs.
 *
 * Instances are threadsafe.
 *
 * Since construction is relatively costly, users should reuse a single instance across calls and across threads.
 *
 * @copyright Aria Systems, Inc
 */
public class AriaBillingIntegrationRest extends BaseAriaBilling implements AriaBillingIntegration {
    final private Client client;
  
    /************** CONSTRUCTOR ************************/
    
    /**
     * Create an Aria API client using the provided Jersey client.
     *
     * @param url the Aria API endpoint URI
     * @param client a Jersey client configured by the caller
     */
    public AriaBillingIntegrationRest(String url, Client client) {
        super(url);
        this.client = client;
    }
    
    /**
     * Create an Aria API client using the provided Jersey client.
     *
     * @param url the Aria API endpoint URI
     */
    public AriaBillingIntegrationRest(String url) {
        this(url, Client.create(new DefaultClientConfig()));
    }
        /**
     * @deprecated use {@link AriaBillingIntegrationRest(String)} or {@link AriaBillingIntegrationRest(String,Client)}
     */
    public AriaBillingIntegrationRest(BaseAriaBillingDTO baseAriaBillingDTO) throws Exception {
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
      return BaseAriaBilling.asLibraryType("Integration");
    }
    
    protected String buildUrl(String restCallMethod) {
        return getURL()+"?output_format=json&rest_call="+restCallMethod;
    }
    
    /********************************** METHODS IMPLEMENTATION ***********************************************/

    public Map<String,Object> getAccountDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetAccountDetailsHashMap(parameters);
    }

    public Map<String,Object> getAccountDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountDetails(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetAccountDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_account_details", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAccountStatusHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetAccountStatusHistoryHashMap(parameters);
    }

    public Map<String,Object> getAccountStatusHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountStatusHistory(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetAccountStatusHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_account_status_history", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_status_history";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAccountPlanHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetAccountPlanHistoryHashMap(parameters);
    }

    public Map<String,Object> getAccountPlanHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountPlanHistory(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetAccountPlanHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_account_plan_history", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_plan_history";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getPaymentDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetPaymentDetailsHashMap(parameters);
    }

    public Map<String,Object> getPaymentDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getPaymentDetails(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetPaymentDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_payment_details", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "payment_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getOrderDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetOrderDetailsHashMap(parameters);
    }

    public Map<String,Object> getOrderDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getOrderDetails(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetOrderDetailsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_order_details", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "order_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getInvoiceInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetInvoiceInformationHashMap(parameters);
    }

    public Map<String,Object> getInvoiceInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getInvoiceInformation(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetInvoiceInformationHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_invoice_information", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "invoice_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getTransactionInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetTransactionInformationHashMap(parameters);
    }

    public Map<String,Object> getTransactionInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getTransactionInformation(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetTransactionInformationHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_transaction_information", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "transaction_information";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getRefundInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetRefundInformationHashMap(parameters);
    }

    public Map<String,Object> getRefundInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getRefundInformation(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetRefundInformationHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_refund_information", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "refund_information";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getCouponHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetCouponHistoryHashMap(parameters);
    }

    public Map<String,Object> getCouponHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getCouponHistory(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetCouponHistoryHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_coupon_history", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "coupon_history";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> listTransactionTypes(Long client_no, String auth_key, Long limit, Long offset, String query_string){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"query_string", getValue("String", query_string));
        
        return this.buildListTransactionTypesHashMap(parameters);
    }

    public Map<String,Object> listTransactionTypes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        String query_string = (String) map.get("query_string");
        
        return listTransactionTypes(client_no, auth_key, limit, offset, query_string);
    }
        private Map<String,Object> buildListTransactionTypesHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "list_transaction_types", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "map_record";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> listPaymentMethods(Long client_no, String auth_key, Long limit, Long offset, String query_string){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"query_string", getValue("String", query_string));
        
        return this.buildListPaymentMethodsHashMap(parameters);
    }

    public Map<String,Object> listPaymentMethods(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        String query_string = (String) map.get("query_string");
        
        return listPaymentMethods(client_no, auth_key, limit, offset, query_string);
    }
        private Map<String,Object> buildListPaymentMethodsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "list_payment_methods", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "map_record";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> listPaymentProcessors(Long client_no, String auth_key, Long limit, Long offset, String query_string){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"query_string", getValue("String", query_string));
        
        return this.buildListPaymentProcessorsHashMap(parameters);
    }

    public Map<String,Object> listPaymentProcessors(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        String query_string = (String) map.get("query_string");
        
        return listPaymentProcessors(client_no, auth_key, limit, offset, query_string);
    }
        private Map<String,Object> buildListPaymentProcessorsHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "list_payment_processors", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "map_record";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    public Map<String,Object> getAllInvoiceInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        return this.buildGetAllInvoiceInformationHashMap(parameters);
    }

    public Map<String,Object> getAllInvoiceInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAllInvoiceInformation(client_no, auth_key, query_string, limit, offset);
    }
        private Map<String,Object> buildGetAllInvoiceInformationHashMap(MultivaluedMap<String, String> parameters) {
        
        String response = this.doPost(client, "get_all_invoice_information", parameters);
        String[] returnValues = new String[5];
        
        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "all_invoice_details";
                
        return buildHashMapReturnValues(response,returnValues);
    }
    
    /********************************** END - METHODS IMPLEMENTATION ***********************************************/
}
