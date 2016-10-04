package com.arianasp.simplerecyclerview.interfaceapi;

import com.arianasp.simplerecyclerview.JSONResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mycomputer on 04/10/16.
 */

public interface RequestInterfaceData {

    @GET("api/test")
    Call<JSONResponseData> getJSONData();
}
