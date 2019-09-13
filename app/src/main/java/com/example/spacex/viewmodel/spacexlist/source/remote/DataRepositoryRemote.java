package com.example.spacex.viewmodel.spacexlist.source.remote;

import com.example.spacex.model.SpaceXModel;
import com.example.spacex.network.ApiClient;
import com.example.spacex.network.RestService;

import java.util.List;

import io.reactivex.Single;


/**
 * Used to get data from remote data source using network calls
 */
public class DataRepositoryRemote {
    private final RestService apiService;

    public static DataRepositoryRemote getInstance() {
        return DataRepositoryRemoteInstanceHolder.INSTANCE;
    }

    private DataRepositoryRemote() {
        apiService = ApiClient.getRetrofitInstance()
                .create(RestService.class);
    }

    public Single<List<SpaceXModel>> getSpaceXList(int limit, int offset) {
        return apiService.getSpaceX_Data(limit, offset, "desc");
    }

    private static class DataRepositoryRemoteInstanceHolder {
        private static final DataRepositoryRemote INSTANCE = new DataRepositoryRemote();
    }
}