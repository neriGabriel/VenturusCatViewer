package com.example.venturuscatviewer.retrofit;


import com.example.venturuscatviewer.model.DataRequest;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataRequestApi {

    @GET("search/")
    Observable<DataRequest> getApiInfo(@Query("q") String query);
}
