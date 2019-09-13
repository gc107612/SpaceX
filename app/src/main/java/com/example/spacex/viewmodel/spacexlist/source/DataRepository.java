package com.example.spacex.viewmodel.spacexlist.source;

import androidx.annotation.NonNull;

import com.example.spacex.model.SpaceXModel;
import com.example.spacex.viewmodel.spacexlist.source.remote.DataRepositoryRemote;

import java.util.List;

import io.reactivex.Single;


public class DataRepository {
    private final DataRepositoryRemote remoteDataSource;

    public static DataRepository getInstance() {
        return DataRepositoryHolder.INSTANCE;
    }

    private DataRepository(@NonNull DataRepositoryRemote remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public Single<List<SpaceXModel>> getSpaceXList(int limit, int offset) {
        return remoteDataSource.getSpaceXList(limit, offset);
    }

    private static class DataRepositoryHolder {
        private static final DataRepository INSTANCE = new DataRepository(
                DataRepositoryRemote.getInstance()
        );
    }
}