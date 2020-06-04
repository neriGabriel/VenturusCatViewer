package com.example.venturuscatviewer.injection;

import com.example.venturuscatviewer.retrofit.DataRequestApi;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private final String baseUrl = "https://api.imgur.com/3/gallery/";
    private final String authorization = "Client-ID 1ceddedc03a5d71";

    @Provides
    public DataRequestApi getRetrofitConfig() {
        return new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(this.createHttpCliente())
                .build()
                .create(DataRequestApi.class);
    }

    private OkHttpClient createHttpCliente() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request.Builder onGoing = chain.request().newBuilder();
                    onGoing.addHeader("Authorization", authorization);
                    return chain.proceed(onGoing.build());
                })
                .build();
    }
}
