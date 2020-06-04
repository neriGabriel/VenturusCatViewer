package com.example.venturuscatviewer.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.venturuscatviewer.injection.DaggerRetrofitComponent;
import com.example.venturuscatviewer.model.CatRequest;
import com.example.venturuscatviewer.model.ImageRequest;
import com.example.venturuscatviewer.retrofit.DataRequestApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<ImageRequest>> listMutableLiveData = new MutableLiveData<>();

    @Inject
    public DataRequestApi dataRequestApi;

    public MainActivityViewModel() {
        DaggerRetrofitComponent.create().inject(this);
    }

    public MutableLiveData<List<ImageRequest>> getApiInfo() {
        listMutableLiveData =  new MutableLiveData<>();
        dataRequestApi.getApiInfo("cats")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    for (CatRequest catRequest : data.getCatRequestList()) {
                        listMutableLiveData.setValue(catRequest.getImageRequestList());
                    }
                }, Throwable -> {
                    listMutableLiveData.setValue(null);
                });

        return listMutableLiveData;
    }
}
