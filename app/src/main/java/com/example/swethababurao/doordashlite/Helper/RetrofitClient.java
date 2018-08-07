package com.example.swethababurao.doordashlite.Helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swethababurao on 8/6/18.
 */

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.doordash.com/v2/";

    public static Retrofit getRetrofitClientInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
