package com.oxfordtranslateapi.interfaces;



/**
 * NetworkListener.java
 * It provides an interface between Classes hitting Service and ApiCall Class
 *  @author Ankit Chouhan
 *  @version 1.0
 *  @since 1.0
 */

public interface NetworkListener {

    /**
     * This method is called when response ir received with code 200
     * @param responseCode - code of response
     * @param response - response in String
     * @param requestCode
     */
    void onSuccess(int responseCode, String response, int requestCode);


    /**
     * This method is called when response ir received in the error body
     * @param response - response in th error body
     * @param requestCode
     */
    void onError(String response, int requestCode);


    /**
     * This method is called when we receive a call in failure
     */
    void onFailure();


}


