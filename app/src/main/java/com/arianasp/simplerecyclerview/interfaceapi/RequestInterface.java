package com.arianasp.simplerecyclerview.interfaceapi;

import com.arianasp.simplerecyclerview.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mycomputer on 04/10/16.
 */

public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();
}
