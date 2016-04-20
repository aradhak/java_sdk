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
        
        WebResource webResource = client.resource(buildUrl("get_account_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAccountDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountDetails(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getAccountStatusHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_account_status_history"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_status_history";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAccountStatusHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountStatusHistory(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getAccountPlanHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_account_plan_history"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_plan_history";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAccountPlanHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountPlanHistory(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getPaymentDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_payment_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "payment_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPaymentDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getPaymentDetails(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getOrderDetails(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_order_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "order_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getOrderDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getOrderDetails(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getInvoiceInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_invoice_information"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "invoice_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getInvoiceInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getInvoiceInformation(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getTransactionInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_transaction_information"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "transaction_information";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getTransactionInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getTransactionInformation(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getRefundInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_refund_information"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "refund_information";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getRefundInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getRefundInformation(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getCouponHistory(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_coupon_history"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "coupon_history";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCouponHistory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getCouponHistory(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> listTransactionTypes(Long client_no, String auth_key, Long limit, Long offset, String query_string){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"query_string", getValue("String", query_string));
        
        WebResource webResource = client.resource(buildUrl("list_transaction_types"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "map_record";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> listTransactionTypes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        String query_string = (String) map.get("query_string");
        
        return listTransactionTypes(client_no, auth_key, limit, offset, query_string);
    }

    public Map<String,Object> listPaymentMethods(Long client_no, String auth_key, Long limit, Long offset, String query_string){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"query_string", getValue("String", query_string));
        
        WebResource webResource = client.resource(buildUrl("list_payment_methods"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "map_record";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> listPaymentMethods(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        String query_string = (String) map.get("query_string");
        
        return listPaymentMethods(client_no, auth_key, limit, offset, query_string);
    }

    public Map<String,Object> listPaymentProcessors(Long client_no, String auth_key, Long limit, Long offset, String query_string){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        addParameters(parameters,"query_string", getValue("String", query_string));
        
        WebResource webResource = client.resource(buildUrl("list_payment_processors"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "map_record";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> listPaymentProcessors(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        String query_string = (String) map.get("query_string");
        
        return listPaymentProcessors(client_no, auth_key, limit, offset, query_string);
    }

    public Map<String,Object> getAllInvoiceInformation(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_all_invoice_information"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "all_invoice_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAllInvoiceInformation(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAllInvoiceInformation(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getPlanInstanceInformationM(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_plan_instance_information_m"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "plan_instance_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPlanInstanceInformationM(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getPlanInstanceInformationM(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getAccountDetailsM(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_account_details_m"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_details_m";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAccountDetailsM(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountDetailsM(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getCouponHistoryM(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_coupon_history_m"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "coupon_history_m";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCouponHistoryM(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getCouponHistoryM(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getInvoiceInformationM(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_invoice_information_m"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "invoice_details_m";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getInvoiceInformationM(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getInvoiceInformationM(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getAllInvoiceInformationM(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_all_invoice_information_m"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "all_invoice_details_m";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAllInvoiceInformationM(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAllInvoiceInformationM(client_no, auth_key, query_string, limit, offset);
    }

    public Map<String,Object> getAccountPlanHistoryM(Long client_no, String auth_key, String query_string, Long limit, Long offset){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"query_string", getValue("String", query_string));
        addParameters(parameters,"limit", getValue("Long", limit));
        addParameters(parameters,"offset", getValue("Long", offset));
        
        WebResource webResource = client.resource(buildUrl("get_account_plan_history_m"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[5];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "starting_record";
        returnValues[3] = "total_records";
        returnValues[4] = "account_plan_history_m";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getAccountPlanHistoryM(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String query_string = (String) map.get("query_string");
        Long limit = (Long) map.get("limit");
        Long offset = (Long) map.get("offset");
        
        return getAccountPlanHistoryM(client_no, auth_key, query_string, limit, offset);
    }

    /********************************** END - METHODS IMPLEMENTATION ***********************************************/
}
