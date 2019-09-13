package com.example.spacex.network;

import com.example.spacex.model.SpaceXModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
    @GET(Constants.URL_SPACE_DATA)
    Single<List<SpaceXModel>> getSpaceX_Data(@Query("limit") int limit, @Query("offset") int offset, @Query("order") String order);
}