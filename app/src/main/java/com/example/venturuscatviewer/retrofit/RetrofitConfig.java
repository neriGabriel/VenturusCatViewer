package com.example.venturuscatviewer.retrofit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* Deprecated, now the project is setup to use depedency injection \o/
* */
public class RetrofitConfig {

    private final Retrofit config;
    private final String baseUrl = "https://api.imgur.com/3/gallery/";

    public RetrofitConfig() {
        this.config = new Retrofit.Builder()
                                  .baseUrl(this.baseUrl)
                                  .addConverterFactory(GsonConverterFactory.create())
                                  .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                                  .client(this.createHttpCliente())
                                  .build();
    }

    public DataRequestApi getDataRequestApi() {
        return this.config.create(DataRequestApi.class);
    }

    /*
    * Setup http request configs
    * */
    private OkHttpClient createHttpCliente() {
        return new OkHttpClient.Builder()
                               .addInterceptor(chain -> {
                                    Request.Builder onGoing = chain.request().newBuilder();
                                    onGoing.addHeader("Authorization", "Client-ID 1ceddedc03a5d71");
                                    return chain.proceed(onGoing.build());
                               })
                               .build();
    }
}
