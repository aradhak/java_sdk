package com.aria.sdk.classes;

import java.util.concurrent.atomic.AtomicReference;

public class AriaBillingBuilder {

  private static final AtomicReference<AriaBillingCompleteRest> ariaBillingCompleteRest = new AtomicReference<AriaBillingCompleteRest>(null);

  private static final AtomicReference<AriaBillingAdministrationRest> ariaBillingAdministrationRest = new AtomicReference<AriaBillingAdministrationRest>(null);

  private static final AtomicReference<AriaBillingIntegrationRest> ariaBillingIntegrationRest = new AtomicReference<AriaBillingIntegrationRest>(null);

  private AriaBillingBuilder(){}

  /**
   *  On first call constructs the Aria SDK.
   *  Subsequent calls return the same object; the arguments are ignored.
   *
   *  The instance returned is threadsafe.
   *
   *  @deprecated use the {@link AriaBillingCompleteRest} constructor directly and reuse a single instance.
   */
  synchronized public static AriaBillingComplete getAriaSDK(BaseAriaBillingDTO baseAriaBillingDTO) throws Exception{
    if(ariaBillingCompleteRest.get() == null) {
      ariaBillingCompleteRest.set(new AriaBillingCompleteRest(baseAriaBillingDTO));
    }
    return ariaBillingCompleteRest.get();
  }

  /**
   *  On first call constructs the Aria SDK.
   *  Subsequent calls return the same object; the arguments are ignored.
   *
   *  The instance returned is threadsafe.
   *
   *  @deprecated use the {@link AriaBillingAdministrationRest} constructor directly and reuse a single instance.
   */
  synchronized public static AriaBillingAdministration getAriaAdminSDK(BaseAriaBillingDTO baseAriaBillingDTO) throws Exception{
    if(ariaBillingAdministrationRest.get() == null) {
      ariaBillingAdministrationRest.set(new AriaBillingAdministrationRest(baseAriaBillingDTO));
    }
    return ariaBillingAdministrationRest.get();
  }

  /**
   *  On first call constructs the Aria SDK.
   *  Subsequent calls return the same object; the arguments are ignored.
   *
   *  The instance returned is threadsafe.
   *
   * @deprecated use the {@link AriaBillingIntegrationRest} constructor directly and reuse a single instance.
   */
  synchronized public static AriaBillingIntegration getAriaObjectSDK(BaseAriaBillingDTO baseAriaBillingDTO) throws Exception{
    if(ariaBillingIntegrationRest.get() == null) {
      ariaBillingIntegrationRest.set(new AriaBillingIntegrationRest(baseAriaBillingDTO));
    }
    return ariaBillingIntegrationRest.get();
  }

}
