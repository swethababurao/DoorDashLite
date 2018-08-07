package com.example.swethababurao.doordashlite.Helper;

import com.example.swethababurao.doordashlite.Model.RestaurantObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by swethababurao on 8/6/18.
 */

public interface EndPointsInterface {

    @GET("restaurant")
    Call<List<RestaurantObject>> getAllRestaurants();


    @GET("restaurant")
    Call<List<RestaurantObject>> getAllRestaurantsByLatLngOffsetLimit(@Query("lat") double lat, @Query("lng") double lng, @Query("offset") double offset, @Query("limit") double limit);


}
