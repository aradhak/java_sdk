package com.aria.common.rest.object;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.aria.common.shared.object.*;

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
        public static ArrayList<AccountDetailsReturnElement> buildAccountDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<AccountDetailsReturnElement> returnElement = new ArrayList<AccountDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AccountDetailsReturnElement entity = new AccountDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setSeniorAcctNo(getLongValue(jsonObject,"senior_acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setPassword(getStringValue(jsonObject,"password"));
            entity.setStatusCd(getStringValue(jsonObject,"status_cd"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setFirstName(getStringValue(jsonObject,"first_name"));
            entity.setMi(getStringValue(jsonObject,"mi"));
            entity.setLastName(getStringValue(jsonObject,"last_name"));
            entity.setAddress1(getStringValue(jsonObject,"address_1"));
            entity.setAddress2(getStringValue(jsonObject,"address_2"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setLocality(getStringValue(jsonObject,"locality"));
            entity.setPostalCode(getStringValue(jsonObject,"postal_code"));
            entity.setCountry(getStringValue(jsonObject,"country"));
            entity.setPhoneNpa(getLongValue(jsonObject,"phone_npa"));
            entity.setPhoneNxx(getLongValue(jsonObject,"phone_nxx"));
            entity.setPhoneSuffix(getStringValue(jsonObject,"phone_suffix"));
            entity.setPhoneExtension(getStringValue(jsonObject,"phone_extension"));
            entity.setIntlPhone(getStringValue(jsonObject,"intl_phone"));
            entity.setAltEmail(getStringValue(jsonObject,"alt_email"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setRespLevelCd(getStringValue(jsonObject,"resp_level_cd"));
            entity.setPayMethod(getStringValue(jsonObject,"pay_method"));
            entity.setCreated(getStringValue(jsonObject,"created"));
            entity.setLastUpdated(getStringValue(jsonObject,"last_updated"));
            entity.setClient1(getStringValue(jsonObject,"client_1"));
            entity.setCompanyName(getStringValue(jsonObject,"company_name"));
                        ArrayList<CurrentBillingInfoReturnElement> arrayListCurrentBillingInfoReturnElement = buildCurrentBillingInfoReturnElement((JSONArray)jsonObject.get("current_billing_info"));
            for (CurrentBillingInfoReturnElement element : arrayListCurrentBillingInfoReturnElement){
                entity.getCurrentBillingInfo().add(element);
            }
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setStateProv(getStringValue(jsonObject,"state_prov"));
            entity.setCountryEnglish(getStringValue(jsonObject,"country_english"));
            entity.setPromoName(getStringValue(jsonObject,"promo_name"));
            entity.setNoProvisionInd(getLongValue(jsonObject,"no_provision_ind"));
            entity.setBillActionCd(getLongValue(jsonObject,"bill_action_cd"));
            entity.setStatusName(getStringValue(jsonObject,"status_name"));
            entity.setAcctBalance(getDoubleValue(jsonObject,"acct_balance"));
                        ArrayList<SuppFieldReturnElement> arrayListSuppFieldReturnElement = buildSuppFieldReturnElement((JSONArray)jsonObject.get("supp_field"));
            for (SuppFieldReturnElement element : arrayListSuppFieldReturnElement){
                entity.getSuppField().add(element);
            }
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
                        ArrayList<SuppPlanReturnElement> arrayListSuppPlanReturnElement = buildSuppPlanReturnElement((JSONArray)jsonObject.get("supp_plan"));
            for (SuppPlanReturnElement element : arrayListSuppPlanReturnElement){
                entity.getSuppPlan().add(element);
            }
            entity.setInvoicePostingMethodCd(getLongValue(jsonObject,"invoice_posting_method_cd"));
            entity.setAcctStartDate(getStringValue(jsonObject,"acct_start_date"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CurrentBillingInfoReturnElement> buildCurrentBillingInfoReturnElement(JSONArray jsonArray) {
        ArrayList<CurrentBillingInfoReturnElement> returnElement = new ArrayList<CurrentBillingInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CurrentBillingInfoReturnElement entity = new CurrentBillingInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillingFirstName(getStringValue(jsonObject,"billing_first_name"));
            entity.setBillingMiddleInitial(getStringValue(jsonObject,"billing_middle_initial"));
            entity.setBillingLastName(getStringValue(jsonObject,"billing_last_name"));
            entity.setBillingAddress1(getStringValue(jsonObject,"billing_address1"));
            entity.setBillingAddress2(getStringValue(jsonObject,"billing_address2"));
            entity.setBillingCity(getStringValue(jsonObject,"billing_city"));
            entity.setBillingState(getStringValue(jsonObject,"billing_state"));
            entity.setBillingLocality(getStringValue(jsonObject,"billing_locality"));
            entity.setBillingZip(getStringValue(jsonObject,"billing_zip"));
            entity.setBillingCountry(getStringValue(jsonObject,"billing_country"));
            entity.setBillingPhoneNpa(getStringValue(jsonObject,"billing_phone_npa"));
            entity.setBillingPhoneNxx(getStringValue(jsonObject,"billing_phone_nxx"));
            entity.setBillingPhoneSuffix(getStringValue(jsonObject,"billing_phone_suffix"));
            entity.setBillingPhoneExtension(getStringValue(jsonObject,"billing_phone_extension"));
            entity.setBillingIntlPhone(getStringValue(jsonObject,"billing_intl_phone"));
            entity.setBillingEmail(getStringValue(jsonObject,"billing_email"));
            entity.setBillingPayMethod(getStringValue(jsonObject,"billing_pay_method"));
            entity.setBillingCcExpireMm(getStringValue(jsonObject,"billing_cc_expire_mm"));
            entity.setBillingCcExpireYyyy(getStringValue(jsonObject,"billing_cc_expire_yyyy"));
            entity.setBillingBankRoutingNum(getStringValue(jsonObject,"billing_bank_routing_num"));
            entity.setBillingAgreementId(getStringValue(jsonObject,"billing_agreement_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SuppFieldReturnElement> buildSuppFieldReturnElement(JSONArray jsonArray) {
        ArrayList<SuppFieldReturnElement> returnElement = new ArrayList<SuppFieldReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppFieldReturnElement entity = new SuppFieldReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppFieldName(getStringValue(jsonObject,"supp_field_name"));
            entity.setSuppFieldValue(getStringValue(jsonObject,"supp_field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<SuppPlanReturnElement> buildSuppPlanReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlanReturnElement> returnElement = new ArrayList<SuppPlanReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlanReturnElement entity = new SuppPlanReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppPlanNo(getLongValue(jsonObject,"supp_plan_no"));
            entity.setSuppPlanName(getStringValue(jsonObject,"supp_plan_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AccountStatusHistoryReturnElement> buildAccountStatusHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<AccountStatusHistoryReturnElement> returnElement = new ArrayList<AccountStatusHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AccountStatusHistoryReturnElement entity = new AccountStatusHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getStringValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setCompanyName(getStringValue(jsonObject,"company_name"));
            entity.setClient1(getStringValue(jsonObject,"client_1"));
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setAccountCreationDate(getStringValue(jsonObject,"account_creation_date"));
            entity.setPlanNo(getStringValue(jsonObject,"plan_no"));
            entity.setNewStatus(getStringValue(jsonObject,"new_status"));
            entity.setNewStatusCd(getLongValue(jsonObject,"new_status_cd"));
            entity.setOldStatus(getStringValue(jsonObject,"old_status"));
            entity.setOldStatusCd(getLongValue(jsonObject,"old_status_cd"));
            entity.setChangeDate(getStringValue(jsonObject,"change_date"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AccountPlanHistoryReturnElement> buildAccountPlanHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<AccountPlanHistoryReturnElement> returnElement = new ArrayList<AccountPlanHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AccountPlanHistoryReturnElement entity = new AccountPlanHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getStringValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setClient1(getStringValue(jsonObject,"client_1"));
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setAccountCreationDate(getStringValue(jsonObject,"account_creation_date"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setFromDate(getStringValue(jsonObject,"from_date"));
            entity.setToDate(getStringValue(jsonObject,"to_date"));
            entity.setOldPlanName(getStringValue(jsonObject,"old_plan_name"));
            entity.setOldPlanNo(getLongValue(jsonObject,"old_plan_no"));
            entity.setNewPlanName(getStringValue(jsonObject,"new_plan_name"));
            entity.setNewPlanNo(getLongValue(jsonObject,"new_plan_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<PaymentDetailsReturnElement> buildPaymentDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentDetailsReturnElement> returnElement = new ArrayList<PaymentDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentDetailsReturnElement entity = new PaymentDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPaymentId(getLongValue(jsonObject,"payment_id"));
            entity.setProcessorPaymentId(getLongValue(jsonObject,"processor_payment_id"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setPaymentDate(getStringValue(jsonObject,"payment_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCollectionStatusCd(getStringValue(jsonObject,"collection_status_cd"));
            entity.setCollectionStatusText(getStringValue(jsonObject,"collection_status_text"));
            entity.setProcessorName(getStringValue(jsonObject,"processor_name"));
            entity.setMethod(getStringValue(jsonObject,"method"));
            entity.setReferenceNum(getStringValue(jsonObject,"reference_num"));
            entity.setLastUpdated(getStringValue(jsonObject,"last_updated"));
            entity.setVoidingEventNo(getLongValue(jsonObject,"voiding_event_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<OrderDetailsReturnElement> buildOrderDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<OrderDetailsReturnElement> returnElement = new ArrayList<OrderDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OrderDetailsReturnElement entity = new OrderDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setInvoiceNo(getStringValue(jsonObject,"invoice_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setLastUpdated(getStringValue(jsonObject,"last_updated"));
            entity.setOrderStatus(getStringValue(jsonObject,"order_status"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
                        ArrayList<OrderItemReturnElement> arrayListOrderItemReturnElement = buildOrderItemReturnElement((JSONArray)jsonObject.get("order_item"));
            for (OrderItemReturnElement element : arrayListOrderItemReturnElement){
                entity.getOrderItem().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<OrderItemReturnElement> buildOrderItemReturnElement(JSONArray jsonArray) {
        ArrayList<OrderItemReturnElement> returnElement = new ArrayList<OrderItemReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OrderItemReturnElement entity = new OrderItemReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSku(getStringValue(jsonObject,"sku"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setUnitPrice(getDoubleValue(jsonObject,"unit_price"));
            entity.setSubtotal(getDoubleValue(jsonObject,"subtotal"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<InvoiceDetailsReturnElement> buildInvoiceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceDetailsReturnElement> returnElement = new ArrayList<InvoiceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceDetailsReturnElement entity = new InvoiceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setDebit(getDoubleValue(jsonObject,"debit"));
            entity.setCredit(getDoubleValue(jsonObject,"credit"));
            entity.setBillDate(getStringValue(jsonObject,"bill_date"));
            entity.setDueDate(getStringValue(jsonObject,"due_date"));
            entity.setPaidDate(getStringValue(jsonObject,"paid_date"));
            entity.setNotifyDate(getStringValue(jsonObject,"notify_date"));
            entity.setFromDate(getStringValue(jsonObject,"from_date"));
            entity.setToDate(getStringValue(jsonObject,"to_date"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setBalanceForward(getDoubleValue(jsonObject,"balance_forward"));
            entity.setStatementBalanceForward(getDoubleValue(jsonObject,"statement_balance_forward"));
            entity.setTotalDue(getDoubleValue(jsonObject,"total_due"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setAdditionalComments(getStringValue(jsonObject,"additional_comments"));
            entity.setTransactionType(getStringValue(jsonObject,"transaction_type"));
            entity.setLastUpdated(getStringValue(jsonObject,"last_updated"));
            entity.setAriaEventNo(getLongValue(jsonObject,"aria_event_no"));
            entity.setAriaStatementNo(getLongValue(jsonObject,"aria_statement_no"));
            entity.setAcctStatementSeqStr(getStringValue(jsonObject,"acct_statement_seq_str"));
            entity.setSecondAcctStatementSeqStr(getStringValue(jsonObject,"second_acct_statement_seq_str"));
            entity.setVoidingEventNo(getLongValue(jsonObject,"voiding_event_no"));
            entity.setCustomStatusLabel(getStringValue(jsonObject,"custom_status_label"));
            entity.setClientNotes(getStringValue(jsonObject,"client_notes"));
            entity.setInvoiceTypeCd(getStringValue(jsonObject,"invoice_type_cd"));
            entity.setPostingStatusCd(getLongValue(jsonObject,"posting_status_cd"));
            entity.setPostingDate(getStringValue(jsonObject,"posting_date"));
            entity.setPostingUser(getStringValue(jsonObject,"posting_user"));
                        ArrayList<InvoiceLineReturnElement> arrayListInvoiceLineReturnElement = buildInvoiceLineReturnElement((JSONArray)jsonObject.get("invoice_line"));
            for (InvoiceLineReturnElement element : arrayListInvoiceLineReturnElement){
                entity.getInvoiceLine().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<InvoiceLineReturnElement> buildInvoiceLineReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceLineReturnElement> returnElement = new ArrayList<InvoiceLineReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceLineReturnElement entity = new InvoiceLineReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineItemNo(getLongValue(jsonObject,"line_item_no"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setLedgerCode(getStringValue(jsonObject,"ledger_code"));
            entity.setCoaId(getLongValue(jsonObject,"coa_id"));
            entity.setCoaDescription(getStringValue(jsonObject,"coa_description"));
            entity.setUsageUnits(getDoubleValue(jsonObject,"usage_units"));
            entity.setUsageRate(getDoubleValue(jsonObject,"usage_rate"));
            entity.setUsageTypeNo(getDoubleValue(jsonObject,"usage_type_no"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setBasePlanUnits(getLongValue(jsonObject,"base_plan_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setProrationText(getStringValue(jsonObject,"proration_text"));
            entity.setAdvBillingPeriodTotalDays(getLongValue(jsonObject,"adv_billing_period_total_days"));
            entity.setProrationRemainingDays(getLongValue(jsonObject,"proration_remaining_days"));
            entity.setProrationDescription(getStringValue(jsonObject,"proration_description"));
                        ArrayList<InvoiceLineTaxReturnElement> arrayListInvoiceLineTaxReturnElement = buildInvoiceLineTaxReturnElement((JSONArray)jsonObject.get("invoice_line_tax"));
            for (InvoiceLineTaxReturnElement element : arrayListInvoiceLineTaxReturnElement){
                entity.getInvoiceLineTax().add(element);
            }
            entity.setRateScheduleNo(getDoubleValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleTierNo(getDoubleValue(jsonObject,"rate_schedule_tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<InvoiceLineTaxReturnElement> buildInvoiceLineTaxReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceLineTaxReturnElement> returnElement = new ArrayList<InvoiceLineTaxReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceLineTaxReturnElement entity = new InvoiceLineTaxReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTaxId(getLongValue(jsonObject,"tax_id"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setBeforeCreditAmount(getDoubleValue(jsonObject,"before_credit_amount"));
            entity.setJurisdiction(getStringValue(jsonObject,"jurisdiction"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setIsExcluded(getLongValue(jsonObject,"is_excluded"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<TransactionInformationReturnElement> buildTransactionInformationReturnElement(JSONArray jsonArray) {
        ArrayList<TransactionInformationReturnElement> returnElement = new ArrayList<TransactionInformationReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            TransactionInformationReturnElement entity = new TransactionInformationReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAriaEventNo(getLongValue(jsonObject,"aria_event_no"));
            entity.setTransactionDate(getStringValue(jsonObject,"transaction_date"));
            entity.setTransactionType(getStringValue(jsonObject,"transaction_type"));
            entity.setTransactionTypeNo(getLongValue(jsonObject,"transaction_type_no"));
            entity.setIsChargeType(getLongValue(jsonObject,"is_charge_type"));
            entity.setTypeSpecificId(getLongValue(jsonObject,"type_specific_id"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setAriaStatementNo(getLongValue(jsonObject,"aria_statement_no"));
            entity.setTotalAmountApplied(getDoubleValue(jsonObject,"total_amount_applied"));
            entity.setRelatedAmountApplied(getDoubleValue(jsonObject,"related_amount_applied"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setVoidDate(getStringValue(jsonObject,"void_date"));
            entity.setFullyAppliedDate(getStringValue(jsonObject,"fully_applied_date"));
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
                        ArrayList<RelatedTransactionReturnElement> arrayListRelatedTransactionReturnElement = buildRelatedTransactionReturnElement((JSONArray)jsonObject.get("related_transaction"));
            for (RelatedTransactionReturnElement element : arrayListRelatedTransactionReturnElement){
                entity.getRelatedTransaction().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RelatedTransactionReturnElement> buildRelatedTransactionReturnElement(JSONArray jsonArray) {
        ArrayList<RelatedTransactionReturnElement> returnElement = new ArrayList<RelatedTransactionReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RelatedTransactionReturnElement entity = new RelatedTransactionReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAriaEventNo(getLongValue(jsonObject,"aria_event_no"));
            entity.setTransactionDate(getStringValue(jsonObject,"transaction_date"));
            entity.setTransactionType(getStringValue(jsonObject,"transaction_type"));
            entity.setTransactionTypeNo(getLongValue(jsonObject,"transaction_type_no"));
            entity.setIsChargeType(getLongValue(jsonObject,"is_charge_type"));
            entity.setTypeSpecificId(getLongValue(jsonObject,"type_specific_id"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setAriaStatementNo(getLongValue(jsonObject,"aria_statement_no"));
            entity.setTotalAmountApplied(getDoubleValue(jsonObject,"total_amount_applied"));
            entity.setRelatedAmountApplied(getDoubleValue(jsonObject,"related_amount_applied"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setVoidDate(getStringValue(jsonObject,"void_date"));
            entity.setFullyAppliedDate(getStringValue(jsonObject,"fully_applied_date"));
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setRelatedAmount(getDoubleValue(jsonObject,"related_amount"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<RefundInformationReturnElement> buildRefundInformationReturnElement(JSONArray jsonArray) {
        ArrayList<RefundInformationReturnElement> returnElement = new ArrayList<RefundInformationReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RefundInformationReturnElement entity = new RefundInformationReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAriaEventNo(getLongValue(jsonObject,"aria_event_no"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setRefundAmount(getDoubleValue(jsonObject,"refund_amount"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCreateUser(getStringValue(jsonObject,"create_user"));
            entity.setRefundReasonCode(getLongValue(jsonObject,"refund_reason_code"));
            entity.setRefundReasonLabel(getStringValue(jsonObject,"refund_reason_label"));
            entity.setRefundReasonDescription(getStringValue(jsonObject,"refund_reason_description"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setAriaStatementNo(getLongValue(jsonObject,"aria_statement_no"));
            entity.setRefPaymentEventNo(getLongValue(jsonObject,"ref_payment_event_no"));
            entity.setRefPaymentTransactionType(getLongValue(jsonObject,"ref_payment_transaction_type"));
            entity.setRefPaymentTransactionDesc(getStringValue(jsonObject,"ref_payment_transaction_desc"));
            entity.setRefPaymentAmount(getDoubleValue(jsonObject,"ref_payment_amount"));
            entity.setRefundTransactionType(getLongValue(jsonObject,"refund_transaction_type"));
            entity.setRefundTransactionDesc(getStringValue(jsonObject,"refund_transaction_desc"));
            entity.setRefundCheckNum(getStringValue(jsonObject,"refund_check_num"));
            entity.setRefundBillSeqNo(getLongValue(jsonObject,"refund_bill_seq_no"));
            entity.setRefundPayMethodId(getLongValue(jsonObject,"refund_pay_method_id"));
            entity.setRefundPayMethodName(getStringValue(jsonObject,"refund_pay_method_name"));
            entity.setRefundCcId(getLongValue(jsonObject,"refund_cc_id"));
            entity.setRefundCcType(getStringValue(jsonObject,"refund_cc_type"));
            entity.setRefundPaymentSrcSuffix(getStringValue(jsonObject,"refund_payment_src_suffix"));
            entity.setRefundIsVoidedInd(getLongValue(jsonObject,"refund_is_voided_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<CouponHistoryReturnElement> buildCouponHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<CouponHistoryReturnElement> returnElement = new ArrayList<CouponHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponHistoryReturnElement entity = new CouponHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setCouponCd(getStringValue(jsonObject,"coupon_cd"));
            entity.setCouponCreateDate(getStringValue(jsonObject,"coupon_create_date"));
            entity.setCouponStatus(getStringValue(jsonObject,"coupon_status"));
            entity.setCouponCancelDate(getStringValue(jsonObject,"coupon_cancel_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<MapRecordReturnElement> buildMapRecordReturnElement(JSONArray jsonArray) {
        ArrayList<MapRecordReturnElement> returnElement = new ArrayList<MapRecordReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MapRecordReturnElement entity = new MapRecordReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setNumber(getLongValue(jsonObject,"number"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AllInvoiceDetailsReturnElement> buildAllInvoiceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<AllInvoiceDetailsReturnElement> returnElement = new ArrayList<AllInvoiceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllInvoiceDetailsReturnElement entity = new AllInvoiceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserId(getStringValue(jsonObject,"user_id"));
            entity.setInvoiceType(getStringValue(jsonObject,"invoice_type"));
            entity.setFromDate(getStringValue(jsonObject,"from_date"));
            entity.setToDate(getStringValue(jsonObject,"to_date"));
            entity.setUsageBillFromDate(getStringValue(jsonObject,"usage_bill_from_date"));
            entity.setUsageBillThruDate(getStringValue(jsonObject,"usage_bill_thru_date"));
            entity.setTaxedEmail(getStringValue(jsonObject,"taxed_email"));
            entity.setTaxedFirstName(getStringValue(jsonObject,"taxed_first_name"));
            entity.setTaxedMiddleInitial(getStringValue(jsonObject,"taxed_middle_initial"));
            entity.setTaxedLastName(getStringValue(jsonObject,"taxed_last_name"));
            entity.setTaxedAddress1(getStringValue(jsonObject,"taxed_address1"));
            entity.setTaxedAddress2(getStringValue(jsonObject,"taxed_address2"));
            entity.setTaxedAddress3(getStringValue(jsonObject,"taxed_address3"));
            entity.setTaxedCity(getStringValue(jsonObject,"taxed_city"));
            entity.setTaxedState(getStringValue(jsonObject,"taxed_state"));
            entity.setTaxedLocality(getStringValue(jsonObject,"taxed_locality"));
            entity.setTaxedZip(getStringValue(jsonObject,"taxed_zip"));
            entity.setTaxedCountry(getStringValue(jsonObject,"taxed_country"));
            entity.setDebit(getDoubleValue(jsonObject,"debit"));
            entity.setCredit(getDoubleValue(jsonObject,"credit"));
            entity.setBillDate(getStringValue(jsonObject,"bill_date"));
            entity.setDueDate(getStringValue(jsonObject,"due_date"));
            entity.setPaidDate(getStringValue(jsonObject,"paid_date"));
            entity.setNotifyDate(getStringValue(jsonObject,"notify_date"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setBalanceForward(getDoubleValue(jsonObject,"balance_forward"));
            entity.setStatementBalanceForward(getDoubleValue(jsonObject,"statement_balance_forward"));
            entity.setTotalDue(getDoubleValue(jsonObject,"total_due"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setAdditionalComments(getStringValue(jsonObject,"additional_comments"));
            entity.setTransactionType(getStringValue(jsonObject,"transaction_type"));
            entity.setLastUpdated(getStringValue(jsonObject,"last_updated"));
            entity.setAriaEventNo(getLongValue(jsonObject,"aria_event_no"));
            entity.setAriaStatementNo(getLongValue(jsonObject,"aria_statement_no"));
            entity.setAcctStatementSeqStr(getStringValue(jsonObject,"acct_statement_seq_str"));
            entity.setSecondAcctStatementSeqStr(getStringValue(jsonObject,"second_acct_statement_seq_str"));
            entity.setInvoiceLineItems(getStringValue(jsonObject,"invoice_line_items"));
            entity.setVoidingEventNo(getLongValue(jsonObject,"voiding_event_no"));
            entity.setBillCompanyName(getStringValue(jsonObject,"bill_company_name"));
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setCustomStatusLabel(getStringValue(jsonObject,"custom_status_label"));
            entity.setClientNotes(getStringValue(jsonObject,"client_notes"));
            entity.setPostingStatusCd(getLongValue(jsonObject,"posting_status_cd"));
            entity.setPostingDate(getStringValue(jsonObject,"posting_date"));
            entity.setPostingUser(getStringValue(jsonObject,"posting_user"));
                        ArrayList<AllInvoiceLineReturnElement> arrayListAllInvoiceLineReturnElement = buildAllInvoiceLineReturnElement((JSONArray)jsonObject.get("all_invoice_line"));
            for (AllInvoiceLineReturnElement element : arrayListAllInvoiceLineReturnElement){
                entity.getAllInvoiceLine().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AllInvoiceLineReturnElement> buildAllInvoiceLineReturnElement(JSONArray jsonArray) {
        ArrayList<AllInvoiceLineReturnElement> returnElement = new ArrayList<AllInvoiceLineReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllInvoiceLineReturnElement entity = new AllInvoiceLineReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineItemNo(getLongValue(jsonObject,"line_item_no"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setLedgerCode(getStringValue(jsonObject,"ledger_code"));
            entity.setCoaId(getLongValue(jsonObject,"coa_id"));
            entity.setCoaDescription(getStringValue(jsonObject,"coa_description"));
            entity.setUsageUnits(getDoubleValue(jsonObject,"usage_units"));
            entity.setUsageRate(getDoubleValue(jsonObject,"usage_rate"));
            entity.setUsageTypeNo(getDoubleValue(jsonObject,"usage_type_no"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setBasePlanUnits(getLongValue(jsonObject,"base_plan_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setProrationText(getStringValue(jsonObject,"proration_text"));
            entity.setAdvBillingPeriodTotalDays(getLongValue(jsonObject,"adv_billing_period_total_days"));
            entity.setProrationRemainingDays(getLongValue(jsonObject,"proration_remaining_days"));
            entity.setProrationDescription(getStringValue(jsonObject,"proration_description"));
                        ArrayList<AllInvoiceLineTaxReturnElement> arrayListAllInvoiceLineTaxReturnElement = buildAllInvoiceLineTaxReturnElement((JSONArray)jsonObject.get("all_invoice_line_tax"));
            for (AllInvoiceLineTaxReturnElement element : arrayListAllInvoiceLineTaxReturnElement){
                entity.getAllInvoiceLineTax().add(element);
            }
            entity.setRateScheduleNo(getDoubleValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleTierNo(getDoubleValue(jsonObject,"rate_schedule_tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
        public static ArrayList<AllInvoiceLineTaxReturnElement> buildAllInvoiceLineTaxReturnElement(JSONArray jsonArray) {
        ArrayList<AllInvoiceLineTaxReturnElement> returnElement = new ArrayList<AllInvoiceLineTaxReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllInvoiceLineTaxReturnElement entity = new AllInvoiceLineTaxReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTaxId(getLongValue(jsonObject,"tax_id"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setBeforeCreditAmount(getDoubleValue(jsonObject,"before_credit_amount"));
            entity.setJurisdiction(getStringValue(jsonObject,"jurisdiction"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setIsExcluded(getLongValue(jsonObject,"is_excluded"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    /* ****************** END - SPECIFIC METHODS FOR EACH RETURN ELEMENT (build<#name#>) **************************************** */

    /* ****************** ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT ********************************************** */
    /* ****************** END - ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT **************************************** */

}
