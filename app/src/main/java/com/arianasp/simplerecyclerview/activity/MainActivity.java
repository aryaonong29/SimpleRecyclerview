package com.arianasp.simplerecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.arianasp.simplerecyclerview.JSONResponseData;
import com.arianasp.simplerecyclerview.R;
import com.arianasp.simplerecyclerview.adapter.DataAdapterTest;
import com.arianasp.simplerecyclerview.interfaceapi.RequestInterfaceData;
import com.arianasp.simplerecyclerview.model.DataVersion;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<DataVersion> data;
    DataAdapterTest adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        rv = (RecyclerView) findViewById(R.id.card_recycler_view);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager rvLay = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(rvLay);
//        loadJSON();
        loadJSONData();
    }
//
//    private void loadJSON(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://api.learn2crack.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RequestInterface req =retrofit.create(RequestInterface.class);
//        Call<JSONResponse> call = req.getJSON();
//        call.enqueue(new Callback<JSONResponse>() {
//            @Override
//            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
//                JSONResponse jsonres = response.body();
//                data = new ArrayList<AndroidVersion>(Arrays.asList(jsonres.getAndroid()));
//                adapter = new DataAdapter(data);
//                rv.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<JSONResponse> call, Throwable t) {
//                Log.d("Error", t.getMessage());
//            }
//        });
//    }

    private void loadJSONData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("192.168.1.210:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterfaceData request =retrofit.create(RequestInterfaceData.class);
        Call<JSONResponseData> call = request.getJSONData();
        call.enqueue(new Callback<JSONResponseData>() {
            @Override
            public void onResponse(Call<JSONResponseData> call, Response<JSONResponseData> response) {
                JSONResponseData jsonres = response.body();
                data = new ArrayList<DataVersion>(Arrays.asList(jsonres.getData()));
                adapter = new DataAdapterTest(data);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponseData> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }

        });
    }
}
