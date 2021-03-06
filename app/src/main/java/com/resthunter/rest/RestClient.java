package com.resthunter.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.resthunter.rest.service.RestHunterApiService;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by cleac on 04.04.15.
 */
public class RestClient {

    public static final String base_url = "http://192.168.21.38:666";
    private final RestHunterApiService apiService;

    public RestClient() {
        Gson gson = new GsonBuilder()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(base_url)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(RestHunterApiService.class);
    }

    public RestHunterApiService getApiService() {
        return apiService;
    }
}
