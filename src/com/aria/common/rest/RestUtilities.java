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
            entity.setBillAgreementId(getStringValue(jsonObject,"bill_agreement_id"));
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
            entity.setRateTierDescription(getStringValue(jsonObject,"rate_tier_description"));
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

    /* ****************** END - ARRAY TO PARAM METHODS FOR EACH ARRAY ELEMENT **************************************** */

}
