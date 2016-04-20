package com.aria.sdk.unitTest.object;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.junit.Test;

import com.aria.sdk.classes.AriaBillingBuilder;
import com.aria.sdk.classes.AriaBillingIntegration;
import com.aria.sdk.classes.BaseAriaBillingDTO;
import com.aria.sdk.classes.CallType;
import com.aria.sdk.classes.LibraryType;
import com.aria.sdk.classes.OutPutFormat;

public class AriaServiceClientTest {
    /**************************** CLASS ATTRIBUTES ***********************/
    public final String ERROR_CODE = "error_code";
    public final String ERROR_MESSAGE = "error_msg";
    private static ResourceBundle resourceBundle;
    private Map<String,Object> hashMapReturnValues = new HashMap<String,Object>();
    private AriaBillingIntegration ariaBillingIntegration;
    private String dispatcher = getResourceBundle().getString("api.object.dispatcher.url");
    /**************************** END - CLASS ATTRIBUTES ***********************/

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle("ariasdk");
        }
        return resourceBundle;
    }

    /**************************** GETTERS ***********************/
    public AriaBillingIntegration getBaseAriaBilling() throws Exception {
        if (ariaBillingIntegration == null){
            /*REST CALL*/
            BaseAriaBillingDTO baseAriaBillingDTO = new BaseAriaBillingDTO(dispatcher,"logger",false/*Debug*/,CallType.REST,OutPutFormat.OUTPUT_JSON,LibraryType.OBJECT_QUERY);
            ariaBillingIntegration = AriaBillingBuilder.getAriaObjectSDK(baseAriaBillingDTO);
        }
        return ariaBillingIntegration;
    }
    public long getClientNo() {
        return Long.parseLong(getResourceBundle().getString("client.no"));
    }
    public String getAuthKey() {
        return getResourceBundle().getString("client.auth.key");
    }
    /**************************** END - GETTERS ***********************/

    @org.junit.BeforeClass
    public static void init() {
    }
    /*************************** TEST ******************************/
    @Test
    /* Please, UnComment the method call on which you wnat to do the test */
    public void fullTest() throws Exception{
        //getAccountDetails();
        //getAccountStatusHistory();
        //getAccountPlanHistory();
        //getPaymentDetails();
        //getOrderDetails();
        //getInvoiceInformation();
        //getInvoiceDetails();
        //getTransactionInformation();
        //getRefundInformation();
        //getCouponHistory();
        //listTransactionTypes();
        //listPaymentMethods();
        //listPaymentProcessors();
        //getAllInvoiceInformation();
        //getPlanInstanceInformationM();
        //getAccountDetailsM();
        //getCouponHistoryM();
        //getInvoiceInformationM();
        //getAllInvoiceInformationM();
        //getAccountPlanHistoryM();
            }

    //@Test
    public void getAccountDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAccountDetails(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAccountDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAccountStatusHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAccountStatusHistory(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAccountStatusHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAccountPlanHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAccountPlanHistory(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAccountPlanHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPaymentDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPaymentDetails(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPaymentDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getOrderDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getOrderDetails(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getOrderDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvoiceInformation() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoiceInformation(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoiceInformation - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getTransactionInformation() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getTransactionInformation(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getTransactionInformation - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRefundInformation() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRefundInformation(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRefundInformation - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCouponHistory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCouponHistory(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCouponHistory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void listTransactionTypes() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().listTransactionTypes(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "listTransactionTypes - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void listPaymentMethods() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().listPaymentMethods(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "listPaymentMethods - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void listPaymentProcessors() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().listPaymentProcessors(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "listPaymentProcessors - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllInvoiceInformation() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllInvoiceInformation(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllInvoiceInformation - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlanInstanceInformationM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlanInstanceInformationM(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlanInstanceInformationM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAccountDetailsM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAccountDetailsM(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAccountDetailsM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCouponHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCouponHistoryM(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCouponHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInvoiceInformationM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInvoiceInformationM(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInvoiceInformationM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAllInvoiceInformationM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAllInvoiceInformationM(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAllInvoiceInformationM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getAccountPlanHistoryM() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getAccountPlanHistoryM(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getAccountPlanHistoryM - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

        /*************************** END - TEST ******************************/
}
