package com.aria.sdk.classes;

import java.util.Map;

/**
 * AriaBillingAdministration
 * Web Service class
 * @copyright Aria Systems, Inc
 * @author (Automatic generated) Aria
 */
public interface AriaBillingAdministration {
    /********************************** METHODS ***********************************************/
    /**
    * getPromoPlanSets
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promo_plan_set - Type: ArrayList&#60;PromoPlanSetReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPromoPlanSets(Long client_no, String auth_key);

    abstract Map<String,Object> getPromoPlanSets(Map<String,Object> map);

    /**
    * getPromoPlanSetDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param promo_plan_set_no - Type: Long
            * @param client_plan_type_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promo_plan_set_no - Type: javax.xml.ws.Holder<br>
    *   promo_plan_set_name - Type: javax.xml.ws.Holder<br>
    *   promo_plan_set_desc - Type: javax.xml.ws.Holder<br>
    *   client_plan_type_id - Type: javax.xml.ws.Holder<br>
    *   plan - Type: ArrayList&#60;PlanReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPromoPlanSetDetails(Long client_no, String auth_key, Long promo_plan_set_no, String client_plan_type_id);

    abstract Map<String,Object> getPromoPlanSetDetails(Map<String,Object> map);

    /**
    * createPromoPlanSet
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param promo_plan_set_name - Type: String
            * @param promo_plan_set_desc - Type: String
            * @param client_plan_type_id - Type: String
            * @param plan_no - Type: String
            * @param client_plan_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promo_plan_set_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createPromoPlanSet(Long client_no, String auth_key, String promo_plan_set_name, String promo_plan_set_desc, String client_plan_type_id, String plan_no, String client_plan_id);

    abstract Map<String,Object> createPromoPlanSet(Map<String,Object> map);

    /**
    * updatePromoPlanSet
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param promo_plan_set_no - Type: Long
            * @param promo_plan_set_name - Type: String
            * @param promo_plan_set_desc - Type: String
            * @param client_plan_type_id - Type: String
            * @param plan_no - Type: String
            * @param client_plan_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promo_plan_set_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updatePromoPlanSet(Long client_no, String auth_key, Long promo_plan_set_no, String promo_plan_set_name, String promo_plan_set_desc, String client_plan_type_id, String plan_no, String client_plan_id);

    abstract Map<String,Object> updatePromoPlanSet(Map<String,Object> map);

    /**
    * listPromoSets
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_groups - Type: ArrayList&#60;PlanGroupsReturnElement&#62;<br>
    */
    abstract Map<String,Object> listPromoSets(Long client_no, String auth_key);

    abstract Map<String,Object> listPromoSets(Map<String,Object> map);

    /**
    * getCompanyProfile
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   client_name - Type: javax.xml.ws.Holder<br>
    *   domain - Type: javax.xml.ws.Holder<br>
    *   address1 - Type: javax.xml.ws.Holder<br>
    *   address2 - Type: javax.xml.ws.Holder<br>
    *   city - Type: javax.xml.ws.Holder<br>
    *   locality - Type: javax.xml.ws.Holder<br>
    *   state_prov - Type: javax.xml.ws.Holder<br>
    *   country - Type: javax.xml.ws.Holder<br>
    *   postal_code - Type: javax.xml.ws.Holder<br>
    *   phone - Type: javax.xml.ws.Holder<br>
    *   contact - Type: javax.xml.ws.Holder<br>
    *   contact_address1 - Type: javax.xml.ws.Holder<br>
    *   contact_address2 - Type: javax.xml.ws.Holder<br>
    *   contact_city - Type: javax.xml.ws.Holder<br>
    *   contact_state - Type: javax.xml.ws.Holder<br>
    *   contact_zip - Type: javax.xml.ws.Holder<br>
    *   contact_phone - Type: javax.xml.ws.Holder<br>
    *   contact_email - Type: javax.xml.ws.Holder<br>
    *   billing_contact - Type: javax.xml.ws.Holder<br>
    *   billing_address1 - Type: javax.xml.ws.Holder<br>
    *   billing_address2 - Type: javax.xml.ws.Holder<br>
    *   billing_city - Type: javax.xml.ws.Holder<br>
    *   billing_state - Type: javax.xml.ws.Holder<br>
    *   billing_zip - Type: javax.xml.ws.Holder<br>
    *   billing_phone - Type: javax.xml.ws.Holder<br>
    *   billing_email - Type: javax.xml.ws.Holder<br>
    *   contact_country - Type: javax.xml.ws.Holder<br>
    *   contact_locality - Type: javax.xml.ws.Holder<br>
    *   billing_country - Type: javax.xml.ws.Holder<br>
    *   billing_locality - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getCompanyProfile(Long client_no, String auth_key);

    abstract Map<String,Object> getCompanyProfile(Map<String,Object> map);

    /**
    * setCompanyProfile
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param domain - Type: String
            * @param address1 - Type: String
            * @param address2 - Type: String
            * @param city - Type: String
            * @param locality - Type: String
            * @param state_prov - Type: String
            * @param country - Type: String
            * @param postal_code - Type: String
            * @param phone - Type: String
            * @param contact - Type: String
            * @param contact_address1 - Type: String
            * @param contact_address2 - Type: String
            * @param contact_city - Type: String
            * @param contact_state - Type: String
            * @param contact_zip - Type: String
            * @param contact_phone - Type: String
            * @param contact_email - Type: String
            * @param billing_contact - Type: String
            * @param billing_address1 - Type: String
            * @param billing_address2 - Type: String
            * @param billing_city - Type: String
            * @param billing_state - Type: String
            * @param billing_zip - Type: String
            * @param billing_phone - Type: String
            * @param billing_email - Type: String
            * @param contact_country - Type: String
            * @param contact_locality - Type: String
            * @param billing_country - Type: String
            * @param billing_locality - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   client_name - Type: javax.xml.ws.Holder<br>
    *   domain - Type: javax.xml.ws.Holder<br>
    *   address1 - Type: javax.xml.ws.Holder<br>
    *   address2 - Type: javax.xml.ws.Holder<br>
    *   city - Type: javax.xml.ws.Holder<br>
    *   locality - Type: javax.xml.ws.Holder<br>
    *   state_prov - Type: javax.xml.ws.Holder<br>
    *   country - Type: javax.xml.ws.Holder<br>
    *   postal_code - Type: javax.xml.ws.Holder<br>
    *   phone - Type: javax.xml.ws.Holder<br>
    *   contact - Type: javax.xml.ws.Holder<br>
    *   contact_address1 - Type: javax.xml.ws.Holder<br>
    *   contact_address2 - Type: javax.xml.ws.Holder<br>
    *   contact_city - Type: javax.xml.ws.Holder<br>
    *   contact_state - Type: javax.xml.ws.Holder<br>
    *   contact_zip - Type: javax.xml.ws.Holder<br>
    *   contact_phone - Type: javax.xml.ws.Holder<br>
    *   contact_email - Type: javax.xml.ws.Holder<br>
    *   billing_contact - Type: javax.xml.ws.Holder<br>
    *   billing_address1 - Type: javax.xml.ws.Holder<br>
    *   billing_address2 - Type: javax.xml.ws.Holder<br>
    *   billing_city - Type: javax.xml.ws.Holder<br>
    *   billing_state - Type: javax.xml.ws.Holder<br>
    *   billing_zip - Type: javax.xml.ws.Holder<br>
    *   billing_phone - Type: javax.xml.ws.Holder<br>
    *   billing_email - Type: javax.xml.ws.Holder<br>
    *   contact_country - Type: javax.xml.ws.Holder<br>
    *   contact_locality - Type: javax.xml.ws.Holder<br>
    *   billing_country - Type: javax.xml.ws.Holder<br>
    *   billing_locality - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> setCompanyProfile(Long client_no, String auth_key, String domain, String address1, String address2, String city, String locality, String state_prov, String country, String postal_code, String phone, String contact, String contact_address1, String contact_address2, String contact_city, String contact_state, String contact_zip, String contact_phone, String contact_email, String billing_contact, String billing_address1, String billing_address2, String billing_city, String billing_state, String billing_zip, String billing_phone, String billing_email, String contact_country, String contact_locality, String billing_country, String billing_locality);

    abstract Map<String,Object> setCompanyProfile(Map<String,Object> map);

    /**
    * getInventoryItems
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   inventory_items - Type: ArrayList&#60;InventoryItemsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getInventoryItems(Long client_no, String auth_key);

    abstract Map<String,Object> getInventoryItems(Map<String,Object> map);

    /**
    * getInventoryItemDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param item_no - Type: Long
            * @param client_item_id - Type: String
            * @param currency_cd - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   item_no - Type: javax.xml.ws.Holder<br>
    *   client_item_id - Type: javax.xml.ws.Holder<br>
    *   item_type - Type: javax.xml.ws.Holder<br>
    *   item_name - Type: javax.xml.ws.Holder<br>
    *   item_desc - Type: javax.xml.ws.Holder<br>
    *   active_ind - Type: javax.xml.ws.Holder<br>
    *   service_no - Type: javax.xml.ws.Holder<br>
    *   client_service_id - Type: javax.xml.ws.Holder<br>
    *   invoice_advancement_months - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    *   client_plan_id - Type: javax.xml.ws.Holder<br>
    *   client_sku - Type: javax.xml.ws.Holder<br>
    *   pricing - Type: ArrayList&#60;PricingReturnElement&#62;<br>
    *   modify_price_ind - Type: javax.xml.ws.Holder<br>
    *   subunit_qty - Type: javax.xml.ws.Holder<br>
    *   subunit_label - Type: javax.xml.ws.Holder<br>
    *   days_to_expiry - Type: javax.xml.ws.Holder<br>
    *   resources - Type: ArrayList&#60;ResourcesReturnElement&#62;<br>
    *   stock_level - Type: javax.xml.ws.Holder<br>
    *   image - Type: ArrayList&#60;ImageReturnElement&#62;<br>
    *   supplemental_obj_fields - Type: ArrayList&#60;SupplementalObjFieldsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getInventoryItemDetails(Long client_no, String auth_key, Long item_no, String client_item_id, String currency_cd);

    abstract Map<String,Object> getInventoryItemDetails(Map<String,Object> map);

    /**
    * createInventoryItem
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param item_type - Type: Long
            * @param item_name - Type: String
            * @param item_desc - Type: String
            * @param service - Type: com.aria.common.shared.admin.ServiceArray
            * @param client_sku - Type: String
            * @param currency_cd - Type: String
            * @param item_price - Type: String
            * @param client_item_id - Type: String
            * @param active_ind - Type: Long
            * @param invoice_advancement_months - Type: Long
            * @param plan_no - Type: Long
            * @param client_plan_id - Type: String
            * @param tax_inclusive_ind - Type: Long
            * @param modify_price_ind - Type: String
            * @param subunit_qty - Type: Long
            * @param subunit_label - Type: String
            * @param days_to_expiry - Type: Long
            * @param resource_type_no - Type: String
            * @param resource_units - Type: String
            * @param stock_level_track - Type: Long
            * @param stock_level_adjust - Type: Double
            * @param image - Type: com.aria.common.shared.admin.ImageArray
            * @param parent_class - Type: com.aria.common.shared.admin.ParentClassArray
            * @param supplemental_obj_field - Type: com.aria.common.shared.admin.SupplementalObjFieldArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   item_no - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createInventoryItem(Long client_no, String auth_key, Long item_type, String item_name, String item_desc, com.aria.common.shared.admin.ServiceArray service, String client_sku, String currency_cd, String item_price, String client_item_id, Long active_ind, Long invoice_advancement_months, Long plan_no, String client_plan_id, Long tax_inclusive_ind, String modify_price_ind, Long subunit_qty, String subunit_label, Long days_to_expiry, String resource_type_no, String resource_units, Long stock_level_track, Double stock_level_adjust, com.aria.common.shared.admin.ImageArray image, com.aria.common.shared.admin.ParentClassArray parent_class, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field);

    abstract Map<String,Object> createInventoryItem(Map<String,Object> map);

    /**
    * updateInventoryItem
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param item_no - Type: String
            * @param item_name - Type: String
            * @param item_desc - Type: String
            * @param client_item_id - Type: String
            * @param service_no - Type: Long
            * @param client_service_id - Type: String
            * @param currency_cd - Type: String
            * @param item_price - Type: String
            * @param active_ind - Type: Long
            * @param invoice_advancement_months - Type: Long
            * @param plan_no - Type: Long
            * @param client_plan_id - Type: String
            * @param modify_price_ind - Type: String
            * @param subunit_qty - Type: Long
            * @param subunit_label - Type: String
            * @param days_to_expiry - Type: Long
            * @param resource_type_no - Type: String
            * @param resource_units - Type: String
            * @param stock_level_track - Type: Long
            * @param stock_level_adjust - Type: Double
            * @param image - Type: com.aria.common.shared.admin.ImageArray
            * @param parent_class - Type: com.aria.common.shared.admin.ParentClassArray
            * @param supplemental_obj_field - Type: com.aria.common.shared.admin.SupplementalObjFieldArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   item_no - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateInventoryItem(Long client_no, String auth_key, String item_no, String item_name, String item_desc, String client_item_id, Long service_no, String client_service_id, String currency_cd, String item_price, Long active_ind, Long invoice_advancement_months, Long plan_no, String client_plan_id, String modify_price_ind, Long subunit_qty, String subunit_label, Long days_to_expiry, String resource_type_no, String resource_units, Long stock_level_track, Double stock_level_adjust, com.aria.common.shared.admin.ImageArray image, com.aria.common.shared.admin.ParentClassArray parent_class, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field);

    abstract Map<String,Object> updateInventoryItem(Map<String,Object> map);

    /**
    * createItemClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param class_name - Type: String
            * @param class_desc - Type: String
            * @param active_ind - Type: Long
            * @param client_inventory_class_id - Type: String
            * @param parent_class - Type: com.aria.common.shared.admin.ParentClassArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   class_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createItemClass(Long client_no, String auth_key, String class_name, String class_desc, Long active_ind, String client_inventory_class_id, com.aria.common.shared.admin.ParentClassArray parent_class);

    abstract Map<String,Object> createItemClass(Map<String,Object> map);

    /**
    * editItemClass
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param class_no - Type: String
            * @param class_name - Type: String
            * @param client_inventory_class_id - Type: String
            * @param class_desc - Type: String
            * @param active_ind - Type: Long
            * @param parent_class - Type: com.aria.common.shared.admin.ParentClassArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   class_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> editItemClass(Long client_no, String auth_key, String class_no, String class_name, String client_inventory_class_id, String class_desc, Long active_ind, com.aria.common.shared.admin.ParentClassArray parent_class);

    abstract Map<String,Object> editItemClass(Map<String,Object> map);

    /**
    * getServiceTypes
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   service_types - Type: ArrayList&#60;ServiceTypesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getServiceTypes(Long client_no, String auth_key);

    abstract Map<String,Object> getServiceTypes(Map<String,Object> map);

    /**
    * getServices
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   services - Type: ArrayList&#60;ServicesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getServices(Long client_no, String auth_key);

    abstract Map<String,Object> getServices(Map<String,Object> map);

    /**
    * getServiceDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param service_no - Type: Long
            * @param client_service_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   service_no - Type: javax.xml.ws.Holder<br>
    *   client_service_id - Type: javax.xml.ws.Holder<br>
    *   service_name - Type: javax.xml.ws.Holder<br>
    *   service_type - Type: javax.xml.ws.Holder<br>
    *   gl_cd - Type: javax.xml.ws.Holder<br>
    *   taxable_ind - Type: javax.xml.ws.Holder<br>
    *   tax_group - Type: javax.xml.ws.Holder<br>
    *   client_tax_group_id - Type: javax.xml.ws.Holder<br>
    *   usage_type - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getServiceDetails(Long client_no, String auth_key, Long service_no, String client_service_id);

    abstract Map<String,Object> getServiceDetails(Map<String,Object> map);

    /**
    * getPlanServiceDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param service_no - Type: Long
            * @param client_service_id - Type: String
            * @param plan_no - Type: Long
            * @param client_plan_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    *   client_plan_id - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    *   service_no - Type: javax.xml.ws.Holder<br>
    *   service_name - Type: javax.xml.ws.Holder<br>
    *   service_type - Type: javax.xml.ws.Holder<br>
    *   client_service_id - Type: javax.xml.ws.Holder<br>
    *   taxable_ind - Type: javax.xml.ws.Holder<br>
    *   tax_group - Type: javax.xml.ws.Holder<br>
    *   client_tax_group_id - Type: javax.xml.ws.Holder<br>
    *   gl_cd - Type: javax.xml.ws.Holder<br>
    *   usage_type - Type: javax.xml.ws.Holder<br>
    *   rate_type - Type: javax.xml.ws.Holder<br>
    *   rate_schedules - Type: ArrayList&#60;RateSchedulesReturnElement&#62;<br>
    *   parent_plans - Type: ArrayList&#60;ParentPlansReturnElement&#62;<br>
    *   parent_plan_ids - Type: ArrayList&#60;ParentPlanIdsReturnElement&#62;<br>
    *   exclusion_plans - Type: ArrayList&#60;ExclusionPlansReturnElement&#62;<br>
    *   supplemental_obj_fields - Type: ArrayList&#60;SupplementalObjFieldsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlanServiceDetails(Long client_no, String auth_key, Long service_no, String client_service_id, Long plan_no, String client_plan_id);

    abstract Map<String,Object> getPlanServiceDetails(Map<String,Object> map);

    /**
    * createService
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param service_name - Type: String
            * @param service_type - Type: String
            * @param gl_cd - Type: String
            * @param taxable_ind - Type: String
            * @param tax_group - Type: String
            * @param usage_type - Type: String
            * @param client_service_id - Type: String
            * @param supplemental_obj_field - Type: com.aria.common.shared.admin.SupplementalObjFieldArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   service_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createService(Long client_no, String auth_key, String service_name, String service_type, String gl_cd, String taxable_ind, String tax_group, String usage_type, String client_service_id, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field);

    abstract Map<String,Object> createService(Map<String,Object> map);

    /**
    * updateService
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param service_no - Type: Long
            * @param service_name - Type: String
            * @param service_type - Type: String
            * @param client_service_id - Type: String
            * @param gl_cd - Type: String
            * @param taxable_ind - Type: String
            * @param tax_group - Type: String
            * @param usage_type - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   service_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateService(Long client_no, String auth_key, Long service_no, String service_name, String service_type, String client_service_id, String gl_cd, String taxable_ind, String tax_group, String usage_type);

    abstract Map<String,Object> updateService(Map<String,Object> map);

    /**
    * getSuppFields
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   supp_fields - Type: ArrayList&#60;SuppFieldsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSuppFields(Long client_no, String auth_key);

    abstract Map<String,Object> getSuppFields(Map<String,Object> map);

    /**
    * getSuppFieldDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param field_name - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   field_name - Type: javax.xml.ws.Holder<br>
    *   field_desc - Type: javax.xml.ws.Holder<br>
    *   field_order - Type: javax.xml.ws.Holder<br>
    *   required_ind - Type: javax.xml.ws.Holder<br>
    *   hidden_ind - Type: javax.xml.ws.Holder<br>
    *   presentation_mode - Type: javax.xml.ws.Holder<br>
    *   min_no_sel - Type: javax.xml.ws.Holder<br>
    *   max_no_sel - Type: javax.xml.ws.Holder<br>
    *   additional_html - Type: javax.xml.ws.Holder<br>
    *   extra_validation_methods - Type: javax.xml.ws.Holder<br>
    *   field_options - Type: ArrayList&#60;FieldOptionsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSuppFieldDetails(Long client_no, String auth_key, String field_name);

    abstract Map<String,Object> getSuppFieldDetails(Map<String,Object> map);

    /**
    * createSuppField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param field_name - Type: String
            * @param field_order - Type: Long
            * @param presentation_mode - Type: String
            * @param field_desc - Type: String
            * @param required_ind - Type: Long
            * @param hidden_ind - Type: Long
            * @param sel_ind - Type: Long
            * @param min_no_sel - Type: Long
            * @param max_no_sel - Type: Long
            * @param display_text - Type: String
            * @param option_value - Type: String
            * @param option_value_order - Type: Long
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   field_name - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createSuppField(Long client_no, String auth_key, String field_name, Long field_order, String presentation_mode, String field_desc, Long required_ind, Long hidden_ind, Long sel_ind, Long min_no_sel, Long max_no_sel, String display_text, String option_value, Long option_value_order);

    abstract Map<String,Object> createSuppField(Map<String,Object> map);

    /**
    * updateSuppField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param field_name - Type: String
            * @param field_desc - Type: String
            * @param field_order - Type: Long
            * @param required_ind - Type: Long
            * @param hidden_ind - Type: Long
            * @param sel_ind - Type: Long
            * @param presentation_mode - Type: String
            * @param min_no_sel - Type: Long
            * @param max_no_sel - Type: Long
            * @param display_text - Type: String
            * @param option_value - Type: String
            * @param option_value_order - Type: Long
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   field_name - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateSuppField(Long client_no, String auth_key, String field_name, String field_desc, Long field_order, Long required_ind, Long hidden_ind, Long sel_ind, String presentation_mode, Long min_no_sel, Long max_no_sel, String display_text, String option_value, Long option_value_order);

    abstract Map<String,Object> updateSuppField(Map<String,Object> map);

    /**
    * getCoupons
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coupons - Type: ArrayList&#60;CouponsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCoupons(Long client_no, String auth_key);

    abstract Map<String,Object> getCoupons(Map<String,Object> map);

    /**
    * getCouponDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coupon_cd - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coupon_cd - Type: javax.xml.ws.Holder<br>
    *   coupon_desc - Type: javax.xml.ws.Holder<br>
    *   coupon_msg - Type: javax.xml.ws.Holder<br>
    *   status_ind - Type: javax.xml.ws.Holder<br>
    *   no_of_uses - Type: javax.xml.ws.Holder<br>
    *   start_date - Type: javax.xml.ws.Holder<br>
    *   end_date - Type: javax.xml.ws.Holder<br>
    *   credit_template - Type: ArrayList&#60;CreditTemplateReturnElement&#62;<br>
    *   discount_rule - Type: ArrayList&#60;DiscountRuleReturnElement&#62;<br>
    *   discount_bundle - Type: ArrayList&#60;DiscountBundleReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCouponDetails(Long client_no, String auth_key, String coupon_cd);

    abstract Map<String,Object> getCouponDetails(Map<String,Object> map);

    /**
    * createCoupon
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coupon_cd - Type: String
            * @param status_ind - Type: Long
            * @param start_date - Type: String
            * @param end_date - Type: String
            * @param coupon_desc - Type: String
            * @param coupon_msg - Type: String
            * @param no_of_uses - Type: Long
            * @param template - Type: com.aria.common.shared.admin.TemplateArray
            * @param existing_template - Type: com.aria.common.shared.admin.ExistingTemplateArray
            * @param existing_template_id - Type: com.aria.common.shared.admin.ExistingTemplateIdArray
            * @param discount_rule - Type: com.aria.common.shared.admin.DiscountRuleArray
            * @param existing_discount_rule - Type: com.aria.common.shared.admin.ExistingDiscountRuleArray
            * @param existing_discount_rule_id - Type: com.aria.common.shared.admin.ExistingDiscountRuleIdArray
            * @param discount_bundle - Type: com.aria.common.shared.admin.DiscountBundleArray
            * @param existing_discount_bundle - Type: com.aria.common.shared.admin.ExistingDiscountBundleArray
            * @param existing_discount_bundle_id - Type: com.aria.common.shared.admin.ExistingDiscountBundleIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coupon_cd - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createCoupon(Long client_no, String auth_key, String coupon_cd, Long status_ind, String start_date, String end_date, String coupon_desc, String coupon_msg, Long no_of_uses, com.aria.common.shared.admin.TemplateArray template, com.aria.common.shared.admin.ExistingTemplateArray existing_template, com.aria.common.shared.admin.ExistingTemplateIdArray existing_template_id, com.aria.common.shared.admin.DiscountRuleArray discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleArray existing_discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleIdArray existing_discount_rule_id, com.aria.common.shared.admin.DiscountBundleArray discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleArray existing_discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleIdArray existing_discount_bundle_id);

    abstract Map<String,Object> createCoupon(Map<String,Object> map);

    /**
    * updateCoupon
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coupon_cd - Type: String
            * @param status_ind - Type: Long
            * @param start_date - Type: String
            * @param end_date - Type: String
            * @param coupon_desc - Type: String
            * @param coupon_msg - Type: String
            * @param no_of_uses - Type: Long
            * @param template - Type: com.aria.common.shared.admin.TemplateArray
            * @param existing_template - Type: com.aria.common.shared.admin.ExistingTemplateArray
            * @param existing_template_id - Type: com.aria.common.shared.admin.ExistingTemplateIdArray
            * @param discount_rule - Type: com.aria.common.shared.admin.DiscountRuleArray
            * @param existing_discount_rule - Type: com.aria.common.shared.admin.ExistingDiscountRuleArray
            * @param existing_discount_rule_id - Type: com.aria.common.shared.admin.ExistingDiscountRuleIdArray
            * @param discount_bundle - Type: com.aria.common.shared.admin.DiscountBundleArray
            * @param existing_discount_bundle - Type: com.aria.common.shared.admin.ExistingDiscountBundleArray
            * @param existing_discount_bundle_id - Type: com.aria.common.shared.admin.ExistingDiscountBundleIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coupon_cd - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateCoupon(Long client_no, String auth_key, String coupon_cd, Long status_ind, String start_date, String end_date, String coupon_desc, String coupon_msg, Long no_of_uses, com.aria.common.shared.admin.TemplateArray template, com.aria.common.shared.admin.ExistingTemplateArray existing_template, com.aria.common.shared.admin.ExistingTemplateIdArray existing_template_id, com.aria.common.shared.admin.DiscountRuleArray discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleArray existing_discount_rule, com.aria.common.shared.admin.ExistingDiscountRuleIdArray existing_discount_rule_id, com.aria.common.shared.admin.DiscountBundleArray discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleArray existing_discount_bundle, com.aria.common.shared.admin.ExistingDiscountBundleIdArray existing_discount_bundle_id);

    abstract Map<String,Object> updateCoupon(Map<String,Object> map);

    /**
    * deleteCoupons
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coupon_nos - Type: com.aria.common.shared.admin.CouponNosArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coupons - Type: ArrayList&#60;CouponsReturnElement&#62;<br>
    */
    abstract Map<String,Object> deleteCoupons(Long client_no, String auth_key, com.aria.common.shared.admin.CouponNosArray coupon_nos);

    abstract Map<String,Object> deleteCoupons(Map<String,Object> map);

    /**
    * getRecurringCreditTemplates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   credit_templates - Type: ArrayList&#60;CreditTemplatesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRecurringCreditTemplates(Long client_no, String auth_key);

    abstract Map<String,Object> getRecurringCreditTemplates(Map<String,Object> map);

    /**
    * getRecurringCreditTemplateDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param credit_template_no - Type: Long
            * @param client_credit_template_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   recurring_credit_template_no - Type: javax.xml.ws.Holder<br>
    *   credit_template_name - Type: javax.xml.ws.Holder<br>
    *   client_credit_template_id - Type: javax.xml.ws.Holder<br>
    *   eligible_plan_no - Type: javax.xml.ws.Holder<br>
    *   eligible_client_plan_id - Type: javax.xml.ws.Holder<br>
    *   eligible_service_no - Type: javax.xml.ws.Holder<br>
    *   eligible_client_service_id - Type: javax.xml.ws.Holder<br>
    *   eligible_service_types - Type: ArrayList&#60;EligibleServiceTypesReturnElement&#62;<br>
    *   no_of_credits - Type: javax.xml.ws.Holder<br>
    *   time_between_credits - Type: javax.xml.ws.Holder<br>
    *   discount_type - Type: javax.xml.ws.Holder<br>
    *   discount_amt - Type: javax.xml.ws.Holder<br>
    *   percentage_plan_no - Type: javax.xml.ws.Holder<br>
    *   percentage_client_plan_id - Type: javax.xml.ws.Holder<br>
    *   percentage_service_no - Type: javax.xml.ws.Holder<br>
    *   percentage_client_service_id - Type: javax.xml.ws.Holder<br>
    *   alt_service_no - Type: javax.xml.ws.Holder<br>
    *   alt_client_service_id - Type: javax.xml.ws.Holder<br>
    *   coupons - Type: ArrayList&#60;CouponsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getRecurringCreditTemplateDetails(Long client_no, String auth_key, Long credit_template_no, String client_credit_template_id);

    abstract Map<String,Object> getRecurringCreditTemplateDetails(Map<String,Object> map);

    /**
    * createCreditTemplate
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param credit_template_name - Type: String
            * @param discount_type - Type: Long
            * @param discount_amt - Type: Double
            * @param no_of_credits - Type: Long
            * @param credit_interval_months - Type: Long
            * @param eligible_plan_no - Type: Long
            * @param eligible_client_plan_id - Type: String
            * @param eligible_service_no - Type: Long
            * @param eligible_client_service_id - Type: String
            * @param eligible_service_types - Type: com.aria.common.shared.admin.EligibleServiceTypesArray
            * @param percentage_plan_no - Type: Long
            * @param percentage_client_plan_id - Type: String
            * @param percentage_service_no - Type: Long
            * @param percentage_client_service_id - Type: String
            * @param alt_service_no - Type: Long
            * @param alt_client_service_id - Type: String
            * @param client_credit_template_id - Type: String
            * @param coupon - Type: com.aria.common.shared.admin.CouponArray
            * @param existing_coupon - Type: com.aria.common.shared.admin.ExistingCouponArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   credit_template_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createCreditTemplate(Long client_no, String auth_key, String credit_template_name, Long discount_type, Double discount_amt, Long no_of_credits, Long credit_interval_months, Long eligible_plan_no, String eligible_client_plan_id, Long eligible_service_no, String eligible_client_service_id, com.aria.common.shared.admin.EligibleServiceTypesArray eligible_service_types, Long percentage_plan_no, String percentage_client_plan_id, Long percentage_service_no, String percentage_client_service_id, Long alt_service_no, String alt_client_service_id, String client_credit_template_id, com.aria.common.shared.admin.CouponArray coupon, com.aria.common.shared.admin.ExistingCouponArray existing_coupon);

    abstract Map<String,Object> createCreditTemplate(Map<String,Object> map);

    /**
    * updateCreditTemplate
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param credit_template_no - Type: String
            * @param credit_template_name - Type: String
            * @param discount_type - Type: Long
            * @param discount_amt - Type: Double
            * @param no_of_credits - Type: Long
            * @param credit_interval_months - Type: Long
            * @param client_credit_template_id - Type: String
            * @param eligible_plan_no - Type: Long
            * @param eligible_client_plan_id - Type: String
            * @param eligible_service_no - Type: Long
            * @param eligible_client_service_id - Type: String
            * @param eligible_service_types - Type: com.aria.common.shared.admin.EligibleServiceTypesArray
            * @param percentage_plan_no - Type: Long
            * @param percentage_client_plan_id - Type: String
            * @param percentage_service_no - Type: Long
            * @param percentage_client_service_id - Type: String
            * @param alt_service_no - Type: Long
            * @param alt_client_service_id - Type: String
            * @param coupon - Type: com.aria.common.shared.admin.CouponArray
            * @param existing_coupon - Type: com.aria.common.shared.admin.ExistingCouponArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   credit_template_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateCreditTemplate(Long client_no, String auth_key, String credit_template_no, String credit_template_name, Long discount_type, Double discount_amt, Long no_of_credits, Long credit_interval_months, String client_credit_template_id, Long eligible_plan_no, String eligible_client_plan_id, Long eligible_service_no, String eligible_client_service_id, com.aria.common.shared.admin.EligibleServiceTypesArray eligible_service_types, Long percentage_plan_no, String percentage_client_plan_id, Long percentage_service_no, String percentage_client_service_id, Long alt_service_no, String alt_client_service_id, com.aria.common.shared.admin.CouponArray coupon, com.aria.common.shared.admin.ExistingCouponArray existing_coupon);

    abstract Map<String,Object> updateCreditTemplate(Map<String,Object> map);

    /**
    * deleteTemplates
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param template_nos - Type: com.aria.common.shared.admin.TemplateNosArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteTemplates(Long client_no, String auth_key, com.aria.common.shared.admin.TemplateNosArray template_nos);

    abstract Map<String,Object> deleteTemplates(Map<String,Object> map);

    /**
    * createDiscountRule
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param label - Type: String
            * @param rule_id - Type: String
            * @param description - Type: String
            * @param ext_description - Type: String
            * @param flat_percent_ind - Type: Long
            * @param amount - Type: Double
            * @param currency - Type: String
            * @param duration_type_ind - Type: String
            * @param inline_offset_ind - Type: String
            * @param service_code_to_use - Type: Long
            * @param scope_no - Type: Long
            * @param max_applicable_months - Type: Long
            * @param max_applications_per_acct - Type: Long
            * @param alt_service_no_2_apply - Type: Long
            * @param alt_service_id_2_apply - Type: String
            * @param applicable_trans_scope - Type: String
            * @param plan_no - Type: com.aria.common.shared.admin.PlanNoArray
            * @param client_plan_id - Type: com.aria.common.shared.admin.ClientPlanIdArray
            * @param service_no - Type: com.aria.common.shared.admin.ServiceNoArray
            * @param client_service_id - Type: com.aria.common.shared.admin.ClientServiceIdArray
            * @param item_no - Type: com.aria.common.shared.admin.ItemNoArray
            * @param client_item_id - Type: com.aria.common.shared.admin.ClientItemIdArray
            * @param use_all_or_nth_subs_rule - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   rule_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createDiscountRule(Long client_no, String auth_key, String label, String rule_id, String description, String ext_description, Long flat_percent_ind, Double amount, String currency, String duration_type_ind, String inline_offset_ind, Long service_code_to_use, Long scope_no, Long max_applicable_months, Long max_applications_per_acct, Long alt_service_no_2_apply, String alt_service_id_2_apply, String applicable_trans_scope, com.aria.common.shared.admin.PlanNoArray plan_no, com.aria.common.shared.admin.ClientPlanIdArray client_plan_id, com.aria.common.shared.admin.ServiceNoArray service_no, com.aria.common.shared.admin.ClientServiceIdArray client_service_id, com.aria.common.shared.admin.ItemNoArray item_no, com.aria.common.shared.admin.ClientItemIdArray client_item_id, String use_all_or_nth_subs_rule);

    abstract Map<String,Object> createDiscountRule(Map<String,Object> map);

    /**
    * createDiscountBundle
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param bundle_name - Type: String
            * @param bundle_id - Type: String
            * @param bundle_description - Type: String
            * @param allow_overlap_ind - Type: String
            * @param rules - Type: com.aria.common.shared.admin.RulesArray
            * @param rule_ids - Type: com.aria.common.shared.admin.RuleIdsArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   rule_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createDiscountBundle(Long client_no, String auth_key, String bundle_name, String bundle_id, String bundle_description, String allow_overlap_ind, com.aria.common.shared.admin.RulesArray rules, com.aria.common.shared.admin.RuleIdsArray rule_ids);

    abstract Map<String,Object> createDiscountBundle(Map<String,Object> map);

    /**
    * getDiscountBundles
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   discount_bundles - Type: ArrayList&#60;DiscountBundlesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getDiscountBundles(Long client_no, String auth_key);

    abstract Map<String,Object> getDiscountBundles(Map<String,Object> map);

    /**
    * getDiscountBundleDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param bundle_no - Type: Long
            * @param bundle_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   discount_bundles - Type: ArrayList&#60;DiscountBundlesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getDiscountBundleDetails(Long client_no, String auth_key, Long bundle_no, String bundle_id);

    abstract Map<String,Object> getDiscountBundleDetails(Map<String,Object> map);

    /**
    * getDiscountRules
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   discount_rules - Type: ArrayList&#60;DiscountRulesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getDiscountRules(Long client_no, String auth_key);

    abstract Map<String,Object> getDiscountRules(Map<String,Object> map);

    /**
    * getDiscountRuleDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param rule_no - Type: Long
            * @param client_rule_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   discount_rules - Type: ArrayList&#60;DiscountRulesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getDiscountRuleDetails(Long client_no, String auth_key, Long rule_no, String client_rule_id);

    abstract Map<String,Object> getDiscountRuleDetails(Map<String,Object> map);

    /**
    * deleteRules
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param rule_nos - Type: com.aria.common.shared.admin.RuleNosArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteRules(Long client_no, String auth_key, com.aria.common.shared.admin.RuleNosArray rule_nos);

    abstract Map<String,Object> deleteRules(Map<String,Object> map);

    /**
    * deleteBundles
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param bundle_nos - Type: com.aria.common.shared.admin.BundleNosArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteBundles(Long client_no, String auth_key, com.aria.common.shared.admin.BundleNosArray bundle_nos);

    abstract Map<String,Object> deleteBundles(Map<String,Object> map);

    /**
    * getPlans
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlans(Long client_no, String auth_key);

    abstract Map<String,Object> getPlans(Map<String,Object> map);

    /**
    * getPlanDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param plan_no - Type: Long
            * @param client_plan_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    *   client_plan_id - Type: javax.xml.ws.Holder<br>
    *   plan_name - Type: javax.xml.ws.Holder<br>
    *   plan_level - Type: javax.xml.ws.Holder<br>
    *   plan_type - Type: javax.xml.ws.Holder<br>
    *   plan_description - Type: javax.xml.ws.Holder<br>
    *   plan_groups - Type: ArrayList&#60;PlanGroupsReturnElement&#62;<br>
    *   plan_group_ids - Type: ArrayList&#60;PlanGroupIdsReturnElement&#62;<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    *   billing_interval - Type: javax.xml.ws.Holder<br>
    *   usage_billing_interval - Type: javax.xml.ws.Holder<br>
    *   active_ind - Type: javax.xml.ws.Holder<br>
    *   rollover_months - Type: javax.xml.ws.Holder<br>
    *   rollover_plan_no - Type: javax.xml.ws.Holder<br>
    *   rollover_client_plan_id - Type: javax.xml.ws.Holder<br>
    *   allow_child_accounts - Type: javax.xml.ws.Holder<br>
    *   dunning_plan_no - Type: javax.xml.ws.Holder<br>
    *   dunning_client_plan_id - Type: javax.xml.ws.Holder<br>
    *   free_trial_type - Type: javax.xml.ws.Holder<br>
    *   free_trial_duration - Type: javax.xml.ws.Holder<br>
    *   initial_free_months - Type: javax.xml.ws.Holder<br>
    *   acct_status_cd - Type: javax.xml.ws.Holder<br>
    *   rollover_status_days - Type: javax.xml.ws.Holder<br>
    *   rollover_status_cd - Type: javax.xml.ws.Holder<br>
    *   template_no - Type: javax.xml.ws.Holder<br>
    *   template_id - Type: javax.xml.ws.Holder<br>
    *   plan_cancel_min_month - Type: javax.xml.ws.Holder<br>
    *   how_to_apply_min_fee - Type: javax.xml.ws.Holder<br>
    *   is_deletable - Type: javax.xml.ws.Holder<br>
    *   services - Type: ArrayList&#60;ServicesReturnElement&#62;<br>
    *   resources - Type: ArrayList&#60;ResourcesReturnElement&#62;<br>
    *   parent_plans - Type: ArrayList&#60;ParentPlansReturnElement&#62;<br>
    *   parent_plan_ids - Type: ArrayList&#60;ParentPlanIdsReturnElement&#62;<br>
    *   exclusion_plans - Type: ArrayList&#60;ExclusionPlansReturnElement&#62;<br>
    *   supplemental_obj_fields - Type: ArrayList&#60;SupplementalObjFieldsReturnElement&#62;<br>
    *   surcharges - Type: ArrayList&#60;SurchargesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlanDetails(Long client_no, String auth_key, Long plan_no, String client_plan_id);

    abstract Map<String,Object> getPlanDetails(Map<String,Object> map);

    /**
    * createNewPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param plan_name - Type: String
            * @param plan_description - Type: String
            * @param plan_type - Type: String
            * @param currency - Type: String
            * @param billing_interval - Type: String
            * @param client_plan_id - Type: String
            * @param plan_group - Type: com.aria.common.shared.admin.PlanGroupArray
            * @param plan_group_id - Type: com.aria.common.shared.admin.PlanGroupIdArray
            * @param usage_billing_interval - Type: String
            * @param active - Type: Long
            * @param rollover_months - Type: String
            * @param rollover_plan_no - Type: Long
            * @param rollover_client_plan_id - Type: String
            * @param initial_free_months - Type: Long
            * @param acct_status_cd - Type: Long
            * @param rollover_status_days - Type: Long
            * @param rollover_status_cd - Type: Long
            * @param dunning_plan_no - Type: Long
            * @param dunning_client_plan_id - Type: String
            * @param template_no - Type: Long
            * @param client_email_template_id - Type: String
            * @param apply_cancellation - Type: String
            * @param plan_cancel_min_month - Type: Long
            * @param apply_minimum_fee - Type: String
            * @param how_to_apply_minimum_fee - Type: String
            * @param schedule - Type: com.aria.common.shared.admin.ScheduleArray
            * @param service - Type: com.aria.common.shared.admin.ServiceArray
            * @param resource - Type: com.aria.common.shared.admin.ResourceArray
            * @param arc_service_no - Type: Long
            * @param parent_plans - Type: com.aria.common.shared.admin.ParentPlansArray
            * @param parent_client_plan_ids - Type: com.aria.common.shared.admin.ParentClientPlanIdsArray
            * @param exclusion_plans - Type: com.aria.common.shared.admin.ExclusionPlansArray
            * @param supplemental_obj_field - Type: com.aria.common.shared.admin.SupplementalObjFieldArray
            * @param template_ind - Type: Long
            * @param child_plans - Type: com.aria.common.shared.admin.ChildPlansArray
            * @param notification_template_group_no - Type: String
            * @param credit_note_template_no - Type: String
            * @param surcharge_no - Type: com.aria.common.shared.admin.SurchargeNoArray
            * @param client_surcharge_id - Type: com.aria.common.shared.admin.ClientSurchargeIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createNewPlan(Long client_no, String auth_key, String plan_name, String plan_description, String plan_type, String currency, String billing_interval, String client_plan_id, com.aria.common.shared.admin.PlanGroupArray plan_group, com.aria.common.shared.admin.PlanGroupIdArray plan_group_id, String usage_billing_interval, Long active, String rollover_months, Long rollover_plan_no, String rollover_client_plan_id, Long initial_free_months, Long acct_status_cd, Long rollover_status_days, Long rollover_status_cd, Long dunning_plan_no, String dunning_client_plan_id, Long template_no, String client_email_template_id, String apply_cancellation, Long plan_cancel_min_month, String apply_minimum_fee, String how_to_apply_minimum_fee, com.aria.common.shared.admin.ScheduleArray schedule, com.aria.common.shared.admin.ServiceArray service, com.aria.common.shared.admin.ResourceArray resource, Long arc_service_no, com.aria.common.shared.admin.ParentPlansArray parent_plans, com.aria.common.shared.admin.ParentClientPlanIdsArray parent_client_plan_ids, com.aria.common.shared.admin.ExclusionPlansArray exclusion_plans, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, Long template_ind, com.aria.common.shared.admin.ChildPlansArray child_plans, String notification_template_group_no, String credit_note_template_no, com.aria.common.shared.admin.SurchargeNoArray surcharge_no, com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id);

    abstract Map<String,Object> createNewPlan(Map<String,Object> map);

    /**
    * editPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param plan_no - Type: String
            * @param plan_name - Type: String
            * @param client_plan_id - Type: String
            * @param plan_type - Type: Long
            * @param billing_interval - Type: String
            * @param currency - Type: String
            * @param plan_description - Type: String
            * @param plan_group - Type: com.aria.common.shared.admin.PlanGroupArray
            * @param plan_group_id - Type: com.aria.common.shared.admin.PlanGroupIdArray
            * @param active - Type: Long
            * @param usage_billing_interval - Type: String
            * @param template_no - Type: Long
            * @param client_email_template_id - Type: String
            * @param rollover_months - Type: String
            * @param rollover_plan_no - Type: Long
            * @param rollover_client_plan_id - Type: String
            * @param dunning_plan_no - Type: Long
            * @param dunning_client_plan_id - Type: String
            * @param initial_free_months - Type: Long
            * @param acct_status_cd - Type: Long
            * @param rollover_status_days - Type: Long
            * @param rollover_status_cd - Type: Long
            * @param allow_child_accts - Type: Long
            * @param apply_cancellation - Type: String
            * @param plan_cancel_min_month - Type: Long
            * @param apply_minimum_fee - Type: String
            * @param how_to_apply_minimum_fee - Type: Long
            * @param schedule - Type: com.aria.common.shared.admin.ScheduleArray
            * @param service - Type: com.aria.common.shared.admin.ServiceArray
            * @param resource - Type: com.aria.common.shared.admin.ResourceArray
            * @param arc_service_no - Type: Long
            * @param parent_plans - Type: com.aria.common.shared.admin.ParentPlansArray
            * @param parent_client_plan_ids - Type: com.aria.common.shared.admin.ParentClientPlanIdsArray
            * @param exclusion_plans - Type: com.aria.common.shared.admin.ExclusionPlansArray
            * @param supplemental_obj_field - Type: com.aria.common.shared.admin.SupplementalObjFieldArray
            * @param child_plans - Type: com.aria.common.shared.admin.ChildPlansArray
            * @param notification_template_group_no - Type: String
            * @param credit_note_template_no - Type: String
            * @param surcharge_no - Type: com.aria.common.shared.admin.SurchargeNoArray
            * @param client_surcharge_id - Type: com.aria.common.shared.admin.ClientSurchargeIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> editPlan(Long client_no, String auth_key, String plan_no, String plan_name, String client_plan_id, Long plan_type, String billing_interval, String currency, String plan_description, com.aria.common.shared.admin.PlanGroupArray plan_group, com.aria.common.shared.admin.PlanGroupIdArray plan_group_id, Long active, String usage_billing_interval, Long template_no, String client_email_template_id, String rollover_months, Long rollover_plan_no, String rollover_client_plan_id, Long dunning_plan_no, String dunning_client_plan_id, Long initial_free_months, Long acct_status_cd, Long rollover_status_days, Long rollover_status_cd, Long allow_child_accts, String apply_cancellation, Long plan_cancel_min_month, String apply_minimum_fee, Long how_to_apply_minimum_fee, com.aria.common.shared.admin.ScheduleArray schedule, com.aria.common.shared.admin.ServiceArray service, com.aria.common.shared.admin.ResourceArray resource, Long arc_service_no, com.aria.common.shared.admin.ParentPlansArray parent_plans, com.aria.common.shared.admin.ParentClientPlanIdsArray parent_client_plan_ids, com.aria.common.shared.admin.ExclusionPlansArray exclusion_plans, com.aria.common.shared.admin.SupplementalObjFieldArray supplemental_obj_field, com.aria.common.shared.admin.ChildPlansArray child_plans, String notification_template_group_no, String credit_note_template_no, com.aria.common.shared.admin.SurchargeNoArray surcharge_no, com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id);

    abstract Map<String,Object> editPlan(Map<String,Object> map);

    /**
    * deletePlans
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param plan_nos - Type: com.aria.common.shared.admin.PlanNosArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> deletePlans(Long client_no, String auth_key, com.aria.common.shared.admin.PlanNosArray plan_nos);

    abstract Map<String,Object> deletePlans(Map<String,Object> map);

    /**
    * copyPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param plan_no - Type: Long
            * @param client_plan_id - Type: String
            * @param plan_name - Type: String
            * @param new_client_plan_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> copyPlan(Long client_no, String auth_key, Long plan_no, String client_plan_id, String plan_name, String new_client_plan_id);

    abstract Map<String,Object> copyPlan(Map<String,Object> map);

    /**
    * updateMasterPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    */
    abstract Map<String,Object> updateMasterPlan(Long client_no, String auth_key);

    abstract Map<String,Object> updateMasterPlan(Map<String,Object> map);

    /**
    * updateSupplementalPlan
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    */
    abstract Map<String,Object> updateSupplementalPlan(Long client_no, String auth_key);

    abstract Map<String,Object> updateSupplementalPlan(Map<String,Object> map);

    /**
    * getPromotions
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promotions - Type: ArrayList&#60;PromotionsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPromotions(Long client_no, String auth_key);

    abstract Map<String,Object> getPromotions(Map<String,Object> map);

    /**
    * getPromotionDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param promo_cd - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   client_no - Type: javax.xml.ws.Holder<br>
    *   promo_cd - Type: javax.xml.ws.Holder<br>
    *   promo_desc - Type: javax.xml.ws.Holder<br>
    *   start_date - Type: javax.xml.ws.Holder<br>
    *   exp_date - Type: javax.xml.ws.Holder<br>
    *   max_uses - Type: javax.xml.ws.Holder<br>
    *   plan_type_name - Type: javax.xml.ws.Holder<br>
    *   plan_type_desc - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getPromotionDetails(Long client_no, String auth_key, String promo_cd);

    abstract Map<String,Object> getPromotionDetails(Map<String,Object> map);

    /**
    * createPromotion
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param promo_cd - Type: String
            * @param promo_desc - Type: String
            * @param promo_plan_set_no - Type: Long
            * @param no_of_uses - Type: String
            * @param start_date - Type: String
            * @param exp_date - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promo_cd - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createPromotion(Long client_no, String auth_key, String promo_cd, String promo_desc, Long promo_plan_set_no, String no_of_uses, String start_date, String exp_date);

    abstract Map<String,Object> createPromotion(Map<String,Object> map);

    /**
    * updatePromotion
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param promo_cd - Type: String
            * @param promo_desc - Type: String
            * @param promo_plan_set_no - Type: Long
            * @param no_of_uses - Type: String
            * @param start_date - Type: String
            * @param exp_date - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   promo_cd - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updatePromotion(Long client_no, String auth_key, String promo_cd, String promo_desc, Long promo_plan_set_no, String no_of_uses, String start_date, String exp_date);

    abstract Map<String,Object> updatePromotion(Map<String,Object> map);

    /**
    * getUsageTypes
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_types - Type: ArrayList&#60;UsageTypesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getUsageTypes(Long client_no, String auth_key);

    abstract Map<String,Object> getUsageTypes(Map<String,Object> map);

    /**
    * getUsageTypeDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param usage_type_no - Type: Long
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_type_no - Type: javax.xml.ws.Holder<br>
    *   usage_type_name - Type: javax.xml.ws.Holder<br>
    *   usage_type_desc - Type: javax.xml.ws.Holder<br>
    *   usage_type_cd - Type: javax.xml.ws.Holder<br>
    *   usage_unit_type - Type: javax.xml.ws.Holder<br>
    *   client_usage_unit_type_id - Type: javax.xml.ws.Holder<br>
    *   is_editable - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> getUsageTypeDetails(Long client_no, String auth_key, Long usage_type_no);

    abstract Map<String,Object> getUsageTypeDetails(Map<String,Object> map);

    /**
    * getUsageUnitTypes
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_unit_types - Type: ArrayList&#60;UsageUnitTypesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getUsageUnitTypes(Long client_no, String auth_key);

    abstract Map<String,Object> getUsageUnitTypes(Map<String,Object> map);

    /**
    * createUsageType
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param usage_type_name - Type: String
            * @param usage_type_desc - Type: String
            * @param usage_unit_type_no - Type: Long
            * @param usage_type_code - Type: String
            * @param usage_type_display_string - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_type_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createUsageType(Long client_no, String auth_key, String usage_type_name, String usage_type_desc, Long usage_unit_type_no, String usage_type_code, String usage_type_display_string);

    abstract Map<String,Object> createUsageType(Map<String,Object> map);

    /**
    * updateUsageType
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param usage_type_no - Type: Long
            * @param usage_type_name - Type: String
            * @param usage_type_desc - Type: String
            * @param usage_unit_type_no - Type: Long
            * @param usage_type_code - Type: String
            * @param usage_type_display_string - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   usage_type_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateUsageType(Long client_no, String auth_key, Long usage_type_no, String usage_type_name, String usage_type_desc, Long usage_unit_type_no, String usage_type_code, String usage_type_display_string);

    abstract Map<String,Object> updateUsageType(Map<String,Object> map);

    /**
    * createSuppObjField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param field_name - Type: String
            * @param description - Type: String
            * @param min_no_sel - Type: String
            * @param max_no_sel - Type: Long
            * @param datatype - Type: String
            * @param form_input_type - Type: String
            * @param use_allowed_vals_ind - Type: String
            * @param option_value - Type: String
            * @param option_value_order - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   field_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createSuppObjField(Long client_no, String auth_key, String field_name, String description, String min_no_sel, Long max_no_sel, String datatype, String form_input_type, String use_allowed_vals_ind, String option_value, String option_value_order);

    abstract Map<String,Object> createSuppObjField(Map<String,Object> map);

    /**
    * updateSuppObjField
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param field_no - Type: Long
            * @param field_name - Type: String
            * @param description - Type: String
            * @param min_no_sel - Type: String
            * @param max_no_sel - Type: Long
            * @param datatype - Type: String
            * @param form_input_type - Type: String
            * @param use_allowed_vals_ind - Type: String
            * @param option_value - Type: String
            * @param option_value_order - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   field_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updateSuppObjField(Long client_no, String auth_key, Long field_no, String field_name, String description, String min_no_sel, Long max_no_sel, String datatype, String form_input_type, String use_allowed_vals_ind, String option_value, String option_value_order);

    abstract Map<String,Object> updateSuppObjField(Map<String,Object> map);

    /**
    * getSuppObjFields
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param field_no - Type: Long
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   field_no - Type: javax.xml.ws.Holder<br>
    *   field_name - Type: javax.xml.ws.Holder<br>
    *   description - Type: javax.xml.ws.Holder<br>
    *   datatype - Type: javax.xml.ws.Holder<br>
    *   min_no_sel - Type: javax.xml.ws.Holder<br>
    *   max_no_sel - Type: javax.xml.ws.Holder<br>
    *   form_input_type - Type: javax.xml.ws.Holder<br>
    *   allowed_values - Type: ArrayList&#60;AllowedValuesReturnElement&#62;<br>
    *   associated_objects - Type: ArrayList&#60;AssociatedObjectsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSuppObjFields(Long client_no, String auth_key, Long field_no);

    abstract Map<String,Object> getSuppObjFields(Map<String,Object> map);

    /**
    * getPlanGroups
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_groups - Type: ArrayList&#60;PlanGroupsReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlanGroups(Long client_no, String auth_key);

    abstract Map<String,Object> getPlanGroups(Map<String,Object> map);

    /**
    * getPlanGroupDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param group_no - Type: Long
            * @param client_plan_change_group_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   group_no - Type: javax.xml.ws.Holder<br>
    *   group_name - Type: javax.xml.ws.Holder<br>
    *   group_desc - Type: javax.xml.ws.Holder<br>
    *   client_plan_change_group_id - Type: javax.xml.ws.Holder<br>
    *   group_usage - Type: javax.xml.ws.Holder<br>
    *   plans - Type: ArrayList&#60;PlansReturnElement&#62;<br>
    */
    abstract Map<String,Object> getPlanGroupDetails(Long client_no, String auth_key, Long group_no, String client_plan_change_group_id);

    abstract Map<String,Object> getPlanGroupDetails(Map<String,Object> map);

    /**
    * createPlanGroup
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param group_name - Type: String
            * @param group_desc - Type: String
            * @param group_usage - Type: String
            * @param client_plan_change_group_id - Type: String
            * @param group_plans - Type: String
            * @param group_plan_ids - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   group_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createPlanGroup(Long client_no, String auth_key, String group_name, String group_desc, String group_usage, String client_plan_change_group_id, String group_plans, String group_plan_ids);

    abstract Map<String,Object> createPlanGroup(Map<String,Object> map);

    /**
    * updatePlanGroup
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param group_no - Type: Long
            * @param group_name - Type: String
            * @param group_desc - Type: String
            * @param group_usage - Type: String
            * @param client_plan_change_group_id - Type: String
            * @param group_plans - Type: String
            * @param group_plan_ids - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   group_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> updatePlanGroup(Long client_no, String auth_key, Long group_no, String group_name, String group_desc, String group_usage, String client_plan_change_group_id, String group_plans, String group_plan_ids);

    abstract Map<String,Object> updatePlanGroup(Map<String,Object> map);

    /**
    * deletePlanGroup
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param group_list - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   plan_groups - Type: ArrayList&#60;PlanGroupsReturnElement&#62;<br>
    */
    abstract Map<String,Object> deletePlanGroup(Long client_no, String auth_key, String group_list);

    abstract Map<String,Object> deletePlanGroup(Map<String,Object> map);

    /**
    * listCoa
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coa_list - Type: ArrayList&#60;CoaListReturnElement&#62;<br>
    */
    abstract Map<String,Object> listCoa(Long client_no, String auth_key);

    abstract Map<String,Object> listCoa(Map<String,Object> map);

    /**
    * addCoa
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coa_code - Type: String
            * @param coa_description - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coa - Type: ArrayList&#60;CoaReturnElement&#62;<br>
    */
    abstract Map<String,Object> addCoa(Long client_no, String auth_key, String coa_code, String coa_description);

    abstract Map<String,Object> addCoa(Map<String,Object> map);

    /**
    * getCoa
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coa_id - Type: Long
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coa - Type: ArrayList&#60;CoaReturnElement&#62;<br>
    */
    abstract Map<String,Object> getCoa(Long client_no, String auth_key, Long coa_id);

    abstract Map<String,Object> getCoa(Map<String,Object> map);

    /**
    * editCoa
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param coa_id - Type: Long
            * @param coa_code - Type: String
            * @param coa_description - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   coa - Type: ArrayList&#60;CoaReturnElement&#62;<br>
    */
    abstract Map<String,Object> editCoa(Long client_no, String auth_key, Long coa_id, String coa_code, String coa_description);

    abstract Map<String,Object> editCoa(Map<String,Object> map);

    /**
    * getSurcharges
    * @param client_no - Type: Long
    * @param auth_key - Type: String
    * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   surcharges - Type: ArrayList&#60;SurchargesReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSurcharges(Long client_no, String auth_key);

    abstract Map<String,Object> getSurcharges(Map<String,Object> map);

    /**
    * getSurchargeDetails
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param surcharge_no - Type: Long
            * @param client_surcharge_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   surcharge_no - Type: javax.xml.ws.Holder<br>
    *   surcharge_name - Type: javax.xml.ws.Holder<br>
    *   client_surcharge_id - Type: javax.xml.ws.Holder<br>
    *   description - Type: javax.xml.ws.Holder<br>
    *   ext_description - Type: javax.xml.ws.Holder<br>
    *   currency_cd - Type: javax.xml.ws.Holder<br>
    *   surcharge_type_cd - Type: javax.xml.ws.Holder<br>
    *   inline_offset_ind - Type: javax.xml.ws.Holder<br>
    *   apply_b4_or_after_discount_cd - Type: javax.xml.ws.Holder<br>
    *   apply_to_zero_invoice_ind - Type: javax.xml.ws.Holder<br>
    *   tax_group - Type: javax.xml.ws.Holder<br>
    *   gl_cd - Type: javax.xml.ws.Holder<br>
    *   ar_gl_cd - Type: javax.xml.ws.Holder<br>
    *   scope_no - Type: javax.xml.ws.Holder<br>
    *   plan_no - Type: ArrayList&#60;PlanNoReturnElement&#62;<br>
    *   client_plan_id - Type: ArrayList&#60;ClientPlanIdReturnElement&#62;<br>
    *   service_no - Type: ArrayList&#60;ServiceNoReturnElement&#62;<br>
    *   client_service_id - Type: ArrayList&#60;ClientServiceIdReturnElement&#62;<br>
    *   item_no - Type: ArrayList&#60;ItemNoReturnElement&#62;<br>
    *   client_item_id - Type: ArrayList&#60;ClientItemIdReturnElement&#62;<br>
    *   plan_service - Type: ArrayList&#60;PlanServiceReturnElement&#62;<br>
    *   surcharge_tier - Type: ArrayList&#60;SurchargeTierReturnElement&#62;<br>
    */
    abstract Map<String,Object> getSurchargeDetails(Long client_no, String auth_key, Long surcharge_no, String client_surcharge_id);

    abstract Map<String,Object> getSurchargeDetails(Map<String,Object> map);

    /**
    * createSurcharge
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param surcharge_name - Type: String
            * @param description - Type: String
            * @param ext_description - Type: String
            * @param currency_cd - Type: String
            * @param surcharge_type_cd - Type: String
            * @param inline_offset_ind - Type: String
            * @param apply_b4_or_after_discount_cd - Type: String
            * @param scope_no - Type: Long
            * @param surcharge_tier - Type: com.aria.common.shared.admin.SurchargeTierArray
            * @param client_surcharge_id - Type: String
            * @param apply_to_zero_invoice_ind - Type: Long
            * @param tax_group - Type: Long
            * @param gl_cd - Type: String
            * @param ar_gl_cd - Type: String
            * @param plan_no - Type: com.aria.common.shared.admin.PlanNoArray
            * @param client_plan_id - Type: com.aria.common.shared.admin.ClientPlanIdArray
            * @param service_no - Type: com.aria.common.shared.admin.ServiceNoArray
            * @param client_service_id - Type: com.aria.common.shared.admin.ClientServiceIdArray
            * @param item_no - Type: com.aria.common.shared.admin.ItemNoArray
            * @param client_item_id - Type: com.aria.common.shared.admin.ClientItemIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   surcharge_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> createSurcharge(Long client_no, String auth_key, String surcharge_name, String description, String ext_description, String currency_cd, String surcharge_type_cd, String inline_offset_ind, String apply_b4_or_after_discount_cd, Long scope_no, com.aria.common.shared.admin.SurchargeTierArray surcharge_tier, String client_surcharge_id, Long apply_to_zero_invoice_ind, Long tax_group, String gl_cd, String ar_gl_cd, com.aria.common.shared.admin.PlanNoArray plan_no, com.aria.common.shared.admin.ClientPlanIdArray client_plan_id, com.aria.common.shared.admin.ServiceNoArray service_no, com.aria.common.shared.admin.ClientServiceIdArray client_service_id, com.aria.common.shared.admin.ItemNoArray item_no, com.aria.common.shared.admin.ClientItemIdArray client_item_id);

    abstract Map<String,Object> createSurcharge(Map<String,Object> map);

    /**
    * editSurcharge
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param surcharge_no - Type: String
            * @param surcharge_name - Type: String
            * @param client_surcharge_id - Type: String
            * @param description - Type: String
            * @param ext_description - Type: String
            * @param currency_cd - Type: String
            * @param scope_no - Type: Long
            * @param surcharge_tier - Type: com.aria.common.shared.admin.SurchargeTierArray
            * @param apply_to_zero_invoice_ind - Type: Long
            * @param plan_no - Type: com.aria.common.shared.admin.PlanNoArray
            * @param client_plan_id - Type: com.aria.common.shared.admin.ClientPlanIdArray
            * @param service_no - Type: com.aria.common.shared.admin.ServiceNoArray
            * @param client_service_id - Type: com.aria.common.shared.admin.ClientServiceIdArray
            * @param item_no - Type: com.aria.common.shared.admin.ItemNoArray
            * @param client_item_id - Type: com.aria.common.shared.admin.ClientItemIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    *   surcharge_no - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> editSurcharge(Long client_no, String auth_key, String surcharge_no, String surcharge_name, String client_surcharge_id, String description, String ext_description, String currency_cd, Long scope_no, com.aria.common.shared.admin.SurchargeTierArray surcharge_tier, Long apply_to_zero_invoice_ind, com.aria.common.shared.admin.PlanNoArray plan_no, com.aria.common.shared.admin.ClientPlanIdArray client_plan_id, com.aria.common.shared.admin.ServiceNoArray service_no, com.aria.common.shared.admin.ClientServiceIdArray client_service_id, com.aria.common.shared.admin.ItemNoArray item_no, com.aria.common.shared.admin.ClientItemIdArray client_item_id);

    abstract Map<String,Object> editSurcharge(Map<String,Object> map);

    /**
    * deleteSurcharge
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param surcharge_no - Type: com.aria.common.shared.admin.SurchargeNoArray
            * @param client_surcharge_id - Type: com.aria.common.shared.admin.ClientSurchargeIdArray
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> deleteSurcharge(Long client_no, String auth_key, com.aria.common.shared.admin.SurchargeNoArray surcharge_no, com.aria.common.shared.admin.ClientSurchargeIdArray client_surcharge_id);

    abstract Map<String,Object> deleteSurcharge(Map<String,Object> map);

    /**
    * validateAdminSession
    * @param client_no - Type: Long
    * @param auth_key - Type: String
        * @param session_id - Type: String
        * @return A <code>Map&#60;String,Object&#62;</code>, containing the following Objects:
    *   error_code - Type: javax.xml.ws.Holder<br>
    *   error_msg - Type: javax.xml.ws.Holder<br>
    */
    abstract Map<String,Object> validateAdminSession(Long client_no, String auth_key, String session_id);

    abstract Map<String,Object> validateAdminSession(Map<String,Object> map);

    /********************************** END - METHODS ***********************************************/
}
