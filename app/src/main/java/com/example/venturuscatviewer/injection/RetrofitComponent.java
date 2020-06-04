package com.example.venturuscatviewer.injection;

import com.example.venturuscatviewer.viewmodel.MainActivityViewModel;

import dagger.Component;

@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {

    void inject(MainActivityViewModel mainActivityViewModel);
}
