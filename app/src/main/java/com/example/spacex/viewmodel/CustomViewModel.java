package com.example.spacex.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


public abstract class CustomViewModel extends AndroidViewModel {
    public final MutableLiveData<Boolean> dataLoading = new MutableLiveData<>(false);

    public CustomViewModel(@NonNull Application application) {
        super(application);
    }

}