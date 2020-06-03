package com.example.venturuscatviewer.viewmodel;

import android.app.Application;
import android.media.Image;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.venturuscatviewer.injection.DaggerRetrofitComponent;
import com.example.venturuscatviewer.model.CatRequest;
import com.example.venturuscatviewer.model.ImageRequest;
import com.example.venturuscatviewer.retrofit.DataRequestApi;
import com.example.venturuscatviewer.retrofit.RetrofitConfig;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    //private final RetrofitConfig retrofitConfig;
    private MutableLiveData<List<ImageRequest>> listMutableLiveData = new MutableLiveData<>();

    @Inject
    public DataRequestApi dataRequestApi;

    public MainActivityViewModel() {
        //this.retrofitConfig = new RetrofitConfig();
        DaggerRetrofitComponent.create().inject(this);
    }

    public MutableLiveData<List<ImageRequest>> getApiInfo() {

        if(this.listMutableLiveData.getValue() == null) {
            this.dataRequestApi.getApiInfo("cats")
                               .subscribeOn(Schedulers.newThread())
                               .observeOn(AndroidSchedulers.mainThread())
                               .subscribe(data -> {
                                   for(CatRequest catRequest : data.getCatRequestList()) {
                                       this.listMutableLiveData.setValue(catRequest.getImageRequestList());
                                   }
                               }, Throwable -> {
                                   this.listMutableLiveData.setValue(null);
                               });
        }

        return this.listMutableLiveData;
    }
}
