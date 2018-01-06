package com.oxfordtranslateapi.network;

import android.content.Context;


import com.oxfordtranslateapi.interfaces.NetworkListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ApiCall.java
 * This singleton class is used to hit service and handle response at single place.
 *  @author Ankit Chouhan
 *  @version 1.0
 *  @since 1.0
 */
public class ApiCall {
    private static ApiCall apiCall = null;
    private final String LOG_TAG = "Network Connection";


    /**
     * This method is used to provide the instance of Network Connection Class
     * @return instance of Network Connection Class
     */
    public static ApiCall getInstance() {
        if (apiCall == null) {
            return new ApiCall();
        } else {
            return apiCall;
        }
    }


    /**
     * This class is used to hit the service and handle their responses
     * @param context  - Context of the class
     * @param bodyCall - retrofit call
     * @param requestCode
     */
    public void hitService(final Context context, Call<ResponseBody> bodyCall, final NetworkListener networkListener, final int requestCode) {
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response != null) {
                        if (response.body() != null) {
                            networkListener.onSuccess(response.code(), response.body().string(),requestCode);
                        } else if (response.errorBody() != null) {
                            networkListener.onError(response.errorBody().string(),requestCode);
                        }
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                networkListener.onFailure();
            }
        });
    }
}


