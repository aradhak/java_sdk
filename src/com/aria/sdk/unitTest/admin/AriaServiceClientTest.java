package com.aria.sdk.unitTest.admin;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.junit.Test;

import com.aria.sdk.classes.AriaBillingAdministration;
import com.aria.sdk.classes.AriaBillingBuilder;
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
    private AriaBillingAdministration ariaBillingAdministration;
    private String dispatcher = getResourceBundle().getString("api.admin.dispatcher.url");
    /**************************** END - CLASS ATTRIBUTES ***********************/

    public static ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle("ariasdk");
        }
        return resourceBundle;
    }

    /**************************** GETTERS ***********************/
    public AriaBillingAdministration getBaseAriaBilling() throws Exception {
        if (ariaBillingAdministration == null){            
                        /*REST CALL*/
            BaseAriaBillingDTO baseAriaBillingDTO = new BaseAriaBillingDTO(dispatcher,"logger",false/*Debug*/,CallType.REST,OutPutFormat.OUTPUT_JSON,LibraryType.ADMINTOOLS);
            ariaBillingAdministration = AriaBillingBuilder.getAriaAdminSDK(baseAriaBillingDTO);
                        
            
        }
        return ariaBillingAdministration;
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
        //getPromoPlanSets();
        //getPromoPlanSetDetails();
        //createPromoPlanSet();
        //updatePromoPlanSet();
        //listPromoSets();
        //getCompanyProfile();
        //setCompanyProfile();
        //planExport();
        //planImport();
        //getInventoryItems();
        //getInventoryItemDetails();
        //createInventoryItem();
        //updateInventoryItem();
        //createItemClass();
        //editItemClass();
        //getServiceTypes();
        //getServices();
        //getServiceDetails();
        //getServicePlanDetails();
        //getPlanServiceDetails();
        //createService();
        //updateService();
        //updatePlanServiceDetails();
        //getSuppFields();
        //getSuppFieldDetails();
        //createSuppField();
        //updateSuppField();
        //getCoupons();
        //getCouponDetails();
        //createCoupon();
        //updateCoupon();
        //deleteCoupons();
        //getRecurringCreditTemplates();
        //getRecurringCreditTemplateDetails();
        //createCreditTemplate();
        //updateCreditTemplate();
        //deleteTemplates();
        //createDiscountRule();
        //createDiscountBundle();
        //getDiscountBundles();
        //getDiscountBundleDetails();
        //getDiscountRules();
        //getDiscountRuleDetails();
        //deleteRules();
        //deleteBundles();
        //getPlans();
        //getPlanDetails();
        //createPlan();
        //createNewPlan();
        //editPlan();
        //editPlanServiceDetails();
        //deletePlans();
        //copyPlan();
        //updateMasterPlan();
        //updateSupplementalPlan();
        //getPromotions();
        //getPromotionDetails();
        //createPromotion();
        //updatePromotion();
        //getUsageTypes();
        //getUsageTypeDetails();
        //getUsageUnitTypes();
        //createUsageType();
        //updateUsageType();
        //createSuppObjField();
        //updateSuppObjField();
        //getSuppObjFields();
        //listSuppObjFields();
        //getPlanGroups();
        //getPlanGroupDetails();
        //createPlanGroup();
        //updatePlanGroup();
        //deletePlanGroup();
        //listCoa();
        //addCoa();
        //getCoa();
        //editCoa();
        //getSurcharges();
        //getSurchargeDetails();
        //createSurcharge();
        //editSurcharge();
        //deleteSurcharge();
        //validateAdminSession();
        //createChannel();
        //copyClient();
        //getRevrecProfiles();
        //getRevrecProfileDetails();
        //createRevrecProfile();
        //updateRevrecProfile();
        //deleteRevrecProfile();
        //createProductFieldCategory();
        //editProductFieldCategory();
        //deleteProductFieldCategory();
        //getProductFieldCategories();
        //getProductFieldCategoryDetails();
        //createCouponGroup();
        //updateCouponGroup();
        //getCouponGroups();
        //getCouponGroupDetails();
        //getClientPaymentMethod();
            }

    //@Test
    public void getPromoPlanSets() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPromoPlanSets(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPromoPlanSets - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPromoPlanSetDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPromoPlanSetDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPromoPlanSetDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createPromoPlanSet() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createPromoPlanSet(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createPromoPlanSet - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updatePromoPlanSet() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updatePromoPlanSet(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updatePromoPlanSet - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void listPromoSets() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().listPromoSets(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "listPromoSets - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCompanyProfile() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCompanyProfile(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCompanyProfile - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void setCompanyProfile() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().setCompanyProfile(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "setCompanyProfile - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInventoryItems() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInventoryItems(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInventoryItems - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getInventoryItemDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getInventoryItemDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getInventoryItemDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createInventoryItem() throws Exception {
        com.aria.common.shared.admin.ServiceArray serviceArray = new com.aria.common.shared.admin.ServiceArray();
        com.aria.common.shared.admin.ScheduleArray scheduleArray = new com.aria.common.shared.admin.ScheduleArray();
        com.aria.common.shared.admin.ImageArray imageArray = new com.aria.common.shared.admin.ImageArray();
        com.aria.common.shared.admin.ParentClassArray parentClassArray = new com.aria.common.shared.admin.ParentClassArray();
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        
        hashMapReturnValues = getBaseAriaBilling().createInventoryItem(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , serviceArray
                , ""
                , ""
                , ""
                , ""
                , 1L
                , ""
                , scheduleArray
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1d
                , imageArray
                , parentClassArray
                , supplementalObjFieldArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createInventoryItem - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateInventoryItem() throws Exception {
        com.aria.common.shared.admin.ServiceArray serviceArray = new com.aria.common.shared.admin.ServiceArray();
        com.aria.common.shared.admin.ScheduleArray scheduleArray = new com.aria.common.shared.admin.ScheduleArray();
        com.aria.common.shared.admin.ImageArray imageArray = new com.aria.common.shared.admin.ImageArray();
        com.aria.common.shared.admin.ParentClassArray parentClassArray = new com.aria.common.shared.admin.ParentClassArray();
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateInventoryItem(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , serviceArray
                , ""
                , ""
                , ""
                , 1L
                , scheduleArray
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , 1d
                , imageArray
                , parentClassArray
                , supplementalObjFieldArray
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateInventoryItem - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createItemClass() throws Exception {
        com.aria.common.shared.admin.ParentClassArray parentClassArray = new com.aria.common.shared.admin.ParentClassArray();
        
        hashMapReturnValues = getBaseAriaBilling().createItemClass(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , parentClassArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createItemClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void editItemClass() throws Exception {
        com.aria.common.shared.admin.ParentClassArray parentClassArray = new com.aria.common.shared.admin.ParentClassArray();
        
        hashMapReturnValues = getBaseAriaBilling().editItemClass(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , 1L
                , parentClassArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "editItemClass - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getServiceTypes() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getServiceTypes(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getServiceTypes - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getServices() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getServices(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getServices - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getServiceDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getServiceDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getServiceDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlanServiceDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlanServiceDetails(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlanServiceDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createService() throws Exception {
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        
        hashMapReturnValues = getBaseAriaBilling().createService(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , supplementalObjFieldArray
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createService - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateService() throws Exception {
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateService(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , supplementalObjFieldArray
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateService - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppFields() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppFields(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppFieldDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppFieldDetails(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppFieldDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createSuppField() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createSuppField(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createSuppField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateSuppField() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateSuppField(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateSuppField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCoupons() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCoupons(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCoupons - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCouponDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCouponDetails(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCouponDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createCoupon() throws Exception {
        com.aria.common.shared.admin.TemplateArray templateArray = new com.aria.common.shared.admin.TemplateArray();
        com.aria.common.shared.admin.ExistingTemplateArray existingTemplateArray = new com.aria.common.shared.admin.ExistingTemplateArray();
        com.aria.common.shared.admin.ExistingTemplateIdArray existingTemplateIdArray = new com.aria.common.shared.admin.ExistingTemplateIdArray();
        com.aria.common.shared.admin.DiscountRuleArray discountRuleArray = new com.aria.common.shared.admin.DiscountRuleArray();
        com.aria.common.shared.admin.ExistingDiscountRuleArray existingDiscountRuleArray = new com.aria.common.shared.admin.ExistingDiscountRuleArray();
        com.aria.common.shared.admin.ExistingDiscountRuleIdArray existingDiscountRuleIdArray = new com.aria.common.shared.admin.ExistingDiscountRuleIdArray();
        com.aria.common.shared.admin.DiscountBundleArray discountBundleArray = new com.aria.common.shared.admin.DiscountBundleArray();
        com.aria.common.shared.admin.ExistingDiscountBundleArray existingDiscountBundleArray = new com.aria.common.shared.admin.ExistingDiscountBundleArray();
        com.aria.common.shared.admin.ExistingDiscountBundleIdArray existingDiscountBundleIdArray = new com.aria.common.shared.admin.ExistingDiscountBundleIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().createCoupon(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , templateArray
                , existingTemplateArray
                , existingTemplateIdArray
                , discountRuleArray
                , existingDiscountRuleArray
                , existingDiscountRuleIdArray
                , discountBundleArray
                , existingDiscountBundleArray
                , existingDiscountBundleIdArray
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createCoupon - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateCoupon() throws Exception {
        com.aria.common.shared.admin.TemplateArray templateArray = new com.aria.common.shared.admin.TemplateArray();
        com.aria.common.shared.admin.ExistingTemplateArray existingTemplateArray = new com.aria.common.shared.admin.ExistingTemplateArray();
        com.aria.common.shared.admin.ExistingTemplateIdArray existingTemplateIdArray = new com.aria.common.shared.admin.ExistingTemplateIdArray();
        com.aria.common.shared.admin.DiscountRuleArray discountRuleArray = new com.aria.common.shared.admin.DiscountRuleArray();
        com.aria.common.shared.admin.ExistingDiscountRuleArray existingDiscountRuleArray = new com.aria.common.shared.admin.ExistingDiscountRuleArray();
        com.aria.common.shared.admin.ExistingDiscountRuleIdArray existingDiscountRuleIdArray = new com.aria.common.shared.admin.ExistingDiscountRuleIdArray();
        com.aria.common.shared.admin.DiscountBundleArray discountBundleArray = new com.aria.common.shared.admin.DiscountBundleArray();
        com.aria.common.shared.admin.ExistingDiscountBundleArray existingDiscountBundleArray = new com.aria.common.shared.admin.ExistingDiscountBundleArray();
        com.aria.common.shared.admin.ExistingDiscountBundleIdArray existingDiscountBundleIdArray = new com.aria.common.shared.admin.ExistingDiscountBundleIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateCoupon(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , templateArray
                , existingTemplateArray
                , existingTemplateIdArray
                , discountRuleArray
                , existingDiscountRuleArray
                , existingDiscountRuleIdArray
                , discountBundleArray
                , existingDiscountBundleArray
                , existingDiscountBundleIdArray
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateCoupon - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteCoupons() throws Exception {
        com.aria.common.shared.admin.CouponNosArray couponNosArray = new com.aria.common.shared.admin.CouponNosArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteCoupons(getClientNo(), getAuthKey()        , couponNosArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteCoupons - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRecurringCreditTemplates() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRecurringCreditTemplates(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRecurringCreditTemplates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRecurringCreditTemplateDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRecurringCreditTemplateDetails(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRecurringCreditTemplateDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createCreditTemplate() throws Exception {
        com.aria.common.shared.admin.EligibleServiceTypesArray eligibleServiceTypesArray = new com.aria.common.shared.admin.EligibleServiceTypesArray();
        com.aria.common.shared.admin.CouponArray couponArray = new com.aria.common.shared.admin.CouponArray();
        com.aria.common.shared.admin.ExistingCouponArray existingCouponArray = new com.aria.common.shared.admin.ExistingCouponArray();
        
        hashMapReturnValues = getBaseAriaBilling().createCreditTemplate(getClientNo(), getAuthKey()        , ""
                , 1L
                , 1d
                , 1L
                , ""
                , 1L
                , ""
                , eligibleServiceTypesArray
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , ""
                , couponArray
                , existingCouponArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createCreditTemplate - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateCreditTemplate() throws Exception {
        com.aria.common.shared.admin.EligibleServiceTypesArray eligibleServiceTypesArray = new com.aria.common.shared.admin.EligibleServiceTypesArray();
        com.aria.common.shared.admin.CouponArray couponArray = new com.aria.common.shared.admin.CouponArray();
        com.aria.common.shared.admin.ExistingCouponArray existingCouponArray = new com.aria.common.shared.admin.ExistingCouponArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateCreditTemplate(getClientNo(), getAuthKey()        , ""
                , ""
                , 1d
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , eligibleServiceTypesArray
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , couponArray
                , existingCouponArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateCreditTemplate - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteTemplates() throws Exception {
        com.aria.common.shared.admin.TemplateNosArray templateNosArray = new com.aria.common.shared.admin.TemplateNosArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteTemplates(getClientNo(), getAuthKey()        , templateNosArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteTemplates - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createDiscountRule() throws Exception {
        com.aria.common.shared.admin.PlanNoArray planNoArray = new com.aria.common.shared.admin.PlanNoArray();
        com.aria.common.shared.admin.ClientPlanIdArray clientPlanIdArray = new com.aria.common.shared.admin.ClientPlanIdArray();
        com.aria.common.shared.admin.ServiceNoArray serviceNoArray = new com.aria.common.shared.admin.ServiceNoArray();
        com.aria.common.shared.admin.ClientServiceIdArray clientServiceIdArray = new com.aria.common.shared.admin.ClientServiceIdArray();
        com.aria.common.shared.admin.ItemNoArray itemNoArray = new com.aria.common.shared.admin.ItemNoArray();
        com.aria.common.shared.admin.ClientItemIdArray clientItemIdArray = new com.aria.common.shared.admin.ClientItemIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().createDiscountRule(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , 1d
                , ""
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , ""
                , planNoArray
                , clientPlanIdArray
                , serviceNoArray
                , clientServiceIdArray
                , itemNoArray
                , clientItemIdArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createDiscountRule - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createDiscountBundle() throws Exception {
        com.aria.common.shared.admin.RulesArray rulesArray = new com.aria.common.shared.admin.RulesArray();
        com.aria.common.shared.admin.RuleIdsArray ruleIdsArray = new com.aria.common.shared.admin.RuleIdsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createDiscountBundle(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , rulesArray
                , ruleIdsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createDiscountBundle - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getDiscountBundles() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getDiscountBundles(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getDiscountBundles - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getDiscountBundleDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getDiscountBundleDetails(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getDiscountBundleDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getDiscountRules() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getDiscountRules(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getDiscountRules - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getDiscountRuleDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getDiscountRuleDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getDiscountRuleDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteRules() throws Exception {
        com.aria.common.shared.admin.RuleNosArray ruleNosArray = new com.aria.common.shared.admin.RuleNosArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteRules(getClientNo(), getAuthKey()        , ruleNosArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteRules - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteBundles() throws Exception {
        com.aria.common.shared.admin.BundleNosArray bundleNosArray = new com.aria.common.shared.admin.BundleNosArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteBundles(getClientNo(), getAuthKey()        , bundleNosArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteBundles - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlans() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlans(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlans - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlanDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlanDetails(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlanDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createNewPlan() throws Exception {
        com.aria.common.shared.admin.ScheduleArray scheduleArray = new com.aria.common.shared.admin.ScheduleArray();
        com.aria.common.shared.admin.ServiceArray serviceArray = new com.aria.common.shared.admin.ServiceArray();
        com.aria.common.shared.admin.PlanGroupArray planGroupArray = new com.aria.common.shared.admin.PlanGroupArray();
        com.aria.common.shared.admin.PlanGroupIdArray planGroupIdArray = new com.aria.common.shared.admin.PlanGroupIdArray();
        com.aria.common.shared.admin.ResourceArray resourceArray = new com.aria.common.shared.admin.ResourceArray();
        com.aria.common.shared.admin.ParentPlansArray parentPlansArray = new com.aria.common.shared.admin.ParentPlansArray();
        com.aria.common.shared.admin.ParentClientPlanIdsArray parentClientPlanIdsArray = new com.aria.common.shared.admin.ParentClientPlanIdsArray();
        com.aria.common.shared.admin.ExclusionPlansArray exclusionPlansArray = new com.aria.common.shared.admin.ExclusionPlansArray();
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        com.aria.common.shared.admin.ChildPlansArray childPlansArray = new com.aria.common.shared.admin.ChildPlansArray();
        com.aria.common.shared.admin.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.admin.SurchargeNoArray();
        com.aria.common.shared.admin.ClientSurchargeIdArray clientSurchargeIdArray = new com.aria.common.shared.admin.ClientSurchargeIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().createNewPlan(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , 1L
                , scheduleArray
                , serviceArray
                , ""
                , ""
                , planGroupArray
                , planGroupIdArray
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , resourceArray
                , 1L
                , parentPlansArray
                , parentClientPlanIdsArray
                , exclusionPlansArray
                , supplementalObjFieldArray
                , 1L
                , childPlansArray
                , ""
                , ""
                , surchargeNoArray
                , clientSurchargeIdArray
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createNewPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void editPlan() throws Exception {
        com.aria.common.shared.admin.PlanGroupArray planGroupArray = new com.aria.common.shared.admin.PlanGroupArray();
        com.aria.common.shared.admin.PlanGroupIdArray planGroupIdArray = new com.aria.common.shared.admin.PlanGroupIdArray();
        com.aria.common.shared.admin.ScheduleArray scheduleArray = new com.aria.common.shared.admin.ScheduleArray();
        com.aria.common.shared.admin.ServiceArray serviceArray = new com.aria.common.shared.admin.ServiceArray();
        com.aria.common.shared.admin.ResourceArray resourceArray = new com.aria.common.shared.admin.ResourceArray();
        com.aria.common.shared.admin.ParentPlansArray parentPlansArray = new com.aria.common.shared.admin.ParentPlansArray();
        com.aria.common.shared.admin.ParentClientPlanIdsArray parentClientPlanIdsArray = new com.aria.common.shared.admin.ParentClientPlanIdsArray();
        com.aria.common.shared.admin.ExclusionPlansArray exclusionPlansArray = new com.aria.common.shared.admin.ExclusionPlansArray();
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        com.aria.common.shared.admin.ChildPlansArray childPlansArray = new com.aria.common.shared.admin.ChildPlansArray();
        com.aria.common.shared.admin.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.admin.SurchargeNoArray();
        com.aria.common.shared.admin.ClientSurchargeIdArray clientSurchargeIdArray = new com.aria.common.shared.admin.ClientSurchargeIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().editPlan(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , planGroupArray
                , planGroupIdArray
                , 1L
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
                , ""
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , 1L
                , 1L
                , 1L
                , 1L
                , ""
                , 1L
                , ""
                , 1L
                , scheduleArray
                , serviceArray
                , resourceArray
                , 1L
                , parentPlansArray
                , parentClientPlanIdsArray
                , exclusionPlansArray
                , supplementalObjFieldArray
                , childPlansArray
                , ""
                , ""
                , surchargeNoArray
                , clientSurchargeIdArray
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "editPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deletePlans() throws Exception {
        com.aria.common.shared.admin.PlanNosArray planNosArray = new com.aria.common.shared.admin.PlanNosArray();
        
        hashMapReturnValues = getBaseAriaBilling().deletePlans(getClientNo(), getAuthKey()        , planNosArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deletePlans - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void copyPlan() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().copyPlan(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "copyPlan - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPromotions() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPromotions(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPromotions - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPromotionDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPromotionDetails(getClientNo(), getAuthKey()        , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPromotionDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createPromotion() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createPromotion(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createPromotion - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updatePromotion() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updatePromotion(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updatePromotion - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageTypes() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUsageTypes(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageTypes - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageTypeDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUsageTypeDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageTypeDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getUsageUnitTypes() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getUsageUnitTypes(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getUsageUnitTypes - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createUsageType() throws Exception {
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        
        hashMapReturnValues = getBaseAriaBilling().createUsageType(getClientNo(), getAuthKey()        , ""
                , ""
                , 1L
                , ""
                , ""
                , supplementalObjFieldArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createUsageType - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateUsageType() throws Exception {
        com.aria.common.shared.admin.SupplementalObjFieldArray supplementalObjFieldArray = new com.aria.common.shared.admin.SupplementalObjFieldArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateUsageType(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , supplementalObjFieldArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateUsageType - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createSuppObjField() throws Exception {
        com.aria.common.shared.admin.AssignFieldCategoriesArray assignFieldCategoriesArray = new com.aria.common.shared.admin.AssignFieldCategoriesArray();
        com.aria.common.shared.admin.ObjectTypeArray objectTypeArray = new com.aria.common.shared.admin.ObjectTypeArray();
        
        hashMapReturnValues = getBaseAriaBilling().createSuppObjField(getClientNo(), getAuthKey()        , ""
                , assignFieldCategoriesArray
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , objectTypeArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createSuppObjField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateSuppObjField() throws Exception {
        com.aria.common.shared.admin.AssignFieldCategoriesArray assignFieldCategoriesArray = new com.aria.common.shared.admin.AssignFieldCategoriesArray();
        com.aria.common.shared.admin.ObjectTypeArray objectTypeArray = new com.aria.common.shared.admin.ObjectTypeArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateSuppObjField(getClientNo(), getAuthKey()        , 1L
                , ""
                , assignFieldCategoriesArray
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , objectTypeArray
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateSuppObjField - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSuppObjFields() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSuppObjFields(getClientNo(), getAuthKey()        , 1L
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSuppObjFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void listSuppObjFields() throws Exception {
        com.aria.common.shared.admin.FieldSelectionArray fieldSelectionArray = new com.aria.common.shared.admin.FieldSelectionArray();
        com.aria.common.shared.admin.FieldCategoriesArray fieldCategoriesArray = new com.aria.common.shared.admin.FieldCategoriesArray();
        
        hashMapReturnValues = getBaseAriaBilling().listSuppObjFields(getClientNo(), getAuthKey()        , fieldSelectionArray
                , fieldCategoriesArray
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "listSuppObjFields - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlanGroups() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlanGroups(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlanGroups - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getPlanGroupDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getPlanGroupDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getPlanGroupDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createPlanGroup() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createPlanGroup(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createPlanGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updatePlanGroup() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updatePlanGroup(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updatePlanGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deletePlanGroup() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().deletePlanGroup(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deletePlanGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void listCoa() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().listCoa(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "listCoa - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void addCoa() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().addCoa(getClientNo(), getAuthKey()        , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "addCoa - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCoa() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCoa(getClientNo(), getAuthKey()        , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCoa - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void editCoa() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().editCoa(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "editCoa - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSurcharges() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSurcharges(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSurcharges - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getSurchargeDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getSurchargeDetails(getClientNo(), getAuthKey()        , 1L
                , ""
                , 1L
                , ""
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getSurchargeDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createSurcharge() throws Exception {
        com.aria.common.shared.admin.SurchargeTierArray surchargeTierArray = new com.aria.common.shared.admin.SurchargeTierArray();
        com.aria.common.shared.admin.PlanNoArray planNoArray = new com.aria.common.shared.admin.PlanNoArray();
        com.aria.common.shared.admin.ClientPlanIdArray clientPlanIdArray = new com.aria.common.shared.admin.ClientPlanIdArray();
        com.aria.common.shared.admin.ServiceNoArray serviceNoArray = new com.aria.common.shared.admin.ServiceNoArray();
        com.aria.common.shared.admin.ClientServiceIdArray clientServiceIdArray = new com.aria.common.shared.admin.ClientServiceIdArray();
        com.aria.common.shared.admin.ItemNoArray itemNoArray = new com.aria.common.shared.admin.ItemNoArray();
        com.aria.common.shared.admin.ClientItemIdArray clientItemIdArray = new com.aria.common.shared.admin.ClientItemIdArray();
        com.aria.common.shared.admin.ScheduleArray scheduleArray = new com.aria.common.shared.admin.ScheduleArray();
        
        hashMapReturnValues = getBaseAriaBilling().createSurcharge(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , surchargeTierArray
                , ""
                , 1L
                , 1L
                , ""
                , ""
                , planNoArray
                , clientPlanIdArray
                , serviceNoArray
                , clientServiceIdArray
                , itemNoArray
                , clientItemIdArray
                , scheduleArray
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createSurcharge - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void editSurcharge() throws Exception {
        com.aria.common.shared.admin.SurchargeTierArray surchargeTierArray = new com.aria.common.shared.admin.SurchargeTierArray();
        com.aria.common.shared.admin.PlanNoArray planNoArray = new com.aria.common.shared.admin.PlanNoArray();
        com.aria.common.shared.admin.ClientPlanIdArray clientPlanIdArray = new com.aria.common.shared.admin.ClientPlanIdArray();
        com.aria.common.shared.admin.ServiceNoArray serviceNoArray = new com.aria.common.shared.admin.ServiceNoArray();
        com.aria.common.shared.admin.ClientServiceIdArray clientServiceIdArray = new com.aria.common.shared.admin.ClientServiceIdArray();
        com.aria.common.shared.admin.ItemNoArray itemNoArray = new com.aria.common.shared.admin.ItemNoArray();
        com.aria.common.shared.admin.ClientItemIdArray clientItemIdArray = new com.aria.common.shared.admin.ClientItemIdArray();
        com.aria.common.shared.admin.ScheduleArray scheduleArray = new com.aria.common.shared.admin.ScheduleArray();
        
        hashMapReturnValues = getBaseAriaBilling().editSurcharge(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , 1L
                , surchargeTierArray
                , 1L
                , planNoArray
                , clientPlanIdArray
                , serviceNoArray
                , clientServiceIdArray
                , itemNoArray
                , clientItemIdArray
                , scheduleArray
                , 1L
                , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "editSurcharge - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteSurcharge() throws Exception {
        com.aria.common.shared.admin.SurchargeNoArray surchargeNoArray = new com.aria.common.shared.admin.SurchargeNoArray();
        com.aria.common.shared.admin.ClientSurchargeIdArray clientSurchargeIdArray = new com.aria.common.shared.admin.ClientSurchargeIdArray();
        
        hashMapReturnValues = getBaseAriaBilling().deleteSurcharge(getClientNo(), getAuthKey()        , surchargeNoArray
                , clientSurchargeIdArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteSurcharge - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void validateAdminSession() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().validateAdminSession(getClientNo(), getAuthKey()        , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "validateAdminSession - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createChannel() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createChannel(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createChannel - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void copyClient() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().copyClient(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "copyClient - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRevrecProfiles() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRevrecProfiles(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRevrecProfiles - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getRevrecProfileDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getRevrecProfileDetails(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getRevrecProfileDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createRevrecProfile() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().createRevrecProfile(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createRevrecProfile - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateRevrecProfile() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().updateRevrecProfile(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , 1L
                , 1L
                , 1L
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateRevrecProfile - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteRevrecProfile() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().deleteRevrecProfile(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteRevrecProfile - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createProductFieldCategory() throws Exception {
        com.aria.common.shared.admin.AssignCategoryPlansArray assignCategoryPlansArray = new com.aria.common.shared.admin.AssignCategoryPlansArray();
        com.aria.common.shared.admin.AssignCategoryFieldsArray assignCategoryFieldsArray = new com.aria.common.shared.admin.AssignCategoryFieldsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createProductFieldCategory(getClientNo(), getAuthKey()        , ""
                , assignCategoryPlansArray
                , assignCategoryFieldsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createProductFieldCategory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void editProductFieldCategory() throws Exception {
        com.aria.common.shared.admin.AssignCategoryPlansArray assignCategoryPlansArray = new com.aria.common.shared.admin.AssignCategoryPlansArray();
        com.aria.common.shared.admin.AssignCategoryFieldsArray assignCategoryFieldsArray = new com.aria.common.shared.admin.AssignCategoryFieldsArray();
        
        hashMapReturnValues = getBaseAriaBilling().editProductFieldCategory(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , assignCategoryPlansArray
                , assignCategoryFieldsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "editProductFieldCategory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void deleteProductFieldCategory() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().deleteProductFieldCategory(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "deleteProductFieldCategory - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getProductFieldCategories() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getProductFieldCategories(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getProductFieldCategories - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getProductFieldCategoryDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getProductFieldCategoryDetails(getClientNo(), getAuthKey()        , 1L
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getProductFieldCategoryDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void createCouponGroup() throws Exception {
        com.aria.common.shared.admin.CouponsArray couponsArray = new com.aria.common.shared.admin.CouponsArray();
        
        hashMapReturnValues = getBaseAriaBilling().createCouponGroup(getClientNo(), getAuthKey()        , ""
                , ""
                , ""
                , ""
                , couponsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "createCouponGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void updateCouponGroup() throws Exception {
        com.aria.common.shared.admin.CouponsArray couponsArray = new com.aria.common.shared.admin.CouponsArray();
        
        hashMapReturnValues = getBaseAriaBilling().updateCouponGroup(getClientNo(), getAuthKey()        , 1L
                , ""
                , ""
                , ""
                , ""
                , 1L
                , couponsArray
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "updateCouponGroup - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCouponGroups() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCouponGroups(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCouponGroups - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getCouponGroupDetails() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getCouponGroupDetails(getClientNo(), getAuthKey()        , ""
                , ""
        );
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getCouponGroupDetails - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

    //@Test
    public void getClientPaymentMethod() throws Exception {
        
        hashMapReturnValues = getBaseAriaBilling().getClientPaymentMethod(getClientNo(), getAuthKey());
        if (hashMapReturnValues.get(ERROR_CODE) != null) {
            String errorMessage = "getClientPaymentMethod - " + ERROR_CODE + " (" + hashMapReturnValues.get(ERROR_CODE) + ") ";
            if (hashMapReturnValues.get(ERROR_MESSAGE) != null) {
                errorMessage += ERROR_MESSAGE + " (" + hashMapReturnValues.get(ERROR_MESSAGE) + ")";
            }
            assertEquals(errorMessage, 0L, hashMapReturnValues.get(ERROR_CODE));
        }
    }

        /*************************** END - TEST ******************************/
}
