package com.example.swethababurao.doordashlite;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.swethababurao.doordashlite.Adapter.RestuarantAdapter;
import com.example.swethababurao.doordashlite.Helper.EndPointsInterface;
import com.example.swethababurao.doordashlite.Helper.RetrofitClient;
import com.example.swethababurao.doordashlite.Model.RestaurantObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRestaurantList;
    ProgressDialog mProgressDialog;
    private RestuarantAdapter mRestuarantAdapter;
    private double mLat;
    private double mLng;
    private double mOffset;
    private double mLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*  assign the values for latitude longitude offset and limit
         * the next versions will get the latitude and longitude from location service */
        mLat = 37.422740;
        mLng = -122.139956;
        mOffset = 0;
        mLimit = 50;

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();


        //Create handle for the RetrofitInstance interface

        EndPointsInterface mService = RetrofitClient.getRetrofitClientInstance().create(EndPointsInterface.class);

        //Call<List<RestaurantObject>> call = mService.getAllRestaurants();

        /* Call Restaurants with the params specified in the method*/
        Call<List<RestaurantObject>> call = mService.getAllRestaurantsByLatLngOffsetLimit(mLat, mLng, mOffset, mLimit);
        call.enqueue(new Callback<List<RestaurantObject>>() {
            @Override
            public void onResponse(Call<List<RestaurantObject>> call, Response<List<RestaurantObject>> response) {
                mProgressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RestaurantObject>> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Please try later..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* Method to generate List of data using RecyclerView with custom adapter */
    private void generateDataList(List<RestaurantObject> restaurantList) {
        mRestaurantList = (RecyclerView) findViewById(R.id.rv_restuarantList);
        mRestuarantAdapter = new RestuarantAdapter(this, restaurantList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRestaurantList.setLayoutManager(layoutManager);
        mRestaurantList.addItemDecoration(new DividerItemDecoration(mRestaurantList.getContext(), DividerItemDecoration.VERTICAL));
        mRestaurantList.setAdapter(mRestuarantAdapter);

    }

}

