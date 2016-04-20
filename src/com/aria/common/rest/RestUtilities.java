package com.aria.common.rest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.aria.common.shared.*;

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
    public static ArrayList<InvoiceLineItemsReturnElement> buildInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceLineItemsReturnElement> returnElement = new ArrayList<InvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceLineItemsReturnElement entity = new InvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setBasePlanUnits(getDoubleValue(jsonObject,"base_plan_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setCsrComments(getStringValue(jsonObject,"csr_comments"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setProrationText(getStringValue(jsonObject,"proration_text"));
            entity.setAdvBillingPeriodTotalDays(getLongValue(jsonObject,"adv_billing_period_total_days"));
            entity.setProrationRemainingDays(getLongValue(jsonObject,"proration_remaining_days"));
            entity.setProrationDescription(getStringValue(jsonObject,"proration_description"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleTierNo(getLongValue(jsonObject,"rate_schedule_tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ErrorRecordsReturnElement> buildErrorRecordsReturnElement(JSONArray jsonArray) {
        ArrayList<ErrorRecordsReturnElement> returnElement = new ArrayList<ErrorRecordsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ErrorRecordsReturnElement entity = new ErrorRecordsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutClientRecordId(getStringValue(jsonObject,"out_client_record_id"));
            entity.setRecordErrorCode(getLongValue(jsonObject,"record_error_code"));
            entity.setRecordErrorMsg(getStringValue(jsonObject,"record_error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ErrorCodesReturnElement> buildErrorCodesReturnElement(JSONArray jsonArray) {
        ArrayList<ErrorCodesReturnElement> returnElement = new ArrayList<ErrorCodesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ErrorCodesReturnElement entity = new ErrorCodesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutMasterPlanInstanceNo(getLongValue(jsonObject,"out_master_plan_instance_no"));
            entity.setOutClientMpInstanceId(getStringValue(jsonObject,"out_client_mp_instance_id"));
            entity.setRecurCreditNo(getLongValue(jsonObject,"recur_credit_no"));
            entity.setErrorCode(getLongValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SeqNosReturnElement> buildSeqNosReturnElement(JSONArray jsonArray) {
        ArrayList<SeqNosReturnElement> returnElement = new ArrayList<SeqNosReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SeqNosReturnElement entity = new SeqNosReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSourceAcctSeqNo(getLongValue(jsonObject,"source_acct_seq_no"));
            entity.setTargetAcctSeqNo(getLongValue(jsonObject,"target_acct_seq_no"));
            entity.setPrimaryIndicatorCd(getLongValue(jsonObject,"primary_indicator_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceLineItemsListReturnElement> buildInvoiceLineItemsListReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceLineItemsListReturnElement> returnElement = new ArrayList<InvoiceLineItemsListReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceLineItemsListReturnElement entity = new InvoiceLineItemsListReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceIsTaxInd(getLongValue(jsonObject,"service_is_tax_ind"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setRefChargeLineNo(getLongValue(jsonObject,"ref_charge_line_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ThirdPartyErrorsReturnElement> buildThirdPartyErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<ThirdPartyErrorsReturnElement> returnElement = new ArrayList<ThirdPartyErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ThirdPartyErrorsReturnElement entity = new ThirdPartyErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setErrorClass(getStringValue(jsonObject,"error_class"));
            entity.setErrorCode(getStringValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<FailedRecordsReturnElement> buildFailedRecordsReturnElement(JSONArray jsonArray) {
        ArrayList<FailedRecordsReturnElement> returnElement = new ArrayList<FailedRecordsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            FailedRecordsReturnElement entity = new FailedRecordsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setUsageRecordNo(getLongValue(jsonObject,"usage_record_no"));
            entity.setClientRecordId(getStringValue(jsonObject,"client_record_id"));
            entity.setRecordErrorCode(getLongValue(jsonObject,"record_error_code"));
            entity.setRecordErrorMsg(getStringValue(jsonObject,"record_error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PaymentHistoryReturnElement> buildPaymentHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentHistoryReturnElement> returnElement = new ArrayList<PaymentHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentHistoryReturnElement entity = new PaymentHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setPaymentSource(getStringValue(jsonObject,"payment_source"));
            entity.setPaymentStatus(getStringValue(jsonObject,"payment_status"));
            entity.setPaymentDate(getStringValue(jsonObject,"payment_date"));
            entity.setPaymentTransType(getLongValue(jsonObject,"payment_trans_type"));
            entity.setPaymentCurrency(getStringValue(jsonObject,"payment_currency"));
            entity.setPaymentAmount(getDoubleValue(jsonObject,"payment_amount"));
            entity.setPaymentAmountLeftToApply(getDoubleValue(jsonObject,"payment_amount_left_to_apply"));
            entity.setVoidingEventNo(getLongValue(jsonObject,"voiding_event_no"));
            entity.setVoidableFlag(getLongValue(jsonObject,"voidable_flag"));
            entity.setCcSuffix(getStringValue(jsonObject,"cc_suffix"));
            entity.setCcString(getStringValue(jsonObject,"cc_string"));
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setProcStatusCode(getLongValue(jsonObject,"proc_status_code"));
            entity.setProcPaymentId(getStringValue(jsonObject,"proc_payment_id"));
            entity.setProcAuthCode(getStringValue(jsonObject,"proc_auth_code"));
            entity.setPaymentTimestamp(getStringValue(jsonObject,"payment_timestamp"));
            entity.setProcStatusText(getStringValue(jsonObject,"proc_status_text"));
                        ArrayList<PaymentApplicationDetailsReturnElement> arrayListPaymentApplicationDetailsReturnElement = buildPaymentApplicationDetailsReturnElement((JSONArray)jsonObject.get("payment_application_details"));
            for (PaymentApplicationDetailsReturnElement element : arrayListPaymentApplicationDetailsReturnElement){
                entity.getPaymentApplicationDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PaymentApplicationDetailsReturnElement> buildPaymentApplicationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentApplicationDetailsReturnElement> returnElement = new ArrayList<PaymentApplicationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentApplicationDetailsReturnElement entity = new PaymentApplicationDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceDate(getStringValue(jsonObject,"invoice_date"));
            entity.setInvoiceFromDate(getStringValue(jsonObject,"invoice_from_date"));
            entity.setInvoiceToDate(getStringValue(jsonObject,"invoice_to_date"));
            entity.setInvoicePayAppliedAmount(getDoubleValue(jsonObject,"invoice_pay_applied_amount"));
            entity.setInvoiceOverallPaidAmount(getDoubleValue(jsonObject,"invoice_overall_paid_amount"));
            entity.setInvoiceCharge(getDoubleValue(jsonObject,"invoice_charge"));
            entity.setInvoiceCredit(getDoubleValue(jsonObject,"invoice_credit"));
            entity.setInvoiceBalDue(getDoubleValue(jsonObject,"invoice_bal_due"));
                        ArrayList<AppliedTransactionsReturnElement> arrayListAppliedTransactionsReturnElement = buildAppliedTransactionsReturnElement((JSONArray)jsonObject.get("applied_transactions"));
            for (AppliedTransactionsReturnElement element : arrayListAppliedTransactionsReturnElement){
                entity.getAppliedTransactions().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AppliedTransactionsReturnElement> buildAppliedTransactionsReturnElement(JSONArray jsonArray) {
        ArrayList<AppliedTransactionsReturnElement> returnElement = new ArrayList<AppliedTransactionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AppliedTransactionsReturnElement entity = new AppliedTransactionsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setOriginalAmount(getDoubleValue(jsonObject,"original_amount"));
            entity.setAmountApplied(getDoubleValue(jsonObject,"amount_applied"));
            entity.setDateApplied(getStringValue(jsonObject,"date_applied"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<WriteOffInfoReturnElement> buildWriteOffInfoReturnElement(JSONArray jsonArray) {
        ArrayList<WriteOffInfoReturnElement> returnElement = new ArrayList<WriteOffInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            WriteOffInfoReturnElement entity = new WriteOffInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRecNo(getLongValue(jsonObject,"rec_no"));
            entity.setCreatedBy(getStringValue(jsonObject,"created_by"));
            entity.setCreatedDate(getStringValue(jsonObject,"created_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceDate(getStringValue(jsonObject,"invoice_date"));
            entity.setInvoiceAmt(getDoubleValue(jsonObject,"invoice_amt"));
                        ArrayList<WriteoffDetailsReturnElement> arrayListWriteoffDetailsReturnElement = buildWriteoffDetailsReturnElement((JSONArray)jsonObject.get("writeoff_details"));
            for (WriteoffDetailsReturnElement element : arrayListWriteoffDetailsReturnElement){
                entity.getWriteoffDetails().add(element);
            }
            entity.setDisputeCreationDate(getStringValue(jsonObject,"dispute_creation_date"));
            entity.setDisputeExpDate(getStringValue(jsonObject,"dispute_exp_date"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setSecondaryReasonCode(getLongValue(jsonObject,"secondary_reason_code"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setDisputeInd(getLongValue(jsonObject,"dispute_ind"));
            entity.setCanUnsettle(getStringValue(jsonObject,"can_unsettle"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<WriteoffDetailsReturnElement> buildWriteoffDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<WriteoffDetailsReturnElement> returnElement = new ArrayList<WriteoffDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            WriteoffDetailsReturnElement entity = new WriteoffDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceBillDate(getStringValue(jsonObject,"invoice_bill_date"));
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setTotalLineDebit(getDoubleValue(jsonObject,"total_line_debit"));
            entity.setWriteoffLineAmount(getDoubleValue(jsonObject,"writeoff_line_amount"));
            entity.setWriteoffLineStartDate(getStringValue(jsonObject,"writeoff_line_start_date"));
            entity.setWriteoffLineEndDate(getStringValue(jsonObject,"writeoff_line_end_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ReceiptActionReturnElement> buildReceiptActionReturnElement(JSONArray jsonArray) {
        ArrayList<ReceiptActionReturnElement> returnElement = new ArrayList<ReceiptActionReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ReceiptActionReturnElement entity = new ReceiptActionReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setActionTypeId(getLongValue(jsonObject,"action_type_id"));
            entity.setActionTypeLabel(getStringValue(jsonObject,"action_type_label"));
            entity.setActionTypeDesc(getStringValue(jsonObject,"action_type_desc"));
            entity.setActionRecIdLabel(getStringValue(jsonObject,"action_rec_id_label"));
            entity.setActionRecIdVal(getStringValue(jsonObject,"action_rec_id_val"));
            entity.setActionDate(getStringValue(jsonObject,"action_date"));
            entity.setActionUser(getStringValue(jsonObject,"action_user"));
            entity.setActionQualifier1Label(getStringValue(jsonObject,"action_qualifier_1_label"));
            entity.setActionQualifier1Val(getStringValue(jsonObject,"action_qualifier_1_val"));
            entity.setActionQualifier2Label(getStringValue(jsonObject,"action_qualifier_2_label"));
            entity.setActionQualifier2Val(getStringValue(jsonObject,"action_qualifier_2_val"));
            entity.setActionQualifier3Label(getStringValue(jsonObject,"action_qualifier_3_label"));
            entity.setActionQualifier3Val(getStringValue(jsonObject,"action_qualifier_3_val"));
            entity.setActionQualifier4Label(getStringValue(jsonObject,"action_qualifier_4_label"));
            entity.setActionQualifier4Val(getStringValue(jsonObject,"action_qualifier_4_val"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<VelocityDataReturnElement> buildVelocityDataReturnElement(JSONArray jsonArray) {
        ArrayList<VelocityDataReturnElement> returnElement = new ArrayList<VelocityDataReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            VelocityDataReturnElement entity = new VelocityDataReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setAction(getStringValue(jsonObject,"action"));
            entity.setDate(getStringValue(jsonObject,"date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ExtendedTransactionQualifiersReturnElement> buildExtendedTransactionQualifiersReturnElement(JSONArray jsonArray) {
        ArrayList<ExtendedTransactionQualifiersReturnElement> returnElement = new ArrayList<ExtendedTransactionQualifiersReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ExtendedTransactionQualifiersReturnElement entity = new ExtendedTransactionQualifiersReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setQualifierName(getStringValue(jsonObject,"qualifier_name"));
            entity.setQualifierValue(getStringValue(jsonObject,"qualifier_value"));
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
            entity.setBillDate(getStringValue(jsonObject,"bill_date"));
            entity.setDueDate(getStringValue(jsonObject,"due_date"));
            entity.setDaysPastDue(getLongValue(jsonObject,"days_past_due"));
            entity.setInvoiceAmount(getDoubleValue(jsonObject,"invoice_amount"));
            entity.setTotalPaid(getDoubleValue(jsonObject,"total_paid"));
            entity.setBalanceDue(getDoubleValue(jsonObject,"balance_due"));
            entity.setInvoiceTypeCd(getStringValue(jsonObject,"invoice_type_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OrderReturnElement> buildOrderReturnElement(JSONArray jsonArray) {
        ArrayList<OrderReturnElement> returnElement = new ArrayList<OrderReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OrderReturnElement entity = new OrderReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setStatusLabel(getStringValue(jsonObject,"status_label"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setClientOrderId(getStringValue(jsonObject,"client_order_id"));
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setOrderCreateClientReceiptId(getStringValue(jsonObject,"order_create_client_receipt_id"));
            entity.setOrderStatusClientReceiptId(getStringValue(jsonObject,"order_status_client_receipt_id"));
            entity.setStatementMessage(getStringValue(jsonObject,"statement_message"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OrderItemsReturnElement> buildOrderItemsReturnElement(JSONArray jsonArray) {
        ArrayList<OrderItemsReturnElement> returnElement = new ArrayList<OrderItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OrderItemsReturnElement entity = new OrderItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setLabel(getStringValue(jsonObject,"label"));
            entity.setAltLabel(getStringValue(jsonObject,"alt_label"));
            entity.setLongDesc(getStringValue(jsonObject,"long_desc"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setUnitAmount(getDoubleValue(jsonObject,"unit_amount"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineComments(getStringValue(jsonObject,"line_comments"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OrderItemsListReturnElement> buildOrderItemsListReturnElement(JSONArray jsonArray) {
        ArrayList<OrderItemsListReturnElement> returnElement = new ArrayList<OrderItemsListReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OrderItemsListReturnElement entity = new OrderItemsListReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setLabel(getStringValue(jsonObject,"label"));
            entity.setAltLabel(getStringValue(jsonObject,"alt_label"));
            entity.setLongDesc(getStringValue(jsonObject,"long_desc"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setUnitAmount(getDoubleValue(jsonObject,"unit_amount"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineComments(getStringValue(jsonObject,"line_comments"));
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setTierNo(getLongValue(jsonObject,"tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PaymentApplicationsReturnElement> buildPaymentApplicationsReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentApplicationsReturnElement> returnElement = new ArrayList<PaymentApplicationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentApplicationsReturnElement entity = new PaymentApplicationsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setAppliedAmount(getDoubleValue(jsonObject,"applied_amount"));
            entity.setCurrencyCode(getStringValue(jsonObject,"currency_code"));
            entity.setTransactionDate(getStringValue(jsonObject,"transaction_date"));
            entity.setIsVoided(getStringValue(jsonObject,"is_voided"));
            entity.setStatementNo(getLongValue(jsonObject,"statement_no"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setSeqStatementId(getStringValue(jsonObject,"seq_statement_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoicePaymentsReturnElement> buildInvoicePaymentsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoicePaymentsReturnElement> returnElement = new ArrayList<InvoicePaymentsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoicePaymentsReturnElement entity = new InvoicePaymentsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setAppliedAmount(getDoubleValue(jsonObject,"applied_amount"));
            entity.setCurrencyCode(getStringValue(jsonObject,"currency_code"));
            entity.setTransactionDate(getStringValue(jsonObject,"transaction_date"));
            entity.setIsVoided(getStringValue(jsonObject,"is_voided"));
            entity.setStatementNo(getLongValue(jsonObject,"statement_no"));
            entity.setPaymentType(getStringValue(jsonObject,"payment_type"));
            entity.setPaymentSrcDescription(getStringValue(jsonObject,"payment_src_description"));
            entity.setPaymentSrcSuffix(getStringValue(jsonObject,"payment_src_suffix"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setSeqStatementId(getStringValue(jsonObject,"seq_statement_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RefundDetailsReturnElement> buildRefundDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<RefundDetailsReturnElement> returnElement = new ArrayList<RefundDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RefundDetailsReturnElement entity = new RefundDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRefundTransactionId(getLongValue(jsonObject,"refund_transaction_id"));
            entity.setRefundAmount(getDoubleValue(jsonObject,"refund_amount"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCreateUser(getStringValue(jsonObject,"create_user"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setReasonLabel(getStringValue(jsonObject,"reason_label"));
            entity.setReasonDescription(getStringValue(jsonObject,"reason_description"));
            entity.setRefPaymentTransactionId(getLongValue(jsonObject,"ref_payment_transaction_id"));
            entity.setRefPaymentTransactionType(getLongValue(jsonObject,"ref_payment_transaction_type"));
            entity.setRefPaymentTransactionDesc(getStringValue(jsonObject,"ref_payment_transaction_desc"));
            entity.setRefPaymentAmount(getDoubleValue(jsonObject,"ref_payment_amount"));
            entity.setRefPaymentRefCode(getStringValue(jsonObject,"ref_payment_ref_code"));
            entity.setBillSeqNo(getLongValue(jsonObject,"bill_seq_no"));
            entity.setPayMethodId(getLongValue(jsonObject,"pay_method_id"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setCcId(getLongValue(jsonObject,"cc_id"));
            entity.setCcType(getStringValue(jsonObject,"cc_type"));
            entity.setPaymentSrcSuffix(getStringValue(jsonObject,"payment_src_suffix"));
            entity.setRefundCheckNum(getStringValue(jsonObject,"refund_check_num"));
            entity.setIsVoidedInd(getLongValue(jsonObject,"is_voided_ind"));
                        ArrayList<InvoiceReversalsReturnElement> arrayListInvoiceReversalsReturnElement = buildInvoiceReversalsReturnElement((JSONArray)jsonObject.get("invoice_reversals"));
            for (InvoiceReversalsReturnElement element : arrayListInvoiceReversalsReturnElement){
                entity.getInvoiceReversals().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceReversalsReturnElement> buildInvoiceReversalsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceReversalsReturnElement> returnElement = new ArrayList<InvoiceReversalsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceReversalsReturnElement entity = new InvoiceReversalsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceBillDate(getStringValue(jsonObject,"invoice_bill_date"));
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setTotalLineDebit(getDoubleValue(jsonObject,"total_line_debit"));
            entity.setReversedLineAmount(getDoubleValue(jsonObject,"reversed_line_amount"));
            entity.setReversedLineStartDate(getStringValue(jsonObject,"reversed_line_start_date"));
            entity.setReversedLineEndDate(getStringValue(jsonObject,"reversed_line_end_date"));
            entity.setTransactionId(getStringValue(jsonObject,"transaction_id"));
            entity.setReversalDate(getStringValue(jsonObject,"reversal_date"));
            entity.setServiceNo(getStringValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setTransactionComments(getStringValue(jsonObject,"transaction_comments"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RefundablePaymentsReturnElement> buildRefundablePaymentsReturnElement(JSONArray jsonArray) {
        ArrayList<RefundablePaymentsReturnElement> returnElement = new ArrayList<RefundablePaymentsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RefundablePaymentsReturnElement entity = new RefundablePaymentsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPaymentTransactionId(getLongValue(jsonObject,"payment_transaction_id"));
            entity.setPaymentDate(getStringValue(jsonObject,"payment_date"));
            entity.setPaymentDescription(getStringValue(jsonObject,"payment_description"));
            entity.setPaymentAmount(getDoubleValue(jsonObject,"payment_amount"));
            entity.setPaymentRefundedAmount(getDoubleValue(jsonObject,"payment_refunded_amount"));
            entity.setPaymentRefundableAmount(getDoubleValue(jsonObject,"payment_refundable_amount"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ReversibleAuthorizationsReturnElement> buildReversibleAuthorizationsReturnElement(JSONArray jsonArray) {
        ArrayList<ReversibleAuthorizationsReturnElement> returnElement = new ArrayList<ReversibleAuthorizationsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ReversibleAuthorizationsReturnElement entity = new ReversibleAuthorizationsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAuthNo(getLongValue(jsonObject,"auth_no"));
            entity.setProcAuthId(getStringValue(jsonObject,"proc_auth_id"));
            entity.setAuthorizationDate(getStringValue(jsonObject,"authorization_date"));
            entity.setAuthorizationReversibleAmount(getDoubleValue(jsonObject,"authorization_reversible_amount"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ReversibleInvoicesReturnElement> buildReversibleInvoicesReturnElement(JSONArray jsonArray) {
        ArrayList<ReversibleInvoicesReturnElement> returnElement = new ArrayList<ReversibleInvoicesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ReversibleInvoicesReturnElement entity = new ReversibleInvoicesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoicedAcctNo(getLongValue(jsonObject,"invoiced_acct_no"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceDate(getStringValue(jsonObject,"invoice_date"));
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setInvoiceLineDescription(getStringValue(jsonObject,"invoice_line_description"));
            entity.setInvoiceLineAmount(getDoubleValue(jsonObject,"invoice_line_amount"));
            entity.setInvoiceLineReversedAmount(getDoubleValue(jsonObject,"invoice_line_reversed_amount"));
            entity.setInvoiceLineReversibleAmount(getDoubleValue(jsonObject,"invoice_line_reversible_amount"));
            entity.setInvoiceLineIsRecurService(getLongValue(jsonObject,"invoice_line_is_recur_service"));
            entity.setInvoiceLineRecurStartDate(getStringValue(jsonObject,"invoice_line_recur_start_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SoReturnElement> buildSoReturnElement(JSONArray jsonArray) {
        ArrayList<SoReturnElement> returnElement = new ArrayList<SoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SoReturnElement entity = new SoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setStandingOrderNo(getLongValue(jsonObject,"standing_order_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setNumOrdersReq(getLongValue(jsonObject,"num_orders_req"));
            entity.setNumOrdersComp(getLongValue(jsonObject,"num_orders_comp"));
            entity.setNumOrdersRemain(getLongValue(jsonObject,"num_orders_remain"));
            entity.setIntervalDays(getLongValue(jsonObject,"interval_days"));
            entity.setLastOrderDate(getStringValue(jsonObject,"last_order_date"));
            entity.setNextOrderDate(getStringValue(jsonObject,"next_order_date"));
            entity.setStatusCd(getLongValue(jsonObject,"status_cd"));
            entity.setStatusLabel(getStringValue(jsonObject,"status_label"));
            entity.setStatusDesc(getStringValue(jsonObject,"status_desc"));
            entity.setFirstOrderDate(getStringValue(jsonObject,"first_order_date"));
            entity.setCancelDate(getStringValue(jsonObject,"cancel_date"));
            entity.setCancelComments(getStringValue(jsonObject,"cancel_comments"));
            entity.setClientOrderId(getStringValue(jsonObject,"client_order_id"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setStatementMessage(getStringValue(jsonObject,"statement_message"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SoItemsReturnElement> buildSoItemsReturnElement(JSONArray jsonArray) {
        ArrayList<SoItemsReturnElement> returnElement = new ArrayList<SoItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SoItemsReturnElement entity = new SoItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setLabel(getStringValue(jsonObject,"label"));
            entity.setAltLabel(getStringValue(jsonObject,"alt_label"));
            entity.setLongDesc(getStringValue(jsonObject,"long_desc"));
            entity.setUnits(getLongValue(jsonObject,"units"));
            entity.setUnitAmount(getDoubleValue(jsonObject,"unit_amount"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineComments(getStringValue(jsonObject,"line_comments"));
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setTierNo(getLongValue(jsonObject,"tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ReversedInvoiceLinesReturnElement> buildReversedInvoiceLinesReturnElement(JSONArray jsonArray) {
        ArrayList<ReversedInvoiceLinesReturnElement> returnElement = new ArrayList<ReversedInvoiceLinesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ReversedInvoiceLinesReturnElement entity = new ReversedInvoiceLinesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setInvoiceLineServiceNo(getLongValue(jsonObject,"invoice_line_service_no"));
            entity.setInvoiceLineReversedAmount(getDoubleValue(jsonObject,"invoice_line_reversed_amount"));
            entity.setInvoiceLineReversingDate(getStringValue(jsonObject,"invoice_line_reversing_date"));
            entity.setInvoiceLineComments(getStringValue(jsonObject,"invoice_line_comments"));
            entity.setClientInvoiceLineServiceId(getStringValue(jsonObject,"client_invoice_line_service_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvCalcOutReturnElement> buildInvCalcOutReturnElement(JSONArray jsonArray) {
        ArrayList<InvCalcOutReturnElement> returnElement = new ArrayList<InvCalcOutReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvCalcOutReturnElement entity = new InvCalcOutReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTaxItemCode(getLongValue(jsonObject,"tax_item_code"));
            entity.setTaxItemDesc(getStringValue(jsonObject,"tax_item_desc"));
            entity.setTaxItemAmount(getDoubleValue(jsonObject,"tax_item_amount"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CartInvoiceLineItemsReturnElement> buildCartInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<CartInvoiceLineItemsReturnElement> returnElement = new ArrayList<CartInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CartInvoiceLineItemsReturnElement entity = new CartInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceIsTaxInd(getLongValue(jsonObject,"service_is_tax_ind"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setRefChargeLineNo(getLongValue(jsonObject,"ref_charge_line_no"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlanLineItemsReturnElement> buildSuppPlanLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlanLineItemsReturnElement> returnElement = new ArrayList<SuppPlanLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlanLineItemsReturnElement entity = new SuppPlanLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineBaseUnits(getDoubleValue(jsonObject,"line_base_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MultiSpInvoiceLineItemsReturnElement> buildMultiSpInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<MultiSpInvoiceLineItemsReturnElement> returnElement = new ArrayList<MultiSpInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MultiSpInvoiceLineItemsReturnElement entity = new MultiSpInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineBaseUnits(getDoubleValue(jsonObject,"line_base_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OutNewAcctPlanContractsReturnElement> buildOutNewAcctPlanContractsReturnElement(JSONArray jsonArray) {
        ArrayList<OutNewAcctPlanContractsReturnElement> returnElement = new ArrayList<OutNewAcctPlanContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OutNewAcctPlanContractsReturnElement entity = new OutNewAcctPlanContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutContractNo(getLongValue(jsonObject,"out_contract_no"));
            entity.setOutContractPlanNo(getLongValue(jsonObject,"out_contract_plan_no"));
            entity.setOutClientContractPlanId(getStringValue(jsonObject,"out_client_contract_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<NewAcctInvoiceLineItemsReturnElement> buildNewAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<NewAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<NewAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            NewAcctInvoiceLineItemsReturnElement entity = new NewAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setInvoicePlanNo(getLongValue(jsonObject,"invoice_plan_no"));
            entity.setInvoicePlanName(getStringValue(jsonObject,"invoice_plan_name"));
            entity.setInvoiceServiceNo(getLongValue(jsonObject,"invoice_service_no"));
            entity.setInvoiceServiceName(getStringValue(jsonObject,"invoice_service_name"));
            entity.setInvoiceServiceCoaId(getLongValue(jsonObject,"invoice_service_coa_id"));
            entity.setInvoiceUnits(getDoubleValue(jsonObject,"invoice_units"));
            entity.setInvoiceRatePerUnit(getDoubleValue(jsonObject,"invoice_rate_per_unit"));
            entity.setInvoiceLineAmount(getDoubleValue(jsonObject,"invoice_line_amount"));
            entity.setInvoiceLineDescription(getStringValue(jsonObject,"invoice_line_description"));
            entity.setInvoiceStartDateRange(getStringValue(jsonObject,"invoice_start_date_range"));
            entity.setInvoiceEndDateRange(getStringValue(jsonObject,"invoice_end_date_range"));
            entity.setClientInvoicePlanId(getStringValue(jsonObject,"client_invoice_plan_id"));
            entity.setClientInvoiceServiceId(getStringValue(jsonObject,"client_invoice_service_id"));
            entity.setClientInvoiceServiceCoaCode(getStringValue(jsonObject,"client_invoice_service_coa_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A1OutNewAcctPlanContractsReturnElement> buildA1OutNewAcctPlanContractsReturnElement(JSONArray jsonArray) {
        ArrayList<A1OutNewAcctPlanContractsReturnElement> returnElement = new ArrayList<A1OutNewAcctPlanContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A1OutNewAcctPlanContractsReturnElement entity = new A1OutNewAcctPlanContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA1OutContractNo(getLongValue(jsonObject,"a1_out_contract_no"));
            entity.setA1OutContractPlanNo(getLongValue(jsonObject,"a1_out_contract_plan_no"));
            entity.setA1OutClientContractPlanId(getStringValue(jsonObject,"a1_out_client_contract_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A1NewAcctInvoiceLineItemsReturnElement> buildA1NewAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<A1NewAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<A1NewAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A1NewAcctInvoiceLineItemsReturnElement entity = new A1NewAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA1InvoiceLineNo(getLongValue(jsonObject,"a1_invoice_line_no"));
            entity.setA1InvoicePlanNo(getLongValue(jsonObject,"a1_invoice_plan_no"));
            entity.setA1InvoicePlanName(getStringValue(jsonObject,"a1_invoice_plan_name"));
            entity.setA1InvoiceServiceNo(getLongValue(jsonObject,"a1_invoice_service_no"));
            entity.setA1InvoiceServiceName(getStringValue(jsonObject,"a1_invoice_service_name"));
            entity.setA1InvoiceServiceCoaId(getLongValue(jsonObject,"a1_invoice_service_coa_id"));
            entity.setA1InvoiceUnits(getDoubleValue(jsonObject,"a1_invoice_units"));
            entity.setA1InvoiceRatePerUnit(getDoubleValue(jsonObject,"a1_invoice_rate_per_unit"));
            entity.setA1InvoiceLineAmount(getDoubleValue(jsonObject,"a1_invoice_line_amount"));
            entity.setA1InvoiceLineDescription(getStringValue(jsonObject,"a1_invoice_line_description"));
            entity.setA1InvoiceStartDateRange(getStringValue(jsonObject,"a1_invoice_start_date_range"));
            entity.setA1InvoiceEndDateRange(getStringValue(jsonObject,"a1_invoice_end_date_range"));
            entity.setA1ClientInvoicePlanId(getStringValue(jsonObject,"a1_client_invoice_plan_id"));
            entity.setA1ClientInvoiceServiceId(getStringValue(jsonObject,"a1_client_invoice_service_id"));
            entity.setA1ClientInvoiceServiceCoaCode(getStringValue(jsonObject,"a1_client_invoice_service_coa_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A1ThirdPartyErrorsReturnElement> buildA1ThirdPartyErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<A1ThirdPartyErrorsReturnElement> returnElement = new ArrayList<A1ThirdPartyErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A1ThirdPartyErrorsReturnElement entity = new A1ThirdPartyErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setErrorClass(getStringValue(jsonObject,"error_class"));
            entity.setErrorCode(getStringValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A2OutNewAcctPlanContractsReturnElement> buildA2OutNewAcctPlanContractsReturnElement(JSONArray jsonArray) {
        ArrayList<A2OutNewAcctPlanContractsReturnElement> returnElement = new ArrayList<A2OutNewAcctPlanContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A2OutNewAcctPlanContractsReturnElement entity = new A2OutNewAcctPlanContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA2OutContractNo(getLongValue(jsonObject,"a2_out_contract_no"));
            entity.setA2OutContractPlanNo(getLongValue(jsonObject,"a2_out_contract_plan_no"));
            entity.setA2OutClientContractPlanId(getStringValue(jsonObject,"a2_out_client_contract_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A2NewAcctInvoiceLineItemsReturnElement> buildA2NewAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<A2NewAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<A2NewAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A2NewAcctInvoiceLineItemsReturnElement entity = new A2NewAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA2InvoiceLineNo(getLongValue(jsonObject,"a2_invoice_line_no"));
            entity.setA2InvoicePlanNo(getLongValue(jsonObject,"a2_invoice_plan_no"));
            entity.setA2InvoicePlanName(getStringValue(jsonObject,"a2_invoice_plan_name"));
            entity.setA2InvoiceServiceNo(getLongValue(jsonObject,"a2_invoice_service_no"));
            entity.setA2InvoiceServiceName(getStringValue(jsonObject,"a2_invoice_service_name"));
            entity.setA2InvoiceServiceCoaId(getLongValue(jsonObject,"a2_invoice_service_coa_id"));
            entity.setA2InvoiceUnits(getDoubleValue(jsonObject,"a2_invoice_units"));
            entity.setA2InvoiceRatePerUnit(getDoubleValue(jsonObject,"a2_invoice_rate_per_unit"));
            entity.setA2InvoiceLineAmount(getDoubleValue(jsonObject,"a2_invoice_line_amount"));
            entity.setA2InvoiceLineDescription(getStringValue(jsonObject,"a2_invoice_line_description"));
            entity.setA2InvoiceStartDateRange(getStringValue(jsonObject,"a2_invoice_start_date_range"));
            entity.setA2InvoiceEndDateRange(getStringValue(jsonObject,"a2_invoice_end_date_range"));
            entity.setA2ClientInvoicePlanId(getStringValue(jsonObject,"a2_client_invoice_plan_id"));
            entity.setA2ClientInvoiceServiceId(getStringValue(jsonObject,"a2_client_invoice_service_id"));
            entity.setA2ClientInvoiceServiceCoaCode(getStringValue(jsonObject,"a2_client_invoice_service_coa_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A2ThirdPartyErrorsReturnElement> buildA2ThirdPartyErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<A2ThirdPartyErrorsReturnElement> returnElement = new ArrayList<A2ThirdPartyErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A2ThirdPartyErrorsReturnElement entity = new A2ThirdPartyErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setErrorClass(getStringValue(jsonObject,"error_class"));
            entity.setErrorCode(getStringValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A3OutNewAcctPlanContractsReturnElement> buildA3OutNewAcctPlanContractsReturnElement(JSONArray jsonArray) {
        ArrayList<A3OutNewAcctPlanContractsReturnElement> returnElement = new ArrayList<A3OutNewAcctPlanContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A3OutNewAcctPlanContractsReturnElement entity = new A3OutNewAcctPlanContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA3OutContractNo(getLongValue(jsonObject,"a3_out_contract_no"));
            entity.setA3OutContractPlanNo(getLongValue(jsonObject,"a3_out_contract_plan_no"));
            entity.setA3OutClientContractPlanId(getStringValue(jsonObject,"a3_out_client_contract_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A3NewAcctInvoiceLineItemsReturnElement> buildA3NewAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<A3NewAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<A3NewAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A3NewAcctInvoiceLineItemsReturnElement entity = new A3NewAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA3InvoiceLineNo(getLongValue(jsonObject,"a3_invoice_line_no"));
            entity.setA3InvoicePlanNo(getLongValue(jsonObject,"a3_invoice_plan_no"));
            entity.setA3InvoicePlanName(getStringValue(jsonObject,"a3_invoice_plan_name"));
            entity.setA3InvoiceServiceNo(getLongValue(jsonObject,"a3_invoice_service_no"));
            entity.setA3InvoiceServiceName(getStringValue(jsonObject,"a3_invoice_service_name"));
            entity.setA3InvoiceServiceCoaId(getLongValue(jsonObject,"a3_invoice_service_coa_id"));
            entity.setA3InvoiceUnits(getDoubleValue(jsonObject,"a3_invoice_units"));
            entity.setA3InvoiceRatePerUnit(getDoubleValue(jsonObject,"a3_invoice_rate_per_unit"));
            entity.setA3InvoiceLineAmount(getDoubleValue(jsonObject,"a3_invoice_line_amount"));
            entity.setA3InvoiceLineDescription(getStringValue(jsonObject,"a3_invoice_line_description"));
            entity.setA3InvoiceStartDateRange(getStringValue(jsonObject,"a3_invoice_start_date_range"));
            entity.setA3InvoiceEndDateRange(getStringValue(jsonObject,"a3_invoice_end_date_range"));
            entity.setA3ClientInvoicePlanId(getStringValue(jsonObject,"a3_client_invoice_plan_id"));
            entity.setA3ClientInvoiceServiceId(getStringValue(jsonObject,"a3_client_invoice_service_id"));
            entity.setA3ClientInvoiceServiceCoaCode(getStringValue(jsonObject,"a3_client_invoice_service_coa_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A3ThirdPartyErrorsReturnElement> buildA3ThirdPartyErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<A3ThirdPartyErrorsReturnElement> returnElement = new ArrayList<A3ThirdPartyErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A3ThirdPartyErrorsReturnElement entity = new A3ThirdPartyErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setErrorClass(getStringValue(jsonObject,"error_class"));
            entity.setErrorCode(getStringValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A4OutNewAcctPlanContractsReturnElement> buildA4OutNewAcctPlanContractsReturnElement(JSONArray jsonArray) {
        ArrayList<A4OutNewAcctPlanContractsReturnElement> returnElement = new ArrayList<A4OutNewAcctPlanContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A4OutNewAcctPlanContractsReturnElement entity = new A4OutNewAcctPlanContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA4OutContractNo(getLongValue(jsonObject,"a4_out_contract_no"));
            entity.setA4OutContractPlanNo(getLongValue(jsonObject,"a4_out_contract_plan_no"));
            entity.setA4OutClientContractPlanId(getStringValue(jsonObject,"a4_out_client_contract_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A4NewAcctInvoiceLineItemsReturnElement> buildA4NewAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<A4NewAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<A4NewAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A4NewAcctInvoiceLineItemsReturnElement entity = new A4NewAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA4InvoiceLineNo(getLongValue(jsonObject,"a4_invoice_line_no"));
            entity.setA4InvoicePlanNo(getLongValue(jsonObject,"a4_invoice_plan_no"));
            entity.setA4InvoicePlanName(getStringValue(jsonObject,"a4_invoice_plan_name"));
            entity.setA4InvoiceServiceNo(getLongValue(jsonObject,"a4_invoice_service_no"));
            entity.setA4InvoiceServiceName(getStringValue(jsonObject,"a4_invoice_service_name"));
            entity.setA4InvoiceServiceCoaId(getLongValue(jsonObject,"a4_invoice_service_coa_id"));
            entity.setA4InvoiceUnits(getDoubleValue(jsonObject,"a4_invoice_units"));
            entity.setA4InvoiceRatePerUnit(getDoubleValue(jsonObject,"a4_invoice_rate_per_unit"));
            entity.setA4InvoiceLineAmount(getDoubleValue(jsonObject,"a4_invoice_line_amount"));
            entity.setA4InvoiceLineDescription(getStringValue(jsonObject,"a4_invoice_line_description"));
            entity.setA4InvoiceStartDateRange(getStringValue(jsonObject,"a4_invoice_start_date_range"));
            entity.setA4InvoiceEndDateRange(getStringValue(jsonObject,"a4_invoice_end_date_range"));
            entity.setA4ClientInvoicePlanId(getStringValue(jsonObject,"a4_client_invoice_plan_id"));
            entity.setA4ClientInvoiceServiceId(getStringValue(jsonObject,"a4_client_invoice_service_id"));
            entity.setA4ClientInvoiceServiceCoaCode(getStringValue(jsonObject,"a4_client_invoice_service_coa_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A4ThirdPartyErrorsReturnElement> buildA4ThirdPartyErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<A4ThirdPartyErrorsReturnElement> returnElement = new ArrayList<A4ThirdPartyErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A4ThirdPartyErrorsReturnElement entity = new A4ThirdPartyErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setErrorClass(getStringValue(jsonObject,"error_class"));
            entity.setErrorCode(getStringValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A5OutNewAcctPlanContractsReturnElement> buildA5OutNewAcctPlanContractsReturnElement(JSONArray jsonArray) {
        ArrayList<A5OutNewAcctPlanContractsReturnElement> returnElement = new ArrayList<A5OutNewAcctPlanContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A5OutNewAcctPlanContractsReturnElement entity = new A5OutNewAcctPlanContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA5OutContractNo(getLongValue(jsonObject,"a5_out_contract_no"));
            entity.setA5OutContractPlanNo(getLongValue(jsonObject,"a5_out_contract_plan_no"));
            entity.setA5OutClientContractPlanId(getStringValue(jsonObject,"a5_out_client_contract_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A5NewAcctInvoiceLineItemsReturnElement> buildA5NewAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<A5NewAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<A5NewAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A5NewAcctInvoiceLineItemsReturnElement entity = new A5NewAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setA5InvoiceLineNo(getLongValue(jsonObject,"a5_invoice_line_no"));
            entity.setA5InvoicePlanNo(getLongValue(jsonObject,"a5_invoice_plan_no"));
            entity.setA5InvoicePlanName(getStringValue(jsonObject,"a5_invoice_plan_name"));
            entity.setA5InvoiceServiceNo(getLongValue(jsonObject,"a5_invoice_service_no"));
            entity.setA5InvoiceServiceName(getStringValue(jsonObject,"a5_invoice_service_name"));
            entity.setA5InvoiceServiceCoaId(getLongValue(jsonObject,"a5_invoice_service_coa_id"));
            entity.setA5InvoiceUnits(getDoubleValue(jsonObject,"a5_invoice_units"));
            entity.setA5InvoiceRatePerUnit(getDoubleValue(jsonObject,"a5_invoice_rate_per_unit"));
            entity.setA5InvoiceLineAmount(getDoubleValue(jsonObject,"a5_invoice_line_amount"));
            entity.setA5InvoiceLineDescription(getStringValue(jsonObject,"a5_invoice_line_description"));
            entity.setA5InvoiceStartDateRange(getStringValue(jsonObject,"a5_invoice_start_date_range"));
            entity.setA5InvoiceEndDateRange(getStringValue(jsonObject,"a5_invoice_end_date_range"));
            entity.setA5ClientInvoicePlanId(getStringValue(jsonObject,"a5_client_invoice_plan_id"));
            entity.setA5ClientInvoiceServiceId(getStringValue(jsonObject,"a5_client_invoice_service_id"));
            entity.setA5ClientInvoiceServiceCoaCode(getStringValue(jsonObject,"a5_client_invoice_service_coa_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<A5ThirdPartyErrorsReturnElement> buildA5ThirdPartyErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<A5ThirdPartyErrorsReturnElement> returnElement = new ArrayList<A5ThirdPartyErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            A5ThirdPartyErrorsReturnElement entity = new A5ThirdPartyErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setErrorClass(getStringValue(jsonObject,"error_class"));
            entity.setErrorCode(getStringValue(jsonObject,"error_code"));
            entity.setErrorMsg(getStringValue(jsonObject,"error_msg"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctCommentsReturnElement> buildAcctCommentsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctCommentsReturnElement> returnElement = new ArrayList<AcctCommentsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctCommentsReturnElement entity = new AcctCommentsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCommentAuthor(getStringValue(jsonObject,"comment_author"));
            entity.setCommentDateTime(getStringValue(jsonObject,"comment_date_time"));
            entity.setComment(getStringValue(jsonObject,"comment"));
            entity.setApplicationId(getStringValue(jsonObject,"application_id"));
            entity.setApplicationDate(getStringValue(jsonObject,"application_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<EligibleServicePlanDetailsReturnElement> buildEligibleServicePlanDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<EligibleServicePlanDetailsReturnElement> returnElement = new ArrayList<EligibleServicePlanDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            EligibleServicePlanDetailsReturnElement entity = new EligibleServicePlanDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctCreditsReturnElement> buildAcctCreditsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctCreditsReturnElement> returnElement = new ArrayList<AcctCreditsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctCreditsReturnElement entity = new AcctCreditsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCreditNo(getLongValue(jsonObject,"credit_no"));
            entity.setCreatedBy(getStringValue(jsonObject,"created_by"));
            entity.setCreatedDate(getStringValue(jsonObject,"created_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCreditType(getStringValue(jsonObject,"credit_type"));
            entity.setAppliedAmount(getDoubleValue(jsonObject,"applied_amount"));
            entity.setUnappliedAmount(getDoubleValue(jsonObject,"unapplied_amount"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setReasonText(getStringValue(jsonObject,"reason_text"));
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setVoidTransactionId(getLongValue(jsonObject,"void_transaction_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctGroupsReturnElement> buildAcctGroupsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctGroupsReturnElement> returnElement = new ArrayList<AcctGroupsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctGroupsReturnElement entity = new AcctGroupsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setGroupNo(getLongValue(jsonObject,"group_no"));
            entity.setGroupName(getStringValue(jsonObject,"group_name"));
            entity.setGroupDesc(getStringValue(jsonObject,"group_desc"));
            entity.setGroupType(getStringValue(jsonObject,"group_type"));
            entity.setGroupMask(getStringValue(jsonObject,"group_mask"));
            entity.setGroupSeqNo(getLongValue(jsonObject,"group_seq_no"));
            entity.setClientAcctGroupId(getStringValue(jsonObject,"client_acct_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctHierarchyDetailsReturnElement> buildAcctHierarchyDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctHierarchyDetailsReturnElement> returnElement = new ArrayList<AcctHierarchyDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctHierarchyDetailsReturnElement entity = new AcctHierarchyDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setFirstName(getStringValue(jsonObject,"first_name"));
            entity.setMi(getStringValue(jsonObject,"mi"));
            entity.setLastName(getStringValue(jsonObject,"last_name"));
            entity.setUserid(getStringValue(jsonObject,"userid"));
            entity.setBirthdate(getStringValue(jsonObject,"birthdate"));
            entity.setJobTitle(getStringValue(jsonObject,"job_title"));
            entity.setSalutation(getStringValue(jsonObject,"salutation"));
            entity.setSeniorAcctNo(getLongValue(jsonObject,"senior_acct_no"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setRespLevelCd(getLongValue(jsonObject,"resp_level_cd"));
            entity.setIsTestAcct(getLongValue(jsonObject,"is_test_acct"));
            entity.setAltEmail(getStringValue(jsonObject,"alt_email"));
            entity.setAddress1(getStringValue(jsonObject,"address1"));
            entity.setAddress2(getStringValue(jsonObject,"address2"));
            entity.setAddress3(getStringValue(jsonObject,"address3"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setStateProv(getStringValue(jsonObject,"state_prov"));
            entity.setLocality(getStringValue(jsonObject,"locality"));
            entity.setPostalCode(getStringValue(jsonObject,"postal_code"));
            entity.setCountry(getStringValue(jsonObject,"country"));
            entity.setCompanyName(getStringValue(jsonObject,"company_name"));
            entity.setFaxPhone(getStringValue(jsonObject,"fax_phone"));
            entity.setPhone(getStringValue(jsonObject,"phone"));
            entity.setPhoneExt(getStringValue(jsonObject,"phone_ext"));
            entity.setCellPhone(getStringValue(jsonObject,"cell_phone"));
            entity.setWorkPhone(getStringValue(jsonObject,"work_phone"));
            entity.setWorkPhoneExt(getStringValue(jsonObject,"work_phone_ext"));
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
            entity.setCreatedDate(getStringValue(jsonObject,"created_date"));
            entity.setDateToExpire(getStringValue(jsonObject,"date_to_expire"));
            entity.setDateToSuspend(getStringValue(jsonObject,"date_to_suspend"));
            entity.setLastArrearsBillThruDate(getStringValue(jsonObject,"last_arrears_bill_thru_date"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setLastBillThruDate(getStringValue(jsonObject,"last_bill_thru_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setStatusDate(getStringValue(jsonObject,"status_date"));
            entity.setStatusDegradeDate(getStringValue(jsonObject,"status_degrade_date"));
            entity.setStatusCd(getLongValue(jsonObject,"status_cd"));
            entity.setStatusLabel(getStringValue(jsonObject,"status_label"));
            entity.setMasterPlanNo(getLongValue(jsonObject,"master_plan_no"));
            entity.setMasterPlanName(getStringValue(jsonObject,"master_plan_name"));
            entity.setMasterPlanUnits(getLongValue(jsonObject,"master_plan_units"));
            entity.setNotifyMethod(getLongValue(jsonObject,"notify_method"));
            entity.setNotifyMethodName(getStringValue(jsonObject,"notify_method_name"));
            entity.setPassword(getStringValue(jsonObject,"password"));
            entity.setPin(getStringValue(jsonObject,"pin"));
            entity.setSecretQuestion(getStringValue(jsonObject,"secret_question"));
            entity.setSecretQuestionAnswer(getStringValue(jsonObject,"secret_question_answer"));
            entity.setPayMethod(getLongValue(jsonObject,"pay_method"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setTaxId(getStringValue(jsonObject,"tax_id"));
            entity.setListStartMasterFile(getLongValue(jsonObject,"list_start_master_file"));
            entity.setBillingEmail(getStringValue(jsonObject,"billing_email"));
            entity.setBillingFirstName(getStringValue(jsonObject,"billing_first_name"));
            entity.setBillingMiddleInitial(getStringValue(jsonObject,"billing_middle_initial"));
            entity.setBillingLastName(getStringValue(jsonObject,"billing_last_name"));
            entity.setBillingAddress1(getStringValue(jsonObject,"billing_address1"));
            entity.setBillingAddress2(getStringValue(jsonObject,"billing_address2"));
            entity.setBillingAddress3(getStringValue(jsonObject,"billing_address3"));
            entity.setBillingCity(getStringValue(jsonObject,"billing_city"));
            entity.setBillingState(getStringValue(jsonObject,"billing_state"));
            entity.setBillingLocality(getStringValue(jsonObject,"billing_locality"));
            entity.setBillingZip(getStringValue(jsonObject,"billing_zip"));
            entity.setBillingCountry(getStringValue(jsonObject,"billing_country"));
            entity.setCcSuffix(getStringValue(jsonObject,"cc_suffix"));
            entity.setCcExpireMm(getStringValue(jsonObject,"cc_expire_mm"));
            entity.setCcExpireYyyy(getStringValue(jsonObject,"cc_expire_yyyy"));
            entity.setCcId(getLongValue(jsonObject,"cc_id"));
            entity.setBankAcctSuffix(getStringValue(jsonObject,"bank_acct_suffix"));
            entity.setBankRoutingNo(getStringValue(jsonObject,"bank_routing_no"));
            entity.setBillingCompanyName(getStringValue(jsonObject,"billing_company_name"));
            entity.setBillingPhone(getStringValue(jsonObject,"billing_phone"));
            entity.setBillingPhoneExt(getStringValue(jsonObject,"billing_phone_ext"));
            entity.setBillingCellPhone(getStringValue(jsonObject,"billing_cell_phone"));
            entity.setBillingWorkPhoneExt(getStringValue(jsonObject,"billing_work_phone_ext"));
            entity.setBalance(getDoubleValue(jsonObject,"balance"));
            entity.setAcctCreateClientReceiptId(getStringValue(jsonObject,"acct_create_client_receipt_id"));
            entity.setPlanClientReceiptId(getStringValue(jsonObject,"plan_client_receipt_id"));
            entity.setStatusClientReceiptId(getStringValue(jsonObject,"status_client_receipt_id"));
            entity.setTaxpayerId(getStringValue(jsonObject,"taxpayer_id"));
            entity.setAltMsgTemplateNo(getLongValue(jsonObject,"alt_msg_template_no"));
            entity.setSeqFuncGroupNo(getLongValue(jsonObject,"seq_func_group_no"));
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setAddressVerificationCode(getStringValue(jsonObject,"address_verification_code"));
            entity.setAddressMatchScore(getDoubleValue(jsonObject,"address_match_score"));
            entity.setBillingAddressVerificationCode(getStringValue(jsonObject,"billing_address_verification_code"));
            entity.setBillingAddressMatchScore(getDoubleValue(jsonObject,"billing_address_match_score"));
            entity.setClientMasterPlanId(getStringValue(jsonObject,"client_master_plan_id"));
            entity.setClientAltMsgTemplateId(getStringValue(jsonObject,"client_alt_msg_template_id"));
                        ArrayList<ChildAcctNoReturnElement> arrayListChildAcctNoReturnElement = buildChildAcctNoReturnElement((JSONArray)jsonObject.get("child_acct_no"));
            for (ChildAcctNoReturnElement element : arrayListChildAcctNoReturnElement){
                entity.getChildAcctNo().add(element);
            }
                        ArrayList<ThisAcctSuppPlansReturnElement> arrayListThisAcctSuppPlansReturnElement = buildThisAcctSuppPlansReturnElement((JSONArray)jsonObject.get("this_acct_supp_plans"));
            for (ThisAcctSuppPlansReturnElement element : arrayListThisAcctSuppPlansReturnElement){
                entity.getThisAcctSuppPlans().add(element);
            }
                        ArrayList<ThisAcctSuppFieldsReturnElement> arrayListThisAcctSuppFieldsReturnElement = buildThisAcctSuppFieldsReturnElement((JSONArray)jsonObject.get("this_acct_supp_fields"));
            for (ThisAcctSuppFieldsReturnElement element : arrayListThisAcctSuppFieldsReturnElement){
                entity.getThisAcctSuppFields().add(element);
            }
            entity.setStmntEmailList(getStringValue(jsonObject,"stmnt_email_list"));
            entity.setStmntEmailListCc(getStringValue(jsonObject,"stmnt_email_list_cc"));
            entity.setStmntEmailListBcc(getStringValue(jsonObject,"stmnt_email_list_bcc"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ChildAcctNoReturnElement> buildChildAcctNoReturnElement(JSONArray jsonArray) {
        ArrayList<ChildAcctNoReturnElement> returnElement = new ArrayList<ChildAcctNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ChildAcctNoReturnElement entity = new ChildAcctNoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ThisAcctSuppPlansReturnElement> buildThisAcctSuppPlansReturnElement(JSONArray jsonArray) {
        ArrayList<ThisAcctSuppPlansReturnElement> returnElement = new ArrayList<ThisAcctSuppPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ThisAcctSuppPlansReturnElement entity = new ThisAcctSuppPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppPlanNo(getLongValue(jsonObject,"supp_plan_no"));
            entity.setSuppPlanName(getStringValue(jsonObject,"supp_plan_name"));
            entity.setSuppPlanUnits(getLongValue(jsonObject,"supp_plan_units"));
            entity.setClientSuppPlanId(getStringValue(jsonObject,"client_supp_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ThisAcctSuppFieldsReturnElement> buildThisAcctSuppFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<ThisAcctSuppFieldsReturnElement> returnElement = new ArrayList<ThisAcctSuppFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ThisAcctSuppFieldsReturnElement entity = new ThisAcctSuppFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceHistoryReturnElement> buildInvoiceHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceHistoryReturnElement> returnElement = new ArrayList<InvoiceHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceHistoryReturnElement entity = new InvoiceHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setMasterPlanNo(getLongValue(jsonObject,"master_plan_no"));
            entity.setMasterPlanName(getStringValue(jsonObject,"master_plan_name"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setBillDate(getStringValue(jsonObject,"bill_date"));
            entity.setPaidDate(getStringValue(jsonObject,"paid_date"));
            entity.setDebit(getDoubleValue(jsonObject,"debit"));
            entity.setCredit(getDoubleValue(jsonObject,"credit"));
            entity.setRecurringBillFrom(getStringValue(jsonObject,"recurring_bill_from"));
            entity.setRecurringBillThru(getStringValue(jsonObject,"recurring_bill_thru"));
            entity.setUsageBillFrom(getStringValue(jsonObject,"usage_bill_from"));
            entity.setUsageBillThru(getStringValue(jsonObject,"usage_bill_thru"));
            entity.setIsVoidedInd(getLongValue(jsonObject,"is_voided_ind"));
            entity.setClientMasterPlanId(getStringValue(jsonObject,"client_master_plan_id"));
            entity.setInvoiceTypeCd(getStringValue(jsonObject,"invoice_type_cd"));
            entity.setPostingStatusCd(getLongValue(jsonObject,"posting_status_cd"));
            entity.setPostingUser(getStringValue(jsonObject,"posting_user"));
            entity.setPostingDate(getStringValue(jsonObject,"posting_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNoReturnElement> buildPlanNoReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNoReturnElement> returnElement = new ArrayList<PlanNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNoReturnElement entity = new PlanNoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanStatusCd(getLongValue(jsonObject,"plan_status_cd"));
            entity.setPlanStatusLabel(getStringValue(jsonObject,"plan_status_label"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNameReturnElement> buildPlanNameReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNameReturnElement> returnElement = new ArrayList<PlanNameReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNameReturnElement entity = new PlanNameReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientPlanIdReturnElement> buildClientPlanIdReturnElement(JSONArray jsonArray) {
        ArrayList<ClientPlanIdReturnElement> returnElement = new ArrayList<ClientPlanIdReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientPlanIdReturnElement entity = new ClientPlanIdReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctNotificationDetailsReturnElement> buildAcctNotificationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctNotificationDetailsReturnElement> returnElement = new ArrayList<AcctNotificationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctNotificationDetailsReturnElement entity = new AcctNotificationDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setNotifyTmpltGrpId(getStringValue(jsonObject,"notify_tmplt_grp_id"));
            entity.setNotifyTmpltGrpLabel(getStringValue(jsonObject,"notify_tmplt_grp_label"));
            entity.setNotifyTmpltGrpAssignLvl(getStringValue(jsonObject,"notify_tmplt_grp_assign_lvl"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OpenChargeItemsReturnElement> buildOpenChargeItemsReturnElement(JSONArray jsonArray) {
        ArrayList<OpenChargeItemsReturnElement> returnElement = new ArrayList<OpenChargeItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OpenChargeItemsReturnElement entity = new OpenChargeItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setProrationNo(getLongValue(jsonObject,"proration_no"));
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setPostingDate(getStringValue(jsonObject,"posting_date"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctPayMethodsReturnElement> buildAcctPayMethodsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctPayMethodsReturnElement> returnElement = new ArrayList<AcctPayMethodsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctPayMethodsReturnElement entity = new AcctPayMethodsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFirstName(getStringValue(jsonObject,"first_name"));
            entity.setMiddleInitial(getStringValue(jsonObject,"middle_initial"));
            entity.setLastName(getStringValue(jsonObject,"last_name"));
            entity.setAddress1(getStringValue(jsonObject,"address1"));
            entity.setAddress2(getStringValue(jsonObject,"address2"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setState(getStringValue(jsonObject,"state"));
            entity.setZipcode(getStringValue(jsonObject,"zipcode"));
            entity.setCountry(getStringValue(jsonObject,"country"));
            entity.setLocality(getStringValue(jsonObject,"locality"));
            entity.setPhone(getStringValue(jsonObject,"phone"));
            entity.setCellPhone(getStringValue(jsonObject,"cell_phone"));
            entity.setWorkPhone(getStringValue(jsonObject,"work_phone"));
            entity.setEmail(getStringValue(jsonObject,"email"));
            entity.setCompanyName(getStringValue(jsonObject,"company_name"));
            entity.setSeqNo(getLongValue(jsonObject,"seq_no"));
            entity.setPayMethodId(getLongValue(jsonObject,"pay_method_id"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setPersistentInd(getLongValue(jsonObject,"persistent_ind"));
            entity.setFromDate(getStringValue(jsonObject,"from_date"));
            entity.setToDate(getStringValue(jsonObject,"to_date"));
            entity.setCcExpMm(getLongValue(jsonObject,"cc_exp_mm"));
            entity.setCcExpYy(getLongValue(jsonObject,"cc_exp_yy"));
            entity.setCcId(getLongValue(jsonObject,"cc_id"));
            entity.setCcType(getStringValue(jsonObject,"cc_type"));
            entity.setBankRouting(getLongValue(jsonObject,"bank_routing"));
            entity.setBankName(getStringValue(jsonObject,"bank_name"));
            entity.setBankAcctType(getStringValue(jsonObject,"bank_acct_type"));
            entity.setSuffix(getStringValue(jsonObject,"suffix"));
            entity.setCurrentPayMethod(getLongValue(jsonObject,"current_pay_method"));
            entity.setBillInfoApiReceiptId(getStringValue(jsonObject,"bill_info_api_receipt_id"));
            entity.setAddress3(getStringValue(jsonObject,"address3"));
            entity.setFromDateTime(getStringValue(jsonObject,"from_date_time"));
            entity.setToDateTime(getStringValue(jsonObject,"to_date_time"));
            entity.setBkupPayMethodInd(getLongValue(jsonObject,"bkup_pay_method_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctPlanContractReturnElement> buildAcctPlanContractReturnElement(JSONArray jsonArray) {
        ArrayList<AcctPlanContractReturnElement> returnElement = new ArrayList<AcctPlanContractReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctPlanContractReturnElement entity = new AcctPlanContractReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractNo(getLongValue(jsonObject,"contract_no"));
            entity.setTypeNo(getLongValue(jsonObject,"type_no"));
            entity.setLengthMonths(getLongValue(jsonObject,"length_months"));
            entity.setCancelFee(getDoubleValue(jsonObject,"cancel_fee"));
            entity.setCreateComments(getStringValue(jsonObject,"create_comments"));
            entity.setUpdateComments(getStringValue(jsonObject,"update_comments"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setStatusCode(getLongValue(jsonObject,"status_code"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanHistReturnElement> buildPlanHistReturnElement(JSONArray jsonArray) {
        ArrayList<PlanHistReturnElement> returnElement = new ArrayList<PlanHistReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanHistReturnElement entity = new PlanHistReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setNewPlan(getStringValue(jsonObject,"new_plan"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setPlanUnits(getDoubleValue(jsonObject,"plan_units"));
            entity.setClientNewPlanId(getStringValue(jsonObject,"client_new_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllPlanUnitInstancesReturnElement> buildAllPlanUnitInstancesReturnElement(JSONArray jsonArray) {
        ArrayList<AllPlanUnitInstancesReturnElement> returnElement = new ArrayList<AllPlanUnitInstancesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllPlanUnitInstancesReturnElement entity = new AllPlanUnitInstancesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setQueuedInd(getStringValue(jsonObject,"queued_ind"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanType(getStringValue(jsonObject,"plan_type"));
                        ArrayList<PlanUnitInstanceReturnElement> arrayListPlanUnitInstanceReturnElement = buildPlanUnitInstanceReturnElement((JSONArray)jsonObject.get("plan_unit_instance"));
            for (PlanUnitInstanceReturnElement element : arrayListPlanUnitInstanceReturnElement){
                entity.getPlanUnitInstance().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanUnitInstanceReturnElement> buildPlanUnitInstanceReturnElement(JSONArray jsonArray) {
        ArrayList<PlanUnitInstanceReturnElement> returnElement = new ArrayList<PlanUnitInstanceReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanUnitInstanceReturnElement entity = new PlanUnitInstanceReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanUnitInstNo(getLongValue(jsonObject,"plan_unit_inst_no"));
            entity.setClientPlanUnitInstId(getStringValue(jsonObject,"client_plan_unit_inst_id"));
            entity.setPlanUnitInstStatus(getStringValue(jsonObject,"plan_unit_inst_status"));
                        ArrayList<PlanUnitInstServicesInfoReturnElement> arrayListPlanUnitInstServicesInfoReturnElement = buildPlanUnitInstServicesInfoReturnElement((JSONArray)jsonObject.get("plan_unit_inst_services_info"));
            for (PlanUnitInstServicesInfoReturnElement element : arrayListPlanUnitInstServicesInfoReturnElement){
                entity.getPlanUnitInstServicesInfo().add(element);
            }
                        ArrayList<PlanUnitInstFieldsReturnElement> arrayListPlanUnitInstFieldsReturnElement = buildPlanUnitInstFieldsReturnElement((JSONArray)jsonObject.get("plan_unit_inst_fields"));
            for (PlanUnitInstFieldsReturnElement element : arrayListPlanUnitInstFieldsReturnElement){
                entity.getPlanUnitInstFields().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanUnitInstServicesInfoReturnElement> buildPlanUnitInstServicesInfoReturnElement(JSONArray jsonArray) {
        ArrayList<PlanUnitInstServicesInfoReturnElement> returnElement = new ArrayList<PlanUnitInstServicesInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanUnitInstServicesInfoReturnElement entity = new PlanUnitInstServicesInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setFulfillmentStatus(getStringValue(jsonObject,"fulfillment_status"));
            entity.setFulfillmentDate(getStringValue(jsonObject,"fulfillment_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanUnitInstFieldsReturnElement> buildPlanUnitInstFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanUnitInstFieldsReturnElement> returnElement = new ArrayList<PlanUnitInstFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanUnitInstFieldsReturnElement entity = new PlanUnitInstFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            entity.setPlanUnitInstDirective(getLongValue(jsonObject,"plan_unit_inst_directive"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctPlansReturnElement> buildAcctPlansReturnElement(JSONArray jsonArray) {
        ArrayList<AcctPlansReturnElement> returnElement = new ArrayList<AcctPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctPlansReturnElement entity = new AcctPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setPlanUnits(getLongValue(jsonObject,"plan_units"));
            entity.setQueuedPlanUnits(getLongValue(jsonObject,"queued_plan_units"));
            entity.setUnitsChangeDate(getStringValue(jsonObject,"units_change_date"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setBillThruDate(getStringValue(jsonObject,"bill_thru_date"));
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleName(getStringValue(jsonObject,"rate_schedule_name"));
            entity.setRateSchedIsDefaultInd(getLongValue(jsonObject,"rate_sched_is_default_ind"));
            entity.setAvailableFromDate(getStringValue(jsonObject,"available_from_date"));
            entity.setAvailableToDate(getStringValue(jsonObject,"available_to_date"));
            entity.setFollowupRsNo(getLongValue(jsonObject,"followup_rs_no"));
            entity.setClientFollowupRsId(getStringValue(jsonObject,"client_followup_rs_id"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setSuppPlanStatusCd(getLongValue(jsonObject,"supp_plan_status_cd"));
            entity.setSuppPlanStatusLabel(getStringValue(jsonObject,"supp_plan_status_label"));
            entity.setSuppPlanStatusDate(getStringValue(jsonObject,"supp_plan_status_date"));
            entity.setSuppPlanActivateDate(getStringValue(jsonObject,"supp_plan_activate_date"));
            entity.setSuppPlanTerminateDate(getStringValue(jsonObject,"supp_plan_terminate_date"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllAcctPlansReturnElement> buildAllAcctPlansReturnElement(JSONArray jsonArray) {
        ArrayList<AllAcctPlansReturnElement> returnElement = new ArrayList<AllAcctPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllAcctPlansReturnElement entity = new AllAcctPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setPlanUnits(getLongValue(jsonObject,"plan_units"));
            entity.setQueuedPlanUnits(getLongValue(jsonObject,"queued_plan_units"));
            entity.setUnitsChangeDate(getStringValue(jsonObject,"units_change_date"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setBillThruDate(getStringValue(jsonObject,"bill_thru_date"));
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleName(getStringValue(jsonObject,"rate_schedule_name"));
            entity.setRateSchedIsDefaultInd(getLongValue(jsonObject,"rate_sched_is_default_ind"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setSuppPlanStatusCd(getLongValue(jsonObject,"supp_plan_status_cd"));
            entity.setSuppPlanStatusLabel(getStringValue(jsonObject,"supp_plan_status_label"));
            entity.setSuppPlanStatusDate(getStringValue(jsonObject,"supp_plan_status_date"));
            entity.setSuppPlanActivateDate(getStringValue(jsonObject,"supp_plan_activate_date"));
            entity.setSuppPlanTerminateDate(getStringValue(jsonObject,"supp_plan_terminate_date"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
                        ArrayList<SurchargesAllReturnElement> arrayListSurchargesAllReturnElement = buildSurchargesAllReturnElement((JSONArray)jsonObject.get("surcharges_all"));
            for (SurchargesAllReturnElement element : arrayListSurchargesAllReturnElement){
                entity.getSurchargesAll().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanServicesReturnElement> buildPlanServicesReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServicesReturnElement> returnElement = new ArrayList<PlanServicesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServicesReturnElement entity = new PlanServicesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setIsRecurringInd(getLongValue(jsonObject,"is_recurring_ind"));
            entity.setIsUsageBasedInd(getLongValue(jsonObject,"is_usage_based_ind"));
            entity.setUsageType(getLongValue(jsonObject,"usage_type"));
            entity.setTaxableInd(getLongValue(jsonObject,"taxable_ind"));
            entity.setIsTaxInd(getLongValue(jsonObject,"is_tax_ind"));
            entity.setIsArrearsInd(getLongValue(jsonObject,"is_arrears_ind"));
            entity.setIsSetupInd(getLongValue(jsonObject,"is_setup_ind"));
            entity.setIsMiscInd(getLongValue(jsonObject,"is_misc_ind"));
            entity.setIsDonationInd(getLongValue(jsonObject,"is_donation_ind"));
            entity.setIsOrderBasedInd(getLongValue(jsonObject,"is_order_based_ind"));
            entity.setIsCancellationInd(getLongValue(jsonObject,"is_cancellation_ind"));
            entity.setCoaId(getStringValue(jsonObject,"coa_id"));
            entity.setLedgerCode(getStringValue(jsonObject,"ledger_code"));
            entity.setClientCoaCode(getStringValue(jsonObject,"client_coa_code"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setTieredPricingRule(getLongValue(jsonObject,"tiered_pricing_rule"));
            entity.setIsMinFeeInd(getLongValue(jsonObject,"is_min_fee_ind"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
                        ArrayList<AllServiceSuppFieldsReturnElement> arrayListAllServiceSuppFieldsReturnElement = buildAllServiceSuppFieldsReturnElement((JSONArray)jsonObject.get("all_service_supp_fields"));
            for (AllServiceSuppFieldsReturnElement element : arrayListAllServiceSuppFieldsReturnElement){
                entity.getAllServiceSuppFields().add(element);
            }
            entity.setFulfillmentBasedInd(getLongValue(jsonObject,"fulfillment_based_ind"));
                        ArrayList<PlanServiceRatesReturnElement> arrayListPlanServiceRatesReturnElement = buildPlanServiceRatesReturnElement((JSONArray)jsonObject.get("plan_service_rates"));
            for (PlanServiceRatesReturnElement element : arrayListPlanServiceRatesReturnElement){
                entity.getPlanServiceRates().add(element);
            }
                        ArrayList<AllPlanServiceRatesReturnElement> arrayListAllPlanServiceRatesReturnElement = buildAllPlanServiceRatesReturnElement((JSONArray)jsonObject.get("all_plan_service_rates"));
            for (AllPlanServiceRatesReturnElement element : arrayListAllPlanServiceRatesReturnElement){
                entity.getAllPlanServiceRates().add(element);
            }
            entity.setUsageTypeName(getStringValue(jsonObject,"usage_type_name"));
            entity.setUsageTypeDesc(getStringValue(jsonObject,"usage_type_desc"));
            entity.setUsageTypeCode(getStringValue(jsonObject,"usage_type_code"));
            entity.setUsageUnitLabel(getStringValue(jsonObject,"usage_unit_label"));
            entity.setApplyUsageRatesDaily(getLongValue(jsonObject,"apply_usage_rates_daily"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllServiceSuppFieldsReturnElement> buildAllServiceSuppFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<AllServiceSuppFieldsReturnElement> returnElement = new ArrayList<AllServiceSuppFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllServiceSuppFieldsReturnElement entity = new AllServiceSuppFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldDesc(getStringValue(jsonObject,"field_desc"));
            entity.setFieldOrderNo(getLongValue(jsonObject,"field_order_no"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanServiceRatesReturnElement> buildPlanServiceRatesReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServiceRatesReturnElement> returnElement = new ArrayList<PlanServiceRatesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServiceRatesReturnElement entity = new PlanServiceRatesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRateSeqNo(getLongValue(jsonObject,"rate_seq_no"));
            entity.setFromUnit(getDoubleValue(jsonObject,"from_unit"));
            entity.setToUnit(getDoubleValue(jsonObject,"to_unit"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setFutureRatePerUnit(getDoubleValue(jsonObject,"future_rate_per_unit"));
            entity.setMonthlyFee(getDoubleValue(jsonObject,"monthly_fee"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setRateTierDescription(getStringValue(jsonObject,"rate_tier_description"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllPlanServiceRatesReturnElement> buildAllPlanServiceRatesReturnElement(JSONArray jsonArray) {
        ArrayList<AllPlanServiceRatesReturnElement> returnElement = new ArrayList<AllPlanServiceRatesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllPlanServiceRatesReturnElement entity = new AllPlanServiceRatesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setFutureRate(getLongValue(jsonObject,"future_rate"));
            entity.setFutureChangeDate(getStringValue(jsonObject,"future_change_date"));
            entity.setFollowupRsNo(getLongValue(jsonObject,"followup_rs_no"));
            entity.setClientFollowupRsId(getStringValue(jsonObject,"client_followup_rs_id"));
                        ArrayList<PlanServiceRatesReturnElement> arrayListPlanServiceRatesReturnElement = buildPlanServiceRatesReturnElement((JSONArray)jsonObject.get("plan_service_rates"));
            for (PlanServiceRatesReturnElement element : arrayListPlanServiceRatesReturnElement){
                entity.getPlanServiceRates().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SurchargesAllReturnElement> buildSurchargesAllReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargesAllReturnElement> returnElement = new ArrayList<SurchargesAllReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargesAllReturnElement entity = new SurchargesAllReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSurchargeNo(getLongValue(jsonObject,"surcharge_no"));
            entity.setSurchargeName(getStringValue(jsonObject,"surcharge_name"));
            entity.setClientSurchargeId(getStringValue(jsonObject,"client_surcharge_id"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setSurchargeType(getStringValue(jsonObject,"surcharge_type"));
            entity.setCurrency(getStringValue(jsonObject,"currency"));
            entity.setTaxGroup(getStringValue(jsonObject,"tax_group"));
            entity.setInvoiceAppMethod(getStringValue(jsonObject,"invoice_app_method"));
            entity.setRevGlCode(getStringValue(jsonObject,"rev_gl_code"));
            entity.setArGlCode(getStringValue(jsonObject,"ar_gl_code"));
                        ArrayList<SurchargeRateReturnElement> arrayListSurchargeRateReturnElement = buildSurchargeRateReturnElement((JSONArray)jsonObject.get("surcharge_rate"));
            for (SurchargeRateReturnElement element : arrayListSurchargeRateReturnElement){
                entity.getSurchargeRate().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SurchargeRateReturnElement> buildSurchargeRateReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargeRateReturnElement> returnElement = new ArrayList<SurchargeRateReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargeRateReturnElement entity = new SurchargeRateReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRateSeqNo(getLongValue(jsonObject,"rate_seq_no"));
            entity.setFromUnit(getDoubleValue(jsonObject,"from_unit"));
            entity.setToUnit(getDoubleValue(jsonObject,"to_unit"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setIncludeZero(getLongValue(jsonObject,"include_zero"));
            entity.setRateSchedIsAssignedInd(getLongValue(jsonObject,"rate_sched_is_assigned_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ServiceOutageLineItemsReturnElement> buildServiceOutageLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<ServiceOutageLineItemsReturnElement> returnElement = new ArrayList<ServiceOutageLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ServiceOutageLineItemsReturnElement entity = new ServiceOutageLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setOutageDuration(getDoubleValue(jsonObject,"outage_duration"));
            entity.setCreditAmount(getDoubleValue(jsonObject,"credit_amount"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutMasterPlanInstanceNo(getLongValue(jsonObject,"out_master_plan_instance_no"));
            entity.setOutClientMpInstanceId(getStringValue(jsonObject,"out_client_mp_instance_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<StatementHistoryReturnElement> buildStatementHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<StatementHistoryReturnElement> returnElement = new ArrayList<StatementHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            StatementHistoryReturnElement entity = new StatementHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setStatementNo(getLongValue(jsonObject,"statement_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setDueDate(getStringValue(jsonObject,"due_date"));
            entity.setDueDatePlusGracePeriod(getStringValue(jsonObject,"due_date_plus_grace_period"));
            entity.setNewChargesAmount(getDoubleValue(jsonObject,"new_charges_amount"));
            entity.setNewPaymentsAmount(getDoubleValue(jsonObject,"new_payments_amount"));
            entity.setBalanceForwardAmount(getDoubleValue(jsonObject,"balance_forward_amount"));
            entity.setTotalAmount(getDoubleValue(jsonObject,"total_amount"));
            entity.setIsPaidInd(getLongValue(jsonObject,"is_paid_ind"));
            entity.setInvoiceActivityInd(getLongValue(jsonObject,"invoice_activity_ind"));
            entity.setSeqStatementId(getStringValue(jsonObject,"seq_statement_id"));
            entity.setSentStatus(getStringValue(jsonObject,"sent_status"));
            entity.setDateSent(getStringValue(jsonObject,"date_sent"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<StatHistReturnElement> buildStatHistReturnElement(JSONArray jsonArray) {
        ArrayList<StatHistReturnElement> returnElement = new ArrayList<StatHistReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            StatHistReturnElement entity = new StatHistReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setDateEntered(getStringValue(jsonObject,"date_entered"));
            entity.setAcctStatus(getStringValue(jsonObject,"acct_status"));
            entity.setNewStatus(getStringValue(jsonObject,"new_status"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppFieldsReturnElement> buildSuppFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<SuppFieldsReturnElement> returnElement = new ArrayList<SuppFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppFieldsReturnElement entity = new SuppFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlanHistReturnElement> buildSuppPlanHistReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlanHistReturnElement> returnElement = new ArrayList<SuppPlanHistReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlanHistReturnElement entity = new SuppPlanHistReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppPlanNo(getLongValue(jsonObject,"supp_plan_no"));
            entity.setOldStatusCd(getLongValue(jsonObject,"old_status_cd"));
            entity.setNewStatusCd(getLongValue(jsonObject,"new_status_cd"));
            entity.setOldPlanUnits(getDoubleValue(jsonObject,"old_plan_units"));
            entity.setNewPlanUnits(getDoubleValue(jsonObject,"new_plan_units"));
            entity.setOldScheduleNo(getLongValue(jsonObject,"old_schedule_no"));
            entity.setNewScheduleNo(getLongValue(jsonObject,"new_schedule_no"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setClientSuppPlanId(getStringValue(jsonObject,"client_supp_plan_id"));
            entity.setClientOldScheduleId(getStringValue(jsonObject,"client_old_schedule_id"));
            entity.setClientNewScheduleId(getStringValue(jsonObject,"client_new_schedule_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<HistoryReturnElement> buildHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<HistoryReturnElement> returnElement = new ArrayList<HistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            HistoryReturnElement entity = new HistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setTransactionDesc(getStringValue(jsonObject,"transaction_desc"));
            entity.setTransactionAmount(getDoubleValue(jsonObject,"transaction_amount"));
            entity.setTransactionAppliedAmount(getDoubleValue(jsonObject,"transaction_applied_amount"));
            entity.setTransactionCurrency(getStringValue(jsonObject,"transaction_currency"));
            entity.setTransactionCreateDate(getStringValue(jsonObject,"transaction_create_date"));
            entity.setTransactionVoidDate(getStringValue(jsonObject,"transaction_void_date"));
            entity.setStatementNo(getLongValue(jsonObject,"statement_no"));
            entity.setTransactionVoidReason(getStringValue(jsonObject,"transaction_void_reason"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setTransactionComments(getStringValue(jsonObject,"transaction_comments"));
            entity.setTransactionSourceId(getLongValue(jsonObject,"transaction_source_id"));
            entity.setTransactionRefCode(getStringValue(jsonObject,"transaction_ref_code"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setCsrComments(getStringValue(jsonObject,"csr_comments"));
            entity.setSeqStatementId(getStringValue(jsonObject,"seq_statement_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UuidDataReturnElement> buildUuidDataReturnElement(JSONArray jsonArray) {
        ArrayList<UuidDataReturnElement> returnElement = new ArrayList<UuidDataReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UuidDataReturnElement entity = new UuidDataReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSeqNo(getLongValue(jsonObject,"seq_no"));
            entity.setUuid(getStringValue(jsonObject,"uuid"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctsWithPayMethodReturnElement> buildAcctsWithPayMethodReturnElement(JSONArray jsonArray) {
        ArrayList<AcctsWithPayMethodReturnElement> returnElement = new ArrayList<AcctsWithPayMethodReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctsWithPayMethodReturnElement entity = new AcctsWithPayMethodReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setActive(getLongValue(jsonObject,"active"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllAcctActiveContractsReturnElement> buildAllAcctActiveContractsReturnElement(JSONArray jsonArray) {
        ArrayList<AllAcctActiveContractsReturnElement> returnElement = new ArrayList<AllAcctActiveContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllAcctActiveContractsReturnElement entity = new AllAcctActiveContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractNo(getLongValue(jsonObject,"contract_no"));
            entity.setContractScope(getStringValue(jsonObject,"contract_scope"));
            entity.setTypeNo(getLongValue(jsonObject,"type_no"));
            entity.setLengthMonths(getLongValue(jsonObject,"length_months"));
            entity.setCancelFee(getDoubleValue(jsonObject,"cancel_fee"));
            entity.setCreateComments(getStringValue(jsonObject,"create_comments"));
            entity.setUpdateComments(getStringValue(jsonObject,"update_comments"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setStatusCode(getLongValue(jsonObject,"status_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllAcctContractsReturnElement> buildAllAcctContractsReturnElement(JSONArray jsonArray) {
        ArrayList<AllAcctContractsReturnElement> returnElement = new ArrayList<AllAcctContractsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllAcctContractsReturnElement entity = new AllAcctContractsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractNo(getLongValue(jsonObject,"contract_no"));
            entity.setContractScope(getStringValue(jsonObject,"contract_scope"));
            entity.setTypeNo(getLongValue(jsonObject,"type_no"));
            entity.setLengthMonths(getLongValue(jsonObject,"length_months"));
            entity.setCancelFee(getDoubleValue(jsonObject,"cancel_fee"));
            entity.setCreateComments(getStringValue(jsonObject,"create_comments"));
            entity.setUpdateComments(getStringValue(jsonObject,"update_comments"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setStatusCode(getLongValue(jsonObject,"status_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanStatusCd(getLongValue(jsonObject,"plan_status_cd"));
            entity.setPlanStatusLabel(getStringValue(jsonObject,"plan_status_label"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctReceiptReturnElement> buildAcctReceiptReturnElement(JSONArray jsonArray) {
        ArrayList<AcctReceiptReturnElement> returnElement = new ArrayList<AcctReceiptReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctReceiptReturnElement entity = new AcctReceiptReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setReceiptDate(getStringValue(jsonObject,"receipt_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlansReturnElement> buildPlansReturnElement(JSONArray jsonArray) {
        ArrayList<PlansReturnElement> returnElement = new ArrayList<PlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlansReturnElement entity = new PlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllPlansReturnElement> buildAllPlansReturnElement(JSONArray jsonArray) {
        ArrayList<AllPlansReturnElement> returnElement = new ArrayList<AllPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllPlansReturnElement entity = new AllPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ChildAcctsReturnElement> buildChildAcctsReturnElement(JSONArray jsonArray) {
        ArrayList<ChildAcctsReturnElement> returnElement = new ArrayList<ChildAcctsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ChildAcctsReturnElement entity = new ChildAcctsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CouponsReturnElement> buildCouponsReturnElement(JSONArray jsonArray) {
        ArrayList<CouponsReturnElement> returnElement = new ArrayList<CouponsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponsReturnElement entity = new CouponsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutCouponCd(getStringValue(jsonObject,"out_coupon_cd"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setExpDate(getStringValue(jsonObject,"exp_date"));
            entity.setMaxUses(getLongValue(jsonObject,"max_uses"));
            entity.setTotalUses(getLongValue(jsonObject,"total_uses"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRecurDiscountFlatAmt(getDoubleValue(jsonObject,"recur_discount_flat_amt"));
            entity.setOneTimeDiscountFlatAmt(getDoubleValue(jsonObject,"one_time_discount_flat_amt"));
            entity.setRecurDiscountPct(getDoubleValue(jsonObject,"recur_discount_pct"));
            entity.setOneTimeDiscountPct(getDoubleValue(jsonObject,"one_time_discount_pct"));
            entity.setStatusInd(getLongValue(jsonObject,"status_ind"));
            entity.setGroupNo(getLongValue(jsonObject,"group_no"));
            entity.setClientGroupId(getStringValue(jsonObject,"client_group_id"));
            entity.setGroupName(getStringValue(jsonObject,"group_name"));
            entity.setGroupDescription(getStringValue(jsonObject,"group_description"));
            entity.setGroupPrecedence(getLongValue(jsonObject,"group_precedence"));
                        ArrayList<CreditTemplatesReturnElement> arrayListCreditTemplatesReturnElement = buildCreditTemplatesReturnElement((JSONArray)jsonObject.get("credit_templates"));
            for (CreditTemplatesReturnElement element : arrayListCreditTemplatesReturnElement){
                entity.getCreditTemplates().add(element);
            }
                        ArrayList<DiscountRulesReturnElement> arrayListDiscountRulesReturnElement = buildDiscountRulesReturnElement((JSONArray)jsonObject.get("discount_rules"));
            for (DiscountRulesReturnElement element : arrayListDiscountRulesReturnElement){
                entity.getDiscountRules().add(element);
            }
                        ArrayList<DiscountBundlesReturnElement> arrayListDiscountBundlesReturnElement = buildDiscountBundlesReturnElement((JSONArray)jsonObject.get("discount_bundles"));
            for (DiscountBundlesReturnElement element : arrayListDiscountBundlesReturnElement){
                entity.getDiscountBundles().add(element);
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
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCreditTemplateNo(getLongValue(jsonObject,"credit_template_no"));
            entity.setTemplateName(getStringValue(jsonObject,"template_name"));
            entity.setFlatAmount(getDoubleValue(jsonObject,"flat_amount"));
            entity.setPercentAmount(getDoubleValue(jsonObject,"percent_amount"));
            entity.setPercentEvalPlanNo(getLongValue(jsonObject,"percent_eval_plan_no"));
            entity.setPercentEvalServiceNo(getLongValue(jsonObject,"percent_eval_service_no"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setEligiblePlanNo(getLongValue(jsonObject,"eligible_plan_no"));
            entity.setEligibleServiceNo(getLongValue(jsonObject,"eligible_service_no"));
            entity.setAltServiceNo2Apply(getLongValue(jsonObject,"alt_service_no_2_apply"));
            entity.setNumCreditsRequired(getDoubleValue(jsonObject,"num_credits_required"));
            entity.setCreditIntervalMonths(getLongValue(jsonObject,"credit_interval_months"));
                        ArrayList<EligibleServiceTypesReturnElement> arrayListEligibleServiceTypesReturnElement = buildEligibleServiceTypesReturnElement((JSONArray)jsonObject.get("eligible_service_types"));
            for (EligibleServiceTypesReturnElement element : arrayListEligibleServiceTypesReturnElement){
                entity.getEligibleServiceTypes().add(element);
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
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setEligibleServiceTypes(getStringValue(jsonObject,"eligible_service_types"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<DiscountRulesReturnElement> buildDiscountRulesReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountRulesReturnElement> returnElement = new ArrayList<DiscountRulesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountRulesReturnElement entity = new DiscountRulesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRuleNo(getLongValue(jsonObject,"rule_no"));
            entity.setClientRuleId(getStringValue(jsonObject,"client_rule_id"));
            entity.setRuleName(getStringValue(jsonObject,"rule_name"));
            entity.setScopeNo(getLongValue(jsonObject,"scope_no"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setFlatPercentInd(getStringValue(jsonObject,"flat_percent_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setInlineOffsetInd(getStringValue(jsonObject,"inline_offset_ind"));
            entity.setDurationTypeInd(getStringValue(jsonObject,"duration_type_ind"));
            entity.setMaxApplicableMonths(getLongValue(jsonObject,"max_applicable_months"));
            entity.setMaxApplicationsPerAcct(getLongValue(jsonObject,"max_applications_per_acct"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setAltServiceNo2Apply(getLongValue(jsonObject,"alt_service_no_2_apply"));
                        ArrayList<DiscountBundleNoReturnElement> arrayListDiscountBundleNoReturnElement = buildDiscountBundleNoReturnElement((JSONArray)jsonObject.get("discount_bundle_no"));
            for (DiscountBundleNoReturnElement element : arrayListDiscountBundleNoReturnElement){
                entity.getDiscountBundleNo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<DiscountBundleNoReturnElement> buildDiscountBundleNoReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountBundleNoReturnElement> returnElement = new ArrayList<DiscountBundleNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountBundleNoReturnElement entity = new DiscountBundleNoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBundleNo(getLongValue(jsonObject,"bundle_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<DiscountBundlesReturnElement> buildDiscountBundlesReturnElement(JSONArray jsonArray) {
        ArrayList<DiscountBundlesReturnElement> returnElement = new ArrayList<DiscountBundlesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DiscountBundlesReturnElement entity = new DiscountBundlesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBundleNo(getLongValue(jsonObject,"bundle_no"));
            entity.setClientBundleId(getStringValue(jsonObject,"client_bundle_id"));
            entity.setBundleName(getStringValue(jsonObject,"bundle_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CreditReasonCodesReturnElement> buildCreditReasonCodesReturnElement(JSONArray jsonArray) {
        ArrayList<CreditReasonCodesReturnElement> returnElement = new ArrayList<CreditReasonCodesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CreditReasonCodesReturnElement entity = new CreditReasonCodesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setReasonText(getStringValue(jsonObject,"reason_text"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<FamTransReturnElement> buildFamTransReturnElement(JSONArray jsonArray) {
        ArrayList<FamTransReturnElement> returnElement = new ArrayList<FamTransReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            FamTransReturnElement entity = new FamTransReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setTransactionDesc(getStringValue(jsonObject,"transaction_desc"));
            entity.setTransactionAmt(getDoubleValue(jsonObject,"transaction_amt"));
            entity.setTransactionAppliedAmt(getDoubleValue(jsonObject,"transaction_applied_amt"));
            entity.setTransactionCurrency(getStringValue(jsonObject,"transaction_currency"));
            entity.setTransactionCreateDate(getStringValue(jsonObject,"transaction_create_date"));
            entity.setTransactionVoidDate(getStringValue(jsonObject,"transaction_void_date"));
            entity.setTransactionStmtNo(getLongValue(jsonObject,"transaction_stmt_no"));
            entity.setTransactionVoidReason(getStringValue(jsonObject,"transaction_void_reason"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setTransactionComments(getStringValue(jsonObject,"transaction_comments"));
            entity.setTransactionSourceId(getLongValue(jsonObject,"transaction_source_id"));
            entity.setTransactionRefCode(getStringValue(jsonObject,"transaction_ref_code"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setCsrComments(getStringValue(jsonObject,"csr_comments"));
            entity.setTransactionSeqStmtId(getStringValue(jsonObject,"transaction_seq_stmt_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PayMethodsReturnElement> buildPayMethodsReturnElement(JSONArray jsonArray) {
        ArrayList<PayMethodsReturnElement> returnElement = new ArrayList<PayMethodsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PayMethodsReturnElement entity = new PayMethodsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSeqNo(getLongValue(jsonObject,"seq_no"));
            entity.setPayMethod(getLongValue(jsonObject,"pay_method"));
            entity.setFirstName(getStringValue(jsonObject,"first_name"));
            entity.setLastName(getStringValue(jsonObject,"last_name"));
            entity.setAddress1(getStringValue(jsonObject,"address1"));
            entity.setAddress2(getStringValue(jsonObject,"address2"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setState(getStringValue(jsonObject,"state"));
            entity.setZip(getStringValue(jsonObject,"zip"));
            entity.setCountry(getStringValue(jsonObject,"country"));
            entity.setPhone(getStringValue(jsonObject,"phone"));
            entity.setEmail(getStringValue(jsonObject,"email"));
            entity.setCcType(getStringValue(jsonObject,"cc_type"));
            entity.setCcSuffix(getStringValue(jsonObject,"cc_suffix"));
            entity.setCcExpMm(getStringValue(jsonObject,"cc_exp_mm"));
            entity.setCcExpYyyy(getStringValue(jsonObject,"cc_exp_yyyy"));
            entity.setBankName(getStringValue(jsonObject,"bank_name"));
            entity.setBankAcctSuffix(getStringValue(jsonObject,"bank_acct_suffix"));
            entity.setRecurringInd(getStringValue(jsonObject,"recurring_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<QueuedPlansReturnElement> buildQueuedPlansReturnElement(JSONArray jsonArray) {
        ArrayList<QueuedPlansReturnElement> returnElement = new ArrayList<QueuedPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            QueuedPlansReturnElement entity = new QueuedPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOriginalPlan(getStringValue(jsonObject,"original_plan"));
            entity.setOriginalPlanNo(getLongValue(jsonObject,"original_plan_no"));
            entity.setNewPlan(getStringValue(jsonObject,"new_plan"));
            entity.setNewPlanNo(getLongValue(jsonObject,"new_plan_no"));
            entity.setChangeDate(getStringValue(jsonObject,"change_date"));
            entity.setNewRateScheduleNo(getLongValue(jsonObject,"new_rate_schedule_no"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setNewPlanUnits(getDoubleValue(jsonObject,"new_plan_units"));
            entity.setNewPlanType(getStringValue(jsonObject,"new_plan_type"));
            entity.setClientOriginalPlanId(getStringValue(jsonObject,"client_original_plan_id"));
            entity.setClientNewPlanId(getStringValue(jsonObject,"client_new_plan_id"));
            entity.setClientNewRateScheduleId(getStringValue(jsonObject,"client_new_rate_schedule_id"));
                        ArrayList<CustomRateReturnElement> arrayListCustomRateReturnElement = buildCustomRateReturnElement((JSONArray)jsonObject.get("custom_rate"));
            for (CustomRateReturnElement element : arrayListCustomRateReturnElement){
                entity.getCustomRate().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CustomRateReturnElement> buildCustomRateReturnElement(JSONArray jsonArray) {
        ArrayList<CustomRateReturnElement> returnElement = new ArrayList<CustomRateReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CustomRateReturnElement entity = new CustomRateReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCustomRateServiceNo(getLongValue(jsonObject,"custom_rate_service_no"));
            entity.setCustomRateSeqNo(getLongValue(jsonObject,"custom_rate_seq_no"));
            entity.setCustomRateFromUnit(getLongValue(jsonObject,"custom_rate_from_unit"));
            entity.setCustomRateToUnit(getLongValue(jsonObject,"custom_rate_to_unit"));
            entity.setCustomRatePerUnit(getDoubleValue(jsonObject,"custom_rate_per_unit"));
            entity.setClientCustomRateServiceId(getStringValue(jsonObject,"client_custom_rate_service_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RecurringCreditInfoReturnElement> buildRecurringCreditInfoReturnElement(JSONArray jsonArray) {
        ArrayList<RecurringCreditInfoReturnElement> returnElement = new ArrayList<RecurringCreditInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RecurringCreditInfoReturnElement entity = new RecurringCreditInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRecurringCreditNo(getLongValue(jsonObject,"recurring_credit_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCreateUser(getStringValue(jsonObject,"create_user"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setUpdateUser(getStringValue(jsonObject,"update_user"));
            entity.setFirstCreditDate(getStringValue(jsonObject,"first_credit_date"));
            entity.setLastCreditDate(getStringValue(jsonObject,"last_credit_date"));
            entity.setNextCreditDate(getStringValue(jsonObject,"next_credit_date"));
            entity.setCreditAmount(getDoubleValue(jsonObject,"credit_amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setCreditsCompleted(getLongValue(jsonObject,"credits_completed"));
            entity.setCreditsRemaining(getLongValue(jsonObject,"credits_remaining"));
            entity.setCreditIntervalMonths(getLongValue(jsonObject,"credit_interval_months"));
            entity.setEligiblePlanNo(getLongValue(jsonObject,"eligible_plan_no"));
            entity.setEligiblePlanName(getStringValue(jsonObject,"eligible_plan_name"));
            entity.setEligibleServiceNo(getLongValue(jsonObject,"eligible_service_no"));
            entity.setEligibleServiceName(getStringValue(jsonObject,"eligible_service_name"));
            entity.setServiceNoToApply(getLongValue(jsonObject,"service_no_to_apply"));
            entity.setServiceNameToApply(getStringValue(jsonObject,"service_name_to_apply"));
            entity.setCreditStatusCd(getLongValue(jsonObject,"credit_status_cd"));
            entity.setCreditStatusLabel(getStringValue(jsonObject,"credit_status_label"));
            entity.setCreditReasonCd(getLongValue(jsonObject,"credit_reason_cd"));
            entity.setCreditReasonText(getStringValue(jsonObject,"credit_reason_text"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setCancelDate(getStringValue(jsonObject,"cancel_date"));
            entity.setCancelUser(getStringValue(jsonObject,"cancel_user"));
            entity.setCancelComments(getStringValue(jsonObject,"cancel_comments"));
            entity.setClientEligiblePlanId(getStringValue(jsonObject,"client_eligible_plan_id"));
            entity.setClientEligibleServiceId(getStringValue(jsonObject,"client_eligible_service_id"));
            entity.setClientServiceIdToApply(getStringValue(jsonObject,"client_service_id_to_apply"));
                        ArrayList<EligibleServiceTypesReturnElement> arrayListEligibleServiceTypesReturnElement = buildEligibleServiceTypesReturnElement((JSONArray)jsonObject.get("eligible_service_types"));
            for (EligibleServiceTypesReturnElement element : arrayListEligibleServiceTypesReturnElement){
                entity.getEligibleServiceTypes().add(element);
            }
                        ArrayList<EligibleServicePlanDetailsReturnElement> arrayListEligibleServicePlanDetailsReturnElement = buildEligibleServicePlanDetailsReturnElement((JSONArray)jsonObject.get("eligible_service_plan_details"));
            for (EligibleServicePlanDetailsReturnElement element : arrayListEligibleServicePlanDetailsReturnElement){
                entity.getEligibleServicePlanDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuReturnElement> buildSuReturnElement(JSONArray jsonArray) {
        ArrayList<SuReturnElement> returnElement = new ArrayList<SuReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuReturnElement entity = new SuReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setStandingUsageRecNo(getLongValue(jsonObject,"standing_usage_rec_no"));
            entity.setUsageType(getLongValue(jsonObject,"usage_type"));
            entity.setUsageUnits(getDoubleValue(jsonObject,"usage_units"));
            entity.setNextUsageDate(getStringValue(jsonObject,"next_usage_date"));
            entity.setAltDesc(getStringValue(jsonObject,"alt_desc"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setFirstUsageDate(getStringValue(jsonObject,"first_usage_date"));
            entity.setRecurringInd(getLongValue(jsonObject,"recurring_ind"));
            entity.setUsageTypeCode(getStringValue(jsonObject,"usage_type_code"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppFieldValuesReturnElement> buildSuppFieldValuesReturnElement(JSONArray jsonArray) {
        ArrayList<SuppFieldValuesReturnElement> returnElement = new ArrayList<SuppFieldValuesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppFieldValuesReturnElement entity = new SuppFieldValuesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppFieldValues(getStringValue(jsonObject,"supp_field_values"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctSuppFieldValuesReturnElement> buildAcctSuppFieldValuesReturnElement(JSONArray jsonArray) {
        ArrayList<AcctSuppFieldValuesReturnElement> returnElement = new ArrayList<AcctSuppFieldValuesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctSuppFieldValuesReturnElement entity = new AcctSuppFieldValuesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppFieldValue(getStringValue(jsonObject,"supp_field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UnappliedServiceCreditsReturnElement> buildUnappliedServiceCreditsReturnElement(JSONArray jsonArray) {
        ArrayList<UnappliedServiceCreditsReturnElement> returnElement = new ArrayList<UnappliedServiceCreditsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UnappliedServiceCreditsReturnElement entity = new UnappliedServiceCreditsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCreditId(getLongValue(jsonObject,"credit_id"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCreateUser(getStringValue(jsonObject,"create_user"));
            entity.setInitialAmount(getDoubleValue(jsonObject,"initial_amount"));
            entity.setAmountLeftToApply(getDoubleValue(jsonObject,"amount_left_to_apply"));
            entity.setReasonCd(getLongValue(jsonObject,"reason_cd"));
            entity.setReasonText(getStringValue(jsonObject,"reason_text"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setServiceNoToApply(getLongValue(jsonObject,"service_no_to_apply"));
            entity.setServiceNameToApply(getStringValue(jsonObject,"service_name_to_apply"));
            entity.setEligiblePlanNo(getLongValue(jsonObject,"eligible_plan_no"));
            entity.setEligiblePlanName(getStringValue(jsonObject,"eligible_plan_name"));
            entity.setEligibleServiceNo(getLongValue(jsonObject,"eligible_service_no"));
            entity.setEligibleServiceName(getStringValue(jsonObject,"eligible_service_name"));
            entity.setClientServiceIdToApply(getStringValue(jsonObject,"client_service_id_to_apply"));
            entity.setClientEligiblePlanId(getStringValue(jsonObject,"client_eligible_plan_id"));
            entity.setClientEligibleServiceId(getStringValue(jsonObject,"client_eligible_service_id"));
            entity.setAmountReservedForAnniversary(getLongValue(jsonObject,"amount_reserved_for_anniversary"));
                        ArrayList<EligibleServiceTypesReturnElement> arrayListEligibleServiceTypesReturnElement = buildEligibleServiceTypesReturnElement((JSONArray)jsonObject.get("eligible_service_types"));
            for (EligibleServiceTypesReturnElement element : arrayListEligibleServiceTypesReturnElement){
                entity.getEligibleServiceTypes().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UnbilledUsageRecsReturnElement> buildUnbilledUsageRecsReturnElement(JSONArray jsonArray) {
        ArrayList<UnbilledUsageRecsReturnElement> returnElement = new ArrayList<UnbilledUsageRecsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UnbilledUsageRecsReturnElement entity = new UnbilledUsageRecsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeDescription(getStringValue(jsonObject,"usage_type_description"));
            entity.setUsageDate(getStringValue(jsonObject,"usage_date"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setSpecificRecordChargeAmount(getDoubleValue(jsonObject,"specific_record_charge_amount"));
            entity.setPreRatedRate(getDoubleValue(jsonObject,"pre_rated_rate"));
            entity.setRecordedUnits(getDoubleValue(jsonObject,"recorded_units"));
            entity.setUsageParentRecNo(getLongValue(jsonObject,"usage_parent_rec_no"));
            entity.setUsageTypeCode(getStringValue(jsonObject,"usage_type_code"));
            entity.setExcludeReasonCd(getLongValue(jsonObject,"exclude_reason_cd"));
            entity.setUsageRecNo(getLongValue(jsonObject,"usage_rec_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UnitThresholdDetailsReturnElement> buildUnitThresholdDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<UnitThresholdDetailsReturnElement> returnElement = new ArrayList<UnitThresholdDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UnitThresholdDetailsReturnElement entity = new UnitThresholdDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setThresholdDestType(getStringValue(jsonObject,"threshold_dest_type"));
            entity.setThresholdBalanceType(getStringValue(jsonObject,"threshold_balance_type"));
            entity.setThresholdUnits(getDoubleValue(jsonObject,"threshold_units"));
            entity.setUsageUnitsMeasured(getDoubleValue(jsonObject,"usage_units_measured"));
                        ArrayList<ThresholdLevelsReturnElement> arrayListThresholdLevelsReturnElement = buildThresholdLevelsReturnElement((JSONArray)jsonObject.get("threshold_levels"));
            for (ThresholdLevelsReturnElement element : arrayListThresholdLevelsReturnElement){
                entity.getThresholdLevels().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ThresholdLevelsReturnElement> buildThresholdLevelsReturnElement(JSONArray jsonArray) {
        ArrayList<ThresholdLevelsReturnElement> returnElement = new ArrayList<ThresholdLevelsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ThresholdLevelsReturnElement entity = new ThresholdLevelsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLevelNo(getLongValue(jsonObject,"level_no"));
            entity.setThresholdValue(getDoubleValue(jsonObject,"threshold_value"));
            entity.setDeltaUsageUnitsBal(getDoubleValue(jsonObject,"delta_usage_units_bal"));
            entity.setDeltaUsageUnitsSign(getStringValue(jsonObject,"delta_usage_units_sign"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UsageHistoryRecordsReturnElement> buildUsageHistoryRecordsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageHistoryRecordsReturnElement> returnElement = new ArrayList<UsageHistoryRecordsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageHistoryRecordsReturnElement entity = new UsageHistoryRecordsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillableAcctNo(getLongValue(jsonObject,"billable_acct_no"));
            entity.setIncurringAcctNo(getLongValue(jsonObject,"incurring_acct_no"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeDescription(getStringValue(jsonObject,"usage_type_description"));
            entity.setUsageDate(getStringValue(jsonObject,"usage_date"));
            entity.setUsageTime(getStringValue(jsonObject,"usage_time"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setUnitsDescription(getStringValue(jsonObject,"units_description"));
            entity.setUsageUnitsDescription(getStringValue(jsonObject,"usage_units_description"));
            entity.setInvoiceTransactionId(getLongValue(jsonObject,"invoice_transaction_id"));
            entity.setTelcoTo(getStringValue(jsonObject,"telco_to"));
            entity.setTelcoFrom(getStringValue(jsonObject,"telco_from"));
            entity.setSpecificRecordChargeAmount(getDoubleValue(jsonObject,"specific_record_charge_amount"));
            entity.setIsExcluded(getStringValue(jsonObject,"is_excluded"));
            entity.setExclusionComments(getStringValue(jsonObject,"exclusion_comments"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setPreRatedRate(getDoubleValue(jsonObject,"pre_rated_rate"));
            entity.setQualifier1(getStringValue(jsonObject,"qualifier_1"));
            entity.setQualifier2(getStringValue(jsonObject,"qualifier_2"));
            entity.setQualifier3(getStringValue(jsonObject,"qualifier_3"));
            entity.setQualifier4(getStringValue(jsonObject,"qualifier_4"));
            entity.setRecordedUnits(getDoubleValue(jsonObject,"recorded_units"));
            entity.setUsageRecNo(getLongValue(jsonObject,"usage_rec_no"));
            entity.setUsageParentRecNo(getLongValue(jsonObject,"usage_parent_rec_no"));
            entity.setUsageTypeCode(getStringValue(jsonObject,"usage_type_code"));
            entity.setClientRecordId(getStringValue(jsonObject,"client_record_id"));
            entity.setExcludeReasonCd(getLongValue(jsonObject,"exclude_reason_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UsageSummaryRecordsReturnElement> buildUsageSummaryRecordsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageSummaryRecordsReturnElement> returnElement = new ArrayList<UsageSummaryRecordsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageSummaryRecordsReturnElement entity = new UsageSummaryRecordsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeLabel(getStringValue(jsonObject,"usage_type_label"));
            entity.setBilledInd(getLongValue(jsonObject,"billed_ind"));
            entity.setTotalUnits(getDoubleValue(jsonObject,"total_units"));
            entity.setTotalValueAmount(getDoubleValue(jsonObject,"total_value_amount"));
            entity.setTotalValueCurrencyCode(getStringValue(jsonObject,"total_value_currency_code"));
            entity.setLastUsageDate(getStringValue(jsonObject,"last_usage_date"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CancelledSuppPlansReturnElement> buildCancelledSuppPlansReturnElement(JSONArray jsonArray) {
        ArrayList<CancelledSuppPlansReturnElement> returnElement = new ArrayList<CancelledSuppPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CancelledSuppPlansReturnElement entity = new CancelledSuppPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppPlanNo(getLongValue(jsonObject,"supp_plan_no"));
            entity.setSuppPlanName(getStringValue(jsonObject,"supp_plan_name"));
            entity.setSuppProrationResultAmount(getDoubleValue(jsonObject,"supp_proration_result_amount"));
            entity.setClientSuppPlanId(getStringValue(jsonObject,"client_supp_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UpdAcctInvoiceLineItemsReturnElement> buildUpdAcctInvoiceLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<UpdAcctInvoiceLineItemsReturnElement> returnElement = new ArrayList<UpdAcctInvoiceLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UpdAcctInvoiceLineItemsReturnElement entity = new UpdAcctInvoiceLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineBaseUnits(getDoubleValue(jsonObject,"line_base_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllAcctSurchargesReturnElement> buildAllAcctSurchargesReturnElement(JSONArray jsonArray) {
        ArrayList<AllAcctSurchargesReturnElement> returnElement = new ArrayList<AllAcctSurchargesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllAcctSurchargesReturnElement entity = new AllAcctSurchargesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSurchargeNo(getLongValue(jsonObject,"surcharge_no"));
            entity.setSurchargeName(getStringValue(jsonObject,"surcharge_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setSurchargeType(getStringValue(jsonObject,"surcharge_type"));
            entity.setCurrency(getStringValue(jsonObject,"currency"));
            entity.setTaxGroup(getStringValue(jsonObject,"tax_group"));
            entity.setInvoiceAppMethod(getStringValue(jsonObject,"invoice_app_method"));
            entity.setRevGlCode(getStringValue(jsonObject,"rev_gl_code"));
            entity.setArGlCode(getStringValue(jsonObject,"ar_gl_code"));
                        ArrayList<SurchargePlanReturnElement> arrayListSurchargePlanReturnElement = buildSurchargePlanReturnElement((JSONArray)jsonObject.get("surcharge_plan"));
            for (SurchargePlanReturnElement element : arrayListSurchargePlanReturnElement){
                entity.getSurchargePlan().add(element);
            }
                        ArrayList<SurchargeRateReturnElement> arrayListSurchargeRateReturnElement = buildSurchargeRateReturnElement((JSONArray)jsonObject.get("surcharge_rate"));
            for (SurchargeRateReturnElement element : arrayListSurchargeRateReturnElement){
                entity.getSurchargeRate().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SurchargePlanReturnElement> buildSurchargePlanReturnElement(JSONArray jsonArray) {
        ArrayList<SurchargePlanReturnElement> returnElement = new ArrayList<SurchargePlanReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SurchargePlanReturnElement entity = new SurchargePlanReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientReceiptReturnElement> buildClientReceiptReturnElement(JSONArray jsonArray) {
        ArrayList<ClientReceiptReturnElement> returnElement = new ArrayList<ClientReceiptReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientReceiptReturnElement entity = new ClientReceiptReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setReceiptDate(getStringValue(jsonObject,"receipt_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ChildItemClassReturnElement> buildChildItemClassReturnElement(JSONArray jsonArray) {
        ArrayList<ChildItemClassReturnElement> returnElement = new ArrayList<ChildItemClassReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ChildItemClassReturnElement entity = new ChildItemClassReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setClassDescription(getStringValue(jsonObject,"class_description"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientCountryReturnElement> buildClientCountryReturnElement(JSONArray jsonArray) {
        ArrayList<ClientCountryReturnElement> returnElement = new ArrayList<ClientCountryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientCountryReturnElement entity = new ClientCountryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCountryCd(getStringValue(jsonObject,"country_cd"));
            entity.setCountryNative(getStringValue(jsonObject,"country_native"));
            entity.setCountryEnglish(getStringValue(jsonObject,"country_english"));
            entity.setIso31661n(getStringValue(jsonObject,"iso_3166_1n"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientCurrencyReturnElement> buildClientCurrencyReturnElement(JSONArray jsonArray) {
        ArrayList<ClientCurrencyReturnElement> returnElement = new ArrayList<ClientCurrencyReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientCurrencyReturnElement entity = new ClientCurrencyReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setCurrencyName(getStringValue(jsonObject,"currency_name"));
            entity.setCurrencyShortName(getStringValue(jsonObject,"currency_short_name"));
            entity.setIso4217n(getLongValue(jsonObject,"iso_4217n"));
            entity.setCurrencySymbol(getStringValue(jsonObject,"currency_symbol"));
            entity.setCurrencyHtml(getStringValue(jsonObject,"currency_html"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllItemClassesReturnElement> buildAllItemClassesReturnElement(JSONArray jsonArray) {
        ArrayList<AllItemClassesReturnElement> returnElement = new ArrayList<AllItemClassesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllItemClassesReturnElement entity = new AllItemClassesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setLabel(getStringValue(jsonObject,"label"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ItemImagesReturnElement> buildItemImagesReturnElement(JSONArray jsonArray) {
        ArrayList<ItemImagesReturnElement> returnElement = new ArrayList<ItemImagesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemImagesReturnElement entity = new ItemImagesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setImageClassName(getStringValue(jsonObject,"image_class_name"));
            entity.setImageClassNo(getLongValue(jsonObject,"image_class_no"));
            entity.setImageClassSeqNo(getLongValue(jsonObject,"image_class_seq_no"));
            entity.setImageUrl(getStringValue(jsonObject,"image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ItemRatesReturnElement> buildItemRatesReturnElement(JSONArray jsonArray) {
        ArrayList<ItemRatesReturnElement> returnElement = new ArrayList<ItemRatesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemRatesReturnElement entity = new ItemRatesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPrice(getDoubleValue(jsonObject,"price"));
            entity.setPricePerUnit(getDoubleValue(jsonObject,"price_per_unit"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
                        ArrayList<ScheduleReturnElement> arrayListScheduleReturnElement = buildScheduleReturnElement((JSONArray)jsonObject.get("schedule"));
            for (ScheduleReturnElement element : arrayListScheduleReturnElement){
                entity.getSchedule().add(element);
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
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setIsDefault(getStringValue(jsonObject,"is_default"));
            entity.setTaxInclusiveInd(getStringValue(jsonObject,"tax_inclusive_ind"));
                        ArrayList<TierReturnElement> arrayListTierReturnElement = buildTierReturnElement((JSONArray)jsonObject.get("tier"));
            for (TierReturnElement element : arrayListTierReturnElement){
                entity.getTier().add(element);
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
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFrom(getDoubleValue(jsonObject,"from"));
            entity.setTo(getDoubleValue(jsonObject,"to"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllItemSuppFieldsReturnElement> buildAllItemSuppFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<AllItemSuppFieldsReturnElement> returnElement = new ArrayList<AllItemSuppFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllItemSuppFieldsReturnElement entity = new AllItemSuppFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldDesc(getStringValue(jsonObject,"field_desc"));
            entity.setFieldOrderNo(getLongValue(jsonObject,"field_order_no"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientItemsReturnElement> buildClientItemsReturnElement(JSONArray jsonArray) {
        ArrayList<ClientItemsReturnElement> returnElement = new ArrayList<ClientItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientItemsReturnElement entity = new ClientItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setImageUrl(getStringValue(jsonObject,"image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
                        ArrayList<ScheduleReturnElement> arrayListScheduleReturnElement = buildScheduleReturnElement((JSONArray)jsonObject.get("schedule"));
            for (ScheduleReturnElement element : arrayListScheduleReturnElement){
                entity.getSchedule().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllClientItemsReturnElement> buildAllClientItemsReturnElement(JSONArray jsonArray) {
        ArrayList<AllClientItemsReturnElement> returnElement = new ArrayList<AllClientItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllClientItemsReturnElement entity = new AllClientItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
                        ArrayList<AllServiceSuppFieldsReturnElement> arrayListAllServiceSuppFieldsReturnElement = buildAllServiceSuppFieldsReturnElement((JSONArray)jsonObject.get("all_service_supp_fields"));
            for (AllServiceSuppFieldsReturnElement element : arrayListAllServiceSuppFieldsReturnElement){
                entity.getAllServiceSuppFields().add(element);
            }
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setItemType(getLongValue(jsonObject,"item_type"));
            entity.setItemDesc(getStringValue(jsonObject,"item_desc"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setModifyPriceInd(getStringValue(jsonObject,"modify_price_ind"));
            entity.setSubunitQty(getDoubleValue(jsonObject,"subunit_qty"));
            entity.setSubunitLabel(getStringValue(jsonObject,"subunit_label"));
            entity.setServiceType(getStringValue(jsonObject,"service_type"));
            entity.setCoaId(getStringValue(jsonObject,"coa_id"));
            entity.setClientCoaCode(getStringValue(jsonObject,"client_coa_code"));
            entity.setTaxableInd(getLongValue(jsonObject,"taxable_ind"));
            entity.setTaxGroup(getLongValue(jsonObject,"tax_group"));
            entity.setUsageType(getLongValue(jsonObject,"usage_type"));
                        ArrayList<AllItemPricesReturnElement> arrayListAllItemPricesReturnElement = buildAllItemPricesReturnElement((JSONArray)jsonObject.get("all_item_prices"));
            for (AllItemPricesReturnElement element : arrayListAllItemPricesReturnElement){
                entity.getAllItemPrices().add(element);
            }
                        ArrayList<AllItemImagesReturnElement> arrayListAllItemImagesReturnElement = buildAllItemImagesReturnElement((JSONArray)jsonObject.get("all_item_images"));
            for (AllItemImagesReturnElement element : arrayListAllItemImagesReturnElement){
                entity.getAllItemImages().add(element);
            }
                        ArrayList<AllItemSuppFieldsReturnElement> arrayListAllItemSuppFieldsReturnElement = buildAllItemSuppFieldsReturnElement((JSONArray)jsonObject.get("all_item_supp_fields"));
            for (AllItemSuppFieldsReturnElement element : arrayListAllItemSuppFieldsReturnElement){
                entity.getAllItemSuppFields().add(element);
            }
                        ArrayList<AllItemClassesReturnElement> arrayListAllItemClassesReturnElement = buildAllItemClassesReturnElement((JSONArray)jsonObject.get("all_item_classes"));
            for (AllItemClassesReturnElement element : arrayListAllItemClassesReturnElement){
                entity.getAllItemClasses().add(element);
            }
                        ArrayList<ScheduleReturnElement> arrayListScheduleReturnElement = buildScheduleReturnElement((JSONArray)jsonObject.get("schedule"));
            for (ScheduleReturnElement element : arrayListScheduleReturnElement){
                entity.getSchedule().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllItemPricesReturnElement> buildAllItemPricesReturnElement(JSONArray jsonArray) {
        ArrayList<AllItemPricesReturnElement> returnElement = new ArrayList<AllItemPricesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllItemPricesReturnElement entity = new AllItemPricesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPrice(getDoubleValue(jsonObject,"price"));
            entity.setPricePerUnit(getDoubleValue(jsonObject,"price_per_unit"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllItemImagesReturnElement> buildAllItemImagesReturnElement(JSONArray jsonArray) {
        ArrayList<AllItemImagesReturnElement> returnElement = new ArrayList<AllItemImagesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllItemImagesReturnElement entity = new AllItemImagesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setImageClassName(getStringValue(jsonObject,"image_class_name"));
            entity.setImageClassNo(getLongValue(jsonObject,"image_class_no"));
            entity.setImageClassSeqNo(getLongValue(jsonObject,"image_class_seq_no"));
            entity.setImageUrl(getStringValue(jsonObject,"image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ItemsBasicReturnElement> buildItemsBasicReturnElement(JSONArray jsonArray) {
        ArrayList<ItemsBasicReturnElement> returnElement = new ArrayList<ItemsBasicReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemsBasicReturnElement entity = new ItemsBasicReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setItemType(getLongValue(jsonObject,"item_type"));
            entity.setItemDesc(getStringValue(jsonObject,"item_desc"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setModifyPriceInd(getStringValue(jsonObject,"modify_price_ind"));
            entity.setSubunitQty(getDoubleValue(jsonObject,"subunit_qty"));
            entity.setSubunitLabel(getStringValue(jsonObject,"subunit_label"));
            entity.setServiceType(getStringValue(jsonObject,"service_type"));
            entity.setCoaId(getStringValue(jsonObject,"coa_id"));
            entity.setClientCoaCode(getStringValue(jsonObject,"client_coa_code"));
            entity.setTaxableInd(getLongValue(jsonObject,"taxable_ind"));
            entity.setTaxGroup(getLongValue(jsonObject,"tax_group"));
            entity.setUsageType(getLongValue(jsonObject,"usage_type"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientPlansReturnElement> buildClientPlansReturnElement(JSONArray jsonArray) {
        ArrayList<ClientPlansReturnElement> returnElement = new ArrayList<ClientPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientPlansReturnElement entity = new ClientPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setNoDisplayInd(getLongValue(jsonObject,"no_display_ind"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatusCd(getLongValue(jsonObject,"new_acct_status_cd"));
            entity.setRolloverAcctStatusCd(getLongValue(jsonObject,"rollover_acct_status_cd"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDaysTillSuspend(getLongValue(jsonObject,"days_till_suspend"));
            entity.setRateSeqNo(getLongValue(jsonObject,"rate_seq_no"));
            entity.setFromUnit(getDoubleValue(jsonObject,"from_unit"));
            entity.setToUnit(getDoubleValue(jsonObject,"to_unit"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setMonthlyFee(getDoubleValue(jsonObject,"monthly_fee"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllClientPlansReturnElement> buildAllClientPlansReturnElement(JSONArray jsonArray) {
        ArrayList<AllClientPlansReturnElement> returnElement = new ArrayList<AllClientPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllClientPlansReturnElement entity = new AllClientPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
                        ArrayList<PlanRateSchedulesReturnElement> arrayListPlanRateSchedulesReturnElement = buildPlanRateSchedulesReturnElement((JSONArray)jsonObject.get("plan_rate_schedules"));
            for (PlanRateSchedulesReturnElement element : arrayListPlanRateSchedulesReturnElement){
                entity.getPlanRateSchedules().add(element);
            }
                        ArrayList<PlanGroupsReturnElement> arrayListPlanGroupsReturnElement = buildPlanGroupsReturnElement((JSONArray)jsonObject.get("plan_groups"));
            for (PlanGroupsReturnElement element : arrayListPlanGroupsReturnElement){
                entity.getPlanGroups().add(element);
            }
                        ArrayList<PromotionalPlanSetsReturnElement> arrayListPromotionalPlanSetsReturnElement = buildPromotionalPlanSetsReturnElement((JSONArray)jsonObject.get("promotional_plan_sets"));
            for (PromotionalPlanSetsReturnElement element : arrayListPromotionalPlanSetsReturnElement){
                entity.getPromotionalPlanSets().add(element);
            }
                        ArrayList<ParentPlansReturnElement> arrayListParentPlansReturnElement = buildParentPlansReturnElement((JSONArray)jsonObject.get("parent_plans"));
            for (ParentPlansReturnElement element : arrayListParentPlansReturnElement){
                entity.getParentPlans().add(element);
            }
                        ArrayList<PlanSuppFieldsReturnElement> arrayListPlanSuppFieldsReturnElement = buildPlanSuppFieldsReturnElement((JSONArray)jsonObject.get("plan_supp_fields"));
            for (PlanSuppFieldsReturnElement element : arrayListPlanSuppFieldsReturnElement){
                entity.getPlanSuppFields().add(element);
            }
            entity.setFirstRetrievalLevelInd(getStringValue(jsonObject,"first_retrieval_level_ind"));
                        ArrayList<ChildPlanNoReturnElement> arrayListChildPlanNoReturnElement = buildChildPlanNoReturnElement((JSONArray)jsonObject.get("child_plan_no"));
            for (ChildPlanNoReturnElement element : arrayListChildPlanNoReturnElement){
                entity.getChildPlanNo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanRateSchedulesReturnElement> buildPlanRateSchedulesReturnElement(JSONArray jsonArray) {
        ArrayList<PlanRateSchedulesReturnElement> returnElement = new ArrayList<PlanRateSchedulesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanRateSchedulesReturnElement entity = new PlanRateSchedulesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setScheduleCurrency(getStringValue(jsonObject,"schedule_currency"));
            entity.setScheduleDefaultInd(getLongValue(jsonObject,"schedule_default_ind"));
            entity.setScheduleDefaultIndCurr(getLongValue(jsonObject,"schedule_default_ind_curr"));
            entity.setScheduleDisplayInd(getLongValue(jsonObject,"schedule_display_ind"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setAvailableFromDate(getStringValue(jsonObject,"available_from_date"));
            entity.setAvailableToDate(getStringValue(jsonObject,"available_to_date"));
            entity.setFutureRate(getLongValue(jsonObject,"future_rate"));
            entity.setFutureChangeDate(getStringValue(jsonObject,"future_change_date"));
            entity.setFollowupRsNo(getLongValue(jsonObject,"followup_rs_no"));
            entity.setClientFollowupRsId(getStringValue(jsonObject,"client_followup_rs_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanGroupsReturnElement> buildPlanGroupsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanGroupsReturnElement> returnElement = new ArrayList<PlanGroupsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanGroupsReturnElement entity = new PlanGroupsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanGroupNo(getLongValue(jsonObject,"plan_group_no"));
            entity.setPlanGroupName(getStringValue(jsonObject,"plan_group_name"));
            entity.setPlanGroupDesc(getStringValue(jsonObject,"plan_group_desc"));
            entity.setPlanGroupUsage(getStringValue(jsonObject,"plan_group_usage"));
            entity.setSelectableInd(getLongValue(jsonObject,"selectable_ind"));
            entity.setClientPlanGroupId(getStringValue(jsonObject,"client_plan_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PromotionalPlanSetsReturnElement> buildPromotionalPlanSetsReturnElement(JSONArray jsonArray) {
        ArrayList<PromotionalPlanSetsReturnElement> returnElement = new ArrayList<PromotionalPlanSetsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PromotionalPlanSetsReturnElement entity = new PromotionalPlanSetsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPromoSetNo(getLongValue(jsonObject,"promo_set_no"));
            entity.setPromoSetName(getStringValue(jsonObject,"promo_set_name"));
            entity.setPromoSetDesc(getStringValue(jsonObject,"promo_set_desc"));
                        ArrayList<PromotionsForSetReturnElement> arrayListPromotionsForSetReturnElement = buildPromotionsForSetReturnElement((JSONArray)jsonObject.get("promotions_for_set"));
            for (PromotionsForSetReturnElement element : arrayListPromotionsForSetReturnElement){
                entity.getPromotionsForSet().add(element);
            }
            entity.setClientPromoSetId(getStringValue(jsonObject,"client_promo_set_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PromotionsForSetReturnElement> buildPromotionsForSetReturnElement(JSONArray jsonArray) {
        ArrayList<PromotionsForSetReturnElement> returnElement = new ArrayList<PromotionsForSetReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PromotionsForSetReturnElement entity = new PromotionsForSetReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPromoCode(getStringValue(jsonObject,"promo_code"));
            entity.setPromoCodeDesc(getStringValue(jsonObject,"promo_code_desc"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ParentPlansReturnElement> buildParentPlansReturnElement(JSONArray jsonArray) {
        ArrayList<ParentPlansReturnElement> returnElement = new ArrayList<ParentPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ParentPlansReturnElement entity = new ParentPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParentPlanNo(getLongValue(jsonObject,"parent_plan_no"));
            entity.setParentPlanName(getStringValue(jsonObject,"parent_plan_name"));
            entity.setClientParentPlanId(getStringValue(jsonObject,"client_parent_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanSuppFieldsReturnElement> buildPlanSuppFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanSuppFieldsReturnElement> returnElement = new ArrayList<PlanSuppFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanSuppFieldsReturnElement entity = new PlanSuppFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanSuppFieldNo(getLongValue(jsonObject,"plan_supp_field_no"));
            entity.setPlanSuppFieldName(getStringValue(jsonObject,"plan_supp_field_name"));
            entity.setPlanSuppFieldDesc(getStringValue(jsonObject,"plan_supp_field_desc"));
            entity.setPlanSuppFieldValue(getStringValue(jsonObject,"plan_supp_field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ChildPlanNoReturnElement> buildChildPlanNoReturnElement(JSONArray jsonArray) {
        ArrayList<ChildPlanNoReturnElement> returnElement = new ArrayList<ChildPlanNoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ChildPlanNoReturnElement entity = new ChildPlanNoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlansBasicReturnElement> buildPlansBasicReturnElement(JSONArray jsonArray) {
        ArrayList<PlansBasicReturnElement> returnElement = new ArrayList<PlansBasicReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlansBasicReturnElement entity = new PlansBasicReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<TemplatesByClientReturnElement> buildTemplatesByClientReturnElement(JSONArray jsonArray) {
        ArrayList<TemplatesByClientReturnElement> returnElement = new ArrayList<TemplatesByClientReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            TemplatesByClientReturnElement entity = new TemplatesByClientReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTemplateNo(getLongValue(jsonObject,"template_no"));
            entity.setTemplateName(getStringValue(jsonObject,"template_name"));
            entity.setTemplateClass(getStringValue(jsonObject,"template_class"));
            entity.setClientEmailTemplateId(getStringValue(jsonObject,"client_email_template_id"));
            entity.setGlobalInd(getLongValue(jsonObject,"global_ind"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ItemRatingsReviewsReturnElement> buildItemRatingsReviewsReturnElement(JSONArray jsonArray) {
        ArrayList<ItemRatingsReviewsReturnElement> returnElement = new ArrayList<ItemRatingsReviewsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemRatingsReviewsReturnElement entity = new ItemRatingsReviewsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRatings(getLongValue(jsonObject,"ratings"));
            entity.setReviews(getStringValue(jsonObject,"reviews"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClassItemsReturnElement> buildClassItemsReturnElement(JSONArray jsonArray) {
        ArrayList<ClassItemsReturnElement> returnElement = new ArrayList<ClassItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClassItemsReturnElement entity = new ClassItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setPrice(getDoubleValue(jsonObject,"price"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setImageUrl(getStringValue(jsonObject,"image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ItemsBySuppFieldReturnElement> buildItemsBySuppFieldReturnElement(JSONArray jsonArray) {
        ArrayList<ItemsBySuppFieldReturnElement> returnElement = new ArrayList<ItemsBySuppFieldReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemsBySuppFieldReturnElement entity = new ItemsBySuppFieldReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setPrice(getDoubleValue(jsonObject,"price"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getDoubleValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setImageUrl(getStringValue(jsonObject,"image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlansBySuppFieldReturnElement> buildMasterPlansBySuppFieldReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlansBySuppFieldReturnElement> returnElement = new ArrayList<MasterPlansBySuppFieldReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlansBySuppFieldReturnElement entity = new MasterPlansBySuppFieldReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ParentItemClassReturnElement> buildParentItemClassReturnElement(JSONArray jsonArray) {
        ArrayList<ParentItemClassReturnElement> returnElement = new ArrayList<ParentItemClassReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ParentItemClassReturnElement entity = new ParentItemClassReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setClassDescription(getStringValue(jsonObject,"class_description"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RateSchedReturnElement> buildRateSchedReturnElement(JSONArray jsonArray) {
        ArrayList<RateSchedReturnElement> returnElement = new ArrayList<RateSchedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RateSchedReturnElement entity = new RateSchedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setScheduleCurrency(getStringValue(jsonObject,"schedule_currency"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setDefaultIndCurr(getLongValue(jsonObject,"default_ind_curr"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setAvailableFromDate(getStringValue(jsonObject,"available_from_date"));
            entity.setAvailableToDate(getStringValue(jsonObject,"available_to_date"));
            entity.setFollowupRsNo(getLongValue(jsonObject,"followup_rs_no"));
            entity.setClientFollowupRsId(getStringValue(jsonObject,"client_followup_rs_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OutRegUssConfigParamsReturnElement> buildOutRegUssConfigParamsReturnElement(JSONArray jsonArray) {
        ArrayList<OutRegUssConfigParamsReturnElement> returnElement = new ArrayList<OutRegUssConfigParamsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OutRegUssConfigParamsReturnElement entity = new OutRegUssConfigParamsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParamName(getStringValue(jsonObject,"param_name"));
            entity.setParamVal(getStringValue(jsonObject,"param_val"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OutRegUssParamsReturnElement> buildOutRegUssParamsReturnElement(JSONArray jsonArray) {
        ArrayList<OutRegUssParamsReturnElement> returnElement = new ArrayList<OutRegUssParamsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OutRegUssParamsReturnElement entity = new OutRegUssParamsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParamName(getStringValue(jsonObject,"param_name"));
            entity.setParamVal(getStringValue(jsonObject,"param_val"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlansBySuppFieldReturnElement> buildSuppPlansBySuppFieldReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlansBySuppFieldReturnElement> returnElement = new ArrayList<SuppPlansBySuppFieldReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlansBySuppFieldReturnElement entity = new SuppPlansBySuppFieldReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInterval(getLongValue(jsonObject,"billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<TopItemClassReturnElement> buildTopItemClassReturnElement(JSONArray jsonArray) {
        ArrayList<TopItemClassReturnElement> returnElement = new ArrayList<TopItemClassReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            TopItemClassReturnElement entity = new TopItemClassReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setClassDescription(getStringValue(jsonObject,"class_description"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<WebValsOutReturnElement> buildWebValsOutReturnElement(JSONArray jsonArray) {
        ArrayList<WebValsOutReturnElement> returnElement = new ArrayList<WebValsOutReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            WebValsOutReturnElement entity = new WebValsOutReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutReplacementNames(getStringValue(jsonObject,"out_replacement_names"));
            entity.setOutReplacementValues(getStringValue(jsonObject,"out_replacement_values"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<EventsReturnElement> buildEventsReturnElement(JSONArray jsonArray) {
        ArrayList<EventsReturnElement> returnElement = new ArrayList<EventsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            EventsReturnElement entity = new EventsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setEventId(getLongValue(jsonObject,"event_id"));
            entity.setEventName(getStringValue(jsonObject,"event_name"));
            entity.setEventDescription(getStringValue(jsonObject,"event_description"));
            entity.setEventState(getStringValue(jsonObject,"event_state"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<NewInventoryItemStockReturnElement> buildNewInventoryItemStockReturnElement(JSONArray jsonArray) {
        ArrayList<NewInventoryItemStockReturnElement> returnElement = new ArrayList<NewInventoryItemStockReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            NewInventoryItemStockReturnElement entity = new NewInventoryItemStockReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutItemNo(getLongValue(jsonObject,"out_item_no"));
            entity.setOutClientSku(getStringValue(jsonObject,"out_client_sku"));
            entity.setNewStockLevel(getDoubleValue(jsonObject,"new_stock_level"));
            entity.setOutClientItemId(getStringValue(jsonObject,"out_client_item_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctPlanLineItemsReturnElement> buildAcctPlanLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctPlanLineItemsReturnElement> returnElement = new ArrayList<AcctPlanLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctPlanLineItemsReturnElement entity = new AcctPlanLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineBaseUnits(getDoubleValue(jsonObject,"line_base_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OutAcctReturnElement> buildOutAcctReturnElement(JSONArray jsonArray) {
        ArrayList<OutAcctReturnElement> returnElement = new ArrayList<OutAcctReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OutAcctReturnElement entity = new OutAcctReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setUserid(getStringValue(jsonObject,"userid"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setAcctLocaleNo(getLongValue(jsonObject,"acct_locale_no"));
            entity.setAcctLocaleName(getStringValue(jsonObject,"acct_locale_name"));
                        ArrayList<ContractDetailsReturnElement> arrayListContractDetailsReturnElement = buildContractDetailsReturnElement((JSONArray)jsonObject.get("contract_details"));
            for (ContractDetailsReturnElement element : arrayListContractDetailsReturnElement){
                entity.getContractDetails().add(element);
            }
            entity.setSessionId(getStringValue(jsonObject,"session_id"));
                        ArrayList<BillingErrorsReturnElement> arrayListBillingErrorsReturnElement = buildBillingErrorsReturnElement((JSONArray)jsonObject.get("billing_errors"));
            for (BillingErrorsReturnElement element : arrayListBillingErrorsReturnElement){
                entity.getBillingErrors().add(element);
            }
                        ArrayList<MasterPlansAssignedReturnElement> arrayListMasterPlansAssignedReturnElement = buildMasterPlansAssignedReturnElement((JSONArray)jsonObject.get("master_plans_assigned"));
            for (MasterPlansAssignedReturnElement element : arrayListMasterPlansAssignedReturnElement){
                entity.getMasterPlansAssigned().add(element);
            }
                        ArrayList<InvoiceInfoReturnElement> arrayListInvoiceInfoReturnElement = buildInvoiceInfoReturnElement((JSONArray)jsonObject.get("invoice_info"));
            for (InvoiceInfoReturnElement element : arrayListInvoiceInfoReturnElement){
                entity.getInvoiceInfo().add(element);
            }
                        ArrayList<OutAcctReturnElement> arrayListOutAcctReturnElement = buildOutAcctReturnElement((JSONArray)jsonObject.get("out_acct"));
            for (OutAcctReturnElement element : arrayListOutAcctReturnElement){
                entity.getOutAcct().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ContractDetailsReturnElement> buildContractDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<ContractDetailsReturnElement> returnElement = new ArrayList<ContractDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ContractDetailsReturnElement entity = new ContractDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractNo(getLongValue(jsonObject,"contract_no"));
            entity.setClientContractId(getStringValue(jsonObject,"client_contract_id"));
                        ArrayList<ContractPlanDetailsReturnElement> arrayListContractPlanDetailsReturnElement = buildContractPlanDetailsReturnElement((JSONArray)jsonObject.get("contract_plan_details"));
            for (ContractPlanDetailsReturnElement element : arrayListContractPlanDetailsReturnElement){
                entity.getContractPlanDetails().add(element);
            }
            entity.setContractScope(getStringValue(jsonObject,"contract_scope"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ContractPlanDetailsReturnElement> buildContractPlanDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<ContractPlanDetailsReturnElement> returnElement = new ArrayList<ContractPlanDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ContractPlanDetailsReturnElement entity = new ContractPlanDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<BillingErrorsReturnElement> buildBillingErrorsReturnElement(JSONArray jsonArray) {
        ArrayList<BillingErrorsReturnElement> returnElement = new ArrayList<BillingErrorsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            BillingErrorsReturnElement entity = new BillingErrorsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoicingErrorCode(getLongValue(jsonObject,"invoicing_error_code"));
            entity.setInvoicingErrorMsg(getStringValue(jsonObject,"invoicing_error_msg"));
            entity.setCollectionErrorCode(getLongValue(jsonObject,"collection_error_code"));
            entity.setCollectionErrorMsg(getStringValue(jsonObject,"collection_error_msg"));
            entity.setStatementErrorCode(getLongValue(jsonObject,"statement_error_code"));
            entity.setStatementErrorMsg(getStringValue(jsonObject,"statement_error_msg"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlansAssignedReturnElement> buildMasterPlansAssignedReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlansAssignedReturnElement> returnElement = new ArrayList<MasterPlansAssignedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlansAssignedReturnElement entity = new MasterPlansAssignedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setNsoOrderNo(getLongValue(jsonObject,"nso_order_no"));
            entity.setNsoOrderStatusLabel(getStringValue(jsonObject,"nso_order_status_label"));
                        ArrayList<PlanUnitInstanceDetailsReturnElement> arrayListPlanUnitInstanceDetailsReturnElement = buildPlanUnitInstanceDetailsReturnElement((JSONArray)jsonObject.get("plan_unit_instance_details"));
            for (PlanUnitInstanceDetailsReturnElement element : arrayListPlanUnitInstanceDetailsReturnElement){
                entity.getPlanUnitInstanceDetails().add(element);
            }
                        ArrayList<SuppPlansAssignedReturnElement> arrayListSuppPlansAssignedReturnElement = buildSuppPlansAssignedReturnElement((JSONArray)jsonObject.get("supp_plans_assigned"));
            for (SuppPlansAssignedReturnElement element : arrayListSuppPlansAssignedReturnElement){
                entity.getSuppPlansAssigned().add(element);
            }
                        ArrayList<OutContractReturnElement> arrayListOutContractReturnElement = buildOutContractReturnElement((JSONArray)jsonObject.get("out_contract"));
            for (OutContractReturnElement element : arrayListOutContractReturnElement){
                entity.getOutContract().add(element);
            }
                        ArrayList<ThirdPartyErrorsReturnElement> arrayListThirdPartyErrorsReturnElement = buildThirdPartyErrorsReturnElement((JSONArray)jsonObject.get("third_party_errors"));
            for (ThirdPartyErrorsReturnElement element : arrayListThirdPartyErrorsReturnElement){
                entity.getThirdPartyErrors().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanUnitInstanceDetailsReturnElement> buildPlanUnitInstanceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanUnitInstanceDetailsReturnElement> returnElement = new ArrayList<PlanUnitInstanceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanUnitInstanceDetailsReturnElement entity = new PlanUnitInstanceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutPlanUnitInstNo(getLongValue(jsonObject,"out_plan_unit_inst_no"));
            entity.setOutClientPlanUnitInstId(getStringValue(jsonObject,"out_client_plan_unit_inst_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlansAssignedReturnElement> buildSuppPlansAssignedReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlansAssignedReturnElement> returnElement = new ArrayList<SuppPlansAssignedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlansAssignedReturnElement entity = new SuppPlansAssignedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppPlanInstanceNo(getLongValue(jsonObject,"supp_plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
                        ArrayList<PlanUnitInstanceDetailsReturnElement> arrayListPlanUnitInstanceDetailsReturnElement = buildPlanUnitInstanceDetailsReturnElement((JSONArray)jsonObject.get("plan_unit_instance_details"));
            for (PlanUnitInstanceDetailsReturnElement element : arrayListPlanUnitInstanceDetailsReturnElement){
                entity.getPlanUnitInstanceDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OutContractReturnElement> buildOutContractReturnElement(JSONArray jsonArray) {
        ArrayList<OutContractReturnElement> returnElement = new ArrayList<OutContractReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OutContractReturnElement entity = new OutContractReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractNo(getLongValue(jsonObject,"contract_no"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceInfoReturnElement> buildInvoiceInfoReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceInfoReturnElement> returnElement = new ArrayList<InvoiceInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceInfoReturnElement entity = new InvoiceInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setProcCvvResponse(getStringValue(jsonObject,"proc_cvv_response"));
            entity.setProcAvsResponse(getStringValue(jsonObject,"proc_avs_response"));
            entity.setProcCavvResponse(getStringValue(jsonObject,"proc_cavv_response"));
            entity.setProcStatusCode(getStringValue(jsonObject,"proc_status_code"));
            entity.setProcStatusText(getStringValue(jsonObject,"proc_status_text"));
            entity.setProcPaymentId(getStringValue(jsonObject,"proc_payment_id"));
            entity.setProcAuthCode(getStringValue(jsonObject,"proc_auth_code"));
            entity.setProcMerchComments(getStringValue(jsonObject,"proc_merch_comments"));
            entity.setInvoiceChargesBeforeTax(getDoubleValue(jsonObject,"invoice_charges_before_tax"));
            entity.setInvoiceTaxCharges(getDoubleValue(jsonObject,"invoice_tax_charges"));
            entity.setInvoiceChargesAfterTax(getDoubleValue(jsonObject,"invoice_charges_after_tax"));
            entity.setInvoiceCreditAmount(getDoubleValue(jsonObject,"invoice_credit_amount"));
            entity.setInvoiceTotalAmount(getDoubleValue(jsonObject,"invoice_total_amount"));
            entity.setTotalCredit(getDoubleValue(jsonObject,"total_credit"));
            entity.setTotalTaxCredit(getDoubleValue(jsonObject,"total_tax_credit"));
            entity.setTotalCreditBeforeTax(getDoubleValue(jsonObject,"total_credit_before_tax"));
            entity.setTotal(getDoubleValue(jsonObject,"total"));
            entity.setProrationResultAmount(getDoubleValue(jsonObject,"proration_result_amount"));
            entity.setExpectedMonthlyRecCost(getDoubleValue(jsonObject,"expected_monthly_rec_cost"));
            entity.setExpectedAnnualRecCost(getDoubleValue(jsonObject,"expected_annual_rec_cost"));
                        ArrayList<InvoiceItemsReturnElement> arrayListInvoiceItemsReturnElement = buildInvoiceItemsReturnElement((JSONArray)jsonObject.get("invoice_items"));
            for (InvoiceItemsReturnElement element : arrayListInvoiceItemsReturnElement){
                entity.getInvoiceItems().add(element);
            }
                        ArrayList<TaxDetailsReturnElement> arrayListTaxDetailsReturnElement = buildTaxDetailsReturnElement((JSONArray)jsonObject.get("tax_details"));
            for (TaxDetailsReturnElement element : arrayListTaxDetailsReturnElement){
                entity.getTaxDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceItemsReturnElement> buildInvoiceItemsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceItemsReturnElement> returnElement = new ArrayList<InvoiceItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceItemsReturnElement entity = new InvoiceItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceCoaId(getLongValue(jsonObject,"service_coa_id"));
            entity.setClientServiceCoaCode(getStringValue(jsonObject,"client_service_coa_code"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineDescription(getStringValue(jsonObject,"line_description"));
            entity.setStartDateRange(getStringValue(jsonObject,"start_date_range"));
            entity.setEndDateRange(getStringValue(jsonObject,"end_date_range"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setBasePlanUnits(getDoubleValue(jsonObject,"base_plan_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setProrationText(getStringValue(jsonObject,"proration_text"));
            entity.setProrationRemainingDays(getLongValue(jsonObject,"proration_remaining_days"));
            entity.setProrationDescription(getStringValue(jsonObject,"proration_description"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setAdvBillingPeriodTotalDays(getLongValue(jsonObject,"adv_billing_period_total_days"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleTierNo(getLongValue(jsonObject,"rate_schedule_tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<TaxDetailsReturnElement> buildTaxDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<TaxDetailsReturnElement> returnElement = new ArrayList<TaxDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            TaxDetailsReturnElement entity = new TaxDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTaxDetailLine(getLongValue(jsonObject,"tax_detail_line"));
            entity.setSeqNum(getLongValue(jsonObject,"seq_num"));
            entity.setTaxedSeqNum(getLongValue(jsonObject,"taxed_seq_num"));
            entity.setDebit(getDoubleValue(jsonObject,"debit"));
            entity.setTaxAuthorityLevel(getLongValue(jsonObject,"tax_authority_level"));
            entity.setTaxRate(getDoubleValue(jsonObject,"tax_rate"));
            entity.setOrigWasTaxInclusive(getStringValue(jsonObject,"orig_was_tax_inclusive"));
            entity.setTaxSrvTaxTypeId(getStringValue(jsonObject,"tax_srv_tax_type_id"));
            entity.setTaxSrvTaxTypeDesc(getStringValue(jsonObject,"tax_srv_tax_type_desc"));
            entity.setTaxSrvCatText(getStringValue(jsonObject,"tax_srv_cat_text"));
            entity.setTaxSrvJurisNm(getStringValue(jsonObject,"tax_srv_juris_nm"));
            entity.setTaxSrvTaxSumText(getStringValue(jsonObject,"tax_srv_tax_sum_text"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlanInstancesReturnElement> buildMasterPlanInstancesReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlanInstancesReturnElement> returnElement = new ArrayList<MasterPlanInstancesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlanInstancesReturnElement entity = new MasterPlanInstancesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientDefMasterPlanInstanceId(getStringValue(jsonObject,"client_def_master_plan_instance_id"));
            entity.setMasterPlanName(getStringValue(jsonObject,"master_plan_name"));
            entity.setMasterPlanInstanceDesc(getStringValue(jsonObject,"master_plan_instance_desc"));
            entity.setMasterPlanInstanceBalance(getDoubleValue(jsonObject,"master_plan_instance_balance"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<BillingGroupsReturnElement> buildBillingGroupsReturnElement(JSONArray jsonArray) {
        ArrayList<BillingGroupsReturnElement> returnElement = new ArrayList<BillingGroupsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            BillingGroupsReturnElement entity = new BillingGroupsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setBillingGroupName(getStringValue(jsonObject,"billing_group_name"));
            entity.setBillingGroupDescription(getStringValue(jsonObject,"billing_group_description"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            entity.setStatus(getLongValue(jsonObject,"status"));
            entity.setNotifyMethod(getLongValue(jsonObject,"notify_method"));
            entity.setNotifyTemplateGroup(getLongValue(jsonObject,"notify_template_group"));
            entity.setStatementTemplate(getLongValue(jsonObject,"statement_template"));
            entity.setCreditNoteTemplate(getLongValue(jsonObject,"credit_note_template"));
            entity.setPrimaryPaymentMethodNo(getLongValue(jsonObject,"primary_payment_method_no"));
            entity.setClientPrimaryPaymentMethodId(getStringValue(jsonObject,"client_primary_payment_method_id"));
            entity.setBackupPaymentMethodNo(getLongValue(jsonObject,"backup_payment_method_no"));
            entity.setClientBackupPaymentMethodId(getStringValue(jsonObject,"client_backup_payment_method_id"));
            entity.setStmtFirstName(getStringValue(jsonObject,"stmt_first_name"));
            entity.setStmtMi(getStringValue(jsonObject,"stmt_mi"));
            entity.setStmtLastName(getStringValue(jsonObject,"stmt_last_name"));
            entity.setStmtCompanyName(getStringValue(jsonObject,"stmt_company_name"));
            entity.setStmtAddress1(getStringValue(jsonObject,"stmt_address1"));
            entity.setStmtAddress2(getStringValue(jsonObject,"stmt_address2"));
            entity.setStmtAddress3(getStringValue(jsonObject,"stmt_address3"));
            entity.setStmtCity(getStringValue(jsonObject,"stmt_city"));
            entity.setStmtLocality(getStringValue(jsonObject,"stmt_locality"));
            entity.setStmtStateProv(getStringValue(jsonObject,"stmt_state_prov"));
            entity.setStmtCountry(getStringValue(jsonObject,"stmt_country"));
            entity.setStmtPostalCd(getStringValue(jsonObject,"stmt_postal_cd"));
            entity.setStmtPhone(getStringValue(jsonObject,"stmt_phone"));
            entity.setStmtPhoneExt(getStringValue(jsonObject,"stmt_phone_ext"));
            entity.setStmtCellPhone(getStringValue(jsonObject,"stmt_cell_phone"));
            entity.setStmtWorkPhone(getStringValue(jsonObject,"stmt_work_phone"));
            entity.setStmtWorkPhoneExt(getStringValue(jsonObject,"stmt_work_phone_ext"));
            entity.setStmtFax(getStringValue(jsonObject,"stmt_fax"));
            entity.setStmtEmail(getStringValue(jsonObject,"stmt_email"));
            entity.setStmtBirthdate(getStringValue(jsonObject,"stmt_birthdate"));
            entity.setListStartMasterFile(getLongValue(jsonObject,"list_start_master_file"));
            entity.setAddressVerificationCode(getStringValue(jsonObject,"address_verification_code"));
            entity.setAddressMatchScore(getDoubleValue(jsonObject,"address_match_score"));
                        ArrayList<MasterPlansSummaryReturnElement> arrayListMasterPlansSummaryReturnElement = buildMasterPlansSummaryReturnElement((JSONArray)jsonObject.get("master_plans_summary"));
            for (MasterPlansSummaryReturnElement element : arrayListMasterPlansSummaryReturnElement){
                entity.getMasterPlansSummary().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlansSummaryReturnElement> buildMasterPlansSummaryReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlansSummaryReturnElement> returnElement = new ArrayList<MasterPlansSummaryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlansSummaryReturnElement entity = new MasterPlansSummaryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PaymentMethodsSummaryReturnElement> buildPaymentMethodsSummaryReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentMethodsSummaryReturnElement> returnElement = new ArrayList<PaymentMethodsSummaryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentMethodsSummaryReturnElement entity = new PaymentMethodsSummaryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillFirstName(getStringValue(jsonObject,"bill_first_name"));
            entity.setBillMiddleInitial(getStringValue(jsonObject,"bill_middle_initial"));
            entity.setBillLastName(getStringValue(jsonObject,"bill_last_name"));
            entity.setBillCompanyName(getStringValue(jsonObject,"bill_company_name"));
            entity.setBillAddress1(getStringValue(jsonObject,"bill_address1"));
            entity.setBillAddress2(getStringValue(jsonObject,"bill_address2"));
            entity.setBillAddress3(getStringValue(jsonObject,"bill_address3"));
            entity.setBillCity(getStringValue(jsonObject,"bill_city"));
            entity.setBillLocality(getStringValue(jsonObject,"bill_locality"));
            entity.setBillStateProv(getStringValue(jsonObject,"bill_state_prov"));
            entity.setBillCountry(getStringValue(jsonObject,"bill_country"));
            entity.setBillPostalCd(getStringValue(jsonObject,"bill_postal_cd"));
            entity.setBillPhone(getStringValue(jsonObject,"bill_phone"));
            entity.setBillPhoneExt(getStringValue(jsonObject,"bill_phone_ext"));
            entity.setBillCellPhone(getStringValue(jsonObject,"bill_cell_phone"));
            entity.setBillWorkPhone(getStringValue(jsonObject,"bill_work_phone"));
            entity.setBillWorkPhoneExt(getStringValue(jsonObject,"bill_work_phone_ext"));
            entity.setBillFax(getStringValue(jsonObject,"bill_fax"));
            entity.setBillEmail(getStringValue(jsonObject,"bill_email"));
            entity.setBillBirthdate(getStringValue(jsonObject,"bill_birthdate"));
            entity.setBillAddressVerificationCode(getStringValue(jsonObject,"bill_address_verification_code"));
            entity.setBillAddressMatchScore(getDoubleValue(jsonObject,"bill_address_match_score"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setPaymentMethodNo(getLongValue(jsonObject,"payment_method_no"));
            entity.setClientPaymentMethodId(getStringValue(jsonObject,"client_payment_method_id"));
            entity.setPayMethodDescription(getStringValue(jsonObject,"pay_method_description"));
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setCcExpireMm(getLongValue(jsonObject,"cc_expire_mm"));
            entity.setCcExpireYyyy(getLongValue(jsonObject,"cc_expire_yyyy"));
            entity.setBillAgreementId(getStringValue(jsonObject,"bill_agreement_id"));
            entity.setBankSwiftCd(getStringValue(jsonObject,"bank_swift_cd"));
            entity.setBankCountryCd(getStringValue(jsonObject,"bank_country_cd"));
            entity.setMandateId(getStringValue(jsonObject,"mandate_id"));
            entity.setListStartMasterFile(getLongValue(jsonObject,"list_start_master_file"));
            entity.setBankIdCd(getStringValue(jsonObject,"bank_id_cd"));
            entity.setBankBranchCd(getStringValue(jsonObject,"bank_branch_cd"));
            entity.setSuffix(getStringValue(jsonObject,"suffix"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AccountContactReturnElement> buildAccountContactReturnElement(JSONArray jsonArray) {
        ArrayList<AccountContactReturnElement> returnElement = new ArrayList<AccountContactReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AccountContactReturnElement entity = new AccountContactReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFirstName(getStringValue(jsonObject,"first_name"));
            entity.setMiddleInitial(getStringValue(jsonObject,"middle_initial"));
            entity.setLastName(getStringValue(jsonObject,"last_name"));
            entity.setCompanyName(getStringValue(jsonObject,"company_name"));
            entity.setAddress1(getStringValue(jsonObject,"address1"));
            entity.setAddress2(getStringValue(jsonObject,"address2"));
            entity.setAddress3(getStringValue(jsonObject,"address3"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setLocality(getStringValue(jsonObject,"locality"));
            entity.setStateProv(getStringValue(jsonObject,"state_prov"));
            entity.setCountryCd(getStringValue(jsonObject,"country_cd"));
            entity.setPostalCd(getStringValue(jsonObject,"postal_cd"));
            entity.setPhone(getStringValue(jsonObject,"phone"));
            entity.setPhoneExt(getStringValue(jsonObject,"phone_ext"));
            entity.setCellPhone(getStringValue(jsonObject,"cell_phone"));
            entity.setWorkPhone(getStringValue(jsonObject,"work_phone"));
            entity.setWorkPhoneExt(getStringValue(jsonObject,"work_phone_ext"));
            entity.setFax(getStringValue(jsonObject,"fax"));
            entity.setEmail(getStringValue(jsonObject,"email"));
            entity.setBirthdate(getStringValue(jsonObject,"birthdate"));
            entity.setAddressVerificationCode(getStringValue(jsonObject,"address_verification_code"));
            entity.setAddressMatchScore(getDoubleValue(jsonObject,"address_match_score"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<BillingContactsReturnElement> buildBillingContactsReturnElement(JSONArray jsonArray) {
        ArrayList<BillingContactsReturnElement> returnElement = new ArrayList<BillingContactsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            BillingContactsReturnElement entity = new BillingContactsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillFirstName(getStringValue(jsonObject,"bill_first_name"));
            entity.setBillMiddleInitial(getStringValue(jsonObject,"bill_middle_initial"));
            entity.setBillLastName(getStringValue(jsonObject,"bill_last_name"));
            entity.setBillCompanyName(getStringValue(jsonObject,"bill_company_name"));
            entity.setBillAddress1(getStringValue(jsonObject,"bill_address1"));
            entity.setBillAddress2(getStringValue(jsonObject,"bill_address2"));
            entity.setBillAddress3(getStringValue(jsonObject,"bill_address3"));
            entity.setBillCity(getStringValue(jsonObject,"bill_city"));
            entity.setBillLocality(getStringValue(jsonObject,"bill_locality"));
            entity.setBillStateProv(getStringValue(jsonObject,"bill_state_prov"));
            entity.setBillCountry(getStringValue(jsonObject,"bill_country"));
            entity.setBillPostalCd(getStringValue(jsonObject,"bill_postal_cd"));
            entity.setBillPhone(getStringValue(jsonObject,"bill_phone"));
            entity.setBillPhoneExt(getStringValue(jsonObject,"bill_phone_ext"));
            entity.setBillCellPhone(getStringValue(jsonObject,"bill_cell_phone"));
            entity.setBillWorkPhone(getStringValue(jsonObject,"bill_work_phone"));
            entity.setBillWorkPhoneExt(getStringValue(jsonObject,"bill_work_phone_ext"));
            entity.setBillFax(getStringValue(jsonObject,"bill_fax"));
            entity.setBillEmail(getStringValue(jsonObject,"bill_email"));
            entity.setBillBirthdate(getStringValue(jsonObject,"bill_birthdate"));
            entity.setBillAddressVerificationCode(getStringValue(jsonObject,"bill_address_verification_code"));
            entity.setBillAddressMatchScore(getDoubleValue(jsonObject,"bill_address_match_score"));
            entity.setBillBillingGroupNo(getLongValue(jsonObject,"bill_billing_group_no"));
            entity.setBillClientBillingGroupId(getStringValue(jsonObject,"bill_client_billing_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<BackupContactsReturnElement> buildBackupContactsReturnElement(JSONArray jsonArray) {
        ArrayList<BackupContactsReturnElement> returnElement = new ArrayList<BackupContactsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            BackupContactsReturnElement entity = new BackupContactsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBkupFirstName(getStringValue(jsonObject,"bkup_first_name"));
            entity.setBkupMiddleInitial(getStringValue(jsonObject,"bkup_middle_initial"));
            entity.setBkupLastName(getStringValue(jsonObject,"bkup_last_name"));
            entity.setBkupCompanyName(getStringValue(jsonObject,"bkup_company_name"));
            entity.setBkupAddress1(getStringValue(jsonObject,"bkup_address1"));
            entity.setBkupAddress2(getStringValue(jsonObject,"bkup_address2"));
            entity.setBkupAddress3(getStringValue(jsonObject,"bkup_address3"));
            entity.setBkupCity(getStringValue(jsonObject,"bkup_city"));
            entity.setBkupLocality(getStringValue(jsonObject,"bkup_locality"));
            entity.setBkupStateProv(getStringValue(jsonObject,"bkup_state_prov"));
            entity.setBkupCountry(getStringValue(jsonObject,"bkup_country"));
            entity.setBkupPostalCd(getStringValue(jsonObject,"bkup_postal_cd"));
            entity.setBkupPhone(getStringValue(jsonObject,"bkup_phone"));
            entity.setBkupPhoneExt(getStringValue(jsonObject,"bkup_phone_ext"));
            entity.setBkupCellPhone(getStringValue(jsonObject,"bkup_cell_phone"));
            entity.setBkupWorkPhone(getStringValue(jsonObject,"bkup_work_phone"));
            entity.setBkupWorkPhoneExt(getStringValue(jsonObject,"bkup_work_phone_ext"));
            entity.setBkupFax(getStringValue(jsonObject,"bkup_fax"));
            entity.setBkupEmail(getStringValue(jsonObject,"bkup_email"));
            entity.setBkupBirthdate(getStringValue(jsonObject,"bkup_birthdate"));
            entity.setBkupAddressVerificationCode(getStringValue(jsonObject,"bkup_address_verification_code"));
            entity.setBkupAddressMatchScore(getDoubleValue(jsonObject,"bkup_address_match_score"));
            entity.setBkupBillingGroupNo(getLongValue(jsonObject,"bkup_billing_group_no"));
            entity.setBkupClientBillingGroupId(getStringValue(jsonObject,"bkup_client_billing_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<StatementContactsReturnElement> buildStatementContactsReturnElement(JSONArray jsonArray) {
        ArrayList<StatementContactsReturnElement> returnElement = new ArrayList<StatementContactsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            StatementContactsReturnElement entity = new StatementContactsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setStatFirstName(getStringValue(jsonObject,"stat_first_name"));
            entity.setStatMiddleInitial(getStringValue(jsonObject,"stat_middle_initial"));
            entity.setStatLastName(getStringValue(jsonObject,"stat_last_name"));
            entity.setStatCompanyName(getStringValue(jsonObject,"stat_company_name"));
            entity.setStatAddress1(getStringValue(jsonObject,"stat_address1"));
            entity.setStatAddress2(getStringValue(jsonObject,"stat_address2"));
            entity.setStatAddress3(getStringValue(jsonObject,"stat_address3"));
            entity.setStatCity(getStringValue(jsonObject,"stat_city"));
            entity.setStatLocality(getStringValue(jsonObject,"stat_locality"));
            entity.setStatStateProv(getStringValue(jsonObject,"stat_state_prov"));
            entity.setStatCountry(getStringValue(jsonObject,"stat_country"));
            entity.setStatPostalCd(getStringValue(jsonObject,"stat_postal_cd"));
            entity.setStatPhone(getStringValue(jsonObject,"stat_phone"));
            entity.setStatPhoneExt(getStringValue(jsonObject,"stat_phone_ext"));
            entity.setStatCellPhone(getStringValue(jsonObject,"stat_cell_phone"));
            entity.setStatWorkPhone(getStringValue(jsonObject,"stat_work_phone"));
            entity.setStatWorkPhoneExt(getStringValue(jsonObject,"stat_work_phone_ext"));
            entity.setStatFax(getStringValue(jsonObject,"stat_fax"));
            entity.setStatEmail(getStringValue(jsonObject,"stat_email"));
            entity.setStatBirthdate(getStringValue(jsonObject,"stat_birthdate"));
            entity.setStatAddressVerificationCode(getStringValue(jsonObject,"stat_address_verification_code"));
            entity.setStatAddressMatchScore(getDoubleValue(jsonObject,"stat_address_match_score"));
            entity.setStatBillingGroupNo(getLongValue(jsonObject,"stat_billing_group_no"));
            entity.setStatClientBillingGroupId(getStringValue(jsonObject,"stat_client_billing_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CouponsDetailReturnElement> buildCouponsDetailReturnElement(JSONArray jsonArray) {
        ArrayList<CouponsDetailReturnElement> returnElement = new ArrayList<CouponsDetailReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponsDetailReturnElement entity = new CouponsDetailReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutClientAcctId(getStringValue(jsonObject,"out_client_acct_id"));
            entity.setOutMasterPlanInstanceNo(getLongValue(jsonObject,"out_master_plan_instance_no"));
            entity.setOutClientMasterPlanInstanceId(getStringValue(jsonObject,"out_client_master_plan_instance_id"));
            entity.setOutCouponCd(getStringValue(jsonObject,"out_coupon_cd"));
            entity.setCouponScope(getLongValue(jsonObject,"coupon_scope"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setExpDate(getStringValue(jsonObject,"exp_date"));
            entity.setMaxUses(getLongValue(jsonObject,"max_uses"));
            entity.setTotalUses(getLongValue(jsonObject,"total_uses"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRecurDiscountFlatAmt(getDoubleValue(jsonObject,"recur_discount_flat_amt"));
            entity.setOneTimeDiscountFlatAmt(getDoubleValue(jsonObject,"one_time_discount_flat_amt"));
            entity.setRecurDiscountPct(getDoubleValue(jsonObject,"recur_discount_pct"));
            entity.setOneTimeDiscountPct(getDoubleValue(jsonObject,"one_time_discount_pct"));
            entity.setStatusInd(getLongValue(jsonObject,"status_ind"));
            entity.setGroupNo(getLongValue(jsonObject,"group_no"));
            entity.setClientGroupId(getStringValue(jsonObject,"client_group_id"));
            entity.setGroupName(getStringValue(jsonObject,"group_name"));
            entity.setGroupDescription(getStringValue(jsonObject,"group_description"));
            entity.setGroupPrecedence(getLongValue(jsonObject,"group_precedence"));
                        ArrayList<CreditTemplatesReturnElement> arrayListCreditTemplatesReturnElement = buildCreditTemplatesReturnElement((JSONArray)jsonObject.get("credit_templates"));
            for (CreditTemplatesReturnElement element : arrayListCreditTemplatesReturnElement){
                entity.getCreditTemplates().add(element);
            }
                        ArrayList<DiscountRulesReturnElement> arrayListDiscountRulesReturnElement = buildDiscountRulesReturnElement((JSONArray)jsonObject.get("discount_rules"));
            for (DiscountRulesReturnElement element : arrayListDiscountRulesReturnElement){
                entity.getDiscountRules().add(element);
            }
                        ArrayList<DiscountBundlesReturnElement> arrayListDiscountBundlesReturnElement = buildDiscountBundlesReturnElement((JSONArray)jsonObject.get("discount_bundles"));
            for (DiscountBundlesReturnElement element : arrayListDiscountBundlesReturnElement){
                entity.getDiscountBundles().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllCreditsReturnElement> buildAllCreditsReturnElement(JSONArray jsonArray) {
        ArrayList<AllCreditsReturnElement> returnElement = new ArrayList<AllCreditsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllCreditsReturnElement entity = new AllCreditsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutMasterPlanInstanceNo(getLongValue(jsonObject,"out_master_plan_instance_no"));
            entity.setOutClientMpInstanceId(getStringValue(jsonObject,"out_client_mp_instance_id"));
            entity.setCreditNo(getLongValue(jsonObject,"credit_no"));
            entity.setCreatedBy(getStringValue(jsonObject,"created_by"));
            entity.setCreatedDate(getStringValue(jsonObject,"created_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCreditType(getStringValue(jsonObject,"credit_type"));
            entity.setAppliedAmount(getDoubleValue(jsonObject,"applied_amount"));
            entity.setUnappliedAmount(getDoubleValue(jsonObject,"unapplied_amount"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setReasonText(getStringValue(jsonObject,"reason_text"));
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setVoidTransactionId(getLongValue(jsonObject,"void_transaction_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<FunctionalAcctGroupReturnElement> buildFunctionalAcctGroupReturnElement(JSONArray jsonArray) {
        ArrayList<FunctionalAcctGroupReturnElement> returnElement = new ArrayList<FunctionalAcctGroupReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            FunctionalAcctGroupReturnElement entity = new FunctionalAcctGroupReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFunctionalAcctGroupNo(getLongValue(jsonObject,"functional_acct_group_no"));
            entity.setClientFunctionalAcctGroupId(getStringValue(jsonObject,"client_functional_acct_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CollectionAcctGroupReturnElement> buildCollectionAcctGroupReturnElement(JSONArray jsonArray) {
        ArrayList<CollectionAcctGroupReturnElement> returnElement = new ArrayList<CollectionAcctGroupReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CollectionAcctGroupReturnElement entity = new CollectionAcctGroupReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCollectionsAcctGroupNo(getLongValue(jsonObject,"collections_acct_group_no"));
            entity.setClientCollectionsAcctGroupId(getStringValue(jsonObject,"client_collections_acct_group_id"));
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
    public static ArrayList<AcctSurchargesInfoReturnElement> buildAcctSurchargesInfoReturnElement(JSONArray jsonArray) {
        ArrayList<AcctSurchargesInfoReturnElement> returnElement = new ArrayList<AcctSurchargesInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctSurchargesInfoReturnElement entity = new AcctSurchargesInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSurchargeNo(getLongValue(jsonObject,"surcharge_no"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctCouponsReturnElement> buildAcctCouponsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctCouponsReturnElement> returnElement = new ArrayList<AcctCouponsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctCouponsReturnElement entity = new AcctCouponsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctCouponCd(getStringValue(jsonObject,"acct_coupon_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<BillingGroupsInfoReturnElement> buildBillingGroupsInfoReturnElement(JSONArray jsonArray) {
        ArrayList<BillingGroupsInfoReturnElement> returnElement = new ArrayList<BillingGroupsInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            BillingGroupsInfoReturnElement entity = new BillingGroupsInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setBillingGroupName(getStringValue(jsonObject,"billing_group_name"));
            entity.setBillingGroupDescription(getStringValue(jsonObject,"billing_group_description"));
            entity.setClientDefBillingGroupId(getStringValue(jsonObject,"client_def_billing_group_id"));
            entity.setNotifyMethod(getLongValue(jsonObject,"notify_method"));
            entity.setNotifyTemplateGroup(getLongValue(jsonObject,"notify_template_group"));
            entity.setStatementTemplate(getLongValue(jsonObject,"statement_template"));
            entity.setCreditNoteTemplate(getLongValue(jsonObject,"credit_note_template"));
            entity.setPrimaryPaymentMethodId(getLongValue(jsonObject,"primary_payment_method_id"));
            entity.setBackupPaymentMethodId(getLongValue(jsonObject,"backup_payment_method_id"));
            entity.setStmtFirstName(getStringValue(jsonObject,"stmt_first_name"));
            entity.setStmtMi(getStringValue(jsonObject,"stmt_mi"));
            entity.setStmtLastName(getStringValue(jsonObject,"stmt_last_name"));
            entity.setStmtCompanyName(getStringValue(jsonObject,"stmt_company_name"));
            entity.setStmtAddress1(getStringValue(jsonObject,"stmt_address1"));
            entity.setStmtAddress2(getStringValue(jsonObject,"stmt_address2"));
            entity.setStmtAddress3(getStringValue(jsonObject,"stmt_address3"));
            entity.setStmtCity(getStringValue(jsonObject,"stmt_city"));
            entity.setStmtLocality(getStringValue(jsonObject,"stmt_locality"));
            entity.setStmtStateProv(getStringValue(jsonObject,"stmt_state_prov"));
            entity.setStmtCountry(getStringValue(jsonObject,"stmt_country"));
            entity.setStmtPostalCd(getStringValue(jsonObject,"stmt_postal_cd"));
            entity.setStmtPhone(getStringValue(jsonObject,"stmt_phone"));
            entity.setStmtPhoneExt(getStringValue(jsonObject,"stmt_phone_ext"));
            entity.setStmtCellPhone(getStringValue(jsonObject,"stmt_cell_phone"));
            entity.setStmtWorkPhone(getStringValue(jsonObject,"stmt_work_phone"));
            entity.setStmtWorkPhoneExt(getStringValue(jsonObject,"stmt_work_phone_ext"));
            entity.setStmtFax(getStringValue(jsonObject,"stmt_fax"));
            entity.setStmtEmail(getStringValue(jsonObject,"stmt_email"));
            entity.setStmtBirthdate(getStringValue(jsonObject,"stmt_birthdate"));
            entity.setBgListStartMasterFile(getLongValue(jsonObject,"bg_list_start_master_file"));
            entity.setStmtAddressVerificationCode(getStringValue(jsonObject,"stmt_address_verification_code"));
            entity.setStmtAddressMatchScore(getDoubleValue(jsonObject,"stmt_address_match_score"));
            entity.setClientPrimaryPaymentMethodId(getStringValue(jsonObject,"client_primary_payment_method_id"));
            entity.setClientBackupPaymentMethodId(getStringValue(jsonObject,"client_backup_payment_method_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PaymentMethodsInfoReturnElement> buildPaymentMethodsInfoReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentMethodsInfoReturnElement> returnElement = new ArrayList<PaymentMethodsInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentMethodsInfoReturnElement entity = new PaymentMethodsInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientDefBillingGroupId(getStringValue(jsonObject,"client_def_billing_group_id"));
            entity.setPaymentMethodNo(getLongValue(jsonObject,"payment_method_no"));
            entity.setBillFirstName(getStringValue(jsonObject,"bill_first_name"));
            entity.setBillMiddleInitial(getStringValue(jsonObject,"bill_middle_initial"));
            entity.setBillLastName(getStringValue(jsonObject,"bill_last_name"));
            entity.setBillCompanyName(getStringValue(jsonObject,"bill_company_name"));
            entity.setBillAddress1(getStringValue(jsonObject,"bill_address1"));
            entity.setBillAddress2(getStringValue(jsonObject,"bill_address2"));
            entity.setBillAddress3(getStringValue(jsonObject,"bill_address3"));
            entity.setBillCity(getStringValue(jsonObject,"bill_city"));
            entity.setBillLocality(getStringValue(jsonObject,"bill_locality"));
            entity.setBillStateProv(getStringValue(jsonObject,"bill_state_prov"));
            entity.setBillCountry(getStringValue(jsonObject,"bill_country"));
            entity.setBillPostalCd(getStringValue(jsonObject,"bill_postal_cd"));
            entity.setBillAddressVerificationCode(getStringValue(jsonObject,"bill_address_verification_code"));
            entity.setBillAddressMatchScore(getDoubleValue(jsonObject,"bill_address_match_score"));
            entity.setBillPhone(getStringValue(jsonObject,"bill_phone"));
            entity.setBillPhoneExt(getStringValue(jsonObject,"bill_phone_ext"));
            entity.setBillCellPhone(getStringValue(jsonObject,"bill_cell_phone"));
            entity.setBillWorkPhone(getStringValue(jsonObject,"bill_work_phone"));
            entity.setBillWorkPhoneExt(getStringValue(jsonObject,"bill_work_phone_ext"));
            entity.setBillFax(getStringValue(jsonObject,"bill_fax"));
            entity.setBillEmail(getStringValue(jsonObject,"bill_email"));
            entity.setBillBirthdate(getStringValue(jsonObject,"bill_birthdate"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setClientPaymentMethodId(getStringValue(jsonObject,"client_payment_method_id"));
            entity.setPayMethodDescription(getStringValue(jsonObject,"pay_method_description"));
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setSuffix(getStringValue(jsonObject,"suffix"));
            entity.setCcExpireMm(getLongValue(jsonObject,"cc_expire_mm"));
            entity.setCcExpireYyyy(getLongValue(jsonObject,"cc_expire_yyyy"));
            entity.setCcType(getStringValue(jsonObject,"cc_type"));
            entity.setBankRoutingNum(getStringValue(jsonObject,"bank_routing_num"));
            entity.setBillAgreementId(getStringValue(jsonObject,"bill_agreement_id"));
            entity.setIban(getStringValue(jsonObject,"iban"));
            entity.setBankSwiftCd(getStringValue(jsonObject,"bank_swift_cd"));
            entity.setBankCountryCd(getStringValue(jsonObject,"bank_country_cd"));
            entity.setMandateId(getStringValue(jsonObject,"mandate_id"));
            entity.setBankIdCd(getStringValue(jsonObject,"bank_id_cd"));
            entity.setBankBranchCd(getStringValue(jsonObject,"bank_branch_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlansInfoReturnElement> buildMasterPlansInfoReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlansInfoReturnElement> returnElement = new ArrayList<MasterPlansInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlansInfoReturnElement entity = new MasterPlansInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientMasterPlanInstanceId(getStringValue(jsonObject,"client_master_plan_instance_id"));
            entity.setClientMasterPlanId(getStringValue(jsonObject,"client_master_plan_id"));
            entity.setMasterPlanNo(getLongValue(jsonObject,"master_plan_no"));
            entity.setMasterPlanInstanceDescription(getStringValue(jsonObject,"master_plan_instance_description"));
            entity.setDunningGroupNo(getLongValue(jsonObject,"dunning_group_no"));
            entity.setClientDunningGroupId(getStringValue(jsonObject,"client_dunning_group_id"));
            entity.setDunningGroupName(getStringValue(jsonObject,"dunning_group_name"));
            entity.setDunningGroupDescription(getStringValue(jsonObject,"dunning_group_description"));
            entity.setDunningProcessNo(getLongValue(jsonObject,"dunning_process_no"));
            entity.setClientDunningProcessId(getStringValue(jsonObject,"client_dunning_process_id"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            entity.setMasterPlanInstanceStatus(getLongValue(jsonObject,"master_plan_instance_status"));
            entity.setMpInstanceStatusLabel(getStringValue(jsonObject,"mp_instance_status_label"));
            entity.setMasterPlanUnits(getLongValue(jsonObject,"master_plan_units"));
            entity.setRespLevelCd(getLongValue(jsonObject,"resp_level_cd"));
            entity.setParentMasterPlanInstNo(getLongValue(jsonObject,"parent_master_plan_inst_no"));
            entity.setAltRateScheduleNo(getLongValue(jsonObject,"alt_rate_schedule_no"));
            entity.setClientAltRateScheduleId(getStringValue(jsonObject,"client_alt_rate_schedule_id"));
            entity.setPromoCd(getStringValue(jsonObject,"promo_cd"));
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
            entity.setLastArrearsBillThruDate(getStringValue(jsonObject,"last_arrears_bill_thru_date"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setLastBillThruDate(getStringValue(jsonObject,"last_bill_thru_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setStatusDate(getStringValue(jsonObject,"status_date"));
            entity.setMasterPlanInstanceBalance(getDoubleValue(jsonObject,"master_plan_instance_balance"));
            entity.setStatusDegradeDate(getStringValue(jsonObject,"status_degrade_date"));
            entity.setRecurringBillingInterval(getLongValue(jsonObject,"recurring_billing_interval"));
            entity.setUsageBillingInterval(getLongValue(jsonObject,"usage_billing_interval"));
            entity.setInitialPlanStatus(getLongValue(jsonObject,"initial_plan_status"));
            entity.setRolloverPlanStatus(getLongValue(jsonObject,"rollover_plan_status"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setDunningState(getLongValue(jsonObject,"dunning_state"));
            entity.setDunningStep(getLongValue(jsonObject,"dunning_step"));
            entity.setDunningDegradeDate(getStringValue(jsonObject,"dunning_degrade_date"));
            entity.setPlanDeprovisionedDate(getStringValue(jsonObject,"plan_deprovisioned_date"));
                        ArrayList<CouponCodesReturnElement> arrayListCouponCodesReturnElement = buildCouponCodesReturnElement((JSONArray)jsonObject.get("coupon_codes"));
            for (CouponCodesReturnElement element : arrayListCouponCodesReturnElement){
                entity.getCouponCodes().add(element);
            }
                        ArrayList<MasterPlanProductFieldsReturnElement> arrayListMasterPlanProductFieldsReturnElement = buildMasterPlanProductFieldsReturnElement((JSONArray)jsonObject.get("master_plan_product_fields"));
            for (MasterPlanProductFieldsReturnElement element : arrayListMasterPlanProductFieldsReturnElement){
                entity.getMasterPlanProductFields().add(element);
            }
                        ArrayList<MpPlanInstFieldsReturnElement> arrayListMpPlanInstFieldsReturnElement = buildMpPlanInstFieldsReturnElement((JSONArray)jsonObject.get("mp_plan_inst_fields"));
            for (MpPlanInstFieldsReturnElement element : arrayListMpPlanInstFieldsReturnElement){
                entity.getMpPlanInstFields().add(element);
            }
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
                        ArrayList<SuppPlansInfoReturnElement> arrayListSuppPlansInfoReturnElement = buildSuppPlansInfoReturnElement((JSONArray)jsonObject.get("supp_plans_info"));
            for (SuppPlansInfoReturnElement element : arrayListSuppPlansInfoReturnElement){
                entity.getSuppPlansInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CouponCodesReturnElement> buildCouponCodesReturnElement(JSONArray jsonArray) {
        ArrayList<CouponCodesReturnElement> returnElement = new ArrayList<CouponCodesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CouponCodesReturnElement entity = new CouponCodesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCouponCodes(getStringValue(jsonObject,"coupon_codes"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlanProductFieldsReturnElement> buildMasterPlanProductFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlanProductFieldsReturnElement> returnElement = new ArrayList<MasterPlanProductFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlanProductFieldsReturnElement entity = new MasterPlanProductFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MpPlanInstFieldsReturnElement> buildMpPlanInstFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<MpPlanInstFieldsReturnElement> returnElement = new ArrayList<MpPlanInstFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MpPlanInstFieldsReturnElement entity = new MpPlanInstFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceFieldName(getStringValue(jsonObject,"plan_instance_field_name"));
            entity.setPlanInstanceFieldValue(getStringValue(jsonObject,"plan_instance_field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlansInfoReturnElement> buildSuppPlansInfoReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlansInfoReturnElement> returnElement = new ArrayList<SuppPlansInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlansInfoReturnElement entity = new SuppPlansInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSuppPlanInstanceNo(getLongValue(jsonObject,"supp_plan_instance_no"));
            entity.setClientSuppPlanInstanceId(getStringValue(jsonObject,"client_supp_plan_instance_id"));
            entity.setSuppPlanNo(getLongValue(jsonObject,"supp_plan_no"));
            entity.setClientSuppPlanId(getStringValue(jsonObject,"client_supp_plan_id"));
            entity.setSuppPlanInstanceDescription(getStringValue(jsonObject,"supp_plan_instance_description"));
            entity.setSuppPlanUnits(getLongValue(jsonObject,"supp_plan_units"));
            entity.setAltRateScheduleNo(getLongValue(jsonObject,"alt_rate_schedule_no"));
            entity.setClientAltRateScheduleId(getStringValue(jsonObject,"client_alt_rate_schedule_id"));
            entity.setLastArrearsBillThruDate(getStringValue(jsonObject,"last_arrears_bill_thru_date"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setLastBillThruDate(getStringValue(jsonObject,"last_bill_thru_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setStatusDate(getStringValue(jsonObject,"status_date"));
            entity.setSuppPlanInstanceStatusCd(getLongValue(jsonObject,"supp_plan_instance_status_cd"));
            entity.setSuppPlanInstanceStatus(getStringValue(jsonObject,"supp_plan_instance_status"));
            entity.setParentPlanInstanceNo(getLongValue(jsonObject,"parent_plan_instance_no"));
            entity.setClientParentPlanInstanceId(getStringValue(jsonObject,"client_parent_plan_instance_id"));
            entity.setRecurringBillingInterval(getLongValue(jsonObject,"recurring_billing_interval"));
            entity.setUsageBillingInterval(getLongValue(jsonObject,"usage_billing_interval"));
            entity.setRolloverPlanStatus(getLongValue(jsonObject,"rollover_plan_status"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setPlanDeprovisionedDate(getStringValue(jsonObject,"plan_deprovisioned_date"));
                        ArrayList<SuppPlanProductFieldsReturnElement> arrayListSuppPlanProductFieldsReturnElement = buildSuppPlanProductFieldsReturnElement((JSONArray)jsonObject.get("supp_plan_product_fields"));
            for (SuppPlanProductFieldsReturnElement element : arrayListSuppPlanProductFieldsReturnElement){
                entity.getSuppPlanProductFields().add(element);
            }
                        ArrayList<SuppPlanPlanInstFieldsReturnElement> arrayListSuppPlanPlanInstFieldsReturnElement = buildSuppPlanPlanInstFieldsReturnElement((JSONArray)jsonObject.get("supp_plan_plan_inst_fields"));
            for (SuppPlanPlanInstFieldsReturnElement element : arrayListSuppPlanPlanInstFieldsReturnElement){
                entity.getSuppPlanPlanInstFields().add(element);
            }
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlanProductFieldsReturnElement> buildSuppPlanProductFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlanProductFieldsReturnElement> returnElement = new ArrayList<SuppPlanProductFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlanProductFieldsReturnElement entity = new SuppPlanProductFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlanPlanInstFieldsReturnElement> buildSuppPlanPlanInstFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlanPlanInstFieldsReturnElement> returnElement = new ArrayList<SuppPlanPlanInstFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlanPlanInstFieldsReturnElement entity = new SuppPlanPlanInstFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceFieldName(getStringValue(jsonObject,"plan_instance_field_name"));
            entity.setPlanInstanceFieldValue(getStringValue(jsonObject,"plan_instance_field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<DunningGroupsReturnElement> buildDunningGroupsReturnElement(JSONArray jsonArray) {
        ArrayList<DunningGroupsReturnElement> returnElement = new ArrayList<DunningGroupsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DunningGroupsReturnElement entity = new DunningGroupsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setDunningGroupNo(getLongValue(jsonObject,"dunning_group_no"));
            entity.setDunningGroupName(getStringValue(jsonObject,"dunning_group_name"));
            entity.setDunningGroupDescription(getStringValue(jsonObject,"dunning_group_description"));
            entity.setClientDunningGroupId(getStringValue(jsonObject,"client_dunning_group_id"));
            entity.setDunningProcessNo(getLongValue(jsonObject,"dunning_process_no"));
            entity.setClientDunningProcessId(getStringValue(jsonObject,"client_dunning_process_id"));
            entity.setStatus(getLongValue(jsonObject,"status"));
                        ArrayList<MasterPlansSummaryReturnElement> arrayListMasterPlansSummaryReturnElement = buildMasterPlansSummaryReturnElement((JSONArray)jsonObject.get("master_plans_summary"));
            for (MasterPlansSummaryReturnElement element : arrayListMasterPlansSummaryReturnElement){
                entity.getMasterPlansSummary().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctHierarchyDtlsReturnElement> buildAcctHierarchyDtlsReturnElement(JSONArray jsonArray) {
        ArrayList<AcctHierarchyDtlsReturnElement> returnElement = new ArrayList<AcctHierarchyDtlsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctHierarchyDtlsReturnElement entity = new AcctHierarchyDtlsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setUserid(getStringValue(jsonObject,"userid"));
            entity.setFirstName(getStringValue(jsonObject,"first_name"));
            entity.setMiddleInitial(getStringValue(jsonObject,"middle_initial"));
            entity.setLastName(getStringValue(jsonObject,"last_name"));
            entity.setCompanyName(getStringValue(jsonObject,"company_name"));
            entity.setAddress1(getStringValue(jsonObject,"address1"));
            entity.setAddress2(getStringValue(jsonObject,"address2"));
            entity.setAddress3(getStringValue(jsonObject,"address3"));
            entity.setCity(getStringValue(jsonObject,"city"));
            entity.setLocality(getStringValue(jsonObject,"locality"));
            entity.setStateProv(getStringValue(jsonObject,"state_prov"));
            entity.setCountryCd(getStringValue(jsonObject,"country_cd"));
            entity.setPostalCd(getStringValue(jsonObject,"postal_cd"));
            entity.setPhone(getStringValue(jsonObject,"phone"));
            entity.setPhoneExt(getStringValue(jsonObject,"phone_ext"));
            entity.setCellPhone(getStringValue(jsonObject,"cell_phone"));
            entity.setWorkPhone(getStringValue(jsonObject,"work_phone"));
            entity.setWorkPhoneExt(getStringValue(jsonObject,"work_phone_ext"));
            entity.setFax(getStringValue(jsonObject,"fax"));
            entity.setEmail(getStringValue(jsonObject,"email"));
            entity.setBirthdate(getStringValue(jsonObject,"birthdate"));
            entity.setStatusCd(getLongValue(jsonObject,"status_cd"));
            entity.setNotifyMethod(getLongValue(jsonObject,"notify_method"));
            entity.setSeniorAcctNo(getLongValue(jsonObject,"senior_acct_no"));
            entity.setSeniorAcctUserId(getStringValue(jsonObject,"senior_acct_user_id"));
            entity.setSeniorClientAcctId(getStringValue(jsonObject,"senior_client_acct_id"));
            entity.setTestAcctInd(getLongValue(jsonObject,"test_acct_ind"));
            entity.setTaxpayerId(getStringValue(jsonObject,"taxpayer_id"));
            entity.setAcctStartDate(getStringValue(jsonObject,"acct_start_date"));
            entity.setAltMsgTemplateNo(getLongValue(jsonObject,"alt_msg_template_no"));
            entity.setSeqFuncGroupNo(getLongValue(jsonObject,"seq_func_group_no"));
            entity.setTaxExemptionLevel(getLongValue(jsonObject,"tax_exemption_level"));
            entity.setClientAltMsgTemplateId(getStringValue(jsonObject,"client_alt_msg_template_id"));
            entity.setListStartMasterFile(getLongValue(jsonObject,"list_start_master_file"));
            entity.setClientCnAltMsgTemplateId(getStringValue(jsonObject,"client_cn_alt_msg_template_id"));
                        ArrayList<FunctionalAcctGroupReturnElement> arrayListFunctionalAcctGroupReturnElement = buildFunctionalAcctGroupReturnElement((JSONArray)jsonObject.get("functional_acct_group"));
            for (FunctionalAcctGroupReturnElement element : arrayListFunctionalAcctGroupReturnElement){
                entity.getFunctionalAcctGroup().add(element);
            }
                        ArrayList<CollectionAcctGroupReturnElement> arrayListCollectionAcctGroupReturnElement = buildCollectionAcctGroupReturnElement((JSONArray)jsonObject.get("collection_acct_group"));
            for (CollectionAcctGroupReturnElement element : arrayListCollectionAcctGroupReturnElement){
                entity.getCollectionAcctGroup().add(element);
            }
                        ArrayList<SuppFieldReturnElement> arrayListSuppFieldReturnElement = buildSuppFieldReturnElement((JSONArray)jsonObject.get("supp_field"));
            for (SuppFieldReturnElement element : arrayListSuppFieldReturnElement){
                entity.getSuppField().add(element);
            }
                        ArrayList<AcctSurchargesInfoReturnElement> arrayListAcctSurchargesInfoReturnElement = buildAcctSurchargesInfoReturnElement((JSONArray)jsonObject.get("acct_surcharges_info"));
            for (AcctSurchargesInfoReturnElement element : arrayListAcctSurchargesInfoReturnElement){
                entity.getAcctSurchargesInfo().add(element);
            }
            entity.setAcctCurrency(getStringValue(jsonObject,"acct_currency"));
            entity.setAcctBalance(getDoubleValue(jsonObject,"acct_balance"));
            entity.setAddressVerificationCode(getStringValue(jsonObject,"address_verification_code"));
            entity.setAddressMatchScore(getDoubleValue(jsonObject,"address_match_score"));
            entity.setAcctCreateClientReceiptId(getStringValue(jsonObject,"acct_create_client_receipt_id"));
            entity.setStatusClientReceiptId(getStringValue(jsonObject,"status_client_receipt_id"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
                        ArrayList<BillingGroupsInfoReturnElement> arrayListBillingGroupsInfoReturnElement = buildBillingGroupsInfoReturnElement((JSONArray)jsonObject.get("billing_groups_info"));
            for (BillingGroupsInfoReturnElement element : arrayListBillingGroupsInfoReturnElement){
                entity.getBillingGroupsInfo().add(element);
            }
                        ArrayList<PaymentMethodsInfoReturnElement> arrayListPaymentMethodsInfoReturnElement = buildPaymentMethodsInfoReturnElement((JSONArray)jsonObject.get("payment_methods_info"));
            for (PaymentMethodsInfoReturnElement element : arrayListPaymentMethodsInfoReturnElement){
                entity.getPaymentMethodsInfo().add(element);
            }
                        ArrayList<MasterPlansInfoReturnElement> arrayListMasterPlansInfoReturnElement = buildMasterPlansInfoReturnElement((JSONArray)jsonObject.get("master_plans_info"));
            for (MasterPlansInfoReturnElement element : arrayListMasterPlansInfoReturnElement){
                entity.getMasterPlansInfo().add(element);
            }
                        ArrayList<ChildAcctNoReturnElement> arrayListChildAcctNoReturnElement = buildChildAcctNoReturnElement((JSONArray)jsonObject.get("child_acct_no"));
            for (ChildAcctNoReturnElement element : arrayListChildAcctNoReturnElement){
                entity.getChildAcctNo().add(element);
            }
            entity.setAcctLocaleNo(getLongValue(jsonObject,"acct_locale_no"));
            entity.setAcctLocaleName(getStringValue(jsonObject,"acct_locale_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AccountPaymentMethodsReturnElement> buildAccountPaymentMethodsReturnElement(JSONArray jsonArray) {
        ArrayList<AccountPaymentMethodsReturnElement> returnElement = new ArrayList<AccountPaymentMethodsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AccountPaymentMethodsReturnElement entity = new AccountPaymentMethodsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillFirstName(getStringValue(jsonObject,"bill_first_name"));
            entity.setBillMiddleInitial(getStringValue(jsonObject,"bill_middle_initial"));
            entity.setBillLastName(getStringValue(jsonObject,"bill_last_name"));
            entity.setBillCompanyName(getStringValue(jsonObject,"bill_company_name"));
            entity.setBillAddress1(getStringValue(jsonObject,"bill_address1"));
            entity.setBillAddress2(getStringValue(jsonObject,"bill_address2"));
            entity.setBillAddress3(getStringValue(jsonObject,"bill_address3"));
            entity.setBillCity(getStringValue(jsonObject,"bill_city"));
            entity.setBillLocality(getStringValue(jsonObject,"bill_locality"));
            entity.setBillStateProv(getStringValue(jsonObject,"bill_state_prov"));
            entity.setBillCountry(getStringValue(jsonObject,"bill_country"));
            entity.setBillPostalCd(getStringValue(jsonObject,"bill_postal_cd"));
            entity.setBillAddressVerificationCode(getStringValue(jsonObject,"bill_address_verification_code"));
            entity.setBillAddressMatchScore(getDoubleValue(jsonObject,"bill_address_match_score"));
            entity.setBillPhone(getStringValue(jsonObject,"bill_phone"));
            entity.setBillPhoneExt(getStringValue(jsonObject,"bill_phone_ext"));
            entity.setBillCellPhone(getStringValue(jsonObject,"bill_cell_phone"));
            entity.setBillWorkPhone(getStringValue(jsonObject,"bill_work_phone"));
            entity.setBillWorkPhoneExt(getStringValue(jsonObject,"bill_work_phone_ext"));
            entity.setBillFax(getStringValue(jsonObject,"bill_fax"));
            entity.setBillEmail(getStringValue(jsonObject,"bill_email"));
            entity.setBillBirthdate(getStringValue(jsonObject,"bill_birthdate"));
            entity.setPayMethodName(getStringValue(jsonObject,"pay_method_name"));
            entity.setClientPaymentMethodId(getStringValue(jsonObject,"client_payment_method_id"));
            entity.setPayMethodDescription(getStringValue(jsonObject,"pay_method_description"));
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setSuffix(getStringValue(jsonObject,"suffix"));
            entity.setCcExpireMm(getLongValue(jsonObject,"cc_expire_mm"));
            entity.setCcExpireYyyy(getLongValue(jsonObject,"cc_expire_yyyy"));
            entity.setCcType(getStringValue(jsonObject,"cc_type"));
            entity.setBankRoutingNum(getStringValue(jsonObject,"bank_routing_num"));
            entity.setBillAgreementId(getStringValue(jsonObject,"bill_agreement_id"));
            entity.setBankSwiftCd(getStringValue(jsonObject,"bank_swift_cd"));
            entity.setBankCountryCd(getStringValue(jsonObject,"bank_country_cd"));
            entity.setMandateId(getStringValue(jsonObject,"mandate_id"));
            entity.setBankIdCd(getStringValue(jsonObject,"bank_id_cd"));
            entity.setBankBranchCd(getStringValue(jsonObject,"bank_branch_cd"));
            entity.setStatus(getLongValue(jsonObject,"status"));
            entity.setPaymentMethodNo(getLongValue(jsonObject,"payment_method_no"));
            entity.setPersistentInd(getLongValue(jsonObject,"persistent_ind"));
            entity.setFromDate(getStringValue(jsonObject,"from_date"));
            entity.setToDate(getStringValue(jsonObject,"to_date"));
            entity.setBillInfoApiReceiptId(getStringValue(jsonObject,"bill_info_api_receipt_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanHistoryReturnElement> buildPlanHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<PlanHistoryReturnElement> returnElement = new ArrayList<PlanHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanHistoryReturnElement entity = new PlanHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setOldPlanNo(getLongValue(jsonObject,"old_plan_no"));
            entity.setNewPlanNo(getLongValue(jsonObject,"new_plan_no"));
            entity.setOldClientPlanId(getStringValue(jsonObject,"old_client_plan_id"));
            entity.setNewClientPlanId(getStringValue(jsonObject,"new_client_plan_id"));
            entity.setOldPlanName(getStringValue(jsonObject,"old_plan_name"));
            entity.setNewPlanName(getStringValue(jsonObject,"new_plan_name"));
            entity.setOldPromoCd(getStringValue(jsonObject,"old_promo_cd"));
            entity.setNewPromoCd(getStringValue(jsonObject,"new_promo_cd"));
            entity.setOldStatusCd(getLongValue(jsonObject,"old_status_cd"));
            entity.setNewStatusCd(getLongValue(jsonObject,"new_status_cd"));
            entity.setOldPlanUnits(getDoubleValue(jsonObject,"old_plan_units"));
            entity.setNewPlanUnits(getDoubleValue(jsonObject,"new_plan_units"));
            entity.setOldRateScheduleNo(getLongValue(jsonObject,"old_rate_schedule_no"));
            entity.setNewRateScheduleNo(getLongValue(jsonObject,"new_rate_schedule_no"));
            entity.setOldClientRateScheduleId(getStringValue(jsonObject,"old_client_rate_schedule_id"));
            entity.setNewClientRateScheduleId(getStringValue(jsonObject,"new_client_rate_schedule_id"));
            entity.setOldClientPlanInstanceId(getStringValue(jsonObject,"old_client_plan_instance_id"));
            entity.setNewClientPlanInstanceId(getStringValue(jsonObject,"new_client_plan_instance_id"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setOldDunningState(getLongValue(jsonObject,"old_dunning_state"));
            entity.setNewDunningState(getLongValue(jsonObject,"new_dunning_state"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllPlanInstancesReturnElement> buildAllPlanInstancesReturnElement(JSONArray jsonArray) {
        ArrayList<AllPlanInstancesReturnElement> returnElement = new ArrayList<AllPlanInstancesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllPlanInstancesReturnElement entity = new AllPlanInstancesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setQueuedInd(getStringValue(jsonObject,"queued_ind"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setParentPlanInstanceNo(getLongValue(jsonObject,"parent_plan_instance_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanType(getStringValue(jsonObject,"plan_type"));
                        ArrayList<PlanUnitInstListReturnElement> arrayListPlanUnitInstListReturnElement = buildPlanUnitInstListReturnElement((JSONArray)jsonObject.get("plan_unit_inst_list"));
            for (PlanUnitInstListReturnElement element : arrayListPlanUnitInstListReturnElement){
                entity.getPlanUnitInstList().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanUnitInstListReturnElement> buildPlanUnitInstListReturnElement(JSONArray jsonArray) {
        ArrayList<PlanUnitInstListReturnElement> returnElement = new ArrayList<PlanUnitInstListReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanUnitInstListReturnElement entity = new PlanUnitInstListReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanUnitInstNo(getLongValue(jsonObject,"plan_unit_inst_no"));
            entity.setClientPlanUnitInstId(getStringValue(jsonObject,"client_plan_unit_inst_id"));
            entity.setPlanUnitInstStatus(getStringValue(jsonObject,"plan_unit_inst_status"));
                        ArrayList<PlanUnitInstServiceDetailsReturnElement> arrayListPlanUnitInstServiceDetailsReturnElement = buildPlanUnitInstServiceDetailsReturnElement((JSONArray)jsonObject.get("plan_unit_inst_service_details"));
            for (PlanUnitInstServiceDetailsReturnElement element : arrayListPlanUnitInstServiceDetailsReturnElement){
                entity.getPlanUnitInstServiceDetails().add(element);
            }
                        ArrayList<PlanUnitInstFieldsReturnElement> arrayListPlanUnitInstFieldsReturnElement = buildPlanUnitInstFieldsReturnElement((JSONArray)jsonObject.get("plan_unit_inst_fields"));
            for (PlanUnitInstFieldsReturnElement element : arrayListPlanUnitInstFieldsReturnElement){
                entity.getPlanUnitInstFields().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanUnitInstServiceDetailsReturnElement> buildPlanUnitInstServiceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanUnitInstServiceDetailsReturnElement> returnElement = new ArrayList<PlanUnitInstServiceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanUnitInstServiceDetailsReturnElement entity = new PlanUnitInstServiceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setFulfillmentStatus(getStringValue(jsonObject,"fulfillment_status"));
            entity.setFulfillmentDate(getStringValue(jsonObject,"fulfillment_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllAcctPlansMReturnElement> buildAllAcctPlansMReturnElement(JSONArray jsonArray) {
        ArrayList<AllAcctPlansMReturnElement> returnElement = new ArrayList<AllAcctPlansMReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllAcctPlansMReturnElement entity = new AllAcctPlansMReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setPlanUnits(getLongValue(jsonObject,"plan_units"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setBillThruDate(getStringValue(jsonObject,"bill_thru_date"));
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
            entity.setRecurringBillingInterval(getLongValue(jsonObject,"recurring_billing_interval"));
            entity.setUsageBillingInterval(getLongValue(jsonObject,"usage_billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setInitialPlanStatus(getLongValue(jsonObject,"initial_plan_status"));
            entity.setRolloverPlanStatus(getLongValue(jsonObject,"rollover_plan_status"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            entity.setDunningGroupNo(getLongValue(jsonObject,"dunning_group_no"));
            entity.setClientDunningGroupId(getStringValue(jsonObject,"client_dunning_group_id"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleName(getStringValue(jsonObject,"rate_schedule_name"));
            entity.setRateSchedIsDefaultInd(getLongValue(jsonObject,"rate_sched_is_default_ind"));
            entity.setAvailableFromDate(getStringValue(jsonObject,"available_from_date"));
            entity.setAvailableToDate(getStringValue(jsonObject,"available_to_date"));
            entity.setFollowupRsNo(getLongValue(jsonObject,"followup_rs_no"));
            entity.setClientFollowupRsId(getStringValue(jsonObject,"client_followup_rs_id"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setPlanInstanceStatusCd(getLongValue(jsonObject,"plan_instance_status_cd"));
            entity.setPlanInstanceStatusLabel(getStringValue(jsonObject,"plan_instance_status_label"));
            entity.setPlanInstanceStatusDate(getStringValue(jsonObject,"plan_instance_status_date"));
            entity.setDunningState(getLongValue(jsonObject,"dunning_state"));
            entity.setDunningStep(getLongValue(jsonObject,"dunning_step"));
            entity.setDunningDegradeDate(getStringValue(jsonObject,"dunning_degrade_date"));
            entity.setPlanAssignmentDate(getStringValue(jsonObject,"plan_assignment_date"));
            entity.setPlanDeprovisionedDate(getStringValue(jsonObject,"plan_deprovisioned_date"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
                        ArrayList<ProductFieldsReturnElement> arrayListProductFieldsReturnElement = buildProductFieldsReturnElement((JSONArray)jsonObject.get("product_fields"));
            for (ProductFieldsReturnElement element : arrayListProductFieldsReturnElement){
                entity.getProductFields().add(element);
            }
                        ArrayList<PlanInstanceFieldsDetailReturnElement> arrayListPlanInstanceFieldsDetailReturnElement = buildPlanInstanceFieldsDetailReturnElement((JSONArray)jsonObject.get("plan_instance_fields_detail"));
            for (PlanInstanceFieldsDetailReturnElement element : arrayListPlanInstanceFieldsDetailReturnElement){
                entity.getPlanInstanceFieldsDetail().add(element);
            }
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientMasterPlanInstanceId(getStringValue(jsonObject,"client_master_plan_instance_id"));
            entity.setParentPlanInstanceNo(getLongValue(jsonObject,"parent_plan_instance_no"));
            entity.setClientParentPlanInstanceId(getStringValue(jsonObject,"client_parent_plan_instance_id"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
                        ArrayList<SurchargesAllReturnElement> arrayListSurchargesAllReturnElement = buildSurchargesAllReturnElement((JSONArray)jsonObject.get("surcharges_all"));
            for (SurchargesAllReturnElement element : arrayListSurchargesAllReturnElement){
                entity.getSurchargesAll().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
            entity.setContractRolloverRateSchedNo(getLongValue(jsonObject,"contract_rollover_rate_sched_no"));
            entity.setContractRolloverClientRateSchedId(getStringValue(jsonObject,"contract_rollover_client_rate_sched_id"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ProductFieldsReturnElement> buildProductFieldsReturnElement(JSONArray jsonArray) {
        ArrayList<ProductFieldsReturnElement> returnElement = new ArrayList<ProductFieldsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ProductFieldsReturnElement entity = new ProductFieldsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanInstanceFieldsDetailReturnElement> buildPlanInstanceFieldsDetailReturnElement(JSONArray jsonArray) {
        ArrayList<PlanInstanceFieldsDetailReturnElement> returnElement = new ArrayList<PlanInstanceFieldsDetailReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanInstanceFieldsDetailReturnElement entity = new PlanInstanceFieldsDetailReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctPlansMReturnElement> buildAcctPlansMReturnElement(JSONArray jsonArray) {
        ArrayList<AcctPlansMReturnElement> returnElement = new ArrayList<AcctPlansMReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctPlansMReturnElement entity = new AcctPlansMReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setPlanDate(getStringValue(jsonObject,"plan_date"));
            entity.setPlanUnits(getLongValue(jsonObject,"plan_units"));
            entity.setLastBillDate(getStringValue(jsonObject,"last_bill_date"));
            entity.setNextBillDate(getStringValue(jsonObject,"next_bill_date"));
            entity.setBillThruDate(getStringValue(jsonObject,"bill_thru_date"));
            entity.setBillDay(getLongValue(jsonObject,"bill_day"));
            entity.setRecurringBillingInterval(getLongValue(jsonObject,"recurring_billing_interval"));
            entity.setUsageBillingInterval(getLongValue(jsonObject,"usage_billing_interval"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setInitialPlanStatus(getLongValue(jsonObject,"initial_plan_status"));
            entity.setRolloverPlanStatus(getLongValue(jsonObject,"rollover_plan_status"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleName(getStringValue(jsonObject,"rate_schedule_name"));
            entity.setRateSchedIsDefaultInd(getLongValue(jsonObject,"rate_sched_is_default_ind"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setPlanInstanceStatusCd(getLongValue(jsonObject,"plan_instance_status_cd"));
            entity.setPlanInstanceStatusLabel(getStringValue(jsonObject,"plan_instance_status_label"));
            entity.setPlanInstanceStatusDate(getStringValue(jsonObject,"plan_instance_status_date"));
            entity.setDunningState(getLongValue(jsonObject,"dunning_state"));
            entity.setDunningStep(getLongValue(jsonObject,"dunning_step"));
            entity.setDunningDegradeDate(getStringValue(jsonObject,"dunning_degrade_date"));
            entity.setPlanAssignmentDate(getStringValue(jsonObject,"plan_assignment_date"));
            entity.setPlanDeprovisionedDate(getStringValue(jsonObject,"plan_deprovisioned_date"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientMasterPlanInstanceId(getStringValue(jsonObject,"client_master_plan_instance_id"));
            entity.setParentPlanInstanceNo(getLongValue(jsonObject,"parent_plan_instance_no"));
            entity.setClientParentPlanInstanceId(getStringValue(jsonObject,"client_parent_plan_instance_id"));
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
            entity.setContractRolloverRateSchedNo(getLongValue(jsonObject,"contract_rollover_rate_sched_no"));
            entity.setContractRolloverClientRateSchedId(getStringValue(jsonObject,"contract_rollover_client_rate_sched_id"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<StatementsHistoryReturnElement> buildStatementsHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<StatementsHistoryReturnElement> returnElement = new ArrayList<StatementsHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            StatementsHistoryReturnElement entity = new StatementsHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setStatementNo(getLongValue(jsonObject,"statement_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setDueDate(getStringValue(jsonObject,"due_date"));
            entity.setDueDatePlusGracePeriod(getStringValue(jsonObject,"due_date_plus_grace_period"));
            entity.setNewChargesAmount(getDoubleValue(jsonObject,"new_charges_amount"));
            entity.setNewPaymentsAmount(getDoubleValue(jsonObject,"new_payments_amount"));
            entity.setBalanceForwardAmount(getDoubleValue(jsonObject,"balance_forward_amount"));
            entity.setTotalAmount(getDoubleValue(jsonObject,"total_amount"));
            entity.setIsPaidInd(getLongValue(jsonObject,"is_paid_ind"));
            entity.setInvoiceActivityInd(getLongValue(jsonObject,"invoice_activity_ind"));
            entity.setSeqStatementId(getStringValue(jsonObject,"seq_statement_id"));
                        ArrayList<StatementMasterPlanInstancesReturnElement> arrayListStatementMasterPlanInstancesReturnElement = buildStatementMasterPlanInstancesReturnElement((JSONArray)jsonObject.get("statement_master_plan_instances"));
            for (StatementMasterPlanInstancesReturnElement element : arrayListStatementMasterPlanInstancesReturnElement){
                entity.getStatementMasterPlanInstances().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<StatementMasterPlanInstancesReturnElement> buildStatementMasterPlanInstancesReturnElement(JSONArray jsonArray) {
        ArrayList<StatementMasterPlanInstancesReturnElement> returnElement = new ArrayList<StatementMasterPlanInstancesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            StatementMasterPlanInstancesReturnElement entity = new StatementMasterPlanInstancesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientMasterPlanInstanceId(getStringValue(jsonObject,"client_master_plan_instance_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UuidInfoReturnElement> buildUuidInfoReturnElement(JSONArray jsonArray) {
        ArrayList<UuidInfoReturnElement> returnElement = new ArrayList<UuidInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UuidInfoReturnElement entity = new UuidInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPaymentMethodNo(getLongValue(jsonObject,"payment_method_no"));
            entity.setClientPaymentMethodId(getStringValue(jsonObject,"client_payment_method_id"));
            entity.setUuid(getStringValue(jsonObject,"uuid"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllAcctContractsMReturnElement> buildAllAcctContractsMReturnElement(JSONArray jsonArray) {
        ArrayList<AllAcctContractsMReturnElement> returnElement = new ArrayList<AllAcctContractsMReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllAcctContractsMReturnElement entity = new AllAcctContractsMReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractNo(getLongValue(jsonObject,"contract_no"));
            entity.setClientContractId(getStringValue(jsonObject,"client_contract_id"));
            entity.setContractScope(getStringValue(jsonObject,"contract_scope"));
            entity.setTypeNo(getLongValue(jsonObject,"type_no"));
            entity.setLengthMonths(getLongValue(jsonObject,"length_months"));
            entity.setCancelFee(getDoubleValue(jsonObject,"cancel_fee"));
            entity.setCreateComments(getStringValue(jsonObject,"create_comments"));
            entity.setUpdateComments(getStringValue(jsonObject,"update_comments"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setStartDate(getStringValue(jsonObject,"start_date"));
            entity.setEndDate(getStringValue(jsonObject,"end_date"));
            entity.setStatusCode(getLongValue(jsonObject,"status_code"));
                        ArrayList<ContractPlanInstanceInfoReturnElement> arrayListContractPlanInstanceInfoReturnElement = buildContractPlanInstanceInfoReturnElement((JSONArray)jsonObject.get("contract_plan_instance_info"));
            for (ContractPlanInstanceInfoReturnElement element : arrayListContractPlanInstanceInfoReturnElement){
                entity.getContractPlanInstanceInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ContractPlanInstanceInfoReturnElement> buildContractPlanInstanceInfoReturnElement(JSONArray jsonArray) {
        ArrayList<ContractPlanInstanceInfoReturnElement> returnElement = new ArrayList<ContractPlanInstanceInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ContractPlanInstanceInfoReturnElement entity = new ContractPlanInstanceInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setPlanInstanceStatusCd(getLongValue(jsonObject,"plan_instance_status_cd"));
            entity.setPlanInstanceStatusLabel(getStringValue(jsonObject,"plan_instance_status_label"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setRolloverClientPlanId(getStringValue(jsonObject,"rollover_client_plan_id"));
            entity.setRolloverRateSchedNo(getLongValue(jsonObject,"rollover_rate_sched_no"));
            entity.setRolloverClientRateSchedId(getStringValue(jsonObject,"rollover_client_rate_sched_id"));
                        ArrayList<ContractRolloverCustomRateInfoReturnElement> arrayListContractRolloverCustomRateInfoReturnElement = buildContractRolloverCustomRateInfoReturnElement((JSONArray)jsonObject.get("contract_rollover_custom_rate_info"));
            for (ContractRolloverCustomRateInfoReturnElement element : arrayListContractRolloverCustomRateInfoReturnElement){
                entity.getContractRolloverCustomRateInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ContractRolloverCustomRateInfoReturnElement> buildContractRolloverCustomRateInfoReturnElement(JSONArray jsonArray) {
        ArrayList<ContractRolloverCustomRateInfoReturnElement> returnElement = new ArrayList<ContractRolloverCustomRateInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ContractRolloverCustomRateInfoReturnElement entity = new ContractRolloverCustomRateInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCustomRatePlanInstanceNo(getLongValue(jsonObject,"custom_rate_plan_instance_no"));
            entity.setCustomRateClientPlanInstanceId(getStringValue(jsonObject,"custom_rate_client_plan_instance_id"));
            entity.setCustomRateServiceNo(getLongValue(jsonObject,"custom_rate_service_no"));
            entity.setCustomClientRateServiceId(getStringValue(jsonObject,"custom_client_rate_service_id"));
            entity.setCustomRateSeqNo(getStringValue(jsonObject,"custom_rate_seq_no"));
            entity.setCustomRateFromUnit(getStringValue(jsonObject,"custom_rate_from_unit"));
            entity.setCustomRateToUnit(getStringValue(jsonObject,"custom_rate_to_unit"));
            entity.setCustomRatePerUnit(getStringValue(jsonObject,"custom_rate_per_unit"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllClientPlansServicesReturnElement> buildAllClientPlansServicesReturnElement(JSONArray jsonArray) {
        ArrayList<AllClientPlansServicesReturnElement> returnElement = new ArrayList<AllClientPlansServicesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllClientPlansServicesReturnElement entity = new AllClientPlansServicesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParentPlanInstanceNo(getLongValue(jsonObject,"parent_plan_instance_no"));
            entity.setParentClientPlanInstanceId(getStringValue(jsonObject,"parent_client_plan_instance_id"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewPlanStatus(getLongValue(jsonObject,"new_plan_status"));
            entity.setRolloverPlanStatus(getLongValue(jsonObject,"rollover_plan_status"));
            entity.setRolloverPlanStatusDays(getLongValue(jsonObject,"rollover_plan_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanRateSchedulesDetailsReturnElement> buildPlanRateSchedulesDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanRateSchedulesDetailsReturnElement> returnElement = new ArrayList<PlanRateSchedulesDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanRateSchedulesDetailsReturnElement entity = new PlanRateSchedulesDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setScheduleCurrency(getStringValue(jsonObject,"schedule_currency"));
            entity.setRecurringBillingInterval(getLongValue(jsonObject,"recurring_billing_interval"));
            entity.setUsageBillingInterval(getLongValue(jsonObject,"usage_billing_interval"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            entity.setDefaultIndCurr(getLongValue(jsonObject,"default_ind_curr"));
            entity.setScheduleDisplayInd(getLongValue(jsonObject,"schedule_display_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ContractRolloverRateSchedReturnElement> buildContractRolloverRateSchedReturnElement(JSONArray jsonArray) {
        ArrayList<ContractRolloverRateSchedReturnElement> returnElement = new ArrayList<ContractRolloverRateSchedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ContractRolloverRateSchedReturnElement entity = new ContractRolloverRateSchedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setContractCurrentRateSchedNo(getLongValue(jsonObject,"contract_current_rate_sched_no"));
            entity.setContractCurrentClientRateSchedId(getStringValue(jsonObject,"contract_current_client_rate_sched_id"));
            entity.setContractRolloverRateSchedNo(getLongValue(jsonObject,"contract_rollover_rate_sched_no"));
            entity.setContractRolloverClientRateSchedId(getStringValue(jsonObject,"contract_rollover_client_rate_sched_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllClientAvailPlansReturnElement> buildAllClientAvailPlansReturnElement(JSONArray jsonArray) {
        ArrayList<AllClientAvailPlansReturnElement> returnElement = new ArrayList<AllClientAvailPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllClientAvailPlansReturnElement entity = new AllClientAvailPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setParentPlanInstanceNo(getLongValue(jsonObject,"parent_plan_instance_no"));
            entity.setParentClientPlanInstanceId(getStringValue(jsonObject,"parent_client_plan_instance_id"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewPlanStatus(getLongValue(jsonObject,"new_plan_status"));
            entity.setRolloverPlanStatus(getLongValue(jsonObject,"rollover_plan_status"));
            entity.setRolloverPlanStatusDays(getLongValue(jsonObject,"rollover_plan_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setClientPlan2AssignOnSusp(getStringValue(jsonObject,"client_plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CashCreditsReturnElement> buildCashCreditsReturnElement(JSONArray jsonArray) {
        ArrayList<CashCreditsReturnElement> returnElement = new ArrayList<CashCreditsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CashCreditsReturnElement entity = new CashCreditsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCreditNo(getLongValue(jsonObject,"credit_no"));
            entity.setCreatedBy(getStringValue(jsonObject,"created_by"));
            entity.setCreatedDate(getStringValue(jsonObject,"created_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setReasonText(getStringValue(jsonObject,"reason_text"));
                        ArrayList<AppliedCashCreditsReturnElement> arrayListAppliedCashCreditsReturnElement = buildAppliedCashCreditsReturnElement((JSONArray)jsonObject.get("applied_cash_credits"));
            for (AppliedCashCreditsReturnElement element : arrayListAppliedCashCreditsReturnElement){
                entity.getAppliedCashCredits().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AppliedCashCreditsReturnElement> buildAppliedCashCreditsReturnElement(JSONArray jsonArray) {
        ArrayList<AppliedCashCreditsReturnElement> returnElement = new ArrayList<AppliedCashCreditsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AppliedCashCreditsReturnElement entity = new AppliedCashCreditsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setTransactionName(getStringValue(jsonObject,"transaction_name"));
            entity.setAppliedTransactionId(getLongValue(jsonObject,"applied_transaction_id"));
            entity.setAppliedAmount(getDoubleValue(jsonObject,"applied_amount"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<FamTransactionsReturnElement> buildFamTransactionsReturnElement(JSONArray jsonArray) {
        ArrayList<FamTransactionsReturnElement> returnElement = new ArrayList<FamTransactionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            FamTransactionsReturnElement entity = new FamTransactionsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientMasterPlanInstanceId(getStringValue(jsonObject,"client_master_plan_instance_id"));
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setTransactionDesc(getStringValue(jsonObject,"transaction_desc"));
            entity.setTransactionAmt(getDoubleValue(jsonObject,"transaction_amt"));
            entity.setTransactionAppliedAmt(getDoubleValue(jsonObject,"transaction_applied_amt"));
            entity.setTransactionCurrency(getStringValue(jsonObject,"transaction_currency"));
            entity.setTransactionCreateDate(getStringValue(jsonObject,"transaction_create_date"));
            entity.setTransactionVoidDate(getStringValue(jsonObject,"transaction_void_date"));
            entity.setTransactionStmtNo(getLongValue(jsonObject,"transaction_stmt_no"));
            entity.setTransactionVoidReason(getStringValue(jsonObject,"transaction_void_reason"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setTransactionComments(getStringValue(jsonObject,"transaction_comments"));
            entity.setTransactionSourceId(getLongValue(jsonObject,"transaction_source_id"));
            entity.setTransactionRefCode(getStringValue(jsonObject,"transaction_ref_code"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setCsrComments(getStringValue(jsonObject,"csr_comments"));
            entity.setTransactionSeqStmtId(getStringValue(jsonObject,"transaction_seq_stmt_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ContractPlanInstanceDetailsReturnElement> buildContractPlanInstanceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<ContractPlanInstanceDetailsReturnElement> returnElement = new ArrayList<ContractPlanInstanceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ContractPlanInstanceDetailsReturnElement entity = new ContractPlanInstanceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setPlanInstanceStatusCd(getLongValue(jsonObject,"plan_instance_status_cd"));
            entity.setPlanInstanceStatusLabel(getStringValue(jsonObject,"plan_instance_status_label"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setRolloverClientPlanId(getStringValue(jsonObject,"rollover_client_plan_id"));
            entity.setRolloverRateSchedNo(getLongValue(jsonObject,"rollover_rate_sched_no"));
            entity.setRolloverClientRateSchedId(getStringValue(jsonObject,"rollover_client_rate_sched_id"));
                        ArrayList<ContractRolloverCustomRateInfoReturnElement> arrayListContractRolloverCustomRateInfoReturnElement = buildContractRolloverCustomRateInfoReturnElement((JSONArray)jsonObject.get("contract_rollover_custom_rate_info"));
            for (ContractRolloverCustomRateInfoReturnElement element : arrayListContractRolloverCustomRateInfoReturnElement){
                entity.getContractRolloverCustomRateInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceHistReturnElement> buildInvoiceHistReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceHistReturnElement> returnElement = new ArrayList<InvoiceHistReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceHistReturnElement entity = new InvoiceHistReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setOutacctNo(getLongValue(jsonObject,"outacct_no"));
            entity.setOutclientAcctId(getStringValue(jsonObject,"outclient_acct_id"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            entity.setMasterPlanNo(getLongValue(jsonObject,"master_plan_no"));
            entity.setMasterPlanName(getStringValue(jsonObject,"master_plan_name"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setBillDate(getStringValue(jsonObject,"bill_date"));
            entity.setPaidDate(getStringValue(jsonObject,"paid_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCredit(getDoubleValue(jsonObject,"credit"));
            entity.setRecurringBillFrom(getStringValue(jsonObject,"recurring_bill_from"));
            entity.setRecurringBillThru(getStringValue(jsonObject,"recurring_bill_thru"));
            entity.setUsageBillFrom(getStringValue(jsonObject,"usage_bill_from"));
            entity.setUsageBillThru(getStringValue(jsonObject,"usage_bill_thru"));
            entity.setIsVoidedInd(getLongValue(jsonObject,"is_voided_ind"));
            entity.setClientMasterPlanId(getStringValue(jsonObject,"client_master_plan_id"));
            entity.setInvoiceTypeCd(getStringValue(jsonObject,"invoice_type_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PendingInvoiceReturnElement> buildPendingInvoiceReturnElement(JSONArray jsonArray) {
        ArrayList<PendingInvoiceReturnElement> returnElement = new ArrayList<PendingInvoiceReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PendingInvoiceReturnElement entity = new PendingInvoiceReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setAcctNo(getLongValue(jsonObject,"acct_no"));
            entity.setClientMasterPlanInstanceId(getStringValue(jsonObject,"client_master_plan_instance_id"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllPlanDetailsReturnElement> buildAllPlanDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<AllPlanDetailsReturnElement> returnElement = new ArrayList<AllPlanDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllPlanDetailsReturnElement entity = new AllPlanDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
            entity.setNsoInclListScope(getLongValue(jsonObject,"nso_incl_list_scope"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
                        ArrayList<PlanNsoItemsReturnElement> arrayListPlanNsoItemsReturnElement = buildPlanNsoItemsReturnElement((JSONArray)jsonObject.get("plan_nso_items"));
            for (PlanNsoItemsReturnElement element : arrayListPlanNsoItemsReturnElement){
                entity.getPlanNsoItems().add(element);
            }
                        ArrayList<PlanNsoGroupReturnElement> arrayListPlanNsoGroupReturnElement = buildPlanNsoGroupReturnElement((JSONArray)jsonObject.get("plan_nso_group"));
            for (PlanNsoGroupReturnElement element : arrayListPlanNsoGroupReturnElement){
                entity.getPlanNsoGroup().add(element);
            }
            entity.setNsoGroupMinQty(getStringValue(jsonObject,"nso_group_min_qty"));
            entity.setNsoGroupMaxQty(getStringValue(jsonObject,"nso_group_max_qty"));
            entity.setNsoGroupItemScope(getStringValue(jsonObject,"nso_group_item_scope"));
                        ArrayList<PlanNsoInclListReturnElement> arrayListPlanNsoInclListReturnElement = buildPlanNsoInclListReturnElement((JSONArray)jsonObject.get("plan_nso_incl_list"));
            for (PlanNsoInclListReturnElement element : arrayListPlanNsoInclListReturnElement){
                entity.getPlanNsoInclList().add(element);
            }
                        ArrayList<PlanTranslationDetailsReturnElement> arrayListPlanTranslationDetailsReturnElement = buildPlanTranslationDetailsReturnElement((JSONArray)jsonObject.get("plan_translation_details"));
            for (PlanTranslationDetailsReturnElement element : arrayListPlanTranslationDetailsReturnElement){
                entity.getPlanTranslationDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNsoItemsReturnElement> buildPlanNsoItemsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNsoItemsReturnElement> returnElement = new ArrayList<PlanNsoItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNsoItemsReturnElement entity = new PlanNsoItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setMinQty(getStringValue(jsonObject,"min_qty"));
            entity.setMaxQty(getStringValue(jsonObject,"max_qty"));
            entity.setItemScope(getLongValue(jsonObject,"item_scope"));
                        ArrayList<PlanNsoPriceOverrideReturnElement> arrayListPlanNsoPriceOverrideReturnElement = buildPlanNsoPriceOverrideReturnElement((JSONArray)jsonObject.get("plan_nso_price_override"));
            for (PlanNsoPriceOverrideReturnElement element : arrayListPlanNsoPriceOverrideReturnElement){
                entity.getPlanNsoPriceOverride().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNsoPriceOverrideReturnElement> buildPlanNsoPriceOverrideReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNsoPriceOverrideReturnElement> returnElement = new ArrayList<PlanNsoPriceOverrideReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNsoPriceOverrideReturnElement entity = new PlanNsoPriceOverrideReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setOverridePrice(getStringValue(jsonObject,"override_price"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNsoGroupReturnElement> buildPlanNsoGroupReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNsoGroupReturnElement> returnElement = new ArrayList<PlanNsoGroupReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNsoGroupReturnElement entity = new PlanNsoGroupReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
                        ArrayList<PlanNsoGroupPriceOverrideReturnElement> arrayListPlanNsoGroupPriceOverrideReturnElement = buildPlanNsoGroupPriceOverrideReturnElement((JSONArray)jsonObject.get("plan_nso_group_price_override"));
            for (PlanNsoGroupPriceOverrideReturnElement element : arrayListPlanNsoGroupPriceOverrideReturnElement){
                entity.getPlanNsoGroupPriceOverride().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNsoGroupPriceOverrideReturnElement> buildPlanNsoGroupPriceOverrideReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNsoGroupPriceOverrideReturnElement> returnElement = new ArrayList<PlanNsoGroupPriceOverrideReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNsoGroupPriceOverrideReturnElement entity = new PlanNsoGroupPriceOverrideReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setOverridePrice(getStringValue(jsonObject,"override_price"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanNsoInclListReturnElement> buildPlanNsoInclListReturnElement(JSONArray jsonArray) {
        ArrayList<PlanNsoInclListReturnElement> returnElement = new ArrayList<PlanNsoInclListReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanNsoInclListReturnElement entity = new PlanNsoInclListReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanTranslationDetailsReturnElement> buildPlanTranslationDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanTranslationDetailsReturnElement> returnElement = new ArrayList<PlanTranslationDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanTranslationDetailsReturnElement entity = new PlanTranslationDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
                        ArrayList<RateSchedsTReturnElement> arrayListRateSchedsTReturnElement = buildRateSchedsTReturnElement((JSONArray)jsonObject.get("rate_scheds_t"));
            for (RateSchedsTReturnElement element : arrayListRateSchedsTReturnElement){
                entity.getRateSchedsT().add(element);
            }
                        ArrayList<PlanServicesTReturnElement> arrayListPlanServicesTReturnElement = buildPlanServicesTReturnElement((JSONArray)jsonObject.get("plan_services_t"));
            for (PlanServicesTReturnElement element : arrayListPlanServicesTReturnElement){
                entity.getPlanServicesT().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RateSchedsTReturnElement> buildRateSchedsTReturnElement(JSONArray jsonArray) {
        ArrayList<RateSchedsTReturnElement> returnElement = new ArrayList<RateSchedsTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RateSchedsTReturnElement entity = new RateSchedsTReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanServicesTReturnElement> buildPlanServicesTReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServicesTReturnElement> returnElement = new ArrayList<PlanServicesTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServicesTReturnElement entity = new PlanServicesTReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanDetailsReturnElement> buildPlanDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanDetailsReturnElement> returnElement = new ArrayList<PlanDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanDetailsReturnElement entity = new PlanDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
                        ArrayList<PlanTranslationInfoReturnElement> arrayListPlanTranslationInfoReturnElement = buildPlanTranslationInfoReturnElement((JSONArray)jsonObject.get("plan_translation_info"));
            for (PlanTranslationInfoReturnElement element : arrayListPlanTranslationInfoReturnElement){
                entity.getPlanTranslationInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanTranslationInfoReturnElement> buildPlanTranslationInfoReturnElement(JSONArray jsonArray) {
        ArrayList<PlanTranslationInfoReturnElement> returnElement = new ArrayList<PlanTranslationInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanTranslationInfoReturnElement entity = new PlanTranslationInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
                        ArrayList<RateSchedsTReturnElement> arrayListRateSchedsTReturnElement = buildRateSchedsTReturnElement((JSONArray)jsonObject.get("rate_scheds_t"));
            for (RateSchedsTReturnElement element : arrayListRateSchedsTReturnElement){
                entity.getRateSchedsT().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<QueuedPlanInstanceDetailsReturnElement> buildQueuedPlanInstanceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<QueuedPlanInstanceDetailsReturnElement> returnElement = new ArrayList<QueuedPlanInstanceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            QueuedPlanInstanceDetailsReturnElement entity = new QueuedPlanInstanceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOriginalPlan(getStringValue(jsonObject,"original_plan"));
            entity.setOriginalPlanNo(getLongValue(jsonObject,"original_plan_no"));
            entity.setNewPlan(getStringValue(jsonObject,"new_plan"));
            entity.setNewPlanNo(getLongValue(jsonObject,"new_plan_no"));
            entity.setChangeDate(getStringValue(jsonObject,"change_date"));
            entity.setNewRateScheduleNo(getLongValue(jsonObject,"new_rate_schedule_no"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setNewPlanUnits(getDoubleValue(jsonObject,"new_plan_units"));
            entity.setNewPlanType(getStringValue(jsonObject,"new_plan_type"));
            entity.setClientOriginalPlanId(getStringValue(jsonObject,"client_original_plan_id"));
            entity.setClientNewPlanId(getStringValue(jsonObject,"client_new_plan_id"));
            entity.setClientNewRateScheduleId(getStringValue(jsonObject,"client_new_rate_schedule_id"));
            entity.setCurrentRateScheduleNo(getLongValue(jsonObject,"current_rate_schedule_no"));
            entity.setClientCurrentRateScheduleId(getStringValue(jsonObject,"client_current_rate_schedule_id"));
                        ArrayList<CustomRateReturnElement> arrayListCustomRateReturnElement = buildCustomRateReturnElement((JSONArray)jsonObject.get("custom_rate"));
            for (CustomRateReturnElement element : arrayListCustomRateReturnElement){
                entity.getCustomRate().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RateSchedsReturnElement> buildRateSchedsReturnElement(JSONArray jsonArray) {
        ArrayList<RateSchedsReturnElement> returnElement = new ArrayList<RateSchedsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RateSchedsReturnElement entity = new RateSchedsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setScheduleNo(getLongValue(jsonObject,"schedule_no"));
            entity.setScheduleName(getStringValue(jsonObject,"schedule_name"));
            entity.setScheduleCurrency(getStringValue(jsonObject,"schedule_currency"));
            entity.setRecurringBillingInterval(getLongValue(jsonObject,"recurring_billing_interval"));
            entity.setUsageBillingInterval(getLongValue(jsonObject,"usage_billing_interval"));
            entity.setDefaultInd(getLongValue(jsonObject,"default_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setDefaultIndCurr(getLongValue(jsonObject,"default_ind_curr"));
            entity.setClientRateScheduleId(getStringValue(jsonObject,"client_rate_schedule_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<RecurringCreditsDetailsReturnElement> buildRecurringCreditsDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<RecurringCreditsDetailsReturnElement> returnElement = new ArrayList<RecurringCreditsDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            RecurringCreditsDetailsReturnElement entity = new RecurringCreditsDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutMasterPlanInstanceNo(getLongValue(jsonObject,"out_master_plan_instance_no"));
            entity.setOutClientMpInstanceId(getStringValue(jsonObject,"out_client_mp_instance_id"));
            entity.setRecurringCreditNo(getLongValue(jsonObject,"recurring_credit_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCreateUser(getStringValue(jsonObject,"create_user"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setUpdateUser(getStringValue(jsonObject,"update_user"));
            entity.setFirstCreditDate(getStringValue(jsonObject,"first_credit_date"));
            entity.setLastCreditDate(getStringValue(jsonObject,"last_credit_date"));
            entity.setNextCreditDate(getStringValue(jsonObject,"next_credit_date"));
            entity.setCreditAmount(getDoubleValue(jsonObject,"credit_amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setCreditsCompleted(getLongValue(jsonObject,"credits_completed"));
            entity.setCreditsRemaining(getLongValue(jsonObject,"credits_remaining"));
            entity.setCreditIntervalMonths(getLongValue(jsonObject,"credit_interval_months"));
            entity.setEligiblePlanNo(getLongValue(jsonObject,"eligible_plan_no"));
            entity.setEligiblePlanName(getStringValue(jsonObject,"eligible_plan_name"));
            entity.setEligibleServiceNo(getLongValue(jsonObject,"eligible_service_no"));
            entity.setEligibleServiceName(getStringValue(jsonObject,"eligible_service_name"));
            entity.setServiceNoToApply(getLongValue(jsonObject,"service_no_to_apply"));
            entity.setServiceNameToApply(getStringValue(jsonObject,"service_name_to_apply"));
            entity.setCreditStatusCd(getLongValue(jsonObject,"credit_status_cd"));
            entity.setCreditStatusLabel(getStringValue(jsonObject,"credit_status_label"));
            entity.setCreditReasonCd(getLongValue(jsonObject,"credit_reason_cd"));
            entity.setCreditReasonText(getStringValue(jsonObject,"credit_reason_text"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setCancelDate(getStringValue(jsonObject,"cancel_date"));
            entity.setCancelUser(getStringValue(jsonObject,"cancel_user"));
            entity.setCancelComments(getStringValue(jsonObject,"cancel_comments"));
            entity.setClientEligiblePlanId(getStringValue(jsonObject,"client_eligible_plan_id"));
            entity.setClientEligibleServiceId(getStringValue(jsonObject,"client_eligible_service_id"));
            entity.setClientServiceIdToApply(getStringValue(jsonObject,"client_service_id_to_apply"));
                        ArrayList<EligibleServiceTypesReturnElement> arrayListEligibleServiceTypesReturnElement = buildEligibleServiceTypesReturnElement((JSONArray)jsonObject.get("eligible_service_types"));
            for (EligibleServiceTypesReturnElement element : arrayListEligibleServiceTypesReturnElement){
                entity.getEligibleServiceTypes().add(element);
            }
                        ArrayList<EligibleServicePlanDetailsReturnElement> arrayListEligibleServicePlanDetailsReturnElement = buildEligibleServicePlanDetailsReturnElement((JSONArray)jsonObject.get("eligible_service_plan_details"));
            for (EligibleServicePlanDetailsReturnElement element : arrayListEligibleServicePlanDetailsReturnElement){
                entity.getEligibleServicePlanDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlansDetailsReturnElement> buildPlansDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<PlansDetailsReturnElement> returnElement = new ArrayList<PlansDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlansDetailsReturnElement entity = new PlansDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
                        ArrayList<PlanTranslationInfoReturnElement> arrayListPlanTranslationInfoReturnElement = buildPlanTranslationInfoReturnElement((JSONArray)jsonObject.get("plan_translation_info"));
            for (PlanTranslationInfoReturnElement element : arrayListPlanTranslationInfoReturnElement){
                entity.getPlanTranslationInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UnappliedServiceCreditsDetailsReturnElement> buildUnappliedServiceCreditsDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<UnappliedServiceCreditsDetailsReturnElement> returnElement = new ArrayList<UnappliedServiceCreditsDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UnappliedServiceCreditsDetailsReturnElement entity = new UnappliedServiceCreditsDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCreditId(getLongValue(jsonObject,"credit_id"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setCreateUser(getStringValue(jsonObject,"create_user"));
            entity.setInitialAmount(getDoubleValue(jsonObject,"initial_amount"));
            entity.setAmountLeftToApply(getDoubleValue(jsonObject,"amount_left_to_apply"));
            entity.setReasonCd(getLongValue(jsonObject,"reason_cd"));
            entity.setReasonText(getStringValue(jsonObject,"reason_text"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setServiceNoToApply(getLongValue(jsonObject,"service_no_to_apply"));
            entity.setServiceNameToApply(getStringValue(jsonObject,"service_name_to_apply"));
            entity.setEligiblePlanNo(getLongValue(jsonObject,"eligible_plan_no"));
            entity.setEligiblePlanName(getStringValue(jsonObject,"eligible_plan_name"));
            entity.setEligibleServiceNo(getLongValue(jsonObject,"eligible_service_no"));
            entity.setEligibleServiceName(getStringValue(jsonObject,"eligible_service_name"));
            entity.setClientServiceIdToApply(getStringValue(jsonObject,"client_service_id_to_apply"));
            entity.setClientEligiblePlanId(getStringValue(jsonObject,"client_eligible_plan_id"));
            entity.setClientEligibleServiceId(getStringValue(jsonObject,"client_eligible_service_id"));
            entity.setAmountReservedForAnniversary(getLongValue(jsonObject,"amount_reserved_for_anniversary"));
                        ArrayList<EligibleServiceTypesReturnElement> arrayListEligibleServiceTypesReturnElement = buildEligibleServiceTypesReturnElement((JSONArray)jsonObject.get("eligible_service_types"));
            for (EligibleServiceTypesReturnElement element : arrayListEligibleServiceTypesReturnElement){
                entity.getEligibleServiceTypes().add(element);
            }
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutMasterPlanInstanceNo(getLongValue(jsonObject,"out_master_plan_instance_no"));
            entity.setOutClientMpInstanceId(getStringValue(jsonObject,"out_client_mp_instance_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UnbilledUsageRecReturnElement> buildUnbilledUsageRecReturnElement(JSONArray jsonArray) {
        ArrayList<UnbilledUsageRecReturnElement> returnElement = new ArrayList<UnbilledUsageRecReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UnbilledUsageRecReturnElement entity = new UnbilledUsageRecReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceId(getLongValue(jsonObject,"plan_instance_id"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeDescription(getStringValue(jsonObject,"usage_type_description"));
            entity.setUsageDate(getStringValue(jsonObject,"usage_date"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setSpecificRecordChargeAmount(getDoubleValue(jsonObject,"specific_record_charge_amount"));
            entity.setPreRatedRate(getDoubleValue(jsonObject,"pre_rated_rate"));
            entity.setRecordedUnits(getDoubleValue(jsonObject,"recorded_units"));
            entity.setUsageParentRecNo(getLongValue(jsonObject,"usage_parent_rec_no"));
            entity.setUsageTypeCode(getStringValue(jsonObject,"usage_type_code"));
            entity.setExcludeReasonCd(getLongValue(jsonObject,"exclude_reason_cd"));
            entity.setUsageRecNo(getLongValue(jsonObject,"usage_rec_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UsageHistoryRecsReturnElement> buildUsageHistoryRecsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageHistoryRecsReturnElement> returnElement = new ArrayList<UsageHistoryRecsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageHistoryRecsReturnElement entity = new UsageHistoryRecsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillableAcctNo(getLongValue(jsonObject,"billable_acct_no"));
            entity.setIncurringAcctNo(getLongValue(jsonObject,"incurring_acct_no"));
            entity.setClientBillableAcctId(getStringValue(jsonObject,"client_billable_acct_id"));
            entity.setClientIncurringAcctId(getStringValue(jsonObject,"client_incurring_acct_id"));
            entity.setPlanInstanceId(getLongValue(jsonObject,"plan_instance_id"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeDescription(getStringValue(jsonObject,"usage_type_description"));
            entity.setUsageDate(getStringValue(jsonObject,"usage_date"));
            entity.setUsageTime(getStringValue(jsonObject,"usage_time"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setUnitsDescription(getStringValue(jsonObject,"units_description"));
            entity.setUsageUnitsDescription(getStringValue(jsonObject,"usage_units_description"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setTelcoTo(getStringValue(jsonObject,"telco_to"));
            entity.setTelcoFrom(getStringValue(jsonObject,"telco_from"));
            entity.setSpecificRecordChargeAmount(getDoubleValue(jsonObject,"specific_record_charge_amount"));
            entity.setIsExcluded(getStringValue(jsonObject,"is_excluded"));
            entity.setExclusionComments(getStringValue(jsonObject,"exclusion_comments"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setPreRatedRate(getDoubleValue(jsonObject,"pre_rated_rate"));
            entity.setQualifier1(getStringValue(jsonObject,"qualifier_1"));
            entity.setQualifier2(getStringValue(jsonObject,"qualifier_2"));
            entity.setQualifier3(getStringValue(jsonObject,"qualifier_3"));
            entity.setQualifier4(getStringValue(jsonObject,"qualifier_4"));
            entity.setRecordedUnits(getDoubleValue(jsonObject,"recorded_units"));
            entity.setUsageRecNo(getLongValue(jsonObject,"usage_rec_no"));
            entity.setUsageParentRecNo(getLongValue(jsonObject,"usage_parent_rec_no"));
            entity.setUsageTypeCode(getStringValue(jsonObject,"usage_type_code"));
            entity.setClientRecordId(getStringValue(jsonObject,"client_record_id"));
            entity.setExcludeReasonCd(getLongValue(jsonObject,"exclude_reason_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UsageSummaryRecsReturnElement> buildUsageSummaryRecsReturnElement(JSONArray jsonArray) {
        ArrayList<UsageSummaryRecsReturnElement> returnElement = new ArrayList<UsageSummaryRecsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UsageSummaryRecsReturnElement entity = new UsageSummaryRecsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOutAcctNo(getLongValue(jsonObject,"out_acct_no"));
            entity.setOutClientAcctId(getStringValue(jsonObject,"out_client_acct_id"));
            entity.setOutPlanInstanceNo(getLongValue(jsonObject,"out_plan_instance_no"));
            entity.setOutPlanInstanceCdid(getStringValue(jsonObject,"out_plan_instance_cdid"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeLabel(getStringValue(jsonObject,"usage_type_label"));
            entity.setBilledInd(getLongValue(jsonObject,"billed_ind"));
            entity.setTotalUnits(getDoubleValue(jsonObject,"total_units"));
            entity.setTotalValueAmount(getDoubleValue(jsonObject,"total_value_amount"));
            entity.setTotalValueCurrencyCode(getStringValue(jsonObject,"total_value_currency_code"));
            entity.setLastUsageDate(getStringValue(jsonObject,"last_usage_date"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceLineItemReturnElement> buildInvoiceLineItemReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceLineItemReturnElement> returnElement = new ArrayList<InvoiceLineItemReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceLineItemReturnElement entity = new InvoiceLineItemReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setLineBaseUnits(getDoubleValue(jsonObject,"line_base_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlansUpdatedReturnElement> buildPlansUpdatedReturnElement(JSONArray jsonArray) {
        ArrayList<PlansUpdatedReturnElement> returnElement = new ArrayList<PlansUpdatedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlansUpdatedReturnElement entity = new PlansUpdatedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanOperation(getLongValue(jsonObject,"plan_operation"));
                        ArrayList<PlanUnitInstanceDetailsReturnElement> arrayListPlanUnitInstanceDetailsReturnElement = buildPlanUnitInstanceDetailsReturnElement((JSONArray)jsonObject.get("plan_unit_instance_details"));
            for (PlanUnitInstanceDetailsReturnElement element : arrayListPlanUnitInstanceDetailsReturnElement){
                entity.getPlanUnitInstanceDetails().add(element);
            }
                        ArrayList<PlanServiceProrationResultsReturnElement> arrayListPlanServiceProrationResultsReturnElement = buildPlanServiceProrationResultsReturnElement((JSONArray)jsonObject.get("plan_service_proration_results"));
            for (PlanServiceProrationResultsReturnElement element : arrayListPlanServiceProrationResultsReturnElement){
                entity.getPlanServiceProrationResults().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanServiceProrationResultsReturnElement> buildPlanServiceProrationResultsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServiceProrationResultsReturnElement> returnElement = new ArrayList<PlanServiceProrationResultsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServiceProrationResultsReturnElement entity = new PlanServiceProrationResultsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setProrationText(getStringValue(jsonObject,"proration_text"));
            entity.setProrationRemainingDays(getLongValue(jsonObject,"proration_remaining_days"));
            entity.setProrationDescription(getStringValue(jsonObject,"proration_description"));
            entity.setProrationResultTotal(getDoubleValue(jsonObject,"proration_result_total"));
            entity.setProrationAmount(getDoubleValue(jsonObject,"proration_amount"));
            entity.setProrationTaxCharges(getDoubleValue(jsonObject,"proration_tax_charges"));
            entity.setProrationTaxCredits(getDoubleValue(jsonObject,"proration_tax_credits"));
            entity.setProrationSurchargeAmount(getDoubleValue(jsonObject,"proration_surcharge_amount"));
            entity.setProrationCreditAmount(getDoubleValue(jsonObject,"proration_credit_amount"));
            entity.setProrationStartDate(getStringValue(jsonObject,"proration_start_date"));
            entity.setProrationEndDate(getStringValue(jsonObject,"proration_end_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<BillingGroupsUpdatedReturnElement> buildBillingGroupsUpdatedReturnElement(JSONArray jsonArray) {
        ArrayList<BillingGroupsUpdatedReturnElement> returnElement = new ArrayList<BillingGroupsUpdatedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            BillingGroupsUpdatedReturnElement entity = new BillingGroupsUpdatedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupsId(getStringValue(jsonObject,"client_billing_groups_id"));
            entity.setPrimaryPaymentMethodNo(getLongValue(jsonObject,"primary_payment_method_no"));
            entity.setPrimaryClientPaymentMethodId(getStringValue(jsonObject,"primary_client_payment_method_id"));
            entity.setBackupPaymentMethodNo(getLongValue(jsonObject,"backup_payment_method_no"));
            entity.setBackupClientPaymentMethodId(getStringValue(jsonObject,"backup_client_payment_method_id"));
            entity.setBillingGroupOperation(getLongValue(jsonObject,"billing_group_operation"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<DunningGroupsUpdatedReturnElement> buildDunningGroupsUpdatedReturnElement(JSONArray jsonArray) {
        ArrayList<DunningGroupsUpdatedReturnElement> returnElement = new ArrayList<DunningGroupsUpdatedReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            DunningGroupsUpdatedReturnElement entity = new DunningGroupsUpdatedReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setDunningGroupNo(getLongValue(jsonObject,"dunning_group_no"));
            entity.setClientDunningGroupsId(getStringValue(jsonObject,"client_dunning_groups_id"));
            entity.setDunningGroupOperation(getLongValue(jsonObject,"dunning_group_operation"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MultiPlanInvoiceDetailsReturnElement> buildMultiPlanInvoiceDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<MultiPlanInvoiceDetailsReturnElement> returnElement = new ArrayList<MultiPlanInvoiceDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MultiPlanInvoiceDetailsReturnElement entity = new MultiPlanInvoiceDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setProcCvvResponse(getStringValue(jsonObject,"proc_cvv_response"));
            entity.setProcAvsResponse(getLongValue(jsonObject,"proc_avs_response"));
            entity.setProcCavvResponse(getLongValue(jsonObject,"proc_cavv_response"));
            entity.setProcStatusCode(getStringValue(jsonObject,"proc_status_code"));
            entity.setProcStatusText(getLongValue(jsonObject,"proc_status_text"));
            entity.setProcPaymentId(getStringValue(jsonObject,"proc_payment_id"));
            entity.setProcAuthCode(getLongValue(jsonObject,"proc_auth_code"));
            entity.setProcMerchComments(getStringValue(jsonObject,"proc_merch_comments"));
            entity.setInvoiceChargesBeforeTax(getDoubleValue(jsonObject,"invoice_charges_before_tax"));
            entity.setInvoiceTaxCharges(getDoubleValue(jsonObject,"invoice_tax_charges"));
            entity.setInvoiceChargesAfterTax(getDoubleValue(jsonObject,"invoice_charges_after_tax"));
            entity.setInvoiceCreditBeforeTax(getDoubleValue(jsonObject,"invoice_credit_before_tax"));
            entity.setInvoiceTaxCredits(getDoubleValue(jsonObject,"invoice_tax_credits"));
            entity.setInvoiceCredits(getDoubleValue(jsonObject,"invoice_credits"));
            entity.setInvoiceTotalAmount(getDoubleValue(jsonObject,"invoice_total_amount"));
            entity.setExpectdActivationFee(getDoubleValue(jsonObject,"expectd_activation_fee"));
            entity.setExpectdMthlyRecurringCost(getDoubleValue(jsonObject,"expectd_mthly_recurring_cost"));
            entity.setExpectdAnnuRecurringCost(getDoubleValue(jsonObject,"expectd_annu_recurring_cost"));
                        ArrayList<InvoiceItemDetailsReturnElement> arrayListInvoiceItemDetailsReturnElement = buildInvoiceItemDetailsReturnElement((JSONArray)jsonObject.get("invoice_item_details"));
            for (InvoiceItemDetailsReturnElement element : arrayListInvoiceItemDetailsReturnElement){
                entity.getInvoiceItemDetails().add(element);
            }
                        ArrayList<TaxDetailsReturnElement> arrayListTaxDetailsReturnElement = buildTaxDetailsReturnElement((JSONArray)jsonObject.get("tax_details"));
            for (TaxDetailsReturnElement element : arrayListTaxDetailsReturnElement){
                entity.getTaxDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceItemDetailsReturnElement> buildInvoiceItemDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceItemDetailsReturnElement> returnElement = new ArrayList<InvoiceItemDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceItemDetailsReturnElement entity = new InvoiceItemDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setLineType(getLongValue(jsonObject,"line_type"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setServiceName(getLongValue(jsonObject,"service_name"));
            entity.setServiceIsTaxInd(getLongValue(jsonObject,"service_is_tax_ind"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getLongValue(jsonObject,"client_plan_instance_id"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getStringValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getLongValue(jsonObject,"line_amount"));
            entity.setLineBaseUnits(getLongValue(jsonObject,"line_base_units"));
            entity.setProrationFactor(getStringValue(jsonObject,"proration_factor"));
            entity.setLineDescription(getLongValue(jsonObject,"line_description"));
            entity.setStartDateRange(getLongValue(jsonObject,"start_date_range"));
            entity.setEndDateRange(getStringValue(jsonObject,"end_date_range"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setUsageTypeCd(getLongValue(jsonObject,"usage_type_cd"));
            entity.setServiceCoaId(getLongValue(jsonObject,"service_coa_id"));
            entity.setClientServiceCoaCode(getLongValue(jsonObject,"client_service_coa_code"));
            entity.setRefChargeLineNo(getLongValue(jsonObject,"ref_charge_line_no"));
            entity.setNsoOrderNo(getStringValue(jsonObject,"nso_order_no"));
            entity.setNsoOrderStatusLabel(getLongValue(jsonObject,"nso_order_status_label"));
            entity.setClientSku(getLongValue(jsonObject,"client_sku"));
            entity.setItemNo(getStringValue(jsonObject,"item_no"));
            entity.setClientItemId(getLongValue(jsonObject,"client_item_id"));
            entity.setCreditCouponCode(getStringValue(jsonObject,"credit_coupon_code"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setCsrComments(getStringValue(jsonObject,"csr_comments"));
            entity.setAdvBillingPeriodTotalDays(getLongValue(jsonObject,"adv_billing_period_total_days"));
            entity.setRateScheduleNo(getLongValue(jsonObject,"rate_schedule_no"));
            entity.setRateScheduleTierNo(getLongValue(jsonObject,"rate_schedule_tier_no"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CollectionInfoReturnElement> buildCollectionInfoReturnElement(JSONArray jsonArray) {
        ArrayList<CollectionInfoReturnElement> returnElement = new ArrayList<CollectionInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CollectionInfoReturnElement entity = new CollectionInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setCollectionErrorCode(getLongValue(jsonObject,"collection_error_code"));
            entity.setCollectionErrorMsg(getStringValue(jsonObject,"collection_error_msg"));
            entity.setBillGroupNo(getLongValue(jsonObject,"bill_group_no"));
            entity.setClientBillGroupId(getStringValue(jsonObject,"client_bill_group_id"));
            entity.setProcCvvResponse(getStringValue(jsonObject,"proc_cvv_response"));
            entity.setProcAvsResponse(getStringValue(jsonObject,"proc_avs_response"));
            entity.setProcCavvResponse(getStringValue(jsonObject,"proc_cavv_response"));
            entity.setProcStatusCode(getStringValue(jsonObject,"proc_status_code"));
            entity.setProcStatusText(getStringValue(jsonObject,"proc_status_text"));
            entity.setProcPaymentId(getStringValue(jsonObject,"proc_payment_id"));
            entity.setProcAuthCode(getStringValue(jsonObject,"proc_auth_code"));
            entity.setProcMerchComments(getStringValue(jsonObject,"proc_merch_comments"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctNsoInclListReturnElement> buildAcctNsoInclListReturnElement(JSONArray jsonArray) {
        ArrayList<AcctNsoInclListReturnElement> returnElement = new ArrayList<AcctNsoInclListReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctNsoInclListReturnElement entity = new AcctNsoInclListReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setPurchaseScope(getLongValue(jsonObject,"purchase_scope"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllSurchargesReturnElement> buildAllSurchargesReturnElement(JSONArray jsonArray) {
        ArrayList<AllSurchargesReturnElement> returnElement = new ArrayList<AllSurchargesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllSurchargesReturnElement entity = new AllSurchargesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSurchargeNo(getLongValue(jsonObject,"surcharge_no"));
            entity.setSurchargeName(getStringValue(jsonObject,"surcharge_name"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setExtDescription(getStringValue(jsonObject,"ext_description"));
            entity.setSurchargeType(getStringValue(jsonObject,"surcharge_type"));
            entity.setCurrency(getStringValue(jsonObject,"currency"));
            entity.setTaxGroup(getStringValue(jsonObject,"tax_group"));
            entity.setInvoiceAppMethod(getStringValue(jsonObject,"invoice_app_method"));
            entity.setRevGlCode(getStringValue(jsonObject,"rev_gl_code"));
            entity.setArGlCode(getStringValue(jsonObject,"ar_gl_code"));
                        ArrayList<SurchargePlanReturnElement> arrayListSurchargePlanReturnElement = buildSurchargePlanReturnElement((JSONArray)jsonObject.get("surcharge_plan"));
            for (SurchargePlanReturnElement element : arrayListSurchargePlanReturnElement){
                entity.getSurchargePlan().add(element);
            }
                        ArrayList<SurchargeRateReturnElement> arrayListSurchargeRateReturnElement = buildSurchargeRateReturnElement((JSONArray)jsonObject.get("surcharge_rate"));
            for (SurchargeRateReturnElement element : arrayListSurchargeRateReturnElement){
                entity.getSurchargeRate().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllClientItemDetailsReturnElement> buildAllClientItemDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<AllClientItemDetailsReturnElement> returnElement = new ArrayList<AllClientItemDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllClientItemDetailsReturnElement entity = new AllClientItemDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
                        ArrayList<AllServiceSuppFieldsReturnElement> arrayListAllServiceSuppFieldsReturnElement = buildAllServiceSuppFieldsReturnElement((JSONArray)jsonObject.get("all_service_supp_fields"));
            for (AllServiceSuppFieldsReturnElement element : arrayListAllServiceSuppFieldsReturnElement){
                entity.getAllServiceSuppFields().add(element);
            }
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setItemType(getLongValue(jsonObject,"item_type"));
            entity.setItemDesc(getStringValue(jsonObject,"item_desc"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setModifyPriceInd(getStringValue(jsonObject,"modify_price_ind"));
            entity.setSubunitQty(getDoubleValue(jsonObject,"subunit_qty"));
            entity.setSubunitLabel(getStringValue(jsonObject,"subunit_label"));
            entity.setServiceType(getStringValue(jsonObject,"service_type"));
            entity.setCoaId(getStringValue(jsonObject,"coa_id"));
            entity.setClientCoaCode(getStringValue(jsonObject,"client_coa_code"));
            entity.setTaxableInd(getLongValue(jsonObject,"taxable_ind"));
            entity.setTaxGroup(getLongValue(jsonObject,"tax_group"));
            entity.setUsageType(getLongValue(jsonObject,"usage_type"));
            entity.setPurchaseScope(getLongValue(jsonObject,"purchase_scope"));
                        ArrayList<AllItemPricesReturnElement> arrayListAllItemPricesReturnElement = buildAllItemPricesReturnElement((JSONArray)jsonObject.get("all_item_prices"));
            for (AllItemPricesReturnElement element : arrayListAllItemPricesReturnElement){
                entity.getAllItemPrices().add(element);
            }
                        ArrayList<AllItemImagesReturnElement> arrayListAllItemImagesReturnElement = buildAllItemImagesReturnElement((JSONArray)jsonObject.get("all_item_images"));
            for (AllItemImagesReturnElement element : arrayListAllItemImagesReturnElement){
                entity.getAllItemImages().add(element);
            }
                        ArrayList<AllItemSuppFieldsReturnElement> arrayListAllItemSuppFieldsReturnElement = buildAllItemSuppFieldsReturnElement((JSONArray)jsonObject.get("all_item_supp_fields"));
            for (AllItemSuppFieldsReturnElement element : arrayListAllItemSuppFieldsReturnElement){
                entity.getAllItemSuppFields().add(element);
            }
                        ArrayList<AllItemClassesReturnElement> arrayListAllItemClassesReturnElement = buildAllItemClassesReturnElement((JSONArray)jsonObject.get("all_item_classes"));
            for (AllItemClassesReturnElement element : arrayListAllItemClassesReturnElement){
                entity.getAllItemClasses().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ItemsBasicDetailsReturnElement> buildItemsBasicDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<ItemsBasicDetailsReturnElement> returnElement = new ArrayList<ItemsBasicDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ItemsBasicDetailsReturnElement entity = new ItemsBasicDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setItemType(getLongValue(jsonObject,"item_type"));
            entity.setItemDesc(getStringValue(jsonObject,"item_desc"));
            entity.setActiveInd(getLongValue(jsonObject,"active_ind"));
            entity.setModifyPriceInd(getStringValue(jsonObject,"modify_price_ind"));
            entity.setSubunitQty(getDoubleValue(jsonObject,"subunit_qty"));
            entity.setSubunitLabel(getStringValue(jsonObject,"subunit_label"));
            entity.setServiceType(getStringValue(jsonObject,"service_type"));
            entity.setCoaId(getStringValue(jsonObject,"coa_id"));
            entity.setClientCoaCode(getStringValue(jsonObject,"client_coa_code"));
            entity.setTaxableInd(getLongValue(jsonObject,"taxable_ind"));
            entity.setTaxGroup(getLongValue(jsonObject,"tax_group"));
            entity.setUsageType(getLongValue(jsonObject,"usage_type"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            entity.setPurchaseScope(getLongValue(jsonObject,"purchase_scope"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ClientItemDetailsReturnElement> buildClientItemDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<ClientItemDetailsReturnElement> returnElement = new ArrayList<ClientItemDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ClientItemDetailsReturnElement entity = new ClientItemDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setItemLabel(getStringValue(jsonObject,"item_label"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceDesc(getStringValue(jsonObject,"service_desc"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setItemPlan(getLongValue(jsonObject,"item_plan"));
            entity.setItemMonths(getLongValue(jsonObject,"item_months"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClassNo(getLongValue(jsonObject,"class_no"));
            entity.setClassLabel(getStringValue(jsonObject,"class_label"));
            entity.setStockLevel(getDoubleValue(jsonObject,"stock_level"));
            entity.setAvgRatings(getLongValue(jsonObject,"avg_ratings"));
            entity.setNumRatings(getLongValue(jsonObject,"num_ratings"));
            entity.setNumReviews(getLongValue(jsonObject,"num_reviews"));
            entity.setImageUrl(getStringValue(jsonObject,"image_url"));
            entity.setImageText(getStringValue(jsonObject,"image_text"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setClientItemPlanId(getStringValue(jsonObject,"client_item_plan_id"));
            entity.setPurchaseScope(getLongValue(jsonObject,"purchase_scope"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllClientPlanDtlsReturnElement> buildAllClientPlanDtlsReturnElement(JSONArray jsonArray) {
        ArrayList<AllClientPlanDtlsReturnElement> returnElement = new ArrayList<AllClientPlanDtlsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllClientPlanDtlsReturnElement entity = new AllClientPlanDtlsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setSuppPlanInd(getLongValue(jsonObject,"supp_plan_ind"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
            entity.setNsoInclListScope(getLongValue(jsonObject,"nso_incl_list_scope"));
                        ArrayList<PlanServicesReturnElement> arrayListPlanServicesReturnElement = buildPlanServicesReturnElement((JSONArray)jsonObject.get("plan_services"));
            for (PlanServicesReturnElement element : arrayListPlanServicesReturnElement){
                entity.getPlanServices().add(element);
            }
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
                        ArrayList<PlanNsoInclListReturnElement> arrayListPlanNsoInclListReturnElement = buildPlanNsoInclListReturnElement((JSONArray)jsonObject.get("plan_nso_incl_list"));
            for (PlanNsoInclListReturnElement element : arrayListPlanNsoInclListReturnElement){
                entity.getPlanNsoInclList().add(element);
            }
                        ArrayList<PlanGroupsReturnElement> arrayListPlanGroupsReturnElement = buildPlanGroupsReturnElement((JSONArray)jsonObject.get("plan_groups"));
            for (PlanGroupsReturnElement element : arrayListPlanGroupsReturnElement){
                entity.getPlanGroups().add(element);
            }
                        ArrayList<PromotionalPlanSetsReturnElement> arrayListPromotionalPlanSetsReturnElement = buildPromotionalPlanSetsReturnElement((JSONArray)jsonObject.get("promotional_plan_sets"));
            for (PromotionalPlanSetsReturnElement element : arrayListPromotionalPlanSetsReturnElement){
                entity.getPromotionalPlanSets().add(element);
            }
                        ArrayList<ParentPlansReturnElement> arrayListParentPlansReturnElement = buildParentPlansReturnElement((JSONArray)jsonObject.get("parent_plans"));
            for (ParentPlansReturnElement element : arrayListParentPlansReturnElement){
                entity.getParentPlans().add(element);
            }
                        ArrayList<PlanSuppFieldsReturnElement> arrayListPlanSuppFieldsReturnElement = buildPlanSuppFieldsReturnElement((JSONArray)jsonObject.get("plan_supp_fields"));
            for (PlanSuppFieldsReturnElement element : arrayListPlanSuppFieldsReturnElement){
                entity.getPlanSuppFields().add(element);
            }
            entity.setFirstRetrievalLevelInd(getStringValue(jsonObject,"first_retrieval_level_ind"));
                        ArrayList<ChildPlansReturnElement> arrayListChildPlansReturnElement = buildChildPlansReturnElement((JSONArray)jsonObject.get("child_plans"));
            for (ChildPlansReturnElement element : arrayListChildPlansReturnElement){
                entity.getChildPlans().add(element);
            }
                        ArrayList<PlanNsoItemsReturnElement> arrayListPlanNsoItemsReturnElement = buildPlanNsoItemsReturnElement((JSONArray)jsonObject.get("plan_nso_items"));
            for (PlanNsoItemsReturnElement element : arrayListPlanNsoItemsReturnElement){
                entity.getPlanNsoItems().add(element);
            }
                        ArrayList<PlanNsoGroupReturnElement> arrayListPlanNsoGroupReturnElement = buildPlanNsoGroupReturnElement((JSONArray)jsonObject.get("plan_nso_group"));
            for (PlanNsoGroupReturnElement element : arrayListPlanNsoGroupReturnElement){
                entity.getPlanNsoGroup().add(element);
            }
            entity.setNsoGroupMinQty(getStringValue(jsonObject,"nso_group_min_qty"));
            entity.setNsoGroupMaxQty(getStringValue(jsonObject,"nso_group_max_qty"));
            entity.setNsoGroupItemScope(getStringValue(jsonObject,"nso_group_item_scope"));
                        ArrayList<PlanTranslationDtlsReturnElement> arrayListPlanTranslationDtlsReturnElement = buildPlanTranslationDtlsReturnElement((JSONArray)jsonObject.get("plan_translation_dtls"));
            for (PlanTranslationDtlsReturnElement element : arrayListPlanTranslationDtlsReturnElement){
                entity.getPlanTranslationDtls().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ChildPlansReturnElement> buildChildPlansReturnElement(JSONArray jsonArray) {
        ArrayList<ChildPlansReturnElement> returnElement = new ArrayList<ChildPlansReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ChildPlansReturnElement entity = new ChildPlansReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setIsMandatory(getLongValue(jsonObject,"is_mandatory"));
            entity.setIsDefault(getStringValue(jsonObject,"is_default"));
            entity.setMinUnits(getLongValue(jsonObject,"min_units"));
            entity.setMaxUnits(getStringValue(jsonObject,"max_units"));
            entity.setEnforcementLevel(getStringValue(jsonObject,"enforcement_level"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanTranslationDtlsReturnElement> buildPlanTranslationDtlsReturnElement(JSONArray jsonArray) {
        ArrayList<PlanTranslationDtlsReturnElement> returnElement = new ArrayList<PlanTranslationDtlsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanTranslationDtlsReturnElement entity = new PlanTranslationDtlsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setLocaleName(getStringValue(jsonObject,"locale_name"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setLocaleNo(getLongValue(jsonObject,"locale_no"));
                        ArrayList<RateSchedsTReturnElement> arrayListRateSchedsTReturnElement = buildRateSchedsTReturnElement((JSONArray)jsonObject.get("rate_scheds_t"));
            for (RateSchedsTReturnElement element : arrayListRateSchedsTReturnElement){
                entity.getRateSchedsT().add(element);
            }
                        ArrayList<PlanServiceTReturnElement> arrayListPlanServiceTReturnElement = buildPlanServiceTReturnElement((JSONArray)jsonObject.get("plan_service_t"));
            for (PlanServiceTReturnElement element : arrayListPlanServiceTReturnElement){
                entity.getPlanServiceT().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanServiceTReturnElement> buildPlanServiceTReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServiceTReturnElement> returnElement = new ArrayList<PlanServiceTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServiceTReturnElement entity = new PlanServiceTReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
                        ArrayList<AllServiceSuppFieldsTReturnElement> arrayListAllServiceSuppFieldsTReturnElement = buildAllServiceSuppFieldsTReturnElement((JSONArray)jsonObject.get("all_service_supp_fields_t"));
            for (AllServiceSuppFieldsTReturnElement element : arrayListAllServiceSuppFieldsTReturnElement){
                entity.getAllServiceSuppFieldsT().add(element);
            }
                        ArrayList<PlanServiceRatesTReturnElement> arrayListPlanServiceRatesTReturnElement = buildPlanServiceRatesTReturnElement((JSONArray)jsonObject.get("plan_service_rates_t"));
            for (PlanServiceRatesTReturnElement element : arrayListPlanServiceRatesTReturnElement){
                entity.getPlanServiceRatesT().add(element);
            }
            entity.setUsageTypeName(getStringValue(jsonObject,"usage_type_name"));
            entity.setUsageTypeDesc(getStringValue(jsonObject,"usage_type_desc"));
            entity.setUsageUnitLabel(getStringValue(jsonObject,"usage_unit_label"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AllServiceSuppFieldsTReturnElement> buildAllServiceSuppFieldsTReturnElement(JSONArray jsonArray) {
        ArrayList<AllServiceSuppFieldsTReturnElement> returnElement = new ArrayList<AllServiceSuppFieldsTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AllServiceSuppFieldsTReturnElement entity = new AllServiceSuppFieldsTReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setFieldName(getStringValue(jsonObject,"field_name"));
            entity.setFieldDesc(getStringValue(jsonObject,"field_desc"));
            entity.setFieldOrderNo(getLongValue(jsonObject,"field_order_no"));
            entity.setFieldValue(getStringValue(jsonObject,"field_value"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PlanServiceRatesTReturnElement> buildPlanServiceRatesTReturnElement(JSONArray jsonArray) {
        ArrayList<PlanServiceRatesTReturnElement> returnElement = new ArrayList<PlanServiceRatesTReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PlanServiceRatesTReturnElement entity = new PlanServiceRatesTReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRateSeqNo(getLongValue(jsonObject,"rate_seq_no"));
            entity.setRateTierDescription(getStringValue(jsonObject,"rate_tier_description"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<MasterPlansDtlBySuppFieldReturnElement> buildMasterPlansDtlBySuppFieldReturnElement(JSONArray jsonArray) {
        ArrayList<MasterPlansDtlBySuppFieldReturnElement> returnElement = new ArrayList<MasterPlansDtlBySuppFieldReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            MasterPlansDtlBySuppFieldReturnElement entity = new MasterPlansDtlBySuppFieldReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setEarlyCancelFee(getDoubleValue(jsonObject,"early_cancel_fee"));
            entity.setEarlyCancelMinMonths(getLongValue(jsonObject,"early_cancel_min_months"));
            entity.setSuspensionPeriod(getLongValue(jsonObject,"suspension_period"));
            entity.setNewAcctStatus(getLongValue(jsonObject,"new_acct_status"));
            entity.setRolloverAcctStatus(getLongValue(jsonObject,"rollover_acct_status"));
            entity.setRolloverAcctStatusDays(getLongValue(jsonObject,"rollover_acct_status_days"));
            entity.setInitFreeMonths(getLongValue(jsonObject,"init_free_months"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
                        ArrayList<PlanTranslationInfoReturnElement> arrayListPlanTranslationInfoReturnElement = buildPlanTranslationInfoReturnElement((JSONArray)jsonObject.get("plan_translation_info"));
            for (PlanTranslationInfoReturnElement element : arrayListPlanTranslationInfoReturnElement){
                entity.getPlanTranslationInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<SuppPlansDtlBySuppFieldReturnElement> buildSuppPlansDtlBySuppFieldReturnElement(JSONArray jsonArray) {
        ArrayList<SuppPlansDtlBySuppFieldReturnElement> returnElement = new ArrayList<SuppPlansDtlBySuppFieldReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            SuppPlansDtlBySuppFieldReturnElement entity = new SuppPlansDtlBySuppFieldReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setPlanDesc(getStringValue(jsonObject,"plan_desc"));
            entity.setBillingInd(getLongValue(jsonObject,"billing_ind"));
            entity.setDisplayInd(getLongValue(jsonObject,"display_ind"));
            entity.setRolloverMonths(getLongValue(jsonObject,"rollover_months"));
            entity.setRolloverPlanNo(getLongValue(jsonObject,"rollover_plan_no"));
            entity.setPlan2AssignOnSusp(getLongValue(jsonObject,"plan_2_assign_on_susp"));
            entity.setDefaultNotifyMethod(getLongValue(jsonObject,"default_notify_method"));
            entity.setPrepaidInd(getLongValue(jsonObject,"prepaid_ind"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientRolloverPlanId(getStringValue(jsonObject,"client_rollover_plan_id"));
            entity.setClientPlanId2AssignOnSusp(getStringValue(jsonObject,"client_plan_id_2_assign_on_susp"));
            entity.setProrationInvoiceTimingCd(getStringValue(jsonObject,"proration_invoice_timing_cd"));
            entity.setRolloverPlanDuration(getStringValue(jsonObject,"rollover_plan_duration"));
            entity.setRolloverPlanUomCd(getLongValue(jsonObject,"rollover_plan_uom_cd"));
            entity.setInitFreePeriodDuration(getLongValue(jsonObject,"init_free_period_duration"));
            entity.setInitFreePeriodUomCd(getStringValue(jsonObject,"init_free_period_uom_cd"));
            entity.setInitialPlanStatusCd(getLongValue(jsonObject,"initial_plan_status_cd"));
            entity.setRolloverPlanStatusDuration(getLongValue(jsonObject,"rollover_plan_status_duration"));
            entity.setRolloverPlanStatusUomCd(getLongValue(jsonObject,"rollover_plan_status_uom_cd"));
            entity.setRolloverPlanStatusCd(getLongValue(jsonObject,"rollover_plan_status_cd"));
                        ArrayList<PlanRateSchedulesDetailsReturnElement> arrayListPlanRateSchedulesDetailsReturnElement = buildPlanRateSchedulesDetailsReturnElement((JSONArray)jsonObject.get("plan_rate_schedules_details"));
            for (PlanRateSchedulesDetailsReturnElement element : arrayListPlanRateSchedulesDetailsReturnElement){
                entity.getPlanRateSchedulesDetails().add(element);
            }
            entity.setContractRolloverPlanNo(getLongValue(jsonObject,"contract_rollover_plan_no"));
            entity.setContractRolloverClientPlanId(getStringValue(jsonObject,"contract_rollover_client_plan_id"));
                        ArrayList<ContractRolloverRateSchedReturnElement> arrayListContractRolloverRateSchedReturnElement = buildContractRolloverRateSchedReturnElement((JSONArray)jsonObject.get("contract_rollover_rate_sched"));
            for (ContractRolloverRateSchedReturnElement element : arrayListContractRolloverRateSchedReturnElement){
                entity.getContractRolloverRateSched().add(element);
            }
                        ArrayList<PlanTranslationInfoReturnElement> arrayListPlanTranslationInfoReturnElement = buildPlanTranslationInfoReturnElement((JSONArray)jsonObject.get("plan_translation_info"));
            for (PlanTranslationInfoReturnElement element : arrayListPlanTranslationInfoReturnElement){
                entity.getPlanTranslationInfo().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<PaymentMethodMapReturnElement> buildPaymentMethodMapReturnElement(JSONArray jsonArray) {
        ArrayList<PaymentMethodMapReturnElement> returnElement = new ArrayList<PaymentMethodMapReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            PaymentMethodMapReturnElement entity = new PaymentMethodMapReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setSourcePmtMethodNo(getLongValue(jsonObject,"source_pmt_method_no"));
            entity.setClientSourcePmtMethodId(getStringValue(jsonObject,"client_source_pmt_method_id"));
            entity.setTargetPmtMethodNo(getLongValue(jsonObject,"target_pmt_method_no"));
            entity.setClientTargetPmtMethodId(getStringValue(jsonObject,"client_target_pmt_method_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<CartInvLineItemsReturnElement> buildCartInvLineItemsReturnElement(JSONArray jsonArray) {
        ArrayList<CartInvLineItemsReturnElement> returnElement = new ArrayList<CartInvLineItemsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            CartInvLineItemsReturnElement entity = new CartInvLineItemsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setServiceIsTaxInd(getLongValue(jsonObject,"service_is_tax_ind"));
            entity.setLineUnits(getDoubleValue(jsonObject,"line_units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setLineAmount(getDoubleValue(jsonObject,"line_amount"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setPlanInstanceNo(getLongValue(jsonObject,"plan_instance_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setRefChargeLineNo(getLongValue(jsonObject,"ref_charge_line_no"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<WriteoffTransactionsReturnElement> buildWriteoffTransactionsReturnElement(JSONArray jsonArray) {
        ArrayList<WriteoffTransactionsReturnElement> returnElement = new ArrayList<WriteoffTransactionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            WriteoffTransactionsReturnElement entity = new WriteoffTransactionsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setWriteoffTransactionId(getLongValue(jsonObject,"writeoff_transaction_id"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setOriginalAmount(getLongValue(jsonObject,"original_amount"));
            entity.setAmount(getLongValue(jsonObject,"amount"));
            entity.setDate(getStringValue(jsonObject,"date"));
            entity.setWriteoffReasoncode(getLongValue(jsonObject,"writeoff_reasoncode"));
            entity.setDisputeCreationDate(getStringValue(jsonObject,"dispute_creation_date"));
            entity.setDisputeExpiryDate(getStringValue(jsonObject,"dispute_expiry_date"));
            entity.setDisputeInd(getLongValue(jsonObject,"dispute_ind"));
            entity.setCanUnsettle(getStringValue(jsonObject,"can_unsettle"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OutInvoicesReturnElement> buildOutInvoicesReturnElement(JSONArray jsonArray) {
        ArrayList<OutInvoicesReturnElement> returnElement = new ArrayList<OutInvoicesReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OutInvoicesReturnElement entity = new OutInvoicesReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoicingErrorCode(getLongValue(jsonObject,"invoicing_error_code"));
            entity.setInvoicingErrorMsg(getStringValue(jsonObject,"invoicing_error_msg"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setBillingGroupNo(getLongValue(jsonObject,"billing_group_no"));
            entity.setClientBillingGroupId(getStringValue(jsonObject,"client_billing_group_id"));
            entity.setInvoiceChargesBeforeTax(getDoubleValue(jsonObject,"invoice_charges_before_tax"));
            entity.setInvoiceTaxCharges(getDoubleValue(jsonObject,"invoice_tax_charges"));
            entity.setInvoiceChargesAfterTax(getDoubleValue(jsonObject,"invoice_charges_after_tax"));
            entity.setInvoiceCreditAmount(getDoubleValue(jsonObject,"invoice_credit_amount"));
            entity.setInvoiceTotalAmount(getDoubleValue(jsonObject,"invoice_total_amount"));
                        ArrayList<InvoiceItemsReturnElement> arrayListInvoiceItemsReturnElement = buildInvoiceItemsReturnElement((JSONArray)jsonObject.get("invoice_items"));
            for (InvoiceItemsReturnElement element : arrayListInvoiceItemsReturnElement){
                entity.getInvoiceItems().add(element);
            }
                        ArrayList<TaxDetailsReturnElement> arrayListTaxDetailsReturnElement = buildTaxDetailsReturnElement((JSONArray)jsonObject.get("tax_details"));
            for (TaxDetailsReturnElement element : arrayListTaxDetailsReturnElement){
                entity.getTaxDetails().add(element);
            }
                        ArrayList<ThirdPartyErrorsReturnElement> arrayListThirdPartyErrorsReturnElement = buildThirdPartyErrorsReturnElement((JSONArray)jsonObject.get("third_party_errors"));
            for (ThirdPartyErrorsReturnElement element : arrayListThirdPartyErrorsReturnElement){
                entity.getThirdPartyErrors().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<AcctPaymentHistoryReturnElement> buildAcctPaymentHistoryReturnElement(JSONArray jsonArray) {
        ArrayList<AcctPaymentHistoryReturnElement> returnElement = new ArrayList<AcctPaymentHistoryReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            AcctPaymentHistoryReturnElement entity = new AcctPaymentHistoryReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setPaymentSource(getStringValue(jsonObject,"payment_source"));
            entity.setPaymentStatus(getStringValue(jsonObject,"payment_status"));
            entity.setPaymentDate(getStringValue(jsonObject,"payment_date"));
            entity.setPaymentTransType(getLongValue(jsonObject,"payment_trans_type"));
            entity.setPaymentCurrency(getStringValue(jsonObject,"payment_currency"));
            entity.setPaymentAmount(getDoubleValue(jsonObject,"payment_amount"));
            entity.setPaymentAmountLeftToApply(getDoubleValue(jsonObject,"payment_amount_left_to_apply"));
            entity.setVoidingEventNo(getLongValue(jsonObject,"voiding_event_no"));
            entity.setVoidableFlag(getLongValue(jsonObject,"voidable_flag"));
            entity.setCcSuffix(getStringValue(jsonObject,"cc_suffix"));
            entity.setCcString(getStringValue(jsonObject,"cc_string"));
            entity.setPayMethodType(getLongValue(jsonObject,"pay_method_type"));
            entity.setProcStatusCode(getLongValue(jsonObject,"proc_status_code"));
            entity.setProcPaymentId(getStringValue(jsonObject,"proc_payment_id"));
            entity.setProcAuthCode(getStringValue(jsonObject,"proc_auth_code"));
            entity.setPaymentTimestamp(getStringValue(jsonObject,"payment_timestamp"));
            entity.setProcStatusText(getStringValue(jsonObject,"proc_status_text"));
            entity.setPaymentMethodNo(getLongValue(jsonObject,"payment_method_no"));
            entity.setClientPaymentMethodId(getStringValue(jsonObject,"client_payment_method_id"));
            entity.setPaymentReceivedDate(getStringValue(jsonObject,"payment_received_date"));
                        ArrayList<PaymentApplicationDetailsReturnElement> arrayListPaymentApplicationDetailsReturnElement = buildPaymentApplicationDetailsReturnElement((JSONArray)jsonObject.get("payment_application_details"));
            for (PaymentApplicationDetailsReturnElement element : arrayListPaymentApplicationDetailsReturnElement){
                entity.getPaymentApplicationDetails().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<WriteoffDisputeInfoReturnElement> buildWriteoffDisputeInfoReturnElement(JSONArray jsonArray) {
        ArrayList<WriteoffDisputeInfoReturnElement> returnElement = new ArrayList<WriteoffDisputeInfoReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            WriteoffDisputeInfoReturnElement entity = new WriteoffDisputeInfoReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setRecNo(getLongValue(jsonObject,"rec_no"));
            entity.setCreatedBy(getStringValue(jsonObject,"created_by"));
            entity.setCreatedDate(getStringValue(jsonObject,"created_date"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceDate(getStringValue(jsonObject,"invoice_date"));
            entity.setInvoiceAmt(getDoubleValue(jsonObject,"invoice_amt"));
                        ArrayList<WriteoffDetailReturnElement> arrayListWriteoffDetailReturnElement = buildWriteoffDetailReturnElement((JSONArray)jsonObject.get("writeoff_detail"));
            for (WriteoffDetailReturnElement element : arrayListWriteoffDetailReturnElement){
                entity.getWriteoffDetail().add(element);
            }
            entity.setDisputeCreationDate(getStringValue(jsonObject,"dispute_creation_date"));
            entity.setDisputeExpDate(getStringValue(jsonObject,"dispute_exp_date"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setSecondaryReasonCode(getLongValue(jsonObject,"secondary_reason_code"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setDisputeInd(getLongValue(jsonObject,"dispute_ind"));
            entity.setCanUnsettle(getStringValue(jsonObject,"can_unsettle"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<WriteoffDetailReturnElement> buildWriteoffDetailReturnElement(JSONArray jsonArray) {
        ArrayList<WriteoffDetailReturnElement> returnElement = new ArrayList<WriteoffDetailReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            WriteoffDetailReturnElement entity = new WriteoffDetailReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceBillDate(getStringValue(jsonObject,"invoice_bill_date"));
            entity.setInvoiceTransactionId(getLongValue(jsonObject,"invoice_transaction_id"));
            entity.setOriginalTransactionAmount(getDoubleValue(jsonObject,"original_transaction_amount"));
            entity.setWriteoffTransactionAmount(getDoubleValue(jsonObject,"writeoff_transaction_amount"));
            entity.setWriteoffTransactionStartDate(getStringValue(jsonObject,"writeoff_transaction_start_date"));
            entity.setWriteoffTransactionEndDate(getStringValue(jsonObject,"writeoff_transaction_end_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoiceLineDetailsReturnElement> buildInvoiceLineDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoiceLineDetailsReturnElement> returnElement = new ArrayList<InvoiceLineDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoiceLineDetailsReturnElement entity = new InvoiceLineDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setLineNo(getLongValue(jsonObject,"line_no"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setServiceName(getStringValue(jsonObject,"service_name"));
            entity.setUnits(getDoubleValue(jsonObject,"units"));
            entity.setRatePerUnit(getDoubleValue(jsonObject,"rate_per_unit"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setDateRangeStart(getStringValue(jsonObject,"date_range_start"));
            entity.setDateRangeEnd(getStringValue(jsonObject,"date_range_end"));
            entity.setUsageTypeNo(getLongValue(jsonObject,"usage_type_no"));
            entity.setPlanNo(getLongValue(jsonObject,"plan_no"));
            entity.setPlanName(getStringValue(jsonObject,"plan_name"));
            entity.setCreditReasonCodeDescription(getStringValue(jsonObject,"credit_reason_code_description"));
            entity.setCsrComments(getStringValue(jsonObject,"csr_comments"));
            entity.setClientSku(getStringValue(jsonObject,"client_sku"));
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setItemNo(getLongValue(jsonObject,"item_no"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            entity.setUsageTypeCd(getStringValue(jsonObject,"usage_type_cd"));
            entity.setClientPlanId(getStringValue(jsonObject,"client_plan_id"));
            entity.setClientItemId(getStringValue(jsonObject,"client_item_id"));
            entity.setBasePlanUnits(getDoubleValue(jsonObject,"base_plan_units"));
            entity.setProrationFactor(getDoubleValue(jsonObject,"proration_factor"));
            entity.setProrationText(getStringValue(jsonObject,"proration_text"));
            entity.setAdvBillingPeriodTotalDays(getLongValue(jsonObject,"adv_billing_period_total_days"));
            entity.setProrationRemainingDays(getLongValue(jsonObject,"proration_remaining_days"));
            entity.setProrationDescription(getStringValue(jsonObject,"proration_description"));
            entity.setClientAcctId(getStringValue(jsonObject,"client_acct_id"));
            entity.setMasterPlanInstanceNo(getLongValue(jsonObject,"master_plan_instance_no"));
            entity.setClientMpInstanceId(getStringValue(jsonObject,"client_mp_instance_id"));
            entity.setInvoiceTransactionId(getLongValue(jsonObject,"invoice_transaction_id"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<OrdersReturnElement> buildOrdersReturnElement(JSONArray jsonArray) {
        ArrayList<OrdersReturnElement> returnElement = new ArrayList<OrdersReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            OrdersReturnElement entity = new OrdersReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setOrderNo(getLongValue(jsonObject,"order_no"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setCurrencyCd(getStringValue(jsonObject,"currency_cd"));
            entity.setStatusLabel(getStringValue(jsonObject,"status_label"));
            entity.setPlanInstanceNo(getStringValue(jsonObject,"plan_instance_no"));
            entity.setClientPlanInstanceId(getStringValue(jsonObject,"client_plan_instance_id"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setCreateDate(getStringValue(jsonObject,"create_date"));
            entity.setUpdateDate(getStringValue(jsonObject,"update_date"));
            entity.setComments(getStringValue(jsonObject,"comments"));
            entity.setClientOrderId(getStringValue(jsonObject,"client_order_id"));
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setOrderCreateClientReceiptId(getStringValue(jsonObject,"order_create_client_receipt_id"));
            entity.setOrderStatusClientReceiptId(getStringValue(jsonObject,"order_status_client_receipt_id"));
            entity.setStatementMessage(getStringValue(jsonObject,"statement_message"));
            entity.setPoNum(getStringValue(jsonObject,"po_num"));
                        ArrayList<OrderItemsReturnElement> arrayListOrderItemsReturnElement = buildOrderItemsReturnElement((JSONArray)jsonObject.get("order_items"));
            for (OrderItemsReturnElement element : arrayListOrderItemsReturnElement){
                entity.getOrderItems().add(element);
            }
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<InvoicePaymentDetailsReturnElement> buildInvoicePaymentDetailsReturnElement(JSONArray jsonArray) {
        ArrayList<InvoicePaymentDetailsReturnElement> returnElement = new ArrayList<InvoicePaymentDetailsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            InvoicePaymentDetailsReturnElement entity = new InvoicePaymentDetailsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setTransactionId(getLongValue(jsonObject,"transaction_id"));
            entity.setTransactionType(getLongValue(jsonObject,"transaction_type"));
            entity.setDescription(getStringValue(jsonObject,"description"));
            entity.setAmount(getDoubleValue(jsonObject,"amount"));
            entity.setAppliedAmount(getDoubleValue(jsonObject,"applied_amount"));
            entity.setCurrencyCode(getStringValue(jsonObject,"currency_code"));
            entity.setTransactionDate(getStringValue(jsonObject,"transaction_date"));
            entity.setIsVoided(getStringValue(jsonObject,"is_voided"));
            entity.setStatementNo(getLongValue(jsonObject,"statement_no"));
            entity.setPaymentType(getStringValue(jsonObject,"payment_type"));
            entity.setPaymentSrcDescription(getStringValue(jsonObject,"payment_src_description"));
            entity.setPaymentSrcSuffix(getStringValue(jsonObject,"payment_src_suffix"));
            entity.setClientReceiptId(getStringValue(jsonObject,"client_receipt_id"));
            entity.setSeqStatementId(getStringValue(jsonObject,"seq_statement_id"));
            entity.setPaymentMethodNo(getLongValue(jsonObject,"payment_method_no"));
            entity.setClientPaymentMethodId(getStringValue(jsonObject,"client_payment_method_id"));
            entity.setReasonCode(getLongValue(jsonObject,"reason_code"));
            entity.setReasonDescription(getStringValue(jsonObject,"reason_description"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ReversibleInvTransReturnElement> buildReversibleInvTransReturnElement(JSONArray jsonArray) {
        ArrayList<ReversibleInvTransReturnElement> returnElement = new ArrayList<ReversibleInvTransReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ReversibleInvTransReturnElement entity = new ReversibleInvTransReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoicedAcctNo(getLongValue(jsonObject,"invoiced_acct_no"));
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setInvoiceTransId(getLongValue(jsonObject,"invoice_trans_id"));
            entity.setInvoiceTransDate(getStringValue(jsonObject,"invoice_trans_date"));
            entity.setInvoiceTransDescription(getStringValue(jsonObject,"invoice_trans_description"));
            entity.setInvoiceTransAmount(getDoubleValue(jsonObject,"invoice_trans_amount"));
            entity.setInvTransReversedAmount(getDoubleValue(jsonObject,"inv_trans_reversed_amount"));
            entity.setInvTransReversibleAmount(getDoubleValue(jsonObject,"inv_trans_reversible_amount"));
            entity.setInvoiceTransIsRecurService(getLongValue(jsonObject,"invoice_trans_is_recur_service"));
            entity.setInvoiceTransRecurStartDate(getStringValue(jsonObject,"invoice_trans_recur_start_date"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<UnappliedPaymentsReturnElement> buildUnappliedPaymentsReturnElement(JSONArray jsonArray) {
        ArrayList<UnappliedPaymentsReturnElement> returnElement = new ArrayList<UnappliedPaymentsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            UnappliedPaymentsReturnElement entity = new UnappliedPaymentsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setPaymentTransactionId(getLongValue(jsonObject,"payment_transaction_id"));
            entity.setPaymentAmount(getDoubleValue(jsonObject,"payment_amount"));
            entity.setUnappliedAmount(getDoubleValue(jsonObject,"unapplied_amount"));
            entity.setCashCreditTransactionId(getLongValue(jsonObject,"cash_credit_transaction_id"));
            entity.setCashCreditAmount(getDoubleValue(jsonObject,"cash_credit_amount"));
            entity.setUnappliedCashCredit(getDoubleValue(jsonObject,"unapplied_cash_credit"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<ReversedInvoiceTransactionsReturnElement> buildReversedInvoiceTransactionsReturnElement(JSONArray jsonArray) {
        ArrayList<ReversedInvoiceTransactionsReturnElement> returnElement = new ArrayList<ReversedInvoiceTransactionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            ReversedInvoiceTransactionsReturnElement entity = new ReversedInvoiceTransactionsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceNo(getLongValue(jsonObject,"invoice_no"));
            entity.setInvoiceLineNo(getLongValue(jsonObject,"invoice_line_no"));
            entity.setReversedTransactionId(getLongValue(jsonObject,"reversed_transaction_id"));
            entity.setServiceNo(getLongValue(jsonObject,"service_no"));
            entity.setReversedAmount(getDoubleValue(jsonObject,"reversed_amount"));
            entity.setReversingDate(getStringValue(jsonObject,"reversing_date"));
            entity.setTransactionComments(getStringValue(jsonObject,"transaction_comments"));
            entity.setClientServiceId(getStringValue(jsonObject,"client_service_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    public static ArrayList<VoidTransactionsReturnElement> buildVoidTransactionsReturnElement(JSONArray jsonArray) {
        ArrayList<VoidTransactionsReturnElement> returnElement = new ArrayList<VoidTransactionsReturnElement>();
        if (jsonArray == null) return returnElement;
        for (int i = 0;i < jsonArray.size();i++) {
            VoidTransactionsReturnElement entity = new VoidTransactionsReturnElement();
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            entity.setInvoiceTransactionId(getLongValue(jsonObject,"invoice_transaction_id"));
            entity.setVoidTransactionId(getLongValue(jsonObject,"void_transaction_id"));
            returnElement.add(entity);
        }
        return returnElement;
    }
    /* ****************** END - SPECIFIC METHODS FOR EACH RETURN ELEMENT (build<#name#>) **************************************** */

    /* ****************** ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT ********************************************** */
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SpecificChargeTransactionIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SpecificChargeTransactionIdRow row : arrayList.getSpecificChargeTransactionIdRow()){
            parameters.add("specific_charge_transaction_id["+i+"]", getValue("Long", row.getSpecificChargeTransactionId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SpecificChargeTransactionIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SpecificChargeTransactionIdRow row : arrayList.getSpecificChargeTransactionIdRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[specific_charge_transaction_id]", getValue("Long", row.getSpecificChargeTransactionId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageRecordsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageRecordsRow row : arrayList.getUsageRecordsRow()){
            parameters.add("acct_no["+i+"]", getValue("Long", row.getAcctNo()));
            parameters.add("userid["+i+"]", getValue("String", row.getUserid()));
            parameters.add("usage_type["+i+"]", getValue("Long", row.getUsageType()));
            parameters.add("usage_units["+i+"]", getValue("Double", row.getUsageUnits()));
            parameters.add("usage_date["+i+"]", getValue("String", row.getUsageDate()));
            parameters.add("billable_units["+i+"]", getValue("Double", row.getBillableUnits()));
            parameters.add("amt["+i+"]", getValue("Double", row.getAmt()));
            parameters.add("rate["+i+"]", getValue("Double", row.getRate()));
            parameters.add("telco_from["+i+"]", getValue("String", row.getTelcoFrom()));
            parameters.add("telco_to["+i+"]", getValue("String", row.getTelcoTo()));
            parameters.add("comments["+i+"]", getValue("String", row.getComments()));
            parameters.add("exclude_from_billing["+i+"]", getValue("String", row.getExcludeFromBilling()));
            parameters.add("exclusion_comments["+i+"]", getValue("String", row.getExclusionComments()));
            parameters.add("parent_usage_rec_no["+i+"]", getValue("Long", row.getParentUsageRecNo()));
            parameters.add("qualifier_1["+i+"]", getValue("String", row.getQualifier1()));
            parameters.add("qualifier_2["+i+"]", getValue("String", row.getQualifier2()));
            parameters.add("qualifier_3["+i+"]", getValue("String", row.getQualifier3()));
            parameters.add("qualifier_4["+i+"]", getValue("String", row.getQualifier4()));
            parameters.add("usage_type_code["+i+"]", getValue("String", row.getUsageTypeCode()));
            parameters.add("client_record_id["+i+"]", getValue("String", row.getClientRecordId()));
            parameters.add("caller_id["+i+"]", getValue("String", row.getCallerId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageRecordsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageRecordsRow row : arrayList.getUsageRecordsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[acct_no]", getValue("Long", row.getAcctNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[userid]", getValue("String", row.getUserid()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_type]", getValue("Long", row.getUsageType()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_units]", getValue("Double", row.getUsageUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_date]", getValue("String", row.getUsageDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[billable_units]", getValue("Double", row.getBillableUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[amt]", getValue("Double", row.getAmt()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate]", getValue("Double", row.getRate()));
            parameters.add(paramPrefix + "["+i+"]" + "[telco_from]", getValue("String", row.getTelcoFrom()));
            parameters.add(paramPrefix + "["+i+"]" + "[telco_to]", getValue("String", row.getTelcoTo()));
            parameters.add(paramPrefix + "["+i+"]" + "[comments]", getValue("String", row.getComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[exclude_from_billing]", getValue("String", row.getExcludeFromBilling()));
            parameters.add(paramPrefix + "["+i+"]" + "[exclusion_comments]", getValue("String", row.getExclusionComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_usage_rec_no]", getValue("Long", row.getParentUsageRecNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_1]", getValue("String", row.getQualifier1()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_2]", getValue("String", row.getQualifier2()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_3]", getValue("String", row.getQualifier3()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_4]", getValue("String", row.getQualifier4()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_type_code]", getValue("String", row.getUsageTypeCode()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_record_id]", getValue("String", row.getClientRecordId()));
            parameters.add(paramPrefix + "["+i+"]" + "[caller_id]", getValue("String", row.getCallerId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.RecurringCreditNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.RecurringCreditNoRow row : arrayList.getRecurringCreditNoRow()){
            parameters.add("recurring_credit_no["+i+"]", getValue("Long", row.getRecurringCreditNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.RecurringCreditNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.RecurringCreditNoRow row : arrayList.getRecurringCreditNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[recurring_credit_no]", getValue("Long", row.getRecurringCreditNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.OrderLineItemsListArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.OrderLineItemsListRow row : arrayList.getOrderLineItemsListRow()){
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("units["+i+"]", getValue("Double", row.getUnits()));
            parameters.add("amount["+i+"]", getValue("Double", row.getAmount()));
            parameters.add("unit_discount_amount["+i+"]", getValue("Double", row.getUnitDiscountAmount()));
            parameters.add("line_comments["+i+"]", getValue("String", row.getLineComments()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            parameters.add("client_defined_rate_schedule_id["+i+"]", getValue("String", row.getClientDefinedRateScheduleId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.OrderLineItemsListArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.OrderLineItemsListRow row : arrayList.getOrderLineItemsListRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[units]", getValue("Double", row.getUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[amount]", getValue("Double", row.getAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[unit_discount_amount]", getValue("Double", row.getUnitDiscountAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[line_comments]", getValue("String", row.getLineComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_defined_rate_schedule_id]", getValue("String", row.getClientDefinedRateScheduleId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CartSuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CartSuppPlansRow row : arrayList.getCartSuppPlansRow()){
            parameters.add("supp_plan_no["+i+"]", getValue("Long", row.getSuppPlanNo()));
            parameters.add("supp_plan_units["+i+"]", getValue("Long", row.getSuppPlanUnits()));
            parameters.add("assignment_directive["+i+"]", getValue("Long", row.getAssignmentDirective()));
            parameters.add("client_supp_plan_ids["+i+"]", getValue("String", row.getClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CartSuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CartSuppPlansRow row : arrayList.getCartSuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_plan_no]", getValue("Long", row.getSuppPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[supp_plan_units]", getValue("Long", row.getSuppPlanUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[assignment_directive]", getValue("Long", row.getAssignmentDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_supp_plan_ids]", getValue("String", row.getClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MultipleCouponsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MultipleCouponsRow row : arrayList.getMultipleCouponsRow()){
            parameters.add("coupon_codes["+i+"]", getValue("String", row.getCouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MultipleCouponsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MultipleCouponsRow row : arrayList.getMultipleCouponsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[coupon_codes]", getValue("String", row.getCouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageRecordNosArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageRecordNosRow row : arrayList.getUsageRecordNosRow()){
            parameters.add("usage_record_no["+i+"]", getValue("Long", row.getUsageRecordNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageRecordNosArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageRecordNosRow row : arrayList.getUsageRecordNosRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[usage_record_no]", getValue("Long", row.getUsageRecordNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientRecordIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientRecordIdsRow row : arrayList.getClientRecordIdsRow()){
            parameters.add("client_record_id["+i+"]", getValue("String", row.getClientRecordId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientRecordIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientRecordIdsRow row : arrayList.getClientRecordIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_record_id]", getValue("String", row.getClientRecordId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InvoicesToReverseArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InvoicesToReverseRow row : arrayList.getInvoicesToReverseRow()){
            parameters.add("invoice_no["+i+"]", getValue("Long", row.getInvoiceNo()));
            parameters.add("invoice_line_no["+i+"]", getValue("Long", row.getInvoiceLineNo()));
            parameters.add("invoice_line_reversing_amount["+i+"]", getValue("Double", row.getInvoiceLineReversingAmount()));
            parameters.add("invoice_line_reversing_date["+i+"]", getValue("String", row.getInvoiceLineReversingDate()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InvoicesToReverseArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InvoicesToReverseRow row : arrayList.getInvoicesToReverseRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_no]", getValue("Long", row.getInvoiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_line_no]", getValue("Long", row.getInvoiceLineNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_line_reversing_amount]", getValue("Double", row.getInvoiceLineReversingAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_line_reversing_date]", getValue("String", row.getInvoiceLineReversingDate()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PreCalcPlanArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PreCalcPlanRow row : arrayList.getPreCalcPlanRow()){
            parameters.add("plan_item_service_no["+i+"]", getValue("Long", row.getPlanItemServiceNo()));
            parameters.add("plan_item_plan_no["+i+"]", getValue("Long", row.getPlanItemPlanNo()));
            parameters.add("plan_item_units["+i+"]", getValue("Double", row.getPlanItemUnits()));
            parameters.add("plan_item_unit_amount["+i+"]", getValue("Double", row.getPlanItemUnitAmount()));
            parameters.add("client_plan_item_service_id["+i+"]", getValue("String", row.getClientPlanItemServiceId()));
            parameters.add("client_plan_item_plan_id["+i+"]", getValue("String", row.getClientPlanItemPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PreCalcPlanArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PreCalcPlanRow row : arrayList.getPreCalcPlanRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_item_service_no]", getValue("Long", row.getPlanItemServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_item_plan_no]", getValue("Long", row.getPlanItemPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_item_units]", getValue("Double", row.getPlanItemUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_item_unit_amount]", getValue("Double", row.getPlanItemUnitAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_item_service_id]", getValue("String", row.getClientPlanItemServiceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_item_plan_id]", getValue("String", row.getClientPlanItemPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PreCalcSkuArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PreCalcSkuRow row : arrayList.getPreCalcSkuRow()){
            parameters.add("sku["+i+"]", getValue("String", row.getSku()));
            parameters.add("sku_plan_no["+i+"]", getValue("Long", row.getSkuPlanNo()));
            parameters.add("sku_units["+i+"]", getValue("Double", row.getSkuUnits()));
            parameters.add("sku_unit_amount["+i+"]", getValue("Double", row.getSkuUnitAmount()));
            parameters.add("client_sku_plan_id["+i+"]", getValue("String", row.getClientSkuPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PreCalcSkuArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PreCalcSkuRow row : arrayList.getPreCalcSkuRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[sku]", getValue("String", row.getSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[sku_plan_no]", getValue("Long", row.getSkuPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[sku_units]", getValue("Double", row.getSkuUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[sku_unit_amount]", getValue("Double", row.getSkuUnitAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku_plan_id]", getValue("String", row.getClientSkuPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InvoiceNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InvoiceNoRow row : arrayList.getInvoiceNoRow()){
            parameters.add("invoice_no["+i+"]", getValue("Long", row.getInvoiceNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InvoiceNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InvoiceNoRow row : arrayList.getInvoiceNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_no]", getValue("Long", row.getInvoiceNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.StandingOrderArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.StandingOrderRow row : arrayList.getStandingOrderRow()){
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("units["+i+"]", getValue("Double", row.getUnits()));
            parameters.add("amount["+i+"]", getValue("String", row.getAmount()));
            parameters.add("unit_discount_amount["+i+"]", getValue("String", row.getUnitDiscountAmount()));
            parameters.add("line_comments["+i+"]", getValue("String", row.getLineComments()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            parameters.add("client_defined_rate_schedule_id["+i+"]", getValue("String", row.getClientDefinedRateScheduleId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.StandingOrderArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.StandingOrderRow row : arrayList.getStandingOrderRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[units]", getValue("Double", row.getUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[amount]", getValue("String", row.getAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[unit_discount_amount]", getValue("String", row.getUnitDiscountAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[line_comments]", getValue("String", row.getLineComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_defined_rate_schedule_id]", getValue("String", row.getClientDefinedRateScheduleId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CreditCardPaymentMethodArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CreditCardPaymentMethodRow row : arrayList.getCreditCardPaymentMethodRow()){
            parameters.add("seq_no["+i+"]", getValue("Long", row.getSeqNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CreditCardPaymentMethodArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CreditCardPaymentMethodRow row : arrayList.getCreditCardPaymentMethodRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[seq_no]", getValue("Long", row.getSeqNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CustomAcctRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CustomAcctRatesRow row : arrayList.getCustomAcctRatesRow()){
            parameters.add("rate_seq_no["+i+"]", getValue("Long", row.getRateSeqNo()));
            parameters.add("rate_per_unit["+i+"]", getValue("Double", row.getRatePerUnit()));
            parameters.add("from_unit["+i+"]", getValue("Long", row.getFromUnit()));
            parameters.add("to_unit["+i+"]", getValue("Long", row.getToUnit()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CustomAcctRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CustomAcctRatesRow row : arrayList.getCustomAcctRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[rate_seq_no]", getValue("Long", row.getRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_per_unit]", getValue("Double", row.getRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[from_unit]", getValue("Long", row.getFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[to_unit]", getValue("Long", row.getToUnit()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NewAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NewAcctCustomRatesRow row : arrayList.getNewAcctCustomRatesRow()){
            parameters.add("custom_rate_plan_no["+i+"]", getValue("Long", row.getCustomRatePlanNo()));
            parameters.add("custom_rate_service_no["+i+"]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add("custom_rate_seq_no["+i+"]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add("custom_rate_from_unit["+i+"]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add("custom_rate_to_unit["+i+"]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add("custom_rate_per_unit["+i+"]", getValue("Double", row.getCustomRatePerUnit()));
            parameters.add("client_custom_rate_plan_id["+i+"]", getValue("String", row.getClientCustomRatePlanId()));
            parameters.add("client_custom_rate_service_id["+i+"]", getValue("String", row.getClientCustomRateServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NewAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NewAcctCustomRatesRow row : arrayList.getNewAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_plan_no]", getValue("Long", row.getCustomRatePlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_service_no]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_seq_no]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_from_unit]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_to_unit]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_per_unit]", getValue("Double", row.getCustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_custom_rate_plan_id]", getValue("String", row.getClientCustomRatePlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_custom_rate_service_id]", getValue("String", row.getClientCustomRateServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SurchargeNoRow row : arrayList.getSurchargeNoRow()){
            parameters.add("surcharge_no["+i+"]", getValue("Long", row.getSurchargeNo()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SurchargeNoRow row : arrayList.getSurchargeNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_no]", getValue("Long", row.getSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlansToAssignArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlansToAssignRow row : arrayList.getSuppPlansToAssignRow()){
            parameters.add("supp_plan_no["+i+"]", getValue("Long", row.getSuppPlanNo()));
            parameters.add("alt_rate_schedule_no["+i+"]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add("num_plan_units["+i+"]", getValue("Long", row.getNumPlanUnits()));
            parameters.add("contract_type_no["+i+"]", getValue("Long", row.getContractTypeNo()));
            parameters.add("contract_alt_recur_fee["+i+"]", getValue("Double", row.getContractAltRecurFee()));
            parameters.add("contract_length_months["+i+"]", getValue("Long", row.getContractLengthMonths()));
            parameters.add("contract_cancel_fee["+i+"]", getValue("Double", row.getContractCancelFee()));
            parameters.add("contract_comments["+i+"]", getValue("String", row.getContractComments()));
            parameters.add("contract_start_date["+i+"]", getValue("String", row.getContractStartDate()));
            parameters.add("offset_months["+i+"]", getValue("Long", row.getOffsetMonths()));
            parameters.add("auto_offset_months_option["+i+"]", getValue("Long", row.getAutoOffsetMonthsOption()));
            parameters.add("offset_interval["+i+"]", getValue("Long", row.getOffsetInterval()));
            parameters.add("contract_end_date["+i+"]", getValue("String", row.getContractEndDate()));
            parameters.add("client_supp_plan_id["+i+"]", getValue("String", row.getClientSuppPlanId()));
            parameters.add("client_alt_rate_schedule_id["+i+"]", getValue("String", row.getClientAltRateScheduleId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlansToAssignArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlansToAssignRow row : arrayList.getSuppPlansToAssignRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_plan_no]", getValue("Long", row.getSuppPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_rate_schedule_no]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[num_plan_units]", getValue("Long", row.getNumPlanUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_type_no]", getValue("Long", row.getContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_alt_recur_fee]", getValue("Double", row.getContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_length_months]", getValue("Long", row.getContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_cancel_fee]", getValue("Double", row.getContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_comments]", getValue("String", row.getContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_start_date]", getValue("String", row.getContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[offset_months]", getValue("Long", row.getOffsetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[auto_offset_months_option]", getValue("Long", row.getAutoOffsetMonthsOption()));
            parameters.add(paramPrefix + "["+i+"]" + "[offset_interval]", getValue("Long", row.getOffsetInterval()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_end_date]", getValue("String", row.getContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_supp_plan_id]", getValue("String", row.getClientSuppPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_alt_rate_schedule_id]", getValue("String", row.getClientAltRateScheduleId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CouponCodesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CouponCodesRow row : arrayList.getCouponCodesRow()){
            parameters.add("coupon_codes["+i+"]", getValue("String", row.getCouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CouponCodesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CouponCodesRow row : arrayList.getCouponCodesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[coupon_codes]", getValue("String", row.getCouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanSurchargesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanSurchargesRow row : arrayList.getSuppPlanSurchargesRow()){
            parameters.add("surcharge_no["+i+"]", getValue("Long", row.getSurchargeNo()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            parameters.add("surcharge_supp_plan_no["+i+"]", getValue("Long", row.getSurchargeSuppPlanNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanSurchargesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanSurchargesRow row : arrayList.getSuppPlanSurchargesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_no]", getValue("Long", row.getSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_supp_plan_no]", getValue("Long", row.getSurchargeSuppPlanNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanNoToRemoveArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanNoToRemoveRow row : arrayList.getPlanNoToRemoveRow()){
            parameters.add("queued_plan_no["+i+"]", getValue("Long", row.getQueuedPlanNo()));
            parameters.add("queued_client_plan_id["+i+"]", getValue("String", row.getQueuedClientPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanNoToRemoveArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanNoToRemoveRow row : arrayList.getPlanNoToRemoveRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[queued_plan_no]", getValue("Long", row.getQueuedPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[queued_client_plan_id]", getValue("String", row.getQueuedClientPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CreditIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CreditIdsRow row : arrayList.getCreditIdsRow()){
            parameters.add("credit_ids["+i+"]", getValue("String", row.getCreditIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CreditIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CreditIdsRow row : arrayList.getCreditIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[credit_ids]", getValue("String", row.getCreditIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlansRow row : arrayList.getSuppPlansRow()){
            parameters.add("supp_plans["+i+"]", getValue("Long", row.getSuppPlans()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlansRow row : arrayList.getSuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_plans]", getValue("Long", row.getSuppPlans()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanUnitsRow row : arrayList.getSuppPlanUnitsRow()){
            parameters.add("supp_plan_units["+i+"]", getValue("Long", row.getSuppPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanUnitsRow row : arrayList.getSuppPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_plan_units]", getValue("Long", row.getSuppPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.FunctionalAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.FunctionalAcctGroupsRow row : arrayList.getFunctionalAcctGroupsRow()){
            parameters.add("functional_acct_groups["+i+"]", getValue("Long", row.getFunctionalAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.FunctionalAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.FunctionalAcctGroupsRow row : arrayList.getFunctionalAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[functional_acct_groups]", getValue("Long", row.getFunctionalAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CollectionsAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CollectionsAcctGroupsRow row : arrayList.getCollectionsAcctGroupsRow()){
            parameters.add("collections_acct_groups["+i+"]", getValue("Long", row.getCollectionsAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CollectionsAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CollectionsAcctGroupsRow row : arrayList.getCollectionsAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[collections_acct_groups]", getValue("Long", row.getCollectionsAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppFieldNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppFieldNamesRow row : arrayList.getSuppFieldNamesRow()){
            parameters.add("supp_field_names["+i+"]", getValue("String", row.getSuppFieldNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppFieldNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppFieldNamesRow row : arrayList.getSuppFieldNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_names]", getValue("String", row.getSuppFieldNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppFieldValuesRow row : arrayList.getSuppFieldValuesRow()){
            parameters.add("supp_field_values["+i+"]", getValue("String", row.getSuppFieldValues()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppFieldValuesRow row : arrayList.getSuppFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_values]", getValue("String", row.getSuppFieldValues()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanAltRateSchedNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanAltRateSchedNoRow row : arrayList.getSuppPlanAltRateSchedNoRow()){
            parameters.add("supp_plan_alt_rate_sched_no["+i+"]", getValue("Long", row.getSuppPlanAltRateSchedNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanAltRateSchedNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanAltRateSchedNoRow row : arrayList.getSuppPlanAltRateSchedNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_plan_alt_rate_sched_no]", getValue("Long", row.getSuppPlanAltRateSchedNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NewAcctPlanContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NewAcctPlanContractsRow row : arrayList.getNewAcctPlanContractsRow()){
            parameters.add("contract_plan_no["+i+"]", getValue("Long", row.getContractPlanNo()));
            parameters.add("contract_type_no["+i+"]", getValue("Long", row.getContractTypeNo()));
            parameters.add("contract_alt_recur_fee["+i+"]", getValue("Double", row.getContractAltRecurFee()));
            parameters.add("contract_length_months["+i+"]", getValue("Long", row.getContractLengthMonths()));
            parameters.add("contract_cancel_fee["+i+"]", getValue("Double", row.getContractCancelFee()));
            parameters.add("contract_comments["+i+"]", getValue("String", row.getContractComments()));
            parameters.add("contract_start_date["+i+"]", getValue("String", row.getContractStartDate()));
            parameters.add("contract_end_date["+i+"]", getValue("String", row.getContractEndDate()));
            parameters.add("client_contract_plan_id["+i+"]", getValue("String", row.getClientContractPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NewAcctPlanContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NewAcctPlanContractsRow row : arrayList.getNewAcctPlanContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[contract_plan_no]", getValue("Long", row.getContractPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_type_no]", getValue("Long", row.getContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_alt_recur_fee]", getValue("Double", row.getContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_length_months]", getValue("Long", row.getContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_cancel_fee]", getValue("Double", row.getContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_comments]", getValue("String", row.getContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_start_date]", getValue("String", row.getContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_end_date]", getValue("String", row.getContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_contract_plan_id]", getValue("String", row.getClientContractPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageAccumulationConfigArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageAccumulationConfigRow row : arrayList.getUsageAccumulationConfigRow()){
            parameters.add("usage_accumulation_plan_no["+i+"]", getValue("Long", row.getUsageAccumulationPlanNo()));
            parameters.add("usage_accumulation_reset_months["+i+"]", getValue("Long", row.getUsageAccumulationResetMonths()));
            parameters.add("client_usage_accumulation_plan_id["+i+"]", getValue("String", row.getClientUsageAccumulationPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageAccumulationConfigArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageAccumulationConfigRow row : arrayList.getUsageAccumulationConfigRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[usage_accumulation_plan_no]", getValue("Long", row.getUsageAccumulationPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_accumulation_reset_months]", getValue("Long", row.getUsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_usage_accumulation_plan_id]", getValue("String", row.getClientUsageAccumulationPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EnableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EnableUsagePoolingPlanNoRow row : arrayList.getEnableUsagePoolingPlanNoRow()){
            parameters.add("enable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getEnableUsagePoolingPlanNo()));
            parameters.add("client_enable_usage_pool_plan_id["+i+"]", getValue("String", row.getClientEnableUsagePoolPlanId()));
            parameters.add("usage_threshold_applicability["+i+"]", getValue("String", row.getUsageThresholdApplicability()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EnableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EnableUsagePoolingPlanNoRow row : arrayList.getEnableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[enable_usage_pooling_plan_no]", getValue("Long", row.getEnableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_enable_usage_pool_plan_id]", getValue("String", row.getClientEnableUsagePoolPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_threshold_applicability]", getValue("String", row.getUsageThresholdApplicability()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientFuncAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientFuncAcctGroupIdsRow row : arrayList.getClientFuncAcctGroupIdsRow()){
            parameters.add("client_func_acct_group_ids["+i+"]", getValue("String", row.getClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientFuncAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientFuncAcctGroupIdsRow row : arrayList.getClientFuncAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_func_acct_group_ids]", getValue("String", row.getClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientCollAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientCollAcctGroupIdsRow row : arrayList.getClientCollAcctGroupIdsRow()){
            parameters.add("client_coll_acct_group_ids["+i+"]", getValue("String", row.getClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientCollAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientCollAcctGroupIdsRow row : arrayList.getClientCollAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_coll_acct_group_ids]", getValue("String", row.getClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientSuppPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientSuppPlanIdsRow row : arrayList.getClientSuppPlanIdsRow()){
            parameters.add("client_supp_plan_ids["+i+"]", getValue("String", row.getClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientSuppPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientSuppPlanIdsRow row : arrayList.getClientSuppPlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_supp_plan_ids]", getValue("String", row.getClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientSpAltRateSchedIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientSpAltRateSchedIdsRow row : arrayList.getClientSpAltRateSchedIdsRow()){
            parameters.add("client_sp_alt_rate_sched_ids["+i+"]", getValue("String", row.getClientSpAltRateSchedIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientSpAltRateSchedIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientSpAltRateSchedIdsRow row : arrayList.getClientSpAltRateSchedIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sp_alt_rate_sched_ids]", getValue("String", row.getClientSpAltRateSchedIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppPlansRow row : arrayList.getA1SuppPlansRow()){
            parameters.add("a1_supp_plans["+i+"]", getValue("Long", row.getA1SuppPlans()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppPlansRow row : arrayList.getA1SuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_supp_plans]", getValue("Long", row.getA1SuppPlans()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppPlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppPlanUnitsRow row : arrayList.getA1SuppPlanUnitsRow()){
            parameters.add("a1_supp_plan_units["+i+"]", getValue("Long", row.getA1SuppPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppPlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppPlanUnitsRow row : arrayList.getA1SuppPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_supp_plan_units]", getValue("Long", row.getA1SuppPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1FunctionalAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1FunctionalAcctGroupsRow row : arrayList.getA1FunctionalAcctGroupsRow()){
            parameters.add("a1_functional_acct_groups["+i+"]", getValue("Long", row.getA1FunctionalAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1FunctionalAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1FunctionalAcctGroupsRow row : arrayList.getA1FunctionalAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_functional_acct_groups]", getValue("Long", row.getA1FunctionalAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1CollectionsAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1CollectionsAcctGroupsRow row : arrayList.getA1CollectionsAcctGroupsRow()){
            parameters.add("a1_collections_acct_groups["+i+"]", getValue("Long", row.getA1CollectionsAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1CollectionsAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1CollectionsAcctGroupsRow row : arrayList.getA1CollectionsAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_collections_acct_groups]", getValue("Long", row.getA1CollectionsAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppFieldNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppFieldNamesRow row : arrayList.getA1SuppFieldNamesRow()){
            parameters.add("a1_supp_field_names["+i+"]", getValue("String", row.getA1SuppFieldNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppFieldNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppFieldNamesRow row : arrayList.getA1SuppFieldNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_supp_field_names]", getValue("String", row.getA1SuppFieldNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppFieldValuesRow row : arrayList.getA1SuppFieldValuesRow()){
            parameters.add("a1_supp_field_values["+i+"]", getValue("String", row.getA1SuppFieldValues()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppFieldValuesRow row : arrayList.getA1SuppFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_supp_field_values]", getValue("String", row.getA1SuppFieldValues()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppPlanAltRateSchedNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppPlanAltRateSchedNoRow row : arrayList.getA1SuppPlanAltRateSchedNoRow()){
            parameters.add("a1_supp_plan_alt_rate_sched_no["+i+"]", getValue("Long", row.getA1SuppPlanAltRateSchedNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SuppPlanAltRateSchedNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SuppPlanAltRateSchedNoRow row : arrayList.getA1SuppPlanAltRateSchedNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_supp_plan_alt_rate_sched_no]", getValue("Long", row.getA1SuppPlanAltRateSchedNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1CouponCodesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1CouponCodesRow row : arrayList.getA1CouponCodesRow()){
            parameters.add("a1_coupon_codes["+i+"]", getValue("String", row.getA1CouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1CouponCodesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1CouponCodesRow row : arrayList.getA1CouponCodesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_coupon_codes]", getValue("String", row.getA1CouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1NewAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1NewAcctCustomRatesRow row : arrayList.getA1NewAcctCustomRatesRow()){
            parameters.add("a1_custom_rate_plan_no["+i+"]", getValue("Long", row.getA1CustomRatePlanNo()));
            parameters.add("a1_custom_rate_service_no["+i+"]", getValue("Long", row.getA1CustomRateServiceNo()));
            parameters.add("a1_custom_rate_seq_no["+i+"]", getValue("Long", row.getA1CustomRateSeqNo()));
            parameters.add("a1_custom_rate_from_unit["+i+"]", getValue("Long", row.getA1CustomRateFromUnit()));
            parameters.add("a1_custom_rate_to_unit["+i+"]", getValue("Long", row.getA1CustomRateToUnit()));
            parameters.add("a1_custom_rate_per_unit["+i+"]", getValue("Double", row.getA1CustomRatePerUnit()));
            parameters.add("a1_client_custom_rate_plan_id["+i+"]", getValue("String", row.getA1ClientCustomRatePlanId()));
            parameters.add("a1_client_custom_rate_service_id["+i+"]", getValue("String", row.getA1ClientCustomRateServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1NewAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1NewAcctCustomRatesRow row : arrayList.getA1NewAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_custom_rate_plan_no]", getValue("Long", row.getA1CustomRatePlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_custom_rate_service_no]", getValue("Long", row.getA1CustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_custom_rate_seq_no]", getValue("Long", row.getA1CustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_custom_rate_from_unit]", getValue("Long", row.getA1CustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_custom_rate_to_unit]", getValue("Long", row.getA1CustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_custom_rate_per_unit]", getValue("Double", row.getA1CustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_custom_rate_plan_id]", getValue("String", row.getA1ClientCustomRatePlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_custom_rate_service_id]", getValue("String", row.getA1ClientCustomRateServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1NewAcctPlanContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1NewAcctPlanContractsRow row : arrayList.getA1NewAcctPlanContractsRow()){
            parameters.add("a1_contract_plan_no["+i+"]", getValue("Long", row.getA1ContractPlanNo()));
            parameters.add("a1_contract_type_no["+i+"]", getValue("Long", row.getA1ContractTypeNo()));
            parameters.add("a1_contract_alt_recur_fee["+i+"]", getValue("Double", row.getA1ContractAltRecurFee()));
            parameters.add("a1_contract_length_months["+i+"]", getValue("Long", row.getA1ContractLengthMonths()));
            parameters.add("a1_contract_cancel_fee["+i+"]", getValue("Double", row.getA1ContractCancelFee()));
            parameters.add("a1_contract_comments["+i+"]", getValue("String", row.getA1ContractComments()));
            parameters.add("a1_contract_start_date["+i+"]", getValue("String", row.getA1ContractStartDate()));
            parameters.add("a1_contract_end_date["+i+"]", getValue("String", row.getA1ContractEndDate()));
            parameters.add("a1_client_contract_plan_id["+i+"]", getValue("String", row.getA1ClientContractPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1NewAcctPlanContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1NewAcctPlanContractsRow row : arrayList.getA1NewAcctPlanContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_plan_no]", getValue("Long", row.getA1ContractPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_type_no]", getValue("Long", row.getA1ContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_alt_recur_fee]", getValue("Double", row.getA1ContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_length_months]", getValue("Long", row.getA1ContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_cancel_fee]", getValue("Double", row.getA1ContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_comments]", getValue("String", row.getA1ContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_start_date]", getValue("String", row.getA1ContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_contract_end_date]", getValue("String", row.getA1ContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_contract_plan_id]", getValue("String", row.getA1ClientContractPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1UsageAccumulationConfigArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1UsageAccumulationConfigRow row : arrayList.getA1UsageAccumulationConfigRow()){
            parameters.add("a1_usage_accumulation_plan_no["+i+"]", getValue("Long", row.getA1UsageAccumulationPlanNo()));
            parameters.add("a1_usage_accumulation_reset_months["+i+"]", getValue("Long", row.getA1UsageAccumulationResetMonths()));
            parameters.add("a1_client_usg_accum_plan_id["+i+"]", getValue("String", row.getA1ClientUsgAccumPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1UsageAccumulationConfigArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1UsageAccumulationConfigRow row : arrayList.getA1UsageAccumulationConfigRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_usage_accumulation_plan_no]", getValue("Long", row.getA1UsageAccumulationPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_usage_accumulation_reset_months]", getValue("Long", row.getA1UsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_usg_accum_plan_id]", getValue("String", row.getA1ClientUsgAccumPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1EnableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1EnableUsagePoolingPlanNoRow row : arrayList.getA1EnableUsagePoolingPlanNoRow()){
            parameters.add("a1_enable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getA1EnableUsagePoolingPlanNo()));
            parameters.add("a1_client_enable_usg_pool_plan_id["+i+"]", getValue("String", row.getA1ClientEnableUsgPoolPlanId()));
            parameters.add("a1_usage_threshold_applicability["+i+"]", getValue("String", row.getA1UsageThresholdApplicability()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1EnableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1EnableUsagePoolingPlanNoRow row : arrayList.getA1EnableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_enable_usage_pooling_plan_no]", getValue("Long", row.getA1EnableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_enable_usg_pool_plan_id]", getValue("String", row.getA1ClientEnableUsgPoolPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_usage_threshold_applicability]", getValue("String", row.getA1UsageThresholdApplicability()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientFuncAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientFuncAcctGroupIdsRow row : arrayList.getA1ClientFuncAcctGroupIdsRow()){
            parameters.add("a1_client_func_acct_group_ids["+i+"]", getValue("String", row.getA1ClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientFuncAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientFuncAcctGroupIdsRow row : arrayList.getA1ClientFuncAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_func_acct_group_ids]", getValue("String", row.getA1ClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientCollAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientCollAcctGroupIdsRow row : arrayList.getA1ClientCollAcctGroupIdsRow()){
            parameters.add("a1_client_coll_acct_group_ids["+i+"]", getValue("String", row.getA1ClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientCollAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientCollAcctGroupIdsRow row : arrayList.getA1ClientCollAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_coll_acct_group_ids]", getValue("String", row.getA1ClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientSuppPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientSuppPlanIdsRow row : arrayList.getA1ClientSuppPlanIdsRow()){
            parameters.add("a1_client_supp_plan_ids["+i+"]", getValue("String", row.getA1ClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientSuppPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientSuppPlanIdsRow row : arrayList.getA1ClientSuppPlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_supp_plan_ids]", getValue("String", row.getA1ClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientSpAltRateSchedIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientSpAltRateSchedIdsRow row : arrayList.getA1ClientSpAltRateSchedIdsRow()){
            parameters.add("a1_client_sp_alt_rate_sched_ids["+i+"]", getValue("String", row.getA1ClientSpAltRateSchedIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1ClientSpAltRateSchedIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1ClientSpAltRateSchedIdsRow row : arrayList.getA1ClientSpAltRateSchedIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_client_sp_alt_rate_sched_ids]", getValue("String", row.getA1ClientSpAltRateSchedIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SurchargeNoRow row : arrayList.getA1SurchargeNoRow()){
            parameters.add("a1_surcharge_no["+i+"]", getValue("Long", row.getA1SurchargeNo()));
            parameters.add("a1_rate_schedule_no["+i+"]", getValue("Long", row.getA1RateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A1SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A1SurchargeNoRow row : arrayList.getA1SurchargeNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a1_surcharge_no]", getValue("Long", row.getA1SurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a1_rate_schedule_no]", getValue("Long", row.getA1RateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppPlansRow row : arrayList.getA2SuppPlansRow()){
            parameters.add("a2_supp_plans["+i+"]", getValue("Long", row.getA2SuppPlans()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppPlansRow row : arrayList.getA2SuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_supp_plans]", getValue("Long", row.getA2SuppPlans()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppPlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppPlanUnitsRow row : arrayList.getA2SuppPlanUnitsRow()){
            parameters.add("a2_supp_plan_units["+i+"]", getValue("Long", row.getA2SuppPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppPlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppPlanUnitsRow row : arrayList.getA2SuppPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_supp_plan_units]", getValue("Long", row.getA2SuppPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2FunctionalAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2FunctionalAcctGroupsRow row : arrayList.getA2FunctionalAcctGroupsRow()){
            parameters.add("a2_functional_acct_groups["+i+"]", getValue("Long", row.getA2FunctionalAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2FunctionalAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2FunctionalAcctGroupsRow row : arrayList.getA2FunctionalAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_functional_acct_groups]", getValue("Long", row.getA2FunctionalAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2CollectionsAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2CollectionsAcctGroupsRow row : arrayList.getA2CollectionsAcctGroupsRow()){
            parameters.add("a2_collections_acct_groups["+i+"]", getValue("Long", row.getA2CollectionsAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2CollectionsAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2CollectionsAcctGroupsRow row : arrayList.getA2CollectionsAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_collections_acct_groups]", getValue("Long", row.getA2CollectionsAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppFieldNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppFieldNamesRow row : arrayList.getA2SuppFieldNamesRow()){
            parameters.add("a2_supp_field_names["+i+"]", getValue("String", row.getA2SuppFieldNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppFieldNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppFieldNamesRow row : arrayList.getA2SuppFieldNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_supp_field_names]", getValue("String", row.getA2SuppFieldNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppFieldValuesRow row : arrayList.getA2SuppFieldValuesRow()){
            parameters.add("a2_supp_field_values["+i+"]", getValue("String", row.getA2SuppFieldValues()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppFieldValuesRow row : arrayList.getA2SuppFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_supp_field_values]", getValue("String", row.getA2SuppFieldValues()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppPlanAltRateSchedNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppPlanAltRateSchedNoRow row : arrayList.getA2SuppPlanAltRateSchedNoRow()){
            parameters.add("a2_supp_plan_alt_rate_sched_no["+i+"]", getValue("Long", row.getA2SuppPlanAltRateSchedNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SuppPlanAltRateSchedNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SuppPlanAltRateSchedNoRow row : arrayList.getA2SuppPlanAltRateSchedNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_supp_plan_alt_rate_sched_no]", getValue("Long", row.getA2SuppPlanAltRateSchedNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2CouponCodesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2CouponCodesRow row : arrayList.getA2CouponCodesRow()){
            parameters.add("a2_coupon_codes["+i+"]", getValue("String", row.getA2CouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2CouponCodesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2CouponCodesRow row : arrayList.getA2CouponCodesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_coupon_codes]", getValue("String", row.getA2CouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2NewAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2NewAcctCustomRatesRow row : arrayList.getA2NewAcctCustomRatesRow()){
            parameters.add("a2_custom_rate_plan_no["+i+"]", getValue("Long", row.getA2CustomRatePlanNo()));
            parameters.add("a2_custom_rate_service_no["+i+"]", getValue("Long", row.getA2CustomRateServiceNo()));
            parameters.add("a2_custom_rate_seq_no["+i+"]", getValue("Long", row.getA2CustomRateSeqNo()));
            parameters.add("a2_custom_rate_from_unit["+i+"]", getValue("Long", row.getA2CustomRateFromUnit()));
            parameters.add("a2_custom_rate_to_unit["+i+"]", getValue("Long", row.getA2CustomRateToUnit()));
            parameters.add("a2_custom_rate_per_unit["+i+"]", getValue("Double", row.getA2CustomRatePerUnit()));
            parameters.add("a2_client_custom_rate_plan_id["+i+"]", getValue("String", row.getA2ClientCustomRatePlanId()));
            parameters.add("a2_client_custom_rate_service_id["+i+"]", getValue("String", row.getA2ClientCustomRateServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2NewAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2NewAcctCustomRatesRow row : arrayList.getA2NewAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_custom_rate_plan_no]", getValue("Long", row.getA2CustomRatePlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_custom_rate_service_no]", getValue("Long", row.getA2CustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_custom_rate_seq_no]", getValue("Long", row.getA2CustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_custom_rate_from_unit]", getValue("Long", row.getA2CustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_custom_rate_to_unit]", getValue("Long", row.getA2CustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_custom_rate_per_unit]", getValue("Double", row.getA2CustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_custom_rate_plan_id]", getValue("String", row.getA2ClientCustomRatePlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_custom_rate_service_id]", getValue("String", row.getA2ClientCustomRateServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2NewAcctPlanContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2NewAcctPlanContractsRow row : arrayList.getA2NewAcctPlanContractsRow()){
            parameters.add("a2_contract_plan_no["+i+"]", getValue("Long", row.getA2ContractPlanNo()));
            parameters.add("a2_contract_type_no["+i+"]", getValue("Long", row.getA2ContractTypeNo()));
            parameters.add("a2_contract_alt_recur_fee["+i+"]", getValue("Double", row.getA2ContractAltRecurFee()));
            parameters.add("a2_contract_length_months["+i+"]", getValue("Long", row.getA2ContractLengthMonths()));
            parameters.add("a2_contract_cancel_fee["+i+"]", getValue("Double", row.getA2ContractCancelFee()));
            parameters.add("a2_contract_comments["+i+"]", getValue("String", row.getA2ContractComments()));
            parameters.add("a2_contract_start_date["+i+"]", getValue("String", row.getA2ContractStartDate()));
            parameters.add("a2_contract_end_date["+i+"]", getValue("String", row.getA2ContractEndDate()));
            parameters.add("a2_client_contract_plan_id["+i+"]", getValue("String", row.getA2ClientContractPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2NewAcctPlanContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2NewAcctPlanContractsRow row : arrayList.getA2NewAcctPlanContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_plan_no]", getValue("Long", row.getA2ContractPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_type_no]", getValue("Long", row.getA2ContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_alt_recur_fee]", getValue("Double", row.getA2ContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_length_months]", getValue("Long", row.getA2ContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_cancel_fee]", getValue("Double", row.getA2ContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_comments]", getValue("String", row.getA2ContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_start_date]", getValue("String", row.getA2ContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_contract_end_date]", getValue("String", row.getA2ContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_contract_plan_id]", getValue("String", row.getA2ClientContractPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2UsageAccumulationConfigArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2UsageAccumulationConfigRow row : arrayList.getA2UsageAccumulationConfigRow()){
            parameters.add("a2_usage_accumulation_plan_no["+i+"]", getValue("Long", row.getA2UsageAccumulationPlanNo()));
            parameters.add("a2_usage_accumulation_reset_months["+i+"]", getValue("Long", row.getA2UsageAccumulationResetMonths()));
            parameters.add("a2_client_usg_accum_plan_id["+i+"]", getValue("String", row.getA2ClientUsgAccumPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2UsageAccumulationConfigArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2UsageAccumulationConfigRow row : arrayList.getA2UsageAccumulationConfigRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_usage_accumulation_plan_no]", getValue("Long", row.getA2UsageAccumulationPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_usage_accumulation_reset_months]", getValue("Long", row.getA2UsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_usg_accum_plan_id]", getValue("String", row.getA2ClientUsgAccumPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2EnableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2EnableUsagePoolingPlanNoRow row : arrayList.getA2EnableUsagePoolingPlanNoRow()){
            parameters.add("a2_enable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getA2EnableUsagePoolingPlanNo()));
            parameters.add("a2_client_enable_usg_pool_plan_id["+i+"]", getValue("String", row.getA2ClientEnableUsgPoolPlanId()));
            parameters.add("a2_usage_threshold_applicability["+i+"]", getValue("String", row.getA2UsageThresholdApplicability()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2EnableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2EnableUsagePoolingPlanNoRow row : arrayList.getA2EnableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_enable_usage_pooling_plan_no]", getValue("Long", row.getA2EnableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_enable_usg_pool_plan_id]", getValue("String", row.getA2ClientEnableUsgPoolPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_usage_threshold_applicability]", getValue("String", row.getA2UsageThresholdApplicability()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientFuncAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientFuncAcctGroupIdsRow row : arrayList.getA2ClientFuncAcctGroupIdsRow()){
            parameters.add("a2_client_func_acct_group_ids["+i+"]", getValue("String", row.getA2ClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientFuncAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientFuncAcctGroupIdsRow row : arrayList.getA2ClientFuncAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_func_acct_group_ids]", getValue("String", row.getA2ClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientCollAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientCollAcctGroupIdsRow row : arrayList.getA2ClientCollAcctGroupIdsRow()){
            parameters.add("a2_client_coll_acct_group_ids["+i+"]", getValue("String", row.getA2ClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientCollAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientCollAcctGroupIdsRow row : arrayList.getA2ClientCollAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_coll_acct_group_ids]", getValue("String", row.getA2ClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientSuppPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientSuppPlanIdsRow row : arrayList.getA2ClientSuppPlanIdsRow()){
            parameters.add("a2_client_supp_plan_ids["+i+"]", getValue("String", row.getA2ClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientSuppPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientSuppPlanIdsRow row : arrayList.getA2ClientSuppPlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_supp_plan_ids]", getValue("String", row.getA2ClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientSpAltRateSchedIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientSpAltRateSchedIdsRow row : arrayList.getA2ClientSpAltRateSchedIdsRow()){
            parameters.add("a2_client_sp_alt_rate_sched_ids["+i+"]", getValue("String", row.getA2ClientSpAltRateSchedIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2ClientSpAltRateSchedIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2ClientSpAltRateSchedIdsRow row : arrayList.getA2ClientSpAltRateSchedIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_client_sp_alt_rate_sched_ids]", getValue("String", row.getA2ClientSpAltRateSchedIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SurchargeNoRow row : arrayList.getA2SurchargeNoRow()){
            parameters.add("a2_surcharge_no["+i+"]", getValue("Long", row.getA2SurchargeNo()));
            parameters.add("a2_rate_schedule_no["+i+"]", getValue("Long", row.getA2RateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A2SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A2SurchargeNoRow row : arrayList.getA2SurchargeNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a2_surcharge_no]", getValue("Long", row.getA2SurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a2_rate_schedule_no]", getValue("Long", row.getA2RateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppPlansRow row : arrayList.getA3SuppPlansRow()){
            parameters.add("a3_supp_plans["+i+"]", getValue("Long", row.getA3SuppPlans()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppPlansRow row : arrayList.getA3SuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_supp_plans]", getValue("Long", row.getA3SuppPlans()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppPlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppPlanUnitsRow row : arrayList.getA3SuppPlanUnitsRow()){
            parameters.add("a3_supp_plan_units["+i+"]", getValue("Long", row.getA3SuppPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppPlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppPlanUnitsRow row : arrayList.getA3SuppPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_supp_plan_units]", getValue("Long", row.getA3SuppPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3FunctionalAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3FunctionalAcctGroupsRow row : arrayList.getA3FunctionalAcctGroupsRow()){
            parameters.add("a3_functional_acct_groups["+i+"]", getValue("Long", row.getA3FunctionalAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3FunctionalAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3FunctionalAcctGroupsRow row : arrayList.getA3FunctionalAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_functional_acct_groups]", getValue("Long", row.getA3FunctionalAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3CollectionsAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3CollectionsAcctGroupsRow row : arrayList.getA3CollectionsAcctGroupsRow()){
            parameters.add("a3_collections_acct_groups["+i+"]", getValue("Long", row.getA3CollectionsAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3CollectionsAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3CollectionsAcctGroupsRow row : arrayList.getA3CollectionsAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_collections_acct_groups]", getValue("Long", row.getA3CollectionsAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppFieldNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppFieldNamesRow row : arrayList.getA3SuppFieldNamesRow()){
            parameters.add("a3_supp_field_names["+i+"]", getValue("String", row.getA3SuppFieldNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppFieldNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppFieldNamesRow row : arrayList.getA3SuppFieldNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_supp_field_names]", getValue("String", row.getA3SuppFieldNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppFieldValuesRow row : arrayList.getA3SuppFieldValuesRow()){
            parameters.add("a3_supp_field_values["+i+"]", getValue("String", row.getA3SuppFieldValues()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppFieldValuesRow row : arrayList.getA3SuppFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_supp_field_values]", getValue("String", row.getA3SuppFieldValues()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppPlanAltRateSchedNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppPlanAltRateSchedNoRow row : arrayList.getA3SuppPlanAltRateSchedNoRow()){
            parameters.add("a3_supp_plan_alt_rate_sched_no["+i+"]", getValue("Long", row.getA3SuppPlanAltRateSchedNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SuppPlanAltRateSchedNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SuppPlanAltRateSchedNoRow row : arrayList.getA3SuppPlanAltRateSchedNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_supp_plan_alt_rate_sched_no]", getValue("Long", row.getA3SuppPlanAltRateSchedNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3CouponCodesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3CouponCodesRow row : arrayList.getA3CouponCodesRow()){
            parameters.add("a3_coupon_codes["+i+"]", getValue("String", row.getA3CouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3CouponCodesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3CouponCodesRow row : arrayList.getA3CouponCodesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_coupon_codes]", getValue("String", row.getA3CouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3NewAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3NewAcctCustomRatesRow row : arrayList.getA3NewAcctCustomRatesRow()){
            parameters.add("a3_custom_rate_plan_no["+i+"]", getValue("Long", row.getA3CustomRatePlanNo()));
            parameters.add("a3_custom_rate_service_no["+i+"]", getValue("Long", row.getA3CustomRateServiceNo()));
            parameters.add("a3_custom_rate_seq_no["+i+"]", getValue("Long", row.getA3CustomRateSeqNo()));
            parameters.add("a3_custom_rate_from_unit["+i+"]", getValue("Long", row.getA3CustomRateFromUnit()));
            parameters.add("a3_custom_rate_to_unit["+i+"]", getValue("Long", row.getA3CustomRateToUnit()));
            parameters.add("a3_custom_rate_per_unit["+i+"]", getValue("Double", row.getA3CustomRatePerUnit()));
            parameters.add("a3_client_custom_rate_plan_id["+i+"]", getValue("String", row.getA3ClientCustomRatePlanId()));
            parameters.add("a3_client_custom_rate_service_id["+i+"]", getValue("String", row.getA3ClientCustomRateServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3NewAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3NewAcctCustomRatesRow row : arrayList.getA3NewAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_custom_rate_plan_no]", getValue("Long", row.getA3CustomRatePlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_custom_rate_service_no]", getValue("Long", row.getA3CustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_custom_rate_seq_no]", getValue("Long", row.getA3CustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_custom_rate_from_unit]", getValue("Long", row.getA3CustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_custom_rate_to_unit]", getValue("Long", row.getA3CustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_custom_rate_per_unit]", getValue("Double", row.getA3CustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_custom_rate_plan_id]", getValue("String", row.getA3ClientCustomRatePlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_custom_rate_service_id]", getValue("String", row.getA3ClientCustomRateServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3NewAcctPlanContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3NewAcctPlanContractsRow row : arrayList.getA3NewAcctPlanContractsRow()){
            parameters.add("a3_contract_plan_no["+i+"]", getValue("Long", row.getA3ContractPlanNo()));
            parameters.add("a3_contract_type_no["+i+"]", getValue("Long", row.getA3ContractTypeNo()));
            parameters.add("a3_contract_alt_recur_fee["+i+"]", getValue("Double", row.getA3ContractAltRecurFee()));
            parameters.add("a3_contract_length_months["+i+"]", getValue("Long", row.getA3ContractLengthMonths()));
            parameters.add("a3_contract_cancel_fee["+i+"]", getValue("Double", row.getA3ContractCancelFee()));
            parameters.add("a3_contract_comments["+i+"]", getValue("String", row.getA3ContractComments()));
            parameters.add("a3_contract_start_date["+i+"]", getValue("String", row.getA3ContractStartDate()));
            parameters.add("a3_contract_end_date["+i+"]", getValue("String", row.getA3ContractEndDate()));
            parameters.add("a3_client_contract_plan_id["+i+"]", getValue("String", row.getA3ClientContractPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3NewAcctPlanContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3NewAcctPlanContractsRow row : arrayList.getA3NewAcctPlanContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_plan_no]", getValue("Long", row.getA3ContractPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_type_no]", getValue("Long", row.getA3ContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_alt_recur_fee]", getValue("Double", row.getA3ContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_length_months]", getValue("Long", row.getA3ContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_cancel_fee]", getValue("Double", row.getA3ContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_comments]", getValue("String", row.getA3ContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_start_date]", getValue("String", row.getA3ContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_contract_end_date]", getValue("String", row.getA3ContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_contract_plan_id]", getValue("String", row.getA3ClientContractPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3UsageAccumulationConfigArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3UsageAccumulationConfigRow row : arrayList.getA3UsageAccumulationConfigRow()){
            parameters.add("a3_usage_accumulation_plan_no["+i+"]", getValue("Long", row.getA3UsageAccumulationPlanNo()));
            parameters.add("a3_usage_accumulation_reset_months["+i+"]", getValue("Long", row.getA3UsageAccumulationResetMonths()));
            parameters.add("a3_client_usg_accum_plan_id["+i+"]", getValue("String", row.getA3ClientUsgAccumPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3UsageAccumulationConfigArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3UsageAccumulationConfigRow row : arrayList.getA3UsageAccumulationConfigRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_usage_accumulation_plan_no]", getValue("Long", row.getA3UsageAccumulationPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_usage_accumulation_reset_months]", getValue("Long", row.getA3UsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_usg_accum_plan_id]", getValue("String", row.getA3ClientUsgAccumPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3EnableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3EnableUsagePoolingPlanNoRow row : arrayList.getA3EnableUsagePoolingPlanNoRow()){
            parameters.add("a3_enable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getA3EnableUsagePoolingPlanNo()));
            parameters.add("a3_client_enable_usg_pool_plan_id["+i+"]", getValue("String", row.getA3ClientEnableUsgPoolPlanId()));
            parameters.add("a3_usage_threshold_applicability["+i+"]", getValue("String", row.getA3UsageThresholdApplicability()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3EnableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3EnableUsagePoolingPlanNoRow row : arrayList.getA3EnableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_enable_usage_pooling_plan_no]", getValue("Long", row.getA3EnableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_enable_usg_pool_plan_id]", getValue("String", row.getA3ClientEnableUsgPoolPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_usage_threshold_applicability]", getValue("String", row.getA3UsageThresholdApplicability()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientFuncAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientFuncAcctGroupIdsRow row : arrayList.getA3ClientFuncAcctGroupIdsRow()){
            parameters.add("a3_client_func_acct_group_ids["+i+"]", getValue("String", row.getA3ClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientFuncAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientFuncAcctGroupIdsRow row : arrayList.getA3ClientFuncAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_func_acct_group_ids]", getValue("String", row.getA3ClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientCollAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientCollAcctGroupIdsRow row : arrayList.getA3ClientCollAcctGroupIdsRow()){
            parameters.add("a3_client_coll_acct_group_ids["+i+"]", getValue("String", row.getA3ClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientCollAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientCollAcctGroupIdsRow row : arrayList.getA3ClientCollAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_coll_acct_group_ids]", getValue("String", row.getA3ClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientSuppPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientSuppPlanIdsRow row : arrayList.getA3ClientSuppPlanIdsRow()){
            parameters.add("a3_client_supp_plan_ids["+i+"]", getValue("String", row.getA3ClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientSuppPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientSuppPlanIdsRow row : arrayList.getA3ClientSuppPlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_supp_plan_ids]", getValue("String", row.getA3ClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientSpAltRateSchedIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientSpAltRateSchedIdsRow row : arrayList.getA3ClientSpAltRateSchedIdsRow()){
            parameters.add("a3_client_sp_alt_rate_sched_ids["+i+"]", getValue("String", row.getA3ClientSpAltRateSchedIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3ClientSpAltRateSchedIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3ClientSpAltRateSchedIdsRow row : arrayList.getA3ClientSpAltRateSchedIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_client_sp_alt_rate_sched_ids]", getValue("String", row.getA3ClientSpAltRateSchedIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SurchargeNoRow row : arrayList.getA3SurchargeNoRow()){
            parameters.add("a3_surcharge_no["+i+"]", getValue("Long", row.getA3SurchargeNo()));
            parameters.add("a3_rate_schedule_no["+i+"]", getValue("Long", row.getA3RateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A3SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A3SurchargeNoRow row : arrayList.getA3SurchargeNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a3_surcharge_no]", getValue("Long", row.getA3SurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a3_rate_schedule_no]", getValue("Long", row.getA3RateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppPlansRow row : arrayList.getA4SuppPlansRow()){
            parameters.add("a4_supp_plans["+i+"]", getValue("Long", row.getA4SuppPlans()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppPlansRow row : arrayList.getA4SuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_supp_plans]", getValue("Long", row.getA4SuppPlans()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppPlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppPlanUnitsRow row : arrayList.getA4SuppPlanUnitsRow()){
            parameters.add("a4_supp_plan_units["+i+"]", getValue("Long", row.getA4SuppPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppPlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppPlanUnitsRow row : arrayList.getA4SuppPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_supp_plan_units]", getValue("Long", row.getA4SuppPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4FunctionalAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4FunctionalAcctGroupsRow row : arrayList.getA4FunctionalAcctGroupsRow()){
            parameters.add("a4_functional_acct_groups["+i+"]", getValue("Long", row.getA4FunctionalAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4FunctionalAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4FunctionalAcctGroupsRow row : arrayList.getA4FunctionalAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_functional_acct_groups]", getValue("Long", row.getA4FunctionalAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4CollectionsAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4CollectionsAcctGroupsRow row : arrayList.getA4CollectionsAcctGroupsRow()){
            parameters.add("a4_collections_acct_groups["+i+"]", getValue("Long", row.getA4CollectionsAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4CollectionsAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4CollectionsAcctGroupsRow row : arrayList.getA4CollectionsAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_collections_acct_groups]", getValue("Long", row.getA4CollectionsAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppFieldNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppFieldNamesRow row : arrayList.getA4SuppFieldNamesRow()){
            parameters.add("a4_supp_field_names["+i+"]", getValue("String", row.getA4SuppFieldNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppFieldNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppFieldNamesRow row : arrayList.getA4SuppFieldNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_supp_field_names]", getValue("String", row.getA4SuppFieldNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppFieldValuesRow row : arrayList.getA4SuppFieldValuesRow()){
            parameters.add("a4_supp_field_values["+i+"]", getValue("String", row.getA4SuppFieldValues()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppFieldValuesRow row : arrayList.getA4SuppFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_supp_field_values]", getValue("String", row.getA4SuppFieldValues()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppPlanAltRateSchedNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppPlanAltRateSchedNoRow row : arrayList.getA4SuppPlanAltRateSchedNoRow()){
            parameters.add("a4_supp_plan_alt_rate_sched_no["+i+"]", getValue("Long", row.getA4SuppPlanAltRateSchedNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SuppPlanAltRateSchedNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SuppPlanAltRateSchedNoRow row : arrayList.getA4SuppPlanAltRateSchedNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_supp_plan_alt_rate_sched_no]", getValue("Long", row.getA4SuppPlanAltRateSchedNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4CouponCodesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4CouponCodesRow row : arrayList.getA4CouponCodesRow()){
            parameters.add("a4_coupon_codes["+i+"]", getValue("String", row.getA4CouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4CouponCodesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4CouponCodesRow row : arrayList.getA4CouponCodesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_coupon_codes]", getValue("String", row.getA4CouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4NewAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4NewAcctCustomRatesRow row : arrayList.getA4NewAcctCustomRatesRow()){
            parameters.add("a4_custom_rate_plan_no["+i+"]", getValue("Long", row.getA4CustomRatePlanNo()));
            parameters.add("a4_custom_rate_service_no["+i+"]", getValue("Long", row.getA4CustomRateServiceNo()));
            parameters.add("a4_custom_rate_seq_no["+i+"]", getValue("Long", row.getA4CustomRateSeqNo()));
            parameters.add("a4_custom_rate_from_unit["+i+"]", getValue("Long", row.getA4CustomRateFromUnit()));
            parameters.add("a4_custom_rate_to_unit["+i+"]", getValue("Long", row.getA4CustomRateToUnit()));
            parameters.add("a4_custom_rate_per_unit["+i+"]", getValue("Double", row.getA4CustomRatePerUnit()));
            parameters.add("a4_client_custom_rate_plan_id["+i+"]", getValue("String", row.getA4ClientCustomRatePlanId()));
            parameters.add("a4_client_custom_rate_service_id["+i+"]", getValue("String", row.getA4ClientCustomRateServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4NewAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4NewAcctCustomRatesRow row : arrayList.getA4NewAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_custom_rate_plan_no]", getValue("Long", row.getA4CustomRatePlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_custom_rate_service_no]", getValue("Long", row.getA4CustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_custom_rate_seq_no]", getValue("Long", row.getA4CustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_custom_rate_from_unit]", getValue("Long", row.getA4CustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_custom_rate_to_unit]", getValue("Long", row.getA4CustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_custom_rate_per_unit]", getValue("Double", row.getA4CustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_custom_rate_plan_id]", getValue("String", row.getA4ClientCustomRatePlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_custom_rate_service_id]", getValue("String", row.getA4ClientCustomRateServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4NewAcctPlanContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4NewAcctPlanContractsRow row : arrayList.getA4NewAcctPlanContractsRow()){
            parameters.add("a4_contract_plan_no["+i+"]", getValue("Long", row.getA4ContractPlanNo()));
            parameters.add("a4_contract_type_no["+i+"]", getValue("Long", row.getA4ContractTypeNo()));
            parameters.add("a4_contract_alt_recur_fee["+i+"]", getValue("Double", row.getA4ContractAltRecurFee()));
            parameters.add("a4_contract_length_months["+i+"]", getValue("Long", row.getA4ContractLengthMonths()));
            parameters.add("a4_contract_cancel_fee["+i+"]", getValue("Double", row.getA4ContractCancelFee()));
            parameters.add("a4_contract_comments["+i+"]", getValue("String", row.getA4ContractComments()));
            parameters.add("a4_contract_start_date["+i+"]", getValue("String", row.getA4ContractStartDate()));
            parameters.add("a4_contract_end_date["+i+"]", getValue("String", row.getA4ContractEndDate()));
            parameters.add("a4_client_contract_plan_id["+i+"]", getValue("String", row.getA4ClientContractPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4NewAcctPlanContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4NewAcctPlanContractsRow row : arrayList.getA4NewAcctPlanContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_plan_no]", getValue("Long", row.getA4ContractPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_type_no]", getValue("Long", row.getA4ContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_alt_recur_fee]", getValue("Double", row.getA4ContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_length_months]", getValue("Long", row.getA4ContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_cancel_fee]", getValue("Double", row.getA4ContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_comments]", getValue("String", row.getA4ContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_start_date]", getValue("String", row.getA4ContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_contract_end_date]", getValue("String", row.getA4ContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_contract_plan_id]", getValue("String", row.getA4ClientContractPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4UsageAccumulationConfigArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4UsageAccumulationConfigRow row : arrayList.getA4UsageAccumulationConfigRow()){
            parameters.add("a4_usage_accumulation_plan_no["+i+"]", getValue("Long", row.getA4UsageAccumulationPlanNo()));
            parameters.add("a4_usage_accumulation_reset_months["+i+"]", getValue("Long", row.getA4UsageAccumulationResetMonths()));
            parameters.add("a4_client_usg_accum_plan_id["+i+"]", getValue("String", row.getA4ClientUsgAccumPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4UsageAccumulationConfigArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4UsageAccumulationConfigRow row : arrayList.getA4UsageAccumulationConfigRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_usage_accumulation_plan_no]", getValue("Long", row.getA4UsageAccumulationPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_usage_accumulation_reset_months]", getValue("Long", row.getA4UsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_usg_accum_plan_id]", getValue("String", row.getA4ClientUsgAccumPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4EnableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4EnableUsagePoolingPlanNoRow row : arrayList.getA4EnableUsagePoolingPlanNoRow()){
            parameters.add("a4_enable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getA4EnableUsagePoolingPlanNo()));
            parameters.add("a4_client_enable_usg_pool_plan_id["+i+"]", getValue("String", row.getA4ClientEnableUsgPoolPlanId()));
            parameters.add("a4_usage_threshold_applicability["+i+"]", getValue("String", row.getA4UsageThresholdApplicability()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4EnableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4EnableUsagePoolingPlanNoRow row : arrayList.getA4EnableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_enable_usage_pooling_plan_no]", getValue("Long", row.getA4EnableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_enable_usg_pool_plan_id]", getValue("String", row.getA4ClientEnableUsgPoolPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_usage_threshold_applicability]", getValue("String", row.getA4UsageThresholdApplicability()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientFuncAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientFuncAcctGroupIdsRow row : arrayList.getA4ClientFuncAcctGroupIdsRow()){
            parameters.add("a4_client_func_acct_group_ids["+i+"]", getValue("String", row.getA4ClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientFuncAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientFuncAcctGroupIdsRow row : arrayList.getA4ClientFuncAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_func_acct_group_ids]", getValue("String", row.getA4ClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientCollAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientCollAcctGroupIdsRow row : arrayList.getA4ClientCollAcctGroupIdsRow()){
            parameters.add("a4_client_coll_acct_group_ids["+i+"]", getValue("String", row.getA4ClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientCollAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientCollAcctGroupIdsRow row : arrayList.getA4ClientCollAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_coll_acct_group_ids]", getValue("String", row.getA4ClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientSuppPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientSuppPlanIdsRow row : arrayList.getA4ClientSuppPlanIdsRow()){
            parameters.add("a4_client_supp_plan_ids["+i+"]", getValue("String", row.getA4ClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientSuppPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientSuppPlanIdsRow row : arrayList.getA4ClientSuppPlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_supp_plan_ids]", getValue("String", row.getA4ClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientSpAltRateSchedIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientSpAltRateSchedIdsRow row : arrayList.getA4ClientSpAltRateSchedIdsRow()){
            parameters.add("a4_client_sp_alt_rate_sched_ids["+i+"]", getValue("String", row.getA4ClientSpAltRateSchedIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4ClientSpAltRateSchedIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4ClientSpAltRateSchedIdsRow row : arrayList.getA4ClientSpAltRateSchedIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_client_sp_alt_rate_sched_ids]", getValue("String", row.getA4ClientSpAltRateSchedIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SurchargeNoRow row : arrayList.getA4SurchargeNoRow()){
            parameters.add("a4_surcharge_no["+i+"]", getValue("Long", row.getA4SurchargeNo()));
            parameters.add("a4_rate_schedule_no["+i+"]", getValue("Long", row.getA4RateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A4SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A4SurchargeNoRow row : arrayList.getA4SurchargeNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a4_surcharge_no]", getValue("Long", row.getA4SurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a4_rate_schedule_no]", getValue("Long", row.getA4RateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppPlansRow row : arrayList.getA5SuppPlansRow()){
            parameters.add("a5_supp_plans["+i+"]", getValue("Long", row.getA5SuppPlans()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppPlansRow row : arrayList.getA5SuppPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_supp_plans]", getValue("Long", row.getA5SuppPlans()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppPlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppPlanUnitsRow row : arrayList.getA5SuppPlanUnitsRow()){
            parameters.add("a5_supp_plan_units["+i+"]", getValue("Long", row.getA5SuppPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppPlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppPlanUnitsRow row : arrayList.getA5SuppPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_supp_plan_units]", getValue("Long", row.getA5SuppPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5FunctionalAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5FunctionalAcctGroupsRow row : arrayList.getA5FunctionalAcctGroupsRow()){
            parameters.add("a5_functional_acct_groups["+i+"]", getValue("Long", row.getA5FunctionalAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5FunctionalAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5FunctionalAcctGroupsRow row : arrayList.getA5FunctionalAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_functional_acct_groups]", getValue("Long", row.getA5FunctionalAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5CollectionsAcctGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5CollectionsAcctGroupsRow row : arrayList.getA5CollectionsAcctGroupsRow()){
            parameters.add("a5_collections_acct_groups["+i+"]", getValue("Long", row.getA5CollectionsAcctGroups()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5CollectionsAcctGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5CollectionsAcctGroupsRow row : arrayList.getA5CollectionsAcctGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_collections_acct_groups]", getValue("Long", row.getA5CollectionsAcctGroups()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppFieldNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppFieldNamesRow row : arrayList.getA5SuppFieldNamesRow()){
            parameters.add("a5_supp_field_names["+i+"]", getValue("String", row.getA5SuppFieldNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppFieldNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppFieldNamesRow row : arrayList.getA5SuppFieldNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_supp_field_names]", getValue("String", row.getA5SuppFieldNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppFieldValuesRow row : arrayList.getA5SuppFieldValuesRow()){
            parameters.add("a5_supp_field_values["+i+"]", getValue("String", row.getA5SuppFieldValues()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppFieldValuesRow row : arrayList.getA5SuppFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_supp_field_values]", getValue("String", row.getA5SuppFieldValues()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppPlanAltRateSchedNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppPlanAltRateSchedNoRow row : arrayList.getA5SuppPlanAltRateSchedNoRow()){
            parameters.add("a5_supp_plan_alt_rate_sched_no["+i+"]", getValue("Long", row.getA5SuppPlanAltRateSchedNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SuppPlanAltRateSchedNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SuppPlanAltRateSchedNoRow row : arrayList.getA5SuppPlanAltRateSchedNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_supp_plan_alt_rate_sched_no]", getValue("Long", row.getA5SuppPlanAltRateSchedNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5CouponCodesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5CouponCodesRow row : arrayList.getA5CouponCodesRow()){
            parameters.add("a5_coupon_codes["+i+"]", getValue("String", row.getA5CouponCodes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5CouponCodesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5CouponCodesRow row : arrayList.getA5CouponCodesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_coupon_codes]", getValue("String", row.getA5CouponCodes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5NewAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5NewAcctCustomRatesRow row : arrayList.getA5NewAcctCustomRatesRow()){
            parameters.add("a5_custom_rate_plan_no["+i+"]", getValue("Long", row.getA5CustomRatePlanNo()));
            parameters.add("a5_custom_rate_service_no["+i+"]", getValue("Long", row.getA5CustomRateServiceNo()));
            parameters.add("a5_custom_rate_seq_no["+i+"]", getValue("Long", row.getA5CustomRateSeqNo()));
            parameters.add("a5_custom_rate_from_unit["+i+"]", getValue("Long", row.getA5CustomRateFromUnit()));
            parameters.add("a5_custom_rate_to_unit["+i+"]", getValue("Long", row.getA5CustomRateToUnit()));
            parameters.add("a5_custom_rate_per_unit["+i+"]", getValue("Double", row.getA5CustomRatePerUnit()));
            parameters.add("a5_client_custom_rate_plan_id["+i+"]", getValue("String", row.getA5ClientCustomRatePlanId()));
            parameters.add("a5_client_custom_rate_service_id["+i+"]", getValue("String", row.getA5ClientCustomRateServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5NewAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5NewAcctCustomRatesRow row : arrayList.getA5NewAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_custom_rate_plan_no]", getValue("Long", row.getA5CustomRatePlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_custom_rate_service_no]", getValue("Long", row.getA5CustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_custom_rate_seq_no]", getValue("Long", row.getA5CustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_custom_rate_from_unit]", getValue("Long", row.getA5CustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_custom_rate_to_unit]", getValue("Long", row.getA5CustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_custom_rate_per_unit]", getValue("Double", row.getA5CustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_custom_rate_plan_id]", getValue("String", row.getA5ClientCustomRatePlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_custom_rate_service_id]", getValue("String", row.getA5ClientCustomRateServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5NewAcctPlanContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5NewAcctPlanContractsRow row : arrayList.getA5NewAcctPlanContractsRow()){
            parameters.add("a5_contract_plan_no["+i+"]", getValue("Long", row.getA5ContractPlanNo()));
            parameters.add("a5_contract_type_no["+i+"]", getValue("Long", row.getA5ContractTypeNo()));
            parameters.add("a5_contract_alt_recur_fee["+i+"]", getValue("Double", row.getA5ContractAltRecurFee()));
            parameters.add("a5_contract_length_months["+i+"]", getValue("Long", row.getA5ContractLengthMonths()));
            parameters.add("a5_contract_cancel_fee["+i+"]", getValue("Double", row.getA5ContractCancelFee()));
            parameters.add("a5_contract_comments["+i+"]", getValue("String", row.getA5ContractComments()));
            parameters.add("a5_contract_start_date["+i+"]", getValue("String", row.getA5ContractStartDate()));
            parameters.add("a5_contract_end_date["+i+"]", getValue("String", row.getA5ContractEndDate()));
            parameters.add("a5_client_contract_plan_id["+i+"]", getValue("String", row.getA5ClientContractPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5NewAcctPlanContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5NewAcctPlanContractsRow row : arrayList.getA5NewAcctPlanContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_plan_no]", getValue("Long", row.getA5ContractPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_type_no]", getValue("Long", row.getA5ContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_alt_recur_fee]", getValue("Double", row.getA5ContractAltRecurFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_length_months]", getValue("Long", row.getA5ContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_cancel_fee]", getValue("Double", row.getA5ContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_comments]", getValue("String", row.getA5ContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_start_date]", getValue("String", row.getA5ContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_contract_end_date]", getValue("String", row.getA5ContractEndDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_contract_plan_id]", getValue("String", row.getA5ClientContractPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5UsageAccumulationConfigArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5UsageAccumulationConfigRow row : arrayList.getA5UsageAccumulationConfigRow()){
            parameters.add("a5_usage_accumulation_plan_no["+i+"]", getValue("Long", row.getA5UsageAccumulationPlanNo()));
            parameters.add("a5_usage_accumulation_reset_months["+i+"]", getValue("Long", row.getA5UsageAccumulationResetMonths()));
            parameters.add("a5_client_usg_accum_plan_id["+i+"]", getValue("String", row.getA5ClientUsgAccumPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5UsageAccumulationConfigArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5UsageAccumulationConfigRow row : arrayList.getA5UsageAccumulationConfigRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_usage_accumulation_plan_no]", getValue("Long", row.getA5UsageAccumulationPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_usage_accumulation_reset_months]", getValue("Long", row.getA5UsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_usg_accum_plan_id]", getValue("String", row.getA5ClientUsgAccumPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5EnableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5EnableUsagePoolingPlanNoRow row : arrayList.getA5EnableUsagePoolingPlanNoRow()){
            parameters.add("a5_enable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getA5EnableUsagePoolingPlanNo()));
            parameters.add("a5_client_enable_usg_pool_plan_id["+i+"]", getValue("String", row.getA5ClientEnableUsgPoolPlanId()));
            parameters.add("a5_usage_threshold_applicability["+i+"]", getValue("String", row.getA5UsageThresholdApplicability()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5EnableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5EnableUsagePoolingPlanNoRow row : arrayList.getA5EnableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_enable_usage_pooling_plan_no]", getValue("Long", row.getA5EnableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_enable_usg_pool_plan_id]", getValue("String", row.getA5ClientEnableUsgPoolPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_usage_threshold_applicability]", getValue("String", row.getA5UsageThresholdApplicability()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientFuncAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientFuncAcctGroupIdsRow row : arrayList.getA5ClientFuncAcctGroupIdsRow()){
            parameters.add("a5_client_func_acct_group_ids["+i+"]", getValue("String", row.getA5ClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientFuncAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientFuncAcctGroupIdsRow row : arrayList.getA5ClientFuncAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_func_acct_group_ids]", getValue("String", row.getA5ClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientCollAcctGroupIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientCollAcctGroupIdsRow row : arrayList.getA5ClientCollAcctGroupIdsRow()){
            parameters.add("a5_client_coll_acct_group_ids["+i+"]", getValue("String", row.getA5ClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientCollAcctGroupIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientCollAcctGroupIdsRow row : arrayList.getA5ClientCollAcctGroupIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_coll_acct_group_ids]", getValue("String", row.getA5ClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientSuppPlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientSuppPlanIdsRow row : arrayList.getA5ClientSuppPlanIdsRow()){
            parameters.add("a5_client_supp_plan_ids["+i+"]", getValue("String", row.getA5ClientSuppPlanIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientSuppPlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientSuppPlanIdsRow row : arrayList.getA5ClientSuppPlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_supp_plan_ids]", getValue("String", row.getA5ClientSuppPlanIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientSpAltRateSchedIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientSpAltRateSchedIdsRow row : arrayList.getA5ClientSpAltRateSchedIdsRow()){
            parameters.add("a5_client_sp_alt_rate_sched_ids["+i+"]", getValue("String", row.getA5ClientSpAltRateSchedIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5ClientSpAltRateSchedIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5ClientSpAltRateSchedIdsRow row : arrayList.getA5ClientSpAltRateSchedIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_client_sp_alt_rate_sched_ids]", getValue("String", row.getA5ClientSpAltRateSchedIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SurchargeNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SurchargeNoRow row : arrayList.getA5SurchargeNoRow()){
            parameters.add("a5_surcharge_no["+i+"]", getValue("Long", row.getA5SurchargeNo()));
            parameters.add("a5_rate_schedule_no["+i+"]", getValue("Long", row.getA5RateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.A5SurchargeNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.A5SurchargeNoRow row : arrayList.getA5SurchargeNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[a5_surcharge_no]", getValue("Long", row.getA5SurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[a5_rate_schedule_no]", getValue("Long", row.getA5RateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanNoRow row : arrayList.getPlanNoRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanNoRow row : arrayList.getPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientPlanIdArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientPlanIdRow row : arrayList.getClientPlanIdRow()){
            parameters.add("client_plan_id["+i+"]", getValue("String", row.getClientPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientPlanIdArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientPlanIdRow row : arrayList.getClientPlanIdRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_id]", getValue("String", row.getClientPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EligibleServiceTypesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EligibleServiceTypesRow row : arrayList.getEligibleServiceTypesRow()){
            parameters.add("eligible_service_types["+i+"]", getValue("String", row.getEligibleServiceTypes()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EligibleServiceTypesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EligibleServiceTypesRow row : arrayList.getEligibleServiceTypesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[eligible_service_types]", getValue("String", row.getEligibleServiceTypes()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EligibleServicePlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EligibleServicePlansRow row : arrayList.getEligibleServicePlansRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            parameters.add("service_no["+i+"]", getValue("Long", row.getServiceNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EligibleServicePlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EligibleServicePlansRow row : arrayList.getEligibleServicePlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[service_no]", getValue("Long", row.getServiceNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientEligibleServicePlanIdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientEligibleServicePlanIdsRow row : arrayList.getClientEligibleServicePlanIdsRow()){
            parameters.add("client_plan_id["+i+"]", getValue("String", row.getClientPlanId()));
            parameters.add("client_service_id["+i+"]", getValue("String", row.getClientServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientEligibleServicePlanIdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientEligibleServicePlanIdsRow row : arrayList.getClientEligibleServicePlanIdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_id]", getValue("String", row.getClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_service_id]", getValue("String", row.getClientServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlansToGetOutageArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlansToGetOutageRow row : arrayList.getPlansToGetOutageRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlansToGetOutageArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlansToGetOutageRow row : arrayList.getPlansToGetOutageRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientPlanIdsToGetOutageArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientPlanIdsToGetOutageRow row : arrayList.getClientPlanIdsToGetOutageRow()){
            parameters.add("client_plan_ids_to_get_outage["+i+"]", getValue("String", row.getClientPlanIdsToGetOutage()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientPlanIdsToGetOutageArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientPlanIdsToGetOutageRow row : arrayList.getClientPlanIdsToGetOutageRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_ids_to_get_outage]", getValue("String", row.getClientPlanIdsToGetOutage()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier1Array arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier1Row row : arrayList.getUsageQualifier1Row()){
            parameters.add("usage_qualifier_1["+i+"]", getValue("String", row.getUsageQualifier1()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier1Array arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier1Row row : arrayList.getUsageQualifier1Row()){
            parameters.add(paramPrefix + "["+i+"]" + "[usage_qualifier_1]", getValue("String", row.getUsageQualifier1()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier2Array arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier2Row row : arrayList.getUsageQualifier2Row()){
            parameters.add("usage_qualifier_2["+i+"]", getValue("String", row.getUsageQualifier2()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier2Array arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier2Row row : arrayList.getUsageQualifier2Row()){
            parameters.add(paramPrefix + "["+i+"]" + "[usage_qualifier_2]", getValue("String", row.getUsageQualifier2()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier3Array arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier3Row row : arrayList.getUsageQualifier3Row()){
            parameters.add("usage_qualifier_3["+i+"]", getValue("String", row.getUsageQualifier3()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier3Array arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier3Row row : arrayList.getUsageQualifier3Row()){
            parameters.add(paramPrefix + "["+i+"]" + "[usage_qualifier_3]", getValue("String", row.getUsageQualifier3()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier4Array arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier4Row row : arrayList.getUsageQualifier4Row()){
            parameters.add("usage_qualifier_4["+i+"]", getValue("String", row.getUsageQualifier4()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageQualifier4Array arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageQualifier4Row row : arrayList.getUsageQualifier4Row()){
            parameters.add(paramPrefix + "["+i+"]" + "[usage_qualifier_4]", getValue("String", row.getUsageQualifier4()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlansInputArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlansInputRow row : arrayList.getPlansInputRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlansInputArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlansInputRow row : arrayList.getPlansInputRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitsRow row : arrayList.getPlanUnitsRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            parameters.add("client_plan_id["+i+"]", getValue("String", row.getClientPlanId()));
            parameters.add("plan_unit_inst_no["+i+"]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add("assignment_directive["+i+"]", getValue("Long", row.getAssignmentDirective()));
            parameters.add("new_plan_units["+i+"]", getValue("Double", row.getNewPlanUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitsRow row : arrayList.getPlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_id]", getValue("String", row.getClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_no]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add(paramPrefix + "["+i+"]" + "[assignment_directive]", getValue("Long", row.getAssignmentDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_plan_units]", getValue("Double", row.getNewPlanUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NewClientPlanUnitInstArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NewClientPlanUnitInstRow row : arrayList.getNewClientPlanUnitInstRow()){
            parameters.add("new_client_plan_unit_inst_id["+i+"]", getValue("String", row.getNewClientPlanUnitInstId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NewClientPlanUnitInstArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NewClientPlanUnitInstRow row : arrayList.getNewClientPlanUnitInstRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[new_client_plan_unit_inst_id]", getValue("String", row.getNewClientPlanUnitInstId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctSuppFieldsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctSuppFieldsRow row : arrayList.getAcctSuppFieldsRow()){
            parameters.add("supp_field_name["+i+"]", getValue("String", row.getSuppFieldName()));
            parameters.add("supp_field_value["+i+"]", getValue("String", row.getSuppFieldValue()));
            parameters.add("supp_field_directive["+i+"]", getValue("Long", row.getSuppFieldDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctSuppFieldsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctSuppFieldsRow row : arrayList.getAcctSuppFieldsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_name]", getValue("String", row.getSuppFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_value]", getValue("String", row.getSuppFieldValue()));
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_directive]", getValue("Long", row.getSuppFieldDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageUnitThresholdsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageUnitThresholdsRow row : arrayList.getUsageUnitThresholdsRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            parameters.add("usage_type_no["+i+"]", getValue("Long", row.getUsageTypeNo()));
            parameters.add("usage_type_code["+i+"]", getValue("String", row.getUsageTypeCode()));
            parameters.add("threshold_units["+i+"]", getValue("Double", row.getThresholdUnits()));
            parameters.add("threshold_level_no["+i+"]", getValue("Long", row.getThresholdLevelNo()));
            parameters.add("threshold_level_value["+i+"]", getValue("Double", row.getThresholdLevelValue()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageUnitThresholdsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageUnitThresholdsRow row : arrayList.getUsageUnitThresholdsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_type_no]", getValue("Long", row.getUsageTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_type_code]", getValue("String", row.getUsageTypeCode()));
            parameters.add(paramPrefix + "["+i+"]" + "[threshold_units]", getValue("Double", row.getThresholdUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[threshold_level_no]", getValue("Long", row.getThresholdLevelNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[threshold_level_value]", getValue("Double", row.getThresholdLevelValue()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctSuppFieldArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctSuppFieldRow row : arrayList.getUpdateAcctSuppFieldRow()){
            parameters.add("supp_field_names["+i+"]", getValue("String", row.getSuppFieldNames()));
            parameters.add("supp_field_values["+i+"]", getValue("String", row.getSuppFieldValues()));
            parameters.add("supp_field_directives["+i+"]", getValue("Long", row.getSuppFieldDirectives()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctSuppFieldArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctSuppFieldRow row : arrayList.getUpdateAcctSuppFieldRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_names]", getValue("String", row.getSuppFieldNames()));
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_values]", getValue("String", row.getSuppFieldValues()));
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_directives]", getValue("Long", row.getSuppFieldDirectives()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctFuncGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctFuncGroupRow row : arrayList.getUpdateAcctFuncGroupRow()){
            parameters.add("functional_acct_groups["+i+"]", getValue("Long", row.getFunctionalAcctGroups()));
            parameters.add("functional_group_directives["+i+"]", getValue("Long", row.getFunctionalGroupDirectives()));
            parameters.add("client_func_acct_group_ids["+i+"]", getValue("String", row.getClientFuncAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctFuncGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctFuncGroupRow row : arrayList.getUpdateAcctFuncGroupRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[functional_acct_groups]", getValue("Long", row.getFunctionalAcctGroups()));
            parameters.add(paramPrefix + "["+i+"]" + "[functional_group_directives]", getValue("Long", row.getFunctionalGroupDirectives()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_func_acct_group_ids]", getValue("String", row.getClientFuncAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctCollGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctCollGroupRow row : arrayList.getUpdateAcctCollGroupRow()){
            parameters.add("collections_acct_groups["+i+"]", getValue("Long", row.getCollectionsAcctGroups()));
            parameters.add("collections_group_directives["+i+"]", getValue("Long", row.getCollectionsGroupDirectives()));
            parameters.add("client_coll_acct_group_ids["+i+"]", getValue("String", row.getClientCollAcctGroupIds()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctCollGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctCollGroupRow row : arrayList.getUpdateAcctCollGroupRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[collections_acct_groups]", getValue("Long", row.getCollectionsAcctGroups()));
            parameters.add(paramPrefix + "["+i+"]" + "[collections_group_directives]", getValue("Long", row.getCollectionsGroupDirectives()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_coll_acct_group_ids]", getValue("String", row.getClientCollAcctGroupIds()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.DisableUsagePoolingPlanNoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.DisableUsagePoolingPlanNoRow row : arrayList.getDisableUsagePoolingPlanNoRow()){
            parameters.add("disable_usage_pooling_plan_no["+i+"]", getValue("Long", row.getDisableUsagePoolingPlanNo()));
            parameters.add("client_disable_usage_pool_plan_id["+i+"]", getValue("String", row.getClientDisableUsagePoolPlanId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.DisableUsagePoolingPlanNoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.DisableUsagePoolingPlanNoRow row : arrayList.getDisableUsagePoolingPlanNoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[disable_usage_pooling_plan_no]", getValue("Long", row.getDisableUsagePoolingPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_disable_usage_pool_plan_id]", getValue("String", row.getClientDisableUsagePoolPlanId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateSurchargeArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateSurchargeRow row : arrayList.getUpdateSurchargeRow()){
            parameters.add("surcharge_no["+i+"]", getValue("Long", row.getSurchargeNo()));
            parameters.add("surcharge_directive["+i+"]", getValue("Long", row.getSurchargeDirective()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateSurchargeArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateSurchargeRow row : arrayList.getUpdateSurchargeRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_no]", getValue("Long", row.getSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_directive]", getValue("Long", row.getSurchargeDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstServicesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstServicesRow row : arrayList.getPlanUnitInstServicesRow()){
            parameters.add("service_no["+i+"]", getValue("Long", row.getServiceNo()));
            parameters.add("client_service_id["+i+"]", getValue("String", row.getClientServiceId()));
            parameters.add("service_fulfillment_date["+i+"]", getValue("String", row.getServiceFulfillmentDate()));
            parameters.add("fulfillment_directive["+i+"]", getValue("Long", row.getFulfillmentDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstServicesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstServicesRow row : arrayList.getPlanUnitInstServicesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[service_no]", getValue("Long", row.getServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_service_id]", getValue("String", row.getClientServiceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[service_fulfillment_date]", getValue("String", row.getServiceFulfillmentDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[fulfillment_directive]", getValue("Long", row.getFulfillmentDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldsRow row : arrayList.getPlanUnitInstFieldsRow()){
            parameters.add("field_name["+i+"]", getValue("String", row.getFieldName()));
            parameters.add("field_value["+i+"]", getValue("String", row.getFieldValue()));
            parameters.add("plan_unit_inst_directive["+i+"]", getValue("Long", row.getPlanUnitInstDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldsRow row : arrayList.getPlanUnitInstFieldsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[field_name]", getValue("String", row.getFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[field_value]", getValue("String", row.getFieldValue()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_directive]", getValue("Long", row.getPlanUnitInstDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ParamNamesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ParamNamesRow row : arrayList.getParamNamesRow()){
            parameters.add("param_name["+i+"]", getValue("String", row.getParamName()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ParamNamesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ParamNamesRow row : arrayList.getParamNamesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[param_name]", getValue("String", row.getParamName()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.WebValsInArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.WebValsInRow row : arrayList.getWebValsInRow()){
            parameters.add("in_replacement_names["+i+"]", getValue("String", row.getInReplacementNames()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.WebValsInArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.WebValsInRow row : arrayList.getWebValsInRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[in_replacement_names]", getValue("String", row.getInReplacementNames()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InRegUssConfigParamsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InRegUssConfigParamsRow row : arrayList.getInRegUssConfigParamsRow()){
            parameters.add("param_name["+i+"]", getValue("String", row.getParamName()));
            parameters.add("param_val["+i+"]", getValue("String", row.getParamVal()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InRegUssConfigParamsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InRegUssConfigParamsRow row : arrayList.getInRegUssConfigParamsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[param_name]", getValue("String", row.getParamName()));
            parameters.add(paramPrefix + "["+i+"]" + "[param_val]", getValue("String", row.getParamVal()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InRegUssParamsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InRegUssParamsRow row : arrayList.getInRegUssParamsRow()){
            parameters.add("param_name["+i+"]", getValue("String", row.getParamName()));
            parameters.add("param_val["+i+"]", getValue("String", row.getParamVal()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InRegUssParamsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InRegUssParamsRow row : arrayList.getInRegUssParamsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[param_name]", getValue("String", row.getParamName()));
            parameters.add(paramPrefix + "["+i+"]" + "[param_val]", getValue("String", row.getParamVal()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EventListArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EventListRow row : arrayList.getEventListRow()){
            parameters.add("event_list["+i+"]", getValue("Long", row.getEventList()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EventListArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EventListRow row : arrayList.getEventListRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[event_list]", getValue("Long", row.getEventList()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InventoryItemStockArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InventoryItemStockRow row : arrayList.getInventoryItemStockRow()){
            parameters.add("item_no["+i+"]", getValue("Long", row.getItemNo()));
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("update_directive["+i+"]", getValue("Long", row.getUpdateDirective()));
            parameters.add("update_amount["+i+"]", getValue("Double", row.getUpdateAmount()));
            parameters.add("client_item_id["+i+"]", getValue("String", row.getClientItemId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InventoryItemStockArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InventoryItemStockRow row : arrayList.getInventoryItemStockRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[item_no]", getValue("Long", row.getItemNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[update_directive]", getValue("Long", row.getUpdateDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[update_amount]", getValue("Double", row.getUpdateAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_item_id]", getValue("String", row.getClientItemId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.BillingDatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.BillingDatesRow row : arrayList.getBillingDatesRow()){
            parameters.add("master_plan_instance_no["+i+"]", getValue("Long", row.getMasterPlanInstanceNo()));
            parameters.add("client_master_plan_instance_id["+i+"]", getValue("String", row.getClientMasterPlanInstanceId()));
            parameters.add("action_directive["+i+"]", getValue("Long", row.getActionDirective()));
            parameters.add("adjustment_days["+i+"]", getValue("Long", row.getAdjustmentDays()));
            parameters.add("adjustment_date["+i+"]", getValue("String", row.getAdjustmentDate()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.BillingDatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.BillingDatesRow row : arrayList.getBillingDatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[master_plan_instance_no]", getValue("Long", row.getMasterPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_master_plan_instance_id]", getValue("String", row.getClientMasterPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[action_directive]", getValue("Long", row.getActionDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[adjustment_days]", getValue("Long", row.getAdjustmentDays()));
            parameters.add(paramPrefix + "["+i+"]" + "[adjustment_date]", getValue("String", row.getAdjustmentDate()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MpiSurchargesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MpiSurchargesRow row : arrayList.getMpiSurchargesRow()){
            parameters.add("mpi_surcharge_no["+i+"]", getValue("Long", row.getMpiSurchargeNo()));
            parameters.add("mpi_rate_schedule_no["+i+"]", getValue("Long", row.getMpiRateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MpiSurchargesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MpiSurchargesRow row : arrayList.getMpiSurchargesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[mpi_surcharge_no]", getValue("Long", row.getMpiSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[mpi_rate_schedule_no]", getValue("Long", row.getMpiRateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceFieldsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceFieldsRow row : arrayList.getPlanInstanceFieldsRow()){
            parameters.add("plan_instance_field_name["+i+"]", getValue("String", row.getPlanInstanceFieldName()));
            parameters.add("plan_instance_field_value["+i+"]", getValue("String", row.getPlanInstanceFieldValue()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceFieldsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceFieldsRow row : arrayList.getPlanInstanceFieldsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_name]", getValue("String", row.getPlanInstanceFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_value]", getValue("String", row.getPlanInstanceFieldValue()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CustomRatesRow row : arrayList.getCustomRatesRow()){
            parameters.add("custom_rate_service_no["+i+"]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add("custom_rate_client_service_id["+i+"]", getValue("String", row.getCustomRateClientServiceId()));
            parameters.add("custom_rate_seq_no["+i+"]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add("custom_rate_from_unit["+i+"]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add("custom_rate_to_unit["+i+"]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add("custom_rate_per_unit["+i+"]", getValue("Double", row.getCustomRatePerUnit()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CustomRatesRow row : arrayList.getCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_service_no]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_client_service_id]", getValue("String", row.getCustomRateClientServiceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_seq_no]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_from_unit]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_to_unit]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_per_unit]", getValue("Double", row.getCustomRatePerUnit()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NsoItemListArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NsoItemListRow row : arrayList.getNsoItemListRow()){
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("item_units["+i+"]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NsoItemListArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NsoItemListRow row : arrayList.getNsoItemListRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[item_units]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceToRemoveArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceToRemoveRow row : arrayList.getPlanInstanceToRemoveRow()){
            parameters.add("plan_instance_no["+i+"]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceToRemoveArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceToRemoveRow row : arrayList.getPlanInstanceToRemoveRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_no]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.QueueIdToRemoveArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.QueueIdToRemoveRow row : arrayList.getQueueIdToRemoveRow()){
            parameters.add("queue_id["+i+"]", getValue("Long", row.getQueueId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.QueueIdToRemoveArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.QueueIdToRemoveRow row : arrayList.getQueueIdToRemoveRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[queue_id]", getValue("Long", row.getQueueId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlansSummaryArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlansSummaryRow row : arrayList.getMasterPlansSummaryRow()){
            parameters.add("plan_instance_no["+i+"]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlansSummaryArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlansSummaryRow row : arrayList.getMasterPlansSummaryRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_no]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctRow row : arrayList.getAcctRow()){
                        addParameterValuesFromArray(parameters, row.getAcct(), "acct["+i+"]");
            parameters.add("client_acct_id["+i+"]", getValue("String", row.getClientAcctId()));
            parameters.add("userid["+i+"]", getValue("String", row.getUserid()));
            parameters.add("status_cd["+i+"]", getValue("Long", row.getStatusCd()));
            parameters.add("notify_method["+i+"]", getValue("Long", row.getNotifyMethod()));
            parameters.add("password["+i+"]", getValue("String", row.getPassword()));
            parameters.add("secret_question["+i+"]", getValue("String", row.getSecretQuestion()));
            parameters.add("secret_question_answer["+i+"]", getValue("String", row.getSecretQuestionAnswer()));
            parameters.add("first_name["+i+"]", getValue("String", row.getFirstName()));
            parameters.add("mi["+i+"]", getValue("String", row.getMi()));
            parameters.add("last_name["+i+"]", getValue("String", row.getLastName()));
            parameters.add("company_name["+i+"]", getValue("String", row.getCompanyName()));
            parameters.add("address1["+i+"]", getValue("String", row.getAddress1()));
            parameters.add("address2["+i+"]", getValue("String", row.getAddress2()));
            parameters.add("address3["+i+"]", getValue("String", row.getAddress3()));
            parameters.add("city["+i+"]", getValue("String", row.getCity()));
            parameters.add("locality["+i+"]", getValue("String", row.getLocality()));
            parameters.add("state_prov["+i+"]", getValue("String", row.getStateProv()));
            parameters.add("country["+i+"]", getValue("String", row.getCountry()));
            parameters.add("postal_cd["+i+"]", getValue("String", row.getPostalCd()));
            parameters.add("phone["+i+"]", getValue("String", row.getPhone()));
            parameters.add("phone_ext["+i+"]", getValue("String", row.getPhoneExt()));
            parameters.add("cell_phone["+i+"]", getValue("String", row.getCellPhone()));
            parameters.add("work_phone["+i+"]", getValue("String", row.getWorkPhone()));
            parameters.add("work_phone_ext["+i+"]", getValue("String", row.getWorkPhoneExt()));
            parameters.add("fax["+i+"]", getValue("String", row.getFax()));
            parameters.add("email["+i+"]", getValue("String", row.getEmail()));
            parameters.add("birthdate["+i+"]", getValue("String", row.getBirthdate()));
            parameters.add("senior_acct_no["+i+"]", getValue("Long", row.getSeniorAcctNo()));
            parameters.add("senior_acct_userid["+i+"]", getValue("String", row.getSeniorAcctUserid()));
            parameters.add("client_senior_acct_id["+i+"]", getValue("String", row.getClientSeniorAcctId()));
            parameters.add("invoicing_option["+i+"]", getValue("Long", row.getInvoicingOption()));
            parameters.add("alt_start_date["+i+"]", getValue("String", row.getAltStartDate()));
            parameters.add("alt_bill_day["+i+"]", getValue("Long", row.getAltBillDay()));
            parameters.add("retroactive_start_date["+i+"]", getValue("String", row.getRetroactiveStartDate()));
                        addParameterValuesFromArray(parameters, row.getFunctionalAcctGroup(), "functional_acct_group["+i+"]");
                        addParameterValuesFromArray(parameters, row.getCollectionAcctGroup(), "collection_acct_group["+i+"]");
                        addParameterValuesFromArray(parameters, row.getSuppField(), "supp_field["+i+"]");
            parameters.add("test_acct_ind["+i+"]", getValue("Long", row.getTestAcctInd()));
            parameters.add("acct_start_date["+i+"]", getValue("String", row.getAcctStartDate()));
            parameters.add("acct_currency["+i+"]", getValue("String", row.getAcctCurrency()));
            parameters.add("seq_func_group_no["+i+"]", getValue("Long", row.getSeqFuncGroupNo()));
            parameters.add("client_seq_func_group_id["+i+"]", getValue("String", row.getClientSeqFuncGroupId()));
            parameters.add("taxpayer_id["+i+"]", getValue("String", row.getTaxpayerId()));
            parameters.add("tax_exemption_level["+i+"]", getValue("Long", row.getTaxExemptionLevel()));
            parameters.add("list_start_master_file["+i+"]", getValue("Long", row.getListStartMasterFile()));
            parameters.add("alt_msg_template_no["+i+"]", getValue("Long", row.getAltMsgTemplateNo()));
            parameters.add("cn_alt_msg_template_no["+i+"]", getValue("Long", row.getCnAltMsgTemplateNo()));
            parameters.add("invoice_approval_required["+i+"]", getValue("String", row.getInvoiceApprovalRequired()));
            parameters.add("create_session["+i+"]", getValue("String", row.getCreateSession()));
            parameters.add("client_alt_msg_template_id["+i+"]", getValue("String", row.getClientAltMsgTemplateId()));
            parameters.add("client_cn_alt_msg_template_id["+i+"]", getValue("Long", row.getClientCnAltMsgTemplateId()));
                        addParameterValuesFromArray(parameters, row.getAcctSurcharges(), "acct_surcharges["+i+"]");
                        addParameterValuesFromArray(parameters, row.getCouponCodes(), "coupon_codes["+i+"]");
                        addParameterValuesFromArray(parameters, row.getPaymentMethod(), "payment_method["+i+"]");
                        addParameterValuesFromArray(parameters, row.getBillingGroup(), "billing_group["+i+"]");
                        addParameterValuesFromArray(parameters, row.getDunningGroup(), "dunning_group["+i+"]");
                        addParameterValuesFromArray(parameters, row.getContracts(), "contracts["+i+"]");
                        addParameterValuesFromArray(parameters, row.getMasterPlansDetail(), "master_plans_detail["+i+"]");
            parameters.add("consumer_acct_ind["+i+"]", getValue("String", row.getConsumerAcctInd()));
            parameters.add("revrec_profile_no["+i+"]", getValue("Long", row.getRevrecProfileNo()));
            parameters.add("client_revrec_id["+i+"]", getValue("String", row.getClientRevrecId()));
            parameters.add("po_num["+i+"]", getValue("String", row.getPoNum()));
            parameters.add("locale_no["+i+"]", getValue("Long", row.getLocaleNo()));
            parameters.add("locale_name["+i+"]", getValue("String", row.getLocaleName()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctRow row : arrayList.getAcctRow()){
            addParameterValuesFromArray(parameters, row.getAcct(), paramPrefix + "["+i+"]" + "[acct][acct_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[client_acct_id]", getValue("String", row.getClientAcctId()));
            parameters.add(paramPrefix + "["+i+"]" + "[userid]", getValue("String", row.getUserid()));
            parameters.add(paramPrefix + "["+i+"]" + "[status_cd]", getValue("Long", row.getStatusCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[notify_method]", getValue("Long", row.getNotifyMethod()));
            parameters.add(paramPrefix + "["+i+"]" + "[password]", getValue("String", row.getPassword()));
            parameters.add(paramPrefix + "["+i+"]" + "[secret_question]", getValue("String", row.getSecretQuestion()));
            parameters.add(paramPrefix + "["+i+"]" + "[secret_question_answer]", getValue("String", row.getSecretQuestionAnswer()));
            parameters.add(paramPrefix + "["+i+"]" + "[first_name]", getValue("String", row.getFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[mi]", getValue("String", row.getMi()));
            parameters.add(paramPrefix + "["+i+"]" + "[last_name]", getValue("String", row.getLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[company_name]", getValue("String", row.getCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[address1]", getValue("String", row.getAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[address2]", getValue("String", row.getAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[address3]", getValue("String", row.getAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[city]", getValue("String", row.getCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[locality]", getValue("String", row.getLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[state_prov]", getValue("String", row.getStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[country]", getValue("String", row.getCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[postal_cd]", getValue("String", row.getPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[phone]", getValue("String", row.getPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[phone_ext]", getValue("String", row.getPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[cell_phone]", getValue("String", row.getCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[work_phone]", getValue("String", row.getWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[work_phone_ext]", getValue("String", row.getWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[fax]", getValue("String", row.getFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[email]", getValue("String", row.getEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[birthdate]", getValue("String", row.getBirthdate()));
            parameters.add(paramPrefix + "["+i+"]" + "[senior_acct_no]", getValue("Long", row.getSeniorAcctNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[senior_acct_userid]", getValue("String", row.getSeniorAcctUserid()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_senior_acct_id]", getValue("String", row.getClientSeniorAcctId()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoicing_option]", getValue("Long", row.getInvoicingOption()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_start_date]", getValue("String", row.getAltStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_bill_day]", getValue("Long", row.getAltBillDay()));
            parameters.add(paramPrefix + "["+i+"]" + "[retroactive_start_date]", getValue("String", row.getRetroactiveStartDate()));
            addParameterValuesFromArray(parameters, row.getFunctionalAcctGroup(), paramPrefix + "["+i+"]" + "[functional_acct_group][functional_acct_group_row]");
            addParameterValuesFromArray(parameters, row.getCollectionAcctGroup(), paramPrefix + "["+i+"]" + "[collection_acct_group][collection_acct_group_row]");
            addParameterValuesFromArray(parameters, row.getSuppField(), paramPrefix + "["+i+"]" + "[supp_field][supp_field_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[test_acct_ind]", getValue("Long", row.getTestAcctInd()));
            parameters.add(paramPrefix + "["+i+"]" + "[acct_start_date]", getValue("String", row.getAcctStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[acct_currency]", getValue("String", row.getAcctCurrency()));
            parameters.add(paramPrefix + "["+i+"]" + "[seq_func_group_no]", getValue("Long", row.getSeqFuncGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_seq_func_group_id]", getValue("String", row.getClientSeqFuncGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[taxpayer_id]", getValue("String", row.getTaxpayerId()));
            parameters.add(paramPrefix + "["+i+"]" + "[tax_exemption_level]", getValue("Long", row.getTaxExemptionLevel()));
            parameters.add(paramPrefix + "["+i+"]" + "[list_start_master_file]", getValue("Long", row.getListStartMasterFile()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_msg_template_no]", getValue("Long", row.getAltMsgTemplateNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[cn_alt_msg_template_no]", getValue("Long", row.getCnAltMsgTemplateNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_approval_required]", getValue("String", row.getInvoiceApprovalRequired()));
            parameters.add(paramPrefix + "["+i+"]" + "[create_session]", getValue("String", row.getCreateSession()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_alt_msg_template_id]", getValue("String", row.getClientAltMsgTemplateId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_cn_alt_msg_template_id]", getValue("Long", row.getClientCnAltMsgTemplateId()));
            addParameterValuesFromArray(parameters, row.getAcctSurcharges(), paramPrefix + "["+i+"]" + "[acct_surcharges][acct_surcharges_row]");
            addParameterValuesFromArray(parameters, row.getCouponCodes(), paramPrefix + "["+i+"]" + "[coupon_codes][coupon_codes_row]");
            addParameterValuesFromArray(parameters, row.getPaymentMethod(), paramPrefix + "["+i+"]" + "[payment_method][payment_method_row]");
            addParameterValuesFromArray(parameters, row.getBillingGroup(), paramPrefix + "["+i+"]" + "[billing_group][billing_group_row]");
            addParameterValuesFromArray(parameters, row.getDunningGroup(), paramPrefix + "["+i+"]" + "[dunning_group][dunning_group_row]");
            addParameterValuesFromArray(parameters, row.getContracts(), paramPrefix + "["+i+"]" + "[contracts][contracts_row]");
            addParameterValuesFromArray(parameters, row.getMasterPlansDetail(), paramPrefix + "["+i+"]" + "[master_plans_detail][master_plans_detail_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[consumer_acct_ind]", getValue("String", row.getConsumerAcctInd()));
            parameters.add(paramPrefix + "["+i+"]" + "[revrec_profile_no]", getValue("Long", row.getRevrecProfileNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_revrec_id]", getValue("String", row.getClientRevrecId()));
            parameters.add(paramPrefix + "["+i+"]" + "[po_num]", getValue("String", row.getPoNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[locale_no]", getValue("Long", row.getLocaleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[locale_name]", getValue("String", row.getLocaleName()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.FunctionalAcctGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.FunctionalAcctGroupRow row : arrayList.getFunctionalAcctGroupRow()){
            parameters.add("functional_acct_group_no["+i+"]", getValue("Long", row.getFunctionalAcctGroupNo()));
            parameters.add("client_functional_acct_group_id["+i+"]", getValue("String", row.getClientFunctionalAcctGroupId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.FunctionalAcctGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.FunctionalAcctGroupRow row : arrayList.getFunctionalAcctGroupRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[functional_acct_group_no]", getValue("Long", row.getFunctionalAcctGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_functional_acct_group_id]", getValue("String", row.getClientFunctionalAcctGroupId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CollectionAcctGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CollectionAcctGroupRow row : arrayList.getCollectionAcctGroupRow()){
            parameters.add("collections_acct_group_no["+i+"]", getValue("Long", row.getCollectionsAcctGroupNo()));
            parameters.add("client_collections_acct_group_id["+i+"]", getValue("String", row.getClientCollectionsAcctGroupId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CollectionAcctGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CollectionAcctGroupRow row : arrayList.getCollectionAcctGroupRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[collections_acct_group_no]", getValue("Long", row.getCollectionsAcctGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_collections_acct_group_id]", getValue("String", row.getClientCollectionsAcctGroupId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppFieldArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppFieldRow row : arrayList.getSuppFieldRow()){
            parameters.add("supp_field_name["+i+"]", getValue("String", row.getSuppFieldName()));
            parameters.add("supp_field_value["+i+"]", getValue("String", row.getSuppFieldValue()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppFieldArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppFieldRow row : arrayList.getSuppFieldRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_name]", getValue("String", row.getSuppFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[supp_field_value]", getValue("String", row.getSuppFieldValue()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctSurchargesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctSurchargesRow row : arrayList.getAcctSurchargesRow()){
            parameters.add("acct_surcharge_no["+i+"]", getValue("Long", row.getAcctSurchargeNo()));
            parameters.add("acct_rate_schedule_no["+i+"]", getValue("Long", row.getAcctRateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctSurchargesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctSurchargesRow row : arrayList.getAcctSurchargesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[acct_surcharge_no]", getValue("Long", row.getAcctSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[acct_rate_schedule_no]", getValue("Long", row.getAcctRateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PaymentMethodArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PaymentMethodRow row : arrayList.getPaymentMethodRow()){
            parameters.add("pay_method_type["+i+"]", getValue("Long", row.getPayMethodType()));
            parameters.add("pay_method_name["+i+"]", getValue("String", row.getPayMethodName()));
            parameters.add("pay_method_description["+i+"]", getValue("String", row.getPayMethodDescription()));
            parameters.add("client_pay_method_cdid["+i+"]", getValue("String", row.getClientPayMethodCdid()));
            parameters.add("payment_method_idx["+i+"]", getValue("Long", row.getPaymentMethodIdx()));
            parameters.add("first_name["+i+"]", getValue("String", row.getFirstName()));
            parameters.add("mi["+i+"]", getValue("String", row.getMi()));
            parameters.add("last_name["+i+"]", getValue("String", row.getLastName()));
            parameters.add("company_name["+i+"]", getValue("String", row.getCompanyName()));
            parameters.add("address1["+i+"]", getValue("String", row.getAddress1()));
            parameters.add("address2["+i+"]", getValue("String", row.getAddress2()));
            parameters.add("address3["+i+"]", getValue("String", row.getAddress3()));
            parameters.add("city["+i+"]", getValue("String", row.getCity()));
            parameters.add("locality["+i+"]", getValue("String", row.getLocality()));
            parameters.add("state_prov["+i+"]", getValue("String", row.getStateProv()));
            parameters.add("country["+i+"]", getValue("String", row.getCountry()));
            parameters.add("postal_cd["+i+"]", getValue("String", row.getPostalCd()));
            parameters.add("phone["+i+"]", getValue("String", row.getPhone()));
            parameters.add("phone_ext["+i+"]", getValue("String", row.getPhoneExt()));
            parameters.add("cell_phone["+i+"]", getValue("String", row.getCellPhone()));
            parameters.add("work_phone["+i+"]", getValue("String", row.getWorkPhone()));
            parameters.add("work_phone_ext["+i+"]", getValue("String", row.getWorkPhoneExt()));
            parameters.add("fax["+i+"]", getValue("String", row.getFax()));
            parameters.add("email["+i+"]", getValue("String", row.getEmail()));
            parameters.add("birthdate["+i+"]", getValue("String", row.getBirthdate()));
            parameters.add("cc_num["+i+"]", getValue("String", row.getCcNum()));
            parameters.add("cc_expire_mm["+i+"]", getValue("Long", row.getCcExpireMm()));
            parameters.add("cc_expire_yyyy["+i+"]", getValue("Long", row.getCcExpireYyyy()));
            parameters.add("bank_acct_num["+i+"]", getValue("String", row.getBankAcctNum()));
            parameters.add("bank_routing_no["+i+"]", getValue("String", row.getBankRoutingNo()));
            parameters.add("cvv["+i+"]", getValue("String", row.getCvv()));
            parameters.add("track_data1["+i+"]", getValue("String", row.getTrackData1()));
            parameters.add("track_data2["+i+"]", getValue("String", row.getTrackData2()));
            parameters.add("taxpayer_id["+i+"]", getValue("String", row.getTaxpayerId()));
            parameters.add("bill_agreement_id["+i+"]", getValue("String", row.getBillAgreementId()));
            parameters.add("iban["+i+"]", getValue("String", row.getIban()));
            parameters.add("bank_check_digit["+i+"]", getValue("Long", row.getBankCheckDigit()));
            parameters.add("bank_swift_cd["+i+"]", getValue("String", row.getBankSwiftCd()));
            parameters.add("bank_country_cd["+i+"]", getValue("String", row.getBankCountryCd()));
            parameters.add("mandate_id["+i+"]", getValue("String", row.getMandateId()));
            parameters.add("bank_id_cd["+i+"]", getValue("String", row.getBankIdCd()));
            parameters.add("bank_branch_cd["+i+"]", getValue("String", row.getBankBranchCd()));
            parameters.add("cc_id["+i+"]", getValue("Long", row.getCcId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PaymentMethodArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PaymentMethodRow row : arrayList.getPaymentMethodRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[pay_method_type]", getValue("Long", row.getPayMethodType()));
            parameters.add(paramPrefix + "["+i+"]" + "[pay_method_name]", getValue("String", row.getPayMethodName()));
            parameters.add(paramPrefix + "["+i+"]" + "[pay_method_description]", getValue("String", row.getPayMethodDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_pay_method_cdid]", getValue("String", row.getClientPayMethodCdid()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_idx]", getValue("Long", row.getPaymentMethodIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[first_name]", getValue("String", row.getFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[mi]", getValue("String", row.getMi()));
            parameters.add(paramPrefix + "["+i+"]" + "[last_name]", getValue("String", row.getLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[company_name]", getValue("String", row.getCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[address1]", getValue("String", row.getAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[address2]", getValue("String", row.getAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[address3]", getValue("String", row.getAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[city]", getValue("String", row.getCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[locality]", getValue("String", row.getLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[state_prov]", getValue("String", row.getStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[country]", getValue("String", row.getCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[postal_cd]", getValue("String", row.getPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[phone]", getValue("String", row.getPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[phone_ext]", getValue("String", row.getPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[cell_phone]", getValue("String", row.getCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[work_phone]", getValue("String", row.getWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[work_phone_ext]", getValue("String", row.getWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[fax]", getValue("String", row.getFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[email]", getValue("String", row.getEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[birthdate]", getValue("String", row.getBirthdate()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_num]", getValue("String", row.getCcNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_expire_mm]", getValue("Long", row.getCcExpireMm()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_expire_yyyy]", getValue("Long", row.getCcExpireYyyy()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_acct_num]", getValue("String", row.getBankAcctNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_routing_no]", getValue("String", row.getBankRoutingNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[cvv]", getValue("String", row.getCvv()));
            parameters.add(paramPrefix + "["+i+"]" + "[track_data1]", getValue("String", row.getTrackData1()));
            parameters.add(paramPrefix + "["+i+"]" + "[track_data2]", getValue("String", row.getTrackData2()));
            parameters.add(paramPrefix + "["+i+"]" + "[taxpayer_id]", getValue("String", row.getTaxpayerId()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_agreement_id]", getValue("String", row.getBillAgreementId()));
            parameters.add(paramPrefix + "["+i+"]" + "[iban]", getValue("String", row.getIban()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_check_digit]", getValue("Long", row.getBankCheckDigit()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_swift_cd]", getValue("String", row.getBankSwiftCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_country_cd]", getValue("String", row.getBankCountryCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[mandate_id]", getValue("String", row.getMandateId()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_id_cd]", getValue("String", row.getBankIdCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_branch_cd]", getValue("String", row.getBankBranchCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_id]", getValue("Long", row.getCcId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.BillingGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.BillingGroupRow row : arrayList.getBillingGroupRow()){
            parameters.add("billing_group_name["+i+"]", getValue("String", row.getBillingGroupName()));
            parameters.add("billing_group_description["+i+"]", getValue("String", row.getBillingGroupDescription()));
            parameters.add("client_billing_group_id["+i+"]", getValue("String", row.getClientBillingGroupId()));
            parameters.add("billing_group_idx["+i+"]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add("notify_method["+i+"]", getValue("Long", row.getNotifyMethod()));
            parameters.add("notify_template_group["+i+"]", getValue("Long", row.getNotifyTemplateGroup()));
            parameters.add("statement_template["+i+"]", getValue("Long", row.getStatementTemplate()));
            parameters.add("credit_note_template["+i+"]", getValue("Long", row.getCreditNoteTemplate()));
            parameters.add("primary_client_payment_method_id["+i+"]", getValue("String", row.getPrimaryClientPaymentMethodId()));
            parameters.add("primary_payment_method_idx["+i+"]", getValue("Long", row.getPrimaryPaymentMethodIdx()));
            parameters.add("backup_client_payment_method_id["+i+"]", getValue("String", row.getBackupClientPaymentMethodId()));
            parameters.add("backup_payment_method_idx["+i+"]", getValue("Long", row.getBackupPaymentMethodIdx()));
            parameters.add("first_name["+i+"]", getValue("String", row.getFirstName()));
            parameters.add("mi["+i+"]", getValue("String", row.getMi()));
            parameters.add("last_name["+i+"]", getValue("String", row.getLastName()));
            parameters.add("company_name["+i+"]", getValue("String", row.getCompanyName()));
            parameters.add("address1["+i+"]", getValue("String", row.getAddress1()));
            parameters.add("address2["+i+"]", getValue("String", row.getAddress2()));
            parameters.add("address3["+i+"]", getValue("String", row.getAddress3()));
            parameters.add("city["+i+"]", getValue("String", row.getCity()));
            parameters.add("locality["+i+"]", getValue("String", row.getLocality()));
            parameters.add("state_prov["+i+"]", getValue("String", row.getStateProv()));
            parameters.add("country["+i+"]", getValue("String", row.getCountry()));
            parameters.add("postal_cd["+i+"]", getValue("String", row.getPostalCd()));
            parameters.add("phone["+i+"]", getValue("String", row.getPhone()));
            parameters.add("phone_ext["+i+"]", getValue("String", row.getPhoneExt()));
            parameters.add("cell_phone["+i+"]", getValue("String", row.getCellPhone()));
            parameters.add("work_phone["+i+"]", getValue("String", row.getWorkPhone()));
            parameters.add("work_phone_ext["+i+"]", getValue("String", row.getWorkPhoneExt()));
            parameters.add("fax["+i+"]", getValue("String", row.getFax()));
            parameters.add("email["+i+"]", getValue("String", row.getEmail()));
            parameters.add("birthdate["+i+"]", getValue("String", row.getBirthdate()));
            parameters.add("list_start_master_file["+i+"]", getValue("Long", row.getListStartMasterFile()));
            parameters.add("payment_terms_no["+i+"]", getValue("Long", row.getPaymentTermsNo()));
            parameters.add("payment_terms_name["+i+"]", getValue("String", row.getPaymentTermsName()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.BillingGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.BillingGroupRow row : arrayList.getBillingGroupRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_name]", getValue("String", row.getBillingGroupName()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_description]", getValue("String", row.getBillingGroupDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_billing_group_id]", getValue("String", row.getClientBillingGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_idx]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[notify_method]", getValue("Long", row.getNotifyMethod()));
            parameters.add(paramPrefix + "["+i+"]" + "[notify_template_group]", getValue("Long", row.getNotifyTemplateGroup()));
            parameters.add(paramPrefix + "["+i+"]" + "[statement_template]", getValue("Long", row.getStatementTemplate()));
            parameters.add(paramPrefix + "["+i+"]" + "[credit_note_template]", getValue("Long", row.getCreditNoteTemplate()));
            parameters.add(paramPrefix + "["+i+"]" + "[primary_client_payment_method_id]", getValue("String", row.getPrimaryClientPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[primary_payment_method_idx]", getValue("Long", row.getPrimaryPaymentMethodIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[backup_client_payment_method_id]", getValue("String", row.getBackupClientPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[backup_payment_method_idx]", getValue("Long", row.getBackupPaymentMethodIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[first_name]", getValue("String", row.getFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[mi]", getValue("String", row.getMi()));
            parameters.add(paramPrefix + "["+i+"]" + "[last_name]", getValue("String", row.getLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[company_name]", getValue("String", row.getCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[address1]", getValue("String", row.getAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[address2]", getValue("String", row.getAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[address3]", getValue("String", row.getAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[city]", getValue("String", row.getCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[locality]", getValue("String", row.getLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[state_prov]", getValue("String", row.getStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[country]", getValue("String", row.getCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[postal_cd]", getValue("String", row.getPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[phone]", getValue("String", row.getPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[phone_ext]", getValue("String", row.getPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[cell_phone]", getValue("String", row.getCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[work_phone]", getValue("String", row.getWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[work_phone_ext]", getValue("String", row.getWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[fax]", getValue("String", row.getFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[email]", getValue("String", row.getEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[birthdate]", getValue("String", row.getBirthdate()));
            parameters.add(paramPrefix + "["+i+"]" + "[list_start_master_file]", getValue("Long", row.getListStartMasterFile()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_terms_no]", getValue("Long", row.getPaymentTermsNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_terms_name]", getValue("String", row.getPaymentTermsName()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.DunningGroupArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.DunningGroupRow row : arrayList.getDunningGroupRow()){
            parameters.add("dunning_group_name["+i+"]", getValue("String", row.getDunningGroupName()));
            parameters.add("dunning_group_description["+i+"]", getValue("String", row.getDunningGroupDescription()));
            parameters.add("client_dunning_group_id["+i+"]", getValue("String", row.getClientDunningGroupId()));
            parameters.add("dunning_group_idx["+i+"]", getValue("Long", row.getDunningGroupIdx()));
            parameters.add("dunning_process_no["+i+"]", getValue("Long", row.getDunningProcessNo()));
            parameters.add("client_dunning_process_id["+i+"]", getValue("String", row.getClientDunningProcessId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.DunningGroupArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.DunningGroupRow row : arrayList.getDunningGroupRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_name]", getValue("String", row.getDunningGroupName()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_description]", getValue("String", row.getDunningGroupDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_dunning_group_id]", getValue("String", row.getClientDunningGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_idx]", getValue("Long", row.getDunningGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_process_no]", getValue("Long", row.getDunningProcessNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_dunning_process_id]", getValue("String", row.getClientDunningProcessId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractsRow row : arrayList.getContractsRow()){
            parameters.add("client_contract_id["+i+"]", getValue("String", row.getClientContractId()));
            parameters.add("contract_type_no["+i+"]", getValue("Long", row.getContractTypeNo()));
            parameters.add("contract_length_months["+i+"]", getValue("Long", row.getContractLengthMonths()));
            parameters.add("contract_cancel_fee["+i+"]", getValue("Double", row.getContractCancelFee()));
            parameters.add("contract_comments["+i+"]", getValue("String", row.getContractComments()));
            parameters.add("contract_start_date["+i+"]", getValue("String", row.getContractStartDate()));
            parameters.add("contract_end_date["+i+"]", getValue("String", row.getContractEndDate()));
                        addParameterValuesFromArray(parameters, row.getContractPlans(), "contract_plans["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractsRow row : arrayList.getContractsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_contract_id]", getValue("String", row.getClientContractId()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_type_no]", getValue("Long", row.getContractTypeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_length_months]", getValue("Long", row.getContractLengthMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_cancel_fee]", getValue("Double", row.getContractCancelFee()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_comments]", getValue("String", row.getContractComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_start_date]", getValue("String", row.getContractStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[contract_end_date]", getValue("String", row.getContractEndDate()));
            addParameterValuesFromArray(parameters, row.getContractPlans(), paramPrefix + "["+i+"]" + "[contract_plans][contract_plans_row]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractPlansArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractPlansRow row : arrayList.getContractPlansRow()){
            parameters.add("plan_instance_idx["+i+"]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("cascade_action["+i+"]", getValue("String", row.getCascadeAction()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractPlansArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractPlansRow row : arrayList.getContractPlansRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_idx]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[cascade_action]", getValue("String", row.getCascadeAction()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlansDetailArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlansDetailRow row : arrayList.getMasterPlansDetailRow()){
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            parameters.add("client_plan_id["+i+"]", getValue("String", row.getClientPlanId()));
            parameters.add("plan_instance_description["+i+"]", getValue("String", row.getPlanInstanceDescription()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("plan_instance_idx["+i+"]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add("promo_cd["+i+"]", getValue("String", row.getPromoCd()));
            parameters.add("plan_instance_units["+i+"]", getValue("Long", row.getPlanInstanceUnits()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstances(), "plan_unit_instances["+i+"]");
            parameters.add("plan_instance_status["+i+"]", getValue("Long", row.getPlanInstanceStatus()));
            parameters.add("resp_level_cd["+i+"]", getValue("Long", row.getRespLevelCd()));
            parameters.add("resp_master_plan_inst_no["+i+"]", getValue("Long", row.getRespMasterPlanInstNo()));
            parameters.add("client_resp_master_plan_inst_id["+i+"]", getValue("String", row.getClientRespMasterPlanInstId()));
            parameters.add("resp_master_plan_inst_idx["+i+"]", getValue("Long", row.getRespMasterPlanInstIdx()));
            parameters.add("client_billing_group_id["+i+"]", getValue("String", row.getClientBillingGroupId()));
            parameters.add("billing_group_idx["+i+"]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add("client_dunning_group_id["+i+"]", getValue("String", row.getClientDunningGroupId()));
            parameters.add("dunning_group_idx["+i+"]", getValue("Long", row.getDunningGroupIdx()));
            parameters.add("status_until_alt_start["+i+"]", getValue("Long", row.getStatusUntilAltStart()));
            parameters.add("balance_forward["+i+"]", getValue("Double", row.getBalanceForward()));
                        addParameterValuesFromArray(parameters, row.getCouponCodes(), "coupon_codes["+i+"]");
                        addParameterValuesFromArray(parameters, row.getMpiSurcharges(), "mpi_surcharges["+i+"]");
            parameters.add("nso_bill_immediately["+i+"]", getValue("Long", row.getNsoBillImmediately()));
                        addParameterValuesFromArray(parameters, row.getMasterPlanNsoList(), "master_plan_nso_list["+i+"]");
            parameters.add("nso_po_num["+i+"]", getValue("String", row.getNsoPoNum()));
                        addParameterValuesFromArray(parameters, row.getPlanInstanceFieldsInfo(), "plan_instance_fields_info["+i+"]");
            parameters.add("alt_rate_schedule_no["+i+"]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add("client_alt_rate_schedule_id["+i+"]", getValue("String", row.getClientAltRateScheduleId()));
            parameters.add("usage_accumulation_reset_months["+i+"]", getValue("Long", row.getUsageAccumulationResetMonths()));
            parameters.add("usage_pooling["+i+"]", getValue("String", row.getUsagePooling()));
            parameters.add("usage_threshold_applicability["+i+"]", getValue("String", row.getUsageThresholdApplicability()));
                        addParameterValuesFromArray(parameters, row.getCustomRates(), "custom_rates["+i+"]");
            parameters.add("po_num["+i+"]", getValue("String", row.getPoNum()));
                        addParameterValuesFromArray(parameters, row.getSuppPlan(), "supp_plan["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlansDetailArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlansDetailRow row : arrayList.getMasterPlansDetailRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_id]", getValue("String", row.getClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_description]", getValue("String", row.getPlanInstanceDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_idx]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[promo_cd]", getValue("String", row.getPromoCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_units]", getValue("Long", row.getPlanInstanceUnits()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstances(), paramPrefix + "["+i+"]" + "[plan_unit_instances][plan_unit_instances_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_status]", getValue("Long", row.getPlanInstanceStatus()));
            parameters.add(paramPrefix + "["+i+"]" + "[resp_level_cd]", getValue("Long", row.getRespLevelCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[resp_master_plan_inst_no]", getValue("Long", row.getRespMasterPlanInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_resp_master_plan_inst_id]", getValue("String", row.getClientRespMasterPlanInstId()));
            parameters.add(paramPrefix + "["+i+"]" + "[resp_master_plan_inst_idx]", getValue("Long", row.getRespMasterPlanInstIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_billing_group_id]", getValue("String", row.getClientBillingGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_idx]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_dunning_group_id]", getValue("String", row.getClientDunningGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_idx]", getValue("Long", row.getDunningGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[status_until_alt_start]", getValue("Long", row.getStatusUntilAltStart()));
            parameters.add(paramPrefix + "["+i+"]" + "[balance_forward]", getValue("Double", row.getBalanceForward()));
            addParameterValuesFromArray(parameters, row.getCouponCodes(), paramPrefix + "["+i+"]" + "[coupon_codes][coupon_codes_row]");
            addParameterValuesFromArray(parameters, row.getMpiSurcharges(), paramPrefix + "["+i+"]" + "[mpi_surcharges][mpi_surcharges_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[nso_bill_immediately]", getValue("Long", row.getNsoBillImmediately()));
            addParameterValuesFromArray(parameters, row.getMasterPlanNsoList(), paramPrefix + "["+i+"]" + "[master_plan_nso_list][master_plan_nso_list_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[nso_po_num]", getValue("String", row.getNsoPoNum()));
            addParameterValuesFromArray(parameters, row.getPlanInstanceFieldsInfo(), paramPrefix + "["+i+"]" + "[plan_instance_fields_info][plan_instance_fields_info_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[alt_rate_schedule_no]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_alt_rate_schedule_id]", getValue("String", row.getClientAltRateScheduleId()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_accumulation_reset_months]", getValue("Long", row.getUsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_pooling]", getValue("String", row.getUsagePooling()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_threshold_applicability]", getValue("String", row.getUsageThresholdApplicability()));
            addParameterValuesFromArray(parameters, row.getCustomRates(), paramPrefix + "["+i+"]" + "[custom_rates][custom_rates_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[po_num]", getValue("String", row.getPoNum()));
            addParameterValuesFromArray(parameters, row.getSuppPlan(), paramPrefix + "["+i+"]" + "[supp_plan][supp_plan_row]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstancesRow row : arrayList.getPlanUnitInstancesRow()){
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstanceServices(), "plan_unit_instance_services["+i+"]");
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstFields(), "plan_unit_inst_fields["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstancesRow row : arrayList.getPlanUnitInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstanceServices(), paramPrefix + "["+i+"]" + "[plan_unit_instance_services][plan_unit_instance_services_row]");
            addParameterValuesFromArray(parameters, row.getPlanUnitInstFields(), paramPrefix + "["+i+"]" + "[plan_unit_inst_fields][plan_unit_inst_fields_row]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstanceServicesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstanceServicesRow row : arrayList.getPlanUnitInstanceServicesRow()){
            parameters.add("service_no["+i+"]", getValue("Long", row.getServiceNo()));
            parameters.add("client_service_id["+i+"]", getValue("String", row.getClientServiceId()));
            parameters.add("service_fulfillment_date["+i+"]", getValue("String", row.getServiceFulfillmentDate()));
            parameters.add("fulfillment_directive["+i+"]", getValue("Long", row.getFulfillmentDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstanceServicesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstanceServicesRow row : arrayList.getPlanUnitInstanceServicesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[service_no]", getValue("Long", row.getServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_service_id]", getValue("String", row.getClientServiceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[service_fulfillment_date]", getValue("String", row.getServiceFulfillmentDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[fulfillment_directive]", getValue("Long", row.getFulfillmentDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlanNsoListArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlanNsoListRow row : arrayList.getMasterPlanNsoListRow()){
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("item_units["+i+"]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlanNsoListArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlanNsoListRow row : arrayList.getMasterPlanNsoListRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[item_units]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceFieldsInfoArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceFieldsInfoRow row : arrayList.getPlanInstanceFieldsInfoRow()){
            parameters.add("field_no["+i+"]", getValue("Long", row.getFieldNo()));
            parameters.add("field_name["+i+"]", getValue("String", row.getFieldName()));
            parameters.add("field_value["+i+"]", getValue("String", row.getFieldValue()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceFieldsInfoArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceFieldsInfoRow row : arrayList.getPlanInstanceFieldsInfoRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[field_no]", getValue("Long", row.getFieldNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[field_name]", getValue("String", row.getFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[field_value]", getValue("String", row.getFieldValue()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanRow row : arrayList.getSuppPlanRow()){
                        addParameterValuesFromArray(parameters, row.getSuppPlan(), "supp_plan["+i+"]");
            parameters.add("plan_no["+i+"]", getValue("Long", row.getPlanNo()));
            parameters.add("client_plan_id["+i+"]", getValue("String", row.getClientPlanId()));
            parameters.add("plan_instance_description["+i+"]", getValue("String", row.getPlanInstanceDescription()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("plan_instance_idx["+i+"]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add("plan_instance_units["+i+"]", getValue("Long", row.getPlanInstanceUnits()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstances(), "plan_unit_instances["+i+"]");
                        addParameterValuesFromArray(parameters, row.getSuppPlanNsoList(), "supp_plan_nso_list["+i+"]");
                        addParameterValuesFromArray(parameters, row.getPlanInstanceFieldsInfo(), "plan_instance_fields_info["+i+"]");
            parameters.add("alt_rate_schedule_no["+i+"]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add("client_alt_rate_schedule_id["+i+"]", getValue("String", row.getClientAltRateScheduleId()));
            parameters.add("usage_accumulation_reset_months["+i+"]", getValue("Long", row.getUsageAccumulationResetMonths()));
            parameters.add("usage_pooling["+i+"]", getValue("String", row.getUsagePooling()));
            parameters.add("usage_threshold_applicability["+i+"]", getValue("String", row.getUsageThresholdApplicability()));
                        addParameterValuesFromArray(parameters, row.getCustomRates(), "custom_rates["+i+"]");
            parameters.add("po_num["+i+"]", getValue("String", row.getPoNum()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanRow row : arrayList.getSuppPlanRow()){
            addParameterValuesFromArray(parameters, row.getSuppPlan(), paramPrefix + "["+i+"]" + "[supp_plan][supp_plan_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[plan_no]", getValue("Long", row.getPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_id]", getValue("String", row.getClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_description]", getValue("String", row.getPlanInstanceDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_idx]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_units]", getValue("Long", row.getPlanInstanceUnits()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstances(), paramPrefix + "["+i+"]" + "[plan_unit_instances][plan_unit_instances_row]");
            addParameterValuesFromArray(parameters, row.getSuppPlanNsoList(), paramPrefix + "["+i+"]" + "[supp_plan_nso_list][supp_plan_nso_list_row]");
            addParameterValuesFromArray(parameters, row.getPlanInstanceFieldsInfo(), paramPrefix + "["+i+"]" + "[plan_instance_fields_info][plan_instance_fields_info_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[alt_rate_schedule_no]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_alt_rate_schedule_id]", getValue("String", row.getClientAltRateScheduleId()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_accumulation_reset_months]", getValue("Long", row.getUsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_pooling]", getValue("String", row.getUsagePooling()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_threshold_applicability]", getValue("String", row.getUsageThresholdApplicability()));
            addParameterValuesFromArray(parameters, row.getCustomRates(), paramPrefix + "["+i+"]" + "[custom_rates][custom_rates_row]");
            parameters.add(paramPrefix + "["+i+"]" + "[po_num]", getValue("String", row.getPoNum()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanNsoListArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanNsoListRow row : arrayList.getSuppPlanNsoListRow()){
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("item_units["+i+"]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SuppPlanNsoListArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SuppPlanNsoListRow row : arrayList.getSuppPlanNsoListRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[item_units]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EligiblePlanInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EligiblePlanInstancesRow row : arrayList.getEligiblePlanInstancesRow()){
            parameters.add("plan_instance_no["+i+"]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add("plan_instance_service_no["+i+"]", getValue("Long", row.getPlanInstanceServiceNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.EligiblePlanInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.EligiblePlanInstancesRow row : arrayList.getEligiblePlanInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_no]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_service_no]", getValue("Long", row.getPlanInstanceServiceNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientEligiblePlanInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientEligiblePlanInstancesRow row : arrayList.getClientEligiblePlanInstancesRow()){
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("client_plan_instance_service_id["+i+"]", getValue("String", row.getClientPlanInstanceServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ClientEligiblePlanInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ClientEligiblePlanInstancesRow row : arrayList.getClientEligiblePlanInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_service_id]", getValue("String", row.getClientPlanInstanceServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractPlanInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractPlanInstancesRow row : arrayList.getContractPlanInstancesRow()){
            parameters.add("plan_instance_no["+i+"]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("rollover_plan_no["+i+"]", getValue("Long", row.getRolloverPlanNo()));
            parameters.add("rollover_client_plan_id["+i+"]", getValue("String", row.getRolloverClientPlanId()));
            parameters.add("rollover_rate_sched_no["+i+"]", getValue("Long", row.getRolloverRateSchedNo()));
            parameters.add("rollover_client_rate_sched_id["+i+"]", getValue("String", row.getRolloverClientRateSchedId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractPlanInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractPlanInstancesRow row : arrayList.getContractPlanInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_no]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_plan_no]", getValue("Long", row.getRolloverPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_client_plan_id]", getValue("String", row.getRolloverClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_rate_sched_no]", getValue("Long", row.getRolloverRateSchedNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_client_rate_sched_id]", getValue("String", row.getRolloverClientRateSchedId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractRolloverCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractRolloverCustomRatesRow row : arrayList.getContractRolloverCustomRatesRow()){
            parameters.add("custom_rate_plan_instance_no["+i+"]", getValue("Long", row.getCustomRatePlanInstanceNo()));
            parameters.add("custom_rate_client_plan_instance_id["+i+"]", getValue("String", row.getCustomRateClientPlanInstanceId()));
            parameters.add("custom_rate_service_no["+i+"]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add("custom_rate_client_service_id["+i+"]", getValue("String", row.getCustomRateClientServiceId()));
            parameters.add("custom_rate_seq_no["+i+"]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add("custom_rate_from_unit["+i+"]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add("custom_rate_to_unit["+i+"]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add("custom_rate_per_unit["+i+"]", getValue("Double", row.getCustomRatePerUnit()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractRolloverCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractRolloverCustomRatesRow row : arrayList.getContractRolloverCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_plan_instance_no]", getValue("Long", row.getCustomRatePlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_client_plan_instance_id]", getValue("String", row.getCustomRateClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_service_no]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_client_service_id]", getValue("String", row.getCustomRateClientServiceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_seq_no]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_from_unit]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_to_unit]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_per_unit]", getValue("Double", row.getCustomRatePerUnit()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.RemovePlanUnitsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.RemovePlanUnitsRow row : arrayList.getRemovePlanUnitsRow()){
            parameters.add("plan_unit_inst_no["+i+"]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.RemovePlanUnitsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.RemovePlanUnitsRow row : arrayList.getRemovePlanUnitsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_no]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractPlanInstancesUpdateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractPlanInstancesUpdateRow row : arrayList.getContractPlanInstancesUpdateRow()){
            parameters.add("plan_instance_no["+i+"]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("rollover_plan_no["+i+"]", getValue("Long", row.getRolloverPlanNo()));
            parameters.add("rollover_client_plan_id["+i+"]", getValue("String", row.getRolloverClientPlanId()));
            parameters.add("rollover_rate_sched_no["+i+"]", getValue("Long", row.getRolloverRateSchedNo()));
            parameters.add("rollover_client_rate_sched_id["+i+"]", getValue("String", row.getRolloverClientRateSchedId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.ContractPlanInstancesUpdateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.ContractPlanInstancesUpdateRow row : arrayList.getContractPlanInstancesUpdateRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_no]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_plan_no]", getValue("Long", row.getRolloverPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_client_plan_id]", getValue("String", row.getRolloverClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_rate_sched_no]", getValue("Long", row.getRolloverRateSchedNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[rollover_client_rate_sched_id]", getValue("String", row.getRolloverClientRateSchedId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MpSurchargesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MpSurchargesRow row : arrayList.getMpSurchargesRow()){
            parameters.add("mp_surcharge_no["+i+"]", getValue("Long", row.getMpSurchargeNo()));
            parameters.add("mp_surcharge_directive["+i+"]", getValue("Long", row.getMpSurchargeDirective()));
            parameters.add("mp_rate_schedule_no["+i+"]", getValue("Long", row.getMpRateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MpSurchargesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MpSurchargesRow row : arrayList.getMpSurchargesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[mp_surcharge_no]", getValue("Long", row.getMpSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[mp_surcharge_directive]", getValue("Long", row.getMpSurchargeDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[mp_rate_schedule_no]", getValue("Long", row.getMpRateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceFieldUpdateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceFieldUpdateRow row : arrayList.getPlanInstanceFieldUpdateRow()){
            parameters.add("plan_instance_field_name["+i+"]", getValue("String", row.getPlanInstanceFieldName()));
            parameters.add("plan_instance_field_value["+i+"]", getValue("String", row.getPlanInstanceFieldValue()));
            parameters.add("plan_instance_field_directive["+i+"]", getValue("Long", row.getPlanInstanceFieldDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanInstanceFieldUpdateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanInstanceFieldUpdateRow row : arrayList.getPlanInstanceFieldUpdateRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_name]", getValue("String", row.getPlanInstanceFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_value]", getValue("String", row.getPlanInstanceFieldValue()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_directive]", getValue("Long", row.getPlanInstanceFieldDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctCouponsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctCouponsRow row : arrayList.getAcctCouponsRow()){
            parameters.add("acct_coupon_cd["+i+"]", getValue("String", row.getAcctCouponCd()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctCouponsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctCouponsRow row : arrayList.getAcctCouponsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[acct_coupon_cd]", getValue("String", row.getAcctCouponCd()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.FunctionalAcctGroupsUpdateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.FunctionalAcctGroupsUpdateRow row : arrayList.getFunctionalAcctGroupsUpdateRow()){
            parameters.add("functional_acct_group_no["+i+"]", getValue("Long", row.getFunctionalAcctGroupNo()));
            parameters.add("client_functional_acct_group_id["+i+"]", getValue("String", row.getClientFunctionalAcctGroupId()));
            parameters.add("functional_acct_grp_directive["+i+"]", getValue("Long", row.getFunctionalAcctGrpDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.FunctionalAcctGroupsUpdateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.FunctionalAcctGroupsUpdateRow row : arrayList.getFunctionalAcctGroupsUpdateRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[functional_acct_group_no]", getValue("Long", row.getFunctionalAcctGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_functional_acct_group_id]", getValue("String", row.getClientFunctionalAcctGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[functional_acct_grp_directive]", getValue("Long", row.getFunctionalAcctGrpDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CollectionAcctGroupsUpdateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CollectionAcctGroupsUpdateRow row : arrayList.getCollectionAcctGroupsUpdateRow()){
            parameters.add("collection_acct_group_no["+i+"]", getValue("Long", row.getCollectionAcctGroupNo()));
            parameters.add("client_collection_acct_group_id["+i+"]", getValue("String", row.getClientCollectionAcctGroupId()));
            parameters.add("collection_acct_grp_directive["+i+"]", getValue("Long", row.getCollectionAcctGrpDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CollectionAcctGroupsUpdateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CollectionAcctGroupsUpdateRow row : arrayList.getCollectionAcctGroupsUpdateRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[collection_acct_group_no]", getValue("Long", row.getCollectionAcctGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_collection_acct_group_id]", getValue("String", row.getClientCollectionAcctGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[collection_acct_grp_directive]", getValue("Long", row.getCollectionAcctGrpDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctSuppFieldsUpdateArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctSuppFieldsUpdateRow row : arrayList.getAcctSuppFieldsUpdateRow()){
            parameters.add("acct_supp_field_name["+i+"]", getValue("String", row.getAcctSuppFieldName()));
            parameters.add("acct_supp_field_value["+i+"]", getValue("String", row.getAcctSuppFieldValue()));
            parameters.add("acct_supp_field_directive["+i+"]", getValue("Long", row.getAcctSuppFieldDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctSuppFieldsUpdateArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctSuppFieldsUpdateRow row : arrayList.getAcctSuppFieldsUpdateRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[acct_supp_field_name]", getValue("String", row.getAcctSuppFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[acct_supp_field_value]", getValue("String", row.getAcctSuppFieldValue()));
            parameters.add(paramPrefix + "["+i+"]" + "[acct_supp_field_directive]", getValue("Long", row.getAcctSuppFieldDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AccountSurchargesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AccountSurchargesRow row : arrayList.getAccountSurchargesRow()){
            parameters.add("surcharge_no["+i+"]", getValue("Long", row.getSurchargeNo()));
            parameters.add("surcharge_directive["+i+"]", getValue("Long", row.getSurchargeDirective()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AccountSurchargesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AccountSurchargesRow row : arrayList.getAccountSurchargesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_no]", getValue("Long", row.getSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_directive]", getValue("Long", row.getSurchargeDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MpCouponsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MpCouponsRow row : arrayList.getMpCouponsRow()){
            parameters.add("mp_coupon_cd["+i+"]", getValue("String", row.getMpCouponCd()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MpCouponsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MpCouponsRow row : arrayList.getMpCouponsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[mp_coupon_cd]", getValue("String", row.getMpCouponCd()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlanPlanInstFieldsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlanPlanInstFieldsRow row : arrayList.getMasterPlanPlanInstFieldsRow()){
            parameters.add("plan_instance_field_name["+i+"]", getValue("String", row.getPlanInstanceFieldName()));
            parameters.add("plan_instance_field_value["+i+"]", getValue("String", row.getPlanInstanceFieldValue()));
            parameters.add("plan_instance_field_directive["+i+"]", getValue("Long", row.getPlanInstanceFieldDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.MasterPlanPlanInstFieldsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.MasterPlanPlanInstFieldsRow row : arrayList.getMasterPlanPlanInstFieldsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_name]", getValue("String", row.getPlanInstanceFieldName()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_value]", getValue("String", row.getPlanInstanceFieldValue()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_field_directive]", getValue("Long", row.getPlanInstanceFieldDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctCustomRatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctCustomRatesRow row : arrayList.getUpdateAcctCustomRatesRow()){
            parameters.add("custom_rate_service_no["+i+"]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add("custom_rate_seq_no["+i+"]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add("custom_rate_from_unit["+i+"]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add("custom_rate_to_unit["+i+"]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add("custom_rate_per_unit["+i+"]", getValue("Double", row.getCustomRatePerUnit()));
            parameters.add("custom_rate_client_service_id["+i+"]", getValue("String", row.getCustomRateClientServiceId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdateAcctCustomRatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdateAcctCustomRatesRow row : arrayList.getUpdateAcctCustomRatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_service_no]", getValue("Long", row.getCustomRateServiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_seq_no]", getValue("Long", row.getCustomRateSeqNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_from_unit]", getValue("Long", row.getCustomRateFromUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_to_unit]", getValue("Long", row.getCustomRateToUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_per_unit]", getValue("Double", row.getCustomRatePerUnit()));
            parameters.add(paramPrefix + "["+i+"]" + "[custom_rate_client_service_id]", getValue("String", row.getCustomRateClientServiceId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.BillingGroupsArrayArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.BillingGroupsArrayRow row : arrayList.getBillingGroupsArrayRow()){
            parameters.add("billing_group_name["+i+"]", getValue("String", row.getBillingGroupName()));
            parameters.add("billing_group_description["+i+"]", getValue("String", row.getBillingGroupDescription()));
            parameters.add("billing_group_no["+i+"]", getValue("Long", row.getBillingGroupNo()));
            parameters.add("client_billing_group_id["+i+"]", getValue("String", row.getClientBillingGroupId()));
            parameters.add("bg_notify_method["+i+"]", getValue("Long", row.getBgNotifyMethod()));
            parameters.add("notify_template_group["+i+"]", getValue("Long", row.getNotifyTemplateGroup()));
            parameters.add("statement_template["+i+"]", getValue("Long", row.getStatementTemplate()));
            parameters.add("credit_note_template["+i+"]", getValue("Long", row.getCreditNoteTemplate()));
            parameters.add("primary_payment_method_no["+i+"]", getValue("Long", row.getPrimaryPaymentMethodNo()));
            parameters.add("client_primary_payment_method_id["+i+"]", getValue("String", row.getClientPrimaryPaymentMethodId()));
            parameters.add("backup_payment_method_no["+i+"]", getValue("Long", row.getBackupPaymentMethodNo()));
            parameters.add("client_backup_payment_method_id["+i+"]", getValue("String", row.getClientBackupPaymentMethodId()));
            parameters.add("stmt_first_name["+i+"]", getValue("String", row.getStmtFirstName()));
            parameters.add("stmt_mi["+i+"]", getValue("String", row.getStmtMi()));
            parameters.add("stmt_last_name["+i+"]", getValue("String", row.getStmtLastName()));
            parameters.add("stmt_company_name["+i+"]", getValue("String", row.getStmtCompanyName()));
            parameters.add("stmt_address1["+i+"]", getValue("String", row.getStmtAddress1()));
            parameters.add("stmt_address2["+i+"]", getValue("String", row.getStmtAddress2()));
            parameters.add("stmt_address3["+i+"]", getValue("String", row.getStmtAddress3()));
            parameters.add("stmt_city["+i+"]", getValue("String", row.getStmtCity()));
            parameters.add("stmt_locality["+i+"]", getValue("String", row.getStmtLocality()));
            parameters.add("stmt_state_prov["+i+"]", getValue("String", row.getStmtStateProv()));
            parameters.add("stmt_country["+i+"]", getValue("String", row.getStmtCountry()));
            parameters.add("stmt_postal_cd["+i+"]", getValue("String", row.getStmtPostalCd()));
            parameters.add("stmt_phone["+i+"]", getValue("String", row.getStmtPhone()));
            parameters.add("stmt_phone_ext["+i+"]", getValue("String", row.getStmtPhoneExt()));
            parameters.add("stmt_cell_phone["+i+"]", getValue("String", row.getStmtCellPhone()));
            parameters.add("stmt_work_phone["+i+"]", getValue("String", row.getStmtWorkPhone()));
            parameters.add("stmt_work_phone_ext["+i+"]", getValue("String", row.getStmtWorkPhoneExt()));
            parameters.add("stmt_fax["+i+"]", getValue("String", row.getStmtFax()));
            parameters.add("stmt_email["+i+"]", getValue("String", row.getStmtEmail()));
            parameters.add("stmt_birthdate["+i+"]", getValue("String", row.getStmtBirthdate()));
            parameters.add("bg_list_start_master_file["+i+"]", getValue("Long", row.getBgListStartMasterFile()));
            parameters.add("payment_terms_no["+i+"]", getValue("Long", row.getPaymentTermsNo()));
            parameters.add("payment_terms_name["+i+"]", getValue("String", row.getPaymentTermsName()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.BillingGroupsArrayArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.BillingGroupsArrayRow row : arrayList.getBillingGroupsArrayRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_name]", getValue("String", row.getBillingGroupName()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_description]", getValue("String", row.getBillingGroupDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_no]", getValue("Long", row.getBillingGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_billing_group_id]", getValue("String", row.getClientBillingGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[bg_notify_method]", getValue("Long", row.getBgNotifyMethod()));
            parameters.add(paramPrefix + "["+i+"]" + "[notify_template_group]", getValue("Long", row.getNotifyTemplateGroup()));
            parameters.add(paramPrefix + "["+i+"]" + "[statement_template]", getValue("Long", row.getStatementTemplate()));
            parameters.add(paramPrefix + "["+i+"]" + "[credit_note_template]", getValue("Long", row.getCreditNoteTemplate()));
            parameters.add(paramPrefix + "["+i+"]" + "[primary_payment_method_no]", getValue("Long", row.getPrimaryPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_primary_payment_method_id]", getValue("String", row.getClientPrimaryPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[backup_payment_method_no]", getValue("Long", row.getBackupPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_backup_payment_method_id]", getValue("String", row.getClientBackupPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_first_name]", getValue("String", row.getStmtFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_mi]", getValue("String", row.getStmtMi()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_last_name]", getValue("String", row.getStmtLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_company_name]", getValue("String", row.getStmtCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_address1]", getValue("String", row.getStmtAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_address2]", getValue("String", row.getStmtAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_address3]", getValue("String", row.getStmtAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_city]", getValue("String", row.getStmtCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_locality]", getValue("String", row.getStmtLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_state_prov]", getValue("String", row.getStmtStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_country]", getValue("String", row.getStmtCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_postal_cd]", getValue("String", row.getStmtPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_phone]", getValue("String", row.getStmtPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_phone_ext]", getValue("String", row.getStmtPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_cell_phone]", getValue("String", row.getStmtCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_work_phone]", getValue("String", row.getStmtWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_work_phone_ext]", getValue("String", row.getStmtWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_fax]", getValue("String", row.getStmtFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_email]", getValue("String", row.getStmtEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_birthdate]", getValue("String", row.getStmtBirthdate()));
            parameters.add(paramPrefix + "["+i+"]" + "[bg_list_start_master_file]", getValue("Long", row.getBgListStartMasterFile()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_terms_no]", getValue("Long", row.getPaymentTermsNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_terms_name]", getValue("String", row.getPaymentTermsName()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PaymentMethodsArrayArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PaymentMethodsArrayRow row : arrayList.getPaymentMethodsArrayRow()){
            parameters.add("payment_method_no["+i+"]", getValue("Long", row.getPaymentMethodNo()));
            parameters.add("bill_first_name["+i+"]", getValue("String", row.getBillFirstName()));
            parameters.add("bill_middle_initial["+i+"]", getValue("String", row.getBillMiddleInitial()));
            parameters.add("bill_last_name["+i+"]", getValue("String", row.getBillLastName()));
            parameters.add("bill_company_name["+i+"]", getValue("String", row.getBillCompanyName()));
            parameters.add("bill_address1["+i+"]", getValue("String", row.getBillAddress1()));
            parameters.add("bill_address2["+i+"]", getValue("String", row.getBillAddress2()));
            parameters.add("bill_address3["+i+"]", getValue("String", row.getBillAddress3()));
            parameters.add("bill_city["+i+"]", getValue("String", row.getBillCity()));
            parameters.add("bill_locality["+i+"]", getValue("String", row.getBillLocality()));
            parameters.add("bill_state_prov["+i+"]", getValue("String", row.getBillStateProv()));
            parameters.add("bill_country["+i+"]", getValue("String", row.getBillCountry()));
            parameters.add("bill_postal_cd["+i+"]", getValue("String", row.getBillPostalCd()));
            parameters.add("bill_phone["+i+"]", getValue("String", row.getBillPhone()));
            parameters.add("bill_phone_ext["+i+"]", getValue("String", row.getBillPhoneExt()));
            parameters.add("bill_cell_phone["+i+"]", getValue("String", row.getBillCellPhone()));
            parameters.add("bill_work_phone["+i+"]", getValue("String", row.getBillWorkPhone()));
            parameters.add("bill_work_phone_ext["+i+"]", getValue("String", row.getBillWorkPhoneExt()));
            parameters.add("bill_fax["+i+"]", getValue("String", row.getBillFax()));
            parameters.add("bill_email["+i+"]", getValue("String", row.getBillEmail()));
            parameters.add("bill_birthdate["+i+"]", getValue("String", row.getBillBirthdate()));
            parameters.add("pay_method_name["+i+"]", getValue("String", row.getPayMethodName()));
            parameters.add("client_pay_method_id["+i+"]", getValue("String", row.getClientPayMethodId()));
            parameters.add("pay_method_description["+i+"]", getValue("String", row.getPayMethodDescription()));
            parameters.add("pay_method_type["+i+"]", getValue("Long", row.getPayMethodType()));
            parameters.add("cc_num["+i+"]", getValue("String", row.getCcNum()));
            parameters.add("cc_expire_mm["+i+"]", getValue("Long", row.getCcExpireMm()));
            parameters.add("cc_expire_yyyy["+i+"]", getValue("Long", row.getCcExpireYyyy()));
            parameters.add("bank_acct_num["+i+"]", getValue("String", row.getBankAcctNum()));
            parameters.add("bank_routing_num["+i+"]", getValue("String", row.getBankRoutingNum()));
            parameters.add("cvv["+i+"]", getValue("String", row.getCvv()));
            parameters.add("track_data1["+i+"]", getValue("String", row.getTrackData1()));
            parameters.add("track_data2["+i+"]", getValue("String", row.getTrackData2()));
            parameters.add("bill_agreement_id["+i+"]", getValue("String", row.getBillAgreementId()));
            parameters.add("iban["+i+"]", getValue("String", row.getIban()));
            parameters.add("bank_check_digit["+i+"]", getValue("Long", row.getBankCheckDigit()));
            parameters.add("bank_swift_cd["+i+"]", getValue("String", row.getBankSwiftCd()));
            parameters.add("bank_country_cd["+i+"]", getValue("String", row.getBankCountryCd()));
            parameters.add("mandate_id["+i+"]", getValue("String", row.getMandateId()));
            parameters.add("bank_id_cd["+i+"]", getValue("String", row.getBankIdCd()));
            parameters.add("bank_branch_cd["+i+"]", getValue("String", row.getBankBranchCd()));
            parameters.add("do_collect["+i+"]", getValue("String", row.getDoCollect()));
            parameters.add("change_status_after_coll["+i+"]", getValue("String", row.getChangeStatusAfterColl()));
            parameters.add("cc_id["+i+"]", getValue("Long", row.getCcId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PaymentMethodsArrayArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PaymentMethodsArrayRow row : arrayList.getPaymentMethodsArrayRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_no]", getValue("Long", row.getPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_first_name]", getValue("String", row.getBillFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_middle_initial]", getValue("String", row.getBillMiddleInitial()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_last_name]", getValue("String", row.getBillLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_company_name]", getValue("String", row.getBillCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_address1]", getValue("String", row.getBillAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_address2]", getValue("String", row.getBillAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_address3]", getValue("String", row.getBillAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_city]", getValue("String", row.getBillCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_locality]", getValue("String", row.getBillLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_state_prov]", getValue("String", row.getBillStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_country]", getValue("String", row.getBillCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_postal_cd]", getValue("String", row.getBillPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_phone]", getValue("String", row.getBillPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_phone_ext]", getValue("String", row.getBillPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_cell_phone]", getValue("String", row.getBillCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_work_phone]", getValue("String", row.getBillWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_work_phone_ext]", getValue("String", row.getBillWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_fax]", getValue("String", row.getBillFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_email]", getValue("String", row.getBillEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_birthdate]", getValue("String", row.getBillBirthdate()));
            parameters.add(paramPrefix + "["+i+"]" + "[pay_method_name]", getValue("String", row.getPayMethodName()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_pay_method_id]", getValue("String", row.getClientPayMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[pay_method_description]", getValue("String", row.getPayMethodDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[pay_method_type]", getValue("Long", row.getPayMethodType()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_num]", getValue("String", row.getCcNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_expire_mm]", getValue("Long", row.getCcExpireMm()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_expire_yyyy]", getValue("Long", row.getCcExpireYyyy()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_acct_num]", getValue("String", row.getBankAcctNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_routing_num]", getValue("String", row.getBankRoutingNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[cvv]", getValue("String", row.getCvv()));
            parameters.add(paramPrefix + "["+i+"]" + "[track_data1]", getValue("String", row.getTrackData1()));
            parameters.add(paramPrefix + "["+i+"]" + "[track_data2]", getValue("String", row.getTrackData2()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_agreement_id]", getValue("String", row.getBillAgreementId()));
            parameters.add(paramPrefix + "["+i+"]" + "[iban]", getValue("String", row.getIban()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_check_digit]", getValue("Long", row.getBankCheckDigit()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_swift_cd]", getValue("String", row.getBankSwiftCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_country_cd]", getValue("String", row.getBankCountryCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[mandate_id]", getValue("String", row.getMandateId()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_id_cd]", getValue("String", row.getBankIdCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_branch_cd]", getValue("String", row.getBankBranchCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[do_collect]", getValue("String", row.getDoCollect()));
            parameters.add(paramPrefix + "["+i+"]" + "[change_status_after_coll]", getValue("String", row.getChangeStatusAfterColl()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_id]", getValue("Long", row.getCcId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUpdatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUpdatesRow row : arrayList.getPlanUpdatesRow()){
            parameters.add("plan_directive["+i+"]", getValue("Long", row.getPlanDirective()));
            parameters.add("existing_plan_instance_no["+i+"]", getValue("Long", row.getExistingPlanInstanceNo()));
            parameters.add("existing_client_plan_instance_id["+i+"]", getValue("String", row.getExistingClientPlanInstanceId()));
            parameters.add("new_client_plan_instance_id["+i+"]", getValue("String", row.getNewClientPlanInstanceId()));
            parameters.add("plan_instance_idx["+i+"]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add("plan_instance_description["+i+"]", getValue("String", row.getPlanInstanceDescription()));
            parameters.add("new_plan_no["+i+"]", getValue("Long", row.getNewPlanNo()));
            parameters.add("new_client_plan_id["+i+"]", getValue("String", row.getNewClientPlanId()));
            parameters.add("promo_cd["+i+"]", getValue("String", row.getPromoCd()));
            parameters.add("plan_units["+i+"]", getValue("Double", row.getPlanUnits()));
                        addParameterValuesFromArray(parameters, row.getAssignPlanUnitInstances(), "assign_plan_unit_instances["+i+"]");
                        addParameterValuesFromArray(parameters, row.getUpdatePlanUnitInstances(), "update_plan_unit_instances["+i+"]");
                        addParameterValuesFromArray(parameters, row.getRemovePlanUnitInstances(), "remove_plan_unit_instances["+i+"]");
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstFieldDetails(), "plan_unit_inst_field_details["+i+"]");
            parameters.add("alt_rate_schedule_no["+i+"]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add("client_alt_rate_schedule_id["+i+"]", getValue("String", row.getClientAltRateScheduleId()));
            parameters.add("proration_invoice_timing["+i+"]", getValue("Long", row.getProrationInvoiceTiming()));
                        addParameterValuesFromArray(parameters, row.getCustomRates(), "custom_rates["+i+"]");
                        addParameterValuesFromArray(parameters, row.getCouponCodeUpdates(), "coupon_code_updates["+i+"]");
                        addParameterValuesFromArray(parameters, row.getSurchargeUpdates(), "surcharge_updates["+i+"]");
            parameters.add("balance_forward["+i+"]", getValue("Double", row.getBalanceForward()));
            parameters.add("parent_plan_instance_no["+i+"]", getValue("Long", row.getParentPlanInstanceNo()));
            parameters.add("parent_client_plan_instance_id["+i+"]", getValue("String", row.getParentClientPlanInstanceId()));
            parameters.add("parent_plan_instance_idx["+i+"]", getValue("Long", row.getParentPlanInstanceIdx()));
            parameters.add("plan_status_cd["+i+"]", getValue("Long", row.getPlanStatusCd()));
            parameters.add("status_until_alt_start_cd["+i+"]", getValue("Long", row.getStatusUntilAltStartCd()));
            parameters.add("dunning_state["+i+"]", getValue("Long", row.getDunningState()));
            parameters.add("degrade_date["+i+"]", getValue("String", row.getDegradeDate()));
            parameters.add("billing_group_no["+i+"]", getValue("Long", row.getBillingGroupNo()));
            parameters.add("client_billing_group_id["+i+"]", getValue("String", row.getClientBillingGroupId()));
            parameters.add("billing_group_idx["+i+"]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add("resp_level_cd["+i+"]", getValue("Long", row.getRespLevelCd()));
            parameters.add("parent_acct_mp_inst_no["+i+"]", getValue("Long", row.getParentAcctMpInstNo()));
            parameters.add("parent_acct_client_mp_inst_id["+i+"]", getValue("String", row.getParentAcctClientMpInstId()));
            parameters.add("dunning_group_no["+i+"]", getValue("Long", row.getDunningGroupNo()));
            parameters.add("client_dunning_group_id["+i+"]", getValue("String", row.getClientDunningGroupId()));
            parameters.add("dunning_group_idx["+i+"]", getValue("Long", row.getDunningGroupIdx()));
                        addParameterValuesFromArray(parameters, row.getPlanInstanceFieldUpdate(), "plan_instance_field_update["+i+"]");
            parameters.add("effective_date["+i+"]", getValue("String", row.getEffectiveDate()));
            parameters.add("offset_months["+i+"]", getValue("Long", row.getOffsetMonths()));
            parameters.add("alt_proration_start_date["+i+"]", getValue("String", row.getAltProrationStartDate()));
            parameters.add("auto_offset_months_option["+i+"]", getValue("Long", row.getAutoOffsetMonthsOption()));
            parameters.add("alt_collect_group_no["+i+"]", getValue("String", row.getAltCollectGroupNo()));
            parameters.add("alt_client_collect_group_id["+i+"]", getValue("String", row.getAltClientCollectGroupId()));
            parameters.add("offset_interval["+i+"]", getValue("Long", row.getOffsetInterval()));
            parameters.add("invoice_unbilled_usage["+i+"]", getValue("String", row.getInvoiceUnbilledUsage()));
            parameters.add("force_supp_bill_date_reset["+i+"]", getValue("Long", row.getForceSuppBillDateReset()));
            parameters.add("force_master_bill_date_reset["+i+"]", getValue("Long", row.getForceMasterBillDateReset()));
            parameters.add("usage_accumulation_reset_months["+i+"]", getValue("String", row.getUsageAccumulationResetMonths()));
            parameters.add("usage_pooling["+i+"]", getValue("String", row.getUsagePooling()));
            parameters.add("usage_threshold_applicability["+i+"]", getValue("String", row.getUsageThresholdApplicability()));
            parameters.add("nso_bill_immediately["+i+"]", getValue("String", row.getNsoBillImmediately()));
                        addParameterValuesFromArray(parameters, row.getNsoItemArray(), "nso_item_array["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUpdatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUpdatesRow row : arrayList.getPlanUpdatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_directive]", getValue("Long", row.getPlanDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[existing_plan_instance_no]", getValue("Long", row.getExistingPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[existing_client_plan_instance_id]", getValue("String", row.getExistingClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_client_plan_instance_id]", getValue("String", row.getNewClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_idx]", getValue("Long", row.getPlanInstanceIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_description]", getValue("String", row.getPlanInstanceDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_plan_no]", getValue("Long", row.getNewPlanNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_client_plan_id]", getValue("String", row.getNewClientPlanId()));
            parameters.add(paramPrefix + "["+i+"]" + "[promo_cd]", getValue("String", row.getPromoCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_units]", getValue("Double", row.getPlanUnits()));
            addParameterValuesFromArray(parameters, row.getAssignPlanUnitInstances(), paramPrefix + "["+i+"]" + "[assign_plan_unit_instances]");
            addParameterValuesFromArray(parameters, row.getUpdatePlanUnitInstances(), paramPrefix + "["+i+"]" + "[update_plan_unit_instances]");
            addParameterValuesFromArray(parameters, row.getRemovePlanUnitInstances(), paramPrefix + "["+i+"]" + "[remove_plan_unit_instances]");
            addParameterValuesFromArray(parameters, row.getPlanUnitInstFieldDetails(), paramPrefix + "["+i+"]" + "[plan_unit_inst_field_details]");
            parameters.add(paramPrefix + "["+i+"]" + "[alt_rate_schedule_no]", getValue("Long", row.getAltRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_alt_rate_schedule_id]", getValue("String", row.getClientAltRateScheduleId()));
            parameters.add(paramPrefix + "["+i+"]" + "[proration_invoice_timing]", getValue("Long", row.getProrationInvoiceTiming()));
            addParameterValuesFromArray(parameters, row.getCustomRates(), paramPrefix + "["+i+"]" + "[custom_rates]");
            addParameterValuesFromArray(parameters, row.getCouponCodeUpdates(), paramPrefix + "["+i+"]" + "[coupon_code_updates]");
            addParameterValuesFromArray(parameters, row.getSurchargeUpdates(), paramPrefix + "["+i+"]" + "[surcharge_updates]");
            parameters.add(paramPrefix + "["+i+"]" + "[balance_forward]", getValue("Double", row.getBalanceForward()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_plan_instance_no]", getValue("Long", row.getParentPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_client_plan_instance_id]", getValue("String", row.getParentClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_plan_instance_idx]", getValue("Long", row.getParentPlanInstanceIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_status_cd]", getValue("Long", row.getPlanStatusCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[status_until_alt_start_cd]", getValue("Long", row.getStatusUntilAltStartCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_state]", getValue("Long", row.getDunningState()));
            parameters.add(paramPrefix + "["+i+"]" + "[degrade_date]", getValue("String", row.getDegradeDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_no]", getValue("Long", row.getBillingGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_billing_group_id]", getValue("String", row.getClientBillingGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_idx]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[resp_level_cd]", getValue("Long", row.getRespLevelCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_acct_mp_inst_no]", getValue("Long", row.getParentAcctMpInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_acct_client_mp_inst_id]", getValue("String", row.getParentAcctClientMpInstId()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_no]", getValue("Long", row.getDunningGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_dunning_group_id]", getValue("String", row.getClientDunningGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_idx]", getValue("Long", row.getDunningGroupIdx()));
            addParameterValuesFromArray(parameters, row.getPlanInstanceFieldUpdate(), paramPrefix + "["+i+"]" + "[plan_instance_field_update]");
            parameters.add(paramPrefix + "["+i+"]" + "[effective_date]", getValue("String", row.getEffectiveDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[offset_months]", getValue("Long", row.getOffsetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_proration_start_date]", getValue("String", row.getAltProrationStartDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[auto_offset_months_option]", getValue("Long", row.getAutoOffsetMonthsOption()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_collect_group_no]", getValue("String", row.getAltCollectGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[alt_client_collect_group_id]", getValue("String", row.getAltClientCollectGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[offset_interval]", getValue("Long", row.getOffsetInterval()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_unbilled_usage]", getValue("String", row.getInvoiceUnbilledUsage()));
            parameters.add(paramPrefix + "["+i+"]" + "[force_supp_bill_date_reset]", getValue("Long", row.getForceSuppBillDateReset()));
            parameters.add(paramPrefix + "["+i+"]" + "[force_master_bill_date_reset]", getValue("Long", row.getForceMasterBillDateReset()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_accumulation_reset_months]", getValue("String", row.getUsageAccumulationResetMonths()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_pooling]", getValue("String", row.getUsagePooling()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_threshold_applicability]", getValue("String", row.getUsageThresholdApplicability()));
            parameters.add(paramPrefix + "["+i+"]" + "[nso_bill_immediately]", getValue("String", row.getNsoBillImmediately()));
            addParameterValuesFromArray(parameters, row.getNsoItemArray(), paramPrefix + "["+i+"]" + "[nso_item_array]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AssignPlanUnitInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AssignPlanUnitInstancesRow row : arrayList.getAssignPlanUnitInstancesRow()){
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add("plan_unit_inst_idx["+i+"]", getValue("Long", row.getPlanUnitInstIdx()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstanceServices(), "plan_unit_instance_services["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AssignPlanUnitInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AssignPlanUnitInstancesRow row : arrayList.getAssignPlanUnitInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_idx]", getValue("Long", row.getPlanUnitInstIdx()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstanceServices(), paramPrefix + "["+i+"]" + "[plan_unit_instance_services]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdatePlanUnitInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdatePlanUnitInstancesRow row : arrayList.getUpdatePlanUnitInstancesRow()){
            parameters.add("plan_unit_inst_no["+i+"]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add("new_client_plan_unit_inst_id["+i+"]", getValue("String", row.getNewClientPlanUnitInstId()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstanceServices(), "plan_unit_instance_services["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UpdatePlanUnitInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UpdatePlanUnitInstancesRow row : arrayList.getUpdatePlanUnitInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_no]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_client_plan_unit_inst_id]", getValue("String", row.getNewClientPlanUnitInstId()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstanceServices(), paramPrefix + "["+i+"]" + "[plan_unit_instance_services]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.RemovePlanUnitInstancesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.RemovePlanUnitInstancesRow row : arrayList.getRemovePlanUnitInstancesRow()){
            parameters.add("plan_unit_inst_no["+i+"]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.RemovePlanUnitInstancesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.RemovePlanUnitInstancesRow row : arrayList.getRemovePlanUnitInstancesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_no]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldDetailsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldDetailsRow row : arrayList.getPlanUnitInstFieldDetailsRow()){
            parameters.add("plan_unit_inst_no["+i+"]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add("client_plan_unit_inst_id["+i+"]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add("plan_unit_inst_idx["+i+"]", getValue("Long", row.getPlanUnitInstIdx()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstFieldList(), "plan_unit_inst_field_list["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldDetailsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldDetailsRow row : arrayList.getPlanUnitInstFieldDetailsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_no]", getValue("Long", row.getPlanUnitInstNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_unit_inst_id]", getValue("String", row.getClientPlanUnitInstId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_idx]", getValue("Long", row.getPlanUnitInstIdx()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstFieldList(), paramPrefix + "["+i+"]" + "[plan_unit_inst_field_list]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldListArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldListRow row : arrayList.getPlanUnitInstFieldListRow()){
            parameters.add("field_name["+i+"]", getValue("String", row.getFieldName()));
                        addParameterValuesFromArray(parameters, row.getPlanUnitInstFieldValues(), "plan_unit_inst_field_values["+i+"]");
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldListArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldListRow row : arrayList.getPlanUnitInstFieldListRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[field_name]", getValue("String", row.getFieldName()));
            addParameterValuesFromArray(parameters, row.getPlanUnitInstFieldValues(), paramPrefix + "["+i+"]" + "[plan_unit_inst_field_values]");
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldValuesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldValuesRow row : arrayList.getPlanUnitInstFieldValuesRow()){
            parameters.add("field_value["+i+"]", getValue("String", row.getFieldValue()));
            parameters.add("plan_unit_inst_field_val_directive["+i+"]", getValue("Long", row.getPlanUnitInstFieldValDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PlanUnitInstFieldValuesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PlanUnitInstFieldValuesRow row : arrayList.getPlanUnitInstFieldValuesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[field_value]", getValue("String", row.getFieldValue()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_unit_inst_field_val_directive]", getValue("Long", row.getPlanUnitInstFieldValDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CouponCodeUpdatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CouponCodeUpdatesRow row : arrayList.getCouponCodeUpdatesRow()){
            parameters.add("coupon_cd["+i+"]", getValue("String", row.getCouponCd()));
            parameters.add("coupon_directive["+i+"]", getValue("Long", row.getCouponDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CouponCodeUpdatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CouponCodeUpdatesRow row : arrayList.getCouponCodeUpdatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[coupon_cd]", getValue("String", row.getCouponCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[coupon_directive]", getValue("Long", row.getCouponDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SurchargeUpdatesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SurchargeUpdatesRow row : arrayList.getSurchargeUpdatesRow()){
            parameters.add("surcharge_no["+i+"]", getValue("Long", row.getSurchargeNo()));
            parameters.add("client_surcharge_id["+i+"]", getValue("String", row.getClientSurchargeId()));
            parameters.add("rate_schedule_no["+i+"]", getValue("Long", row.getRateScheduleNo()));
            parameters.add("surcharge_directive["+i+"]", getValue("Long", row.getSurchargeDirective()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SurchargeUpdatesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SurchargeUpdatesRow row : arrayList.getSurchargeUpdatesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_no]", getValue("Long", row.getSurchargeNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_surcharge_id]", getValue("String", row.getClientSurchargeId()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate_schedule_no]", getValue("Long", row.getRateScheduleNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[surcharge_directive]", getValue("Long", row.getSurchargeDirective()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NsoItemArrayArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NsoItemArrayRow row : arrayList.getNsoItemArrayRow()){
            parameters.add("item_no["+i+"]", getValue("String", row.getItemNo()));
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("item_units["+i+"]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.NsoItemArrayArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.NsoItemArrayRow row : arrayList.getNsoItemArrayRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[item_no]", getValue("String", row.getItemNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[item_units]", getValue("Long", row.getItemUnits()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctBillingGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctBillingGroupsRow row : arrayList.getAcctBillingGroupsRow()){
            parameters.add("billing_group_directive["+i+"]", getValue("Long", row.getBillingGroupDirective()));
            parameters.add("existing_billing_group_no["+i+"]", getValue("Long", row.getExistingBillingGroupNo()));
            parameters.add("existing_client_billing_group_id["+i+"]", getValue("String", row.getExistingClientBillingGroupId()));
            parameters.add("billing_group_name["+i+"]", getValue("String", row.getBillingGroupName()));
            parameters.add("billing_group_description["+i+"]", getValue("String", row.getBillingGroupDescription()));
            parameters.add("new_client_billing_group_id["+i+"]", getValue("String", row.getNewClientBillingGroupId()));
            parameters.add("billing_group_idx["+i+"]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add("notify_method["+i+"]", getValue("Long", row.getNotifyMethod()));
            parameters.add("notify_template_group["+i+"]", getValue("Long", row.getNotifyTemplateGroup()));
            parameters.add("statement_template["+i+"]", getValue("Long", row.getStatementTemplate()));
            parameters.add("credit_note_template["+i+"]", getValue("Long", row.getCreditNoteTemplate()));
            parameters.add("primary_payment_method_no["+i+"]", getValue("Long", row.getPrimaryPaymentMethodNo()));
            parameters.add("primary_client_payment_method_id["+i+"]", getValue("String", row.getPrimaryClientPaymentMethodId()));
            parameters.add("primary_payment_method_idx["+i+"]", getValue("Long", row.getPrimaryPaymentMethodIdx()));
            parameters.add("backup_payment_method_no["+i+"]", getValue("Long", row.getBackupPaymentMethodNo()));
            parameters.add("backup_client_payment_method_id["+i+"]", getValue("Long", row.getBackupClientPaymentMethodId()));
            parameters.add("backup_payment_method_idx["+i+"]", getValue("Long", row.getBackupPaymentMethodIdx()));
            parameters.add("stmt_first_name["+i+"]", getValue("String", row.getStmtFirstName()));
            parameters.add("stmt_mi["+i+"]", getValue("String", row.getStmtMi()));
            parameters.add("stmt_last_name["+i+"]", getValue("String", row.getStmtLastName()));
            parameters.add("stmt_company_name["+i+"]", getValue("String", row.getStmtCompanyName()));
            parameters.add("stmt_address1["+i+"]", getValue("String", row.getStmtAddress1()));
            parameters.add("stmt_address2["+i+"]", getValue("String", row.getStmtAddress2()));
            parameters.add("stmt_address3["+i+"]", getValue("String", row.getStmtAddress3()));
            parameters.add("stmt_city["+i+"]", getValue("String", row.getStmtCity()));
            parameters.add("stmt_locality["+i+"]", getValue("String", row.getStmtLocality()));
            parameters.add("stmt_state_prov["+i+"]", getValue("String", row.getStmtStateProv()));
            parameters.add("stmt_country["+i+"]", getValue("String", row.getStmtCountry()));
            parameters.add("stmt_postal_cd["+i+"]", getValue("String", row.getStmtPostalCd()));
            parameters.add("stmt_phone["+i+"]", getValue("String", row.getStmtPhone()));
            parameters.add("stmt_phone_ext["+i+"]", getValue("String", row.getStmtPhoneExt()));
            parameters.add("stmt_cell_phone["+i+"]", getValue("String", row.getStmtCellPhone()));
            parameters.add("stmt_work_phone["+i+"]", getValue("String", row.getStmtWorkPhone()));
            parameters.add("stmt_work_phone_ext["+i+"]", getValue("String", row.getStmtWorkPhoneExt()));
            parameters.add("stmt_fax["+i+"]", getValue("String", row.getStmtFax()));
            parameters.add("stmt_email["+i+"]", getValue("String", row.getStmtEmail()));
            parameters.add("stmt_birthdate["+i+"]", getValue("String", row.getStmtBirthdate()));
            parameters.add("bg_list_start_master_file["+i+"]", getValue("Long", row.getBgListStartMasterFile()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctBillingGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctBillingGroupsRow row : arrayList.getAcctBillingGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_directive]", getValue("Long", row.getBillingGroupDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[existing_billing_group_no]", getValue("Long", row.getExistingBillingGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[existing_client_billing_group_id]", getValue("String", row.getExistingClientBillingGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_name]", getValue("String", row.getBillingGroupName()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_description]", getValue("String", row.getBillingGroupDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_client_billing_group_id]", getValue("String", row.getNewClientBillingGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[billing_group_idx]", getValue("Long", row.getBillingGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[notify_method]", getValue("Long", row.getNotifyMethod()));
            parameters.add(paramPrefix + "["+i+"]" + "[notify_template_group]", getValue("Long", row.getNotifyTemplateGroup()));
            parameters.add(paramPrefix + "["+i+"]" + "[statement_template]", getValue("Long", row.getStatementTemplate()));
            parameters.add(paramPrefix + "["+i+"]" + "[credit_note_template]", getValue("Long", row.getCreditNoteTemplate()));
            parameters.add(paramPrefix + "["+i+"]" + "[primary_payment_method_no]", getValue("Long", row.getPrimaryPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[primary_client_payment_method_id]", getValue("String", row.getPrimaryClientPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[primary_payment_method_idx]", getValue("Long", row.getPrimaryPaymentMethodIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[backup_payment_method_no]", getValue("Long", row.getBackupPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[backup_client_payment_method_id]", getValue("Long", row.getBackupClientPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[backup_payment_method_idx]", getValue("Long", row.getBackupPaymentMethodIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_first_name]", getValue("String", row.getStmtFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_mi]", getValue("String", row.getStmtMi()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_last_name]", getValue("String", row.getStmtLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_company_name]", getValue("String", row.getStmtCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_address1]", getValue("String", row.getStmtAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_address2]", getValue("String", row.getStmtAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_address3]", getValue("String", row.getStmtAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_city]", getValue("String", row.getStmtCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_locality]", getValue("String", row.getStmtLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_state_prov]", getValue("String", row.getStmtStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_country]", getValue("String", row.getStmtCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_postal_cd]", getValue("String", row.getStmtPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_phone]", getValue("String", row.getStmtPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_phone_ext]", getValue("String", row.getStmtPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_cell_phone]", getValue("String", row.getStmtCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_work_phone]", getValue("String", row.getStmtWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_work_phone_ext]", getValue("String", row.getStmtWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_fax]", getValue("String", row.getStmtFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_email]", getValue("String", row.getStmtEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[stmt_birthdate]", getValue("String", row.getStmtBirthdate()));
            parameters.add(paramPrefix + "["+i+"]" + "[bg_list_start_master_file]", getValue("Long", row.getBgListStartMasterFile()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctPaymentMethodsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctPaymentMethodsRow row : arrayList.getAcctPaymentMethodsRow()){
            parameters.add("payment_method_name["+i+"]", getValue("String", row.getPaymentMethodName()));
            parameters.add("client_payment_method_id["+i+"]", getValue("String", row.getClientPaymentMethodId()));
            parameters.add("payment_method_description["+i+"]", getValue("String", row.getPaymentMethodDescription()));
            parameters.add("payment_method_idx["+i+"]", getValue("Long", row.getPaymentMethodIdx()));
            parameters.add("payment_method_type["+i+"]", getValue("Long", row.getPaymentMethodType()));
            parameters.add("cc_num["+i+"]", getValue("String", row.getCcNum()));
            parameters.add("cc_expire_mm["+i+"]", getValue("Long", row.getCcExpireMm()));
            parameters.add("cc_expire_yyyy["+i+"]", getValue("Long", row.getCcExpireYyyy()));
            parameters.add("bank_acct_num["+i+"]", getValue("String", row.getBankAcctNum()));
            parameters.add("bank_routing_num["+i+"]", getValue("String", row.getBankRoutingNum()));
            parameters.add("cvv["+i+"]", getValue("String", row.getCvv()));
            parameters.add("track_data1["+i+"]", getValue("String", row.getTrackData1()));
            parameters.add("track_data2["+i+"]", getValue("String", row.getTrackData2()));
            parameters.add("bill_agreement_id["+i+"]", getValue("String", row.getBillAgreementId()));
            parameters.add("iban["+i+"]", getValue("String", row.getIban()));
            parameters.add("bank_check_digit["+i+"]", getValue("Long", row.getBankCheckDigit()));
            parameters.add("bank_swift_cd["+i+"]", getValue("String", row.getBankSwiftCd()));
            parameters.add("bank_country_cd["+i+"]", getValue("String", row.getBankCountryCd()));
            parameters.add("mandate_id["+i+"]", getValue("String", row.getMandateId()));
            parameters.add("bank_id_cd["+i+"]", getValue("String", row.getBankIdCd()));
            parameters.add("bank_branch_cd["+i+"]", getValue("String", row.getBankBranchCd()));
            parameters.add("bill_first_name["+i+"]", getValue("String", row.getBillFirstName()));
            parameters.add("bill_mi["+i+"]", getValue("String", row.getBillMi()));
            parameters.add("bill_last_name["+i+"]", getValue("String", row.getBillLastName()));
            parameters.add("bill_company_name["+i+"]", getValue("String", row.getBillCompanyName()));
            parameters.add("bill_address1["+i+"]", getValue("String", row.getBillAddress1()));
            parameters.add("bill_address2["+i+"]", getValue("String", row.getBillAddress2()));
            parameters.add("bill_address3["+i+"]", getValue("String", row.getBillAddress3()));
            parameters.add("bill_city["+i+"]", getValue("String", row.getBillCity()));
            parameters.add("bill_locality["+i+"]", getValue("String", row.getBillLocality()));
            parameters.add("bill_state_prov["+i+"]", getValue("String", row.getBillStateProv()));
            parameters.add("bill_country["+i+"]", getValue("String", row.getBillCountry()));
            parameters.add("bill_postal_cd["+i+"]", getValue("String", row.getBillPostalCd()));
            parameters.add("bill_phone["+i+"]", getValue("String", row.getBillPhone()));
            parameters.add("bill_phone_ext["+i+"]", getValue("String", row.getBillPhoneExt()));
            parameters.add("bill_cell_phone["+i+"]", getValue("String", row.getBillCellPhone()));
            parameters.add("bill_work_phone["+i+"]", getValue("String", row.getBillWorkPhone()));
            parameters.add("bill_work_phone_ext["+i+"]", getValue("String", row.getBillWorkPhoneExt()));
            parameters.add("bill_fax["+i+"]", getValue("String", row.getBillFax()));
            parameters.add("bill_email["+i+"]", getValue("String", row.getBillEmail()));
            parameters.add("bill_birthdate["+i+"]", getValue("String", row.getBillBirthdate()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctPaymentMethodsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctPaymentMethodsRow row : arrayList.getAcctPaymentMethodsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_name]", getValue("String", row.getPaymentMethodName()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_payment_method_id]", getValue("String", row.getClientPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_description]", getValue("String", row.getPaymentMethodDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_idx]", getValue("Long", row.getPaymentMethodIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_type]", getValue("Long", row.getPaymentMethodType()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_num]", getValue("String", row.getCcNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_expire_mm]", getValue("Long", row.getCcExpireMm()));
            parameters.add(paramPrefix + "["+i+"]" + "[cc_expire_yyyy]", getValue("Long", row.getCcExpireYyyy()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_acct_num]", getValue("String", row.getBankAcctNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_routing_num]", getValue("String", row.getBankRoutingNum()));
            parameters.add(paramPrefix + "["+i+"]" + "[cvv]", getValue("String", row.getCvv()));
            parameters.add(paramPrefix + "["+i+"]" + "[track_data1]", getValue("String", row.getTrackData1()));
            parameters.add(paramPrefix + "["+i+"]" + "[track_data2]", getValue("String", row.getTrackData2()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_agreement_id]", getValue("String", row.getBillAgreementId()));
            parameters.add(paramPrefix + "["+i+"]" + "[iban]", getValue("String", row.getIban()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_check_digit]", getValue("Long", row.getBankCheckDigit()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_swift_cd]", getValue("String", row.getBankSwiftCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_country_cd]", getValue("String", row.getBankCountryCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[mandate_id]", getValue("String", row.getMandateId()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_id_cd]", getValue("String", row.getBankIdCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bank_branch_cd]", getValue("String", row.getBankBranchCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_first_name]", getValue("String", row.getBillFirstName()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_mi]", getValue("String", row.getBillMi()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_last_name]", getValue("String", row.getBillLastName()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_company_name]", getValue("String", row.getBillCompanyName()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_address1]", getValue("String", row.getBillAddress1()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_address2]", getValue("String", row.getBillAddress2()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_address3]", getValue("String", row.getBillAddress3()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_city]", getValue("String", row.getBillCity()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_locality]", getValue("String", row.getBillLocality()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_state_prov]", getValue("String", row.getBillStateProv()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_country]", getValue("String", row.getBillCountry()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_postal_cd]", getValue("String", row.getBillPostalCd()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_phone]", getValue("String", row.getBillPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_phone_ext]", getValue("String", row.getBillPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_cell_phone]", getValue("String", row.getBillCellPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_work_phone]", getValue("String", row.getBillWorkPhone()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_work_phone_ext]", getValue("String", row.getBillWorkPhoneExt()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_fax]", getValue("String", row.getBillFax()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_email]", getValue("String", row.getBillEmail()));
            parameters.add(paramPrefix + "["+i+"]" + "[bill_birthdate]", getValue("String", row.getBillBirthdate()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctDunningGroupsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctDunningGroupsRow row : arrayList.getAcctDunningGroupsRow()){
            parameters.add("dunning_group_directive["+i+"]", getValue("Long", row.getDunningGroupDirective()));
            parameters.add("existing_dunning_group_no["+i+"]", getValue("Long", row.getExistingDunningGroupNo()));
            parameters.add("existing_client_dunning_group_id["+i+"]", getValue("String", row.getExistingClientDunningGroupId()));
            parameters.add("dunning_group_name["+i+"]", getValue("String", row.getDunningGroupName()));
            parameters.add("dunning_group_description["+i+"]", getValue("String", row.getDunningGroupDescription()));
            parameters.add("new_client_dunning_group_id["+i+"]", getValue("String", row.getNewClientDunningGroupId()));
            parameters.add("dunning_group_idx["+i+"]", getValue("Long", row.getDunningGroupIdx()));
            parameters.add("dunning_process_no["+i+"]", getValue("Long", row.getDunningProcessNo()));
            parameters.add("client_dunning_process_id["+i+"]", getValue("String", row.getClientDunningProcessId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.AcctDunningGroupsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.AcctDunningGroupsRow row : arrayList.getAcctDunningGroupsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_directive]", getValue("Long", row.getDunningGroupDirective()));
            parameters.add(paramPrefix + "["+i+"]" + "[existing_dunning_group_no]", getValue("Long", row.getExistingDunningGroupNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[existing_client_dunning_group_id]", getValue("String", row.getExistingClientDunningGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_name]", getValue("String", row.getDunningGroupName()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_description]", getValue("String", row.getDunningGroupDescription()));
            parameters.add(paramPrefix + "["+i+"]" + "[new_client_dunning_group_id]", getValue("String", row.getNewClientDunningGroupId()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_group_idx]", getValue("Long", row.getDunningGroupIdx()));
            parameters.add(paramPrefix + "["+i+"]" + "[dunning_process_no]", getValue("Long", row.getDunningProcessNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_dunning_process_id]", getValue("String", row.getClientDunningProcessId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SpecificInvoicesArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SpecificInvoicesRow row : arrayList.getSpecificInvoicesRow()){
            parameters.add("invoice_no["+i+"]", getValue("Long", row.getInvoiceNo()));
            parameters.add("invoice_credit_amount["+i+"]", getValue("Double", row.getInvoiceCreditAmount()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SpecificInvoicesArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SpecificInvoicesRow row : arrayList.getSpecificInvoicesRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_no]", getValue("Long", row.getInvoiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_credit_amount]", getValue("Double", row.getInvoiceCreditAmount()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SpecificTransactionsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SpecificTransactionsRow row : arrayList.getSpecificTransactionsRow()){
            parameters.add("transaction_id["+i+"]", getValue("Long", row.getTransactionId()));
            parameters.add("trans_credit_amount["+i+"]", getValue("Double", row.getTransCreditAmount()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.SpecificTransactionsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.SpecificTransactionsRow row : arrayList.getSpecificTransactionsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[transaction_id]", getValue("Long", row.getTransactionId()));
            parameters.add(paramPrefix + "["+i+"]" + "[trans_credit_amount]", getValue("Double", row.getTransCreditAmount()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageRecsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageRecsRow row : arrayList.getUsageRecsRow()){
            parameters.add("acct_no["+i+"]", getValue("Long", row.getAcctNo()));
            parameters.add("userid["+i+"]", getValue("String", row.getUserid()));
            parameters.add("master_plan_instance_no["+i+"]", getValue("Long", row.getMasterPlanInstanceNo()));
            parameters.add("client_master_plan_instance_id["+i+"]", getValue("String", row.getClientMasterPlanInstanceId()));
            parameters.add("plan_instance_no["+i+"]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add("client_plan_instance_id["+i+"]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add("usage_type["+i+"]", getValue("Long", row.getUsageType()));
            parameters.add("usage_units["+i+"]", getValue("Double", row.getUsageUnits()));
            parameters.add("usage_date["+i+"]", getValue("String", row.getUsageDate()));
            parameters.add("billable_units["+i+"]", getValue("Double", row.getBillableUnits()));
            parameters.add("amt["+i+"]", getValue("Double", row.getAmt()));
            parameters.add("rate["+i+"]", getValue("Double", row.getRate()));
            parameters.add("telco_from["+i+"]", getValue("String", row.getTelcoFrom()));
            parameters.add("telco_to["+i+"]", getValue("String", row.getTelcoTo()));
            parameters.add("comments["+i+"]", getValue("String", row.getComments()));
            parameters.add("exclude_from_billing["+i+"]", getValue("String", row.getExcludeFromBilling()));
            parameters.add("exclusion_comments["+i+"]", getValue("String", row.getExclusionComments()));
            parameters.add("parent_usage_rec_no["+i+"]", getValue("Long", row.getParentUsageRecNo()));
            parameters.add("qualifier_1["+i+"]", getValue("String", row.getQualifier1()));
            parameters.add("qualifier_2["+i+"]", getValue("String", row.getQualifier2()));
            parameters.add("qualifier_3["+i+"]", getValue("String", row.getQualifier3()));
            parameters.add("qualifier_4["+i+"]", getValue("String", row.getQualifier4()));
            parameters.add("usage_type_code["+i+"]", getValue("String", row.getUsageTypeCode()));
            parameters.add("client_record_id["+i+"]", getValue("String", row.getClientRecordId()));
            parameters.add("caller_id["+i+"]", getValue("String", row.getCallerId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.UsageRecsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.UsageRecsRow row : arrayList.getUsageRecsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[acct_no]", getValue("Long", row.getAcctNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[userid]", getValue("String", row.getUserid()));
            parameters.add(paramPrefix + "["+i+"]" + "[master_plan_instance_no]", getValue("Long", row.getMasterPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_master_plan_instance_id]", getValue("String", row.getClientMasterPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[plan_instance_no]", getValue("Long", row.getPlanInstanceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_plan_instance_id]", getValue("String", row.getClientPlanInstanceId()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_type]", getValue("Long", row.getUsageType()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_units]", getValue("Double", row.getUsageUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_date]", getValue("String", row.getUsageDate()));
            parameters.add(paramPrefix + "["+i+"]" + "[billable_units]", getValue("Double", row.getBillableUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[amt]", getValue("Double", row.getAmt()));
            parameters.add(paramPrefix + "["+i+"]" + "[rate]", getValue("Double", row.getRate()));
            parameters.add(paramPrefix + "["+i+"]" + "[telco_from]", getValue("String", row.getTelcoFrom()));
            parameters.add(paramPrefix + "["+i+"]" + "[telco_to]", getValue("String", row.getTelcoTo()));
            parameters.add(paramPrefix + "["+i+"]" + "[comments]", getValue("String", row.getComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[exclude_from_billing]", getValue("String", row.getExcludeFromBilling()));
            parameters.add(paramPrefix + "["+i+"]" + "[exclusion_comments]", getValue("String", row.getExclusionComments()));
            parameters.add(paramPrefix + "["+i+"]" + "[parent_usage_rec_no]", getValue("Long", row.getParentUsageRecNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_1]", getValue("String", row.getQualifier1()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_2]", getValue("String", row.getQualifier2()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_3]", getValue("String", row.getQualifier3()));
            parameters.add(paramPrefix + "["+i+"]" + "[qualifier_4]", getValue("String", row.getQualifier4()));
            parameters.add(paramPrefix + "["+i+"]" + "[usage_type_code]", getValue("String", row.getUsageTypeCode()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_record_id]", getValue("String", row.getClientRecordId()));
            parameters.add(paramPrefix + "["+i+"]" + "[caller_id]", getValue("String", row.getCallerId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PaymentMethodsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PaymentMethodsRow row : arrayList.getPaymentMethodsRow()){
            parameters.add("payment_method_no["+i+"]", getValue("Long", row.getPaymentMethodNo()));
            parameters.add("client_payment_method_id["+i+"]", getValue("String", row.getClientPaymentMethodId()));
            parameters.add("client_new_tgt_pmt_method_id["+i+"]", getValue("String", row.getClientNewTgtPmtMethodId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.PaymentMethodsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.PaymentMethodsRow row : arrayList.getPaymentMethodsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_no]", getValue("Long", row.getPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_payment_method_id]", getValue("String", row.getClientPaymentMethodId()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_new_tgt_pmt_method_id]", getValue("String", row.getClientNewTgtPmtMethodId()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.OrderLineItemsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.OrderLineItemsRow row : arrayList.getOrderLineItemsRow()){
            parameters.add("client_sku["+i+"]", getValue("String", row.getClientSku()));
            parameters.add("units["+i+"]", getValue("Double", row.getUnits()));
            parameters.add("amount["+i+"]", getValue("Double", row.getAmount()));
            parameters.add("unit_discount_amount["+i+"]", getValue("Double", row.getUnitDiscountAmount()));
            parameters.add("line_comments["+i+"]", getValue("String", row.getLineComments()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.OrderLineItemsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.OrderLineItemsRow row : arrayList.getOrderLineItemsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[client_sku]", getValue("String", row.getClientSku()));
            parameters.add(paramPrefix + "["+i+"]" + "[units]", getValue("Double", row.getUnits()));
            parameters.add(paramPrefix + "["+i+"]" + "[amount]", getValue("Double", row.getAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[unit_discount_amount]", getValue("Double", row.getUnitDiscountAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[line_comments]", getValue("String", row.getLineComments()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InvoiceTransToReverseArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InvoiceTransToReverseRow row : arrayList.getInvoiceTransToReverseRow()){
            parameters.add("invoice_no["+i+"]", getValue("Long", row.getInvoiceNo()));
            parameters.add("invoice_line_no["+i+"]", getValue("Long", row.getInvoiceLineNo()));
            parameters.add("invoice_transaction_id["+i+"]", getValue("Long", row.getInvoiceTransactionId()));
            parameters.add("invoice_line_reversing_amount["+i+"]", getValue("Double", row.getInvoiceLineReversingAmount()));
            parameters.add("invoice_line_reversing_date["+i+"]", getValue("String", row.getInvoiceLineReversingDate()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.InvoiceTransToReverseArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.InvoiceTransToReverseRow row : arrayList.getInvoiceTransToReverseRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_no]", getValue("Long", row.getInvoiceNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_line_no]", getValue("Long", row.getInvoiceLineNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_transaction_id]", getValue("Long", row.getInvoiceTransactionId()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_line_reversing_amount]", getValue("Double", row.getInvoiceLineReversingAmount()));
            parameters.add(paramPrefix + "["+i+"]" + "[invoice_line_reversing_date]", getValue("String", row.getInvoiceLineReversingDate()));
            i++;
        }
    }

    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CreditCardPaymentMethodsArray arrayList) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CreditCardPaymentMethodsRow row : arrayList.getCreditCardPaymentMethodsRow()){
            parameters.add("payment_method_no["+i+"]", getValue("Long", row.getPaymentMethodNo()));
            parameters.add("client_payment_method_id["+i+"]", getValue("String", row.getClientPaymentMethodId()));
            i++;
        }
    }
    public static void addParameterValuesFromArray(MultivaluedMap<String, String> parameters, com.aria.common.shared.CreditCardPaymentMethodsArray arrayList, String paramPrefix) {
        if (arrayList == null) return;
        int i = 0;
        for (com.aria.common.shared.CreditCardPaymentMethodsRow row : arrayList.getCreditCardPaymentMethodsRow()){
            parameters.add(paramPrefix + "["+i+"]" + "[payment_method_no]", getValue("Long", row.getPaymentMethodNo()));
            parameters.add(paramPrefix + "["+i+"]" + "[client_payment_method_id]", getValue("String", row.getClientPaymentMethodId()));
            i++;
        }
    }

    /* ****************** END - ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT **************************************** */

}
