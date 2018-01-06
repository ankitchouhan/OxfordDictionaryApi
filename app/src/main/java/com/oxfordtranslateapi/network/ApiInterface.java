package com.oxfordtranslateapi.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * ApiInterface.java
 * This class act as an interface between Retrofit and Classes used using Retrofit in Application
 *
 * @author Ankit Chouhan
 * @version 1.0
 * @since 1.0
 */

public interface ApiInterface {

    @GET()
    Call<ResponseBody> getWordDetails(@Url String wordId);

}
