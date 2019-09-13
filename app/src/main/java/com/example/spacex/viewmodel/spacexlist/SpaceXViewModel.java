package com.example.spacex.viewmodel.spacexlist;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.spacex.model.SpaceXModel;
import com.example.spacex.util.Utils;
import com.example.spacex.viewmodel.CustomViewModel;
import com.example.spacex.viewmodel.spacexlist.adapters.SpaceAdapter;
import com.example.spacex.viewmodel.spacexlist.source.DataRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SpaceXViewModel extends CustomViewModel {

    private static final String TAG = "SpaceXViewModel";
    private final SpaceAdapter adapter;
    public final ArrayList<SpaceXModel> data;
    private DataRepository dataRepository;

    private static final int pageLimit = 10;
    private int pageOffset = 0;


    public SpaceXViewModel(@NonNull Application application) {
        super(application);
        data = new ArrayList<>();
        adapter = new SpaceAdapter(application, data);
        dataRepository = DataRepository.getInstance();
        loadData();
    }

    public SpaceAdapter getAdapter() {
        return adapter;
    }

    public ArrayList<SpaceXModel> getData() {
        return data;
    }

    public void loadNextData() {
        pageOffset = pageOffset + 10;
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        dataLoading.setValue(true);
        dataRepository.getSpaceXList(pageLimit, pageOffset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<SpaceXModel>>() {
                    @Override
                    public void onSuccess(List<SpaceXModel> spaceXModels) {
                        data.addAll(spaceXModels);
                        Utils.sortDataByUTC(data);
                        adapter.notifyDataSetChanged();
                        dataLoading.setValue(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e.getMessage() != null)
                            Log.e(TAG, e.getMessage());
                        dataLoading.setValue(false);
                    }
                });
    }
}
