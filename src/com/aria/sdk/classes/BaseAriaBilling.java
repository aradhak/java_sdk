package com.aria.sdk.classes;

import java.util.HashMap;
import java.util.logging.Level;

import javax.ws.rs.core.MultivaluedMap;

import com.aria.common.rest.RestUtilities;

/**
 * BaseAriaBilling
 * Web Service class that abstracts API calls
 *
 * @copyright Aria Systems, Inc
 */
public abstract class BaseAriaBilling {
    /*************** CLASS ATTRIBUTES ****************/
    public final String URL;
    
    /*************** END - CLASS ATTRIBUTES  ****************/

    /********************** CONSTRUCTOR ***********************/
    protected BaseAriaBilling(String url) {
      if (url == null) {
          throw new RuntimeException("URL parameter required" );
      }
      this.URL = url;
    }
    
    /********************** BASE AND GENERAL METHODS ***********************/

    /* @deprecated */
    public void setMessageToLogger(Level level,String message) {
    }

    public String getValue(String type, Object value) {
        return RestUtilities.getValue(type, value);
    }

    protected HashMap<String, Object> buildHashMapReturnValues(String response, String[] returnValues) {
        if (getLibraryType() == null || getLibraryType().equals(LibraryType.CORE)) {
            return RestUtilities.buildJSonReturn(response,returnValues);
        } else if (getLibraryType().equals(LibraryType.ADMINTOOLS)) {
            return com.aria.common.rest.admin.RestUtilities.buildJSonReturn(response,returnValues);
        } else if (getLibraryType().equals(LibraryType.OBJECT_QUERY)) {
            return com.aria.common.rest.object.RestUtilities.buildJSonReturn(response,returnValues);
        }
        return new HashMap<String, Object>();
    }

    protected void addParameters(MultivaluedMap<String, String> parameters, String parmName, String value) {
        if (value == null || value.length() <= 0){
            return;
        }
        parameters.add(parmName,value);
    }
    /********************** END - BASE AND GENERAL METHODS ***********************/

    /*************** GETTERS ****************/

    abstract public LibraryType getLibraryType();

    public String getURL() { return URL; }

    /*************** END - GETTERS ****************/
    
    protected static LibraryType asLibraryType(String type) {
      return "Administration".equals(type) ? LibraryType.ADMINTOOLS 
        : "Integration".equals(type) ? LibraryType.OBJECT_QUERY
        : LibraryType.CORE;
    }

}
