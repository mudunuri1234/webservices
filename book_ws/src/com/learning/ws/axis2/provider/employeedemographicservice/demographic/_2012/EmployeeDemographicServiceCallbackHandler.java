
/**
 * EmployeeDemographicServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.learning.ws.axis2.provider.employeedemographicservice.demographic._2012;

    /**
     *  EmployeeDemographicServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class EmployeeDemographicServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public EmployeeDemographicServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public EmployeeDemographicServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getDemographicInformation method
            * override this method for handling normal response from getDemographicInformation operation
            */
           public void receiveResultgetDemographicInformation(
                    com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationResponseDocument result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDemographicInformation operation
           */
            public void receiveErrorgetDemographicInformation(java.lang.Exception e) {
            }
                


    }
    