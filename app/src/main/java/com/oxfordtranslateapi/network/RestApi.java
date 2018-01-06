package com.oxfordtranslateapi.network;

/**
 * Created by Ankit Chouhan on 15/12/17.
 */

import android.content.Context;

import java.io.File;
import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * This class is used to handling operation for Service
 */
public class RestApi {
    private static final String API_BASE_URL = "https://od-api.oxforddictionaries.com/api/v1/";
    private static String APP_KEY = "your_app_key";
    private static String APP_ID = "your_app_id";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create());

    public static <S> S createService(final Context context, Class<S> aClass) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder;
                requestBuilder = original.newBuilder()
                        .header("app_id", APP_ID)
                        .header("app_key", APP_KEY)
                        .header("Accept","application/json")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();
        return retrofit.create(aClass);
    }


    public static RequestBody getRequestBody(String params) {
        return RequestBody.create(MediaType.parse("text/plain"), params.getBytes());
    }

    //This method is used to create the multipart file data
    public static MultipartBody.Part prepareFilePart(String partName, File file) {

        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*; boundary=----" + System.currentTimeMillis()), file);
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }
}
