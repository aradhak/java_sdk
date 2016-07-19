package com.aria.sdk.classes;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.aria.common.rest.admin.RestUtilities;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * AriaBillingAdministrationRest
 * 
 * Creates an client to the Aria APIs.
 *
 * Instances are threadsafe.
 *
 * Since construction is relatively costly, users should reuse a single instance across calls and across threads.
 *
 * @copyright Aria Systems, Inc
 */
public class AriaBillingAdministrationRest extends BaseAriaBilling implements AriaBillingAdministration {
    final private Client client;
  
    /************** CONSTRUCTOR ************************/
    
    /**
     * Create an Aria API client using the provided Jersey client.
     *
     * @param url the Aria API endpoint URI
     * @param client a Jersey client configured by the caller
     */
    public AriaBillingAdministrationRest(String url, Client client) {
        super(url);
        this.client = client;
    }
    
    /**
     * Create an Aria API client using the provided Jersey client.
     *
     * @param url the Aria API endpoint URI
     */
    public AriaBillingAdministrationRest(String url) {
        this(url, Client.create(new DefaultClientConfig()));
    }
        /**
     * @deprecated use {@link AriaBillingAdministrationRest(String)} or {@link AriaBillingAdministrationRest(String,Client)}
     */
    public AriaBillingAdministrationRest(BaseAriaBillingDTO baseAriaBillingDTO) throws Exception {
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
      return BaseAriaBilling.asLibraryType("Administration");
    }
    
    protected String buildUrl(String restCallMethod) {
        return getURL()+"?output_format=json&rest_call="+restCallMethod;
    }
    
    /********************************** METHODS IMPLEMENTATION ***********************************************/

    public Map<String,Object> getPromoPlanSets(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_promo_plan_sets"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_plan_set";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPromoPlanSets(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getPromoPlanSets(client_no, auth_key);
    }

    public Map<String,Object> getPromoPlanSetDetails(Long client_no, String auth_key, Long promo_plan_set_no, String client_plan_type_id, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_plan_set_no", getValue("Long", promo_plan_set_no));
        addParameters(parameters,"client_plan_type_id", getValue("String", client_plan_type_id));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_promo_plan_set_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[8];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_plan_set_no";
        returnValues[3] = "promo_plan_set_name";
        returnValues[4] = "promo_plan_set_desc";
        returnValues[5] = "client_plan_type_id";
        returnValues[6] = "plan";
        returnValues[7] = "promo_plan_set_translation_info";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPromoPlanSetDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long promo_plan_set_no = (Long) map.get("promo_plan_set_no");
        String client_plan_type_id = (String) map.get("client_plan_type_id");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getPromoPlanSetDetails(client_no, auth_key, promo_plan_set_no, client_plan_type_id, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createPromoPlanSet(Long client_no, String auth_key, String promo_plan_set_name, String promo_plan_set_desc, String client_plan_type_id, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_plan_set_name", getValue("String", promo_plan_set_name));
        addParameters(parameters,"promo_plan_set_desc", getValue("String", promo_plan_set_desc));
        addParameters(parameters,"client_plan_type_id", getValue("String", client_plan_type_id));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        WebResource webResource = client.resource(buildUrl("create_promo_plan_set"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_plan_set_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createPromoPlanSet(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_plan_set_name = (String) map.get("promo_plan_set_name");
        String promo_plan_set_desc = (String) map.get("promo_plan_set_desc");
        String client_plan_type_id = (String) map.get("client_plan_type_id");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return createPromoPlanSet(client_no, auth_key, promo_plan_set_name, promo_plan_set_desc, client_plan_type_id, plan_no, client_plan_id);
    }

    public Map<String,Object> updatePromoPlanSet(Long client_no, String auth_key, Long promo_plan_set_no, String promo_plan_set_name, String promo_plan_set_desc, String client_plan_type_id, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_plan_set_no", getValue("Long", promo_plan_set_no));
        addParameters(parameters,"promo_plan_set_name", getValue("String", promo_plan_set_name));
        addParameters(parameters,"promo_plan_set_desc", getValue("String", promo_plan_set_desc));
        addParameters(parameters,"client_plan_type_id", getValue("String", client_plan_type_id));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        WebResource webResource = client.resource(buildUrl("update_promo_plan_set"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_plan_set_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updatePromoPlanSet(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long promo_plan_set_no = (Long) map.get("promo_plan_set_no");
        String promo_plan_set_name = (String) map.get("promo_plan_set_name");
        String promo_plan_set_desc = (String) map.get("promo_plan_set_desc");
        String client_plan_type_id = (String) map.get("client_plan_type_id");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return updatePromoPlanSet(client_no, auth_key, promo_plan_set_no, promo_plan_set_name, promo_plan_set_desc, client_plan_type_id, plan_no, client_plan_id);
    }

    public Map<String,Object> listPromoSets(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("list_promo_sets"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_plan_set";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> listPromoSets(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return listPromoSets(client_no, auth_key);
    }

    public Map<String,Object> getCompanyProfile(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_company_profile"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "client";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCompanyProfile(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getCompanyProfile(client_no, auth_key);
    }

    public Map<String,Object> setCompanyProfile(Long client_no, String auth_key, String domain, String address1, String address2, String city, String locality, String state_prov, String country, String postal_code, String phone, String contact, String contact_address1, String contact_address2, String contact_city, String contact_state, String contact_zip, String contact_phone, String contact_email, String billing_contact, String billing_address1, String billing_address2, String billing_city, String billing_state, String billing_zip, String billing_phone, String billing_email, String contact_country, String contact_locality, String billing_country, String billing_locality, String batch_job_alert_contact, String batch_job_alert_email, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"domain", getValue("String", domain));
        addParameters(parameters,"address1", getValue("String", address1));
        addParameters(parameters,"address2", getValue("String", address2));
        addParameters(parameters,"city", getValue("String", city));
        addParameters(parameters,"locality", getValue("String", locality));
        addParameters(parameters,"state_prov", getValue("String", state_prov));
        addParameters(parameters,"country", getValue("String", country));
        addParameters(parameters,"postal_code", getValue("String", postal_code));
        addParameters(parameters,"phone", getValue("String", phone));
        addParameters(parameters,"contact", getValue("String", contact));
        addParameters(parameters,"contact_address1", getValue("String", contact_address1));
        addParameters(parameters,"contact_address2", getValue("String", contact_address2));
        addParameters(parameters,"contact_city", getValue("String", contact_city));
        addParameters(parameters,"contact_state", getValue("String", contact_state));
        addParameters(parameters,"contact_zip", getValue("String", contact_zip));
        addParameters(parameters,"contact_phone", getValue("String", contact_phone));
        addParameters(parameters,"contact_email", getValue("String", contact_email));
        addParameters(parameters,"billing_contact", getValue("String", billing_contact));
        addParameters(parameters,"billing_address1", getValue("String", billing_address1));
        addParameters(parameters,"billing_address2", getValue("String", billing_address2));
        addParameters(parameters,"billing_city", getValue("String", billing_city));
        addParameters(parameters,"billing_state", getValue("String", billing_state));
        addParameters(parameters,"billing_zip", getValue("String", billing_zip));
        addParameters(parameters,"billing_phone", getValue("String", billing_phone));
        addParameters(parameters,"billing_email", getValue("String", billing_email));
        addParameters(parameters,"contact_country", getValue("String", contact_country));
        addParameters(parameters,"contact_locality", getValue("String", contact_locality));
        addParameters(parameters,"billing_country", getValue("String", billing_country));
        addParameters(parameters,"billing_locality", getValue("String", billing_locality));
        addParameters(parameters,"batch_job_alert_contact", getValue("String", batch_job_alert_contact));
        addParameters(parameters,"batch_job_alert_email", getValue("String", batch_job_alert_email));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("set_company_profile"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "client";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> setCompanyProfile(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String domain = (String) map.get("domain");
        String address1 = (String) map.get("address1");
        String address2 = (String) map.get("address2");
        String city = (String) map.get("city");
        String locality = (String) map.get("locality");
        String state_prov = (String) map.get("state_prov");
        String country = (String) map.get("country");
        String postal_code = (String) map.get("postal_code");
        String phone = (String) map.get("phone");
        String contact = (String) map.get("contact");
        String contact_address1 = (String) map.get("contact_address1");
        String contact_address2 = (String) map.get("contact_address2");
        String contact_city = (String) map.get("contact_city");
        String contact_state = (String) map.get("contact_state");
        String contact_zip = (String) map.get("contact_zip");
        String contact_phone = (String) map.get("contact_phone");
        String contact_email = (String) map.get("contact_email");
        String billing_contact = (String) map.get("billing_contact");
        String billing_address1 = (String) map.get("billing_address1");
        String billing_address2 = (String) map.get("billing_address2");
        String billing_city = (String) map.get("billing_city");
        String billing_state = (String) map.get("billing_state");
        String billing_zip = (String) map.get("billing_zip");
        String billing_phone = (String) map.get("billing_phone");
        String billing_email = (String) map.get("billing_email");
        String contact_country = (String) map.get("contact_country");
        String contact_locality = (String) map.get("contact_locality");
        String billing_country = (String) map.get("billing_country");
        String billing_locality = (String) map.get("billing_locality");
        String batch_job_alert_contact = (String) map.get("batch_job_alert_contact");
        String batch_job_alert_email = (String) map.get("batch_job_alert_email");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return setCompanyProfile(client_no, auth_key, domain, address1, address2, city, locality, state_prov, country, postal_code, phone, contact, contact_address1, contact_address2, contact_city, contact_state, contact_zip, contact_phone, contact_email, billing_contact, billing_address1, billing_address2, billing_city, billing_state, billing_zip, billing_phone, billing_email, contact_country, contact_locality, billing_country, billing_locality, batch_job_alert_contact, batch_job_alert_email, locale_no, locale_name);
    }

    public Map<String,Object> getInventoryItems(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_inventory_items"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "inventory_items";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getInventoryItems(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getInventoryItems(client_no, auth_key);
    }

    public Map<String,Object> getInventoryItemDetails(Long client_no, String auth_key, Long item_no, String client_item_id, String currency_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"item_no", getValue("Long", item_no));
        addParameters(parameters,"client_item_id", getValue("String", client_item_id));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        
        WebResource webResource = client.resource(buildUrl("get_inventory_item_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[25];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "item_no";
        returnValues[3] = "client_item_id";
        returnValues[4] = "item_type";
        returnValues[5] = "item_name";
        returnValues[6] = "item_desc";
        returnValues[7] = "active_ind";
        returnValues[8] = "service_no";
        returnValues[9] = "client_service_id";
        returnValues[10] = "invoice_advancement_months";
        returnValues[11] = "plan_no";
        returnValues[12] = "client_plan_id";
        returnValues[13] = "client_sku";
        returnValues[14] = "modify_price_ind";
        returnValues[15] = "subunit_qty";
        returnValues[16] = "subunit_label";
        returnValues[17] = "days_to_expiry";
        returnValues[18] = "resources";
        returnValues[19] = "pricing";
        returnValues[20] = "stock_level";
        returnValues[21] = "image";
        returnValues[22] = "item_class";
        returnValues[23] = "supplemental_obj_fields";
        returnValues[24] = "schedule";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getInventoryItemDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long item_no = (Long) map.get("item_no");
        String client_item_id = (String) map.get("client_item_id");
        String currency_cd = (String) map.get("currency_cd");
        
        return getInventoryItemDetails(client_no, auth_key, item_no, client_item_id, currency_cd);
    }

    public Map<String,Object> createInventoryItem(Long client_no, String auth_key, Long item_type, String item_name, String item_desc, Long service_no, com.aria.common.shared.admin.ServiceArray service, String client_sku, String currency_cd, String item_price, String client_item_id, Long active_ind, String client_service_id, com.aria.common.shared.admin.ScheduleArray schedule, String tax_inclusive_ind, String modify_price_ind, Long subunit_qty, String subunit_label, Long pricing_rule, Long queued_active_ind, String queued_active_date, String do_auto_create_service_credit, Long days_to_expiry, String resource_type_no, String resource_units, Long stock_level_track, Double stock_level_adjust, com.aria.common.shared.admin.ImageArray image, com.aria.common.shared.admin.ParentClassArray parent_class, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"item_type", getValue("Long", item_type));
        addParameters(parameters,"item_name", getValue("String", item_name));
        addParameters(parameters,"item_desc", getValue("String", item_desc));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        RestUtilities.addParameterValuesFromArray(parameters, service, "service");
        addParameters(parameters,"client_sku", getValue("String", client_sku));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"item_price", getValue("String", item_price));
        addParameters(parameters,"client_item_id", getValue("String", client_item_id));
        addParameters(parameters,"active_ind", getValue("Long", active_ind));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        RestUtilities.addParameterValuesFromArray(parameters, schedule, "schedule");
        addParameters(parameters,"tax_inclusive_ind", getValue("String", tax_inclusive_ind));
        addParameters(parameters,"modify_price_ind", getValue("String", modify_price_ind));
        addParameters(parameters,"subunit_qty", getValue("Long", subunit_qty));
        addParameters(parameters,"subunit_label", getValue("String", subunit_label));
        addParameters(parameters,"pricing_rule", getValue("Long", pricing_rule));
        addParameters(parameters,"queued_active_ind", getValue("Long", queued_active_ind));
        addParameters(parameters,"queued_active_date", getValue("String", queued_active_date));
        addParameters(parameters,"do_auto_create_service_credit", getValue("String", do_auto_create_service_credit));
        addParameters(parameters,"days_to_expiry", getValue("Long", days_to_expiry));
        addParameters(parameters,"resource_type_no", getValue("String", resource_type_no));
        addParameters(parameters,"resource_units", getValue("String", resource_units));
        addParameters(parameters,"stock_level_track", getValue("Long", stock_level_track));
        addParameters(parameters,"stock_level_adjust", getValue("Double", stock_level_adjust));
        RestUtilities.addParameterValuesFromArray(parameters, image, "image");
        RestUtilities.addParameterValuesFromArray(parameters, parent_class, "parent_class");
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        
        WebResource webResource = client.resource(buildUrl("create_inventory_item"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "item_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createInventoryItem(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long item_type = (Long) map.get("item_type");
        String item_name = (String) map.get("item_name");
        String item_desc = (String) map.get("item_desc");
        Long service_no = (Long) map.get("service_no");
        com.aria.common.shared.admin.ServiceArray service = (com.aria.common.shared.admin.ServiceArray) map.get("service");
        String client_sku = (String) map.get("client_sku");
        String currency_cd = (String) map.get("currency_cd");
        String item_price = (String) map.get("item_price");
        String client_item_id = (String) map.get("client_item_id");
        Long active_ind = (Long) map.get("active_ind");
        String client_service_id = (String) map.get("client_service_id");
        com.aria.common.shared.admin.ScheduleArray schedule = (com.aria.common.shared.admin.ScheduleArray) map.get("schedule");
        String tax_inclusive_ind = (String) map.get("tax_inclusive_ind");
        String modify_price_ind = (String) map.get("modify_price_ind");
        Long subunit_qty = (Long) map.get("subunit_qty");
        String subunit_label = (String) map.get("subunit_label");
        Long pricing_rule = (Long) map.get("pricing_rule");
        Long queued_active_ind = (Long) map.get("queued_active_ind");
        String queued_active_date = (String) map.get("queued_active_date");
        String do_auto_create_service_credit = (String) map.get("do_auto_create_service_credit");
        Long days_to_expiry = (Long) map.get("days_to_expiry");
        String resource_type_no = (String) map.get("resource_type_no");
        String resource_units = (String) map.get("resource_units");
        Long stock_level_track = (Long) map.get("stock_level_track");
        Double stock_level_adjust = (Double) map.get("stock_level_adjust");
        com.aria.common.shared.admin.ImageArray image = (com.aria.common.shared.admin.ImageArray) map.get("image");
        com.aria.common.shared.admin.ParentClassArray parent_class = (com.aria.common.shared.admin.ParentClassArray) map.get("parent_class");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        
        return createInventoryItem(client_no, auth_key, item_type, item_name, item_desc, service_no, service, client_sku, currency_cd, item_price, client_item_id, active_ind, client_service_id, schedule, tax_inclusive_ind, modify_price_ind, subunit_qty, subunit_label, pricing_rule, queued_active_ind, queued_active_date, do_auto_create_service_credit, days_to_expiry, resource_type_no, resource_units, stock_level_track, stock_level_adjust, image, parent_class, supplemental_obj_field);
    }

    public Map<String,Object> updateInventoryItem(Long client_no, String auth_key, Long item_no, Long item_type, String item_name, String item_desc, String client_item_id, Long service_no, String client_service_id, com.aria.common.shared.admin.ServiceArray service, String client_sku, String currency_cd, String item_price, Long active_ind, com.aria.common.shared.admin.ScheduleArray schedule, String tax_inclusive_ind, String modify_price_ind, Long subunit_qty, String subunit_label, Long pricing_rule, Long queued_active_ind, String queued_active_date, Long do_auto_create_service_credit, Long days_to_expiry, String resource_type_no, String resource_units, Long stock_level_track, Double stock_level_adjust, com.aria.common.shared.admin.ImageArray image, com.aria.common.shared.admin.ParentClassArray parent_class, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, Long edit_directive){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"item_no", getValue("Long", item_no));
        addParameters(parameters,"item_type", getValue("Long", item_type));
        addParameters(parameters,"item_name", getValue("String", item_name));
        addParameters(parameters,"item_desc", getValue("String", item_desc));
        addParameters(parameters,"client_item_id", getValue("String", client_item_id));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        RestUtilities.addParameterValuesFromArray(parameters, service, "service");
        addParameters(parameters,"client_sku", getValue("String", client_sku));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"item_price", getValue("String", item_price));
        addParameters(parameters,"active_ind", getValue("Long", active_ind));
        RestUtilities.addParameterValuesFromArray(parameters, schedule, "schedule");
        addParameters(parameters,"tax_inclusive_ind", getValue("String", tax_inclusive_ind));
        addParameters(parameters,"modify_price_ind", getValue("String", modify_price_ind));
        addParameters(parameters,"subunit_qty", getValue("Long", subunit_qty));
        addParameters(parameters,"subunit_label", getValue("String", subunit_label));
        addParameters(parameters,"pricing_rule", getValue("Long", pricing_rule));
        addParameters(parameters,"queued_active_ind", getValue("Long", queued_active_ind));
        addParameters(parameters,"queued_active_date", getValue("String", queued_active_date));
        addParameters(parameters,"do_auto_create_service_credit", getValue("Long", do_auto_create_service_credit));
        addParameters(parameters,"days_to_expiry", getValue("Long", days_to_expiry));
        addParameters(parameters,"resource_type_no", getValue("String", resource_type_no));
        addParameters(parameters,"resource_units", getValue("String", resource_units));
        addParameters(parameters,"stock_level_track", getValue("Long", stock_level_track));
        addParameters(parameters,"stock_level_adjust", getValue("Double", stock_level_adjust));
        RestUtilities.addParameterValuesFromArray(parameters, image, "image");
        RestUtilities.addParameterValuesFromArray(parameters, parent_class, "parent_class");
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        addParameters(parameters,"edit_directive", getValue("Long", edit_directive));
        
        WebResource webResource = client.resource(buildUrl("update_inventory_item"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "item_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateInventoryItem(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long item_no = (Long) map.get("item_no");
        Long item_type = (Long) map.get("item_type");
        String item_name = (String) map.get("item_name");
        String item_desc = (String) map.get("item_desc");
        String client_item_id = (String) map.get("client_item_id");
        Long service_no = (Long) map.get("service_no");
        String client_service_id = (String) map.get("client_service_id");
        com.aria.common.shared.admin.ServiceArray service = (com.aria.common.shared.admin.ServiceArray) map.get("service");
        String client_sku = (String) map.get("client_sku");
        String currency_cd = (String) map.get("currency_cd");
        String item_price = (String) map.get("item_price");
        Long active_ind = (Long) map.get("active_ind");
        com.aria.common.shared.admin.ScheduleArray schedule = (com.aria.common.shared.admin.ScheduleArray) map.get("schedule");
        String tax_inclusive_ind = (String) map.get("tax_inclusive_ind");
        String modify_price_ind = (String) map.get("modify_price_ind");
        Long subunit_qty = (Long) map.get("subunit_qty");
        String subunit_label = (String) map.get("subunit_label");
        Long pricing_rule = (Long) map.get("pricing_rule");
        Long queued_active_ind = (Long) map.get("queued_active_ind");
        String queued_active_date = (String) map.get("queued_active_date");
        Long do_auto_create_service_credit = (Long) map.get("do_auto_create_service_credit");
        Long days_to_expiry = (Long) map.get("days_to_expiry");
        String resource_type_no = (String) map.get("resource_type_no");
        String resource_units = (String) map.get("resource_units");
        Long stock_level_track = (Long) map.get("stock_level_track");
        Double stock_level_adjust = (Double) map.get("stock_level_adjust");
        com.aria.common.shared.admin.ImageArray image = (com.aria.common.shared.admin.ImageArray) map.get("image");
        com.aria.common.shared.admin.ParentClassArray parent_class = (com.aria.common.shared.admin.ParentClassArray) map.get("parent_class");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        Long edit_directive = (Long) map.get("edit_directive");
        
        return updateInventoryItem(client_no, auth_key, item_no, item_type, item_name, item_desc, client_item_id, service_no, client_service_id, service, client_sku, currency_cd, item_price, active_ind, schedule, tax_inclusive_ind, modify_price_ind, subunit_qty, subunit_label, pricing_rule, queued_active_ind, queued_active_date, do_auto_create_service_credit, days_to_expiry, resource_type_no, resource_units, stock_level_track, stock_level_adjust, image, parent_class, supplemental_obj_field, edit_directive);
    }

    public Map<String,Object> createItemClass(Long client_no, String auth_key, String class_name, String class_desc, Long active_ind, String client_inventory_class_id, com.aria.common.shared.admin.ParentClassArray parent_class){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"class_name", getValue("String", class_name));
        addParameters(parameters,"class_desc", getValue("String", class_desc));
        addParameters(parameters,"active_ind", getValue("Long", active_ind));
        addParameters(parameters,"client_inventory_class_id", getValue("String", client_inventory_class_id));
        RestUtilities.addParameterValuesFromArray(parameters, parent_class, "parent_class");
        
        WebResource webResource = client.resource(buildUrl("create_item_class"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "class_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createItemClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String class_name = (String) map.get("class_name");
        String class_desc = (String) map.get("class_desc");
        Long active_ind = (Long) map.get("active_ind");
        String client_inventory_class_id = (String) map.get("client_inventory_class_id");
        com.aria.common.shared.admin.ParentClassArray parent_class = (com.aria.common.shared.admin.ParentClassArray) map.get("parent_class");
        
        return createItemClass(client_no, auth_key, class_name, class_desc, active_ind, client_inventory_class_id, parent_class);
    }

    public Map<String,Object> editItemClass(Long client_no, String auth_key, String class_no, String class_name, String client_inventory_class_id, String class_desc, Long active_ind, com.aria.common.shared.admin.ParentClassArray parent_class){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"class_no", getValue("String", class_no));
        addParameters(parameters,"class_name", getValue("String", class_name));
        addParameters(parameters,"client_inventory_class_id", getValue("String", client_inventory_class_id));
        addParameters(parameters,"class_desc", getValue("String", class_desc));
        addParameters(parameters,"active_ind", getValue("Long", active_ind));
        RestUtilities.addParameterValuesFromArray(parameters, parent_class, "parent_class");
        
        WebResource webResource = client.resource(buildUrl("edit_item_class"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "class_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> editItemClass(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String class_no = (String) map.get("class_no");
        String class_name = (String) map.get("class_name");
        String client_inventory_class_id = (String) map.get("client_inventory_class_id");
        String class_desc = (String) map.get("class_desc");
        Long active_ind = (Long) map.get("active_ind");
        com.aria.common.shared.admin.ParentClassArray parent_class = (com.aria.common.shared.admin.ParentClassArray) map.get("parent_class");
        
        return editItemClass(client_no, auth_key, class_no, class_name, client_inventory_class_id, class_desc, active_ind, parent_class);
    }

    public Map<String,Object> getServiceTypes(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_service_types"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "service_types";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getServiceTypes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getServiceTypes(client_no, auth_key);
    }

    public Map<String,Object> getServices(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_services"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "services";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getServices(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getServices(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getServiceDetails(Long client_no, String auth_key, Long service_no, String client_service_id, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_service_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[19];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "service_no";
        returnValues[3] = "client_service_id";
        returnValues[4] = "service_name";
        returnValues[5] = "service_type";
        returnValues[6] = "gl_cd";
        returnValues[7] = "taxable_ind";
        returnValues[8] = "tax_group";
        returnValues[9] = "usage_type";
        returnValues[10] = "rev_rec_ind";
        returnValues[11] = "ar_ind";
        returnValues[12] = "ar_gl_cd";
        returnValues[13] = "def_ind";
        returnValues[14] = "def_gl_cd";
        returnValues[15] = "supplemental_obj_fields";
        returnValues[16] = "commodity_cd";
        returnValues[17] = "client_tax_group_id";
        returnValues[18] = "service_translation_info";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getServiceDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long service_no = (Long) map.get("service_no");
        String client_service_id = (String) map.get("client_service_id");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getServiceDetails(client_no, auth_key, service_no, client_service_id, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getPlanServiceDetails(Long client_no, String auth_key, Long service_no, Long plan_no, String client_service_id, String client_plan_id, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_plan_service_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[24];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_no";
        returnValues[3] = "client_plan_id";
        returnValues[4] = "currency_cd";
        returnValues[5] = "service_no";
        returnValues[6] = "service_name";
        returnValues[7] = "service_type";
        returnValues[8] = "client_service_id";
        returnValues[9] = "taxable_ind";
        returnValues[10] = "tax_group";
        returnValues[11] = "client_tax_group_id";
        returnValues[12] = "gl_cd";
        returnValues[13] = "usage_type";
        returnValues[14] = "rate_type";
        returnValues[15] = "rate_schedules";
        returnValues[16] = "parent_plans";
        returnValues[17] = "parent_plan_ids";
        returnValues[18] = "exclusion_plans";
        returnValues[19] = "supplemental_obj_fields";
        returnValues[20] = "commodity_cd";
        returnValues[21] = "fulfillment_based_ind";
        returnValues[22] = "apply_usage_rates_daily";
        returnValues[23] = "service_translation_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPlanServiceDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long service_no = (Long) map.get("service_no");
        Long plan_no = (Long) map.get("plan_no");
        String client_service_id = (String) map.get("client_service_id");
        String client_plan_id = (String) map.get("client_plan_id");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getPlanServiceDetails(client_no, auth_key, service_no, plan_no, client_service_id, client_plan_id, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createService(Long client_no, String auth_key, String service_name, String service_type, String gl_cd, String ar_gl_cd, String def_gl_cd, Long rev_rec_ind, Long deferred_ind, Long taxable_ind, Long tax_group, Long usage_type, String client_service_id, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, String commodity_cd, String client_tax_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"service_name", getValue("String", service_name));
        addParameters(parameters,"service_type", getValue("String", service_type));
        addParameters(parameters,"gl_cd", getValue("String", gl_cd));
        addParameters(parameters,"ar_gl_cd", getValue("String", ar_gl_cd));
        addParameters(parameters,"def_gl_cd", getValue("String", def_gl_cd));
        addParameters(parameters,"rev_rec_ind", getValue("Long", rev_rec_ind));
        addParameters(parameters,"deferred_ind", getValue("Long", deferred_ind));
        addParameters(parameters,"taxable_ind", getValue("Long", taxable_ind));
        addParameters(parameters,"tax_group", getValue("Long", tax_group));
        addParameters(parameters,"usage_type", getValue("Long", usage_type));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        addParameters(parameters,"commodity_cd", getValue("String", commodity_cd));
        addParameters(parameters,"client_tax_group_id", getValue("String", client_tax_group_id));
        
        WebResource webResource = client.resource(buildUrl("create_service"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "service_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createService(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String service_name = (String) map.get("service_name");
        String service_type = (String) map.get("service_type");
        String gl_cd = (String) map.get("gl_cd");
        String ar_gl_cd = (String) map.get("ar_gl_cd");
        String def_gl_cd = (String) map.get("def_gl_cd");
        Long rev_rec_ind = (Long) map.get("rev_rec_ind");
        Long deferred_ind = (Long) map.get("deferred_ind");
        Long taxable_ind = (Long) map.get("taxable_ind");
        Long tax_group = (Long) map.get("tax_group");
        Long usage_type = (Long) map.get("usage_type");
        String client_service_id = (String) map.get("client_service_id");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        String commodity_cd = (String) map.get("commodity_cd");
        String client_tax_group_id = (String) map.get("client_tax_group_id");
        
        return createService(client_no, auth_key, service_name, service_type, gl_cd, ar_gl_cd, def_gl_cd, rev_rec_ind, deferred_ind, taxable_ind, tax_group, usage_type, client_service_id, supplemental_obj_field, commodity_cd, client_tax_group_id);
    }

    public Map<String,Object> updateService(Long client_no, String auth_key, Long service_no, String service_name, String service_type, String gl_cd, String ar_gl_cd, String def_gl_cd, Long rev_rec_ind, Long deferred_ind, Long taxable_ind, Long tax_group, Long usage_type, String client_service_id, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, String commodity_cd, String client_tax_group_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"service_no", getValue("Long", service_no));
        addParameters(parameters,"service_name", getValue("String", service_name));
        addParameters(parameters,"service_type", getValue("String", service_type));
        addParameters(parameters,"gl_cd", getValue("String", gl_cd));
        addParameters(parameters,"ar_gl_cd", getValue("String", ar_gl_cd));
        addParameters(parameters,"def_gl_cd", getValue("String", def_gl_cd));
        addParameters(parameters,"rev_rec_ind", getValue("Long", rev_rec_ind));
        addParameters(parameters,"deferred_ind", getValue("Long", deferred_ind));
        addParameters(parameters,"taxable_ind", getValue("Long", taxable_ind));
        addParameters(parameters,"tax_group", getValue("Long", tax_group));
        addParameters(parameters,"usage_type", getValue("Long", usage_type));
        addParameters(parameters,"client_service_id", getValue("String", client_service_id));
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        addParameters(parameters,"commodity_cd", getValue("String", commodity_cd));
        addParameters(parameters,"client_tax_group_id", getValue("String", client_tax_group_id));
        
        WebResource webResource = client.resource(buildUrl("update_service"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "service_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateService(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long service_no = (Long) map.get("service_no");
        String service_name = (String) map.get("service_name");
        String service_type = (String) map.get("service_type");
        String gl_cd = (String) map.get("gl_cd");
        String ar_gl_cd = (String) map.get("ar_gl_cd");
        String def_gl_cd = (String) map.get("def_gl_cd");
        Long rev_rec_ind = (Long) map.get("rev_rec_ind");
        Long deferred_ind = (Long) map.get("deferred_ind");
        Long taxable_ind = (Long) map.get("taxable_ind");
        Long tax_group = (Long) map.get("tax_group");
        Long usage_type = (Long) map.get("usage_type");
        String client_service_id = (String) map.get("client_service_id");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        String commodity_cd = (String) map.get("commodity_cd");
        String client_tax_group_id = (String) map.get("client_tax_group_id");
        
        return updateService(client_no, auth_key, service_no, service_name, service_type, gl_cd, ar_gl_cd, def_gl_cd, rev_rec_ind, deferred_ind, taxable_ind, tax_group, usage_type, client_service_id, supplemental_obj_field, commodity_cd, client_tax_group_id);
    }

    public Map<String,Object> getSuppFields(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_supp_fields"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "supp_fields";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getSuppFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getSuppFields(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getSuppFieldDetails(Long client_no, String auth_key, String field_name, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_name", getValue("String", field_name));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_supp_field_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[14];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_name";
        returnValues[3] = "field_desc";
        returnValues[4] = "field_order";
        returnValues[5] = "hidden_ind";
        returnValues[6] = "required_ind";
        returnValues[7] = "sel_ind";
        returnValues[8] = "presentation_mode";
        returnValues[9] = "min_no_sel";
        returnValues[10] = "max_no_sel";
        returnValues[11] = "additional_html";
        returnValues[12] = "extra_validation_methods";
        returnValues[13] = "sel_options";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getSuppFieldDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String field_name = (String) map.get("field_name");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getSuppFieldDetails(client_no, auth_key, field_name, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createSuppField(Long client_no, String auth_key, String field_name, Long field_order, String presentation_mode, String field_desc, Long required_ind, Long hidden_ind, Long sel_ind, Long min_no_sel, Long max_no_sel, String display_text, String option_value, Long option_value_order){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_name", getValue("String", field_name));
        addParameters(parameters,"field_order", getValue("Long", field_order));
        addParameters(parameters,"presentation_mode", getValue("String", presentation_mode));
        addParameters(parameters,"field_desc", getValue("String", field_desc));
        addParameters(parameters,"required_ind", getValue("Long", required_ind));
        addParameters(parameters,"hidden_ind", getValue("Long", hidden_ind));
        addParameters(parameters,"sel_ind", getValue("Long", sel_ind));
        addParameters(parameters,"min_no_sel", getValue("Long", min_no_sel));
        addParameters(parameters,"max_no_sel", getValue("Long", max_no_sel));
        addParameters(parameters,"display_text", getValue("String", display_text));
        addParameters(parameters,"option_value", getValue("String", option_value));
        addParameters(parameters,"option_value_order", getValue("Long", option_value_order));
        
        WebResource webResource = client.resource(buildUrl("create_supp_field"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_name";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createSuppField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String field_name = (String) map.get("field_name");
        Long field_order = (Long) map.get("field_order");
        String presentation_mode = (String) map.get("presentation_mode");
        String field_desc = (String) map.get("field_desc");
        Long required_ind = (Long) map.get("required_ind");
        Long hidden_ind = (Long) map.get("hidden_ind");
        Long sel_ind = (Long) map.get("sel_ind");
        Long min_no_sel = (Long) map.get("min_no_sel");
        Long max_no_sel = (Long) map.get("max_no_sel");
        String display_text = (String) map.get("display_text");
        String option_value = (String) map.get("option_value");
        Long option_value_order = (Long) map.get("option_value_order");
        
        return createSuppField(client_no, auth_key, field_name, field_order, presentation_mode, field_desc, required_ind, hidden_ind, sel_ind, min_no_sel, max_no_sel, display_text, option_value, option_value_order);
    }

    public Map<String,Object> updateSuppField(Long client_no, String auth_key, String field_name, String field_desc, Long field_order, Long required_ind, Long hidden_ind, Long sel_ind, String presentation_mode, Long min_no_sel, Long max_no_sel, String display_text, String option_value, Long option_value_order, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_name", getValue("String", field_name));
        addParameters(parameters,"field_desc", getValue("String", field_desc));
        addParameters(parameters,"field_order", getValue("Long", field_order));
        addParameters(parameters,"required_ind", getValue("Long", required_ind));
        addParameters(parameters,"hidden_ind", getValue("Long", hidden_ind));
        addParameters(parameters,"sel_ind", getValue("Long", sel_ind));
        addParameters(parameters,"presentation_mode", getValue("String", presentation_mode));
        addParameters(parameters,"min_no_sel", getValue("Long", min_no_sel));
        addParameters(parameters,"max_no_sel", getValue("Long", max_no_sel));
        addParameters(parameters,"display_text", getValue("String", display_text));
        addParameters(parameters,"option_value", getValue("String", option_value));
        addParameters(parameters,"option_value_order", getValue("Long", option_value_order));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("update_supp_field"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_name";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateSuppField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String field_name = (String) map.get("field_name");
        String field_desc = (String) map.get("field_desc");
        Long field_order = (Long) map.get("field_order");
        Long required_ind = (Long) map.get("required_ind");
        Long hidden_ind = (Long) map.get("hidden_ind");
        Long sel_ind = (Long) map.get("sel_ind");
        String presentation_mode = (String) map.get("presentation_mode");
        Long min_no_sel = (Long) map.get("min_no_sel");
        Long max_no_sel = (Long) map.get("max_no_sel");
        String display_text = (String) map.get("display_text");
        String option_value = (String) map.get("option_value");
        Long option_value_order = (Long) map.get("option_value_order");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return updateSuppField(client_no, auth_key, field_name, field_desc, field_order, required_ind, hidden_ind, sel_ind, presentation_mode, min_no_sel, max_no_sel, display_text, option_value, option_value_order, locale_no, locale_name);
    }

    public Map<String,Object> getCoupons(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_coupons"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupons";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCoupons(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getCoupons(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getCouponDetails(Long client_no, String auth_key, String coupon_cd, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_coupon_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[36];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupon_cd";
        returnValues[3] = "coupon_desc";
        returnValues[4] = "coupon_msg";
        returnValues[5] = "status_ind";
        returnValues[6] = "no_of_uses";
        returnValues[7] = "start_date";
        returnValues[8] = "end_date";
        returnValues[9] = "credit_template_id";
        returnValues[10] = "credit_template_name";
        returnValues[11] = "eligible_plan_no";
        returnValues[12] = "eligible_client_plan_id";
        returnValues[13] = "eligible_service_no";
        returnValues[14] = "eligible_client_service_id";
        returnValues[15] = "no_of_credits";
        returnValues[16] = "time_between_credits";
        returnValues[17] = "discount_type";
        returnValues[18] = "discount_amt";
        returnValues[19] = "percentage_plan_no";
        returnValues[20] = "percentage_client_plan_id";
        returnValues[21] = "percentage_service_no";
        returnValues[22] = "percentage_client_service_id";
        returnValues[23] = "alt_service_no";
        returnValues[24] = "alt_client_service_id";
        returnValues[25] = "eligible_service_types";
        returnValues[26] = "credit_template";
        returnValues[27] = "discount_rule";
        returnValues[28] = "discount_bundle";
        returnValues[29] = "group_no";
        returnValues[30] = "client_group_id";
        returnValues[31] = "group_name";
        returnValues[32] = "group_description";
        returnValues[33] = "precedence";
        returnValues[34] = "coupon_scope";
        returnValues[35] = "coupon_translation_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCouponDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String coupon_cd = (String) map.get("coupon_cd");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getCouponDetails(client_no, auth_key, coupon_cd, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createCoupon(Long client_no, String auth_key, String coupon_cd, String coupon_desc, String coupon_msg, Long status_ind, Long no_of_uses, String start_date, String end_date, com.aria.common.shared.admin.TemplateArray template, com.aria.common.shared.admin.ExistingTemplateArray existing_template, com.aria.common.shared.admin.ExistingTemplateIdArray existing_template_id, com.aria.common.shared.admin.DiscountRuleArray discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleArray existing_discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleIdArray existing_discount_rule_id, com.aria.common.shared.admin.DiscountBundleArray discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleArray existing_discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleIdArray existing_discount_bundle_id, Long coupon_scope){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        addParameters(parameters,"coupon_desc", getValue("String", coupon_desc));
        addParameters(parameters,"coupon_msg", getValue("String", coupon_msg));
        addParameters(parameters,"status_ind", getValue("Long", status_ind));
        addParameters(parameters,"no_of_uses", getValue("Long", no_of_uses));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        RestUtilities.addParameterValuesFromArray(parameters, template, "template");
        RestUtilities.addParameterValuesFromArray(parameters, existing_template, "existing_template");
        RestUtilities.addParameterValuesFromArray(parameters, existing_template_id, "existing_template_id");
        RestUtilities.addParameterValuesFromArray(parameters, discount_rule, "discount_rule");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_rule, "existing_discount_rule");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_rule_id, "existing_discount_rule_id");
        RestUtilities.addParameterValuesFromArray(parameters, discount_bundle, "discount_bundle");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_bundle, "existing_discount_bundle");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_bundle_id, "existing_discount_bundle_id");
        addParameters(parameters,"coupon_scope", getValue("Long", coupon_scope));
        
        WebResource webResource = client.resource(buildUrl("create_coupon"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupon_cd";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createCoupon(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String coupon_cd = (String) map.get("coupon_cd");
        String coupon_desc = (String) map.get("coupon_desc");
        String coupon_msg = (String) map.get("coupon_msg");
        Long status_ind = (Long) map.get("status_ind");
        Long no_of_uses = (Long) map.get("no_of_uses");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        com.aria.common.shared.admin.TemplateArray template = (com.aria.common.shared.admin.TemplateArray) map.get("template");
        com.aria.common.shared.admin.ExistingTemplateArray existing_template = (com.aria.common.shared.admin.ExistingTemplateArray) map.get("existing_template");
        com.aria.common.shared.admin.ExistingTemplateIdArray existing_template_id = (com.aria.common.shared.admin.ExistingTemplateIdArray) map.get("existing_template_id");
        com.aria.common.shared.admin.DiscountRuleArray discount_rule = (com.aria.common.shared.admin.DiscountRuleArray) map.get("discount_rule");
        com.aria.common.shared.admin.ExistingDiscountRuleArray existing_discount_rule = (com.aria.common.shared.admin.ExistingDiscountRuleArray) map.get("existing_discount_rule");
        com.aria.common.shared.admin.ExistingDiscountRuleIdArray existing_discount_rule_id = (com.aria.common.shared.admin.ExistingDiscountRuleIdArray) map.get("existing_discount_rule_id");
        com.aria.common.shared.admin.DiscountBundleArray discount_bundle = (com.aria.common.shared.admin.DiscountBundleArray) map.get("discount_bundle");
        com.aria.common.shared.admin.ExistingDiscountBundleArray existing_discount_bundle = (com.aria.common.shared.admin.ExistingDiscountBundleArray) map.get("existing_discount_bundle");
        com.aria.common.shared.admin.ExistingDiscountBundleIdArray existing_discount_bundle_id = (com.aria.common.shared.admin.ExistingDiscountBundleIdArray) map.get("existing_discount_bundle_id");
        Long coupon_scope = (Long) map.get("coupon_scope");
        
        return createCoupon(client_no, auth_key, coupon_cd, coupon_desc, coupon_msg, status_ind, no_of_uses, start_date, end_date, template, existing_template, existing_template_id, discount_rule, existing_discount_rule, existing_discount_rule_id, discount_bundle, existing_discount_bundle, existing_discount_bundle_id, coupon_scope);
    }

    public Map<String,Object> updateCoupon(Long client_no, String auth_key, String coupon_cd, String coupon_desc, String coupon_msg, Long status_ind, Long no_of_uses, String start_date, String end_date, com.aria.common.shared.admin.TemplateArray template, com.aria.common.shared.admin.ExistingTemplateArray existing_template, com.aria.common.shared.admin.ExistingTemplateIdArray existing_template_id, com.aria.common.shared.admin.DiscountRuleArray discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleArray existing_discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleIdArray existing_discount_rule_id, com.aria.common.shared.admin.DiscountBundleArray discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleArray existing_discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleIdArray existing_discount_bundle_id, Long coupon_scope, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"coupon_cd", getValue("String", coupon_cd));
        addParameters(parameters,"coupon_desc", getValue("String", coupon_desc));
        addParameters(parameters,"coupon_msg", getValue("String", coupon_msg));
        addParameters(parameters,"status_ind", getValue("Long", status_ind));
        addParameters(parameters,"no_of_uses", getValue("Long", no_of_uses));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"end_date", getValue("String", end_date));
        RestUtilities.addParameterValuesFromArray(parameters, template, "template");
        RestUtilities.addParameterValuesFromArray(parameters, existing_template, "existing_template");
        RestUtilities.addParameterValuesFromArray(parameters, existing_template_id, "existing_template_id");
        RestUtilities.addParameterValuesFromArray(parameters, discount_rule, "discount_rule");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_rule, "existing_discount_rule");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_rule_id, "existing_discount_rule_id");
        RestUtilities.addParameterValuesFromArray(parameters, discount_bundle, "discount_bundle");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_bundle, "existing_discount_bundle");
        RestUtilities.addParameterValuesFromArray(parameters, existing_discount_bundle_id, "existing_discount_bundle_id");
        addParameters(parameters,"coupon_scope", getValue("Long", coupon_scope));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("update_coupon"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupon_cd";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateCoupon(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String coupon_cd = (String) map.get("coupon_cd");
        String coupon_desc = (String) map.get("coupon_desc");
        String coupon_msg = (String) map.get("coupon_msg");
        Long status_ind = (Long) map.get("status_ind");
        Long no_of_uses = (Long) map.get("no_of_uses");
        String start_date = (String) map.get("start_date");
        String end_date = (String) map.get("end_date");
        com.aria.common.shared.admin.TemplateArray template = (com.aria.common.shared.admin.TemplateArray) map.get("template");
        com.aria.common.shared.admin.ExistingTemplateArray existing_template = (com.aria.common.shared.admin.ExistingTemplateArray) map.get("existing_template");
        com.aria.common.shared.admin.ExistingTemplateIdArray existing_template_id = (com.aria.common.shared.admin.ExistingTemplateIdArray) map.get("existing_template_id");
        com.aria.common.shared.admin.DiscountRuleArray discount_rule = (com.aria.common.shared.admin.DiscountRuleArray) map.get("discount_rule");
        com.aria.common.shared.admin.ExistingDiscountRuleArray existing_discount_rule = (com.aria.common.shared.admin.ExistingDiscountRuleArray) map.get("existing_discount_rule");
        com.aria.common.shared.admin.ExistingDiscountRuleIdArray existing_discount_rule_id = (com.aria.common.shared.admin.ExistingDiscountRuleIdArray) map.get("existing_discount_rule_id");
        com.aria.common.shared.admin.DiscountBundleArray discount_bundle = (com.aria.common.shared.admin.DiscountBundleArray) map.get("discount_bundle");
        com.aria.common.shared.admin.ExistingDiscountBundleArray existing_discount_bundle = (com.aria.common.shared.admin.ExistingDiscountBundleArray) map.get("existing_discount_bundle");
        com.aria.common.shared.admin.ExistingDiscountBundleIdArray existing_discount_bundle_id = (com.aria.common.shared.admin.ExistingDiscountBundleIdArray) map.get("existing_discount_bundle_id");
        Long coupon_scope = (Long) map.get("coupon_scope");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return updateCoupon(client_no, auth_key, coupon_cd, coupon_desc, coupon_msg, status_ind, no_of_uses, start_date, end_date, template, existing_template, existing_template_id, discount_rule, existing_discount_rule, existing_discount_rule_id, discount_bundle, existing_discount_bundle, existing_discount_bundle_id, coupon_scope, locale_no, locale_name);
    }

    public Map<String,Object> deleteCoupons(Long client_no, String auth_key, com.aria.common.shared.admin.CouponNosArray coupon_nos){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, coupon_nos, "coupon_nos");
        
        WebResource webResource = client.resource(buildUrl("delete_coupons"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupons";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteCoupons(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.CouponNosArray coupon_nos = (com.aria.common.shared.admin.CouponNosArray) map.get("coupon_nos");
        
        return deleteCoupons(client_no, auth_key, coupon_nos);
    }

    public Map<String,Object> getRecurringCreditTemplates(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_recurring_credit_templates"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "credit_templates";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getRecurringCreditTemplates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getRecurringCreditTemplates(client_no, auth_key);
    }

    public Map<String,Object> getRecurringCreditTemplateDetails(Long client_no, String auth_key, Long credit_template_no, String client_credit_template_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"credit_template_no", getValue("Long", credit_template_no));
        addParameters(parameters,"client_credit_template_id", getValue("String", client_credit_template_id));
        
        WebResource webResource = client.resource(buildUrl("get_recurring_credit_template_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[21];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "credit_template_id";
        returnValues[3] = "client_credit_template_id";
        returnValues[4] = "credit_template_name";
        returnValues[5] = "eligible_plan_no";
        returnValues[6] = "eligible_client_plan_id";
        returnValues[7] = "eligible_service_no";
        returnValues[8] = "eligible_client_service_id";
        returnValues[9] = "no_of_credits";
        returnValues[10] = "time_between_credits";
        returnValues[11] = "discount_type";
        returnValues[12] = "discount_amt";
        returnValues[13] = "percentage_plan_no";
        returnValues[14] = "percentage_client_plan_id";
        returnValues[15] = "percentage_service_no";
        returnValues[16] = "percentage_client_service_id";
        returnValues[17] = "alt_service_no";
        returnValues[18] = "alt_client_service_id";
        returnValues[19] = "eligible_service_types";
        returnValues[20] = "coupons";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getRecurringCreditTemplateDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long credit_template_no = (Long) map.get("credit_template_no");
        String client_credit_template_id = (String) map.get("client_credit_template_id");
        
        return getRecurringCreditTemplateDetails(client_no, auth_key, credit_template_no, client_credit_template_id);
    }

    public Map<String,Object> createCreditTemplate(Long client_no, String auth_key, String credit_template_name, Long discount_type, Double discount_amt, Long eligible_plan_no, String eligible_client_plan_id, Long eligible_service_no, String eligible_client_service_id, com.aria.common.shared.admin.EligibleServiceTypesArray eligible_service_types, Long no_of_credits, Long credit_interval_months, Long percentage_plan_no, String percentage_client_plan_id, Long percentage_service_no, String percentage_client_service_id, Long alt_service_no, String alt_client_service_id, String client_credit_template_id, String currency_cd, com.aria.common.shared.admin.CouponArray coupon, com.aria.common.shared.admin.ExistingCouponArray existing_coupon){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"credit_template_name", getValue("String", credit_template_name));
        addParameters(parameters,"discount_type", getValue("Long", discount_type));
        addParameters(parameters,"discount_amt", getValue("Double", discount_amt));
        addParameters(parameters,"eligible_plan_no", getValue("Long", eligible_plan_no));
        addParameters(parameters,"eligible_client_plan_id", getValue("String", eligible_client_plan_id));
        addParameters(parameters,"eligible_service_no", getValue("Long", eligible_service_no));
        addParameters(parameters,"eligible_client_service_id", getValue("String", eligible_client_service_id));
        RestUtilities.addParameterValuesFromArray(parameters, eligible_service_types, "eligible_service_types");
        addParameters(parameters,"no_of_credits", getValue("Long", no_of_credits));
        addParameters(parameters,"credit_interval_months", getValue("Long", credit_interval_months));
        addParameters(parameters,"percentage_plan_no", getValue("Long", percentage_plan_no));
        addParameters(parameters,"percentage_client_plan_id", getValue("String", percentage_client_plan_id));
        addParameters(parameters,"percentage_service_no", getValue("Long", percentage_service_no));
        addParameters(parameters,"percentage_client_service_id", getValue("String", percentage_client_service_id));
        addParameters(parameters,"alt_service_no", getValue("Long", alt_service_no));
        addParameters(parameters,"alt_client_service_id", getValue("String", alt_client_service_id));
        addParameters(parameters,"client_credit_template_id", getValue("String", client_credit_template_id));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        RestUtilities.addParameterValuesFromArray(parameters, coupon, "coupon");
        RestUtilities.addParameterValuesFromArray(parameters, existing_coupon, "existing_coupon");
        
        WebResource webResource = client.resource(buildUrl("create_credit_template"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "credit_template_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createCreditTemplate(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String credit_template_name = (String) map.get("credit_template_name");
        Long discount_type = (Long) map.get("discount_type");
        Double discount_amt = (Double) map.get("discount_amt");
        Long eligible_plan_no = (Long) map.get("eligible_plan_no");
        String eligible_client_plan_id = (String) map.get("eligible_client_plan_id");
        Long eligible_service_no = (Long) map.get("eligible_service_no");
        String eligible_client_service_id = (String) map.get("eligible_client_service_id");
        com.aria.common.shared.admin.EligibleServiceTypesArray eligible_service_types = (com.aria.common.shared.admin.EligibleServiceTypesArray) map.get("eligible_service_types");
        Long no_of_credits = (Long) map.get("no_of_credits");
        Long credit_interval_months = (Long) map.get("credit_interval_months");
        Long percentage_plan_no = (Long) map.get("percentage_plan_no");
        String percentage_client_plan_id = (String) map.get("percentage_client_plan_id");
        Long percentage_service_no = (Long) map.get("percentage_service_no");
        String percentage_client_service_id = (String) map.get("percentage_client_service_id");
        Long alt_service_no = (Long) map.get("alt_service_no");
        String alt_client_service_id = (String) map.get("alt_client_service_id");
        String client_credit_template_id = (String) map.get("client_credit_template_id");
        String currency_cd = (String) map.get("currency_cd");
        com.aria.common.shared.admin.CouponArray coupon = (com.aria.common.shared.admin.CouponArray) map.get("coupon");
        com.aria.common.shared.admin.ExistingCouponArray existing_coupon = (com.aria.common.shared.admin.ExistingCouponArray) map.get("existing_coupon");
        
        return createCreditTemplate(client_no, auth_key, credit_template_name, discount_type, discount_amt, eligible_plan_no, eligible_client_plan_id, eligible_service_no, eligible_client_service_id, eligible_service_types, no_of_credits, credit_interval_months, percentage_plan_no, percentage_client_plan_id, percentage_service_no, percentage_client_service_id, alt_service_no, alt_client_service_id, client_credit_template_id, currency_cd, coupon, existing_coupon);
    }

    public Map<String,Object> updateCreditTemplate(Long client_no, String auth_key, String credit_template_no, String credit_template_name, Double discount_amt, String client_credit_template_id, Long eligible_plan_no, String eligible_client_plan_id, Long eligible_service_no, String eligible_client_service_id, com.aria.common.shared.admin.EligibleServiceTypesArray eligible_service_types, Long discount_type, Long no_of_credits, Long credit_interval_months, Long percentage_plan_no, String percentage_client_plan_id, Long percentage_service_no, String percentage_client_service_id, Long alt_service_no, String alt_client_service_id, String currency_cd, com.aria.common.shared.admin.CouponArray coupon, com.aria.common.shared.admin.ExistingCouponArray existing_coupon){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"credit_template_no", getValue("String", credit_template_no));
        addParameters(parameters,"credit_template_name", getValue("String", credit_template_name));
        addParameters(parameters,"discount_amt", getValue("Double", discount_amt));
        addParameters(parameters,"client_credit_template_id", getValue("String", client_credit_template_id));
        addParameters(parameters,"eligible_plan_no", getValue("Long", eligible_plan_no));
        addParameters(parameters,"eligible_client_plan_id", getValue("String", eligible_client_plan_id));
        addParameters(parameters,"eligible_service_no", getValue("Long", eligible_service_no));
        addParameters(parameters,"eligible_client_service_id", getValue("String", eligible_client_service_id));
        RestUtilities.addParameterValuesFromArray(parameters, eligible_service_types, "eligible_service_types");
        addParameters(parameters,"discount_type", getValue("Long", discount_type));
        addParameters(parameters,"no_of_credits", getValue("Long", no_of_credits));
        addParameters(parameters,"credit_interval_months", getValue("Long", credit_interval_months));
        addParameters(parameters,"percentage_plan_no", getValue("Long", percentage_plan_no));
        addParameters(parameters,"percentage_client_plan_id", getValue("String", percentage_client_plan_id));
        addParameters(parameters,"percentage_service_no", getValue("Long", percentage_service_no));
        addParameters(parameters,"percentage_client_service_id", getValue("String", percentage_client_service_id));
        addParameters(parameters,"alt_service_no", getValue("Long", alt_service_no));
        addParameters(parameters,"alt_client_service_id", getValue("String", alt_client_service_id));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        RestUtilities.addParameterValuesFromArray(parameters, coupon, "coupon");
        RestUtilities.addParameterValuesFromArray(parameters, existing_coupon, "existing_coupon");
        
        WebResource webResource = client.resource(buildUrl("update_credit_template"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "credit_template_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateCreditTemplate(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String credit_template_no = (String) map.get("credit_template_no");
        String credit_template_name = (String) map.get("credit_template_name");
        Double discount_amt = (Double) map.get("discount_amt");
        String client_credit_template_id = (String) map.get("client_credit_template_id");
        Long eligible_plan_no = (Long) map.get("eligible_plan_no");
        String eligible_client_plan_id = (String) map.get("eligible_client_plan_id");
        Long eligible_service_no = (Long) map.get("eligible_service_no");
        String eligible_client_service_id = (String) map.get("eligible_client_service_id");
        com.aria.common.shared.admin.EligibleServiceTypesArray eligible_service_types = (com.aria.common.shared.admin.EligibleServiceTypesArray) map.get("eligible_service_types");
        Long discount_type = (Long) map.get("discount_type");
        Long no_of_credits = (Long) map.get("no_of_credits");
        Long credit_interval_months = (Long) map.get("credit_interval_months");
        Long percentage_plan_no = (Long) map.get("percentage_plan_no");
        String percentage_client_plan_id = (String) map.get("percentage_client_plan_id");
        Long percentage_service_no = (Long) map.get("percentage_service_no");
        String percentage_client_service_id = (String) map.get("percentage_client_service_id");
        Long alt_service_no = (Long) map.get("alt_service_no");
        String alt_client_service_id = (String) map.get("alt_client_service_id");
        String currency_cd = (String) map.get("currency_cd");
        com.aria.common.shared.admin.CouponArray coupon = (com.aria.common.shared.admin.CouponArray) map.get("coupon");
        com.aria.common.shared.admin.ExistingCouponArray existing_coupon = (com.aria.common.shared.admin.ExistingCouponArray) map.get("existing_coupon");
        
        return updateCreditTemplate(client_no, auth_key, credit_template_no, credit_template_name, discount_amt, client_credit_template_id, eligible_plan_no, eligible_client_plan_id, eligible_service_no, eligible_client_service_id, eligible_service_types, discount_type, no_of_credits, credit_interval_months, percentage_plan_no, percentage_client_plan_id, percentage_service_no, percentage_client_service_id, alt_service_no, alt_client_service_id, currency_cd, coupon, existing_coupon);
    }

    public Map<String,Object> deleteTemplates(Long client_no, String auth_key, com.aria.common.shared.admin.TemplateNosArray template_nos){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, template_nos, "template_nos");
        
        WebResource webResource = client.resource(buildUrl("delete_templates"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteTemplates(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.TemplateNosArray template_nos = (com.aria.common.shared.admin.TemplateNosArray) map.get("template_nos");
        
        return deleteTemplates(client_no, auth_key, template_nos);
    }

    public Map<String,Object> createDiscountRule(Long client_no, String auth_key, String label, String rule_id, String description, String ext_description, String flat_percent_ind, Double amount, String currency, String duration_type_ind, String inline_offset_ind, String discount_behavior_type_ind, Long service_code_to_use, Long scope_no, Long max_applicable_months, Long max_applications_per_acct, Long alt_service_no_2_apply, String alt_service_id_2_apply, String applicable_trans_scope, com.aria.common.shared.admin.PlanNoArray plan_no, com.aria.common.shared.admin.ClientPlanIdArray client_plan_id, com.aria.common.shared.admin.ServiceNoArray service_no, com.aria.common.shared.admin.ClientServiceIdArray client_service_id, com.aria.common.shared.admin.ItemNoArray item_no, com.aria.common.shared.admin.ClientItemIdArray client_item_id, String use_all_or_nth_subs_rule){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"label", getValue("String", label));
        addParameters(parameters,"rule_id", getValue("String", rule_id));
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"ext_description", getValue("String", ext_description));
        addParameters(parameters,"flat_percent_ind", getValue("String", flat_percent_ind));
        addParameters(parameters,"amount", getValue("Double", amount));
        addParameters(parameters,"currency", getValue("String", currency));
        addParameters(parameters,"duration_type_ind", getValue("String", duration_type_ind));
        addParameters(parameters,"inline_offset_ind", getValue("String", inline_offset_ind));
        addParameters(parameters,"discount_behavior_type_ind", getValue("String", discount_behavior_type_ind));
        addParameters(parameters,"service_code_to_use", getValue("Long", service_code_to_use));
        addParameters(parameters,"scope_no", getValue("Long", scope_no));
        addParameters(parameters,"max_applicable_months", getValue("Long", max_applicable_months));
        addParameters(parameters,"max_applications_per_acct", getValue("Long", max_applications_per_acct));
        addParameters(parameters,"alt_service_no_2_apply", getValue("Long", alt_service_no_2_apply));
        addParameters(parameters,"alt_service_id_2_apply", getValue("String", alt_service_id_2_apply));
        addParameters(parameters,"applicable_trans_scope", getValue("String", applicable_trans_scope));
        RestUtilities.addParameterValuesFromArray(parameters, plan_no, "plan_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_plan_id, "client_plan_id");
        RestUtilities.addParameterValuesFromArray(parameters, service_no, "service_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_service_id, "client_service_id");
        RestUtilities.addParameterValuesFromArray(parameters, item_no, "item_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_item_id, "client_item_id");
        addParameters(parameters,"use_all_or_nth_subs_rule", getValue("String", use_all_or_nth_subs_rule));
        
        WebResource webResource = client.resource(buildUrl("create_discount_rule"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "rule_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createDiscountRule(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String label = (String) map.get("label");
        String rule_id = (String) map.get("rule_id");
        String description = (String) map.get("description");
        String ext_description = (String) map.get("ext_description");
        String flat_percent_ind = (String) map.get("flat_percent_ind");
        Double amount = (Double) map.get("amount");
        String currency = (String) map.get("currency");
        String duration_type_ind = (String) map.get("duration_type_ind");
        String inline_offset_ind = (String) map.get("inline_offset_ind");
        String discount_behavior_type_ind = (String) map.get("discount_behavior_type_ind");
        Long service_code_to_use = (Long) map.get("service_code_to_use");
        Long scope_no = (Long) map.get("scope_no");
        Long max_applicable_months = (Long) map.get("max_applicable_months");
        Long max_applications_per_acct = (Long) map.get("max_applications_per_acct");
        Long alt_service_no_2_apply = (Long) map.get("alt_service_no_2_apply");
        String alt_service_id_2_apply = (String) map.get("alt_service_id_2_apply");
        String applicable_trans_scope = (String) map.get("applicable_trans_scope");
        com.aria.common.shared.admin.PlanNoArray plan_no = (com.aria.common.shared.admin.PlanNoArray) map.get("plan_no");
        com.aria.common.shared.admin.ClientPlanIdArray client_plan_id = (com.aria.common.shared.admin.ClientPlanIdArray) map.get("client_plan_id");
        com.aria.common.shared.admin.ServiceNoArray service_no = (com.aria.common.shared.admin.ServiceNoArray) map.get("service_no");
        com.aria.common.shared.admin.ClientServiceIdArray client_service_id = (com.aria.common.shared.admin.ClientServiceIdArray) map.get("client_service_id");
        com.aria.common.shared.admin.ItemNoArray item_no = (com.aria.common.shared.admin.ItemNoArray) map.get("item_no");
        com.aria.common.shared.admin.ClientItemIdArray client_item_id = (com.aria.common.shared.admin.ClientItemIdArray) map.get("client_item_id");
        String use_all_or_nth_subs_rule = (String) map.get("use_all_or_nth_subs_rule");
        
        return createDiscountRule(client_no, auth_key, label, rule_id, description, ext_description, flat_percent_ind, amount, currency, duration_type_ind, inline_offset_ind, discount_behavior_type_ind, service_code_to_use, scope_no, max_applicable_months, max_applications_per_acct, alt_service_no_2_apply, alt_service_id_2_apply, applicable_trans_scope, plan_no, client_plan_id, service_no, client_service_id, item_no, client_item_id, use_all_or_nth_subs_rule);
    }

    public Map<String,Object> createDiscountBundle(Long client_no, String auth_key, String bundle_name, String bundle_id, String bundle_description, String allow_overlap_ind, com.aria.common.shared.admin.RulesArray rules, com.aria.common.shared.admin.RuleIdsArray rule_ids){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"bundle_name", getValue("String", bundle_name));
        addParameters(parameters,"bundle_id", getValue("String", bundle_id));
        addParameters(parameters,"bundle_description", getValue("String", bundle_description));
        addParameters(parameters,"allow_overlap_ind", getValue("String", allow_overlap_ind));
        RestUtilities.addParameterValuesFromArray(parameters, rules, "rules");
        RestUtilities.addParameterValuesFromArray(parameters, rule_ids, "rule_ids");
        
        WebResource webResource = client.resource(buildUrl("create_discount_bundle"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "bundle_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createDiscountBundle(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String bundle_name = (String) map.get("bundle_name");
        String bundle_id = (String) map.get("bundle_id");
        String bundle_description = (String) map.get("bundle_description");
        String allow_overlap_ind = (String) map.get("allow_overlap_ind");
        com.aria.common.shared.admin.RulesArray rules = (com.aria.common.shared.admin.RulesArray) map.get("rules");
        com.aria.common.shared.admin.RuleIdsArray rule_ids = (com.aria.common.shared.admin.RuleIdsArray) map.get("rule_ids");
        
        return createDiscountBundle(client_no, auth_key, bundle_name, bundle_id, bundle_description, allow_overlap_ind, rules, rule_ids);
    }

    public Map<String,Object> getDiscountBundles(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_discount_bundles"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "discount_bundles";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getDiscountBundles(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getDiscountBundles(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getDiscountBundleDetails(Long client_no, String auth_key, Long bundle_no, String bundle_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"bundle_no", getValue("Long", bundle_no));
        addParameters(parameters,"bundle_id", getValue("String", bundle_id));
        
        WebResource webResource = client.resource(buildUrl("get_discount_bundle_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "discount_bundles";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getDiscountBundleDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long bundle_no = (Long) map.get("bundle_no");
        String bundle_id = (String) map.get("bundle_id");
        
        return getDiscountBundleDetails(client_no, auth_key, bundle_no, bundle_id);
    }

    public Map<String,Object> getDiscountRules(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_discount_rules"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[4];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "discount_rules";
        returnValues[3] = "currency";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getDiscountRules(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getDiscountRules(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getDiscountRuleDetails(Long client_no, String auth_key, Long rule_no, String client_rule_id, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"rule_no", getValue("Long", rule_no));
        addParameters(parameters,"client_rule_id", getValue("String", client_rule_id));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_discount_rule_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "discount_rules";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getDiscountRuleDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long rule_no = (Long) map.get("rule_no");
        String client_rule_id = (String) map.get("client_rule_id");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getDiscountRuleDetails(client_no, auth_key, rule_no, client_rule_id, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> deleteRules(Long client_no, String auth_key, com.aria.common.shared.admin.RuleNosArray rule_nos){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, rule_nos, "rule_nos");
        
        WebResource webResource = client.resource(buildUrl("delete_rules"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteRules(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.RuleNosArray rule_nos = (com.aria.common.shared.admin.RuleNosArray) map.get("rule_nos");
        
        return deleteRules(client_no, auth_key, rule_nos);
    }

    public Map<String,Object> deleteBundles(Long client_no, String auth_key, com.aria.common.shared.admin.BundleNosArray bundle_nos){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, bundle_nos, "bundle_nos");
        
        WebResource webResource = client.resource(buildUrl("delete_bundles"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteBundles(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.BundleNosArray bundle_nos = (com.aria.common.shared.admin.BundleNosArray) map.get("bundle_nos");
        
        return deleteBundles(client_no, auth_key, bundle_nos);
    }

    public Map<String,Object> getPlans(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_plans"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPlans(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getPlans(client_no, auth_key);
    }

    public Map<String,Object> getPlanDetails(Long client_no, String auth_key, Long plan_no, String client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        
        WebResource webResource = client.resource(buildUrl("get_plan_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[39];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_no";
        returnValues[3] = "client_plan_id";
        returnValues[4] = "plan_level";
        returnValues[5] = "plan_type";
        returnValues[6] = "plan_name";
        returnValues[7] = "plan_desc";
        returnValues[8] = "plan_groups";
        returnValues[9] = "plan_group_ids";
        returnValues[10] = "currency_cd";
        returnValues[11] = "billing_interval";
        returnValues[12] = "usage_billing_interval";
        returnValues[13] = "active_ind";
        returnValues[14] = "rollover_months";
        returnValues[15] = "rollover_plan_no";
        returnValues[16] = "rollover_client_plan_id";
        returnValues[17] = "allow_child_accounts";
        returnValues[18] = "dunning_plan_no";
        returnValues[19] = "dunning_client_plan_id";
        returnValues[20] = "free_trial_duration";
        returnValues[21] = "free_trial_type";
        returnValues[22] = "initial_free_months";
        returnValues[23] = "acct_status_cd";
        returnValues[24] = "rollover_acct_status_days";
        returnValues[25] = "rollover_acct_status_cd";
        returnValues[26] = "template_no";
        returnValues[27] = "template_id";
        returnValues[28] = "plan_cancel_min_months";
        returnValues[29] = "how_to_apply_min_fee";
        returnValues[30] = "is_deletable";
        returnValues[31] = "services";
        returnValues[32] = "parent_plans";
        returnValues[33] = "parent_plan_ids";
        returnValues[34] = "exclusion_plans";
        returnValues[35] = "resources";
        returnValues[36] = "supplemental_obj_fields";
        returnValues[37] = "surcharges";
        returnValues[38] = "proration_invoice_timing_cd";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPlanDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        
        return getPlanDetails(client_no, auth_key, plan_no, client_plan_id);
    }

    public Map<String,Object> createNewPlan(Long client_no, String auth_key, String plan_name, String plan_type, String currency, String billing_interval, Long active, com.aria.common.shared.admin.ScheduleArray schedule, com.aria.common.shared.admin.ServiceArray service, String plan_description, String client_plan_id, com.aria.common.shared.admin.PlanGroupArray plan_group, com.aria.common.shared.admin.PlanGroupIdArray plan_group_id, String usage_billing_interval, String rollover_months, Long rollover_plan_no, String rollover_client_plan_id, Long initial_free_months, String free_trial_type, String free_trial_duration, Long acct_status_cd, Long rollover_acct_status_days, Long rollover_acct_status_cd, Long dunning_plan_no, String dunning_client_plan_id, Long template_no, String client_email_template_id, String apply_cancellation, Long plan_cancel_min_month, String apply_minimum_fee, String how_to_apply_min_fee, com.aria.common.shared.admin.ResourceArray resource, Long arc_service_no, com.aria.common.shared.admin.ParentPlansArray parent_plans, com.aria.common.shared.admin.ParentClientPlanIdsArray parent_client_plan_ids, com.aria.common.shared.admin.ExclusionPlansArray exclusion_plans, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, Long template_ind, com.aria.common.shared.admin.ChildPlansArray child_plans, String notification_template_group_no, String credit_note_template_no, com.aria.common.shared.admin.SurchargeNoArray surcharge_no, com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id, String proration_invoice_timing_cd){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_name", getValue("String", plan_name));
        addParameters(parameters,"plan_type", getValue("String", plan_type));
        addParameters(parameters,"currency", getValue("String", currency));
        addParameters(parameters,"billing_interval", getValue("String", billing_interval));
        addParameters(parameters,"active", getValue("Long", active));
        RestUtilities.addParameterValuesFromArray(parameters, schedule, "schedule");
        RestUtilities.addParameterValuesFromArray(parameters, service, "service");
        addParameters(parameters,"plan_description", getValue("String", plan_description));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        RestUtilities.addParameterValuesFromArray(parameters, plan_group, "plan_group");
        RestUtilities.addParameterValuesFromArray(parameters, plan_group_id, "plan_group_id");
        addParameters(parameters,"usage_billing_interval", getValue("String", usage_billing_interval));
        addParameters(parameters,"rollover_months", getValue("String", rollover_months));
        addParameters(parameters,"rollover_plan_no", getValue("Long", rollover_plan_no));
        addParameters(parameters,"rollover_client_plan_id", getValue("String", rollover_client_plan_id));
        addParameters(parameters,"initial_free_months", getValue("Long", initial_free_months));
        addParameters(parameters,"free_trial_type", getValue("String", free_trial_type));
        addParameters(parameters,"free_trial_duration", getValue("String", free_trial_duration));
        addParameters(parameters,"acct_status_cd", getValue("Long", acct_status_cd));
        addParameters(parameters,"rollover_acct_status_days", getValue("Long", rollover_acct_status_days));
        addParameters(parameters,"rollover_acct_status_cd", getValue("Long", rollover_acct_status_cd));
        addParameters(parameters,"dunning_plan_no", getValue("Long", dunning_plan_no));
        addParameters(parameters,"dunning_client_plan_id", getValue("String", dunning_client_plan_id));
        addParameters(parameters,"template_no", getValue("Long", template_no));
        addParameters(parameters,"client_email_template_id", getValue("String", client_email_template_id));
        addParameters(parameters,"apply_cancellation", getValue("String", apply_cancellation));
        addParameters(parameters,"plan_cancel_min_month", getValue("Long", plan_cancel_min_month));
        addParameters(parameters,"apply_minimum_fee", getValue("String", apply_minimum_fee));
        addParameters(parameters,"how_to_apply_min_fee", getValue("String", how_to_apply_min_fee));
        RestUtilities.addParameterValuesFromArray(parameters, resource, "resource");
        addParameters(parameters,"arc_service_no", getValue("Long", arc_service_no));
        RestUtilities.addParameterValuesFromArray(parameters, parent_plans, "parent_plans");
        RestUtilities.addParameterValuesFromArray(parameters, parent_client_plan_ids, "parent_client_plan_ids");
        RestUtilities.addParameterValuesFromArray(parameters, exclusion_plans, "exclusion_plans");
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        addParameters(parameters,"template_ind", getValue("Long", template_ind));
        RestUtilities.addParameterValuesFromArray(parameters, child_plans, "child_plans");
        addParameters(parameters,"notification_template_group_no", getValue("String", notification_template_group_no));
        addParameters(parameters,"credit_note_template_no", getValue("String", credit_note_template_no));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no, "surcharge_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_surcharge_id, "client_surcharge_id");
        addParameters(parameters,"proration_invoice_timing_cd", getValue("String", proration_invoice_timing_cd));
        
        WebResource webResource = client.resource(buildUrl("create_new_plan"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createNewPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String plan_name = (String) map.get("plan_name");
        String plan_type = (String) map.get("plan_type");
        String currency = (String) map.get("currency");
        String billing_interval = (String) map.get("billing_interval");
        Long active = (Long) map.get("active");
        com.aria.common.shared.admin.ScheduleArray schedule = (com.aria.common.shared.admin.ScheduleArray) map.get("schedule");
        com.aria.common.shared.admin.ServiceArray service = (com.aria.common.shared.admin.ServiceArray) map.get("service");
        String plan_description = (String) map.get("plan_description");
        String client_plan_id = (String) map.get("client_plan_id");
        com.aria.common.shared.admin.PlanGroupArray plan_group = (com.aria.common.shared.admin.PlanGroupArray) map.get("plan_group");
        com.aria.common.shared.admin.PlanGroupIdArray plan_group_id = (com.aria.common.shared.admin.PlanGroupIdArray) map.get("plan_group_id");
        String usage_billing_interval = (String) map.get("usage_billing_interval");
        String rollover_months = (String) map.get("rollover_months");
        Long rollover_plan_no = (Long) map.get("rollover_plan_no");
        String rollover_client_plan_id = (String) map.get("rollover_client_plan_id");
        Long initial_free_months = (Long) map.get("initial_free_months");
        String free_trial_type = (String) map.get("free_trial_type");
        String free_trial_duration = (String) map.get("free_trial_duration");
        Long acct_status_cd = (Long) map.get("acct_status_cd");
        Long rollover_acct_status_days = (Long) map.get("rollover_acct_status_days");
        Long rollover_acct_status_cd = (Long) map.get("rollover_acct_status_cd");
        Long dunning_plan_no = (Long) map.get("dunning_plan_no");
        String dunning_client_plan_id = (String) map.get("dunning_client_plan_id");
        Long template_no = (Long) map.get("template_no");
        String client_email_template_id = (String) map.get("client_email_template_id");
        String apply_cancellation = (String) map.get("apply_cancellation");
        Long plan_cancel_min_month = (Long) map.get("plan_cancel_min_month");
        String apply_minimum_fee = (String) map.get("apply_minimum_fee");
        String how_to_apply_min_fee = (String) map.get("how_to_apply_min_fee");
        com.aria.common.shared.admin.ResourceArray resource = (com.aria.common.shared.admin.ResourceArray) map.get("resource");
        Long arc_service_no = (Long) map.get("arc_service_no");
        com.aria.common.shared.admin.ParentPlansArray parent_plans = (com.aria.common.shared.admin.ParentPlansArray) map.get("parent_plans");
        com.aria.common.shared.admin.ParentClientPlanIdsArray parent_client_plan_ids = (com.aria.common.shared.admin.ParentClientPlanIdsArray) map.get("parent_client_plan_ids");
        com.aria.common.shared.admin.ExclusionPlansArray exclusion_plans = (com.aria.common.shared.admin.ExclusionPlansArray) map.get("exclusion_plans");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        Long template_ind = (Long) map.get("template_ind");
        com.aria.common.shared.admin.ChildPlansArray child_plans = (com.aria.common.shared.admin.ChildPlansArray) map.get("child_plans");
        String notification_template_group_no = (String) map.get("notification_template_group_no");
        String credit_note_template_no = (String) map.get("credit_note_template_no");
        com.aria.common.shared.admin.SurchargeNoArray surcharge_no = (com.aria.common.shared.admin.SurchargeNoArray) map.get("surcharge_no");
        com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id = (com.aria.common.shared.admin.ClientSurchargeIdArray) map.get("client_surcharge_id");
        String proration_invoice_timing_cd = (String) map.get("proration_invoice_timing_cd");
        
        return createNewPlan(client_no, auth_key, plan_name, plan_type, currency, billing_interval, active, schedule, service, plan_description, client_plan_id, plan_group, plan_group_id, usage_billing_interval, rollover_months, rollover_plan_no, rollover_client_plan_id, initial_free_months, free_trial_type, free_trial_duration, acct_status_cd, rollover_acct_status_days, rollover_acct_status_cd, dunning_plan_no, dunning_client_plan_id, template_no, client_email_template_id, apply_cancellation, plan_cancel_min_month, apply_minimum_fee, how_to_apply_min_fee, resource, arc_service_no, parent_plans, parent_client_plan_ids, exclusion_plans, supplemental_obj_field, template_ind, child_plans, notification_template_group_no, credit_note_template_no, surcharge_no, client_surcharge_id, proration_invoice_timing_cd);
    }

    public Map<String,Object> editPlan(Long client_no, String auth_key, String plan_no, String client_plan_id, String plan_name, String plan_description, com.aria.common.shared.admin.PlanGroupArray plan_group, com.aria.common.shared.admin.PlanGroupIdArray plan_group_id, Long plan_type, Long active, String billing_interval, String usage_billing_interval, String currency, Long template_no, String client_email_template_id, String rollover_months, Long rollover_plan_no, String rollover_client_plan_id, Long dunning_plan_no, String dunning_client_plan_id, Long initial_free_months, Long acct_status_cd, Long rollover_acct_status_days, Long rollover_acct_status_cd, Long allow_child_accts, String apply_cancellation, Long plan_cancel_min_month, String apply_minimum_fee, Long how_to_apply_min_fee, com.aria.common.shared.admin.ScheduleArray schedule, com.aria.common.shared.admin.ServiceArray service, com.aria.common.shared.admin.ResourceArray resource, Long arc_service_no, com.aria.common.shared.admin.ParentPlansArray parent_plans, com.aria.common.shared.admin.ParentClientPlanIdsArray parent_client_plan_ids, com.aria.common.shared.admin.ExclusionPlansArray exclusion_plans, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, com.aria.common.shared.admin.ChildPlansArray child_plans, String notification_template_group_no, String credit_note_template_no, com.aria.common.shared.admin.SurchargeNoArray surcharge_no, com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id, String proration_invoice_timing_cd, Long edit_directives){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("String", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"plan_name", getValue("String", plan_name));
        addParameters(parameters,"plan_description", getValue("String", plan_description));
        RestUtilities.addParameterValuesFromArray(parameters, plan_group, "plan_group");
        RestUtilities.addParameterValuesFromArray(parameters, plan_group_id, "plan_group_id");
        addParameters(parameters,"plan_type", getValue("Long", plan_type));
        addParameters(parameters,"active", getValue("Long", active));
        addParameters(parameters,"billing_interval", getValue("String", billing_interval));
        addParameters(parameters,"usage_billing_interval", getValue("String", usage_billing_interval));
        addParameters(parameters,"currency", getValue("String", currency));
        addParameters(parameters,"template_no", getValue("Long", template_no));
        addParameters(parameters,"client_email_template_id", getValue("String", client_email_template_id));
        addParameters(parameters,"rollover_months", getValue("String", rollover_months));
        addParameters(parameters,"rollover_plan_no", getValue("Long", rollover_plan_no));
        addParameters(parameters,"rollover_client_plan_id", getValue("String", rollover_client_plan_id));
        addParameters(parameters,"dunning_plan_no", getValue("Long", dunning_plan_no));
        addParameters(parameters,"dunning_client_plan_id", getValue("String", dunning_client_plan_id));
        addParameters(parameters,"initial_free_months", getValue("Long", initial_free_months));
        addParameters(parameters,"acct_status_cd", getValue("Long", acct_status_cd));
        addParameters(parameters,"rollover_acct_status_days", getValue("Long", rollover_acct_status_days));
        addParameters(parameters,"rollover_acct_status_cd", getValue("Long", rollover_acct_status_cd));
        addParameters(parameters,"allow_child_accts", getValue("Long", allow_child_accts));
        addParameters(parameters,"apply_cancellation", getValue("String", apply_cancellation));
        addParameters(parameters,"plan_cancel_min_month", getValue("Long", plan_cancel_min_month));
        addParameters(parameters,"apply_minimum_fee", getValue("String", apply_minimum_fee));
        addParameters(parameters,"how_to_apply_min_fee", getValue("Long", how_to_apply_min_fee));
        RestUtilities.addParameterValuesFromArray(parameters, schedule, "schedule");
        RestUtilities.addParameterValuesFromArray(parameters, service, "service");
        RestUtilities.addParameterValuesFromArray(parameters, resource, "resource");
        addParameters(parameters,"arc_service_no", getValue("Long", arc_service_no));
        RestUtilities.addParameterValuesFromArray(parameters, parent_plans, "parent_plans");
        RestUtilities.addParameterValuesFromArray(parameters, parent_client_plan_ids, "parent_client_plan_ids");
        RestUtilities.addParameterValuesFromArray(parameters, exclusion_plans, "exclusion_plans");
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        RestUtilities.addParameterValuesFromArray(parameters, child_plans, "child_plans");
        addParameters(parameters,"notification_template_group_no", getValue("String", notification_template_group_no));
        addParameters(parameters,"credit_note_template_no", getValue("String", credit_note_template_no));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no, "surcharge_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_surcharge_id, "client_surcharge_id");
        addParameters(parameters,"proration_invoice_timing_cd", getValue("String", proration_invoice_timing_cd));
        addParameters(parameters,"edit_directives", getValue("Long", edit_directives));
        
        WebResource webResource = client.resource(buildUrl("edit_plan"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> editPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String plan_no = (String) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        String plan_name = (String) map.get("plan_name");
        String plan_description = (String) map.get("plan_description");
        com.aria.common.shared.admin.PlanGroupArray plan_group = (com.aria.common.shared.admin.PlanGroupArray) map.get("plan_group");
        com.aria.common.shared.admin.PlanGroupIdArray plan_group_id = (com.aria.common.shared.admin.PlanGroupIdArray) map.get("plan_group_id");
        Long plan_type = (Long) map.get("plan_type");
        Long active = (Long) map.get("active");
        String billing_interval = (String) map.get("billing_interval");
        String usage_billing_interval = (String) map.get("usage_billing_interval");
        String currency = (String) map.get("currency");
        Long template_no = (Long) map.get("template_no");
        String client_email_template_id = (String) map.get("client_email_template_id");
        String rollover_months = (String) map.get("rollover_months");
        Long rollover_plan_no = (Long) map.get("rollover_plan_no");
        String rollover_client_plan_id = (String) map.get("rollover_client_plan_id");
        Long dunning_plan_no = (Long) map.get("dunning_plan_no");
        String dunning_client_plan_id = (String) map.get("dunning_client_plan_id");
        Long initial_free_months = (Long) map.get("initial_free_months");
        Long acct_status_cd = (Long) map.get("acct_status_cd");
        Long rollover_acct_status_days = (Long) map.get("rollover_acct_status_days");
        Long rollover_acct_status_cd = (Long) map.get("rollover_acct_status_cd");
        Long allow_child_accts = (Long) map.get("allow_child_accts");
        String apply_cancellation = (String) map.get("apply_cancellation");
        Long plan_cancel_min_month = (Long) map.get("plan_cancel_min_month");
        String apply_minimum_fee = (String) map.get("apply_minimum_fee");
        Long how_to_apply_min_fee = (Long) map.get("how_to_apply_min_fee");
        com.aria.common.shared.admin.ScheduleArray schedule = (com.aria.common.shared.admin.ScheduleArray) map.get("schedule");
        com.aria.common.shared.admin.ServiceArray service = (com.aria.common.shared.admin.ServiceArray) map.get("service");
        com.aria.common.shared.admin.ResourceArray resource = (com.aria.common.shared.admin.ResourceArray) map.get("resource");
        Long arc_service_no = (Long) map.get("arc_service_no");
        com.aria.common.shared.admin.ParentPlansArray parent_plans = (com.aria.common.shared.admin.ParentPlansArray) map.get("parent_plans");
        com.aria.common.shared.admin.ParentClientPlanIdsArray parent_client_plan_ids = (com.aria.common.shared.admin.ParentClientPlanIdsArray) map.get("parent_client_plan_ids");
        com.aria.common.shared.admin.ExclusionPlansArray exclusion_plans = (com.aria.common.shared.admin.ExclusionPlansArray) map.get("exclusion_plans");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        com.aria.common.shared.admin.ChildPlansArray child_plans = (com.aria.common.shared.admin.ChildPlansArray) map.get("child_plans");
        String notification_template_group_no = (String) map.get("notification_template_group_no");
        String credit_note_template_no = (String) map.get("credit_note_template_no");
        com.aria.common.shared.admin.SurchargeNoArray surcharge_no = (com.aria.common.shared.admin.SurchargeNoArray) map.get("surcharge_no");
        com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id = (com.aria.common.shared.admin.ClientSurchargeIdArray) map.get("client_surcharge_id");
        String proration_invoice_timing_cd = (String) map.get("proration_invoice_timing_cd");
        Long edit_directives = (Long) map.get("edit_directives");
        
        return editPlan(client_no, auth_key, plan_no, client_plan_id, plan_name, plan_description, plan_group, plan_group_id, plan_type, active, billing_interval, usage_billing_interval, currency, template_no, client_email_template_id, rollover_months, rollover_plan_no, rollover_client_plan_id, dunning_plan_no, dunning_client_plan_id, initial_free_months, acct_status_cd, rollover_acct_status_days, rollover_acct_status_cd, allow_child_accts, apply_cancellation, plan_cancel_min_month, apply_minimum_fee, how_to_apply_min_fee, schedule, service, resource, arc_service_no, parent_plans, parent_client_plan_ids, exclusion_plans, supplemental_obj_field, child_plans, notification_template_group_no, credit_note_template_no, surcharge_no, client_surcharge_id, proration_invoice_timing_cd, edit_directives);
    }

    public Map<String,Object> deletePlans(Long client_no, String auth_key, com.aria.common.shared.admin.PlanNosArray plan_nos){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, plan_nos, "plan_nos");
        
        WebResource webResource = client.resource(buildUrl("delete_plans"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plans";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deletePlans(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.PlanNosArray plan_nos = (com.aria.common.shared.admin.PlanNosArray) map.get("plan_nos");
        
        return deletePlans(client_no, auth_key, plan_nos);
    }

    public Map<String,Object> copyPlan(Long client_no, String auth_key, Long plan_no, String client_plan_id, String plan_name, String new_client_plan_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"plan_no", getValue("Long", plan_no));
        addParameters(parameters,"client_plan_id", getValue("String", client_plan_id));
        addParameters(parameters,"plan_name", getValue("String", plan_name));
        addParameters(parameters,"new_client_plan_id", getValue("String", new_client_plan_id));
        
        WebResource webResource = client.resource(buildUrl("copy_plan"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> copyPlan(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long plan_no = (Long) map.get("plan_no");
        String client_plan_id = (String) map.get("client_plan_id");
        String plan_name = (String) map.get("plan_name");
        String new_client_plan_id = (String) map.get("new_client_plan_id");
        
        return copyPlan(client_no, auth_key, plan_no, client_plan_id, plan_name, new_client_plan_id);
    }

    public Map<String,Object> getPromotions(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_promotions"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promotions";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPromotions(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getPromotions(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getPromotionDetails(Long client_no, String auth_key, String promo_cd, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_cd", getValue("String", promo_cd));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_promotion_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[11];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "client_no";
        returnValues[3] = "promo_cd";
        returnValues[4] = "promo_desc";
        returnValues[5] = "start_date";
        returnValues[6] = "exp_date";
        returnValues[7] = "no_of_uses";
        returnValues[8] = "plan_type_name";
        returnValues[9] = "plan_type_desc";
        returnValues[10] = "promotion_translations";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPromotionDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_cd = (String) map.get("promo_cd");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getPromotionDetails(client_no, auth_key, promo_cd, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createPromotion(Long client_no, String auth_key, String promo_cd, String promo_desc, Long promo_plan_set_no, String no_of_uses, String start_date, String exp_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_cd", getValue("String", promo_cd));
        addParameters(parameters,"promo_desc", getValue("String", promo_desc));
        addParameters(parameters,"promo_plan_set_no", getValue("Long", promo_plan_set_no));
        addParameters(parameters,"no_of_uses", getValue("String", no_of_uses));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"exp_date", getValue("String", exp_date));
        
        WebResource webResource = client.resource(buildUrl("create_promotion"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_cd";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createPromotion(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_cd = (String) map.get("promo_cd");
        String promo_desc = (String) map.get("promo_desc");
        Long promo_plan_set_no = (Long) map.get("promo_plan_set_no");
        String no_of_uses = (String) map.get("no_of_uses");
        String start_date = (String) map.get("start_date");
        String exp_date = (String) map.get("exp_date");
        
        return createPromotion(client_no, auth_key, promo_cd, promo_desc, promo_plan_set_no, no_of_uses, start_date, exp_date);
    }

    public Map<String,Object> updatePromotion(Long client_no, String auth_key, String promo_cd, String promo_desc, Long promo_plan_set_no, String no_of_uses, String start_date, String exp_date, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"promo_cd", getValue("String", promo_cd));
        addParameters(parameters,"promo_desc", getValue("String", promo_desc));
        addParameters(parameters,"promo_plan_set_no", getValue("Long", promo_plan_set_no));
        addParameters(parameters,"no_of_uses", getValue("String", no_of_uses));
        addParameters(parameters,"start_date", getValue("String", start_date));
        addParameters(parameters,"exp_date", getValue("String", exp_date));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("update_promotion"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "promo_cd";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updatePromotion(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String promo_cd = (String) map.get("promo_cd");
        String promo_desc = (String) map.get("promo_desc");
        Long promo_plan_set_no = (Long) map.get("promo_plan_set_no");
        String no_of_uses = (String) map.get("no_of_uses");
        String start_date = (String) map.get("start_date");
        String exp_date = (String) map.get("exp_date");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return updatePromotion(client_no, auth_key, promo_cd, promo_desc, promo_plan_set_no, no_of_uses, start_date, exp_date, locale_no, locale_name);
    }

    public Map<String,Object> getUsageTypes(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_usage_types"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_types";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getUsageTypes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getUsageTypes(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getUsageTypeDetails(Long client_no, String auth_key, Long usage_type_no, String usage_type_code, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"usage_type_no", getValue("Long", usage_type_no));
        addParameters(parameters,"usage_type_code", getValue("String", usage_type_code));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_usage_type_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[11];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_type_no";
        returnValues[3] = "usage_type_name";
        returnValues[4] = "usage_type_desc";
        returnValues[5] = "usage_type_display_string";
        returnValues[6] = "usage_unit_type";
        returnValues[7] = "usage_type_code";
        returnValues[8] = "is_editable";
        returnValues[9] = "supplemental_obj_fields";
        returnValues[10] = "usage_type_translation_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getUsageTypeDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long usage_type_no = (Long) map.get("usage_type_no");
        String usage_type_code = (String) map.get("usage_type_code");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getUsageTypeDetails(client_no, auth_key, usage_type_no, usage_type_code, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getUsageUnitTypes(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_usage_unit_types"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_unit_types";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getUsageUnitTypes(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getUsageUnitTypes(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createUsageType(Long client_no, String auth_key, String usage_type_name, String usage_type_desc, Long usage_unit_type_no, String usage_type_code, String usage_type_display_string, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"usage_type_name", getValue("String", usage_type_name));
        addParameters(parameters,"usage_type_desc", getValue("String", usage_type_desc));
        addParameters(parameters,"usage_unit_type_no", getValue("Long", usage_unit_type_no));
        addParameters(parameters,"usage_type_code", getValue("String", usage_type_code));
        addParameters(parameters,"usage_type_display_string", getValue("String", usage_type_display_string));
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        
        WebResource webResource = client.resource(buildUrl("create_usage_type"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_type_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createUsageType(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String usage_type_name = (String) map.get("usage_type_name");
        String usage_type_desc = (String) map.get("usage_type_desc");
        Long usage_unit_type_no = (Long) map.get("usage_unit_type_no");
        String usage_type_code = (String) map.get("usage_type_code");
        String usage_type_display_string = (String) map.get("usage_type_display_string");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        
        return createUsageType(client_no, auth_key, usage_type_name, usage_type_desc, usage_unit_type_no, usage_type_code, usage_type_display_string, supplemental_obj_field);
    }

    public Map<String,Object> updateUsageType(Long client_no, String auth_key, Long usage_type_no, String usage_type_name, String usage_type_desc, Long usage_unit_type_no, String usage_type_code, String usage_type_display_string, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"usage_type_no", getValue("Long", usage_type_no));
        addParameters(parameters,"usage_type_name", getValue("String", usage_type_name));
        addParameters(parameters,"usage_type_desc", getValue("String", usage_type_desc));
        addParameters(parameters,"usage_unit_type_no", getValue("Long", usage_unit_type_no));
        addParameters(parameters,"usage_type_code", getValue("String", usage_type_code));
        addParameters(parameters,"usage_type_display_string", getValue("String", usage_type_display_string));
        RestUtilities.addParameterValuesFromArray(parameters, supplemental_obj_field, "supplemental_obj_field");
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("update_usage_type"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "usage_type_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateUsageType(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long usage_type_no = (Long) map.get("usage_type_no");
        String usage_type_name = (String) map.get("usage_type_name");
        String usage_type_desc = (String) map.get("usage_type_desc");
        Long usage_unit_type_no = (Long) map.get("usage_unit_type_no");
        String usage_type_code = (String) map.get("usage_type_code");
        String usage_type_display_string = (String) map.get("usage_type_display_string");
        com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field = (com.aria.common.shared.admin.SupplementalObjFieldArray) map.get("supplemental_obj_field");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return updateUsageType(client_no, auth_key, usage_type_no, usage_type_name, usage_type_desc, usage_unit_type_no, usage_type_code, usage_type_display_string, supplemental_obj_field, locale_no, locale_name);
    }

    public Map<String,Object> createSuppObjField(Long client_no, String auth_key, String field_name, com.aria.common.shared.admin.AssignFieldCategoriesArray assign_field_categories, String description, String min_no_sel, Long max_no_sel, String datatype, String form_input_type, String use_allowed_vals_ind, String option_value, String option_value_order, Long allow_instance_override, com.aria.common.shared.admin.ObjectTypeArray object_type){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_name", getValue("String", field_name));
        RestUtilities.addParameterValuesFromArray(parameters, assign_field_categories, "assign_field_categories");
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"min_no_sel", getValue("String", min_no_sel));
        addParameters(parameters,"max_no_sel", getValue("Long", max_no_sel));
        addParameters(parameters,"datatype", getValue("String", datatype));
        addParameters(parameters,"form_input_type", getValue("String", form_input_type));
        addParameters(parameters,"use_allowed_vals_ind", getValue("String", use_allowed_vals_ind));
        addParameters(parameters,"option_value", getValue("String", option_value));
        addParameters(parameters,"option_value_order", getValue("String", option_value_order));
        addParameters(parameters,"allow_instance_override", getValue("Long", allow_instance_override));
        RestUtilities.addParameterValuesFromArray(parameters, object_type, "object_type");
        
        WebResource webResource = client.resource(buildUrl("create_supp_obj_field"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createSuppObjField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String field_name = (String) map.get("field_name");
        com.aria.common.shared.admin.AssignFieldCategoriesArray assign_field_categories = (com.aria.common.shared.admin.AssignFieldCategoriesArray) map.get("assign_field_categories");
        String description = (String) map.get("description");
        String min_no_sel = (String) map.get("min_no_sel");
        Long max_no_sel = (Long) map.get("max_no_sel");
        String datatype = (String) map.get("datatype");
        String form_input_type = (String) map.get("form_input_type");
        String use_allowed_vals_ind = (String) map.get("use_allowed_vals_ind");
        String option_value = (String) map.get("option_value");
        String option_value_order = (String) map.get("option_value_order");
        Long allow_instance_override = (Long) map.get("allow_instance_override");
        com.aria.common.shared.admin.ObjectTypeArray object_type = (com.aria.common.shared.admin.ObjectTypeArray) map.get("object_type");
        
        return createSuppObjField(client_no, auth_key, field_name, assign_field_categories, description, min_no_sel, max_no_sel, datatype, form_input_type, use_allowed_vals_ind, option_value, option_value_order, allow_instance_override, object_type);
    }

    public Map<String,Object> updateSuppObjField(Long client_no, String auth_key, Long field_no, String field_name, com.aria.common.shared.admin.AssignFieldCategoriesArray assign_field_categories, String description, String min_no_sel, Long max_no_sel, String datatype, String form_input_type, String use_allowed_vals_ind, String option_value, String option_value_order, Long allow_instance_override, com.aria.common.shared.admin.ObjectTypeArray object_type, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_no", getValue("Long", field_no));
        addParameters(parameters,"field_name", getValue("String", field_name));
        RestUtilities.addParameterValuesFromArray(parameters, assign_field_categories, "assign_field_categories");
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"min_no_sel", getValue("String", min_no_sel));
        addParameters(parameters,"max_no_sel", getValue("Long", max_no_sel));
        addParameters(parameters,"datatype", getValue("String", datatype));
        addParameters(parameters,"form_input_type", getValue("String", form_input_type));
        addParameters(parameters,"use_allowed_vals_ind", getValue("String", use_allowed_vals_ind));
        addParameters(parameters,"option_value", getValue("String", option_value));
        addParameters(parameters,"option_value_order", getValue("String", option_value_order));
        addParameters(parameters,"allow_instance_override", getValue("Long", allow_instance_override));
        RestUtilities.addParameterValuesFromArray(parameters, object_type, "object_type");
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("update_supp_obj_field"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateSuppObjField(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_no = (Long) map.get("field_no");
        String field_name = (String) map.get("field_name");
        com.aria.common.shared.admin.AssignFieldCategoriesArray assign_field_categories = (com.aria.common.shared.admin.AssignFieldCategoriesArray) map.get("assign_field_categories");
        String description = (String) map.get("description");
        String min_no_sel = (String) map.get("min_no_sel");
        Long max_no_sel = (Long) map.get("max_no_sel");
        String datatype = (String) map.get("datatype");
        String form_input_type = (String) map.get("form_input_type");
        String use_allowed_vals_ind = (String) map.get("use_allowed_vals_ind");
        String option_value = (String) map.get("option_value");
        String option_value_order = (String) map.get("option_value_order");
        Long allow_instance_override = (Long) map.get("allow_instance_override");
        com.aria.common.shared.admin.ObjectTypeArray object_type = (com.aria.common.shared.admin.ObjectTypeArray) map.get("object_type");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return updateSuppObjField(client_no, auth_key, field_no, field_name, assign_field_categories, description, min_no_sel, max_no_sel, datatype, form_input_type, use_allowed_vals_ind, option_value, option_value_order, allow_instance_override, object_type, locale_no, locale_name);
    }

    public Map<String,Object> getSuppObjFields(Long client_no, String auth_key, Long field_no, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_no", getValue("Long", field_no));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_supp_obj_fields"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[14];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_no";
        returnValues[3] = "field_name";
        returnValues[4] = "description";
        returnValues[5] = "datatype";
        returnValues[6] = "min_no_sel";
        returnValues[7] = "max_no_sel";
        returnValues[8] = "form_input_type";
        returnValues[9] = "allowed_values";
        returnValues[10] = "associated_objects";
        returnValues[11] = "field_categories";
        returnValues[12] = "allow_instance_override";
        returnValues[13] = "supp_obj_field_translations";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getSuppObjFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_no = (Long) map.get("field_no");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getSuppObjFields(client_no, auth_key, field_no, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> listSuppObjFields(Long client_no, String auth_key, com.aria.common.shared.admin.FieldSelectionArray field_selection, com.aria.common.shared.admin.FieldCategoriesArray field_categories, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, field_selection, "field_selection");
        RestUtilities.addParameterValuesFromArray(parameters, field_categories, "field_categories");
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("list_supp_obj_fields"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> listSuppObjFields(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.FieldSelectionArray field_selection = (com.aria.common.shared.admin.FieldSelectionArray) map.get("field_selection");
        com.aria.common.shared.admin.FieldCategoriesArray field_categories = (com.aria.common.shared.admin.FieldCategoriesArray) map.get("field_categories");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return listSuppObjFields(client_no, auth_key, field_selection, field_categories, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getPlanGroups(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_plan_groups"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_groups";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPlanGroups(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getPlanGroups(client_no, auth_key);
    }

    public Map<String,Object> getPlanGroupDetails(Long client_no, String auth_key, Long group_no, String client_plan_change_group_id, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_no", getValue("Long", group_no));
        addParameters(parameters,"client_plan_change_group_id", getValue("String", client_plan_change_group_id));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_plan_group_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[9];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "group_no";
        returnValues[3] = "client_plan_change_group_id";
        returnValues[4] = "group_name";
        returnValues[5] = "group_desc";
        returnValues[6] = "group_usage";
        returnValues[7] = "plans";
        returnValues[8] = "plan_group_translation_info";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getPlanGroupDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long group_no = (Long) map.get("group_no");
        String client_plan_change_group_id = (String) map.get("client_plan_change_group_id");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getPlanGroupDetails(client_no, auth_key, group_no, client_plan_change_group_id, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createPlanGroup(Long client_no, String auth_key, String group_name, String group_desc, String group_usage, String client_plan_change_group_id, String group_plans, String group_plan_ids){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_name", getValue("String", group_name));
        addParameters(parameters,"group_desc", getValue("String", group_desc));
        addParameters(parameters,"group_usage", getValue("String", group_usage));
        addParameters(parameters,"client_plan_change_group_id", getValue("String", client_plan_change_group_id));
        addParameters(parameters,"group_plans", getValue("String", group_plans));
        addParameters(parameters,"group_plan_ids", getValue("String", group_plan_ids));
        
        WebResource webResource = client.resource(buildUrl("create_plan_group"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "group_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createPlanGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String group_name = (String) map.get("group_name");
        String group_desc = (String) map.get("group_desc");
        String group_usage = (String) map.get("group_usage");
        String client_plan_change_group_id = (String) map.get("client_plan_change_group_id");
        String group_plans = (String) map.get("group_plans");
        String group_plan_ids = (String) map.get("group_plan_ids");
        
        return createPlanGroup(client_no, auth_key, group_name, group_desc, group_usage, client_plan_change_group_id, group_plans, group_plan_ids);
    }

    public Map<String,Object> updatePlanGroup(Long client_no, String auth_key, Long group_no, String group_name, String group_desc, String group_usage, String client_plan_change_group_id, String group_plans, String group_plan_ids){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_no", getValue("Long", group_no));
        addParameters(parameters,"group_name", getValue("String", group_name));
        addParameters(parameters,"group_desc", getValue("String", group_desc));
        addParameters(parameters,"group_usage", getValue("String", group_usage));
        addParameters(parameters,"client_plan_change_group_id", getValue("String", client_plan_change_group_id));
        addParameters(parameters,"group_plans", getValue("String", group_plans));
        addParameters(parameters,"group_plan_ids", getValue("String", group_plan_ids));
        
        WebResource webResource = client.resource(buildUrl("update_plan_group"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "group_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updatePlanGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long group_no = (Long) map.get("group_no");
        String group_name = (String) map.get("group_name");
        String group_desc = (String) map.get("group_desc");
        String group_usage = (String) map.get("group_usage");
        String client_plan_change_group_id = (String) map.get("client_plan_change_group_id");
        String group_plans = (String) map.get("group_plans");
        String group_plan_ids = (String) map.get("group_plan_ids");
        
        return updatePlanGroup(client_no, auth_key, group_no, group_name, group_desc, group_usage, client_plan_change_group_id, group_plans, group_plan_ids);
    }

    public Map<String,Object> deletePlanGroup(Long client_no, String auth_key, String group_list){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_list", getValue("String", group_list));
        
        WebResource webResource = client.resource(buildUrl("delete_plan_group"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "plan_groups";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deletePlanGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String group_list = (String) map.get("group_list");
        
        return deletePlanGroup(client_no, auth_key, group_list);
    }

    public Map<String,Object> listCoa(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("list_coa"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coa_list";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> listCoa(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return listCoa(client_no, auth_key);
    }

    public Map<String,Object> addCoa(Long client_no, String auth_key, String coa_code, String coa_description){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"coa_code", getValue("String", coa_code));
        addParameters(parameters,"coa_description", getValue("String", coa_description));
        
        WebResource webResource = client.resource(buildUrl("add_coa"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coa";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> addCoa(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String coa_code = (String) map.get("coa_code");
        String coa_description = (String) map.get("coa_description");
        
        return addCoa(client_no, auth_key, coa_code, coa_description);
    }

    public Map<String,Object> getCoa(Long client_no, String auth_key, Long coa_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"coa_id", getValue("Long", coa_id));
        
        WebResource webResource = client.resource(buildUrl("get_coa"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coa";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCoa(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long coa_id = (Long) map.get("coa_id");
        
        return getCoa(client_no, auth_key, coa_id);
    }

    public Map<String,Object> editCoa(Long client_no, String auth_key, Long coa_id, String coa_code, String coa_description){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"coa_id", getValue("Long", coa_id));
        addParameters(parameters,"coa_code", getValue("String", coa_code));
        addParameters(parameters,"coa_description", getValue("String", coa_description));
        
        WebResource webResource = client.resource(buildUrl("edit_coa"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coa";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> editCoa(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long coa_id = (Long) map.get("coa_id");
        String coa_code = (String) map.get("coa_code");
        String coa_description = (String) map.get("coa_description");
        
        return editCoa(client_no, auth_key, coa_id, coa_code, coa_description);
    }

    public Map<String,Object> getSurcharges(Long client_no, String auth_key, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_surcharges"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "surcharges";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getSurcharges(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getSurcharges(client_no, auth_key, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> getSurchargeDetails(Long client_no, String auth_key, Long surcharge_no, String client_surcharge_id, Long locale_no, String locale_name, Long include_translations){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"surcharge_no", getValue("Long", surcharge_no));
        addParameters(parameters,"client_surcharge_id", getValue("String", client_surcharge_id));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        addParameters(parameters,"include_translations", getValue("Long", include_translations));
        
        WebResource webResource = client.resource(buildUrl("get_surcharge_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[27];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "surcharge_no";
        returnValues[3] = "surcharge_name";
        returnValues[4] = "client_surcharge_id";
        returnValues[5] = "description";
        returnValues[6] = "ext_description";
        returnValues[7] = "currency_cd";
        returnValues[8] = "surcharge_type_cd";
        returnValues[9] = "inline_offset_ind";
        returnValues[10] = "tax_group";
        returnValues[11] = "gl_cd";
        returnValues[12] = "ar_gl_cd";
        returnValues[13] = "apply_b4_or_after_discount_cd";
        returnValues[14] = "apply_to_zero_invoice_ind";
        returnValues[15] = "scope_no";
        returnValues[16] = "surcharge_tier";
        returnValues[17] = "plan_no";
        returnValues[18] = "client_plan_id";
        returnValues[19] = "service_no";
        returnValues[20] = "client_service_id";
        returnValues[21] = "item_no";
        returnValues[22] = "client_item_id";
        returnValues[23] = "plan_service";
        returnValues[24] = "surcharge_scope";
        returnValues[25] = "pay_method";
        returnValues[26] = "surcharge_translation_details";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getSurchargeDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long surcharge_no = (Long) map.get("surcharge_no");
        String client_surcharge_id = (String) map.get("client_surcharge_id");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        Long include_translations = (Long) map.get("include_translations");
        
        return getSurchargeDetails(client_no, auth_key, surcharge_no, client_surcharge_id, locale_no, locale_name, include_translations);
    }

    public Map<String,Object> createSurcharge(Long client_no, String auth_key, String surcharge_name, String description, String ext_description, String currency_cd, String surcharge_type_cd, String inline_offset_ind, String apply_b4_or_after_discount_cd, Long scope_no, com.aria.common.shared.admin.SurchargeTierArray surcharge_tier, String client_surcharge_id, Long apply_to_zero_invoice_ind, Long tax_group, String gl_cd, String ar_gl_cd, com.aria.common.shared.admin.PlanNoArray plan_no, com.aria.common.shared.admin.ClientPlanIdArray client_plan_id, com.aria.common.shared.admin.ServiceNoArray service_no, com.aria.common.shared.admin.ClientServiceIdArray client_service_id, com.aria.common.shared.admin.ItemNoArray item_no, com.aria.common.shared.admin.ClientItemIdArray client_item_id, com.aria.common.shared.admin.ScheduleArray schedule, Long surcharge_scope){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"surcharge_name", getValue("String", surcharge_name));
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"ext_description", getValue("String", ext_description));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"surcharge_type_cd", getValue("String", surcharge_type_cd));
        addParameters(parameters,"inline_offset_ind", getValue("String", inline_offset_ind));
        addParameters(parameters,"apply_b4_or_after_discount_cd", getValue("String", apply_b4_or_after_discount_cd));
        addParameters(parameters,"scope_no", getValue("Long", scope_no));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_tier, "surcharge_tier");
        addParameters(parameters,"client_surcharge_id", getValue("String", client_surcharge_id));
        addParameters(parameters,"apply_to_zero_invoice_ind", getValue("Long", apply_to_zero_invoice_ind));
        addParameters(parameters,"tax_group", getValue("Long", tax_group));
        addParameters(parameters,"gl_cd", getValue("String", gl_cd));
        addParameters(parameters,"ar_gl_cd", getValue("String", ar_gl_cd));
        RestUtilities.addParameterValuesFromArray(parameters, plan_no, "plan_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_plan_id, "client_plan_id");
        RestUtilities.addParameterValuesFromArray(parameters, service_no, "service_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_service_id, "client_service_id");
        RestUtilities.addParameterValuesFromArray(parameters, item_no, "item_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_item_id, "client_item_id");
        RestUtilities.addParameterValuesFromArray(parameters, schedule, "schedule");
        addParameters(parameters,"surcharge_scope", getValue("Long", surcharge_scope));
        
        WebResource webResource = client.resource(buildUrl("create_surcharge"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "surcharge_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createSurcharge(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String surcharge_name = (String) map.get("surcharge_name");
        String description = (String) map.get("description");
        String ext_description = (String) map.get("ext_description");
        String currency_cd = (String) map.get("currency_cd");
        String surcharge_type_cd = (String) map.get("surcharge_type_cd");
        String inline_offset_ind = (String) map.get("inline_offset_ind");
        String apply_b4_or_after_discount_cd = (String) map.get("apply_b4_or_after_discount_cd");
        Long scope_no = (Long) map.get("scope_no");
        com.aria.common.shared.admin.SurchargeTierArray surcharge_tier = (com.aria.common.shared.admin.SurchargeTierArray) map.get("surcharge_tier");
        String client_surcharge_id = (String) map.get("client_surcharge_id");
        Long apply_to_zero_invoice_ind = (Long) map.get("apply_to_zero_invoice_ind");
        Long tax_group = (Long) map.get("tax_group");
        String gl_cd = (String) map.get("gl_cd");
        String ar_gl_cd = (String) map.get("ar_gl_cd");
        com.aria.common.shared.admin.PlanNoArray plan_no = (com.aria.common.shared.admin.PlanNoArray) map.get("plan_no");
        com.aria.common.shared.admin.ClientPlanIdArray client_plan_id = (com.aria.common.shared.admin.ClientPlanIdArray) map.get("client_plan_id");
        com.aria.common.shared.admin.ServiceNoArray service_no = (com.aria.common.shared.admin.ServiceNoArray) map.get("service_no");
        com.aria.common.shared.admin.ClientServiceIdArray client_service_id = (com.aria.common.shared.admin.ClientServiceIdArray) map.get("client_service_id");
        com.aria.common.shared.admin.ItemNoArray item_no = (com.aria.common.shared.admin.ItemNoArray) map.get("item_no");
        com.aria.common.shared.admin.ClientItemIdArray client_item_id = (com.aria.common.shared.admin.ClientItemIdArray) map.get("client_item_id");
        com.aria.common.shared.admin.ScheduleArray schedule = (com.aria.common.shared.admin.ScheduleArray) map.get("schedule");
        Long surcharge_scope = (Long) map.get("surcharge_scope");
        
        return createSurcharge(client_no, auth_key, surcharge_name, description, ext_description, currency_cd, surcharge_type_cd, inline_offset_ind, apply_b4_or_after_discount_cd, scope_no, surcharge_tier, client_surcharge_id, apply_to_zero_invoice_ind, tax_group, gl_cd, ar_gl_cd, plan_no, client_plan_id, service_no, client_service_id, item_no, client_item_id, schedule, surcharge_scope);
    }

    public Map<String,Object> editSurcharge(Long client_no, String auth_key, String surcharge_no, String surcharge_name, String client_surcharge_id, String description, String ext_description, String currency_cd, Long scope_no, com.aria.common.shared.admin.SurchargeTierArray surcharge_tier, Long apply_to_zero_invoice_ind, com.aria.common.shared.admin.PlanNoArray plan_no, com.aria.common.shared.admin.ClientPlanIdArray client_plan_id, com.aria.common.shared.admin.ServiceNoArray service_no, com.aria.common.shared.admin.ClientServiceIdArray client_service_id, com.aria.common.shared.admin.ItemNoArray item_no, com.aria.common.shared.admin.ClientItemIdArray client_item_id, com.aria.common.shared.admin.ScheduleArray schedule, Long surcharge_scope, Long locale_no, String locale_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"surcharge_no", getValue("String", surcharge_no));
        addParameters(parameters,"surcharge_name", getValue("String", surcharge_name));
        addParameters(parameters,"client_surcharge_id", getValue("String", client_surcharge_id));
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"ext_description", getValue("String", ext_description));
        addParameters(parameters,"currency_cd", getValue("String", currency_cd));
        addParameters(parameters,"scope_no", getValue("Long", scope_no));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_tier, "surcharge_tier");
        addParameters(parameters,"apply_to_zero_invoice_ind", getValue("Long", apply_to_zero_invoice_ind));
        RestUtilities.addParameterValuesFromArray(parameters, plan_no, "plan_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_plan_id, "client_plan_id");
        RestUtilities.addParameterValuesFromArray(parameters, service_no, "service_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_service_id, "client_service_id");
        RestUtilities.addParameterValuesFromArray(parameters, item_no, "item_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_item_id, "client_item_id");
        RestUtilities.addParameterValuesFromArray(parameters, schedule, "schedule");
        addParameters(parameters,"surcharge_scope", getValue("Long", surcharge_scope));
        addParameters(parameters,"locale_no", getValue("Long", locale_no));
        addParameters(parameters,"locale_name", getValue("String", locale_name));
        
        WebResource webResource = client.resource(buildUrl("edit_surcharge"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "surcharge_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> editSurcharge(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String surcharge_no = (String) map.get("surcharge_no");
        String surcharge_name = (String) map.get("surcharge_name");
        String client_surcharge_id = (String) map.get("client_surcharge_id");
        String description = (String) map.get("description");
        String ext_description = (String) map.get("ext_description");
        String currency_cd = (String) map.get("currency_cd");
        Long scope_no = (Long) map.get("scope_no");
        com.aria.common.shared.admin.SurchargeTierArray surcharge_tier = (com.aria.common.shared.admin.SurchargeTierArray) map.get("surcharge_tier");
        Long apply_to_zero_invoice_ind = (Long) map.get("apply_to_zero_invoice_ind");
        com.aria.common.shared.admin.PlanNoArray plan_no = (com.aria.common.shared.admin.PlanNoArray) map.get("plan_no");
        com.aria.common.shared.admin.ClientPlanIdArray client_plan_id = (com.aria.common.shared.admin.ClientPlanIdArray) map.get("client_plan_id");
        com.aria.common.shared.admin.ServiceNoArray service_no = (com.aria.common.shared.admin.ServiceNoArray) map.get("service_no");
        com.aria.common.shared.admin.ClientServiceIdArray client_service_id = (com.aria.common.shared.admin.ClientServiceIdArray) map.get("client_service_id");
        com.aria.common.shared.admin.ItemNoArray item_no = (com.aria.common.shared.admin.ItemNoArray) map.get("item_no");
        com.aria.common.shared.admin.ClientItemIdArray client_item_id = (com.aria.common.shared.admin.ClientItemIdArray) map.get("client_item_id");
        com.aria.common.shared.admin.ScheduleArray schedule = (com.aria.common.shared.admin.ScheduleArray) map.get("schedule");
        Long surcharge_scope = (Long) map.get("surcharge_scope");
        Long locale_no = (Long) map.get("locale_no");
        String locale_name = (String) map.get("locale_name");
        
        return editSurcharge(client_no, auth_key, surcharge_no, surcharge_name, client_surcharge_id, description, ext_description, currency_cd, scope_no, surcharge_tier, apply_to_zero_invoice_ind, plan_no, client_plan_id, service_no, client_service_id, item_no, client_item_id, schedule, surcharge_scope, locale_no, locale_name);
    }

    public Map<String,Object> deleteSurcharge(Long client_no, String auth_key, com.aria.common.shared.admin.SurchargeNoArray surcharge_no, com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        RestUtilities.addParameterValuesFromArray(parameters, surcharge_no, "surcharge_no");
        RestUtilities.addParameterValuesFromArray(parameters, client_surcharge_id, "client_surcharge_id");
        
        WebResource webResource = client.resource(buildUrl("delete_surcharge"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteSurcharge(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        com.aria.common.shared.admin.SurchargeNoArray surcharge_no = (com.aria.common.shared.admin.SurchargeNoArray) map.get("surcharge_no");
        com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id = (com.aria.common.shared.admin.ClientSurchargeIdArray) map.get("client_surcharge_id");
        
        return deleteSurcharge(client_no, auth_key, surcharge_no, client_surcharge_id);
    }

    public Map<String,Object> validateAdminSession(Long client_no, String auth_key, String session_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"session_id", getValue("String", session_id));
        
        WebResource webResource = client.resource(buildUrl("validate_admin_session"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> validateAdminSession(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String session_id = (String) map.get("session_id");
        
        return validateAdminSession(client_no, auth_key, session_id);
    }

    public Map<String,Object> createChannel(Long client_no, String auth_key, Long source_client_no, String target_client_name, String destination_email, Long acct_template_no, String user_id, String first_name, String last_name, String users_email, String users_password_first, String users_secret_question, String users_secret_question_answer){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"source_client_no", getValue("Long", source_client_no));
        addParameters(parameters,"target_client_name", getValue("String", target_client_name));
        addParameters(parameters,"destination_email", getValue("String", destination_email));
        addParameters(parameters,"acct_template_no", getValue("Long", acct_template_no));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"users_email", getValue("String", users_email));
        addParameters(parameters,"users_password_first", getValue("String", users_password_first));
        addParameters(parameters,"users_secret_question", getValue("String", users_secret_question));
        addParameters(parameters,"users_secret_question_answer", getValue("String", users_secret_question_answer));
        
        WebResource webResource = client.resource(buildUrl("create_channel"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[4];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "client_no";
        returnValues[3] = "acct_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createChannel(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long source_client_no = (Long) map.get("source_client_no");
        String target_client_name = (String) map.get("target_client_name");
        String destination_email = (String) map.get("destination_email");
        Long acct_template_no = (Long) map.get("acct_template_no");
        String user_id = (String) map.get("user_id");
        String first_name = (String) map.get("first_name");
        String last_name = (String) map.get("last_name");
        String users_email = (String) map.get("users_email");
        String users_password_first = (String) map.get("users_password_first");
        String users_secret_question = (String) map.get("users_secret_question");
        String users_secret_question_answer = (String) map.get("users_secret_question_answer");
        
        return createChannel(client_no, auth_key, source_client_no, target_client_name, destination_email, acct_template_no, user_id, first_name, last_name, users_email, users_password_first, users_secret_question, users_secret_question_answer);
    }

    public Map<String,Object> copyClient(Long client_no, String auth_key, Long source_client_no, String target_client_name, String destination_email, String user_id, String first_name, String last_name, String users_email, String users_password_first, String users_secret_question, String users_secret_question_answer){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"source_client_no", getValue("Long", source_client_no));
        addParameters(parameters,"target_client_name", getValue("String", target_client_name));
        addParameters(parameters,"destination_email", getValue("String", destination_email));
        addParameters(parameters,"user_id", getValue("String", user_id));
        addParameters(parameters,"first_name", getValue("String", first_name));
        addParameters(parameters,"last_name", getValue("String", last_name));
        addParameters(parameters,"users_email", getValue("String", users_email));
        addParameters(parameters,"users_password_first", getValue("String", users_password_first));
        addParameters(parameters,"users_secret_question", getValue("String", users_secret_question));
        addParameters(parameters,"users_secret_question_answer", getValue("String", users_secret_question_answer));
        
        WebResource webResource = client.resource(buildUrl("copy_client"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "client_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> copyClient(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long source_client_no = (Long) map.get("source_client_no");
        String target_client_name = (String) map.get("target_client_name");
        String destination_email = (String) map.get("destination_email");
        String user_id = (String) map.get("user_id");
        String first_name = (String) map.get("first_name");
        String last_name = (String) map.get("last_name");
        String users_email = (String) map.get("users_email");
        String users_password_first = (String) map.get("users_password_first");
        String users_secret_question = (String) map.get("users_secret_question");
        String users_secret_question_answer = (String) map.get("users_secret_question_answer");
        
        return copyClient(client_no, auth_key, source_client_no, target_client_name, destination_email, user_id, first_name, last_name, users_email, users_password_first, users_secret_question, users_secret_question_answer);
    }

    public Map<String,Object> getRevrecProfiles(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_revrec_profiles"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "profiles";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getRevrecProfiles(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getRevrecProfiles(client_no, auth_key);
    }

    public Map<String,Object> getRevrecProfileDetails(Long client_no, String auth_key, Long profile_id, String client_profile_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"profile_id", getValue("Long", profile_id));
        addParameters(parameters,"client_profile_id", getValue("String", client_profile_id));
        
        WebResource webResource = client.resource(buildUrl("get_revrec_profile_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[9];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "profile_id";
        returnValues[3] = "profile_name";
        returnValues[4] = "client_profile_id";
        returnValues[5] = "profile_desc";
        returnValues[6] = "on_plan_payment_date";
        returnValues[7] = "on_order_payment_date";
        returnValues[8] = "on_order_fulfill_date";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getRevrecProfileDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long profile_id = (Long) map.get("profile_id");
        String client_profile_id = (String) map.get("client_profile_id");
        
        return getRevrecProfileDetails(client_no, auth_key, profile_id, client_profile_id);
    }

    public Map<String,Object> createRevrecProfile(Long client_no, String auth_key, String profile_name, String client_profile_id, String profile_desc, Long on_plan_payment_date, Long on_order_payment_date, Long on_order_fulfill_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"profile_name", getValue("String", profile_name));
        addParameters(parameters,"client_profile_id", getValue("String", client_profile_id));
        addParameters(parameters,"profile_desc", getValue("String", profile_desc));
        addParameters(parameters,"on_plan_payment_date", getValue("Long", on_plan_payment_date));
        addParameters(parameters,"on_order_payment_date", getValue("Long", on_order_payment_date));
        addParameters(parameters,"on_order_fulfill_date", getValue("Long", on_order_fulfill_date));
        
        WebResource webResource = client.resource(buildUrl("create_revrec_profile"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "profile_id";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createRevrecProfile(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String profile_name = (String) map.get("profile_name");
        String client_profile_id = (String) map.get("client_profile_id");
        String profile_desc = (String) map.get("profile_desc");
        Long on_plan_payment_date = (Long) map.get("on_plan_payment_date");
        Long on_order_payment_date = (Long) map.get("on_order_payment_date");
        Long on_order_fulfill_date = (Long) map.get("on_order_fulfill_date");
        
        return createRevrecProfile(client_no, auth_key, profile_name, client_profile_id, profile_desc, on_plan_payment_date, on_order_payment_date, on_order_fulfill_date);
    }

    public Map<String,Object> updateRevrecProfile(Long client_no, String auth_key, Long profile_id, String profile_name, String client_profile_id, String profile_desc, Long on_plan_payment_date, Long on_order_payment_date, Long on_order_fulfill_date){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"profile_id", getValue("Long", profile_id));
        addParameters(parameters,"profile_name", getValue("String", profile_name));
        addParameters(parameters,"client_profile_id", getValue("String", client_profile_id));
        addParameters(parameters,"profile_desc", getValue("String", profile_desc));
        addParameters(parameters,"on_plan_payment_date", getValue("Long", on_plan_payment_date));
        addParameters(parameters,"on_order_payment_date", getValue("Long", on_order_payment_date));
        addParameters(parameters,"on_order_fulfill_date", getValue("Long", on_order_fulfill_date));
        
        WebResource webResource = client.resource(buildUrl("update_revrec_profile"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "profile_id";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateRevrecProfile(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long profile_id = (Long) map.get("profile_id");
        String profile_name = (String) map.get("profile_name");
        String client_profile_id = (String) map.get("client_profile_id");
        String profile_desc = (String) map.get("profile_desc");
        Long on_plan_payment_date = (Long) map.get("on_plan_payment_date");
        Long on_order_payment_date = (Long) map.get("on_order_payment_date");
        Long on_order_fulfill_date = (Long) map.get("on_order_fulfill_date");
        
        return updateRevrecProfile(client_no, auth_key, profile_id, profile_name, client_profile_id, profile_desc, on_plan_payment_date, on_order_payment_date, on_order_fulfill_date);
    }

    public Map<String,Object> deleteRevrecProfile(Long client_no, String auth_key, Long profile_id, String client_profile_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"profile_id", getValue("Long", profile_id));
        addParameters(parameters,"client_profile_id", getValue("String", client_profile_id));
        
        WebResource webResource = client.resource(buildUrl("delete_revrec_profile"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteRevrecProfile(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long profile_id = (Long) map.get("profile_id");
        String client_profile_id = (String) map.get("client_profile_id");
        
        return deleteRevrecProfile(client_no, auth_key, profile_id, client_profile_id);
    }

    public Map<String,Object> createProductFieldCategory(Long client_no, String auth_key, String field_category_name, com.aria.common.shared.admin.AssignCategoryPlansArray assign_category_plans, com.aria.common.shared.admin.AssignCategoryFieldsArray assign_category_fields){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_category_name", getValue("String", field_category_name));
        RestUtilities.addParameterValuesFromArray(parameters, assign_category_plans, "assign_category_plans");
        RestUtilities.addParameterValuesFromArray(parameters, assign_category_fields, "assign_category_fields");
        
        WebResource webResource = client.resource(buildUrl("create_product_field_category"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_category_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createProductFieldCategory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String field_category_name = (String) map.get("field_category_name");
        com.aria.common.shared.admin.AssignCategoryPlansArray assign_category_plans = (com.aria.common.shared.admin.AssignCategoryPlansArray) map.get("assign_category_plans");
        com.aria.common.shared.admin.AssignCategoryFieldsArray assign_category_fields = (com.aria.common.shared.admin.AssignCategoryFieldsArray) map.get("assign_category_fields");
        
        return createProductFieldCategory(client_no, auth_key, field_category_name, assign_category_plans, assign_category_fields);
    }

    public Map<String,Object> editProductFieldCategory(Long client_no, String auth_key, Long field_category_no, String field_category_name, String new_category_name, com.aria.common.shared.admin.AssignCategoryPlansArray assign_category_plans, com.aria.common.shared.admin.AssignCategoryFieldsArray assign_category_fields){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_category_no", getValue("Long", field_category_no));
        addParameters(parameters,"field_category_name", getValue("String", field_category_name));
        addParameters(parameters,"new_category_name", getValue("String", new_category_name));
        RestUtilities.addParameterValuesFromArray(parameters, assign_category_plans, "assign_category_plans");
        RestUtilities.addParameterValuesFromArray(parameters, assign_category_fields, "assign_category_fields");
        
        WebResource webResource = client.resource(buildUrl("edit_product_field_category"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "field_category_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> editProductFieldCategory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_category_no = (Long) map.get("field_category_no");
        String field_category_name = (String) map.get("field_category_name");
        String new_category_name = (String) map.get("new_category_name");
        com.aria.common.shared.admin.AssignCategoryPlansArray assign_category_plans = (com.aria.common.shared.admin.AssignCategoryPlansArray) map.get("assign_category_plans");
        com.aria.common.shared.admin.AssignCategoryFieldsArray assign_category_fields = (com.aria.common.shared.admin.AssignCategoryFieldsArray) map.get("assign_category_fields");
        
        return editProductFieldCategory(client_no, auth_key, field_category_no, field_category_name, new_category_name, assign_category_plans, assign_category_fields);
    }

    public Map<String,Object> deleteProductFieldCategory(Long client_no, String auth_key, Long field_category_no, String field_category_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_category_no", getValue("Long", field_category_no));
        addParameters(parameters,"field_category_name", getValue("String", field_category_name));
        
        WebResource webResource = client.resource(buildUrl("delete_product_field_category"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[2];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> deleteProductFieldCategory(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_category_no = (Long) map.get("field_category_no");
        String field_category_name = (String) map.get("field_category_name");
        
        return deleteProductFieldCategory(client_no, auth_key, field_category_no, field_category_name);
    }

    public Map<String,Object> getProductFieldCategories(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_product_field_categories"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "product_field_category";
        returnValues[1] = "error_code";
        returnValues[2] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getProductFieldCategories(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getProductFieldCategories(client_no, auth_key);
    }

    public Map<String,Object> getProductFieldCategoryDetails(Long client_no, String auth_key, Long field_category_no, String field_category_name){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"field_category_no", getValue("Long", field_category_no));
        addParameters(parameters,"field_category_name", getValue("String", field_category_name));
        
        WebResource webResource = client.resource(buildUrl("get_product_field_category_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[6];

        returnValues[0] = "field_category_no";
        returnValues[1] = "field_category_name";
        returnValues[2] = "plan";
        returnValues[3] = "product_fields";
        returnValues[4] = "error_code";
        returnValues[5] = "error_msg";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getProductFieldCategoryDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long field_category_no = (Long) map.get("field_category_no");
        String field_category_name = (String) map.get("field_category_name");
        
        return getProductFieldCategoryDetails(client_no, auth_key, field_category_no, field_category_name);
    }

    public Map<String,Object> createCouponGroup(Long client_no, String auth_key, String group_name, String client_defined_id, String description, String precedence, com.aria.common.shared.admin.CouponsArray coupons){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_name", getValue("String", group_name));
        addParameters(parameters,"client_defined_id", getValue("String", client_defined_id));
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"precedence", getValue("String", precedence));
        RestUtilities.addParameterValuesFromArray(parameters, coupons, "coupons");
        
        WebResource webResource = client.resource(buildUrl("create_coupon_group"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "group_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> createCouponGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String group_name = (String) map.get("group_name");
        String client_defined_id = (String) map.get("client_defined_id");
        String description = (String) map.get("description");
        String precedence = (String) map.get("precedence");
        com.aria.common.shared.admin.CouponsArray coupons = (com.aria.common.shared.admin.CouponsArray) map.get("coupons");
        
        return createCouponGroup(client_no, auth_key, group_name, client_defined_id, description, precedence, coupons);
    }

    public Map<String,Object> updateCouponGroup(Long client_no, String auth_key, Long group_no, String group_name, String client_defined_id, String description, String precedence, Long edit_directive, com.aria.common.shared.admin.CouponsArray coupons){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_no", getValue("Long", group_no));
        addParameters(parameters,"group_name", getValue("String", group_name));
        addParameters(parameters,"client_defined_id", getValue("String", client_defined_id));
        addParameters(parameters,"description", getValue("String", description));
        addParameters(parameters,"precedence", getValue("String", precedence));
        addParameters(parameters,"edit_directive", getValue("Long", edit_directive));
        RestUtilities.addParameterValuesFromArray(parameters, coupons, "coupons");
        
        WebResource webResource = client.resource(buildUrl("update_coupon_group"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "group_no";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> updateCouponGroup(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        Long group_no = (Long) map.get("group_no");
        String group_name = (String) map.get("group_name");
        String client_defined_id = (String) map.get("client_defined_id");
        String description = (String) map.get("description");
        String precedence = (String) map.get("precedence");
        Long edit_directive = (Long) map.get("edit_directive");
        com.aria.common.shared.admin.CouponsArray coupons = (com.aria.common.shared.admin.CouponsArray) map.get("coupons");
        
        return updateCouponGroup(client_no, auth_key, group_no, group_name, client_defined_id, description, precedence, edit_directive, coupons);
    }

    public Map<String,Object> getCouponGroups(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_coupon_groups"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupon_groups";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCouponGroups(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getCouponGroups(client_no, auth_key);
    }

    public Map<String,Object> getCouponGroupDetails(Long client_no, String auth_key, String group_no, String client_defined_id){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        addParameters(parameters,"group_no", getValue("String", group_no));
        addParameters(parameters,"client_defined_id", getValue("String", client_defined_id));
        
        WebResource webResource = client.resource(buildUrl("get_coupon_group_details"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "coupon_groups";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getCouponGroupDetails(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        String group_no = (String) map.get("group_no");
        String client_defined_id = (String) map.get("client_defined_id");
        
        return getCouponGroupDetails(client_no, auth_key, group_no, client_defined_id);
    }

    public Map<String,Object> getClientPaymentMethod(Long client_no, String auth_key){
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        addParameters(parameters,"client_no",getValue("Long",client_no));
        addParameters(parameters,"auth_key",getValue("String",auth_key));
        
        WebResource webResource = client.resource(buildUrl("get_client_payment_method"));
        String ret = webResource.type("application/x-www-form-urlencoded").accept("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("accept-encoding", "deflate").header("accept-encoding", "gzip").post(String.class, parameters);
        String[] returnValues = new String[3];

        returnValues[0] = "error_code";
        returnValues[1] = "error_msg";
        returnValues[2] = "all_pay_methods";
        
        return buildHashMapReturnValues(ret,returnValues);
    }

    public Map<String,Object> getClientPaymentMethod(Map<String,Object> map){
        Long client_no = (Long) map.get("client_no");
        String auth_key = (String) map.get("auth_key");
        
        return getClientPaymentMethod(client_no, auth_key);
    }

    /********************************** END - METHODS IMPLEMENTATION ***********************************************/
}
