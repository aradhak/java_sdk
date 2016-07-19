package com.aria.common.rest.admin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.aria.common.shared.admin.*;

/**
 * RestUtilities
 * Web Service class which has method used on rest service calls
 * @copyright Aria Systems, Inc
 */
public class RestUtilities {

    public static HashMap<String, Object> buildJSonReturn(String response, String[] returnValues) {
        HashMap<String,Object> returnHashMap = new HashMap<String,Object>();
        JSONObject jsonObj = (JSONObject)JSONValue.parse(response);
        if (jsonObj == null) return null;
        for (int i = 0;i < returnValues.length;i++){
            if (!jsonObj.containsKey(returnValues[i])) continue;
            if (jsonObj.get(returnValues[i]) instanceof JSONArray){
                returnHashMap.put(returnValues[i], buildReturnElement(jsonObj,returnValues[i]));
            }else{
                returnHashMap.put(returnValues[i], jsonObj.get(returnValues[i]));
            }
        }
        return returnHashMap;
    }

    public static String getValue(String type, Object value) {
        String ret = "";
        if (type.equalsIgnoreCase("long")){
            Long longValue = (Long) value;
            if (longValue!=null){
                ret = Long.toString(longValue);
            }
        }else if (type.equalsIgnoreCase("double")){
            Double doubleValue = (Double) value;
            if (doubleValue!=null){
                ret = Double.toString(doubleValue);
            }
        }else if (type.equalsIgnoreCase("string")){
            String stringValue = (String) value;
            if (stringValue!=null){
                ret = stringValue;
            }
        }
        return ret;
    }

    private static Double getDoubleValue(JSONObject jsonObject, String field) {
        if (jsonObject.get(field)==null) return 0D;
        Double doubleValue = 0D;
        try {
            doubleValue = Double.parseDouble(jsonObject.get(field).toString());
        } catch (NumberFormatException e) {
            String newValue = jsonObject.get(field).toString()+".0";
            try {
                doubleValue = Double.parseDouble(newValue);
            } catch (NumberFormatException ex) {
                doubleValue = 0D;
            }
        }
        return doubleValue;
    }

    private static Long getLongValue(JSONObject jsonObject, String field) {
        if (jsonObject.get(field)==null) return 0L;
        Long longValue = 0L;
        try {
            longValue = Long.parseLong(jsonObject.get(field).toString());
        } catch (NumberFormatException e) {
            longValue = 0L;
        }
        return longValue;
    }

    private static String getStringValue(JSONObject jsonObject, String field) {
        String ret = "";
        if (jsonObject.get(field)==null) return ret;
        return jsonObject.get(field).toString();
    }

    /* ****************** RETURN ELEMENT BASE METHOD ********************************* */
    private static Object buildReturnElement(JSONObject jsonObj, String value) {
        JSONArray jsonArray=(JSONArray)jsonObj.get(value);
        Object ret = new Object();
        if (value.equalsIgnoreCase(value)){
            try {
                String methodName = buildJavaName(value);
                methodName = "build"+methodName+"ReturnElement";
                Class<?>[] classes = {JSONArray.class};
                Method method = RestUtilities.class.getDeclaredMethod (methodName, classes);
                ret = method.invoke(new RestUtilities(), jsonArray);
            } catch (SecurityException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return ret;
    }

    /** Wsdl to Java For example parm_name to ParmName  */
    private static String buildJavaName(String name) {
        String ret = "";
        boolean toUpper = true;
        /*SpecialCase*/
        for (char character : name.toCharArray()) {
            if (toUpper) character = Character.toUpperCase(character);
            toUpper = character == '_' || Character.toString(character).matches("[0-9]");
            if (character != '_') ret += character;
        }
        return ret;
    }
    /* ****************** END - RETURN ELEMENT BASE METHOD ********************************* */

    /* ****************** SPECIFIC METHODS FOR EACH RETURN ELEMENT (build<#name#>) ********************************************** */
        public static ArrayList<PromoPlanSetReturnElement> buildPromoPlanSetReturnElement(JSONArray jsonArray) {
        ArrayList<PromoPlanSetReturnElement> returnElement = new ArrayList<PromoPlanSetReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PromoPlanSetReturnElement entity = new PromoPlanSetReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPromoPlanSetNo(getLongValue(jsonObject,"promo_plan_set_no"));
            entity.setPromoPlanSetName(getStringValue(jsonObject,"promo_plan_set_name"));
            entity.setPromoPlanSetDesc(getStringValue(jsonObject,"promo_plan_set_desc"));
            entity.setClientPlanTypeId(getStringValue(jsonObject,"client_plan_type_id"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoPlanSetNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPromoPlanSetNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPromoPlanSetNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoPlanSetName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPromoPlanSetName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoPlanSetDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPromoPlanSetDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientPlanTypeId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientPlanTypeId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanReturnElement> buildPlanReturnElement(JSONArray jsonArray) {
        ArrayList<PlanReturnElement> returnElement = new ArrayList<PlanReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanReturnElement entity = new PlanReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientPlanId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientPlanId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PromoPlanSetTranslationInfoReturnElement> buildPromoPlanSetTranslationInfoReturnElement(JSONArray jsonArray) {
        ArrayList<PromoPlanSetTranslationInfoReturnElement> returnElement = new ArrayList<PromoPlanSetTranslationInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PromoPlanSetTranslationInfoReturnElement entity = new PromoPlanSetTranslationInfoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
                        ArrayList<PlanTReturnElement> arrayListPlanTReturnElement = buildPlanTReturnElement((JSONArray)jsonObject.get("plan_t"));
            for (PlanTReturnElement element : arrayListPlanTReturnElement){
                entity.getPlanT().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanTReturnElement> buildPlanTReturnElement(JSONArray jsonArray) {
        ArrayList<PlanTReturnElement> returnElement = new ArrayList<PlanTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanTReturnElement entity = new PlanTReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ClientReturnElement> buildClientReturnElement(JSONArray jsonArray) {
        ArrayList<ClientReturnElement> returnElement = new ArrayList<ClientReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientReturnElement entity = new ClientReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientName(getStringValue(jsonObject,"client_name"));
            entity.setDomain(getStringValue(jsonObject,"domain"));
            entity.setAddress1(getStringValue(jsonObject,"address1"));
            entity.setAddress2(getStringValue(jsonObject,"address2"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setLocality(getStringValue(jsonObject,"locality"));
            entity.setStateProv(getStringValue(jsonObject,"state_prov"));
            entity.setCountry(getStringValue(jsonObject,"country"));
            entity.setPostalCode(getStringValue(jsonObject,"postal_code"));
            entity.setPhone(getStringValue(jsonObject,"phone"));
            entity.setContact(getStringValue(jsonObject,"contact"));
            entity.setContactAddress1(getStringValue(jsonObject,"contact_address1"));
            entity.setContactAddress2(getStringValue(jsonObject,"contact_address2"));
            entity.setContactCity(getStringValue(jsonObject,"contact_city"));
            entity.setContactState(getStringValue(jsonObject,"contact_state"));
            entity.setContactZip(getStringValue(jsonObject,"contact_zip"));
            entity.setContactPhone(getStringValue(jsonObject,"contact_phone"));
            entity.setContactEmail(getStringValue(jsonObject,"contact_email"));
            entity.setBillingContact(getStringValue(jsonObject,"billing_contact"));
            entity.setBillingAddress1(getStringValue(jsonObject,"billing_address1"));
            entity.setBillingAddress2(getStringValue(jsonObject,"billing_address2"));
            entity.setBillingCity(getStringValue(jsonObject,"billing_city"));
            entity.setBillingState(getStringValue(jsonObject,"billing_state"));
            entity.setBillingZip(getStringValue(jsonObject,"billing_zip"));
            entity.setBillingPhone(getStringValue(jsonObject,"billing_phone"));
            entity.setBillingEmail(getStringValue(jsonObject,"billing_email"));
            entity.setContactCountry(getStringValue(jsonObject,"contact_country"));
            entity.setContactLocality(getStringValue(jsonObject,"contact_locality"));
            entity.setBillingCountry(getStringValue(jsonObject,"billing_country"));
            entity.setBillingLocality(getStringValue(jsonObject,"billing_locality"));
            entity.setBatchJobAlertContact(getStringValue(jsonObject,"batch_job_alert_contact"));
            entity.setBatchJobAlertEmail(getStringValue(jsonObject,"batch_job_alert_email"));
            entity.setClientLocaleName(getStringValue(jsonObject,"client_locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDomain(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDomain(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAddress1(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAddress1(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAddress2(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAddress2(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCity(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCity(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocality(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocality(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setStateProv(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setStateProv(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCountry(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCountry(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPostalCode(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPostalCode(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPhone(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPhone(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContact(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContact(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactAddress1(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactAddress1(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactAddress2(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactAddress2(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactCity(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactCity(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactState(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactState(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactZip(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactZip(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactPhone(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactPhone(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactEmail(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactEmail(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingContact(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingContact(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingAddress1(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingAddress1(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingAddress2(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingAddress2(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingCity(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingCity(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingState(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingState(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingZip(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingZip(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingPhone(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingPhone(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingEmail(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingEmail(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactCountry(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactCountry(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setContactLocality(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setContactLocality(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingCountry(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingCountry(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingLocality(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBillingLocality(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBatchJobAlertContact(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBatchJobAlertContact(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBatchJobAlertEmail(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBatchJobAlertEmail(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<InventoryItemsReturnElement> buildInventoryItemsReturnElement(JSONArray jsonArray) {
        ArrayList<InventoryItemsReturnElement> returnElement = new ArrayList<InventoryItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InventoryItemsReturnElement entity = new InventoryItemsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemName(getStringValue(jsonObject,"item_name"));
            entity.setItemType(getLongValue(jsonObject,"item_type"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setItemNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setItemNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setItemNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setItemName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setItemName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setItemType(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setItemType(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setItemType(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientSku(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientSku(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setActiveInd(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setActiveInd(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setActiveInd(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setStockLevel(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setStockLevel(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setStockLevel(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientItemId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientItemId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ResourcesReturnElement> buildResourcesReturnElement(JSONArray jsonArray) {
        ArrayList<ResourcesReturnElement> returnElement = new ArrayList<ResourcesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ResourcesReturnElement entity = new ResourcesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setResourceTypeNo(getLongValue(jsonObject,"resource_type_no"));
            entity.setResourceUnits(getLongValue(jsonObject,"resource_units"));
            entity.setDaysToExpiry(getLongValue(jsonObject,"days_to_expiry"));
            entity.setResourceName(getStringValue(jsonObject,"resource_name"));
            entity.setResources(getLongValue(jsonObject,"resources"));
            entity.setExpireOnPaidThrough(getLongValue(jsonObject,"expire_on_paid_through"));
            entity.setResetOnUpdate(getLongValue(jsonObject,"reset_on_update"));
            entity.setAddDaysToExpiry(getLongValue(jsonObject,"add_days_to_expiry"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setResourceTypeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setResourceTypeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setResourceTypeNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setResourceUnits(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setResourceUnits(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setResourceUnits(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDaysToExpiry(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDaysToExpiry(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDaysToExpiry(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setResourceName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setResourceName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setResources(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setResources(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setResources(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExpireOnPaidThrough(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setExpireOnPaidThrough(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setExpireOnPaidThrough(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setResetOnUpdate(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setResetOnUpdate(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setResetOnUpdate(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAddDaysToExpiry(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setAddDaysToExpiry(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setAddDaysToExpiry(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PricingReturnElement> buildPricingReturnElement(JSONArray jsonArray) {
        ArrayList<PricingReturnElement> returnElement = new ArrayList<PricingReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PricingReturnElement entity = new PricingReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setPrice(getDoubleValue(jsonObject,"price"));
            entity.setPricePerUnit(getDoubleValue(jsonObject,"price_per_unit"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCurrencyCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCurrencyCd(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPrice(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setPrice(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setPrice(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPricePerUnit(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setPricePerUnit(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setPricePerUnit(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ImageReturnElement> buildImageReturnElement(JSONArray jsonArray) {
        ArrayList<ImageReturnElement> returnElement = new ArrayList<ImageReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ImageReturnElement entity = new ImageReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setThumbnailImageUrl(getStringValue(jsonObject,"thumbnail_image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            entity.setImageClassSeqNo(getLongValue(jsonObject,"image_class_seq_no"));
            entity.setActive(getLongValue(jsonObject,"active"));
            entity.setMainImageUrl(getStringValue(jsonObject,"main_image_url"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setThumbnailImageUrl(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setThumbnailImageUrl(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setImageText(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setImageText(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDefaultInd(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDefaultInd(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDefaultInd(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setImageClassSeqNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setImageClassSeqNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setImageClassSeqNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setActive(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setActive(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setActive(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMainImageUrl(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setMainImageUrl(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SupplementalObjFieldsReturnElement> buildSupplementalObjFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<SupplementalObjFieldsReturnElement> returnElement = new ArrayList<SupplementalObjFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SupplementalObjFieldsReturnElement entity = new SupplementalObjFieldsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldNo(getLongValue(jsonObject,"field_no"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setSupplementalObjField(getStringValue(jsonObject,"supplemental_obj_field"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFieldNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFieldNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldValue(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldValue(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSupplementalObjField(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setSupplementalObjField(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ScheduleReturnElement> buildScheduleReturnElement(JSONArray jsonArray) {
        ArrayList<ScheduleReturnElement> returnElement = new ArrayList<ScheduleReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ScheduleReturnElement entity = new ScheduleReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setIsDefault(getLongValue(jsonObject,"is_default"));
            entity.setTaxInclusiveRate(getLongValue(jsonObject,"tax_inclusive_rate"));
                        ArrayList<TierReturnElement> arrayListTierReturnElement = buildTierReturnElement((JSONArray)jsonObject.get("tier"));
            for (TierReturnElement element : arrayListTierReturnElement){
                entity.getTier().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setScheduleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setScheduleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCurrencyCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCurrencyCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientRateScheduleId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientRateScheduleId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setIsDefault(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setIsDefault(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setIsDefault(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setTaxInclusiveRate(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setTaxInclusiveRate(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setTaxInclusiveRate(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<TierReturnElement> buildTierReturnElement(JSONArray jsonArray) {
        ArrayList<TierReturnElement> returnElement = new ArrayList<TierReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            TierReturnElement entity = new TierReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFrom(getLongValue(jsonObject,"from"));
            entity.setTo(getLongValue(jsonObject,"to"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFrom(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFrom(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFrom(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setTo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setTo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setTo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAmount(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setAmount(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setAmount(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ServiceTypesReturnElement> buildServiceTypesReturnElement(JSONArray jsonArray) {
        ArrayList<ServiceTypesReturnElement> returnElement = new ArrayList<ServiceTypesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServiceTypesReturnElement entity = new ServiceTypesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceTypeCd(getStringValue(jsonObject,"service_type_cd"));
            entity.setServiceTypeName(getStringValue(jsonObject,"service_type_name"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceTypeCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceTypeCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceTypeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceTypeName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ServicesReturnElement> buildServicesReturnElement(JSONArray jsonArray) {
        ArrayList<ServicesReturnElement> returnElement = new ArrayList<ServicesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServicesReturnElement entity = new ServicesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceType(getStringValue(jsonObject,"service_type"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
                        ArrayList<ServiceTranslationsReturnElement> arrayListServiceTranslationsReturnElement = buildServiceTranslationsReturnElement((JSONArray)jsonObject.get("service_translations"));
            for (ServiceTranslationsReturnElement element : arrayListServiceTranslationsReturnElement){
                entity.getServiceTranslations().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setServiceNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setServiceNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceType(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientServiceId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientServiceId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ServiceTranslationsReturnElement> buildServiceTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<ServiceTranslationsReturnElement> returnElement = new ArrayList<ServiceTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServiceTranslationsReturnElement entity = new ServiceTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setServiceNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setServiceNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ServiceTranslationInfoReturnElement> buildServiceTranslationInfoReturnElement(JSONArray jsonArray) {
        ArrayList<ServiceTranslationInfoReturnElement> returnElement = new ArrayList<ServiceTranslationInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServiceTranslationInfoReturnElement entity = new ServiceTranslationInfoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setServiceNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setServiceNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RateSchedulesReturnElement> buildRateSchedulesReturnElement(JSONArray jsonArray) {
        ArrayList<RateSchedulesReturnElement> returnElement = new ArrayList<RateSchedulesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RateSchedulesReturnElement entity = new RateSchedulesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCurrency(getStringValue(jsonObject,"currency"));
                        ArrayList<RateInfoReturnElement> arrayListRateInfoReturnElement = buildRateInfoReturnElement((JSONArray)jsonObject.get("rate_info"));
            for (RateInfoReturnElement element : arrayListRateInfoReturnElement){
                entity.getRateInfo().add(element);
            }
            entity.setIsDefault(getLongValue(jsonObject,"is_default"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCurrency(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCurrency(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setIsDefault(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setIsDefault(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setIsDefault(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RateInfoReturnElement> buildRateInfoReturnElement(JSONArray jsonArray) {
        ArrayList<RateInfoReturnElement> returnElement = new ArrayList<RateInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RateInfoReturnElement entity = new RateInfoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setFromUnit(getLongValue(jsonObject,"from_unit"));
            entity.setToUnit(getLongValue(jsonObject,"to_unit"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setScheduleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setScheduleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setScheduleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setScheduleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setScheduleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientRateScheduleId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientRateScheduleId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFromUnit(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFromUnit(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFromUnit(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setToUnit(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setToUnit(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setToUnit(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRatePerUnit(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setRatePerUnit(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setRatePerUnit(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ParentPlansReturnElement> buildParentPlansReturnElement(JSONArray jsonArray) {
        ArrayList<ParentPlansReturnElement> returnElement = new ArrayList<ParentPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ParentPlansReturnElement entity = new ParentPlansReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParentPlan(getLongValue(jsonObject,"parent_plan"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setParentPlan(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setParentPlan(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setParentPlan(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ParentPlanIdsReturnElement> buildParentPlanIdsReturnElement(JSONArray jsonArray) {
        ArrayList<ParentPlanIdsReturnElement> returnElement = new ArrayList<ParentPlanIdsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ParentPlanIdsReturnElement entity = new ParentPlanIdsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParentPlanId(getStringValue(jsonObject,"parent_plan_id"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setParentPlanId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setParentPlanId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ExclusionPlansReturnElement> buildExclusionPlansReturnElement(JSONArray jsonArray) {
        ArrayList<ExclusionPlansReturnElement> returnElement = new ArrayList<ExclusionPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ExclusionPlansReturnElement entity = new ExclusionPlansReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setExclusionPlan(getLongValue(jsonObject,"exclusion_plan"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExclusionPlan(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setExclusionPlan(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setExclusionPlan(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ServiceTranslationDetailsReturnElement> buildServiceTranslationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<ServiceTranslationDetailsReturnElement> returnElement = new ArrayList<ServiceTranslationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServiceTranslationDetailsReturnElement entity = new ServiceTranslationDetailsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setServiceNo(getStringValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
                        ArrayList<RateSchedulesTReturnElement> arrayListRateSchedulesTReturnElement = buildRateSchedulesTReturnElement((JSONArray)jsonObject.get("rate_schedules_t"));
            for (RateSchedulesTReturnElement element : arrayListRateSchedulesTReturnElement){
                entity.getRateSchedulesT().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceNo(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceNo(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RateSchedulesTReturnElement> buildRateSchedulesTReturnElement(JSONArray jsonArray) {
        ArrayList<RateSchedulesTReturnElement> returnElement = new ArrayList<RateSchedulesTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RateSchedulesTReturnElement entity = new RateSchedulesTReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
                        ArrayList<RateInfoReturnElement> arrayListRateInfoReturnElement = buildRateInfoReturnElement((JSONArray)jsonObject.get("rate_info"));
            for (RateInfoReturnElement element : arrayListRateInfoReturnElement){
                entity.getRateInfo().add(element);
            }
            } else {
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SuppFieldsReturnElement> buildSuppFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<SuppFieldsReturnElement> returnElement = new ArrayList<SuppFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppFieldsReturnElement entity = new SuppFieldsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldDesc(getStringValue(jsonObject,"field_desc"));
            entity.setFieldOrder(getLongValue(jsonObject,"field_order"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldDesc(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldOrder(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFieldOrder(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFieldOrder(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SelOptionsReturnElement> buildSelOptionsReturnElement(JSONArray jsonArray) {
        ArrayList<SelOptionsReturnElement> returnElement = new ArrayList<SelOptionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SelOptionsReturnElement entity = new SelOptionsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setDisplayText(getStringValue(jsonObject,"display_text"));
            entity.setOptionValue(getStringValue(jsonObject,"option_value"));
            entity.setOptionValueOrder(getLongValue(jsonObject,"option_value_order"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDisplayText(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDisplayText(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setOptionValue(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setOptionValue(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setOptionValueOrder(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setOptionValueOrder(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setOptionValueOrder(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CouponsReturnElement> buildCouponsReturnElement(JSONArray jsonArray) {
        ArrayList<CouponsReturnElement> returnElement = new ArrayList<CouponsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponsReturnElement entity = new CouponsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCouponCd(getStringValue(jsonObject,"coupon_cd"));
            entity.setCouponDesc(getStringValue(jsonObject,"coupon_desc"));
            entity.setExpiresAfter(getStringValue(jsonObject,"expires_after"));
            entity.setCouponScope(getLongValue(jsonObject,"coupon_scope"));
                        ArrayList<CouponTranslationsReturnElement> arrayListCouponTranslationsReturnElement = buildCouponTranslationsReturnElement((JSONArray)jsonObject.get("coupon_translations"));
            for (CouponTranslationsReturnElement element : arrayListCouponTranslationsReturnElement){
                entity.getCouponTranslations().add(element);
            }
            entity.setCouponNo(getLongValue(jsonObject,"coupon_no"));
            entity.setCouponMsg(getStringValue(jsonObject,"coupon_msg"));
            entity.setStatusInd(getLongValue(jsonObject,"status_ind"));
            entity.setNoOfUses(getLongValue(jsonObject,"no_of_uses"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCouponCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCouponDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExpiresAfter(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExpiresAfter(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponScope(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setCouponScope(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setCouponScope(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setCouponNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setCouponNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponMsg(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCouponMsg(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setStatusInd(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setStatusInd(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setStatusInd(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setNoOfUses(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setNoOfUses(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setNoOfUses(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setStartDate(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setStartDate(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setEndDate(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setEndDate(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CouponTranslationsReturnElement> buildCouponTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<CouponTranslationsReturnElement> returnElement = new ArrayList<CouponTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponTranslationsReturnElement entity = new CouponTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setCouponDesc(getStringValue(jsonObject,"coupon_desc"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCouponDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<EligibleServiceTypesReturnElement> buildEligibleServiceTypesReturnElement(JSONArray jsonArray) {
        ArrayList<EligibleServiceTypesReturnElement> returnElement = new ArrayList<EligibleServiceTypesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            EligibleServiceTypesReturnElement entity = new EligibleServiceTypesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setEligibleServiceType(getStringValue(jsonObject,"eligible_service_type"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setEligibleServiceType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setEligibleServiceType(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CreditTemplateReturnElement> buildCreditTemplateReturnElement(JSONArray jsonArray) {
        ArrayList<CreditTemplateReturnElement> returnElement = new ArrayList<CreditTemplateReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CreditTemplateReturnElement entity = new CreditTemplateReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCreditTemplateNo(getLongValue(jsonObject,"credit_template_no"));
            entity.setCreditTemplateId(getStringValue(jsonObject,"credit_template_id"));
            entity.setCreditTemplateName(getStringValue(jsonObject,"credit_template_name"));
            entity.setClientCreditTemplateId(getStringValue(jsonObject,"client_credit_template_id"));
            entity.setEligiblePlanNo(getLongValue(jsonObject,"eligible_plan_no"));
            entity.setEligibleClientPlanId(getStringValue(jsonObject,"eligible_client_plan_id"));
            entity.setEligibleServiceNo(getLongValue(jsonObject,"eligible_service_no"));
            entity.setEligibleClientServiceId(getStringValue(jsonObject,"eligible_client_service_id"));
            entity.setNoOfCredits(getLongValue(jsonObject,"no_of_credits"));
            entity.setTimeBetweenCredits(getLongValue(jsonObject,"time_between_credits"));
            entity.setDiscountType(getLongValue(jsonObject,"discount_type"));
            entity.setDiscountAmt(getDoubleValue(jsonObject,"discount_amt"));
            entity.setPercentagePlanNo(getLongValue(jsonObject,"percentage_plan_no"));
            entity.setPercentageClientPlanId(getStringValue(jsonObject,"percentage_client_plan_id"));
            entity.setPercentageServiceNo(getLongValue(jsonObject,"percentage_service_no"));
            entity.setPercentageClientServiceId(getStringValue(jsonObject,"percentage_client_service_id"));
            entity.setAltServiceNo(getLongValue(jsonObject,"alt_service_no"));
            entity.setAltClientServiceId(getStringValue(jsonObject,"alt_client_service_id"));
                        ArrayList<EligibleServiceTypesReturnElement> arrayListEligibleServiceTypesReturnElement = buildEligibleServiceTypesReturnElement((JSONArray)jsonObject.get("eligible_service_types"));
            for (EligibleServiceTypesReturnElement element : arrayListEligibleServiceTypesReturnElement){
                entity.getEligibleServiceTypes().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCreditTemplateNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setCreditTemplateNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setCreditTemplateNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCreditTemplateId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCreditTemplateId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCreditTemplateName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCreditTemplateName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientCreditTemplateId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientCreditTemplateId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setEligiblePlanNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setEligiblePlanNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setEligiblePlanNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setEligibleClientPlanId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setEligibleClientPlanId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setEligibleServiceNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setEligibleServiceNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setEligibleServiceNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setEligibleClientServiceId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setEligibleClientServiceId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setNoOfCredits(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setNoOfCredits(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setNoOfCredits(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setTimeBetweenCredits(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setTimeBetweenCredits(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setTimeBetweenCredits(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDiscountType(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDiscountType(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDiscountType(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDiscountAmt(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setDiscountAmt(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setDiscountAmt(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPercentagePlanNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPercentagePlanNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPercentagePlanNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPercentageClientPlanId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPercentageClientPlanId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPercentageServiceNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPercentageServiceNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPercentageServiceNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPercentageClientServiceId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPercentageClientServiceId(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAltServiceNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setAltServiceNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setAltServiceNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAltClientServiceId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAltClientServiceId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<DiscountRuleReturnElement> buildDiscountRuleReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountRuleReturnElement> returnElement = new ArrayList<DiscountRuleReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountRuleReturnElement entity = new DiscountRuleReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRuleNo(getLongValue(jsonObject,"rule_no"));
            entity.setRuleName(getStringValue(jsonObject,"rule_name"));
            entity.setRuleId(getStringValue(jsonObject,"rule_id"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setDiscountType(getStringValue(jsonObject,"discount_type"));
            entity.setFlatPercentInd(getLongValue(jsonObject,"flat_percent_ind"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCurrency(getStringValue(jsonObject,"currency"));
            entity.setApplicableTransScope(getStringValue(jsonObject,"applicable_trans_scope"));
            entity.setDurationTypeInd(getStringValue(jsonObject,"duration_type_ind"));
            entity.setMaxApplicableMonths(getLongValue(jsonObject,"max_applicable_months"));
            entity.setMaxApplicationsPerAcct(getLongValue(jsonObject,"max_applications_per_acct"));
            entity.setInlineOffsetInd(getStringValue(jsonObject,"inline_offset_ind"));
            entity.setServiceCodeToUse(getLongValue(jsonObject,"service_code_to_use"));
            entity.setAltServiceNo2Apply(getLongValue(jsonObject,"alt_service_no_2_apply"));
            entity.setAltServiceId2Apply(getStringValue(jsonObject,"alt_service_id_2_apply"));
            entity.setScopeNo(getLongValue(jsonObject,"scope_no"));
                        ArrayList<PlanNoReturnElement> arrayListPlanNoReturnElement = buildPlanNoReturnElement((JSONArray)jsonObject.get("plan_no"));
            for (PlanNoReturnElement element : arrayListPlanNoReturnElement){
                entity.getPlanNo().add(element);
            }
                        ArrayList<ClientPlanIdReturnElement> arrayListClientPlanIdReturnElement = buildClientPlanIdReturnElement((JSONArray)jsonObject.get("client_plan_id"));
            for (ClientPlanIdReturnElement element : arrayListClientPlanIdReturnElement){
                entity.getClientPlanId().add(element);
            }
                        ArrayList<ServiceNoReturnElement> arrayListServiceNoReturnElement = buildServiceNoReturnElement((JSONArray)jsonObject.get("service_no"));
            for (ServiceNoReturnElement element : arrayListServiceNoReturnElement){
                entity.getServiceNo().add(element);
            }
                        ArrayList<ClientServiceIdReturnElement> arrayListClientServiceIdReturnElement = buildClientServiceIdReturnElement((JSONArray)jsonObject.get("client_service_id"));
            for (ClientServiceIdReturnElement element : arrayListClientServiceIdReturnElement){
                entity.getClientServiceId().add(element);
            }
                        ArrayList<ItemNoReturnElement> arrayListItemNoReturnElement = buildItemNoReturnElement((JSONArray)jsonObject.get("item_no"));
            for (ItemNoReturnElement element : arrayListItemNoReturnElement){
                entity.getItemNo().add(element);
            }
                        ArrayList<ClientItemIdReturnElement> arrayListClientItemIdReturnElement = buildClientItemIdReturnElement((JSONArray)jsonObject.get("client_item_id"));
            for (ClientItemIdReturnElement element : arrayListClientItemIdReturnElement){
                entity.getClientItemId().add(element);
            }
                        ArrayList<RuleApplicationReturnElement> arrayListRuleApplicationReturnElement = buildRuleApplicationReturnElement((JSONArray)jsonObject.get("rule_application"));
            for (RuleApplicationReturnElement element : arrayListRuleApplicationReturnElement){
                entity.getRuleApplication().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setRuleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setRuleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRuleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRuleId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExtDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExtDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDiscountType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDiscountType(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFlatPercentInd(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFlatPercentInd(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFlatPercentInd(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAmount(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setAmount(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setAmount(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCurrency(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCurrency(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setApplicableTransScope(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setApplicableTransScope(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDurationTypeInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDurationTypeInd(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMaxApplicableMonths(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setMaxApplicableMonths(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setMaxApplicableMonths(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMaxApplicationsPerAcct(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setMaxApplicationsPerAcct(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setMaxApplicationsPerAcct(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setInlineOffsetInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setInlineOffsetInd(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceCodeToUse(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setServiceCodeToUse(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setServiceCodeToUse(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAltServiceNo2Apply(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setAltServiceNo2Apply(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setAltServiceNo2Apply(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAltServiceId2Apply(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAltServiceId2Apply(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setScopeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setScopeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setScopeNo(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanNoReturnElement> buildPlanNoReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNoReturnElement> returnElement = new ArrayList<PlanNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNoReturnElement entity = new PlanNoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNos(getLongValue(jsonObject,"plan_nos"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanNos(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanNos(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanNos(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ClientPlanIdReturnElement> buildClientPlanIdReturnElement(JSONArray jsonArray) {
        ArrayList<ClientPlanIdReturnElement> returnElement = new ArrayList<ClientPlanIdReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientPlanIdReturnElement entity = new ClientPlanIdReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientPlanIds(getStringValue(jsonObject,"client_plan_ids"));
            entity.setPlanIds(getStringValue(jsonObject,"plan_ids"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientPlanIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientPlanIds(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanIds(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ServiceNoReturnElement> buildServiceNoReturnElement(JSONArray jsonArray) {
        ArrayList<ServiceNoReturnElement> returnElement = new ArrayList<ServiceNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServiceNoReturnElement entity = new ServiceNoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNos(getLongValue(jsonObject,"service_nos"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceNos(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setServiceNos(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setServiceNos(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ClientServiceIdReturnElement> buildClientServiceIdReturnElement(JSONArray jsonArray) {
        ArrayList<ClientServiceIdReturnElement> returnElement = new ArrayList<ClientServiceIdReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientServiceIdReturnElement entity = new ClientServiceIdReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientServiceIds(getStringValue(jsonObject,"client_service_ids"));
            entity.setServiceIds(getStringValue(jsonObject,"service_ids"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientServiceIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientServiceIds(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceIds(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ItemNoReturnElement> buildItemNoReturnElement(JSONArray jsonArray) {
        ArrayList<ItemNoReturnElement> returnElement = new ArrayList<ItemNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemNoReturnElement entity = new ItemNoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNos(getLongValue(jsonObject,"item_nos"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setItemNos(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setItemNos(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setItemNos(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ClientItemIdReturnElement> buildClientItemIdReturnElement(JSONArray jsonArray) {
        ArrayList<ClientItemIdReturnElement> returnElement = new ArrayList<ClientItemIdReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientItemIdReturnElement entity = new ClientItemIdReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientItemIds(getStringValue(jsonObject,"client_item_ids"));
            entity.setItemIds(getStringValue(jsonObject,"item_ids"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientItemIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientItemIds(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setItemIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setItemIds(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RuleApplicationReturnElement> buildRuleApplicationReturnElement(JSONArray jsonArray) {
        ArrayList<RuleApplicationReturnElement> returnElement = new ArrayList<RuleApplicationReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RuleApplicationReturnElement entity = new RuleApplicationReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
                        ArrayList<PlanNoReturnElement> arrayListPlanNoReturnElement = buildPlanNoReturnElement((JSONArray)jsonObject.get("plan_no"));
            for (PlanNoReturnElement element : arrayListPlanNoReturnElement){
                entity.getPlanNo().add(element);
            }
                        ArrayList<ClientPlanIdReturnElement> arrayListClientPlanIdReturnElement = buildClientPlanIdReturnElement((JSONArray)jsonObject.get("client_plan_id"));
            for (ClientPlanIdReturnElement element : arrayListClientPlanIdReturnElement){
                entity.getClientPlanId().add(element);
            }
                        ArrayList<ServiceNoReturnElement> arrayListServiceNoReturnElement = buildServiceNoReturnElement((JSONArray)jsonObject.get("service_no"));
            for (ServiceNoReturnElement element : arrayListServiceNoReturnElement){
                entity.getServiceNo().add(element);
            }
                        ArrayList<ClientServiceIdReturnElement> arrayListClientServiceIdReturnElement = buildClientServiceIdReturnElement((JSONArray)jsonObject.get("client_service_id"));
            for (ClientServiceIdReturnElement element : arrayListClientServiceIdReturnElement){
                entity.getClientServiceId().add(element);
            }
                        ArrayList<ItemNoReturnElement> arrayListItemNoReturnElement = buildItemNoReturnElement((JSONArray)jsonObject.get("item_no"));
            for (ItemNoReturnElement element : arrayListItemNoReturnElement){
                entity.getItemNo().add(element);
            }
                        ArrayList<ClientItemIdReturnElement> arrayListClientItemIdReturnElement = buildClientItemIdReturnElement((JSONArray)jsonObject.get("client_item_id"));
            for (ClientItemIdReturnElement element : arrayListClientItemIdReturnElement){
                entity.getClientItemId().add(element);
            }
                        ArrayList<PlanServiceReturnElement> arrayListPlanServiceReturnElement = buildPlanServiceReturnElement((JSONArray)jsonObject.get("plan_service"));
            for (PlanServiceReturnElement element : arrayListPlanServiceReturnElement){
                entity.getPlanService().add(element);
            }
            } else {
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanServiceReturnElement> buildPlanServiceReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServiceReturnElement> returnElement = new ArrayList<PlanServiceReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServiceReturnElement entity = new PlanServiceReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getStringValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setServiceNo(getStringValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanNo(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanNo(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientPlanId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientPlanId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceNo(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setServiceNo(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientServiceId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientServiceId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<DiscountBundleReturnElement> buildDiscountBundleReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountBundleReturnElement> returnElement = new ArrayList<DiscountBundleReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountBundleReturnElement entity = new DiscountBundleReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBundleNo(getLongValue(jsonObject,"bundle_no"));
            entity.setBundleName(getStringValue(jsonObject,"bundle_name"));
            entity.setBundleId(getStringValue(jsonObject,"bundle_id"));
            entity.setDescription(getStringValue(jsonObject,"description"));
                        ArrayList<RulesReturnElement> arrayListRulesReturnElement = buildRulesReturnElement((JSONArray)jsonObject.get("rules"));
            for (RulesReturnElement element : arrayListRulesReturnElement){
                entity.getRules().add(element);
            }
                        ArrayList<RuleIdsReturnElement> arrayListRuleIdsReturnElement = buildRuleIdsReturnElement((JSONArray)jsonObject.get("rule_ids"));
            for (RuleIdsReturnElement element : arrayListRuleIdsReturnElement){
                entity.getRuleIds().add(element);
            }
            entity.setAllowOverlapInd(getStringValue(jsonObject,"allow_overlap_ind"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBundleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setBundleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setBundleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBundleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBundleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBundleId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBundleId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAllowOverlapInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAllowOverlapInd(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RulesReturnElement> buildRulesReturnElement(JSONArray jsonArray) {
        ArrayList<RulesReturnElement> returnElement = new ArrayList<RulesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RulesReturnElement entity = new RulesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRule(getLongValue(jsonObject,"rule"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRule(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setRule(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setRule(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RuleIdsReturnElement> buildRuleIdsReturnElement(JSONArray jsonArray) {
        ArrayList<RuleIdsReturnElement> returnElement = new ArrayList<RuleIdsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RuleIdsReturnElement entity = new RuleIdsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRule(getStringValue(jsonObject,"rule"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRule(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRule(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CouponTranslationDetailsReturnElement> buildCouponTranslationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<CouponTranslationDetailsReturnElement> returnElement = new ArrayList<CouponTranslationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponTranslationDetailsReturnElement entity = new CouponTranslationDetailsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setCouponDesc(getStringValue(jsonObject,"coupon_desc"));
            entity.setCouponMsg(getStringValue(jsonObject,"coupon_msg"));
                        ArrayList<DiscountRuleTReturnElement> arrayListDiscountRuleTReturnElement = buildDiscountRuleTReturnElement((JSONArray)jsonObject.get("discount_rule_t"));
            for (DiscountRuleTReturnElement element : arrayListDiscountRuleTReturnElement){
                entity.getDiscountRuleT().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCouponDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCouponMsg(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCouponMsg(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<DiscountRuleTReturnElement> buildDiscountRuleTReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountRuleTReturnElement> returnElement = new ArrayList<DiscountRuleTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountRuleTReturnElement entity = new DiscountRuleTReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRuleNo(getLongValue(jsonObject,"rule_no"));
            entity.setRuleName(getStringValue(jsonObject,"rule_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setRuleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setRuleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRuleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExtDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExtDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CreditTemplatesReturnElement> buildCreditTemplatesReturnElement(JSONArray jsonArray) {
        ArrayList<CreditTemplatesReturnElement> returnElement = new ArrayList<CreditTemplatesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CreditTemplatesReturnElement entity = new CreditTemplatesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRecurringCreditTemplateNo(getLongValue(jsonObject,"recurring_credit_template_no"));
            entity.setCreditTemplateName(getStringValue(jsonObject,"credit_template_name"));
            entity.setClientCreditTemplateId(getStringValue(jsonObject,"client_credit_template_id"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRecurringCreditTemplateNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setRecurringCreditTemplateNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setRecurringCreditTemplateNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCreditTemplateName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCreditTemplateName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientCreditTemplateId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientCreditTemplateId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<DiscountBundlesReturnElement> buildDiscountBundlesReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountBundlesReturnElement> returnElement = new ArrayList<DiscountBundlesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountBundlesReturnElement entity = new DiscountBundlesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBundleNo(getLongValue(jsonObject,"bundle_no"));
            entity.setBundleName(getStringValue(jsonObject,"bundle_name"));
            entity.setBundleId(getStringValue(jsonObject,"bundle_id"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setAllowOverlapInd(getStringValue(jsonObject,"allow_overlap_ind"));
                        ArrayList<RulesReturnElement> arrayListRulesReturnElement = buildRulesReturnElement((JSONArray)jsonObject.get("rules"));
            for (RulesReturnElement element : arrayListRulesReturnElement){
                entity.getRules().add(element);
            }
                        ArrayList<RuleIdsReturnElement> arrayListRuleIdsReturnElement = buildRuleIdsReturnElement((JSONArray)jsonObject.get("rule_ids"));
            for (RuleIdsReturnElement element : arrayListRuleIdsReturnElement){
                entity.getRuleIds().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBundleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setBundleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setBundleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBundleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBundleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBundleId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setBundleId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAllowOverlapInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAllowOverlapInd(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<DiscountRulesReturnElement> buildDiscountRulesReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountRulesReturnElement> returnElement = new ArrayList<DiscountRulesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountRulesReturnElement entity = new DiscountRulesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRuleNo(getLongValue(jsonObject,"rule_no"));
            entity.setRuleId(getStringValue(jsonObject,"rule_id"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setDiscountType(getLongValue(jsonObject,"discount_type"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
                        ArrayList<DiscountRuleTranslationsReturnElement> arrayListDiscountRuleTranslationsReturnElement = buildDiscountRuleTranslationsReturnElement((JSONArray)jsonObject.get("discount_rule_translations"));
            for (DiscountRuleTranslationsReturnElement element : arrayListDiscountRuleTranslationsReturnElement){
                entity.getDiscountRuleTranslations().add(element);
            }
            entity.setRuleName(getStringValue(jsonObject,"rule_name"));
            entity.setCurrency(getStringValue(jsonObject,"currency"));
            entity.setApplicableTransScope(getStringValue(jsonObject,"applicable_trans_scope"));
            entity.setDurationTypeInd(getStringValue(jsonObject,"duration_type_ind"));
            entity.setMaxApplicableMonths(getLongValue(jsonObject,"max_applicable_months"));
            entity.setMaxApplicationsPerAcct(getLongValue(jsonObject,"max_applications_per_acct"));
            entity.setInlineOffsetInd(getStringValue(jsonObject,"inline_offset_ind"));
            entity.setServiceCodeToUse(getLongValue(jsonObject,"service_code_to_use"));
            entity.setAltServiceNo2Apply(getLongValue(jsonObject,"alt_service_no_2_apply"));
            entity.setAltServiceId2Apply(getStringValue(jsonObject,"alt_service_id_2_apply"));
            entity.setScopeNo(getLongValue(jsonObject,"scope_no"));
            entity.setDiscountBehaviorTypeInd(getStringValue(jsonObject,"discount_behavior_type_ind"));
                        ArrayList<PlanNoReturnElement> arrayListPlanNoReturnElement = buildPlanNoReturnElement((JSONArray)jsonObject.get("plan_no"));
            for (PlanNoReturnElement element : arrayListPlanNoReturnElement){
                entity.getPlanNo().add(element);
            }
                        ArrayList<ClientPlanIdReturnElement> arrayListClientPlanIdReturnElement = buildClientPlanIdReturnElement((JSONArray)jsonObject.get("client_plan_id"));
            for (ClientPlanIdReturnElement element : arrayListClientPlanIdReturnElement){
                entity.getClientPlanId().add(element);
            }
                        ArrayList<ServiceNoReturnElement> arrayListServiceNoReturnElement = buildServiceNoReturnElement((JSONArray)jsonObject.get("service_no"));
            for (ServiceNoReturnElement element : arrayListServiceNoReturnElement){
                entity.getServiceNo().add(element);
            }
                        ArrayList<ClientServiceIdReturnElement> arrayListClientServiceIdReturnElement = buildClientServiceIdReturnElement((JSONArray)jsonObject.get("client_service_id"));
            for (ClientServiceIdReturnElement element : arrayListClientServiceIdReturnElement){
                entity.getClientServiceId().add(element);
            }
                        ArrayList<ItemNoReturnElement> arrayListItemNoReturnElement = buildItemNoReturnElement((JSONArray)jsonObject.get("item_no"));
            for (ItemNoReturnElement element : arrayListItemNoReturnElement){
                entity.getItemNo().add(element);
            }
                        ArrayList<ClientItemIdReturnElement> arrayListClientItemIdReturnElement = buildClientItemIdReturnElement((JSONArray)jsonObject.get("client_item_id"));
            for (ClientItemIdReturnElement element : arrayListClientItemIdReturnElement){
                entity.getClientItemId().add(element);
            }
            entity.setUseAllOrNthSubsRule(getStringValue(jsonObject,"use_all_or_nth_subs_rule"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setRuleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setRuleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRuleId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExtDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExtDescription(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDiscountType(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDiscountType(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDiscountType(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAmount(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setAmount(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setAmount(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRuleName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCurrency(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCurrency(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setApplicableTransScope(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setApplicableTransScope(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDurationTypeInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDurationTypeInd(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMaxApplicableMonths(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setMaxApplicableMonths(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setMaxApplicableMonths(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMaxApplicationsPerAcct(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setMaxApplicationsPerAcct(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setMaxApplicationsPerAcct(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setInlineOffsetInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setInlineOffsetInd(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setServiceCodeToUse(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setServiceCodeToUse(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setServiceCodeToUse(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAltServiceNo2Apply(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setAltServiceNo2Apply(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setAltServiceNo2Apply(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAltServiceId2Apply(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAltServiceId2Apply(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setScopeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setScopeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setScopeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDiscountBehaviorTypeInd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDiscountBehaviorTypeInd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUseAllOrNthSubsRule(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUseAllOrNthSubsRule(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<DiscountRuleTranslationsReturnElement> buildDiscountRuleTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountRuleTranslationsReturnElement> returnElement = new ArrayList<DiscountRuleTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountRuleTranslationsReturnElement entity = new DiscountRuleTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setRuleNo(getLongValue(jsonObject,"rule_no"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setRuleName(getStringValue(jsonObject,"rule_name"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setRuleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setRuleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExtDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExtDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRuleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setRuleName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlansReturnElement> buildPlansReturnElement(JSONArray jsonArray) {
        ArrayList<PlansReturnElement> returnElement = new ArrayList<PlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlansReturnElement entity = new PlansReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanLevel(getLongValue(jsonObject,"plan_level"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setIsDeletable(getStringValue(jsonObject,"is_deletable"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientPlanId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientPlanId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanLevel(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanLevel(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanLevel(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setBillingInterval(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setBillingInterval(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setBillingInterval(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setActiveInd(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setActiveInd(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setActiveInd(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setIsDeletable(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setIsDeletable(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanGroupsReturnElement> buildPlanGroupsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanGroupsReturnElement> returnElement = new ArrayList<PlanGroupsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanGroupsReturnElement entity = new PlanGroupsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanGroup(getLongValue(jsonObject,"plan_group"));
            entity.setGroupNo(getLongValue(jsonObject,"group_no"));
            entity.setClientPlanChangeGroupId(getStringValue(jsonObject,"client_plan_change_group_id"));
            entity.setGroupName(getStringValue(jsonObject,"group_name"));
            entity.setGroupDesc(getStringValue(jsonObject,"group_desc"));
            entity.setGroupUsage(getStringValue(jsonObject,"group_usage"));
            entity.setGroupPlansCount(getLongValue(jsonObject,"group_plans_count"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanGroup(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanGroup(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanGroup(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setGroupNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setGroupNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientPlanChangeGroupId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientPlanChangeGroupId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setGroupName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setGroupDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupUsage(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setGroupUsage(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupPlansCount(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setGroupPlansCount(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setGroupPlansCount(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanGroupIdsReturnElement> buildPlanGroupIdsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanGroupIdsReturnElement> returnElement = new ArrayList<PlanGroupIdsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanGroupIdsReturnElement entity = new PlanGroupIdsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanGroupId(getStringValue(jsonObject,"plan_group_id"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanGroupId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanGroupId(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SurchargesReturnElement> buildSurchargesReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargesReturnElement> returnElement = new ArrayList<SurchargesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargesReturnElement entity = new SurchargesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
                        ArrayList<SurchargeNoReturnElement> arrayListSurchargeNoReturnElement = buildSurchargeNoReturnElement((JSONArray)jsonObject.get("surcharge_no"));
            for (SurchargeNoReturnElement element : arrayListSurchargeNoReturnElement){
                entity.getSurchargeNo().add(element);
            }
                        ArrayList<ClientSurchargeIdReturnElement> arrayListClientSurchargeIdReturnElement = buildClientSurchargeIdReturnElement((JSONArray)jsonObject.get("client_surcharge_id"));
            for (ClientSurchargeIdReturnElement element : arrayListClientSurchargeIdReturnElement){
                entity.getClientSurchargeId().add(element);
            }
            entity.setSurchargeName(getStringValue(jsonObject,"surcharge_name"));
            entity.setSurchargeTypeCd(getStringValue(jsonObject,"surcharge_type_cd"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setScopeLabel(getStringValue(jsonObject,"scope_label"));
            entity.setDeleteable(getStringValue(jsonObject,"deleteable"));
            entity.setSurchargeScope(getLongValue(jsonObject,"surcharge_scope"));
                        ArrayList<SurchargeTranslationsReturnElement> arrayListSurchargeTranslationsReturnElement = buildSurchargeTranslationsReturnElement((JSONArray)jsonObject.get("surcharge_translations"));
            for (SurchargeTranslationsReturnElement element : arrayListSurchargeTranslationsReturnElement){
                entity.getSurchargeTranslations().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setSurchargeName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeTypeCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setSurchargeTypeCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCurrencyCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCurrencyCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setScopeLabel(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setScopeLabel(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDeleteable(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDeleteable(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeScope(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setSurchargeScope(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setSurchargeScope(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SurchargeNoReturnElement> buildSurchargeNoReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargeNoReturnElement> returnElement = new ArrayList<SurchargeNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargeNoReturnElement entity = new SurchargeNoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSurchargeNos(getLongValue(jsonObject,"surcharge_nos"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeNos(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setSurchargeNos(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setSurchargeNos(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ClientSurchargeIdReturnElement> buildClientSurchargeIdReturnElement(JSONArray jsonArray) {
        ArrayList<ClientSurchargeIdReturnElement> returnElement = new ArrayList<ClientSurchargeIdReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientSurchargeIdReturnElement entity = new ClientSurchargeIdReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientSurchargeIds(getStringValue(jsonObject,"client_surcharge_ids"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientSurchargeIds(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientSurchargeIds(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PromotionsReturnElement> buildPromotionsReturnElement(JSONArray jsonArray) {
        ArrayList<PromotionsReturnElement> returnElement = new ArrayList<PromotionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PromotionsReturnElement entity = new PromotionsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setPromoDesc(getStringValue(jsonObject,"promo_desc"));
            entity.setExpiresAfter(getStringValue(jsonObject,"expires_after"));
                        ArrayList<PromotionTranslationsReturnElement> arrayListPromotionTranslationsReturnElement = buildPromotionTranslationsReturnElement((JSONArray)jsonObject.get("promotion_translations"));
            for (PromotionTranslationsReturnElement element : arrayListPromotionTranslationsReturnElement){
                entity.getPromotionTranslations().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPromoCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPromoDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExpiresAfter(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExpiresAfter(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PromotionTranslationsReturnElement> buildPromotionTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<PromotionTranslationsReturnElement> returnElement = new ArrayList<PromotionTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PromotionTranslationsReturnElement entity = new PromotionTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setPromoDesc(getStringValue(jsonObject,"promo_desc"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoCd(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPromoCd(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPromoDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPromoDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<UsageTypesReturnElement> buildUsageTypesReturnElement(JSONArray jsonArray) {
        ArrayList<UsageTypesReturnElement> returnElement = new ArrayList<UsageTypesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageTypesReturnElement entity = new UsageTypesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeDesc(getStringValue(jsonObject,"usage_type_desc"));
            entity.setUsageUnitType(getStringValue(jsonObject,"usage_unit_type"));
            entity.setUsageTypeName(getStringValue(jsonObject,"usage_type_name"));
            entity.setIsEditable(getLongValue(jsonObject,"is_editable"));
                        ArrayList<UsageTypeTranslationsReturnElement> arrayListUsageTypeTranslationsReturnElement = buildUsageTypeTranslationsReturnElement((JSONArray)jsonObject.get("usage_type_translations"));
            for (UsageTypeTranslationsReturnElement element : arrayListUsageTypeTranslationsReturnElement){
                entity.getUsageTypeTranslations().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setUsageTypeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setUsageTypeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageUnitType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageUnitType(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setIsEditable(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setIsEditable(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setIsEditable(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<UsageTypeTranslationsReturnElement> buildUsageTypeTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageTypeTranslationsReturnElement> returnElement = new ArrayList<UsageTypeTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageTypeTranslationsReturnElement entity = new UsageTypeTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeName(getStringValue(jsonObject,"usage_type_name"));
            entity.setUsageTypeDesc(getStringValue(jsonObject,"usage_type_desc"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setUsageTypeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setUsageTypeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<UsageTypeTranslationDetailsReturnElement> buildUsageTypeTranslationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageTypeTranslationDetailsReturnElement> returnElement = new ArrayList<UsageTypeTranslationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageTypeTranslationDetailsReturnElement entity = new UsageTypeTranslationDetailsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeName(getStringValue(jsonObject,"usage_type_name"));
            entity.setUsageTypeDesc(getStringValue(jsonObject,"usage_type_desc"));
            entity.setUsageTypeDisplayString(getStringValue(jsonObject,"usage_type_display_string"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setUsageTypeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setUsageTypeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeDesc(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageTypeDisplayString(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageTypeDisplayString(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<UsageUnitTypesReturnElement> buildUsageUnitTypesReturnElement(JSONArray jsonArray) {
        ArrayList<UsageUnitTypesReturnElement> returnElement = new ArrayList<UsageUnitTypesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageUnitTypesReturnElement entity = new UsageUnitTypesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setUsageUnitTypeNo(getLongValue(jsonObject,"usage_unit_type_no"));
            entity.setUsageUnitTypeDesc(getStringValue(jsonObject,"usage_unit_type_desc"));
                        ArrayList<UsageUnitTypeTranslationsReturnElement> arrayListUsageUnitTypeTranslationsReturnElement = buildUsageUnitTypeTranslationsReturnElement((JSONArray)jsonObject.get("usage_unit_type_translations"));
            for (UsageUnitTypeTranslationsReturnElement element : arrayListUsageUnitTypeTranslationsReturnElement){
                entity.getUsageUnitTypeTranslations().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageUnitTypeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setUsageUnitTypeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setUsageUnitTypeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageUnitTypeDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageUnitTypeDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<UsageUnitTypeTranslationsReturnElement> buildUsageUnitTypeTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageUnitTypeTranslationsReturnElement> returnElement = new ArrayList<UsageUnitTypeTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageUnitTypeTranslationsReturnElement entity = new UsageUnitTypeTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setUsageUnitTypeNo(getLongValue(jsonObject,"usage_unit_type_no"));
            entity.setUsageUnitTypeDesc(getStringValue(jsonObject,"usage_unit_type_desc"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageUnitTypeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setUsageUnitTypeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setUsageUnitTypeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setUsageUnitTypeDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setUsageUnitTypeDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AllowedValuesReturnElement> buildAllowedValuesReturnElement(JSONArray jsonArray) {
        ArrayList<AllowedValuesReturnElement> returnElement = new ArrayList<AllowedValuesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllowedValuesReturnElement entity = new AllowedValuesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setValue(getStringValue(jsonObject,"value"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setValue(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setValue(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AssociatedObjectsReturnElement> buildAssociatedObjectsReturnElement(JSONArray jsonArray) {
        ArrayList<AssociatedObjectsReturnElement> returnElement = new ArrayList<AssociatedObjectsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AssociatedObjectsReturnElement entity = new AssociatedObjectsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAssociatedObject(getStringValue(jsonObject,"associated_object"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAssociatedObject(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAssociatedObject(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<FieldCategoriesReturnElement> buildFieldCategoriesReturnElement(JSONArray jsonArray) {
        ArrayList<FieldCategoriesReturnElement> returnElement = new ArrayList<FieldCategoriesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            FieldCategoriesReturnElement entity = new FieldCategoriesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldCategoryNo(getLongValue(jsonObject,"field_category_no"));
            entity.setFieldCategoryName(getStringValue(jsonObject,"field_category_name"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldCategoryNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFieldCategoryNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFieldCategoryNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldCategoryName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldCategoryName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SuppObjFieldTranslationsReturnElement> buildSuppObjFieldTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<SuppObjFieldTranslationsReturnElement> returnElement = new ArrayList<SuppObjFieldTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppObjFieldTranslationsReturnElement entity = new SuppObjFieldTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setFieldNo(getLongValue(jsonObject,"field_no"));
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
                        ArrayList<AllowedValuesTReturnElement> arrayListAllowedValuesTReturnElement = buildAllowedValuesTReturnElement((JSONArray)jsonObject.get("allowed_values_t"));
            for (AllowedValuesTReturnElement element : arrayListAllowedValuesTReturnElement){
                entity.getAllowedValuesT().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFieldNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFieldNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AllowedValuesTReturnElement> buildAllowedValuesTReturnElement(JSONArray jsonArray) {
        ArrayList<AllowedValuesTReturnElement> returnElement = new ArrayList<AllowedValuesTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllowedValuesTReturnElement entity = new AllowedValuesTReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setValue(getStringValue(jsonObject,"value"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setValue(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setValue(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<FieldDetailsReturnElement> buildFieldDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<FieldDetailsReturnElement> returnElement = new ArrayList<FieldDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            FieldDetailsReturnElement entity = new FieldDetailsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldNo(getLongValue(jsonObject,"field_no"));
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setDescription(getLongValue(jsonObject,"description"));
            entity.setDatatype(getLongValue(jsonObject,"datatype"));
            entity.setMinNoSel(getLongValue(jsonObject,"min_no_sel"));
            entity.setMaxNoSel(getLongValue(jsonObject,"max_no_sel"));
            entity.setFormInputType(getStringValue(jsonObject,"form_input_type"));
                        ArrayList<AllowedValuesReturnElement> arrayListAllowedValuesReturnElement = buildAllowedValuesReturnElement((JSONArray)jsonObject.get("allowed_values"));
            for (AllowedValuesReturnElement element : arrayListAllowedValuesReturnElement){
                entity.getAllowedValues().add(element);
            }
            entity.setAssociatedTypes(getStringValue(jsonObject,"associated_types"));
                        ArrayList<FieldCategoriesReturnElement> arrayListFieldCategoriesReturnElement = buildFieldCategoriesReturnElement((JSONArray)jsonObject.get("field_categories"));
            for (FieldCategoriesReturnElement element : arrayListFieldCategoriesReturnElement){
                entity.getFieldCategories().add(element);
            }
                        ArrayList<ObjectValuesReturnElement> arrayListObjectValuesReturnElement = buildObjectValuesReturnElement((JSONArray)jsonObject.get("object_values"));
            for (ObjectValuesReturnElement element : arrayListObjectValuesReturnElement){
                entity.getObjectValues().add(element);
            }
            entity.setAllowInstanceOverride(getLongValue(jsonObject,"allow_instance_override"));
                        ArrayList<SuppObjFieldTranslationsReturnElement> arrayListSuppObjFieldTranslationsReturnElement = buildSuppObjFieldTranslationsReturnElement((JSONArray)jsonObject.get("supp_obj_field_translations"));
            for (SuppObjFieldTranslationsReturnElement element : arrayListSuppObjFieldTranslationsReturnElement){
                entity.getSuppObjFieldTranslations().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFieldNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFieldNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDescription(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDescription(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDatatype(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDatatype(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDatatype(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMinNoSel(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setMinNoSel(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setMinNoSel(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setMaxNoSel(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setMaxNoSel(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setMaxNoSel(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFormInputType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFormInputType(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAssociatedTypes(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setAssociatedTypes(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAllowInstanceOverride(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setAllowInstanceOverride(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setAllowInstanceOverride(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ObjectValuesReturnElement> buildObjectValuesReturnElement(JSONArray jsonArray) {
        ArrayList<ObjectValuesReturnElement> returnElement = new ArrayList<ObjectValuesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ObjectValuesReturnElement entity = new ObjectValuesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setObjectType(getStringValue(jsonObject,"object_type"));
            entity.setObjectId(getLongValue(jsonObject,"object_id"));
            entity.setValueText(getStringValue(jsonObject,"value_text"));
            entity.setPrimacy(getLongValue(jsonObject,"primacy"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setObjectType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setObjectType(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setObjectId(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setObjectId(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setObjectId(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setValueText(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setValueText(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPrimacy(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPrimacy(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPrimacy(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlanGroupTranslationInfoReturnElement> buildPlanGroupTranslationInfoReturnElement(JSONArray jsonArray) {
        ArrayList<PlanGroupTranslationInfoReturnElement> returnElement = new ArrayList<PlanGroupTranslationInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanGroupTranslationInfoReturnElement entity = new PlanGroupTranslationInfoReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
                        ArrayList<PlansTReturnElement> arrayListPlansTReturnElement = buildPlansTReturnElement((JSONArray)jsonObject.get("plans_t"));
            for (PlansTReturnElement element : arrayListPlansTReturnElement){
                entity.getPlansT().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PlansTReturnElement> buildPlansTReturnElement(JSONArray jsonArray) {
        ArrayList<PlansTReturnElement> returnElement = new ArrayList<PlansTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlansTReturnElement entity = new PlansTReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPlanDesc(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPlanNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPlanNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPlanNo(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CoaListReturnElement> buildCoaListReturnElement(JSONArray jsonArray) {
        ArrayList<CoaListReturnElement> returnElement = new ArrayList<CoaListReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CoaListReturnElement entity = new CoaListReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCoaId(getLongValue(jsonObject,"coa_id"));
            entity.setCoaCode(getStringValue(jsonObject,"coa_code"));
            entity.setCoaDescription(getStringValue(jsonObject,"coa_description"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCoaId(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setCoaId(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setCoaId(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCoaCode(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCoaCode(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCoaDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCoaDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CoaReturnElement> buildCoaReturnElement(JSONArray jsonArray) {
        ArrayList<CoaReturnElement> returnElement = new ArrayList<CoaReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CoaReturnElement entity = new CoaReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCoaId(getLongValue(jsonObject,"coa_id"));
            entity.setCoaCode(getStringValue(jsonObject,"coa_code"));
            entity.setCoaDescription(getStringValue(jsonObject,"coa_description"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCoaId(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setCoaId(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setCoaId(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCoaCode(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCoaCode(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setCoaDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setCoaDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SurchargeTranslationsReturnElement> buildSurchargeTranslationsReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargeTranslationsReturnElement> returnElement = new ArrayList<SurchargeTranslationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargeTranslationsReturnElement entity = new SurchargeTranslationsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setSurchargeNo(getLongValue(jsonObject,"surcharge_no"));
            entity.setSurchargeName(getStringValue(jsonObject,"surcharge_name"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setSurchargeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setSurchargeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setSurchargeName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SurchargeTierReturnElement> buildSurchargeTierReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargeTierReturnElement> returnElement = new ArrayList<SurchargeTierReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargeTierReturnElement entity = new SurchargeTierReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFrom(getLongValue(jsonObject,"from"));
            entity.setTo(getLongValue(jsonObject,"to"));
            entity.setRate(getDoubleValue(jsonObject,"rate"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFrom(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFrom(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFrom(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setTo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setTo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setTo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setRate(Double.parseDouble(((JSONArray)jsonArray.get(i)).get(0).toString()+".0"));
                    }
                } else {
                    entity.setRate(Double.parseDouble(jsonArray.get(i).toString()+".0"));
                }
            } catch (NumberFormatException e) {
                entity.setRate(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PayMethodReturnElement> buildPayMethodReturnElement(JSONArray jsonArray) {
        ArrayList<PayMethodReturnElement> returnElement = new ArrayList<PayMethodReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PayMethodReturnElement entity = new PayMethodReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPaymentMethodType(getStringValue(jsonObject,"payment_method_type"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPaymentMethodType(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPaymentMethodType(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SurchargeTranslationDetailsReturnElement> buildSurchargeTranslationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargeTranslationDetailsReturnElement> returnElement = new ArrayList<SurchargeTranslationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargeTranslationDetailsReturnElement entity = new SurchargeTranslationDetailsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
            entity.setSurchargeNo(getLongValue(jsonObject,"surcharge_no"));
            entity.setSurchargeName(getStringValue(jsonObject,"surcharge_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
                        ArrayList<SurchargeTierTReturnElement> arrayListSurchargeTierTReturnElement = buildSurchargeTierTReturnElement((JSONArray)jsonObject.get("surcharge_tier_t"));
            for (SurchargeTierTReturnElement element : arrayListSurchargeTierTReturnElement){
                entity.getSurchargeTierT().add(element);
            }
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setLocaleName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setLocaleNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setLocaleNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setLocaleNo(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setSurchargeNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setSurchargeNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setSurchargeName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setSurchargeName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setExtDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setExtDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SurchargeTierTReturnElement> buildSurchargeTierTReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargeTierTReturnElement> returnElement = new ArrayList<SurchargeTierTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargeTierTReturnElement entity = new SurchargeTierTReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setDescription(getStringValue(jsonObject,"description"));
            } else {
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ProfilesReturnElement> buildProfilesReturnElement(JSONArray jsonArray) {
        ArrayList<ProfilesReturnElement> returnElement = new ArrayList<ProfilesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ProfilesReturnElement entity = new ProfilesReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setProfileId(getLongValue(jsonObject,"profile_id"));
            entity.setClientProfileId(getStringValue(jsonObject,"client_profile_id"));
            entity.setProfileName(getStringValue(jsonObject,"profile_name"));
            entity.setProfileDesc(getStringValue(jsonObject,"profile_desc"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProfileId(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setProfileId(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setProfileId(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientProfileId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientProfileId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProfileName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setProfileName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProfileDesc(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setProfileDesc(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ProductFieldCategoryReturnElement> buildProductFieldCategoryReturnElement(JSONArray jsonArray) {
        ArrayList<ProductFieldCategoryReturnElement> returnElement = new ArrayList<ProductFieldCategoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ProductFieldCategoryReturnElement entity = new ProductFieldCategoryReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldCategoryNo(getLongValue(jsonObject,"field_category_no"));
            entity.setFieldCategoryName(getStringValue(jsonObject,"field_category_name"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldCategoryNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setFieldCategoryNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setFieldCategoryNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setFieldCategoryName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setFieldCategoryName(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<ProductFieldsReturnElement> buildProductFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<ProductFieldsReturnElement> returnElement = new ArrayList<ProductFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ProductFieldsReturnElement entity = new ProductFieldsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setProductFieldNo(getLongValue(jsonObject,"product_field_no"));
            entity.setProductFieldName(getStringValue(jsonObject,"product_field_name"));
            entity.setProductFieldDesc(getLongValue(jsonObject,"product_field_desc"));
            entity.setProductFieldValue(getStringValue(jsonObject,"product_field_value"));
            entity.setAllowInstanceOverride(getLongValue(jsonObject,"allow_instance_override"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProductFieldNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setProductFieldNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setProductFieldNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProductFieldName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setProductFieldName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProductFieldDesc(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setProductFieldDesc(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setProductFieldDesc(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setProductFieldValue(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setProductFieldValue(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setAllowInstanceOverride(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setAllowInstanceOverride(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setAllowInstanceOverride(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CouponGroupsReturnElement> buildCouponGroupsReturnElement(JSONArray jsonArray) {
        ArrayList<CouponGroupsReturnElement> returnElement = new ArrayList<CouponGroupsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponGroupsReturnElement entity = new CouponGroupsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setGroupNo(getLongValue(jsonObject,"group_no"));
            entity.setClientDefinedId(getStringValue(jsonObject,"client_defined_id"));
            entity.setGroupName(getStringValue(jsonObject,"group_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setPrecedence(getStringValue(jsonObject,"precedence"));
                        ArrayList<CouponsReturnElement> arrayListCouponsReturnElement = buildCouponsReturnElement((JSONArray)jsonObject.get("coupons"));
            for (CouponsReturnElement element : arrayListCouponsReturnElement){
                entity.getCoupons().add(element);
            }
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupNo(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setGroupNo(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setGroupNo(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setClientDefinedId(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setClientDefinedId(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setGroupName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setGroupName(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDescription(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setDescription(jsonArray.get(i).toString());
                }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPrecedence(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPrecedence(jsonArray.get(i).toString());
                }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AllPayMethodsReturnElement> buildAllPayMethodsReturnElement(JSONArray jsonArray) {
        ArrayList<AllPayMethodsReturnElement> returnElement = new ArrayList<AllPayMethodsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllPayMethodsReturnElement entity = new AllPayMethodsReturnElement();
            JSONObject jsonObject = null;
            if (jsonArray.get(i) instanceof JSONObject){
            jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setDaysUntilPaymentReminder01(getLongValue(jsonObject,"days_until_payment_reminder_01"));
            entity.setDaysUntilPaymentReminder02(getLongValue(jsonObject,"days_until_payment_reminder_02"));
            entity.setDaysUntilPaymentReminder03(getLongValue(jsonObject,"days_until_payment_reminder_03"));
            } else {
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPayMethodType(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setPayMethodType(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setPayMethodType(null);
            }
            if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setPayMethodName(((JSONArray)jsonArray.get(i)).get(0).toString());
                    }
                } else {
                    entity.setPayMethodName(jsonArray.get(i).toString());
                }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDaysUntilPaymentReminder01(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDaysUntilPaymentReminder01(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDaysUntilPaymentReminder01(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDaysUntilPaymentReminder02(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDaysUntilPaymentReminder02(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDaysUntilPaymentReminder02(null);
            }
            try {
                if (jsonArray.get(i) instanceof JSONArray){
                    if(((JSONArray)jsonArray.get(i)).size() > 0){
                        entity.setDaysUntilPaymentReminder03(Long.parseLong(((JSONArray)jsonArray.get(i)).get(0).toString()));
                    }
                } else {
                    entity.setDaysUntilPaymentReminder03(Long.parseLong(jsonArray.get(i).toString()));
                }
            } catch (NumberFormatException e) {
                entity.setDaysUntilPaymentReminder03(null);
            }
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    /* ****************** END - SPECIFIC METHODS FOR EACH RETURN ELEMENT (build<#name#>) **************************************** */

    /* ****************** ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT ********************************************** */
        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ServiceArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ServiceRow row : arrayList.getServiceRow()){
            if (row.getName() != null){
                parameters.add("name["+i+"]", getValue("String", row.getName()));
            }
            if (row.getGlCd() != null){
                parameters.add("gl_cd["+i+"]", getValue("String", row.getGlCd()));
            }
            if (row.getTaxable() != null){
                parameters.add("taxable["+i+"]", getValue("Long", row.getTaxable()));
            }
            if (row.getTaxGroup() != null){
                parameters.add("tax_group["+i+"]", getValue("Long", row.getTaxGroup()));
            }
            if (row.getCommodityCd() != null){
                parameters.add("commodity_cd["+i+"]", getValue("String", row.getCommodityCd()));
            }
            if (row.getServiceNo() != null){
                parameters.add("service_no["+i+"]", getValue("Long", row.getServiceNo()));
            }
            if (row.getClientServiceId() != null){
                parameters.add("client_service_id["+i+"]", getValue("String", row.getClientServiceId()));
            }
            if (row.getServiceType() != null){
                parameters.add("service_type["+i+"]", getValue("String", row.getServiceType()));
            }
            if (row.getTaxableInd() != null){
                parameters.add("taxable_ind["+i+"]", getValue("String", row.getTaxableInd()));
            }
            if (row.getUsageType() != null){
                parameters.add("usage_type["+i+"]", getValue("Long", row.getUsageType()));
            }
            if (row.getRateType() != null){
                parameters.add("rate_type["+i+"]", getValue("String", row.getRateType()));
            }
            if (row.getPricingRule() != null){
                parameters.add("pricing_rule["+i+"]", getValue("String", row.getPricingRule()));
            }
            if (row.getHighWater() != null){
                parameters.add("high_water["+i+"]", getValue("Long", row.getHighWater()));
            }
            if (row.getTaxInclusiveInd() != null){
                parameters.add("tax_inclusive_ind["+i+"]", getValue("Long", row.getTaxInclusiveInd()));
            }
                        addParameterValuesFromArray(parameters, row.getUsageThreshold(), "usage_threshold["+i+"]");
                        addParameterValuesFromArray(parameters, row.getTier(), "tier["+i+"]");
            if (row.getFulfillmentBasedInd() != null){
                parameters.add("fulfillment_based_ind["+i+"]", getValue("Long", row.getFulfillmentBasedInd()));
            }
            if (row.getApplyUsageRatesDaily() != null){
                parameters.add("apply_usage_rates_daily["+i+"]", getValue("Long", row.getApplyUsageRatesDaily()));
            }
            if (row.getBillingOption() != null){
                parameters.add("billing_option["+i+"]", getValue("Long", row.getBillingOption()));
            }
            if (row.getThreshold() != null){
                parameters.add("threshold["+i+"]", getValue("Long", row.getThreshold()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ServiceArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ServiceRow row : arrayList.getServiceRow()){
                        if (row.getName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[name]", getValue("String", row.getName()));
            }
                                    if (row.getGlCd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[gl_cd]", getValue("String", row.getGlCd()));
            }
                                    if (row.getTaxable() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[taxable]", getValue("Long", row.getTaxable()));
            }
                                    if (row.getTaxGroup() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[tax_group]", getValue("Long", row.getTaxGroup()));
            }
                                    if (row.getCommodityCd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[commodity_cd]", getValue("String", row.getCommodityCd()));
            }
                                    if (row.getServiceNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[service_no]", getValue("Long", row.getServiceNo()));
            }
                                    if (row.getClientServiceId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[client_service_id]", getValue("String", row.getClientServiceId()));
            }
                                    if (row.getServiceType() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[service_type]", getValue("String", row.getServiceType()));
            }
                                    if (row.getTaxableInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[taxable_ind]", getValue("String", row.getTaxableInd()));
            }
                                    if (row.getUsageType() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[usage_type]", getValue("Long", row.getUsageType()));
            }
                                    if (row.getRateType() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[rate_type]", getValue("String", row.getRateType()));
            }
                                    if (row.getPricingRule() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[pricing_rule]", getValue("String", row.getPricingRule()));
            }
                                    if (row.getHighWater() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[high_water]", getValue("Long", row.getHighWater()));
            }
                                    if (row.getTaxInclusiveInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[tax_inclusive_ind]", getValue("Long", row.getTaxInclusiveInd()));
            }
                        addParameterValuesFromArray(parameters, row.getUsageThreshold(), paramPrefix + "["+i+"]" + "[usage_threshold]");
            addParameterValuesFromArray(parameters, row.getTier(), paramPrefix + "["+i+"]" + "[tier]");
                        if (row.getFulfillmentBasedInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[fulfillment_based_ind]", getValue("Long", row.getFulfillmentBasedInd()));
            }
                                    if (row.getApplyUsageRatesDaily() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[apply_usage_rates_daily]", getValue("Long", row.getApplyUsageRatesDaily()));
            }
                                    if (row.getBillingOption() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[billing_option]", getValue("Long", row.getBillingOption()));
            }
                                    if (row.getThreshold() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[threshold]", getValue("Long", row.getThreshold()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ScheduleArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ScheduleRow row : arrayList.getScheduleRow()){
            if (row.getScheduleName() != null){
                parameters.add("schedule_name["+i+"]", getValue("String", row.getScheduleName()));
            }
            if (row.getCurrencyCd() != null){
                parameters.add("currency_cd["+i+"]", getValue("String", row.getCurrencyCd()));
            }
            if (row.getClientRateScheduleId() != null){
                parameters.add("client_rate_schedule_id["+i+"]", getValue("String", row.getClientRateScheduleId()));
            }
            if (row.getIsDefault() != null){
                parameters.add("is_default["+i+"]", getValue("Long", row.getIsDefault()));
            }
            if (row.getTaxInclusiveRate() != null){
                parameters.add("tax_inclusive_rate["+i+"]", getValue("Long", row.getTaxInclusiveRate()));
            }
                        addParameterValuesFromArray(parameters, row.getTier(), "tier["+i+"]");
            if (row.getScheduleNo() != null){
                parameters.add("schedule_no["+i+"]", getValue("String", row.getScheduleNo()));
            }
            if (row.getAvailableFromDt() != null){
                parameters.add("available_from_dt["+i+"]", getValue("String", row.getAvailableFromDt()));
            }
            if (row.getAvailableToDt() != null){
                parameters.add("available_to_dt["+i+"]", getValue("String", row.getAvailableToDt()));
            }
            if (row.getFutureRate() != null){
                parameters.add("future_rate["+i+"]", getValue("Long", row.getFutureRate()));
            }
            if (row.getFutureChangeDt() != null){
                parameters.add("future_change_dt["+i+"]", getValue("String", row.getFutureChangeDt()));
            }
            if (row.getFollowupRsNo() != null){
                parameters.add("followup_rs_no["+i+"]", getValue("Long", row.getFollowupRsNo()));
            }
            if (row.getClientFollowupRsId() != null){
                parameters.add("client_followup_rs_id["+i+"]", getValue("String", row.getClientFollowupRsId()));
            }
            if (row.getAmount() != null){
                parameters.add("amount["+i+"]", getValue("Double", row.getAmount()));
            }
            if (row.getFrom() != null){
                parameters.add("from["+i+"]", getValue("Long", row.getFrom()));
            }
            if (row.getTo() != null){
                parameters.add("to["+i+"]", getValue("Long", row.getTo()));
            }
            if (row.getDescription() != null){
                parameters.add("description["+i+"]", getValue("String", row.getDescription()));
            }
            if (row.getFutureAmount() != null){
                parameters.add("future_amount["+i+"]", getValue("Double", row.getFutureAmount()));
            }
            if (row.getMinSurchargeToApply() != null){
                parameters.add("min_surcharge_to_apply["+i+"]", getValue("Double", row.getMinSurchargeToApply()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ScheduleArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ScheduleRow row : arrayList.getScheduleRow()){
                        if (row.getScheduleName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[schedule_name]", getValue("String", row.getScheduleName()));
            }
                                    if (row.getCurrencyCd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[currency_cd]", getValue("String", row.getCurrencyCd()));
            }
                                    if (row.getClientRateScheduleId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[client_rate_schedule_id]", getValue("String", row.getClientRateScheduleId()));
            }
                                    if (row.getIsDefault() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[is_default]", getValue("Long", row.getIsDefault()));
            }
                                    if (row.getTaxInclusiveRate() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[tax_inclusive_rate]", getValue("Long", row.getTaxInclusiveRate()));
            }
                        addParameterValuesFromArray(parameters, row.getTier(), paramPrefix + "["+i+"]" + "[tier]");
                        if (row.getScheduleNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[schedule_no]", getValue("String", row.getScheduleNo()));
            }
                                    if (row.getAvailableFromDt() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[available_from_dt]", getValue("String", row.getAvailableFromDt()));
            }
                                    if (row.getAvailableToDt() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[available_to_dt]", getValue("String", row.getAvailableToDt()));
            }
                                    if (row.getFutureRate() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[future_rate]", getValue("Long", row.getFutureRate()));
            }
                                    if (row.getFutureChangeDt() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[future_change_dt]", getValue("String", row.getFutureChangeDt()));
            }
                                    if (row.getFollowupRsNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[followup_rs_no]", getValue("Long", row.getFollowupRsNo()));
            }
                                    if (row.getClientFollowupRsId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[client_followup_rs_id]", getValue("String", row.getClientFollowupRsId()));
            }
                                    if (row.getAmount() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[amount]", getValue("Double", row.getAmount()));
            }
                                    if (row.getFrom() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[from]", getValue("Long", row.getFrom()));
            }
                                    if (row.getTo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[to]", getValue("Long", row.getTo()));
            }
                                    if (row.getDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[description]", getValue("String", row.getDescription()));
            }
                                    if (row.getFutureAmount() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[future_amount]", getValue("Double", row.getFutureAmount()));
            }
                                    if (row.getMinSurchargeToApply() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[min_surcharge_to_apply]", getValue("Double", row.getMinSurchargeToApply()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.TierArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.TierRow row : arrayList.getTierRow()){
            if (row.getFrom() != null){
                parameters.add("from["+i+"]", getValue("Long", row.getFrom()));
            }
            if (row.getTo() != null){
                parameters.add("to["+i+"]", getValue("Long", row.getTo()));
            }
            if (row.getDescription() != null){
                parameters.add("description["+i+"]", getValue("String", row.getDescription()));
            }
            if (row.getAmount() != null){
                parameters.add("amount["+i+"]", getValue("Double", row.getAmount()));
            }
                        addParameterValuesFromArray(parameters, row.getSchedule(), "schedule["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.TierArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.TierRow row : arrayList.getTierRow()){
                        if (row.getFrom() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[from]", getValue("Long", row.getFrom()));
            }
                                    if (row.getTo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[to]", getValue("Long", row.getTo()));
            }
                                    if (row.getDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[description]", getValue("String", row.getDescription()));
            }
                                    if (row.getAmount() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[amount]", getValue("Double", row.getAmount()));
            }
                        addParameterValuesFromArray(parameters, row.getSchedule(), paramPrefix + "["+i+"]" + "[schedule]");
            i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ImageArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ImageRow row : arrayList.getImageRow()){
            if (row.getDefaultImageUrl() != null){
                parameters.add("default_image_url["+i+"]", getValue("String", row.getDefaultImageUrl()));
            }
            if (row.getThumbnailImageUrl() != null){
                parameters.add("thumbnail_image_url["+i+"]", getValue("String", row.getThumbnailImageUrl()));
            }
            if (row.getImageText() != null){
                parameters.add("image_text["+i+"]", getValue("String", row.getImageText()));
            }
            if (row.getDefaultInd() != null){
                parameters.add("default_ind["+i+"]", getValue("Long", row.getDefaultInd()));
            }
            if (row.getActive() != null){
                parameters.add("active["+i+"]", getValue("Long", row.getActive()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ImageArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ImageRow row : arrayList.getImageRow()){
                        if (row.getDefaultImageUrl() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[default_image_url]", getValue("String", row.getDefaultImageUrl()));
            }
                                    if (row.getThumbnailImageUrl() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[thumbnail_image_url]", getValue("String", row.getThumbnailImageUrl()));
            }
                                    if (row.getImageText() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[image_text]", getValue("String", row.getImageText()));
            }
                                    if (row.getDefaultInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[default_ind]", getValue("Long", row.getDefaultInd()));
            }
                                    if (row.getActive() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[active]", getValue("Long", row.getActive()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ParentClassArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ParentClassRow row : arrayList.getParentClassRow()){
            if (row.getClassNo() != null){
                parameters.add("class_no["+i+"]", getValue("Long", row.getClassNo()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ParentClassArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ParentClassRow row : arrayList.getParentClassRow()){
                        if (row.getClassNo() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getClassNo()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.SupplementalObjFieldArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.SupplementalObjFieldRow row : arrayList.getSupplementalObjFieldRow()){
            if (row.getFieldNo() != null){
                parameters.add("field_no["+i+"]", getValue("Long", row.getFieldNo()));
            }
            if (row.getFieldName() != null){
                parameters.add("field_name["+i+"]", getValue("String", row.getFieldName()));
            }
                        addParameterValuesFromArray(parameters, row.getFieldValue(), "field_value["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.SupplementalObjFieldArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.SupplementalObjFieldRow row : arrayList.getSupplementalObjFieldRow()){
                        if (row.getFieldNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_no]", getValue("Long", row.getFieldNo()));
            }
                                    if (row.getFieldName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_name]", getValue("String", row.getFieldName()));
            }
                        addParameterValuesFromArray(parameters, row.getFieldValue(), paramPrefix + "["+i+"]" + "[field_value]");
            i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.FieldValueArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.FieldValueRow row : arrayList.getFieldValueRow()){
            if (row.getFieldValue() != null){
                parameters.add("field_value["+i+"]", getValue("String", row.getFieldValue()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.FieldValueArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.FieldValueRow row : arrayList.getFieldValueRow()){
                        if (row.getFieldValue() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getFieldValue()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.TemplateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.TemplateRow row : arrayList.getTemplateRow()){
            if (row.getCreditTemplateName() != null){
                parameters.add("credit_template_name["+i+"]", getValue("String", row.getCreditTemplateName()));
            }
            if (row.getClientCreditTemplateId() != null){
                parameters.add("client_credit_template_id["+i+"]", getValue("String", row.getClientCreditTemplateId()));
            }
            if (row.getEligiblePlanNo() != null){
                parameters.add("eligible_plan_no["+i+"]", getValue("Long", row.getEligiblePlanNo()));
            }
            if (row.getEligibleClientPlanId() != null){
                parameters.add("eligible_client_plan_id["+i+"]", getValue("String", row.getEligibleClientPlanId()));
            }
            if (row.getEligibleServiceNo() != null){
                parameters.add("eligible_service_no["+i+"]", getValue("Long", row.getEligibleServiceNo()));
            }
            if (row.getEligibleClientServiceId() != null){
                parameters.add("eligible_client_service_id["+i+"]", getValue("String", row.getEligibleClientServiceId()));
            }
                        addParameterValuesFromArray(parameters, row.getEligibleServiceTypes(), "eligible_service_types["+i+"]");
            if (row.getDiscountType() != null){
                parameters.add("discount_type["+i+"]", getValue("Long", row.getDiscountType()));
            }
            if (row.getDiscountAmt() != null){
                parameters.add("discount_amt["+i+"]", getValue("Double", row.getDiscountAmt()));
            }
            if (row.getNoOfCredits() != null){
                parameters.add("no_of_credits["+i+"]", getValue("Long", row.getNoOfCredits()));
            }
            if (row.getCreditIntervalMonths() != null){
                parameters.add("credit_interval_months["+i+"]", getValue("Long", row.getCreditIntervalMonths()));
            }
            if (row.getPercentagePlanNo() != null){
                parameters.add("percentage_plan_no["+i+"]", getValue("Long", row.getPercentagePlanNo()));
            }
            if (row.getPercentageClientPlanId() != null){
                parameters.add("percentage_client_plan_id["+i+"]", getValue("String", row.getPercentageClientPlanId()));
            }
            if (row.getPercentageServiceNo() != null){
                parameters.add("percentage_service_no["+i+"]", getValue("Long", row.getPercentageServiceNo()));
            }
            if (row.getPercentageClientServiceId() != null){
                parameters.add("percentage_client_service_id["+i+"]", getValue("String", row.getPercentageClientServiceId()));
            }
            if (row.getAltServiceNo() != null){
                parameters.add("alt_service_no["+i+"]", getValue("Long", row.getAltServiceNo()));
            }
            if (row.getAltClientServiceId() != null){
                parameters.add("alt_client_service_id["+i+"]", getValue("String", row.getAltClientServiceId()));
            }
            if (row.getCurrencyCd() != null){
                parameters.add("currency_cd["+i+"]", getValue("String", row.getCurrencyCd()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.TemplateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.TemplateRow row : arrayList.getTemplateRow()){
                        if (row.getCreditTemplateName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[credit_template_name]", getValue("String", row.getCreditTemplateName()));
            }
                                    if (row.getClientCreditTemplateId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[client_credit_template_id]", getValue("String", row.getClientCreditTemplateId()));
            }
                                    if (row.getEligiblePlanNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[eligible_plan_no]", getValue("Long", row.getEligiblePlanNo()));
            }
                                    if (row.getEligibleClientPlanId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[eligible_client_plan_id]", getValue("String", row.getEligibleClientPlanId()));
            }
                                    if (row.getEligibleServiceNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[eligible_service_no]", getValue("Long", row.getEligibleServiceNo()));
            }
                                    if (row.getEligibleClientServiceId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[eligible_client_service_id]", getValue("String", row.getEligibleClientServiceId()));
            }
                        addParameterValuesFromArray(parameters, row.getEligibleServiceTypes(), paramPrefix + "["+i+"]" + "[eligible_service_types]");
                        if (row.getDiscountType() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[discount_type]", getValue("Long", row.getDiscountType()));
            }
                                    if (row.getDiscountAmt() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[discount_amt]", getValue("Double", row.getDiscountAmt()));
            }
                                    if (row.getNoOfCredits() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[no_of_credits]", getValue("Long", row.getNoOfCredits()));
            }
                                    if (row.getCreditIntervalMonths() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[credit_interval_months]", getValue("Long", row.getCreditIntervalMonths()));
            }
                                    if (row.getPercentagePlanNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[percentage_plan_no]", getValue("Long", row.getPercentagePlanNo()));
            }
                                    if (row.getPercentageClientPlanId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[percentage_client_plan_id]", getValue("String", row.getPercentageClientPlanId()));
            }
                                    if (row.getPercentageServiceNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[percentage_service_no]", getValue("Long", row.getPercentageServiceNo()));
            }
                                    if (row.getPercentageClientServiceId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[percentage_client_service_id]", getValue("String", row.getPercentageClientServiceId()));
            }
                                    if (row.getAltServiceNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[alt_service_no]", getValue("Long", row.getAltServiceNo()));
            }
                                    if (row.getAltClientServiceId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[alt_client_service_id]", getValue("String", row.getAltClientServiceId()));
            }
                                    if (row.getCurrencyCd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[currency_cd]", getValue("String", row.getCurrencyCd()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.EligibleServiceTypesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.EligibleServiceTypesRow row : arrayList.getEligibleServiceTypesRow()){
            if (row.getEligibleServiceType() != null){
                parameters.add("eligible_service_type["+i+"]", getValue("String", row.getEligibleServiceType()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.EligibleServiceTypesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.EligibleServiceTypesRow row : arrayList.getEligibleServiceTypesRow()){
                        if (row.getEligibleServiceType() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getEligibleServiceType()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingTemplateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingTemplateRow row : arrayList.getExistingTemplateRow()){
            if (row.getExistingTemplates() != null){
                parameters.add("existing_templates["+i+"]", getValue("Long", row.getExistingTemplates()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingTemplateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingTemplateRow row : arrayList.getExistingTemplateRow()){
                        if (row.getExistingTemplates() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getExistingTemplates()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingTemplateIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingTemplateIdRow row : arrayList.getExistingTemplateIdRow()){
            if (row.getExistingTemplateIds() != null){
                parameters.add("existing_template_ids["+i+"]", getValue("String", row.getExistingTemplateIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingTemplateIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingTemplateIdRow row : arrayList.getExistingTemplateIdRow()){
                        if (row.getExistingTemplateIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getExistingTemplateIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.DiscountRuleArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.DiscountRuleRow row : arrayList.getDiscountRuleRow()){
            if (row.getLabel() != null){
                parameters.add("label["+i+"]", getValue("String", row.getLabel()));
            }
            if (row.getRuleId() != null){
                parameters.add("rule_id["+i+"]", getValue("String", row.getRuleId()));
            }
            if (row.getDescription() != null){
                parameters.add("description["+i+"]", getValue("String", row.getDescription()));
            }
            if (row.getExtDescription() != null){
                parameters.add("ext_description["+i+"]", getValue("String", row.getExtDescription()));
            }
            if (row.getFlatPercentInd() != null){
                parameters.add("flat_percent_ind["+i+"]", getValue("String", row.getFlatPercentInd()));
            }
            if (row.getAmount() != null){
                parameters.add("amount["+i+"]", getValue("Double", row.getAmount()));
            }
            if (row.getCurrency() != null){
                parameters.add("currency["+i+"]", getValue("String", row.getCurrency()));
            }
            if (row.getDurationTypeInd() != null){
                parameters.add("duration_type_ind["+i+"]", getValue("String", row.getDurationTypeInd()));
            }
            if (row.getMaxApplicableMonths() != null){
                parameters.add("max_applicable_months["+i+"]", getValue("Long", row.getMaxApplicableMonths()));
            }
            if (row.getMaxApplicationsPerAcct() != null){
                parameters.add("max_applications_per_acct["+i+"]", getValue("Long", row.getMaxApplicationsPerAcct()));
            }
            if (row.getInlineOffsetInd() != null){
                parameters.add("inline_offset_ind["+i+"]", getValue("String", row.getInlineOffsetInd()));
            }
            if (row.getDiscountBehaviorTypeInd() != null){
                parameters.add("discount_behavior_type_ind["+i+"]", getValue("String", row.getDiscountBehaviorTypeInd()));
            }
            if (row.getServiceCodeToUse() != null){
                parameters.add("service_code_to_use["+i+"]", getValue("Long", row.getServiceCodeToUse()));
            }
            if (row.getAltServiceNo2Apply() != null){
                parameters.add("alt_service_no_2_apply["+i+"]", getValue("Long", row.getAltServiceNo2Apply()));
            }
            if (row.getAltServiceId2Apply() != null){
                parameters.add("alt_service_id_2_apply["+i+"]", getValue("String", row.getAltServiceId2Apply()));
            }
            if (row.getApplicableTransScope() != null){
                parameters.add("applicable_trans_scope["+i+"]", getValue("String", row.getApplicableTransScope()));
            }
            if (row.getScopeNo() != null){
                parameters.add("scope_no["+i+"]", getValue("Long", row.getScopeNo()));
            }
                        addParameterValuesFromArray(parameters, row.getPlanNo(), "plan_no["+i+"]");
                        addParameterValuesFromArray(parameters, row.getClientPlanId(), "client_plan_id["+i+"]");
                        addParameterValuesFromArray(parameters, row.getServiceNo(), "service_no["+i+"]");
                        addParameterValuesFromArray(parameters, row.getClientServiceId(), "client_service_id["+i+"]");
                        addParameterValuesFromArray(parameters, row.getItemNo(), "item_no["+i+"]");
                        addParameterValuesFromArray(parameters, row.getClientItemId(), "client_item_id["+i+"]");
            if (row.getUseAllOrNthSubsRule() != null){
                parameters.add("use_all_or_nth_subs_rule["+i+"]", getValue("String", row.getUseAllOrNthSubsRule()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.DiscountRuleArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.DiscountRuleRow row : arrayList.getDiscountRuleRow()){
                        if (row.getLabel() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[label]", getValue("String", row.getLabel()));
            }
                                    if (row.getRuleId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[rule_id]", getValue("String", row.getRuleId()));
            }
                                    if (row.getDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[description]", getValue("String", row.getDescription()));
            }
                                    if (row.getExtDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[ext_description]", getValue("String", row.getExtDescription()));
            }
                                    if (row.getFlatPercentInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[flat_percent_ind]", getValue("String", row.getFlatPercentInd()));
            }
                                    if (row.getAmount() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[amount]", getValue("Double", row.getAmount()));
            }
                                    if (row.getCurrency() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[currency]", getValue("String", row.getCurrency()));
            }
                                    if (row.getDurationTypeInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[duration_type_ind]", getValue("String", row.getDurationTypeInd()));
            }
                                    if (row.getMaxApplicableMonths() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[max_applicable_months]", getValue("Long", row.getMaxApplicableMonths()));
            }
                                    if (row.getMaxApplicationsPerAcct() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[max_applications_per_acct]", getValue("Long", row.getMaxApplicationsPerAcct()));
            }
                                    if (row.getInlineOffsetInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[inline_offset_ind]", getValue("String", row.getInlineOffsetInd()));
            }
                                    if (row.getDiscountBehaviorTypeInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[discount_behavior_type_ind]", getValue("String", row.getDiscountBehaviorTypeInd()));
            }
                                    if (row.getServiceCodeToUse() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[service_code_to_use]", getValue("Long", row.getServiceCodeToUse()));
            }
                                    if (row.getAltServiceNo2Apply() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[alt_service_no_2_apply]", getValue("Long", row.getAltServiceNo2Apply()));
            }
                                    if (row.getAltServiceId2Apply() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[alt_service_id_2_apply]", getValue("String", row.getAltServiceId2Apply()));
            }
                                    if (row.getApplicableTransScope() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[applicable_trans_scope]", getValue("String", row.getApplicableTransScope()));
            }
                                    if (row.getScopeNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[scope_no]", getValue("Long", row.getScopeNo()));
            }
                        addParameterValuesFromArray(parameters, row.getPlanNo(), paramPrefix + "["+i+"]" + "[plan_no]");
            addParameterValuesFromArray(parameters, row.getClientPlanId(), paramPrefix + "["+i+"]" + "[client_plan_id]");
            addParameterValuesFromArray(parameters, row.getServiceNo(), paramPrefix + "["+i+"]" + "[service_no]");
            addParameterValuesFromArray(parameters, row.getClientServiceId(), paramPrefix + "["+i+"]" + "[client_service_id]");
            addParameterValuesFromArray(parameters, row.getItemNo(), paramPrefix + "["+i+"]" + "[item_no]");
            addParameterValuesFromArray(parameters, row.getClientItemId(), paramPrefix + "["+i+"]" + "[client_item_id]");
                        if (row.getUseAllOrNthSubsRule() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[use_all_or_nth_subs_rule]", getValue("String", row.getUseAllOrNthSubsRule()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanNoRow row : arrayList.getPlanNoRow()){
            if (row.getPlanNos() != null){
                parameters.add("plan_nos["+i+"]", getValue("Long", row.getPlanNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanNoRow row : arrayList.getPlanNoRow()){
                        if (row.getPlanNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getPlanNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientPlanIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientPlanIdRow row : arrayList.getClientPlanIdRow()){
            if (row.getClientPlanIds() != null){
                parameters.add("client_plan_ids["+i+"]", getValue("String", row.getClientPlanIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientPlanIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientPlanIdRow row : arrayList.getClientPlanIdRow()){
                        if (row.getClientPlanIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getClientPlanIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ServiceNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ServiceNoRow row : arrayList.getServiceNoRow()){
            if (row.getServiceNos() != null){
                parameters.add("service_nos["+i+"]", getValue("Long", row.getServiceNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ServiceNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ServiceNoRow row : arrayList.getServiceNoRow()){
                        if (row.getServiceNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getServiceNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientServiceIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientServiceIdRow row : arrayList.getClientServiceIdRow()){
            if (row.getClientServiceIds() != null){
                parameters.add("client_service_ids["+i+"]", getValue("String", row.getClientServiceIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientServiceIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientServiceIdRow row : arrayList.getClientServiceIdRow()){
                        if (row.getClientServiceIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getClientServiceIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ItemNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ItemNoRow row : arrayList.getItemNoRow()){
            if (row.getItemNos() != null){
                parameters.add("item_nos["+i+"]", getValue("Long", row.getItemNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ItemNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ItemNoRow row : arrayList.getItemNoRow()){
                        if (row.getItemNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getItemNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientItemIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientItemIdRow row : arrayList.getClientItemIdRow()){
            if (row.getClientItemIds() != null){
                parameters.add("client_item_ids["+i+"]", getValue("String", row.getClientItemIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientItemIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientItemIdRow row : arrayList.getClientItemIdRow()){
                        if (row.getClientItemIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getClientItemIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountRuleArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountRuleRow row : arrayList.getExistingDiscountRuleRow()){
            if (row.getExistingRules() != null){
                parameters.add("existing_rules["+i+"]", getValue("Long", row.getExistingRules()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountRuleArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountRuleRow row : arrayList.getExistingDiscountRuleRow()){
                        if (row.getExistingRules() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getExistingRules()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountRuleIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountRuleIdRow row : arrayList.getExistingDiscountRuleIdRow()){
            if (row.getExistingDiscountRuleIds() != null){
                parameters.add("existing_discount_rule_ids["+i+"]", getValue("String", row.getExistingDiscountRuleIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountRuleIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountRuleIdRow row : arrayList.getExistingDiscountRuleIdRow()){
                        if (row.getExistingDiscountRuleIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getExistingDiscountRuleIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.DiscountBundleArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.DiscountBundleRow row : arrayList.getDiscountBundleRow()){
            if (row.getBundleName() != null){
                parameters.add("bundle_name["+i+"]", getValue("String", row.getBundleName()));
            }
            if (row.getBundleId() != null){
                parameters.add("bundle_id["+i+"]", getValue("String", row.getBundleId()));
            }
            if (row.getBundleDescription() != null){
                parameters.add("bundle_description["+i+"]", getValue("String", row.getBundleDescription()));
            }
            if (row.getAllowOverlapInd() != null){
                parameters.add("allow_overlap_ind["+i+"]", getValue("String", row.getAllowOverlapInd()));
            }
                        addParameterValuesFromArray(parameters, row.getRules(), "rules["+i+"]");
                        addParameterValuesFromArray(parameters, row.getRuleIds(), "rule_ids["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.DiscountBundleArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.DiscountBundleRow row : arrayList.getDiscountBundleRow()){
                        if (row.getBundleName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[bundle_name]", getValue("String", row.getBundleName()));
            }
                                    if (row.getBundleId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[bundle_id]", getValue("String", row.getBundleId()));
            }
                                    if (row.getBundleDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[bundle_description]", getValue("String", row.getBundleDescription()));
            }
                                    if (row.getAllowOverlapInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[allow_overlap_ind]", getValue("String", row.getAllowOverlapInd()));
            }
                        addParameterValuesFromArray(parameters, row.getRules(), paramPrefix + "["+i+"]" + "[rules]");
            addParameterValuesFromArray(parameters, row.getRuleIds(), paramPrefix + "["+i+"]" + "[rule_ids]");
            i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.RulesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.RulesRow row : arrayList.getRulesRow()){
            if (row.getRule() != null){
                parameters.add("rule["+i+"]", getValue("Long", row.getRule()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.RulesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.RulesRow row : arrayList.getRulesRow()){
                        if (row.getRule() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getRule()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.RuleIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.RuleIdsRow row : arrayList.getRuleIdsRow()){
            if (row.getRule() != null){
                parameters.add("rule["+i+"]", getValue("String", row.getRule()));
            }
            if (row.getRuleId() != null){
                parameters.add("rule_id["+i+"]", getValue("String", row.getRuleId()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.RuleIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.RuleIdsRow row : arrayList.getRuleIdsRow()){
                        if (row.getRule() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[rule]", getValue("String", row.getRule()));
            }
                                    if (row.getRuleId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[rule_id]", getValue("String", row.getRuleId()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountBundleArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountBundleRow row : arrayList.getExistingDiscountBundleRow()){
            if (row.getExistingBundles() != null){
                parameters.add("existing_bundles["+i+"]", getValue("Long", row.getExistingBundles()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountBundleArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountBundleRow row : arrayList.getExistingDiscountBundleRow()){
                        if (row.getExistingBundles() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getExistingBundles()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountBundleIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountBundleIdRow row : arrayList.getExistingDiscountBundleIdRow()){
            if (row.getExistingBundleIds() != null){
                parameters.add("existing_bundle_ids["+i+"]", getValue("String", row.getExistingBundleIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingDiscountBundleIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingDiscountBundleIdRow row : arrayList.getExistingDiscountBundleIdRow()){
                        if (row.getExistingBundleIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getExistingBundleIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.CouponNosArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.CouponNosRow row : arrayList.getCouponNosRow()){
            if (row.getCouponNo() != null){
                parameters.add("coupon_no["+i+"]", getValue("Long", row.getCouponNo()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.CouponNosArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.CouponNosRow row : arrayList.getCouponNosRow()){
                        if (row.getCouponNo() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getCouponNo()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.CouponArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.CouponRow row : arrayList.getCouponRow()){
            if (row.getCouponCd() != null){
                parameters.add("coupon_cd["+i+"]", getValue("String", row.getCouponCd()));
            }
            if (row.getCouponDesc() != null){
                parameters.add("coupon_desc["+i+"]", getValue("String", row.getCouponDesc()));
            }
            if (row.getCouponMsg() != null){
                parameters.add("coupon_msg["+i+"]", getValue("String", row.getCouponMsg()));
            }
            if (row.getStatusInd() != null){
                parameters.add("status_ind["+i+"]", getValue("Long", row.getStatusInd()));
            }
            if (row.getNoOfUses() != null){
                parameters.add("no_of_uses["+i+"]", getValue("Long", row.getNoOfUses()));
            }
            if (row.getStartDate() != null){
                parameters.add("start_date["+i+"]", getValue("String", row.getStartDate()));
            }
            if (row.getEndDate() != null){
                parameters.add("end_date["+i+"]", getValue("String", row.getEndDate()));
            }
            if (row.getCouponScope() != null){
                parameters.add("coupon_scope["+i+"]", getValue("Long", row.getCouponScope()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.CouponArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.CouponRow row : arrayList.getCouponRow()){
                        if (row.getCouponCd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[coupon_cd]", getValue("String", row.getCouponCd()));
            }
                                    if (row.getCouponDesc() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[coupon_desc]", getValue("String", row.getCouponDesc()));
            }
                                    if (row.getCouponMsg() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[coupon_msg]", getValue("String", row.getCouponMsg()));
            }
                                    if (row.getStatusInd() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[status_ind]", getValue("Long", row.getStatusInd()));
            }
                                    if (row.getNoOfUses() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[no_of_uses]", getValue("Long", row.getNoOfUses()));
            }
                                    if (row.getStartDate() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[start_date]", getValue("String", row.getStartDate()));
            }
                                    if (row.getEndDate() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[end_date]", getValue("String", row.getEndDate()));
            }
                                    if (row.getCouponScope() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[coupon_scope]", getValue("Long", row.getCouponScope()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingCouponArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingCouponRow row : arrayList.getExistingCouponRow()){
            if (row.getExistingCoupons() != null){
                parameters.add("existing_coupons["+i+"]", getValue("Long", row.getExistingCoupons()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExistingCouponArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExistingCouponRow row : arrayList.getExistingCouponRow()){
                        if (row.getExistingCoupons() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getExistingCoupons()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.TemplateNosArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.TemplateNosRow row : arrayList.getTemplateNosRow()){
            if (row.getTemplateNos() != null){
                parameters.add("template_nos["+i+"]", getValue("Long", row.getTemplateNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.TemplateNosArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.TemplateNosRow row : arrayList.getTemplateNosRow()){
                        if (row.getTemplateNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getTemplateNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.RuleNosArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.RuleNosRow row : arrayList.getRuleNosRow()){
            if (row.getRuleNos() != null){
                parameters.add("rule_nos["+i+"]", getValue("Long", row.getRuleNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.RuleNosArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.RuleNosRow row : arrayList.getRuleNosRow()){
                        if (row.getRuleNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getRuleNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.BundleNosArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.BundleNosRow row : arrayList.getBundleNosRow()){
            if (row.getBundleNos() != null){
                parameters.add("bundle_nos["+i+"]", getValue("Long", row.getBundleNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.BundleNosArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.BundleNosRow row : arrayList.getBundleNosRow()){
                        if (row.getBundleNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getBundleNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.UsageThresholdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.UsageThresholdRow row : arrayList.getUsageThresholdRow()){
            if (row.getNoticeDestType() != null){
                parameters.add("notice_dest_type["+i+"]", getValue("String", row.getNoticeDestType()));
            }
            if (row.getNoticeBalanceType() != null){
                parameters.add("notice_balance_type["+i+"]", getValue("String", row.getNoticeBalanceType()));
            }
                        addParameterValuesFromArray(parameters, row.getNotifications(), "notifications["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.UsageThresholdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.UsageThresholdRow row : arrayList.getUsageThresholdRow()){
                        if (row.getNoticeDestType() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[notice_dest_type]", getValue("String", row.getNoticeDestType()));
            }
                                    if (row.getNoticeBalanceType() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[notice_balance_type]", getValue("String", row.getNoticeBalanceType()));
            }
                        addParameterValuesFromArray(parameters, row.getNotifications(), paramPrefix + "["+i+"]" + "[notifications]");
            i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.NotificationsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.NotificationsRow row : arrayList.getNotificationsRow()){
            if (row.getUnits() != null){
                parameters.add("units["+i+"]", getValue("Long", row.getUnits()));
            }
            if (row.getValues() != null){
                parameters.add("values["+i+"]", getValue("", row.getValues()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.NotificationsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.NotificationsRow row : arrayList.getNotificationsRow()){
                        if (row.getUnits() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[units]", getValue("Long", row.getUnits()));
            }
                                    if (row.getValues() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[values]", getValue("", row.getValues()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanGroupRow row : arrayList.getPlanGroupRow()){
            if (row.getPlanGroups() != null){
                parameters.add("plan_groups["+i+"]", getValue("Long", row.getPlanGroups()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanGroupRow row : arrayList.getPlanGroupRow()){
                        if (row.getPlanGroups() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getPlanGroups()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanGroupIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanGroupIdRow row : arrayList.getPlanGroupIdRow()){
            if (row.getPlanGroupId() != null){
                parameters.add("plan_group_id["+i+"]", getValue("String", row.getPlanGroupId()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanGroupIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanGroupIdRow row : arrayList.getPlanGroupIdRow()){
                        if (row.getPlanGroupId() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getPlanGroupId()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ResourceArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ResourceRow row : arrayList.getResourceRow()){
            if (row.getResourceNo() != null){
                parameters.add("resource_no["+i+"]", getValue("Long", row.getResourceNo()));
            }
            if (row.getResourceName() != null){
                parameters.add("resource_name["+i+"]", getValue("String", row.getResourceName()));
            }
            if (row.getResourceDescription() != null){
                parameters.add("resource_description["+i+"]", getValue("String", row.getResourceDescription()));
            }
            if (row.getFlatThreshold() != null){
                parameters.add("flat_threshold["+i+"]", getValue("Long", row.getFlatThreshold()));
            }
            if (row.getResourceUnits() != null){
                parameters.add("resource_units["+i+"]", getValue("Long", row.getResourceUnits()));
            }
            if (row.getExpireOnPaidThrough() != null){
                parameters.add("expire_on_paid_through["+i+"]", getValue("String", row.getExpireOnPaidThrough()));
            }
            if (row.getAdditionalDays() != null){
                parameters.add("additional_days["+i+"]", getValue("Long", row.getAdditionalDays()));
            }
            if (row.getResetOnUpdate() != null){
                parameters.add("reset_on_update["+i+"]", getValue("String", row.getResetOnUpdate()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ResourceArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ResourceRow row : arrayList.getResourceRow()){
                        if (row.getResourceNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[resource_no]", getValue("Long", row.getResourceNo()));
            }
                                    if (row.getResourceName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[resource_name]", getValue("String", row.getResourceName()));
            }
                                    if (row.getResourceDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[resource_description]", getValue("String", row.getResourceDescription()));
            }
                                    if (row.getFlatThreshold() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[flat_threshold]", getValue("Long", row.getFlatThreshold()));
            }
                                    if (row.getResourceUnits() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[resource_units]", getValue("Long", row.getResourceUnits()));
            }
                                    if (row.getExpireOnPaidThrough() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[expire_on_paid_through]", getValue("String", row.getExpireOnPaidThrough()));
            }
                                    if (row.getAdditionalDays() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[additional_days]", getValue("Long", row.getAdditionalDays()));
            }
                                    if (row.getResetOnUpdate() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[reset_on_update]", getValue("String", row.getResetOnUpdate()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ParentPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ParentPlansRow row : arrayList.getParentPlansRow()){
            if (row.getParentPlan() != null){
                parameters.add("parent_plan["+i+"]", getValue("Long", row.getParentPlan()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ParentPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ParentPlansRow row : arrayList.getParentPlansRow()){
                        if (row.getParentPlan() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getParentPlan()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ParentClientPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ParentClientPlanIdsRow row : arrayList.getParentClientPlanIdsRow()){
            if (row.getParentClientPlanId() != null){
                parameters.add("parent_client_plan_id["+i+"]", getValue("String", row.getParentClientPlanId()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ParentClientPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ParentClientPlanIdsRow row : arrayList.getParentClientPlanIdsRow()){
                        if (row.getParentClientPlanId() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getParentClientPlanId()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExclusionPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExclusionPlansRow row : arrayList.getExclusionPlansRow()){
            if (row.getExclusionPlan() != null){
                parameters.add("exclusion_plan["+i+"]", getValue("Long", row.getExclusionPlan()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ExclusionPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ExclusionPlansRow row : arrayList.getExclusionPlansRow()){
                        if (row.getExclusionPlan() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getExclusionPlan()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ChildPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ChildPlansRow row : arrayList.getChildPlansRow()){
            if (row.getChildPlan() != null){
                parameters.add("child_plan["+i+"]", getValue("String", row.getChildPlan()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ChildPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ChildPlansRow row : arrayList.getChildPlansRow()){
                        if (row.getChildPlan() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getChildPlan()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.SurchargeNoRow row : arrayList.getSurchargeNoRow()){
            if (row.getSurchargeNos() != null){
                parameters.add("surcharge_nos["+i+"]", getValue("Long", row.getSurchargeNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.SurchargeNoRow row : arrayList.getSurchargeNoRow()){
                        if (row.getSurchargeNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getSurchargeNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientSurchargeIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientSurchargeIdRow row : arrayList.getClientSurchargeIdRow()){
            if (row.getClientSurchargeIds() != null){
                parameters.add("client_surcharge_ids["+i+"]", getValue("String", row.getClientSurchargeIds()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ClientSurchargeIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ClientSurchargeIdRow row : arrayList.getClientSurchargeIdRow()){
                        if (row.getClientSurchargeIds() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getClientSurchargeIds()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanNosArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanNosRow row : arrayList.getPlanNosRow()){
            if (row.getPlanNos() != null){
                parameters.add("plan_nos["+i+"]", getValue("Long", row.getPlanNos()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.PlanNosArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.PlanNosRow row : arrayList.getPlanNosRow()){
                        if (row.getPlanNos() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("Long", row.getPlanNos()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.AssignFieldCategoriesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.AssignFieldCategoriesRow row : arrayList.getAssignFieldCategoriesRow()){
            if (row.getFieldCategoryNo() != null){
                parameters.add("field_category_no["+i+"]", getValue("Long", row.getFieldCategoryNo()));
            }
            if (row.getFieldCategoryName() != null){
                parameters.add("field_category_name["+i+"]", getValue("String", row.getFieldCategoryName()));
            }
            if (row.getFieldCategoryDirective() != null){
                parameters.add("field_category_directive["+i+"]", getValue("Long", row.getFieldCategoryDirective()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.AssignFieldCategoriesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.AssignFieldCategoriesRow row : arrayList.getAssignFieldCategoriesRow()){
                        if (row.getFieldCategoryNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_category_no]", getValue("Long", row.getFieldCategoryNo()));
            }
                                    if (row.getFieldCategoryName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_category_name]", getValue("String", row.getFieldCategoryName()));
            }
                                    if (row.getFieldCategoryDirective() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_category_directive]", getValue("Long", row.getFieldCategoryDirective()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ObjectTypeArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ObjectTypeRow row : arrayList.getObjectTypeRow()){
            if (row.getObjectType() != null){
                parameters.add("object_type["+i+"]", getValue("String", row.getObjectType()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.ObjectTypeArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.ObjectTypeRow row : arrayList.getObjectTypeRow()){
                        if (row.getObjectType() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getObjectType()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.FieldSelectionArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.FieldSelectionRow row : arrayList.getFieldSelectionRow()){
            if (row.getFieldNo() != null){
                parameters.add("field_no["+i+"]", getValue("Long", row.getFieldNo()));
            }
            if (row.getFieldName() != null){
                parameters.add("field_name["+i+"]", getValue("String", row.getFieldName()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.FieldSelectionArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.FieldSelectionRow row : arrayList.getFieldSelectionRow()){
                        if (row.getFieldNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_no]", getValue("Long", row.getFieldNo()));
            }
                                    if (row.getFieldName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_name]", getValue("String", row.getFieldName()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.FieldCategoriesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.FieldCategoriesRow row : arrayList.getFieldCategoriesRow()){
            if (row.getFieldCategoryNo() != null){
                parameters.add("field_category_no["+i+"]", getValue("Long", row.getFieldCategoryNo()));
            }
            if (row.getFieldCategoryName() != null){
                parameters.add("field_category_name["+i+"]", getValue("String", row.getFieldCategoryName()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.FieldCategoriesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.FieldCategoriesRow row : arrayList.getFieldCategoriesRow()){
                        if (row.getFieldCategoryNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_category_no]", getValue("Long", row.getFieldCategoryNo()));
            }
                                    if (row.getFieldCategoryName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_category_name]", getValue("String", row.getFieldCategoryName()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.SurchargeTierArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.SurchargeTierRow row : arrayList.getSurchargeTierRow()){
            if (row.getFrom() != null){
                parameters.add("from["+i+"]", getValue("Long", row.getFrom()));
            }
            if (row.getTo() != null){
                parameters.add("to["+i+"]", getValue("Long", row.getTo()));
            }
            if (row.getRate() != null){
                parameters.add("rate["+i+"]", getValue("Double", row.getRate()));
            }
            if (row.getDescription() != null){
                parameters.add("description["+i+"]", getValue("String", row.getDescription()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.SurchargeTierArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.SurchargeTierRow row : arrayList.getSurchargeTierRow()){
                        if (row.getFrom() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[from]", getValue("Long", row.getFrom()));
            }
                                    if (row.getTo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[to]", getValue("Long", row.getTo()));
            }
                                    if (row.getRate() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[rate]", getValue("Double", row.getRate()));
            }
                                    if (row.getDescription() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[description]", getValue("String", row.getDescription()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.AssignCategoryPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.AssignCategoryPlansRow row : arrayList.getAssignCategoryPlansRow()){
            if (row.getPlanNo() != null){
                parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            }
            if (row.getClientPlanId() != null){
                parameters.add("client_plan_id["+i+"]", getValue("String", row.getClientPlanId()));
            }
            if (row.getPlanDirective() != null){
                parameters.add("plan_directive["+i+"]", getValue("Long", row.getPlanDirective()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.AssignCategoryPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.AssignCategoryPlansRow row : arrayList.getAssignCategoryPlansRow()){
                        if (row.getPlanNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            }
                                    if (row.getClientPlanId() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[client_plan_id]", getValue("String", row.getClientPlanId()));
            }
                                    if (row.getPlanDirective() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[plan_directive]", getValue("Long", row.getPlanDirective()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.AssignCategoryFieldsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.AssignCategoryFieldsRow row : arrayList.getAssignCategoryFieldsRow()){
            if (row.getFieldNo() != null){
                parameters.add("field_no["+i+"]", getValue("Long", row.getFieldNo()));
            }
            if (row.getFieldName() != null){
                parameters.add("field_name["+i+"]", getValue("String", row.getFieldName()));
            }
            if (row.getFieldDirective() != null){
                parameters.add("field_directive["+i+"]", getValue("Long", row.getFieldDirective()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.AssignCategoryFieldsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.AssignCategoryFieldsRow row : arrayList.getAssignCategoryFieldsRow()){
                        if (row.getFieldNo() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_no]", getValue("Long", row.getFieldNo()));
            }
                                    if (row.getFieldName() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_name]", getValue("String", row.getFieldName()));
            }
                                    if (row.getFieldDirective() != null){
                parameters.add(paramPrefix + "["+i+"]" + "[field_directive]", getValue("Long", row.getFieldDirective()));
            }
                        i++;
        }
    }

        public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.CouponsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.CouponsRow row : arrayList.getCouponsRow()){
            if (row.getCouponCd() != null){
                parameters.add("coupon_cd["+i+"]", getValue("String", row.getCouponCd()));
            }
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.admin.CouponsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.admin.CouponsRow row : arrayList.getCouponsRow()){
                        if (row.getCouponCd() != null){
                parameters.add(paramPrefix + "["+i+"]", getValue("String", row.getCouponCd()));
            }
                        i++;
        }
    }

    /* ****************** END - ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT **************************************** */

}
